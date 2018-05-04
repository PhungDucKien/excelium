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

package excelium.core.reader;

import excelium.common.ss.RangeLocation;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract workbook reader.
 * This class implements some helper methods for inquiring and searching cell values.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.23
 */
public abstract class AbstractWorkbookReader<W, S> implements WorkbookReader<W, S> {

    /**
     * Workbook object
     */
    protected W workbook;

    @Override
    public String findFirstOccurrence(Object value) throws IOException {
        List<S> sheets = listSheets();
        for (S sheet : sheets) {
            String sheetCellLocation = findFirstOccurrence(value, sheet);
            if (StringUtils.isNotBlank(sheetCellLocation)) {
                return sheetCellLocation;
            }
        }
        return null;
    }

    @Override
    public Map<Object, String> batchFindFirstOccurrence(List<Object> values) throws IOException {
        Map<Object, String> locationMap = new HashMap<>();

        List<S> sheets = listSheets();
        for (S sheet : sheets) {
            Map<Object, String> sheetCellLocations = batchFindFirstOccurrence(values, sheet);

            for (Object value : values) {
                if (!locationMap.containsKey(value) && StringUtils.isNotBlank(sheetCellLocations.get(value))) {
                    locationMap.put(value, sheetCellLocations.get(value));
                }
            }
        }
        return locationMap;
    }

    @Override
    public String findFirstOccurrence(Object value, S sheet) throws IOException {
        List<Object> values = new ArrayList<>();
        values.add(value);

        Map<Object, String> sheetCellLocations = batchFindFirstOccurrence(values, sheet);
        return sheetCellLocations.get(value);
    }

    @Override
    public Object getCellValue(String cell) throws IOException {
        return batchGetCellValues(cell).get(cell);
    }

    @Override
    public List<Object> getRowCellValues(String row) throws IOException {
        return batchGetRowCellValues(row).get(row);
    }

    @Override
    public List<Object> getColumnCellValues(String column) throws IOException {
        return batchGetColumnCellValues(column).get(column);
    }

    @Override
    public List<List<Object>> getRangeCellValues(String range) throws IOException {
        return batchGetRangeCellValues(range).get(range);
    }

    @Override
    public Map<String, Object> batchGetCellValues(String... cells) throws IOException {
        Map<String, List<List<Object>>> batchRangeCellValues = batchGetRangeCellValues(cells);
        Map<String, Object> values = new HashMap<>();
        for (String cell : batchRangeCellValues.keySet()) {
            List<List<Object>> rangeValue = batchRangeCellValues.get(cell);
            RangeLocation rangeLocation = new RangeLocation(cell);
            values.put(rangeLocation.formatAsString(), getFirstValue(rangeValue));
        }
        return values;
    }

    @Override
    public Map<String, List<Object>> batchGetRowCellValues(String... rows) throws IOException {
        Map<String, List<List<Object>>> batchRangeCellValues = batchGetRangeCellValues(rows);
        Map<String, List<Object>> values = new HashMap<>();
        for (String cell : batchRangeCellValues.keySet()) {
            List<List<Object>> rangeValue = batchRangeCellValues.get(cell);
            RangeLocation rangeLocation = new RangeLocation(cell);
            values.put(rangeLocation.formatAsString(), getFirstRowValues(rangeValue));
        }
        return values;
    }

    @Override
    public Map<String, List<Object>> batchGetColumnCellValues(String... columns) throws IOException {
        Map<String, List<List<Object>>> batchRangeCellValues = batchGetRangeCellValues(columns);
        Map<String, List<Object>> values = new HashMap<>();
        for (String cell : batchRangeCellValues.keySet()) {
            List<List<Object>> rangeValue = batchRangeCellValues.get(cell);
            RangeLocation rangeLocation = new RangeLocation(cell);
            values.put(rangeLocation.formatAsString(), getFirstColumnValues(rangeValue));
        }
        return values;
    }

    /**
     * Gets first value of 2-dimension list of objects
     *
     * @param values 2-dimension list of objects
     * @return first value
     */
    private Object getFirstValue(List<List<Object>> values) {
        if (CollectionUtils.isNotEmpty(values) && CollectionUtils.isNotEmpty(values.get(0))) {
            return values.get(0).get(0);
        }
        return null;
    }

    /**
     * Gets first row values of 2-dimension list of objects
     *
     * @param values 2-dimension list of objects
     * @return first row values
     */
    private List<Object> getFirstRowValues(List<List<Object>> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            return values.get(0);
        }
        return new ArrayList<>();
    }

    /**
     * Gets first column values of 2-dimension list of objects
     *
     * @param values 2-dimension list of objects
     * @return first column values
     */
    private List<Object> getFirstColumnValues(List<List<Object>> values) {
        List<Object> columnValues = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(values)) {
            for (List<Object> rowValues : values) {
                if (CollectionUtils.isNotEmpty(rowValues)) {
                    columnValues.add(rowValues.get(0));
                } else {
                    columnValues.add(null);
                }
            }
        }
        return columnValues;
    }

    @Override
    public void close() throws IOException {
        if (workbook instanceof Closeable) {
            ((Closeable) workbook).close();
        }
        workbook = null;
    }
}
