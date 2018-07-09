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

public class TestModalDialog extends WebExecutorTestBase {
  @Test
  public void testModalDialog() throws Throwable {
    selenium.open("../tests/html/test_modal_dialog.html");
    selenium.verifyLocationMatch("^[\\s\\S]*/tests/html/test_modal_dialog\\.html$");
    selenium.verifyTitle("Modal Dialog Host Window");

    selenium.verifyText("changeText", "before modal dialog");

    // TODO(simon): re-enable this test
    return;

    // selenium.click("modal");
    // // selenium.waitForPopup("Modal Dialog Popup", "5000");
    // selenium.selectWindow("Modal Dialog Popup");
    // selenium.verifyTitle("Modal Dialog Popup");
    // selenium.click("change");
    // selenium.click("close");
    // selenium.selectWindow("Modal Dialog Host Window");
    // selenium.verifyText("changeText", "after modal dialog");
    // selenium.verifyTitle("Modal Dialog Popup");
  }
}
