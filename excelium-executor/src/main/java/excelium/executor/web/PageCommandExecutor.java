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

package excelium.executor.web;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class which contains commands for controlling pages.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class PageCommandExecutor extends CommandExecutor {

    private int timeToWait = 250;

    /**
     * Instantiates a new Page command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public PageCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Opens an URL in the test frame. This accepts both relative and absolute URLs.
     * <p>
     * The "open" command waits for the page to load before proceeding.
     *
     * <aside class="notice">The URL must be on the same domain as the runner HTML due to security
     * restrictions in the browser (Same Origin Policy). If you need to open an URL on another domain,
     * use the Selenium Server to start a new browser session on that domain.</aside>
     *
     * @param url the URL to open; may be relative or absolute
     */
    @Action(param1 = "url")
    public void open(String url) {
        webDriver.get(getAbsoluteUrl(url));
    }

    /**
     * Gets the title of the current page.
     *
     * @return the title of the current page
     */
    @Accessor
    public String getTitle() {
        String getText = webDriver.getJavascriptLibrary().getSeleniumScript("getText.js");
        try {
            WebElement titleElem = webDriver.findElement(By.xpath("/html/head/title"));
            return (String) webDriver.executeScript(
                    "return (" + getText + ")(arguments[0]);", titleElem);
        } catch (WebDriverException e) {
            return webDriver.getTitle();
        }
    }

    /**
     * Gets the absolute URL of the current page.
     *
     * @return the absolute URL of the current page
     */
    @Accessor
    public String getLocation() {
        return webDriver.executeScript("return window.location.href").toString();
    }

    /**
     * Gets the entire text of the page.
     *
     * @return the entire text of the page
     */
    @Accessor
    public String getBodyText() {
        return webDriver.getElementText(webDriver.findElement(By.xpath("//body")));
    }

    /**
     * Returns the entire HTML source between the opening and closing "html" tags.
     *
     * @return the entire HTML source
     */
    @Accessor
    public String getHtmlSource() {
        return webDriver.getPageSource();
    }

    /**
     * Determines if the specified text pattern appears somewhere on the rendered page shown to the
     * user.
     *
     * @param pattern a pattern to match with the text of the page
     * @return true if the pattern matches the text, false otherwise
     */
    @Accessor(param1 = "pattern")
    public boolean isTextPresent(String pattern) {
        String script = webDriver.getJavascriptLibrary().getSeleniumScript("isTextPresent.js");

        Boolean result = (Boolean) webDriver.executeScript(
                "return (" + script + ")(arguments[0]);", pattern);

        // Handle the null case
        return Boolean.TRUE == result;
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
     * Returns the IDs of all buttons on the page.
     *
     * <p>
     * If a given button has no ID, it will appear as "" in this array.
     * </p>
     *
     * @return the IDs of all buttons on the page
     */
    @Accessor(waitCmd = false, executeCmd = false)
    public String[] getAllButtons() {
        List<WebElement> allInputs = webDriver.findElements(By.xpath("//input"));
        List<String> ids = new ArrayList<>();

        for (WebElement input : allInputs) {
            String type = input.getAttribute("type").toLowerCase();
            if ("button".equals(type) || "submit".equals(type) || "reset".equals(type))
                ids.add(input.getAttribute("id"));
        }

        return ids.toArray(new String[0]);
    }

    /**
     * Returns the IDs of all links on the page.
     *
     * <p>
     * If a given link has no ID, it will appear as "" in this array.
     * </p>
     *
     * @return the IDs of all links on the page
     */
    @Accessor(waitCmd = false, executeCmd = false)
    public String[] getAllLinks() {
        List<WebElement> allLinks = webDriver.findElements(By.xpath("//a"));
        List<String> links = new ArrayList<>();
        for (WebElement link : allLinks) {
            String id = link.getAttribute("id");
            links.add(id == null ? "" : id);
        }

        return links.toArray(new String[0]);
    }

    /**
     * Returns the IDs of all input fields on the page.
     *
     * <p>
     * If a given field has no ID, it will appear as "" in this array.
     * </p>
     *
     * @return the IDs of all field on the page
     */
    @Accessor(waitCmd = false, executeCmd = false)
    public String[] getAllFields() {
        List<WebElement> allInputs = webDriver.findElements(By.xpath("//input"));
        List<String> ids = new ArrayList<>();

        for (WebElement input : allInputs) {
            String type = input.getAttribute("type").toLowerCase();
            if ("text".equals(type))
                ids.add(input.getAttribute("id"));
        }

        return ids.toArray(new String[0]);
    }

    /**
     * Returns the number of nodes that match the specified xpath, eg. "//table" would give the number
     * of tables.
     *
     * @param xpath the xpath expression to evaluate. do NOT wrap this expression in a 'count()'
     *              function; we will do that for you.
     * @return the number of nodes that match the specified xpath
     */
    @Accessor(param1 = "xpath", storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getXpathCount(String xpath) {
        return webDriver.findElements(By.xpath(xpath)).size();
    }

    /**
     * Returns the number of nodes that match the specified css selector, eg. "css=table" would give
     * the number of tables.
     *
     * @param css the css selector to evaluate. do NOT wrap this expression in a 'count()' function;
     *            we will do that for you.
     * @return the number of nodes that match the specified selector
     */
    @Accessor(param1 = "css", storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getCssCount(String css) {
        return webDriver.findElements(By.cssSelector(css)).size();
    }

    /**
     * Waits for a new page to load.
     *
     * <p>
     * You can use this command instead of the "AndWait" suffixes, "clickAndWait", "selectAndWait",
     * "typeAndWait" etc. (which are only available in the JS API).
     * </p>
     * <p>
     * Selenium constantly keeps track of new pages loading, and sets a "newPageLoaded" flag when it
     * first notices a page load. Running any other Selenium command after turns the flag to false.
     * Hence, if you want to wait for a page to load, you must wait immediately after a Selenium
     * command that caused a page-load.
     * </p>
     *
     * @param timeout a timeout in milliseconds, after which this command will return with an error
     */
    @Action(param1 = "timeout")
    public void waitForPageToLoad(String timeout) {
        // Micro sleep before we continue in case an async click needs processing.
        hesitate(timeToWait);

        Object result;
        try {
            result = webDriver.executeScript(
                    "return !!document['readyState'];");
        } catch (WebDriverException e) {
            // Page might still be loading. Give it a chance to get some content.
            hesitate(500);
            try {
                result = webDriver.executeScript(
                        "return !!document['readyState'];");
            } catch (WebDriverException e2) {
                return;
            }
        }

        WebDriverWait wait = createWebDriverWait(timeout);
        wait.until((result != null && (Boolean) result) ?
                getReadyStateUsingWait() : getLengthCheckingWait());

        hesitate(timeToWait);
    }

    private void hesitate(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private ExpectedCondition<Boolean> getReadyStateUsingWait() {
        return driver -> {
            try {
                Object result = ((JavascriptExecutor) driver).executeScript(
                        "return 'complete' == document.readyState;");

                if (result instanceof Boolean && (Boolean) result) {
                    return true;
                }
            } catch (Exception e) {
                // Possible page reload. Fine
            }
            return false;
        };
    }

    public ExpectedCondition<Boolean> getLengthCheckingWait() {
        return new ExpectedCondition<Boolean>() {
            private int length;
            private long seenAt;

            @Override
            public Boolean apply(WebDriver driver) {
                // Page length needs to be stable for a second
                try {
                    int currentLength = webDriver.getElementText(driver.findElement(By.tagName("body"))).length();
                    if (seenAt == 0) {
                        seenAt = System.currentTimeMillis();
                        length = currentLength;
                        return false;
                    }

                    if (currentLength != length) {
                        seenAt = System.currentTimeMillis();
                        length = currentLength;
                        return false;
                    }

                    return System.currentTimeMillis() - seenAt > 1000;
                } catch (NoSuchElementException ignored) {
                } catch (NullPointerException ignored) {
                }

                return false;
            }
        };
    }
}
