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

public class TestFramesClick extends WebExecutorTestBase {
  @Test
  public void testFramesClick() throws Throwable {
    selenium.open("../tests/html/Frames.html");
    selenium.selectFrame("mainFrame");
    selenium.open("../tests/html/test_click_page1.html");
    // Click a regular link
    selenium.verifyText("link", "Click here for next page");
    selenium.click("link");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Click Page Target");
    selenium.click("previousPage");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Click Page 1");
    // Click a link with an enclosed image
    selenium.click("linkWithEnclosedImage");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Click Page Target");
    selenium.click("previousPage");
    selenium.waitForPageToLoad("30000");
    // Click an image enclosed by a link
    selenium.click("enclosedImage");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Click Page Target");
    selenium.click("previousPage");
    selenium.waitForPageToLoad("30000");
    // Click a link with an href anchor target within this page
    selenium.click("linkToAnchorOnThisPage");
    selenium.verifyTitle("Click Page 1");
    // Click a link where onclick returns false
    selenium.click("linkWithOnclickReturnsFalse");
    // Need a pause to give the page a chance to reload (so this test can fail)
    Thread.sleep(300);
    selenium.verifyTitle("Click Page 1");
    selenium.setTimeout("5000");
    selenium.open("../tests/html/test_click_page1.html");
    // TODO Click a link with a target attribute
  }
}
