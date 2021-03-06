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

public class TestFailingVerifications extends WebExecutorTestBase {
  @Test
  public void testFailingVerifications() throws Throwable {
    selenium.open("../tests/html/test_verifications.html");
    try {
      selenium.assertLocationMatch(
          "^[\\s\\S]*/tests/html/not_test_verifications\\.html$");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertValue("theText", "not the text value");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertNotValue("theText", "the text value");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertValue("theHidden", "not the hidden value");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertText("theSpan", "this is not the span");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertTextPresent("this is not the span");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertTextNotPresent("this is the span");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertElementPresent("notTheSpan");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertElementNotPresent("theSpan");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertTable("theTable", "2.0", "a");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertSelectedIndex("theSelect", "2");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertSelectedValueMatch("theSelect", "^opt[\\s\\S]*3$");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertSelectedLabel("theSelect", "third option");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertSelectOptions("theSelect",
          "first\\\noption\nsecond option");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertAttribute("theText", "class", "bar");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertNotAttribute("theText", "class", "foo");
      fail("expected failure");
    } catch (Throwable e) {
    }
  }
}
