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

public class MobileExcelium extends Excelium {

    public MobileExcelium(ContextAwareWebDriver webDriver, String baseUrl, Project project) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        super(webDriver, baseUrl, project);
    }

    public void assertAttribute(String locator, String name, String text) throws Throwable {
        runCommand("assertAttribute", locator, name, text);
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

    public void assertNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("assertNotAttribute", locator, name, text);
    }

    public void assertNotBackgroundColor(String locator, String text) throws Throwable {
        runCommand("assertNotBackgroundColor", locator, text, null);
    }

    public void assertNotBackgroundColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotBackgroundColor", parentLocator, locator, text);
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

    public void echo(String message) throws Throwable {
        runCommand("echo", message, null, null);
    }

    public void execute(String action) throws Throwable {
        runCommand("execute", action, null, null);
    }

    public void executeEach(String action, String locator, String variable) throws Throwable {
        runCommand("executeEach", action, locator, variable);
    }

    public void executeIfChecked(String action, String locator) throws Throwable {
        runCommand("executeIfChecked", action, locator, null);
    }

    public void executeIfChecked(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfChecked", action, parentLocator, locator);
    }

    public void executeIfEditable(String action, String locator) throws Throwable {
        runCommand("executeIfEditable", action, locator, null);
    }

    public void executeIfEditable(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfEditable", action, parentLocator, locator);
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

    public void executeIfListContain(String action, String variable, String text) throws Throwable {
        runCommand("executeIfListContain", action, variable, text);
    }

    public void executeIfListNotContain(String action, String variable, String text) throws Throwable {
        runCommand("executeIfListNotContain", action, variable, text);
    }

    public void executeIfNotChecked(String action, String locator) throws Throwable {
        runCommand("executeIfNotChecked", action, locator, null);
    }

    public void executeIfNotChecked(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotChecked", action, parentLocator, locator);
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

    public void executeLoop(String action, String times) throws Throwable {
        runCommand("executeLoop", action, times, null);
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

    public void pause(String waitTime) throws Throwable {
        runCommand("pause", waitTime, null, null);
    }

    public void refresh() throws Throwable {
        runCommand("refresh", null, null, null);
    }

    public void runScript(String script) throws Throwable {
        runCommand("runScript", script, null, null);
    }

    public void setTimeout(String timeout) throws Throwable {
        runCommand("setTimeout", timeout, null, null);
    }

    public void store(String text, String variable) throws Throwable {
        runCommand("store", text, variable, null);
    }

    public void storeAttribute(String locator, String name, String variable) throws Throwable {
        runCommand("storeAttribute", locator, name, variable);
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

    public void storeText(String locator, String variable) throws Throwable {
        runCommand("storeText", locator, variable, null);
    }

    public void storeText(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeText", parentLocator, locator, variable);
    }

    public void storeValue(String locator, String variable) throws Throwable {
        runCommand("storeValue", locator, variable, null);
    }

    public void storeValue(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeValue", parentLocator, locator, variable);
    }

    public void verifyAttribute(String locator, String name, String text) throws Throwable {
        runCommand("verifyAttribute", locator, name, text);
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

    public void verifyNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("verifyNotAttribute", locator, name, text);
    }

    public void verifyNotBackgroundColor(String locator, String text) throws Throwable {
        runCommand("verifyNotBackgroundColor", locator, text, null);
    }

    public void verifyNotBackgroundColor(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotBackgroundColor", parentLocator, locator, text);
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

    public void waitForChecked(String locator) throws Throwable {
        runCommand("waitForChecked", locator, null, null);
    }

    public void waitForChecked(String parentLocator, String locator) throws Throwable {
        runCommand("waitForChecked", parentLocator, locator, null);
    }

    public void waitForCondition(String script, String timeout) throws Throwable {
        runCommand("waitForCondition", script, timeout, null);
    }

    public void waitForEditable(String locator) throws Throwable {
        runCommand("waitForEditable", locator, null, null);
    }

    public void waitForEditable(String parentLocator, String locator) throws Throwable {
        runCommand("waitForEditable", parentLocator, locator, null);
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

    public void waitForNotAttribute(String locator, String name, String text) throws Throwable {
        runCommand("waitForNotAttribute", locator, name, text);
    }

    public void waitForNotChecked(String locator) throws Throwable {
        runCommand("waitForNotChecked", locator, null, null);
    }

    public void waitForNotChecked(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotChecked", parentLocator, locator, null);
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

}
