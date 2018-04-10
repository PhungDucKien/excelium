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
import excelium.model.project.Project;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Creates an empty structured project folder.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class ProjectGenerator {

    /**
     * Creates an empty structured project folder.
     *
     * @param project  Project model
     * @param basePath Project base path
     * @throws IOException   if any unexpected problem occurs during directory creation
     * @throws JAXBException if any unexpected problem occurs during the project marshalling
     */
    public void createProject(Project project, Path basePath) throws IOException, JAXBException {

        Files.createDirectories(basePath);
        Files.createDirectories(basePath.resolve("config"));

        if (project.getTestPath() != null) {
            Files.createDirectories(basePath.resolve(project.getTestPath()));
        }
        if (project.getTemplatePath() != null) {
            Files.createDirectories(basePath.resolve(project.getTemplatePath()));
        }
        if (project.getAppPath() != null) {
            Files.createDirectories(basePath.resolve(project.getAppPath()));
        }
        if (project.getFilePath() != null) {
            Files.createDirectories(basePath.resolve(project.getFilePath()));
        }
        if (project.getScreenshotPath() != null) {
            Files.createDirectories(basePath.resolve(project.getScreenshotPath()));
        }
        if (project.getDownloadPath() != null) {
            Files.createDirectories(basePath.resolve(project.getDownloadPath()));
        }

        XmlMarshaller.marshaller(project, basePath.resolve("project.xml"));
    }
}
