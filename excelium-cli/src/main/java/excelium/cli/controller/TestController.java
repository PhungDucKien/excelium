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

package excelium.cli.controller;

import com.beust.jcommander.Parameter;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.core.TestExecutor;
import excelium.core.reader.TestReaderFactory;
import excelium.model.project.Project;
import excelium.model.test.TestFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides commands for controlling test.
 *
 * @author PhungDucKien
 * @since 2018.04.13
 */
@Controller
public class TestController {

    /** Logger */
    private static final Logger LOG = LogManager.getLogger();

    /** Help flag */
    @Parameter(names = { "-h", "-help" }, description = "Print help information", help = true)
    private boolean help = false;

    /** Debug flag */
    @Parameter(names = { "-d", "-debug" }, description = "Debug mode. Use breakpoints to pause execution")
    private boolean debug = false;

    /** Silent flag */
    @Parameter(names = { "-silent" }, description = "Do not write results to workbooks")
    private boolean silent = false;

    /** Workbook filter */
    @Parameter(names = { "-w", "-workbooks" }, description = "Use the given workbooks", variableArity = true)
    private List<String> workbooks = new ArrayList<>();

    /** Sheet filter */
    @Parameter(names = { "-s", "-sheets" }, description = "Use the given sheets", variableArity = true)
    private List<String> sheets = new ArrayList<>();

    /** Test case filter */
    @Parameter(names = { "-t", "-test-cases" }, description = "Use the given test cases", variableArity = true)
    private List<String> testCases = new ArrayList<>();

    /**
     * Project instance
     */
    @Injectable
    private Project project;

    /**
     * Test reader factory
     */
    @Injectable
    private TestReaderFactory testReaderFactory;

    /**
     * Executes tests.
     */
    @Command
    public void execute() {
        TestFilter testFilter = new TestFilter();
        testFilter.setWorkbooks(workbooks);
        testFilter.setSheets(sheets);
        testFilter.setTestCases(testCases);

        TestExecutor testExecutor = new TestExecutor(project, testReaderFactory);
        testExecutor.execute(testFilter);
    }
}
