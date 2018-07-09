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

import static org.junit.Assert.fail;

public class TestAlerts extends WebExecutorTestBase {
  @Test
  public void testAlerts() throws Throwable {
    selenium.open("../tests/html/test_verify_alert.html");
    selenium.verifyAlertNotPresent();
    selenium.assertAlertNotPresent();
    selenium.click("oneAlert");
    selenium.verifyAlertPresent();
    selenium.waitForAlertPresent();

    selenium.assertAlertPresent();
    selenium.verifyAlert("Store Below 494 degrees K!");
    selenium.chooseOkAlert();
    selenium.click("multipleLineAlert");
    selenium.verifyAlert("This alert spans\nmultiple lines");
    selenium.chooseOkAlert();
    selenium.click("oneAlert");
    selenium.storeAlert("myVar");
    selenium.verifyExpression("${myVar}", "Store Below 494 degrees K!");
    selenium.chooseOkAlert();
    selenium.click("twoAlerts");
    selenium.verifyAlertMatch("^[\\s\\S]* 220 degrees C!$");
    selenium.chooseOkAlert();
    selenium.verifyAlertMatch("^Store Below 429 degrees F!");
    selenium.chooseOkAlert();
    selenium.click("alertAndLeave");
    selenium.verifyAlert("I'm Melting! I'm Melting!");
    selenium.chooseOkAlert();
    selenium.waitForPageToLoad("30000");
    selenium.open("../tests/html/test_verify_alert.html");
    try {
      selenium.assertAlert("noAlert");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.click("oneAlert");
    try {
      selenium.assertAlert("wrongAlert");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.chooseOkAlert();
    selenium.click("twoAlerts");
    try {
      selenium.assertAlert("Store Below 429 degrees F!");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.chooseOkAlert();
    try {
      selenium.assertAlert("Store Below 220 degrees C!");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.chooseOkAlert();
    selenium.click("oneAlert");
    try {
      selenium.open("../tests/html/test_verify_alert.html");
      fail("expected failure");
    } catch (Throwable e) {
    }
    selenium.chooseOkAlert();
  }
}
