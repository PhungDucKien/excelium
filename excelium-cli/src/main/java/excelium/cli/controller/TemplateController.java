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

import excelium.cli.Prompt;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.common.FileUtil;
import excelium.common.StringUtil;
import excelium.common.TemplateUtil;
import excelium.core.reader.TestReader;
import excelium.core.reader.TestReaderFactory;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import excelium.model.project.Template;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides commands for controlling Template.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
@Controller(name = "template")
public class TemplateController {

    /**
     * Project instance
     */
    @Injectable
    private Project project;

    /**
     * Test reader factory
     */
    @Injectable(ignore = {"remove"})
    private TestReaderFactory testReaderFactory;

    /**
     * Imports test template.
     */
    @Command(name = "import")
    public void importTemplate() throws IOException, JAXBException, IllegalAccessException {
        TestReader testReader = null;

        if (project.getWorkbookType() == WorkbookType.EXCEL) {
            List<String> templateFilePaths = FileUtil.listFiles(project.getTemplatePath());
            String filePath = Prompt.promptList("What is the file path of the template you want to import?", templateFilePaths);
            testReader = testReaderFactory.createReader(project.getTemplatePath().resolve(filePath).toString());
        } else if (project.getWorkbookType() == WorkbookType.SHEETS) {
            String spreadsheetLocation = Prompt.promptInput("What is the spreadsheet ID/URL of the template you want to import?", null);
            String spreadsheetId = StringUtil.extractSpreadsheetId(spreadsheetLocation);
            testReader = testReaderFactory.createReader(spreadsheetId);
        }

        Template template = new Template();
        template.setMarkupLocations(testReader.getMarkupLocationMap(Template.getMarkupList()));

        String configurationSheet = TemplateUtil.getSuggestSheetForConfiguration(template);
        if (StringUtils.isNotBlank(configurationSheet)) {
            String configurationPattern = Prompt.promptInput("What is the pattern of the name of Configuration sheet? (The asterisk (*) means any string)", configurationSheet);
            template.setConfigurationPattern(configurationPattern);
        }

        String mappingSheet = TemplateUtil.getSuggestSheetForMapping(template);
        if (StringUtils.isNotBlank(mappingSheet)) {
            String mappingPattern = Prompt.promptInput("What is the pattern of the name of Mapping sheet? (The asterisk (*) means any string)", mappingSheet);
            template.setMappingPattern(mappingPattern);
        }

        String actionSheet = TemplateUtil.getSuggestSheetForAction(template);
        if (StringUtils.isNotBlank(actionSheet)) {
            String actionPattern = Prompt.promptInput("What is the pattern of the name of Action sheet? (The asterisk (*) means any string)", actionSheet);
            template.setMappingPattern(actionPattern);
        }

        String dataSheet = TemplateUtil.getSuggestSheetForData(template);
        if (StringUtils.isNotBlank(dataSheet)) {
            String dataPattern = Prompt.promptInput("What is the pattern of the name of Data sheet? (The asterisk (*) means any string)", dataSheet);
            template.setDataPattern(dataPattern);
        }

        String testPattern = Prompt.promptInput("What is the pattern of the name of Test Case sheet? (The asterisk (*) means any string)", "*");
        template.setTestPattern(testPattern);

        List<String> ignorePatterns = new ArrayList<>();
        boolean addIgnorePatterns = Prompt.promptConfirm("Do you want to add the pattern of the name of sheet that should be ignored?");
        while (addIgnorePatterns) {
            String ignorePattern = Prompt.promptInput("Please add the pattern of the name of sheet that should be ignored:", null);
            ignorePatterns.add(ignorePattern);
            addIgnorePatterns = Prompt.promptConfirm("Do you want to add the pattern of the name of sheet that should be ignored?");
        }
        template.setIgnorePatterns(ignorePatterns);

        Map<String, Template> templates = project.getTemplates();
        if (templates == null) {
            templates = new LinkedHashMap<>();
        }
        String templateName = testReader.getWorkbookName();
        templates.put(templateName, template);
        project.setTemplates(templates);

        if (StringUtils.isBlank(project.getDefaultTemplate()) || project.getTemplates().keySet().size() < 2) {
            project.setDefaultTemplate(templateName);
        } else {
            String defaultTemplate = Prompt.promptList("Choose the default template:", new ArrayList<>(project.getTemplates().keySet()));
            project.setDefaultTemplate(defaultTemplate);
        }

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, Paths.get("."));
    }

    /**
     * Removes test template.
     */
    @Command(name = "remove")
    public void remove() throws IOException, JAXBException, IllegalAccessException {
        String removeTemplate = Prompt.promptList("Choose the template to remove:", new ArrayList<>(project.getTemplates().keySet()));
        project.getTemplates().remove(removeTemplate);

        if (removeTemplate.equals(project.getDefaultTemplate())) {
            if (project.getTemplates().keySet().size() == 0) {
                project.setDefaultTemplate(null);
            } else {
                String defaultTemplate = Prompt.promptList("Choose the default template:", new ArrayList<>(project.getTemplates().keySet()));
                project.setDefaultTemplate(defaultTemplate);
            }
        }

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, Paths.get("."));
    }
}
