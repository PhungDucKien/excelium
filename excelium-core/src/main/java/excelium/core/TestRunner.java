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

import excelium.core.command.CommandFactory;
import excelium.core.database.DatabaseService;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverFactory;
import excelium.core.exception.AssertFailedException;
import excelium.core.executor.CommandExecutor;
import excelium.core.executor.ExecutorProviderService;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

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
     * Current command map of environment
     */
    private Map<String, Command> commandMap;

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
        this.screenshotService = new ScreenshotService(this, project);
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
     * @throws IOException the io exception
     */
    private void runEnvironment(Environment environment) throws IOException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        setEnvironment(environment);
        try {
            webDriver = DriverFactory.createDriver(environment, project);
            String baseUrl = test.getConfig() != null ? test.getConfig().getBaseUrl() : null;
            commandMap = CommandFactory.createCommandMap(environment, webDriver, baseUrl, this);
            if (test.getTestSuites() != null) {
                for (TestSuite testSuite : test.getTestSuites().values()) {
                    runTestSuite(testSuite);
                }
            }
        } finally {
            commandMap = null;
            if (this.webDriver != null) {
                this.webDriver.quit();
                this.webDriver = null;
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
        Command command = commandMap.get(testStep.getCommand());

        if (command != null) {
            if (StringUtils.isNotBlank(testStep.getTestData())) {
                databaseService.createTestData(test.getTestData().get(testStep.getTestData()).getTableData());
            }

            Object param1 = getParam(command.getParam1(), testStep.getParam1());
            Object param2 = getParam(command.getParam2(), testStep.getParam2());
            Object param3 = getParam(command.getParam3(), testStep.getParam3());
            StepResult result = runCommand(command, param1, param2, param3);

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
     * @param command the command
     * @param param1  value of parameter 1
     * @param param2  value of parameter 2
     * @param param3  value of parameter 3
     * @return Result of the command
     */
    private StepResult runCommand(Command command, Object param1, Object param2, Object param3) {
        try {
            command.getConsumer().accept(param1, param2, param3);
            return new StepResult(Result.OK);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof AssertFailedException) {
                return new StepResult(Result.FAIL, StringUtils.startsWithIgnoreCase(command.getMethod(), "verify"), "Assertion failed: " + e.getCause().getMessage());
            } else {
                return new StepResult(Result.ERROR, false, "Invoke command " + command.getName() + " error: " + e.getCause().getMessage());
            }
        } catch (AssertFailedException e) {
            return new StepResult(Result.FAIL, StringUtils.startsWithIgnoreCase(command.getMethod(), "verify"), "Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            return new StepResult(Result.ERROR, false, "Invoke command " + command.getName() + " error: " + e.getMessage());
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
            String param = getItemValue(rawValue);
            if ("url".equals(paramName) && param.startsWith("/")) {
                param = test.getConfig().getBaseUrl() + param;
            }
            return param;
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
        for (PageSet pageSet : pageSets.values()) {
            if (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment) {
                String currentPath = webDriver.getCurrentUrl();
                String currentTitle = webDriver.getTitle();
                if ((StringUtils.isNotBlank(pageSet.getPath()) && !Pattern.compile(pageSet.getPath()).matcher(currentPath).matches()) ||
                        (StringUtils.isNotBlank(pageSet.getTitle()) && !Pattern.compile(pageSet.getTitle()).matcher(currentTitle).matches())) {
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
     * Run the action using the action name
     *
     * @param actionName action name
     * @return the result of action execution
     * @throws IOException            the io exception
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Result runAction(String actionName) throws IOException, SQLException, ClassNotFoundException {
        if (StringUtils.isBlank(actionName)) {
            return Result.ERROR;
        }
        for (TestAction action : test.getActions().values()) {
            if (action.getName().equals(actionName)) {
                return runTestFlow(action);
            }
        }
        return Result.ERROR;
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
