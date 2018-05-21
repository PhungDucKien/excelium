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
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverFactory;
import excelium.core.exception.AssertFailedException;
import excelium.core.executor.CommandExecutor;
import excelium.core.report.TestReporter;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Executes all tests of a workbook test file
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.05.05
 */
public class TestRunner<W, S> {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Test object
     */
    private final Test<W, S> test;

    /**
     * Project instance
     */
    private Project project;

    /**
     * Test reporter
     */
    private TestReporter<W, S> testReporter;

    /**
     * Test writer
     */
    private final TestWriter testWriter;

    /**
     * Template
     */
    private final Template template;

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
    private TestSuite<S> testSuite;

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
    TestRunner(Test<W, S> test, Project project, TestReporter testReporter, TestWriter testWriter, Template template) {
        this.test = test;
        this.project = project;
        this.testReporter = testReporter;
        this.testWriter = testWriter;
        this.template = template;
    }

    /**
     * Run all tests on all environments.
     *
     * @throws IOException the io exception
     */
    void runAll() throws IOException {
        testReporter.startTest(test);
        testStepResultMap = new HashMap<>();
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
    private void runEnvironment(Environment environment) throws IOException {
        setEnvironment(environment);
        try {
            webDriver = DriverFactory.createDriver(environment, project);
            commandMap = CommandFactory.createCommandMap(getCommandExecutors());
            for (TestSuite<S> testSuite : test.getTestSuites().values()) {
                runTestSuite(testSuite);
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
    private void runTestSuite(TestSuite<S> testSuite) throws IOException {
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
    private Result runTestFlow(TestFlow testFlow) throws IOException {
        testReporter.startTestFlow(testFlow);
        Result flowResult = Result.OK;
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
        testReporter.endTestFlow(testFlow);
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
    private StepResult runTestStep(TestStep testStep, boolean writeResult) throws IOException {
        Command command = commandMap.get(testStep.getCommand());

        if (command != null) {
            Object param1 = getParam(command.getParam1(), testStep.getParam1());
            Object param2 = getParam(command.getParam2(), testStep.getParam2());
            Object param3 = getParam(command.getParam3(), testStep.getParam3());
            StepResult result = runCommand(command, param1, param2, param3);

            if (writeResult) {
                writeResult(testStep, result.getResult());
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
     * Get the list of command executors of current environment
     *
     * @return the list of command executors
     */
    private List<CommandExecutor> getCommandExecutors() {
        List<CommandExecutor> commandExecutors = new ArrayList<>();

        if (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment) {
//            commandExecutors.add(new WebCommandExecutor(this.webDriver, this));
        }

        return commandExecutors;
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
     */
    public Result runAction(String actionName) throws IOException {
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
    private void setTestSuite(TestSuite<S> testSuite) {
        this.testSuite = testSuite;
        testReporter.startTestSuite(testSuite);
    }
}
