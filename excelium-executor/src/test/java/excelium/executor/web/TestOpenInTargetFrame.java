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

public class TestOpenInTargetFrame extends WebExecutorTestBase {
  @Test
  public void testOpenInTargetFrame() throws Throwable {
    selenium.open("../tests/html/test_open_in_target_frame.html");
    selenium.selectFrame("rightFrame");
    selenium.click("link=Show new frame in leftFrame");
    // we are forced to do a pause instead of clickandwait here,
    // for currently we can not detect target frame loading in ie yet
    Thread.sleep(1500);
    selenium.verifyTextPresent("Show new frame in leftFrame");
    selenium.selectFrame("relative=top");
    selenium.selectFrame("leftFrame");
    selenium.verifyTextPresent("content loaded");
    selenium.verifyTextNotPresent("This is frame LEFT");
  }
}
