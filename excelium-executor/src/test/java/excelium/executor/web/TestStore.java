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

public class TestStore extends WebExecutorTestBase {
  @Test
  public void testStore() throws Throwable {
    selenium.open("../tests/html/test_verifications.html");
    selenium.storeValue("theHidden", "storedHiddenValue");
    selenium.storeText("theSpan", "storedSpanText");
    selenium.storeAttribute("theText", "class", "storedTextClass");
    selenium.storeTitle("storedTitle");
    selenium.store("PLAIN TEXT", "textVariable");
    selenium.storeEvalScript("'Pi ~= ' +\n (Math.round(Math.PI * 100) / 100)", "javascriptVariable");
    selenium.open("../tests/html/test_store_value.html");
    selenium.type("theText", "${storedHiddenValue}");
    selenium.verifyValue("theText", "the hidden value");
    selenium.type("theText", "${storedSpanText}");
    selenium.verifyValue("theText", "this is the span");
    selenium.type("theText", "${storedTextClass}");
    selenium.verifyValue("theText", "foo");
    selenium.type("theText", "${textVariable}");
    selenium.verifyValue("theText", "PLAIN TEXT");
    selenium.type("theText", "${javascriptVariable}");
    selenium.verifyValue("theText", "Pi ~= 3.14");
    selenium.type("theText", "${storedTitle}");
    selenium.verifyValue("theText", "theTitle");
    // Test multiple output variables in a single expression
    selenium.type("theText", "'${storedHiddenValue}'_'${storedSpanText}'");
    selenium.verifyValue("theText", "'the hidden value'_'this is the span'");
    // backward compatibility
    selenium.open("../tests/html/test_just_text.html");
    selenium.storeBodyText("storedBodyText");
    selenium.open("../tests/html/test_store_value.html");
    selenium.verifyValue("theText", "");
    selenium.type("theText", "${storedBodyText}");
    selenium.verifyValue("theText", "This is the entire text of the page.");
    selenium.verifyExpression("${storedBodyText}", "This is the entire text of the page.");
  }
}
