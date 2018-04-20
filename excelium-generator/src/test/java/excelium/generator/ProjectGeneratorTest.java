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

package excelium.generator;

import excelium.common.XmlMarshaller;
import excelium.model.enums.AppType;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.project.TestFile;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link ProjectGenerator}.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class ProjectGeneratorTest {

    @Test
    public void testCreateProject() throws IOException, JAXBException {

        Project project = new Project();
        project.setName("myproject");
        project.setAppType(AppType.WEB);
        project.setWorkbookType(WorkbookType.SHEETS);

        Map<String, TestFile> testFiles = new HashMap<>();
        TestFile testFile = new TestFile();
        testFile.setName("testFile");
        testFile.setLocation("testFile.xlsx");
        testFiles.put("testFile", testFile);
        project.setTests(testFiles);

        Map<String, Template> templates = new HashMap<>();
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%SYSTEM_NAME%", "A2");
        template.setMarkupLocations(markupLocations);
        List<String> ignorePatterns = new ArrayList<>();
        ignorePatterns.add("*");
        template.setIgnorePatterns(ignorePatterns);
        templates.put("default", template);
        project.setTemplates(templates);

        Path basePath = Paths.get("myproject");

        ProjectGenerator generator = new ProjectGenerator();
        generator.createProject(project, basePath);

        Assert.assertEquals(true, Files.exists(basePath));
        Assert.assertEquals(true, Files.exists(basePath.resolve("config")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("project.xml")));

        Project unmarshalled = (Project) XmlMarshaller.unmarshall(basePath.resolve("project.xml"), Project.class);

        Assert.assertEquals("myproject", unmarshalled.getName());
        Assert.assertEquals(AppType.WEB, unmarshalled.getAppType());
        Assert.assertEquals(WorkbookType.SHEETS, unmarshalled.getWorkbookType());

        Assert.assertEquals(1, unmarshalled.getTests().size());
        Assert.assertEquals("testFile", unmarshalled.getTests().get("testFile").getName());
        Assert.assertEquals("testFile.xlsx", unmarshalled.getTests().get("testFile").getLocation());

        Assert.assertEquals(1, unmarshalled.getTemplates().size());
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getMarkupLocations().size());
        Assert.assertEquals("A2", unmarshalled.getTemplates().get("default").getMarkupLocations().get("%SYSTEM_NAME%"));
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getIgnorePatterns().size());
        Assert.assertEquals("*", unmarshalled.getTemplates().get("default").getIgnorePatterns().get(0));

        // Deletes generated files
        Files.delete(basePath.resolve("project.xml"));
        Files.delete(basePath.resolve("config"));
        Files.delete(basePath);
    }

    @Test
    public void testCreateProjectWithAllPaths() throws IOException, JAXBException {

        Project project = new Project();
        project.setName("myproject");
        project.setAppType(AppType.WEB);
        project.setWorkbookType(WorkbookType.SHEETS);
        project.setTestPath(Paths.get("test"));
        project.setTemplatePath(Paths.get("template"));
        project.setAppPath(Paths.get("app"));
        project.setFilePath(Paths.get("file"));
        project.setScreenshotPath(Paths.get("screenshot"));
        project.setDownloadPath(Paths.get("download"));

        Map<String, TestFile> testFiles = new HashMap<>();
        TestFile testFile = new TestFile();
        testFile.setName("testFile");
        testFile.setLocation("testFile.xlsx");
        testFiles.put("testFile", testFile);
        project.setTests(testFiles);

        Map<String, Template> templates = new HashMap<>();
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%SYSTEM_NAME%", "A2");
        template.setMarkupLocations(markupLocations);
        List<String> ignorePatterns = new ArrayList<>();
        ignorePatterns.add("*");
        template.setIgnorePatterns(ignorePatterns);
        templates.put("default", template);
        project.setTemplates(templates);

        Path basePath = Paths.get("myproject");

        ProjectGenerator generator = new ProjectGenerator();
        generator.createProject(project, basePath);

        Assert.assertEquals(true, Files.exists(basePath));
        Assert.assertEquals(true, Files.exists(basePath.resolve("config")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("test")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("template")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("app")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("file")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("screenshot")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("download")));
        Assert.assertEquals(true, Files.exists(basePath.resolve("project.xml")));

        Project unmarshalled = (Project) XmlMarshaller.unmarshall(basePath.resolve("project.xml"), Project.class);

        Assert.assertEquals("myproject", unmarshalled.getName());
        Assert.assertEquals(AppType.WEB, unmarshalled.getAppType());
        Assert.assertEquals(WorkbookType.SHEETS, unmarshalled.getWorkbookType());
        Assert.assertEquals(Paths.get("test"), unmarshalled.getTestPath());
        Assert.assertEquals(Paths.get("template"), unmarshalled.getTemplatePath());
        Assert.assertEquals(Paths.get("app"), unmarshalled.getAppPath());
        Assert.assertEquals(Paths.get("file"), unmarshalled.getFilePath());
        Assert.assertEquals(Paths.get("screenshot"), unmarshalled.getScreenshotPath());
        Assert.assertEquals(Paths.get("download"), unmarshalled.getDownloadPath());

        Assert.assertEquals(1, unmarshalled.getTests().size());
        Assert.assertEquals("testFile", unmarshalled.getTests().get("testFile").getName());
        Assert.assertEquals("testFile.xlsx", unmarshalled.getTests().get("testFile").getLocation());

        Assert.assertEquals(1, unmarshalled.getTemplates().size());
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getMarkupLocations().size());
        Assert.assertEquals("A2", unmarshalled.getTemplates().get("default").getMarkupLocations().get("%SYSTEM_NAME%"));
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getIgnorePatterns().size());
        Assert.assertEquals("*", unmarshalled.getTemplates().get("default").getIgnorePatterns().get(0));

        // Deletes generated files
        Files.delete(basePath.resolve("project.xml"));
        Files.delete(basePath.resolve("config"));
        Files.delete(basePath.resolve("test"));
        Files.delete(basePath.resolve("template"));
        Files.delete(basePath.resolve("app"));
        Files.delete(basePath.resolve("file"));
        Files.delete(basePath.resolve("screenshot"));
        Files.delete(basePath.resolve("download"));
        Files.delete(basePath);
    }

    @Test
    public void testUpdateProject() throws IOException, JAXBException {

        Project project = new Project();
        project.setName("myproject");
        project.setAppType(AppType.WEB);
        project.setWorkbookType(WorkbookType.SHEETS);

        Map<String, TestFile> testFiles = new HashMap<>();
        TestFile testFile = new TestFile();
        testFile.setName("testFile");
        testFile.setLocation("testFile.xlsx");
        testFiles.put("testFile", testFile);
        project.setTests(testFiles);

        Map<String, Template> templates = new HashMap<>();
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%SYSTEM_NAME%", "A2");
        template.setMarkupLocations(markupLocations);
        List<String> ignorePatterns = new ArrayList<>();
        ignorePatterns.add("*");
        template.setIgnorePatterns(ignorePatterns);
        templates.put("default", template);
        project.setTemplates(templates);

        Path basePath = Paths.get("myproject");

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, basePath);

        Assert.assertEquals(true, Files.exists(basePath));
        Assert.assertEquals(true, Files.exists(basePath.resolve("project.xml")));

        Project unmarshalled = (Project) XmlMarshaller.unmarshall(basePath.resolve("project.xml"), Project.class);

        Assert.assertEquals("myproject", unmarshalled.getName());
        Assert.assertEquals(AppType.WEB, unmarshalled.getAppType());
        Assert.assertEquals(WorkbookType.SHEETS, unmarshalled.getWorkbookType());

        Assert.assertEquals(1, unmarshalled.getTests().size());
        Assert.assertEquals("testFile", unmarshalled.getTests().get("testFile").getName());
        Assert.assertEquals("testFile.xlsx", unmarshalled.getTests().get("testFile").getLocation());

        Assert.assertEquals(1, unmarshalled.getTemplates().size());
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getMarkupLocations().size());
        Assert.assertEquals("A2", unmarshalled.getTemplates().get("default").getMarkupLocations().get("%SYSTEM_NAME%"));
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getIgnorePatterns().size());
        Assert.assertEquals("*", unmarshalled.getTemplates().get("default").getIgnorePatterns().get(0));

        // Deletes generated files
        Files.delete(basePath.resolve("project.xml"));
        Files.delete(basePath);
    }
}
