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
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.ExpandableChoiceResult;
import de.codeshelf.consoleui.prompt.builder.ExpandableChoicePromptBuilder;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.common.Version;
import excelium.core.TestExecutor;
import excelium.core.reader.TestReaderFactory;
import excelium.core.server.FileServer;
import excelium.core.writer.TestWriterFactory;
import excelium.model.project.Project;
import excelium.model.project.TestFile;
import excelium.model.test.TestCase;
import excelium.model.test.TestFilter;
import excelium.model.test.TestRunConfig;
import excelium.model.test.TestSuite;
import excelium.updater.AppUpdater;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static excelium.common.CiInfoUtil.isCI;
import static excelium.common.Prompt.promptList;

/**
 * Provides commands for controlling test.
 *
 * @author PhungDucKien
 * @since 2018.04.13
 */
@Controller
public class TestController extends BaseController {

    private static final String ACTION_ALL = "ALL";
    private static final String ACTION_PREVIOUS_FILTER = "PREVIOUS_FILTER";
    private static final String ACTION_FILTER_TESTS = "FILTER";
    private static final String ACTION_QUIT = "QUIT";

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

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
     * Test writer factory
     */
    @Injectable
    private TestWriterFactory testWriterFactory;

    /**
     * All flag
     */
    @Parameter(names = {"-a", "--all"}, description = "Run all tests", help = true)
    private boolean all = false;

    /**
     * Workbook filter
     */
    @Parameter(names = {"-w", "--workbook"}, description = "Run workbook tests", help = true)
    private String workbook;

    /**
     * Sheet filter
     */
    @Parameter(names = {"-s", "--sheet"}, description = "Run sheet tests", help = true)
    private String sheet;

    /**
     * Test case filter
     */
    @Parameter(names = {"-t", "--test-case"}, description = "Run test case", help = true)
    private String testCase;

    /**
     * Remote host
     */
    @Parameter(names = {"--remote-host"}, description = "Remote WebDriver server host", help = true)
    private String remoteHost;

    /**
     * Remote port
     */
    @Parameter(names = {"--remote-port"}, description = "Remote WebDriver server port", help = true)
    private String remotePort;

    /**
     * UDID
     */
    @Parameter(names = {"--udid"}, description = "Remote WebDriver server port", help = true)
    private String udid;

    /**
     * Headless flag
     */
    @Parameter(names = {"--headless"}, description = "Run browser in headless mode (Only for Chrome and Firefox)", help = true)
    private boolean headless = false;

    /**
     * Executes tests.
     */
    @Command
    public void execute() throws IOException {
        System.out.println("Excelium " + Version.VERSION);

        boolean isCI = isCI();

        if (!isCI) {
            AppUpdater updater = new AppUpdater();
            boolean shouldRestart = updater.checkVersion();

            if (shouldRestart) {
                System.exit(0);
                return;
            }
        }

        FileServer fileServer = null;

        if (isRemoteHost(remoteHost)) {
            fileServer = FileServer.createInstance(project);
            fileServer.start();
        }

        try {
            TestRunConfig runConfig = new TestRunConfig();
            runConfig.setRemoteHost(remoteHost);
            runConfig.setRemotePort(remotePort);
            runConfig.setUdid(udid);
            runConfig.setHeadless(headless);

            TestExecutor testExecutor = new TestExecutor(project, runConfig, testReaderFactory, testWriterFactory);
            TestFilter testFilter = new TestFilter();
            boolean testExecuted = false;

            if (all) {
                testFilter.setWorkbook(TestFile.ALL);
                testExecutor.execute(testFilter);
                testExecuted = true;

                if (isCI) {
                    return;
                }
            }

            if (StringUtils.isNotBlank(workbook)) {
                testFilter.setWorkbook(workbook);

                if (StringUtils.isNotBlank(sheet)) {
                    testFilter.setSheet(sheet);

                    if (StringUtils.isNotBlank(testCase)) {
                        testFilter.setTestCase(testCase);
                    } else {
                        testFilter.setTestCase(TestCase.ALL);
                    }
                } else {
                    testFilter.setSheet(TestSuite.ALL);
                }

                testExecutor.execute(testFilter);
                testExecuted = true;

                if (isCI) {
                    return;
                }
            }

            String action = "";
            while (!ACTION_QUIT.equals(action)) {
                action = promptAction(testExecuted, all, StringUtils.isNotBlank(workbook), StringUtils.isNotBlank(sheet), StringUtils.isNotBlank(testCase));
                switch (action) {
                    case ACTION_ALL:
                        testFilter = new TestFilter();
                        testFilter.setWorkbook(TestFile.ALL);
                        testExecutor.execute(testFilter);
                        testExecuted = true;
                        break;
                    case ACTION_PREVIOUS_FILTER:
                        testExecutor.execute(testFilter);
                        testExecuted = true;
                        break;
                    case ACTION_FILTER_TESTS:
                        testFilter = new TestFilter();

                        if (StringUtils.isNotBlank(workbook)) {
                            testFilter.setWorkbook(workbook);

                            if (StringUtils.isNotBlank(sheet)) {
                                testFilter.setSheet(sheet);

                                if (StringUtils.isNotBlank(testCase)) {
                                    testFilter.setTestCase(testCase);
                                }
                            }
                        } else {
                            String runWorkbook = promptList("Choose the test file to run:", project.getTestListChoice(true));
                            testFilter.setWorkbook(runWorkbook);
                        }

                        testExecutor.execute(testFilter);
                        testExecuted = true;
                        break;
                }

                if (isCI) {
                    break;
                }
            }
        } finally {
            if (fileServer != null) {
                fileServer.stop();
            }
        }
    }

    /**
     * Prompts for user to choose action
     *
     * @return User selected action
     * @throws IOException if an I/O exception is thrown
     */
    private String promptAction(boolean testExecuted, boolean allFlag, boolean hasWorkbookFlag, boolean hasSheetFlag, boolean hasTestCaseFlag) throws IOException {
        ConsolePrompt prompt = new ConsolePrompt();
        PromptBuilder promptBuilder = prompt.getPromptBuilder();

        ExpandableChoicePromptBuilder actionPromptBuilder = promptBuilder.createChoicePrompt()
                .message("Press one of the following keys to continue (or press <h> for help)");
        if (!hasWorkbookFlag) {
            actionPromptBuilder.newItem(ACTION_ALL).key('a').message("Run all tests").add();
        }
        if (!allFlag) {
            if (hasWorkbookFlag && hasSheetFlag && hasTestCaseFlag) {
                actionPromptBuilder.newItem(ACTION_FILTER_TESTS).key('t').message("Run filter tests").add();
            } else {
                if (testExecuted) {
                    actionPromptBuilder.newItem(ACTION_PREVIOUS_FILTER).key('p').message("Use previous filter and run tests").add();
                }
                actionPromptBuilder.newItem(ACTION_FILTER_TESTS).key('t').message("Set filter and run tests").add();
            }
        }
        if (testExecuted) {
            actionPromptBuilder.newItem(ACTION_QUIT).key('q').message("Quit").add();
        }

        actionPromptBuilder.addPrompt();

        ExpandableChoiceResult actionResult = (ExpandableChoiceResult) prompt.prompt(promptBuilder.build()).values().iterator().next();
        return actionResult.getSelectedId();
    }

    private boolean isRemoteHost(String remoteHost) {
        return StringUtils.isNotBlank(remoteHost);
    }
}
