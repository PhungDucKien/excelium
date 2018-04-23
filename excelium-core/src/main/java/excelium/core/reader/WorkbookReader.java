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

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Workbook reader interface.
 * Provides helper methods for inquiring and searching cell values.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.23
 */
public interface WorkbookReader<W, S> {

    /**
     * Gets workbook object.
     *
     * @return the workbook
     * @throws IOException the io exception
     */
    W getWorkbook() throws IOException;

    /**
     * Gets workbook name.
     *
     * @return the workbook name
     * @throws IOException the io exception
     */
    String getWorkbookName() throws IOException;

    /**
     * Gets list of sheets.
     *
     * @return List of sheets
     * @throws IOException the io exception
     */
    List<S> listSheets() throws IOException;

    /**
     * Gets sheet name.
     *
     * @param sheet Sheet object
     * @return sheet name
     */
    String getSheetName(S sheet);

    /**
     * Finds the first cell with the given value in the workbook/spreadsheet
     * and returns the cell location.
     * The location of the cell contains the sheet name and A1 notation.
     *
     * @param value the value to find
     * @return Cell location
     * @throws IOException the io exception
     */
    String findFirstOccurrence(Object value) throws IOException;

    /**
     * Finds the first cells with the given values in the workbook/spreadsheet
     * and returns the map that maps a value to the found cell location.
     * The location of the cell contains the sheet name and A1 notation.
     *
     * @param values the values to find
     * @return Cell location map
     * @throws IOException the io exception
     */
    Map<Object, String> batchFindFirstOccurrence(List<Object> values) throws IOException;

    /**
     * Finds the first cell with the given value in the given sheet
     * and returns the cell location.
     * The location of the cell contains the sheet name and A1 notation.
     *
     * @param value the value to find
     * @param sheet the sheet
     * @return Cell location
     * @throws IOException the io exception
     */
    String findFirstOccurrence(Object value, S sheet) throws IOException;

    /**
     * Finds the first cells with the given values in the given sheet
     * and returns the map that maps a value to the found cell location.
     * The location of the cell contains the sheet name and A1 notation.
     *
     * @param values the values to find
     * @param sheet  the sheet
     * @return Cell location map
     * @throws IOException if the IOException occurs
     */
    Map<Object, String> batchFindFirstOccurrence(List<Object> values, S sheet) throws IOException;

    /**
     * Gets cell value of a single cell
     *
     * @param cell Cell location
     * @return cell value
     * @throws IOException the io exception
     */
    Object getCellValue(String cell) throws IOException;

    /**
     * Gets list of cell values of a single row
     *
     * @param row Row location
     * @return cell values of row
     * @throws IOException the io exception
     */
    List<Object> getRowCellValues(String row) throws IOException;

    /**
     * Gets list of cell values of a single column
     *
     * @param column Column location
     * @return cell values of column
     * @throws IOException the io exception
     */
    List<Object> getColumnCellValues(String column) throws IOException;

    /**
     * Gets 2-dimension list of cell values of a single range
     *
     * @param range Range location
     * @return cell values of range
     * @throws IOException the io exception
     */
    List<List<Object>> getRangeCellValues(String range) throws IOException;

    /**
     * Gets a map of cell values of multiple cells
     *
     * @param cells Cell location array
     * @return Map of cell values. The key of the return map is cell location.
     * @throws IOException the io exception
     */
    Map<String, Object> batchGetCellValues(String... cells) throws IOException;

    /**
     * Gets a map of list of cell values of multiple rows
     *
     * @param rows Row location array
     * @return Map of row cell values. The key of the return map is row location.
     * @throws IOException the io exception
     */
    Map<String, List<Object>> batchGetRowCellValues(String... rows) throws IOException;

    /**
     * Gets a map of list of cell values of multiple columns
     *
     * @param columns Column location array
     * @return Map of column cell values. The key of the return map is column location.
     * @throws IOException the io exception
     */
    Map<String, List<Object>> batchGetColumnCellValues(String... columns) throws IOException;

    /**
     * Gets a map of 2-dimension list of cell values of multiple ranges
     *
     * @param ranges Range location array
     * @return Map of range cell values. The key of the return map is range location.
     * @throws IOException the io exception
     */
    Map<String, List<List<Object>>> batchGetRangeCellValues(String... ranges) throws IOException;
}
