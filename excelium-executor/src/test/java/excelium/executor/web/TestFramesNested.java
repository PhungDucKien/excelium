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

public class TestFramesNested extends WebExecutorTestBase {
  @Test
  public void testFramesNested() throws Throwable {
    selenium.open("../tests/html/NestedFrames.html");
    selenium.verifyTitle("NestedFrames");
    selenium.verifyTextNotPresent("This is a test");
    selenium.selectFrame("mainFrame");
    selenium.verifyTitle("NestedFrames2");
    selenium.selectFrame("mainFrame");
    selenium.verifyTitle("AUT");
    selenium.selectFrame("mainFrame");
    selenium.verifyLocationMatch("^[\\s\\S]*/tests/html/test_open\\.html$");
    selenium.verifyTextPresent("This is a test");
    selenium.selectFrame("relative=up");
    selenium.verifyTitle("AUT");
    selenium.verifyTextNotPresent("This is a test");
    selenium.selectFrame("relative=top");
    selenium.verifyTitle("NestedFrames");
//    selenium.selectFrame("dom=window.frames[1]");
    selenium.selectFrame("index=1");
    selenium.verifyTitle("NestedFrames2");
    selenium.selectFrame("relative=top");
    selenium.verifyTitle("NestedFrames");
    selenium.selectFrame("index=1");
    selenium.verifyTitle("NestedFrames2");
    selenium.selectFrame("relative=top");
    selenium.verifyTitle("NestedFrames");
    selenium.selectFrame("foo");
    selenium.verifyTitle("NestedFrames2");
    selenium.selectFrame("relative=top");
    selenium.verifyTitle("NestedFrames");
//    selenium.selectFrame("dom=window.frames[\"mainFrame\"].frames[\"mainFrame\"]");
    selenium.selectFrame("mainFrame");
    selenium.selectFrame("mainFrame");
    selenium.verifyTitle("AUT");
  }
}
