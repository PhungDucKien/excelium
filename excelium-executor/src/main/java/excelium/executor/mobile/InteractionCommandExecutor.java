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
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

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
     * Scroll down until an element is visible.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollDownTo(String parentLocator, String locator) {
        boolean isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        while (!isFound) {
            swipeVertical(webDriver.getAppiumDriver(), 0.9f, 0.1f, 0.5f, 1000);
            isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        }
    }

    /**
     * Scroll up until an element is visible.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void scrollUpTo(String parentLocator, String locator) {
        boolean isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        while (!isFound) {
            swipeVertical(webDriver.getAppiumDriver(), 0.1f, 0.9f, 0.5f, 1000);
            isFound = webDriver.findElements(parentLocator, locator).size() > 0;
        }
    }

    /**
     * Swipe from left to right
     */
    @Action
    public void swipeRight() {
        swipeHorizontal(webDriver.getAppiumDriver(), 0.1f, 0.9f, 0.5f, 1000);
    }

    /**
     * Swipe from right to left
     */
    @Action
    public void swipeLeft() {
        swipeHorizontal(webDriver.getAppiumDriver(), 0.9f, 0.1f, 0.5f, 1000);
    }

    private void swipeHorizontal(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);
        new TouchAction(driver)
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }

    private void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }
}
