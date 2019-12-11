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

package excelium.core.by;

import excelium.core.driver.ContextAwareWebDriver;
import io.appium.java_client.MobileBy;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;

/**
 * Tests for {@link ByParser}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class ByParserTest {

    @Mocked
    private ContextAwareWebDriver webDriver;

    @Test
    public void testParseByWeb() {
        new Expectations() {{
            webDriver.isWebContext(); result = true;
        }};

        By by = ByParser.parseBy("id=id", webDriver);
        Assert.assertTrue(by instanceof By.ById);
        Assert.assertEquals("By.id: id", by.toString());

        by = ByParser.parseBy("link=link", webDriver);
        Assert.assertTrue(by instanceof By.ByLinkText);
        Assert.assertEquals("By.linkText: link", by.toString());

        by = ByParser.parseBy("partial link=link", webDriver);
        Assert.assertTrue(by instanceof By.ByPartialLinkText);
        Assert.assertEquals("By.partialLinkText: link", by.toString());

        by = ByParser.parseBy("tag=button", webDriver);
        Assert.assertTrue(by instanceof By.ByTagName);
        Assert.assertEquals("By.tagName: button", by.toString());

        by = ByParser.parseBy("name=name", webDriver);
        Assert.assertTrue(by instanceof By.ByName);
        Assert.assertEquals("By.name: name", by.toString());

        by = ByParser.parseBy("class=class", webDriver);
        Assert.assertTrue(by instanceof By.ByClassName);
        Assert.assertEquals("By.className: class", by.toString());

        by = ByParser.parseBy("css=css", webDriver);
        Assert.assertTrue(by instanceof ByCss);
        Assert.assertEquals("By.css: css", by.toString());

        by = ByParser.parseBy("xpath=//xpath", webDriver);
        Assert.assertTrue(by instanceof By.ByXPath);
        Assert.assertEquals("By.xpath: //xpath", by.toString());

        by = ByParser.parseBy("identifier=identifier", webDriver);
        Assert.assertTrue(by instanceof ByIdOrName);
        Assert.assertEquals("by id or name \"identifier\"", by.toString());

        by = ByParser.parseBy("alt=alt", webDriver);
        Assert.assertTrue(by instanceof ByAlt);
        Assert.assertEquals("By.alt: alt", by.toString());

        by = ByParser.parseBy("dom=dom", webDriver);
        Assert.assertTrue(by instanceof ByDom);
        Assert.assertEquals("By.dom: dom", by.toString());

        by = ByParser.parseBy("index=1", webDriver);
        Assert.assertTrue(by instanceof ByIndex);
        Assert.assertEquals("By.index: [null][1]", by.toString());

        by = ByParser.parseBy("variable=variable", webDriver);
        Assert.assertTrue(by instanceof ByVariable);
        Assert.assertEquals("By.variable: variable", by.toString());

        by = ByParser.parseBy("//xpath", webDriver);
        Assert.assertTrue(by instanceof By.ByXPath);
        Assert.assertEquals("By.xpath: //xpath", by.toString());

        by = ByParser.parseBy("document.getElementById('login-btn')", webDriver);
        Assert.assertTrue(by instanceof ByDom);
        Assert.assertEquals("By.dom: document.getElementById('login-btn')", by.toString());

        by = ByParser.parseBy("identifier", webDriver);
        Assert.assertTrue(by instanceof ByIdOrName);
        Assert.assertEquals("by id or name \"identifier\"", by.toString());
    }

    @Test
    public void testParseByMobile() {
        new Expectations() {{
            webDriver.isWebContext(); result = false;
        }};

        By by = ByParser.parseBy("accessibility id=accessibility id", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAccessibilityId);
        Assert.assertEquals("By.AccessibilityId: accessibility id", by.toString());

        by = ByParser.parseBy("class=class", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByClassName);
        Assert.assertEquals("By.className: class", by.toString());

        by = ByParser.parseBy("id=id", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ById);
        Assert.assertEquals("By.id: id", by.toString());

        by = ByParser.parseBy("name=name", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByName);
        Assert.assertEquals("By.name: name", by.toString());

        by = ByParser.parseBy("xpath=//xpath", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByXPath);
        Assert.assertEquals("By.xpath: //xpath", by.toString());

        by = ByParser.parseBy("android uiautomator=android uiautomator", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAndroidUIAutomator);
        Assert.assertEquals("By.AndroidUIAutomator: android uiautomator", by.toString());

        by = ByParser.parseBy("android viewtag=android viewtag", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAndroidViewTag);
        Assert.assertEquals("By.AndroidViewTag: android viewtag", by.toString());

        by = ByParser.parseBy("android datamatcher=android datamatcher", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAndroidDataMatcher);
        Assert.assertEquals("By.FindsByAndroidDataMatcher: android datamatcher", by.toString());

        by = ByParser.parseBy("ios predicate string=ios predicate string", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByIosNsPredicate);
        Assert.assertEquals("By.IosNsPredicate: ios predicate string", by.toString());

        by = ByParser.parseBy("ios class chain=ios class chain", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByIosClassChain);
        Assert.assertEquals("By.IosClassChain: ios class chain", by.toString());

        by = ByParser.parseBy("windows uiautomation=windows uiautomation", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByWindowsAutomation);

        by = ByParser.parseBy("index=1", webDriver);
        Assert.assertTrue(by instanceof ByIndex);
        Assert.assertEquals("By.index: [null][1]", by.toString());

        by = ByParser.parseBy("variable=variable", webDriver);
        Assert.assertTrue(by instanceof ByVariable);
        Assert.assertEquals("By.variable: variable", by.toString());

        by = ByParser.parseBy("//xpath", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByXPath);
        Assert.assertEquals("By.xpath: //xpath", by.toString());

        by = ByParser.parseBy("accessibility id", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAccessibilityId);
        Assert.assertEquals("By.AccessibilityId: accessibility id", by.toString());
    }
}
