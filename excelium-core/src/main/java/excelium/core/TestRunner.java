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

package excelium.core;

import excelium.common.WildcardUtil;
import excelium.core.database.DatabaseService;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverFactory;
import excelium.core.exception.AssertFailedException;
import excelium.core.report.TestReporter;
import excelium.core.screenshot.ScreenshotService;
import excelium.core.writer.TestWriter;
import excelium.model.enums.Platform;
import excelium.model.enums.Result;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.test.*;
import excelium.model.test.action.TestAction;
import excelium.model.test.command.Command;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.MobileWebEnvironment;
import excelium.model.test.config.PcEnvironment;
import excelium.model.test.item.Item;
import excelium.model.test.item.PageSet;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Executes all tests of a workbook test file
 *
 * @author PhungDucKien
 * @since 2018.05.05
 */
public class TestRunner {

    /**
     * Test object
     */
    private final Test test;

    /**
     * Project instance
     */
    private Project project;

    /**
     * Test reporter
     */
    private TestReporter testReporter;

    /**
     * Test writer
     */
    private final TestWriter testWriter;

    /**
     * Template
     */
    private final Template template;

    /**
     * Database service
     */
    private final DatabaseService databaseService;

    /**
     * Screenshot service
     */
    private final ScreenshotService screenshotService;

    /**
     * Current environment
     */
    private Environment environment;

    /**
     * Current web driver
     */
    private ContextAwareWebDriver webDriver;

    /**
     * Current test suite
     */
    private TestSuite testSuite;

    /**
     * Stack of test flows
     */
    private List<TestFlow> testFlows;

    /**
     * Current test step
     */
    private TestStep testStep;

    /**
     * Map of test result.
     */
    private Map<TestStep, Result> testStepResultMap;

    /**
     * Excelium object
     */
    private Excelium excelium;

    /**
     * Instantiates a new Test runner.
     *
     * @param test         the test
     * @param project      the project
     * @param testReporter the test reporter
     * @param testWriter   the test writer
     * @param template     the template
     */
    public TestRunner(Test test, Project project, TestReporter testReporter, TestWriter testWriter, Template template) {
        this.test = test;
        this.project = project;
        this.testReporter = testReporter;
        this.testWriter = testWriter;
        this.template = template;
        this.databaseService = new DatabaseService(project);
        this.screenshotService = new ScreenshotService(this);
    }

    /**
     * Run all tests on all environments.
     *
     * @throws IOException               the io exception
     * @throws SQLException              the sql exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    public void runAll() throws IOException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        testReporter.startTest(test);
        testStepResultMap = new HashMap<>();
        testFlows = new ArrayList<>();
        for (Environment environment : test.getConfig().getEnvironments()) {
            runEnvironment(environment);
        }
    }

    /**
     * Run all tests on an environment.
     *
     * @param environment the environment
     * @throws IOException               the io exception
     * @throws SQLException              the sql exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     */
    private void runEnvironment(Environment environment) throws IOException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        setEnvironment(environment);
        try {
            webDriver = DriverFactory.createDriver(environment, project);
            if (test.getTestSuites() != null) {
                initializeExcelium(webDriver);
                for (TestSuite testSuite : test.getTestSuites().values()) {
                    runTestSuite(testSuite);
                }
            }
        } finally {
            excelium = null;
            if (webDriver != null) {
                webDriver.quit();
                webDriver = null;
            }
        }
    }

    /**
     * Run a test suite.
     *
     * @param testSuite the test suite
     * @throws IOException the io exception
     */
    private void runTestSuite(TestSuite testSuite) throws IOException, SQLException, ClassNotFoundException {
        setTestSuite(testSuite);
        for (TestCase testCase : testSuite.getTestCases()) {
            runTestFlow(testCase);
        }
    }

    /**
     * Run a test flow
     *
     * @param testFlow the test flow
     * @return Result of the flow
     * @throws IOException the io exception
     */
    private Result runTestFlow(TestFlow testFlow) throws IOException, SQLException, ClassNotFoundException {
        Result flowResult = Result.OK;
        try {
            testFlows.add(testFlow);
            testReporter.startTestFlow(testFlow);
            boolean shouldContinue = true;
            for (TestStep testStep : testFlow.getTestSteps()) {
                if (!testStep.isSkipOn(environment)) {
                    if (shouldContinue) {
                        testReporter.startTestStep(testStep);
                        StepResult stepResult = runTestStep(testStep, testFlow instanceof TestCase);
                        testReporter.endTestStep(stepResult);
                        shouldContinue = stepResult.isShouldContinue();
                    } else {
                        testReporter.startTestStep(testStep);
                        testReporter.endTestStep(new StepResult(Result.SKIP));
                    }
                }
            }
        } finally {
            testReporter.endTestFlow();
            testFlows.remove(testFlow);
        }
        return flowResult;
    }

    /**
     * Run a test step
     *
     * @param testStep    test step
     * @param writeResult should write the result to the workbook
     * @return Result of the step
     * @throws IOException the io exception
     */
    private StepResult runTestStep(TestStep testStep, boolean writeResult) throws IOException, SQLException, ClassNotFoundException {
        this.testStep = testStep;
        String methodName = StringUtils.uncapitalize(StringUtils.remove(WordUtils.capitalizeFully(testStep.getCommand()), " "));
        Command command = excelium.getCommandMap().get(methodName + "(" + countParam(testStep) + ")");

        if (command != null) {
            if (StringUtils.isNotBlank(testStep.getTestData())) {
                databaseService.createTestData(test.getTestData().get(testStep.getTestData()).getTableData());
            }

            Object param1 = getParam(command.getParam1(), testStep.getParam1());
            Object param2 = getParam(command.getParam2(), testStep.getParam2());
            Object param3 = getParam(command.getParam3(), testStep.getParam3());
            StepResult result = runCommand(methodName, param1, param2, param3);

            if (writeResult) {
                writeResult(testStep, result.getResult());
            }

            if (testStep.isCapture()) {
                screenshotService.captureEntirePage(webDriver);
            }

            return result;
        }

        if (writeResult) {
            writeResult(testStep, Result.ERROR);
        }
        return new StepResult(Result.ERROR, false, "Command not found: " + testStep.getCommand());
    }

    /**
     * Run the command.
     *
     * @param methodName the method name
     * @param param1  value of parameter 1
     * @param param2  value of parameter 2
     * @param param3  value of parameter 3
     * @return Result of the command
     */
    private StepResult runCommand(String methodName, Object param1, Object param2, Object param3) {
        try {
            excelium.runCommand(methodName, param1, param2, param3);
            return new StepResult(Result.OK);
        } catch (AssertFailedException e) {
            return new StepResult(Result.FAIL, StringUtils.startsWithIgnoreCase(methodName, "verify"), "Assertion failed: " + e.getMessage());
        } catch (Throwable e) {
            return new StepResult(Result.ERROR, false, "Invoke command " + methodName + " error: " + e.getMessage());
        }
    }

    /**
     * Initialize Excelium object.
     *
     * @param webDriver the web driver
     */
    private void initializeExcelium(ContextAwareWebDriver webDriver) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String baseUrl = test.getConfig() != null ? test.getConfig().getBaseUrl() : null;
        excelium = new Excelium(webDriver, baseUrl, project);

        if (test.getActions() != null && !test.getActions().isEmpty()) {
            for (TestAction action : test.getActions().values()) {
                excelium.addAction(action.getName(),  (input) -> {
                    runTestFlow(action);
                });
            }
        }
    }

    /**
     * Get the value of the parameter
     *
     * @param paramName the name of parameter
     * @param rawValue  the raw value of parameter
     * @return the value of parameter
     */
    private Object getParam(String paramName, String rawValue) {
        if (StringUtils.isBlank(rawValue)) {
            return null;
        }
        if (paramName.endsWith("Array")) {
            String[] items = rawValue.split("[,\n]");
            String[] values = new String[items.length];
            int i = 0;
            for (String item : items) {
                values[i] = (String) getParam(paramName.replace("Array", ""), item.trim());
                i++;
            }
            return values;
        }
        if (StringUtils.endsWithIgnoreCase(paramName, "locator") ||
                "activity".equals(paramName) ||
                "url".equals(paramName) ||
                "file".equals(paramName)) {
            return getItemValue(rawValue);
        }
        return rawValue;
    }

    /**
     * Get value of the item
     *
     * @param rawValue the raw value of item
     * @return value of item
     */
    private String getItemValue(String rawValue) {
        String itemValue = rawValue;
        Item item = getItem(rawValue);
        if (item != null) {
            if (environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.ANDROID) {
                itemValue = item.getAndroidValue();
            } else if (environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.IOS) {
                itemValue = item.getIosValue();
            } else {
                itemValue = item.getValue();
            }
        }
        return itemValue;
    }

    /**
     * Get the item
     *
     * @param itemName item name
     * @return the item
     */
    private Item getItem(String itemName) {
        Map<String, PageSet> pageSets = test.getPageSets();
        String baseUrl = test.getConfig() != null ? test.getConfig().getBaseUrl() : null;

        for (PageSet pageSet : pageSets.values()) {
            if (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment) {
                String currentPath = webDriver.getCurrentUrl();
                String currentTitle = webDriver.getTitle();

                String pageSetPath = baseUrl != null && !pageSet.getPath().contains("://") ?
                        baseUrl + (!pageSet.getPath().startsWith("/") ? "/" : "") + pageSet.getPath() :
                        pageSet.getPath();
                if ((StringUtils.isNotBlank(pageSet.getPath()) && !WildcardUtil.isMatch(currentPath, pageSetPath)) ||
                        (StringUtils.isNotBlank(pageSet.getTitle()) && !WildcardUtil.isMatch(currentTitle, pageSet.getTitle()))) {
                    continue;
                }
            }
            for (Item pageSetItem : pageSet.getItems().values()) {
                if (pageSetItem.getName().equals(itemName)) {
                    return pageSetItem;
                }
            }
        }
        return null;
    }

    /**
     * Write test result to the workbook
     *
     * @param testStep  the test step
     * @param result    the result to write
     * @throws IOException the io exception
     */
    private void writeResult(TestStep testStep, Result result) throws IOException {
        Result curResult = testStepResultMap.get(testStep);
        if (curResult == null || (curResult == Result.OK && result != Result.OK)) {
            testWriter.writeResult(template, testSuite.getSheetName(), testStep, result);
            testStepResultMap.put(testStep, result);
        }
    }

    /**
     * Count the number of parameters of the test step.
     *
     * @param testStep the test step
     * @return the number of parameters
     */
    private static int countParam(TestStep testStep) {
        int count = 0;
        if (StringUtils.isNotBlank(testStep.getParam1())) count++;
        if (StringUtils.isNotBlank(testStep.getParam2())) count++;
        if (StringUtils.isNotBlank(testStep.getParam3())) count++;
        return count;
    }

    /**
     * Sets environment.
     *
     * @param environment the environment
     */
    private void setEnvironment(Environment environment) {
        this.environment = environment;
        testReporter.startEnvironment(environment);
    }

    /**
     * Sets test suite.
     *
     * @param testSuite the test suite
     */
    private void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
        testReporter.startTestSuite(testSuite);
    }

    /**
     * Gets project.
     *
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Gets test.
     *
     * @return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * Gets test suite.
     *
     * @return the test suite
     */
    public TestSuite getTestSuite() {
        return testSuite;
    }

    /**
     * Gets test flows.
     *
     * @return the test flows
     */
    public List<TestFlow> getTestFlows() {
        return testFlows;
    }

    /**
     * Gets test step.
     *
     * @return the test step
     */
    public TestStep getTestStep() {
        return testStep;
    }
}
