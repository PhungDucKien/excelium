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

package excelium.core;

import excelium.core.reader.TestReader;
import excelium.core.reader.TestReaderFactory;
import excelium.core.writer.TestWriter;
import excelium.core.writer.TestWriterFactory;
import excelium.model.enums.AppType;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import excelium.model.project.Template;
import excelium.model.project.TestFile;
import excelium.model.test.TestFilter;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link TestExecutor}.
 *
 * @author PhungDucKien
 * @since 2018.05.04
 */
public class TestExecutorTest {

    @Mocked
    private TestReaderFactory testReaderFactory;

    @Mocked
    private TestWriterFactory testWriterFactory;

    @Mocked
    private TestReader testReader;

    private Project createTestProject() {
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
        testFile.setName("testFile1");
        testFile.setLocation("testFile1.xlsx");
        testFile.setTemplate("default");
        testFiles.put("testFile1", testFile);
        testFile = new TestFile();
        testFile.setName("testFile2");
        testFile.setLocation("testFile2.xlsx");
        testFile.setTemplate("default");
        testFiles.put("testFile2", testFile);
        testFile = new TestFile();
        testFile.setName("testFile3");
        testFile.setLocation("testFile3.xlsx");
        testFile.setTemplate("default");
        testFiles.put("testFile3", testFile);
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

        return project;
    }

    @Test
    public void testExecuteAll() throws IOException {
        new Expectations() {{
            testReaderFactory.createReader(anyString); result = testReader;
        }};

        TestExecutor testExecutor = new TestExecutor(createTestProject(), testReaderFactory, testWriterFactory);
        testExecutor.execute(null);

        new Verifications() {{
            testReader.parseTest((Template) any, null, (TestWriter) any); times = 3;
        }};
    }

    @Test
    public void testExecuteWithFilter() throws IOException {
        new Expectations() {{
            testReaderFactory.createReader(anyString); result = testReader;
        }};

        TestFilter testFilter = new TestFilter();
        List<String> workbooks = new ArrayList<>();
        workbooks.add("testFile2");
        testFilter.setWorkbooks(workbooks);

        TestExecutor testExecutor = new TestExecutor(createTestProject(), testReaderFactory, testWriterFactory);
        testExecutor.execute(testFilter);

        new Verifications() {{
            testReader.parseTest((Template) any, (TestFilter) any, (TestWriter) any); times = 1;
        }};
    }

    @Test
    public void testExecuteWhenParseError() throws IOException {
        new Expectations() {{
            testReaderFactory.createReader(anyString); result = testReader;
            testReader.parseTest((Template) any, null, (TestWriter) any); result = new IOException();
        }};

        TestExecutor testExecutor = new TestExecutor(createTestProject(), testReaderFactory, testWriterFactory);
        testExecutor.execute(null);
    }
}
