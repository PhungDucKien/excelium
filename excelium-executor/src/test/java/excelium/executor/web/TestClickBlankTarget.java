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

public class TestClickBlankTarget extends WebExecutorTestBase {
  @Test
  public void testClickBlankTarget() throws Throwable {
    selenium.open("../tests/html/Frames.html");
    selenium.selectFrame("bottomFrame");
    selenium.click("changeBlank");
    selenium.waitForPopUp("_blank", "10000");
    selenium.selectWindow("_blank");
    selenium.click("changeSpan");
    selenium.close();
    selenium.selectWindow("null");
    selenium.click("changeBlank");
    selenium.waitForPopUp("_blank", "10000");
    selenium.selectWindow("_blank");
    selenium.click("changeSpan");
    selenium.close();
    selenium.selectWindow("null");
    selenium.selectParentFrame();
    selenium.selectFrame("bottomFrame");
    selenium.submit("formBlank");
    selenium.waitForPopUp("_blank", "10000");
    selenium.selectWindow("_blank");
    selenium.click("changeSpan");
    selenium.close();
    selenium.selectWindow("null");
    selenium.open("../tests/html/test_select_window.html");
    selenium.click("popupBlank");
    selenium.waitForPopUp("_blank", "10000");
    selenium.selectWindow("_blank");
    System.out.println("At the end");
    selenium.verifyTitle("Select Window Popup");
    selenium.close();
    selenium.selectWindow("null");
  }
}
