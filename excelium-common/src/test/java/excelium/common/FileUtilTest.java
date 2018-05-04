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

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Tests for {@link FileUtil}.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class FileUtilTest {

    @Test
    public void testListFiles() throws IOException {
        Path templatePath = Paths.get("template_test");

        // Generates files
        Files.createDirectories(templatePath.resolve("category1").resolve("group1"));
        Files.createDirectories(templatePath.resolve("category1").resolve("group2"));
        Files.createDirectories(templatePath.resolve("category2").resolve("group3"));

        Files.createFile(templatePath.resolve("category1").resolve("group1").resolve("File1.xlsx"));
        Files.createFile(templatePath.resolve("category1").resolve("group2").resolve("File2.xlsx"));
        Files.createFile(templatePath.resolve("category2").resolve("group3").resolve("File3.xlsx"));
        Files.createFile(templatePath.resolve("category1").resolve("group1").resolve("File4.xlsx"));

        List<String> templateFiles = FileUtil.listFiles(templatePath);
        Assert.assertEquals(4, templateFiles.size());
        Assert.assertTrue(templateFiles.contains("category1/group1/File1.xlsx"));
        Assert.assertTrue(templateFiles.contains("category1/group1/File4.xlsx"));
        Assert.assertTrue(templateFiles.contains("category1/group2/File2.xlsx"));
        Assert.assertTrue(templateFiles.contains("category2/group3/File3.xlsx"));

        // Deletes generated files
        Files.delete(templatePath.resolve("category1").resolve("group1").resolve("File1.xlsx"));
        Files.delete(templatePath.resolve("category1").resolve("group2").resolve("File2.xlsx"));
        Files.delete(templatePath.resolve("category2").resolve("group3").resolve("File3.xlsx"));
        Files.delete(templatePath.resolve("category1").resolve("group1").resolve("File4.xlsx"));

        Files.delete(templatePath.resolve("category1").resolve("group1"));
        Files.delete(templatePath.resolve("category1").resolve("group2"));
        Files.delete(templatePath.resolve("category2").resolve("group3"));

        Files.delete(templatePath.resolve("category1"));
        Files.delete(templatePath.resolve("category2"));

        Files.delete(templatePath);
    }
}
