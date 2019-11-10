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

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a class which contains commands for controlling mobile interaction actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class InteractionCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Interaction command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public InteractionCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Single tap on the touch enabled device
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void tap(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        new TouchAction(webDriver.getAppiumDriver())
                .tap(TapOptions.tapOptions().withTapsCount(1).withElement(ElementOption.element(element)))
                .perform();
    }

    /**
     * Double tap on the touch screen using finger motion events
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void doubleTap(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        new TouchAction(webDriver.getAppiumDriver())
                .tap(TapOptions.tapOptions().withTapsCount(2).withElement(ElementOption.element(element)))
                .perform();
    }

    /**
     * Long press on the touch screen using finger motion events.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void longPress(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        new TouchAction(webDriver.getAppiumDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .perform();
    }

    /**
     * Single tap at a specified position on the touch enabled device
     *
     * @param coordinate a string represents a position of x and y
     */
    @Action(param1 = "coordinate")
    public void tapAt(String coordinate) {
        String[] coords = coordinate.split(",");
        new TouchAction(webDriver.getAppiumDriver())
                .tap(TapOptions.tapOptions().withTapsCount(1).withPosition(PointOption.point(Integer.parseInt(coords[0].trim()), Integer.parseInt(coords[1].trim()))))
                .perform();
    }

    /**
     * Double tap at a specified position on the touch enabled device
     *
     * @param coordinate a string represents a position of x and y
     */
    @Action(param1 = "coordinate")
    public void doubleTapAt(String coordinate) {
        String[] coords = coordinate.split(",");
        new TouchAction(webDriver.getAppiumDriver())
                .tap(TapOptions.tapOptions().withTapsCount(2).withPosition(PointOption.point(Integer.parseInt(coords[0].trim()), Integer.parseInt(coords[1].trim()))))
                .perform();
    }

    /**
     * Long press at a specified position on the touch enabled device
     *
     * @param coordinate a string represents a position of x and y
     */
    @Action(param1 = "coordinate")
    public void longPressAt(String coordinate) {
        String[] coords = coordinate.split(",");
        new TouchAction(webDriver.getAppiumDriver())
                .longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(Integer.parseInt(coords[0].trim()), Integer.parseInt(coords[1].trim()))))
                .perform();
    }

    /**
     * Performs a simple "swipe" up gesture on the whole screen.
     */
    @Action
    public void swipeUp() {
        swipeUp(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" down gesture on the whole screen.
     */
    @Action
    public void swipeDown() {
        swipeDown(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" right gesture on the whole screen.
     */
    @Action
    public void swipeRight() {
        swipeRight(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" left gesture on the whole screen.
     */
    @Action
    public void swipeLeft() {
        swipeLeft(webDriver.getAppiumDriver(), null);
    }

    /**
     * Performs a simple "swipe" up gesture on the particular screen element.
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
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollLeftTo(String parentLocator, String locator) {
        scrollLeftTo(webDriver.getAppiumDriver(), parentLocator, locator);
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

    private void swipeAndroid(AndroidDriver driver, String direction, WebElement element) {
        int xOffset = 0;
        int yOffset = 0;
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        if (element != null) {
            xOffset = element.getRect().getX();
            yOffset = element.getRect().getY();
            width = element.getRect().getWidth();
            height = element.getRect().getHeight();
        }

        double anchorPercentage = 0.5f;
        double startPercentage = (direction.equals("up") || direction.equals("right")) ? 0.1f : 0.9f;
        double finalPercentage = (direction.equals("up") || direction.equals("right")) ? 0.9f : 0.1f;
        long duration = 1000;

        PointOption startPoint = PointOption.point(
                (int) (xOffset + width * ((direction.equals("up") || direction.equals("down")) ? anchorPercentage : startPercentage)),
                (int) (yOffset + height * ((direction.equals("up") || direction.equals("down")) ? startPercentage : anchorPercentage))
        );

        PointOption finalPoint = PointOption.point(
                (int) (xOffset + width * ((direction.equals("up") || direction.equals("down")) ? anchorPercentage : finalPercentage)),
                (int) (yOffset + height * ((direction.equals("up") || direction.equals("down")) ? finalPercentage : anchorPercentage))
        );

        new TouchAction(driver)
                .press(startPoint)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(finalPoint)
                .release().perform();
    }

    private void scrollAndroid(AndroidDriver driver, String direction, WebElement element) {
        swipeAndroid(driver, direction, element);
    }

    private void scrollToAndroid(AndroidDriver driver, String direction, String parentLocator, String locator) {
        boolean isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        while (!isFound) {
            scrollAndroid(driver, direction, null);
            isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        }
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
}
