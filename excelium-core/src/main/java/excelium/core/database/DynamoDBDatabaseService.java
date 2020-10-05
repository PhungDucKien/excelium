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

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import excelium.model.project.DataSource;
import excelium.model.test.data.Column;
import excelium.model.test.data.TableData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Amazon DynamoDB Database service.
 *
 * @author PhungDucKien
 * @since 2019.11.29
 */
public class DynamoDBDatabaseService implements DatabaseService {

    private static final Logger LOG = LogManager.getLogger();

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Data source
     */
    private final DataSource dataSource;

    private final Map<String, String> reservedAttributeNames;

    /**
     * Instantiates a new DynamoDB Database service.
     *
     * @param dataSource the data source
     */
    DynamoDBDatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.reservedAttributeNames = new HashMap<>();
        initReservedAttributeNames();
    }

    /**
     * Test connection boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean testConnection() {
        try {
            DynamoDB connection = getConnection();
            connection.listTables();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Create test data.
     *
     * @param tableDataList the table data list
     * @throws Exception the exception
     */
    @Override
    public void createTestData(List<TableData> tableDataList) throws Exception {
        if (tableDataList == null || tableDataList.size() == 0) {
            return;
        }

        DynamoDB connection = getConnection();
        for (TableData tableData : tableDataList) {
            String tableName = tableData.getName();

            switch (tableData.getMode()) {
                case APPEND:
                    appendRecords(connection, tableName, tableData.getColumns(), tableData.getRowData());
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

    @Override
    public int count(String query) throws Exception {
        Pattern pattern = Pattern.compile("FROM\\s+((?:(?!\\s).)+)(?:\\s+WHERE\\s+(.+))?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = pattern.matcher(query);
        if (m.find()) {
            String tableName = m.group(1);
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName);

            if (m.groupCount() == 2) {
                String expression = m.group(2);
                scanRequest.setFilterExpression(expression);
            }

            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
            return client.scan(scanRequest).getCount();
        }
        throw new Exception("The filter expression syntax is invalid.");
    }

    @Override
    public int count(String query, String values) throws Exception {
        Pattern pattern = Pattern.compile("FROM\\s+((?:(?!\\s).)+)(?:\\s+WHERE\\s+(.+))?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = pattern.matcher(query);
        if (m.find()) {
            String tableName = m.group(1);
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName);

            if (m.groupCount() == 2) {
                String expression = m.group(2);
                scanRequest.setFilterExpression(expression);

                Map<String, AttributeValue> attributeValues = new HashMap<>();
                Yaml yaml = new Yaml();
                Map<String, Object> obj = yaml.load(values);
                for (String key : obj.keySet()) {
                    Object value = obj.get(key);

                    String attributeKey = key.startsWith(":") ? key : ":" + key;
                    if (value == null) {
                        attributeValues.put(attributeKey, new AttributeValue().withNULL(true));
                    } else if (value instanceof String) {
                        attributeValues.put(attributeKey, new AttributeValue().withS(value.toString()));
                    } else if (value instanceof Integer || value instanceof Long || value instanceof Double || value instanceof Float) {
                        attributeValues.put(attributeKey, new AttributeValue().withN(value.toString()));
                    } else if (value instanceof Boolean) {
                        attributeValues.put(attributeKey, new AttributeValue().withBOOL((Boolean) value));
                    }
                }
                scanRequest.setExpressionAttributeValues(attributeValues);

                Map<String, String> attributeNames = new HashMap<>();
                for (String name : reservedAttributeNames.keySet()) {
                    if (StringUtils.containsIgnoreCase(expression, name)) {
                        attributeNames.put(name, reservedAttributeNames.get(name));
                    }
                }
                scanRequest.setExpressionAttributeNames(attributeNames);
            }

            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
            return client.scan(scanRequest).getCount();
        }
        throw new Exception("The filter expression syntax is invalid.");
    }

    private DynamoDB getConnection() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        return new DynamoDB(client);
    }

    /**
     * Appends records to a table.
     * Inserts records that do not exist in the table, and updates records that exist in the table.
     * This is the default behaviour of test data writing.
     *
     * @param connection the connection
     * @param tableName  the table name
     * @param columns    the columns
     * @param rowsData   the rows data
     */
    private void appendRecords(DynamoDB connection, String tableName, List<Column> columns, List<Map<String, Object>> rowsData) throws IOException {
        if (CollectionUtils.isNotEmpty(rowsData)) {
            Map<String, Column> columnMap = new HashMap<>();
            for (Column column : columns) {
                columnMap.put(column.getName(), column);
            }

            List<Item> items = new ArrayList<>();

            for (Map<String, Object> rowData : rowsData) {
                Item item = new Item();

                for (String dataKey : rowData.keySet()) {
                    Column column = columnMap.get(dataKey);
                    String dataType = column.getType();
                    if (StringUtils.equalsAnyIgnoreCase(dataType, "String", "varchar")) {
                        String value = rowData.get(dataKey).toString();
                        item.with(dataKey, value);
                    } else if (StringUtils.equalsIgnoreCase(dataType, "Binary")) {
                        ByteBuffer value = convertBase64ToByteBuffer(rowData.get(dataKey).toString());
                        item.with(dataKey, value);
                    } else if (StringUtils.equalsIgnoreCase(dataType, "Number")) {
                        Object value = rowData.get(dataKey);
                        if (value instanceof String) {
                            if (((String) value).contains(".")) {
                                item.with(dataKey, Double.parseDouble((String) value));
                            } else {
                                item.with(dataKey, Integer.parseInt((String) value));
                            }
                        } else {
                            item.with(dataKey, value);
                        }
                    } else if (StringUtils.equalsIgnoreCase(dataType, "Boolean")) {
                        Object value = rowData.get(dataKey);
                        if (value instanceof Boolean) {
                            item.with(dataKey, value);
                        } else {
                            item.with(dataKey, Boolean.parseBoolean(value.toString()));
                        }
                    } else if (StringUtils.equalsIgnoreCase(dataType, "Null")) {
                        item.withNull(dataKey);
                    } else if (StringUtils.equalsIgnoreCase(dataType, "StringSet")) {
                        String stringRep = rowData.get(dataKey).toString().trim();
                        String json = "[" + stringRep.substring(1, stringRep.length() - 2) + "]";
                        item.withJSON(dataKey, json);
                        Set value = new HashSet<>(Arrays.asList(gson.fromJson(json, String[].class)));
                        item.with(dataKey, value);
                    } else if (StringUtils.equalsIgnoreCase(dataType, "NumberSet")) {
                        String stringRep = rowData.get(dataKey).toString().trim();
                        String json = "[" + stringRep.substring(1, stringRep.length() - 2) + "]";
                        Set value = new HashSet<>(Arrays.asList(gson.fromJson(json, Double[].class)));
                        item.with(dataKey, value);
                    } else if (StringUtils.equalsAnyIgnoreCase(dataType, "Map", "List")) {
                        String json = rowData.get(dataKey).toString();
                        item.withJSON(dataKey, json);
                    } else {
                        item.with(dataKey, rowData.get(dataKey));
                    }
                }

                items.add(item);
            }

            TableWriteItems tableWriteItems = new TableWriteItems(tableName)
                    .withItemsToPut(items);

            connection.batchWriteItem(tableWriteItems);
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
     * @throws InterruptedException the interrupted exception
     */
    private void replaceRecords(DynamoDB connection, String tableName, List<Column> columns, List<Map<String, Object>> rowsData) throws InterruptedException, IOException {
        truncateTable(connection, tableName);

        if (CollectionUtils.isNotEmpty(rowsData)) {
            appendRecords(connection, tableName, columns, rowsData);
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
     */
    private void deleteRecords(DynamoDB connection, String tableName, List<String> primaryKeys, List<Map<String, Object>> rowsData) {
        if (CollectionUtils.isNotEmpty(rowsData)) {
            TableWriteItems tableWriteItems = new TableWriteItems(tableName);

            for (Map<String, Object> rowData : rowsData) {
                PrimaryKey primaryKey = new PrimaryKey();

                for (String key : primaryKeys) {
                    primaryKey.addComponent(key, rowData.get(key));
                }

                tableWriteItems.addPrimaryKeyToDelete(primaryKey);
            }

            connection.batchWriteItem(tableWriteItems);
        }
    }

    /**
     * Truncates the table.
     *
     * @param connection the connection
     * @param tableName  the table name
     * @throws InterruptedException the interrupted exception
     */
    private void truncateTable(DynamoDB connection, String tableName) throws InterruptedException {
        Table table = connection.getTable(tableName);
        TableDescription description = table.describe();

        ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput()
                .withReadCapacityUnits(description.getProvisionedThroughput().getReadCapacityUnits())
                .withWriteCapacityUnits(description.getProvisionedThroughput().getWriteCapacityUnits());

        CreateTableRequest request = new CreateTableRequest()
                .withTableName(tableName)
                .withKeySchema(description.getKeySchema())
                .withAttributeDefinitions(description.getAttributeDefinitions())
                .withProvisionedThroughput(provisionedThroughput);

        table.delete();
        table.waitForDelete();

        connection.createTable(request);
        connection.getTable(tableName).waitForActive();
    }

    private void initReservedAttributeNames() {
        reservedAttributeNames.clear();

        try {
            List<String> reservedWords = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("dynamodb_reserved_words.txt"), Charset.defaultCharset());
            for (String word : reservedWords) {
                reservedAttributeNames.put("#" + word.toLowerCase(), word.toLowerCase());
            }
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    private static ByteBuffer convertBase64ToByteBuffer(String base64String) throws IOException {
        byte[] bytes = Base64.getDecoder().decode(base64String.getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes, 0, bytes.length);
        buffer.position(0);
        return buffer;
    }
}
