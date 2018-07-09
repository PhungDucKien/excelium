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

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class TestType extends WebExecutorTestBase {
  @Test
  public void testType() throws Throwable {
    selenium.open("../tests/html/test_type_page1.html");
    selenium.verifyValue("username", "");
    selenium.shiftKeyDown();
    selenium.type("username", "x");
    selenium.verifyValue("username", "X");
    selenium.shiftKeyUp();
    selenium.type("username", "TestUserWithLongName");
    selenium.verifyValue("username", "TestUserWi");
    selenium.type("username", "TestUser");
    selenium.verifyValue("username", "TestUser");
    selenium.verifyValue("password", "");
    selenium.type("password", "testUserPasswordIsVeryLong");
    selenium.verifyValue("password", "testUserPasswordIsVe");
    selenium.type("password", "testUserPassword");
    selenium.verifyValue("password", "testUserPassword");
    if (isAbleToUpdateFileElements()) {
      File tempFile = File.createTempFile("example", "upload");
      tempFile.deleteOnExit();
      Files.write("I like cheese", tempFile, StandardCharsets.UTF_8);
      selenium.type("file", tempFile.getAbsolutePath());
      selenium.click("submitButton");
      selenium.waitForPageToLoad("30000");
      selenium.verifyTextPresent("Welcome, TestUser!");
    }
  }

  private boolean isAbleToUpdateFileElements() {
    return !webDriver.isIE();
  }
}
