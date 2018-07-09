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

import com.thoughtworks.selenium.SeleniumException;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestCursorPosition extends WebExecutorTestBase {
  @Test
  public void testCursorPosition() throws Throwable {
    selenium.open("../tests/html/test_type_page1.html");
    try {
      selenium.assertCursorPosition("username", "8");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.windowFocus();
    selenium.verifyValue("username", "");
    selenium.type("username", "TestUser");
    selenium.setCursorPosition("username", "0");

    try {
      selenium.storeCursorPosition("username", "position");
    } catch (SeleniumException e) {
      if (!isWindowInFocus(e)) {
        return;
      }
    }
    selenium.verifyVariable("position", "0");
    selenium.setCursorPosition("username", "-1");
    selenium.verifyCursorPosition("username", "8");
    selenium.refresh();
    selenium.waitForPageToLoad("30000");
    try {
      selenium.assertCursorPosition("username", "8");
      fail("expected failure");
    } catch (Throwable e) {
    }
  }

  private boolean isWindowInFocus(SeleniumException e) {
    if (e.getMessage().contains("There is no cursor on this page")) {
      System.out.println("Test failed because window does not have focus");
      return false;
    }
    return true;
  }
}
