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

package excelium.common;

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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link XmlMarshaller}.
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
public class XmlMarshallerTest {

    @Test
    public void testMarshaller() throws JAXBException, IOException {
        Project project = new Project();
        project.setName("myproject");
        project.setAppType(AppType.WEB);
        project.setWorkbookType(WorkbookType.SHEETS);
        project.setTestPath(Paths.get("tests"));

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

        XmlMarshaller.marshaller(project, Paths.get("dump"));

        Project unmarshalled = (Project) XmlMarshaller.unmarshaller(Paths.get("dump"), Project.class);

        Assert.assertEquals("myproject", unmarshalled.getName());
        Assert.assertEquals(AppType.WEB, unmarshalled.getAppType());
        Assert.assertEquals(WorkbookType.SHEETS, unmarshalled.getWorkbookType());
        Assert.assertEquals(Paths.get("tests"), unmarshalled.getTestPath());

        Assert.assertEquals(1, unmarshalled.getTests().size());
        Assert.assertEquals("testFile", unmarshalled.getTests().get("testFile").getName());
        Assert.assertEquals("testFile.xlsx", unmarshalled.getTests().get("testFile").getLocation());

        Assert.assertEquals(1, unmarshalled.getTemplates().size());
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getMarkupLocations().size());
        Assert.assertEquals("A2", unmarshalled.getTemplates().get("default").getMarkupLocations().get("%SYSTEM_NAME%"));
        Assert.assertEquals(1, unmarshalled.getTemplates().get("default").getIgnorePatterns().size());
        Assert.assertEquals("*", unmarshalled.getTemplates().get("default").getIgnorePatterns().get(0));

        Files.delete(Paths.get("dump"));
    }
}
