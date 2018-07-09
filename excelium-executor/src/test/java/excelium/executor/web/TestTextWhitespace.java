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

public class TestTextWhitespace extends WebExecutorTestBase {
  @Test
  public void testTextWhitespace() throws Throwable {
    selenium.open("../tests/html/test_text_content.html");
    selenium.verifyText("nonTextMarkup",
        "There is non-visible and visible markup here that doesn't change the text content");
    // Match exactly the same space characters
    selenium.verifyText("spaces",
        "1 space|2 space|3 space|1 nbsp|2  nbsp|3   nbsp|2  space_nbsp|2  nbsp_space|3   space_nbsp_space|3   nbsp_space_nbsp");
    selenium.verifyText("tabcharacter", "tab character between");
    selenium.verifyText("nonVisibleNewlines", "non visible newlines between");
    selenium.verifyTextMatch("visibleNewlines", "visible\\s*newlines\\s*between");
    selenium.verifyNotText("visibleNewlines", "visible newlines between");
    selenium.verifyTextMatch("paragraphs", "^First paragraph[\\s\\S]*Second paragraph$");
    selenium.verifyNotText("paragraphs", "First paragraph Second paragraph");
    selenium.verifyTextMatch("preformatted", "^preformatted[\\s\\S]*newline$");
    selenium.verifyNotText("preformatted", "preformatted newline");
    selenium.verifyTextMatch("mixedMarkup",
            "^visible[\\s\\S]*newlines and markup and non-visible newlines and markup[\\s\\S]*With[\\s\\S]*a paragraph[\\s\\S]*and[\\s\\S]*pre[\\s\\S]*formatted[\\s\\S]*text$");
    selenium.verifyText("empty", "");
  }
}
