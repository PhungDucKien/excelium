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

package excelium.model.test;

import excelium.model.test.config.Environment;

/**
 * Represents the state of test execution.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.05.14
 */
public class TestState<W, S> {

    /**
     * The Test.
     */
    private Test<W, S> test;

    /**
     * The Test total count.
     */
    private long testTotalCount;

    /**
     * The Test executed count.
     */
    private long testExecutedCount;

    /**
     * The Test error count.
     */
    private long testErrorCount;

    /**
     * The Test failed count.
     */
    private long testFailedCount;

    /**
     * The Test skipped count.
     */
    private long testSkippedCount;

    /**
     * The Environment.
     */
    private Environment environment;

    /**
     * The Environment total count.
     */
    private long environmentTotalCount;

    /**
     * The Environment executed count.
     */
    private long environmentExecutedCount;

    /**
     * The Environment error count.
     */
    private long environmentErrorCount;

    /**
     * The Environment failed count.
     */
    private long environmentFailedCount;

    /**
     * The Environment skipped count.
     */
    private long environmentSkippedCount;

    /**
     * The Suite total count.
     */
    private long suiteTotalCount;

    /**
     * The Suite executed count.
     */
    private long suiteExecutedCount;

    /**
     * The Suite error count.
     */
    private long suiteErrorCount;

    /**
     * The Suite failed count.
     */
    private long suiteFailedCount;

    /**
     * The Suite skipped count.
     */
    private long suiteSkippedCount;

    /**
     * The Case total count.
     */
    private long caseTotalCount;

    /**
     * The Case executed count.
     */
    private long caseExecutedCount;

    /**
     * The Case error count.
     */
    private long caseErrorCount;

    /**
     * The Case failed count.
     */
    private long caseFailedCount;

    /**
     * The Case skipped count.
     */
    private long caseSkippedCount;

    /**
     * Gets test.
     *
     * @return the test
     */
    public Test<W, S> getTest() {
        return test;
    }

    /**
     * Sets test.
     *
     * @param test the test
     */
    public void setTest(Test<W, S> test) {
        this.test = test;
    }

    /**
     * Gets test total count.
     *
     * @return the test total count
     */
    public long getTestTotalCount() {
        return testTotalCount;
    }

    /**
     * Sets test total count.
     *
     * @param testTotalCount the test total count
     */
    public void setTestTotalCount(long testTotalCount) {
        this.testTotalCount = testTotalCount;
    }

    /**
     * Gets test executed count.
     *
     * @return the test executed count
     */
    public long getTestExecutedCount() {
        return testExecutedCount;
    }

    /**
     * Sets test executed count.
     *
     * @param testExecutedCount the test executed count
     */
    public void setTestExecutedCount(long testExecutedCount) {
        this.testExecutedCount = testExecutedCount;
    }

    /**
     * Gets test error count.
     *
     * @return the test error count
     */
    public long getTestErrorCount() {
        return testErrorCount;
    }

    /**
     * Sets test error count.
     *
     * @param testErrorCount the test error count
     */
    public void setTestErrorCount(long testErrorCount) {
        this.testErrorCount = testErrorCount;
    }

    /**
     * Gets test failed count.
     *
     * @return the test failed count
     */
    public long getTestFailedCount() {
        return testFailedCount;
    }

    /**
     * Sets test failed count.
     *
     * @param testFailedCount the test failed count
     */
    public void setTestFailedCount(long testFailedCount) {
        this.testFailedCount = testFailedCount;
    }

    /**
     * Gets test skipped count.
     *
     * @return the test skipped count
     */
    public long getTestSkippedCount() {
        return testSkippedCount;
    }

    /**
     * Sets test skipped count.
     *
     * @param testSkippedCount the test skipped count
     */
    public void setTestSkippedCount(long testSkippedCount) {
        this.testSkippedCount = testSkippedCount;
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
     * Sets environment.
     *
     * @param environment the environment
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * Gets environment total count.
     *
     * @return the environment total count
     */
    public long getEnvironmentTotalCount() {
        return environmentTotalCount;
    }

    /**
     * Sets environment total count.
     *
     * @param environmentTotalCount the environment total count
     */
    public void setEnvironmentTotalCount(long environmentTotalCount) {
        this.environmentTotalCount = environmentTotalCount;
    }

    /**
     * Gets environment executed count.
     *
     * @return the environment executed count
     */
    public long getEnvironmentExecutedCount() {
        return environmentExecutedCount;
    }

    /**
     * Sets environment executed count.
     *
     * @param environmentExecutedCount the environment executed count
     */
    public void setEnvironmentExecutedCount(long environmentExecutedCount) {
        this.environmentExecutedCount = environmentExecutedCount;
    }

    /**
     * Gets environment error count.
     *
     * @return the environment error count
     */
    public long getEnvironmentErrorCount() {
        return environmentErrorCount;
    }

    /**
     * Sets environment error count.
     *
     * @param environmentErrorCount the environment error count
     */
    public void setEnvironmentErrorCount(long environmentErrorCount) {
        this.environmentErrorCount = environmentErrorCount;
    }

    /**
     * Gets environment failed count.
     *
     * @return the environment failed count
     */
    public long getEnvironmentFailedCount() {
        return environmentFailedCount;
    }

    /**
     * Sets environment failed count.
     *
     * @param environmentFailedCount the environment failed count
     */
    public void setEnvironmentFailedCount(long environmentFailedCount) {
        this.environmentFailedCount = environmentFailedCount;
    }

    /**
     * Gets environment skipped count.
     *
     * @return the environment skipped count
     */
    public long getEnvironmentSkippedCount() {
        return environmentSkippedCount;
    }

    /**
     * Sets environment skipped count.
     *
     * @param environmentSkippedCount the environment skipped count
     */
    public void setEnvironmentSkippedCount(long environmentSkippedCount) {
        this.environmentSkippedCount = environmentSkippedCount;
    }

    /**
     * Gets suite total count.
     *
     * @return the suite total count
     */
    public long getSuiteTotalCount() {
        return suiteTotalCount;
    }

    /**
     * Sets suite total count.
     *
     * @param suiteTotalCount the suite total count
     */
    public void setSuiteTotalCount(long suiteTotalCount) {
        this.suiteTotalCount = suiteTotalCount;
    }

    /**
     * Gets suite executed count.
     *
     * @return the suite executed count
     */
    public long getSuiteExecutedCount() {
        return suiteExecutedCount;
    }

    /**
     * Sets suite executed count.
     *
     * @param suiteExecutedCount the suite executed count
     */
    public void setSuiteExecutedCount(long suiteExecutedCount) {
        this.suiteExecutedCount = suiteExecutedCount;
    }

    /**
     * Gets suite error count.
     *
     * @return the suite error count
     */
    public long getSuiteErrorCount() {
        return suiteErrorCount;
    }

    /**
     * Sets suite error count.
     *
     * @param suiteErrorCount the suite error count
     */
    public void setSuiteErrorCount(long suiteErrorCount) {
        this.suiteErrorCount = suiteErrorCount;
    }

    /**
     * Gets suite failed count.
     *
     * @return the suite failed count
     */
    public long getSuiteFailedCount() {
        return suiteFailedCount;
    }

    /**
     * Sets suite failed count.
     *
     * @param suiteFailedCount the suite failed count
     */
    public void setSuiteFailedCount(long suiteFailedCount) {
        this.suiteFailedCount = suiteFailedCount;
    }

    /**
     * Gets suite skipped count.
     *
     * @return the suite skipped count
     */
    public long getSuiteSkippedCount() {
        return suiteSkippedCount;
    }

    /**
     * Sets suite skipped count.
     *
     * @param suiteSkippedCount the suite skipped count
     */
    public void setSuiteSkippedCount(long suiteSkippedCount) {
        this.suiteSkippedCount = suiteSkippedCount;
    }

    /**
     * Gets case total count.
     *
     * @return the case total count
     */
    public long getCaseTotalCount() {
        return caseTotalCount;
    }

    /**
     * Sets case total count.
     *
     * @param caseTotalCount the case total count
     */
    public void setCaseTotalCount(long caseTotalCount) {
        this.caseTotalCount = caseTotalCount;
    }

    /**
     * Gets case executed count.
     *
     * @return the case executed count
     */
    public long getCaseExecutedCount() {
        return caseExecutedCount;
    }

    /**
     * Sets case executed count.
     *
     * @param caseExecutedCount the case executed count
     */
    public void setCaseExecutedCount(long caseExecutedCount) {
        this.caseExecutedCount = caseExecutedCount;
    }

    /**
     * Gets case error count.
     *
     * @return the case error count
     */
    public long getCaseErrorCount() {
        return caseErrorCount;
    }

    /**
     * Sets case error count.
     *
     * @param caseErrorCount the case error count
     */
    public void setCaseErrorCount(long caseErrorCount) {
        this.caseErrorCount = caseErrorCount;
    }

    /**
     * Gets case failed count.
     *
     * @return the case failed count
     */
    public long getCaseFailedCount() {
        return caseFailedCount;
    }

    /**
     * Sets case failed count.
     *
     * @param caseFailedCount the case failed count
     */
    public void setCaseFailedCount(long caseFailedCount) {
        this.caseFailedCount = caseFailedCount;
    }

    /**
     * Gets case skipped count.
     *
     * @return the case skipped count
     */
    public long getCaseSkippedCount() {
        return caseSkippedCount;
    }

    /**
     * Sets case skipped count.
     *
     * @param caseSkippedCount the case skipped count
     */
    public void setCaseSkippedCount(long caseSkippedCount) {
        this.caseSkippedCount = caseSkippedCount;
    }
}
