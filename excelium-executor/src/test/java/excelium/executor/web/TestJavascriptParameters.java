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

public class TestJavascriptParameters extends WebExecutorTestBase {
  @Test
  public void testJavascriptParameters() throws Throwable {
//    selenium.open("../tests/html/test_store_value.html");
//    selenium.type("theText", "exp{[1,2,3,4,5].join(':')}");
//    selenium.verifyValue("theText", "1:2:3:4:5");
//    selenium.type("exp{'the' + 'Text'}", "exp{10 * 5}");
//    selenium.verifyValue("theText", "50");
//    selenium.verifyValue("theText", "exp{10 + 10 + 10 + 10 + 10}");
//    // Check a complex expression
//    selenium.type("theText", "exp{\n function square(n) {\n return n * n;\n };\n '25 * 25 = ' + square(25);\n }");
//    selenium.verifyValueMatch("theText", "^25 [\\s\\S]* 25 = 625$");
//    // Demonstrate interation between variable substitution and javascript
//    selenium.store("the value", "var1");
//    selenium.type("theText", "exp{'${var1}'.toUpperCase()}");
//    selenium.verifyValue("theText", "${VAR1}");
//    selenium.type("theText", "exp{'" + var1 + "'.toUpperCase()}");
//    selenium.verifyValue("theText", "THE VALUE");
//    selenium.verifyExpression(selenium.getEval("'" + var1 + "'.toUpperCase()")),
//        "THE VALUE");
//    selenium.verifyTrue(Pattern.compile("TH[Ee] VALUE")
//        .matcher(selenium.getExpression(selenium.getEval("selenium.getValue('theText')"))).find());
  }
}
