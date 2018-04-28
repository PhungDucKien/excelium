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
import excelium.model.enums.Browser;
import excelium.model.project.Template;
import excelium.model.test.config.PcEnvironment;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static excelium.model.project.Template.*;

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
    public void testParseTest() throws IOException {
        Template webTemplate = new Template();
        webTemplate.setLocation("1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50");
        webTemplate.setName("1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50 - Web Template");
        webTemplate.setActionPattern("Actions");
        webTemplate.setDataPattern("Test Data");
        webTemplate.setMappingPattern("Mapping");
        webTemplate.setTestPattern("*");
        webTemplate.setIgnorePatterns(new ArrayList<String>() {{ add("Commands"); }});

        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put(BASE_URL, "Configuration!B19");
        markupLocations.put(USE_PC, "Configuration!B27");
        markupLocations.put(USE_CHROME, "Configuration!B35");
        markupLocations.put(MAPPING_PAGESET_NAME, "Mapping!B2");
        markupLocations.put(MAPPING_PAGESET_PATH, "Mapping!C2");
        markupLocations.put(MAPPING_PAGESET_TITLE, "Mapping!D2");
        markupLocations.put(MAPPING_ITEM_NAME, "Mapping!E2");
        markupLocations.put(MAPPING_ITEM_VALUE, "Mapping!F2");
        markupLocations.put(ACTION_NO, "Actions!A3");
        markupLocations.put(ACTION_GUTTER, "Actions!B3");
        markupLocations.put(ACTION_CAPTURE, "Actions!C3");
        markupLocations.put(ACTION_NAME, "Actions!E3");
        markupLocations.put(ACTION_COMMAND, "Actions!F3");
        markupLocations.put(ACTION_PARAM1, "Actions!G3");
        markupLocations.put(ACTION_PARAM2, "Actions!H3");
        markupLocations.put(ACTION_PARAM3, "Actions!I3");
        markupLocations.put(ACTION_DATA, "Actions!J3");
        markupLocations.put(TEST_NO, "'Test Case'!A3");
        markupLocations.put(TEST_GUTTER, "'Test Case'!B3");
        markupLocations.put(TEST_CAPTURE, "'Test Case'!C3");
        markupLocations.put(TEST_NAME, "'Test Case'!E3");
        markupLocations.put(TEST_COMMAND, "'Test Case'!F3");
        markupLocations.put(TEST_PARAM1, "'Test Case'!G3");
        markupLocations.put(TEST_PARAM2, "'Test Case'!H3");
        markupLocations.put(TEST_PARAM3, "'Test Case'!I3");
        markupLocations.put(TEST_DATA, "'Test Case'!J3");
        markupLocations.put(DATA_NAME, "'Test Data'!A1");
        markupLocations.put(DATA_DESC, "'Test Data'!B2");
        markupLocations.put(DATA_TABLE_DEF, "'Test Data'!B3");
        markupLocations.put(DATA_TABLE_DATA, "'Test Data'!B4");
        webTemplate.setMarkupLocations(markupLocations);

        TestReader sheetsReader = readerFactory.createReader("1mNKWaLq-vmXJOGEVEJzUUTfkoBM22Bn6OZz99d6X0DE");
        excelium.model.test.Test test = sheetsReader.parseTest(webTemplate);

        Assert.assertEquals("1mNKWaLq-vmXJOGEVEJzUUTfkoBM22Bn6OZz99d6X0DE - Web Test", test.getWorkbookName());
        Assert.assertEquals("http://demo.excelium.tech", test.getConfig().getBaseUrl());
        Assert.assertEquals(1, test.getConfig().getEnvironments().size());
        Assert.assertEquals(Browser.CHROME, ((PcEnvironment) test.getConfig().getEnvironments().get(0)).getBrowser());

        Assert.assertTrue(test.getPageSets().size() > 0);
        Assert.assertTrue(test.getActions().size() > 0);
        Assert.assertTrue(test.getTestSuites().size() > 0);
        Assert.assertTrue(test.getTestData().size() > 0);
    }

    @Test
    public void testGetWorkbook() throws IOException {
        TestReader sheetsReader = readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Assert.assertNotNull(sheetsReader.getWorkbook());
    }

    @Test
    public void testGetWorkbookName() throws IOException {
        TestReader sheetsReader = readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Assert.assertEquals("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q - Workbook1.xlsx", sheetsReader.getWorkbookName());
    }

    @Test
    public void testListSheets() throws IOException {
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        List<Sheet> sheets = sheetsReader.listSheets();
        Assert.assertEquals(3, sheets.size());
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
    public void testFindFirstOccurrence() throws IllegalAccessException, IOException {
        TestReader sheetsReader = readerFactory.createReader("10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY");
        Assert.assertEquals("'Test Case'!A2", sheetsReader.findFirstOccurrence("%TEST_COMMAND%"));
        Assert.assertEquals("'Test Case'!B2", sheetsReader.findFirstOccurrence("%TEST_PARAM1%"));
        Assert.assertEquals("'Test Case'!C2", sheetsReader.findFirstOccurrence("%TEST_PARAM2%"));
        Assert.assertEquals("'Test Case'!D2", sheetsReader.findFirstOccurrence("%TEST_PARAM3%"));

        List<Sheet> sheets = sheetsReader.listSheets();
        Assert.assertEquals("'Test Case'!A2", sheetsReader.findFirstOccurrence("%TEST_COMMAND%", sheets.get(0)));
        Assert.assertEquals("'Test Case'!B2", sheetsReader.findFirstOccurrence("%TEST_PARAM1%", sheets.get(0)));
        Assert.assertEquals("'Test Case'!C2", sheetsReader.findFirstOccurrence("%TEST_PARAM2%", sheets.get(0)));
        Assert.assertEquals("'Test Case'!D2", sheetsReader.findFirstOccurrence("%TEST_PARAM3%", sheets.get(0)));
    }

    @Test
    public void testBatchFindFirstOccurrence() throws IllegalAccessException, IOException {
        TestReader sheetsReader = readerFactory.createReader("10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY");
        Map<Object, String> cellLocations = sheetsReader.batchFindFirstOccurrence(TemplateUtil.getMarkups());
        Assert.assertEquals(4, cellLocations.size());
        Assert.assertEquals("'Test Case'!A2", cellLocations.get("%TEST_COMMAND%"));
        Assert.assertEquals("'Test Case'!B2", cellLocations.get("%TEST_PARAM1%"));
        Assert.assertEquals("'Test Case'!C2", cellLocations.get("%TEST_PARAM2%"));
        Assert.assertEquals("'Test Case'!D2", cellLocations.get("%TEST_PARAM3%"));

        List<Sheet> sheets = sheetsReader.listSheets();
        cellLocations = sheetsReader.batchFindFirstOccurrence(TemplateUtil.getMarkups(), sheets.get(0));
        Assert.assertEquals(4, cellLocations.size());
        Assert.assertEquals("'Test Case'!A2", cellLocations.get("%TEST_COMMAND%"));
        Assert.assertEquals("'Test Case'!B2", cellLocations.get("%TEST_PARAM1%"));
        Assert.assertEquals("'Test Case'!C2", cellLocations.get("%TEST_PARAM2%"));
        Assert.assertEquals("'Test Case'!D2", cellLocations.get("%TEST_PARAM3%"));
    }

    @Test
    public void testGetCellValue() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Assert.assertEquals("Cell B2", sheetsReader.getCellValue("Sheet1!B2"));
        Assert.assertEquals("Cell C2", sheetsReader.getCellValue("Sheet1!C2"));
        Assert.assertEquals("Cell D2", sheetsReader.getCellValue("Sheet1!D2"));
        Assert.assertEquals(1, sheetsReader.getCellValue("Sheet1!B3"));
        Assert.assertEquals(2, sheetsReader.getCellValue("Sheet1!C3"));
        Assert.assertEquals(true, sheetsReader.getCellValue("Sheet1!B4"));
        Assert.assertEquals(false, sheetsReader.getCellValue("Sheet1!C4"));
        Assert.assertEquals(true, sheetsReader.getCellValue("Sheet1!D4"));
        Assert.assertEquals(false, sheetsReader.getCellValue("Sheet1!E4"));
        Assert.assertEquals(1.1, sheetsReader.getCellValue("Sheet1!B5"));
        Assert.assertEquals(2.1, sheetsReader.getCellValue("Sheet1!C5"));
        Assert.assertEquals("2018-01-01", format.format(sheetsReader.getCellValue("Sheet1!B6")));
        Assert.assertEquals("2018-01-02", format.format(sheetsReader.getCellValue("Sheet1!C6")));
        Assert.assertEquals(1, sheetsReader.getCellValue("Sheet1!B7"));
        Assert.assertEquals("2.2", sheetsReader.getCellValue("Sheet1!C7"));
        Assert.assertEquals("2018-01-01", format.format(sheetsReader.getCellValue("Sheet1!B8")));
        Assert.assertEquals("2018-01-02", format.format(sheetsReader.getCellValue("Sheet1!C8")));
    }

    @Test
    public void testGetRowCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");

        List<Object> rowCellValues = sheetsReader.getRowCellValues("Sheet1!B2:E3");
        Assert.assertEquals("Cell B2", rowCellValues.get(0));
        Assert.assertEquals("Cell C2", rowCellValues.get(1));
        Assert.assertEquals("Cell D2", rowCellValues.get(2));

        rowCellValues = sheetsReader.getRowCellValues("Sheet1!B4:E5");
        Assert.assertEquals(true, rowCellValues.get(0));
        Assert.assertEquals(false, rowCellValues.get(1));
        Assert.assertEquals(true, rowCellValues.get(2));
        Assert.assertEquals(false, rowCellValues.get(3));

        rowCellValues = sheetsReader.getRowCellValues("Sheet1!B6:E8");
        Assert.assertEquals("2018-01-01", format.format(rowCellValues.get(0)));
        Assert.assertEquals("2018-01-02", format.format(rowCellValues.get(1)));
    }

    @Test
    public void testGetColumnCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");

        List<Object> columnCellValues = sheetsReader.getColumnCellValues("Sheet1!B2:C7");
        Assert.assertEquals("Cell B2", columnCellValues.get(0));
        Assert.assertEquals(1, columnCellValues.get(1));
        Assert.assertEquals(true, columnCellValues.get(2));
        Assert.assertEquals(1.1, columnCellValues.get(3));
        Assert.assertEquals("2018-01-01", format.format(columnCellValues.get(4)));
        Assert.assertEquals(1, columnCellValues.get(5));

        columnCellValues = sheetsReader.getColumnCellValues("Sheet1!D2:E7");
        Assert.assertEquals("Cell D2", columnCellValues.get(0));
        Assert.assertEquals(null, columnCellValues.get(1));
        Assert.assertEquals(true, columnCellValues.get(2));
    }

    @Test
    public void testGetRangeCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        List<List<Object>> rangeCellValue = sheetsReader.getRangeCellValues("Sheet1!B2:E8");
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
    public void testBatchGetCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Map<String, Object> cellValues = sheetsReader.batchGetCellValues(
                "Sheet1!B2", "Sheet1!C2", "Sheet1!D2", "Sheet1!B3", "Sheet1!C3", "Sheet1!B4", "Sheet1!C4", "Sheet1!D4", "Sheet1!E4",
                "Sheet1!B5", "Sheet1!C5", "Sheet1!B6", "Sheet1!C6", "Sheet1!B7", "Sheet1!C7", "Sheet1!B8", "Sheet1!C8"
        );
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

    @Test
    public void testBatchGetRowCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Map<String, List<Object>> rowCellValues = sheetsReader.batchGetRowCellValues("Sheet1!B2:E3", "Sheet1!B4:E5", "Sheet1!B6:E8");
        Assert.assertEquals("Cell B2", rowCellValues.get("Sheet1!B2:E3").get(0));
        Assert.assertEquals("Cell C2", rowCellValues.get("Sheet1!B2:E3").get(1));
        Assert.assertEquals("Cell D2", rowCellValues.get("Sheet1!B2:E3").get(2));
        Assert.assertEquals(true, rowCellValues.get("Sheet1!B4:E5").get(0));
        Assert.assertEquals(false, rowCellValues.get("Sheet1!B4:E5").get(1));
        Assert.assertEquals(true, rowCellValues.get("Sheet1!B4:E5").get(2));
        Assert.assertEquals(false, rowCellValues.get("Sheet1!B4:E5").get(3));
        Assert.assertEquals("2018-01-01", format.format(rowCellValues.get("Sheet1!B6:E8").get(0)));
        Assert.assertEquals("2018-01-02", format.format(rowCellValues.get("Sheet1!B6:E8").get(1)));
    }

    @Test
    public void testBatchGetColumnCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Map<String, List<Object>> columnCellValues = sheetsReader.batchGetColumnCellValues("Sheet1!B2:C7", "Sheet1!D2:E7");
        Assert.assertEquals("Cell B2", columnCellValues.get("Sheet1!B2:C7").get(0));
        Assert.assertEquals(1, columnCellValues.get("Sheet1!B2:C7").get(1));
        Assert.assertEquals(true, columnCellValues.get("Sheet1!B2:C7").get(2));
        Assert.assertEquals(1.1, columnCellValues.get("Sheet1!B2:C7").get(3));
        Assert.assertEquals("2018-01-01", format.format(columnCellValues.get("Sheet1!B2:C7").get(4)));
        Assert.assertEquals(1, columnCellValues.get("Sheet1!B2:C7").get(5));
        Assert.assertEquals("Cell D2", columnCellValues.get("Sheet1!D2:E7").get(0));
        Assert.assertEquals(null, columnCellValues.get("Sheet1!D2:E7").get(1));
        Assert.assertEquals(true, columnCellValues.get("Sheet1!D2:E7").get(2));
    }

    @Test
    public void testBatchGetRangeCellValues() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SheetsReader sheetsReader = (SheetsReader) readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        Map<String, List<List<Object>>> rangeCellValues = sheetsReader.batchGetRangeCellValues(
                "Sheet1!B2", "Sheet1!C2", "Sheet1!D2", "Sheet1!B3", "Sheet1!C3", "Sheet1!B4", "Sheet1!C4", "Sheet1!D4", "Sheet1!E4",
                "Sheet1!B5", "Sheet1!C5", "Sheet1!B6", "Sheet1!C6", "Sheet1!B7", "Sheet1!C7", "Sheet1!B8", "Sheet1!C8"
        );
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
}
