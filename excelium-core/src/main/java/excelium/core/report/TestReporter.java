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

package excelium.core.report;

import excelium.model.enums.Result;
import excelium.model.test.*;
import excelium.model.test.config.Environment;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.fusesource.jansi.Ansi;

import java.io.PrintStream;

import static org.apache.commons.lang3.StringUtils.rightPad;

/**
 * A console-based Test state reporter
 *
 * @author PhungDucKien
 * @since 2018.05.14
 */
public class TestReporter {

    /**
     * State
     */
    private TestState testState;

    /**
     * Console stream
     */
    private PrintStream consoleStream;

    /**
     * Padding to the flow
     */
    private int flowPadding;

    /**
     * Instantiates a new Test reporter.
     *
     * @param consoleStream the console stream
     */
    public TestReporter(PrintStream consoleStream) {
        this.consoleStream = consoleStream;

        testState = new TestState();
        consoleStream.println();
    }

    /**
     * Notify that a test is about to start.
     *
     * @param test the test
     */
    public void startTest(Test test) {
        testState.setTest(test);
        resetTestCount(test);

        printFixLine("Workbook: " + test.getWorkbookName(), 0, true, null);
        printCounts();
    }

    /**
     * Notify that the test on an environment is about to start.
     *
     * @param environment the environment
     */
    public void startEnvironment(Environment environment) {
        testState.setEnvironment(environment);
        resetEnvironmentCount(environment, testState.getTest());

        printFixLine("Environment: " + testState.getEnvironment().getKey(), 2, true, null);
        printCounts();
    }

    /**
     * Notify that a test suite is about to start.
     *
     * @param testSuite the test suite
     */
    public void startTestSuite(TestSuite testSuite) {
        resetSuiteCount(testSuite, testState.getEnvironment());

        printFixLine("Sheet: " + testSuite.getSheetName(), 4, true, null);
        printCounts();
    }

    /**
     * Notify that a test flow is about to start.
     *
     * @param testFlow the test flow
     */
    public void startTestFlow(TestFlow testFlow) {
        if (testFlow instanceof TestCase) {
            resetCaseCount((TestCase) testFlow, testState.getEnvironment());
        }
        flowPadding += 2;

        printFixLine(testFlow.getName(), 4 + flowPadding, false, null);
        printCounts();
    }

    /**
     * Notify that a test flow is finished.
     */
    public void endTestFlow() {
        flowPadding -= 2;
    }

    /**
     * Notify that a test step is about to start.
     *
     * @param testStep the test step
     */
    public void startTestStep(TestStep testStep) {
        printFixLine(rightPad(testStep.getCommand(), 30) +
                (StringUtils.isNotBlank(testStep.getParam1()) ? "  " + rightPad(testStep.getParam1(), 30) : "") +
                (StringUtils.isNotBlank(testStep.getParam2()) ? "  " + rightPad(testStep.getParam2(), 30) : "") +
                (StringUtils.isNotBlank(testStep.getParam3()) ? "  " + rightPad(testStep.getParam3(), 30) : ""), 6 + flowPadding, false, null);
        printCounts();
    }

    /**
     * Notify that a test step is finished.
     * Print the test step result and message (if any) out to the console.
     *
     * @param result the result
     */
    public void endTestStep(StepResult result) {
        if (flowPadding == 2) {
            // Changes the counts for main steps
            increaseExecutedCount(1);
            switch (result.getResult()) {
                case ERROR:
                    increaseErrorCount(1);
                    break;
                case FAIL:
                    increaseFailedCount(1);
                    break;
                case SKIP:
                    increaseSkippedCount(1);
                    break;
            }
        }
        if (result.getResult() != Result.OK) {
            printFixLine(rightPad(result.getResult().name(), 5) +
                    (StringUtils.isNotBlank(result.getMessage()) ? "  " + result.getMessage() : ""), 8 + flowPadding, false, Ansi.Color.RED);
        }
        printCounts();
    }

    /**
     * Increase executed count.
     *
     * @param count the count
     */
    private void increaseExecutedCount(int count) {
        testState.setCaseExecutedCount(testState.getCaseExecutedCount() + count);
        testState.setSuiteExecutedCount(testState.getSuiteExecutedCount() + count);
        testState.setEnvironmentExecutedCount(testState.getEnvironmentExecutedCount() + count);
        testState.setTestExecutedCount(testState.getTestExecutedCount() + count);
    }

    /**
     * Increase error count.
     *
     * @param count the count
     */
    private void increaseErrorCount(int count) {
        testState.setCaseErrorCount(testState.getCaseErrorCount() + count);
        testState.setSuiteErrorCount(testState.getSuiteErrorCount() + count);
        testState.setEnvironmentErrorCount(testState.getEnvironmentErrorCount() + count);
        testState.setTestErrorCount(testState.getTestErrorCount() + count);
    }

    /**
     * Increase failed count.
     *
     * @param count the count
     */
    private void increaseFailedCount(int count) {
        testState.setCaseFailedCount(testState.getCaseFailedCount() + count);
        testState.setSuiteFailedCount(testState.getSuiteFailedCount() + count);
        testState.setEnvironmentFailedCount(testState.getEnvironmentFailedCount() + count);
        testState.setTestFailedCount(testState.getTestFailedCount() + count);
    }

    /**
     * Increase skipped count.
     *
     * @param count the count
     */
    private void increaseSkippedCount(int count) {
        testState.setCaseSkippedCount(testState.getCaseSkippedCount() + count);
        testState.setSuiteSkippedCount(testState.getSuiteSkippedCount() + count);
        testState.setEnvironmentSkippedCount(testState.getEnvironmentSkippedCount() + count);
        testState.setTestSkippedCount(testState.getTestSkippedCount() + count);
    }

    /**
     * Reset test count.
     *
     * @param test the test
     */
    private void resetTestCount(Test test) {
        testState.setTestTotalCount(countTestStep(test));
        testState.setTestExecutedCount(0);
        testState.setTestErrorCount(0);
        testState.setTestFailedCount(0);
        testState.setTestSkippedCount(0);

        resetEnvironmentCount(null, test);
    }

    /**
     * Reset environment count.
     *
     * @param environment the environment
     * @param test        the test
     */
    private void resetEnvironmentCount(Environment environment, Test test) {
        testState.setEnvironmentTotalCount(countTestStep(test, environment));
        testState.setEnvironmentExecutedCount(0);
        testState.setEnvironmentErrorCount(0);
        testState.setEnvironmentFailedCount(0);
        testState.setEnvironmentSkippedCount(0);

        resetSuiteCount(null, environment);
    }

    /**
     * Reset suite count.
     *
     * @param suite       the suite
     * @param environment the environment
     */
    private void resetSuiteCount(TestSuite suite, Environment environment) {
        testState.setSuiteTotalCount(countTestStep(suite, environment));
        testState.setSuiteExecutedCount(0);
        testState.setSuiteErrorCount(0);
        testState.setSuiteFailedCount(0);
        testState.setSuiteSkippedCount(0);

        resetCaseCount(null, environment);
    }

    /**
     * Reset case count.
     *
     * @param testCase    the test case
     * @param environment the environment
     */
    private void resetCaseCount(TestCase testCase, Environment environment) {
        testState.setCaseTotalCount(countTestStep(testCase, environment));
        testState.setCaseExecutedCount(0);
        testState.setCaseErrorCount(0);
        testState.setCaseFailedCount(0);
        testState.setCaseSkippedCount(0);
    }

    /**
     * Count test step long.
     *
     * @param test the test
     * @return the long
     */
    private long countTestStep(Test test) {
        if (test == null || test.getConfig() == null || CollectionUtils.isEmpty(test.getConfig().getEnvironments())) {
            return 0;
        }
        int testTotalCount = 0;
        for (Environment environment : test.getConfig().getEnvironments()) {
            testTotalCount += countTestStep(test, environment);
        }
        return testTotalCount;
    }

    /**
     * Count test step long.
     *
     * @param test        the test
     * @param environment the environment
     * @return the long
     */
    private long countTestStep(Test test, Environment environment) {
        if (test == null || test.getTestSuites() == null || test.getTestSuites().isEmpty()) {
            return 0;
        }
        int environmentTotalCount = 0;
        for (TestSuite suite : test.getTestSuites().values()) {
            environmentTotalCount += countTestStep(suite, environment);
        }
        return environmentTotalCount;
    }

    /**
     * Count test step long.
     *
     * @param suite       the suite
     * @param environment the environment
     * @return the long
     */
    private long countTestStep(TestSuite suite, Environment environment) {
        if (suite == null || CollectionUtils.isEmpty(suite.getTestCases())) {
            return 0;
        }
        int suiteTotalCount = 0;
        for (TestCase testCase : suite.getTestCases()) {
            suiteTotalCount += countTestStep(testCase, environment);
        }
        return suiteTotalCount;
    }

    /**
     * Count test step long.
     *
     * @param testCase    the test case
     * @param environment the environment
     * @return the long
     */
    private long countTestStep(TestCase testCase, Environment environment) {
        if (testCase == null || CollectionUtils.isEmpty(testCase.getTestSteps())) {
            return 0;
        }
        return testCase.getTestSteps().stream().filter((step) -> !step.isSkipOn(environment)).count();
    }

    /**
     * Print counts.
     */
    private void printCounts() {
        printTempLine("Runs: " + testState.getTestExecutedCount() + "/" + testState.getTestTotalCount() +
                "          Errors: " + testState.getTestErrorCount() +
                "          Fails: " + testState.getTestFailedCount() +
                "          Skips: " + testState.getTestSkippedCount(), 0);
    }

    /**
     * Print fix line.
     *
     * @param text    the text
     * @param padding the padding
     */
    private void printFixLine(String text, int padding, boolean bold, Ansi.Color color) {
        consoleStream.print(Ansi.ansi().cursorUp(1).eraseLine());
        Ansi ansi = Ansi.ansi();
        if (bold) {
            ansi = ansi.bold();
        }
        if (color != null) {
            ansi = ansi.fg(color);
        }
        consoleStream.println(ansi.a(rightPad("", padding) + text).reset().toString());
        consoleStream.println();
    }

    /**
     * Print temp line.
     *
     * @param text    the text
     * @param padding the padding
     */
    private void printTempLine(String text, int padding) {
        consoleStream.print(Ansi.ansi().cursorUp(1).eraseLine());
        consoleStream.println(rightPad("", padding) + text);
    }
}
