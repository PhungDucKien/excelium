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

package excelium.executor.mobile.common;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a class which contains commands for controlling mobile gesture actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class GestureCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Gesture command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public GestureCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Performs a simple "swipe" up gesture on the whole screen.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     */
    @Action
    public void swipeUp() {
        swipeUp(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" down gesture on the whole screen.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     */
    @Action
    public void swipeDown() {
        swipeDown(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" right gesture on the whole screen.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     */
    @Action
    public void swipeRight() {
        swipeRight(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" left gesture on the whole screen.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     */
    @Action
    public void swipeLeft() {
        swipeLeft(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" up gesture on the particular screen element.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void swipeUp(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        swipeUp(webDriver.getAppiumDriver(), element);
    }

    /**
     * Performs a simple "swipe" down gesture on the particular screen element.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void swipeDown(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        swipeDown(webDriver.getAppiumDriver(), element);
    }

    /**
     * Performs a simple "swipe" right gesture on the particular screen element.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void swipeRight(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        swipeRight(webDriver.getAppiumDriver(), element);
    }

    /**
     * Performs a simple "swipe" left gesture on the particular screen element.
     * This method does not accept coordinates and simply emulates single swipe with one finger.
     * It might be useful for such cases like album pagination, switching views, etc.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void swipeLeft(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        swipeLeft(webDriver.getAppiumDriver(), element);
    }

    /**
     * Scrolls up the whole screen.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     */
    @Action
    public void scrollUp() {
        scrollUp(webDriver.getAppiumDriver(), null);
    }

    /**
     * Scrolls down the whole screen.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     */
    @Action
    public void scrollDown() {
        scrollDown(webDriver.getAppiumDriver(), null);
    }

    /**
     * Scrolls right the whole screen.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     */
    @Action
    public void scrollRight() {
        scrollRight(webDriver.getAppiumDriver(), null);
    }

    /**
     * Scrolls left the whole screen.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     */
    @Action
    public void scrollLeft() {
        scrollLeft(webDriver.getAppiumDriver(), null);
    }

    /**
     * Scrolls up on the particular screen element.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollUp(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        scrollUp(webDriver.getAppiumDriver(), element);
    }

    /**
     * Scrolls down on the particular screen element.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollDown(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        scrollDown(webDriver.getAppiumDriver(), element);
    }

    /**
     * Scrolls right on the particular screen element.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollRight(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        scrollRight(webDriver.getAppiumDriver(), element);
    }

    /**
     * Scrolls left on the particular screen element.
     * The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollLeft(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        scrollLeft(webDriver.getAppiumDriver(), element);
    }

    /**
     * Scrolls up on the whole screen to the first visible element in the parent container.
     * Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed.
     * Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollUpTo(String parentLocator, String locator) {
        scrollUpTo(webDriver.getAppiumDriver(), parentLocator, locator);
    }

    /**
     * Scrolls down on the whole screen to the first visible element in the parent container.
     * Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed.
     * Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollDownTo(String parentLocator, String locator) {
        scrollDownTo(webDriver.getAppiumDriver(), parentLocator, locator);
    }

    /**
     * Scrolls right on the whole screen to the first visible element in the parent container.
     * Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed.
     * Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollRightTo(String parentLocator, String locator) {
        scrollRightTo(webDriver.getAppiumDriver(), parentLocator, locator);
    }

    /**
     * Scrolls left on the whole screen to the first visible element in the parent container.
     * Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed.
     * Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollLeftTo(String parentLocator, String locator) {
        scrollLeftTo(webDriver.getAppiumDriver(), parentLocator, locator);
    }

    /**
     * Performs pinch gesture on the application element.
     *
     * @param scale Pinch scale of type float. Use a scale between 0 and 1 to "pinch close" or zoom out and a scale greater than 1 to "pinch open" or zoom in.
     */
    @Action(param1 = "scale")
    public void pinch(String scale) {
        pinch(webDriver.getAppiumDriver(), null, Double.parseDouble(scale));
    }

    /**
     * Performs pinch gesture on the given element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param scale         Pinch scale of type float. Use a scale between 0 and 1 to "pinch close" or zoom out and a scale greater than 1 to "pinch open" or zoom in.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "scale")
    public void pinch(String parentLocator, String locator, String scale) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        pinch(webDriver.getAppiumDriver(), element, Double.parseDouble(scale));
    }

    private void swipeUp(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            swipeAndroid((AndroidDriver) driver, "up", element);
        } else if (driver instanceof IOSDriver) {
            swipeIOS((IOSDriver) driver, "up", element);
        }
    }

    private void swipeDown(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            swipeAndroid((AndroidDriver) driver, "down", element);
        } else if (driver instanceof IOSDriver) {
            swipeIOS((IOSDriver) driver, "down", element);
        }
    }

    private void swipeRight(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            swipeAndroid((AndroidDriver) driver, "right", element);
        } else if (driver instanceof IOSDriver) {
            swipeIOS((IOSDriver) driver, "right", element);
        }
    }

    private void swipeLeft(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            swipeAndroid((AndroidDriver) driver, "left", element);
        } else if (driver instanceof IOSDriver) {
            swipeIOS((IOSDriver) driver, "left", element);
        }
    }

    private void scrollUp(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            scrollAndroid((AndroidDriver) driver, "up", element);
        } else if (driver instanceof IOSDriver) {
            scrollIOS((IOSDriver) driver, "up", element);
        }
    }

    private void scrollDown(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            scrollAndroid((AndroidDriver) driver, "down", element);
        } else if (driver instanceof IOSDriver) {
            scrollIOS((IOSDriver) driver, "down", element);
        }
    }

    private void scrollRight(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            scrollAndroid((AndroidDriver) driver, "right", element);
        } else if (driver instanceof IOSDriver) {
            scrollIOS((IOSDriver) driver, "right", element);
        }
    }

    private void scrollLeft(AppiumDriver driver, WebElement element) {
        if (driver instanceof AndroidDriver) {
            scrollAndroid((AndroidDriver) driver, "left", element);
        } else if (driver instanceof IOSDriver) {
            scrollIOS((IOSDriver) driver, "left", element);
        }
    }

    private void scrollUpTo(AppiumDriver driver, String parentLocator, String locator) {
        if (driver instanceof AndroidDriver) {
            scrollToAndroid((AndroidDriver) driver, "up", parentLocator, locator);
        } else if (driver instanceof IOSDriver) {
            scrollToIOS((IOSDriver) driver, parentLocator, locator);
        }
    }

    private void scrollDownTo(AppiumDriver driver, String parentLocator, String locator) {
        if (driver instanceof AndroidDriver) {
            scrollToAndroid((AndroidDriver) driver, "down", parentLocator, locator);
        } else if (driver instanceof IOSDriver) {
            scrollToIOS((IOSDriver) driver, parentLocator, locator);
        }
    }

    private void scrollRightTo(AppiumDriver driver, String parentLocator, String locator) {
        if (driver instanceof AndroidDriver) {
            scrollToAndroid((AndroidDriver) driver, "right", parentLocator, locator);
        } else if (driver instanceof IOSDriver) {
            scrollToIOS((IOSDriver) driver, parentLocator, locator);
        }
    }

    private void scrollLeftTo(AppiumDriver driver, String parentLocator, String locator) {
        if (driver instanceof AndroidDriver) {
            scrollToAndroid((AndroidDriver) driver, "left", parentLocator, locator);
        } else if (driver instanceof IOSDriver) {
            scrollToIOS((IOSDriver) driver, parentLocator, locator);
        }
    }

    private void pinch(AppiumDriver driver, WebElement element, double scale) {
        if (driver instanceof AndroidDriver) {
            pinchAndroid((AndroidDriver) driver, element, scale);
        } else if (driver instanceof IOSDriver) {
            pinchIOS((IOSDriver) driver, element, scale);
        }
    }

    private void swipeAndroid(AndroidDriver driver, String direction, WebElement element) {
        try {
            String uiScrollable = getAndroidUIScrollable(direction, element);
            if (direction.equals("down") || direction.equals("right")) {
                driver.findElement(MobileBy.AndroidUIAutomator(uiScrollable + ".flingForward()"));
            } else {
                driver.findElement(MobileBy.AndroidUIAutomator(uiScrollable + ".flingBackward()"));
            }
        } catch (InvalidSelectorException e) {
            // ignore
        }
    }

    private void scrollAndroid(AndroidDriver driver, String direction, WebElement element) {
        try {
            String uiScrollable = getAndroidUIScrollable(direction, element);
            if (direction.equals("down") || direction.equals("right")) {
                driver.findElement(MobileBy.AndroidUIAutomator(uiScrollable + ".scrollForward()"));
            } else {
                driver.findElement(MobileBy.AndroidUIAutomator(uiScrollable + ".scrollBackward()"));
            }
        } catch (InvalidSelectorException e) {
            // ignore
        }
    }

    private void scrollToAndroid(AndroidDriver driver, String direction, String parentLocator, String locator) {
        boolean isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        while (!isFound) {
            scrollAndroid(driver, direction, null);
            isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        }
    }

    private String getAndroidUIScrollable(String direction, WebElement element) {
        String scrollableSelector = "new UiSelector().scrollable(true)";
        if (element != null) {
            String resourceId = element.getAttribute("resource-id");
            if (StringUtils.isNotBlank(resourceId)) {
                scrollableSelector += ".resourceId(\"" + StringEscapeUtils.escapeJava(resourceId) + "\")";
            }
            String contentDesc = element.getAttribute("content-desc");
            if (StringUtils.isNotBlank(contentDesc)) {
                scrollableSelector += ".description(\"" + StringEscapeUtils.escapeJava(contentDesc) + "\")";
            }
        }
        String uiScrollable = "new UiScrollable(" + scrollableSelector + ")";
        if (direction.equals("up") || direction.equals("down")) {
            uiScrollable += ".setAsVerticalList()";
        } else {
            uiScrollable += ".setAsHorizontalList()";
        }
        return uiScrollable;
    }

    private void pinchAndroid(AndroidDriver driver, WebElement element, double scale) {
    }

    private void swipeIOS(IOSDriver driver, String direction, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        if (element != null) {
            params.put("element", ((RemoteWebElement) element).getId());
        }
        driver.executeScript("mobile: swipe", params);
    }

    private void scrollIOS(IOSDriver driver, String direction, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        if (element != null) {
            params.put("element", ((RemoteWebElement) element).getId());
        }
        driver.executeScript("mobile: scroll", params);
    }

    private void scrollToIOS(IOSDriver driver, String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("toVisible", true);
        driver.executeScript("mobile: scroll", params);
    }

    private void pinchIOS(IOSDriver driver, WebElement element, double scale) {
        Map<String, Object> params = new HashMap<>();
        if (element != null) {
            params.put("element", ((RemoteWebElement) element).getId());
        }
        params.put("scale", scale);
        params.put("velocity", scale < 1 ? -2 : 2);
        driver.executeScript("mobile: pinch", params);
    }
}
