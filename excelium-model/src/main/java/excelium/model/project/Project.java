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

import excelium.model.adapter.PathXmlAdapter;
import excelium.model.enums.AppType;
import excelium.model.enums.WorkbookType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.nio.file.Path;
import java.util.Map;

/**
 * Represents project model.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

    /** Project name */
    private String name;

    /** Application type */
    private AppType appType;

    /** Workbook type */
    private WorkbookType workbookType;

    /** Test path */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path testPath;

    /** Template path */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path templatePath;

    /** App path */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path appPath;

    /** File path */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path filePath;

    /** Screenshot path */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path screenshotPath;

    /** Download path */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path downloadPath;

    /** Test files */
    @XmlElement(name = "tests")
    private Map<String, TestFile> testFiles;

    /** Templates */
    @XmlElement(name = "templates")
    private Map<String, Template> templates;

    /** Default template */
    private String defaultTemplate;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets app type.
     *
     * @return the app type
     */
    public AppType getAppType() {
        return appType;
    }

    /**
     * Sets app type.
     *
     * @param appType the app type
     */
    public void setAppType(AppType appType) {
        this.appType = appType;
    }

    /**
     * Gets workbook type.
     *
     * @return the workbook type
     */
    public WorkbookType getWorkbookType() {
        return workbookType;
    }

    /**
     * Sets workbook type.
     *
     * @param workbookType the workbook type
     */
    public void setWorkbookType(WorkbookType workbookType) {
        this.workbookType = workbookType;
    }

    /**
     * Gets test path.
     *
     * @return the test path
     */
    public Path getTestPath() {
        return testPath;
    }

    /**
     * Sets test path.
     *
     * @param testPath the test path
     */
    public void setTestPath(Path testPath) {
        this.testPath = testPath;
    }

    /**
     * Gets template path.
     *
     * @return the template path
     */
    public Path getTemplatePath() {
        return templatePath;
    }

    /**
     * Sets template path.
     *
     * @param templatePath the template path
     */
    public void setTemplatePath(Path templatePath) {
        this.templatePath = templatePath;
    }

    /**
     * Gets app path.
     *
     * @return the app path
     */
    public Path getAppPath() {
        return appPath;
    }

    /**
     * Sets app path.
     *
     * @param appPath the app path
     */
    public void setAppPath(Path appPath) {
        this.appPath = appPath;
    }

    /**
     * Gets file path.
     *
     * @return the file path
     */
    public Path getFilePath() {
        return filePath;
    }

    /**
     * Sets file path.
     *
     * @param filePath the file path
     */
    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets screenshot path.
     *
     * @return the screenshot path
     */
    public Path getScreenshotPath() {
        return screenshotPath;
    }

    /**
     * Sets screenshot path.
     *
     * @param screenshotPath the screenshot path
     */
    public void setScreenshotPath(Path screenshotPath) {
        this.screenshotPath = screenshotPath;
    }

    /**
     * Gets download path.
     *
     * @return the download path
     */
    public Path getDownloadPath() {
        return downloadPath;
    }

    /**
     * Sets download path.
     *
     * @param downloadPath the download path
     */
    public void setDownloadPath(Path downloadPath) {
        this.downloadPath = downloadPath;
    }

    /**
     * Gets test files.
     *
     * @return the test files
     */
    public Map<String, TestFile> getTestFiles() {
        return testFiles;
    }

    /**
     * Sets test files.
     *
     * @param testFiles the test files
     */
    public void setTestFiles(Map<String, TestFile> testFiles) {
        this.testFiles = testFiles;
    }

    /**
     * Gets templates.
     *
     * @return the templates
     */
    public Map<String, Template> getTemplates() {
        return templates;
    }

    /**
     * Sets templates.
     *
     * @param templates the templates
     */
    public void setTemplates(Map<String, Template> templates) {
        this.templates = templates;
    }

    /**
     * Gets default template.
     *
     * @return the default template
     */
    public String getDefaultTemplate() {
        return defaultTemplate;
    }

    /**
     * Sets default template.
     *
     * @param defaultTemplate the default template
     */
    public void setDefaultTemplate(String defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }
}
