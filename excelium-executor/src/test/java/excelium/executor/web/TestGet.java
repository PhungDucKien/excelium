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

// TODO(simon): The verifications should not be commented out
public class TestGet extends WebExecutorTestBase {
  @Test
  public void testGet() throws Throwable {
    // test API getters
    selenium.open("../tests/html/test_get.html");
    // IE uppercases the property names of the style.
    // Firefox lowercases the property names of the style.
    // IE omits the trailing semi-colon.
    selenium.verifyAttributeMatch("//img[@alt='banner']", "style", "(width|WIDTH): 644px; (height|HEIGHT): 41px(;?)");
    // This asserts on the current behavior of selArrayToString(). Commas and
    // backslashes are escaped in array values. Backslash-craziness!!
    selenium.verifySelectOptionsMatch("selectWithFunkyValues",
        "^foo[\\s\\S]*$");
    // selenium.verifySelectOptionsMatch("selectWithFunkyValues",
    // "^javascript\\{ \\[ 'foo', '\\\\,\\\\\\\\\\\\\\\\bar\\\\\\\\\\\\\\\\\\\\,', '[\\s\\S]*baz[\\s\\S]*' \\]\\.join\\(','\\) \\}$");
    // selenium.verifySelectOptions("selectWithFunkyValues"), ','),
    // selenium.getEval(" 'regexp:' + [ 'foo', '\\\\\\,\\\\\\\\\\\\\\\\bar\\\\\\\\\\\\\\\\\\\\\\,', '\\\\u00a0{2}baz\\\\u00a0{2}' ].join(',') ");
  }
}
