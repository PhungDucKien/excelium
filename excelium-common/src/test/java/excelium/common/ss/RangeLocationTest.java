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

import junit.framework.TestCase;

/**
 * Test for {@link RangeLocation} handling of max rows.
 *
 * @author David North
 */
public class RangeLocationTest extends TestCase {

    public void testWholeColumn() {
        RangeLocation oldStyle = RangeLocation.getWholeColumn("A", "B");
        assertEquals(0, oldStyle.getFirstCell().getCol());
        assertEquals(0, oldStyle.getFirstCell().getRow());
        assertEquals(1, oldStyle.getLastCell().getCol());
        assertEquals(65535, oldStyle.getLastCell().getRow());
        assertTrue(oldStyle.isWholeColumnReference());

        RangeLocation oldStyleNonWholeColumn = new RangeLocation("A1:B23");
        assertFalse(oldStyleNonWholeColumn.isWholeColumnReference());

        RangeLocation newStyle = RangeLocation.getWholeColumn("A", "B");
        assertEquals(0, newStyle.getFirstCell().getCol());
        assertEquals(0, newStyle.getFirstCell().getRow());
        assertEquals(1, newStyle.getLastCell().getCol());
        assertEquals(65535, newStyle.getLastCell().getRow());
        assertTrue(newStyle.isWholeColumnReference());

        RangeLocation newStyleNonWholeColumn = new RangeLocation("A1:B23");
        assertFalse(newStyleNonWholeColumn.isWholeColumnReference());
    }

    public void testWholeRow() {
        RangeLocation oldStyle = RangeLocation.getWholeRow("1", "2");
        assertEquals(0, oldStyle.getFirstCell().getCol());
        assertEquals(0, oldStyle.getFirstCell().getRow());
        assertEquals(255, oldStyle.getLastCell().getCol());
        assertEquals(1, oldStyle.getLastCell().getRow());

        RangeLocation newStyle = RangeLocation.getWholeRow("1", "2");
        assertEquals(0, newStyle.getFirstCell().getCol());
        assertEquals(0, newStyle.getFirstCell().getRow());
        assertEquals(255, newStyle.getLastCell().getCol());
        assertEquals(1, newStyle.getLastCell().getRow());
    }

    public void testAreaRef1() {
        RangeLocation ar = new RangeLocation("$A$1:$B$2");
        assertFalse("Two cells expected", ar.isSingleCell());
        CellLocation cf = ar.getFirstCell();
        assertTrue("row is 4",cf.getRow()==0);
        assertTrue("col is 1",cf.getCol()==0);
        assertTrue("row is abs",cf.isRowAbsolute());
        assertTrue("col is abs",cf.isColAbsolute());
        assertTrue("string is $A$1",cf.formatAsString().equals("$A$1"));

        cf = ar.getLastCell();
        assertTrue("row is 4",cf.getRow()==1);
        assertTrue("col is 1",cf.getCol()==1);
        assertTrue("row is abs",cf.isRowAbsolute());
        assertTrue("col is abs",cf.isColAbsolute());
        assertTrue("string is $B$2",cf.formatAsString().equals("$B$2"));

        CellLocation[] refs = ar.getAllReferencedCells();
        assertEquals(4, refs.length);

        assertEquals(0, refs[0].getRow());
        assertEquals(0, refs[0].getCol());
        assertNull(refs[0].getSheetName());

        assertEquals(0, refs[1].getRow());
        assertEquals(1, refs[1].getCol());
        assertNull(refs[1].getSheetName());

        assertEquals(1, refs[2].getRow());
        assertEquals(0, refs[2].getCol());
        assertNull(refs[2].getSheetName());

        assertEquals(1, refs[3].getRow());
        assertEquals(1, refs[3].getCol());
        assertNull(refs[3].getSheetName());
    }

    /**
     * References failed when sheet names were being used
     * Reported by Arne.Clauss@gedas.de
     */
    public void testReferenceWithSheet() {
        RangeLocation ar;

        ar = new RangeLocation("Tabelle1!B5:B5");
        assertTrue(ar.isSingleCell());
        CellLocationTest.confirmCell(ar.getFirstCell(), "Tabelle1", 4, 1, false, false, "Tabelle1!B5");

        assertEquals(1, ar.getAllReferencedCells().length);


        ar = new RangeLocation("Tabelle1!$B$5:$B$7");
        assertFalse(ar.isSingleCell());

        CellLocationTest.confirmCell(ar.getFirstCell(), "Tabelle1", 4, 1, true, true, "Tabelle1!$B$5");
        CellLocationTest.confirmCell(ar.getLastCell(), "Tabelle1", 6, 1, true, true, "Tabelle1!$B$7");

        // And all that make it up
        CellLocation[] allCells = ar.getAllReferencedCells();
        assertEquals(3, allCells.length);
        CellLocationTest.confirmCell(allCells[0], "Tabelle1", 4, 1, true, true, "Tabelle1!$B$5");
        CellLocationTest.confirmCell(allCells[1], "Tabelle1", 5, 1, true, true, "Tabelle1!$B$6");
        CellLocationTest.confirmCell(allCells[2], "Tabelle1", 6, 1, true, true, "Tabelle1!$B$7");
    }

    public void testContiguousReferences() {
        String refSimple = "$C$10:$C$10";
        String ref2D = "$C$10:$D$11";
        String refDCSimple = "$C$10:$C$10,$D$12:$D$12,$E$14:$E$14";
        String refDC2D = "$C$10:$C$11,$D$12:$D$12,$E$14:$E$20";
        String refDC3D = "Tabelle1!$C$10:$C$14,Tabelle1!$D$10:$D$12";

        // Check that we detect as contiguous properly
        assertTrue(RangeLocation.isContiguous(refSimple));
        assertTrue(RangeLocation.isContiguous(ref2D));
        assertFalse(RangeLocation.isContiguous(refDCSimple));
        assertFalse(RangeLocation.isContiguous(refDC2D));
        assertFalse(RangeLocation.isContiguous(refDC3D));

        // Check we can only create contiguous entries
        new RangeLocation(refSimple);
        new RangeLocation(ref2D);
        try {
            new RangeLocation(refDCSimple);
            fail("expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // expected during successful test
        }
        try {
            new RangeLocation(refDC2D);
            fail("expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // expected during successful test
        }
        try {
            new RangeLocation(refDC3D);
            fail("expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // expected during successful test
        }

        // Test that we split as expected
        RangeLocation[] refs;

        refs = RangeLocation.generateContiguous(refSimple);
        assertEquals(1, refs.length);
        assertTrue(refs[0].isSingleCell());
        assertEquals("$C$10", refs[0].formatAsString());

        refs = RangeLocation.generateContiguous(ref2D);
        assertEquals(1, refs.length);
        assertFalse(refs[0].isSingleCell());
        assertEquals("$C$10:$D$11", refs[0].formatAsString());

        refs = RangeLocation.generateContiguous(refDCSimple);
        assertEquals(3, refs.length);
        assertTrue(refs[0].isSingleCell());
        assertTrue(refs[1].isSingleCell());
        assertTrue(refs[2].isSingleCell());
        assertEquals("$C$10", refs[0].formatAsString());
        assertEquals("$D$12", refs[1].formatAsString());
        assertEquals("$E$14", refs[2].formatAsString());

        refs = RangeLocation.generateContiguous(refDC2D);
        assertEquals(3, refs.length);
        assertFalse(refs[0].isSingleCell());
        assertTrue(refs[1].isSingleCell());
        assertFalse(refs[2].isSingleCell());
        assertEquals("$C$10:$C$11", refs[0].formatAsString());
        assertEquals("$D$12", refs[1].formatAsString());
        assertEquals("$E$14:$E$20", refs[2].formatAsString());

        refs = RangeLocation.generateContiguous(refDC3D);
        assertEquals(2, refs.length);
        assertFalse(refs[0].isSingleCell());
        assertFalse(refs[0].isSingleCell());
        assertEquals("Tabelle1!$C$10:$C$14", refs[0].formatAsString());
        assertEquals("Tabelle1!$D$10:$D$12", refs[1].formatAsString());
        assertEquals("Tabelle1", refs[0].getFirstCell().getSheetName());
        assertEquals("Tabelle1", refs[0].getLastCell().getSheetName());
        assertEquals("Tabelle1", refs[1].getFirstCell().getSheetName());
        assertEquals("Tabelle1", refs[1].getLastCell().getSheetName());
    }

    public void testSpecialSheetNames() {
        RangeLocation ar;
        ar = new RangeLocation("'Sheet A'!A1:A1");
        confirmAreaSheetName(ar, "Sheet A", "'Sheet A'!A1");

        ar = new RangeLocation("'Hey! Look Here!'!A1:A1");
        confirmAreaSheetName(ar, "Hey! Look Here!", "'Hey! Look Here!'!A1");

        ar = new RangeLocation("'O''Toole'!A1:B2");
        confirmAreaSheetName(ar, "O'Toole", "'O''Toole'!A1:B2");

        ar = new RangeLocation("'one:many'!A1:B2");
        confirmAreaSheetName(ar, "one:many", "'one:many'!A1:B2");
    }

    private static void confirmAreaSheetName(RangeLocation ar, String sheetName, String expectedFullText) {
        CellLocation[] cells = ar.getAllReferencedCells();
        assertEquals(sheetName, cells[0].getSheetName());
        assertEquals(expectedFullText, ar.formatAsString());
    }

    public void testWholeColumnRefs() {
        confirmWholeColumnRef("A:A", 0, 0, false, false);
        confirmWholeColumnRef("$C:D", 2, 3, true, false);
        confirmWholeColumnRef("AD:$AE", 29, 30, false, true);
    }

    private static void confirmWholeColumnRef(String ref, int firstCol, int lastCol, boolean firstIsAbs, boolean lastIsAbs) {
        RangeLocation ar = new RangeLocation(ref);
        confirmCell(ar.getFirstCell(), 0, firstCol, true, firstIsAbs);
        confirmCell(ar.getLastCell(), 0xFFFF, lastCol, true, lastIsAbs);
    }

    private static void confirmCell(CellLocation cell, int row, int col, boolean isRowAbs,
                                    boolean isColAbs) {
        assertEquals(row, cell.getRow());
        assertEquals(col, cell.getCol());
        assertEquals(isRowAbs, cell.isRowAbsolute());
        assertEquals(isColAbs, cell.isColAbsolute());
    }
}
