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

import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.core.database.DatabaseService;
import excelium.generator.ProjectGenerator;
import excelium.model.enums.DataSourceType;
import excelium.model.project.DataSource;
import excelium.model.project.Project;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Paths;

import static excelium.cli.Prompt.promptInput;
import static excelium.cli.Prompt.promptList;

/**
 * Provides commands for controlling data source.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
@Controller(name = "ds")
public class DataSourceController extends BaseController {

    /**
     * Project instance
     */
    @Injectable
    private Project project;

    /**
     * Adds data source.
     *
     * @throws IOException            the io exception
     * @throws JAXBException          the jaxb exception
     * @throws IllegalAccessException the illegal access exception
     */
    @Command(name = "add")
    public void add() throws IOException, JAXBException {

        String dataSourceTypeId = promptList("What is the type of database you want to connect?", DataSourceType.getListChoice());
        DataSourceType dataSourceType = DataSourceType.fromName(dataSourceTypeId);

        String driverClass = dataSourceType.getDriverClass();

        String databaseHost = promptInput("Database Host", "localhost");
        String databasePort = promptInput("Database Port", String.valueOf(dataSourceType.getDefaultPort()));
        String databaseName = promptInput("Database Name", null);
        String userName = promptInput("User Name", null);
        String password = promptInput("Password", null);

        String url = dataSourceType.getUrl(databaseHost, databasePort, databaseName);

        DataSource dataSource = new DataSource();
        dataSource.setType(dataSourceType);
        dataSource.setDriverClass(driverClass);
        dataSource.setUrl(url);
        dataSource.setUserName(userName);
        dataSource.setPassword(password);

        DatabaseService databaseService = new DatabaseService(project);
        boolean isConnectible = databaseService.testConnection(dataSource);

        if (isConnectible) {
            String dataSourceName = promptInput("Enter the name of the data source", databaseName);
            dataSource.setName(dataSourceName);
            project.addDataSource(dataSource);

            if (project.getDataSources().size() == 1) {
                project.setDefaultDataSource(dataSource.getName());
            } else {
                String defaultDataSource = promptList("Please choose the default data source", project.getDataSourceListChoice());
                project.setDefaultDataSource(defaultDataSource);
            }

            ProjectGenerator generator = new ProjectGenerator();
            generator.updateProject(project, Paths.get("."));
        } else {
            System.out.println("The database is not connectible.");
        }
    }

    /**
     * Removes data source.
     *
     * @throws IOException            the io exception
     * @throws JAXBException          the jaxb exception
     * @throws IllegalAccessException the illegal access exception
     */
    @Command(name = "remove")
    public void remove() throws IOException, JAXBException {
        String removeDataSource = promptList("Choose the data source to remove:", project.getDataSourceListChoice());
        project.getDataSources().remove(removeDataSource);

        if (StringUtils.equals(project.getDefaultDataSource(), removeDataSource)) {
            if (project.getDataSources().size() == 0) {
                project.setDefaultDataSource(null);
            } else if (project.getDataSources().size() == 1) {
                project.setDefaultDataSource(project.getDataSources().keySet().iterator().next());
            } else {
                String defaultDataSource = promptList("Please choose the default data source", project.getDataSourceListChoice());
                project.setDefaultDataSource(defaultDataSource);
            }
        }

        ProjectGenerator generator = new ProjectGenerator();
        generator.updateProject(project, Paths.get("."));
    }
}
