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
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.project.TestFile;
import excelium.model.test.Test;
import excelium.model.test.TestFilter;
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
     * Instantiates a new Test executor.
     *
     * @param project           the project
     * @param testReaderFactory the test reader factory
     */
    public TestExecutor(Project project, TestReaderFactory testReaderFactory) {
        this.project = project;
        this.testReaderFactory = testReaderFactory;
    }

    /**
     * Executes tests.
     *
     * @param testFilter the test filter
     */
    public void execute(TestFilter testFilter) {
        TestIterator iterator = new TestIterator(filterTestFiles(testFilter));
        while (iterator.hasNext()) {
            try (Test test = iterator.next()) {
                // Execute all tests of workbook
//                TestRunner testRunner = new TestRunner(test, testWriter, screenshotService, debug, silent);
//                testRunner.runAll();
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
        if (testFilter != null && testFilter.getWorkbooks() != null && testFilter.getWorkbooks().size() > 0) {
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

    /**
     * Test Iterator.
     */
    private class TestIterator implements Iterator<Test> {

        /**
         * Test files
         */
        List<TestFile> testFiles;

        /** Cursor */
        private int cursor;

        /**
         * Instantiates a new Test iterator.
         *
         * @param testFiles the test files
         */
        TestIterator(List<TestFile> testFiles) {
            this.testFiles = testFiles;
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursor < testFiles.size();
        }

        @Override
        public Test next() {
            if (this.hasNext()) {
                try {
                    TestFile testFile = testFiles.get(cursor);
                    Template template = project.getTemplates().get(testFile.getTemplate());
                    TestReader testReader = testReaderFactory.createReader(testFile.getLocation());
                    return testReader.parseTest(template);
                } catch (IOException e) {
                    throw new NoSuchElementException();
                } finally {
                    cursor++;
                }
            }
            throw new NoSuchElementException();
        }
    }
}
