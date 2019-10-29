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

import excelium.model.enums.Browser;
import excelium.model.enums.Result;
import excelium.model.test.*;
import excelium.model.test.config.Environment;
import excelium.model.test.config.PcEnvironment;
import excelium.model.test.config.TestConfig;
import mockit.Injectable;
import mockit.Verifications;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fusesource.jansi.AnsiRenderer.render;

/**
 * @author PhungDucKien
 * @since 2018.05.15
 */
public class TestReporterTest {

    @Injectable
    private PrintStream consoleStream;

    @org.junit.Test
    public void testReport() throws InterruptedException {
        TestReporter testReporter = new TestReporter(consoleStream);

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            TestSuite testSuite = new TestSuite();
            List<TestCase> testCases = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                TestCase testCase = new TestCase();
                List<TestStep> testSteps = new ArrayList<>();
                for (int k = 1; k <= 5; k++) {
                    TestStep testStep = new TestStep();
                    testStep.setNo(k);
                    testStep.setName("Test Step " + k);
                    testStep.setCommand("Click");
                    testStep.setParam1(String.valueOf(k));
                    testSteps.add(testStep);
                }
                testCase.setTestSteps(testSteps);
                testCase.setNo(j);
                testCase.setName("Test Case " + j);
                testCases.add(testCase);
            }
            testSuite.setTestCases(testCases);
            testSuite.setSheetName("Test Suite " + i);
            testSuiteMap.put(testSuite.getSheetName(), testSuite);
        }
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        testReporter.startTest(test);
        testReporter.startEnvironment(environment);
        TestSuite testSuite = test.getTestSuites().values().iterator().next();
        testReporter.startTestSuite(testSuite);
        TestCase testCase1 = testSuite.getTestCases().get(0);
        testReporter.startTestFlow(testCase1);
        TestCase testCase2 = testSuite.getTestCases().get(1);
        testReporter.startTestFlow(testCase2);
        TestCase testCase3 = testSuite.getTestCases().get(2);
        testReporter.startTestFlow(testCase3);
        for (int i = 0; i < testCase1.getTestSteps().size(); i++) {
            Thread.sleep(1000);
            testReporter.startTestStep(testCase3.getTestSteps().get(i));
            testReporter.endTestStep(new StepResult(i % 2 == 0 ? Result.OK : Result.FAIL, true, i % 2 == 0 ? null : "Verification failed!"));
        }
        testReporter.endTestFlow();
        testReporter.endTestFlow();
        testReporter.endTestFlow();

        new Verifications() {{
            consoleStream.println(render("@|black       Test Case 1|@"));
            consoleStream.println(render("@|black         Test Case 2|@"));
            consoleStream.println(render("@|black           Test Case 3|@"));
        }};
    }
}
