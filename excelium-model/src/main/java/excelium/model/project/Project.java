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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {


    /**
     * Base path
     */
    @XmlTransient
    private Path basePath;

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
     * Get test file list choice.
     *
     * @return the test file list choice
     */
    public String[][] getTestListChoice(boolean showAll) {
        if (tests != null) {
            String[][] listChoice = new String[showAll ? tests.size() + 1 : tests.size()][2];
            int i = 0;
            for (TestFile t : tests.values()) {
                listChoice[i++] = new String[]{t.getLocation(), t.getName()};
            }
            if (showAll) {
                listChoice[i] = new String[]{TestFile.ALL, "All workbooks"};
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
    public String[][] getTemplateListChoice(boolean showAll) {
        if (templates != null) {
            String[][] listChoice = new String[showAll ? templates.size() + 1 : templates.size()][2];
            int i = 0;
            for (Template t : templates.values()) {
                listChoice[i++] = new String[]{t.getLocation(), t.getName()};
            }
            if (showAll) {
                listChoice[i] = new String[]{Template.ALL, "All templates"};
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
    public String[][] getDataSourceListChoice(boolean showAll) {
        if (dataSources != null) {
            String[][] listChoice = new String[showAll ? dataSources.size() + 1 : dataSources.size()][2];
            int i = 0;
            for (DataSource d : dataSources.values()) {
                listChoice[i++] = new String[]{d.getName(), d.getName()};
            }
            if (showAll) {
                listChoice[i] = new String[]{DataSource.ALL, "All data sources"};
            }
            return listChoice;
        }
        return null;
    }
}
