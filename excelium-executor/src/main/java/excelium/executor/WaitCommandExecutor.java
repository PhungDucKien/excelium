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

package excelium.executor;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static excelium.core.by.ByParser.parseBy;

/**
 * Represents a class which contains commands for waiting for a condition.
 *
 * @author PhungDucKien
 * @since 2018.06.30
 */
public class WaitCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Wait command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public WaitCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Wait for the specified amount of time (in milliseconds)
     *
     * @param waitTime the amount of time to sleep (in milliseconds)
     * @throws InterruptedException
     */
    @Action(param1 = "waitTime")
    public void pause(String waitTime) throws InterruptedException {
        Thread.sleep(toInteger(waitTime, 0));
    }

    /**
     * Specifies the amount of time that Selenium will wait for actions to complete.
     *
     * <p>
     * Actions that require waiting include "open" and the "waitFor*" actions.
     * </p>
     * The default timeout is 30 seconds.
     *
     * @param timeout a timeout in milliseconds, after which the action will return with an error
     */
    @Action(param1 = "timeout")
    public void setTimeout(String timeout) {
        webDriver.manage().timeouts().implicitlyWait(Long.valueOf(timeout), TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().setScriptTimeout(Long.valueOf(timeout), TimeUnit.MILLISECONDS);
        webDriver.setTimeout(Integer.valueOf(timeout));
    }

    /**
     * Sets the amount of time to wait for a page load to complete before throwing an error.
     *
     * @param timeout a timeout in milliseconds, after which the page load will return with an error
     */
    @Action(param1 = "timeout", android = false, ios = false)
    public void setPageLoadTimeout(String timeout) {
        long wait = toPositiveInteger(timeout, webDriver.getTimeout());
        webDriver.manage().timeouts().pageLoadTimeout(wait, TimeUnit.MILLISECONDS);
    }

    /**
     * Waits for any of the specified texts is somewhere on the page.
     *
     * @param textArray array of texts
     */
    @Action(param1 = "textArray")
    public void waitForAnyTextPresent(String[] textArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            expectedConditions[i] = textToBePresent(normalizeText(textArray[i]));
        }
        wait.until(ExpectedConditions.or(expectedConditions));
    }

    /**
     * Waits for any of the specified texts is not present on the page.
     *
     * @param textArray array of texts
     */
    @Action(param1 = "textArray")
    public void waitForAnyTextNotPresent(String[] textArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            expectedConditions[i] = ExpectedConditions.not(textToBePresent(normalizeText(textArray[i])));
        }
        wait.until(ExpectedConditions.or(expectedConditions));
    }

    /**
     * Waits for all of the specified texts are somewhere on the page.
     *
     * @param textArray array of texts
     */
    @Action(param1 = "textArray")
    public void waitForAllTextPresent(String[] textArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            expectedConditions[i] = textToBePresent(normalizeText(textArray[i]));
        }
        wait.until(ExpectedConditions.and(expectedConditions));
    }

    /**
     * Waits for all of the specified texts are not present on the page.
     *
     * @param textArray array of texts
     */
    @Action(param1 = "textArray")
    public void waitForAllTextNotPresent(String[] textArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            expectedConditions[i] = ExpectedConditions.not(textToBePresent(normalizeText(textArray[i])));
        }
        wait.until(ExpectedConditions.and(expectedConditions));
    }

    /**
     * Waits for any of the specified elements is somewhere on the page.
     *
     * @param locatorArray array of element locators
     */
    @Action(param1 = "locatorArray")
    public void waitForAnyElementPresent(String[] locatorArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[locatorArray.length];
        for (int i = 0; i < locatorArray.length; i++) {
            expectedConditions[i] = ExpectedConditions.presenceOfElementLocated(parseBy(locatorArray[i], webDriver));
        }
        wait.until(ExpectedConditions.or(expectedConditions));
    }

    /**
     * Waits for any of the specified elements is not present on the page.
     *
     * @param locatorArray array of element locators
     */
    @Action(param1 = "locatorArray")
    public void waitForAnyElementNotPresent(String[] locatorArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[locatorArray.length];
        for (int i = 0; i < locatorArray.length; i++) {
            expectedConditions[i] = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(parseBy(locatorArray[i], webDriver)));
        }
        wait.until(ExpectedConditions.or(expectedConditions));
    }

    /**
     * Waits for all of the specified elements are somewhere on the page.
     *
     * @param locatorArray array of element locators
     */
    @Action(param1 = "locatorArray")
    public void waitForAllElementPresent(String[] locatorArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[locatorArray.length];
        for (int i = 0; i < locatorArray.length; i++) {
            expectedConditions[i] = ExpectedConditions.presenceOfElementLocated(parseBy(locatorArray[i], webDriver));
        }
        wait.until(ExpectedConditions.and(expectedConditions));
    }

    /**
     * Waits for all of the specified elements are not present on the page.
     *
     * @param locatorArray array of element locators
     */
    @Action(param1 = "locatorArray")
    public void waitForAllElementNotPresent(String[] locatorArray) {
        WebDriverWait wait = createWebDriverWait();
        ExpectedCondition[] expectedConditions = new ExpectedCondition[locatorArray.length];
        for (int i = 0; i < locatorArray.length; i++) {
            expectedConditions[i] = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(parseBy(locatorArray[i], webDriver)));
        }
        wait.until(ExpectedConditions.and(expectedConditions));
    }

    private ExpectedCondition<Boolean> textToBePresent(final String text) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                if (webDriver.isWebContext()) {
                    String script = webDriver.getJavascriptLibrary().getSeleniumScript("isTextPresent.js");

                    Boolean result = (Boolean) webDriver.executeScript(
                            "return (" + script + ")(arguments[0]);", text);

                    // Handle the null case
                    return Boolean.TRUE == result;
                } else {
                    return driver.getPageSource().contains(text);
                }
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in page", text);
            }
        };
    }
}
