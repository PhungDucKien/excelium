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

package excelium.model.project;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link Project}.
 *
 * @author PhungDucKien
 * @since 2018.04.20
 */
public class ProjectTest {

    @Test
    public void testGetTestListChoice() {
        Project project = new Project();

        TestFile testFile1 = new TestFile();
        testFile1.setLocation("dir1/dir2/file1.xlsx");
        testFile1.setName("Workbook1.xlsx");
        project.addTest(testFile1);

        TestFile testFile2 = new TestFile();
        testFile2.setLocation("dir1/dir2/file2.xlsx");
        testFile2.setName("Workbook2.xlsx");
        project.addTest(testFile2);

        String[][] listChoice = project.getTestListChoice(false);
        Assert.assertEquals(2, listChoice.length);
        Assert.assertEquals("dir1/dir2/file1.xlsx", listChoice[0][0]);
        Assert.assertEquals("Workbook1.xlsx", listChoice[0][1]);
        Assert.assertEquals("dir1/dir2/file2.xlsx", listChoice[1][0]);
        Assert.assertEquals("Workbook2.xlsx", listChoice[1][1]);

        listChoice = project.getTestListChoice(true);
        Assert.assertEquals(3, listChoice.length);
        Assert.assertEquals("dir1/dir2/file1.xlsx", listChoice[0][0]);
        Assert.assertEquals("Workbook1.xlsx", listChoice[0][1]);
        Assert.assertEquals("dir1/dir2/file2.xlsx", listChoice[1][0]);
        Assert.assertEquals("Workbook2.xlsx", listChoice[1][1]);
        Assert.assertEquals("ALL", listChoice[2][0]);
        Assert.assertEquals("All workbooks", listChoice[2][1]);
    }

    @Test
    public void testGetTemplateListChoice() {
        Project project = new Project();

        Template template1 = new Template();
        template1.setLocation("dir1/dir2/file1.xlsx");
        template1.setName("Workbook1.xlsx");
        project.addTemplate(template1);

        Template template2 = new Template();
        template2.setLocation("dir1/dir2/file2.xlsx");
        template2.setName("Workbook2.xlsx");
        project.addTemplate(template2);

        String[][] listChoice = project.getTemplateListChoice(false);
        Assert.assertEquals(2, listChoice.length);
        Assert.assertEquals("dir1/dir2/file1.xlsx", listChoice[0][0]);
        Assert.assertEquals("Workbook1.xlsx", listChoice[0][1]);
        Assert.assertEquals("dir1/dir2/file2.xlsx", listChoice[1][0]);
        Assert.assertEquals("Workbook2.xlsx", listChoice[1][1]);

        listChoice = project.getTemplateListChoice(true);
        Assert.assertEquals(3, listChoice.length);
        Assert.assertEquals("dir1/dir2/file1.xlsx", listChoice[0][0]);
        Assert.assertEquals("Workbook1.xlsx", listChoice[0][1]);
        Assert.assertEquals("dir1/dir2/file2.xlsx", listChoice[1][0]);
        Assert.assertEquals("Workbook2.xlsx", listChoice[1][1]);
        Assert.assertEquals("ALL", listChoice[2][0]);
        Assert.assertEquals("All templates", listChoice[2][1]);
    }
}
