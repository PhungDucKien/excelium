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

public class TestGoBack extends WebExecutorTestBase {
  @Test
  public void testGoBack() throws Throwable {
    selenium.open("../tests/html/test_click_page1.html");
    selenium.verifyTitle("Click Page 1");
    // Click a regular link
    selenium.click("link");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Click Page Target");
    selenium.goBack();
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Click Page 1");
    // history.forward() generates 'Permission Denied' in IE
    // <tr>
    // <td>goForward</td>
    // <td>&nbsp;</td>
    // <td>&nbsp;</td>
    // </tr>
    // <tr>
    // <td>verifyTitle</td>
    // <td>Click Page Target</td>
    // <td>&nbsp;</td>
    // </tr>
    //
  }
}
