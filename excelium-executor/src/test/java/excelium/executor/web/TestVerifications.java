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

public class TestVerifications extends WebExecutorTestBase {
  @Test
  public void testVerifications() throws Throwable {
    selenium.open("../tests/html/test_verifications.html?foo=bar");
    selenium.verifyLocationMatch(
        "^[\\s\\S]*/tests/html/test_verifications\\.html[\\s\\S]*$");
    selenium.verifyLocationMatch(
        "^[\\s\\S]*/tests/html/test_verifications\\.html[\\s\\S]foo=bar$");
    selenium.verifyValue("theText", "the text value");
    selenium.verifyNotValue("theText", "not the text value");
    selenium.verifyValue("theHidden", "the hidden value");
    selenium.verifyText("theSpan", "this is the span");
    selenium.verifyNotText("theSpan", "blah blah");
    selenium.verifyTextPresent("this is the span");
    selenium.verifyTextNotPresent("this is not the span");
    selenium.verifyElementPresent("theSpan");
    selenium.verifyElementPresent("theText");
    selenium.verifyElementNotPresent("unknown");
    selenium.verifyTable("theTable", "0.0", "th1");
    selenium.verifyTable("theTable", "1.0", "a");
    selenium.verifyTable("theTable", "2.1", "d");
    selenium.verifyTable("theTable", "3.1", "f2");
    selenium.verifySelectedIndex("theSelect", "1");
    selenium.verifySelectedValue("theSelect", "option2");
    selenium.verifySelectedLabel("theSelect", "second option");
    selenium.verifySelectedLabel("theSelect", "second option");
    selenium.verifySelectedId("theSelect", "o2");
    selenium.verifySelectOptions("theSelect",
        "first option\nsecond option\nthird,,option");
    selenium.verifyAttribute("theText", "class", "foo");
    selenium.verifyNotAttribute("theText", "class", "fox");
    selenium.verifyTitle("theTitle");
    selenium.verifyNotTitle("Blah Blah");
  }
}
