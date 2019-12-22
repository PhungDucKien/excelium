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

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.Parameter;
import excelium.generator.ProjectGenerator;
import excelium.model.project.Project;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Base controller.
 *
 * @author PhungDucKien
 * @since 2018.04.15
 */
public class BaseController {

    /**
     * Help flag
     */
    @Parameter(names = {"-h", "--help"}, description = "Print help information", help = true)
    private boolean help = false;

    /**
     * Project file
     */
    @Parameter(names = {"-f", "--project-file"}, description = "Force the use of an alternate project file", help = true)
    private String projectFile;

    /**
     * System properties
     */
    @DynamicParameter(names = "-D", description = "Define a system property")
    private Map<String, String> properties = new HashMap<>();

    /**
     * Gets help flag.
     *
     * @return the help flag
     */
    public boolean isHelp() {
        return help;
    }

    /**
     * Gets project file.
     *
     * @return the project file
     */
    public String getProjectFile() {
        return projectFile;
    }

    /**
     * Gets system properties
     *
     * @return the system properties
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    protected void updateProjectFile(Project project) throws JAXBException, IOException {
        String customProjectFile = getProjectFile();
        Path projectFilePath = Paths.get(StringUtils.isBlank(customProjectFile) ? "project.xml" : customProjectFile);

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, projectFilePath);
    }
}
