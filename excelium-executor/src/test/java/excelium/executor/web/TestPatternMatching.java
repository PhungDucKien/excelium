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

import java.util.regex.Pattern;

public class TestPatternMatching extends WebExecutorTestBase {
  @Test
  public void testPatternMatching() throws Throwable {
    selenium.open("../tests/html/test_verifications.html");
    selenium.verifyValueMatch("theText", "^[\\s\\S]*text[\\s\\S]*$");
    selenium.verifyValueMatch("theHidden", "^[\\s\\S]* hidden value$");
    selenium.verifyTextMatch("theSpan", "^[\\s\\S]* span$");
    selenium.verifySelectedLabelMatch("theSelect", "^second [\\s\\S]*$");
    selenium.verifySelectOptionsMatch("theSelect",
        "^first[\\s\\S]*\nsecond[\\s\\S]*\nthird[\\s\\S]*$");
    selenium.verifyAttributeMatch("theText", "class", "^[\\s\\S]oo$");
    selenium.verifyValueMatch("theTextarea", "^Line 1[\\s\\S]*$");
    selenium.verifyValueMatch("theText", "^[a-z ]+$");
    selenium.verifyValueMatch("theHidden", "dd");
    selenium.verifyValueNotMatch("theHidden", "DD");
//    selenium.verifyValue("theHidden", "regexpi:DD");
    selenium.verifyTextMatch("theSpan", "span$");
    selenium.verifySelectedLabelMatch("theSelect", "second .*");
    selenium.verifyAttributeMatch("theText", "class", "^f");
    selenium.verifyValueMatch("theText", "^[a-z ]+$");
    selenium.verifyValueMatch("theHidden", "dd");
    selenium.verifyTextMatch("theSpan", "span$");
    selenium.verifySelectedLabelMatch("theSelect", "second .*");
    selenium.verifyAttributeMatch("theText", "class", "^f");
    selenium.verifyValue("theText", "the text value");
    selenium.verifySelectedLabel("theSelect", "second option");
    selenium.verifySelectOptionsMatch("theSelect", "^first.*?\nsecond option\nthird*");
  }
}
