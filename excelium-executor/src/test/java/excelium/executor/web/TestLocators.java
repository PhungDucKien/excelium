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

public class TestLocators extends WebExecutorTestBase {
  @Test
  public void testLocators() throws Throwable {
    selenium.open("../tests/html/test_locators.html");
    // Id location
    selenium.verifyText("id=id1", "this is the first element");
    selenium.verifyElementNotPresent("id=name1");
    selenium.verifyElementNotPresent("id=id4");
    selenium.verifyAttribute("id=id1", "class", "a1");
    // name location
    selenium.verifyText("name=name1", "this is the second element");
    selenium.verifyElementNotPresent("name=id1");
    selenium.verifyElementNotPresent("name=notAName");
    selenium.verifyAttribute("name=name1", "class", "a2");
    // class location
    selenium.verifyText("class=a3", "this is the third element");
    // alt location
    selenium.verifyElementPresent("alt=banner");
    // identifier location
    selenium.verifyText("identifier=id1", "this is the first element");
    selenium.verifyElementNotPresent("identifier=id4");
    selenium.verifyAttribute("identifier=id1", "class", "a1");
    selenium.verifyText("identifier=name1", "this is the second element");
    selenium.verifyAttribute("identifier=name1", "class", "a2");
    // DOM Traversal location
    selenium.verifyText("dom=document.links[1]", "this is the second element");
    selenium.verifyText("dom=function foo() {return document.links[1];}; foo();",
        "this is the second element");
    selenium.verifyText("dom=function foo() {\nreturn document.links[1];};\nfoo();",
        "this is the second element");
    selenium.verifyAttribute("dom=document.links[1]", "class", "a2");
    selenium.verifyElementNotPresent("dom=document.links[9]");
    selenium.verifyElementNotPresent("dom=foo");
    // Link location
    selenium.verifyElementPresent("link=this is the second element");
    selenium.assertTextPresent("this is the second element");
//    selenium.verifyElementPresent("link=this * second element");
//    selenium.verifyElementPresent("link=regexp:this [aeiou]s the second element");
    selenium.verifyAttribute("link=this is the second element", "class", "a2");
    selenium.verifyElementNotPresent("link=this is not an element");
    // SEL-484: IE: Can't select element by ID when there's another earlier element whose "name"
    // matches the ID
    selenium.verifyElementPresent("name=foobar");
    selenium.verifyElementPresent("id=foobar");
    // SEL-608:
    // "ID selector does not work when an element on the page has a name parameter equal to id"
    selenium.verifyElementPresent("id=myForm");
  }
}
