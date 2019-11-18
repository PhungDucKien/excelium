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
import excelium.core.report.TestReporter;
import excelium.core.screenshot.ScreenshotService;
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
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.fusesource.jansi.AnsiRenderer.render;

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
    private RemoteWebDriver driver;

    @Mocked
    private ContextAwareWebDriver webDriver;

    @Mocked
    private DriverFactory driverFactory;

    @Injectable
    private PrintStream consoleStream;

    @org.junit.Test
    public void testRunAll() throws Exception {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("click(1)", command);

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
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
    public void testRunAll_NotFoundCommand() throws Exception {
        Map<String, Command> commandMap = new HashMap<>();

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
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
        testStep.setCommand("Not Found Command");
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
            consoleStream.println(render("@|red           ERROR  Command not found: Not Found Command|@"));
        }};
    }

    @org.junit.Test
    public void testRunAll_ActionCommand() throws Exception {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("click(1)", command);

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
                return commandMap;
            }
        };

        new Expectations() {{
            webDriver.evalTemplate("action1"); result = "action1";
            webDriver.evalTemplate("id=id"); result = "id=id";
        }};

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Run Action");
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
            Excelium excelium = Deencapsulation.getField(testRunner, "excelium");
            Method method = MyCommandExecutor.class.getMethod("runAction", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, excelium, null);
            method.invoke(executor, param1);
        });
        commandMap.put("runAction(1)", command);

        testRunner.runAll();

        Assert.assertEquals(1, runCount.get());

        new Verifications() {{
            testWriter.writeResult((Template) any, anyString, (TestStep) any, (Result) any); times = 1;
        }};
    }

    @org.junit.Test
    public void testRunAll_ActionNotFound() throws Exception {
        AtomicInteger runCount = new AtomicInteger();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("click(1)", command);

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
                return commandMap;
            }
        };

        new Expectations() {{
            webDriver.evalTemplate("action2"); result = "action2";
        }};

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Run Action");
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
        command.setName("Run Action");
        command.setParam1("action");
        command.setConsumer((param1, param2, param3) -> {
            Excelium excelium = Deencapsulation.getField(testRunner, "excelium");
            Method method = MyCommandExecutor.class.getMethod("runAction", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, excelium, null);
            method.invoke(executor, param1);
        });
        commandMap.put("runAction(1)", command);

        testRunner.runAll();

        new Verifications() {{
            consoleStream.println(render("@|red           ERROR  Invoke command runAction error: Action not found: action2|@"));
        }};
    }

    @org.junit.Test
    public void testRunAll_ParamArray() throws Exception {
        AtomicReference<String[]> param = new AtomicReference<>();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locatorArray");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("clickArray", String[].class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1);
            param.set((String[]) param1);
        });
        commandMap.put("clickArray(1)", command);

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
                return commandMap;
            }
        };

        new Expectations() {{
            webDriver.evalTemplate("id=id"); result = "id=id";
            webDriver.evalTemplate("id2=id2"); result = "id2=id2";
            webDriver.evalTemplate("id3=id3"); result = "id3=id3";
        }};

        Test test = new Test();
        Map<String, TestSuite> testSuiteMap = new HashMap<>();
        TestSuite testSuite = new TestSuite();
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase();
        List<TestStep> testSteps = new ArrayList<>();
        TestStep testStep = new TestStep();
        testStep.setNo(1);
        testStep.setName("Test Step");
        testStep.setCommand("Click Array");
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
    public void testRunAll_AssertFailed() throws Exception {
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
        commandMap.put("verifyAccessor(2)", command);

        command = new Command();
        command.setMethod("Verify");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("verifyText", String.class, String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1, param2);
        });
        commandMap.put("verify(2)", command);

        command = new Command();
        command.setMethod("AssertAccessor");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            if (!((String)param2).equalsIgnoreCase("OK")) {
                throw new AssertFailedException("Assertion Failed");
            }
        });
        commandMap.put("assertAccessor(2)", command);

        command = new Command();
        command.setMethod("Assert");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("assertText", String.class, String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1, param2);
        });
        commandMap.put("assert(2)", command);

        command = new Command();
        command.setMethod("ErrorAccessor");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            throw new Exception();
        });
        commandMap.put("errorAccessor(2)", command);

        command = new Command();
        command.setMethod("Error");
        command.setParam1("locator");
        command.setParam2("text");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("error", String.class, String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1, param2);
        });
        commandMap.put("error(2)", command);

        command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1);
            runCount.getAndIncrement();
        });
        commandMap.put("click(1)", command);

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
                return commandMap;
            }
        };

        new Expectations() {{
            webDriver.evalTemplate("id=id"); result = "id=id";
            webDriver.evalTemplate("OK"); result = "OK";
            webDriver.evalTemplate("NG"); result = "NG";
        }};

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
        testStep.setCommand("Assert Accessor");
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
        testStep.setCommand("Assert Accessor");
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
        testStep.setCommand("Verify Accessor");
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
        testStep.setCommand("Verify Accessor");
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
        testStep.setCommand("Error Accessor");
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
    public void testRunAll_ItemValue() throws Exception {
        AtomicReference<String> param = new AtomicReference<>();
        Map<String, Command> commandMap = new HashMap<>();
        Command command = new Command();
        command.setParam1("locator");
        command.setConsumer((param1, param2, param3) -> {
            Method method = MyCommandExecutor.class.getMethod("click", String.class);
            MyCommandExecutor executor = new MyCommandExecutor(null, null, null, null);
            method.invoke(executor, param1);
            param.set((String) param1);
        });
        commandMap.put("click(1)", command);

        new Expectations() {{
            driverFactory.createDriver((Environment) any, (Project) any); result = driver;
            webDriver.isWebApp(); result = true;
        }};

        new MockUp<CommandFactory>() {
            @Mock
            public Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors, boolean webContext) {
                return commandMap;
            }
        };

        new Expectations() {{
            webDriver.evalTemplate("id=id"); result = "id=id";
            webDriver.evalTemplate("androidId=androidId"); result = "androidId=androidId";
            webDriver.evalTemplate("iOSId=iOSId"); result = "iOSId=iOSId";
        }};

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

        public MyCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
            super(webDriver, baseUrl, excelium, project);
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
