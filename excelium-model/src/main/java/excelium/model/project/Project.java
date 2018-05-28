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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.nio.file.Path;
import java.util.LinkedHashMap;
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

    /**
     * Project name
     */
    private String name;

    /**
     * Application type
     */
    private AppType appType;

    /**
     * Workbook type
     */
    private WorkbookType workbookType;

    /**
     * Test path
     */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path testPath;

    /**
     * Template path
     */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path templatePath;

    /**
     * App path
     */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path appPath;

    /**
     * File path
     */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path filePath;

    /**
     * Screenshot path
     */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path screenshotPath;

    /**
     * Download path
     */
    @XmlJavaTypeAdapter(PathXmlAdapter.class)
    private Path downloadPath;

    /**
     * Test files
     */
    private Map<String, TestFile> tests;

    /**
     * Templates
     */
    private Map<String, Template> templates;

    /**
     * Data sources
     */
    private Map<String, DataSource> dataSources;

    /**
     * Default data source
     */
    private String defaultDataSource;

    /**
     * Appium host
     */
    private String appiumHost;

    /**
     * Appium port
     */
    private Integer appiumPort;

    /**
     * Excelium port
     */
    private Integer exceliumPort;

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
     * Gets tests.
     *
     * @return the tests
     */
    public Map<String, TestFile> getTests() {
        return tests;
    }

    /**
     * Sets tests.
     *
     * @param tests the tests
     */
    public void setTests(Map<String, TestFile> tests) {
        this.tests = tests;
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
     * Gets data sources.
     *
     * @return the data sources
     */
    public Map<String, DataSource> getDataSources() {
        return dataSources;
    }

    /**
     * Sets data sources.
     *
     * @param dataSources the data sources
     */
    public void setDataSources(Map<String, DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    /**
     * Gets default data source.
     *
     * @return the default data source
     */
    public String getDefaultDataSource() {
        return defaultDataSource;
    }

    /**
     * Sets default data source.
     *
     * @param defaultDataSource the default data source
     */
    public void setDefaultDataSource(String defaultDataSource) {
        this.defaultDataSource = defaultDataSource;
    }

    /**
     * Gets appium host.
     *
     * @return the appium host
     */
    public String getAppiumHost() {
        return appiumHost;
    }

    /**
     * Sets appium host.
     *
     * @param appiumHost the appium host
     */
    public void setAppiumHost(String appiumHost) {
        this.appiumHost = appiumHost;
    }

    /**
     * Gets appium port.
     *
     * @return the appium port
     */
    public Integer getAppiumPort() {
        return appiumPort;
    }

    /**
     * Sets appium port.
     *
     * @param appiumPort the appium port
     */
    public void setAppiumPort(Integer appiumPort) {
        this.appiumPort = appiumPort;
    }

    /**
     * Gets excelium port.
     *
     * @return the excelium port
     */
    public Integer getExceliumPort() {
        return exceliumPort;
    }

    /**
     * Sets excelium port.
     *
     * @param exceliumPort the excelium port
     */
    public void setExceliumPort(Integer exceliumPort) {
        this.exceliumPort = exceliumPort;
    }

    /**
     * Get test file list choice.
     *
     * @return the test file list choice
     */
    public String[][] getTestListChoice() {
        if (tests != null) {
            String[][] listChoice = new String[tests.size()][2];
            int i = 0;
            for (TestFile t : tests.values()) {
                listChoice[i++] = new String[]{t.getLocation(), t.getName()};
            }
            return listChoice;
        }
        return null;
    }

    /**
     * Get template list choice.
     *
     * @return the template list choice
     */
    public String[][] getTemplateListChoice() {
        if (templates != null) {
            String[][] listChoice = new String[templates.size()][2];
            int i = 0;
            for (Template t : templates.values()) {
                listChoice[i++] = new String[]{t.getLocation(), t.getName()};
            }
            return listChoice;
        }
        return null;
    }

    /**
     * Get data source list choice.
     *
     * @return the data source list choice
     */
    public String[][] getDataSourceListChoice() {
        if (dataSources != null) {
            String[][] listChoice = new String[dataSources.size()][2];
            int i = 0;
            for (DataSource d : dataSources.values()) {
                listChoice[i++] = new String[]{d.getName(), d.getName()};
            }
            return listChoice;
        }
        return null;
    }

    /**
     * Add test.
     *
     * @param test the test
     */
    public void addTest(TestFile test) {
        if (tests == null) {
            tests = new LinkedHashMap<>();
        }
        tests.put(test.getLocation(), test);
    }

    /**
     * Add template.
     *
     * @param template the template
     */
    public void addTemplate(Template template) {
        if (templates == null) {
            templates = new LinkedHashMap<>();
        }
        templates.put(template.getLocation(), template);
    }

    /**
     * Add data source.
     *
     * @param dataSource the data source
     */
    public void addDataSource(DataSource dataSource) {
        if (dataSources == null) {
            dataSources = new LinkedHashMap<>();
        }
        dataSources.put(dataSource.getName(), dataSource);
    }
}
