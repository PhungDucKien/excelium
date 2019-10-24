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

    public void assertChecked(String locator) throws Throwable {
        runCommand("assertChecked", locator, null, null);
    }

    public void assertChecked(String parentLocator, String locator) throws Throwable {
        runCommand("assertChecked", parentLocator, locator, null);
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

    public void assertEnabled(String locator) throws Throwable {
        runCommand("assertEnabled", locator, null, null);
    }

    public void assertEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("assertEnabled", parentLocator, locator, null);
    }

    public void assertEval(String expression, String text) throws Throwable {
        runCommand("assertEval", expression, text, null);
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

    public void assertNotChecked(String locator) throws Throwable {
        runCommand("assertNotChecked", locator, null, null);
    }

    public void assertNotChecked(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotChecked", parentLocator, locator, null);
    }

    public void assertNotEditable(String locator) throws Throwable {
        runCommand("assertNotEditable", locator, null, null);
    }

    public void assertNotEditable(String parentLocator, String locator) throws Throwable {
        runCommand("assertNotEditable", parentLocator, locator, null);
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

    public void assertNotExistsInDatabase(String sql) throws Throwable {
        runCommand("assertNotExistsInDatabase", sql, null, null);
    }

    public void assertNotExpression(String expression, String text) throws Throwable {
        runCommand("assertNotExpression", expression, text, null);
    }

    public void assertNotText(String locator, String text) throws Throwable {
        runCommand("assertNotText", locator, text, null);
    }

    public void assertNotText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertNotText", parentLocator, locator, text);
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

    public void assertText(String locator, String text) throws Throwable {
        runCommand("assertText", locator, text, null);
    }

    public void assertText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("assertText", parentLocator, locator, text);
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

    public void executeIfEnabled(String action, String locator) throws Throwable {
        runCommand("executeIfEnabled", action, locator, null);
    }

    public void executeIfEnabled(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfEnabled", action, parentLocator, locator);
    }

    public void executeIfEval(String action, String expression, String text) throws Throwable {
        runCommand("executeIfEval", action, expression, text);
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

    public void executeIfNotEnabled(String action, String locator) throws Throwable {
        runCommand("executeIfNotEnabled", action, locator, null);
    }

    public void executeIfNotEnabled(String action, String parentLocator, String locator) throws Throwable {
        runCommand("executeIfNotEnabled", action, parentLocator, locator);
    }

    public void executeIfNotEval(String action, String expression, String text) throws Throwable {
        runCommand("executeIfNotEval", action, expression, text);
    }

    public void executeIfNotExistsInDatabase(String action, String sql) throws Throwable {
        runCommand("executeIfNotExistsInDatabase", action, sql, null);
    }

    public void executeIfNotExpression(String action, String expression, String text) throws Throwable {
        runCommand("executeIfNotExpression", action, expression, text);
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

    public void pause(String waitTime) throws Throwable {
        runCommand("pause", waitTime, null, null);
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

    public void storeEval(String expression, String variable) throws Throwable {
        runCommand("storeEval", expression, variable, null);
    }

    public void storeExpression(String expression, String variable) throws Throwable {
        runCommand("storeExpression", expression, variable, null);
    }

    public void storePush(String text, String variable) throws Throwable {
        runCommand("storePush", text, variable, null);
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

    public void verifyChecked(String locator) throws Throwable {
        runCommand("verifyChecked", locator, null, null);
    }

    public void verifyChecked(String parentLocator, String locator) throws Throwable {
        runCommand("verifyChecked", parentLocator, locator, null);
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

    public void verifyEnabled(String locator) throws Throwable {
        runCommand("verifyEnabled", locator, null, null);
    }

    public void verifyEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("verifyEnabled", parentLocator, locator, null);
    }

    public void verifyEval(String expression, String text) throws Throwable {
        runCommand("verifyEval", expression, text, null);
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

    public void verifyNotChecked(String locator) throws Throwable {
        runCommand("verifyNotChecked", locator, null, null);
    }

    public void verifyNotChecked(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotChecked", parentLocator, locator, null);
    }

    public void verifyNotEditable(String locator) throws Throwable {
        runCommand("verifyNotEditable", locator, null, null);
    }

    public void verifyNotEditable(String parentLocator, String locator) throws Throwable {
        runCommand("verifyNotEditable", parentLocator, locator, null);
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

    public void verifyNotExistsInDatabase(String sql) throws Throwable {
        runCommand("verifyNotExistsInDatabase", sql, null, null);
    }

    public void verifyNotExpression(String expression, String text) throws Throwable {
        runCommand("verifyNotExpression", expression, text, null);
    }

    public void verifyNotText(String locator, String text) throws Throwable {
        runCommand("verifyNotText", locator, text, null);
    }

    public void verifyNotText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyNotText", parentLocator, locator, text);
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

    public void verifyText(String locator, String text) throws Throwable {
        runCommand("verifyText", locator, text, null);
    }

    public void verifyText(String parentLocator, String locator, String text) throws Throwable {
        runCommand("verifyText", parentLocator, locator, text);
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

    public void waitForEditable(String locator) throws Throwable {
        runCommand("waitForEditable", locator, null, null);
    }

    public void waitForEditable(String parentLocator, String locator) throws Throwable {
        runCommand("waitForEditable", parentLocator, locator, null);
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

    public void waitForNotEnabled(String locator) throws Throwable {
        runCommand("waitForNotEnabled", locator, null, null);
    }

    public void waitForNotEnabled(String parentLocator, String locator) throws Throwable {
        runCommand("waitForNotEnabled", parentLocator, locator, null);
    }

    public void waitForNotEval(String expression, String text) throws Throwable {
        runCommand("waitForNotEval", expression, text, null);
    }

    public void waitForNotExistsInDatabase(String sql) throws Throwable {
        runCommand("waitForNotExistsInDatabase", sql, null, null);
    }

    public void waitForNotExpression(String expression, String text) throws Throwable {
        runCommand("waitForNotExpression", expression, text, null);
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
