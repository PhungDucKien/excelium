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
            webDriver.isWeb(); result = true;
        }};

        By by = ByParser.parseBy("id=id", webDriver);
        Assert.assertTrue(by instanceof By.ById);
        Assert.assertEquals("By.id: id", by.toString());

        by = ByParser.parseBy("name=name", webDriver);
        Assert.assertTrue(by instanceof By.ByName);
        Assert.assertEquals("By.name: name", by.toString());

        by = ByParser.parseBy("css=css", webDriver);
        Assert.assertTrue(by instanceof By.ByCssSelector);
        Assert.assertEquals("By.cssSelector: css", by.toString());

        by = ByParser.parseBy("link=link", webDriver);
        Assert.assertTrue(by instanceof By.ByLinkText);
        Assert.assertEquals("By.linkText: link", by.toString());

        by = ByParser.parseBy("xpath=//xpath", webDriver);
        Assert.assertTrue(by instanceof By.ByXPath);
        Assert.assertEquals("By.xpath: //xpath", by.toString());

        by = ByParser.parseBy("identifier=identifier", webDriver);
        Assert.assertTrue(by instanceof ByIdOrName);
        Assert.assertEquals("by id or name \"identifier\"", by.toString());

        by = ByParser.parseBy("variable=variable", webDriver);
        Assert.assertTrue(by instanceof ByVariable);
        Assert.assertEquals("By.variable: variable", by.toString());

        by = ByParser.parseBy("//xpath", webDriver);
        Assert.assertTrue(by instanceof By.ByXPath);
        Assert.assertEquals("By.xpath: //xpath", by.toString());

        by = ByParser.parseBy("identifier", webDriver);
        Assert.assertTrue(by instanceof ByIdOrName);
        Assert.assertEquals("by id or name \"identifier\"", by.toString());
    }

    @Test
    public void testParseByMobile() {
        new Expectations() {{
            webDriver.isWeb(); result = false;
        }};

        By by = ByParser.parseBy("accessibility_id=accessibility_id", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAccessibilityId);
        Assert.assertEquals("By.AccessibilityId: accessibility_id", by.toString());

        by = ByParser.parseBy("class=class", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByClassName);
        Assert.assertEquals("By.className: class", by.toString());

        by = ByParser.parseBy("id=id", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ById);
        Assert.assertEquals("By.id: id", by.toString());

        by = ByParser.parseBy("name=name", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByName);
        Assert.assertEquals("By.name: name", by.toString());

        by = ByParser.parseBy("xpath=xpath", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByXPath);
        Assert.assertEquals("By.xpath: xpath", by.toString());

        by = ByParser.parseBy("android_uiautomator=android_uiautomator", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByAndroidUIAutomator);
        Assert.assertEquals("By.AndroidUIAutomator: android_uiautomator", by.toString());

        by = ByParser.parseBy("ios_uiautomation=ios_uiautomation", webDriver);
        Assert.assertTrue(by instanceof MobileBy.ByIosUIAutomation);
        Assert.assertEquals("By.IosUIAutomation: ios_uiautomation", by.toString());

        by = ByParser.parseBy("variable=variable", webDriver);
        Assert.assertTrue(by instanceof ByVariable);
        Assert.assertEquals("By.variable: variable", by.toString());
    }
}
