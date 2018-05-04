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

package excelium.core.writer;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract workbook writer.
 * This class implements some helper methods for writing cell values.
 *
 * @author PhungDucKien
 * @since 2018.04.29
 */
public abstract class AbstractWorkbookWriter implements WorkbookWriter {

    /**
     * Flush values
     */
    protected Map<String, List<List<Object>>> flushValues = new HashMap<>();

    @Override
    public void setCellValue(Object value, String cell) throws IOException {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put(cell, value);
        batchSetCellValues(valueMap, cell);
    }

    @Override
    public void setRowCellValues(List<Object> values, String row) throws IOException {
        Map<String, List<Object>> valueMap = new HashMap<>();
        valueMap.put(row, values);
        batchSetRowCellValues(valueMap, row);
    }

    @Override
    public void setColumnCellValues(List<Object> values, String column) throws IOException {
        Map<String, List<Object>> valueMap = new HashMap<>();
        valueMap.put(column, values);
        batchSetColumnCellValues(valueMap, column);
    }

    @Override
    public void setRangeCellValues(List<List<Object>> values, String range) throws IOException {
        Map<String, List<List<Object>>> valueMap = new HashMap<>();
        valueMap.put(range, values);
        batchSetRangeCellValues(valueMap, range);
    }

    @Override
    public void batchSetCellValues(Map<String, Object> values, String... cells) throws IOException {
        Map<String, List<List<Object>>> valueMap = new HashMap<>();
        for (String cell : cells) {
            List<List<Object>> rangeValues = new ArrayList<>();
            List<Object> rowValues = new ArrayList<>();
            rowValues.add(values.get(cell));
            rangeValues.add(rowValues);
            valueMap.put(cell, rangeValues);
        }
        batchSetRangeCellValues(valueMap, cells);
    }

    @Override
    public void batchSetRowCellValues(Map<String, List<Object>> values, String... rows) throws IOException {
        Map<String, List<List<Object>>> valueMap = new HashMap<>();
        for (String row : rows) {
            List<List<Object>> rangeValues = new ArrayList<>();
            rangeValues.add(values.get(row));
            valueMap.put(row, rangeValues);
        }
        batchSetRangeCellValues(valueMap, rows);
    }

    @Override
    public void batchSetColumnCellValues(Map<String, List<Object>> values, String... columns) throws IOException {
        Map<String, List<List<Object>>> valueMap = new HashMap<>();
        for (String column : columns) {
            List<List<Object>> rangeValues = new ArrayList<>();
            List<Object> columnValues = values.get(column);
            if (CollectionUtils.isNotEmpty(columnValues)) {
                for (Object value : columnValues) {
                    List<Object> rowValues = new ArrayList<>();
                    rowValues.add(value);
                    rangeValues.add(rowValues);
                }
            }
            valueMap.put(column, rangeValues);
        }
        batchSetRangeCellValues(valueMap, columns);
    }

    @Override
    public void batchSetRangeCellValues(Map<String, List<List<Object>>> values, String... ranges) throws IOException {
        for (String range : ranges) {
            if (values.containsKey(range)) {
                flushValues.put(range, values.get(range));
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (flushValues != null && !flushValues.isEmpty()) {
            flush();
        }
    }
}
