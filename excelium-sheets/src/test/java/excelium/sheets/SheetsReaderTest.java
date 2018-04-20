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
import com.google.api.services.sheets.v4.model.Sheet;
import excelium.common.TemplateUtil;
import excelium.core.reader.TestReader;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link SheetsReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class SheetsReaderTest {

    /**
     * Sheets reader factory
     */
    private static SheetsReaderFactory readerFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {
        GoogleConnection connection = new GoogleConnectionService();
        SheetsServiceProvider sheetsServiceProvider = new SheetsServiceProvider(connection);
        Sheets sheetsService = sheetsServiceProvider.createSheetsService();
        readerFactory = new SheetsReaderFactory(sheetsService);
    }

    @Test
    public void testGetWorkbookName() throws IOException {
        TestReader sheetsReader = readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Assert.assertEquals("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q - Workbook1.xlsx", sheetsReader.getWorkbookName());
    }

    @Test
    public void testGetSheetName() throws IOException {
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        List<Sheet> sheets = sheetsReader.listSheets();
        Assert.assertEquals("Sheet1", sheetsReader.getSheetName(sheets.get(0)));
        Assert.assertEquals("Sheet2", sheetsReader.getSheetName(sheets.get(1)));
        Assert.assertEquals("Sheet3", sheetsReader.getSheetName(sheets.get(2)));
    }

    @Test
    public void testListSheets() throws IOException {
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        List<Sheet> sheets = sheetsReader.listSheets();
        Assert.assertEquals(3, sheets.size());
    }

    @Test
    public void testGetMarkupLocationMap() throws IllegalAccessException, IOException {
        TestReader sheetsReader = readerFactory.createReader("10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY");
        Map<Object, String> markupLocations = sheetsReader.getMarkupLocationMap(TemplateUtil.getMarkups());
        Assert.assertEquals(4, markupLocations.size());
        Assert.assertEquals("'Test Case'!A2", markupLocations.get("%TEST_COMMAND%"));
        Assert.assertEquals("'Test Case'!B2", markupLocations.get("%TEST_PARAM1%"));
        Assert.assertEquals("'Test Case'!C2", markupLocations.get("%TEST_PARAM2%"));
        Assert.assertEquals("'Test Case'!D2", markupLocations.get("%TEST_PARAM3%"));
    }

    @Test
    public void testGetBatchRangeCellValues() throws IOException {
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Map<String, List<List<Object>>> rangeCellValues = sheetsReader.getBatchRangeCellValues(
                "Sheet1!B2", "Sheet1!C2", "Sheet1!D2", "Sheet1!B3", "Sheet1!C3", "Sheet1!B4", "Sheet1!C4", "Sheet1!D4", "Sheet1!E4",
                "Sheet1!B5", "Sheet1!C5", "Sheet1!B6", "Sheet1!C6", "Sheet1!B7", "Sheet1!C7", "Sheet1!B8", "Sheet1!C8"
        );
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals("Cell B2", rangeCellValues.get("Sheet1!B2").get(0).get(0));
        Assert.assertEquals("Cell C2", rangeCellValues.get("Sheet1!C2").get(0).get(0));
        Assert.assertEquals("Cell D2", rangeCellValues.get("Sheet1!D2").get(0).get(0));
        Assert.assertEquals(1, rangeCellValues.get("Sheet1!B3").get(0).get(0));
        Assert.assertEquals(2, rangeCellValues.get("Sheet1!C3").get(0).get(0));
        Assert.assertEquals(true, rangeCellValues.get("Sheet1!B4").get(0).get(0));
        Assert.assertEquals(false, rangeCellValues.get("Sheet1!C4").get(0).get(0));
        Assert.assertEquals(true, rangeCellValues.get("Sheet1!D4").get(0).get(0));
        Assert.assertEquals(false, rangeCellValues.get("Sheet1!E4").get(0).get(0));
        Assert.assertEquals(1.1, rangeCellValues.get("Sheet1!B5").get(0).get(0));
        Assert.assertEquals(2.1, rangeCellValues.get("Sheet1!C5").get(0).get(0));
        Assert.assertEquals("2018-01-01", format.format(rangeCellValues.get("Sheet1!B6").get(0).get(0)));
        Assert.assertEquals("2018-01-02", format.format(rangeCellValues.get("Sheet1!C6").get(0).get(0)));
        Assert.assertEquals(1, rangeCellValues.get("Sheet1!B7").get(0).get(0));
        Assert.assertEquals("2.2", rangeCellValues.get("Sheet1!C7").get(0).get(0));
        Assert.assertEquals("2018-01-01", format.format(rangeCellValues.get("Sheet1!B8").get(0).get(0)));
        Assert.assertEquals("2018-01-02", format.format(rangeCellValues.get("Sheet1!C8").get(0).get(0)));
    }

    @Test
    public void testGetRangeCellValues() throws IOException {
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        List<List<Object>> rangeCellValue = sheetsReader.getRangeCellValues("Sheet1!B2:E8");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals("Cell B2", rangeCellValue.get(0).get(0));
        Assert.assertEquals("Cell C2", rangeCellValue.get(0).get(1));
        Assert.assertEquals("Cell D2", rangeCellValue.get(0).get(2));
        Assert.assertEquals(1, rangeCellValue.get(1).get(0));
        Assert.assertEquals(2, rangeCellValue.get(1).get(1));
        Assert.assertEquals(true, rangeCellValue.get(2).get(0));
        Assert.assertEquals(false, rangeCellValue.get(2).get(1));
        Assert.assertEquals(true, rangeCellValue.get(2).get(2));
        Assert.assertEquals(false, rangeCellValue.get(2).get(3));
        Assert.assertEquals(1.1, rangeCellValue.get(3).get(0));
        Assert.assertEquals(2.1, rangeCellValue.get(3).get(1));
        Assert.assertEquals("2018-01-01", format.format(rangeCellValue.get(4).get(0)));
        Assert.assertEquals("2018-01-02", format.format(rangeCellValue.get(4).get(1)));
        Assert.assertEquals(1, rangeCellValue.get(5).get(0));
        Assert.assertEquals("2.2", rangeCellValue.get(5).get(1));
        Assert.assertEquals("2018-01-01", format.format(rangeCellValue.get(6).get(0)));
        Assert.assertEquals("2018-01-02", format.format(rangeCellValue.get(6).get(1)));
    }

    @Test
    public void testGetBatchCellValues() throws IOException {
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Map<String, Object> cellValues = sheetsReader.getBatchCellValues(
                "Sheet1!B2", "Sheet1!C2", "Sheet1!D2", "Sheet1!B3", "Sheet1!C3", "Sheet1!B4", "Sheet1!C4", "Sheet1!D4", "Sheet1!E4",
                "Sheet1!B5", "Sheet1!C5", "Sheet1!B6", "Sheet1!C6", "Sheet1!B7", "Sheet1!C7", "Sheet1!B8", "Sheet1!C8"
        );
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals("Cell B2", cellValues.get("Sheet1!B2"));
        Assert.assertEquals("Cell C2", cellValues.get("Sheet1!C2"));
        Assert.assertEquals("Cell D2", cellValues.get("Sheet1!D2"));
        Assert.assertEquals(1, cellValues.get("Sheet1!B3"));
        Assert.assertEquals(2, cellValues.get("Sheet1!C3"));
        Assert.assertEquals(true, cellValues.get("Sheet1!B4"));
        Assert.assertEquals(false, cellValues.get("Sheet1!C4"));
        Assert.assertEquals(true, cellValues.get("Sheet1!D4"));
        Assert.assertEquals(false, cellValues.get("Sheet1!E4"));
        Assert.assertEquals(1.1, cellValues.get("Sheet1!B5"));
        Assert.assertEquals(2.1, cellValues.get("Sheet1!C5"));
        Assert.assertEquals("2018-01-01", format.format(cellValues.get("Sheet1!B6")));
        Assert.assertEquals("2018-01-02", format.format(cellValues.get("Sheet1!C6")));
        Assert.assertEquals(1, cellValues.get("Sheet1!B7"));
        Assert.assertEquals("2.2", cellValues.get("Sheet1!C7"));
        Assert.assertEquals("2018-01-01", format.format(cellValues.get("Sheet1!B8")));
        Assert.assertEquals("2018-01-02", format.format(cellValues.get("Sheet1!C8")));
    }
}
