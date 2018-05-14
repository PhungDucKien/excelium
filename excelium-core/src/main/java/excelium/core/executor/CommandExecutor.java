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

package excelium.core.executor;

import excelium.common.NumberUtil;
import excelium.core.TestRunner;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.enums.Result;
import excelium.model.test.action.TestAction;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for command executors.
 *
 * @author PhungDucKien
 * @since 2018.05.07
 */
public class CommandExecutor {

    /**
     * Default timeout (in seconds) for web driver
     */
    private static final int WEBDRIVER_DEFAULT_TIMEOUT = 120;

    /**
     * Web driver
     */
    protected final ContextAwareWebDriver webDriver;

    /**
     * Test runner
     */
    private final TestRunner testRunner;

    /**
     * Instantiates a new Command executor.
     *
     * @param webDriver the web driver
     */
    public CommandExecutor(ContextAwareWebDriver webDriver) {
        this(webDriver, null);
    }

    /**
     * Instantiates a new Command executor.
     *
     * @param webDriver  the web driver
     * @param testRunner the test runner
     */
    public CommandExecutor(ContextAwareWebDriver webDriver, TestRunner testRunner) {
        this.webDriver = webDriver;
        this.testRunner = testRunner;
    }

    /**
     * Run an action.
     *
     * @param action the action
     * @throws Exception the exception
     */
    public void runAction(TestAction action) throws Exception {
        if (testRunner != null) {
            Result result = testRunner.runAction(action);
            if (result != Result.OK) {
                throw new Exception("Action execution failed.");
            }
        }
        throw new Exception("The command executor can not run an action.");
    }

    /**
     * Normalize text string.
     *
     * @param text the text
     * @return the string
     */
    public String normalizeText(String text) {
        text = text.replace("\r\n", "\n");
        if (!this.webDriver.isWeb()) {
            text = text.replace("\n", "&#10;");
        }
        return webDriver.evalTemplate(text);
    }

    /**
     * Create web driver wait with the default timeout.
     *
     * @return the web driver wait
     */
    public WebDriverWait createWebDriverWait() {
        return new WebDriverWait(webDriver, WEBDRIVER_DEFAULT_TIMEOUT);
    }

    /**
     * Create web driver wait with the custom timeout.
     *
     * @param timeOutInSeconds The timeout in seconds when an expectation is called
     * @return the web driver wait
     */
    public WebDriverWait createWebDriverWait(String timeOutInSeconds) {
        return new WebDriverWait(webDriver, NumberUtil.parsePositiveInteger(timeOutInSeconds, WEBDRIVER_DEFAULT_TIMEOUT));
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public ContextAwareWebDriver getWebDriver() {
        return webDriver;
    }
}
