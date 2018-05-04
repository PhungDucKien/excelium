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
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.ValueRange;
import excelium.core.writer.AbstractTestWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Writes Google Sheet spreadsheets.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
public class SheetsWriter extends AbstractTestWriter {

    /**
     * Flush interval. Once the number of changes is greater than this config, flushes changes.
     */
    private static final int FLUSH_INTERVAL = 100;

    /**
     * Spreadsheet id
     */
    private String spreadsheetId;

    /**
     * Sheets service
     */
    private Sheets sheetsService;

    /**
     * Instantiates a new Sheets writer.
     *
     * @param sheetsService the sheets service
     * @param spreadsheetId the spreadsheet id
     */
    SheetsWriter(Sheets sheetsService, String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
        this.sheetsService = sheetsService;
    }

    @Override
    public synchronized void flush() throws IOException {
        List<ValueRange> valueRanges = new ArrayList<>();
        for (String range : flushValues.keySet()) {
            ValueRange valueRange = new ValueRange().setRange(range).setValues(flushValues.get(range));
            valueRanges.add(valueRange);
        }

        BatchUpdateValuesRequest request = new BatchUpdateValuesRequest();
        request.setData(valueRanges);
        request.setValueInputOption("USER_ENTERED");
        sheetsService.spreadsheets().values().batchUpdate(spreadsheetId, request).execute();
        flushValues.clear();
    }

    @Override
    public void batchSetRangeCellValues(Map<String, List<List<Object>>> values, String... ranges) throws IOException {
        super.batchSetRangeCellValues(values, ranges);
        if (flushValues != null && flushValues.size() >= FLUSH_INTERVAL) {
            flush();
        }
    }
}
