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

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.prompt.ConfirmResult;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.AppType;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for {@link ProjectController}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class ProjectControllerTest {

    @Mocked
    ConsolePrompt consolePrompt;

    @Mocked
    ProjectGenerator projectGenerator;

    @Tested
    ProjectController projectController;

    @Test
    public void testCreateWebSheets() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ConfirmResult>() {{ put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES)); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("myproject")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(AppType.WEB.name())); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(WorkbookType.SHEETS.name())); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("file")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("screenshot")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("download")); }});
        }};

        projectController.create();

        new Verifications() {{
           projectGenerator.createProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testCreateWebExcel() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ConfirmResult>() {{ put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES)); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("myproject")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(AppType.WEB.name())); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(WorkbookType.EXCEL.name())); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("test")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("template")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("file")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("screenshot")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("download")); }});
        }};

        projectController.create();

        new Verifications() {{
            projectGenerator.createProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testCreateMobileSheets() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ConfirmResult>() {{ put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES)); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("myproject")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(AppType.MOBILE.name())); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(WorkbookType.SHEETS.name())); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("app")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("screenshot")); }});
        }};

        projectController.create();

        new Verifications() {{
            projectGenerator.createProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testCreateMobileExcel() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ConfirmResult>() {{ put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES)); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("myproject")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(AppType.WEB.name())); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult(WorkbookType.EXCEL.name())); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("test")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("template")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("app")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("screenshot")); }});
        }};

        projectController.create();

        new Verifications() {{
            projectGenerator.createProject((Project) any, (Path) any);
        }};
    }
}
