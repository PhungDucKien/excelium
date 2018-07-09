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

public class TestOpen extends WebExecutorTestBase {
  @Test
  public void testOpen() throws Throwable {
    selenium.open("../tests/html/test_open.html");
    selenium.verifyLocationMatch("^[\\s\\S]*/tests/html/test_open\\.html$");
  }

  @Test
  public void testIsTextPresentCanDoExactAndRegexChecks() throws Throwable {
    selenium.open("../tests/html/test_open.html");
    selenium.verifyTextPresent("This is a test of the open command.");
    selenium.verifyTextPresent("glob:This is a test of the open command.");
    selenium.verifyTextPresent("exact:This is a test of");
    selenium.verifyTextPresent("regexp:This is a test of");
    selenium.verifyTextPresent("regexp:T*his is a test of");
    selenium.verifyTextNotPresent("exact:XXXXThis is a test of");
    selenium.verifyTextNotPresent("regexp:ThXXXXXXXXXis is a test of");
  }

@Test
  public void testCanOpenSlowLoadingPage() throws Throwable {
    selenium.open("../tests/html/test_page.slow.html");
    selenium.verifyLocationMatch("^[\\s\\S]*/tests/html/test_page\\.slow\\.html$");
    selenium.verifyTitle("Slow Loading Page");
    selenium.setTimeout("5000");
    selenium.open("../tests/html/test_open.html");
    selenium.open("../tests/html/test_open.html");
    selenium.open("../tests/html/test_open.html");
  }

}
