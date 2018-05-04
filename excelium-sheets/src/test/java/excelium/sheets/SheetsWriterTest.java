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
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link SheetsWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.03
 */
public class SheetsWriterTest {

    /**
     * Sheets reader factory
     */
    private static SheetsReaderFactory readerFactory;

    /**
     * Sheets writer factory
     */
    private static SheetsWriterFactory writerFactory;

    private static SheetsReader sheetsReader;
    private static SheetsWriter sheetsWriter;

    @BeforeClass
    public static void beforeClass() throws IOException {
        GoogleConnection connection = new GoogleConnectionService();
        SheetsServiceProvider sheetsServiceProvider = new SheetsServiceProvider(connection);
        Sheets sheetsService = sheetsServiceProvider.createSheetsService();
        readerFactory = new SheetsReaderFactory(sheetsService);
        writerFactory = new SheetsWriterFactory(sheetsService);

        sheetsReader = readerFactory.createReader("12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
        sheetsWriter = writerFactory.createWriter(null, "12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q");
    }

    @Test
    public void testFlush() throws IOException {
        List<Object> columnValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            columnValues.add("");
        }

        sheetsWriter.setColumnCellValues(columnValues, "Sheet2!A1:A10");
        sheetsWriter.flush();

        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A1"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A2"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A3"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A4"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A5"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A6"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A7"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A8"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A9"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A10"));

        sheetsWriter.setCellValue("String", "Sheet2!A1");
        sheetsWriter.setCellValue(true, "Sheet2!A2");
        sheetsWriter.setCellValue(1.1, "Sheet2!A3");
        sheetsWriter.setCellValue(1, "Sheet2!A4");
        sheetsWriter.setCellValue(1L, "Sheet2!A5");
        sheetsWriter.setCellValue("", "Sheet2!A6");
        sheetsWriter.setCellValue("1.1", "Sheet2!A7");
        sheetsWriter.setCellValue("1", "Sheet2!A8");
        sheetsWriter.setCellValue("2018/01/01", "Sheet2!A9");
        sheetsWriter.setCellValue("TRUE", "Sheet2!A10");
        sheetsWriter.flush();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals("String", sheetsReader.getCellValue("Sheet2!A1"));
        Assert.assertEquals(true, sheetsReader.getCellValue("Sheet2!A2"));
        Assert.assertEquals(1.1, sheetsReader.getCellValue("Sheet2!A3"));
        Assert.assertEquals(1, sheetsReader.getCellValue("Sheet2!A4"));
        Assert.assertEquals(1, sheetsReader.getCellValue("Sheet2!A5"));
        Assert.assertEquals(null, sheetsReader.getCellValue("Sheet2!A6"));
        Assert.assertEquals(1.1, sheetsReader.getCellValue("Sheet2!A7"));
        Assert.assertEquals(1, sheetsReader.getCellValue("Sheet2!A8"));
        Assert.assertEquals("2018-01-01", format.format(sheetsReader.getCellValue("Sheet2!A9")));
        Assert.assertEquals(true, sheetsReader.getCellValue("Sheet2!A10"));
    }

    @Test
    public void testFlushInterval() throws IOException {
        sheetsWriter.setCellValue(0, "Sheet2!A1");
        sheetsWriter.flush();

        for (int i = 1; i <= 99; i++) {
            sheetsWriter.setCellValue(i, "Sheet2!A" + i);
        }
        Assert.assertEquals(0, sheetsReader.getCellValue("Sheet2!A1"));

        sheetsWriter.setCellValue(100, "Sheet2!A100");
        Assert.assertEquals(1, sheetsReader.getCellValue("Sheet2!A1"));
    }
}
