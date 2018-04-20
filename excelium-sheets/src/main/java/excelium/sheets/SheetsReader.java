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

package excelium.sheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import excelium.common.ss.CellLocation;
import excelium.common.ss.DateUtil;
import excelium.common.ss.RangeLocation;
import excelium.core.reader.DefaultTestReader;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;

import static excelium.common.NumberUtil.getIntValue;
import static excelium.common.NumberUtil.getNumericValue;

/**
 * Reads Google Sheet spreadsheets.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class SheetsReader extends DefaultTestReader<Spreadsheet, Sheet> {

    /**
     * Spreadsheet id
     */
    private String spreadsheetId;

    /**
     * Sheets service
     */
    private Sheets sheetsService;

    /**
     * Constructs reader for a specific Sheets spreadsheet.
     *
     * @param sheetsService Sheets service
     * @param spreadsheetId Spreadsheet ID
     */
    SheetsReader(Sheets sheetsService, String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
        this.sheetsService = sheetsService;
    }

    /**
     * Gets spreadsheet.
     *
     * @return the spreadsheet
     * @throws IOException the io exception
     */
    private Spreadsheet getSpreadsheet() throws IOException {
        if (workbook == null) {
            workbook = sheetsService.spreadsheets().get(spreadsheetId)
                    .setFields("properties.title,sheets(properties(title,sheetId))")
                    .setPrettyPrint(false)
                    .execute();
        }
        return workbook;
    }

    /**
     * Gets sheet by specified name.
     *
     * @param spreadsheet Spreadsheet
     * @param sheetName Sheet name
     * @return Sheet
     */
    private Sheet getSheet(Spreadsheet spreadsheet, String sheetName) {
        List<Sheet> sheets = spreadsheet.getSheets();
        for (Sheet sheet : sheets) {
            if (getSheetName(sheet).equals(sheetName)) {
                return sheet;
            }
        }
        return null;
    }

    @Override
    public String getWorkbookName() throws IOException {
        return spreadsheetId + " - " + getSpreadsheet().getProperties().getTitle();
    }

    @Override
    public String getSheetName(Sheet sheet) {
        return sheet.getProperties().getTitle();
    }

    @Override
    public List<Sheet> listSheets() throws IOException {
        return getSpreadsheet().getSheets();
    }

    @Override
    public String[] getMarkupLocations(List<Object> markups, Sheet sheet) throws IOException {

        // The data filters used to match the ranges of values to retrieve.  Ranges
        // that match any of the specified data filters will be included in the
        // response.
        GridRange gridRange = new GridRange();
        gridRange.setSheetId(sheet.getProperties().getSheetId());

        DataFilter dataFilter = new DataFilter();
        dataFilter.setGridRange(gridRange);

        List<DataFilter> dataFilters = new ArrayList<>();
        dataFilters.add(dataFilter);

        BatchGetValuesByDataFilterRequest requestBody = new BatchGetValuesByDataFilterRequest();
        requestBody.setDataFilters(dataFilters);

        Sheets.Spreadsheets.Values.BatchGetByDataFilter request =
                sheetsService.spreadsheets().values().batchGetByDataFilter(spreadsheetId, requestBody);

        BatchGetValuesByDataFilterResponse response = request.execute();
        List<List<Object>> sheetValues = response.getValueRanges().get(0).getValueRange().getValues();

        String[] cellLocations = new String[markups.size()];

        int i = 0;
        for (Object markup : markups) {
            int r = 0;
            int c = 0;

            for (List<Object> rowValues : sheetValues) {
                if (rowValues != null) {
                    for (Object cellValue : rowValues) {
                        if (cellValue != null && cellValue.equals(markup)) {
                            CellLocation cellLocation = new CellLocation(sheet.getProperties().getTitle(), r, c, false, false);
                            cellLocations[i] = cellLocation.formatAsString();
                        }
                        c++;
                    }
                }
                r++;
                c = 0;
            }

            i++;
        }
        return cellLocations;
    }

    @Override
    public Map<String, List<List<Object>>> getBatchRangeCellValues(String... ranges) throws IOException {
        List<String> rangeList = Arrays.asList(ranges);

        Spreadsheet spreadsheetData = sheetsService.spreadsheets().get(spreadsheetId)
                .setFields("sheets(properties.title,data(rowData.values(effectiveValue,effectiveFormat(textFormat.strikethrough,numberFormat),textFormatRuns(format.strikethrough,startIndex))))")
                .setIncludeGridData(true)
                .setPrettyPrint(false)
                .setRanges(rangeList)
                .execute();

        Map<String, List<String>> rangeGroup = groupRanges(ranges);
        Map<String, List<List<Object>>> values = new HashMap<>();
        for (String sheetName : rangeGroup.keySet()) {
            Sheet sheet = getSheet(spreadsheetData, sheetName);
            if (sheet != null) {
                List<GridData> gridData = sheet.getData();
                if (CollectionUtils.isNotEmpty(gridData)) {
                    int i = 0;
                    for (GridData data : gridData) {
                        String range = rangeGroup.get(sheetName).get(i);
                        values.put(range, getRangeData(data));
                        i++;
                    }
                }
            }
        }
        return values;
    }

    /**
     * Groups input ranges by range's sheet name.
     *
     * @param ranges the ranges
     * @return grouped range
     */
    private Map<String, List<String>> groupRanges(String... ranges) {
        Map<String, List<String>> rangeGroup = new HashMap<>();
        for(String range : ranges) {
            RangeLocation rangeLocation = new RangeLocation(range);
            List<String> group = rangeGroup.computeIfAbsent(rangeLocation.getFirstCell().getSheetName(), k -> new ArrayList<>());
            if (!group.contains(range)) {
                group.add(range);
            }
        }
        return rangeGroup;
    }

    /**
     * Get range data from the given {@link GridData}
     *
     * @param gridData Grid data
     * @return Range data
     */
    private List<List<Object>> getRangeData(GridData gridData) {
        List<List<Object>> rangeData = new ArrayList<>();
        List<RowData> gridRowData = gridData.getRowData();
        if (CollectionUtils.isNotEmpty(gridRowData)) {
            for (RowData gridRow : gridRowData) {
                List<Object> rowData = new ArrayList<>();
                List<CellData> gridCellData = gridRow.getValues();
                if (CollectionUtils.isNotEmpty(gridCellData)) {
                    for (CellData gridCell : gridCellData) {
                        rowData.add(getCellDataValue(gridCell));
                    }
                }
                rangeData.add(rowData);
            }
        }
        return rangeData;
    }

    /**
     * Get cell data value from the given {@link CellData}
     *
     * @param cellData Cell data
     * @return Cell data value
     */
    private Object getCellDataValue(CellData cellData) {
        ExtendedValue effectiveValue = cellData.getEffectiveValue();
        CellFormat effectiveFormat = cellData.getEffectiveFormat();
        if (effectiveValue == null || (effectiveFormat != null && isStrikethrough(effectiveFormat.getTextFormat()))) {
            return null;
        }
        if (effectiveValue.getStringValue() != null) {
            List<TextFormatRun> formatRuns = cellData.getTextFormatRuns();
            if (CollectionUtils.isNotEmpty(formatRuns)) {
                StringBuilder plainText = new StringBuilder();
                int i = 0;
                for (TextFormatRun formatRun : formatRuns) {
                    int runStart = formatRun.getStartIndex() == null ? 0 : formatRun.getStartIndex();
                    int runLength;
                    if (i < formatRuns.size() - 1) {
                        TextFormatRun nextRun = formatRuns.get(i + 1);
                        runLength = nextRun.getStartIndex() - runStart;
                    } else {
                        runLength = effectiveValue.getStringValue().length() - 1 - runStart;
                    }
                    if (!isStrikethrough(formatRun.getFormat())) {
                        plainText.append(effectiveValue.getStringValue().substring(runStart, runStart + runLength));
                    }
                    i++;
                }
                if (plainText.length() > 0) {
                    return plainText.toString();
                } else {
                    return null;
                }
            }
            return effectiveValue.getStringValue();
        } else if (effectiveValue.getNumberValue() != null) {
            if (effectiveFormat == null || effectiveFormat.getNumberFormat() == null) {
                return getNumericValue(effectiveValue.getNumberValue());
            } else if (StringUtils.equalsAnyIgnoreCase(effectiveFormat.getNumberFormat().getType(), "TEXT")) {
                return String.valueOf(getNumericValue(effectiveValue.getNumberValue()));
            } else if (StringUtils.equalsAnyIgnoreCase(effectiveFormat.getNumberFormat().getType(), "DATE", "TIME", "DATE_TIME")) {
                return DateUtil.getJavaDate(effectiveValue.getNumberValue(), false);
            } else {
                if (StringUtils.containsAny(effectiveFormat.getNumberFormat().getPattern(), ".0", ".#", ".?")) {
                    return effectiveValue.getNumberValue();
                } else {
                    return getIntValue(effectiveValue.getNumberValue());
                }
            }
        } else if (effectiveValue.getBoolValue() != null) {
            return effectiveValue.getBoolValue();
        }
        return null;
    }

    /**
     * Checks if the text format is strike-through.
     *
     * @param textFormat The text format
     * @return true if the text format is strike-through
     */
    private boolean isStrikethrough(TextFormat textFormat) {
        return textFormat != null && textFormat.getStrikethrough() != null && textFormat.getStrikethrough();
    }
}
