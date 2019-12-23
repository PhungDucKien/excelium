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

package excelium.core.driver;

import excelium.core.server.FileServer;
import excelium.model.project.Project;
import excelium.model.test.TestRunConfig;
import excelium.model.test.config.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.*;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.MobileCommand.postC;

/**
 * Factory that creates web driver.
 *
 * @author PhungDucKien
 * @since 2018.05.04
 */
public class DriverFactory {

    /**
     * Creates context aware web driver for an environment.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the context aware web driver
     * @throws IOException the io exception
     */
    public RemoteWebDriver createDriver(Environment environment, Project project, TestRunConfig testRunConfig) throws IOException {
        RemoteWebDriver webDriver = null;
        if (environment instanceof PcEnvironment) {
            webDriver = createPcDriver((PcEnvironment) environment, project, testRunConfig);
        } else if (environment instanceof MobileEnvironment) {
            webDriver = createMobileDriver((MobileEnvironment) environment, project, testRunConfig);
        }
        return webDriver;
    }

    /**
     * Creates web driver for the PC environment.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the PC web driver
     * @throws IOException the io exception
     */
    private RemoteWebDriver createPcDriver(PcEnvironment environment, Project project, TestRunConfig testRunConfig) throws IOException {
        boolean isLocalHost = isLocalHost(testRunConfig);
        if (isLocalHost) {
            ensurePcDriverDownloaded(environment);
        }
        RemoteWebDriver webDriver = null;
        switch (environment.getBrowser()) {
            case CHROME:
                webDriver = createChromeDriver(environment, project, testRunConfig);
                break;
            case FIREFOX:
                webDriver = createFirefoxDriver(environment, project, testRunConfig);
                break;
            case IE:
                webDriver = createInternetExplorerDriver(environment, testRunConfig);
                break;
            case EDGE:
                webDriver = createEdgeDriver(environment, testRunConfig);
                break;
            case SAFARI:
                webDriver = createSafariDriver(environment, testRunConfig);
                break;
            case OPERA:
                webDriver = createOperaDriver(environment, testRunConfig);
                break;
        }

        if (!isLocalHost && webDriver != null) {
            webDriver.setFileDetector(new LocalFileDetector());
        }
        return webDriver;
    }

    /**
     * Creates web driver for the mobile environment.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the mobile web driver
     * @throws MalformedURLException the malformed URL exception
     */
    private AppiumDriver createMobileDriver(MobileEnvironment environment, Project project, TestRunConfig testRunConfig) throws MalformedURLException {
        AppiumDriver appiumDriver = null;
        switch (environment.getPlatform()) {
            case ANDROID:
                appiumDriver = createAndroidDriver(environment, project, testRunConfig);
                break;
            case IOS:
                appiumDriver = createIOSDriver(environment, project, testRunConfig);
                break;
        }
        return appiumDriver;
    }

    /**
     * Creates web driver for Chrome browser.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the Chrome web driver
     */
    private RemoteWebDriver createChromeDriver(PcEnvironment environment, Project project, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);

        Path downloadPath = project.getBasePath() != null && project.getDownloadPath() != null ?
                project.getBasePath().resolve(project.getDownloadPath()) : project.getDownloadPath();

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        if (isLocalHost && downloadPath != null) {
            chromePrefs.put("download.default_directory", downloadPath.toFile().getAbsolutePath());
        }
        chromePrefs.put("download.prompt_for_download", "false");
        chromePrefs.put("download.directory_upgrade", "true");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("test-type", "ignore-certificate-errors"));
        if (testRunConfig != null) {
            chromeOptions.setHeadless(testRunConfig.isHeadless());
        }

        if (isLocalHost) {
            System.setProperty("webdriver.chrome.driver", getPcDriverPath(environment));
            return new ChromeDriver(chromeOptions);
        } else {
            return new RemoteWebDriver(getServerAddress(environment, testRunConfig), chromeOptions);
        }
    }

    /**
     * Creates web driver for Firefox browser.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the Firefox web driver
     */
    private RemoteWebDriver createFirefoxDriver(PcEnvironment environment, Project project, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);

        Path downloadPath = project.getBasePath() != null && project.getDownloadPath() != null ?
                project.getBasePath().resolve(project.getDownloadPath()) : project.getDownloadPath();

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
        firefoxProfile.setPreference("browser.startup.homepage_override.mstone", "ignore");
        firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        firefoxProfile.setPreference("browser.download.folderList", 2);
        if (isLocalHost && downloadPath != null) {
            firefoxProfile.setPreference("browser.download.dir", downloadPath.toFile().getAbsolutePath());
        }
//        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", "false");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.setCapability("firefox_profile", firefoxProfile);
//            firefoxOptions.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.IGNORE);
        if (testRunConfig != null) {
            firefoxOptions.setHeadless(testRunConfig.isHeadless());
        }

        if (isLocalHost) {
            System.setProperty("webdriver.gecko.driver", getPcDriverPath(environment));
            return new FirefoxDriver(firefoxOptions);
        } else {
            return new RemoteWebDriver(getServerAddress(environment, testRunConfig), firefoxOptions);
        }
    }

    /**
     * Creates web driver for Internet Explorer browser.
     *
     * @param environment   the environment
     * @param testRunConfig the test run config
     * @return the Internet Explorer web driver
     */
    private RemoteWebDriver createInternetExplorerDriver(PcEnvironment environment, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);

        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.setCapability("ignoreProtectedModeSettings", true);
        ieOptions.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.IGNORE);

        if (isLocalHost) {
            System.setProperty("webdriver.ie.driver", getPcDriverPath(environment));
            return new InternetExplorerDriver(ieOptions);
        } else {
            return new RemoteWebDriver(getServerAddress(environment, testRunConfig), ieOptions);
        }
    }

    /**
     * Creates web driver for Microsoft Edge browser.
     *
     * @param environment   the environment
     * @param testRunConfig the test run config
     * @return the Microsoft Edge web driver
     */
    private RemoteWebDriver createEdgeDriver(PcEnvironment environment, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);

        EdgeOptions edgeOptions = new EdgeOptions();

        if (isLocalHost) {
            System.setProperty("webdriver.edge.driver", getPcDriverPath(environment));
            return new EdgeDriver(edgeOptions);
        } else {
            return new RemoteWebDriver(getServerAddress(environment, testRunConfig), edgeOptions);
        }
    }

    /**
     * Creates web driver for Opera browser.
     *
     * @param environment   the environment
     * @param testRunConfig the test run config
     * @return the Opera web driver
     */
    private RemoteWebDriver createOperaDriver(PcEnvironment environment, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);

        OperaOptions operaOptions = new OperaOptions();

        if (isLocalHost) {
            System.setProperty("webdriver.opera.driver", getPcDriverPath(environment));
            return new OperaDriver(operaOptions);
        } else {
            return new RemoteWebDriver(getServerAddress(environment, testRunConfig), operaOptions);
        }
    }

    /**
     * Creates web driver for Safari browser.
     *
     * @param environment   the environment
     * @param testRunConfig the test run config
     * @return the Safari web driver
     */
    private RemoteWebDriver createSafariDriver(PcEnvironment environment, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);

        SafariOptions safariOptions = new SafariOptions();

        if (isLocalHost) {
            // Safari 10+ included Apple's SafariDriver
            return new SafariDriver(safariOptions);
        } else {
            return new RemoteWebDriver(getServerAddress(environment, testRunConfig), safariOptions);
        }
    }

    /**
     * Creates web driver for Android platform.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the Android driver
     * @throws MalformedURLException the malformed URL exception
     */
    private AndroidDriver createAndroidDriver(MobileEnvironment environment, Project project, TestRunConfig testRunConfig) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        if (StringUtils.isNotBlank(environment.getPlatformVersion())) {
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, environment.getPlatformVersion());
        }
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, StringUtils.isBlank(environment.getDeviceName()) ? "Android" : environment.getDeviceName());
        String udid = testRunConfig.getUdid();
        if (StringUtils.isBlank(udid)) {
            udid = environment.getUdid();
        }
        if (StringUtils.isBlank(udid)) {
            udid = "auto";
        }
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        if (environment instanceof MobileWebEnvironment) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, ((MobileWebEnvironment) environment).getBrowser().getText());
        } else if (environment instanceof MobileAppEnvironment) {
            String appPath = ((MobileAppEnvironment) environment).getAppPath();
            if (StringUtils.isNotBlank(appPath)) {
                if (StringUtils.startsWith(appPath, "http") || StringUtils.startsWith(appPath, "/")) {
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
                } else {
                    FileServer fileServer = FileServer.getInstance();
                    if (fileServer != null) {
                        Path appFile = Paths.get(fileServer.getServerUrl()).resolve(project.getAppPath()).resolve(appPath);
                        desiredCapabilities.setCapability(MobileCapabilityType.APP, appFile.toAbsolutePath().toString());
                    } else {
                        Path appFilePath = project.getBasePath() != null && project.getAppPath() != null ?
                                project.getBasePath().resolve(project.getAppPath()).resolve(appPath) : project.getAppPath().resolve(appPath);
                        File appFile = appFilePath.toFile();
                        desiredCapabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
                    }
                }
            }
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);

            if (StringUtils.isNotBlank(((MobileAppEnvironment) environment).getAppActivity())) {
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ((MobileAppEnvironment) environment).getAppActivity());
            }
            if (StringUtils.isNotBlank(((MobileAppEnvironment) environment).getAppPackage())) {
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ((MobileAppEnvironment) environment).getAppPackage());
            }
            if (StringUtils.isNotBlank(((MobileAppEnvironment) environment).getAppWaitActivity())) {
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ((MobileAppEnvironment) environment).getAppWaitActivity());
            }
            if (StringUtils.isNotBlank(((MobileAppEnvironment) environment).getAppWaitPackage())) {
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, ((MobileAppEnvironment) environment).getAppWaitPackage());
            }
        }

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        return new AndroidDriver(new AppiumCommandExecutor(getCommandRepository(), getServerAddress(environment, testRunConfig)), desiredCapabilities);
    }

    /**
     * Creates web driver for iOS platform.
     *
     * @param environment   the environment
     * @param project       the project
     * @param testRunConfig the test run config
     * @return the iOS driver
     * @throws MalformedURLException the malformed URL exception
     */
    private IOSDriver createIOSDriver(MobileEnvironment environment, Project project, TestRunConfig testRunConfig) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        if (StringUtils.isNotBlank(environment.getPlatformVersion())) {
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, environment.getPlatformVersion());
        }
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, StringUtils.isBlank(environment.getDeviceName()) ? "iPhone" : environment.getDeviceName());
        String udid = testRunConfig.getUdid();
        if (StringUtils.isBlank(udid)) {
            udid = environment.getUdid();
        }
        if (StringUtils.isBlank(udid)) {
            udid = "auto";
        }
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        if (environment instanceof MobileWebEnvironment) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, ((MobileWebEnvironment) environment).getBrowser().getText());
            desiredCapabilities.setCapability(IOSMobileCapabilityType.SAFARI_INITIAL_URL, ((MobileWebEnvironment) environment).getBaseUrl());
            desiredCapabilities.setCapability(IOSMobileCapabilityType.SAFARI_ALLOW_POPUPS, true);
            desiredCapabilities.setCapability(IOSMobileCapabilityType.NATIVE_WEB_TAP, true);
        } else if (environment instanceof MobileAppEnvironment) {
            String appPath = ((MobileAppEnvironment) environment).getAppPath();
            if (StringUtils.isNotBlank(appPath)) {
                if (StringUtils.startsWith(appPath, "http") || StringUtils.startsWith(appPath, "/")) {
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
                } else {
                    FileServer fileServer = FileServer.getInstance();
                    if (fileServer != null) {
                        Path appFile = Paths.get(fileServer.getServerUrl()).resolve(project.getAppPath()).resolve(appPath);
                        desiredCapabilities.setCapability(MobileCapabilityType.APP, appFile.toAbsolutePath().toString());
                    } else {
                        Path appFilePath = project.getBasePath() != null && project.getAppPath() != null ?
                                project.getBasePath().resolve(project.getAppPath()).resolve(appPath) : project.getAppPath().resolve(appPath);
                        File appFile = appFilePath.toFile();
                        desiredCapabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
                    }
                }
            }
            if (StringUtils.isNotBlank(((MobileAppEnvironment) environment).getBundleId())) {
                desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, ((MobileAppEnvironment) environment).getBundleId());
            }
        }

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability(IOSMobileCapabilityType.ALLOW_TOUCHID_ENROLL, true);

        // For iOS 9.3 or higher
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        // For testing on real devices
        String xcodeConfigFile = System.getProperty(IOSMobileCapabilityType.XCODE_CONFIG_FILE);
        if (StringUtils.isBlank(xcodeConfigFile)) {
            xcodeConfigFile = System.getenv("XCODE_CONFIG_FILE");
        }
        if (StringUtils.isNotBlank(xcodeConfigFile)) {
            desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_CONFIG_FILE, xcodeConfigFile);
        } else {
            desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_CONFIG_FILE, System.getProperty("user.home") + File.separator + ".xcconfig");
        }
        String updatedWDABundleId = System.getProperty(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID);
        if (StringUtils.isBlank(updatedWDABundleId)) {
            updatedWDABundleId = System.getenv("UPDATE_WDA_BUNDLEID");
        }
        if (StringUtils.isNotBlank(updatedWDABundleId)) {
            desiredCapabilities.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, updatedWDABundleId);
        }

        return new IOSDriver(new AppiumCommandExecutor(getCommandRepository(), getServerAddress(environment, testRunConfig)), desiredCapabilities);
    }

    /**
     * Get remote server address.
     *
     * @param environment   the environment
     * @param testRunConfig the test run config
     * @return the remote server address
     * @throws MalformedURLException the malformed URL exception
     */
    private URL getServerAddress(Environment environment, TestRunConfig testRunConfig) throws MalformedURLException {
        boolean isLocalHost = isLocalHost(testRunConfig);
        String remoteHost = isLocalHost ? "localhost" : testRunConfig.getRemoteHost();
        String remotePort = isLocalHost ? "" : testRunConfig.getRemotePort();
        if (StringUtils.isBlank(remotePort)) {
            if (environment instanceof PcEnvironment) {
                remotePort = "4444";
            } else {
                remotePort = String.valueOf(AppiumServiceBuilder.DEFAULT_APPIUM_PORT);
            }
        }
        return new URL("http://" + remoteHost + ":" + remotePort + "/wd/hub");
    }

    /**
     * Ensure that the PC web driver is downloaded.
     * This method tries to download the driver if the driver does not exist.
     *
     * @param environment the environment
     * @throws IOException the io exception
     */
    private void ensurePcDriverDownloaded(PcEnvironment environment) throws IOException {
        String driverPath = getPcDriverPath(environment);
        File driverFile = new File(driverPath);
        if (!driverFile.exists()) {
            DriverDownloader downloader = new DriverDownloader();
            downloader.downloadPcDriver(environment, driverPath);
        }
    }

    /**
     * Get the PC web driver local path
     *
     * @param environment the environment
     * @return the PC web driver local path
     */
    private String getPcDriverPath(PcEnvironment environment) {
        String appHome = System.getProperty("app.home");
        if (StringUtils.isBlank(appHome)) {
            appHome = System.getProperty("user.dir");
        }
        String driverPath = appHome + File.separator + "driver" + File.separator + environment.getBrowser().name().toLowerCase();
        if (driverPath.matches("^[a-zA-Z]:\\\\")) {
            driverPath += ".exe";
        }
        return driverPath;
    }

    private boolean isLocalHost(TestRunConfig testRunConfig) {
        return testRunConfig == null
                || StringUtils.isBlank(testRunConfig.getRemoteHost());
    }

    private Map<String, CommandInfo> getCommandRepository() {
        Map<String, CommandInfo> commands = new HashMap<>(MobileCommand.commandRepository);
        commands.put(DriverCommand.SUBMIT_ELEMENT, postC("/session/:sessionId/element/:id/submit"));
        return commands;
    }
}
