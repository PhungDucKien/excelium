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

import excelium.core.reader.TestReader;
import excelium.core.reader.TestReaderFactory;
import excelium.core.report.TestReporter;
import excelium.core.writer.TestWriter;
import excelium.core.writer.TestWriterFactory;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.project.TestFile;
import excelium.model.test.Test;
import excelium.model.test.TestFilter;
import excelium.model.test.TestRunConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Executes project's tests.
 *
 * @author PhungDucKien
 * @since 2018.04.13
 */
public class TestExecutor {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Project instance
     */
    private Project project;

    /**
     * Test run config
     */
    private TestRunConfig testRunConfig;

    /**
     * Test reader factory
     */
    private TestReaderFactory testReaderFactory;

    /**
     * Test writer factory
     */
    private TestWriterFactory testWriterFactory;

    /**
     * Instantiates a new Test executor.
     *
     * @param project           the project
     * @param testRunConfig     the test run config
     * @param testReaderFactory the test reader factory
     * @param testWriterFactory the test writer factory
     */
    public TestExecutor(Project project, TestRunConfig testRunConfig, TestReaderFactory testReaderFactory, TestWriterFactory testWriterFactory) {
        this.project = project;
        this.testRunConfig = testRunConfig;
        this.testReaderFactory = testReaderFactory;
        this.testWriterFactory = testWriterFactory;
    }

    /**
     * Executes tests.
     *
     * @param testFilter the test filter
     */
    public void execute(TestFilter testFilter) {
        List<TestFile> testFiles = filterTestFiles(testFilter);
        for (TestFile testFile : testFiles) {
            Template template = project.getTemplates().get(testFile.getTemplate());
            try (TestReader testReader = testReaderFactory.createReader(testFile.getLocation());
                 TestWriter testWriter = testWriterFactory.createWriter(testReader.getWorkbook(), testFile.getLocation())) {

                // Parses test
                Test test = testReader.parseTest(template, testFilter, testWriter);

                // Test reporter
                TestReporter testReporter = new TestReporter(System.out);

                // Executes all tests of workbook
                TestRunner testRunner = new TestRunner(test, project, testRunConfig, testReporter, testWriter, template);
                testRunner.runAll();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Filter test files.
     *
     * @param testFilter the test filter
     * @return filtered test files
     */
    private List<TestFile> filterTestFiles(TestFilter testFilter) {
        Map<String, TestFile> tests = project.getTests();
        if (testFilter != null && testFilter.getWorkbook() != null && !testFilter.getWorkbook().equals(TestFile.ALL)) {
            List<TestFile> filtered = new ArrayList<>();
            String workbook = testFilter.getWorkbook();
            if (tests.keySet().contains(workbook)) {
                filtered.add(tests.get(workbook));
            }
            return filtered;
        } else {
            return new ArrayList<>(tests.values());
        }
    }
}
