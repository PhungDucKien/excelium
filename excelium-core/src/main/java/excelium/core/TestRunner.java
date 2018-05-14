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
import excelium.core.writer.TestWriter;
import excelium.model.enums.Platform;
import excelium.model.enums.Result;
import excelium.model.project.Project;
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
     * Test writer
     */
    private final TestWriter testWriter;

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
     * Current test case
     */
    private TestCase testCase;

    /**
     * Current test step
     */
    private TestStep testStep;

    /**
     * Instantiates a new Test runner.
     *
     * @param test       the test
     * @param project    the project
     * @param testWriter the test writer
     */
    TestRunner(Test<W, S> test, Project project, TestWriter testWriter) {
        this.test = test;
        this.project = project;
        this.testWriter = testWriter;
    }

    /**
     * Run all tests on all environments.
     *
     * @throws IOException the io exception
     */
    void runAll() throws IOException {
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
        webDriver = DriverFactory.createDriver(environment, project);
        commandMap = CommandFactory.createCommandMap(getCommandExecutors());
        for (TestSuite<S> testSuite : test.getTestSuites().values()) {
            runTestSuite(testSuite);
        }
    }

    /**
     * Run a test suite.
     *
     * @param testSuite the test suite
     */
    private void runTestSuite(TestSuite<S> testSuite) {
        setTestSuite(testSuite);
        for (TestCase testCase : testSuite.getTestCases()) {
            runTestCase(testCase);
        }
    }

    /**
     * Run a test case.
     *
     * @param testCase the test case
     */
    private void runTestCase(TestCase testCase) {
        setTestCase(testCase);
        boolean shouldContinue = true;
        for (TestStep testStep : testCase.getTestSteps()) {
            if (!shouldSkipStep(testStep, environment)) {
                if (shouldContinue) {
                    StepResult stepResult = runTestStep(testStep, true);
                    shouldContinue = stepResult.isShouldContinue();
                }
            }
        }
    }

    /**
     * Run a test action
     *
     * @param testAction the test action
     * @return Result of the action
     */
    public Result runAction(TestAction testAction) {
        Result actionResult = Result.OK;
        boolean shouldContinue = true;
        for (TestStep testStep : testAction.getTestSteps()) {
            if (!shouldSkipStep(testStep, environment)) {
                if (shouldContinue) {
                    StepResult stepResult = runTestStep(testStep, false);
                    shouldContinue = stepResult.isShouldContinue();
                }
            }
        }
        return actionResult;
    }

    /**
     * Run a test step
     *
     * @param testStep    test step
     * @param writeResult should write the result to the workbook
     * @return Result of the step
     */
    private StepResult runTestStep(TestStep testStep, boolean writeResult) {
        setTestStep(testStep);
        Command command = commandMap.get(testStep.getCommand());

        if (command != null) {
            Object param1 = getParam(command.getParam1(), testStep.getParam1());
            Object param2 = getParam(command.getParam2(), testStep.getParam2());
            Object param3 = getParam(command.getParam3(), testStep.getParam3());
            Result result = runCommand(command, param1, param2, param3);

            if (writeResult) {
//                writeCombineTestStepResult(testStep, result);
            }

            return new StepResult(result, result == Result.OK || (result == Result.FAIL && command.getMethod().startsWith("verify")));
        } else {
            if (writeResult) {
//                writeCombineTestStepResult(testStep, Result.ERROR);
            }
        }
        return new StepResult(Result.ERROR, false);
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
    private Result runCommand(Command command, Object param1, Object param2, Object param3) {
        try {
            command.getConsumer().accept(param1, param2, param3);
            return Result.OK;
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof AssertFailedException) {
                LOG.error("Assertion failed: " + e.getCause().getMessage());
                return Result.FAIL;
            } else {
                LOG.error("Invoke command error: " + command, e);
                return Result.ERROR;
            }
        } catch (Exception e) {
            LOG.error("Invoke command error: " + command, e);
            return Result.ERROR;
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
            Object[] values = new Object[items.length];
            int i = 0;
            for (String item : items) {
                values[i] = getParam(paramName.replace("Array", ""), item.trim());
                i++;
            }
            return values;
        }
        if ("action".equals(paramName)) {
            return getAction(rawValue);
        } else if (StringUtils.endsWithIgnoreCase(paramName, "locator") ||
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
     * Get the action.
     *
     * @param actionName action name
     * @return the action
     */
    private TestAction getAction(String actionName) {
        if (StringUtils.isBlank(actionName)) {
            return null;
        }
        for (TestAction action : test.getActions().values()) {
            if (action.getName().equals(actionName)) {
                return action;
            }
        }
        return null;
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
                if ((StringUtils.isBlank(pageSet.getPath()) || Pattern.compile(pageSet.getPath()).matcher(currentPath).matches()) &&
                        (StringUtils.isBlank(pageSet.getTitle()) || Pattern.compile(pageSet.getTitle()).matcher(currentTitle).matches())) {
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
     * Check whether the step should be skipped.
     *
     * @param testStep the test step
     * @return true if the step should be skipped, otherwise, false
     */
    private boolean shouldSkipStep(TestStep testStep, Environment environment) {
        return (isStepSkip(testStep.getGutter()) && (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment)) ||
                (isStepSkip(testStep.getAndroidGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.ANDROID) ||
                (isStepSkip(testStep.getIosGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.IOS);
    }

    /**
     * Check whether the step is a debug point.
     *
     * @param testStep the test step
     * @return true if the step is a debug point, otherwise, false
     */
    private boolean shouldDebugStep(TestStep testStep, Environment environment) {
        return (isStepDebug(testStep.getGutter()) && (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment)) ||
                (isStepDebug(testStep.getAndroidGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.ANDROID) ||
                (isStepDebug(testStep.getIosGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.IOS);
    }

    /**
     * Check whether the step gutter indicates a skip.
     *
     * @param stepGutter the gutter of the step
     * @return true if the step gutter indicates a skip, otherwise, false
     */
    private boolean isStepSkip(String stepGutter) {
        return StringUtils.isNotBlank(stepGutter) && !StringUtils.equalsAny(stepGutter, "D", "M");
    }

    /**
     * Check whether the step gutter indicates a debug.
     *
     * @param stepGutter the gutter of the step
     * @return true if the step gutter indicates a debug, otherwise, false
     */
    private boolean isStepDebug(String stepGutter) {
        return StringUtils.isNotBlank(stepGutter) && StringUtils.equals(stepGutter, "D");
    }

    /**
     * Sets environment.
     *
     * @param environment the environment
     */
    private void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * Sets test suite.
     *
     * @param testSuite the test suite
     */
    private void setTestSuite(TestSuite<S> testSuite) {
        this.testSuite = testSuite;
    }

    /**
     * Sets test case.
     *
     * @param testCase the test case
     */
    private void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    /**
     * Sets test step.
     *
     * @param testStep the test step
     */
    private void setTestStep(TestStep testStep) {
        this.testStep = testStep;
    }
}
