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

import excelium.core.driver.DriverFactory;
import excelium.core.writer.TestWriter;
import excelium.model.project.Project;
import excelium.model.test.Test;
import excelium.model.test.config.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

/**
 * Executes all tests of a workbook test file
 *
 * @author PhungDucKien
 * @since 2018.05.05
 */
public class TestRunner {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Test object
     */
    private final Test test;

    /**
     * Project instance
     */
    private Project project;

    /**
     * Test writer
     */
    private final TestWriter testWriter;

    /**
     * Current web driver
     */
    private RemoteWebDriver webDriver;

    /**
     * Current environment
     */
    private Environment environment;

    /**
     * Instantiates a new Test runner.
     *
     * @param test       the test
     * @param project    the project
     * @param testWriter the test writer
     */
    public TestRunner(Test test, Project project, TestWriter testWriter) {
        this.test = test;
        this.project = project;
        this.testWriter = testWriter;
    }

    /**
     * Run all.
     *
     * @throws IOException the io exception
     */
    public void runAll() throws IOException {
        for (Environment environment : test.getConfig().getEnvironments()) {
            runEnvironment(environment);
        }
    }

    private void runEnvironment(Environment environment) throws IOException {
        webDriver = DriverFactory.createDriver(environment, project);
    }
}
