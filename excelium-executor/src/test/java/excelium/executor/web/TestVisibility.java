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

public class TestVisibility extends WebExecutorTestBase {
  @Test
  public void testVisibility() throws Throwable {
    selenium.open("../tests/html/test_visibility.html");
    selenium.verifyVisible("visibleParagraph");
    selenium.verifyNotVisible("hiddenParagraph");
    selenium.verifyNotVisible("suppressedParagraph");
    selenium.verifyNotVisible("classSuppressedParagraph");
    selenium.verifyNotVisible("jsClassSuppressedParagraph");
    selenium.verifyNotVisible("hiddenSubElement");
    selenium.verifyVisible("visibleSubElement");
    selenium.verifyNotVisible("suppressedSubElement");
    selenium.verifyNotVisible("jsHiddenParagraph");
    try {
      selenium.assertNotVisible("visibleParagraph");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("hiddenParagraph");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("suppressedParagraph");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("classSuppressedParagraph");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("jsClassSuppressedParagraph");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("hiddenSubElement");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("suppressedSubElement");
      fail("expected failure");
    } catch (Throwable e) {
    }
    try {
      selenium.assertVisible("jsHiddenParagraph");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.verifyNotVisible("hiddenInput");
    try {
      selenium.assertVisible("nonExistentElement");
      fail("expected failure");
    } catch (Throwable e) {
    }
  }
}
