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

public class TestWaitInPopupWindow extends WebExecutorTestBase {
  @Test
  public void testWaitInPopupWindow() throws Throwable {
    selenium.open("../tests/html/test_select_window.html");
    selenium.click("popupPage");
    selenium.waitForPopUp("myPopupWindow", "5000");
    selenium.selectWindow("myPopupWindow");
    selenium.verifyTitle("Select Window Popup");
    selenium.setTimeout("5000");
    selenium.click("link=Click to load new page");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Reload Page");
    selenium.setTimeout("30000");
    selenium.click("link=Click here");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Slow Loading Page");
    selenium.close();
    selenium.selectWindow("null");
  }
}
