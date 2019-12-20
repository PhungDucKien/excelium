/*
 * The MIT License
 *
 * Copyright (c) 2004-2010, Sun Microsystems, Inc., Kohsuke Kawaguchi, Tom Huybrechts, Yahoo! Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.tasks;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.*;
import hudson.model.*;
import hudson.remoting.VirtualChannel;
import hudson.slaves.NodeSpecific;
import hudson.tasks._excelium.ExceliumConsoleAnnotator;
import hudson.tasks._excelium.Messages;
import hudson.tools.ToolDescriptor;
import hudson.tools.ToolInstallation;
import hudson.tools.ToolProperty;
import hudson.util.ArgumentListBuilder;
import hudson.util.FormValidation;
import hudson.util.VariableResolver;
import hudson.util.XStream2;
import jenkins.model.Jenkins;
import jenkins.security.MasterToSlaveCallable;
import org.apache.commons.lang.StringUtils;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Excelium launcher.
 *
 * @author Kohsuke Kawaguchi
 */
public class Excelium extends Builder {
    /**
     * The targets, properties, and other Excelium options.
     * Either separated by whitespace or newline.
     */
    private final String targets;

    /**
     * Identifies {@link ExceliumInstallation} to be used.
     */
    private final String exceliumName;

    /**
     * EXCELIUM_OPTS if not null.
     */
    private final String exceliumOpts;

    /**
     * Optional build script path relative to the workspace.
     * Used for the Excelium '-f' option.
     */
    private final String buildFile;

    /**
     * Optional properties to be passed to Excelium. Follows {@link Properties} syntax.
     */
    private final String properties;

    @DataBoundConstructor
    public Excelium(String targets, String exceliumName, String exceliumOpts, String buildFile, String properties) {
        this.targets = targets;
        this.exceliumName = exceliumName;
        this.exceliumOpts = Util.fixEmptyAndTrim(exceliumOpts);
        this.buildFile = Util.fixEmptyAndTrim(buildFile);
        this.properties = Util.fixEmptyAndTrim(properties);
    }

    public String getBuildFile() {
        return buildFile;
    }

    public String getProperties() {
        return properties;
    }

    public String getTargets() {
        return targets;
    }

    /**
     * Gets the Excelium to invoke,
     * or null to invoke the default one.
     */
    public ExceliumInstallation getExcelium() {
        for (ExceliumInstallation i : getDescriptor().getInstallations()) {
            if (exceliumName != null && exceliumName.equals(i.getName()))
                return i;
        }
        return null;
    }

    /**
     * Gets the EXCELIUM_OPTS parameter, or null.
     */
    public String getExceliumOpts() {
        return exceliumOpts;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        ArgumentListBuilder args = new ArgumentListBuilder();

        EnvVars env = build.getEnvironment(listener);

        // Allow empty build parameters to be used in property replacements.
        // The env.override/overrideAll methods remove the propery if it's an empty string.
        for (Map.Entry<String, String> e : build.getBuildVariables().entrySet()) {
            if (e.getValue() != null && e.getValue().length() == 0) {
                env.put(e.getKey(), e.getValue());
            } else {
                env.override(e.getKey(), e.getValue());
            }
        }

        ExceliumInstallation ai = getExcelium();
        if (ai == null) {
            args.add(launcher.isUnix() ? "excelium" : "excelium.bat");
        } else {
            Node node = Computer.currentComputer().getNode();
            if (node == null) {
                throw new AbortException(Messages.Excelium_NodeOffline());
            }
            ai = ai.forNode(node, listener);
            ai = ai.forEnvironment(env);
            String exe = ai.getExecutable(launcher);
            if (exe == null) {
                throw new AbortException(Messages.Excelium_ExecutableNotFound(ai.getName()));
            }
            args.add(exe);
        }

        VariableResolver<String> vr = new VariableResolver.ByMap<String>(env);
        String buildFile = env.expand(this.buildFile);
        String targets = env.expand(this.targets);

        FilePath buildFilePath = buildFilePath(build.getModuleRoot(), buildFile, targets);

        if (!buildFilePath.exists()) {
            // because of the poor choice of getModuleRoot() with CVS/Subversion, people often get confused
            // with where the build file path is relative to. Now it's too late to change this behavior
            // due to compatibility issue, but at least we can make this less painful by looking for errors
            // and diagnosing it nicely. See HUDSON-1782

            // first check if this appears to be a valid relative path from workspace root
            FilePath workspaceFilePath = build.getWorkspace();
            if (workspaceFilePath != null) {
                FilePath buildFilePath2 = buildFilePath(workspaceFilePath, buildFile, targets);
                if (buildFilePath2.exists()) {
                    // This must be what the user meant. Let it continue.
                    buildFilePath = buildFilePath2;
                } else {
                    // neither file exists. So this now really does look like an error.
                    throw new AbortException("Unable to find build script at " + buildFilePath);
                }
            } else {
                throw new AbortException("Workspace is not available. Agent may be disconnected.");
            }
        }

        if (buildFile != null) {
            args.add("-file", buildFilePath.getName());
        }

        Set<String> sensitiveVars = build.getSensitiveBuildVariables();

        args.addKeyValuePairs("-D", build.getBuildVariables(), sensitiveVars);

        args.addKeyValuePairsFromPropertyString("-D", properties, vr, sensitiveVars);

        args.addTokenized(targets.replaceAll("[\t\r\n]+", " "));

        if (ai != null)
            ai.buildEnvVars(env);
        if (exceliumOpts != null)
            env.put("EXCELIUM_OPTS", env.expand(exceliumOpts));

        if (!launcher.isUnix()) {
            args = toWindowsCommand(args.toWindowsCommand());
        }

        long startTime = System.currentTimeMillis();
        try {
            ExceliumConsoleAnnotator eca = new ExceliumConsoleAnnotator(listener.getLogger());
            int r;
            try {
                r = launcher.launch().cmds(args).envs(env).stdout(eca).pwd(buildFilePath.getParent()).join();
            } finally {
                eca.forceEol();
            }
            return r == 0;
        } catch (IOException e) {
            Util.displayIOException(e, listener);

            String errorMessage = Messages.Excelium_ExecFailed();
            if (ai == null && (System.currentTimeMillis() - startTime) < 1000) {
                if (getDescriptor().getInstallations() == null)
                    // looks like the user didn't configure any Excelium installation
                    errorMessage += Messages.Excelium_GlobalConfigNeeded();
                else
                    // There are Excelium installations configured but the project didn't pick it
                    errorMessage += Messages.Excelium_ProjectConfigNeeded();
            }
            throw new AbortException(errorMessage);
        }
    }

    /**
     * Backward compatibility by checking the number of parameters
     */
    protected static ArgumentListBuilder toWindowsCommand(ArgumentListBuilder args) {
        List<String> arguments = args.toList();

        if (arguments.size() > 3) { // "cmd.exe", "/C", "excelium.bat", ...
            // branch for core equals or greater than 1.654
            boolean[] masks = args.toMaskArray();
            // don't know why are missing single quotes.

            args = new ArgumentListBuilder();
            args.add(arguments.get(0), arguments.get(1)); // "cmd.exe", "/C", ...

            int size = arguments.size();
            for (int i = 2; i < size; i++) {
                String arg = arguments.get(i).replaceAll("^(-D[^\" ]+)=$", "$0\"\"");

                if (masks[i]) {
                    args.addMasked(arg);
                } else {
                    args.add(arg);
                }
            }
        } else {
            // branch for core under 1.653 (backward compatibility)
            // For some reason, excelium on windows rejects empty parameters but unix does not.
            // Add quotes for any empty parameter values:
            List<String> newArgs = new ArrayList<String>(args.toList());
            newArgs.set(newArgs.size() - 1, newArgs.get(newArgs.size() - 1).replaceAll(
                    "(?<= )(-D[^\" ]+)= ", "$1=\"\" "));
            args = new ArgumentListBuilder(newArgs.toArray(new String[newArgs.size()]));
        }

        return args;
    }

    private static FilePath buildFilePath(FilePath base, String buildFile, String targets) {
        if (buildFile != null) return base.child(buildFile);
        // some users specify the -f option in the targets field, so take that into account as well.
        // see 
        String[] tokens = Util.tokenize(targets);
        for (int i = 0; i < tokens.length - 1; i++) {
            String a = tokens[i];
            if (a.equals("-f") || a.equals("-file") || a.equals("-buildfile"))
                return base.child(tokens[i + 1]);
        }
        return base.child("build.xml");
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }

    @Extension
    @Symbol("excelium")
    public static class DescriptorImpl extends BuildStepDescriptor<Builder> {
        @CopyOnWrite
        private volatile ExceliumInstallation[] installations = new ExceliumInstallation[0];

        public DescriptorImpl() {
            load();
        }

        protected DescriptorImpl(Class<? extends Excelium> clazz) {
            super(clazz);
        }

        /**
         * Obtains the {@link ExceliumInstallation.DescriptorImpl} instance.
         */
        public ExceliumInstallation.DescriptorImpl getToolDescriptor() {
            return ToolInstallation.all().get(ExceliumInstallation.DescriptorImpl.class);
        }

        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        public String getDisplayName() {
            return Messages.Excelium_DisplayName();
        }

        public ExceliumInstallation[] getInstallations() {
            return Arrays.copyOf(installations, installations.length);
        }

        public void setInstallations(ExceliumInstallation... exceliumInstallations) {
            this.installations = exceliumInstallations;
            save();
        }
    }

    /**
     * Represents the Excelium installation on the system.
     */
    public static final class ExceliumInstallation extends ToolInstallation implements
            EnvironmentSpecific<ExceliumInstallation>, NodeSpecific<ExceliumInstallation> {
        // to remain backward compatible with earlier Hudson that stored this field here.
        @Deprecated
        private transient String exceliumHome;

        @DataBoundConstructor
        public ExceliumInstallation(String name, String home, List<? extends ToolProperty<?>> properties) {
            // JENKINS-57561: while EXCELIUM_HOME is an empty string when the tool is configured from UI, if that value is not configured in
            // yaml files for JCasC, home is null causing a NPE
            super(name, launderHome(StringUtils.defaultString(home)), properties);
        }

        /**
         * @deprecated as of 1.308
         * Use {@link #ExceliumInstallation(String, String, List)}
         */
        @Deprecated
        public ExceliumInstallation(String name, String home) {
            this(name, home, Collections.<ToolProperty<?>>emptyList());
        }

        private static String launderHome(String home) {
            if (home.endsWith("/") || home.endsWith("\\")) {
                // see https://issues.apache.org/bugzilla/show_bug.cgi?id=26947
                // Excelium doesn't like the trailing slash, especially on Windows
                return home.substring(0, home.length() - 1);
            } else {
                return home;
            }
        }

        /**
         * install directory.
         *
         * @deprecated as of 1.307. Use {@link #getHome()}.
         */
        public String getExceliumHome() {
            return getHome();
        }

        @Override
        public void buildEnvVars(EnvVars env) {
            env.put("EXCELIUM_HOME", getHome());
            env.put("PATH+EXCELIUM", getHome() + "/bin");
        }

        /**
         * Gets the executable path of this Excelium on the given target system.
         */
        public String getExecutable(Launcher launcher) throws IOException, InterruptedException {
            VirtualChannel channel = launcher.getChannel();
            if (channel == null) {
                throw new IOException("offline?");
            }
            return channel.call(new GetExecutable(getHome()));
        }

        private static class GetExecutable extends MasterToSlaveCallable<String, IOException> {
            private static final long serialVersionUID = 906341330603832653L;
            private final String rawHome;

            GetExecutable(String rawHome) {
                this.rawHome = rawHome;
            }

            @Override
            public String call() throws IOException {
                String execName = Functions.isWindows() ? "excelium.bat" : "excelium";
                String home = Util.replaceMacro(rawHome, EnvVars.masterEnvVars);
                File exe = new File(home, "bin/" + execName);
                if (exe.exists()) {
                    return exe.getPath();
                }
                return null;
            }
        }

        /**
         * Returns true if the executable exists.
         */
        public boolean getExists() throws IOException, InterruptedException {
            return getExecutable(new Launcher.LocalLauncher(TaskListener.NULL)) != null;
        }

        private static final long serialVersionUID = 1L;

        public ExceliumInstallation forEnvironment(EnvVars environment) {
            return new ExceliumInstallation(getName(), environment.expand(getHome()), getProperties().toList());
        }

        public ExceliumInstallation forNode(Node node, TaskListener log) throws IOException, InterruptedException {
            return new ExceliumInstallation(getName(), translateFor(node, log), getProperties().toList());
        }

        @Extension
        @Symbol("excelium")
        @SuppressFBWarnings(value = "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE", justification = "https://github.com/jenkinsci/jenkins/pull/2094")
        public static class DescriptorImpl extends ToolDescriptor<ExceliumInstallation> {

            @Override
            public String getDisplayName() {
                return "Excelium";
            }

            // for compatibility reasons, the persistence is done by Excelium.DescriptorImpl
            @Override
            public ExceliumInstallation[] getInstallations() {
                return Jenkins.get().getDescriptorByType(Excelium.DescriptorImpl.class).getInstallations();
            }

            @Override
            public void setInstallations(ExceliumInstallation... installations) {
                Jenkins.get().getDescriptorByType(Excelium.DescriptorImpl.class).setInstallations(installations);
            }

            /**
             * Checks if the EXCELIUM_HOME is valid.
             */
            public FormValidation doCheckHome(@QueryParameter File value) {
                // this can be used to check the existence of a file on the server, so needs to be protected
                if (!Jenkins.get().hasPermission(Jenkins.ADMINISTER))
                    return FormValidation.ok();

                if (value.getPath().equals(""))
                    return FormValidation.ok();

                if (!value.isDirectory())
                    return FormValidation.error(Messages.Excelium_NotADirectory(value));

                File lib = new File(value, "lib");
                boolean exceliumJarExists = false;
                for (File jar : lib.listFiles()) {
                    if (jar.getName().matches("excelium-.*\\.jar")) {
                        exceliumJarExists = true;
                        break;
                    }
                }

                if (!exceliumJarExists)
                    return FormValidation.error(Messages.Excelium_NotExceliumDirectory(value));

                return FormValidation.ok();
            }

            public FormValidation doCheckName(@QueryParameter String value) {
                return FormValidation.validateRequired(value);
            }
        }

        public static class ConverterImpl extends ToolConverter {
            public ConverterImpl(XStream2 xstream) {
                super(xstream);
            }

            @Override
            protected String oldHomeField(ToolInstallation obj) {
                return ((ExceliumInstallation) obj).exceliumHome;
            }
        }
    }
}
