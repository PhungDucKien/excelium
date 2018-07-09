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

import excelium.executor.web.env.GlobalWebEnvironment;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBasicAuth extends WebExecutorTestBase {
  @Test
  public void testBasicAuth() throws Throwable {
    selenium.open(getUrl());
    selenium.assertTitle("Welcome");
  }

  private String getUrl() throws MalformedURLException {
    URL url = new URL(GlobalWebEnvironment.get().getServerUrl() + "/tests/html/basicAuth/index.html");

    return String.format("%s://alice:foo@%s:%d%s",
        url.getProtocol(), url.getHost(), url.getPort(), url.getFile());
  }
}
