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

package excelium.model.test.data;

import excelium.model.enums.WriteMode;

import java.util.List;
import java.util.Map;

/**
 * Represents table data model.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class TableData {

    /**
     * Table name
     */
    private String name;

    /**
     * Write mode
     */
    private WriteMode mode;

    /**
     * List of primary keys
     */
    private List<String> primaryKeys;

    /**
     * List of columns
     */
    private List<Column> columns;

    /**
     * Row data
     */
    private List<Map<String, Object>> rowData;

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
     * Gets mode.
     *
     * @return the mode
     */
    public WriteMode getMode() {
        return mode;
    }

    /**
     * Sets mode.
     *
     * @param mode the mode
     */
    public void setMode(WriteMode mode) {
        this.mode = mode;
    }

    /**
     * Gets primary keys.
     *
     * @return the primary keys
     */
    public List<String> getPrimaryKeys() {
        return primaryKeys;
    }

    /**
     * Sets primary keys.
     *
     * @param primaryKeys the primary keys
     */
    public void setPrimaryKeys(List<String> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    /**
     * Gets columns.
     *
     * @return the columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Sets columns.
     *
     * @param columns the columns
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    /**
     * Gets row data.
     *
     * @return the row data
     */
    public List<Map<String, Object>> getRowData() {
        return rowData;
    }

    /**
     * Sets row data.
     *
     * @param rowData the row data
     */
    public void setRowData(List<Map<String, Object>> rowData) {
        this.rowData = rowData;
    }
}
