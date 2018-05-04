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

/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package excelium.common.ss;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests that the common CellLocation works as we need it to.
 */
public final class CellLocationTest {
    @Test
    public void testConstructors() {
        CellLocation cellLocation;
        final String sheet = "Sheet1";
        final String cellRef = "A1";
        final int row = 0;
        final int col = 0;
        final boolean absRow = true;
        final boolean absCol = false;

        cellLocation = new CellLocation(row, col);
        assertEquals("A1", cellLocation.formatAsString());

        cellLocation = new CellLocation(row, col, absRow, absCol);
        assertEquals("A$1", cellLocation.formatAsString());

        cellLocation = new CellLocation(row, (short) col);
        assertEquals("A1", cellLocation.formatAsString());

        cellLocation = new CellLocation(cellRef);
        assertEquals("A1", cellLocation.formatAsString());

        cellLocation = new CellLocation(sheet, row, col, absRow, absCol);
        assertEquals("Sheet1!A$1", cellLocation.formatAsString());
    }

    @Test
    public void testFormatAsString() {
        CellLocation cellLocation;

        cellLocation = new CellLocation(null, 0, 0, false, false);
        assertEquals("A1", cellLocation.formatAsString());

        //absolute references
        cellLocation = new CellLocation(null, 0, 0, true, false);
        assertEquals("A$1", cellLocation.formatAsString());

        //sheet name with no spaces
        cellLocation = new CellLocation("Sheet1", 0, 0, true, false);
        assertEquals("Sheet1!A$1", cellLocation.formatAsString());

        //sheet name with spaces
        cellLocation = new CellLocation("Sheet 1", 0, 0, true, false);
        assertEquals("'Sheet 1'!A$1", cellLocation.formatAsString());
    }

    @Test
    public void testGetCellRefParts() {
        CellLocation cellLocation;
        String[] parts;

        String cellRef = "A1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(0, cellLocation.getCol());
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("1", parts[1]);
        assertEquals("A", parts[2]);

        cellRef = "AA1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26, cellLocation.getCol());
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("1", parts[1]);
        assertEquals("AA", parts[2]);

        cellRef = "AA100";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26, cellLocation.getCol());
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("100", parts[1]);
        assertEquals("AA", parts[2]);

        cellRef = "AAA300";
        cellLocation = new CellLocation(cellRef);
        assertEquals(702, cellLocation.getCol());
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("300", parts[1]);
        assertEquals("AAA", parts[2]);

        cellRef = "ZZ100521";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 * 26 + 25, cellLocation.getCol());
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("100521", parts[1]);
        assertEquals("ZZ", parts[2]);

        cellRef = "ZYX987";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 * 26 * 26 + 25 * 26 + 24 - 1, cellLocation.getCol());
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("987", parts[1]);
        assertEquals("ZYX", parts[2]);

        cellRef = "AABC10065";
        cellLocation = new CellLocation(cellRef);
        parts = cellLocation.getCellRefParts();
        assertNotNull(parts);
        assertEquals(null, parts[0]);
        assertEquals("10065", parts[1]);
        assertEquals("AABC", parts[2]);
    }

    @Test
    public void testGetColNumFromRef() {
        String cellRef = "A1";
        CellLocation cellLocation = new CellLocation(cellRef);
        assertEquals(0, cellLocation.getCol());

        cellRef = "AA1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26, cellLocation.getCol());

        cellRef = "AB1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(27, cellLocation.getCol());

        cellRef = "BA1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 + 26, cellLocation.getCol());

        cellRef = "CA1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 + 26 + 26, cellLocation.getCol());

        cellRef = "ZA1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 * 26, cellLocation.getCol());

        cellRef = "ZZ1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 * 26 + 25, cellLocation.getCol());

        cellRef = "AAA1";
        cellLocation = new CellLocation(cellRef);
        assertEquals(26 * 26 + 26, cellLocation.getCol());


        cellRef = "A1100";
        cellLocation = new CellLocation(cellRef);
        assertEquals(0, cellLocation.getCol());

        cellRef = "BC15";
        cellLocation = new CellLocation(cellRef);
        assertEquals(54, cellLocation.getCol());
    }

    @Test
    public void testGetRowNumFromRef() {
        String cellRef = "A1";
        CellLocation cellLocation = new CellLocation(cellRef);
        assertEquals(0, cellLocation.getRow());

        cellRef = "A12";
        cellLocation = new CellLocation(cellRef);
        assertEquals(11, cellLocation.getRow());

        cellRef = "AS121";
        cellLocation = new CellLocation(cellRef);
        assertEquals(120, cellLocation.getRow());
    }

    @Test
    public void testConvertNumToColString() {
        short col = 702;
        String collRef = new CellLocation(0, col).formatAsString();
        assertEquals("AAA1", collRef);

        short col2 = 0;
        String collRef2 = new CellLocation(0, col2).formatAsString();
        assertEquals("A1", collRef2);

        short col3 = 27;
        String collRef3 = new CellLocation(0, col3).formatAsString();
        assertEquals("AB1", collRef3);

        short col4 = 2080;
        String collRef4 = new CellLocation(0, col4).formatAsString();
        assertEquals("CBA1", collRef4);
    }

    @Test
    public void testBadRowNumber() {
        confirmCrInRange(true, "A", "1");
        confirmCrInRange(true, "IV", "65536");
        confirmCrInRange(false, "IV", "65537");
        confirmCrInRange(false, "IW", "65536");

        assertFalse("Identified bug 47312a", CellLocation.cellReferenceIsWithinRange("B", "0"));

        confirmCrInRange(false, "A", "0");
    }

    @Test
    public void testInvalidReference() {
        try {
            new CellLocation("Sheet1!#REF!");
            fail("Shouldn't be able to create a #REF! refence");
        } catch (IllegalArgumentException expected) {
            // expected here
        }

        try {
            new CellLocation("'MySheetName'!#REF!");
            fail("Shouldn't be able to create a #REF! refence");
        } catch (IllegalArgumentException expected) {
            // expected here
        }

        try {
            new CellLocation("#REF!");
            fail("Shouldn't be able to create a #REF! refence");
        } catch (IllegalArgumentException expected) {
            // expected here
        }
    }

    private static void confirmCrInRange(boolean expResult, String colStr, String rowStr) {
        if (expResult == CellLocation.cellReferenceIsWithinRange(colStr, rowStr)) {
            return;
        }
        fail("expected (c='" + colStr + "', r='" + rowStr + "' to be "
                + (expResult ? "within" : "out of") + " bounds");
    }

    @Test
    public void testConvertColStringToIndex() {
        assertEquals(0, CellLocation.convertColStringToIndex("A"));
        assertEquals(1, CellLocation.convertColStringToIndex("B"));
        assertEquals(14, CellLocation.convertColStringToIndex("O"));
        assertEquals(701, CellLocation.convertColStringToIndex("ZZ"));
        assertEquals(18252, CellLocation.convertColStringToIndex("ZZA"));

        assertEquals(0, CellLocation.convertColStringToIndex("$A"));
        assertEquals(1, CellLocation.convertColStringToIndex("$B"));

        try {
            CellLocation.convertColStringToIndex("A$");
            fail("Should throw exception here");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("A$"));
        }
    }

    @Test
    public void testConvertNumColColString() {
        assertEquals("A", CellLocation.convertNumToColString(0));
        assertEquals("AV", CellLocation.convertNumToColString(47));
        assertEquals("AW", CellLocation.convertNumToColString(48));
        assertEquals("BF", CellLocation.convertNumToColString(57));

        assertEquals("", CellLocation.convertNumToColString(-1));
        assertEquals("", CellLocation.convertNumToColString(Integer.MIN_VALUE));
        assertEquals("", CellLocation.convertNumToColString(Integer.MAX_VALUE));
        assertEquals("FXSHRXW", CellLocation.convertNumToColString(Integer.MAX_VALUE - 1));
    }

    /**
     * bug 59684: separateRefParts fails on entire-column references
     */
    @Test
    public void entireColumnReferences() {
        CellLocation ref = new CellLocation("HOME!$169");
        assertEquals("HOME", ref.getSheetName());
        assertEquals(168, ref.getRow());
        assertEquals(-1, ref.getCol());
        assertTrue("row absolute", ref.isRowAbsolute());
        //assertFalse("column absolute/relative is undefined", ref.isColAbsolute());
    }

    @Test
    public void getSheetName() {
        assertEquals(null, new CellLocation("A5").getSheetName());
        assertEquals(null, new CellLocation(null, 0, 0, false, false).getSheetName());
        // FIXME: CellLocation is inconsistent
        assertEquals("", new CellLocation("", 0, 0, false, false).getSheetName());
        assertEquals("Sheet1", new CellLocation("Sheet1!A5").getSheetName());
        assertEquals("Sheet 1", new CellLocation("'Sheet 1'!A5").getSheetName());
    }

    @Test
    public void testToString() {
        CellLocation ref = new CellLocation("'Sheet 1'!A5");
        assertEquals("excelium.common.ss.CellLocation ['Sheet 1'!A5]", ref.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        CellLocation ref1 = new CellLocation("'Sheet 1'!A5");
        CellLocation ref2 = new CellLocation("Sheet 1", 4, 0, false, false);
        assertEquals("equals", ref1, ref1);
        assertEquals("equals", ref1, ref2);
        assertEquals("hash code", ref1.hashCode(), ref2.hashCode());

        //noinspection ObjectEqualsNull
        assertFalse("null", ref1.equals(null));
        assertFalse("3D vs 2D", ref1.equals(new CellLocation("A5")));
        //noinspection EqualsBetweenInconvertibleTypes
        assertFalse("type", ref1.equals(new Integer(0)));
    }

    @Test
    public void isRowWithinRange() {
        assertFalse("1 before first row", CellLocation.isRowWithinRange("0"));
        assertTrue("first row", CellLocation.isRowWithinRange("1"));
        assertTrue("last row", CellLocation.isRowWithinRange("65536"));
        assertFalse("1 beyond last row", CellLocation.isRowWithinRange("65537"));

        // int versions of above, using 0-based indices
        assertFalse("1 before first row", CellLocation.isRowWithinRange(-1));
        assertTrue("first row", CellLocation.isRowWithinRange(0));
        assertTrue("last row", CellLocation.isRowWithinRange(65535));
        assertFalse("1 beyond last row", CellLocation.isRowWithinRange(65536));
    }

    @Test(expected = NumberFormatException.class)
    public void isRowWithinRangeNonInteger_BigNumber() {
        String rowNum = "4000000000";
        CellLocation.isRowWithinRange(rowNum);
    }

    @Test(expected = NumberFormatException.class)
    public void isRowWithinRangeNonInteger_Alpha() {
        String rowNum = "NotANumber";
        CellLocation.isRowWithinRange(rowNum);
    }

    @Test
    public void isColWithinRange() {
        assertTrue("(empty)", CellLocation.isColumnWithinRange(""));
        assertTrue("first column (A)", CellLocation.isColumnWithinRange("A"));
        assertTrue("last column (IV)", CellLocation.isColumnWithinRange("IV"));
        assertFalse("1 beyond last column (IW)", CellLocation.isColumnWithinRange("IW"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void unquotedSheetName() {
        new CellLocation("'Sheet 1!A5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void mismatchedQuotesSheetName() {
        new CellLocation("Sheet 1!A5");
    }

    @Test
    public void escapedSheetName() {
        String escapedName = "'Don''t Touch'!A5";
        String unescapedName = "'Don't Touch'!A5";
        new CellLocation(escapedName);
        try {
            new CellLocation(unescapedName);
            fail("Sheet names containing apostrophe's must be escaped via a repeated apostrophe");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().startsWith("Bad sheet name quote escaping: "));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeRow() {
        new CellLocation("sheet", -2, 0, false, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeColumn() {
        new CellLocation("sheet", 0, -2, false, false);
    }

    @Test
    public void testColNumConversion() {
        assertEquals(0, CellLocation.convertColStringToIndex("A"));
        assertEquals(1, CellLocation.convertColStringToIndex("B"));
        assertEquals(25, CellLocation.convertColStringToIndex("Z"));
        assertEquals(26, CellLocation.convertColStringToIndex("AA"));
        assertEquals(27, CellLocation.convertColStringToIndex("AB"));
        assertEquals(51, CellLocation.convertColStringToIndex("AZ"));
        assertEquals(701, CellLocation.convertColStringToIndex("ZZ"));
        assertEquals(702, CellLocation.convertColStringToIndex("AAA"));
        assertEquals(18277, CellLocation.convertColStringToIndex("ZZZ"));

        assertEquals("A", CellLocation.convertNumToColString(0));
        assertEquals("B", CellLocation.convertNumToColString(1));
        assertEquals("Z", CellLocation.convertNumToColString(25));
        assertEquals("AA", CellLocation.convertNumToColString(26));
        assertEquals("ZZ", CellLocation.convertNumToColString(701));
        assertEquals("AAA", CellLocation.convertNumToColString(702));
        assertEquals("ZZZ", CellLocation.convertNumToColString(18277));

        // Absolute references are allowed for the string ones
        assertEquals(0, CellLocation.convertColStringToIndex("$A"));
        assertEquals(25, CellLocation.convertColStringToIndex("$Z"));
        assertEquals(26, CellLocation.convertColStringToIndex("$AA"));

        // $ sign isn't allowed elsewhere though
        try {
            CellLocation.convertColStringToIndex("A$B$");
            fail("Column reference is invalid and shouldn't be accepted");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAbsRef1() {
        CellLocation cf = new CellLocation("$B$5");
        confirmCell(cf, null, 4, 1, true, true, "$B$5");
    }

    @Test
    public void testAbsRef2() {
        CellLocation cf = new CellLocation(4, 1, true, true);
        confirmCell(cf, null, 4, 1, true, true, "$B$5");
    }

    @Test
    public void testAbsRef3() {
        CellLocation cf = new CellLocation("B$5");
        confirmCell(cf, null, 4, 1, true, false, "B$5");
    }

    @Test
    public void testAbsRef4() {
        CellLocation cf = new CellLocation(4, 1, true, false);
        confirmCell(cf, null, 4, 1, true, false, "B$5");
    }

    @Test
    public void testAbsRef5() {
        CellLocation cf = new CellLocation("$B5");
        confirmCell(cf, null, 4, 1, false, true, "$B5");
    }

    @Test
    public void testAbsRef6() {
        CellLocation cf = new CellLocation(4, 1, false, true);
        confirmCell(cf, null, 4, 1, false, true, "$B5");
    }

    @Test
    public void testAbsRef7() {
        CellLocation cf = new CellLocation("B5");
        confirmCell(cf, null, 4, 1, false, false, "B5");
    }

    @Test
    public void testAbsRef8() {
        CellLocation cf = new CellLocation(4, 1, false, false);
        confirmCell(cf, null, 4, 1, false, false, "B5");
    }

    @Test
    public void testSpecialSheetNames() {
        CellLocation cf;
        cf = new CellLocation("'profit + loss'!A1");
        confirmCell(cf, "profit + loss", 0, 0, false, false, "'profit + loss'!A1");

        cf = new CellLocation("'O''Brien''s Sales'!A1");
        confirmCell(cf, "O'Brien's Sales", 0, 0, false, false, "'O''Brien''s Sales'!A1");

        cf = new CellLocation("'Amazing!'!A1");
        confirmCell(cf, "Amazing!", 0, 0, false, false, "'Amazing!'!A1");
    }

    /* package */
    static void confirmCell(CellLocation cf, String expSheetName, int expRow,
                            int expCol, boolean expIsRowAbs, boolean expIsColAbs, String expText) {

        assertEquals(expSheetName, cf.getSheetName());
        assertEquals("row index is wrong", expRow, cf.getRow());
        assertEquals("col index is wrong", expCol, cf.getCol());
        assertEquals("isRowAbsolute is wrong", expIsRowAbs, cf.isRowAbsolute());
        assertEquals("isColAbsolute is wrong", expIsColAbs, cf.isColAbsolute());
        assertEquals("text is wrong", expText, cf.formatAsString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSeparateRefPartsInvalid() {
        new CellLocation("Sheet1!1A");
    }
}
