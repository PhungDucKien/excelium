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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link ContextAwareWebDriver}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class ContextAwareWebDriverTest {

    @Mocked
    private ChromeDriver chromeDriver;

    @Mocked
    private AndroidDriver androidDriver;

    @Mocked
    private IOSDriver iosDriver;

    @Mocked
    private WebElement element;

    @Test
    public void testIsWeb() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertTrue(webDriver.isWeb());

        new Expectations() {{
            androidDriver.isBrowser(); result = true;
            iosDriver.isBrowser(); result = true;
        }};

        webDriver = new ContextAwareWebDriver(androidDriver, null, null);
        Assert.assertTrue(webDriver.isWeb());

        webDriver = new ContextAwareWebDriver(iosDriver, null, null);
        Assert.assertTrue(webDriver.isWeb());

        new Expectations() {{
            androidDriver.isBrowser(); result = false;
            iosDriver.isBrowser(); result = false;
        }};

        webDriver = new ContextAwareWebDriver(androidDriver, null, null);
        Assert.assertFalse(webDriver.isWeb());

        webDriver = new ContextAwareWebDriver(iosDriver, null, null);
        Assert.assertFalse(webDriver.isWeb());
    }

    @Test
    public void testIsAndroid() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertFalse(webDriver.isAndroid());

        new Expectations() {{
            androidDriver.isBrowser(); result = false;
        }};

        webDriver = new ContextAwareWebDriver(androidDriver, null, null);
        Assert.assertTrue(webDriver.isAndroid());

        webDriver = new ContextAwareWebDriver(iosDriver, null, null);
        Assert.assertFalse(webDriver.isAndroid());

        new Expectations() {{
            androidDriver.isBrowser(); result = true;
        }};

        webDriver = new ContextAwareWebDriver(androidDriver, null, null);
        Assert.assertFalse(webDriver.isAndroid());

        webDriver = new ContextAwareWebDriver(iosDriver, null, null);
        Assert.assertFalse(webDriver.isAndroid());
    }

    @Test
    public void testIsIos() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertFalse(webDriver.isIOS());

        new Expectations() {{
            iosDriver.isBrowser(); result = false;
        }};

        webDriver = new ContextAwareWebDriver(androidDriver, null, null);
        Assert.assertFalse(webDriver.isIOS());

        webDriver = new ContextAwareWebDriver(iosDriver, null, null);
        Assert.assertTrue(webDriver.isIOS());

        new Expectations() {{
            iosDriver.isBrowser(); result = true;
        }};

        webDriver = new ContextAwareWebDriver(androidDriver, null, null);
        Assert.assertFalse(webDriver.isIOS());

        webDriver = new ContextAwareWebDriver(iosDriver, null, null);
        Assert.assertFalse(webDriver.isIOS());
    }

    @Test
    public void testSetVariable() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        webDriver.setVariable("value", "var1");

        Assert.assertEquals("value", webDriver.getVariable("var1"));
    }

    @Test
    public void testPushVariable() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        webDriver.pushVariable("value1", "list1");
        webDriver.setVariable("value", "list2");
        webDriver.pushVariable("value3", "list2");

        Assert.assertTrue(webDriver.getVariable("list1") instanceof List);
        Assert.assertEquals(1, ((List) webDriver.getVariable("list1")).size());
        Assert.assertEquals("value1", ((List) webDriver.getVariable("list1")).get(0));

        Assert.assertTrue(webDriver.getVariable("list2") instanceof List);
        Assert.assertEquals(2, ((List) webDriver.getVariable("list2")).size());
        Assert.assertEquals("value", ((List) webDriver.getVariable("list2")).get(0));
        Assert.assertEquals("value3", ((List) webDriver.getVariable("list2")).get(1));

        webDriver.pushVariable("value2", "list1");

        Assert.assertTrue(webDriver.getVariable("list1") instanceof List);
        Assert.assertEquals(2, ((List) webDriver.getVariable("list1")).size());
        Assert.assertEquals("value1", ((List) webDriver.getVariable("list1")).get(0));
        Assert.assertEquals("value2", ((List) webDriver.getVariable("list1")).get(1));
    }

    @Test
    public void testEvalExp() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        webDriver.setVariable(1, "x");

        Assert.assertEquals(2, webDriver.evalExp("x+1"));
    }

    @Test
    public void testEvalTemplate() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        webDriver.setVariable("mylove", "x");

        Assert.assertEquals("I love mylove", webDriver.evalTemplate("I love ${x}"));
    }

    @Test
    public void testFindElement() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertEquals(element, webDriver.findElement("id=id"));
        Assert.assertEquals(element, webDriver.findElement(null, "id=id"));
    }

    @Test
    public void testFindElements() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(element);

        new Expectations() {{
            chromeDriver.findElements((By) any); result = elements;
        }};

        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertEquals(element, webDriver.findElements("id=id").get(0));
        Assert.assertEquals(element, webDriver.findElements(null, "id=id").get(0));
    }

    @Test
    public void testFindElementWithParent() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertEquals(element, webDriver.findElement("name=body", "id=id"));

        new Verifications() {{
            element.findElement((By) any);
        }};
    }

    @Test
    public void testFindElementsWithParent() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(element);

        new Expectations() {{
            chromeDriver.findElements((By) any); result = elements;
            element.findElements((By) any); result = elements;
        }};

        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        Assert.assertEquals(element, webDriver.findElements("name=body", "id=id").get(0));

        new Verifications() {{
            element.findElements((By) any);
        }};
    }

    @Test
    public void testOverrideMethods() {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(chromeDriver, null, null);
        webDriver.setFileDetector(null);
        webDriver.getSessionId();
        webDriver.getErrorHandler();
        webDriver.setErrorHandler(null);
        webDriver.getCommandExecutor();
        webDriver.getCapabilities();
        webDriver.get(null);
        webDriver.getTitle();
        webDriver.getCurrentUrl();
        webDriver.getScreenshotAs(null);
        webDriver.findElements((By) null);
        webDriver.findElement((By) null);
        webDriver.findElementById(null);
        webDriver.findElementsById(null);
        webDriver.findElementByLinkText(null);
        webDriver.findElementsByLinkText(null);
        webDriver.findElementByPartialLinkText(null);
        webDriver.findElementsByPartialLinkText(null);
        webDriver.findElementByTagName(null);
        webDriver.findElementsByTagName(null);
        webDriver.findElementByName(null);
        webDriver.findElementsByName(null);
        webDriver.findElementByClassName(null);
        webDriver.findElementsByClassName(null);
        webDriver.findElementByCssSelector(null);
        webDriver.findElementsByCssSelector(null);
        webDriver.findElementByXPath(null);
        webDriver.findElementsByXPath(null);
        webDriver.getPageSource();
        webDriver.close();
        webDriver.quit();
        webDriver.getWindowHandles();
        webDriver.getWindowHandle();
        webDriver.executeScript(null);
        webDriver.executeAsyncScript(null);
        webDriver.switchTo();
        webDriver.navigate();
        webDriver.manage();
        webDriver.setLogLevel(null);
        webDriver.perform(null);
        webDriver.resetInputState();
        webDriver.getKeyboard();
        webDriver.getMouse();
        webDriver.getFileDetector();
        webDriver.toString();

        new Verifications() {{
            chromeDriver.setFileDetector(null);
            chromeDriver.getSessionId();
            chromeDriver.getErrorHandler();
            chromeDriver.setErrorHandler(null);
            chromeDriver.getCommandExecutor();
            chromeDriver.getCapabilities();
            chromeDriver.get(null);
            chromeDriver.getTitle();
            chromeDriver.getCurrentUrl();
            chromeDriver.getScreenshotAs(null);
            chromeDriver.findElements(null);
            chromeDriver.findElement(null);
            chromeDriver.findElementById(null);
            chromeDriver.findElementsById(null);
            chromeDriver.findElementByLinkText(null);
            chromeDriver.findElementsByLinkText(null);
            chromeDriver.findElementByPartialLinkText(null);
            chromeDriver.findElementsByPartialLinkText(null);
            chromeDriver.findElementByTagName(null);
            chromeDriver.findElementsByTagName(null);
            chromeDriver.findElementByName(null);
            chromeDriver.findElementsByName(null);
            chromeDriver.findElementByClassName(null);
            chromeDriver.findElementsByClassName(null);
            chromeDriver.findElementByCssSelector(null);
            chromeDriver.findElementsByCssSelector(null);
            chromeDriver.findElementByXPath(null);
            chromeDriver.findElementsByXPath(null);
            chromeDriver.getPageSource();
            chromeDriver.close();
            chromeDriver.quit();
            chromeDriver.getWindowHandles();
            chromeDriver.getWindowHandle();
            chromeDriver.executeScript(null);
            chromeDriver.executeAsyncScript(null);
            chromeDriver.switchTo();
            chromeDriver.navigate();
            chromeDriver.manage();
            chromeDriver.setLogLevel(null);
            chromeDriver.perform(null);
            chromeDriver.resetInputState();
            chromeDriver.getKeyboard();
            chromeDriver.getMouse();
            chromeDriver.getFileDetector();
            chromeDriver.toString();
        }};
    }
}
