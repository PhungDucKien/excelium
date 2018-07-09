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

public class TestImplicitLocators extends WebExecutorTestBase {
  @Test
  public void testImplicitLocators() throws Throwable {
    selenium.open("../tests/html/test_locators.html");
    selenium.verifyText("id1", "this is the first element");
    selenium.verifyAttribute("id1", "class", "a1");
    selenium.verifyText("name1", "this is the second element");
    selenium.verifyAttribute("name1", "class", "a2");
    selenium.verifyText("document.links[1]", "this is the second element");
    selenium.verifyAttribute("document.links[1]", "class", "a2");
    selenium.verifyAttribute("//img[contains(@src, 'banner.gif')]/", "alt", "banner");
    selenium.verifyText("//body/a[2]", "this is the second element");
  }
}
