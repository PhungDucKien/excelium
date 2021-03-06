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

import com.ibatis.common.jdbc.ScriptRunner;
import excelium.model.project.DataSource;
import excelium.model.test.data.Column;
import excelium.model.test.data.TableData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * SQL Database service.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
public class SQLDatabaseService implements DatabaseService {

    /**
     * Data source
     */
    private final DataSource dataSource;

    /**
     * Instantiates a new SQL Database service.
     *
     * @param dataSource the data source
     */
    SQLDatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Test connection boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean testConnection() {
        try {
            Connection connection = getConnection(dataSource);
            if (connection != null) {
                connection.prepareStatement("SELECT 1").execute();
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * Create test data.
     *
     * @param tableDataList the table data list
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @Override
    public void createTestData(List<TableData> tableDataList) throws SQLException, ClassNotFoundException {
        if (tableDataList == null || tableDataList.size() == 0) {
            return;
        }

        try (Connection connection = getConnection(dataSource)) {
            for (TableData tableData : tableDataList) {
                String tableName = tableData.getName();

                switch (tableData.getMode()) {
                    case APPEND:
                        appendRecords(dataSource, connection, tableName, tableData.getPrimaryKeys(), tableData.getColumns(), tableData.getRowData());
                        break;
                    case REPLACE:
                        replaceRecords(connection, tableName, tableData.getColumns(), tableData.getRowData());
                        break;
                    case REMOVE:
                        deleteRecords(connection, tableName, tableData.getPrimaryKeys(), tableData.getRowData());
                        break;
                    case TRUNCATE:
                        truncateTable(connection, tableName);
                        break;
                }
            }
        }
    }

    /**
     * Executes the given SQL query and return the count.
     *
     * @param sql the SQL query
     * @return the count
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @Override
    public int count(String sql) throws SQLException, ClassNotFoundException {
        boolean countSql;
        if (sql.trim().toUpperCase().startsWith("FROM ")) {
            sql = "SELECT count(*) " + sql;
            countSql = true;
        } else if (sql.trim().toUpperCase().startsWith("SELECT ")) {
            countSql = false;
        } else {
            throw new SQLSyntaxErrorException("Invalid SQL Statement. SQL = " + sql);
        }

        try (Connection connection = getConnection(dataSource);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            if (countSql) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } else {
                if (rs.last()) {
                    return rs.getRow();
                }
            }
            return 0;
        }
    }

    /**
     * Executes the given SQL query and return the count.
     *
     * @param sql    the SQL query
     * @param values the values to bind
     * @return the count
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @Override
    public int count(String sql, String values) throws SQLException, ClassNotFoundException {
        boolean countSql;
        if (sql.trim().toUpperCase().startsWith("FROM ")) {
            sql = "SELECT count(*) " + sql;
            countSql = true;
        } else if (sql.trim().toUpperCase().startsWith("SELECT ")) {
            countSql = false;
        } else {
            throw new SQLSyntaxErrorException("Invalid SQL Statement. SQL = " + sql);
        }

        try (Connection connection = getConnection(dataSource);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            Yaml yaml = new Yaml();
            Map<String, Object> obj = yaml.load(values);
            int i = 1;
            for (String key : obj.keySet()) {
                preparedStatement.setObject(i, obj.get(key));
                i++;
            }

            ResultSet rs = preparedStatement.executeQuery();

            if (countSql) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } else {
                if (rs.last()) {
                    return rs.getRow();
                }
            }
            return 0;
        }
    }

    /**
     * Executes external sql file.
     *
     * @param sqlPath the sql file path
     */
    public void executeSql(Path sqlPath) throws SQLException, ClassNotFoundException, IOException {
        try (Connection connection = getConnection(dataSource);
             Reader reader = new BufferedReader(new FileReader(sqlPath.toFile()))) {
            ScriptRunner sr = new ScriptRunner(connection, false, false);
            sr.runScript(reader);
        }
    }

    /**
     * Attempts to establish a connection to the given data source.
     *
     * @param dataSource the data source
     * @return the connection
     * @throws ClassNotFoundException if the database driver class not found
     * @throws SQLException           if a database access error occurs
     */
    private Connection getConnection(DataSource dataSource) throws ClassNotFoundException, SQLException {
        if (StringUtils.isNotBlank(dataSource.getUrl())) {
            String driverClassName = dataSource.getDriverClass();

            Properties connectionProps = new Properties();
            connectionProps.put("user", dataSource.getUserName());
            connectionProps.put("password", dataSource.getPassword());

            Class.forName(driverClassName);
            return DriverManager.getConnection(dataSource.getUrl(), connectionProps);
        }
        throw new SQLException("Failed to establish a database connection");
    }

    /**
     * Appends records to a table.
     * Inserts records that do not exist in the table, and updates records that exist in the table.
     * Use the given primary keys for record matching.
     * This is the default behaviour of test data writing.
     *
     * @param dataSource  the data source
     * @param connection  the connection
     * @param tableName   the table name
     * @param primaryKeys the primary keys
     * @param columns     the columns
     * @param rowsData    the rows data
     * @throws SQLException the sql exception
     */
    private void appendRecords(DataSource dataSource, Connection connection, String tableName, List<String> primaryKeys, List<Column> columns, List<Map<String, Object>> rowsData) throws SQLException {
        switch (dataSource.getType()) {
            case MYSQL:
                appendMySqlRecords(connection, tableName, columns, rowsData);
                break;
            case POSTGRESQL:
                appendPostgresRecords(connection, tableName, primaryKeys, columns, rowsData);
                break;
        }
    }

    /**
     * Replace the table data with the given test data.
     * Truncates the table and inserts records.
     *
     * @param connection the connection
     * @param tableName  the table name
     * @param columns    the columns
     * @param rowsData   the rows data
     * @throws SQLException the sql exception
     */
    private void replaceRecords(Connection connection, String tableName, List<Column> columns, List<Map<String, Object>> rowsData) throws SQLException {
        truncateTable(connection, tableName);

        if (CollectionUtils.isNotEmpty(rowsData)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(getInsertSql(tableName, columns, rowsData.size()))) {
                bindValues(preparedStatement, columns, rowsData);
                preparedStatement.execute();
            }
        }
    }

    /**
     * Delete records that exist in the table.
     * Use the given primary keys for record matching.
     *
     * @param connection  the connection
     * @param tableName   the table name
     * @param primaryKeys the primary keys
     * @param rowsData    the rows data
     * @throws SQLException the sql exception
     */
    private void deleteRecords(Connection connection, String tableName, List<String> primaryKeys, List<Map<String, Object>> rowsData) throws SQLException {
        if (CollectionUtils.isNotEmpty(rowsData)) {
            List<String> keyConds = new ArrayList<>();
            for (String primaryKey : primaryKeys) {
                keyConds.add(primaryKey + " = ?");
            }
            String rows = StringUtils.repeat("(" + StringUtils.join(keyConds, " AND ") + ")", " OR ", rowsData.size());

            String sql = "DELETE FROM " + tableName + " WHERE " + rows;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                bindValues(preparedStatement, primaryKeys, rowsData);
                preparedStatement.execute();
            }
        }
    }

    /**
     * Truncates the table.
     *
     * @param connection the connection
     * @param tableName  the table name
     * @throws SQLException the sql exception
     */
    private void truncateTable(Connection connection, String tableName) throws SQLException {
        String sql = "TRUNCATE TABLE " + tableName;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        }
    }

    /**
     * Appends records to a MySQL table.
     *
     * @param connection the connection
     * @param tableName  the table name
     * @param columns    the columns
     * @param rowsData   the rows data
     * @throws SQLException the sql exception
     */
    private void appendMySqlRecords(Connection connection, String tableName, List<Column> columns, List<Map<String, Object>> rowsData) throws SQLException {
        if (CollectionUtils.isNotEmpty(rowsData)) {
            List<String> updateColumns = new ArrayList<>();
            for (Column column : columns) {
                updateColumns.add(column + " = VALUES(" + column + ")");
            }

            String sql = getInsertSql(tableName, columns, rowsData.size()) +
                    " ON DUPLICATE KEY UPDATE " +
                    StringUtils.join(updateColumns, ", ");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                bindValues(preparedStatement, columns, rowsData);
                preparedStatement.execute();
            }
        }
    }

    /**
     * Appends records to a PostgreSQL table.
     *
     * @param connection  the connection
     * @param tableName   the table name
     * @param primaryKeys the primary keys
     * @param columns     the columns
     * @param rowsData    the rows data
     * @throws SQLException the sql exception
     */
    private void appendPostgresRecords(Connection connection, String tableName, List<String> primaryKeys, List<Column> columns, List<Map<String, Object>> rowsData) throws SQLException {
        if (CollectionUtils.isNotEmpty(rowsData)) {
            List<String> updateColumns = new ArrayList<>();
            for (Column column : columns) {
                updateColumns.add(column + " = EXCLUDED." + column);
            }

            String sql = getInsertSql(tableName, columns, rowsData.size()) +
                    " ON CONFLICT (" + StringUtils.join(primaryKeys, ", ") + ") " +
                    " DO UPDATE SET " +
                    StringUtils.join(updateColumns, ", ");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                bindValues(preparedStatement, columns, rowsData);
                preparedStatement.execute();
            }
        }
    }

    /**
     * Gets the insert SQL.
     * The SQL is prepared for binding values.
     *
     * @param tableName the table name
     * @param columns   the columns
     * @param dataSize  the data size
     * @return the SQL
     */
    private String getInsertSql(String tableName, List<Column> columns, int dataSize) {
        String row = "(" + StringUtils.repeat("?", ", ", columns.size()) + ")";
        String rows = StringUtils.repeat(row, ", ", dataSize);

        return "INSERT INTO " + tableName + " (" + StringUtils.join(columns, ", ") + ") VALUES " + rows;
    }

    /**
     * Binds values to a PreparedStatement.
     *
     * @param preparedStatement the prepared statement
     * @param columns           the columns
     * @param rowsData          the rows data
     * @throws SQLException the sql exception
     */
    private void bindValues(PreparedStatement preparedStatement, List columns, List<Map<String, Object>> rowsData) throws SQLException {
        int index = 1;
        for (Map<String, Object> rowData : rowsData) {
            for (Object column : columns) {
                Object value = rowData.get(column instanceof Column ? ((Column) column).getName() : column);
                preparedStatement.setObject(index, value);
                index++;
            }
        }
    }
}
