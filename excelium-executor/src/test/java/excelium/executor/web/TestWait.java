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

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestWait extends WebExecutorTestBase {
  @Test
  public void testWait() throws Throwable {
    // Link click
    selenium.open("../tests/html/test_reload_onchange_page.html");
    selenium.click("theLink");
    selenium.waitForPageToLoad("30000");
    // Page should reload
    selenium.verifyTitle("Slow Loading Page");
    selenium.open("../tests/html/test_reload_onchange_page.html");
    selenium.select("theSelect", "Second Option");
    selenium.waitForPageToLoad("30000");
    // Page should reload
    selenium.verifyTitle("Slow Loading Page");
    // Textbox with onblur
    selenium.open("../tests/html/test_reload_onchange_page.html");
    selenium.type("theTextbox", "new value");
    selenium.fireEvent("theTextbox", "blur");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Slow Loading Page");
    // Submit button
    selenium.open("../tests/html/test_reload_onchange_page.html");
    selenium.click("theSubmit");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Slow Loading Page");
    selenium.click("slowPage_reload");
    selenium.waitForPageToLoad("30000");
    selenium.verifyTitle("Slow Loading Page");
  }

  @Test
  public void testPageLoadTimeout() throws Throwable {
    selenium.open("http://appium.io");
    selenium.setPageLoadTimeout("3000");
    try {
      selenium.open("../tests/appium/test/guinea-pig.html?delay=30000");
      Assert.fail("Should be rejected");
    } catch (Exception e) {
    }

    // the page should not have time to load
    selenium.assertHtmlSourceMatch("Appium: Mobile App Automation Made Awesome.");

    Date before = new Date();
    selenium.setTimeout("12000");
    selenium.setPageLoadTimeout("-1");
    selenium.open("../tests/appium/test/guinea-pig.html?delay=3000");
    Date now = new Date();

    // the page should load after 3000
    selenium.assertHtmlSourceMatch("I am some page content");
    Assert.assertTrue(now.getTime() - before.getTime() >= 3000);
    Assert.assertTrue(now.getTime() - before.getTime() < 12000);
  }
}
