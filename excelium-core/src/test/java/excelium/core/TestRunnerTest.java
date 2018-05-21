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
import excelium.core.report.TestReporter;
import excelium.core.writer.TestWriter;
import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.enums.Result;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.test.Test;
import excelium.model.test.TestCase;
import excelium.model.test.TestStep;
import excelium.model.test.TestSuite;
import excelium.model.test.action.TestAction;
import excelium.model.test.command.Command;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.PcEnvironment;
import excelium.model.test.config.TestConfig;
import excelium.model.test.item.Item;
import excelium.model.test.item.PageSet;
import mockit.*;
import org.junit.Assert;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Tests for {@link TestRunner}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class TestRunnerTest {

    @Mocked
    private TestWriter testWriter;

    @Mocked
    private ContextAwareWebDriver webDriver;

    @Injectable
    private PrintStream consoleStream;

    @org.junit.Test
    public void testRunAll() throws IOException {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("Click", command);

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

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
                    testStep.setParam1("button1");
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

        Map<String, PageSet> pageSetMap = new HashMap<>();
        Map<String, Item> itemMap = new HashMap<>();
        Item item = new Item();
        item.setName("button1");
        item.setValue("id=id");
        itemMap.put("button1", item);
        PageSet pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        environment = new PcEnvironment();
        environment.setBrowser(Browser.FIREFOX);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(System.out);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        Assert.assertEquals(250, runCount.get());

        new Verifications() {{
            testWriter.writeResult((Template) any, anyString, (TestStep) any, (Result) any); times = 125;
        }};
    }

    @org.junit.Test
    public void testRunAll_NotFoundCommand() throws IOException {
        Map<String, Command> commandMap = new HashMap<>();

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("NotFoundCommand");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(1);
        testCase.setName("Test Case");
        testCases.add(testCase);
        testSuite.setTestCases(testCases);
        testSuite.setSheetName("Test Suite");
        testSuiteMap.put(testSuite.getSheetName(), testSuite);
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(consoleStream);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        new Verifications() {{
            consoleStream.println("          ERROR  Command not found: NotFoundCommand");
        }};
    }

    @org.junit.Test
    public void testRunAll_ActionCommand() throws IOException {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("Click", command);

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("RunAction");
        testStep.setParam1("action1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(1);
        testCase.setName("Test Case");
        testCases.add(testCase);
        testSuite.setTestCases(testCases);
        testSuite.setSheetName("Test Suite");
        testSuiteMap.put(testSuite.getSheetName(), testSuite);
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        Map<String, TestAction> actions = new HashMap<>();
        TestAction testAction = new TestAction();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testAction.setName("action1");
        testAction.setTestSteps(testSteps);
        actions.put("action1", testAction);
        test.setActions(actions);

        Map<String, PageSet> pageSetMap = new HashMap<>();
        Map<String, Item> itemMap = new HashMap<>();
        Item item = new Item();
        item.setName("button1");
        item.setValue("id=id");
        itemMap.put("button1", item);
        PageSet pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(System.out);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);

        command = new Command();
        command.setParam1("action");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("runAction", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, testRunner);
            method.invoke(executor, param1);
        });
        commandMap.put("RunAction", command);

        testRunner.runAll();

        Assert.assertEquals(1, runCount.get());

        new Verifications() {{
            testWriter.writeResult((Template) any, anyString, (TestStep) any, (Result) any); times = 1;
        }};
    }

    @org.junit.Test
    public void testRunAll_ActionNotFound() throws IOException {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("Click", command);

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("RunAction");
        testStep.setParam1("action2");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(1);
        testCase.setName("Test Case");
        testCases.add(testCase);
        testSuite.setTestCases(testCases);
        testSuite.setSheetName("Test Suite");
        testSuiteMap.put(testSuite.getSheetName(), testSuite);
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        Map<String, TestAction> actions = new HashMap<>();
        TestAction testAction = new TestAction();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testAction.setName("action1");
        testAction.setTestSteps(testSteps);
        actions.put("action1", testAction);
        test.setActions(actions);

        Map<String, PageSet> pageSetMap = new HashMap<>();
        Map<String, Item> itemMap = new HashMap<>();
        Item item = new Item();
        item.setName("button1");
        item.setValue("id=id");
        itemMap.put("button1", item);
        PageSet pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(consoleStream);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);

        command = new Command();
        command.setName("RunAction");
        command.setParam1("action");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("runAction", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, testRunner);
            method.invoke(executor, param1);
        });
        commandMap.put("RunAction", command);

        testRunner.runAll();

        new Verifications() {{
            consoleStream.println("          ERROR  Invoke command RunAction error: Action execution failed.");
        }};
    }

    @org.junit.Test
    public void testRunAll_ParamArray() throws IOException {
        AtomicReference<String[]> param = new AtomicReference<>();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locatorArray");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("clickArray", String[].class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1);
            param.set((String[]) param1);
        });
        commandMap.put("ClickArray", command);

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("ClickArray");
        testStep.setParam1("button1,button2,id3=id3");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(1);
        testCase.setName("Test Case");
        testCases.add(testCase);
        testSuite.setTestCases(testCases);
        testSuite.setSheetName("Test Suite");
        testSuiteMap.put(testSuite.getSheetName(), testSuite);
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        Map<String, PageSet> pageSetMap = new HashMap<>();
        Map<String, Item> itemMap = new HashMap<>();
        Item item = new Item();
        item.setName("button1");
        item.setValue("id=id");
        itemMap.put("button1", item);
        item = new Item();
        item.setName("button2");
        item.setValue("id2=id2");
        itemMap.put("button2", item);
        PageSet pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(System.out);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        Assert.assertEquals("id=id", param.get()[0]);
        Assert.assertEquals("id2=id2", param.get()[1]);
        Assert.assertEquals("id3=id3", param.get()[2]);

        new Verifications() {{
            testWriter.writeResult((Template) any, anyString, (TestStep) any, (Result) any); times = 1;
        }};
    }

    @org.junit.Test
    public void testRunAll_AssertFailed() throws IOException {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setMethod("VerifyAccessor");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            if (!((String)param2).equalsIgnoreCase("OK")) {
                throw new AssertFailedException("Assertion Failed");
            }
        });
        commandMap.put("VerifyAccessor", command);

        command = new Command();
        command.setMethod("Verify");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("verifyText", String.class, String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1, param2);
        });
        commandMap.put("Verify", command);

        command = new Command();
        command.setMethod("AssertAccessor");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            if (!((String)param2).equalsIgnoreCase("OK")) {
                throw new AssertFailedException("Assertion Failed");
            }
        });
        commandMap.put("AssertAccessor", command);

        command = new Command();
        command.setMethod("Assert");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("assertText", String.class, String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1, param2);
        });
        commandMap.put("Assert", command);

        command = new Command();
        command.setMethod("ErrorAccessor");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            throw new Exception();
        });
        commandMap.put("ErrorAccessor", command);

        command = new Command();
        command.setMethod("Error");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("error", String.class, String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1, param2);
        });
        commandMap.put("Error", command);

        command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("Click", command);

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Assert");
        testStep.setParam1("button1");
        testStep.setParam2("OK");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(1);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Assert");
        testStep.setParam1("button1");
        testStep.setParam2("NG");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(2);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("AssertAccessor");
        testStep.setParam1("button1");
        testStep.setParam2("OK");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(3);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("AssertAccessor");
        testStep.setParam1("button1");
        testStep.setParam2("NG");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(4);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Verify");
        testStep.setParam1("button1");
        testStep.setParam2("OK");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(5);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Verify");
        testStep.setParam1("button1");
        testStep.setParam2("NG");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(6);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("VerifyAccessor");
        testStep.setParam1("button1");
        testStep.setParam2("OK");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(7);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("VerifyAccessor");
        testStep.setParam1("button1");
        testStep.setParam2("NG");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(8);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("ErrorAccessor");
        testStep.setParam1("button1");
        testStep.setParam2("OK");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(9);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testCase = new TestCase();
        testSteps = new ArrayList<>();
        testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Error");
        testStep.setParam1("button1");
        testStep.setParam2("OK");
        testSteps.add(testStep);
        testStep = new TestStep();
        testStep.setNo(2);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(10);
        testCase.setName("Test Case");
        testCases.add(testCase);

        testSuite.setTestCases(testCases);
        testSuite.setSheetName("Test Suite");
        testSuiteMap.put(testSuite.getSheetName(), testSuite);
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        Map<String, PageSet> pageSetMap = new HashMap<>();
        Map<String, Item> itemMap = new HashMap<>();
        Item item = new Item();
        item.setName("button1");
        item.setValue("id=id");
        itemMap.put("button1", item);
        PageSet pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(System.out);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        Assert.assertEquals(6, runCount.get());
    }

    @org.junit.Test
    public void testRunAll_ItemValue() throws IOException {
        AtomicReference<String> param = new AtomicReference<>();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null);
            method.invoke(executor, param1);
            param.set((String) param1);
        });
        commandMap.put("Click", command);

        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project) throws IOException {
                return webDriver;
            }
        };

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
                return commandMap;
            }
        };

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Click");
        testStep.setParam1("button1");
        testSteps.add(testStep);
        testCase.setTestSteps(testSteps);
        testCase.setNo(1);
        testCase.setName("Test Case");
        testCases.add(testCase);
        testSuite.setTestCases(testCases);
        testSuite.setSheetName("Test Suite");
        testSuiteMap.put(testSuite.getSheetName(), testSuite);
        test.setTestSuites(testSuiteMap);
        test.setWorkbookName("Workbook test");

        Map<String, PageSet> pageSetMap = new HashMap<>();
        Map<String, Item> itemMap = new HashMap<>();
        Item item = new Item();
        item.setName("button1");
        item.setValue("id=id");
        itemMap.put("button1", item);
        PageSet pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        Environment environment = new PcEnvironment();
        ((PcEnvironment) environment).setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(System.out);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        Assert.assertEquals("id=id", param.get());

        pageSetMap = new HashMap<>();
        itemMap = new HashMap<>();
        item = new Item();
        item.setName("button1");
        item.setAndroidValue("androidId=androidId");
        itemMap.put("button1", item);
        pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        testConfig = new TestConfig();
        environments = new ArrayList<>();
        environment = new MobileAppEnvironment();
        environment.setPlatform(Platform.ANDROID);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        testReporter = new TestReporter(System.out);

        testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        Assert.assertEquals("androidId=androidId", param.get());

        pageSetMap = new HashMap<>();
        itemMap = new HashMap<>();
        item = new Item();
        item.setName("button1");
        item.setIosValue("iOSId=iOSId");
        itemMap.put("button1", item);
        pageSet = new PageSet();
        pageSet.setName("default");
        pageSet.setItems(itemMap);
        pageSetMap.put("default", pageSet);
        test.setPageSets(pageSetMap);

        testConfig = new TestConfig();
        environments = new ArrayList<>();
        environment = new MobileAppEnvironment();
        environment.setPlatform(Platform.IOS);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        testReporter = new TestReporter(System.out);

        testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

        Assert.assertEquals("iOSId=iOSId", param.get());
    }

    public static class MyCommandExecutor extends CommandExecutor {

        public MyCommandExecutor(ContextAwareWebDriver webDriver) {
            super(webDriver);
        }

        public MyCommandExecutor(ContextAwareWebDriver webDriver, TestRunner testRunner) {
            super(webDriver, testRunner);
        }

        public void click(String locator) {
        }

        public void clickArray(String[] locatorArray) {
        }

        public void verifyText(String locator, String text) throws Exception {
            if (!text.equalsIgnoreCase("OK")) {
                throw new AssertFailedException("Assertion Failed");
            }
        }

        public void assertText(String locator, String text) throws Exception {
            if (!text.equalsIgnoreCase("OK")) {
                throw new AssertFailedException("Assertion Failed");
            }
        }

        public void error(String locator, String text) throws Exception {
            throw new Exception();
        }

        public void runAction(String action) throws Exception {
            super.runAction(action);
        }
    }
}
