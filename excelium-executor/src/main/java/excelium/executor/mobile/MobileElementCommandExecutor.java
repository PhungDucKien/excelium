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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Represents a class which contains commands for controlling mobile elements.
 *
 * @author PhungDucKien
 * @since 2019.10.27
 */
public class MobileElementCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Mobile element command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public MobileElementCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Click element at its center point.
     * <p>
     * If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void click(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        element.click();
    }

    /**
     * Click a button with the given text at its center point.
     * <p>
     * If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.
     *
     * @param indexOrText an index or a text to find
     */
    @Action(param1 = "indexOrText")
    public void clickButton(String indexOrText) {
        String buttonClass;
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            buttonClass = "XCUIElementTypeButton";
        } else {
            buttonClass = "android.widget.Button";
        }
        MobileElement element = findElementByClassName(buttonClass, indexOrText);
        element.click();
    }

    /**
     * Click a text label with the given text at its center point.
     * <p>
     * If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.
     *
     * @param indexOrText an index or a text to find
     */
    @Action(param1 = "indexOrText")
    public void clickText(String indexOrText) {
        String textClass;
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            textClass = "XCUIElementTypeTextView";
        } else {
            textClass = "android.widget.TextView";
        }
        MobileElement element = findElementByClassName(textClass, indexOrText);
        element.click();
    }

    private MobileElement findElementByClassName(String className, String indexOrText) {
        List<MobileElement> elements = webDriver.getAppiumDriver().findElementsByClassName(className);

        if (indexOrText.startsWith("index=")) {
            int index = Integer.parseInt(indexOrText.split("=")[1]);
            return elements.get(index);
        } else {
            for (MobileElement element : elements) {
                if (element.getText().equals(indexOrText)) {
                    return element;
                }
            }
        }
        throw new NoSuchElementException("No such element.");
    }

    /**
     * Send a sequence of key strokes to an element
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param value         the value to type
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void type(String parentLocator, String locator, String value) {
        MobileElement element = (MobileElement) webDriver.findElement(parentLocator, locator);
        if (webDriver.getAppiumDriver() instanceof IOSDriver) {
            element.sendKeys(value);
        } else if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            // https://stackoverflow.com/questions/27859076/appium-sendkeys-really-slow-on-android
            element.setValue(value);
        }
        if (webDriver.getAppiumDriver() instanceof AndroidDriver) {
            if (webDriver.getAndroidDriver().isKeyboardShown()) {
                webDriver.getAppiumDriver().hideKeyboard();
            }
        }
    }

    /**
     * Clear an element's value
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void clear(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        element.clear();
    }
}
