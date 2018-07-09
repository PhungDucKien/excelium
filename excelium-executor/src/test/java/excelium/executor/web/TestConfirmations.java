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

public class TestConfirmations extends WebExecutorTestBase {
  @Test
  public void testConfirmations() throws Throwable {
    selenium.open("../tests/html/test_confirm.html");
    selenium.click("confirmAndLeave");
    selenium.verifyConfirmationPresent();
    selenium.waitForConfirmationPresent();

    selenium.assertConfirmationPresent();
    selenium.verifyConfirmation("You are about to go to a dummy page.");
    selenium.chooseCancelConfirmation();
    selenium.verifyTitle("Test Confirm");
    selenium.click("confirmAndLeave");
    selenium.verifyConfirmationMatch("^[\\s\\S]*dummy page[\\s\\S]*$");
    selenium.chooseOkConfirmation();
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Dummy Page");
    selenium.open("../tests/html/test_confirm.html");
    selenium.verifyTitle("Test Confirm");
    selenium.click("confirmAndLeave");
    selenium.verifyConfirmationMatch("^[\\s\\S]*dummy page[\\s\\S]*$");
    selenium.chooseOkConfirmation();
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Dummy Page");
    selenium.open("../tests/html/test_confirm.html");
    try {
      selenium.assertConfirmation("This should fail - there are no confirmations");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.click("confirmAndLeave");
    try {
      selenium.assertConfirmation("this should fail - wrong confirmation");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.chooseOkConfirmation();
    selenium.waitForPageToLoad("30000");
    selenium.open("../tests/html/test_confirm.html");
    selenium.click("confirmAndLeave");
    try {
      selenium.open("../tests/html/test_confirm.html");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.chooseOkConfirmation();
    selenium.waitForPageToLoad("30000");
  }
}
