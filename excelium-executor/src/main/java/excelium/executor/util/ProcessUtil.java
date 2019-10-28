/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.executor.util;

import excelium.common.PlatformDetector;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ProcessUtil {
    private static final Logger LOG = LogManager.getLogger();

    private static final int DEFAULT_ADB_PORT = 5037;
    private static final int DEFAULT_ADB_EXEC_TIMEOUT = 20000;

    private static final String[] WIN_RUNTIME = { "cmd.exe", "/C" };
    private static final String[] OS_LINUX_RUNTIME = { };

    private static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static List<String> execProcess(int timeout, String... command) throws Exception {
        String[] allCommand;
        if (PlatformDetector.getPlatform().isWindows()) {
            allCommand = concat(WIN_RUNTIME, command);
        } else {
            allCommand = concat(OS_LINUX_RUNTIME, command);
        }
        ProcessBuilder pb = new ProcessBuilder(allCommand);
        pb.redirectErrorStream(true);
        Process p = pb.start();
        p.waitFor(timeout, TimeUnit.MILLISECONDS);
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String _temp;
        List<String> line = new ArrayList<>();
        while ((_temp = in.readLine()) != null) {
            line.add(_temp);
        }

        int exitValue = p.exitValue();
        if (exitValue != 0) {
            throw new Exception("The command returned non-zero exit code.");
        }
        return line;
    }

    public static List<String> execAdbShell(AppiumDriver driver, String... command) throws Exception {
        String execCmd = "shell";
        return execAdb(driver, ArrayUtils.insert(0, command, execCmd));
    }

    public static String getDeviceSetting(AppiumDriver driver, String namespace, String setting) throws Exception {
        List<String> settingValue = execAdbShell(driver, "settings", "get", namespace, setting);
        return settingValue.get(0).trim();
    }

    public static List<String> execAdb(AppiumDriver driver, String... command) throws Exception {
        if (command == null || command.length == 0) {
            throw new Exception("You need to pass in a command to adbExec()");
        }
        // setting default timeout for each command to prevent infinite wait.
        int timeout = DEFAULT_ADB_EXEC_TIMEOUT;

        String adbBinaryPath = getSdkBinaryPath("adb");
        String uuid = getDeviceUUID(driver);
        String[] defaultArgs = {"-P", DEFAULT_ADB_PORT + "", "-s", uuid};
        String[] args = ArrayUtils.addAll(defaultArgs, command);

        LOG.debug("Running {} with args: {}", adbBinaryPath, args);
        String[] cmd = ArrayUtils.insert(0, args, adbBinaryPath);
        List<String> stdout = execProcess(timeout, cmd);
        List<String> filterStdout = new ArrayList<>();
        for (String line : stdout) {
            if (!line.startsWith("WARNING: linker")) {
                filterStdout.add(line);
            }
        }
        return filterStdout;
    }

    public static String getSdkBinaryPath(String binaryName) throws Exception {
        LOG.info("Checking whether {} is present", binaryName);
        if (StringUtils.isNotBlank(getSdkRoot())) {
            return getBinaryFromSdkRoot(binaryName);
        }
        LOG.warn("The ANDROID_HOME environment variable is not set to the Android SDK " +
           "root directory path. ANDROID_HOME is required for compatibility " +
           "with SDK 23+.");
        return binaryName;
    }

    public static String getBinaryFromSdkRoot(String binaryName) throws Exception {
        String binary = getBinaryNameForOS(binaryName);

        Path sdkRoot = Paths.get(getSdkRoot());

        Path[] binaryLocs = new Path[]{
                sdkRoot.resolve("platform-tools").resolve(binary),
                sdkRoot.resolve("emulator").resolve(binary),
                sdkRoot.resolve("tools").resolve(binary),
                sdkRoot.resolve("tools").resolve("bin").resolve(binary)
        };

        Path binaryLoc = null;
        for (Path loc : binaryLocs) {
            if (loc.toFile().exists()) {
                binaryLoc = loc;
                break;
            }
        }
        if (binaryLoc == null) {
            throw new Exception("Could not find " + binaryName + ". " +
                    "Do you have the Android SDK installed at '" + sdkRoot.toString() + "'?");
        }

        String loc = binaryLoc.toString().trim();
        LOG.info("Using {} from {}", binaryName, loc);
        return loc;
    }

    public static String getBinaryNameForOS(String binaryName) {
        if (!PlatformDetector.getPlatform().isWindows()) {
            return binaryName;
        }

        if (binaryName.toLowerCase().startsWith("android") || binaryName.toLowerCase().startsWith("apksigner") || binaryName.toLowerCase().startsWith("apkanalyzer")) {
            if (!binaryName.toLowerCase().endsWith(".bat")) {
                return binaryName.toLowerCase() + ".bat";
            }
        } else if (!binaryName.toLowerCase().endsWith(".exe")) {
            return binaryName.toLowerCase() + ".exe";
        }
        return binaryName.toLowerCase();
    }

    public static String getSdkRoot() {
        return System.getenv("ANDROID_HOME");
    }

    public static String getDeviceUUID(AppiumDriver driver) {
        Map<String, Object> caps = driver.getSessionDetails();
        return (String) caps.get("deviceUDID");
    }
}