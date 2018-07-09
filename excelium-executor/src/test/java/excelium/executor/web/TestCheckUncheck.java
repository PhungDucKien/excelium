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

public class TestCheckUncheck extends WebExecutorTestBase {
  @Test
  public void testCheckUncheck() throws Throwable {
    selenium.open("../tests/html/test_check_uncheck.html");
    selenium.verifyChecked("base-spud");
    selenium.verifyNotChecked("base-rice");
    selenium.verifyChecked("option-cheese");
    selenium.verifyNotChecked("option-onions");
    selenium.check("base-rice");
    selenium.verifyNotChecked("base-spud");
    selenium.verifyChecked("base-rice");
    selenium.uncheck("option-cheese");
    selenium.verifyNotChecked("option-cheese");
    selenium.check("option-onions");
    selenium.verifyChecked("option-onions");
    selenium.verifyNotChecked("option-chilli");
    selenium.check("option-chilli");
    selenium.verifyChecked("option-chilli");
    selenium.uncheck("css=[name=option]:nth-of-type(4)");
    selenium.verifyNotChecked("option-chilli");
  }
}
