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

package excelium.executor.mobile;

import excelium.common.StringUtil;
import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.executor.util.ProcessUtil;
import excelium.model.project.Project;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Represents a class which contains commands for controlling mobile device actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class DeviceCommandExecutor extends CommandExecutor {

    private static final String ANDROID_UNICODE_IME = "io.appium.settings/.UnicodeIME";

    /**
     * Instantiates a new Device command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public DeviceCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Start an Android activity by providing package name and activity name.
     * <p>
     * The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties.
     * For example: appPackage=example,appActivity=example
     *
     * @param activity the given activity
     * @throws IOException Invalid properties provided
     */
    @Action(param1 = "activity", androidOnly = true)
    public void startActivity(String activity) throws IOException {
        Properties activityProps = StringUtil.parseProperties(activity, ",");
        webDriver.getAndroidDriver().startActivity(new Activity(activityProps.getProperty("appPackage"), activityProps.getProperty("appActivity")));
    }

    /**
     * Determines the current activity matches the given activity.
     * The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties.
     * For example: appPackage=example,appActivity=example
     *
     * @param activity the given activity
     * @return true if the current activity matches the given activity, false otherwise
     * @throws IOException Invalid properties provided
     */
    @Accessor(param1 = "activity", androidOnly = true)
    public boolean isActivity(String activity) throws IOException {
        String currentActivity = webDriver.getAndroidDriver().currentActivity();
        String currentPackage = webDriver.getAndroidDriver().getCurrentPackage();
        Properties activityProps = StringUtil.parseProperties(activity, ",");

        return activityProps.getProperty("appActivity").equals(currentActivity) && activityProps.getProperty("appPackage").equals(currentPackage);
    }

    /**
     * Launch the app-under-test on the device.
     * <p>
     * If the app-under-test (AUT) is closed, or backgrounded, it will launch it. If the AUT is already open, it will background it and re-launch it.
     */
    @Action
    public void launchApp() {
        webDriver.getAppiumDriver().launchApp();
    }

    /**
     * Send the currently running app for this session to the background, and return after a certain amount of time (-1 means to deactivate the app entirely).
     *
     * @param secs An integer designating how long, in milliseconds, to background the app for.
     */
    @Action(param1 = "millis")
    public void runAppInBackground(String millis) {
        webDriver.getAppiumDriver().runAppInBackground(Duration.ofMillis(toInteger(millis, 1000)));
    }

    /**
     * Close an app on device.
     */
    @Action
    public void closeApp() {
        webDriver.getAppiumDriver().closeApp();
    }

    /**
     * Reset the currently running app for this session.
     */
    @Action
    public void resetApp() {
        webDriver.getAppiumDriver().resetApp();
    }

    /**
     * Reload the application without cleaning application data.
     */
    @Action
    public void reloadApp() {
        webDriver.getAppiumDriver().closeApp();
        webDriver.getAppiumDriver().launchApp();
    }

    /**
     * Activate the given app onto the device.
     *
     * @param bundleId the bundle identifier (or app id) of the app to activate.
     */
    @Action
    public void activateApp(String bundleId) {
        webDriver.getAppiumDriver().activateApp(bundleId);
    }

    /**
     * Terminate the given app on the device.
     *
     * @param bundleId the bundle identifier (or app id) of the app to be terminated.
     */
    @Action
    public void terminateApp(String bundleId) {
        webDriver.getAppiumDriver().terminateApp(bundleId);
    }

    /**
     * Set the content of the system clipboard
     *
     * @param text the value to set
     */
    @Action
    public void setClipboard(String text) {
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            webDriver.getIOSDriver().setClipboardText(text);
        } else if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            webDriver.getAndroidDriver().setClipboardText(text);
        }
    }

    /**
     * Broadcast an Android Intent.
     *
     * @param intent Android Intent
     * @throws Exception
     */
    @Action(param1 = "intent", androidOnly = true)
    public void broadcastIntent(String intent) throws Exception {
        ProcessUtil.execAdbShell(webDriver.getAndroidDriver(), "am", "broadcast", "-a", intent);
    }

    /**
     * Perform a shake action on the device
     */
    @Action(iosOnly = true)
    public void shake() {
        webDriver.getIOSDriver().shake();
    }

    /**
     * Lock the device
     */
    @Action
    public void lock() {
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            webDriver.getIOSDriver().lockDevice(Duration.ofMillis(0));
        } else if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            webDriver.getAndroidDriver().lockDevice();
        }
    }

    /**
     * Unlock the device
     */
    @Action(androidOnly = true)
    public void unlock() {
        webDriver.getAndroidDriver().unlockDevice();
    }

    /**
     * Hide soft keyboard
     */
    @Action
    public void hideKeyboard() {
        webDriver.getAppiumDriver().hideKeyboard();
    }

    /**
     * Toggle airplane mode on device
     */
    @Action(androidOnly = true)
    public void toggleAirplaneMode() {
        webDriver.getAndroidDriver().toggleAirplaneMode();
    }

    /**
     * Switch the state of the wifi service
     */
    @Action(androidOnly = true)
    public void toggleWifi() {
        webDriver.getAndroidDriver().toggleWifi();
    }

    /**
     * Switch the state of the location service
     */
    @Action(androidOnly = true)
    public void toggleLocationServices() {
        webDriver.getAndroidDriver().toggleLocationServices();
    }

    /**
     * Simulate an accept touch id event (iOS Simulator only)
     */
    @Action(iosOnly = true)
    public void acceptTouchID() {
        webDriver.getIOSDriver().performTouchID(true);
    }

    /**
     * Simulate a reject touch id event (iOS Simulator only)
     */
    @Action(iosOnly = true)
    public void rejectTouchID() {
        webDriver.getIOSDriver().performTouchID(false);
    }

    /**
     * Open Android notifications (Emulator only)
     */
    @Action(androidOnly = true)
    public void openNotifications() {
        webDriver.getAndroidDriver().openNotifications();
    }

    /**
     * Authenticate users by using their finger print scans on supported emulators. (For Android emulator)
     *
     * @param fingerPrintId finger prints stored in Android Keystore system (from 1 to 10)
     */
    @Action(androidOnly = true)
    public void fingerPrint(String fingerPrintId) {
        webDriver.getAndroidDriver().fingerPrint(Integer.parseInt(fingerPrintId));
    }
}
