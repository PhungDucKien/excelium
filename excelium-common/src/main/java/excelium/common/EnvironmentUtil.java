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

package excelium.common;

import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.MobileWebEnvironment;
import excelium.model.test.config.PcEnvironment;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of environment handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
public class EnvironmentUtil {

    /**
     * Gets available pc environments.
     *
     * @param browser     the browser
     * @param versions    the versions
     * @param resolutions the resolutions
     * @param baseUrl     the base url
     * @return the available pc environments
     */
    public static List<Environment> getAvailablePcEnvironments(Browser browser, List<String> versions, List<String> resolutions, String baseUrl) {
        List<Environment> environments = new ArrayList<>();
        Platform platform = PlatformDetector.getPlatform();
        if (isBrowserAvailable(platform, browser)) {
            if (CollectionUtils.isEmpty(versions)) {
                versions = new ArrayList<>();
                versions.add("");
            }
            if (CollectionUtils.isEmpty(resolutions)) {
                resolutions = new ArrayList<>();
                resolutions.add("1024x768");
            }
            for (String version : versions) {
                for (String resolution : resolutions) {
                    PcEnvironment environment = new PcEnvironment();
                    environment.setPlatform(platform);
                    environment.setBrowser(browser);
                    environment.setBrowserVersion(version);
                    environment.setResolution(resolution);
                    environment.setBaseUrl(baseUrl);
                    environments.add(environment);
                }
            }
        }
        return environments;
    }

    /**
     * Gets available mobile web environments.
     *
     * @param platform         the platform
     * @param platformVersions the platform versions
     * @param deviceNames      the device names
     * @param orientations     the orientations
     * @param udid             the udid
     * @param browsers         the browsers
     * @param baseUrl          the base url
     * @return the available mobile web environments
     */
    public static List<Environment> getAvailableMobileWebEnvironments(Platform platform, List<String> platformVersions, List<String> deviceNames, List<String> orientations, String udid, List<String> browsers, String baseUrl) {
        if (CollectionUtils.isEmpty(platformVersions)) {
            platformVersions = new ArrayList<>();
            platformVersions.add("");
        }
        if (CollectionUtils.isEmpty(deviceNames)) {
            deviceNames = new ArrayList<>();
            if (platform == Platform.ANDROID) {
                deviceNames.add("Android");
            } else if (platform == Platform.IOS) {
                deviceNames.add("iPhone");
            }
        }
        if (CollectionUtils.isEmpty(orientations)) {
            orientations = new ArrayList<>();
            orientations.add("Portrait");
        }
        if (CollectionUtils.isEmpty(browsers)) {
            browsers = new ArrayList<>();
            if (platform == Platform.ANDROID) {
                browsers.add("Chrome");
            } else if (platform == Platform.IOS) {
                browsers.add("Safari");
            }
        }
        List<Environment> environments = new ArrayList<>();
        for (String platformVersion : platformVersions) {
            for (String deviceName : deviceNames) {
                for (String orientation : orientations) {
                    for (String browser : browsers) {
                        MobileWebEnvironment environment = new MobileWebEnvironment();
                        environment.setPlatform(platform);
                        environment.setPlatformVersion(platformVersion);
                        environment.setDeviceName(deviceName);
                        environment.setOrientation(orientation);
                        environment.setUdid(StringUtils.isBlank(udid) ? "auto" : udid);
                        environment.setBrowser(Browser.fromName(browser));
                        environment.setBaseUrl(baseUrl);
                        environments.add(environment);
                    }
                }
            }
        }
        return environments;
    }

    /**
     * Gets available mobile app environments.
     *
     * @param platform         the platform
     * @param platformVersions the platform versions
     * @param deviceNames      the device names
     * @param orientations     the orientations
     * @param udid             the udid
     * @param appPath          the app path
     * @param appActivity      the app activity
     * @param appPackage       the app package
     * @param appWaitActivity  the app wait activity
     * @param appWaitPackage   the app wait package
     * @param bundleId         the bundle ID
     * @return the available mobile app environments
     */
    public static List<Environment> getAvailableMobileAppEnvironments(Platform platform, List<String> platformVersions, List<String> deviceNames, List<String> orientations, String udid,
                                                                      String appPath, String appActivity, String appPackage, String appWaitActivity, String appWaitPackage, String bundleId) {
        if (CollectionUtils.isEmpty(platformVersions)) {
            platformVersions = new ArrayList<>();
            platformVersions.add("");
        }
        if (CollectionUtils.isEmpty(deviceNames)) {
            deviceNames = new ArrayList<>();
            if (platform == Platform.ANDROID) {
                deviceNames.add("Android");
            } else if (platform == Platform.IOS) {
                deviceNames.add("iPhone");
            }
        }
        if (CollectionUtils.isEmpty(orientations)) {
            orientations = new ArrayList<>();
            orientations.add("Portrait");
        }
        List<Environment> environments = new ArrayList<>();
        for (String platformVersion : platformVersions) {
            for (String deviceName : deviceNames) {
                for (String orientation : orientations) {
                    MobileAppEnvironment environment = new MobileAppEnvironment();
                    environment.setPlatform(platform);
                    environment.setPlatformVersion(platformVersion);
                    environment.setDeviceName(deviceName);
                    environment.setOrientation(orientation);
                    environment.setUdid(StringUtils.isBlank(udid) ? "auto" : udid);
                    environment.setAppPath(appPath);
                    environment.setAppActivity(appActivity);
                    environment.setAppPackage(appPackage);
                    environment.setAppWaitActivity(appWaitActivity);
                    environment.setAppWaitPackage(appWaitPackage);
                    environment.setBundleId(bundleId);
                    environments.add(environment);
                }
            }
        }
        return environments;
    }

    /**
     * Checks if the given browser is available on the platform
     *
     * @param platform the platform
     * @param browser  the browser
     * @return is the browser available
     */
    private static boolean isBrowserAvailable(Platform platform, Browser browser) {
        switch (browser) {
            case IE:
            case EDGE:
                return platform.isWindows();
            case SAFARI:
                return platform.isMac();
            default:
                return true;
        }
    }
}
