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

import SheetNameFormatter from '../../src/ss/SheetNameFormatter';

function confirmFormat(rawSheetName: string, expectedSheetNameEncoding: string): void {
  expect(SheetNameFormatter.format(rawSheetName)).toBe(expectedSheetNameEncoding);
}

function confirmAppendFormat(rawSheetName: string, expectedSheetNameEncoding: string): void {
  const sb = SheetNameFormatter.appendFormat('', rawSheetName);
  expect(sb).toBe(expectedSheetNameEncoding);
}

function confirmAppendFormatWithWorkbook(rawWorkbookName: string, rawSheetName: string, expectedSheetNameEncoding: string): void {
  const sb = SheetNameFormatter.appendFormat('', rawSheetName, rawWorkbookName);
  expect(sb).toBe(expectedSheetNameEncoding);
}

function confirmCellNameMatch(rawSheetName: string, expected: boolean): void {
  expect(SheetNameFormatter.nameLooksLikePlainCellReference(rawSheetName)).toBe(expected);
}

function confirmCellRange(text: string, numberOfPrefixLetters: number, expected: boolean): void {
  const prefix = text.substring(0, numberOfPrefixLetters);
  const suffix = text.substring(numberOfPrefixLetters);
  expect(SheetNameFormatter.cellReferenceIsWithinRange(prefix, suffix)).toBe(expected);
}

/**
 * Tests for {@link SheetNameFormatter}
 *
 * @author Josh Micich
 */
describe('test SheetNameFormatter', () => {
  /**
   * Tests main public method 'format'
   */
  test('format', () => {
    confirmFormat('abc', 'abc');
    confirmFormat('123', "'123'");

    confirmFormat('my sheet', "'my sheet'"); // space
    confirmFormat('A:MEM', "'A:MEM'"); // colon

    confirmFormat("O'Brian", "'O''Brian'"); // single quote gets doubled

    confirmFormat('3rdTimeLucky', "'3rdTimeLucky'"); // digit in first pos
    confirmFormat('_', '_'); // plain underscore OK
    confirmFormat('my_3rd_sheet', 'my_3rd_sheet'); // underscores and digits OK
    confirmFormat('A12220', "'A12220'");
    confirmFormat('TAXRETURN19980415', 'TAXRETURN19980415');
  });

  test('boolean literals', () => {
    confirmFormat('TRUE', "'TRUE'");
    confirmFormat('FALSE', "'FALSE'");
    confirmFormat('True', "'True'");
    confirmFormat('fAlse', "'fAlse'");

    confirmFormat('Yes', 'Yes');
    confirmFormat('No', 'No');
  });

  /**
   * Tests functionality to determine whether a sheet name containing only letters and digits
   * would look (to Excel) like a cell name.
   */
  test('looks like plain cell reference', () => {
    confirmCellNameMatch('A1', true);
    confirmCellNameMatch('a111', true);
    confirmCellNameMatch('AA', false);
    confirmCellNameMatch('aa1', true);
    confirmCellNameMatch('A1A', false);
    confirmCellNameMatch('A1A1', false);
    confirmCellNameMatch('Sh3', false);
    confirmCellNameMatch('SALES20080101', false); // out of range
  });

  /**
   * Tests exact boundaries for names that look very close to cell names (i.e. contain 1 or more
   * letters followed by one or more digits).
   */
  test('cell range', () => {
    confirmCellRange('A1', 1, true);
    confirmCellRange('a111', 1, true);
    confirmCellRange('A65536', 1, true);
    confirmCellRange('A65537', 1, false);
    confirmCellRange('iv1', 2, true);
    confirmCellRange('IW1', 2, false);
    confirmCellRange('AAA1', 3, false);
    confirmCellRange('a111', 1, true);
    confirmCellRange('Sheet1', 6, false);
    confirmCellRange('iV65536', 2, true); // max cell in Excel 97-2003
    confirmCellRange('IW65537', 2, false);
  });

  test('append format', () => {
    confirmAppendFormat('abc', 'abc');
    confirmAppendFormat('123', "'123'");

    confirmAppendFormat('my sheet', "'my sheet'"); // space
    confirmAppendFormat('A:MEM', "'A:MEM'"); // colon

    confirmAppendFormat("O'Brian", "'O''Brian'"); // single quote gets doubled

    confirmAppendFormat('3rdTimeLucky', "'3rdTimeLucky'"); // digit in first pos
    confirmAppendFormat('_', '_'); // plain underscore OK
    confirmAppendFormat('my_3rd_sheet', 'my_3rd_sheet'); // underscores and digits OK
    confirmAppendFormat('A12220', "'A12220'");
    confirmAppendFormat('TAXRETURN19980415', 'TAXRETURN19980415');
  });

  test('append format with workbook', () => {
    confirmAppendFormatWithWorkbook('Workbook', 'abc', '[Workbook]abc');
    confirmAppendFormatWithWorkbook('Workbook', '123', "'[Workbook]123'");

    confirmAppendFormatWithWorkbook('Workbook', 'my sheet', "'[Workbook]my sheet'"); // space
    confirmAppendFormatWithWorkbook('Workbook', 'A:MEM', "'[Workbook]A:MEM'"); // colon

    confirmAppendFormatWithWorkbook('Workbook', "O'Brian", "'[Workbook]O''Brian'"); // single quote gets doubled

    confirmAppendFormatWithWorkbook('Workbook', '3rdTimeLucky', "'[Workbook]3rdTimeLucky'"); // digit in first pos
    confirmAppendFormatWithWorkbook('Workbook', '_', '[Workbook]_'); // plain underscore OK
    confirmAppendFormatWithWorkbook('Workbook', 'my_3rd_sheet', '[Workbook]my_3rd_sheet'); // underscores and digits OK
    confirmAppendFormatWithWorkbook('Workbook', 'A12220', "'[Workbook]A12220'");
    confirmAppendFormatWithWorkbook('Workbook', 'TAXRETURN19980415', '[Workbook]TAXRETURN19980415');
  });
});
