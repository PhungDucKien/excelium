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

public class TestClickJavascriptHrefChrome extends WebExecutorTestBase {
  @Test
  public void testClickJavascriptHrefChrome() throws Throwable {
    selenium.open("../tests/html/test_click_javascript_chrome_page.html");
    selenium.click("id=a");
    selenium.verifyAlert("a");
    selenium.chooseOkAlert();
    selenium.click("id=b");
    selenium.verifyAlert("b");
    selenium.chooseOkAlert();
    selenium.click("id=c");
    selenium.verifyAlert("c");
    selenium.chooseOkAlert();
    selenium.click("id=d");
    selenium.verifyElementNotPresent("id=d");
    selenium.click("id=e");
    selenium.verifyAlert("e");
    selenium.chooseOkAlert();
    selenium.verifyElementNotPresent("id=e");
    selenium.click("id=f");
    selenium.waitForPopUp("f-window", "10000");
    selenium.selectWindow("name=f-window");
    selenium.verifyElementPresent("id=visibleParagraph");
    selenium.close();
    selenium.selectWindow("");

    // TODO(simon): re-enable this part of the test
    // selenium.click("id=g");
    // selenium.verifyAlert("g");
    // selenium.waitForPopUp("g-window", "10000");
    // selenium.selectWindow("name=g-window");
    // selenium.verifyElementPresent("id=visibleParagraph");
    // selenium.close();
    // selenium.selectWindow("");
    selenium.click("id=h");
    selenium.verifyAlert("h");
    selenium.chooseOkAlert();
    selenium.waitForPageToLoad("30000");
    selenium.verifyElementPresent("id=visibleParagraph");
  }
}
