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

package excelium.executor;

import excelium.core.Excelium;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;

import java.lang.reflect.InvocationTargetException;

public class WebExcelium extends Excelium {

    public WebExcelium(ContextAwareWebDriver webDriver, String baseUrl, Project project) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        super(webDriver, baseUrl, project);
    }

    public void addSelection(String locator, String optionLocator) throws Throwable {
        runCommand("addSelection", locator, optionLocator, null);
    }

    public void addSelection(String parentLocator, String locator, String optionLocator) throws Throwable {
        runCommand("addSelection", parentLocator, locator, optionLocator);
    }

    public void addSelectionId(String locator, String id) throws Throwable {
        runCommand("addSelectionId", locator, id, null);
    }

    public void addSelectionId(String parentLocator, String locator, String id) throws Throwable {
        runCommand("addSelectionId", parentLocator, locator, id);
    }

    public void addSelectionIndex(String locator, String index) throws Throwable {
        runCommand("addSelectionIndex", locator, index, null);
    }

    public void addSelectionIndex(String parentLocator, String locator, String index) throws Throwable {
        runCommand("addSelectionIndex", parentLocator, locator, index);
    }

    public void addSelectionLabel(String locator, String label) throws Throwable {
        runCommand("addSelectionLabel", locator, label, null);
    }

    public void addSelectionLabel(String parentLocator, String locator, String label) throws Throwable {
        runCommand("addSelectionLabel", parentLocator, locator, label);
    }

    public void addSelectionValue(String locator, String value) throws Throwable {
        runCommand("addSelectionValue", locator, value, null);
    }

    public void addSelectionValue(String parentLocator, String locator, String value) throws Throwable {
        runCommand("addSelectionValue", parentLocator, locator, value);
    }

    public void altKeyDown() throws Throwable {
        runCommand("altKeyDown", null, null, null);
    }

    public void altKeyUp() throws Throwable {
        runCommand("altKeyUp", null, null, null);
    }

    public void answerPrompt(String answer) throws Throwable {
        runCommand("answerPrompt", answer, null, null);
    }

    public void assertAlert(String text) throws Throwable {
        runCommand("assertAlert", text, null, null);
    }

    public void assertAlertContain(String text) throws Throwable {
        runCommand("assertAlertContain", text, null, null);
    }

    public void assertAlertNotContain(String text) throws Throwable {
        runCommand("assertAlertNotContain", text, null, null);
    }

    public void assertAlertNotPresent() throws Throwable {
        runCommand("assertAlertNotPresent", null, null, null);
    }

    public void assertAlertPresent() throws Throwable {
        runCommand("assertAlertPresent", null, null, null);
    }

    public void assertAttribute(String locator, String name, String text) throws Throwable {
        runCommand("assertAttribute", locator, name, text);
    }

    public void assertAttributeContain(String locator, String name, String text) throws Throwable {
        runCommand("assertAttributeContain", locator, name, text);
    }

    public void assertAttributeNotContain(String locator, String name, String text) throws Throwable {
        runCommand("assertAttributeNotContain", locator, name, text);
    }

    public void assertBackgroundColor(String locator, String text) throws Throwable {
        runCommand("assertBackgroundColor", locator, text, null);
    }

    public void assertBackgroundColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertBackgroundColor", parentLocator, locator, text);
    }

    public void assertBodyText(String text) throws Throwable {
        runCommand("assertBodyText", text, null, null);
    }

    public void assertBodyTextContain(String text) throws Throwable {
        runCommand("assertBodyTextContain", text, null, null);
    }

    public void assertBodyTextNotContain(String text) throws Throwable {
        runCommand("assertBodyTextNotContain", text, null, null);
    }

    public void assertBorderColor(String locator, String text) throws Throwable {
        runCommand("assertBorderColor", locator, text, null);
    }

    public void assertBorderColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertBorderColor", parentLocator, locator, text);
    }

    public void assertChecked(String locator) throws Throwable {
        runCommand("assertChecked", locator, null, null);
    }

    public void assertChecked(String parentLocator, String locator) throws Throwable {
        runCommand("assertChecked", parentLocator, locator, null);
    }

    public void assertColor(String locator, String text) throws Throwable {
        runCommand("assertColor", locator, text, null);
    }

    public void assertColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertColor", parentLocator, locator, text);
    }

    public void assertConfirmation(String text) throws Throwable {
        runCommand("assertConfirmation", text, null, null);
    }

    public void assertConfirmationContain(String text) throws Throwable {
        runCommand("assertConfirmationContain", text, null, null);
    }

    public void assertConfirmationNotContain(String text) throws Throwable {
        runCommand("assertConfirmationNotContain", text, null, null);
    }

    public void assertConfirmationNotPresent() throws Throwable {
        runCommand("assertConfirmationNotPresent", null, null, null);
    }

    public void assertConfirmationPresent() throws Throwable {
        runCommand("assertConfirmationPresent", null, null, null);
    }

    public void assertCookie(String text) throws Throwable {
        runCommand("assertCookie", text, null, null);
    }

    public void assertCookieByName(String name, String text) throws Throwable {
        runCommand("assertCookieByName", name, text, null);
    }

    public void assertCookieByNameContain(String name, String text) throws Throwable {
        runCommand("assertCookieByNameContain", name, text, null);
    }

    public void assertCookieByNameNotContain(String name, String text) throws Throwable {
        runCommand("assertCookieByNameNotContain", name, text, null);
    }

    public void assertCookieContain(String text) throws Throwable {
        runCommand("assertCookieContain", text, null, null);
    }

    public void assertCookieNotContain(String text) throws Throwable {
        runCommand("assertCookieNotContain", text, null, null);
    }

    public void assertCookieNotPresent(String name) throws Throwable {
        runCommand("assertCookieNotPresent", name, null, null);
    }

    public void assertCookiePresent(String name) throws Throwable {
        runCommand("assertCookiePresent", name, null, null);
    }

    public void assertCssCount(String css, String text) throws Throwable {
        runCommand("assertCssCount", css, text, null);
    }

    public void assertCursorPosition(String locator, String text) throws Throwable {
        runCommand("assertCursorPosition", locator, text, null);
    }

    public void assertCursorPosition(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertCursorPosition", parentLocator, locator, text);
    }

    public void assertDateListOrderAsc(String locator, String format) throws Throwable {
        runCommand("assertDateListOrderAsc", locator, format, null);
    }

    public void assertDateListOrderAsc(String parentLocator, String locator, String format) throws Throwable {
        runCommand("assertDateListOrderAsc", parentLocator, locator, format);
    }

    public void assertDateListOrderDesc(String locator, String format) throws Throwable {
        runCommand("assertDateListOrderDesc", locator, format, null);
    }

    public void assertDateListOrderDesc(String parentLocator, String locator, String format) throws Throwable {
        runCommand("assertDateListOrderDesc", parentLocator, locator, format);
    }

    public void assertEditable(String locator) throws Throwable {
        runCommand("assertEditable", locator, null, null);
    }

    public void assertEditable(String parentLocator, String locator) throws Throwable {
        runCommand("assertEditable", parentLocator, locator, null);
    }

    public void assertElementHeight(String locator, String text) throws Throwable {
        runCommand("assertElementHeight", locator, text, null);
    }

    public void assertElementHeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertElementHeight", parentLocator, locator, text);
    }

    public void assertElementIndex(String locator, String text) throws Throwable {
        runCommand("assertElementIndex", locator, text, null);
    }

    public void assertElementIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertElementIndex", parentLocator, locator, text);
    }

    public void assertElementNotPresent(String locator) throws Throwable {
        runCommand("assertElementNotPresent", locator, null, null);
    }

    public void assertElementNotPresent(String parentLocator, String locator) throws Throwable {
        runCommand("assertElementNotPresent", parentLocator, locator, null);
    }

    public void assertElementPositionLeft(String locator, String text) throws Throwable {
        runCommand("assertElementPositionLeft", locator, text, null);
    }

    public void assertElementPositionLeft(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertElementPositionLeft", parentLocator, locator, text);
    }

    public void assertElementPositionTop(String locator, String text) throws Throwable {
        runCommand("assertElementPositionTop", locator, text, null);
    }

    public void assertElementPositionTop(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertElementPositionTop", parentLocator, locator, text);
    }

    public void assertElementPresent(String locator) throws Throwable {
        runCommand("assertElementPresent", locator, null, null);
    }

    public void assertElementPresent(String parentLocator, String locator) throws Throwable {
        runCommand("assertElementPresent", parentLocator, locator, null);
    }

    public void assertElementWidth(String locator, String text) throws Throwable {
        runCommand("assertElementWidth", locator, text, null);
    }

    public void assertElementWidth(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertElementWidth", parentLocator, locator, text);
    }

    public void assertEval(String expression, String text) throws Throwable {
        runCommand("assertEval", expression, text, null);
    }

    public void assertEvalScript(String script, String text) throws Throwable {
        runCommand("assertEvalScript", script, text, null);
    }

    public void assertEvalScriptContain(String script, String text) throws Throwable {
        runCommand("assertEvalScriptContain", script, text, null);
    }

    public void assertEvalScriptNotContain(String script, String text) throws Throwable {
        runCommand("assertEvalScriptNotContain", script, text, null);
    }

    public void assertExistsInDatabase(String sql) throws Throwable {
        runCommand("assertExistsInDatabase", sql, null, null);
    }

    public void assertExpression(String expression, String text) throws Throwable {
        runCommand("assertExpression", expression, text, null);
    }

    public void assertExpressionContain(String expression, String text) throws Throwable {
        runCommand("assertExpressionContain", expression, text, null);
    }

    public void assertExpressionNotContain(String expression, String text) throws Throwable {
        runCommand("assertExpressionNotContain", expression, text, null);
    }

    public void assertFontFamily(String locator, String text) throws Throwable {
        runCommand("assertFontFamily", locator, text, null);
    }

    public void assertFontFamily(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontFamily", parentLocator, locator, text);
    }

    public void assertFontFamilyContain(String locator, String text) throws Throwable {
        runCommand("assertFontFamilyContain", locator, text, null);
    }

    public void assertFontFamilyContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontFamilyContain", parentLocator, locator, text);
    }

    public void assertFontFamilyNotContain(String locator, String text) throws Throwable {
        runCommand("assertFontFamilyNotContain", locator, text, null);
    }

    public void assertFontFamilyNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontFamilyNotContain", parentLocator, locator, text);
    }

    public void assertFontSize(String locator, String text) throws Throwable {
        runCommand("assertFontSize", locator, text, null);
    }

    public void assertFontSize(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontSize", parentLocator, locator, text);
    }

    public void assertFontSizeContain(String locator, String text) throws Throwable {
        runCommand("assertFontSizeContain", locator, text, null);
    }

    public void assertFontSizeContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontSizeContain", parentLocator, locator, text);
    }

    public void assertFontSizeNotContain(String locator, String text) throws Throwable {
        runCommand("assertFontSizeNotContain", locator, text, null);
    }

    public void assertFontSizeNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontSizeNotContain", parentLocator, locator, text);
    }

    public void assertFontStyle(String locator, String text) throws Throwable {
        runCommand("assertFontStyle", locator, text, null);
    }

    public void assertFontStyle(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontStyle", parentLocator, locator, text);
    }

    public void assertFontStyleContain(String locator, String text) throws Throwable {
        runCommand("assertFontStyleContain", locator, text, null);
    }

    public void assertFontStyleContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontStyleContain", parentLocator, locator, text);
    }

    public void assertFontStyleNotContain(String locator, String text) throws Throwable {
        runCommand("assertFontStyleNotContain", locator, text, null);
    }

    public void assertFontStyleNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontStyleNotContain", parentLocator, locator, text);
    }

    public void assertFontWeight(String locator, String text) throws Throwable {
        runCommand("assertFontWeight", locator, text, null);
    }

    public void assertFontWeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontWeight", parentLocator, locator, text);
    }

    public void assertFontWeightContain(String locator, String text) throws Throwable {
        runCommand("assertFontWeightContain", locator, text, null);
    }

    public void assertFontWeightContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontWeightContain", parentLocator, locator, text);
    }

    public void assertFontWeightNotContain(String locator, String text) throws Throwable {
        runCommand("assertFontWeightNotContain", locator, text, null);
    }

    public void assertFontWeightNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontWeightNotContain", parentLocator, locator, text);
    }

    public void assertHtmlSource(String text) throws Throwable {
        runCommand("assertHtmlSource", text, null, null);
    }

    public void assertHtmlSourceContain(String text) throws Throwable {
        runCommand("assertHtmlSourceContain", text, null, null);
    }

    public void assertHtmlSourceNotContain(String text) throws Throwable {
        runCommand("assertHtmlSourceNotContain", text, null, null);
    }

    public void assertIntegerListOrderAsc(String locator) throws Throwable {
        runCommand("assertIntegerListOrderAsc", locator, null, null);
    }

    public void assertIntegerListOrderAsc(String parentLocator, String locator) throws Throwable {
        runCommand("assertIntegerListOrderAsc", parentLocator, locator, null);
    }

    public void assertIntegerListOrderDesc(String locator) throws Throwable {
        runCommand("assertIntegerListOrderDesc", locator, null, null);
    }

    public void assertIntegerListOrderDesc(String parentLocator, String locator) throws Throwable {
        runCommand("assertIntegerListOrderDesc", parentLocator, locator, null);
    }

    public void assertListContain(String variable, String text) throws Throwable {
        runCommand("assertListContain", variable, text, null);
    }

    public void assertListNotContain(String variable, String text) throws Throwable {
        runCommand("assertListNotContain", variable, text, null);
    }

    public void assertListOrderAsc(String variable) throws Throwable {
        runCommand("assertListOrderAsc", variable, null, null);
    }

    public void assertListOrderDesc(String variable) throws Throwable {
        runCommand("assertListOrderDesc", variable, null, null);
    }

    public void assertLocation(String text) throws Throwable {
        runCommand("assertLocation", text, null, null);
    }

    public void assertLocationContain(String text) throws Throwable {
        runCommand("assertLocationContain", text, null, null);
    }

    public void assertLocationNotContain(String text) throws Throwable {
        runCommand("assertLocationNotContain", text, null, null);
    }

    public void assertNotAlert(String text) throws Throwable {
        runCommand("assertNotAlert", text, null, null);
    }

    public void assertNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("assertNotAttribute", locator, name, text);
    }

    public void assertNotBackgroundColor(String locator, String text) throws Throwable {
        runCommand("assertNotBackgroundColor", locator, text, null);
    }

    public void assertNotBackgroundColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotBackgroundColor", parentLocator, locator, text);
    }

    public void assertNotBodyText(String text) throws Throwable {
        runCommand("assertNotBodyText", text, null, null);
    }

    public void assertNotBorderColor(String locator, String text) throws Throwable {
        runCommand("assertNotBorderColor", locator, text, null);
    }

    public void assertNotBorderColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotBorderColor", parentLocator, locator, text);
    }

    public void assertNotChecked(String locator) throws Throwable {
        runCommand("assertNotChecked", locator, null, null);
    }

    public void assertNotChecked(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotChecked", parentLocator, locator, null);
    }

    public void assertNotColor(String locator, String text) throws Throwable {
        runCommand("assertNotColor", locator, text, null);
    }

    public void assertNotColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotColor", parentLocator, locator, text);
    }

    public void assertNotConfirmation(String text) throws Throwable {
        runCommand("assertNotConfirmation", text, null, null);
    }

    public void assertNotCookie(String text) throws Throwable {
        runCommand("assertNotCookie", text, null, null);
    }

    public void assertNotCookieByName(String name, String text) throws Throwable {
        runCommand("assertNotCookieByName", name, text, null);
    }

    public void assertNotCssCount(String css, String text) throws Throwable {
        runCommand("assertNotCssCount", css, text, null);
    }

    public void assertNotCursorPosition(String locator, String text) throws Throwable {
        runCommand("assertNotCursorPosition", locator, text, null);
    }

    public void assertNotCursorPosition(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotCursorPosition", parentLocator, locator, text);
    }

    public void assertNotEditable(String locator) throws Throwable {
        runCommand("assertNotEditable", locator, null, null);
    }

    public void assertNotEditable(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotEditable", parentLocator, locator, null);
    }

    public void assertNotElementHeight(String locator, String text) throws Throwable {
        runCommand("assertNotElementHeight", locator, text, null);
    }

    public void assertNotElementHeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotElementHeight", parentLocator, locator, text);
    }

    public void assertNotElementIndex(String locator, String text) throws Throwable {
        runCommand("assertNotElementIndex", locator, text, null);
    }

    public void assertNotElementIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotElementIndex", parentLocator, locator, text);
    }

    public void assertNotElementPositionLeft(String locator, String text) throws Throwable {
        runCommand("assertNotElementPositionLeft", locator, text, null);
    }

    public void assertNotElementPositionLeft(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotElementPositionLeft", parentLocator, locator, text);
    }

    public void assertNotElementPositionTop(String locator, String text) throws Throwable {
        runCommand("assertNotElementPositionTop", locator, text, null);
    }

    public void assertNotElementPositionTop(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotElementPositionTop", parentLocator, locator, text);
    }

    public void assertNotElementWidth(String locator, String text) throws Throwable {
        runCommand("assertNotElementWidth", locator, text, null);
    }

    public void assertNotElementWidth(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotElementWidth", parentLocator, locator, text);
    }

    public void assertNotEval(String expression, String text) throws Throwable {
        runCommand("assertNotEval", expression, text, null);
    }

    public void assertNotEvalScript(String script, String text) throws Throwable {
        runCommand("assertNotEvalScript", script, text, null);
    }

    public void assertNotExistsInDatabase(String sql) throws Throwable {
        runCommand("assertNotExistsInDatabase", sql, null, null);
    }

    public void assertNotExpression(String expression, String text) throws Throwable {
        runCommand("assertNotExpression", expression, text, null);
    }

    public void assertNotFontFamily(String locator, String text) throws Throwable {
        runCommand("assertNotFontFamily", locator, text, null);
    }

    public void assertNotFontFamily(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotFontFamily", parentLocator, locator, text);
    }

    public void assertNotFontSize(String locator, String text) throws Throwable {
        runCommand("assertNotFontSize", locator, text, null);
    }

    public void assertNotFontSize(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotFontSize", parentLocator, locator, text);
    }

    public void assertNotFontStyle(String locator, String text) throws Throwable {
        runCommand("assertNotFontStyle", locator, text, null);
    }

    public void assertNotFontStyle(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotFontStyle", parentLocator, locator, text);
    }

    public void assertNotFontWeight(String locator, String text) throws Throwable {
        runCommand("assertNotFontWeight", locator, text, null);
    }

    public void assertNotFontWeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotFontWeight", parentLocator, locator, text);
    }

    public void assertNotHtmlSource(String text) throws Throwable {
        runCommand("assertNotHtmlSource", text, null, null);
    }

    public void assertNotLocation(String text) throws Throwable {
        runCommand("assertNotLocation", text, null, null);
    }

    public void assertNotOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("assertNotOrdered", firstLocator, secondLocator, null);
    }

    public void assertNotPrompt(String text) throws Throwable {
        runCommand("assertNotPrompt", text, null, null);
    }

    public void assertNotSelectedId(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedId", locator, text, null);
    }

    public void assertNotSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedId", parentLocator, locator, text);
    }

    public void assertNotSelectedIndex(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIndex", locator, text, null);
    }

    public void assertNotSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIndex", parentLocator, locator, text);
    }

    public void assertNotSelectedLabel(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedLabel", locator, text, null);
    }

    public void assertNotSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedLabel", parentLocator, locator, text);
    }

    public void assertNotSelectedValue(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedValue", locator, text, null);
    }

    public void assertNotSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedValue", parentLocator, locator, text);
    }

    public void assertNotSomethingSelected(String locator) throws Throwable {
        runCommand("assertNotSomethingSelected", locator, null, null);
    }

    public void assertNotSomethingSelected(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotSomethingSelected", parentLocator, locator, null);
    }

    public void assertNotTable(String locator, String cellAddress, String text) throws Throwable {
        runCommand("assertNotTable", locator, cellAddress, text);
    }

    public void assertNotText(String locator, String text) throws Throwable {
        runCommand("assertNotText", locator, text, null);
    }

    public void assertNotText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotText", parentLocator, locator, text);
    }

    public void assertNotTextAlignment(String locator, String text) throws Throwable {
        runCommand("assertNotTextAlignment", locator, text, null);
    }

    public void assertNotTextAlignment(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotTextAlignment", parentLocator, locator, text);
    }

    public void assertNotTextDecoration(String locator, String text) throws Throwable {
        runCommand("assertNotTextDecoration", locator, text, null);
    }

    public void assertNotTextDecoration(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotTextDecoration", parentLocator, locator, text);
    }

    public void assertNotTextEmpty(String locator) throws Throwable {
        runCommand("assertNotTextEmpty", locator, null, null);
    }

    public void assertNotTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotTextEmpty", parentLocator, locator, null);
    }

    public void assertNotTitle(String text) throws Throwable {
        runCommand("assertNotTitle", text, null, null);
    }

    public void assertNotValue(String locator, String text) throws Throwable {
        runCommand("assertNotValue", locator, text, null);
    }

    public void assertNotValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotValue", parentLocator, locator, text);
    }

    public void assertNotValueEmpty(String locator) throws Throwable {
        runCommand("assertNotValueEmpty", locator, null, null);
    }

    public void assertNotValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotValueEmpty", parentLocator, locator, null);
    }

    public void assertNotVariable(String variable, String text) throws Throwable {
        runCommand("assertNotVariable", variable, text, null);
    }

    public void assertNotVisible(String locator) throws Throwable {
        runCommand("assertNotVisible", locator, null, null);
    }

    public void assertNotVisible(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotVisible", parentLocator, locator, null);
    }

    public void assertNotXpathCount(String xpath, String text) throws Throwable {
        runCommand("assertNotXpathCount", xpath, text, null);
    }

    public void assertOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("assertOrdered", firstLocator, secondLocator, null);
    }

    public void assertPrompt(String text) throws Throwable {
        runCommand("assertPrompt", text, null, null);
    }

    public void assertPromptContain(String text) throws Throwable {
        runCommand("assertPromptContain", text, null, null);
    }

    public void assertPromptNotContain(String text) throws Throwable {
        runCommand("assertPromptNotContain", text, null, null);
    }

    public void assertPromptNotPresent() throws Throwable {
        runCommand("assertPromptNotPresent", null, null, null);
    }

    public void assertPromptPresent() throws Throwable {
        runCommand("assertPromptPresent", null, null, null);
    }

    public void assertRowCount(String sql, String count) throws Throwable {
        runCommand("assertRowCount", sql, count, null);
    }

    public void assertRowCountGreaterThan(String sql, String count) throws Throwable {
        runCommand("assertRowCountGreaterThan", sql, count, null);
    }

    public void assertRowCountLessThan(String sql, String count) throws Throwable {
        runCommand("assertRowCountLessThan", sql, count, null);
    }

    public void assertSelectedId(String locator, String text) throws Throwable {
        runCommand("assertSelectedId", locator, text, null);
    }

    public void assertSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedId", parentLocator, locator, text);
    }

    public void assertSelectedIdContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedIdContain", locator, text, null);
    }

    public void assertSelectedIdContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIdContain", parentLocator, locator, text);
    }

    public void assertSelectedIdNotContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedIdNotContain", locator, text, null);
    }

    public void assertSelectedIdNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIdNotContain", parentLocator, locator, text);
    }

    public void assertSelectedIndex(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndex", locator, text, null);
    }

    public void assertSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndex", parentLocator, locator, text);
    }

    public void assertSelectedIndexContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexContain", locator, text, null);
    }

    public void assertSelectedIndexContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexContain", parentLocator, locator, text);
    }

    public void assertSelectedIndexNotContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexNotContain", locator, text, null);
    }

    public void assertSelectedIndexNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexNotContain", parentLocator, locator, text);
    }

    public void assertSelectedLabel(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabel", locator, text, null);
    }

    public void assertSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabel", parentLocator, locator, text);
    }

    public void assertSelectedLabelContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelContain", locator, text, null);
    }

    public void assertSelectedLabelContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelContain", parentLocator, locator, text);
    }

    public void assertSelectedLabelNotContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelNotContain", locator, text, null);
    }

    public void assertSelectedLabelNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelNotContain", parentLocator, locator, text);
    }

    public void assertSelectedValue(String locator, String text) throws Throwable {
        runCommand("assertSelectedValue", locator, text, null);
    }

    public void assertSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValue", parentLocator, locator, text);
    }

    public void assertSelectedValueContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedValueContain", locator, text, null);
    }

    public void assertSelectedValueContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValueContain", parentLocator, locator, text);
    }

    public void assertSelectedValueNotContain(String locator, String text) throws Throwable {
        runCommand("assertSelectedValueNotContain", locator, text, null);
    }

    public void assertSelectedValueNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValueNotContain", parentLocator, locator, text);
    }

    public void assertSomethingSelected(String locator) throws Throwable {
        runCommand("assertSomethingSelected", locator, null, null);
    }

    public void assertSomethingSelected(String parentLocator, String locator) throws Throwable {
        runCommand("assertSomethingSelected", parentLocator, locator, null);
    }

    public void assertTable(String locator, String cellAddress, String text) throws Throwable {
        runCommand("assertTable", locator, cellAddress, text);
    }

    public void assertTableContain(String locator, String cellAddress, String text) throws Throwable {
        runCommand("assertTableContain", locator, cellAddress, text);
    }

    public void assertTableNotContain(String locator, String cellAddress, String text) throws Throwable {
        runCommand("assertTableNotContain", locator, cellAddress, text);
    }

    public void assertText(String locator, String text) throws Throwable {
        runCommand("assertText", locator, text, null);
    }

    public void assertText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertText", parentLocator, locator, text);
    }

    public void assertTextAlignment(String locator, String text) throws Throwable {
        runCommand("assertTextAlignment", locator, text, null);
    }

    public void assertTextAlignment(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextAlignment", parentLocator, locator, text);
    }

    public void assertTextAlignmentContain(String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentContain", locator, text, null);
    }

    public void assertTextAlignmentContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentContain", parentLocator, locator, text);
    }

    public void assertTextAlignmentNotContain(String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentNotContain", locator, text, null);
    }

    public void assertTextAlignmentNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentNotContain", parentLocator, locator, text);
    }

    public void assertTextContain(String locator, String text) throws Throwable {
        runCommand("assertTextContain", locator, text, null);
    }

    public void assertTextContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextContain", parentLocator, locator, text);
    }

    public void assertTextDecoration(String locator, String text) throws Throwable {
        runCommand("assertTextDecoration", locator, text, null);
    }

    public void assertTextDecoration(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextDecoration", parentLocator, locator, text);
    }

    public void assertTextDecorationContain(String locator, String text) throws Throwable {
        runCommand("assertTextDecorationContain", locator, text, null);
    }

    public void assertTextDecorationContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextDecorationContain", parentLocator, locator, text);
    }

    public void assertTextDecorationNotContain(String locator, String text) throws Throwable {
        runCommand("assertTextDecorationNotContain", locator, text, null);
    }

    public void assertTextDecorationNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextDecorationNotContain", parentLocator, locator, text);
    }

    public void assertTextEmpty(String locator) throws Throwable {
        runCommand("assertTextEmpty", locator, null, null);
    }

    public void assertTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("assertTextEmpty", parentLocator, locator, null);
    }

    public void assertTextListOrderAsc(String locator) throws Throwable {
        runCommand("assertTextListOrderAsc", locator, null, null);
    }

    public void assertTextListOrderAsc(String parentLocator, String locator) throws Throwable {
        runCommand("assertTextListOrderAsc", parentLocator, locator, null);
    }

    public void assertTextListOrderDesc(String locator) throws Throwable {
        runCommand("assertTextListOrderDesc", locator, null, null);
    }

    public void assertTextListOrderDesc(String parentLocator, String locator) throws Throwable {
        runCommand("assertTextListOrderDesc", parentLocator, locator, null);
    }

    public void assertTextNotContain(String locator, String text) throws Throwable {
        runCommand("assertTextNotContain", locator, text, null);
    }

    public void assertTextNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextNotContain", parentLocator, locator, text);
    }

    public void assertTextNotPresent(String pattern) throws Throwable {
        runCommand("assertTextNotPresent", pattern, null, null);
    }

    public void assertTextPresent(String pattern) throws Throwable {
        runCommand("assertTextPresent", pattern, null, null);
    }

    public void assertTitle(String text) throws Throwable {
        runCommand("assertTitle", text, null, null);
    }

    public void assertTitleContain(String text) throws Throwable {
        runCommand("assertTitleContain", text, null, null);
    }

    public void assertTitleNotContain(String text) throws Throwable {
        runCommand("assertTitleNotContain", text, null, null);
    }

    public void assertValue(String locator, String text) throws Throwable {
        runCommand("assertValue", locator, text, null);
    }

    public void assertValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertValue", parentLocator, locator, text);
    }

    public void assertValueContain(String locator, String text) throws Throwable {
        runCommand("assertValueContain", locator, text, null);
    }

    public void assertValueContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertValueContain", parentLocator, locator, text);
    }

    public void assertValueEmpty(String locator) throws Throwable {
        runCommand("assertValueEmpty", locator, null, null);
    }

    public void assertValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("assertValueEmpty", parentLocator, locator, null);
    }

    public void assertValueNotContain(String locator, String text) throws Throwable {
        runCommand("assertValueNotContain", locator, text, null);
    }

    public void assertValueNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertValueNotContain", parentLocator, locator, text);
    }

    public void assertVariable(String variable, String text) throws Throwable {
        runCommand("assertVariable", variable, text, null);
    }

    public void assertVariableContain(String variable, String text) throws Throwable {
        runCommand("assertVariableContain", variable, text, null);
    }

    public void assertVariableNotContain(String variable, String text) throws Throwable {
        runCommand("assertVariableNotContain", variable, text, null);
    }

    public void assertVisible(String locator) throws Throwable {
        runCommand("assertVisible", locator, null, null);
    }

    public void assertVisible(String parentLocator, String locator) throws Throwable {
        runCommand("assertVisible", parentLocator, locator, null);
    }

    public void assertXpathCount(String xpath, String text) throws Throwable {
        runCommand("assertXpathCount", xpath, text, null);
    }

    public void assignId(String locator, String identifier) throws Throwable {
        runCommand("assignId", locator, identifier, null);
    }

    public void assignId(String parentLocator, String locator, String identifier) throws Throwable {
        runCommand("assignId", parentLocator, locator, identifier);
    }

    public void blur(String locator) throws Throwable {
        runCommand("blur", locator, null, null);
    }

    public void blur(String parentLocator, String locator) throws Throwable {
        runCommand("blur", parentLocator, locator, null);
    }

    public void check(String locator) throws Throwable {
        runCommand("check", locator, null, null);
    }

    public void check(String parentLocator, String locator) throws Throwable {
        runCommand("check", parentLocator, locator, null);
    }

    public void chooseCancelConfirmation() throws Throwable {
        runCommand("chooseCancelConfirmation", null, null, null);
    }

    public void chooseCancelPrompt() throws Throwable {
        runCommand("chooseCancelPrompt", null, null, null);
    }

    public void chooseOkAlert() throws Throwable {
        runCommand("chooseOkAlert", null, null, null);
    }

    public void chooseOkConfirmation() throws Throwable {
        runCommand("chooseOkConfirmation", null, null, null);
    }

    public void clear(String locator) throws Throwable {
        runCommand("clear", locator, null, null);
    }

    public void clear(String parentLocator, String locator) throws Throwable {
        runCommand("clear", parentLocator, locator, null);
    }

    public void click(String locator) throws Throwable {
        runCommand("click", locator, null, null);
    }

    public void click(String parentLocator, String locator) throws Throwable {
        runCommand("click", parentLocator, locator, null);
    }

    public void clickAt(String locator, String coordString) throws Throwable {
        runCommand("clickAt", locator, coordString, null);
    }

    public void clickAt(String parentLocator, String locator, String coordString) throws Throwable {
        runCommand("clickAt", parentLocator, locator, coordString);
    }

    public void close() throws Throwable {
        runCommand("close", null, null, null);
    }

    public void contextMenu(String locator) throws Throwable {
        runCommand("contextMenu", locator, null, null);
    }

    public void contextMenu(String parentLocator, String locator) throws Throwable {
        runCommand("contextMenu", parentLocator, locator, null);
    }

    public void contextMenuAt(String locator, String coordString) throws Throwable {
        runCommand("contextMenuAt", locator, coordString, null);
    }

    public void contextMenuAt(String parentLocator, String locator, String coordString) throws Throwable {
        runCommand("contextMenuAt", parentLocator, locator, coordString);
    }

    public void controlKeyDown() throws Throwable {
        runCommand("controlKeyDown", null, null, null);
    }

    public void controlKeyUp() throws Throwable {
        runCommand("controlKeyUp", null, null, null);
    }

    public void createCookie(String nameValuePair, String optionsString) throws Throwable {
        runCommand("createCookie", nameValuePair, optionsString, null);
    }

    public void deleteAllVisibleCookies() throws Throwable {
        runCommand("deleteAllVisibleCookies", null, null, null);
    }

    public void deleteCookie(String name) throws Throwable {
        runCommand("deleteCookie", name, null, null);
    }

    public void deselectPopUp() throws Throwable {
        runCommand("deselectPopUp", null, null, null);
    }

    public void doubleClick(String locator) throws Throwable {
        runCommand("doubleClick", locator, null, null);
    }

    public void doubleClick(String parentLocator, String locator) throws Throwable {
        runCommand("doubleClick", parentLocator, locator, null);
    }

    public void doubleClickAt(String locator, String coordString) throws Throwable {
        runCommand("doubleClickAt", locator, coordString, null);
    }

    public void doubleClickAt(String parentLocator, String locator, String coordString) throws Throwable {
        runCommand("doubleClickAt", parentLocator, locator, coordString);
    }

    public void dragAndDrop(String locator, String movementsString) throws Throwable {
        runCommand("dragAndDrop", locator, movementsString, null);
    }

    public void dragAndDrop(String parentLocator, String locator, String movementsString) throws Throwable {
        runCommand("dragAndDrop", parentLocator, locator, movementsString);
    }

    public void dragAndDropToObject(String toBeDraggedObjectLocator, String dragDestinationObjectLocator) throws Throwable {
        runCommand("dragAndDropToObject", toBeDraggedObjectLocator, dragDestinationObjectLocator, null);
    }

    public void echo(String message) throws Throwable {
        runCommand("echo", message, null, null);
    }

    public void execute(String action) throws Throwable {
        runCommand("execute", action, null, null);
    }

    public void executeEach(String action, String locator, String variable) throws Throwable {
        runCommand("executeEach", action, locator, variable);
    }

    public void executeIfAlert(String action, String text) throws Throwable {
        runCommand("executeIfAlert", action, text, null);
    }

    public void executeIfAlertContain(String action, String text) throws Throwable {
        runCommand("executeIfAlertContain", action, text, null);
    }

    public void executeIfAlertNotContain(String action, String text) throws Throwable {
        runCommand("executeIfAlertNotContain", action, text, null);
    }

    public void executeIfAlertNotPresent(String action) throws Throwable {
        runCommand("executeIfAlertNotPresent", action, null, null);
    }

    public void executeIfAlertPresent(String action) throws Throwable {
        runCommand("executeIfAlertPresent", action, null, null);
    }

    public void executeIfBodyText(String action, String text) throws Throwable {
        runCommand("executeIfBodyText", action, text, null);
    }

    public void executeIfBodyTextContain(String action, String text) throws Throwable {
        runCommand("executeIfBodyTextContain", action, text, null);
    }

    public void executeIfBodyTextNotContain(String action, String text) throws Throwable {
        runCommand("executeIfBodyTextNotContain", action, text, null);
    }

    public void executeIfChecked(String action, String locator) throws Throwable {
        runCommand("executeIfChecked", action, locator, null);
    }

    public void executeIfChecked(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfChecked", action, parentLocator, locator);
    }

    public void executeIfConfirmation(String action, String text) throws Throwable {
        runCommand("executeIfConfirmation", action, text, null);
    }

    public void executeIfConfirmationContain(String action, String text) throws Throwable {
        runCommand("executeIfConfirmationContain", action, text, null);
    }

    public void executeIfConfirmationNotContain(String action, String text) throws Throwable {
        runCommand("executeIfConfirmationNotContain", action, text, null);
    }

    public void executeIfConfirmationNotPresent(String action) throws Throwable {
        runCommand("executeIfConfirmationNotPresent", action, null, null);
    }

    public void executeIfConfirmationPresent(String action) throws Throwable {
        runCommand("executeIfConfirmationPresent", action, null, null);
    }

    public void executeIfCookie(String action, String text) throws Throwable {
        runCommand("executeIfCookie", action, text, null);
    }

    public void executeIfCookieByName(String action, String name, String text) throws Throwable {
        runCommand("executeIfCookieByName", action, name, text);
    }

    public void executeIfCookieByNameContain(String action, String name, String text) throws Throwable {
        runCommand("executeIfCookieByNameContain", action, name, text);
    }

    public void executeIfCookieByNameNotContain(String action, String name, String text) throws Throwable {
        runCommand("executeIfCookieByNameNotContain", action, name, text);
    }

    public void executeIfCookieContain(String action, String text) throws Throwable {
        runCommand("executeIfCookieContain", action, text, null);
    }

    public void executeIfCookieNotContain(String action, String text) throws Throwable {
        runCommand("executeIfCookieNotContain", action, text, null);
    }

    public void executeIfCookieNotPresent(String action, String name) throws Throwable {
        runCommand("executeIfCookieNotPresent", action, name, null);
    }

    public void executeIfCookiePresent(String action, String name) throws Throwable {
        runCommand("executeIfCookiePresent", action, name, null);
    }

    public void executeIfEditable(String action, String locator) throws Throwable {
        runCommand("executeIfEditable", action, locator, null);
    }

    public void executeIfEditable(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfEditable", action, parentLocator, locator);
    }

    public void executeIfElementNotPresent(String action, String locator) throws Throwable {
        runCommand("executeIfElementNotPresent", action, locator, null);
    }

    public void executeIfElementNotPresent(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfElementNotPresent", action, parentLocator, locator);
    }

    public void executeIfElementPresent(String action, String locator) throws Throwable {
        runCommand("executeIfElementPresent", action, locator, null);
    }

    public void executeIfElementPresent(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfElementPresent", action, parentLocator, locator);
    }

    public void executeIfEval(String action, String expression, String text) throws Throwable {
        runCommand("executeIfEval", action, expression, text);
    }

    public void executeIfEvalScript(String action, String script, String text) throws Throwable {
        runCommand("executeIfEvalScript", action, script, text);
    }

    public void executeIfEvalScriptContain(String action, String script, String text) throws Throwable {
        runCommand("executeIfEvalScriptContain", action, script, text);
    }

    public void executeIfEvalScriptNotContain(String action, String script, String text) throws Throwable {
        runCommand("executeIfEvalScriptNotContain", action, script, text);
    }

    public void executeIfExistsInDatabase(String action, String sql) throws Throwable {
        runCommand("executeIfExistsInDatabase", action, sql, null);
    }

    public void executeIfExpression(String action, String expression, String text) throws Throwable {
        runCommand("executeIfExpression", action, expression, text);
    }

    public void executeIfExpressionContain(String action, String expression, String text) throws Throwable {
        runCommand("executeIfExpressionContain", action, expression, text);
    }

    public void executeIfExpressionNotContain(String action, String expression, String text) throws Throwable {
        runCommand("executeIfExpressionNotContain", action, expression, text);
    }

    public void executeIfHtmlSource(String action, String text) throws Throwable {
        runCommand("executeIfHtmlSource", action, text, null);
    }

    public void executeIfHtmlSourceContain(String action, String text) throws Throwable {
        runCommand("executeIfHtmlSourceContain", action, text, null);
    }

    public void executeIfHtmlSourceNotContain(String action, String text) throws Throwable {
        runCommand("executeIfHtmlSourceNotContain", action, text, null);
    }

    public void executeIfListContain(String action, String variable, String text) throws Throwable {
        runCommand("executeIfListContain", action, variable, text);
    }

    public void executeIfListNotContain(String action, String variable, String text) throws Throwable {
        runCommand("executeIfListNotContain", action, variable, text);
    }

    public void executeIfLocation(String action, String text) throws Throwable {
        runCommand("executeIfLocation", action, text, null);
    }

    public void executeIfLocationContain(String action, String text) throws Throwable {
        runCommand("executeIfLocationContain", action, text, null);
    }

    public void executeIfLocationNotContain(String action, String text) throws Throwable {
        runCommand("executeIfLocationNotContain", action, text, null);
    }

    public void executeIfNotAlert(String action, String text) throws Throwable {
        runCommand("executeIfNotAlert", action, text, null);
    }

    public void executeIfNotBodyText(String action, String text) throws Throwable {
        runCommand("executeIfNotBodyText", action, text, null);
    }

    public void executeIfNotChecked(String action, String locator) throws Throwable {
        runCommand("executeIfNotChecked", action, locator, null);
    }

    public void executeIfNotChecked(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotChecked", action, parentLocator, locator);
    }

    public void executeIfNotConfirmation(String action, String text) throws Throwable {
        runCommand("executeIfNotConfirmation", action, text, null);
    }

    public void executeIfNotCookie(String action, String text) throws Throwable {
        runCommand("executeIfNotCookie", action, text, null);
    }

    public void executeIfNotCookieByName(String action, String name, String text) throws Throwable {
        runCommand("executeIfNotCookieByName", action, name, text);
    }

    public void executeIfNotEditable(String action, String locator) throws Throwable {
        runCommand("executeIfNotEditable", action, locator, null);
    }

    public void executeIfNotEditable(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotEditable", action, parentLocator, locator);
    }

    public void executeIfNotEval(String action, String expression, String text) throws Throwable {
        runCommand("executeIfNotEval", action, expression, text);
    }

    public void executeIfNotEvalScript(String action, String script, String text) throws Throwable {
        runCommand("executeIfNotEvalScript", action, script, text);
    }

    public void executeIfNotExistsInDatabase(String action, String sql) throws Throwable {
        runCommand("executeIfNotExistsInDatabase", action, sql, null);
    }

    public void executeIfNotExpression(String action, String expression, String text) throws Throwable {
        runCommand("executeIfNotExpression", action, expression, text);
    }

    public void executeIfNotHtmlSource(String action, String text) throws Throwable {
        runCommand("executeIfNotHtmlSource", action, text, null);
    }

    public void executeIfNotLocation(String action, String text) throws Throwable {
        runCommand("executeIfNotLocation", action, text, null);
    }

    public void executeIfNotPrompt(String action, String text) throws Throwable {
        runCommand("executeIfNotPrompt", action, text, null);
    }

    public void executeIfNotSelectedId(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotSelectedId", action, locator, text);
    }

    public void executeIfNotSelectedIndex(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotSelectedIndex", action, locator, text);
    }

    public void executeIfNotSelectedLabel(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotSelectedLabel", action, locator, text);
    }

    public void executeIfNotSelectedValue(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotSelectedValue", action, locator, text);
    }

    public void executeIfNotSomethingSelected(String action, String locator) throws Throwable {
        runCommand("executeIfNotSomethingSelected", action, locator, null);
    }

    public void executeIfNotSomethingSelected(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotSomethingSelected", action, parentLocator, locator);
    }

    public void executeIfNotText(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotText", action, locator, text);
    }

    public void executeIfNotTextEmpty(String action, String locator) throws Throwable {
        runCommand("executeIfNotTextEmpty", action, locator, null);
    }

    public void executeIfNotTextEmpty(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotTextEmpty", action, parentLocator, locator);
    }

    public void executeIfNotTitle(String action, String text) throws Throwable {
        runCommand("executeIfNotTitle", action, text, null);
    }

    public void executeIfNotValue(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotValue", action, locator, text);
    }

    public void executeIfNotValueEmpty(String action, String locator) throws Throwable {
        runCommand("executeIfNotValueEmpty", action, locator, null);
    }

    public void executeIfNotValueEmpty(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotValueEmpty", action, parentLocator, locator);
    }

    public void executeIfNotVariable(String action, String variable, String text) throws Throwable {
        runCommand("executeIfNotVariable", action, variable, text);
    }

    public void executeIfNotVisible(String action, String locator) throws Throwable {
        runCommand("executeIfNotVisible", action, locator, null);
    }

    public void executeIfNotVisible(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotVisible", action, parentLocator, locator);
    }

    public void executeIfPrompt(String action, String text) throws Throwable {
        runCommand("executeIfPrompt", action, text, null);
    }

    public void executeIfPromptContain(String action, String text) throws Throwable {
        runCommand("executeIfPromptContain", action, text, null);
    }

    public void executeIfPromptNotContain(String action, String text) throws Throwable {
        runCommand("executeIfPromptNotContain", action, text, null);
    }

    public void executeIfPromptNotPresent(String action) throws Throwable {
        runCommand("executeIfPromptNotPresent", action, null, null);
    }

    public void executeIfPromptPresent(String action) throws Throwable {
        runCommand("executeIfPromptPresent", action, null, null);
    }

    public void executeIfSelectedId(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedId", action, locator, text);
    }

    public void executeIfSelectedIdContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIdContain", action, locator, text);
    }

    public void executeIfSelectedIdNotContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIdNotContain", action, locator, text);
    }

    public void executeIfSelectedIndex(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIndex", action, locator, text);
    }

    public void executeIfSelectedIndexContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIndexContain", action, locator, text);
    }

    public void executeIfSelectedIndexNotContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIndexNotContain", action, locator, text);
    }

    public void executeIfSelectedLabel(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedLabel", action, locator, text);
    }

    public void executeIfSelectedLabelContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedLabelContain", action, locator, text);
    }

    public void executeIfSelectedLabelNotContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedLabelNotContain", action, locator, text);
    }

    public void executeIfSelectedValue(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedValue", action, locator, text);
    }

    public void executeIfSelectedValueContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedValueContain", action, locator, text);
    }

    public void executeIfSelectedValueNotContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedValueNotContain", action, locator, text);
    }

    public void executeIfSomethingSelected(String action, String locator) throws Throwable {
        runCommand("executeIfSomethingSelected", action, locator, null);
    }

    public void executeIfSomethingSelected(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfSomethingSelected", action, parentLocator, locator);
    }

    public void executeIfText(String action, String locator, String text) throws Throwable {
        runCommand("executeIfText", action, locator, text);
    }

    public void executeIfTextContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTextContain", action, locator, text);
    }

    public void executeIfTextEmpty(String action, String locator) throws Throwable {
        runCommand("executeIfTextEmpty", action, locator, null);
    }

    public void executeIfTextEmpty(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfTextEmpty", action, parentLocator, locator);
    }

    public void executeIfTextNotContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTextNotContain", action, locator, text);
    }

    public void executeIfTextNotPresent(String action, String pattern) throws Throwable {
        runCommand("executeIfTextNotPresent", action, pattern, null);
    }

    public void executeIfTextPresent(String action, String pattern) throws Throwable {
        runCommand("executeIfTextPresent", action, pattern, null);
    }

    public void executeIfTitle(String action, String text) throws Throwable {
        runCommand("executeIfTitle", action, text, null);
    }

    public void executeIfTitleContain(String action, String text) throws Throwable {
        runCommand("executeIfTitleContain", action, text, null);
    }

    public void executeIfTitleNotContain(String action, String text) throws Throwable {
        runCommand("executeIfTitleNotContain", action, text, null);
    }

    public void executeIfValue(String action, String locator, String text) throws Throwable {
        runCommand("executeIfValue", action, locator, text);
    }

    public void executeIfValueContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfValueContain", action, locator, text);
    }

    public void executeIfValueEmpty(String action, String locator) throws Throwable {
        runCommand("executeIfValueEmpty", action, locator, null);
    }

    public void executeIfValueEmpty(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfValueEmpty", action, parentLocator, locator);
    }

    public void executeIfValueNotContain(String action, String locator, String text) throws Throwable {
        runCommand("executeIfValueNotContain", action, locator, text);
    }

    public void executeIfVariable(String action, String variable, String text) throws Throwable {
        runCommand("executeIfVariable", action, variable, text);
    }

    public void executeIfVariableContain(String action, String variable, String text) throws Throwable {
        runCommand("executeIfVariableContain", action, variable, text);
    }

    public void executeIfVariableNotContain(String action, String variable, String text) throws Throwable {
        runCommand("executeIfVariableNotContain", action, variable, text);
    }

    public void executeIfVisible(String action, String locator) throws Throwable {
        runCommand("executeIfVisible", action, locator, null);
    }

    public void executeIfVisible(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfVisible", action, parentLocator, locator);
    }

    public void executeLoop(String action, String times) throws Throwable {
        runCommand("executeLoop", action, times, null);
    }

    public void fireEvent(String locator, String eventName) throws Throwable {
        runCommand("fireEvent", locator, eventName, null);
    }

    public void fireEvent(String parentLocator, String locator, String eventName) throws Throwable {
        runCommand("fireEvent", parentLocator, locator, eventName);
    }

    public void focus(String locator) throws Throwable {
        runCommand("focus", locator, null, null);
    }

    public void focus(String parentLocator, String locator) throws Throwable {
        runCommand("focus", parentLocator, locator, null);
    }

    public void goBack() throws Throwable {
        runCommand("goBack", null, null, null);
    }

    public void goForward() throws Throwable {
        runCommand("goForward", null, null, null);
    }

    public void highlight(String locator) throws Throwable {
        runCommand("highlight", locator, null, null);
    }

    public void highlight(String parentLocator, String locator) throws Throwable {
        runCommand("highlight", parentLocator, locator, null);
    }

    public void keyDown(String keycode) throws Throwable {
        runCommand("keyDown", keycode, null, null);
    }

    public void keyDown(String locator, String keySequence) throws Throwable {
        runCommand("keyDown", locator, keySequence, null);
    }

    public void keyDown(String parentLocator, String locator, String keySequence) throws Throwable {
        runCommand("keyDown", parentLocator, locator, keySequence);
    }

    public void keyPress(String locator, String keySequence) throws Throwable {
        runCommand("keyPress", locator, keySequence, null);
    }

    public void keyPress(String parentLocator, String locator, String keySequence) throws Throwable {
        runCommand("keyPress", parentLocator, locator, keySequence);
    }

    public void keyPress(String keycode) throws Throwable {
        runCommand("keyPress", keycode, null, null);
    }

    public void keyUp(String locator, String keySequence) throws Throwable {
        runCommand("keyUp", locator, keySequence, null);
    }

    public void keyUp(String parentLocator, String locator, String keySequence) throws Throwable {
        runCommand("keyUp", parentLocator, locator, keySequence);
    }

    public void keyUp(String keycode) throws Throwable {
        runCommand("keyUp", keycode, null, null);
    }

    public void metaKeyDown() throws Throwable {
        runCommand("metaKeyDown", null, null, null);
    }

    public void metaKeyUp() throws Throwable {
        runCommand("metaKeyUp", null, null, null);
    }

    public void mouseDown(String locator) throws Throwable {
        runCommand("mouseDown", locator, null, null);
    }

    public void mouseDown(String parentLocator, String locator) throws Throwable {
        runCommand("mouseDown", parentLocator, locator, null);
    }

    public void mouseDownAt(String locator, String coordString) throws Throwable {
        runCommand("mouseDownAt", locator, coordString, null);
    }

    public void mouseDownAt(String parentLocator, String locator, String coordString) throws Throwable {
        runCommand("mouseDownAt", parentLocator, locator, coordString);
    }

    public void mouseMove(String locator) throws Throwable {
        runCommand("mouseMove", locator, null, null);
    }

    public void mouseMove(String parentLocator, String locator) throws Throwable {
        runCommand("mouseMove", parentLocator, locator, null);
    }

    public void mouseMoveAt(String locator, String coordString) throws Throwable {
        runCommand("mouseMoveAt", locator, coordString, null);
    }

    public void mouseMoveAt(String parentLocator, String locator, String coordString) throws Throwable {
        runCommand("mouseMoveAt", parentLocator, locator, coordString);
    }

    public void mouseOut(String locator) throws Throwable {
        runCommand("mouseOut", locator, null, null);
    }

    public void mouseOut(String parentLocator, String locator) throws Throwable {
        runCommand("mouseOut", parentLocator, locator, null);
    }

    public void mouseOver(String locator) throws Throwable {
        runCommand("mouseOver", locator, null, null);
    }

    public void mouseOver(String parentLocator, String locator) throws Throwable {
        runCommand("mouseOver", parentLocator, locator, null);
    }

    public void mouseUp(String locator) throws Throwable {
        runCommand("mouseUp", locator, null, null);
    }

    public void mouseUp(String parentLocator, String locator) throws Throwable {
        runCommand("mouseUp", parentLocator, locator, null);
    }

    public void mouseUpAt(String locator, String coordString) throws Throwable {
        runCommand("mouseUpAt", locator, coordString, null);
    }

    public void mouseUpAt(String parentLocator, String locator, String coordString) throws Throwable {
        runCommand("mouseUpAt", parentLocator, locator, coordString);
    }

    public void open(String url) throws Throwable {
        runCommand("open", url, null, null);
    }

    public void openWindow(String url, String windowID) throws Throwable {
        runCommand("openWindow", url, windowID, null);
    }

    public void openWindow(String url) throws Throwable {
        runCommand("openWindow", url, null, null);
    }

    public void pause(String waitTime) throws Throwable {
        runCommand("pause", waitTime, null, null);
    }

    public void refresh() throws Throwable {
        runCommand("refresh", null, null, null);
    }

    public void removeAllSelections(String locator) throws Throwable {
        runCommand("removeAllSelections", locator, null, null);
    }

    public void removeAllSelections(String parentLocator, String locator) throws Throwable {
        runCommand("removeAllSelections", parentLocator, locator, null);
    }

    public void removeSelection(String locator, String optionLocator) throws Throwable {
        runCommand("removeSelection", locator, optionLocator, null);
    }

    public void removeSelection(String parentLocator, String locator, String optionLocator) throws Throwable {
        runCommand("removeSelection", parentLocator, locator, optionLocator);
    }

    public void removeSelectionId(String locator, String id) throws Throwable {
        runCommand("removeSelectionId", locator, id, null);
    }

    public void removeSelectionId(String parentLocator, String locator, String id) throws Throwable {
        runCommand("removeSelectionId", parentLocator, locator, id);
    }

    public void removeSelectionIndex(String locator, String index) throws Throwable {
        runCommand("removeSelectionIndex", locator, index, null);
    }

    public void removeSelectionIndex(String parentLocator, String locator, String index) throws Throwable {
        runCommand("removeSelectionIndex", parentLocator, locator, index);
    }

    public void removeSelectionLabel(String locator, String label) throws Throwable {
        runCommand("removeSelectionLabel", locator, label, null);
    }

    public void removeSelectionLabel(String parentLocator, String locator, String label) throws Throwable {
        runCommand("removeSelectionLabel", parentLocator, locator, label);
    }

    public void removeSelectionValue(String locator, String value) throws Throwable {
        runCommand("removeSelectionValue", locator, value, null);
    }

    public void removeSelectionValue(String parentLocator, String locator, String value) throws Throwable {
        runCommand("removeSelectionValue", parentLocator, locator, value);
    }

    public void runScript(String script) throws Throwable {
        runCommand("runScript", script, null, null);
    }

    public void select(String locator, String optionLocator) throws Throwable {
        runCommand("select", locator, optionLocator, null);
    }

    public void select(String parentLocator, String locator, String optionLocator) throws Throwable {
        runCommand("select", parentLocator, locator, optionLocator);
    }

    public void selectFirstWindow() throws Throwable {
        runCommand("selectFirstWindow", null, null, null);
    }

    public void selectFrame(String locator) throws Throwable {
        runCommand("selectFrame", locator, null, null);
    }

    public void selectId(String locator, String id) throws Throwable {
        runCommand("selectId", locator, id, null);
    }

    public void selectId(String parentLocator, String locator, String id) throws Throwable {
        runCommand("selectId", parentLocator, locator, id);
    }

    public void selectIndex(String locator, String index) throws Throwable {
        runCommand("selectIndex", locator, index, null);
    }

    public void selectIndex(String parentLocator, String locator, String index) throws Throwable {
        runCommand("selectIndex", parentLocator, locator, index);
    }

    public void selectLabel(String locator, String label) throws Throwable {
        runCommand("selectLabel", locator, label, null);
    }

    public void selectLabel(String parentLocator, String locator, String label) throws Throwable {
        runCommand("selectLabel", parentLocator, locator, label);
    }

    public void selectLastWindow() throws Throwable {
        runCommand("selectLastWindow", null, null, null);
    }

    public void selectParentFrame() throws Throwable {
        runCommand("selectParentFrame", null, null, null);
    }

    public void selectPopUp(String windowID) throws Throwable {
        runCommand("selectPopUp", windowID, null, null);
    }

    public void selectValue(String locator, String value) throws Throwable {
        runCommand("selectValue", locator, value, null);
    }

    public void selectValue(String parentLocator, String locator, String value) throws Throwable {
        runCommand("selectValue", parentLocator, locator, value);
    }

    public void selectWindow(String windowID) throws Throwable {
        runCommand("selectWindow", windowID, null, null);
    }

    public void setCursorPosition(String locator, String position) throws Throwable {
        runCommand("setCursorPosition", locator, position, null);
    }

    public void setCursorPosition(String parentLocator, String locator, String position) throws Throwable {
        runCommand("setCursorPosition", parentLocator, locator, position);
    }

    public void setTimeout(String timeout) throws Throwable {
        runCommand("setTimeout", timeout, null, null);
    }

    public void shiftKeyDown() throws Throwable {
        runCommand("shiftKeyDown", null, null, null);
    }

    public void shiftKeyUp() throws Throwable {
        runCommand("shiftKeyUp", null, null, null);
    }

    public void store(String text, String variable) throws Throwable {
        runCommand("store", text, variable, null);
    }

    public void storeAlert(String variable) throws Throwable {
        runCommand("storeAlert", variable, null, null);
    }

    public void storeAllButtons(String variable) throws Throwable {
        runCommand("storeAllButtons", variable, null, null);
    }

    public void storeAllFields(String variable) throws Throwable {
        runCommand("storeAllFields", variable, null, null);
    }

    public void storeAllLinks(String variable) throws Throwable {
        runCommand("storeAllLinks", variable, null, null);
    }

    public void storeAllWindowNames(String variable) throws Throwable {
        runCommand("storeAllWindowNames", variable, null, null);
    }

    public void storeAllWindowTitles(String variable) throws Throwable {
        runCommand("storeAllWindowTitles", variable, null, null);
    }

    public void storeAttribute(String locator, String name, String variable) throws Throwable {
        runCommand("storeAttribute", locator, name, variable);
    }

    public void storeAttributeFromAllWindows(String attributeName, String variable) throws Throwable {
        runCommand("storeAttributeFromAllWindows", attributeName, variable, null);
    }

    public void storeBodyText(String variable) throws Throwable {
        runCommand("storeBodyText", variable, null, null);
    }

    public void storeConfirmation(String variable) throws Throwable {
        runCommand("storeConfirmation", variable, null, null);
    }

    public void storeCookie(String variable) throws Throwable {
        runCommand("storeCookie", variable, null, null);
    }

    public void storeCookieByName(String name, String variable) throws Throwable {
        runCommand("storeCookieByName", name, variable, null);
    }

    public void storeCurrentDate(String variable) throws Throwable {
        runCommand("storeCurrentDate", variable, null, null);
    }

    public void storeEval(String expression, String variable) throws Throwable {
        runCommand("storeEval", expression, variable, null);
    }

    public void storeEvalScript(String script, String variable) throws Throwable {
        runCommand("storeEvalScript", script, variable, null);
    }

    public void storeExpression(String expression, String variable) throws Throwable {
        runCommand("storeExpression", expression, variable, null);
    }

    public void storeHtmlSource(String variable) throws Throwable {
        runCommand("storeHtmlSource", variable, null, null);
    }

    public void storeLocation(String variable) throws Throwable {
        runCommand("storeLocation", variable, null, null);
    }

    public void storePrompt(String variable) throws Throwable {
        runCommand("storePrompt", variable, null, null);
    }

    public void storePush(String text, String variable) throws Throwable {
        runCommand("storePush", text, variable, null);
    }

    public void storeSelectOptions(String locator, String variable) throws Throwable {
        runCommand("storeSelectOptions", locator, variable, null);
    }

    public void storeSelectOptions(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectOptions", parentLocator, locator, variable);
    }

    public void storeSelectedId(String locator, String variable) throws Throwable {
        runCommand("storeSelectedId", locator, variable, null);
    }

    public void storeSelectedId(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedId", parentLocator, locator, variable);
    }

    public void storeSelectedIds(String locator, String variable) throws Throwable {
        runCommand("storeSelectedIds", locator, variable, null);
    }

    public void storeSelectedIds(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedIds", parentLocator, locator, variable);
    }

    public void storeSelectedIndex(String locator, String variable) throws Throwable {
        runCommand("storeSelectedIndex", locator, variable, null);
    }

    public void storeSelectedIndex(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedIndex", parentLocator, locator, variable);
    }

    public void storeSelectedIndexes(String locator, String variable) throws Throwable {
        runCommand("storeSelectedIndexes", locator, variable, null);
    }

    public void storeSelectedIndexes(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedIndexes", parentLocator, locator, variable);
    }

    public void storeSelectedLabel(String locator, String variable) throws Throwable {
        runCommand("storeSelectedLabel", locator, variable, null);
    }

    public void storeSelectedLabel(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedLabel", parentLocator, locator, variable);
    }

    public void storeSelectedLabels(String locator, String variable) throws Throwable {
        runCommand("storeSelectedLabels", locator, variable, null);
    }

    public void storeSelectedLabels(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedLabels", parentLocator, locator, variable);
    }

    public void storeSelectedValue(String locator, String variable) throws Throwable {
        runCommand("storeSelectedValue", locator, variable, null);
    }

    public void storeSelectedValue(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedValue", parentLocator, locator, variable);
    }

    public void storeSelectedValues(String locator, String variable) throws Throwable {
        runCommand("storeSelectedValues", locator, variable, null);
    }

    public void storeSelectedValues(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeSelectedValues", parentLocator, locator, variable);
    }

    public void storeTable(String locator, String cellAddress, String variable) throws Throwable {
        runCommand("storeTable", locator, cellAddress, variable);
    }

    public void storeText(String locator, String variable) throws Throwable {
        runCommand("storeText", locator, variable, null);
    }

    public void storeText(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeText", parentLocator, locator, variable);
    }

    public void storeTitle(String variable) throws Throwable {
        runCommand("storeTitle", variable, null, null);
    }

    public void storeValue(String locator, String variable) throws Throwable {
        runCommand("storeValue", locator, variable, null);
    }

    public void storeValue(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeValue", parentLocator, locator, variable);
    }

    public void submit(String locator) throws Throwable {
        runCommand("submit", locator, null, null);
    }

    public void submit(String parentLocator, String locator) throws Throwable {
        runCommand("submit", parentLocator, locator, null);
    }

    public void type(String locator, String value) throws Throwable {
        runCommand("type", locator, value, null);
    }

    public void type(String parentLocator, String locator, String value) throws Throwable {
        runCommand("type", parentLocator, locator, value);
    }

    public void typeAndTab(String locator, String value) throws Throwable {
        runCommand("typeAndTab", locator, value, null);
    }

    public void typeAndTab(String parentLocator, String locator, String value) throws Throwable {
        runCommand("typeAndTab", parentLocator, locator, value);
    }

    public void typeKeys(String locator, String value) throws Throwable {
        runCommand("typeKeys", locator, value, null);
    }

    public void typeKeys(String parentLocator, String locator, String value) throws Throwable {
        runCommand("typeKeys", parentLocator, locator, value);
    }

    public void uncheck(String locator) throws Throwable {
        runCommand("uncheck", locator, null, null);
    }

    public void uncheck(String parentLocator, String locator) throws Throwable {
        runCommand("uncheck", parentLocator, locator, null);
    }

    public void verifyAlert(String text) throws Throwable {
        runCommand("verifyAlert", text, null, null);
    }

    public void verifyAlertContain(String text) throws Throwable {
        runCommand("verifyAlertContain", text, null, null);
    }

    public void verifyAlertNotContain(String text) throws Throwable {
        runCommand("verifyAlertNotContain", text, null, null);
    }

    public void verifyAlertNotPresent() throws Throwable {
        runCommand("verifyAlertNotPresent", null, null, null);
    }

    public void verifyAlertPresent() throws Throwable {
        runCommand("verifyAlertPresent", null, null, null);
    }

    public void verifyAttribute(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttribute", locator, name, text);
    }

    public void verifyAttributeContain(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttributeContain", locator, name, text);
    }

    public void verifyAttributeNotContain(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttributeNotContain", locator, name, text);
    }

    public void verifyBackgroundColor(String locator, String text) throws Throwable {
        runCommand("verifyBackgroundColor", locator, text, null);
    }

    public void verifyBackgroundColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyBackgroundColor", parentLocator, locator, text);
    }

    public void verifyBodyText(String text) throws Throwable {
        runCommand("verifyBodyText", text, null, null);
    }

    public void verifyBodyTextContain(String text) throws Throwable {
        runCommand("verifyBodyTextContain", text, null, null);
    }

    public void verifyBodyTextNotContain(String text) throws Throwable {
        runCommand("verifyBodyTextNotContain", text, null, null);
    }

    public void verifyBorderColor(String locator, String text) throws Throwable {
        runCommand("verifyBorderColor", locator, text, null);
    }

    public void verifyBorderColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyBorderColor", parentLocator, locator, text);
    }

    public void verifyChecked(String locator) throws Throwable {
        runCommand("verifyChecked", locator, null, null);
    }

    public void verifyChecked(String parentLocator, String locator) throws Throwable {
        runCommand("verifyChecked", parentLocator, locator, null);
    }

    public void verifyColor(String locator, String text) throws Throwable {
        runCommand("verifyColor", locator, text, null);
    }

    public void verifyColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyColor", parentLocator, locator, text);
    }

    public void verifyConfirmation(String text) throws Throwable {
        runCommand("verifyConfirmation", text, null, null);
    }

    public void verifyConfirmationContain(String text) throws Throwable {
        runCommand("verifyConfirmationContain", text, null, null);
    }

    public void verifyConfirmationNotContain(String text) throws Throwable {
        runCommand("verifyConfirmationNotContain", text, null, null);
    }

    public void verifyConfirmationNotPresent() throws Throwable {
        runCommand("verifyConfirmationNotPresent", null, null, null);
    }

    public void verifyConfirmationPresent() throws Throwable {
        runCommand("verifyConfirmationPresent", null, null, null);
    }

    public void verifyCookie(String text) throws Throwable {
        runCommand("verifyCookie", text, null, null);
    }

    public void verifyCookieByName(String name, String text) throws Throwable {
        runCommand("verifyCookieByName", name, text, null);
    }

    public void verifyCookieByNameContain(String name, String text) throws Throwable {
        runCommand("verifyCookieByNameContain", name, text, null);
    }

    public void verifyCookieByNameNotContain(String name, String text) throws Throwable {
        runCommand("verifyCookieByNameNotContain", name, text, null);
    }

    public void verifyCookieContain(String text) throws Throwable {
        runCommand("verifyCookieContain", text, null, null);
    }

    public void verifyCookieNotContain(String text) throws Throwable {
        runCommand("verifyCookieNotContain", text, null, null);
    }

    public void verifyCookieNotPresent(String name) throws Throwable {
        runCommand("verifyCookieNotPresent", name, null, null);
    }

    public void verifyCookiePresent(String name) throws Throwable {
        runCommand("verifyCookiePresent", name, null, null);
    }

    public void verifyCssCount(String css, String text) throws Throwable {
        runCommand("verifyCssCount", css, text, null);
    }

    public void verifyCursorPosition(String locator, String text) throws Throwable {
        runCommand("verifyCursorPosition", locator, text, null);
    }

    public void verifyCursorPosition(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyCursorPosition", parentLocator, locator, text);
    }

    public void verifyDateListOrderAsc(String locator, String format) throws Throwable {
        runCommand("verifyDateListOrderAsc", locator, format, null);
    }

    public void verifyDateListOrderAsc(String parentLocator, String locator, String format) throws Throwable {
        runCommand("verifyDateListOrderAsc", parentLocator, locator, format);
    }

    public void verifyDateListOrderDesc(String locator, String format) throws Throwable {
        runCommand("verifyDateListOrderDesc", locator, format, null);
    }

    public void verifyDateListOrderDesc(String parentLocator, String locator, String format) throws Throwable {
        runCommand("verifyDateListOrderDesc", parentLocator, locator, format);
    }

    public void verifyEditable(String locator) throws Throwable {
        runCommand("verifyEditable", locator, null, null);
    }

    public void verifyEditable(String parentLocator, String locator) throws Throwable {
        runCommand("verifyEditable", parentLocator, locator, null);
    }

    public void verifyElementHeight(String locator, String text) throws Throwable {
        runCommand("verifyElementHeight", locator, text, null);
    }

    public void verifyElementHeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyElementHeight", parentLocator, locator, text);
    }

    public void verifyElementIndex(String locator, String text) throws Throwable {
        runCommand("verifyElementIndex", locator, text, null);
    }

    public void verifyElementIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyElementIndex", parentLocator, locator, text);
    }

    public void verifyElementNotPresent(String locator) throws Throwable {
        runCommand("verifyElementNotPresent", locator, null, null);
    }

    public void verifyElementNotPresent(String parentLocator, String locator) throws Throwable {
        runCommand("verifyElementNotPresent", parentLocator, locator, null);
    }

    public void verifyElementPositionLeft(String locator, String text) throws Throwable {
        runCommand("verifyElementPositionLeft", locator, text, null);
    }

    public void verifyElementPositionLeft(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyElementPositionLeft", parentLocator, locator, text);
    }

    public void verifyElementPositionTop(String locator, String text) throws Throwable {
        runCommand("verifyElementPositionTop", locator, text, null);
    }

    public void verifyElementPositionTop(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyElementPositionTop", parentLocator, locator, text);
    }

    public void verifyElementPresent(String locator) throws Throwable {
        runCommand("verifyElementPresent", locator, null, null);
    }

    public void verifyElementPresent(String parentLocator, String locator) throws Throwable {
        runCommand("verifyElementPresent", parentLocator, locator, null);
    }

    public void verifyElementWidth(String locator, String text) throws Throwable {
        runCommand("verifyElementWidth", locator, text, null);
    }

    public void verifyElementWidth(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyElementWidth", parentLocator, locator, text);
    }

    public void verifyEval(String expression, String text) throws Throwable {
        runCommand("verifyEval", expression, text, null);
    }

    public void verifyEvalScript(String script, String text) throws Throwable {
        runCommand("verifyEvalScript", script, text, null);
    }

    public void verifyEvalScriptContain(String script, String text) throws Throwable {
        runCommand("verifyEvalScriptContain", script, text, null);
    }

    public void verifyEvalScriptNotContain(String script, String text) throws Throwable {
        runCommand("verifyEvalScriptNotContain", script, text, null);
    }

    public void verifyExistsInDatabase(String sql) throws Throwable {
        runCommand("verifyExistsInDatabase", sql, null, null);
    }

    public void verifyExpression(String expression, String text) throws Throwable {
        runCommand("verifyExpression", expression, text, null);
    }

    public void verifyExpressionContain(String expression, String text) throws Throwable {
        runCommand("verifyExpressionContain", expression, text, null);
    }

    public void verifyExpressionNotContain(String expression, String text) throws Throwable {
        runCommand("verifyExpressionNotContain", expression, text, null);
    }

    public void verifyFontFamily(String locator, String text) throws Throwable {
        runCommand("verifyFontFamily", locator, text, null);
    }

    public void verifyFontFamily(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontFamily", parentLocator, locator, text);
    }

    public void verifyFontFamilyContain(String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyContain", locator, text, null);
    }

    public void verifyFontFamilyContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyContain", parentLocator, locator, text);
    }

    public void verifyFontFamilyNotContain(String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyNotContain", locator, text, null);
    }

    public void verifyFontFamilyNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyNotContain", parentLocator, locator, text);
    }

    public void verifyFontSize(String locator, String text) throws Throwable {
        runCommand("verifyFontSize", locator, text, null);
    }

    public void verifyFontSize(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontSize", parentLocator, locator, text);
    }

    public void verifyFontSizeContain(String locator, String text) throws Throwable {
        runCommand("verifyFontSizeContain", locator, text, null);
    }

    public void verifyFontSizeContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontSizeContain", parentLocator, locator, text);
    }

    public void verifyFontSizeNotContain(String locator, String text) throws Throwable {
        runCommand("verifyFontSizeNotContain", locator, text, null);
    }

    public void verifyFontSizeNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontSizeNotContain", parentLocator, locator, text);
    }

    public void verifyFontStyle(String locator, String text) throws Throwable {
        runCommand("verifyFontStyle", locator, text, null);
    }

    public void verifyFontStyle(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontStyle", parentLocator, locator, text);
    }

    public void verifyFontStyleContain(String locator, String text) throws Throwable {
        runCommand("verifyFontStyleContain", locator, text, null);
    }

    public void verifyFontStyleContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontStyleContain", parentLocator, locator, text);
    }

    public void verifyFontStyleNotContain(String locator, String text) throws Throwable {
        runCommand("verifyFontStyleNotContain", locator, text, null);
    }

    public void verifyFontStyleNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontStyleNotContain", parentLocator, locator, text);
    }

    public void verifyFontWeight(String locator, String text) throws Throwable {
        runCommand("verifyFontWeight", locator, text, null);
    }

    public void verifyFontWeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontWeight", parentLocator, locator, text);
    }

    public void verifyFontWeightContain(String locator, String text) throws Throwable {
        runCommand("verifyFontWeightContain", locator, text, null);
    }

    public void verifyFontWeightContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontWeightContain", parentLocator, locator, text);
    }

    public void verifyFontWeightNotContain(String locator, String text) throws Throwable {
        runCommand("verifyFontWeightNotContain", locator, text, null);
    }

    public void verifyFontWeightNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontWeightNotContain", parentLocator, locator, text);
    }

    public void verifyHtmlSource(String text) throws Throwable {
        runCommand("verifyHtmlSource", text, null, null);
    }

    public void verifyHtmlSourceContain(String text) throws Throwable {
        runCommand("verifyHtmlSourceContain", text, null, null);
    }

    public void verifyHtmlSourceNotContain(String text) throws Throwable {
        runCommand("verifyHtmlSourceNotContain", text, null, null);
    }

    public void verifyIntegerListOrderAsc(String locator) throws Throwable {
        runCommand("verifyIntegerListOrderAsc", locator, null, null);
    }

    public void verifyIntegerListOrderAsc(String parentLocator, String locator) throws Throwable {
        runCommand("verifyIntegerListOrderAsc", parentLocator, locator, null);
    }

    public void verifyIntegerListOrderDesc(String locator) throws Throwable {
        runCommand("verifyIntegerListOrderDesc", locator, null, null);
    }

    public void verifyIntegerListOrderDesc(String parentLocator, String locator) throws Throwable {
        runCommand("verifyIntegerListOrderDesc", parentLocator, locator, null);
    }

    public void verifyListContain(String variable, String text) throws Throwable {
        runCommand("verifyListContain", variable, text, null);
    }

    public void verifyListNotContain(String variable, String text) throws Throwable {
        runCommand("verifyListNotContain", variable, text, null);
    }

    public void verifyListOrderAsc(String variable) throws Throwable {
        runCommand("verifyListOrderAsc", variable, null, null);
    }

    public void verifyListOrderDesc(String variable) throws Throwable {
        runCommand("verifyListOrderDesc", variable, null, null);
    }

    public void verifyLocation(String text) throws Throwable {
        runCommand("verifyLocation", text, null, null);
    }

    public void verifyLocationContain(String text) throws Throwable {
        runCommand("verifyLocationContain", text, null, null);
    }

    public void verifyLocationNotContain(String text) throws Throwable {
        runCommand("verifyLocationNotContain", text, null, null);
    }

    public void verifyNotAlert(String text) throws Throwable {
        runCommand("verifyNotAlert", text, null, null);
    }

    public void verifyNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("verifyNotAttribute", locator, name, text);
    }

    public void verifyNotBackgroundColor(String locator, String text) throws Throwable {
        runCommand("verifyNotBackgroundColor", locator, text, null);
    }

    public void verifyNotBackgroundColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotBackgroundColor", parentLocator, locator, text);
    }

    public void verifyNotBodyText(String text) throws Throwable {
        runCommand("verifyNotBodyText", text, null, null);
    }

    public void verifyNotBorderColor(String locator, String text) throws Throwable {
        runCommand("verifyNotBorderColor", locator, text, null);
    }

    public void verifyNotBorderColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotBorderColor", parentLocator, locator, text);
    }

    public void verifyNotChecked(String locator) throws Throwable {
        runCommand("verifyNotChecked", locator, null, null);
    }

    public void verifyNotChecked(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotChecked", parentLocator, locator, null);
    }

    public void verifyNotColor(String locator, String text) throws Throwable {
        runCommand("verifyNotColor", locator, text, null);
    }

    public void verifyNotColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotColor", parentLocator, locator, text);
    }

    public void verifyNotConfirmation(String text) throws Throwable {
        runCommand("verifyNotConfirmation", text, null, null);
    }

    public void verifyNotCookie(String text) throws Throwable {
        runCommand("verifyNotCookie", text, null, null);
    }

    public void verifyNotCookieByName(String name, String text) throws Throwable {
        runCommand("verifyNotCookieByName", name, text, null);
    }

    public void verifyNotCssCount(String css, String text) throws Throwable {
        runCommand("verifyNotCssCount", css, text, null);
    }

    public void verifyNotCursorPosition(String locator, String text) throws Throwable {
        runCommand("verifyNotCursorPosition", locator, text, null);
    }

    public void verifyNotCursorPosition(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotCursorPosition", parentLocator, locator, text);
    }

    public void verifyNotEditable(String locator) throws Throwable {
        runCommand("verifyNotEditable", locator, null, null);
    }

    public void verifyNotEditable(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotEditable", parentLocator, locator, null);
    }

    public void verifyNotElementHeight(String locator, String text) throws Throwable {
        runCommand("verifyNotElementHeight", locator, text, null);
    }

    public void verifyNotElementHeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotElementHeight", parentLocator, locator, text);
    }

    public void verifyNotElementIndex(String locator, String text) throws Throwable {
        runCommand("verifyNotElementIndex", locator, text, null);
    }

    public void verifyNotElementIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotElementIndex", parentLocator, locator, text);
    }

    public void verifyNotElementPositionLeft(String locator, String text) throws Throwable {
        runCommand("verifyNotElementPositionLeft", locator, text, null);
    }

    public void verifyNotElementPositionLeft(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotElementPositionLeft", parentLocator, locator, text);
    }

    public void verifyNotElementPositionTop(String locator, String text) throws Throwable {
        runCommand("verifyNotElementPositionTop", locator, text, null);
    }

    public void verifyNotElementPositionTop(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotElementPositionTop", parentLocator, locator, text);
    }

    public void verifyNotElementWidth(String locator, String text) throws Throwable {
        runCommand("verifyNotElementWidth", locator, text, null);
    }

    public void verifyNotElementWidth(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotElementWidth", parentLocator, locator, text);
    }

    public void verifyNotEval(String expression, String text) throws Throwable {
        runCommand("verifyNotEval", expression, text, null);
    }

    public void verifyNotEvalScript(String script, String text) throws Throwable {
        runCommand("verifyNotEvalScript", script, text, null);
    }

    public void verifyNotExistsInDatabase(String sql) throws Throwable {
        runCommand("verifyNotExistsInDatabase", sql, null, null);
    }

    public void verifyNotExpression(String expression, String text) throws Throwable {
        runCommand("verifyNotExpression", expression, text, null);
    }

    public void verifyNotFontFamily(String locator, String text) throws Throwable {
        runCommand("verifyNotFontFamily", locator, text, null);
    }

    public void verifyNotFontFamily(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotFontFamily", parentLocator, locator, text);
    }

    public void verifyNotFontSize(String locator, String text) throws Throwable {
        runCommand("verifyNotFontSize", locator, text, null);
    }

    public void verifyNotFontSize(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotFontSize", parentLocator, locator, text);
    }

    public void verifyNotFontStyle(String locator, String text) throws Throwable {
        runCommand("verifyNotFontStyle", locator, text, null);
    }

    public void verifyNotFontStyle(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotFontStyle", parentLocator, locator, text);
    }

    public void verifyNotFontWeight(String locator, String text) throws Throwable {
        runCommand("verifyNotFontWeight", locator, text, null);
    }

    public void verifyNotFontWeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotFontWeight", parentLocator, locator, text);
    }

    public void verifyNotHtmlSource(String text) throws Throwable {
        runCommand("verifyNotHtmlSource", text, null, null);
    }

    public void verifyNotLocation(String text) throws Throwable {
        runCommand("verifyNotLocation", text, null, null);
    }

    public void verifyNotOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("verifyNotOrdered", firstLocator, secondLocator, null);
    }

    public void verifyNotPrompt(String text) throws Throwable {
        runCommand("verifyNotPrompt", text, null, null);
    }

    public void verifyNotSelectedId(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedId", locator, text, null);
    }

    public void verifyNotSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedId", parentLocator, locator, text);
    }

    public void verifyNotSelectedIndex(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIndex", locator, text, null);
    }

    public void verifyNotSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIndex", parentLocator, locator, text);
    }

    public void verifyNotSelectedLabel(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedLabel", locator, text, null);
    }

    public void verifyNotSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedLabel", parentLocator, locator, text);
    }

    public void verifyNotSelectedValue(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedValue", locator, text, null);
    }

    public void verifyNotSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedValue", parentLocator, locator, text);
    }

    public void verifyNotSomethingSelected(String locator) throws Throwable {
        runCommand("verifyNotSomethingSelected", locator, null, null);
    }

    public void verifyNotSomethingSelected(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotSomethingSelected", parentLocator, locator, null);
    }

    public void verifyNotTable(String locator, String cellAddress, String text) throws Throwable {
        runCommand("verifyNotTable", locator, cellAddress, text);
    }

    public void verifyNotText(String locator, String text) throws Throwable {
        runCommand("verifyNotText", locator, text, null);
    }

    public void verifyNotText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotText", parentLocator, locator, text);
    }

    public void verifyNotTextAlignment(String locator, String text) throws Throwable {
        runCommand("verifyNotTextAlignment", locator, text, null);
    }

    public void verifyNotTextAlignment(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotTextAlignment", parentLocator, locator, text);
    }

    public void verifyNotTextDecoration(String locator, String text) throws Throwable {
        runCommand("verifyNotTextDecoration", locator, text, null);
    }

    public void verifyNotTextDecoration(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotTextDecoration", parentLocator, locator, text);
    }

    public void verifyNotTextEmpty(String locator) throws Throwable {
        runCommand("verifyNotTextEmpty", locator, null, null);
    }

    public void verifyNotTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotTextEmpty", parentLocator, locator, null);
    }

    public void verifyNotTitle(String text) throws Throwable {
        runCommand("verifyNotTitle", text, null, null);
    }

    public void verifyNotValue(String locator, String text) throws Throwable {
        runCommand("verifyNotValue", locator, text, null);
    }

    public void verifyNotValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotValue", parentLocator, locator, text);
    }

    public void verifyNotValueEmpty(String locator) throws Throwable {
        runCommand("verifyNotValueEmpty", locator, null, null);
    }

    public void verifyNotValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotValueEmpty", parentLocator, locator, null);
    }

    public void verifyNotVariable(String variable, String text) throws Throwable {
        runCommand("verifyNotVariable", variable, text, null);
    }

    public void verifyNotVisible(String locator) throws Throwable {
        runCommand("verifyNotVisible", locator, null, null);
    }

    public void verifyNotVisible(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotVisible", parentLocator, locator, null);
    }

    public void verifyNotXpathCount(String xpath, String text) throws Throwable {
        runCommand("verifyNotXpathCount", xpath, text, null);
    }

    public void verifyOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("verifyOrdered", firstLocator, secondLocator, null);
    }

    public void verifyPrompt(String text) throws Throwable {
        runCommand("verifyPrompt", text, null, null);
    }

    public void verifyPromptContain(String text) throws Throwable {
        runCommand("verifyPromptContain", text, null, null);
    }

    public void verifyPromptNotContain(String text) throws Throwable {
        runCommand("verifyPromptNotContain", text, null, null);
    }

    public void verifyPromptNotPresent() throws Throwable {
        runCommand("verifyPromptNotPresent", null, null, null);
    }

    public void verifyPromptPresent() throws Throwable {
        runCommand("verifyPromptPresent", null, null, null);
    }

    public void verifyRowCount(String sql, String count) throws Throwable {
        runCommand("verifyRowCount", sql, count, null);
    }

    public void verifyRowCountGreaterThan(String sql, String count) throws Throwable {
        runCommand("verifyRowCountGreaterThan", sql, count, null);
    }

    public void verifyRowCountLessThan(String sql, String count) throws Throwable {
        runCommand("verifyRowCountLessThan", sql, count, null);
    }

    public void verifySelectedId(String locator, String text) throws Throwable {
        runCommand("verifySelectedId", locator, text, null);
    }

    public void verifySelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedId", parentLocator, locator, text);
    }

    public void verifySelectedIdContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedIdContain", locator, text, null);
    }

    public void verifySelectedIdContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIdContain", parentLocator, locator, text);
    }

    public void verifySelectedIdNotContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedIdNotContain", locator, text, null);
    }

    public void verifySelectedIdNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIdNotContain", parentLocator, locator, text);
    }

    public void verifySelectedIndex(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndex", locator, text, null);
    }

    public void verifySelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndex", parentLocator, locator, text);
    }

    public void verifySelectedIndexContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexContain", locator, text, null);
    }

    public void verifySelectedIndexContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexContain", parentLocator, locator, text);
    }

    public void verifySelectedIndexNotContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexNotContain", locator, text, null);
    }

    public void verifySelectedIndexNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexNotContain", parentLocator, locator, text);
    }

    public void verifySelectedLabel(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabel", locator, text, null);
    }

    public void verifySelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabel", parentLocator, locator, text);
    }

    public void verifySelectedLabelContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelContain", locator, text, null);
    }

    public void verifySelectedLabelContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelContain", parentLocator, locator, text);
    }

    public void verifySelectedLabelNotContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelNotContain", locator, text, null);
    }

    public void verifySelectedLabelNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelNotContain", parentLocator, locator, text);
    }

    public void verifySelectedValue(String locator, String text) throws Throwable {
        runCommand("verifySelectedValue", locator, text, null);
    }

    public void verifySelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValue", parentLocator, locator, text);
    }

    public void verifySelectedValueContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedValueContain", locator, text, null);
    }

    public void verifySelectedValueContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValueContain", parentLocator, locator, text);
    }

    public void verifySelectedValueNotContain(String locator, String text) throws Throwable {
        runCommand("verifySelectedValueNotContain", locator, text, null);
    }

    public void verifySelectedValueNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValueNotContain", parentLocator, locator, text);
    }

    public void verifySomethingSelected(String locator) throws Throwable {
        runCommand("verifySomethingSelected", locator, null, null);
    }

    public void verifySomethingSelected(String parentLocator, String locator) throws Throwable {
        runCommand("verifySomethingSelected", parentLocator, locator, null);
    }

    public void verifyTable(String locator, String cellAddress, String text) throws Throwable {
        runCommand("verifyTable", locator, cellAddress, text);
    }

    public void verifyTableContain(String locator, String cellAddress, String text) throws Throwable {
        runCommand("verifyTableContain", locator, cellAddress, text);
    }

    public void verifyTableNotContain(String locator, String cellAddress, String text) throws Throwable {
        runCommand("verifyTableNotContain", locator, cellAddress, text);
    }

    public void verifyText(String locator, String text) throws Throwable {
        runCommand("verifyText", locator, text, null);
    }

    public void verifyText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyText", parentLocator, locator, text);
    }

    public void verifyTextAlignment(String locator, String text) throws Throwable {
        runCommand("verifyTextAlignment", locator, text, null);
    }

    public void verifyTextAlignment(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextAlignment", parentLocator, locator, text);
    }

    public void verifyTextAlignmentContain(String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentContain", locator, text, null);
    }

    public void verifyTextAlignmentContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentContain", parentLocator, locator, text);
    }

    public void verifyTextAlignmentNotContain(String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentNotContain", locator, text, null);
    }

    public void verifyTextAlignmentNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentNotContain", parentLocator, locator, text);
    }

    public void verifyTextContain(String locator, String text) throws Throwable {
        runCommand("verifyTextContain", locator, text, null);
    }

    public void verifyTextContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextContain", parentLocator, locator, text);
    }

    public void verifyTextDecoration(String locator, String text) throws Throwable {
        runCommand("verifyTextDecoration", locator, text, null);
    }

    public void verifyTextDecoration(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextDecoration", parentLocator, locator, text);
    }

    public void verifyTextDecorationContain(String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationContain", locator, text, null);
    }

    public void verifyTextDecorationContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationContain", parentLocator, locator, text);
    }

    public void verifyTextDecorationNotContain(String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationNotContain", locator, text, null);
    }

    public void verifyTextDecorationNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationNotContain", parentLocator, locator, text);
    }

    public void verifyTextEmpty(String locator) throws Throwable {
        runCommand("verifyTextEmpty", locator, null, null);
    }

    public void verifyTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("verifyTextEmpty", parentLocator, locator, null);
    }

    public void verifyTextListOrderAsc(String locator) throws Throwable {
        runCommand("verifyTextListOrderAsc", locator, null, null);
    }

    public void verifyTextListOrderAsc(String parentLocator, String locator) throws Throwable {
        runCommand("verifyTextListOrderAsc", parentLocator, locator, null);
    }

    public void verifyTextListOrderDesc(String locator) throws Throwable {
        runCommand("verifyTextListOrderDesc", locator, null, null);
    }

    public void verifyTextListOrderDesc(String parentLocator, String locator) throws Throwable {
        runCommand("verifyTextListOrderDesc", parentLocator, locator, null);
    }

    public void verifyTextNotContain(String locator, String text) throws Throwable {
        runCommand("verifyTextNotContain", locator, text, null);
    }

    public void verifyTextNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextNotContain", parentLocator, locator, text);
    }

    public void verifyTextNotPresent(String pattern) throws Throwable {
        runCommand("verifyTextNotPresent", pattern, null, null);
    }

    public void verifyTextPresent(String pattern) throws Throwable {
        runCommand("verifyTextPresent", pattern, null, null);
    }

    public void verifyTitle(String text) throws Throwable {
        runCommand("verifyTitle", text, null, null);
    }

    public void verifyTitleContain(String text) throws Throwable {
        runCommand("verifyTitleContain", text, null, null);
    }

    public void verifyTitleNotContain(String text) throws Throwable {
        runCommand("verifyTitleNotContain", text, null, null);
    }

    public void verifyValue(String locator, String text) throws Throwable {
        runCommand("verifyValue", locator, text, null);
    }

    public void verifyValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyValue", parentLocator, locator, text);
    }

    public void verifyValueContain(String locator, String text) throws Throwable {
        runCommand("verifyValueContain", locator, text, null);
    }

    public void verifyValueContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyValueContain", parentLocator, locator, text);
    }

    public void verifyValueEmpty(String locator) throws Throwable {
        runCommand("verifyValueEmpty", locator, null, null);
    }

    public void verifyValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("verifyValueEmpty", parentLocator, locator, null);
    }

    public void verifyValueNotContain(String locator, String text) throws Throwable {
        runCommand("verifyValueNotContain", locator, text, null);
    }

    public void verifyValueNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyValueNotContain", parentLocator, locator, text);
    }

    public void verifyVariable(String variable, String text) throws Throwable {
        runCommand("verifyVariable", variable, text, null);
    }

    public void verifyVariableContain(String variable, String text) throws Throwable {
        runCommand("verifyVariableContain", variable, text, null);
    }

    public void verifyVariableNotContain(String variable, String text) throws Throwable {
        runCommand("verifyVariableNotContain", variable, text, null);
    }

    public void verifyVisible(String locator) throws Throwable {
        runCommand("verifyVisible", locator, null, null);
    }

    public void verifyVisible(String parentLocator, String locator) throws Throwable {
        runCommand("verifyVisible", parentLocator, locator, null);
    }

    public void verifyXpathCount(String xpath, String text) throws Throwable {
        runCommand("verifyXpathCount", xpath, text, null);
    }

    public void waitForAlert(String text) throws Throwable {
        runCommand("waitForAlert", text, null, null);
    }

    public void waitForAlertContain(String text) throws Throwable {
        runCommand("waitForAlertContain", text, null, null);
    }

    public void waitForAlertNotContain(String text) throws Throwable {
        runCommand("waitForAlertNotContain", text, null, null);
    }

    public void waitForAlertNotPresent() throws Throwable {
        runCommand("waitForAlertNotPresent", null, null, null);
    }

    public void waitForAlertPresent() throws Throwable {
        runCommand("waitForAlertPresent", null, null, null);
    }

    public void waitForAllElementNotPresent(String locatorArray) throws Throwable {
        runCommand("waitForAllElementNotPresent", locatorArray, null, null);
    }

    public void waitForAllElementPresent(String locatorArray) throws Throwable {
        runCommand("waitForAllElementPresent", locatorArray, null, null);
    }

    public void waitForAllTextNotPresent(String textArray) throws Throwable {
        runCommand("waitForAllTextNotPresent", textArray, null, null);
    }

    public void waitForAllTextPresent(String textArray) throws Throwable {
        runCommand("waitForAllTextPresent", textArray, null, null);
    }

    public void waitForAnyElementNotPresent(String locatorArray) throws Throwable {
        runCommand("waitForAnyElementNotPresent", locatorArray, null, null);
    }

    public void waitForAnyElementPresent(String locatorArray) throws Throwable {
        runCommand("waitForAnyElementPresent", locatorArray, null, null);
    }

    public void waitForAnyTextNotPresent(String textArray) throws Throwable {
        runCommand("waitForAnyTextNotPresent", textArray, null, null);
    }

    public void waitForAnyTextPresent(String textArray) throws Throwable {
        runCommand("waitForAnyTextPresent", textArray, null, null);
    }

    public void waitForAttribute(String locator, String name, String text) throws Throwable {
        runCommand("waitForAttribute", locator, name, text);
    }

    public void waitForAttributeContain(String locator, String name, String text) throws Throwable {
        runCommand("waitForAttributeContain", locator, name, text);
    }

    public void waitForAttributeNotContain(String locator, String name, String text) throws Throwable {
        runCommand("waitForAttributeNotContain", locator, name, text);
    }

    public void waitForBodyText(String text) throws Throwable {
        runCommand("waitForBodyText", text, null, null);
    }

    public void waitForBodyTextContain(String text) throws Throwable {
        runCommand("waitForBodyTextContain", text, null, null);
    }

    public void waitForBodyTextNotContain(String text) throws Throwable {
        runCommand("waitForBodyTextNotContain", text, null, null);
    }

    public void waitForChecked(String locator) throws Throwable {
        runCommand("waitForChecked", locator, null, null);
    }

    public void waitForChecked(String parentLocator, String locator) throws Throwable {
        runCommand("waitForChecked", parentLocator, locator, null);
    }

    public void waitForCondition(String script, String timeout) throws Throwable {
        runCommand("waitForCondition", script, timeout, null);
    }

    public void waitForConfirmation(String text) throws Throwable {
        runCommand("waitForConfirmation", text, null, null);
    }

    public void waitForConfirmationContain(String text) throws Throwable {
        runCommand("waitForConfirmationContain", text, null, null);
    }

    public void waitForConfirmationNotContain(String text) throws Throwable {
        runCommand("waitForConfirmationNotContain", text, null, null);
    }

    public void waitForConfirmationNotPresent() throws Throwable {
        runCommand("waitForConfirmationNotPresent", null, null, null);
    }

    public void waitForConfirmationPresent() throws Throwable {
        runCommand("waitForConfirmationPresent", null, null, null);
    }

    public void waitForCookie(String text) throws Throwable {
        runCommand("waitForCookie", text, null, null);
    }

    public void waitForCookieByName(String name, String text) throws Throwable {
        runCommand("waitForCookieByName", name, text, null);
    }

    public void waitForCookieByNameContain(String name, String text) throws Throwable {
        runCommand("waitForCookieByNameContain", name, text, null);
    }

    public void waitForCookieByNameNotContain(String name, String text) throws Throwable {
        runCommand("waitForCookieByNameNotContain", name, text, null);
    }

    public void waitForCookieContain(String text) throws Throwable {
        runCommand("waitForCookieContain", text, null, null);
    }

    public void waitForCookieNotContain(String text) throws Throwable {
        runCommand("waitForCookieNotContain", text, null, null);
    }

    public void waitForCookieNotPresent(String name) throws Throwable {
        runCommand("waitForCookieNotPresent", name, null, null);
    }

    public void waitForCookiePresent(String name) throws Throwable {
        runCommand("waitForCookiePresent", name, null, null);
    }

    public void waitForEditable(String locator) throws Throwable {
        runCommand("waitForEditable", locator, null, null);
    }

    public void waitForEditable(String parentLocator, String locator) throws Throwable {
        runCommand("waitForEditable", parentLocator, locator, null);
    }

    public void waitForElementNotPresent(String locator) throws Throwable {
        runCommand("waitForElementNotPresent", locator, null, null);
    }

    public void waitForElementNotPresent(String parentLocator, String locator) throws Throwable {
        runCommand("waitForElementNotPresent", parentLocator, locator, null);
    }

    public void waitForElementPresent(String locator) throws Throwable {
        runCommand("waitForElementPresent", locator, null, null);
    }

    public void waitForElementPresent(String parentLocator, String locator) throws Throwable {
        runCommand("waitForElementPresent", parentLocator, locator, null);
    }

    public void waitForEval(String expression, String text) throws Throwable {
        runCommand("waitForEval", expression, text, null);
    }

    public void waitForEvalScript(String script, String text) throws Throwable {
        runCommand("waitForEvalScript", script, text, null);
    }

    public void waitForEvalScriptContain(String script, String text) throws Throwable {
        runCommand("waitForEvalScriptContain", script, text, null);
    }

    public void waitForEvalScriptNotContain(String script, String text) throws Throwable {
        runCommand("waitForEvalScriptNotContain", script, text, null);
    }

    public void waitForExistsInDatabase(String sql) throws Throwable {
        runCommand("waitForExistsInDatabase", sql, null, null);
    }

    public void waitForExpression(String expression, String text) throws Throwable {
        runCommand("waitForExpression", expression, text, null);
    }

    public void waitForExpressionContain(String expression, String text) throws Throwable {
        runCommand("waitForExpressionContain", expression, text, null);
    }

    public void waitForExpressionNotContain(String expression, String text) throws Throwable {
        runCommand("waitForExpressionNotContain", expression, text, null);
    }

    public void waitForHtmlSource(String text) throws Throwable {
        runCommand("waitForHtmlSource", text, null, null);
    }

    public void waitForHtmlSourceContain(String text) throws Throwable {
        runCommand("waitForHtmlSourceContain", text, null, null);
    }

    public void waitForHtmlSourceNotContain(String text) throws Throwable {
        runCommand("waitForHtmlSourceNotContain", text, null, null);
    }

    public void waitForLocation(String text) throws Throwable {
        runCommand("waitForLocation", text, null, null);
    }

    public void waitForLocationContain(String text) throws Throwable {
        runCommand("waitForLocationContain", text, null, null);
    }

    public void waitForLocationNotContain(String text) throws Throwable {
        runCommand("waitForLocationNotContain", text, null, null);
    }

    public void waitForNotAlert(String text) throws Throwable {
        runCommand("waitForNotAlert", text, null, null);
    }

    public void waitForNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("waitForNotAttribute", locator, name, text);
    }

    public void waitForNotBodyText(String text) throws Throwable {
        runCommand("waitForNotBodyText", text, null, null);
    }

    public void waitForNotChecked(String locator) throws Throwable {
        runCommand("waitForNotChecked", locator, null, null);
    }

    public void waitForNotChecked(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotChecked", parentLocator, locator, null);
    }

    public void waitForNotConfirmation(String text) throws Throwable {
        runCommand("waitForNotConfirmation", text, null, null);
    }

    public void waitForNotCookie(String text) throws Throwable {
        runCommand("waitForNotCookie", text, null, null);
    }

    public void waitForNotCookieByName(String name, String text) throws Throwable {
        runCommand("waitForNotCookieByName", name, text, null);
    }

    public void waitForNotEditable(String locator) throws Throwable {
        runCommand("waitForNotEditable", locator, null, null);
    }

    public void waitForNotEditable(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotEditable", parentLocator, locator, null);
    }

    public void waitForNotEval(String expression, String text) throws Throwable {
        runCommand("waitForNotEval", expression, text, null);
    }

    public void waitForNotEvalScript(String script, String text) throws Throwable {
        runCommand("waitForNotEvalScript", script, text, null);
    }

    public void waitForNotExistsInDatabase(String sql) throws Throwable {
        runCommand("waitForNotExistsInDatabase", sql, null, null);
    }

    public void waitForNotExpression(String expression, String text) throws Throwable {
        runCommand("waitForNotExpression", expression, text, null);
    }

    public void waitForNotHtmlSource(String text) throws Throwable {
        runCommand("waitForNotHtmlSource", text, null, null);
    }

    public void waitForNotLocation(String text) throws Throwable {
        runCommand("waitForNotLocation", text, null, null);
    }

    public void waitForNotPrompt(String text) throws Throwable {
        runCommand("waitForNotPrompt", text, null, null);
    }

    public void waitForNotSelectedId(String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedId", locator, text, null);
    }

    public void waitForNotSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedId", parentLocator, locator, text);
    }

    public void waitForNotSelectedIndex(String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedIndex", locator, text, null);
    }

    public void waitForNotSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedIndex", parentLocator, locator, text);
    }

    public void waitForNotSelectedLabel(String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedLabel", locator, text, null);
    }

    public void waitForNotSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedLabel", parentLocator, locator, text);
    }

    public void waitForNotSelectedValue(String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedValue", locator, text, null);
    }

    public void waitForNotSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotSelectedValue", parentLocator, locator, text);
    }

    public void waitForNotSomethingSelected(String locator) throws Throwable {
        runCommand("waitForNotSomethingSelected", locator, null, null);
    }

    public void waitForNotSomethingSelected(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotSomethingSelected", parentLocator, locator, null);
    }

    public void waitForNotTable(String locator, String cellAddress, String text) throws Throwable {
        runCommand("waitForNotTable", locator, cellAddress, text);
    }

    public void waitForNotText(String locator, String text) throws Throwable {
        runCommand("waitForNotText", locator, text, null);
    }

    public void waitForNotText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotText", parentLocator, locator, text);
    }

    public void waitForNotTextEmpty(String locator) throws Throwable {
        runCommand("waitForNotTextEmpty", locator, null, null);
    }

    public void waitForNotTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotTextEmpty", parentLocator, locator, null);
    }

    public void waitForNotTitle(String text) throws Throwable {
        runCommand("waitForNotTitle", text, null, null);
    }

    public void waitForNotValue(String locator, String text) throws Throwable {
        runCommand("waitForNotValue", locator, text, null);
    }

    public void waitForNotValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotValue", parentLocator, locator, text);
    }

    public void waitForNotValueEmpty(String locator) throws Throwable {
        runCommand("waitForNotValueEmpty", locator, null, null);
    }

    public void waitForNotValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotValueEmpty", parentLocator, locator, null);
    }

    public void waitForNotVisible(String locator) throws Throwable {
        runCommand("waitForNotVisible", locator, null, null);
    }

    public void waitForNotVisible(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotVisible", parentLocator, locator, null);
    }

    public void waitForPageToLoad(String timeout) throws Throwable {
        runCommand("waitForPageToLoad", timeout, null, null);
    }

    public void waitForPopUp(String windowID, String timeout) throws Throwable {
        runCommand("waitForPopUp", windowID, timeout, null);
    }

    public void waitForPrompt(String text) throws Throwable {
        runCommand("waitForPrompt", text, null, null);
    }

    public void waitForPromptContain(String text) throws Throwable {
        runCommand("waitForPromptContain", text, null, null);
    }

    public void waitForPromptNotContain(String text) throws Throwable {
        runCommand("waitForPromptNotContain", text, null, null);
    }

    public void waitForPromptNotPresent() throws Throwable {
        runCommand("waitForPromptNotPresent", null, null, null);
    }

    public void waitForPromptPresent() throws Throwable {
        runCommand("waitForPromptPresent", null, null, null);
    }

    public void waitForSelectedId(String locator, String text) throws Throwable {
        runCommand("waitForSelectedId", locator, text, null);
    }

    public void waitForSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedId", parentLocator, locator, text);
    }

    public void waitForSelectedIdContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdContain", locator, text, null);
    }

    public void waitForSelectedIdContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdContain", parentLocator, locator, text);
    }

    public void waitForSelectedIdNotContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdNotContain", locator, text, null);
    }

    public void waitForSelectedIdNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdNotContain", parentLocator, locator, text);
    }

    public void waitForSelectedIndex(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndex", locator, text, null);
    }

    public void waitForSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndex", parentLocator, locator, text);
    }

    public void waitForSelectedIndexContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexContain", locator, text, null);
    }

    public void waitForSelectedIndexContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexContain", parentLocator, locator, text);
    }

    public void waitForSelectedIndexNotContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexNotContain", locator, text, null);
    }

    public void waitForSelectedIndexNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexNotContain", parentLocator, locator, text);
    }

    public void waitForSelectedLabel(String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabel", locator, text, null);
    }

    public void waitForSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabel", parentLocator, locator, text);
    }

    public void waitForSelectedLabelContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelContain", locator, text, null);
    }

    public void waitForSelectedLabelContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelContain", parentLocator, locator, text);
    }

    public void waitForSelectedLabelNotContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelNotContain", locator, text, null);
    }

    public void waitForSelectedLabelNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelNotContain", parentLocator, locator, text);
    }

    public void waitForSelectedValue(String locator, String text) throws Throwable {
        runCommand("waitForSelectedValue", locator, text, null);
    }

    public void waitForSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedValue", parentLocator, locator, text);
    }

    public void waitForSelectedValueContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueContain", locator, text, null);
    }

    public void waitForSelectedValueContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueContain", parentLocator, locator, text);
    }

    public void waitForSelectedValueNotContain(String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueNotContain", locator, text, null);
    }

    public void waitForSelectedValueNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueNotContain", parentLocator, locator, text);
    }

    public void waitForSomethingSelected(String locator) throws Throwable {
        runCommand("waitForSomethingSelected", locator, null, null);
    }

    public void waitForSomethingSelected(String parentLocator, String locator) throws Throwable {
        runCommand("waitForSomethingSelected", parentLocator, locator, null);
    }

    public void waitForTable(String locator, String cellAddress, String text) throws Throwable {
        runCommand("waitForTable", locator, cellAddress, text);
    }

    public void waitForTableContain(String locator, String cellAddress, String text) throws Throwable {
        runCommand("waitForTableContain", locator, cellAddress, text);
    }

    public void waitForTableNotContain(String locator, String cellAddress, String text) throws Throwable {
        runCommand("waitForTableNotContain", locator, cellAddress, text);
    }

    public void waitForText(String locator, String text) throws Throwable {
        runCommand("waitForText", locator, text, null);
    }

    public void waitForText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForText", parentLocator, locator, text);
    }

    public void waitForTextContain(String locator, String text) throws Throwable {
        runCommand("waitForTextContain", locator, text, null);
    }

    public void waitForTextContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTextContain", parentLocator, locator, text);
    }

    public void waitForTextEmpty(String locator) throws Throwable {
        runCommand("waitForTextEmpty", locator, null, null);
    }

    public void waitForTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("waitForTextEmpty", parentLocator, locator, null);
    }

    public void waitForTextNotContain(String locator, String text) throws Throwable {
        runCommand("waitForTextNotContain", locator, text, null);
    }

    public void waitForTextNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTextNotContain", parentLocator, locator, text);
    }

    public void waitForTextNotPresent(String pattern) throws Throwable {
        runCommand("waitForTextNotPresent", pattern, null, null);
    }

    public void waitForTextPresent(String pattern) throws Throwable {
        runCommand("waitForTextPresent", pattern, null, null);
    }

    public void waitForTitle(String text) throws Throwable {
        runCommand("waitForTitle", text, null, null);
    }

    public void waitForTitleContain(String text) throws Throwable {
        runCommand("waitForTitleContain", text, null, null);
    }

    public void waitForTitleNotContain(String text) throws Throwable {
        runCommand("waitForTitleNotContain", text, null, null);
    }

    public void waitForValue(String locator, String text) throws Throwable {
        runCommand("waitForValue", locator, text, null);
    }

    public void waitForValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForValue", parentLocator, locator, text);
    }

    public void waitForValueContain(String locator, String text) throws Throwable {
        runCommand("waitForValueContain", locator, text, null);
    }

    public void waitForValueContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForValueContain", parentLocator, locator, text);
    }

    public void waitForValueEmpty(String locator) throws Throwable {
        runCommand("waitForValueEmpty", locator, null, null);
    }

    public void waitForValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("waitForValueEmpty", parentLocator, locator, null);
    }

    public void waitForValueNotContain(String locator, String text) throws Throwable {
        runCommand("waitForValueNotContain", locator, text, null);
    }

    public void waitForValueNotContain(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForValueNotContain", parentLocator, locator, text);
    }

    public void waitForVisible(String locator) throws Throwable {
        runCommand("waitForVisible", locator, null, null);
    }

    public void waitForVisible(String parentLocator, String locator) throws Throwable {
        runCommand("waitForVisible", parentLocator, locator, null);
    }

    public void windowFocus() throws Throwable {
        runCommand("windowFocus", null, null, null);
    }

    public void windowMaximize() throws Throwable {
        runCommand("windowMaximize", null, null, null);
    }

}
