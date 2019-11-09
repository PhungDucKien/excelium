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

package excelium.core.driver;

import com.thoughtworks.selenium.webdriven.JavascriptLibrary;
import com.thoughtworks.selenium.webdriven.commands.KeyState;
import excelium.core.context.TestContext;
import excelium.core.database.DatabaseService;
import excelium.core.screenshot.ScreenshotService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.JxltEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import static excelium.core.by.ByParser.parseBy;

/**
 * Web driver that enables context awareness.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class ContextAwareWebDriver extends RemoteWebDriver {

    /**
     * Wrapped web driver
     */
    private RemoteWebDriver webDriver;

    /**
     * Test context
     */
    private TestContext testContext;

    /**
     * Javascript library
     */
    private final JavascriptLibrary javascriptLibrary;

    /**
     * Key state
     */
    private final KeyState keyState;

    /**
     * Database service
     */
    private final DatabaseService databaseService;

    /**
     * Screenshot service
     */
    private final ScreenshotService screenshotService;

    /**
     * Timeout (in milliseconds) for web driver
     */
    private int timeout = 120000;

    /**
     * Instantiates a new ContextAwareWebDriver.
     *
     * @param webDriver         the web driver
     * @param databaseService   the database service
     * @param screenshotService the screenshot service
     */
    public ContextAwareWebDriver(RemoteWebDriver webDriver, DatabaseService databaseService, ScreenshotService screenshotService) {
        this.webDriver = webDriver;
        this.testContext = new TestContext();
        this.javascriptLibrary = new JavascriptLibrary();
        this.keyState = new KeyState();
        this.databaseService = databaseService;
        this.screenshotService = screenshotService;
    }

    public RemoteWebDriver getWebDriver() {
        return webDriver;
    }

    public AppiumDriver getAppiumDriver() {
        return (AppiumDriver) webDriver;
    }

    public AndroidDriver getAndroidDriver() {
        return (AndroidDriver) webDriver;
    }

    public IOSDriver getIOSDriver() {
        return (IOSDriver) webDriver;
    }

    /**
     * Determine whether the web driver is web automation driver.
     *
     * @return true if the web driver is web automation driver
     */
    public boolean isWeb() {
        return !(webDriver instanceof AppiumDriver) || ((AppiumDriver) webDriver).isBrowser();
    }

    /**
     * Determine whether the web driver is Internet Explorer driver.
     *
     * @return true if the web driver is Internet Explorer driver
     */
    public boolean isIE() {
        return webDriver instanceof InternetExplorerDriver;
    }

    /**
     * Determine whether the web driver is Android automation driver.
     *
     * @return true if the web driver is Android automation driver
     */
    public boolean isAndroid() {
        return webDriver instanceof AndroidDriver && !((AndroidDriver) webDriver).isBrowser();
    }

    /**
     * Determine whether the web driver is iOS automation driver.
     *
     * @return true if the web driver is iOS automation driver
     */
    public boolean isIOS() {
        return webDriver instanceof IOSDriver && !((IOSDriver) webDriver).isBrowser();
    }

    /**
     * Gets variable value.
     *
     * @param variable the variable
     * @return the value
     */
    public Object getVariable(String variable) {
        return testContext.get(variable);
    }

    /**
     * Sets variable.
     *
     * @param value    the value
     * @param variable the variable
     */
    public void setVariable(Object value, String variable) {
        testContext.set(variable, value);
    }

    /**
     * Push variable.
     *
     * @param value    the value
     * @param variable the variable
     */
    public void pushVariable(Object value, String variable) {
        if (testContext.has(variable)) {
            Object item = getVariable(variable);
            if (item instanceof List) {
                ((List) item).add(value);
            } else {
                List<Object> newList = new ArrayList<>();
                newList.add(item);
                newList.add(value);
                setVariable(newList, variable);
            }
        } else {
            List<Object> newList = new ArrayList<>();
            newList.add(value);
            setVariable(newList, variable);
        }
    }

    /**
     * Evaluates an expression
     *
     * @param expression the expression string
     * @return the evaluated value
     */
    public Object evalExp(String expression) {
        JexlEngine jexl = new JexlBuilder().create();
        JexlExpression e = jexl.createExpression(expression);
        return e.evaluate(testContext);
    }

    /**
     * Evaluates a template string
     *
     * @param template the template string
     * @return the evaluated string
     */
    public String evalTemplate(String template) {
        JexlEngine jexl = new JexlBuilder().create();
        JxltEngine jxlt = jexl.createJxltEngine();
        JxltEngine.Expression expr = jxlt.createExpression(template);
        return expr.evaluate(testContext).toString();
    }

    /**
     * Finds the element by the given locator.
     *
     * @param locator the locator
     * @return the element
     * @throws NoSuchElementException the no such element exception
     */
    public WebElement findElement(String locator) throws NoSuchElementException {
        By by = parseBy(locator, this);
        return webDriver.findElement(by);
    }

    /**
     * Finds the list of elements by the given locator.
     *
     * @param locator the locator
     * @return the list of elements
     * @throws NoSuchElementException the no such element exception
     */
    public List<WebElement> findElements(String locator) throws NoSuchElementException {
        By by = parseBy(locator, this);
        return webDriver.findElements(by);
    }

    /**
     * Finds the element by the given parent locator and element locator.
     *
     * @param parentLocator the parent locator
     * @param locator       the element locator
     * @return the element
     * @throws NoSuchElementException the no such element exception
     */
    public WebElement findElement(String parentLocator, String locator) {
        if (parentLocator == null) {
            return findElement(locator);
        }
        By parentBy = parseBy(parentLocator, this);
        By by = parseBy(locator, this);
        WebElement parentElement = webDriver.findElement(parentBy);
        return parentElement.findElement(by);
    }

    /**
     * Finds the list of elements by the given parent locator and element locator.
     *
     * @param parentLocator the parent locator
     * @param locator       the element locator
     * @return the list of elements
     * @throws NoSuchElementException the no such element exception
     */
    public List<WebElement> findElements(String parentLocator, String locator) {
        if (parentLocator == null) {
            return findElements(locator);
        }
        By parentBy = parseBy(parentLocator, this);
        By by = parseBy(locator, this);
        List<WebElement> parentElements = webDriver.findElements(parentBy);
        List<WebElement> elements = new ArrayList<>();
        for (WebElement parentElement : parentElements) {
            elements.addAll(parentElement.findElements(by));
        }
        return elements;
    }

    /**
     * Gets the text of an element.
     *
     * @param element an element
     * @return the text of the element
     */
    public String getElementText(WebElement element) {
        if (isWeb()) {
            String getText = javascriptLibrary.getSeleniumScript("getText.js");
            try {
                return (String) webDriver.executeScript(
                        "return (" + getText + ")(arguments[0]);", element);
            } catch (WebDriverException e) {
                // TODO(simon): remove fall back for IE driver
                return element.getText();
            }
        } else {
            return element.getText();
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Gets javascript library.
     *
     * @return the javascript library
     */
    public JavascriptLibrary getJavascriptLibrary() {
        return javascriptLibrary;
    }

    /**
     * Is meta key down boolean.
     *
     * @return the boolean
     */
    public boolean isMetaKeyDown() {
        return keyState.metaKeyDown;
    }

    /**
     * Sets meta key down.
     *
     * @param metaKeyDown the meta key down
     */
    public void setMetaKeyDown(boolean metaKeyDown) {
        keyState.metaKeyDown = metaKeyDown;
    }

    /**
     * Is alt key down boolean.
     *
     * @return the boolean
     */
    public boolean isAltKeyDown() {
        return keyState.altKeyDown;
    }

    /**
     * Sets alt key down.
     *
     * @param altKeyDown the alt key down
     */
    public void setAltKeyDown(boolean altKeyDown) {
        keyState.altKeyDown = altKeyDown;
    }

    /**
     * Is control key down boolean.
     *
     * @return the boolean
     */
    public boolean isControlKeyDown() {
        return keyState.controlKeyDown;
    }

    /**
     * Sets control key down.
     *
     * @param controlKeyDown the control key down
     */
    public void setControlKeyDown(boolean controlKeyDown) {
        keyState.controlKeyDown = controlKeyDown;
    }

    /**
     * Is shift key down boolean.
     *
     * @return the boolean
     */
    public boolean isShiftKeyDown() {
        return keyState.shiftKeyDown;
    }

    /**
     * Sets shift key down.
     *
     * @param shiftKeyDown the shift key down
     */
    public void setShiftKeyDown(boolean shiftKeyDown) {
        keyState.shiftKeyDown = shiftKeyDown;
    }

    /**
     * Gets database service.
     *
     * @return the database service
     */
    public DatabaseService getDatabaseService() {
        return databaseService;
    }

    /**
     * Gets screenshot service.
     *
     * @return the screenshot service
     */
    public ScreenshotService getScreenshotService() {
        return screenshotService;
    }

    @Override
    public void setFileDetector(FileDetector detector) {
        webDriver.setFileDetector(detector);
    }

    @Override
    public SessionId getSessionId() {
        return webDriver.getSessionId();
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return webDriver.getErrorHandler();
    }

    @Override
    public void setErrorHandler(ErrorHandler handler) {
        webDriver.setErrorHandler(handler);
    }

    @Override
    public CommandExecutor getCommandExecutor() {
        return webDriver.getCommandExecutor();
    }

    @Override
    public Capabilities getCapabilities() {
        return webDriver.getCapabilities();
    }

    @Override
    public void get(String url) {
        webDriver.get(url);
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webDriver.getScreenshotAs(outputType);
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    @Override
    public WebElement findElementById(String using) {
        return webDriver.findElementById(using);
    }

    @Override
    public List<WebElement> findElementsById(String using) {
        return webDriver.findElementsById(using);
    }

    @Override
    public WebElement findElementByLinkText(String using) {
        return webDriver.findElementByLinkText(using);
    }

    @Override
    public List<WebElement> findElementsByLinkText(String using) {
        return webDriver.findElementsByLinkText(using);
    }

    @Override
    public WebElement findElementByPartialLinkText(String using) {
        return webDriver.findElementByPartialLinkText(using);
    }

    @Override
    public List<WebElement> findElementsByPartialLinkText(String using) {
        return webDriver.findElementsByPartialLinkText(using);
    }

    @Override
    public WebElement findElementByTagName(String using) {
        return webDriver.findElementByTagName(using);
    }

    @Override
    public List<WebElement> findElementsByTagName(String using) {
        return webDriver.findElementsByTagName(using);
    }

    @Override
    public WebElement findElementByName(String using) {
        return webDriver.findElementByName(using);
    }

    @Override
    public List<WebElement> findElementsByName(String using) {
        return webDriver.findElementsByName(using);
    }

    @Override
    public WebElement findElementByClassName(String using) {
        return webDriver.findElementByClassName(using);
    }

    @Override
    public List<WebElement> findElementsByClassName(String using) {
        return webDriver.findElementsByClassName(using);
    }

    @Override
    public WebElement findElementByCssSelector(String using) {
        return webDriver.findElementByCssSelector(using);
    }

    @Override
    public List<WebElement> findElementsByCssSelector(String using) {
        return webDriver.findElementsByCssSelector(using);
    }

    @Override
    public WebElement findElementByXPath(String using) {
        return webDriver.findElementByXPath(using);
    }

    @Override
    public List<WebElement> findElementsByXPath(String using) {
        return webDriver.findElementsByXPath(using);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return webDriver.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return webDriver.executeAsyncScript(script, args);
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    @Override
    public void setLogLevel(Level level) {
        webDriver.setLogLevel(level);
    }

    @Override
    public void perform(Collection<Sequence> actions) {
        webDriver.perform(actions);
    }

    @Override
    public void resetInputState() {
        webDriver.resetInputState();
    }

    @Override
    public Keyboard getKeyboard() {
        return webDriver.getKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return webDriver.getMouse();
    }

    @Override
    public FileDetector getFileDetector() {
        return webDriver.getFileDetector();
    }

    @Override
    public String toString() {
        return webDriver.toString();
    }
}
