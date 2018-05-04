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

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Workbook writer interface.
 * Provides helper methods for writing cell values.
 *
 * @author PhungDucKien
 * @since 2018.04.28
 */
public interface WorkbookWriter extends Closeable {

    /**
     * Writes cell value to a single cell
     *
     * @param value cell value
     * @param cell  Cell location
     * @throws IOException the io exception
     */
    void setCellValue(Object value, String cell) throws IOException;

    /**
     * Writes list of cell values to a single row
     *
     * @param values cell values of row
     * @param row    Row location
     * @throws IOException the io exception
     */
    void setRowCellValues(List<Object> values, String row) throws IOException;

    /**
     * Writes list of cell values to a single column
     *
     * @param values cell values of column
     * @param column Column location
     * @throws IOException the io exception
     */
    void setColumnCellValues(List<Object> values, String column) throws IOException;

    /**
     * Writes 2-dimension list of cell values to a single range
     *
     * @param values cell values of range
     * @param range  Range location
     * @throws IOException the io exception
     */
    void setRangeCellValues(List<List<Object>> values, String range) throws IOException;

    /**
     * Writes a map of cell values to multiple cells
     *
     * @param values Map of cell values. The key of the map is cell location.
     * @param cells  Cell location array
     * @throws IOException the io exception
     */
    void batchSetCellValues(Map<String, Object> values, String... cells) throws IOException;

    /**
     * Writes a map of list of cell values to multiple rows
     *
     * @param values Map of row cell values. The key of the map is row location.
     * @param rows   Row location array
     * @throws IOException the io exception
     */
    void batchSetRowCellValues(Map<String, List<Object>> values, String... rows) throws IOException;

    /**
     * Writes a map of list of cell values to multiple columns
     *
     * @param values  Map of column cell values. The key of the map is column location.
     * @param columns Column location array
     * @throws IOException the io exception
     */
    void batchSetColumnCellValues(Map<String, List<Object>> values, String... columns) throws IOException;

    /**
     * Writes a map of 2-dimension list of cell values to multiple ranges
     *
     * @param values Map of range cell values. The key of the map is range location.
     * @param ranges Range location array
     * @throws IOException the io exception
     */
    void batchSetRangeCellValues(Map<String, List<List<Object>>> values, String... ranges) throws IOException;

    /**
     * Flush all changes.
     *
     * @throws IOException the io exception
     */
    void flush() throws IOException;
}
