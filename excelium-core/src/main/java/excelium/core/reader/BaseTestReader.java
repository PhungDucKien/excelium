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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base test reader.
 * This class contains helper methods for inquiring cell values. It also implements {@link #getMarkupLocationMap(List)} method.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.17
 */
public abstract class BaseTestReader<W, S> extends TestReader<W> {

    @Override
    public Map<Object, String> getMarkupLocationMap(List markups) throws IOException {
        List<S> sheets = listSheets();

        Map<Object, String> locationMap = new HashMap<>();
        for (S sheet : sheets) {
            String[] sheetCellLocations = getMarkupLocations(markups, sheet);

            for (int i = 0; i < markups.size(); i++) {
                if (!locationMap.containsKey(markups.get(i)) && sheetCellLocations[i] != null) {
                    locationMap.put(markups.get(i), sheetCellLocations[i]);
                }
            }
        }
        return locationMap;
    }

    /**
     * Get sheet name.
     *
     * @param sheet Sheet object
     * @return sheet name
     */
    public abstract String getSheetName(S sheet);

    /**
     * Returns list of sheets.
     *
     * @return List of sheets
     * @throws IOException the io exception
     */
    public abstract List<S> listSheets() throws IOException;

    /**
     * Get a map of values of multiple cells
     *
     * @param cells Cell array
     * @return Map of cell object values. The key of the return map is cell definition.
     * @throws IOException the io exception
     */
    public Map<String, Object> getBatchCellValues(String... cells) throws IOException {
        Map<String, List<List<Object>>> batchRangeCellValues = getBatchRangeCellValues(cells);
        Map<String, Object> values = new HashMap<>();
        for (String cell : batchRangeCellValues.keySet()) {
            List<List<Object>> rangeValue = batchRangeCellValues.get(cell);
            if (rangeValue != null && rangeValue.get(0) != null && rangeValue.get(0).get(0) != null) {
                RangeLocation rangeLocation = new RangeLocation(cell);
                values.put(rangeLocation.formatAsString(), rangeValue.get(0).get(0));
            }
        }
        return values;
    }

    /**
     * Get a map of 2-dimension list of values of multiple cell ranges
     *
     * @param ranges Range array
     * @return Map of range object values. The key of the return map is range definition.
     * @throws IOException the io exception
     */
    public abstract Map<String, List<List<Object>>> getBatchRangeCellValues(String... ranges) throws IOException;

    /**
     * Get 2-dimension list of values of a single cell range
     *
     * @param range Cell range
     * @return range object values
     * @throws IOException the io exception
     */
    public abstract List<List<Object>> getRangeCellValues(String range) throws IOException;

    /**
     * Searches the given sheet of the workbook/spreadsheet to find the locations of the first cells
     * that have values match the given markups.
     * This method return the array of the locations of the found cells.
     * The location of the cell contains the sheet name and A1 notation.
     *
     * @param markups The markups to search
     * @param sheet   Sheet
     * @return Markup locations
     * @throws IOException if the IOException occurs
     */
    public abstract String[] getMarkupLocations(List<Object> markups, S sheet) throws IOException;
}
