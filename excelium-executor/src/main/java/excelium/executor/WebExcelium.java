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

    protected void setWebContext() {
        super.setWebContext();
    }

    protected void setNativeContext() {
        super.setNativeContext();
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

    public void assertAlertMatch(String text) throws Throwable {
        runCommand("assertAlertMatch", text, null, null);
    }

    public void assertAlertNotMatch(String text) throws Throwable {
        runCommand("assertAlertNotMatch", text, null, null);
    }

    public void assertAlertNotPresent() throws Throwable {
        runCommand("assertAlertNotPresent", null, null, null);
    }

    public void assertAlertPresent() throws Throwable {
        runCommand("assertAlertPresent", null, null, null);
    }

    public void assertAllButtons(String text) throws Throwable {
        runCommand("assertAllButtons", text, null, null);
    }

    public void assertAllButtonsMatch(String text) throws Throwable {
        runCommand("assertAllButtonsMatch", text, null, null);
    }

    public void assertAllButtonsNotMatch(String text) throws Throwable {
        runCommand("assertAllButtonsNotMatch", text, null, null);
    }

    public void assertAllFields(String text) throws Throwable {
        runCommand("assertAllFields", text, null, null);
    }

    public void assertAllFieldsMatch(String text) throws Throwable {
        runCommand("assertAllFieldsMatch", text, null, null);
    }

    public void assertAllFieldsNotMatch(String text) throws Throwable {
        runCommand("assertAllFieldsNotMatch", text, null, null);
    }

    public void assertAllLinks(String text) throws Throwable {
        runCommand("assertAllLinks", text, null, null);
    }

    public void assertAllLinksMatch(String text) throws Throwable {
        runCommand("assertAllLinksMatch", text, null, null);
    }

    public void assertAllLinksNotMatch(String text) throws Throwable {
        runCommand("assertAllLinksNotMatch", text, null, null);
    }

    public void assertAllWindowNames(String text) throws Throwable {
        runCommand("assertAllWindowNames", text, null, null);
    }

    public void assertAllWindowNamesMatch(String text) throws Throwable {
        runCommand("assertAllWindowNamesMatch", text, null, null);
    }

    public void assertAllWindowNamesNotMatch(String text) throws Throwable {
        runCommand("assertAllWindowNamesNotMatch", text, null, null);
    }

    public void assertAllWindowTitles(String text) throws Throwable {
        runCommand("assertAllWindowTitles", text, null, null);
    }

    public void assertAllWindowTitlesMatch(String text) throws Throwable {
        runCommand("assertAllWindowTitlesMatch", text, null, null);
    }

    public void assertAllWindowTitlesNotMatch(String text) throws Throwable {
        runCommand("assertAllWindowTitlesNotMatch", text, null, null);
    }

    public void assertAttribute(String locator, String name, String text) throws Throwable {
        runCommand("assertAttribute", locator, name, text);
    }

    public void assertAttributeFromAllWindows(String attributeName, String text) throws Throwable {
        runCommand("assertAttributeFromAllWindows", attributeName, text, null);
    }

    public void assertAttributeFromAllWindowsMatch(String attributeName, String text) throws Throwable {
        runCommand("assertAttributeFromAllWindowsMatch", attributeName, text, null);
    }

    public void assertAttributeFromAllWindowsNotMatch(String attributeName, String text) throws Throwable {
        runCommand("assertAttributeFromAllWindowsNotMatch", attributeName, text, null);
    }

    public void assertAttributeMatch(String locator, String name, String text) throws Throwable {
        runCommand("assertAttributeMatch", locator, name, text);
    }

    public void assertAttributeNotMatch(String locator, String name, String text) throws Throwable {
        runCommand("assertAttributeNotMatch", locator, name, text);
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

    public void assertBodyTextMatch(String text) throws Throwable {
        runCommand("assertBodyTextMatch", text, null, null);
    }

    public void assertBodyTextNotMatch(String text) throws Throwable {
        runCommand("assertBodyTextNotMatch", text, null, null);
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

    public void assertConfirmationMatch(String text) throws Throwable {
        runCommand("assertConfirmationMatch", text, null, null);
    }

    public void assertConfirmationNotMatch(String text) throws Throwable {
        runCommand("assertConfirmationNotMatch", text, null, null);
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

    public void assertCookieByNameMatch(String name, String text) throws Throwable {
        runCommand("assertCookieByNameMatch", name, text, null);
    }

    public void assertCookieByNameNotMatch(String name, String text) throws Throwable {
        runCommand("assertCookieByNameNotMatch", name, text, null);
    }

    public void assertCookieMatch(String text) throws Throwable {
        runCommand("assertCookieMatch", text, null, null);
    }

    public void assertCookieNotMatch(String text) throws Throwable {
        runCommand("assertCookieNotMatch", text, null, null);
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

    public void assertEnabled(String locator) throws Throwable {
        runCommand("assertEnabled", locator, null, null);
    }

    public void assertEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("assertEnabled", parentLocator, locator, null);
    }

    public void assertEval(String expression, String text) throws Throwable {
        runCommand("assertEval", expression, text, null);
    }

    public void assertEvalScript(String script, String text) throws Throwable {
        runCommand("assertEvalScript", script, text, null);
    }

    public void assertEvalScriptMatch(String script, String text) throws Throwable {
        runCommand("assertEvalScriptMatch", script, text, null);
    }

    public void assertEvalScriptNotMatch(String script, String text) throws Throwable {
        runCommand("assertEvalScriptNotMatch", script, text, null);
    }

    public void assertExistsInDatabase(String sql) throws Throwable {
        runCommand("assertExistsInDatabase", sql, null, null);
    }

    public void assertExpression(String expression, String text) throws Throwable {
        runCommand("assertExpression", expression, text, null);
    }

    public void assertExpressionMatch(String expression, String text) throws Throwable {
        runCommand("assertExpressionMatch", expression, text, null);
    }

    public void assertExpressionNotMatch(String expression, String text) throws Throwable {
        runCommand("assertExpressionNotMatch", expression, text, null);
    }

    public void assertFileContainLine(String filePattern, String charset, String text) throws Throwable {
        runCommand("assertFileContainLine", filePattern, charset, text);
    }

    public void assertFileDownloaded(String filePattern) throws Throwable {
        runCommand("assertFileDownloaded", filePattern, null, null);
    }

    public void assertFileFirstLine(String filePattern, String charset, String text) throws Throwable {
        runCommand("assertFileFirstLine", filePattern, charset, text);
    }

    public void assertFontFamily(String locator, String text) throws Throwable {
        runCommand("assertFontFamily", locator, text, null);
    }

    public void assertFontFamily(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontFamily", parentLocator, locator, text);
    }

    public void assertFontFamilyMatch(String locator, String text) throws Throwable {
        runCommand("assertFontFamilyMatch", locator, text, null);
    }

    public void assertFontFamilyMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontFamilyMatch", parentLocator, locator, text);
    }

    public void assertFontFamilyNotMatch(String locator, String text) throws Throwable {
        runCommand("assertFontFamilyNotMatch", locator, text, null);
    }

    public void assertFontFamilyNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontFamilyNotMatch", parentLocator, locator, text);
    }

    public void assertFontSize(String locator, String text) throws Throwable {
        runCommand("assertFontSize", locator, text, null);
    }

    public void assertFontSize(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontSize", parentLocator, locator, text);
    }

    public void assertFontSizeMatch(String locator, String text) throws Throwable {
        runCommand("assertFontSizeMatch", locator, text, null);
    }

    public void assertFontSizeMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontSizeMatch", parentLocator, locator, text);
    }

    public void assertFontSizeNotMatch(String locator, String text) throws Throwable {
        runCommand("assertFontSizeNotMatch", locator, text, null);
    }

    public void assertFontSizeNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontSizeNotMatch", parentLocator, locator, text);
    }

    public void assertFontStyle(String locator, String text) throws Throwable {
        runCommand("assertFontStyle", locator, text, null);
    }

    public void assertFontStyle(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontStyle", parentLocator, locator, text);
    }

    public void assertFontStyleMatch(String locator, String text) throws Throwable {
        runCommand("assertFontStyleMatch", locator, text, null);
    }

    public void assertFontStyleMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontStyleMatch", parentLocator, locator, text);
    }

    public void assertFontStyleNotMatch(String locator, String text) throws Throwable {
        runCommand("assertFontStyleNotMatch", locator, text, null);
    }

    public void assertFontStyleNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontStyleNotMatch", parentLocator, locator, text);
    }

    public void assertFontWeight(String locator, String text) throws Throwable {
        runCommand("assertFontWeight", locator, text, null);
    }

    public void assertFontWeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontWeight", parentLocator, locator, text);
    }

    public void assertFontWeightMatch(String locator, String text) throws Throwable {
        runCommand("assertFontWeightMatch", locator, text, null);
    }

    public void assertFontWeightMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontWeightMatch", parentLocator, locator, text);
    }

    public void assertFontWeightNotMatch(String locator, String text) throws Throwable {
        runCommand("assertFontWeightNotMatch", locator, text, null);
    }

    public void assertFontWeightNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertFontWeightNotMatch", parentLocator, locator, text);
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

    public void assertLocationMatch(String text) throws Throwable {
        runCommand("assertLocationMatch", text, null, null);
    }

    public void assertLocationNotMatch(String text) throws Throwable {
        runCommand("assertLocationNotMatch", text, null, null);
    }

    public void assertLogContainLine(String text) throws Throwable {
        runCommand("assertLogContainLine", text, null, null);
    }

    public void assertLogNotContainLine(String text) throws Throwable {
        runCommand("assertLogNotContainLine", text, null, null);
    }

    public void assertNotAlert(String text) throws Throwable {
        runCommand("assertNotAlert", text, null, null);
    }

    public void assertNotAllButtons(String text) throws Throwable {
        runCommand("assertNotAllButtons", text, null, null);
    }

    public void assertNotAllFields(String text) throws Throwable {
        runCommand("assertNotAllFields", text, null, null);
    }

    public void assertNotAllLinks(String text) throws Throwable {
        runCommand("assertNotAllLinks", text, null, null);
    }

    public void assertNotAllWindowNames(String text) throws Throwable {
        runCommand("assertNotAllWindowNames", text, null, null);
    }

    public void assertNotAllWindowTitles(String text) throws Throwable {
        runCommand("assertNotAllWindowTitles", text, null, null);
    }

    public void assertNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("assertNotAttribute", locator, name, text);
    }

    public void assertNotAttributeFromAllWindows(String attributeName, String text) throws Throwable {
        runCommand("assertNotAttributeFromAllWindows", attributeName, text, null);
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

    public void assertNotEnabled(String locator) throws Throwable {
        runCommand("assertNotEnabled", locator, null, null);
    }

    public void assertNotEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotEnabled", parentLocator, locator, null);
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

    public void assertNotFileDownloaded(String filePattern) throws Throwable {
        runCommand("assertNotFileDownloaded", filePattern, null, null);
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

    public void assertNotLocation(String text) throws Throwable {
        runCommand("assertNotLocation", text, null, null);
    }

    public void assertNotOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("assertNotOrdered", firstLocator, secondLocator, null);
    }

    public void assertNotPageSource(String text) throws Throwable {
        runCommand("assertNotPageSource", text, null, null);
    }

    public void assertNotPrompt(String text) throws Throwable {
        runCommand("assertNotPrompt", text, null, null);
    }

    public void assertNotQR(String locator, String text) throws Throwable {
        runCommand("assertNotQR", locator, text, null);
    }

    public void assertNotQR(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotQR", parentLocator, locator, text);
    }

    public void assertNotSelectOptions(String locator, String text) throws Throwable {
        runCommand("assertNotSelectOptions", locator, text, null);
    }

    public void assertNotSelectOptions(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectOptions", parentLocator, locator, text);
    }

    public void assertNotSelectedId(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedId", locator, text, null);
    }

    public void assertNotSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedId", parentLocator, locator, text);
    }

    public void assertNotSelectedIds(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIds", locator, text, null);
    }

    public void assertNotSelectedIds(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIds", parentLocator, locator, text);
    }

    public void assertNotSelectedIndex(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIndex", locator, text, null);
    }

    public void assertNotSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIndex", parentLocator, locator, text);
    }

    public void assertNotSelectedIndexes(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIndexes", locator, text, null);
    }

    public void assertNotSelectedIndexes(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedIndexes", parentLocator, locator, text);
    }

    public void assertNotSelectedLabel(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedLabel", locator, text, null);
    }

    public void assertNotSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedLabel", parentLocator, locator, text);
    }

    public void assertNotSelectedLabels(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedLabels", locator, text, null);
    }

    public void assertNotSelectedLabels(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedLabels", parentLocator, locator, text);
    }

    public void assertNotSelectedValue(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedValue", locator, text, null);
    }

    public void assertNotSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedValue", parentLocator, locator, text);
    }

    public void assertNotSelectedValues(String locator, String text) throws Throwable {
        runCommand("assertNotSelectedValues", locator, text, null);
    }

    public void assertNotSelectedValues(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotSelectedValues", parentLocator, locator, text);
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

    public void assertNotTagName(String locator, String text) throws Throwable {
        runCommand("assertNotTagName", locator, text, null);
    }

    public void assertNotTagName(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotTagName", parentLocator, locator, text);
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

    public void assertNotWindowCount(String text) throws Throwable {
        runCommand("assertNotWindowCount", text, null, null);
    }

    public void assertNotWindowHandle(String text) throws Throwable {
        runCommand("assertNotWindowHandle", text, null, null);
    }

    public void assertNotXpathCount(String xpath, String text) throws Throwable {
        runCommand("assertNotXpathCount", xpath, text, null);
    }

    public void assertOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("assertOrdered", firstLocator, secondLocator, null);
    }

    public void assertPageSource(String text) throws Throwable {
        runCommand("assertPageSource", text, null, null);
    }

    public void assertPageSourceMatch(String text) throws Throwable {
        runCommand("assertPageSourceMatch", text, null, null);
    }

    public void assertPageSourceNotMatch(String text) throws Throwable {
        runCommand("assertPageSourceNotMatch", text, null, null);
    }

    public void assertPrompt(String text) throws Throwable {
        runCommand("assertPrompt", text, null, null);
    }

    public void assertPromptMatch(String text) throws Throwable {
        runCommand("assertPromptMatch", text, null, null);
    }

    public void assertPromptNotMatch(String text) throws Throwable {
        runCommand("assertPromptNotMatch", text, null, null);
    }

    public void assertPromptNotPresent() throws Throwable {
        runCommand("assertPromptNotPresent", null, null, null);
    }

    public void assertPromptPresent() throws Throwable {
        runCommand("assertPromptPresent", null, null, null);
    }

    public void assertQR(String locator, String text) throws Throwable {
        runCommand("assertQR", locator, text, null);
    }

    public void assertQR(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertQR", parentLocator, locator, text);
    }

    public void assertQRMatch(String locator, String text) throws Throwable {
        runCommand("assertQRMatch", locator, text, null);
    }

    public void assertQRMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertQRMatch", parentLocator, locator, text);
    }

    public void assertQRNotMatch(String locator, String text) throws Throwable {
        runCommand("assertQRNotMatch", locator, text, null);
    }

    public void assertQRNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertQRNotMatch", parentLocator, locator, text);
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

    public void assertSelectOptions(String locator, String text) throws Throwable {
        runCommand("assertSelectOptions", locator, text, null);
    }

    public void assertSelectOptions(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectOptions", parentLocator, locator, text);
    }

    public void assertSelectOptionsMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectOptionsMatch", locator, text, null);
    }

    public void assertSelectOptionsMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectOptionsMatch", parentLocator, locator, text);
    }

    public void assertSelectOptionsNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectOptionsNotMatch", locator, text, null);
    }

    public void assertSelectOptionsNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectOptionsNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedId(String locator, String text) throws Throwable {
        runCommand("assertSelectedId", locator, text, null);
    }

    public void assertSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedId", parentLocator, locator, text);
    }

    public void assertSelectedIdMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIdMatch", locator, text, null);
    }

    public void assertSelectedIdMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIdMatch", parentLocator, locator, text);
    }

    public void assertSelectedIdNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIdNotMatch", locator, text, null);
    }

    public void assertSelectedIdNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIdNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedIds(String locator, String text) throws Throwable {
        runCommand("assertSelectedIds", locator, text, null);
    }

    public void assertSelectedIds(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIds", parentLocator, locator, text);
    }

    public void assertSelectedIdsMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIdsMatch", locator, text, null);
    }

    public void assertSelectedIdsMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIdsMatch", parentLocator, locator, text);
    }

    public void assertSelectedIdsNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIdsNotMatch", locator, text, null);
    }

    public void assertSelectedIdsNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIdsNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedIndex(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndex", locator, text, null);
    }

    public void assertSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndex", parentLocator, locator, text);
    }

    public void assertSelectedIndexMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexMatch", locator, text, null);
    }

    public void assertSelectedIndexMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexMatch", parentLocator, locator, text);
    }

    public void assertSelectedIndexNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexNotMatch", locator, text, null);
    }

    public void assertSelectedIndexNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedIndexes(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexes", locator, text, null);
    }

    public void assertSelectedIndexes(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexes", parentLocator, locator, text);
    }

    public void assertSelectedIndexesMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexesMatch", locator, text, null);
    }

    public void assertSelectedIndexesMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexesMatch", parentLocator, locator, text);
    }

    public void assertSelectedIndexesNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexesNotMatch", locator, text, null);
    }

    public void assertSelectedIndexesNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedIndexesNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedLabel(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabel", locator, text, null);
    }

    public void assertSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabel", parentLocator, locator, text);
    }

    public void assertSelectedLabelMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelMatch", locator, text, null);
    }

    public void assertSelectedLabelMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelMatch", parentLocator, locator, text);
    }

    public void assertSelectedLabelNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelNotMatch", locator, text, null);
    }

    public void assertSelectedLabelNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedLabels(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabels", locator, text, null);
    }

    public void assertSelectedLabels(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabels", parentLocator, locator, text);
    }

    public void assertSelectedLabelsMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelsMatch", locator, text, null);
    }

    public void assertSelectedLabelsMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelsMatch", parentLocator, locator, text);
    }

    public void assertSelectedLabelsNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelsNotMatch", locator, text, null);
    }

    public void assertSelectedLabelsNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedLabelsNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedValue(String locator, String text) throws Throwable {
        runCommand("assertSelectedValue", locator, text, null);
    }

    public void assertSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValue", parentLocator, locator, text);
    }

    public void assertSelectedValueMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedValueMatch", locator, text, null);
    }

    public void assertSelectedValueMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValueMatch", parentLocator, locator, text);
    }

    public void assertSelectedValueNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedValueNotMatch", locator, text, null);
    }

    public void assertSelectedValueNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValueNotMatch", parentLocator, locator, text);
    }

    public void assertSelectedValues(String locator, String text) throws Throwable {
        runCommand("assertSelectedValues", locator, text, null);
    }

    public void assertSelectedValues(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValues", parentLocator, locator, text);
    }

    public void assertSelectedValuesMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedValuesMatch", locator, text, null);
    }

    public void assertSelectedValuesMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValuesMatch", parentLocator, locator, text);
    }

    public void assertSelectedValuesNotMatch(String locator, String text) throws Throwable {
        runCommand("assertSelectedValuesNotMatch", locator, text, null);
    }

    public void assertSelectedValuesNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertSelectedValuesNotMatch", parentLocator, locator, text);
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

    public void assertTableMatch(String locator, String cellAddress, String text) throws Throwable {
        runCommand("assertTableMatch", locator, cellAddress, text);
    }

    public void assertTableNotMatch(String locator, String cellAddress, String text) throws Throwable {
        runCommand("assertTableNotMatch", locator, cellAddress, text);
    }

    public void assertTagName(String locator, String text) throws Throwable {
        runCommand("assertTagName", locator, text, null);
    }

    public void assertTagName(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTagName", parentLocator, locator, text);
    }

    public void assertTagNameMatch(String locator, String text) throws Throwable {
        runCommand("assertTagNameMatch", locator, text, null);
    }

    public void assertTagNameMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTagNameMatch", parentLocator, locator, text);
    }

    public void assertTagNameNotMatch(String locator, String text) throws Throwable {
        runCommand("assertTagNameNotMatch", locator, text, null);
    }

    public void assertTagNameNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTagNameNotMatch", parentLocator, locator, text);
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

    public void assertTextAlignmentMatch(String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentMatch", locator, text, null);
    }

    public void assertTextAlignmentMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentMatch", parentLocator, locator, text);
    }

    public void assertTextAlignmentNotMatch(String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentNotMatch", locator, text, null);
    }

    public void assertTextAlignmentNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextAlignmentNotMatch", parentLocator, locator, text);
    }

    public void assertTextDecoration(String locator, String text) throws Throwable {
        runCommand("assertTextDecoration", locator, text, null);
    }

    public void assertTextDecoration(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextDecoration", parentLocator, locator, text);
    }

    public void assertTextDecorationMatch(String locator, String text) throws Throwable {
        runCommand("assertTextDecorationMatch", locator, text, null);
    }

    public void assertTextDecorationMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextDecorationMatch", parentLocator, locator, text);
    }

    public void assertTextDecorationNotMatch(String locator, String text) throws Throwable {
        runCommand("assertTextDecorationNotMatch", locator, text, null);
    }

    public void assertTextDecorationNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextDecorationNotMatch", parentLocator, locator, text);
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

    public void assertTextMatch(String locator, String text) throws Throwable {
        runCommand("assertTextMatch", locator, text, null);
    }

    public void assertTextMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextMatch", parentLocator, locator, text);
    }

    public void assertTextNotMatch(String locator, String text) throws Throwable {
        runCommand("assertTextNotMatch", locator, text, null);
    }

    public void assertTextNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertTextNotMatch", parentLocator, locator, text);
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

    public void assertTitleMatch(String text) throws Throwable {
        runCommand("assertTitleMatch", text, null, null);
    }

    public void assertTitleNotMatch(String text) throws Throwable {
        runCommand("assertTitleNotMatch", text, null, null);
    }

    public void assertValue(String locator, String text) throws Throwable {
        runCommand("assertValue", locator, text, null);
    }

    public void assertValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertValue", parentLocator, locator, text);
    }

    public void assertValueEmpty(String locator) throws Throwable {
        runCommand("assertValueEmpty", locator, null, null);
    }

    public void assertValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("assertValueEmpty", parentLocator, locator, null);
    }

    public void assertValueMatch(String locator, String text) throws Throwable {
        runCommand("assertValueMatch", locator, text, null);
    }

    public void assertValueMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertValueMatch", parentLocator, locator, text);
    }

    public void assertValueNotMatch(String locator, String text) throws Throwable {
        runCommand("assertValueNotMatch", locator, text, null);
    }

    public void assertValueNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertValueNotMatch", parentLocator, locator, text);
    }

    public void assertVariable(String variable, String text) throws Throwable {
        runCommand("assertVariable", variable, text, null);
    }

    public void assertVisible(String locator) throws Throwable {
        runCommand("assertVisible", locator, null, null);
    }

    public void assertVisible(String parentLocator, String locator) throws Throwable {
        runCommand("assertVisible", parentLocator, locator, null);
    }

    public void assertWindowCount(String text) throws Throwable {
        runCommand("assertWindowCount", text, null, null);
    }

    public void assertWindowHandle(String text) throws Throwable {
        runCommand("assertWindowHandle", text, null, null);
    }

    public void assertWindowHandleMatch(String text) throws Throwable {
        runCommand("assertWindowHandleMatch", text, null, null);
    }

    public void assertWindowHandleNotMatch(String text) throws Throwable {
        runCommand("assertWindowHandleNotMatch", text, null, null);
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

    public void attachFile(String locator, String filePath) throws Throwable {
        runCommand("attachFile", locator, filePath, null);
    }

    public void attachFile(String parentLocator, String locator, String filePath) throws Throwable {
        runCommand("attachFile", parentLocator, locator, filePath);
    }

    public void blur(String locator) throws Throwable {
        runCommand("blur", locator, null, null);
    }

    public void blur(String parentLocator, String locator) throws Throwable {
        runCommand("blur", parentLocator, locator, null);
    }

    public void captureElementScreenshot(String locator) throws Throwable {
        runCommand("captureElementScreenshot", locator, null, null);
    }

    public void captureElementScreenshot(String parentLocator, String locator) throws Throwable {
        runCommand("captureElementScreenshot", parentLocator, locator, null);
    }

    public void captureScreenshot() throws Throwable {
        runCommand("captureScreenshot", null, null, null);
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

    public void cleanDriver() throws Throwable {
        runCommand("cleanDriver", null, null, null);
    }

    public void clear(String locator) throws Throwable {
        runCommand("clear", locator, null, null);
    }

    public void clear(String parentLocator, String locator) throws Throwable {
        runCommand("clear", parentLocator, locator, null);
    }

    public void clearLog() throws Throwable {
        runCommand("clearLog", null, null, null);
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

    public void clickButton(String indexOrText) throws Throwable {
        runCommand("clickButton", indexOrText, null, null);
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

    public void createCookie(String nameValuePair) throws Throwable {
        runCommand("createCookie", nameValuePair, null, null);
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

    public void deleteDownloadedFile(String filePattern) throws Throwable {
        runCommand("deleteDownloadedFile", filePattern, null, null);
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

    public void executeIfAlertMatch(String action, String text) throws Throwable {
        runCommand("executeIfAlertMatch", action, text, null);
    }

    public void executeIfAlertNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfAlertNotMatch", action, text, null);
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

    public void executeIfBodyTextMatch(String action, String text) throws Throwable {
        runCommand("executeIfBodyTextMatch", action, text, null);
    }

    public void executeIfBodyTextNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfBodyTextNotMatch", action, text, null);
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

    public void executeIfConfirmationMatch(String action, String text) throws Throwable {
        runCommand("executeIfConfirmationMatch", action, text, null);
    }

    public void executeIfConfirmationNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfConfirmationNotMatch", action, text, null);
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

    public void executeIfCookieByNameMatch(String action, String name, String text) throws Throwable {
        runCommand("executeIfCookieByNameMatch", action, name, text);
    }

    public void executeIfCookieByNameNotMatch(String action, String name, String text) throws Throwable {
        runCommand("executeIfCookieByNameNotMatch", action, name, text);
    }

    public void executeIfCookieMatch(String action, String text) throws Throwable {
        runCommand("executeIfCookieMatch", action, text, null);
    }

    public void executeIfCookieNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfCookieNotMatch", action, text, null);
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

    public void executeIfEnabled(String action, String locator) throws Throwable {
        runCommand("executeIfEnabled", action, locator, null);
    }

    public void executeIfEnabled(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfEnabled", action, parentLocator, locator);
    }

    public void executeIfEval(String action, String expression, String text) throws Throwable {
        runCommand("executeIfEval", action, expression, text);
    }

    public void executeIfEvalScript(String action, String script, String text) throws Throwable {
        runCommand("executeIfEvalScript", action, script, text);
    }

    public void executeIfEvalScriptMatch(String action, String script, String text) throws Throwable {
        runCommand("executeIfEvalScriptMatch", action, script, text);
    }

    public void executeIfEvalScriptNotMatch(String action, String script, String text) throws Throwable {
        runCommand("executeIfEvalScriptNotMatch", action, script, text);
    }

    public void executeIfExistsInDatabase(String action, String sql) throws Throwable {
        runCommand("executeIfExistsInDatabase", action, sql, null);
    }

    public void executeIfExpression(String action, String expression, String text) throws Throwable {
        runCommand("executeIfExpression", action, expression, text);
    }

    public void executeIfExpressionMatch(String action, String expression, String text) throws Throwable {
        runCommand("executeIfExpressionMatch", action, expression, text);
    }

    public void executeIfExpressionNotMatch(String action, String expression, String text) throws Throwable {
        runCommand("executeIfExpressionNotMatch", action, expression, text);
    }

    public void executeIfFileDownloaded(String action, String filePattern) throws Throwable {
        runCommand("executeIfFileDownloaded", action, filePattern, null);
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

    public void executeIfLocationMatch(String action, String text) throws Throwable {
        runCommand("executeIfLocationMatch", action, text, null);
    }

    public void executeIfLocationNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfLocationNotMatch", action, text, null);
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

    public void executeIfNotEnabled(String action, String locator) throws Throwable {
        runCommand("executeIfNotEnabled", action, locator, null);
    }

    public void executeIfNotEnabled(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotEnabled", action, parentLocator, locator);
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

    public void executeIfNotFileDownloaded(String action, String filePattern) throws Throwable {
        runCommand("executeIfNotFileDownloaded", action, filePattern, null);
    }

    public void executeIfNotLocation(String action, String text) throws Throwable {
        runCommand("executeIfNotLocation", action, text, null);
    }

    public void executeIfNotPageSource(String action, String text) throws Throwable {
        runCommand("executeIfNotPageSource", action, text, null);
    }

    public void executeIfNotPrompt(String action, String text) throws Throwable {
        runCommand("executeIfNotPrompt", action, text, null);
    }

    public void executeIfNotQR(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotQR", action, locator, text);
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

    public void executeIfNotTagName(String action, String locator, String text) throws Throwable {
        runCommand("executeIfNotTagName", action, locator, text);
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

    public void executeIfNotWindowCount(String action, String text) throws Throwable {
        runCommand("executeIfNotWindowCount", action, text, null);
    }

    public void executeIfNotWindowHandle(String action, String text) throws Throwable {
        runCommand("executeIfNotWindowHandle", action, text, null);
    }

    public void executeIfPageSource(String action, String text) throws Throwable {
        runCommand("executeIfPageSource", action, text, null);
    }

    public void executeIfPageSourceMatch(String action, String text) throws Throwable {
        runCommand("executeIfPageSourceMatch", action, text, null);
    }

    public void executeIfPageSourceNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfPageSourceNotMatch", action, text, null);
    }

    public void executeIfPrompt(String action, String text) throws Throwable {
        runCommand("executeIfPrompt", action, text, null);
    }

    public void executeIfPromptMatch(String action, String text) throws Throwable {
        runCommand("executeIfPromptMatch", action, text, null);
    }

    public void executeIfPromptNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfPromptNotMatch", action, text, null);
    }

    public void executeIfPromptNotPresent(String action) throws Throwable {
        runCommand("executeIfPromptNotPresent", action, null, null);
    }

    public void executeIfPromptPresent(String action) throws Throwable {
        runCommand("executeIfPromptPresent", action, null, null);
    }

    public void executeIfQR(String action, String locator, String text) throws Throwable {
        runCommand("executeIfQR", action, locator, text);
    }

    public void executeIfQRMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfQRMatch", action, locator, text);
    }

    public void executeIfQRNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfQRNotMatch", action, locator, text);
    }

    public void executeIfSelectedId(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedId", action, locator, text);
    }

    public void executeIfSelectedIdMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIdMatch", action, locator, text);
    }

    public void executeIfSelectedIdNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIdNotMatch", action, locator, text);
    }

    public void executeIfSelectedIndex(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIndex", action, locator, text);
    }

    public void executeIfSelectedIndexMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIndexMatch", action, locator, text);
    }

    public void executeIfSelectedIndexNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedIndexNotMatch", action, locator, text);
    }

    public void executeIfSelectedLabel(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedLabel", action, locator, text);
    }

    public void executeIfSelectedLabelMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedLabelMatch", action, locator, text);
    }

    public void executeIfSelectedLabelNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedLabelNotMatch", action, locator, text);
    }

    public void executeIfSelectedValue(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedValue", action, locator, text);
    }

    public void executeIfSelectedValueMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedValueMatch", action, locator, text);
    }

    public void executeIfSelectedValueNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfSelectedValueNotMatch", action, locator, text);
    }

    public void executeIfSomethingSelected(String action, String locator) throws Throwable {
        runCommand("executeIfSomethingSelected", action, locator, null);
    }

    public void executeIfSomethingSelected(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfSomethingSelected", action, parentLocator, locator);
    }

    public void executeIfTagName(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTagName", action, locator, text);
    }

    public void executeIfTagNameMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTagNameMatch", action, locator, text);
    }

    public void executeIfTagNameNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTagNameNotMatch", action, locator, text);
    }

    public void executeIfText(String action, String locator, String text) throws Throwable {
        runCommand("executeIfText", action, locator, text);
    }

    public void executeIfTextEmpty(String action, String locator) throws Throwable {
        runCommand("executeIfTextEmpty", action, locator, null);
    }

    public void executeIfTextEmpty(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfTextEmpty", action, parentLocator, locator);
    }

    public void executeIfTextMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTextMatch", action, locator, text);
    }

    public void executeIfTextNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfTextNotMatch", action, locator, text);
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

    public void executeIfTitleMatch(String action, String text) throws Throwable {
        runCommand("executeIfTitleMatch", action, text, null);
    }

    public void executeIfTitleNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfTitleNotMatch", action, text, null);
    }

    public void executeIfValue(String action, String locator, String text) throws Throwable {
        runCommand("executeIfValue", action, locator, text);
    }

    public void executeIfValueEmpty(String action, String locator) throws Throwable {
        runCommand("executeIfValueEmpty", action, locator, null);
    }

    public void executeIfValueEmpty(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfValueEmpty", action, parentLocator, locator);
    }

    public void executeIfValueMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfValueMatch", action, locator, text);
    }

    public void executeIfValueNotMatch(String action, String locator, String text) throws Throwable {
        runCommand("executeIfValueNotMatch", action, locator, text);
    }

    public void executeIfVariable(String action, String variable, String text) throws Throwable {
        runCommand("executeIfVariable", action, variable, text);
    }

    public void executeIfVisible(String action, String locator) throws Throwable {
        runCommand("executeIfVisible", action, locator, null);
    }

    public void executeIfVisible(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfVisible", action, parentLocator, locator);
    }

    public void executeIfWindowCount(String action, String text) throws Throwable {
        runCommand("executeIfWindowCount", action, text, null);
    }

    public void executeIfWindowHandle(String action, String text) throws Throwable {
        runCommand("executeIfWindowHandle", action, text, null);
    }

    public void executeIfWindowHandleMatch(String action, String text) throws Throwable {
        runCommand("executeIfWindowHandleMatch", action, text, null);
    }

    public void executeIfWindowHandleNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfWindowHandleNotMatch", action, text, null);
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

    public void keyPress(String keycode) throws Throwable {
        runCommand("keyPress", keycode, null, null);
    }

    public void keyPress(String locator, String keySequence) throws Throwable {
        runCommand("keyPress", locator, keySequence, null);
    }

    public void keyPress(String parentLocator, String locator, String keySequence) throws Throwable {
        runCommand("keyPress", parentLocator, locator, keySequence);
    }

    public void keyUp(String keycode) throws Throwable {
        runCommand("keyUp", keycode, null, null);
    }

    public void keyUp(String locator, String keySequence) throws Throwable {
        runCommand("keyUp", locator, keySequence, null);
    }

    public void keyUp(String parentLocator, String locator, String keySequence) throws Throwable {
        runCommand("keyUp", parentLocator, locator, keySequence);
    }

    public void landscape() throws Throwable {
        runCommand("landscape", null, null, null);
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

    public void openWindow(String url) throws Throwable {
        runCommand("openWindow", url, null, null);
    }

    public void openWindow(String url, String windowID) throws Throwable {
        runCommand("openWindow", url, windowID, null);
    }

    public void pause(String waitTime) throws Throwable {
        runCommand("pause", waitTime, null, null);
    }

    public void pinch(String scale) throws Throwable {
        runCommand("pinch", scale, null, null);
    }

    public void pinch(String locator, String scale) throws Throwable {
        runCommand("pinch", locator, scale, null);
    }

    public void pinch(String parentLocator, String locator, String scale) throws Throwable {
        runCommand("pinch", parentLocator, locator, scale);
    }

    public void portrait() throws Throwable {
        runCommand("portrait", null, null, null);
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

    public void rotate(String rotation) throws Throwable {
        runCommand("rotate", rotation, null, null);
    }

    public void runScript(String script) throws Throwable {
        runCommand("runScript", script, null, null);
    }

    public void scrollDown() throws Throwable {
        runCommand("scrollDown", null, null, null);
    }

    public void scrollDown(String locator) throws Throwable {
        runCommand("scrollDown", locator, null, null);
    }

    public void scrollDown(String parentLocator, String locator) throws Throwable {
        runCommand("scrollDown", parentLocator, locator, null);
    }

    public void scrollDownTo(String locator) throws Throwable {
        runCommand("scrollDownTo", locator, null, null);
    }

    public void scrollDownTo(String parentLocator, String locator) throws Throwable {
        runCommand("scrollDownTo", parentLocator, locator, null);
    }

    public void scrollLeft() throws Throwable {
        runCommand("scrollLeft", null, null, null);
    }

    public void scrollLeft(String locator) throws Throwable {
        runCommand("scrollLeft", locator, null, null);
    }

    public void scrollLeft(String parentLocator, String locator) throws Throwable {
        runCommand("scrollLeft", parentLocator, locator, null);
    }

    public void scrollLeftTo(String locator) throws Throwable {
        runCommand("scrollLeftTo", locator, null, null);
    }

    public void scrollLeftTo(String parentLocator, String locator) throws Throwable {
        runCommand("scrollLeftTo", parentLocator, locator, null);
    }

    public void scrollRight() throws Throwable {
        runCommand("scrollRight", null, null, null);
    }

    public void scrollRight(String locator) throws Throwable {
        runCommand("scrollRight", locator, null, null);
    }

    public void scrollRight(String parentLocator, String locator) throws Throwable {
        runCommand("scrollRight", parentLocator, locator, null);
    }

    public void scrollRightTo(String locator) throws Throwable {
        runCommand("scrollRightTo", locator, null, null);
    }

    public void scrollRightTo(String parentLocator, String locator) throws Throwable {
        runCommand("scrollRightTo", parentLocator, locator, null);
    }

    public void scrollUp() throws Throwable {
        runCommand("scrollUp", null, null, null);
    }

    public void scrollUp(String locator) throws Throwable {
        runCommand("scrollUp", locator, null, null);
    }

    public void scrollUp(String parentLocator, String locator) throws Throwable {
        runCommand("scrollUp", parentLocator, locator, null);
    }

    public void scrollUpTo(String locator) throws Throwable {
        runCommand("scrollUpTo", locator, null, null);
    }

    public void scrollUpTo(String parentLocator, String locator) throws Throwable {
        runCommand("scrollUpTo", parentLocator, locator, null);
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

    public void selectNextWindow() throws Throwable {
        runCommand("selectNextWindow", null, null, null);
    }

    public void selectOriginalWindow() throws Throwable {
        runCommand("selectOriginalWindow", null, null, null);
    }

    public void selectParentFrame() throws Throwable {
        runCommand("selectParentFrame", null, null, null);
    }

    public void selectPopUp(String windowID) throws Throwable {
        runCommand("selectPopUp", windowID, null, null);
    }

    public void selectPreviousWindow() throws Throwable {
        runCommand("selectPreviousWindow", null, null, null);
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

    public void setGeolocation(String location) throws Throwable {
        runCommand("setGeolocation", location, null, null);
    }

    public void setPageLoadTimeout(String timeout) throws Throwable {
        runCommand("setPageLoadTimeout", timeout, null, null);
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

    public void storeCursorPosition(String locator, String variable) throws Throwable {
        runCommand("storeCursorPosition", locator, variable, null);
    }

    public void storeCursorPosition(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeCursorPosition", parentLocator, locator, variable);
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

    public void storeLocation(String variable) throws Throwable {
        runCommand("storeLocation", variable, null, null);
    }

    public void storePageSource(String variable) throws Throwable {
        runCommand("storePageSource", variable, null, null);
    }

    public void storePrompt(String variable) throws Throwable {
        runCommand("storePrompt", variable, null, null);
    }

    public void storePush(String text, String variable) throws Throwable {
        runCommand("storePush", text, variable, null);
    }

    public void storeQR(String locator, String variable) throws Throwable {
        runCommand("storeQR", locator, variable, null);
    }

    public void storeQR(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeQR", parentLocator, locator, variable);
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

    public void storeTagName(String locator, String variable) throws Throwable {
        runCommand("storeTagName", locator, variable, null);
    }

    public void storeTagName(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeTagName", parentLocator, locator, variable);
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

    public void storeWindowCount(String variable) throws Throwable {
        runCommand("storeWindowCount", variable, null, null);
    }

    public void storeWindowHandle(String variable) throws Throwable {
        runCommand("storeWindowHandle", variable, null, null);
    }

    public void submit(String locator) throws Throwable {
        runCommand("submit", locator, null, null);
    }

    public void submit(String parentLocator, String locator) throws Throwable {
        runCommand("submit", parentLocator, locator, null);
    }

    public void swipeDown() throws Throwable {
        runCommand("swipeDown", null, null, null);
    }

    public void swipeDown(String locator) throws Throwable {
        runCommand("swipeDown", locator, null, null);
    }

    public void swipeDown(String parentLocator, String locator) throws Throwable {
        runCommand("swipeDown", parentLocator, locator, null);
    }

    public void swipeLeft() throws Throwable {
        runCommand("swipeLeft", null, null, null);
    }

    public void swipeLeft(String locator) throws Throwable {
        runCommand("swipeLeft", locator, null, null);
    }

    public void swipeLeft(String parentLocator, String locator) throws Throwable {
        runCommand("swipeLeft", parentLocator, locator, null);
    }

    public void swipeRight() throws Throwable {
        runCommand("swipeRight", null, null, null);
    }

    public void swipeRight(String locator) throws Throwable {
        runCommand("swipeRight", locator, null, null);
    }

    public void swipeRight(String parentLocator, String locator) throws Throwable {
        runCommand("swipeRight", parentLocator, locator, null);
    }

    public void swipeUp() throws Throwable {
        runCommand("swipeUp", null, null, null);
    }

    public void swipeUp(String locator) throws Throwable {
        runCommand("swipeUp", locator, null, null);
    }

    public void swipeUp(String parentLocator, String locator) throws Throwable {
        runCommand("swipeUp", parentLocator, locator, null);
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

    public void typeKeys(String value) throws Throwable {
        runCommand("typeKeys", value, null, null);
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

    public void verifyAlertMatch(String text) throws Throwable {
        runCommand("verifyAlertMatch", text, null, null);
    }

    public void verifyAlertNotMatch(String text) throws Throwable {
        runCommand("verifyAlertNotMatch", text, null, null);
    }

    public void verifyAlertNotPresent() throws Throwable {
        runCommand("verifyAlertNotPresent", null, null, null);
    }

    public void verifyAlertPresent() throws Throwable {
        runCommand("verifyAlertPresent", null, null, null);
    }

    public void verifyAllButtons(String text) throws Throwable {
        runCommand("verifyAllButtons", text, null, null);
    }

    public void verifyAllButtonsMatch(String text) throws Throwable {
        runCommand("verifyAllButtonsMatch", text, null, null);
    }

    public void verifyAllButtonsNotMatch(String text) throws Throwable {
        runCommand("verifyAllButtonsNotMatch", text, null, null);
    }

    public void verifyAllFields(String text) throws Throwable {
        runCommand("verifyAllFields", text, null, null);
    }

    public void verifyAllFieldsMatch(String text) throws Throwable {
        runCommand("verifyAllFieldsMatch", text, null, null);
    }

    public void verifyAllFieldsNotMatch(String text) throws Throwable {
        runCommand("verifyAllFieldsNotMatch", text, null, null);
    }

    public void verifyAllLinks(String text) throws Throwable {
        runCommand("verifyAllLinks", text, null, null);
    }

    public void verifyAllLinksMatch(String text) throws Throwable {
        runCommand("verifyAllLinksMatch", text, null, null);
    }

    public void verifyAllLinksNotMatch(String text) throws Throwable {
        runCommand("verifyAllLinksNotMatch", text, null, null);
    }

    public void verifyAllWindowNames(String text) throws Throwable {
        runCommand("verifyAllWindowNames", text, null, null);
    }

    public void verifyAllWindowNamesMatch(String text) throws Throwable {
        runCommand("verifyAllWindowNamesMatch", text, null, null);
    }

    public void verifyAllWindowNamesNotMatch(String text) throws Throwable {
        runCommand("verifyAllWindowNamesNotMatch", text, null, null);
    }

    public void verifyAllWindowTitles(String text) throws Throwable {
        runCommand("verifyAllWindowTitles", text, null, null);
    }

    public void verifyAllWindowTitlesMatch(String text) throws Throwable {
        runCommand("verifyAllWindowTitlesMatch", text, null, null);
    }

    public void verifyAllWindowTitlesNotMatch(String text) throws Throwable {
        runCommand("verifyAllWindowTitlesNotMatch", text, null, null);
    }

    public void verifyAttribute(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttribute", locator, name, text);
    }

    public void verifyAttributeFromAllWindows(String attributeName, String text) throws Throwable {
        runCommand("verifyAttributeFromAllWindows", attributeName, text, null);
    }

    public void verifyAttributeFromAllWindowsMatch(String attributeName, String text) throws Throwable {
        runCommand("verifyAttributeFromAllWindowsMatch", attributeName, text, null);
    }

    public void verifyAttributeFromAllWindowsNotMatch(String attributeName, String text) throws Throwable {
        runCommand("verifyAttributeFromAllWindowsNotMatch", attributeName, text, null);
    }

    public void verifyAttributeMatch(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttributeMatch", locator, name, text);
    }

    public void verifyAttributeNotMatch(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttributeNotMatch", locator, name, text);
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

    public void verifyBodyTextMatch(String text) throws Throwable {
        runCommand("verifyBodyTextMatch", text, null, null);
    }

    public void verifyBodyTextNotMatch(String text) throws Throwable {
        runCommand("verifyBodyTextNotMatch", text, null, null);
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

    public void verifyConfirmationMatch(String text) throws Throwable {
        runCommand("verifyConfirmationMatch", text, null, null);
    }

    public void verifyConfirmationNotMatch(String text) throws Throwable {
        runCommand("verifyConfirmationNotMatch", text, null, null);
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

    public void verifyCookieByNameMatch(String name, String text) throws Throwable {
        runCommand("verifyCookieByNameMatch", name, text, null);
    }

    public void verifyCookieByNameNotMatch(String name, String text) throws Throwable {
        runCommand("verifyCookieByNameNotMatch", name, text, null);
    }

    public void verifyCookieMatch(String text) throws Throwable {
        runCommand("verifyCookieMatch", text, null, null);
    }

    public void verifyCookieNotMatch(String text) throws Throwable {
        runCommand("verifyCookieNotMatch", text, null, null);
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

    public void verifyEnabled(String locator) throws Throwable {
        runCommand("verifyEnabled", locator, null, null);
    }

    public void verifyEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("verifyEnabled", parentLocator, locator, null);
    }

    public void verifyEval(String expression, String text) throws Throwable {
        runCommand("verifyEval", expression, text, null);
    }

    public void verifyEvalScript(String script, String text) throws Throwable {
        runCommand("verifyEvalScript", script, text, null);
    }

    public void verifyEvalScriptMatch(String script, String text) throws Throwable {
        runCommand("verifyEvalScriptMatch", script, text, null);
    }

    public void verifyEvalScriptNotMatch(String script, String text) throws Throwable {
        runCommand("verifyEvalScriptNotMatch", script, text, null);
    }

    public void verifyExistsInDatabase(String sql) throws Throwable {
        runCommand("verifyExistsInDatabase", sql, null, null);
    }

    public void verifyExpression(String expression, String text) throws Throwable {
        runCommand("verifyExpression", expression, text, null);
    }

    public void verifyExpressionMatch(String expression, String text) throws Throwable {
        runCommand("verifyExpressionMatch", expression, text, null);
    }

    public void verifyExpressionNotMatch(String expression, String text) throws Throwable {
        runCommand("verifyExpressionNotMatch", expression, text, null);
    }

    public void verifyFileContainLine(String filePattern, String charset, String text) throws Throwable {
        runCommand("verifyFileContainLine", filePattern, charset, text);
    }

    public void verifyFileDownloaded(String filePattern) throws Throwable {
        runCommand("verifyFileDownloaded", filePattern, null, null);
    }

    public void verifyFileFirstLine(String filePattern, String charset, String text) throws Throwable {
        runCommand("verifyFileFirstLine", filePattern, charset, text);
    }

    public void verifyFontFamily(String locator, String text) throws Throwable {
        runCommand("verifyFontFamily", locator, text, null);
    }

    public void verifyFontFamily(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontFamily", parentLocator, locator, text);
    }

    public void verifyFontFamilyMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyMatch", locator, text, null);
    }

    public void verifyFontFamilyMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyMatch", parentLocator, locator, text);
    }

    public void verifyFontFamilyNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyNotMatch", locator, text, null);
    }

    public void verifyFontFamilyNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontFamilyNotMatch", parentLocator, locator, text);
    }

    public void verifyFontSize(String locator, String text) throws Throwable {
        runCommand("verifyFontSize", locator, text, null);
    }

    public void verifyFontSize(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontSize", parentLocator, locator, text);
    }

    public void verifyFontSizeMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontSizeMatch", locator, text, null);
    }

    public void verifyFontSizeMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontSizeMatch", parentLocator, locator, text);
    }

    public void verifyFontSizeNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontSizeNotMatch", locator, text, null);
    }

    public void verifyFontSizeNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontSizeNotMatch", parentLocator, locator, text);
    }

    public void verifyFontStyle(String locator, String text) throws Throwable {
        runCommand("verifyFontStyle", locator, text, null);
    }

    public void verifyFontStyle(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontStyle", parentLocator, locator, text);
    }

    public void verifyFontStyleMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontStyleMatch", locator, text, null);
    }

    public void verifyFontStyleMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontStyleMatch", parentLocator, locator, text);
    }

    public void verifyFontStyleNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontStyleNotMatch", locator, text, null);
    }

    public void verifyFontStyleNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontStyleNotMatch", parentLocator, locator, text);
    }

    public void verifyFontWeight(String locator, String text) throws Throwable {
        runCommand("verifyFontWeight", locator, text, null);
    }

    public void verifyFontWeight(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontWeight", parentLocator, locator, text);
    }

    public void verifyFontWeightMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontWeightMatch", locator, text, null);
    }

    public void verifyFontWeightMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontWeightMatch", parentLocator, locator, text);
    }

    public void verifyFontWeightNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyFontWeightNotMatch", locator, text, null);
    }

    public void verifyFontWeightNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyFontWeightNotMatch", parentLocator, locator, text);
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

    public void verifyLocationMatch(String text) throws Throwable {
        runCommand("verifyLocationMatch", text, null, null);
    }

    public void verifyLocationNotMatch(String text) throws Throwable {
        runCommand("verifyLocationNotMatch", text, null, null);
    }

    public void verifyLogContainLine(String text) throws Throwable {
        runCommand("verifyLogContainLine", text, null, null);
    }

    public void verifyLogNotContainLine(String text) throws Throwable {
        runCommand("verifyLogNotContainLine", text, null, null);
    }

    public void verifyNotAlert(String text) throws Throwable {
        runCommand("verifyNotAlert", text, null, null);
    }

    public void verifyNotAllButtons(String text) throws Throwable {
        runCommand("verifyNotAllButtons", text, null, null);
    }

    public void verifyNotAllFields(String text) throws Throwable {
        runCommand("verifyNotAllFields", text, null, null);
    }

    public void verifyNotAllLinks(String text) throws Throwable {
        runCommand("verifyNotAllLinks", text, null, null);
    }

    public void verifyNotAllWindowNames(String text) throws Throwable {
        runCommand("verifyNotAllWindowNames", text, null, null);
    }

    public void verifyNotAllWindowTitles(String text) throws Throwable {
        runCommand("verifyNotAllWindowTitles", text, null, null);
    }

    public void verifyNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("verifyNotAttribute", locator, name, text);
    }

    public void verifyNotAttributeFromAllWindows(String attributeName, String text) throws Throwable {
        runCommand("verifyNotAttributeFromAllWindows", attributeName, text, null);
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

    public void verifyNotEnabled(String locator) throws Throwable {
        runCommand("verifyNotEnabled", locator, null, null);
    }

    public void verifyNotEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotEnabled", parentLocator, locator, null);
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

    public void verifyNotFileDownloaded(String filePattern) throws Throwable {
        runCommand("verifyNotFileDownloaded", filePattern, null, null);
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

    public void verifyNotLocation(String text) throws Throwable {
        runCommand("verifyNotLocation", text, null, null);
    }

    public void verifyNotOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("verifyNotOrdered", firstLocator, secondLocator, null);
    }

    public void verifyNotPageSource(String text) throws Throwable {
        runCommand("verifyNotPageSource", text, null, null);
    }

    public void verifyNotPrompt(String text) throws Throwable {
        runCommand("verifyNotPrompt", text, null, null);
    }

    public void verifyNotQR(String locator, String text) throws Throwable {
        runCommand("verifyNotQR", locator, text, null);
    }

    public void verifyNotQR(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotQR", parentLocator, locator, text);
    }

    public void verifyNotSelectOptions(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectOptions", locator, text, null);
    }

    public void verifyNotSelectOptions(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectOptions", parentLocator, locator, text);
    }

    public void verifyNotSelectedId(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedId", locator, text, null);
    }

    public void verifyNotSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedId", parentLocator, locator, text);
    }

    public void verifyNotSelectedIds(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIds", locator, text, null);
    }

    public void verifyNotSelectedIds(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIds", parentLocator, locator, text);
    }

    public void verifyNotSelectedIndex(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIndex", locator, text, null);
    }

    public void verifyNotSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIndex", parentLocator, locator, text);
    }

    public void verifyNotSelectedIndexes(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIndexes", locator, text, null);
    }

    public void verifyNotSelectedIndexes(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedIndexes", parentLocator, locator, text);
    }

    public void verifyNotSelectedLabel(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedLabel", locator, text, null);
    }

    public void verifyNotSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedLabel", parentLocator, locator, text);
    }

    public void verifyNotSelectedLabels(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedLabels", locator, text, null);
    }

    public void verifyNotSelectedLabels(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedLabels", parentLocator, locator, text);
    }

    public void verifyNotSelectedValue(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedValue", locator, text, null);
    }

    public void verifyNotSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedValue", parentLocator, locator, text);
    }

    public void verifyNotSelectedValues(String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedValues", locator, text, null);
    }

    public void verifyNotSelectedValues(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotSelectedValues", parentLocator, locator, text);
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

    public void verifyNotTagName(String locator, String text) throws Throwable {
        runCommand("verifyNotTagName", locator, text, null);
    }

    public void verifyNotTagName(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotTagName", parentLocator, locator, text);
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

    public void verifyNotWindowCount(String text) throws Throwable {
        runCommand("verifyNotWindowCount", text, null, null);
    }

    public void verifyNotWindowHandle(String text) throws Throwable {
        runCommand("verifyNotWindowHandle", text, null, null);
    }

    public void verifyNotXpathCount(String xpath, String text) throws Throwable {
        runCommand("verifyNotXpathCount", xpath, text, null);
    }

    public void verifyOrdered(String firstLocator, String secondLocator) throws Throwable {
        runCommand("verifyOrdered", firstLocator, secondLocator, null);
    }

    public void verifyPageSource(String text) throws Throwable {
        runCommand("verifyPageSource", text, null, null);
    }

    public void verifyPageSourceMatch(String text) throws Throwable {
        runCommand("verifyPageSourceMatch", text, null, null);
    }

    public void verifyPageSourceNotMatch(String text) throws Throwable {
        runCommand("verifyPageSourceNotMatch", text, null, null);
    }

    public void verifyPrompt(String text) throws Throwable {
        runCommand("verifyPrompt", text, null, null);
    }

    public void verifyPromptMatch(String text) throws Throwable {
        runCommand("verifyPromptMatch", text, null, null);
    }

    public void verifyPromptNotMatch(String text) throws Throwable {
        runCommand("verifyPromptNotMatch", text, null, null);
    }

    public void verifyPromptNotPresent() throws Throwable {
        runCommand("verifyPromptNotPresent", null, null, null);
    }

    public void verifyPromptPresent() throws Throwable {
        runCommand("verifyPromptPresent", null, null, null);
    }

    public void verifyQR(String locator, String text) throws Throwable {
        runCommand("verifyQR", locator, text, null);
    }

    public void verifyQR(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyQR", parentLocator, locator, text);
    }

    public void verifyQRMatch(String locator, String text) throws Throwable {
        runCommand("verifyQRMatch", locator, text, null);
    }

    public void verifyQRMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyQRMatch", parentLocator, locator, text);
    }

    public void verifyQRNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyQRNotMatch", locator, text, null);
    }

    public void verifyQRNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyQRNotMatch", parentLocator, locator, text);
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

    public void verifySelectOptions(String locator, String text) throws Throwable {
        runCommand("verifySelectOptions", locator, text, null);
    }

    public void verifySelectOptions(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectOptions", parentLocator, locator, text);
    }

    public void verifySelectOptionsMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectOptionsMatch", locator, text, null);
    }

    public void verifySelectOptionsMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectOptionsMatch", parentLocator, locator, text);
    }

    public void verifySelectOptionsNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectOptionsNotMatch", locator, text, null);
    }

    public void verifySelectOptionsNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectOptionsNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedId(String locator, String text) throws Throwable {
        runCommand("verifySelectedId", locator, text, null);
    }

    public void verifySelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedId", parentLocator, locator, text);
    }

    public void verifySelectedIdMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIdMatch", locator, text, null);
    }

    public void verifySelectedIdMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIdMatch", parentLocator, locator, text);
    }

    public void verifySelectedIdNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIdNotMatch", locator, text, null);
    }

    public void verifySelectedIdNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIdNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedIds(String locator, String text) throws Throwable {
        runCommand("verifySelectedIds", locator, text, null);
    }

    public void verifySelectedIds(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIds", parentLocator, locator, text);
    }

    public void verifySelectedIdsMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIdsMatch", locator, text, null);
    }

    public void verifySelectedIdsMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIdsMatch", parentLocator, locator, text);
    }

    public void verifySelectedIdsNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIdsNotMatch", locator, text, null);
    }

    public void verifySelectedIdsNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIdsNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedIndex(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndex", locator, text, null);
    }

    public void verifySelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndex", parentLocator, locator, text);
    }

    public void verifySelectedIndexMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexMatch", locator, text, null);
    }

    public void verifySelectedIndexMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexMatch", parentLocator, locator, text);
    }

    public void verifySelectedIndexNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexNotMatch", locator, text, null);
    }

    public void verifySelectedIndexNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedIndexes(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexes", locator, text, null);
    }

    public void verifySelectedIndexes(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexes", parentLocator, locator, text);
    }

    public void verifySelectedIndexesMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexesMatch", locator, text, null);
    }

    public void verifySelectedIndexesMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexesMatch", parentLocator, locator, text);
    }

    public void verifySelectedIndexesNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexesNotMatch", locator, text, null);
    }

    public void verifySelectedIndexesNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedIndexesNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedLabel(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabel", locator, text, null);
    }

    public void verifySelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabel", parentLocator, locator, text);
    }

    public void verifySelectedLabelMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelMatch", locator, text, null);
    }

    public void verifySelectedLabelMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelMatch", parentLocator, locator, text);
    }

    public void verifySelectedLabelNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelNotMatch", locator, text, null);
    }

    public void verifySelectedLabelNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedLabels(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabels", locator, text, null);
    }

    public void verifySelectedLabels(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabels", parentLocator, locator, text);
    }

    public void verifySelectedLabelsMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelsMatch", locator, text, null);
    }

    public void verifySelectedLabelsMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelsMatch", parentLocator, locator, text);
    }

    public void verifySelectedLabelsNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelsNotMatch", locator, text, null);
    }

    public void verifySelectedLabelsNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedLabelsNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedValue(String locator, String text) throws Throwable {
        runCommand("verifySelectedValue", locator, text, null);
    }

    public void verifySelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValue", parentLocator, locator, text);
    }

    public void verifySelectedValueMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedValueMatch", locator, text, null);
    }

    public void verifySelectedValueMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValueMatch", parentLocator, locator, text);
    }

    public void verifySelectedValueNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedValueNotMatch", locator, text, null);
    }

    public void verifySelectedValueNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValueNotMatch", parentLocator, locator, text);
    }

    public void verifySelectedValues(String locator, String text) throws Throwable {
        runCommand("verifySelectedValues", locator, text, null);
    }

    public void verifySelectedValues(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValues", parentLocator, locator, text);
    }

    public void verifySelectedValuesMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedValuesMatch", locator, text, null);
    }

    public void verifySelectedValuesMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValuesMatch", parentLocator, locator, text);
    }

    public void verifySelectedValuesNotMatch(String locator, String text) throws Throwable {
        runCommand("verifySelectedValuesNotMatch", locator, text, null);
    }

    public void verifySelectedValuesNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifySelectedValuesNotMatch", parentLocator, locator, text);
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

    public void verifyTableMatch(String locator, String cellAddress, String text) throws Throwable {
        runCommand("verifyTableMatch", locator, cellAddress, text);
    }

    public void verifyTableNotMatch(String locator, String cellAddress, String text) throws Throwable {
        runCommand("verifyTableNotMatch", locator, cellAddress, text);
    }

    public void verifyTagName(String locator, String text) throws Throwable {
        runCommand("verifyTagName", locator, text, null);
    }

    public void verifyTagName(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTagName", parentLocator, locator, text);
    }

    public void verifyTagNameMatch(String locator, String text) throws Throwable {
        runCommand("verifyTagNameMatch", locator, text, null);
    }

    public void verifyTagNameMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTagNameMatch", parentLocator, locator, text);
    }

    public void verifyTagNameNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyTagNameNotMatch", locator, text, null);
    }

    public void verifyTagNameNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTagNameNotMatch", parentLocator, locator, text);
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

    public void verifyTextAlignmentMatch(String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentMatch", locator, text, null);
    }

    public void verifyTextAlignmentMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentMatch", parentLocator, locator, text);
    }

    public void verifyTextAlignmentNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentNotMatch", locator, text, null);
    }

    public void verifyTextAlignmentNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextAlignmentNotMatch", parentLocator, locator, text);
    }

    public void verifyTextDecoration(String locator, String text) throws Throwable {
        runCommand("verifyTextDecoration", locator, text, null);
    }

    public void verifyTextDecoration(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextDecoration", parentLocator, locator, text);
    }

    public void verifyTextDecorationMatch(String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationMatch", locator, text, null);
    }

    public void verifyTextDecorationMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationMatch", parentLocator, locator, text);
    }

    public void verifyTextDecorationNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationNotMatch", locator, text, null);
    }

    public void verifyTextDecorationNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextDecorationNotMatch", parentLocator, locator, text);
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

    public void verifyTextMatch(String locator, String text) throws Throwable {
        runCommand("verifyTextMatch", locator, text, null);
    }

    public void verifyTextMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextMatch", parentLocator, locator, text);
    }

    public void verifyTextNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyTextNotMatch", locator, text, null);
    }

    public void verifyTextNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyTextNotMatch", parentLocator, locator, text);
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

    public void verifyTitleMatch(String text) throws Throwable {
        runCommand("verifyTitleMatch", text, null, null);
    }

    public void verifyTitleNotMatch(String text) throws Throwable {
        runCommand("verifyTitleNotMatch", text, null, null);
    }

    public void verifyValue(String locator, String text) throws Throwable {
        runCommand("verifyValue", locator, text, null);
    }

    public void verifyValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyValue", parentLocator, locator, text);
    }

    public void verifyValueEmpty(String locator) throws Throwable {
        runCommand("verifyValueEmpty", locator, null, null);
    }

    public void verifyValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("verifyValueEmpty", parentLocator, locator, null);
    }

    public void verifyValueMatch(String locator, String text) throws Throwable {
        runCommand("verifyValueMatch", locator, text, null);
    }

    public void verifyValueMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyValueMatch", parentLocator, locator, text);
    }

    public void verifyValueNotMatch(String locator, String text) throws Throwable {
        runCommand("verifyValueNotMatch", locator, text, null);
    }

    public void verifyValueNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyValueNotMatch", parentLocator, locator, text);
    }

    public void verifyVariable(String variable, String text) throws Throwable {
        runCommand("verifyVariable", variable, text, null);
    }

    public void verifyVisible(String locator) throws Throwable {
        runCommand("verifyVisible", locator, null, null);
    }

    public void verifyVisible(String parentLocator, String locator) throws Throwable {
        runCommand("verifyVisible", parentLocator, locator, null);
    }

    public void verifyWindowCount(String text) throws Throwable {
        runCommand("verifyWindowCount", text, null, null);
    }

    public void verifyWindowHandle(String text) throws Throwable {
        runCommand("verifyWindowHandle", text, null, null);
    }

    public void verifyWindowHandleMatch(String text) throws Throwable {
        runCommand("verifyWindowHandleMatch", text, null, null);
    }

    public void verifyWindowHandleNotMatch(String text) throws Throwable {
        runCommand("verifyWindowHandleNotMatch", text, null, null);
    }

    public void verifyXpathCount(String xpath, String text) throws Throwable {
        runCommand("verifyXpathCount", xpath, text, null);
    }

    public void waitForAlert(String text) throws Throwable {
        runCommand("waitForAlert", text, null, null);
    }

    public void waitForAlertMatch(String text) throws Throwable {
        runCommand("waitForAlertMatch", text, null, null);
    }

    public void waitForAlertNotMatch(String text) throws Throwable {
        runCommand("waitForAlertNotMatch", text, null, null);
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

    public void waitForAttributeMatch(String locator, String name, String text) throws Throwable {
        runCommand("waitForAttributeMatch", locator, name, text);
    }

    public void waitForAttributeNotMatch(String locator, String name, String text) throws Throwable {
        runCommand("waitForAttributeNotMatch", locator, name, text);
    }

    public void waitForBodyText(String text) throws Throwable {
        runCommand("waitForBodyText", text, null, null);
    }

    public void waitForBodyTextMatch(String text) throws Throwable {
        runCommand("waitForBodyTextMatch", text, null, null);
    }

    public void waitForBodyTextNotMatch(String text) throws Throwable {
        runCommand("waitForBodyTextNotMatch", text, null, null);
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

    public void waitForConfirmationMatch(String text) throws Throwable {
        runCommand("waitForConfirmationMatch", text, null, null);
    }

    public void waitForConfirmationNotMatch(String text) throws Throwable {
        runCommand("waitForConfirmationNotMatch", text, null, null);
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

    public void waitForCookieByNameMatch(String name, String text) throws Throwable {
        runCommand("waitForCookieByNameMatch", name, text, null);
    }

    public void waitForCookieByNameNotMatch(String name, String text) throws Throwable {
        runCommand("waitForCookieByNameNotMatch", name, text, null);
    }

    public void waitForCookieMatch(String text) throws Throwable {
        runCommand("waitForCookieMatch", text, null, null);
    }

    public void waitForCookieNotMatch(String text) throws Throwable {
        runCommand("waitForCookieNotMatch", text, null, null);
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

    public void waitForEnabled(String locator) throws Throwable {
        runCommand("waitForEnabled", locator, null, null);
    }

    public void waitForEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("waitForEnabled", parentLocator, locator, null);
    }

    public void waitForEval(String expression, String text) throws Throwable {
        runCommand("waitForEval", expression, text, null);
    }

    public void waitForEvalScript(String script, String text) throws Throwable {
        runCommand("waitForEvalScript", script, text, null);
    }

    public void waitForEvalScriptMatch(String script, String text) throws Throwable {
        runCommand("waitForEvalScriptMatch", script, text, null);
    }

    public void waitForEvalScriptNotMatch(String script, String text) throws Throwable {
        runCommand("waitForEvalScriptNotMatch", script, text, null);
    }

    public void waitForExistsInDatabase(String sql) throws Throwable {
        runCommand("waitForExistsInDatabase", sql, null, null);
    }

    public void waitForExpression(String expression, String text) throws Throwable {
        runCommand("waitForExpression", expression, text, null);
    }

    public void waitForExpressionMatch(String expression, String text) throws Throwable {
        runCommand("waitForExpressionMatch", expression, text, null);
    }

    public void waitForExpressionNotMatch(String expression, String text) throws Throwable {
        runCommand("waitForExpressionNotMatch", expression, text, null);
    }

    public void waitForFileDownloaded(String filePattern) throws Throwable {
        runCommand("waitForFileDownloaded", filePattern, null, null);
    }

    public void waitForLocation(String text) throws Throwable {
        runCommand("waitForLocation", text, null, null);
    }

    public void waitForLocationMatch(String text) throws Throwable {
        runCommand("waitForLocationMatch", text, null, null);
    }

    public void waitForLocationNotMatch(String text) throws Throwable {
        runCommand("waitForLocationNotMatch", text, null, null);
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

    public void waitForNotEnabled(String locator) throws Throwable {
        runCommand("waitForNotEnabled", locator, null, null);
    }

    public void waitForNotEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotEnabled", parentLocator, locator, null);
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

    public void waitForNotFileDownloaded(String filePattern) throws Throwable {
        runCommand("waitForNotFileDownloaded", filePattern, null, null);
    }

    public void waitForNotLocation(String text) throws Throwable {
        runCommand("waitForNotLocation", text, null, null);
    }

    public void waitForNotPageSource(String text) throws Throwable {
        runCommand("waitForNotPageSource", text, null, null);
    }

    public void waitForNotPrompt(String text) throws Throwable {
        runCommand("waitForNotPrompt", text, null, null);
    }

    public void waitForNotQR(String locator, String text) throws Throwable {
        runCommand("waitForNotQR", locator, text, null);
    }

    public void waitForNotQR(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotQR", parentLocator, locator, text);
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

    public void waitForNotTagName(String locator, String text) throws Throwable {
        runCommand("waitForNotTagName", locator, text, null);
    }

    public void waitForNotTagName(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForNotTagName", parentLocator, locator, text);
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

    public void waitForNotWindowCount(String text) throws Throwable {
        runCommand("waitForNotWindowCount", text, null, null);
    }

    public void waitForNotWindowHandle(String text) throws Throwable {
        runCommand("waitForNotWindowHandle", text, null, null);
    }

    public void waitForPageSource(String text) throws Throwable {
        runCommand("waitForPageSource", text, null, null);
    }

    public void waitForPageSourceMatch(String text) throws Throwable {
        runCommand("waitForPageSourceMatch", text, null, null);
    }

    public void waitForPageSourceNotMatch(String text) throws Throwable {
        runCommand("waitForPageSourceNotMatch", text, null, null);
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

    public void waitForPromptMatch(String text) throws Throwable {
        runCommand("waitForPromptMatch", text, null, null);
    }

    public void waitForPromptNotMatch(String text) throws Throwable {
        runCommand("waitForPromptNotMatch", text, null, null);
    }

    public void waitForPromptNotPresent() throws Throwable {
        runCommand("waitForPromptNotPresent", null, null, null);
    }

    public void waitForPromptPresent() throws Throwable {
        runCommand("waitForPromptPresent", null, null, null);
    }

    public void waitForQR(String locator, String text) throws Throwable {
        runCommand("waitForQR", locator, text, null);
    }

    public void waitForQR(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForQR", parentLocator, locator, text);
    }

    public void waitForQRMatch(String locator, String text) throws Throwable {
        runCommand("waitForQRMatch", locator, text, null);
    }

    public void waitForQRMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForQRMatch", parentLocator, locator, text);
    }

    public void waitForQRNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForQRNotMatch", locator, text, null);
    }

    public void waitForQRNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForQRNotMatch", parentLocator, locator, text);
    }

    public void waitForSelectedId(String locator, String text) throws Throwable {
        runCommand("waitForSelectedId", locator, text, null);
    }

    public void waitForSelectedId(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedId", parentLocator, locator, text);
    }

    public void waitForSelectedIdMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdMatch", locator, text, null);
    }

    public void waitForSelectedIdMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdMatch", parentLocator, locator, text);
    }

    public void waitForSelectedIdNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdNotMatch", locator, text, null);
    }

    public void waitForSelectedIdNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIdNotMatch", parentLocator, locator, text);
    }

    public void waitForSelectedIndex(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndex", locator, text, null);
    }

    public void waitForSelectedIndex(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndex", parentLocator, locator, text);
    }

    public void waitForSelectedIndexMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexMatch", locator, text, null);
    }

    public void waitForSelectedIndexMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexMatch", parentLocator, locator, text);
    }

    public void waitForSelectedIndexNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexNotMatch", locator, text, null);
    }

    public void waitForSelectedIndexNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedIndexNotMatch", parentLocator, locator, text);
    }

    public void waitForSelectedLabel(String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabel", locator, text, null);
    }

    public void waitForSelectedLabel(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabel", parentLocator, locator, text);
    }

    public void waitForSelectedLabelMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelMatch", locator, text, null);
    }

    public void waitForSelectedLabelMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelMatch", parentLocator, locator, text);
    }

    public void waitForSelectedLabelNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelNotMatch", locator, text, null);
    }

    public void waitForSelectedLabelNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedLabelNotMatch", parentLocator, locator, text);
    }

    public void waitForSelectedValue(String locator, String text) throws Throwable {
        runCommand("waitForSelectedValue", locator, text, null);
    }

    public void waitForSelectedValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedValue", parentLocator, locator, text);
    }

    public void waitForSelectedValueMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueMatch", locator, text, null);
    }

    public void waitForSelectedValueMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueMatch", parentLocator, locator, text);
    }

    public void waitForSelectedValueNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueNotMatch", locator, text, null);
    }

    public void waitForSelectedValueNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForSelectedValueNotMatch", parentLocator, locator, text);
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

    public void waitForTableMatch(String locator, String cellAddress, String text) throws Throwable {
        runCommand("waitForTableMatch", locator, cellAddress, text);
    }

    public void waitForTableNotMatch(String locator, String cellAddress, String text) throws Throwable {
        runCommand("waitForTableNotMatch", locator, cellAddress, text);
    }

    public void waitForTagName(String locator, String text) throws Throwable {
        runCommand("waitForTagName", locator, text, null);
    }

    public void waitForTagName(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTagName", parentLocator, locator, text);
    }

    public void waitForTagNameMatch(String locator, String text) throws Throwable {
        runCommand("waitForTagNameMatch", locator, text, null);
    }

    public void waitForTagNameMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTagNameMatch", parentLocator, locator, text);
    }

    public void waitForTagNameNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForTagNameNotMatch", locator, text, null);
    }

    public void waitForTagNameNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTagNameNotMatch", parentLocator, locator, text);
    }

    public void waitForText(String locator, String text) throws Throwable {
        runCommand("waitForText", locator, text, null);
    }

    public void waitForText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForText", parentLocator, locator, text);
    }

    public void waitForTextEmpty(String locator) throws Throwable {
        runCommand("waitForTextEmpty", locator, null, null);
    }

    public void waitForTextEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("waitForTextEmpty", parentLocator, locator, null);
    }

    public void waitForTextMatch(String locator, String text) throws Throwable {
        runCommand("waitForTextMatch", locator, text, null);
    }

    public void waitForTextMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTextMatch", parentLocator, locator, text);
    }

    public void waitForTextNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForTextNotMatch", locator, text, null);
    }

    public void waitForTextNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForTextNotMatch", parentLocator, locator, text);
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

    public void waitForTitleMatch(String text) throws Throwable {
        runCommand("waitForTitleMatch", text, null, null);
    }

    public void waitForTitleNotMatch(String text) throws Throwable {
        runCommand("waitForTitleNotMatch", text, null, null);
    }

    public void waitForValue(String locator, String text) throws Throwable {
        runCommand("waitForValue", locator, text, null);
    }

    public void waitForValue(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForValue", parentLocator, locator, text);
    }

    public void waitForValueEmpty(String locator) throws Throwable {
        runCommand("waitForValueEmpty", locator, null, null);
    }

    public void waitForValueEmpty(String parentLocator, String locator) throws Throwable {
        runCommand("waitForValueEmpty", parentLocator, locator, null);
    }

    public void waitForValueMatch(String locator, String text) throws Throwable {
        runCommand("waitForValueMatch", locator, text, null);
    }

    public void waitForValueMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForValueMatch", parentLocator, locator, text);
    }

    public void waitForValueNotMatch(String locator, String text) throws Throwable {
        runCommand("waitForValueNotMatch", locator, text, null);
    }

    public void waitForValueNotMatch(String parentLocator, String locator, String text) throws Throwable {
        runCommand("waitForValueNotMatch", parentLocator, locator, text);
    }

    public void waitForVisible(String locator) throws Throwable {
        runCommand("waitForVisible", locator, null, null);
    }

    public void waitForVisible(String parentLocator, String locator) throws Throwable {
        runCommand("waitForVisible", parentLocator, locator, null);
    }

    public void waitForWindowCount(String text) throws Throwable {
        runCommand("waitForWindowCount", text, null, null);
    }

    public void waitForWindowHandle(String text) throws Throwable {
        runCommand("waitForWindowHandle", text, null, null);
    }

    public void waitForWindowHandleMatch(String text) throws Throwable {
        runCommand("waitForWindowHandleMatch", text, null, null);
    }

    public void waitForWindowHandleNotMatch(String text) throws Throwable {
        runCommand("waitForWindowHandleNotMatch", text, null, null);
    }

    public void windowFocus() throws Throwable {
        runCommand("windowFocus", null, null, null);
    }

    public void windowMaximize() throws Throwable {
        runCommand("windowMaximize", null, null, null);
    }

}
