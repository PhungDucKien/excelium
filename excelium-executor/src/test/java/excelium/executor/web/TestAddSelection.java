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

public class TestAddSelection extends WebExecutorTestBase {
  @Test
  public void addingToSelectionWhenSelectHasEmptyMultipleAttribute() throws Throwable {
    selenium.open("../tests/html/test_multiple_select.html");

    selenium.addSelection("sel", "select_2");
    selenium.addSelection("sel", "select_3");

    selenium.storeSelectedIds("name=sel", "found");

    selenium.assertExpression("${size(found)}", "2");
    selenium.assertExpression("${found[0]}", "select_2");
    selenium.assertExpression("${found.1}", "select_3");
  }

  @Test
  public void addingToSelectionShouldThrowExceptionForSingleSelectionList() throws Throwable {
    selenium.open("../tests/html/test_select.html");

    selenium.storeSelectedIds("theSelect", "before");

    try {
      selenium.addSelection("theSelect", "Second Option");
      fail("Expected SeleniumException");
    } catch (SeleniumException ex) {
      // Expected exception. Message is different in DefaultSelenium
      // and WebDriverBackedSelenium
    }

    selenium.assertSelectedIds("theSelect", "${before.0}");
  }
}
