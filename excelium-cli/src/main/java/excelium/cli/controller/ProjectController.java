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
import excelium.cli.Prompt;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.AppType;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Provides commands for controlling Project.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
@Controller(name = "project")
public class ProjectController {

    /** Folder name */
    @Parameter(description = "Folder name")
    private String folderName;

    /**
     * Creates an empty structured project folder.
     * Project configuration file will be written to project.xml of specified folder.
     */
    @Command(name = "create")
    public void create() throws IOException, JAXBException {
        String defaultProjectName = folderName;
        if (StringUtils.isBlank(folderName)) {
            defaultProjectName = getWorkingDirectoryName();
        }

        Path basePath = StringUtils.isBlank(folderName) ? Paths.get(".") : Paths.get(folderName);
        File projectFile = basePath.resolve("project.xml").toFile();

        if (projectFile.exists()) {
            boolean overwrite = Prompt.promptConfirm("Project configuration file (project.xml) already exists. Would you like to overwrite?");
            if (!overwrite) {
                return;
            }
        }

        // Project instance
        Project project = new Project();

        String name = Prompt.promptInput("What is the name of your project?", defaultProjectName);
        project.setName(name);

        String appTypeId = Prompt.promptList("Which type of application would you like to test?",
                new String[] { AppType.WEB.name(), AppType.WEB.getText() },
                new String[] { AppType.MOBILE.name(), AppType.MOBILE.getText() },
                new String[] { AppType.UNDEFINED.name(), AppType.UNDEFINED.getText() });
        project.setAppType(AppType.fromName(appTypeId));

        String workbookTypeId = Prompt.promptList("Which type of workbook would you like to use?",
                new String[] { WorkbookType.SHEETS.name(), WorkbookType.SHEETS.getText() },
                new String[] { WorkbookType.EXCEL.name(), WorkbookType.EXCEL.getText() });
        project.setWorkbookType(WorkbookType.fromName(workbookTypeId));

        if (project.getWorkbookType() == WorkbookType.EXCEL) {
            String testFolder = Prompt.promptInput("Where do you want to load test files?", "test");
            project.setTestPath(Paths.get(testFolder));

            String templateFolder = Prompt.promptInput("Where do you want to load templates?", "template");
            project.setTemplatePath(Paths.get(templateFolder));
        }

        if (project.getAppType() != AppType.WEB) {
            String appFolder = Prompt.promptInput("Where do you want to load application?", "app");
            project.setAppPath(Paths.get(appFolder));
        }

        if (project.getAppType() != AppType.MOBILE) {
            String fileFolder = Prompt.promptInput("Where do you want to load files?", "file");
            project.setFilePath(Paths.get(fileFolder));
        }

        String screenshotFolder = Prompt.promptInput("Where do you want to store screenshots?", "screenshot");
        project.setScreenshotPath(Paths.get(screenshotFolder));

        if (project.getAppType() != AppType.MOBILE) {
            String downloadFolder = Prompt.promptInput("Where do you want to store downloads?", "download");
            project.setDownloadPath(Paths.get(downloadFolder));
        }

        ProjectGenerator generator = new ProjectGenerator();
        generator.createProject(project, basePath);
    }

    /**
     * Returns current working directory name.
     *
     * @return Current working directory name
     */
    private String getWorkingDirectoryName() {
        return Paths.get(System.getProperty("user.dir")).getFileName().toString();
    }
}
