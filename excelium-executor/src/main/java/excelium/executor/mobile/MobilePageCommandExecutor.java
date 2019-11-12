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
import excelium.core.command.Accessor;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.By;

/**
 * Represents a class which contains commands for controlling mobile pages.
 *
 * @author PhungDucKien
 * @since 2019.10.27
 */
public class MobilePageCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Mobile page command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public MobilePageCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Returns the current application hierarchy XML (app) or page source (web).
     * <p>
     * In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML.
     *
     * @return the entire page source
     */
    @Accessor
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    /**
     * Determines if the specified text appears somewhere on the page.
     *
     * @param text a text to match with the text of the page
     * @return true if the text matches the text of the page, false otherwise
     */
    @Accessor(param1 = "text")
    public boolean isTextPresent(String text) {
        return this.webDriver.getPageSource().contains(normalizeText(text));
    }

    /**
     * Determines if the specified element is somewhere on the page.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return true if the element is present, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isElementPresent(String parentLocator, String locator) {
        try {
            webDriver.findElement(parentLocator, locator);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * Returns the number of nodes that match the specified xpath, eg. "//XCUIElementTypeTable" would give the number
     * of iOS tables.
     *
     * @param xpath the xpath expression to evaluate. do NOT wrap this expression in a 'count()'
     *              function; we will do that for you.
     * @return the number of nodes that match the specified xpath
     */
    @Accessor(param1 = "xpath", storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getXpathCount(String xpath) {
        return webDriver.findElements(By.xpath(xpath)).size();
    }
}
