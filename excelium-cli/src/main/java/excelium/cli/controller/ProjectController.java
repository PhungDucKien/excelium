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
import com.google.api.services.sheets.v4.Sheets;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.common.TemplateUtil;
import excelium.core.reader.TestReader;
import excelium.core.reader.TestReaderFactory;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.AppType;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.sheets.SheetsReaderFactory;
import excelium.sheets.SheetsServiceProvider;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static excelium.common.Prompt.*;

/**
 * Provides commands for controlling project.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
@Controller(name = "project")
public class ProjectController extends BaseController {

    /**
     * Folder name
     */
    @Parameter(description = "Folder name")
    private String folderName;

    /**
     * Creates an empty structured project folder.
     * Project configuration file will be written to project.xml of specified folder.
     *
     * @throws IOException   the io exception
     * @throws JAXBException the jaxb exception
     */
    @Command(name = "create")
    public void create() throws IOException, JAXBException, IllegalAccessException {
        Path basePath = StringUtils.isBlank(folderName) ? Paths.get(".") : Paths.get(folderName);
        String customProjectFile = getProjectFile();
        String projectFile = StringUtils.isBlank(customProjectFile) ? "project.xml" : customProjectFile;
        Path projectFilePath = basePath.resolve(projectFile);

        if (projectFilePath.toFile().exists()) {
            boolean overwrite = promptConfirm("Project configuration file (" + projectFile + ") already exists. Would you like to overwrite?");
            if (!overwrite) {
                return;
            }
        }

        // Project instance
        Project project = new Project();

        String name = promptInput("What is the name of your project?", projectFilePath.getParent().toAbsolutePath().getFileName().toString());
        project.setName(name);

        String appTypeId = promptList("Which type of application would you like to test?", AppType.getListChoice());
        project.setAppType(AppType.fromName(appTypeId));

        String workbookTypeId = promptList("Which type of workbook would you like to use?", WorkbookType.getListChoice());
        project.setWorkbookType(WorkbookType.fromName(workbookTypeId));

        if (project.getWorkbookType() == WorkbookType.EXCEL) {
            String testFolder = promptInput("Where do you want to load test files?", "test");
            project.setTestPath(Paths.get(testFolder));

            String templateFolder = promptInput("Where do you want to load templates?", "template");
            project.setTemplatePath(Paths.get(templateFolder));
        }

        if (project.getAppType() == AppType.WEB) {
            String fileFolder = promptInput("Where do you want to load files?", "file");
            project.setFilePath(Paths.get(fileFolder));

            String downloadFolder = promptInput("Where do you want to store downloads?", "download");
            project.setDownloadPath(Paths.get(downloadFolder));
        } else {
            String appFolder = promptInput("Where do you want to load application?", "app");
            project.setAppPath(Paths.get(appFolder));
        }

        String screenshotFolder = promptInput("Where do you want to store screenshots?", "screenshot");
        project.setScreenshotPath(Paths.get(screenshotFolder));

        String appiumHost = promptInput("What is the Appium server address?", AppiumServiceBuilder.DEFAULT_LOCAL_IP_ADDRESS);
        project.setAppiumHost(appiumHost);
        String appiumPort = promptInput("What is the Appium server port?", String.valueOf(AppiumServiceBuilder.DEFAULT_APPIUM_PORT));
        project.setAppiumPort(Integer.parseInt(appiumPort));

        if (project.getWorkbookType() == WorkbookType.SHEETS) {
            boolean importDefault = promptConfirm("Would you like to import the default template?");
            if (importDefault) {
                String fileLocation = "";
                if (project.getAppType() == AppType.WEB) {
                    fileLocation = "1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50";
                } else if (project.getAppType() == AppType.MOBILE) {
                    fileLocation = "1u1Wr4JrcaGp84joTFCRLSQA1cWXLaa9TK3fUv-EkX9w";
                }
                if (StringUtils.isNotBlank(fileLocation)) {
                    GoogleConnection googleConnection = new GoogleConnectionService();
                    SheetsServiceProvider sheetsServiceProvider = new SheetsServiceProvider(googleConnection);
                    Sheets sheetsService = sheetsServiceProvider.createSheetsService();
                    TestReaderFactory testReaderFactory = new SheetsReaderFactory(sheetsService);
                    TestReader testReader = testReaderFactory.createReader(fileLocation);

                    Template template = new Template();
                    template.setLocation(fileLocation);
                    template.setName(testReader.getWorkbookName());
                    template.setMarkupLocations(testReader.batchFindFirstOccurrence(TemplateUtil.getMarkups()));

                    String mappingSheet = TemplateUtil.getSuggestSheetForMapping(template);
                    template.setMappingPattern(mappingSheet);

                    String actionSheet = TemplateUtil.getSuggestSheetForAction(template);
                    template.setActionPattern(actionSheet);

                    String dataSheet = TemplateUtil.getSuggestSheetForData(template);
                    template.setDataPattern(dataSheet);

                    template.setTestPattern("*");
                    template.addIgnorePattern("Commands");

                    project.addTemplate(template);
                }
            }
        }

        ProjectGenerator generator = new ProjectGenerator();
        generator.createProject(project, projectFilePath);
    }
}
