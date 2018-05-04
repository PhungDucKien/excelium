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

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link AbstractWorkbookWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.03
 */
public class AbstractWorkbookWriterTest {

    @Test
    public void testSetCellValue() throws IOException {
        MyWorkbookWriter workbookWriter = new MyWorkbookWriter();
        workbookWriter.setCellValue("String", "Sheet1!A1");

        Assert.assertEquals(1, workbookWriter.flushValues.size());
        Assert.assertEquals("String", workbookWriter.flushValues.get("Sheet1!A1").get(0).get(0));
    }

    @Test
    public void testSetRowCellValues() throws IOException {
        MyWorkbookWriter workbookWriter = new MyWorkbookWriter();
        List<Object> rowValues = new ArrayList<>();
        rowValues.add("A1");
        rowValues.add("B1");
        rowValues.add("C1");
        workbookWriter.setRowCellValues(rowValues, "Sheet1!A1:C1");

        Assert.assertEquals(1, workbookWriter.flushValues.size());
        Assert.assertEquals("A1", workbookWriter.flushValues.get("Sheet1!A1:C1").get(0).get(0));
        Assert.assertEquals("B1", workbookWriter.flushValues.get("Sheet1!A1:C1").get(0).get(1));
        Assert.assertEquals("C1", workbookWriter.flushValues.get("Sheet1!A1:C1").get(0).get(2));
    }

    @Test
    public void testSetColumnCellValues() throws IOException {
        MyWorkbookWriter workbookWriter = new MyWorkbookWriter();
        List<Object> columnValues = new ArrayList<>();
        columnValues.add("A1");
        columnValues.add("A2");
        columnValues.add("A3");
        workbookWriter.setColumnCellValues(columnValues, "Sheet1!A1:A3");

        Assert.assertEquals(1, workbookWriter.flushValues.size());
        Assert.assertEquals("A1", workbookWriter.flushValues.get("Sheet1!A1:A3").get(0).get(0));
        Assert.assertEquals("A2", workbookWriter.flushValues.get("Sheet1!A1:A3").get(1).get(0));
        Assert.assertEquals("A3", workbookWriter.flushValues.get("Sheet1!A1:A3").get(2).get(0));
    }

    @Test
    public void testSetRangeCellValues() throws IOException {
        MyWorkbookWriter workbookWriter = new MyWorkbookWriter();
        List<List<Object>> rangeValues = new ArrayList<>();
        List<Object> rowValues = new ArrayList<>();
        rowValues.add("A1");
        rowValues.add("B1");
        rowValues.add("C1");
        rangeValues.add(rowValues);
        rowValues = new ArrayList<>();
        rowValues.add("A2");
        rowValues.add("B2");
        rowValues.add("C2");
        rangeValues.add(rowValues);
        rowValues = new ArrayList<>();
        rowValues.add("A3");
        rowValues.add("B3");
        rowValues.add("C3");
        rangeValues.add(rowValues);
        workbookWriter.setRangeCellValues(rangeValues, "Sheet1!A1:C3");

        Assert.assertEquals(1, workbookWriter.flushValues.size());
        Assert.assertEquals("A1", workbookWriter.flushValues.get("Sheet1!A1:C3").get(0).get(0));
        Assert.assertEquals("B1", workbookWriter.flushValues.get("Sheet1!A1:C3").get(0).get(1));
        Assert.assertEquals("C1", workbookWriter.flushValues.get("Sheet1!A1:C3").get(0).get(2));
        Assert.assertEquals("A2", workbookWriter.flushValues.get("Sheet1!A1:C3").get(1).get(0));
        Assert.assertEquals("B2", workbookWriter.flushValues.get("Sheet1!A1:C3").get(1).get(1));
        Assert.assertEquals("C2", workbookWriter.flushValues.get("Sheet1!A1:C3").get(1).get(2));
        Assert.assertEquals("A3", workbookWriter.flushValues.get("Sheet1!A1:C3").get(2).get(0));
        Assert.assertEquals("B3", workbookWriter.flushValues.get("Sheet1!A1:C3").get(2).get(1));
        Assert.assertEquals("C3", workbookWriter.flushValues.get("Sheet1!A1:C3").get(2).get(2));
    }

    public static class MyWorkbookWriter extends AbstractWorkbookWriter {

        @Override
        public void flush() throws IOException {

        }
    }
}
