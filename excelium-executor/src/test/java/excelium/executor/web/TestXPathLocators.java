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

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestXPathLocators extends WebExecutorTestBase {
  @Test
  public void testXPathLocators() throws Throwable {
    selenium.open("../tests/html/test_locators.html");
    selenium.verifyText("xpath=//a", "this is the first element");
    selenium.verifyText("xpath=//a[@class='a2']", "this is the second element");
    selenium.verifyText("xpath=//*[@class='a2']", "this is the second element");
    selenium.verifyText("xpath=//a[2]", "this is the second element");
    selenium.verifyText("xpath=//a[position()=2]", "this is the second element");
    selenium.verifyElementNotPresent("xpath=//a[@href='foo']");
    selenium.verifyAttribute("xpath=//a[contains(@href,'#id1')]/", "class", "a1");
    selenium.verifyElementPresent("xpath=//a[text()=\"this is the" + "\u00a0"
        + "third element\"]");
    selenium.verifyText("//a", "this is the first element");
    selenium.verifyAttribute("//a[contains(@href,'#id1')]/", "class", "a1");
    selenium.verifyText("xpath=(//table[@class='stylee'])//th[text()='theHeaderText']/../td",
        "theCellText");
    selenium.click("//input[@name='name2' and @value='yes']");
    selenium.verifyElementPresent("xpath=//*[text()=\"right\"]");
    selenium.verifyValue("xpath=//div[@id='nested1']/div[1]//input[2]", "nested3b");
    selenium.verifyValue("xpath=id('nested1')/div[1]//input[2]", "nested3b");
    selenium.verifyValue("xpath=id('anotherNested')//div[contains(@id, 'useful')]//input",
        "winner");
    selenium.assignId("xpath=//*[text()=\"right\"]", "rightButton");
    selenium.verifyElementPresent("rightButton");
    selenium.verifyXpathCount("id('nested1')/div[1]//input", "2");
    selenium.verifyXpathCount("//div[@id='nonexistent']", "0");
    selenium.verifyElementPresent("xpath=//a[@href=\"javascript:doFoo('a', 'b')\"]");
    selenium.verifyElementNotPresent("xpath=id('foo')//applet");
    try {
      selenium.assertElementPresent("xpath=id('foo')//applet2");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertElementPresent("xpath=//a[0}");
      fail("expected failure");
    } catch (Throwable e) {
    }

    // These cases are now covered by the "in play attributes" optimization.

    // <p>Test toggling of ignoreAttributesWithoutValue. The test must be performed using the
    // non-native ajaxslt engine. After the test, native xpaths are re-enabled.</p>
    // <table cellpadding="1" cellspacing="1" border="1">
    // <tbody>

    // <tr>
    // <td>allowNativeXpath</td>
    // <td>false</td>
    // <td>&nbsp;</td>
    // </tr>
    // <tr>
    // <td>ignoreAttributesWithoutValue</td>
    // <td>false</td>
    // <td>&nbsp;</td>
    // </tr>
    // <tr>
    // <td>verifyXpathCount</td>
    // <td>//div[@id='ignore']/a[@class]</td>
    // <td>2</td>
    // </tr>
    // <tr>
    // <td>verifyText</td>
    // <td>//div[@id='ignore']/a[@class][1]</td>
    // <td>over the rainbow</td>
    // </tr>
    // <tr>
    // <td>verifyText</td>
    // <td>//div[@id='ignore']/a[@class][2]</td>
    // <td>skies are blue</td>
    // </tr>
    // <tr>
    // <td>verifyXpathCount</td>
    // <td>//div[@id='ignore']/a[@class='']</td>
    // <td>1</td>
    // </tr>
    // <tr>
    // <td>verifyText</td>
    // <td>//div[@id='ignore']/a[@class='']</td>
    // <td>skies are blue</td>
    // </tr>
    // <tr>
    // <td>ignoreAttributesWithoutValue</td>
    // <td>true</td>
    // <td>&nbsp;</td>
    // </tr>
    // <tr>
    // <td>verifyXpathCount</td>
    // <td>//div[@id='ignore']/a[@class]</td>
    // <td>1</td>
    // </tr>
    // <tr>
    // <td>verifyText</td>
    // <td>//div[@id='ignore']/a[@class]</td>
    // <td>over the rainbow</td>
    // </tr>
    // <tr>
    // <td>verifyXpathCount</td>
    // <td>//div[@id='ignore']/a[@class='']</td>
    // <td>0</td>
    // </tr>
    // <tr>
    // <td>allowNativeXpath</td>
    // <td>true</td>
    // <td>&nbsp;</td>
    // </tr>

  }
}
