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

import excelium.model.enums.DataSourceType;
import excelium.model.enums.WriteMode;
import excelium.model.project.DataSource;
import excelium.model.project.Project;
import excelium.model.test.data.Column;
import excelium.model.test.data.TableData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link DynamoDBDatabaseService}.
 *
 * @author PhungDucKien
 * @since 2019.11.29
 */
public class DynamoDBDatabaseServiceTest {

    private static DataSource dynamoDBDataSource;

    @BeforeClass
    public static void initDataSource() {
        dynamoDBDataSource = new DataSource();
        dynamoDBDataSource.setType(DataSourceType.DYNAMODB);
    }

    @Test
    public void testTestConnection() {
        DatabaseService databaseService = DatabaseServiceFactory.createService(dynamoDBDataSource);
        Assert.assertTrue(databaseService.testConnection());
    }

    @Test
    public void testCount() throws Exception {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", dynamoDBDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = DatabaseServiceFactory.createService(project);
        initDB(databaseService);

        Assert.assertEquals(2, databaseService.count("FROM users"));
        Assert.assertEquals(2, databaseService.count("SELECT * FROM users"));

        Assert.assertEquals(1, databaseService.count("FROM users WHERE #name=:name", "name: user"));
        Assert.assertEquals(1, databaseService.count("SELECT * FROM users WHERE #name=:name", "name: user"));

        Assert.assertEquals(0, databaseService.count("FROM users WHERE #name=:name", "name: moderator"));
        Assert.assertEquals(0, databaseService.count("SELECT * FROM users WHERE #name=:name", "name: moderator"));
    }

    @Test
    public void testCreateTestDataAppend() throws Exception {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", dynamoDBDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = DatabaseServiceFactory.createService(project);
        initDB(databaseService);

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
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 1\nname: admin\nmail: admin@excelium.com"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 2\nname: user2\nmail: user2@excelium.com"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 3\nname: user3\nmail: user3@excelium.com"));
    }

    @Test
    public void testCreateTestDataReplace() throws Exception {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", dynamoDBDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = DatabaseServiceFactory.createService(project);
        initDB(databaseService);

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
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 1\nname: admin\nmail: admin@excelium.com"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 2\nname: user2\nmail: user2@excelium.com"));
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 3\nname: user3\nmail: user3@excelium.com"));
    }

    @Test
    public void testCreateTestDataRemove() throws Exception {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", dynamoDBDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = DatabaseServiceFactory.createService(project);
        initDB(databaseService);

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
        Assert.assertEquals(1, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 1\nname: admin\nmail: admin@excelium.com"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 2\nname: user2\nmail: user2@excelium.com"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 3\nname: user3\nmail: user3@excelium.com"));
    }

    @Test
    public void testCreateTestDataTruncate() throws Exception {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", dynamoDBDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = DatabaseServiceFactory.createService(project);
        initDB(databaseService);

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
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 1\nname: admin\nmail: admin@excelium.com"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 2\nname: user2\nmail: user2@excelium.com"));
        Assert.assertEquals(0, databaseService.count("FROM users WHERE id=:id AND #name=:name AND mail=:mail", "id: 3\nname: user3\nmail: user3@excelium.com"));
    }

    private void initDB(DatabaseService databaseService) throws Exception {
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
        rowData.put("id", 1);
        rowData.put("name", "admin");
        rowData.put("mail", "admin@excelium.com");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user");
        rowData.put("mail", "user@excelium.com");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);
    }

    @Test
    public void testDataTypes() throws Exception {
        Project project = new Project();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("default", dynamoDBDataSource);
        project.setDefaultDataSource("default");
        project.setDataSources(dataSourceMap);

        DatabaseService databaseService = DatabaseServiceFactory.createService(project);

        List<TableData> tableDataList = new ArrayList<>();
        List<String> primaryKeys = new ArrayList<>();
        primaryKeys.add("id");
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("id");
        column.setType("Number");
        columns.add(column);
        column = new Column();
        column.setName("name");
        column.setType("String");
        columns.add(column);
        column = new Column();
        column.setName("avatar");
        column.setType("Binary");
        columns.add(column);
        column = new Column();
        column.setName("nicknames");
        column.setType("StringSet");
        columns.add(column);
        column = new Column();
        column.setName("grades");
        column.setType("NumberSet");
        columns.add(column);
        column = new Column();
        column.setName("sports");
        column.setType("List");
        columns.add(column);
        column = new Column();
        column.setName("attributes");
        column.setType("Map");
        columns.add(column);
        column = new Column();
        column.setName("enabled");
        column.setType("Boolean");
        columns.add(column);
        column = new Column();
        column.setName("blank");
        column.setType("Null");
        columns.add(column);
        TableData tableData = new TableData();
        tableData.setMode(WriteMode.TRUNCATE);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        tableDataList.clear();
        tableData = new TableData();
        tableData.setMode(WriteMode.APPEND);
        tableData.setName("users");
        tableData.setPrimaryKeys(primaryKeys);
        tableData.setColumns(columns);

        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Map<String, Object> rowData = new HashMap<>();
        rowData.put("id", 2);
        rowData.put("name", "user2");
        rowData.put("avatar", "YXZhdGFy");
        rowData.put("nicknames", "{ \"a\", \"b\" }");
        rowData.put("grades", "{ 1, 2, 3, 4 }");
        rowData.put("sports", "[ { \"S\" : \"s\" }, { \"N\" : \"1\" }, { \"SS\" : [ \"a\", \"b\" ] }, { \"NS\" : [ \"1\", \"2\" ] }]");
        rowData.put("attributes", "{  \"a\" : { \"SS\" : [      \"a\",      \"b\"    ]  },  \"age\" : { \"N\" : \"30\" },  \"color\" : { \"S\" : \"black\" },  \"sub\" : { \"M\" : {      \"a\" : { \"S\" : \"a\" }    }  }}");
        rowData.put("enabled", "true");
        rowData.put("blank", "");
        rowDataList.add(rowData);
        rowData = new HashMap<>();
        rowData.put("id", 3);
        rowData.put("name", "user3");
        rowData.put("avatar", "YXZhdGFy");
        rowData.put("nicknames", "{ \"a\", \"b\" }");
        rowData.put("grades", "{ 1, 2, 3, 4 }");
        rowData.put("sports", "[ { \"S\" : \"s\" }, { \"N\" : \"1\" }, { \"SS\" : [ \"a\", \"b\" ] }, { \"NS\" : [ \"1\", \"2\" ] }]");
        rowData.put("attributes", "{  \"a\" : { \"SS\" : [      \"a\",      \"b\"    ]  },  \"age\" : { \"N\" : \"30\" },  \"color\" : { \"S\" : \"black\" },  \"sub\" : { \"M\" : {      \"a\" : { \"S\" : \"a\" }    }  }}");
        rowData.put("enabled", "true");
        rowData.put("blank", "");
        rowDataList.add(rowData);
        tableData.setRowData(rowDataList);

        tableDataList.add(tableData);
        databaseService.createTestData(tableDataList);

        Assert.assertEquals(2, databaseService.count("FROM users"));
    }
}
