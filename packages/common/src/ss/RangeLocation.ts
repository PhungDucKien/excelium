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

import CellLocation from './CellLocation';

export default class RangeLocation {
  /**
   * Is the reference for a contiguous (i.e.
   * unbroken) area, or is it made up of
   * several different parts?
   * (If it is, you will need to call
   * {@link #generateContiguous(String)})
   */
  public static isContiguous(reference: string): boolean {
    // If there's a sheet name, strip it off
    const sheetRefEnd = reference.indexOf('!');
    if (sheetRefEnd !== -1) {
      reference = reference.substring(sheetRefEnd);
    }

    // Check for the , as a sign of non-coniguous
    return reference.indexOf(',') === -1;
  }

  public static getWholeRow(start: string, end: string): RangeLocation {
    return new RangeLocation({ reference: '$A' + start + ':$' + 'IV' + end });
  }

  public static getWholeColumn(start: string, end: string): RangeLocation {
    return new RangeLocation({ reference: start + '$1:' + end + '$' + 65536 });
  }

  /**
   * Is the reference for a whole-column reference,
   * such as C:C or D:G ?
   */
  public static isWholeColumnReference(topLeft: CellLocation, bottomRight: CellLocation): boolean {
    // These are represented as something like
    //   C$1:C$65535 or D$1:F$0
    // i.e. absolute from 1st row to 0th one
    return topLeft.getRow() === 0 && topLeft.isRowAbsolute() && bottomRight.getRow() === 65535 && bottomRight.isRowAbsolute();
  }

  /**
   * Takes a non-contiguous area reference, and returns an array of contiguous area references
   *
   * @return an array of contiguous area references.
   */
  public static generateContiguous(reference: string): RangeLocation[] {
    const refs = [] as RangeLocation[];
    const st = reference.split(',');
    if (st.length) {
      st.forEach(s => {
        refs.push(new RangeLocation({ reference: s }));
      });
    }
    return refs;
  }

  /**
   * The character (!) that separates sheet names from cell references
   */
  private static readonly SHEET_NAME_DELIMITER = '!';
  /**
   * The character (:) that separates the two cell references in a multi-cell area reference
   */
  private static readonly CELL_DELIMITER = ':';
  /**
   * The character (') used to quote sheet names when they contain special characters
   */
  private static readonly SPECIAL_NAME_DELIMITER = "'";

  private static isPlainColumn(refPart: string): boolean {
    for (let i = refPart.length - 1; i >= 0; i--) {
      const ch = refPart.charAt(i);
      if (ch === '$' && i === 0) {
        continue;
      }
      if (ch < 'A' || ch > 'Z') {
        return false;
      }
    }
    return true;
  }

  /**
   * Separates Area refs in two parts and returns them as separate elements in a String array,
   * each qualified with the sheet name (if present)
   *
   * @return array with one or two elements. never <code>null</code>
   */
  private static separateAreaRefs(reference: string): string[] {
    // TODO - refactor cell reference parsing logic to one place.
    // Current known incarnations:
    //   FormulaParser.GetName()
    //   CellLocation.separateRefParts()
    //   RangeLocation.separateAreaRefs() (here)
    //   SheetNameFormatter.format() (inverse)

    const len = reference.length;
    let delimiterPos = -1;
    let insideDelimitedName = false;
    for (let i = 0; i < len; i++) {
      switch (reference.charAt(i)) {
        case RangeLocation.CELL_DELIMITER:
          if (!insideDelimitedName) {
            if (delimiterPos >= 0) {
              throw new Error("More than one cell delimiter '" + RangeLocation.CELL_DELIMITER + "' appears in area reference '" + reference + "'");
            }
            delimiterPos = i;
          }
          continue; // continue the for-loop
        case RangeLocation.SPECIAL_NAME_DELIMITER:
          break;
        default:
          continue; // continue the for-loop
      }
      if (!insideDelimitedName) {
        insideDelimitedName = true;
        continue;
      }

      if (i >= len - 1) {
        // reference ends with the delimited name.
        // Assume names like: 'Sheet1!'A1'' are never legal.
        throw new Error("Area reference '" + reference + "' ends with special name delimiter '" + RangeLocation.SPECIAL_NAME_DELIMITER + "'");
      }
      if (reference.charAt(i + 1) === RangeLocation.SPECIAL_NAME_DELIMITER) {
        // two consecutive quotes is the escape sequence for a single one
        i++; // skip this and keep parsing the special name
      } else {
        // this is the end of the delimited name
        insideDelimitedName = false;
      }
    }
    if (delimiterPos < 0) {
      return [reference];
    }

    const partA = reference.substring(0, delimiterPos);
    const partB = reference.substring(delimiterPos + 1);
    if (partB.indexOf(RangeLocation.SHEET_NAME_DELIMITER) >= 0) {
      // partB contains SHEET_NAME_DELIMITER
      // TODO - are references like 'Sheet1!A1:Sheet1:B2' ever valid?
      // FormulaParser has code to handle that.

      throw new Error('Unexpected ' + RangeLocation.SHEET_NAME_DELIMITER + " in second cell reference of '" + reference + "'");
    }

    const plingPos = partA.lastIndexOf(RangeLocation.SHEET_NAME_DELIMITER);
    if (plingPos < 0) {
      return [partA, partB];
    }

    const sheetName = partA.substring(0, plingPos + 1); // +1 to include delimiter

    return [partA, sheetName + partB];
  }

  private firstCell: CellLocation;
  private lastCell: CellLocation;
  private singleCell: boolean;

  /**
   * Create an area ref from a string representation or a pair of Cell References.  Sheet names containing special characters should be
   * delimited and escaped as per normal syntax rules for formulas.<br>
   * The area reference must be contiguous (i.e. represent a single rectangle, not a union of rectangles)
   */
  constructor(props: { reference?: string | null; topLeft?: CellLocation | null; bottomRight?: CellLocation | null }) {
    const { reference, topLeft, bottomRight } = props;

    if (reference) {
      if (!RangeLocation.isContiguous(reference)) {
        throw new Error(
          'References passed to the RangeLocation must be contiguous, ' + 'use generateContiguous(ref) if you have non-contiguous references'
        );
      }

      const parts = RangeLocation.separateAreaRefs(reference);
      const part0 = parts[0];
      if (parts.length === 1) {
        // TODO - probably shouldn't initialize area ref when text is really a cell ref
        // Need to fix some named range stuff to get rid of this
        this.firstCell = new CellLocation({ cellRef: part0 });

        this.lastCell = this.firstCell;
        this.singleCell = true;
        return;
      }
      if (parts.length !== 2) {
        throw new Error("Bad area ref '" + reference + "'");
      }

      const part1 = parts[1];
      if (RangeLocation.isPlainColumn(part0)) {
        if (!RangeLocation.isPlainColumn(part1)) {
          throw new Error("Bad area ref '" + reference + "'");
        }
        // Special handling for whole-column references
        // Represented internally as x$1 to x$65536
        //  which is the maximum range of rows

        const firstIsAbs = CellLocation.isPartAbsolute(part0);
        const lastIsAbs = CellLocation.isPartAbsolute(part1);

        const col0 = CellLocation.convertColStringToIndex(part0);
        const col1 = CellLocation.convertColStringToIndex(part1);

        this.firstCell = new CellLocation({ row: 0, col: col0, absRow: true, absCol: firstIsAbs });
        this.lastCell = new CellLocation({ row: 0xffff, col: col1, absRow: true, absCol: lastIsAbs });
        this.singleCell = false;
        // TODO - whole row refs
      } else {
        this.firstCell = new CellLocation({ cellRef: part0 });
        this.lastCell = new CellLocation({ cellRef: part1 });
        this.singleCell = part0 === part1;
      }
    } else if (topLeft && bottomRight) {
      const swapRows = topLeft.getRow() > bottomRight.getRow();
      const swapCols = topLeft.getCol() > bottomRight.getCol();
      if (swapRows || swapCols) {
        let firstRow;
        let lastRow;
        let firstColumn;
        let lastColumn;
        let firstRowAbs;
        let lastRowAbs;
        let firstColAbs;
        let lastColAbs;
        if (swapRows) {
          firstRow = bottomRight.getRow();
          firstRowAbs = bottomRight.isRowAbsolute();
          lastRow = topLeft.getRow();
          lastRowAbs = topLeft.isRowAbsolute();
        } else {
          firstRow = topLeft.getRow();
          firstRowAbs = topLeft.isRowAbsolute();
          lastRow = bottomRight.getRow();
          lastRowAbs = bottomRight.isRowAbsolute();
        }
        if (swapCols) {
          firstColumn = bottomRight.getCol();
          firstColAbs = bottomRight.isColAbsolute();
          lastColumn = topLeft.getCol();
          lastColAbs = topLeft.isColAbsolute();
        } else {
          firstColumn = topLeft.getCol();
          firstColAbs = topLeft.isColAbsolute();
          lastColumn = bottomRight.getCol();
          lastColAbs = bottomRight.isColAbsolute();
        }
        this.firstCell = new CellLocation({
          sheetName: topLeft.getSheetName(),
          row: firstRow,
          col: firstColumn,
          absRow: firstRowAbs,
          absCol: firstColAbs,
        });
        this.lastCell = new CellLocation({
          sheetName: bottomRight.getSheetName(),
          row: lastRow,
          col: lastColumn,
          absRow: lastRowAbs,
          absCol: lastColAbs,
        });
      } else {
        this.firstCell = topLeft;
        this.lastCell = bottomRight;
      }
      this.singleCell = false;
    }
  }

  public isWholeColumnReference(): boolean {
    return RangeLocation.isWholeColumnReference(this.firstCell, this.lastCell);
  }

  /**
   * @return <code>false</code> if this area reference involves more than one cell
   */
  public isSingleCell(): boolean {
    return this.singleCell;
  }

  /**
   * @return the first cell reference which defines this area. Usually this cell is in the upper
   * left corner of the area (but this is not a requirement).
   */
  public getFirstCell(): CellLocation {
    return this.firstCell;
  }

  /**
   * Note - if this area reference refers to a single cell, the return value of this method will
   * be identical to that of <tt>getFirstCell()</tt>
   *
   * @return the second cell reference which defines this area.  For multi-cell areas, this is
   * cell diagonally opposite the 'first cell'.  Usually this cell is in the lower right corner
   * of the area (but this is not a requirement).
   */
  public getLastCell(): CellLocation {
    return this.lastCell;
  }

  /**
   * Returns a reference to every cell covered by this area
   */
  public getAllReferencedCells(): CellLocation[] {
    // Special case for single cell reference
    if (this.singleCell) {
      return [this.firstCell];
    }

    // Interpolate between the two
    const minRow = Math.min(this.firstCell.getRow(), this.lastCell.getRow());
    const maxRow = Math.max(this.firstCell.getRow(), this.lastCell.getRow());
    const minCol = Math.min(this.firstCell.getCol(), this.lastCell.getCol());
    const maxCol = Math.max(this.firstCell.getCol(), this.lastCell.getCol());
    const sheetName = this.firstCell.getSheetName();

    const refs = [] as CellLocation[];
    for (let row = minRow; row <= maxRow; row++) {
      for (let col = minCol; col <= maxCol; col++) {
        const ref = new CellLocation({ sheetName, row, col, absRow: this.firstCell.isRowAbsolute(), absCol: this.firstCell.isColAbsolute() });
        refs.push(ref);
      }
    }
    return refs;
  }

  /**
   * Returns a text representation of this area reference.
   * <p>
   * Example return values:
   * <table border='0' cellpadding='1' cellspacing='0' summary='Example return values'>
   * <tr><th align='left'>Result</th><th align='left'>Comment</th></tr>
   * <tr><td>A1:A1</td><td>Single cell area reference without sheet</td></tr>
   * <tr><td>A1:$C$1</td><td>Multi-cell area reference without sheet</td></tr>
   * <tr><td>Sheet1!A$1:B4</td><td>Standard sheet name</td></tr>
   * <tr><td>'O''Brien''s Sales'!B5:C6'&nbsp;</td><td>Sheet name with special characters</td></tr>
   * </table>
   *
   * @return the text representation of this area reference as it would appear in a formula.
   */
  public formatAsString(): string {
    // Special handling for whole-column references
    if (this.isWholeColumnReference()) {
      return CellLocation.convertNumToColString(this.firstCell.getCol()) + ':' + CellLocation.convertNumToColString(this.lastCell.getCol());
    }

    let sb = '';
    sb += this.firstCell.formatAsString();
    if (!this.singleCell) {
      sb += RangeLocation.CELL_DELIMITER;
      if (this.lastCell.getSheetName() == null) {
        sb += this.lastCell.formatAsString();
      } else {
        // don't want to include the sheet name twice
        sb = this.lastCell.appendCellReference(sb);
      }
    }
    return sb;
  }
}
