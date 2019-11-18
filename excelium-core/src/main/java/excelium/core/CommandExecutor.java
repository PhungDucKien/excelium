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

package excelium.core;

import excelium.common.NumberUtil;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for command executors.
 *
 * @author PhungDucKien
 * @since 2018.05.07
 */
public class CommandExecutor {

    /**
     * Web driver
     */
    protected final ContextAwareWebDriver webDriver;

    /**
     * Base URL
     */
    protected final String baseUrl;

    /**
     * Excelium object
     */
    protected final Excelium excelium;

    /**
     * Project instance
     */
    protected final Project project;

    /**
     * Instantiates a new Command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public CommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        this.webDriver = webDriver;
        this.baseUrl = baseUrl;
        this.excelium = excelium;
        this.project = project;
    }

    /**
     * Run an action.
     *
     * @param actionName the action name
     * @throws Exception the exception
     */
    public void runAction(String actionName) throws Exception {
        if (excelium != null) {
            excelium.runAction(actionName);
        } else {
            throw new Exception("The command executor can not run an action.");
        }
    }

    /**
     * Normalize text string.
     *
     * @param text the text
     * @return the string
     */
    public String normalizeText(String text) {
        text = text.replace("\r\n", "\n");
        if (webDriver.isNativeContext()) {
            text = text.replace("\n", "&#10;");
        }
        return text;
    }

    /**
     * Create web driver wait with the default timeout.
     *
     * @return the web driver wait
     */
    public WebDriverWait createWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(webDriver, 0);
        wait.withTimeout(Duration.ofMillis(webDriver.getTimeout()));
        return wait;
    }

    /**
     * Create web driver wait with the custom timeout.
     *
     * @param timeOutInMilliseconds The timeout in milliseconds when an expectation is called
     * @return the web driver wait
     */
    public WebDriverWait createWebDriverWait(String timeOutInMilliseconds) {
        long timeout = toPositiveInteger(timeOutInMilliseconds, webDriver.getTimeout());
        WebDriverWait wait = new WebDriverWait(webDriver, 0);
        wait.withTimeout(Duration.ofMillis(timeout));
        return wait;
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public ContextAwareWebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Get the absolute URL from the given URL.
     *
     * @param url the URL
     * @return the absolute URL
     */
    protected String getAbsoluteUrl(String url) {
        return baseUrl != null && !url.contains("://") ?
                baseUrl + (!url.startsWith("/") ? "/" : "") + url :
                url;
    }

    /**
     * Parse the given {@code text} into a positive {@link Integer} instance.
     *
     * @param value the text value
     * @param defaultValue the default value
     * @return an integer
     */
    protected int toPositiveInteger(String value, int defaultValue) {
        // Of course, a non-breaking space doesn't count as whitespace.
        value = value.replace('\u00A0',' ').trim();
        return NumberUtil.parsePositiveInteger(value, defaultValue);
    }

    /**
     * Parse the given {@code text} into an {@link Integer} instance.
     *
     * @param value the text value
     * @param defaultValue the default value
     * @return an integer
     */
    protected int toInteger(String value, int defaultValue) {
        // Of course, a non-breaking space doesn't count as whitespace.
        value = value.replace('\u00A0',' ').trim();
        return NumberUtil.parseInteger(value, defaultValue);
    }
}
