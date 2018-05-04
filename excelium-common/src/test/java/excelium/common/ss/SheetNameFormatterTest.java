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
 * Tests for {@link SheetNameFormatter}
 *
 * @author Josh Micich
 */
public final class SheetNameFormatterTest extends TestCase {

    private static void confirmFormat(String rawSheetName, String expectedSheetNameEncoding) {
        assertEquals(expectedSheetNameEncoding, SheetNameFormatter.format(rawSheetName));
    }

    private static void confirmAppendFormat(String rawSheetName, String expectedSheetNameEncoding) {
        StringBuffer stringBuffer = new StringBuffer();
        SheetNameFormatter.appendFormat(stringBuffer, rawSheetName);
        assertEquals(expectedSheetNameEncoding, stringBuffer.toString());
    }

    private static void confirmAppendFormatWithWorkbook(String rawWorkbookName, String rawSheetName, String expectedSheetNameEncoding) {
        StringBuffer stringBuffer = new StringBuffer();
        SheetNameFormatter.appendFormat(stringBuffer, rawWorkbookName, rawSheetName);
        assertEquals(expectedSheetNameEncoding, stringBuffer.toString());

        StringBuilder stringBuilder = new StringBuilder();
        SheetNameFormatter.appendFormat(stringBuilder, rawWorkbookName, rawSheetName);
        assertEquals(expectedSheetNameEncoding, stringBuilder.toString());
    }

    /**
     * Tests main public method 'format'
     */
    public void testFormat() {

        confirmFormat("abc", "abc");
        confirmFormat("123", "'123'");

        confirmFormat("my sheet", "'my sheet'"); // space
        confirmFormat("A:MEM", "'A:MEM'"); // colon

        confirmFormat("O'Brian", "'O''Brian'"); // single quote gets doubled


        confirmFormat("3rdTimeLucky", "'3rdTimeLucky'"); // digit in first pos
        confirmFormat("_", "_"); // plain underscore OK
        confirmFormat("my_3rd_sheet", "my_3rd_sheet"); // underscores and digits OK
        confirmFormat("A12220", "'A12220'");
        confirmFormat("TAXRETURN19980415", "TAXRETURN19980415");
    }

    public void testBooleanLiterals() {
        confirmFormat("TRUE", "'TRUE'");
        confirmFormat("FALSE", "'FALSE'");
        confirmFormat("True", "'True'");
        confirmFormat("fAlse", "'fAlse'");

        confirmFormat("Yes", "Yes");
        confirmFormat("No", "No");
    }

    private static void confirmCellNameMatch(String rawSheetName, boolean expected) {
        assertEquals(expected, SheetNameFormatter.nameLooksLikePlainCellReference(rawSheetName));
    }

    /**
     * Tests functionality to determine whether a sheet name containing only letters and digits
     * would look (to Excel) like a cell name.
     */
    public void testLooksLikePlainCellReference() {

        confirmCellNameMatch("A1", true);
        confirmCellNameMatch("a111", true);
        confirmCellNameMatch("AA", false);
        confirmCellNameMatch("aa1", true);
        confirmCellNameMatch("A1A", false);
        confirmCellNameMatch("A1A1", false);
        confirmCellNameMatch("Sh3", false);
        confirmCellNameMatch("SALES20080101", false); // out of range
    }

    private static void confirmCellRange(String text, int numberOfPrefixLetters, boolean expected) {
        String prefix = text.substring(0, numberOfPrefixLetters);
        String suffix = text.substring(numberOfPrefixLetters);
        assertEquals(expected, SheetNameFormatter.cellReferenceIsWithinRange(prefix, suffix));
    }

    /**
     * Tests exact boundaries for names that look very close to cell names (i.e. contain 1 or more
     * letters followed by one or more digits).
     */
    public void testCellRange() {
        confirmCellRange("A1", 1, true);
        confirmCellRange("a111", 1, true);
        confirmCellRange("A65536", 1, true);
        confirmCellRange("A65537", 1, false);
        confirmCellRange("iv1", 2, true);
        confirmCellRange("IW1", 2, false);
        confirmCellRange("AAA1", 3, false);
        confirmCellRange("a111", 1, true);
        confirmCellRange("Sheet1", 6, false);
        confirmCellRange("iV65536", 2, true);  // max cell in Excel 97-2003
        confirmCellRange("IW65537", 2, false);
    }

    public void testAppendFormat() {

        confirmAppendFormat("abc", "abc");
        confirmAppendFormat("123", "'123'");

        confirmAppendFormat("my sheet", "'my sheet'"); // space
        confirmAppendFormat("A:MEM", "'A:MEM'"); // colon

        confirmAppendFormat("O'Brian", "'O''Brian'"); // single quote gets doubled


        confirmAppendFormat("3rdTimeLucky", "'3rdTimeLucky'"); // digit in first pos
        confirmAppendFormat("_", "_"); // plain underscore OK
        confirmAppendFormat("my_3rd_sheet", "my_3rd_sheet"); // underscores and digits OK
        confirmAppendFormat("A12220", "'A12220'");
        confirmAppendFormat("TAXRETURN19980415", "TAXRETURN19980415");
    }

    public void testAppendFormatWithWorkbook() {

        confirmAppendFormatWithWorkbook("Workbook", "abc", "[Workbook]abc");
        confirmAppendFormatWithWorkbook("Workbook", "123", "'[Workbook]123'");

        confirmAppendFormatWithWorkbook("Workbook", "my sheet", "'[Workbook]my sheet'"); // space
        confirmAppendFormatWithWorkbook("Workbook", "A:MEM", "'[Workbook]A:MEM'"); // colon

        confirmAppendFormatWithWorkbook("Workbook", "O'Brian", "'[Workbook]O''Brian'"); // single quote gets doubled


        confirmAppendFormatWithWorkbook("Workbook", "3rdTimeLucky", "'[Workbook]3rdTimeLucky'"); // digit in first pos
        confirmAppendFormatWithWorkbook("Workbook", "_", "[Workbook]_"); // plain underscore OK
        confirmAppendFormatWithWorkbook("Workbook", "my_3rd_sheet", "[Workbook]my_3rd_sheet"); // underscores and digits OK
        confirmAppendFormatWithWorkbook("Workbook", "A12220", "'[Workbook]A12220'");
        confirmAppendFormatWithWorkbook("Workbook", "TAXRETURN19980415", "[Workbook]TAXRETURN19980415");
    }
}
