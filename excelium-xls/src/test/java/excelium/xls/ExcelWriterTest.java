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

package excelium.xls;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Tests for {@link ExcelWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.04
 */
public class ExcelWriterTest {

    /**
     * Excel reader factory
     */
    private static ExcelReaderFactory readerFactory;

    /**
     * Excel writer factory
     */
    private static ExcelWriterFactory writerFactory;

    @BeforeClass
    public static void beforeClass() {
        readerFactory = new ExcelReaderFactory();
        writerFactory = new ExcelWriterFactory();
    }

    @Test
    public void testFlush() throws IOException, URISyntaxException {
        ExcelReader excelReader = readerFactory.createReader(ExcelReader.class.getResource("/Workbook1.xlsx").toURI().getPath());
        ExcelWriter excelWriter = writerFactory.createWriter(excelReader.getWorkbook(), ExcelReader.class.getResource("/Workbook1.xlsx").toURI().getPath());

        List<Object> columnValues = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            columnValues.add(null);
        }
        excelWriter.setColumnCellValues(columnValues, "Sheet2!A1:A8");
        excelWriter.close();
        excelReader.close();

        excelReader = readerFactory.createReader(ExcelReader.class.getResource("/Workbook1.xlsx").toURI().getPath());
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A1"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A2"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A3"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A4"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A5"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A6"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A7"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A8"));

        excelWriter = writerFactory.createWriter(excelReader.getWorkbook(), ExcelReader.class.getResource("/Workbook1.xlsx").toURI().getPath());

        excelWriter.setCellValue("1", "Sheet2!A1");
        excelWriter.setCellValue(true, "Sheet2!A2");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 0, 1, 0, 0, 0);
        excelWriter.setCellValue(calendar, "Sheet2!A3");
        excelWriter.setCellValue(calendar.getTime(), "Sheet2!A4");
        excelWriter.setCellValue(1.1, "Sheet2!A5");
        excelWriter.setCellValue(1, "Sheet2!A6");
        excelWriter.setCellValue(1L, "Sheet2!A7");
        excelWriter.setCellValue(null, "Sheet2!A8");
        excelWriter.close();
        excelReader.close();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        excelReader = readerFactory.createReader(ExcelReader.class.getResource("/Workbook1.xlsx").toURI().getPath());
        Assert.assertEquals("1", excelReader.getCellValue("Sheet2!A1"));
        Assert.assertEquals(true, excelReader.getCellValue("Sheet2!A2"));
        Assert.assertEquals("2018-01-01", format.format(excelReader.getCellValue("Sheet2!A3")));
        Assert.assertEquals("2018-01-01", format.format(excelReader.getCellValue("Sheet2!A4")));
        Assert.assertEquals(1.1, excelReader.getCellValue("Sheet2!A5"));
        Assert.assertEquals(1, excelReader.getCellValue("Sheet2!A6"));
        Assert.assertEquals(1, excelReader.getCellValue("Sheet2!A7"));
        Assert.assertEquals(null, excelReader.getCellValue("Sheet2!A8"));
        excelReader.close();
    }
}
