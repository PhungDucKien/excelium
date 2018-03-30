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

import excelium.model.test.action.TestAction;
import excelium.model.test.command.Command;
import excelium.model.test.config.TestConfig;
import excelium.model.test.data.TestData;
import excelium.model.test.item.PageSet;

import java.util.Map;

/**
 * Represents test model.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.03.28
 */
public class Test<W, S> {

    /** Workbook name */
    private String workbookName;

    /** Workbook object */
    private W workbook;

    /** Test configuration */
    private TestConfig config;

    /** Map of sheet name and test suites */
    private Map<String, TestSuite<S>> testSuites;

    /** Map of page sets */
    private Map<String, PageSet> pageSets;

    /** Map of actions */
    private Map<String, TestAction> actions;

    /** Map of test data */
    private Map<String, TestData> testData;

    /** Map of commands */
    private Map<String, Command> commands;

    /**
     * Gets workbook name.
     *
     * @return the workbook name
     */
    public String getWorkbookName() {
        return workbookName;
    }

    /**
     * Sets workbook name.
     *
     * @param workbookName the workbook name
     */
    public void setWorkbookName(String workbookName) {
        this.workbookName = workbookName;
    }

    /**
     * Gets workbook.
     *
     * @return the workbook
     */
    public W getWorkbook() {
        return workbook;
    }

    /**
     * Sets workbook.
     *
     * @param workbook the workbook
     */
    public void setWorkbook(W workbook) {
        this.workbook = workbook;
    }

    /**
     * Gets config.
     *
     * @return the config
     */
    public TestConfig getConfig() {
        return config;
    }

    /**
     * Sets config.
     *
     * @param config the config
     */
    public void setConfig(TestConfig config) {
        this.config = config;
    }

    /**
     * Gets test suites.
     *
     * @return the test suites
     */
    public Map<String, TestSuite<S>> getTestSuites() {
        return testSuites;
    }

    /**
     * Sets test suites.
     *
     * @param testSuites the test suites
     */
    public void setTestSuites(Map<String, TestSuite<S>> testSuites) {
        this.testSuites = testSuites;
    }

    /**
     * Gets page sets.
     *
     * @return the page sets
     */
    public Map<String, PageSet> getPageSets() {
        return pageSets;
    }

    /**
     * Sets page sets.
     *
     * @param pageSets the page sets
     */
    public void setPageSets(Map<String, PageSet> pageSets) {
        this.pageSets = pageSets;
    }

    /**
     * Gets actions.
     *
     * @return the actions
     */
    public Map<String, TestAction> getActions() {
        return actions;
    }

    /**
     * Sets actions.
     *
     * @param actions the actions
     */
    public void setActions(Map<String, TestAction> actions) {
        this.actions = actions;
    }

    /**
     * Gets test data.
     *
     * @return the test data
     */
    public Map<String, TestData> getTestData() {
        return testData;
    }

    /**
     * Sets test data.
     *
     * @param testData the test data
     */
    public void setTestData(Map<String, TestData> testData) {
        this.testData = testData;
    }

    /**
     * Gets commands.
     *
     * @return the commands
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Sets commands.
     *
     * @param commands the commands
     */
    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }
}
