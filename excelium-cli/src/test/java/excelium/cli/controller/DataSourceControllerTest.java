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

import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import excelium.core.database.DatabaseService;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.DataSourceType;
import excelium.model.project.DataSource;
import excelium.model.project.Project;
import mockit.*;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for {@link DataSourceController}.
 *
 * @author PhungDucKien
 * @since 2018.05.26
 */
public class DataSourceControllerTest {

    @Mocked
    ConsolePrompt consolePrompt;

    @Mocked
    ProjectGenerator projectGenerator;

    @Mocked
    DatabaseService databaseService;

    @Tested
    DataSourceController dataSourceController;

    @Test
    public void testAdd() throws IOException, JAXBException, IllegalAccessException {
        Project project = new Project();
        Deencapsulation.setField(dataSourceController, project);

        new Expectations() {{
            databaseService.testConnection((DataSource) any); result = true;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ListResult>() {{ put("", new ListResult("MySQL")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("localhost")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("3306")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("dbname")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("user")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("passwd")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("default")); }});
        }};

        dataSourceController.add();

        Assert.assertEquals(1, project.getDataSources().size());
        Assert.assertEquals("default", project.getDefaultDataSource());
        Assert.assertEquals(DataSourceType.MYSQL, project.getDataSources().get("default").getType());
        Assert.assertEquals("com.mysql.cj.jdbc.Driver", project.getDataSources().get("default").getDriverClass());
        Assert.assertEquals("jdbc:mysql://localhost:3306/dbname", project.getDataSources().get("default").getUrl());
        Assert.assertEquals("user", project.getDataSources().get("default").getUserName());
        Assert.assertEquals("passwd", project.getDataSources().get("default").getPassword());

        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testAddSecond() throws IOException, JAXBException, IllegalAccessException {
        Project project = new Project();
        Deencapsulation.setField(dataSourceController, project);

        new Expectations() {{
            databaseService.testConnection((DataSource) any); result = true;

            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ListResult>() {{ put("", new ListResult("MySQL")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("localhost")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("3306")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("dbname")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("user")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("passwd")); }},
                    new HashMap<String, InputResult>() {{ put("", new InputResult("default")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("default")); }});

            project.setDefaultDataSource("ds2");
            project.setDataSources(new HashMap<String, DataSource>() {{
                put("ds2", new DataSource());
            }});
        }};

        dataSourceController.add();

        Assert.assertEquals(2, project.getDataSources().size());
        Assert.assertEquals("default", project.getDefaultDataSource());
        Assert.assertEquals(DataSourceType.MYSQL, project.getDataSources().get("default").getType());
        Assert.assertEquals("com.mysql.cj.jdbc.Driver", project.getDataSources().get("default").getDriverClass());
        Assert.assertEquals("jdbc:mysql://localhost:3306/dbname", project.getDataSources().get("default").getUrl());
        Assert.assertEquals("user", project.getDataSources().get("default").getUserName());
        Assert.assertEquals("passwd", project.getDataSources().get("default").getPassword());

        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveNonDefault() throws IOException, JAXBException {
        Project project = new Project();
        Deencapsulation.setField(dataSourceController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ListResult>() {{ put("", new ListResult("ds2")); }};

            project.setDefaultDataSource("ds3");
            project.setDataSources(new HashMap<String, DataSource>() {{
                put("ds1", new DataSource());
                put("ds2", new DataSource());
                put("ds3", new DataSource());
            }});
        }};

        dataSourceController.remove();

        Assert.assertEquals(2, project.getDataSources().size());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveDefault() throws IOException, JAXBException {
        Project project = new Project();
        Deencapsulation.setField(dataSourceController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            returns(new HashMap<String, ListResult>() {{ put("", new ListResult("ds2")); }},
                    new HashMap<String, ListResult>() {{ put("", new ListResult("ds3")); }});

            project.setDefaultDataSource("ds2");
            project.setDataSources(new HashMap<String, DataSource>() {{
                put("ds1", new DataSource());
                put("ds2", new DataSource());
                put("ds3", new DataSource());
            }});
        }};

        dataSourceController.remove();

        Assert.assertEquals(2, project.getDataSources().size());
        Assert.assertEquals("ds3", project.getDefaultDataSource());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveDefault2() throws IOException, JAXBException {
        Project project = new Project();
        Deencapsulation.setField(dataSourceController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ListResult>() {{ put("", new ListResult("ds2")); }};

            project.setDefaultDataSource("ds2");
            project.setDataSources(new HashMap<String, DataSource>() {{
                put("ds1", new DataSource());
                put("ds2", new DataSource());
            }});
        }};

        dataSourceController.remove();

        Assert.assertEquals(1, project.getDataSources().size());
        Assert.assertEquals("ds1", project.getDefaultDataSource());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }

    @Test
    public void testRemoveLast() throws IOException, JAXBException {
        Project project = new Project();
        Deencapsulation.setField(dataSourceController, project);

        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ListResult>() {{ put("", new ListResult("ds2")); }};

            project.setDefaultDataSource("ds2");
            project.setDataSources(new HashMap<String, DataSource>() {{
                put("ds2", new DataSource());
            }});
        }};

        dataSourceController.remove();

        Assert.assertEquals(0, project.getDataSources().size());
        Assert.assertEquals(null, project.getDefaultDataSource());
        new Verifications() {{
            projectGenerator.updateProject((Project) any, (Path) any);
        }};
    }
}