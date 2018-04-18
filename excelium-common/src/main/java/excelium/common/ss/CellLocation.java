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

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.endsWithIgnoreCase;

/**
 * <p>Common conversion functions between Excel style A1, C27 style
 * cell references, and POI usermodel style row=0, column=0
 * style references. Handles sheet-based and sheet-free references
 * as well, eg "Sheet1!A1" and "$B$72"</p>
 */
public class CellLocation {

    /**
     * The character ($) that signifies a row or column value is absolute instead of relative
     */
    private static final char ABSOLUTE_REFERENCE_MARKER = '$';
    /**
     * The character (!) that separates sheet names from cell references
     */
    private static final char SHEET_NAME_DELIMITER = '!';
    /**
     * The character (') used to quote sheet names when they contain special characters
     */
    private static final char SPECIAL_NAME_DELIMITER = '\'';

    /**
     * Matches a run of one or more letters followed by a run of one or more digits.
     * Both the letter and number groups are optional.
     * The run of letters is group 1 and the run of digits is group 2.
     * Each group may optionally be prefixed with a single '$'.
     */
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Z]+)?" + "(\\$?[0-9]+)?", Pattern.CASE_INSENSITIVE);

    // FIXME: _sheetName may be null, depending on the entry point.
    // Perhaps it would be better to declare _sheetName is never null, using an empty string to represent a 2D reference.
    private final String _sheetName;
    private final int _rowIndex;
    private final int _colIndex;
    private final boolean _isRowAbs;
    private final boolean _isColAbs;

    /**
     * Create an cell ref from a string representation.  Sheet names containing special characters should be
     * delimited and escaped as per normal syntax rules for formulas.
     */
    public CellLocation(String cellRef) {
        if (endsWithIgnoreCase(cellRef, "#REF!")) {
            throw new IllegalArgumentException("Cell reference invalid: " + cellRef);
        }

        CellRefParts parts = separateRefParts(cellRef);
        _sheetName = parts.sheetName;

        String colRef = parts.colRef;
        _isColAbs = (colRef.length() > 0) && colRef.charAt(0) == '$';
        if (_isColAbs) {
            colRef = colRef.substring(1);
        }
        if (colRef.length() == 0) {
            _colIndex = -1;
        } else {
            _colIndex = convertColStringToIndex(colRef);
        }

        String rowRef = parts.rowRef;
        _isRowAbs = (rowRef.length() > 0) && rowRef.charAt(0) == '$';
        if (_isRowAbs) {
            rowRef = rowRef.substring(1);
        }
        if (rowRef.length() == 0) {
            _rowIndex = -1;
        } else {
            // throws NumberFormatException if rowRef is not convertable to an int
            _rowIndex = Integer.parseInt(rowRef) - 1; // -1 to convert 1-based to zero-based
        }
    }

    public CellLocation(int pRow, int pCol) {
        this(pRow, pCol, false, false);
    }

    public CellLocation(int pRow, short pCol) {
        this(pRow, pCol & 0xFFFF, false, false);
    }

    public CellLocation(int pRow, int pCol, boolean pAbsRow, boolean pAbsCol) {
        this(null, pRow, pCol, pAbsRow, pAbsCol);
    }

    public CellLocation(String pSheetName, int pRow, int pCol, boolean pAbsRow, boolean pAbsCol) {
        // TODO - "-1" is a special value being temporarily used for whole row and whole column area references.
        // so these checks are currently N.Q.R.
        if (pRow < -1) {
            throw new IllegalArgumentException("row index may not be negative, but had " + pRow);
        }
        if (pCol < -1) {
            throw new IllegalArgumentException("column index may not be negative, but had " + pCol);
        }
        _sheetName = pSheetName;
        _rowIndex = pRow;
        _colIndex = pCol;
        _isRowAbs = pAbsRow;
        _isColAbs = pAbsCol;
    }

    public int getRow() {
        return _rowIndex;
    }

    public short getCol() {
        return (short) _colIndex;
    }

    public boolean isRowAbsolute() {
        return _isRowAbs;
    }

    public boolean isColAbsolute() {
        return _isColAbs;
    }

    /**
     * @return possibly <code>null</code> if this is a 2D reference.  Special characters are not
     * escaped or delimited
     */
    public String getSheetName() {
        return _sheetName;
    }

    public static boolean isPartAbsolute(String part) {
        return part.charAt(0) == ABSOLUTE_REFERENCE_MARKER;
    }

    /**
     * takes in a column reference portion of a CellRef and converts it from
     * ALPHA-26 number format to 0-based base 10.
     * 'A' -&gt; 0
     * 'Z' -&gt; 25
     * 'AA' -&gt; 26
     * 'IV' -&gt; 255
     *
     * @return zero based column index
     */
    public static int convertColStringToIndex(String ref) {
        int retval = 0;
        char[] refs = ref.toUpperCase(Locale.ROOT).toCharArray();
        for (int k = 0; k < refs.length; k++) {
            char thechar = refs[k];
            if (thechar == ABSOLUTE_REFERENCE_MARKER) {
                if (k != 0) {
                    throw new IllegalArgumentException("Bad col ref format '" + ref + "'");
                }
                continue;
            }

            // Character is uppercase letter, find relative value to A
            retval = (retval * 26) + (thechar - 'A' + 1);
        }
        return retval - 1;
    }

    /**
     * Used to decide whether a name of the form "[A-Z]*[0-9]*" that appears in a formula can be
     * interpreted as a cell reference.  Names of that form can be also used for sheets and/or
     * named ranges, and in those circumstances, the question of whether the potential cell
     * reference is valid (in range) becomes important.
     * <p>
     * Note - that the maximum sheet size varies across Excel versions:
     * <p>
     * <blockquote><table border="0" cellpadding="1" cellspacing="0"
     * summary="Notable cases.">
     * <tr><th>Version&nbsp;&nbsp;</th><th>File Format&nbsp;&nbsp;</th>
     * <th>Last Column&nbsp;&nbsp;</th><th>Last Row</th></tr>
     * <tr><td>97-2003</td><td>BIFF8</td><td>"IV" (2^8)</td><td>65536 (2^14)</td></tr>
     * <tr><td>2007</td><td>BIFF12</td><td>"XFD" (2^14)</td><td>1048576 (2^20)</td></tr>
     * </table></blockquote>
     * POI currently targets BIFF8 (Excel 97-2003), so the following behaviour can be observed for
     * this method:
     * <blockquote><table border="0" cellpadding="1" cellspacing="0"
     * summary="Notable cases.">
     * <tr><th>Input&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
     * <th>Result&nbsp;</th></tr>
     * <tr><td>"A", "1"</td><td>true</td></tr>
     * <tr><td>"a", "111"</td><td>true</td></tr>
     * <tr><td>"A", "65536"</td><td>true</td></tr>
     * <tr><td>"A", "65537"</td><td>false</td></tr>
     * <tr><td>"iv", "1"</td><td>true</td></tr>
     * <tr><td>"IW", "1"</td><td>false</td></tr>
     * <tr><td>"AAA", "1"</td><td>false</td></tr>
     * <tr><td>"a", "111"</td><td>true</td></tr>
     * <tr><td>"Sheet", "1"</td><td>false</td></tr>
     * </table></blockquote>
     *
     * @param colStr a string of only letter characters
     * @param rowStr a string of only digit characters
     * @return <code>true</code> if the row and col parameters are within range of a BIFF8 spreadsheet.
     */
    public static boolean cellReferenceIsWithinRange(String colStr, String rowStr) {
        if (!isColumnWithinRange(colStr)) {
            return false;
        }
        return isRowWithinRange(rowStr);
    }

    public static boolean isColumnWithinRange(String colStr) {
        // Equivalent to 0 <= CellLocation.convertColStringToIndex(colStr) <= 255

        String lastCol = convertNumToColString(255);
        int lastColLength = lastCol.length();

        int numberOfLetters = colStr.length();
        if (numberOfLetters > lastColLength) {
            // "Sheet1" case etc
            return false; // that was easy
        }
        if (numberOfLetters == lastColLength) {
            if (colStr.toUpperCase(Locale.ROOT).compareTo(lastCol) > 0) {
                return false;
            }
        } else {
            // apparent column name has less chars than max
            // no need to check range
        }
        return true;
    }

    /**
     * Determines whether {@code rowStr} is a valid row number for a given SpreadsheetVersion.
     *
     * @param rowStr the numeric portion of an A1-style cell reference (1-based index)
     * @throws NumberFormatException if rowStr is not parseable as an integer
     */
    public static boolean isRowWithinRange(String rowStr) {
        final int rowNum = Integer.parseInt(rowStr) - 1;
        return isRowWithinRange(rowNum);
    }

    /**
     * Determines whether {@code row} is a valid row number for a given SpreadsheetVersion.
     *
     * @param rowNum the row number (0-based index)
     * @since 3.17 beta 1
     */
    public static boolean isRowWithinRange(int rowNum) {
        return 0 <= rowNum && rowNum <= 65535;
    }

    private static final class CellRefParts {
        final String sheetName;
        final String rowRef;
        final String colRef;

        private CellRefParts(String sheetName, String rowRef, String colRef) {
            this.sheetName = sheetName;
            this.rowRef = (rowRef != null) ? rowRef : "";
            this.colRef = (colRef != null) ? colRef : "";
        }
    }

    /**
     * Separates the sheet name, row, and columns from a cell reference string.
     *
     * @param reference is a string that identifies a cell within the sheet or workbook
     *                  reference may not refer to a cell in an external workbook
     *                  reference may be absolute or relative.
     * @return String array of sheetName, column (in ALPHA-26 format), and row
     * output column or row elements will contain absolute reference markers if they
     * existed in the input reference.
     */
    private static CellRefParts separateRefParts(String reference) {
        int plingPos = reference.lastIndexOf(SHEET_NAME_DELIMITER);
        final String sheetName = parseSheetName(reference, plingPos);
        String cell = reference.substring(plingPos + 1).toUpperCase(Locale.ROOT);
        Matcher matcher = CELL_REF_PATTERN.matcher(cell);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid CellLocation: " + reference);
        }
        String col = matcher.group(1);
        String row = matcher.group(2);

        return new CellRefParts(sheetName, row, col);
    }

    private static String parseSheetName(String reference, int indexOfSheetNameDelimiter) {
        if (indexOfSheetNameDelimiter < 0) {
            return null;
        }

        boolean isQuoted = reference.charAt(0) == SPECIAL_NAME_DELIMITER;
        if (!isQuoted) {
            // sheet names with spaces must be quoted
            if (!reference.contains(" ")) {
                return reference.substring(0, indexOfSheetNameDelimiter);
            } else {
                throw new IllegalArgumentException("Sheet names containing spaces must be quoted: (" + reference + ")");
            }
        }
        int lastQuotePos = indexOfSheetNameDelimiter - 1;
        if (reference.charAt(lastQuotePos) != SPECIAL_NAME_DELIMITER) {
            throw new IllegalArgumentException("Mismatched quotes: (" + reference + ")");
        }

        // TODO - refactor cell reference parsing logic to one place.
        // Current known incarnations:
        //   FormulaParser.GetName()
        //   CellLocation.parseSheetName() (here)
        //   AreaReference.separateAreaRefs()
        //   SheetNameFormatter.format() (inverse)

        StringBuffer sb = new StringBuffer(indexOfSheetNameDelimiter);

        for (int i = 1; i < lastQuotePos; i++) { // Note boundaries - skip outer quotes
            char ch = reference.charAt(i);
            if (ch != SPECIAL_NAME_DELIMITER) {
                sb.append(ch);
                continue;
            }
            if (i + 1 < lastQuotePos && reference.charAt(i + 1) == SPECIAL_NAME_DELIMITER) {
                // two consecutive quotes is the escape sequence for a single one
                i++; // skip this and keep parsing the special name
                sb.append(ch);
                continue;
            }
            throw new IllegalArgumentException("Bad sheet name quote escaping: (" + reference + ")");
        }
        return sb.toString();
    }

    /**
     * Takes in a 0-based base-10 column and returns a ALPHA-26
     * representation.
     * eg {@code convertNumToColString(3)} returns {@code "D"}
     */
    public static String convertNumToColString(int col) {
        // Excel counts column A as the 1st column, we
        //  treat it as the 0th one
        int excelColNum = col + 1;

        StringBuilder colRef = new StringBuilder(2);
        int colRemain = excelColNum;

        while (colRemain > 0) {
            int thisPart = colRemain % 26;
            if (thisPart == 0) {
                thisPart = 26;
            }
            colRemain = (colRemain - thisPart) / 26;

            // The letter A is at 65
            char colChar = (char) (thisPart + 64);
            colRef.insert(0, colChar);
        }

        return colRef.toString();
    }

    /**
     * Returns a text representation of this cell reference.
     * <p>
     * Example return values:
     * <table border="0" cellpadding="1" cellspacing="0" summary="Example return values">
     * <tr><th align='left'>Result</th><th align='left'>Comment</th></tr>
     * <tr><td>A1</td><td>Cell reference without sheet</td></tr>
     * <tr><td>Sheet1!A1</td><td>Standard sheet name</td></tr>
     * <tr><td>'O''Brien''s Sales'!A1'&nbsp;</td><td>Sheet name with special characters</td></tr>
     * </table>
     *
     * @return the text representation of this cell reference as it would appear in a formula.
     */
    public String formatAsString() {
        StringBuilder sb = new StringBuilder(32);
        if (_sheetName != null) {
            SheetNameFormatter.appendFormat(sb, _sheetName);
            sb.append(SHEET_NAME_DELIMITER);
        }
        appendCellReference(sb);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(64);
        sb.append(getClass().getName()).append(" [");
        sb.append(formatAsString());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns the three parts of the cell reference, the
     * Sheet name (or null if none supplied), the 1 based
     * row number, and the A based column letter.
     * This will not include any markers for absolute
     * references, so use {@link #formatAsString()}
     * to properly turn references into strings.
     *
     * @return String array of { sheetName, rowString, colString }
     */
    public String[] getCellRefParts() {
        return new String[]{
                _sheetName,
                Integer.toString(_rowIndex + 1),
                convertNumToColString(_colIndex)
        };
    }

    /**
     * Appends cell reference with '$' markers for absolute values as required.
     * Sheet name is not included.
     */
    /* package */ void appendCellReference(StringBuilder sb) {
        if (_colIndex != -1) {
            if (_isColAbs) {
                sb.append(ABSOLUTE_REFERENCE_MARKER);
            }
            sb.append(convertNumToColString(_colIndex));
        }
        if (_rowIndex != -1) {
            if (_isRowAbs) {
                sb.append(ABSOLUTE_REFERENCE_MARKER);
            }
            sb.append(_rowIndex + 1);
        }
    }

    /**
     * Checks whether this cell reference is equal to another object.
     * <p>
     * Two cells references are assumed to be equal if their string representations
     * ({@link #formatAsString()}  are equal.
     * </p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CellLocation)) {
            return false;
        }
        CellLocation cr = (CellLocation) o;
        return _rowIndex == cr._rowIndex
                && _colIndex == cr._colIndex
                && _isRowAbs == cr._isRowAbs
                && _isColAbs == cr._isColAbs
                && ((_sheetName == null)
                ? (cr._sheetName == null)
                : _sheetName.equals(cr._sheetName));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + _rowIndex;
        result = 31 * result + _colIndex;
        result = 31 * result + (_isRowAbs ? 1 : 0);
        result = 31 * result + (_isColAbs ? 1 : 0);
        result = 31 * result + (_sheetName == null ? 0 : _sheetName.hashCode());
        return result;
    }
}
