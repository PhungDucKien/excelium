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

package excelium.executor.mobile.app;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * Represents a class which contains commands for controlling mobile device actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class DeviceCommandExecutor extends CommandExecutor {

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
     * Set the content of the system clipboard
     *
     * @param text The actual text to be set.
     */
    @Action(param1 = "text")
    public void setClipboard(String text) {
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            webDriver.getIOSDriver().setClipboardText(text);
        } else if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            webDriver.getAndroidDriver().setClipboardText(text);
        }
    }

    /**
     * Perform a shake action on the device
     */
    @Action(android = false)
    public void shake() {
        webDriver.getIOSDriver().shake();
    }

    /**
     * Lock the device (bring it to the lock screen) forever. It will return silently if the device
     * is already locked.
     */
    @Action
    public void lock() {
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            webDriver.getIOSDriver().lockDevice();
        } else if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            webDriver.getAndroidDriver().lockDevice();
        }
    }

    /**
     * Unlock the device if it is locked. This method will return silently if the device
     * is not locked.
     */
    @Action
    public void unlock() {
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            webDriver.getIOSDriver().unlockDevice();
        } else if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            webDriver.getAndroidDriver().unlockDevice();
        }
    }

    /**
     * Hide the soft keyboard if it is showing.
     */
    @Action
    public void hideKeyboard() {
        webDriver.getAppiumDriver().hideKeyboard();
    }

    /**
     * Hide the soft keyboard if it is showing by pressing the particular key button.
     *
     * @param name the key name to press
     */
    @Action(param1 = "name")
    public void hideKeyboard(String name) {
        webDriver.findElement(String.format("//XCUIElementTypeButton[@name='%s']", name)).click();
    }

    /**
     * Toggle Airplane mode on device and this works on OS 6.0 and lesser
     * and does not work on OS 7.0 and greater
     */
    @Action(ios = false)
    public void toggleAirplaneMode() {
        webDriver.getAndroidDriver().toggleAirplaneMode();
    }

    /**
     * Switch the state of the wifi service
     */
    @Action(ios = false)
    public void toggleWifi() {
        webDriver.getAndroidDriver().toggleWifi();
    }

    /**
     * Switch the state of the location service
     */
    @Action(ios = false)
    public void toggleLocationServices() {
        webDriver.getAndroidDriver().toggleLocationServices();
    }

    /**
     * Simulate a successful touch id event (iOS Simulator only)
     * <p>
     * This call will only work if Appium process or its parent application (e.g. Terminal.app or Appium.app) has access to Mac OS accessibility in System Preferences > Security & Privacy > Privacy > Accessibility list
     */
    @Action(android = false)
    public void acceptTouchID() {
        webDriver.getIOSDriver().performTouchID(true);
    }

    /**
     * Simulate a failed touch id event (iOS Simulator only)
     * <p>
     * This call will only work if Appium process or its parent application (e.g. Terminal.app or Appium.app) has access to Mac OS accessibility in System Preferences > Security & Privacy > Privacy > Accessibility list
     */
    @Action(android = false)
    public void rejectTouchID() {
        webDriver.getIOSDriver().performTouchID(false);
    }

    /**
     * Authenticate users by using their finger print scans on supported emulators. (For Android emulator)
     *
     * @param fingerPrintId finger prints stored in Android Keystore system (from 1 to 10)
     */
    @Action(param1 = "fingerPrintId", ios = false)
    public void fingerPrint(String fingerPrintId) {
        webDriver.getAndroidDriver().fingerPrint(Integer.parseInt(fingerPrintId));
    }

    /**
     * Open the notification shade, on Android devices. (Emulator only)
     */
    @Action(ios = false)
    public void openNotifications() {
        webDriver.getAndroidDriver().openNotifications();
    }

    /**
     * Open Control Center, on iOS devices.
     */
    @Action(android = false)
    public void openControlCenter() {

        // Copy from https://github.com/appium/appium-xcuitest-driver/blob/master/test/functional/basic/gesture-e2e-specs.js
        int x, y0, y1;
        WebElement window = webDriver.findElement("class=XCUIElementTypeApplication");
        int width = window.getSize().width;
        int height = window.getSize().height;
        try {
            // Try locating the 'Cellular' element (which can be pulled down)
            WebElement cellularEl = webDriver.findElement("Cellular");
            x = cellularEl.getLocation().x;
            y0 = cellularEl.getLocation().y;
        } catch (NoSuchElementException e) {
            // Otherwise, pull up the middle of the bottom of the device (for iPhone X, pull down from the top)
            x = width / 2;
            y0 = webDriver.isIphoneX() ? 15 : height - 5;
        }
        y1 = height / 2;

        new TouchAction(webDriver.getAppiumDriver())
                .press(PointOption.point(x, y0))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, y1))
                .perform();
    }

    /**
     * Close Control Center, on iOS devices.
     */
    @Action(android = false)
    public void closeControlCenter() {

        // Copy from https://github.com/appium/appium-xcuitest-driver/blob/master/test/functional/basic/gesture-e2e-specs.js
        int x, y0, y1;
        WebElement window = webDriver.findElement("class=XCUIElementTypeApplication");
        int width = window.getSize().width;
        int height = window.getSize().height;
        try {
            // Try locating the 'Cellular' element (which can be pulled down)
            WebElement cellularEl = webDriver.findElement("Cellular");
            x = cellularEl.getLocation().x;
            y0 = cellularEl.getLocation().y;
        } catch (NoSuchElementException e) {
            // Otherwise, pull up the middle of the bottom of the device (for iPhone X, pull down from the top)
            x = width / 2;
            y0 = webDriver.isIphoneX() ? 15 : height - 5;
        }
        y1 = height / 2;

        new TouchAction(webDriver.getAppiumDriver())
                .press(PointOption.point(x, y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, y0))
                .perform();
    }
}
