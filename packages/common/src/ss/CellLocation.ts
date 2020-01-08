/*
 * Licensed to the Software Freedom Conservancy (SFC) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The SFC licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import SheetNameFormatter from './SheetNameFormatter';

class CellRefParts {
  public readonly sheetName: string | null;
  public readonly rowRef: string;
  public readonly colRef: string;

  constructor(sheetName: string | null, rowRef: string | null, colRef: string | null) {
    this.sheetName = sheetName;
    this.rowRef = rowRef != null ? rowRef : '';
    this.colRef = colRef != null ? colRef : '';
  }
}

/**
 * <p>Common conversion functions between Excel style A1, C27 style
 * cell references, and POI usermodel style row=0, column=0
 * style references. Handles sheet-based and sheet-free references
 * as well, eg "Sheet1!A1" and "$B$72"</p>
 */
export default class CellLocation {
  public static isPartAbsolute(part: string): boolean {
    return part.charAt(0) === CellLocation.ABSOLUTE_REFERENCE_MARKER;
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
  public static convertColStringToIndex(ref: string): number {
    let retval = 0;
    const upperRef = ref.toUpperCase();
    for (let k = 0; k < upperRef.length; k++) {
      const thechar = upperRef.charAt(k);
      if (thechar === CellLocation.ABSOLUTE_REFERENCE_MARKER) {
        if (k !== 0) {
          throw new Error("Bad col ref format '" + ref + "'");
        }
        continue;
      }

      // Character is uppercase letter, find relative value to A
      retval = retval * 26 + (thechar.charCodeAt(0) - 'A'.charCodeAt(0) + 1);
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
  public static cellReferenceIsWithinRange(colStr: string, rowStr: string): boolean {
    if (!this.isColumnWithinRange(colStr)) {
      return false;
    }
    return this.isRowWithinRange(rowStr);
  }

  public static isColumnWithinRange(colStr: string): boolean {
    // Equivalent to 0 <= CellLocation.convertColStringToIndex(colStr) <= 255

    const lastCol = this.convertNumToColString(255);
    const lastColLength = lastCol.length;

    const numberOfLetters = colStr.length;
    if (numberOfLetters > lastColLength) {
      // "Sheet1" case etc
      return false; // that was easy
    }
    if (numberOfLetters === lastColLength) {
      if (colStr.toUpperCase().localeCompare(lastCol) > 0) {
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
   */
  public static isRowWithinRange(rowStr: string): boolean {
    const rowNum = parseInt(rowStr, 10) - 1;
    if (isNaN(rowNum)) {
      throw new Error('Invalid number format');
    }
    return this.isRowNumWithinRange(rowNum);
  }

  /**
   * Determines whether {@code row} is a valid row number for a given SpreadsheetVersion.
   *
   * @param rowNum the row number (0-based index)
   * @since 3.17 beta 1
   */
  public static isRowNumWithinRange(rowNum: number): boolean {
    return 0 <= rowNum && rowNum <= 65535;
  }

  /**
   * Takes in a 0-based base-10 column and returns a ALPHA-26
   * representation.
   * eg {@code convertNumToColString(3)} returns {@code "D"}
   */
  public static convertNumToColString(col: number): string {
    // Excel counts column A as the 1st column, we
    //  treat it as the 0th one
    const excelColNum = col + 1;

    let colRef = '';
    let colRemain = excelColNum;

    while (colRemain > 0) {
      let thisPart = colRemain % 26;
      if (thisPart === 0) {
        thisPart = 26;
      }
      colRemain = (colRemain - thisPart) / 26;

      // The letter A is at 65
      const colChar = String.fromCharCode(thisPart + 64);
      colRef = colChar + colRef;
    }

    return colRef;
  }

  /**
   * The character ($) that signifies a row or column value is absolute instead of relative
   */
  private static readonly ABSOLUTE_REFERENCE_MARKER = '$';
  /**
   * The character (!) that separates sheet names from cell references
   */
  private static readonly SHEET_NAME_DELIMITER = '!';
  /**
   * The character (') used to quote sheet names when they contain special characters
   */
  private static readonly SPECIAL_NAME_DELIMITER = "'";

  /**
   * Matches a run of one or more letters followed by a run of one or more digits.
   * Both the letter and number groups are optional.
   * The run of letters is group 1 and the run of digits is group 2.
   * Each group may optionally be prefixed with a single '$'.
   */
  private static readonly CELL_REF_PATTERN = /^(\$?[A-Z]+)?(\$?[0-9]+)?$/i;

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
  private static separateRefParts(reference: string): CellRefParts {
    const plingPos = reference.lastIndexOf(CellLocation.SHEET_NAME_DELIMITER);
    const sheetName = this.parseSheetName(reference, plingPos);
    const cell = reference.substring(plingPos + 1).toUpperCase();
    const matcher = CellLocation.CELL_REF_PATTERN.exec(cell);
    if (!matcher) {
      throw new Error('Invalid CellLocation: ' + reference);
    }
    const col = matcher[1];
    const row = matcher[2];

    return new CellRefParts(sheetName, row, col);
  }

  private static parseSheetName(reference: string, indexOfSheetNameDelimiter: number): string | null {
    if (indexOfSheetNameDelimiter < 0) {
      return null;
    }

    const isQuoted = reference.charAt(0) === CellLocation.SPECIAL_NAME_DELIMITER;
    if (!isQuoted) {
      // sheet names with spaces must be quoted
      if (reference.indexOf(' ') === -1) {
        return reference.substring(0, indexOfSheetNameDelimiter);
      } else {
        throw new Error('Sheet names containing spaces must be quoted: (' + reference + ')');
      }
    }
    const lastQuotePos = indexOfSheetNameDelimiter - 1;
    if (reference.charAt(lastQuotePos) !== CellLocation.SPECIAL_NAME_DELIMITER) {
      throw new Error('Mismatched quotes: (' + reference + ')');
    }

    // TODO - refactor cell reference parsing logic to one place.
    // Current known incarnations:
    //   FormulaParser.GetName()
    //   CellLocation.parseSheetName() (here)
    //   AreaReference.separateAreaRefs()
    //   SheetNameFormatter.format() (inverse)

    let sb = '';

    for (let i = 1; i < lastQuotePos; i++) {
      // Note boundaries - skip outer quotes
      const ch = reference.charAt(i);
      if (ch !== CellLocation.SPECIAL_NAME_DELIMITER) {
        sb += ch;
        continue;
      }
      if (i + 1 < lastQuotePos && reference.charAt(i + 1) === CellLocation.SPECIAL_NAME_DELIMITER) {
        // two consecutive quotes is the escape sequence for a single one
        i++; // skip this and keep parsing the special name
        sb += ch;
        continue;
      }
      throw new Error('Bad sheet name quote escaping: (' + reference + ')');
    }
    return sb;
  }

  // FIXME: _sheetName may be null, depending on the entry point.
  // Perhaps it would be better to declare _sheetName is never null, using an empty string to represent a 2D reference.
  private sheetName: string | null;
  private rowIndex: number;
  private colIndex: number;
  private isRowAbs: boolean;
  private isColAbs: boolean;

  /**
   * Create an cell ref from a string representation.  Sheet names containing special characters should be
   * delimited and escaped as per normal syntax rules for formulas.
   */
  public constructor(props: {
    sheetName?: string | null;
    row?: number | null;
    col?: number | null;
    absRow?: boolean | null;
    absCol?: boolean | null;
    cellRef?: string | null;
  }) {
    const { sheetName, row, col, absRow, absCol, cellRef } = props;

    if (cellRef) {
      if (cellRef.toUpperCase().endsWith('#REF!')) {
        throw new Error('Cell reference invalid: ' + cellRef);
      }

      const parts = CellLocation.separateRefParts(cellRef);
      this.sheetName = parts.sheetName;

      let colRef = parts.colRef;
      this.isColAbs = colRef.length > 0 && colRef.charAt(0) === '$';
      if (this.isColAbs) {
        colRef = colRef.substring(1);
      }
      if (colRef.length === 0) {
        this.colIndex = -1;
      } else {
        this.colIndex = CellLocation.convertColStringToIndex(colRef);
      }

      let rowRef = parts.rowRef;
      this.isRowAbs = rowRef.length > 0 && rowRef.charAt(0) === '$';
      if (this.isRowAbs) {
        rowRef = rowRef.substring(1);
      }
      if (rowRef.length === 0) {
        this.rowIndex = -1;
      } else {
        this.rowIndex = parseInt(rowRef, 10) - 1; // -1 to convert 1-based to zero-based
      }
    } else if (row != null && col != null) {
      // TODO - "-1" is a special value being temporarily used for whole row and whole column area references.
      // so these checks are currently N.Q.R.
      if (row < -1) {
        throw new Error('row index may not be negative, but had ' + row);
      }
      if (col < -1) {
        throw new Error('column index may not be negative, but had ' + col);
      }
      this.sheetName = sheetName || null;
      this.rowIndex = row;
      this.colIndex = col;
      this.isRowAbs = absRow || false;
      this.isColAbs = absCol || false;
    }
  }

  public getRow(): number {
    return this.rowIndex;
  }

  public getCol(): number {
    return this.colIndex;
  }

  public isRowAbsolute(): boolean {
    return this.isRowAbs;
  }

  public isColAbsolute(): boolean {
    return this.isColAbs;
  }

  /**
   * @return possibly <code>null</code> if this is a 2D reference.  Special characters are not
   * escaped or delimited
   */
  public getSheetName(): string | null {
    return this.sheetName;
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
  public formatAsString(): string {
    let sb = '';
    if (this.sheetName != null) {
      sb += SheetNameFormatter.appendFormat(sb, this.sheetName);
      sb += CellLocation.SHEET_NAME_DELIMITER;
    }
    sb = this.appendCellReference(sb);
    return sb;
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
  public getCellRefParts(): string[] {
    return [this.sheetName || '', (this.rowIndex + 1).toString(), CellLocation.convertNumToColString(this.colIndex)];
  }

  /**
   * Appends cell reference with '$' markers for absolute values as required.
   * Sheet name is not included.
   */
  /* package */ public appendCellReference(sb: string): string {
    if (this.colIndex !== -1) {
      if (this.isColAbs) {
        sb += CellLocation.ABSOLUTE_REFERENCE_MARKER;
      }
      sb += CellLocation.convertNumToColString(this.colIndex);
    }
    if (this.rowIndex !== -1) {
      if (this.isRowAbs) {
        sb += CellLocation.ABSOLUTE_REFERENCE_MARKER;
      }
      sb += (this.rowIndex + 1).toString();
    }
    return sb;
  }
}
