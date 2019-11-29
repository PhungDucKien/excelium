/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.core.database;

import excelium.model.project.DataSource;
import excelium.model.project.Project;
import org.apache.commons.lang3.StringUtils;

public class DatabaseServiceFactory {

    public static DatabaseService createService(Project project) {
        return createService(getDataSource(project));
    }

    public static DatabaseService createService(Project project, String dataSourceName) {
        return createService(getDataSource(project, dataSourceName));
    }

    public static DatabaseService createService(DataSource dataSource) {
        if (dataSource != null) {
            switch (dataSource.getType()) {
                case MYSQL:
                case POSTGRESQL:
                    return new SQLDatabaseService(dataSource);
                case DYNAMODB:
                    return null;
            }
        }
        return null;
    }

    /**
     * Gets the default data source of the project.
     *
     * @param project the project
     * @return the default data source
     */
    private static DataSource getDataSource(Project project) {
        return getDataSource(project, null);
    }

    /**
     * Gets the data source of the project by name.
     *
     * @param project        the project
     * @param dataSourceName the data source name
     * @return the data source
     */
    private static DataSource getDataSource(Project project, String dataSourceName) {
        if (project == null || project.getDataSources() == null) {
            return null;
        }
        if (StringUtils.isBlank(dataSourceName)) {
            dataSourceName = project.getDefaultDataSource();
        }
        return project.getDataSources().get(dataSourceName);
    }
}
