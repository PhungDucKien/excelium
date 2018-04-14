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
import excelium.common.CellLocation;
import excelium.core.reader.DefaultTestReader;
import excelium.model.project.Template;
import excelium.model.test.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads Google Sheet spreadsheets.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class SheetsReader extends DefaultTestReader<Spreadsheet, Sheet> {

    /** Logger */
    private static final Logger LOG = LogManager.getLogger();

    /** Spreadsheet id */
    private String spreadsheetId;

    /** Sheets service */
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
    public Spreadsheet getSpreadsheet() throws IOException {
        if (workbook == null) {
            workbook = sheetsService.spreadsheets().get(spreadsheetId).execute();
        }
        return workbook;
    }

    @Override
    public String getWorkbookName() throws IOException {
        return spreadsheetId + " - " + getSpreadsheet().getProperties().getTitle();
    }

    @Override
    public Test parseTest(Template template) throws IOException {
        return null;
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
}
