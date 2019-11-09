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

import excelium.model.enums.Platform;
import excelium.model.project.Project;
import excelium.model.test.config.*;
import io.appium.java_client.AppiumDriver;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
     * @param environment the environment
     * @param project     the project
     * @return the context aware web driver
     * @throws IOException the io exception
     */
    public RemoteWebDriver createDriver(Environment environment, Project project) throws IOException {
        RemoteWebDriver webDriver = null;
        if (environment instanceof PcEnvironment) {
            webDriver = createPcDriver((PcEnvironment) environment, project);
        } else if (environment instanceof MobileEnvironment) {
            webDriver = createMobileDriver((MobileEnvironment) environment, project);
        }
        return webDriver;
    }

    /**
     * Creates web driver for the PC environment.
     *
     * @param environment the environment
     * @param project     the project
     * @return the PC web driver
     * @throws IOException the io exception
     */
    private RemoteWebDriver createPcDriver(PcEnvironment environment, Project project) throws IOException {
        ensurePcDriverDownloaded(environment);
        RemoteWebDriver webDriver = null;
        switch (environment.getBrowser()) {
            case CHROME:
                webDriver = createChromeDriver(environment, project);
                break;
            case FIREFOX:
                webDriver = createFirefoxDriver(environment, project);
                break;
            case IE:
                webDriver = createInternetExplorerDriver(environment);
                break;
            case EDGE:
                webDriver = createEdgeDriver(environment);
                break;
            case SAFARI:
                webDriver = createSafariDriver();
                break;
            case OPERA:
                webDriver = createOperaDriver(environment);
                break;
        }

        return webDriver;
    }

    /**
     * Creates web driver for the mobile environment.
     *
     * @param environment the environment
     * @param project     the project
     * @return the mobile web driver
     * @throws MalformedURLException the malformed URL exception
     */
    private AppiumDriver createMobileDriver(MobileEnvironment environment, Project project) throws MalformedURLException {
        AppiumDriver appiumDriver = null;
        switch (environment.getPlatform()) {
            case ANDROID:
                appiumDriver = createAndroidDriver(environment, project);
                break;
            case IOS:
                appiumDriver = createIOSDriver(environment, project);
                break;
        }
        return appiumDriver;
    }

    /**
     * Creates web driver for Chrome browser.
     *
     * @param environment the environment
     * @param project     the project
     * @return the Chrome web driver
     */
    private ChromeDriver createChromeDriver(PcEnvironment environment, Project project) {
        System.setProperty("webdriver.chrome.driver", getPcDriverPath(environment));

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", project.getDownloadPath().toFile().getAbsolutePath());
        chromePrefs.put("download.prompt_for_download", "false");
        chromePrefs.put("download.directory_upgrade", "true");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("test-type", "ignore-certificate-errors"));
        return new ChromeDriver(chromeOptions);
    }

    /**
     * Creates web driver for Firefox browser.
     *
     * @param environment the environment
     * @param project     the project
     * @return the Firefox web driver
     */
    private FirefoxDriver createFirefoxDriver(PcEnvironment environment, Project project) {
        System.setProperty("webdriver.gecko.driver", getPcDriverPath(environment));

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
        firefoxProfile.setPreference("browser.startup.homepage_override.mstone", "ignore");
        firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", project.getDownloadPath().toFile().getAbsolutePath());
//        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", "false");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.setCapability("firefox_profile", firefoxProfile);
//            firefoxOptions.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.IGNORE);
        return new FirefoxDriver(firefoxOptions);
    }

    /**
     * Creates web driver for Internet Explorer browser.
     *
     * @param environment the environment
     * @return the Internet Explorer web driver
     */
    private InternetExplorerDriver createInternetExplorerDriver(PcEnvironment environment) {
        System.setProperty("webdriver.ie.driver", getPcDriverPath(environment));

        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.setCapability("ignoreProtectedModeSettings", true);
        ieOptions.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.IGNORE);
        return new InternetExplorerDriver(ieOptions);
    }

    /**
     * Creates web driver for Microsoft Edge browser.
     *
     * @param environment the environment
     * @return the Microsoft Edge web driver
     */
    private EdgeDriver createEdgeDriver(PcEnvironment environment) {
        System.setProperty("webdriver.edge.driver", getPcDriverPath(environment));

        EdgeOptions edgeOptions = new EdgeOptions();
        return new EdgeDriver(edgeOptions);
    }

    /**
     * Creates web driver for Opera browser.
     *
     * @param environment the environment
     * @return the Opera web driver
     */
    private OperaDriver createOperaDriver(PcEnvironment environment) {
        System.setProperty("webdriver.opera.driver", getPcDriverPath(environment));

        OperaOptions operaOptions = new OperaOptions();
        return new OperaDriver(operaOptions);
    }

    /**
     * Creates web driver for Safari browser.
     *
     * @return the Safari web driver
     */
    private SafariDriver createSafariDriver() {
        // Safari 10+ included Apple's SafariDriver

        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);
    }

    /**
     * Creates web driver for Android platform.
     *
     * @param environment the environment
     * @param project     the project
     * @return the Android driver
     * @throws MalformedURLException the malformed URL exception
     */
    private AndroidDriver createAndroidDriver(MobileEnvironment environment, Project project) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        if (StringUtils.isNotBlank(environment.getPlatformVersion())) {
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, environment.getPlatformVersion());
        }
        if (StringUtils.isNotBlank(environment.getDeviceName())) {
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, environment.getDeviceName());
        }
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, environment.getUdid());
        if (environment instanceof MobileWebEnvironment) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, ((MobileWebEnvironment) environment).getBrowser().getText());
        } else if (environment instanceof MobileAppEnvironment) {
            String appPath = ((MobileAppEnvironment) environment).getAppPath();
            if (StringUtils.isNotBlank(appPath)) {
                if (StringUtils.startsWith(appPath, "http") || StringUtils.startsWith(appPath, "/")) {
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
                } else {
                    File appFile = project.getAppPath().resolve(appPath).toFile();
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
                }
            }
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
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

        return new AndroidDriver(getAppiumAddress(project), desiredCapabilities);
    }

    /**
     * Creates web driver for iOS platform.
     *
     * @param environment the environment
     * @param project     the project
     * @return the iOS driver
     * @throws MalformedURLException the malformed URL exception
     */
    private IOSDriver createIOSDriver(MobileEnvironment environment, Project project) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        if (StringUtils.isNotBlank(environment.getPlatformVersion())) {
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, environment.getPlatformVersion());
        }
        if (StringUtils.isNotBlank(environment.getDeviceName())) {
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, environment.getDeviceName());
        }
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, environment.getUdid());
        if (environment instanceof MobileWebEnvironment) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, ((MobileWebEnvironment) environment).getBrowser().getText());
        } else if (environment instanceof MobileAppEnvironment) {
            String appPath = ((MobileAppEnvironment) environment).getAppPath();
            if (StringUtils.isNotBlank(appPath)) {
                if (StringUtils.startsWith(appPath, "http") || StringUtils.startsWith(appPath, "/")) {
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
                } else {
                    File appFile = project.getAppPath().resolve(appPath).toFile();
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
                }
            }
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

            if (StringUtils.isNotBlank(((MobileAppEnvironment) environment).getBundleId())) {
                desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, ((MobileAppEnvironment) environment).getBundleId());
            }
        }
        // For iOS 9.3 or higher
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        // For testing on real devices
        String xcodeConfigFilePath = System.getProperty("user.home") + File.separator + ".xcconfig";
        desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_CONFIG_FILE, xcodeConfigFilePath);
        desiredCapabilities.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, System.getenv("UPDATE_WDA_BUNDLEID"));

        return new IOSDriver(getAppiumAddress(project), desiredCapabilities);
    }

    /**
     * Get Appium remote address.
     *
     * @param project the project
     * @return Appium remote address
     * @throws MalformedURLException the malformed URL exception
     */
    private URL getAppiumAddress(Project project) throws MalformedURLException {
        String appiumHost = project.getAppiumHost();
        if (StringUtils.isBlank(appiumHost)) {
            appiumHost = AppiumServiceBuilder.DEFAULT_LOCAL_IP_ADDRESS;
        }
        Integer appiumPort = project.getAppiumPort();
        if (appiumPort == null) {
            appiumPort = AppiumServiceBuilder.DEFAULT_APPIUM_PORT;
        }
        return new URL("http://" + appiumHost + ":" + appiumPort + "/wd/hub");
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
        String driverPath = appHome + File.separator + "driver" + File.separator + environment.getBrowser().name().toLowerCase() + "_" + environment.getPlatform().name().toLowerCase();
        if (environment.getPlatform() == Platform.WINDOWS_32 || environment.getPlatform() == Platform.WINDOWS_64) {
            driverPath += ".exe";
        }
        return driverPath;
    }
}
