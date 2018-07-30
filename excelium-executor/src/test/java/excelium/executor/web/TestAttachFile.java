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
import com.thoughtworks.selenium.SeleniumException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestAttachFile extends WebExecutorTestBase {

  private static final String LOREM_IPSUM_TEXT = "lorem ipsum dolor sit amet";
  private static final String FILE_HTML = "<div>" + LOREM_IPSUM_TEXT + "</div>";

  private File testFile;

  @Before
  public void setUp() throws Exception {
    testFile = createTmpFile(FILE_HTML);
  }

  private File createTmpFile(String content) throws IOException {
    File f = File.createTempFile("webdriver", "tmp");
    f.deleteOnExit();
    Files.write(content, f, StandardCharsets.UTF_8);
    return f;
  }

  @Test
  public void testAttachFile() throws Throwable {
    selenium.open("/tests/html/upload.html");
    selenium.attachFile("upload", testFile.toURI().toURL().toString());
    selenium.click("go");
    selenium.waitForPageToLoad("30000");
    selenium.selectFrame("upload_target");
    selenium.assertText("//body", LOREM_IPSUM_TEXT);
  }

  @Test
  public void testAttachNonExistingFile() throws Throwable {
    selenium.open("/tests/html/upload.html");
    try {
      selenium.attachFile("upload", testFile.toURI().toURL().toString() + "-missing");
    } catch (SeleniumException expected) {
      assertTrue(expected.getCause() instanceof IOException);
      return;
    }
    fail("Exception expected");
  }
}
