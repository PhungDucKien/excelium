/*
 * MIT License
 *
 * Copyright (c) 2018 Excelium
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package excelium.doclet;

import com.sun.javadoc.*;
import com.sun.tools.doclets.standard.Standard;
import excelium.common.StringUtil;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.command.CommandFactory;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.doclet.i18n.Language;
import excelium.doclet.model.CommandDetail;
import excelium.doclet.model.CommandItem;
import excelium.doclet.model.ParameterTag;
import excelium.doclet.service.FreeMarkerTemplateService;
import excelium.doclet.service.TemplateService;
import excelium.model.test.command.Command;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A doclet that generates markdown API documentation.
 * Then the markdown documentation is fed to Slate
 * in order to display beautiful static documentation.
 *
 * @author PhungDucKien
 * @see <a href="https://github.com/lord/slate/">Slate</a>
 * @since 2018.06.27
 */
public class MyDoclet extends Standard {

    /**
     * Template service
     */
    private static TemplateService templateService;

    /**
     * Starts document generation.
     *
     * @param root the root
     * @return the result
     */
    public static boolean start(RootDoc root) {
        return start(root, true);
    }

    /**
     * Starts document generation.
     *
     * @param root            the root
     * @param generateClasses generate Excelium classes
     * @return the result
     */
    public static boolean start(RootDoc root, boolean generateClasses) {
        templateService = new FreeMarkerTemplateService();

        String destinationDir = getDestinationDir(root);
        Map<String, MethodDoc> commandMethodDocs = getCommandMethodDocs(root);

        generateDoc(true, destinationDir, commandMethodDocs, generateClasses);
        generateDoc(false, destinationDir, commandMethodDocs, generateClasses);

        return true;
    }

    /**
     * Generates markdown API documentation.
     *
     * @param isWeb             true for Web, false for Mobile
     * @param destinationDir    the destination directory
     * @param commandMethodDocs the list of methods that are annotated with either @{@link Action} or @{@link Accessor}
     * @param generateClasses   generate Excelium classes
     */
    private static void generateDoc(boolean isWeb, String destinationDir, Map<String, MethodDoc> commandMethodDocs, boolean generateClasses) {
        Map<String, Command> commandMap = getCommandMap(isWeb);

        List<CommandItem> commandItems = new ArrayList<>();
        for (Command command : commandMap.values()) {
            CommandItem item = new CommandItem();
            item.setName(command.getName());
            item.setMethod(command.getMethod());
            item.setParam1(command.getParam1());
            item.setParam2(command.getParam2());
            item.setParam3(command.getParam3());
            commandItems.add(item);
        }

        commandItems.sort(Comparator.comparing(c -> c.getName() + " " + countParam(c)));

        Map<String, CommandDetail> commandDetailMap = new HashMap<>();
        for (Command command : commandMap.values()) {
            CommandDetail commandDetail = commandDetailMap.get(command.getName() + "-" + command.getSourceMethodKey());
            if (commandDetail == null) {
                commandDetail = new CommandDetail();
                commandDetail.setName(command.getName());
                commandDetail.setMethod(command.getMethod());

                MethodDoc methodDoc = commandMethodDocs.get(command.getSourceMethodKey());
                if (methodDoc != null) {
                    commandDetail.setDescription(getCommandDescription(command, methodDoc));
                    commandDetail.setParameterTags(getParameterTags(command, methodDoc));
                }

                commandDetail.addUsage(getCommandUsage(command));
                commandDetailMap.put(command.getName() + "-" + command.getSourceMethodKey(), commandDetail);
            } else {
                commandDetail.addUsage(getCommandUsage(command));
            }
        }

        List<CommandDetail> commandDetails = new ArrayList<>(commandDetailMap.values());
        commandDetails.sort(Comparator.comparing(d -> d.getName() + " " + d.getParameterTags().size()));

        Map<String, Object> input = new HashMap<>();
        input.put("items", commandItems);
        input.put("details", commandDetails);
        input.put("isWeb", isWeb);

        File outputFile = new File(destinationDir, isWeb ? "_web_api.md" : "_mobile_api.md");
        templateService.processTemplate("api.ftl", input, outputFile);

        if (generateClasses) {
            // Generate Excelium API classes
            File javaFile = new File("../excelium-executor/src/main/java/excelium/executor/" +
                    (isWeb ? "WebExcelium.java" : "MobileExcelium.java"));
            templateService.processTemplate("java.ftl", input, javaFile);
        }
    }

    /**
     * Returns the list of methods that are annotated with either @{@link Action} or @{@link Accessor}.
     *
     * @param root the root
     * @return the list of methods that are annotated with either @{@link Action} or @{@link Accessor}.
     */
    private static Map<String, MethodDoc> getCommandMethodDocs(RootDoc root) {
        Map<String, MethodDoc> commandMethodDocs = new HashMap<>();
        for (ClassDoc classDoc : root.classes()) {
            MethodDoc[] methodDocs = classDoc.methods();
            for (MethodDoc methodDoc : methodDocs) {
                if (containsCommandAnnotations(methodDoc)) {
                    commandMethodDocs.put(methodDoc.name() + "(" + methodDoc.parameters().length + ")", methodDoc);
                }
            }
        }
        return commandMethodDocs;
    }

    /**
     * Get the list of Excelium commands
     *
     * @param isWeb true for Web, false for Mobile
     * @return the list of Excelium commands
     */
    private static Map<String, Command> getCommandMap(boolean isWeb) {
        try {
            return CommandFactory.createCommandMap(new ContextAwareWebDriver(new StubWebDriver(), null), null, null, null, isWeb);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the command description from the method comment.
     *
     * @param command   the command
     * @param methodDoc the method
     * @return the command description
     */
    private static String getCommandDescription(Command command, MethodDoc methodDoc) {
        String commentText = methodDoc.commentText();
        commentText = commentText
                .replaceAll("\\n[ ]+", " ") // Removes the leading space characters
                .replaceAll("\\n", "\n\n"); // Allows markdown to display paragraphs
        if (containsActionAnnotation(methodDoc)) {
            return commentText;
        } else if (containsAccessorAnnotation(methodDoc)) {
            return getAccessorDescription(command, commentText, Language.ENGLISH);
        }
        return null;
    }

    /**
     * Returns the accessor command description from the comment.
     *
     * @param command     the command
     * @param commentText the comment
     * @param language    the language
     * @return the accessor command description
     */
    private static String getAccessorDescription(Command command, String commentText, Language language) {
        String firstSentence = StringUtil.getFirstSentence(commentText);
        String remaining = commentText.replace(firstSentence, "");
        String subject = getSubject(firstSentence);

        String verb = null;
        if (command.getMethod().contains("NotContain")) {
            verb = language.getNotContainVerb();
        } else if (command.getMethod().contains("Contain")) {
            verb = language.getContainVerb();
        } else if (command.getMethod().contains("NotMatch")) {
            verb = language.getNotMatchVerb();
        } else if (command.getMethod().contains("Match")) {
            verb = language.getMatchVerb();
        } else if (command.getMethod().contains("Not")) {
            if (isParamAdded("variable", command) || isParamAdded("text", command)) {
                verb = language.getNotEqualVerb();
            } else {
                subject = subject.replaceFirst(language.getToBeVerb(), language.getNotToBeVerb());
            }
        } else {
            if (isParamAdded("variable", command) || isParamAdded("text", command)) {
                verb = language.getEqualVerb();
            }
        }

        if (command.getMethod().startsWith("storePush")) {
            return language.getPushMessage(subject) + remaining;
        } else if (command.getMethod().startsWith("store")) {
            return language.getStoreMessage(subject) + remaining;
        } else if (command.getMethod().startsWith("waitFor")) {
            return language.getWaitMessage(subject, verb) + remaining;
        } else if (command.getMethod().startsWith("executeIf")) {
            return language.getExecuteMessage(subject, verb) + remaining;
        } else if (command.getMethod().startsWith("verify")) {
            return language.getVerifyMessage(subject, verb) + remaining;
        } else if (command.getMethod().startsWith("assert")) {
            return language.getAssertMessage(subject, verb) + remaining;
        }
        return null;
    }

    /**
     * Returns the description of parameters from the method comment.
     *
     * @param command   the command
     * @param methodDoc the method
     * @return the description of parameters
     */
    private static List<ParameterTag> getParameterTags(Command command, MethodDoc methodDoc) {
        List<ParameterTag> parameterTags = new ArrayList<>();
        if (containsActionAnnotation(methodDoc)) {
            return convertParamTags(methodDoc.paramTags());
        } else if (containsAccessorAnnotation(methodDoc)) {
            if (command.getMethod().startsWith("executeIf")) {
                parameterTags.add(new ParameterTag("action", "the name of the action to execute"));
            }
            parameterTags.addAll(convertParamTags(methodDoc.paramTags()));
            if (isParamAdded("variable", command)) {
                parameterTags.add(new ParameterTag("variable", "the name of a variable in which the result is to be stored"));
            } else if (isParamAdded("text", command)) {
                parameterTags.add(new ParameterTag("text", "the value to match with the result"));
            }
        }
        return parameterTags;
    }

    /**
     * Convert an array of ParamTag to the list of ParameterTag.
     * The leading space characters are eliminated.
     *
     * @param paramTags an array of ParamTag
     * @return the list of ParameterTag
     */
    private static List<ParameterTag> convertParamTags(ParamTag[] paramTags) {
        List<ParameterTag> parameterTags = new ArrayList<>();
        for (ParamTag paramTag : paramTags) {
            ParameterTag parameterTag = new ParameterTag(paramTag.parameterName(), paramTag.parameterComment().replaceAll("\\n\\s+", " "));
            parameterTags.add(parameterTag);
        }
        return parameterTags;
    }

    /**
     * Determines whether the parameter with the given name is added by command factories.
     *
     * @return true if the parameter is added, false otherwise
     */
    private static boolean isParamAdded(String parameterName, Command command) {
        boolean paramAdded = false;
        if (parameterName.equals(command.getParam3())) {
            paramAdded = true;
        } else if (StringUtils.isBlank(command.getParam3()) && parameterName.equals(command.getParam2())) {
            paramAdded = true;
        } else if (StringUtils.isBlank(command.getParam2()) && parameterName.equals(command.getParam1())) {
            paramAdded = true;
        }
        return paramAdded;
    }

    /**
     * Returns the usage of the command.
     * Formula: ${name}(${param1}, ${param2}, ${param3})
     *
     * @param command the command
     * @return the usage of the command
     */
    private static String getCommandUsage(Command command) {
        List<String> commandParams = new ArrayList<>();
        if (StringUtils.isNotBlank(command.getParam1())) {
            commandParams.add(command.getParam1());
        }
        if (StringUtils.isNotBlank(command.getParam2())) {
            commandParams.add(command.getParam2());
        }
        if (StringUtils.isNotBlank(command.getParam3())) {
            commandParams.add(command.getParam3());
        }

        return command.getMethod() + "(" + StringUtils.join(commandParams, ", ") + ")";
    }

    /**
     * Determines if the method is annotated with either @{@link Action} or @{@link Accessor}.
     *
     * @param methodDoc the method
     * @return return true if if the method is annotated with either @{@link Action} or @{@link Accessor}, false otherwise.
     */
    private static boolean containsCommandAnnotations(MethodDoc methodDoc) {
        AnnotationDesc[] annotationDescs = methodDoc.annotations();
        for (AnnotationDesc annotationDesc : annotationDescs) {
            if (annotationDesc.annotationType().qualifiedName().equals(Action.class.getName()) ||
                    annotationDesc.annotationType().qualifiedName().equals(Accessor.class.getName())) {
                int paramNum = methodDoc.parameters().length;
                if (paramNum != countParam(annotationDesc)) {
                    System.err.println("WARNING: Number of method arguments does not match the number of annotation parameters. Method: " + methodDoc.name());
                } else if (paramNum != methodDoc.paramTags().length) {
                    System.err.println("WARNING: Number of method arguments does not match the number of @param tag. Method: " + methodDoc.name());
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the method is annotated with @{@link Action}.
     *
     * @param methodDoc the method
     * @return return true if if the method is annotated with @{@link Action}, false otherwise.
     */
    private static boolean containsActionAnnotation(MethodDoc methodDoc) {
        AnnotationDesc[] annotationDescs = methodDoc.annotations();
        for (AnnotationDesc annotationDesc : annotationDescs) {
            if (annotationDesc.annotationType().qualifiedName().equals(Action.class.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the method is annotated with @{@link Accessor}.
     *
     * @param methodDoc the method
     * @return return true if if the method is annotated with @{@link Accessor}, false otherwise.
     */
    private static boolean containsAccessorAnnotation(MethodDoc methodDoc) {
        AnnotationDesc[] annotationDescs = methodDoc.annotations();
        for (AnnotationDesc annotationDesc : annotationDescs) {
            if (annotationDesc.annotationType().qualifiedName().equals(Accessor.class.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the destination directory for output files.
     *
     * @param root the root
     * @return destination directory
     */
    private static String getDestinationDir(RootDoc root) {
        String[][] options = root.options();
        String[] dOption = null;
        for (String[] option : options) {
            if (option[0].equals("-d")) {
                dOption = option;
            }
        }
        if (dOption != null) {
            return dOption[1];
        }
        return ".";
    }

    /**
     * Returns the subject of the javadoc comment
     *
     * @param comment the comment
     * @return the subject
     */
    private static String getSubject(String comment) {
        if (StringUtils.endsWithAny(comment, ".", "!", "?")) {
            comment = comment.substring(0, comment.length() - 1);
        }
        Pattern pattern = Pattern.compile("(?:Return|Get|Retrieve|Determine|Check)s?\\s+(?:(?:true if|if|whether)\\s+)?((?:(?!(, or false|, or fail|, or throws?)).)*)");
        Matcher matcher = pattern.matcher(comment);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return comment;
    }

    /**
     * Count the number of parameters of the AnnotationDesc.
     *
     * @param annotationDesc the AnnotationDesc
     * @return the number of parameters
     */
    private static int countParam(AnnotationDesc annotationDesc) {
        int count = 0;
        for (AnnotationDesc.ElementValuePair valuePair : annotationDesc.elementValues()) {
            if (valuePair.element().name().startsWith("param") && StringUtils.isNotBlank(valuePair.value().toString())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Count the number of parameters of the command item.
     *
     * @param commandItem the command item
     * @return the number of parameters
     */
    private static int countParam(CommandItem commandItem) {
        int count = 0;
        if (StringUtils.isNotBlank(commandItem.getParam1())) count++;
        if (StringUtils.isNotBlank(commandItem.getParam2())) count++;
        if (StringUtils.isNotBlank(commandItem.getParam3())) count++;
        return count;
    }

    /**
     * A stub web driver that does nothing.
     */
    private static class StubWebDriver extends RemoteWebDriver {
        StubWebDriver() {
        }

        @Override
        public String getWindowHandle() {
            return null;
        }
    }
}
