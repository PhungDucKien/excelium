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

public class TestSelect extends WebExecutorTestBase {
  @Test
  public void testSelect() throws Throwable {
    selenium.open("../tests/html/test_select.html");
    selenium.assertSomethingSelected("theSelect");
    selenium.assertSelectedLabel("theSelect", "Second Option");
    selenium.select("theSelect", "index=4");
    selenium.verifySelectedLabel("theSelect", "Fifth Option");
    selenium.verifySelectedIndex("theSelect", "4");
    selenium.verifySelectedLabel("theSelect", "Fifth Option");
    selenium.verifySelectedLabels("theSelect", "Fifth Option");
    selenium.select("theSelect", "Third Option");
    selenium.verifySelectedLabel("theSelect", "Third Option");
    selenium.verifySelectedLabel("theSelect", "Third Option");
    selenium.verifySelectedLabel("theSelect", "Third Option");
    selenium.select("theSelect", "label=Fourth Option");
    selenium.verifySelectedLabel("theSelect", "Fourth Option");
    selenium.verifySelectedLabel("theSelect", "Fourth Option");
    selenium.select("theSelect", "value=option6");
    selenium.verifySelectedLabel("theSelect", "Sixth Option");
    selenium.verifySelectedValue("theSelect", "option6");
    selenium.verifySelectedValue("theSelect", "option6");
    selenium.select("theSelect", "value=");
    selenium.verifySelectedLabel("theSelect", "Empty Value Option");
    selenium.select("theSelect", "id=o4");
    selenium.verifySelectedLabel("theSelect", "Fourth Option");
    selenium.verifySelectedId("theSelect", "o4");
    selenium.select("theSelect", "");
    selenium.verifySelectedLabel("theSelect", "");
    selenium.verifySelectedLabels("theSelect", "");
    try {
      selenium.select("theSelect", "Not an option");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.addSelection("theSelect", "Fourth Option");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.removeSelection("theSelect", "Fourth Option");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.verifySelectOptions("theSelect",
        "First Option\nSecond Option\nThird Option\nFourth Option\nFifth Option\nSixth Option\nEmpty Value Option\n");
  }
}
