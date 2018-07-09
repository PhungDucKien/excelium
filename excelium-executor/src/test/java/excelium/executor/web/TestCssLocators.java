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

public class TestCssLocators extends WebExecutorTestBase {
  @Test
  public void testCssLocators() throws Throwable {

    // Unimplemented features:
    // namespace
    // pseudo element
    // ::first-line
    // ::first-letter
    // ::selection
    // ::before
    // ::after
    // pseudo class including:
    // :nth-of-type
    // :nth-last-of-type
    // :first-of-type
    // :last-of-type
    // :only-of-type
    // :visited
    // :hover
    // :active
    // :focus
    // :indeterminate
    //

    selenium.open("../tests/html/test_locators.html");

    boolean isIe = webDriver.isIE();

    // css2 selector test

    // universal selector

    selenium.verifyElementPresent("css=*");

    // only element type

    selenium.verifyText("css=p", "this is the first element in the document");

    selenium.verifyText("css=a", "this is the first element");

    // id selector

    selenium.verifyText("css=a#id3", "this is the third element");

    // attribute selector

    selenium.verifyElementPresent("css=input[name]");

    selenium.verifyText("css=a[href=\"#id3\"]", "this is the third element");

    selenium.verifyElementNotPresent("css=span[selenium:foo]");

    selenium.verifyText("css=a[class~=\"class2\"]", "this is the fifth element");

    selenium.verifyText("css=a[lang|=\"en\"]", "this is the sixth element");

    // class selector

    selenium.verifyElementPresent("css=a.a1");

    // pseudo class selector

    selenium.verifyText("css=th:first-child", "theHeaderText");

    // descendant combinator

    selenium.verifyText("css=div#combinatorTest a", "and grandson");

    // child combinator

    selenium.verifyText("css=div#combinatorTest > span", "this is a child and grandson");

    // preceding combinator

    selenium.verifyText("css=span#firstChild + span", "another child");

    // css3 selector test

    // attribuite test

    selenium.verifyText("css=a[name^=\"foo\"]", "foobar");

    selenium.verifyText("css=a[name$=\"foo\"]", "barfoo");

    selenium.verifyText("css=a[name*=\"zoo\"]", "foozoobar");

    selenium.verifyText("css=a[name*=\"name\"][alt]", "this is the second element");

    // pseudo class test

    selenium.verifyText("css=div#structuralPseudo :nth-child(2n)", "span2");

    selenium.verifyText("css=div#structuralPseudo :nth-child(2)", "span2");

    selenium.verifyText("css=div#structuralPseudo :nth-child(-n+6)", "span1");

    selenium.verifyText("css=div#onlyChild span:only-child", "only child");

    selenium.verifyElementPresent("css=span:empty");

    // TODO(simon): Re-enable this.
    // selenium.verifyText("css=div#targetTest span:target", "target");

    selenium.verifyElementPresent("css=input[type=\"text\"]:enabled");

    selenium.verifyElementPresent("css=input[type=\"text\"]:disabled");

    selenium.verifyElementPresent("css=input[type=\"checkbox\"]:checked");

    selenium.verifyText("css=a:contains(\"zoo\")", "foozoobar");

    selenium.verifyText("css=div#structuralPseudo span:not(:first-child)", "span2");

    // combinator test

    selenium.verifyText("css=div#combinatorTest span#firstChild ~ span", "another child");

    if (!isIe) {
      selenium.verifyText("css=div#structuralPseudo :first-child", "span1");

      selenium.verifyText("css=div#structuralPseudo :last-child", "div4");

      selenium.verifyText("css=div#structuralPseudo :not(span):not(:last-child)", "div1");
    }

    if (!isIe) {
      // Versions of firefox prior to 3.5 don't propogate the lang property.
      selenium.verifyText("css=a:lang(en)", "this is the first element");

      selenium.verifyText("css=#linkPseudoTest :link", "link pseudo test");

      selenium.verifyElementPresent("css=html:root");

      selenium.verifyText("css=div#structuralPseudo :nth-last-child(4n+1)", "span4");

      selenium.verifyText("css=div#structuralPseudo :nth-last-child(2)", "div3");

      selenium.verifyText("css=div#structuralPseudo :nth-last-child(-n+6)", "span3");
    }
  }
}
