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

package excelium.core.database;

import excelium.model.enums.DataSourceType;
import excelium.model.enums.WriteMode;
import excelium.model.project.DataSource;
import excelium.model.project.Project;
import excelium.model.test.data.Column;
import excelium.model.test.data.TableData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link DatabaseService}.
 *
 * @author PhungDucKien
 * @since 2018.05.26
 */
public class DatabaseServiceTest {

    private static DataSource mysqlDataSource;
    private static DataSource postgresDataSource;

    @BeforeClass
    public static void initDataSource() {
        mysqlDataSource = new DataSource();
        mysqlDataSource.setType(DataSourceType.MYSQL);
        mysqlDataSource.setDriverClass(DataSourceType.MYSQL.getDriverClass());
        mysqlDataSource.setUrl(DataSourceType.MYSQL.getUrl("localhost", "3306", "exceliumdb"));
        mysqlDataSource.setUserName("root");
        mysqlDataSource.setPassword("123456");

        postgresDataSource = new DataSource();
        postgresDataSource.setType(DataSourceType.POSTGRESQL);
        postgresDataSource.setDriverClass(DataSourceType.POSTGRESQL.getDriverClass());
        postgresDataSource.setUrl(DataSourceType.POSTGRESQL.getUrl("localhost", "5432", "exceliumdb"));
        postgresDataSource.setUserName("postgres");
        postgresDataSource.setPassword("123456");
    }

    @Test
    public void testTestConnection() {
        DatabaseService databaseService = new DatabaseService(null);
        Assert.assertTrue(databaseService.testConnection(mysqlDataSource));

        DataSource falseDataSource = new DataSource();
        falseDataSource.setType(DataSourceType.MYSQL);
        falseDataSource.setDriverClass(DataSourceType.MYSQL.getDriverClass());
        falseDataSource.setUrl(DataSourceType.MYSQL.getUrl("localhost", "3306", "exceliumdb"));
        falseDataSource.setUserName("root");
        falseDataSource.setPassword("1234567");
        Assert.assertFalse(databaseService.testConnection(falseDataSource));
    }

    @Test
    public void testExecuteSql() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", mysqlDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));
    }

    @Test
    public void testCount() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", mysqlDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));

        Assert.assertEquals(2, databaseService.count("FROM users"));
        Assert.assertEquals(2, databaseService.count("SELECT * FROM users"));
        Assert.assertEquals(1, databaseService.count("SELECT count(*) FROM users"));

        Assert.assertEquals(1, databaseService.count("FROM users WHERE name='user'"));
        Assert.assertEquals(1, databaseService.count("SELECT * FROM users WHERE name='user'"));
        Assert.assertEquals(1, databaseService.count("SELECT count(*) FROM users WHERE name='user'"));

        Assert.assertEquals(0, databaseService.count("FROM users WHERE name='moderator'"));
        Assert.assertEquals(0, databaseService.count("SELECT * FROM users WHERE name='moderator'"));
        Assert.assertEquals(1, databaseService.count("SELECT count(*) FROM users WHERE name='moderator'"));
    }

    @Test
    public void testCreateTestDataAppendMySQL() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", mysqlDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));

        List<TableData> tableDataList = new ArrayList<>();
        List<String> primaryKeys = new ArrayList<>();
        primaryKeys.add("id");
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("id");
        columns.add(column);
        column = new Column();
        column.setName("name");
        columns.add(column);
        column = new Column();
        column.setName("mail");
        columns.add(column);
        TableData tableData = new TableData();
        tableData.setMode(WriteMode.APPEND);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Map<String, Object> rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user2");
        rowData.put("mail", "user2@excelium.com");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 3);
        rowData.put("name", "user3");
        rowData.put("mail", "user3@excelium.com");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        Assert.assertEquals(3, databaseService.count("FROM users"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 1 AND name = 'admin' AND mail = 'admin@excelium.com'"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 2 AND name = 'user2' AND mail = 'user2@excelium.com'"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 3 AND name = 'user3' AND mail = 'user3@excelium.com'"));
    }

    @Test
    public void testCreateTestDataAppendPostgreSQL() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", postgresDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));

        List<TableData> tableDataList = new ArrayList<>();
        List<String> primaryKeys = new ArrayList<>();
        primaryKeys.add("id");
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("id");
        columns.add(column);
        column = new Column();
        column.setName("name");
        columns.add(column);
        column = new Column();
        column.setName("mail");
        columns.add(column);
        TableData tableData = new TableData();
        tableData.setMode(WriteMode.APPEND);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Map<String, Object> rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user2");
        rowData.put("mail", "user2@excelium.com");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 3);
        rowData.put("name", "user3");
        rowData.put("mail", "user3@excelium.com");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        Assert.assertEquals(3, databaseService.count("FROM users"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 1 AND name = 'admin' AND mail = 'admin@excelium.com'"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 2 AND name = 'user2' AND mail = 'user2@excelium.com'"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 3 AND name = 'user3' AND mail = 'user3@excelium.com'"));
    }

    @Test
    public void testCreateTestDataReplace() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", mysqlDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));

        List<TableData> tableDataList = new ArrayList<>();
        List<String> primaryKeys = new ArrayList<>();
        primaryKeys.add("id");
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("id");
        columns.add(column);
        column = new Column();
        column.setName("name");
        columns.add(column);
        column = new Column();
        column.setName("mail");
        columns.add(column);
        TableData tableData = new TableData();
        tableData.setMode(WriteMode.REPLACE);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Map<String, Object> rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user2");
        rowData.put("mail", "user2@excelium.com");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 3);
        rowData.put("name", "user3");
        rowData.put("mail", "user3@excelium.com");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        Assert.assertEquals(2, databaseService.count("FROM users"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id = 1 AND name = 'admin' AND mail = 'admin@excelium.com'"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 2 AND name = 'user2' AND mail = 'user2@excelium.com'"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 3 AND name = 'user3' AND mail = 'user3@excelium.com'"));
    }

    @Test
    public void testCreateTestDataRemove() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", mysqlDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));

        List<TableData> tableDataList = new ArrayList<>();
        List<String> primaryKeys = new ArrayList<>();
        primaryKeys.add("id");
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("id");
        columns.add(column);
        column = new Column();
        column.setName("name");
        columns.add(column);
        column = new Column();
        column.setName("mail");
        columns.add(column);
        TableData tableData = new TableData();
        tableData.setMode(WriteMode.REMOVE);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Map<String, Object> rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user2");
        rowData.put("mail", "user2@excelium.com");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 3);
        rowData.put("name", "user3");
        rowData.put("mail", "user3@excelium.com");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        Assert.assertEquals(1, databaseService.count("FROM users"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id = 1 AND name = 'admin' AND mail = 'admin@excelium.com'"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id = 2 AND name = 'user2' AND mail = 'user2@excelium.com'"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id = 3 AND name = 'user3' AND mail = 'user3@excelium.com'"));
    }

    @Test
    public void testCreateTestDataTruncate() throws SQLException, IOException, ClassNotFoundException {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", mysqlDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = new DatabaseService(project);
        databaseService.executeSql(Paths.get(getClass().getClassLoader().getResource("db-init.sql").getPath()));

        List<TableData> tableDataList = new ArrayList<>();
        List<String> primaryKeys = new ArrayList<>();
        primaryKeys.add("id");
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("id");
        columns.add(column);
        column = new Column();
        column.setName("name");
        columns.add(column);
        column = new Column();
        column.setName("mail");
        columns.add(column);
        TableData tableData = new TableData();
        tableData.setMode(WriteMode.TRUNCATE);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Map<String, Object> rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user2");
        rowData.put("mail", "user2@excelium.com");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 3);
        rowData.put("name", "user3");
        rowData.put("mail", "user3@excelium.com");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        Assert.assertEquals(0, databaseService.count("FROM users"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id = 1 AND name = 'admin' AND mail = 'admin@excelium.com'"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id = 2 AND name = 'user2' AND mail = 'user2@excelium.com'"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id = 3 AND name = 'user3' AND mail = 'user3@excelium.com'"));
    }
}
