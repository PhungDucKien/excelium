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
import RangeLocation from '../../src/ss/RangeLocation';
import { confirmCell as confirmCellLocation } from './CellLocation.spec';

function confirmAreaSheetName(ar: RangeLocation, sheetName: string, expectedFullText: string): void {
  const cells = ar.getAllReferencedCells();
  expect(cells[0].getSheetName()).toBe(sheetName);
  expect(ar.formatAsString()).toBe(expectedFullText);
}

function confirmWholeColumnRef(ref: string, firstCol: number, lastCol: number, firstIsAbs: boolean, lastIsAbs: boolean): void {
  const ar = new RangeLocation({ reference: ref });
  confirmCell(ar.getFirstCell(), 0, firstCol, true, firstIsAbs);
  confirmCell(ar.getLastCell(), 0xffff, lastCol, true, lastIsAbs);
}

function confirmCell(cell: CellLocation, row: number, col: number, isRowAbs: boolean, isColAbs: boolean): void {
  expect(cell.getRow()).toBe(row);
  expect(cell.getCol()).toBe(col);
  expect(cell.isRowAbsolute()).toBe(isRowAbs);
  expect(cell.isColAbsolute()).toBe(isColAbs);
}

// tslint:disable: no-unused-expression

/**
 * Test for {@link RangeLocation} handling of max rows.
 *
 * @author David North
 */
describe('test RangeLocation', () => {
  test('whole column', () => {
    const oldStyle = RangeLocation.getWholeColumn('A', 'B');
    expect(oldStyle.getFirstCell().getCol()).toBe(0);
    expect(oldStyle.getFirstCell().getRow()).toBe(0);
    expect(oldStyle.getLastCell().getCol()).toBe(1);
    expect(oldStyle.getLastCell().getRow()).toBe(65535);
    expect(oldStyle.isWholeColumnReference()).toBe(true);

    const oldStyleNonWholeColumn = new RangeLocation({ reference: 'A1:B23' });
    expect(oldStyleNonWholeColumn.isWholeColumnReference()).toBe(false);

    const newStyle = RangeLocation.getWholeColumn('A', 'B');
    expect(newStyle.getFirstCell().getCol()).toBe(0);
    expect(newStyle.getFirstCell().getRow()).toBe(0);
    expect(newStyle.getLastCell().getCol()).toBe(1);
    expect(newStyle.getLastCell().getRow()).toBe(65535);
    expect(newStyle.isWholeColumnReference()).toBe(true);

    const newStyleNonWholeColumn = new RangeLocation({ reference: 'A1:B23' });
    expect(newStyleNonWholeColumn.isWholeColumnReference()).toBe(false);
  });

  test('whole row', () => {
    const oldStyle = RangeLocation.getWholeRow('1', '2');
    expect(oldStyle.getFirstCell().getCol()).toBe(0);
    expect(oldStyle.getFirstCell().getRow()).toBe(0);
    expect(oldStyle.getLastCell().getCol()).toBe(255);
    expect(oldStyle.getLastCell().getRow()).toBe(1);

    const newStyle = RangeLocation.getWholeRow('1', '2');
    expect(newStyle.getFirstCell().getCol()).toBe(0);
    expect(newStyle.getFirstCell().getRow()).toBe(0);
    expect(newStyle.getLastCell().getCol()).toBe(255);
    expect(newStyle.getLastCell().getRow()).toBe(1);
  });

  test('area ref 1', () => {
    const ar = new RangeLocation({ reference: '$A$1:$B$2' });
    expect(ar.isSingleCell()).toBe(false);
    let cf = ar.getFirstCell();
    expect(cf.getRow()).toBe(0);
    expect(cf.getCol()).toBe(0);
    expect(cf.isRowAbsolute()).toBe(true);
    expect(cf.isColAbsolute()).toBe(true);
    expect(cf.formatAsString()).toBe('$A$1');

    cf = ar.getLastCell();
    expect(cf.getRow()).toBe(1);
    expect(cf.getCol()).toBe(1);
    expect(cf.isRowAbsolute()).toBe(true);
    expect(cf.isColAbsolute()).toBe(true);
    expect(cf.formatAsString()).toBe('$B$2');

    const refs = ar.getAllReferencedCells();
    expect(refs.length).toBe(4);

    expect(refs[0].getRow()).toBe(0);
    expect(refs[0].getCol()).toBe(0);
    expect(refs[0].getSheetName()).toBe(null);

    expect(refs[1].getRow()).toBe(0);
    expect(refs[1].getCol()).toBe(1);
    expect(refs[1].getSheetName()).toBe(null);

    expect(refs[2].getRow()).toBe(1);
    expect(refs[2].getCol()).toBe(0);
    expect(refs[2].getSheetName()).toBe(null);

    expect(refs[3].getRow()).toBe(1);
    expect(refs[3].getCol()).toBe(1);
    expect(refs[3].getSheetName()).toBe(null);
  });

  /**
   * References failed when sheet names were being used
   * Reported by Arne.Clauss@gedas.de
   */
  test('reference with sheet', () => {
    let ar: RangeLocation;

    ar = new RangeLocation({ reference: 'Tabelle1!B5:B5' });
    expect(ar.isSingleCell()).toBe(true);
    confirmCellLocation(ar.getFirstCell(), 'Tabelle1', 4, 1, false, false, 'Tabelle1!B5');

    expect(ar.getAllReferencedCells().length).toBe(1);

    ar = new RangeLocation({ reference: 'Tabelle1!$B$5:$B$7' });
    expect(ar.isSingleCell()).toBe(false);

    confirmCellLocation(ar.getFirstCell(), 'Tabelle1', 4, 1, true, true, 'Tabelle1!$B$5');
    confirmCellLocation(ar.getLastCell(), 'Tabelle1', 6, 1, true, true, 'Tabelle1!$B$7');

    // And all that make it up
    const allCells = ar.getAllReferencedCells();
    expect(allCells.length).toBe(3);
    confirmCellLocation(allCells[0], 'Tabelle1', 4, 1, true, true, 'Tabelle1!$B$5');
    confirmCellLocation(allCells[1], 'Tabelle1', 5, 1, true, true, 'Tabelle1!$B$6');
    confirmCellLocation(allCells[2], 'Tabelle1', 6, 1, true, true, 'Tabelle1!$B$7');
  });

  test('contiguous references', () => {
    const refSimple = '$C$10:$C$10';
    const ref2D = '$C$10:$D$11';
    const refDCSimple = '$C$10:$C$10,$D$12:$D$12,$E$14:$E$14';
    const refDC2D = '$C$10:$C$11,$D$12:$D$12,$E$14:$E$20';
    const refDC3D = 'Tabelle1!$C$10:$C$14,Tabelle1!$D$10:$D$12';

    // Check that we detect as contiguous properly
    expect(RangeLocation.isContiguous(refSimple)).toBe(true);
    expect(RangeLocation.isContiguous(ref2D)).toBe(true);
    expect(RangeLocation.isContiguous(refDCSimple)).toBe(false);
    expect(RangeLocation.isContiguous(refDC2D)).toBe(false);
    expect(RangeLocation.isContiguous(refDC3D)).toBe(false);

    // Check we can only create contiguous entries
    new RangeLocation({ reference: refSimple });
    new RangeLocation({ reference: ref2D });
    try {
      new RangeLocation({ reference: refDCSimple });
      fail('expected error');
    } catch (e) {
      // expected during successful test
    }
    try {
      new RangeLocation({ reference: refDC2D });
      fail('expected error');
    } catch (e) {
      // expected during successful test
    }
    try {
      new RangeLocation({ reference: refDC3D });
      fail('expected error');
    } catch (e) {
      // expected during successful test
    }

    // Test that we split as expected
    let refs;

    refs = RangeLocation.generateContiguous(refSimple);
    expect(refs.length).toBe(1);
    expect(refs[0].isSingleCell()).toBe(true);
    expect(refs[0].formatAsString()).toBe('$C$10');

    refs = RangeLocation.generateContiguous(ref2D);
    expect(refs.length).toBe(1);
    expect(refs[0].isSingleCell()).toBe(false);
    expect(refs[0].formatAsString()).toBe('$C$10:$D$11');

    refs = RangeLocation.generateContiguous(refDCSimple);
    expect(refs.length).toBe(3);
    expect(refs[0].isSingleCell()).toBe(true);
    expect(refs[1].isSingleCell()).toBe(true);
    expect(refs[2].isSingleCell()).toBe(true);
    expect(refs[0].formatAsString()).toBe('$C$10');
    expect(refs[1].formatAsString()).toBe('$D$12');
    expect(refs[2].formatAsString()).toBe('$E$14');

    refs = RangeLocation.generateContiguous(refDC2D);
    expect(refs.length).toBe(3);
    expect(refs[0].isSingleCell()).toBe(false);
    expect(refs[1].isSingleCell()).toBe(true);
    expect(refs[2].isSingleCell()).toBe(false);
    expect(refs[0].formatAsString()).toBe('$C$10:$C$11');
    expect(refs[1].formatAsString()).toBe('$D$12');
    expect(refs[2].formatAsString()).toBe('$E$14:$E$20');

    refs = RangeLocation.generateContiguous(refDC3D);
    expect(refs.length).toBe(2);
    expect(refs[0].isSingleCell()).toBe(false);
    expect(refs[1].isSingleCell()).toBe(false);
    expect(refs[0].formatAsString()).toBe('Tabelle1!$C$10:$C$14');
    expect(refs[1].formatAsString()).toBe('Tabelle1!$D$10:$D$12');
    expect(refs[0].getFirstCell().getSheetName()).toBe('Tabelle1');
    expect(refs[0].getLastCell().getSheetName()).toBe('Tabelle1');
    expect(refs[1].getFirstCell().getSheetName()).toBe('Tabelle1');
    expect(refs[1].getLastCell().getSheetName()).toBe('Tabelle1');
  });

  test('special sheet names', () => {
    let ar;
    ar = new RangeLocation({ reference: "'Sheet A'!A1:A1" });
    confirmAreaSheetName(ar, 'Sheet A', "'Sheet A'!A1");

    ar = new RangeLocation({ reference: "'Hey! Look Here!'!A1:A1" });
    confirmAreaSheetName(ar, 'Hey! Look Here!', "'Hey! Look Here!'!A1");

    ar = new RangeLocation({ reference: "'O''Toole'!A1:B2" });
    confirmAreaSheetName(ar, "O'Toole", "'O''Toole'!A1:B2");

    ar = new RangeLocation({ reference: "'one:many'!A1:B2" });
    confirmAreaSheetName(ar, 'one:many', "'one:many'!A1:B2");
  });

  test('whole column refs', () => {
    confirmWholeColumnRef('A:A', 0, 0, false, false);
    confirmWholeColumnRef('$C:D', 2, 3, true, false);
    confirmWholeColumnRef('AD:$AE', 29, 30, false, true);
  });

  test('constructor by pair of cell references', () => {
    const topLeft = new CellLocation({ cellRef: 'Tabelle1!B5' });
    const bottomRight = new CellLocation({ cellRef: 'Tabelle1!C8' });
    let ar = new RangeLocation({ topLeft, bottomRight });
    expect(ar.formatAsString()).toBe('Tabelle1!B5:C8');

    ar = new RangeLocation({ topLeft: bottomRight, bottomRight: topLeft });
    expect(ar.formatAsString()).toBe('Tabelle1!B5:C8');

    const topRight = new CellLocation({ cellRef: 'Tabelle1!C5' });
    const bottomLeft = new CellLocation({ cellRef: 'Tabelle1!B8' });
    ar = new RangeLocation({ topLeft: topRight, bottomRight: bottomLeft });
    expect(ar.formatAsString()).toBe('Tabelle1!B5:C8');

    ar = new RangeLocation({ topLeft: bottomLeft, bottomRight: topRight });
    expect(ar.formatAsString()).toBe('Tabelle1!B5:C8');
  });

  test('format whole column reference', () => {
    const ar = new RangeLocation({ reference: "'Sheet 1'!C$1:D$65536" });
    expect(ar.formatAsString()).toBe('C:D');
  });
});
