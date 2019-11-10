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

    public void acceptTouchID() throws Throwable {
        runCommand("acceptTouchID", null, null, null);
    }

    public void activateApp(String bundleId) throws Throwable {
        runCommand("activateApp", bundleId, null, null);
    }

    public void answerPrompt(String answer) throws Throwable {
        runCommand("answerPrompt", answer, null, null);
    }

    public void assertActivity(String activity) throws Throwable {
        runCommand("assertActivity", activity, null, null);
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

    public void assertContext(String text) throws Throwable {
        runCommand("assertContext", text, null, null);
    }

    public void assertContextMatch(String text) throws Throwable {
        runCommand("assertContextMatch", text, null, null);
    }

    public void assertContextNotMatch(String text) throws Throwable {
        runCommand("assertContextNotMatch", text, null, null);
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

    public void assertElementNotPresent(String locator) throws Throwable {
        runCommand("assertElementNotPresent", locator, null, null);
    }

    public void assertElementNotPresent(String parentLocator, String locator) throws Throwable {
        runCommand("assertElementNotPresent", parentLocator, locator, null);
    }

    public void assertElementPresent(String locator) throws Throwable {
        runCommand("assertElementPresent", locator, null, null);
    }

    public void assertElementPresent(String parentLocator, String locator) throws Throwable {
        runCommand("assertElementPresent", parentLocator, locator, null);
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

    public void assertNotActivity(String activity) throws Throwable {
        runCommand("assertNotActivity", activity, null, null);
    }

    public void assertNotAlert(String text) throws Throwable {
        runCommand("assertNotAlert", text, null, null);
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

    public void assertNotConfirmation(String text) throws Throwable {
        runCommand("assertNotConfirmation", text, null, null);
    }

    public void assertNotContext(String text) throws Throwable {
        runCommand("assertNotContext", text, null, null);
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

    public void assertNotPageSource(String text) throws Throwable {
        runCommand("assertNotPageSource", text, null, null);
    }

    public void assertNotPrompt(String text) throws Throwable {
        runCommand("assertNotPrompt", text, null, null);
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

    public void assertRowCount(String sql, String count) throws Throwable {
        runCommand("assertRowCount", sql, count, null);
    }

    public void assertRowCountGreaterThan(String sql, String count) throws Throwable {
        runCommand("assertRowCountGreaterThan", sql, count, null);
    }

    public void assertRowCountLessThan(String sql, String count) throws Throwable {
        runCommand("assertRowCountLessThan", sql, count, null);
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

    public void assertTextNotPresent(String text) throws Throwable {
        runCommand("assertTextNotPresent", text, null, null);
    }

    public void assertTextPresent(String text) throws Throwable {
        runCommand("assertTextPresent", text, null, null);
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

    public void broadcastIntent(String intent) throws Throwable {
        runCommand("broadcastIntent", intent, null, null);
    }

    public void captureScreenshot() throws Throwable {
        runCommand("captureScreenshot", null, null, null);
    }

    public void captureViewport() throws Throwable {
        runCommand("captureViewport", null, null, null);
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

    public void clickButton(String indexOrText) throws Throwable {
        runCommand("clickButton", indexOrText, null, null);
    }

    public void clickText(String indexOrText) throws Throwable {
        runCommand("clickText", indexOrText, null, null);
    }

    public void closeApp() throws Throwable {
        runCommand("closeApp", null, null, null);
    }

    public void doubleTap(String locator) throws Throwable {
        runCommand("doubleTap", locator, null, null);
    }

    public void doubleTap(String parentLocator, String locator) throws Throwable {
        runCommand("doubleTap", parentLocator, locator, null);
    }

    public void doubleTapAt(String coordinate) throws Throwable {
        runCommand("doubleTapAt", coordinate, null, null);
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

    public void executeIfActivity(String action, String activity) throws Throwable {
        runCommand("executeIfActivity", action, activity, null);
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

    public void executeIfContext(String action, String text) throws Throwable {
        runCommand("executeIfContext", action, text, null);
    }

    public void executeIfContextMatch(String action, String text) throws Throwable {
        runCommand("executeIfContextMatch", action, text, null);
    }

    public void executeIfContextNotMatch(String action, String text) throws Throwable {
        runCommand("executeIfContextNotMatch", action, text, null);
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

    public void executeIfNotActivity(String action, String activity) throws Throwable {
        runCommand("executeIfNotActivity", action, activity, null);
    }

    public void executeIfNotAlert(String action, String text) throws Throwable {
        runCommand("executeIfNotAlert", action, text, null);
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

    public void executeIfNotContext(String action, String text) throws Throwable {
        runCommand("executeIfNotContext", action, text, null);
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

    public void executeIfNotPageSource(String action, String text) throws Throwable {
        runCommand("executeIfNotPageSource", action, text, null);
    }

    public void executeIfNotPrompt(String action, String text) throws Throwable {
        runCommand("executeIfNotPrompt", action, text, null);
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

    public void executeIfTextNotPresent(String action, String text) throws Throwable {
        runCommand("executeIfTextNotPresent", action, text, null);
    }

    public void executeIfTextPresent(String action, String text) throws Throwable {
        runCommand("executeIfTextPresent", action, text, null);
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

    public void fingerPrint(String fingerPrintId) throws Throwable {
        runCommand("fingerPrint", fingerPrintId, null, null);
    }

    public void goBack() throws Throwable {
        runCommand("goBack", null, null, null);
    }

    public void hideKeyboard() throws Throwable {
        runCommand("hideKeyboard", null, null, null);
    }

    public void landscape() throws Throwable {
        runCommand("landscape", null, null, null);
    }

    public void launchApp() throws Throwable {
        runCommand("launchApp", null, null, null);
    }

    public void lock() throws Throwable {
        runCommand("lock", null, null, null);
    }

    public void longPress(String locator) throws Throwable {
        runCommand("longPress", locator, null, null);
    }

    public void longPress(String parentLocator, String locator) throws Throwable {
        runCommand("longPress", parentLocator, locator, null);
    }

    public void longPressAt(String coordinate) throws Throwable {
        runCommand("longPressAt", coordinate, null, null);
    }

    public void openNotifications() throws Throwable {
        runCommand("openNotifications", null, null, null);
    }

    public void pause(String waitTime) throws Throwable {
        runCommand("pause", waitTime, null, null);
    }

    public void portrait() throws Throwable {
        runCommand("portrait", null, null, null);
    }

    public void rejectTouchID() throws Throwable {
        runCommand("rejectTouchID", null, null, null);
    }

    public void reloadApp() throws Throwable {
        runCommand("reloadApp", null, null, null);
    }

    public void resetApp() throws Throwable {
        runCommand("resetApp", null, null, null);
    }

    public void rotate(String rotation) throws Throwable {
        runCommand("rotate", rotation, null, null);
    }

    public void runAppInBackground(String millis) throws Throwable {
        runCommand("runAppInBackground", millis, null, null);
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

    public void setClipboard(String text) throws Throwable {
        runCommand("setClipboard", text, null, null);
    }

    public void setContext(String context) throws Throwable {
        runCommand("setContext", context, null, null);
    }

    public void setGeolocation(String location) throws Throwable {
        runCommand("setGeolocation", location, null, null);
    }

    public void setTimeout(String timeout) throws Throwable {
        runCommand("setTimeout", timeout, null, null);
    }

    public void shake() throws Throwable {
        runCommand("shake", null, null, null);
    }

    public void startActivity(String activity) throws Throwable {
        runCommand("startActivity", activity, null, null);
    }

    public void store(String text, String variable) throws Throwable {
        runCommand("store", text, variable, null);
    }

    public void storeAlert(String variable) throws Throwable {
        runCommand("storeAlert", variable, null, null);
    }

    public void storeAttribute(String locator, String name, String variable) throws Throwable {
        runCommand("storeAttribute", locator, name, variable);
    }

    public void storeConfirmation(String variable) throws Throwable {
        runCommand("storeConfirmation", variable, null, null);
    }

    public void storeContext(String variable) throws Throwable {
        runCommand("storeContext", variable, null, null);
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

    public void storePageSource(String variable) throws Throwable {
        runCommand("storePageSource", variable, null, null);
    }

    public void storePrompt(String variable) throws Throwable {
        runCommand("storePrompt", variable, null, null);
    }

    public void storePush(String text, String variable) throws Throwable {
        runCommand("storePush", text, variable, null);
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

    public void storeValue(String locator, String variable) throws Throwable {
        runCommand("storeValue", locator, variable, null);
    }

    public void storeValue(String parentLocator, String locator, String variable) throws Throwable {
        runCommand("storeValue", parentLocator, locator, variable);
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

    public void tap(String locator) throws Throwable {
        runCommand("tap", locator, null, null);
    }

    public void tap(String parentLocator, String locator) throws Throwable {
        runCommand("tap", parentLocator, locator, null);
    }

    public void tapAt(String coordinate) throws Throwable {
        runCommand("tapAt", coordinate, null, null);
    }

    public void terminateApp(String bundleId) throws Throwable {
        runCommand("terminateApp", bundleId, null, null);
    }

    public void toggleAirplaneMode() throws Throwable {
        runCommand("toggleAirplaneMode", null, null, null);
    }

    public void toggleLocationServices() throws Throwable {
        runCommand("toggleLocationServices", null, null, null);
    }

    public void toggleWifi() throws Throwable {
        runCommand("toggleWifi", null, null, null);
    }

    public void type(String locator, String value) throws Throwable {
        runCommand("type", locator, value, null);
    }

    public void type(String parentLocator, String locator, String value) throws Throwable {
        runCommand("type", parentLocator, locator, value);
    }

    public void unlock() throws Throwable {
        runCommand("unlock", null, null, null);
    }

    public void verifyActivity(String activity) throws Throwable {
        runCommand("verifyActivity", activity, null, null);
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

    public void verifyContext(String text) throws Throwable {
        runCommand("verifyContext", text, null, null);
    }

    public void verifyContextMatch(String text) throws Throwable {
        runCommand("verifyContextMatch", text, null, null);
    }

    public void verifyContextNotMatch(String text) throws Throwable {
        runCommand("verifyContextNotMatch", text, null, null);
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

    public void verifyElementNotPresent(String locator) throws Throwable {
        runCommand("verifyElementNotPresent", locator, null, null);
    }

    public void verifyElementNotPresent(String parentLocator, String locator) throws Throwable {
        runCommand("verifyElementNotPresent", parentLocator, locator, null);
    }

    public void verifyElementPresent(String locator) throws Throwable {
        runCommand("verifyElementPresent", locator, null, null);
    }

    public void verifyElementPresent(String parentLocator, String locator) throws Throwable {
        runCommand("verifyElementPresent", parentLocator, locator, null);
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

    public void verifyNotActivity(String activity) throws Throwable {
        runCommand("verifyNotActivity", activity, null, null);
    }

    public void verifyNotAlert(String text) throws Throwable {
        runCommand("verifyNotAlert", text, null, null);
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

    public void verifyNotConfirmation(String text) throws Throwable {
        runCommand("verifyNotConfirmation", text, null, null);
    }

    public void verifyNotContext(String text) throws Throwable {
        runCommand("verifyNotContext", text, null, null);
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

    public void verifyNotPageSource(String text) throws Throwable {
        runCommand("verifyNotPageSource", text, null, null);
    }

    public void verifyNotPrompt(String text) throws Throwable {
        runCommand("verifyNotPrompt", text, null, null);
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

    public void verifyRowCount(String sql, String count) throws Throwable {
        runCommand("verifyRowCount", sql, count, null);
    }

    public void verifyRowCountGreaterThan(String sql, String count) throws Throwable {
        runCommand("verifyRowCountGreaterThan", sql, count, null);
    }

    public void verifyRowCountLessThan(String sql, String count) throws Throwable {
        runCommand("verifyRowCountLessThan", sql, count, null);
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

    public void verifyTextNotPresent(String text) throws Throwable {
        runCommand("verifyTextNotPresent", text, null, null);
    }

    public void verifyTextPresent(String text) throws Throwable {
        runCommand("verifyTextPresent", text, null, null);
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

    public void waitForActivity(String activity) throws Throwable {
        runCommand("waitForActivity", activity, null, null);
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

    public void waitForChecked(String locator) throws Throwable {
        runCommand("waitForChecked", locator, null, null);
    }

    public void waitForChecked(String parentLocator, String locator) throws Throwable {
        runCommand("waitForChecked", parentLocator, locator, null);
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

    public void waitForContext(String text) throws Throwable {
        runCommand("waitForContext", text, null, null);
    }

    public void waitForContextMatch(String text) throws Throwable {
        runCommand("waitForContextMatch", text, null, null);
    }

    public void waitForContextNotMatch(String text) throws Throwable {
        runCommand("waitForContextNotMatch", text, null, null);
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

    public void waitForNotActivity(String activity) throws Throwable {
        runCommand("waitForNotActivity", activity, null, null);
    }

    public void waitForNotAlert(String text) throws Throwable {
        runCommand("waitForNotAlert", text, null, null);
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

    public void waitForNotConfirmation(String text) throws Throwable {
        runCommand("waitForNotConfirmation", text, null, null);
    }

    public void waitForNotContext(String text) throws Throwable {
        runCommand("waitForNotContext", text, null, null);
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

    public void waitForNotPageSource(String text) throws Throwable {
        runCommand("waitForNotPageSource", text, null, null);
    }

    public void waitForNotPrompt(String text) throws Throwable {
        runCommand("waitForNotPrompt", text, null, null);
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

    public void waitForPageSource(String text) throws Throwable {
        runCommand("waitForPageSource", text, null, null);
    }

    public void waitForPageSourceMatch(String text) throws Throwable {
        runCommand("waitForPageSourceMatch", text, null, null);
    }

    public void waitForPageSourceNotMatch(String text) throws Throwable {
        runCommand("waitForPageSourceNotMatch", text, null, null);
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

    public void waitForTextNotPresent(String text) throws Throwable {
        runCommand("waitForTextNotPresent", text, null, null);
    }

    public void waitForTextPresent(String text) throws Throwable {
        runCommand("waitForTextPresent", text, null, null);
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
