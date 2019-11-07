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

import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.common.TemplateUtil;
import excelium.core.reader.TestReader;
import excelium.core.reader.TestReaderFactory;
import excelium.generator.ProjectGenerator;
import excelium.model.project.Project;
import excelium.model.project.Template;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Paths;

import static excelium.common.Prompt.*;

/**
 * Provides commands for controlling template.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
@Controller(name = "template")
public class TemplateController extends BaseController {

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
     *
     * @throws IOException            the io exception
     * @throws JAXBException          the jaxb exception
     * @throws IllegalAccessException the illegal access exception
     */
    @Command(name = "import")
    public void importTemplate() throws IOException, JAXBException, IllegalAccessException {
        String fileLocation = promptFileLocation(project.getWorkbookType(), project.getTemplatePath(),
                "What is the file path of the template you want to import?",
                "What is the spreadsheet ID/URL of the template you want to import?");
        TestReader testReader = testReaderFactory.createReader(fileLocation);

        Template template = new Template();
        template.setLocation(fileLocation);
        template.setName(testReader.getWorkbookName());
        template.setMarkupLocations(testReader.batchFindFirstOccurrence(TemplateUtil.getMarkups()));

        String mappingSheet = TemplateUtil.getSuggestSheetForMapping(template);
        if (StringUtils.isNotBlank(mappingSheet)) {
            String mappingPattern = promptInput("What is the pattern of the name of Mapping sheet? (The asterisk (*) means any string)", mappingSheet);
            template.setMappingPattern(mappingPattern);
        }

        String actionSheet = TemplateUtil.getSuggestSheetForAction(template);
        if (StringUtils.isNotBlank(actionSheet)) {
            String actionPattern = promptInput("What is the pattern of the name of Action sheet? (The asterisk (*) means any string)", actionSheet);
            template.setActionPattern(actionPattern);
        }

        String dataSheet = TemplateUtil.getSuggestSheetForData(template);
        if (StringUtils.isNotBlank(dataSheet)) {
            String dataPattern = promptInput("What is the pattern of the name of Data sheet? (The asterisk (*) means any string)", dataSheet);
            template.setDataPattern(dataPattern);
        }

        String testPattern = promptInput("What is the pattern of the name of Test Case sheet? (The asterisk (*) means any string)", "*");
        template.setTestPattern(testPattern);

        boolean addIgnorePatterns = promptConfirm("Do you want to add the pattern of the name of sheet that should be ignored?");
        while (addIgnorePatterns) {
            String ignorePattern = promptInput("Please add the pattern of the name of sheet that should be ignored:", null);
            template.addIgnorePattern(ignorePattern);
            addIgnorePatterns = promptConfirm("Do you want to add the pattern of the name of sheet that should be ignored?");
        }

        project.addTemplate(template);

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, Paths.get("."));
    }

    /**
     * Removes test template.
     *
     * @throws IOException            the io exception
     * @throws JAXBException          the jaxb exception
     * @throws IllegalAccessException the illegal access exception
     */
    @Command(name = "remove")
    public void remove() throws IOException, JAXBException, IllegalAccessException {
        String removeTemplate = promptList("Choose the template to remove:", project.getTemplateListChoice(true));
        if (removeTemplate.equals(Template.ALL)) {
            project.getTemplates().clear();
        } else {
            project.getTemplates().remove(removeTemplate);
        }

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, Paths.get("."));
    }
}
