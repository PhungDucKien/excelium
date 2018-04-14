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

import com.google.api.services.sheets.v4.Sheets;
import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.prompt.ConfirmResult;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import excelium.core.reader.TestReaderFactory;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.sheets.SheetsReaderFactory;
import excelium.sheets.SheetsServiceProvider;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import mockit.*;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for {@link TemplateController}.
 *
 * @author PhungDucKien
 * @since 2018.04.12
 */
public class TemplateControllerTest {

    @Mocked
    ConsolePrompt consolePrompt;

    @Mocked
    ProjectGenerator projectGenerator;

    @Tested
    TemplateController templateController;

    @Test
    public void testImportTemplate() throws IOException, JAXBException, IllegalAccessException {
        Project project = new Project();

        GoogleConnection connection = new GoogleConnectionService();
        SheetsServiceProvider sheetsServiceProvider = new SheetsServiceProvider(connection);
        Sheets sheetsService = sheetsServiceProvider.createSheetsService();
        TestReaderFactory testReaderFactory = new SheetsReaderFactory(sheetsService);

        Deencapsulation.setField(templateController, project);
        Deencapsulation.setField(templateController, testReaderFactory);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, InputResult>() {{ put("", new InputResult("https://docs.google.com/spreadsheets/u/2/d/10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY/edit#gid=0")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("*")); }},
                    new HashMap<String, ConfirmResult>() {{ put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.NO)); }});

            project.setWorkbookType(WorkbookType.SHEETS);
        }};

        templateController.importTemplate();

        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveNotDefaultTemplate() throws IOException, JAXBException, IllegalAccessException {
        Project project = new Project();

        Deencapsulation.setField(templateController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ListResult>() {{ put("", new ListResult("Template2")); }};

            project.setTemplates(new HashMap<String, Template>() {{
                put("Template1", new Template());
                put("Template2", new Template());
                put("Template3", new Template());
            }});
        }};

        templateController.remove();

        Assert.assertEquals(2, project.getTemplates().size());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveDefaultTemplate() throws IOException, JAXBException, IllegalAccessException {
        Project project = new Project();

        Deencapsulation.setField(templateController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ListResult>() {{ put("", new ListResult("Template1")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("Template3")); }});

            project.setTemplates(new HashMap<String, Template>() {{
                put("Template1", new Template());
                put("Template2", new Template());
                put("Template3", new Template());
            }});
        }};

        templateController.remove();

        Assert.assertEquals(2, project.getTemplates().size());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveLastTemplate() throws IOException, JAXBException, IllegalAccessException {
        Project project = new Project();

        Deencapsulation.setField(templateController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ListResult>() {{ put("", new ListResult("Template1")); }};

            project.setTemplates(new HashMap<String, Template>() {{
                put("Template1", new Template());
            }});
        }};

        templateController.remove();

        Assert.assertEquals(0, project.getTemplates().size());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }
}