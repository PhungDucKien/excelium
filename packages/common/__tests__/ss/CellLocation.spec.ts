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

import CellLocation from '../../src/ss/CellLocation';

function confirmCrInRange(expResult: boolean, colStr: string, rowStr: string): void {
  if (expResult === CellLocation.cellReferenceIsWithinRange(colStr, rowStr)) {
    return;
  }
  fail("expected (c='" + colStr + "', r='" + rowStr + "' to be " + (expResult ? 'within' : 'out of') + ' bounds');
}

export function confirmCell(
  cf: CellLocation,
  expSheetName: string | null,
  expRow: number,
  expCol: number,
  expIsRowAbs: boolean,
  expIsColAbs: boolean,
  expText: string
): void {
  expect(cf.getSheetName()).toBe(expSheetName);
  expect(cf.getRow()).toBe(expRow);
  expect(cf.getCol()).toBe(expCol);
  expect(cf.isRowAbsolute()).toBe(expIsRowAbs);
  expect(cf.isColAbsolute()).toBe(expIsColAbs);
  expect(cf.formatAsString()).toBe(expText);
}

// tslint:disable: no-unused-expression

/**
 * Tests that the common CellLocation works as we need it to.
 */
describe('test SheetNameFormatter', () => {
  test('constructor', () => {
    let cellLocation: CellLocation;
    const sheetName = 'Sheet1';
    const cellRef = 'A1';
    const row = 0;
    const col = 0;
    const absRow = true;
    const absCol = false;

    cellLocation = new CellLocation({ row, col });
    expect(cellLocation.formatAsString()).toBe('A1');

    cellLocation = new CellLocation({ row, col, absRow, absCol });
    expect(cellLocation.formatAsString()).toBe('A$1');

    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.formatAsString()).toBe('A1');

    cellLocation = new CellLocation({ sheetName, row, col });
    expect(cellLocation.formatAsString()).toBe('Sheet1!A1');

    cellLocation = new CellLocation({ sheetName, row, col, absRow, absCol });
    expect(cellLocation.formatAsString()).toBe('Sheet1!A$1');
  });

  test('format as string', () => {
    let cellLocation: CellLocation;

    cellLocation = new CellLocation({ row: 0, col: 0 });
    expect(cellLocation.formatAsString()).toBe('A1');

    // absolute references
    cellLocation = new CellLocation({ row: 0, col: 0, absRow: true, absCol: false });
    expect(cellLocation.formatAsString()).toBe('A$1');

    // sheet name with no spaces
    cellLocation = new CellLocation({ sheetName: 'Sheet1', row: 0, col: 0, absRow: true, absCol: false });
    expect(cellLocation.formatAsString()).toBe('Sheet1!A$1');

    // sheet name with spaces
    cellLocation = new CellLocation({ sheetName: 'Sheet 1', row: 0, col: 0, absRow: true, absCol: false });
    expect(cellLocation.formatAsString()).toBe("'Sheet 1'!A$1");
  });

  test('get cell ref parts', () => {
    let cellLocation: CellLocation;
    let parts: string[];

    let cellRef = 'A1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(0);
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('1');
    expect(parts[2]).toBe('A');

    cellRef = 'AA1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26);
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('1');
    expect(parts[2]).toBe('AA');

    cellRef = 'AA100';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26);
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('100');
    expect(parts[2]).toBe('AA');

    cellRef = 'AAA300';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(702);
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('300');
    expect(parts[2]).toBe('AAA');

    cellRef = 'ZZ100521';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 * 26 + 25);
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('100521');
    expect(parts[2]).toBe('ZZ');

    cellRef = 'ZYX987';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 * 26 * 26 + 25 * 26 + 24 - 1);
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('987');
    expect(parts[2]).toBe('ZYX');

    cellRef = 'AABC10065';
    cellLocation = new CellLocation({ cellRef });
    parts = cellLocation.getCellRefParts();
    expect(parts).not.toBeNull();
    expect(parts[0]).toBe('');
    expect(parts[1]).toBe('10065');
    expect(parts[2]).toBe('AABC');
  });

  test('get col num from ref', () => {
    let cellRef = 'A1';
    let cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(0);

    cellRef = 'AA1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26);

    cellRef = 'AB1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(27);

    cellRef = 'BA1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 + 26);

    cellRef = 'CA1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 + 26 + 26);

    cellRef = 'ZA1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 * 26);

    cellRef = 'ZZ1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 * 26 + 25);

    cellRef = 'AAA1';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(26 * 26 + 26);

    cellRef = 'A100';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(0);

    cellRef = 'BC15';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getCol()).toBe(54);
  });

  test('get row num from ref', () => {
    let cellRef = 'A1';
    let cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getRow()).toBe(0);

    cellRef = 'A12';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getRow()).toBe(11);

    cellRef = 'AS121';
    cellLocation = new CellLocation({ cellRef });
    expect(cellLocation.getRow()).toBe(120);
  });

  test('convert num to col string', () => {
    let col = 702;
    let collRef = new CellLocation({ row: 0, col }).formatAsString();
    expect(collRef).toBe('AAA1');

    col = 0;
    collRef = new CellLocation({ row: 0, col }).formatAsString();
    expect(collRef).toBe('A1');

    col = 27;
    collRef = new CellLocation({ row: 0, col }).formatAsString();
    expect(collRef).toBe('AB1');

    col = 2080;
    collRef = new CellLocation({ row: 0, col }).formatAsString();
    expect(collRef).toBe('CBA1');
  });

  test('bad row number', () => {
    confirmCrInRange(true, 'A', '1');
    confirmCrInRange(true, 'IV', '65536');
    confirmCrInRange(false, 'IV', '65537');
    confirmCrInRange(false, 'IW', '65536');

    expect(CellLocation.cellReferenceIsWithinRange('B', '0')).toBe(false);

    confirmCrInRange(false, 'A', '0');
  });

  test('invalid reference', () => {
    try {
      new CellLocation({ cellRef: 'Sheet1!#REF!' });
      fail("Shouldn't be able to create a #REF! refence");
    } catch (e) {
      // expected here
    }

    try {
      new CellLocation({ cellRef: "'MySheetName'!#REF!" });
      fail("Shouldn't be able to create a #REF! refence");
    } catch (e) {
      // expected here
    }

    try {
      new CellLocation({ cellRef: '#REF!' });
      fail("Shouldn't be able to create a #REF! refence");
    } catch (e) {
      // expected here
    }
  });

  test('convert col string to index', () => {
    expect(CellLocation.convertColStringToIndex('A')).toBe(0);
    expect(CellLocation.convertColStringToIndex('B')).toBe(1);
    expect(CellLocation.convertColStringToIndex('O')).toBe(14);
    expect(CellLocation.convertColStringToIndex('ZZ')).toBe(701);
    expect(CellLocation.convertColStringToIndex('ZZA')).toBe(18252);

    expect(CellLocation.convertColStringToIndex('$A')).toBe(0);
    expect(CellLocation.convertColStringToIndex('$B')).toBe(1);

    try {
      CellLocation.convertColStringToIndex('A$');
      fail('Should throw exception here');
    } catch (e) {
      expect(e.message).toContain('A$');
    }
  });

  test('convert num to col string', () => {
    expect(CellLocation.convertNumToColString(0)).toBe('A');
    expect(CellLocation.convertNumToColString(47)).toBe('AV');
    expect(CellLocation.convertNumToColString(48)).toBe('AW');
    expect(CellLocation.convertNumToColString(57)).toBe('BF');

    expect(CellLocation.convertNumToColString(-1)).toBe('');
    expect(CellLocation.convertNumToColString(-2147483648)).toBe('');
    expect(CellLocation.convertNumToColString(2147483647)).toBe('FXSHRXX');
    expect(CellLocation.convertNumToColString(2147483646)).toBe('FXSHRXW');
  });

  /**
   * bug 59684: separateRefParts fails on entire-column references
   */
  test('entire column references', () => {
    const ref = new CellLocation({ cellRef: 'HOME!$169' });
    expect(ref.getSheetName()).toBe('HOME');
    expect(ref.getRow()).toBe(168);
    expect(ref.getCol()).toBe(-1);
    expect(ref.isRowAbsolute()).toBe(true);
  });

  test('get sheet name', () => {
    expect(new CellLocation({ cellRef: 'A5' }).getSheetName()).toBe(null);
    expect(new CellLocation({ row: 0, col: 0 }).getSheetName()).toBe(null);
    // FIXME: CellLocation is inconsistent
    expect(new CellLocation({ sheetName: '', row: 0, col: 0 }).getSheetName()).toBe(null);
    expect(new CellLocation({ cellRef: 'Sheet1!A5' }).getSheetName()).toBe('Sheet1');
    expect(new CellLocation({ cellRef: "'Sheet 1'!A5" }).getSheetName()).toBe('Sheet 1');
  });

  test('is row within range', () => {
    expect(CellLocation.isRowWithinRange('0')).toBe(false);
    expect(CellLocation.isRowWithinRange('1')).toBe(true);
    expect(CellLocation.isRowWithinRange('65536')).toBe(true);
    expect(CellLocation.isRowWithinRange('65537')).toBe(false);
    expect(CellLocation.isRowWithinRange('4000000000')).toBe(false);

    // int versions of above, using 0-based indices
    expect(CellLocation.isRowNumWithinRange(-1)).toBe(false);
    expect(CellLocation.isRowNumWithinRange(9)).toBe(true);
    expect(CellLocation.isRowNumWithinRange(65535)).toBe(true);
    expect(CellLocation.isRowNumWithinRange(65536)).toBe(false);
  });

  test('is row within range non integer - alpha', () => {
    const rowNum = 'NotANumber';
    try {
      CellLocation.isRowWithinRange(rowNum);
      fail('Should throw exception here');
    } catch (e) {
      // expected here
    }
  });

  test('is col within range', () => {
    expect(CellLocation.isColumnWithinRange('')).toBe(true);
    expect(CellLocation.isColumnWithinRange('A')).toBe(true);
    expect(CellLocation.isColumnWithinRange('IV')).toBe(true);
    expect(CellLocation.isColumnWithinRange('IW')).toBe(false);
  });

  test('unquoted sheet name', () => {
    try {
      new CellLocation({ cellRef: "'Sheet 1!A5" });
      fail('Should throw exception here');
    } catch (e) {
      // expected here
    }
  });

  test('mismatched quotes sheet name', () => {
    try {
      new CellLocation({ cellRef: 'Sheet 1!A5' });
      fail('Should throw exception here');
    } catch (e) {
      // expected here
    }
  });

  test('escaped sheet name', () => {
    const escapedName = "'Don''t Touch'!A5";
    const unescapedName = "'Don't Touch'!A5";
    new CellLocation({ cellRef: escapedName });
    try {
      new CellLocation({ cellRef: unescapedName });
      fail("Sheet names containing apostrophe's must be escaped via a repeated apostrophe");
    } catch (e) {
      expect(e.message).toContain('Bad sheet name quote escaping: ');
    }
  });

  test('negative row', () => {
    try {
      new CellLocation({ sheetName: 'sheet', row: -2, col: 0, absRow: false, absCol: false });
      fail('Should throw exception here');
    } catch (e) {
      // expected here
    }
  });

  test('negative column', () => {
    try {
      new CellLocation({ sheetName: 'sheet', row: 0, col: -2, absRow: false, absCol: false });
      fail('Should throw exception here');
    } catch (e) {
      // expected here
    }
  });

  test('col num conversion', () => {
    expect(CellLocation.convertColStringToIndex('A')).toBe(0);
    expect(CellLocation.convertColStringToIndex('B')).toBe(1);
    expect(CellLocation.convertColStringToIndex('Z')).toBe(25);
    expect(CellLocation.convertColStringToIndex('AA')).toBe(26);
    expect(CellLocation.convertColStringToIndex('AB')).toBe(27);
    expect(CellLocation.convertColStringToIndex('AZ')).toBe(51);
    expect(CellLocation.convertColStringToIndex('ZZ')).toBe(701);
    expect(CellLocation.convertColStringToIndex('AAA')).toBe(702);
    expect(CellLocation.convertColStringToIndex('ZZZ')).toBe(18277);

    expect(CellLocation.convertNumToColString(0)).toBe('A');
    expect(CellLocation.convertNumToColString(1)).toBe('B');
    expect(CellLocation.convertNumToColString(25)).toBe('Z');
    expect(CellLocation.convertNumToColString(26)).toBe('AA');
    expect(CellLocation.convertNumToColString(701)).toBe('ZZ');
    expect(CellLocation.convertNumToColString(702)).toBe('AAA');
    expect(CellLocation.convertNumToColString(18277)).toBe('ZZZ');

    // Absolute references are allowed for the string ones
    expect(CellLocation.convertColStringToIndex('$A')).toBe(0);
    expect(CellLocation.convertColStringToIndex('$Z')).toBe(25);
    expect(CellLocation.convertColStringToIndex('$AA')).toBe(26);

    // $ sign isn't allowed elsewhere though
    try {
      CellLocation.convertColStringToIndex('A$B$');
      fail("Column reference is invalid and shouldn't be accepted");
    } catch (e) {
      // expected here
    }
  });

  test('abs ref 1', () => {
    const cf = new CellLocation({ cellRef: '$B$5' });
    confirmCell(cf, null, 4, 1, true, true, '$B$5');
  });

  test('abs ref 2', () => {
    const cf = new CellLocation({ row: 4, col: 1, absRow: true, absCol: true });
    confirmCell(cf, null, 4, 1, true, true, '$B$5');
  });

  test('abs ref 3', () => {
    const cf = new CellLocation({ cellRef: 'B$5' });
    confirmCell(cf, null, 4, 1, true, false, 'B$5');
  });

  test('abs ref 4', () => {
    const cf = new CellLocation({ row: 4, col: 1, absRow: true, absCol: false });
    confirmCell(cf, null, 4, 1, true, false, 'B$5');
  });

  test('abs ref 5', () => {
    const cf = new CellLocation({ cellRef: '$B5' });
    confirmCell(cf, null, 4, 1, false, true, '$B5');
  });

  test('abs ref 6', () => {
    const cf = new CellLocation({ row: 4, col: 1, absRow: false, absCol: true });
    confirmCell(cf, null, 4, 1, false, true, '$B5');
  });

  test('abs ref 7', () => {
    const cf = new CellLocation({ cellRef: 'B5' });
    confirmCell(cf, null, 4, 1, false, false, 'B5');
  });

  test('abs ref 8', () => {
    const cf = new CellLocation({ row: 4, col: 1, absRow: false, absCol: false });
    confirmCell(cf, null, 4, 1, false, false, 'B5');
  });

  test('special sheet names', () => {
    let cf: CellLocation;
    cf = new CellLocation({ cellRef: "'profit + loss'!A1" });
    confirmCell(cf, 'profit + loss', 0, 0, false, false, "'profit + loss'!A1");

    cf = new CellLocation({ cellRef: "'O''Brien''s Sales'!A1" });
    confirmCell(cf, "O'Brien's Sales", 0, 0, false, false, "'O''Brien''s Sales'!A1");

    cf = new CellLocation({ cellRef: "'Amazing!'!A1" });
    confirmCell(cf, 'Amazing!', 0, 0, false, false, "'Amazing!'!A1");
  });

  test('separate ref parts invalid', () => {
    try {
      new CellLocation({ cellRef: 'Sheet1!1A' });
      fail('Should throw exception here');
    } catch (e) {
      // expected here
    }
  });
});
