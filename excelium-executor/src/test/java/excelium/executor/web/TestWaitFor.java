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

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.fail;

public class TestWaitFor extends WebExecutorTestBase {
  @Test
  public void testWaitFor() throws Throwable {
    selenium.open("../tests/html/test_async_event.html");
    selenium.assertValue("theField", "oldValue");
    selenium.click("theButton");
    selenium.assertValue("theField", "oldValue");
    selenium.waitForValueMatch("theField", "n[aeiou]wValue");

    selenium.verifyValue("theField", "newValue");
    selenium.assertText("theSpan", "Some text");
    selenium.click("theSpanButton");
    selenium.assertText("theSpan", "Some text");
    selenium.waitForTextMatch("theSpan", "Some n[aeiou]w text");

    selenium.verifyText("theSpan", "Some new text");
    selenium.click("theAlertButton");
    selenium.waitForAlertMatch("An [aeiou]lert");
    selenium.chooseOkAlert();

    selenium.open("../tests/html/test_reload_onchange_page.html");
    selenium.click("theLink");
    selenium.waitForTitle("Slow Loading Page");

    selenium.verifyTitle("Slow Loading Page");
    selenium.setTimeout("500");
    try {
      selenium.waitForTextPresent("thisTextIsNotPresent");
      fail("expected failure");
    } catch (Throwable e) {
    }
  }

  @After
  public void resetTimeout() throws Throwable {
    selenium.setTimeout("30000");
  }
}
