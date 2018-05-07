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
import excelium.core.writer.TestWriter;
import excelium.core.writer.TestWriterFactory;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.project.TestFile;
import excelium.model.test.Test;
import excelium.model.test.TestFilter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

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
     * @param testReaderFactory the test reader factory
     * @param testWriterFactory the test writer factory
     */
    public TestExecutor(Project project, TestReaderFactory testReaderFactory, TestWriterFactory testWriterFactory) {
        this.project = project;
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

                // Executes all tests of workbook
                TestRunner testRunner = new TestRunner(test, project, testWriter);
                testRunner.runAll();
            } catch (IOException e) {
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
        if (testFilter != null && CollectionUtils.isNotEmpty(testFilter.getWorkbooks())) {
            List<TestFile> filtered = new ArrayList<>();
            for (String workbook : testFilter.getWorkbooks()) {
                if (tests.keySet().contains(workbook)) {
                    filtered.add(tests.get(workbook));
                }
            }
            return filtered;
        } else {
            return new ArrayList<>(tests.values());
        }
    }
}
