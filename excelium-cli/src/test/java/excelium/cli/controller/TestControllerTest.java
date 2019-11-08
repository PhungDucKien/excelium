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

import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.ExpandableChoiceResult;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import excelium.core.TestExecutor;
import excelium.model.project.DataSource;
import excelium.model.project.Project;
import excelium.model.project.TestFile;
import excelium.model.test.TestFilter;
import excelium.updater.AppUpdater;
import mockit.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for {@link TestController}.
 *
 * @author PhungDucKien
 * @since 2018.04.14
 */
public class TestControllerTest {

    @Mocked
    TestExecutor testExecutor;

    @Mocked
    AppUpdater appUpdater;

    @Mocked
    ConsolePrompt consolePrompt;

    @Mocked
    TestFilter testFilter;

    @Tested
    TestController testController;

    @Test
    public void testShouldRestart() throws IOException {
        new Expectations() {{
            appUpdater.checkVersion();
            result = true;
        }};

        new MockUp<System>() {
            @Mock
            void exit(int status) {
            }
        };

        testController.execute();

        new Verifications() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); times = 0;
            testExecutor.execute((TestFilter) any); times = 0;
        }};
    }

    @Test
    public void testExecuteAll() throws IOException {
        new Expectations() {{
           appUpdater.checkVersion();
           result = false;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("ALL")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("QUIT")); }});
        }};

        testController.execute();

        new Verifications() {{
            testFilter.setWorkbook("ALL"); times = 1;
            testExecutor.execute((TestFilter) any); times = 1;
        }};
    }

    @Test
    public void testExecuteAllTwice() throws IOException {
        new Expectations() {{
            appUpdater.checkVersion();
            result = false;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("ALL")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("ALL")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("QUIT")); }});
        }};

        testController.execute();

        new Verifications() {{
            testFilter.setWorkbook("ALL"); times = 2;
            testExecutor.execute((TestFilter) any); times = 2;
        }};
    }

    @Test
    public void testExecuteFilter() throws IOException {
        Project project = new Project();
        Deencapsulation.setField(testController, project);

        String[][] testListChoices = new String[1][2];
        testListChoices[0] = new String[]{"Workbook1", "Workbook 1"};

        new Expectations() {{
            appUpdater.checkVersion();
            result = false;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("FILTER")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("Workbook1")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("QUIT")); }});

            project.setTests(new HashMap<String, TestFile>() {{
                put("Workbook1", new TestFile());
            }});
        }};

        testController.execute();

        new Verifications() {{
            testFilter.setWorkbook("Workbook1"); times = 1;
            testExecutor.execute((TestFilter) any); times = 1;
        }};
    }

    @Test
    public void testExecuteFilterTwice() throws IOException {
        Project project = new Project();
        Deencapsulation.setField(testController, project);

        String[][] testListChoices = new String[1][2];
        testListChoices[0] = new String[]{"Workbook1", "Workbook 1"};

        new Expectations() {{
            appUpdater.checkVersion();
            result = false;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("FILTER")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("Workbook1")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("FILTER")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("Workbook1")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("QUIT")); }});

            project.setTests(new HashMap<String, TestFile>() {{
                put("Workbook1", new TestFile());
            }});
        }};

        testController.execute();

        new Verifications() {{
            testFilter.setWorkbook("Workbook1"); times = 2;
            testExecutor.execute((TestFilter) any); times = 2;
        }};
    }

    @Test
    public void testExecutePreviousFilter() throws IOException {
        Project project = new Project();
        Deencapsulation.setField(testController, project);

        String[][] testListChoices = new String[1][2];
        testListChoices[0] = new String[]{"Workbook1", "Workbook 1"};

        new Expectations() {{
            appUpdater.checkVersion();
            result = false;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("FILTER")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("Workbook1")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("PREVIOUS_FILTER")); }},
                    new HashMap<String, ExpandableChoiceResult>() {{ put("", new ExpandableChoiceResult("QUIT")); }});

            project.setTests(new HashMap<String, TestFile>() {{
                put("Workbook1", new TestFile());
            }});
        }};

        testController.execute();

        new Verifications() {{
            testFilter.setWorkbook("Workbook1"); times = 1;
            testExecutor.execute((TestFilter) any); times = 2;
        }};
    }
}