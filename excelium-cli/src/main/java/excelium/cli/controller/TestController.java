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

import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.ExpandableChoiceResult;
import de.codeshelf.consoleui.prompt.builder.ExpandableChoicePromptBuilder;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.core.TestExecutor;
import excelium.core.reader.TestReaderFactory;
import excelium.core.writer.TestWriterFactory;
import excelium.model.project.Project;
import excelium.model.project.TestFile;
import excelium.model.test.TestFilter;
import excelium.updater.AppUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

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
     * Executes tests.
     */
    @Command
    public void execute() throws IOException {
        AppUpdater updater = new AppUpdater();
        boolean shouldRestart = updater.checkVersion();

        if (shouldRestart) {
            System.exit(0);
            return;
        }

        String action = "";
        TestExecutor testExecutor = new TestExecutor(project, testReaderFactory, testWriterFactory);
        TestFilter testFilter = new TestFilter();
        boolean testExecuted = false;

        while (!ACTION_QUIT.equals(action)) {
            action = promptAction(testExecuted);
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
                    String runWorkbook = promptList("Choose the test file to run:", project.getTestListChoice(true));

                    testFilter = new TestFilter();
                    testFilter.setWorkbook(runWorkbook);
                    testExecutor.execute(testFilter);
                    testExecuted = true;
                    break;
            }
        }
    }

    /**
     * Prompts for user to choose action
     *
     * @return User selected action
     * @throws IOException if an I/O exception is thrown
     */
    private String promptAction(boolean testExecuted) throws IOException {
        ConsolePrompt prompt = new ConsolePrompt();
        PromptBuilder promptBuilder = prompt.getPromptBuilder();

        ExpandableChoicePromptBuilder actionPromptBuilder = promptBuilder.createChoicePrompt()
                .message("Press one of the following keys to continue (or press <h> for help)");
        actionPromptBuilder.newItem(ACTION_ALL).key('a').message("Run all tests").add();
        if (testExecuted) {
            actionPromptBuilder.newItem(ACTION_PREVIOUS_FILTER).key('p').message("Use previous filter and run tests").add();
        }
        actionPromptBuilder.newItem(ACTION_FILTER_TESTS).key('t').message("Set filter and run tests").add();
        actionPromptBuilder.newItem(ACTION_QUIT).key('q').message("Quit").add();

        actionPromptBuilder.addPrompt();

        ExpandableChoiceResult actionResult = (ExpandableChoiceResult) prompt.prompt(promptBuilder.build()).values().iterator().next();
        return actionResult.getSelectedId();
    }
}
