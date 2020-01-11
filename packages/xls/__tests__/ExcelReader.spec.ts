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

import { TemplateUtil } from '@excelium/common';
import ExcelReaderFactory from '../src/ExcelReaderFactory';

/**
 * Excel reader factory
 */
const readerFactory: ExcelReaderFactory = new ExcelReaderFactory();

/**
 * Tests for {@link ExcelReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
describe('test ExcelReader', () => {
  test('get workbook', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Simple Template.xlsx`);
    const workbook = await excelReader.getWorkbook();
    expect(workbook).not.toBeNull();
  });

  test('get workbook name', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();
    expect(excelReader.getWorkbookName(workbook)).toBe(`${__dirname}/resources/Workbook1.xlsx`);
  });

  test('list sheets', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();
    const sheets = excelReader.listSheets(workbook);
    expect(sheets.length).toBe(3);
  });

  test('get sheet name', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();
    const sheets = excelReader.listSheets(workbook);
    expect(excelReader.getSheetName(sheets[0])).toBe('Sheet1');
    expect(excelReader.getSheetName(sheets[1])).toBe('Sheet2');
    expect(excelReader.getSheetName(sheets[2])).toBe('Sheet3');
  });

  test('find first occurrence', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Simple Template.xlsx`);
    const workbook = await excelReader.getWorkbook();

    expect(await excelReader.findFirstOccurrence('%TEST_COMMAND1234%', workbook)).toBe(null);
    expect(await excelReader.findFirstOccurrence('%TEST_COMMAND%', workbook)).toBe("'Test Case'!A2");
    expect(await excelReader.findFirstOccurrence('%TEST_PARAM1%', workbook)).toBe("'Test Case'!B2");
    expect(await excelReader.findFirstOccurrence('%TEST_PARAM2%', workbook)).toBe("'Test Case'!C2");
    expect(await excelReader.findFirstOccurrence('%TEST_PARAM3%', workbook)).toBe("'Test Case'!D2");

    const sheets = excelReader.listSheets(workbook);
    expect(await excelReader.findFirstOccurrenceSheet('%TEST_COMMAND%', sheets[0])).toBe("'Test Case'!A2");
    expect(await excelReader.findFirstOccurrenceSheet('%TEST_PARAM1%', sheets[0])).toBe("'Test Case'!B2");
    expect(await excelReader.findFirstOccurrenceSheet('%TEST_PARAM2%', sheets[0])).toBe("'Test Case'!C2");
    expect(await excelReader.findFirstOccurrenceSheet('%TEST_PARAM3%', sheets[0])).toBe("'Test Case'!D2");
  });

  test('batch find first occurrence', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Simple Template.xlsx`);
    const workbook = await excelReader.getWorkbook();

    let cellLocations = await excelReader.batchFindFirstOccurrence(TemplateUtil.getMarkups(), workbook);
    expect(cellLocations.size).toBe(4);
    expect(cellLocations.get('%TEST_COMMAND%')).toBe("'Test Case'!A2");
    expect(cellLocations.get('%TEST_PARAM1%')).toBe("'Test Case'!B2");
    expect(cellLocations.get('%TEST_PARAM2%')).toBe("'Test Case'!C2");
    expect(cellLocations.get('%TEST_PARAM3%')).toBe("'Test Case'!D2");

    const sheets = excelReader.listSheets(workbook);
    cellLocations = await excelReader.batchFindFirstOccurrenceSheet(TemplateUtil.getMarkups(), sheets[0]);
    expect(cellLocations.size).toBe(4);
    expect(cellLocations.get('%TEST_COMMAND%')).toBe("'Test Case'!A2");
    expect(cellLocations.get('%TEST_PARAM1%')).toBe("'Test Case'!B2");
    expect(cellLocations.get('%TEST_PARAM2%')).toBe("'Test Case'!C2");
    expect(cellLocations.get('%TEST_PARAM3%')).toBe("'Test Case'!D2");
  });

  test('get cell value', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    expect(await excelReader.getCellValue('Sheet1!B2', workbook)).toBe('Cell B2');
    expect(await excelReader.getCellValue('Sheet1!C2', workbook)).toBe('Cell C2');
    expect(await excelReader.getCellValue('Sheet1!D2', workbook)).toBe('Cell D2');
    expect(await excelReader.getCellValue('Sheet1!E2', workbook)).toBe(0);
    expect(await excelReader.getCellValue('Sheet1!B3', workbook)).toBe(1);
    expect(await excelReader.getCellValue('Sheet1!C3', workbook)).toBe(2);
    expect(await excelReader.getCellValue('Sheet1!B4', workbook)).toBe(true);
    expect(await excelReader.getCellValue('Sheet1!C4', workbook)).toBe(false);
    expect(await excelReader.getCellValue('Sheet1!D4', workbook)).toBe(true);
    // expect(await excelReader.getCellValue("Sheet1!E4", workbook)).toBe(false);
    expect(await excelReader.getCellValue('Sheet1!B5', workbook)).toBe(1.1);
    expect(await excelReader.getCellValue('Sheet1!C5', workbook)).toBe(2.1);
    expect(await excelReader.getCellValue('Sheet1!B6', workbook)).toStrictEqual(new Date('2018-01-01'));
    expect(await excelReader.getCellValue('Sheet1!C6', workbook)).toStrictEqual(new Date('2018-01-02'));
    expect(await excelReader.getCellValue('Sheet1!B7', workbook)).toBe(1);
    expect(await excelReader.getCellValue('Sheet1!C7', workbook)).toBe('2.2');
    expect(await excelReader.getCellValue('Sheet1!B8', workbook)).toStrictEqual(new Date('2018-01-01'));
    expect(await excelReader.getCellValue('Sheet1!C8', workbook)).toStrictEqual(new Date('2018-01-02'));
  });

  test('get row cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    let rowCellValues = await excelReader.getRowCellValues('Sheet1!B2:E3', workbook);
    expect(rowCellValues[0]).toBe('Cell B2');
    expect(rowCellValues[1]).toBe('Cell C2');
    expect(rowCellValues[2]).toBe('Cell D2');

    rowCellValues = await excelReader.getRowCellValues('Sheet1!B4:E5', workbook);
    expect(rowCellValues[0]).toBe(true);
    expect(rowCellValues[1]).toBe(false);
    expect(rowCellValues[2]).toBe(true);
    // expect(rowCellValues[3]).toBe(false);

    rowCellValues = await excelReader.getRowCellValues('Sheet1!B6:E8', workbook);
    expect(rowCellValues[0]).toStrictEqual(new Date('2018-01-01'));
    expect(rowCellValues[1]).toStrictEqual(new Date('2018-01-02'));
  });

  test('get column cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    let columnCellValues = await excelReader.getColumnCellValues('Sheet1!B2:C7', workbook);
    expect(columnCellValues[0]).toBe('Cell B2');
    expect(columnCellValues[1]).toBe(1);
    expect(columnCellValues[2]).toBe(true);
    expect(columnCellValues[3]).toBe(1.1);
    expect(columnCellValues[4]).toStrictEqual(new Date('2018-01-01'));
    expect(columnCellValues[5]).toBe(1);

    columnCellValues = await excelReader.getColumnCellValues('Sheet1!D2:E7', workbook);
    expect(columnCellValues[0]).toBe('Cell D2');
    expect(columnCellValues[1]).toBe(null);
    expect(columnCellValues[2]).toBe(true);
  });

  test('get range cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    const rangeCellValue = await excelReader.getRangeCellValues('Sheet1!B2:E8', workbook);
    expect(rangeCellValue[0][0]).toBe('Cell B2');
    expect(rangeCellValue[0][1]).toBe('Cell C2');
    expect(rangeCellValue[0][2]).toBe('Cell D2');
    expect(rangeCellValue[1][0]).toBe(1);
    expect(rangeCellValue[1][1]).toBe(2);
    expect(rangeCellValue[2][0]).toBe(true);
    expect(rangeCellValue[2][1]).toBe(false);
    expect(rangeCellValue[2][2]).toBe(true);
    // expect(rangeCellValue[2][3]).toBe(false);
    expect(rangeCellValue[3][0]).toBe(1.1);
    expect(rangeCellValue[3][1]).toBe(2.1);
    expect(rangeCellValue[4][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValue[4][1]).toStrictEqual(new Date('2018-01-02'));
    expect(rangeCellValue[5][0]).toBe(1);
    expect(rangeCellValue[5][1]).toBe('2.2');
    expect(rangeCellValue[6][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValue[6][1]).toStrictEqual(new Date('2018-01-02'));
  });

  test('batch get cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    const cellValues = await excelReader.batchGetCellValues(
      [
        'Sheet1!B2',
        'Sheet1!C2',
        'Sheet1!D2',
        'Sheet1!B3',
        'Sheet1!C3',
        'Sheet1!B4',
        'Sheet1!C4',
        'Sheet1!D4',
        'Sheet1!E4',
        'Sheet1!B5',
        'Sheet1!C5',
        'Sheet1!B6',
        'Sheet1!C6',
        'Sheet1!B7',
        'Sheet1!C7',
        'Sheet1!B8',
        'Sheet1!C8',
      ],
      workbook
    );
    expect(cellValues.get('Sheet1!B2')).toBe('Cell B2');
    expect(cellValues.get('Sheet1!C2')).toBe('Cell C2');
    expect(cellValues.get('Sheet1!D2')).toBe('Cell D2');
    expect(cellValues.get('Sheet1!B3')).toBe(1);
    expect(cellValues.get('Sheet1!C3')).toBe(2);
    expect(cellValues.get('Sheet1!B4')).toBe(true);
    expect(cellValues.get('Sheet1!C4')).toBe(false);
    expect(cellValues.get('Sheet1!D4')).toBe(true);
    // expect(cellValues.get("Sheet1!E4")).toBe(false);
    expect(cellValues.get('Sheet1!B5')).toBe(1.1);
    expect(cellValues.get('Sheet1!C5')).toBe(2.1);
    expect(cellValues.get('Sheet1!B6')).toStrictEqual(new Date('2018-01-01'));
    expect(cellValues.get('Sheet1!C6')).toStrictEqual(new Date('2018-01-02'));
    expect(cellValues.get('Sheet1!B7')).toBe(1);
    expect(cellValues.get('Sheet1!C7')).toBe('2.2');
    expect(cellValues.get('Sheet1!B8')).toStrictEqual(new Date('2018-01-01'));
    expect(cellValues.get('Sheet1!C8')).toStrictEqual(new Date('2018-01-02'));
  });

  test('batch get row cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    const rowCellValues = await excelReader.batchGetRowCellValues(['Sheet1!B2:E3', 'Sheet1!B4:E5', 'Sheet1!B6:E8'], workbook);
    expect(rowCellValues.get('Sheet1!B2:E3')![0]).toBe('Cell B2');
    expect(rowCellValues.get('Sheet1!B2:E3')![1]).toBe('Cell C2');
    expect(rowCellValues.get('Sheet1!B2:E3')![2]).toBe('Cell D2');
    expect(rowCellValues.get('Sheet1!B4:E5')![0]).toBe(true);
    expect(rowCellValues.get('Sheet1!B4:E5')![1]).toBe(false);
    expect(rowCellValues.get('Sheet1!B4:E5')![2]).toBe(true);
    // expect(rowCellValues.get("Sheet1!B4:E5")![3]).toBe(false);
    expect(rowCellValues.get('Sheet1!B6:E8')![0]).toStrictEqual(new Date('2018-01-01'));
    expect(rowCellValues.get('Sheet1!B6:E8')![1]).toStrictEqual(new Date('2018-01-02'));
  });

  test('batch get column cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    const columnCellValues = await excelReader.batchGetColumnCellValues(['Sheet1!B2:C7', 'Sheet1!D2:E7'], workbook);
    expect(columnCellValues.get('Sheet1!B2:C7')![0]).toBe('Cell B2');
    expect(columnCellValues.get('Sheet1!B2:C7')![1]).toBe(1);
    expect(columnCellValues.get('Sheet1!B2:C7')![2]).toBe(true);
    expect(columnCellValues.get('Sheet1!B2:C7')![3]).toBe(1.1);
    expect(columnCellValues.get('Sheet1!B2:C7')![4]).toStrictEqual(new Date('2018-01-01'));
    expect(columnCellValues.get('Sheet1!B2:C7')![5]).toBe(1);
    expect(columnCellValues.get('Sheet1!D2:E7')![0]).toBe('Cell D2');
    expect(columnCellValues.get('Sheet1!D2:E7')![1]).toBe(null);
    expect(columnCellValues.get('Sheet1!D2:E7')![2]).toBe(true);
  });

  test('batch get range cell values', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/resources/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();

    const rangeCellValues = await excelReader.batchGetRangeCellValues(
      [
        'Sheet1!B2',
        'Sheet1!C2',
        'Sheet1!D2',
        'Sheet1!B3',
        'Sheet1!C3',
        'Sheet1!B4',
        'Sheet1!C4',
        'Sheet1!D4',
        'Sheet1!E4',
        'Sheet1!B5',
        'Sheet1!C5',
        'Sheet1!B6',
        'Sheet1!C6',
        'Sheet1!B7',
        'Sheet1!C7',
        'Sheet1!B8',
        'Sheet1!C8',
      ],
      workbook
    );
    expect(rangeCellValues.get('Sheet1!B2')![0][0]).toBe('Cell B2');
    expect(rangeCellValues.get('Sheet1!C2')![0][0]).toBe('Cell C2');
    expect(rangeCellValues.get('Sheet1!D2')![0][0]).toBe('Cell D2');
    expect(rangeCellValues.get('Sheet1!B3')![0][0]).toBe(1);
    expect(rangeCellValues.get('Sheet1!C3')![0][0]).toBe(2);
    expect(rangeCellValues.get('Sheet1!B4')![0][0]).toBe(true);
    expect(rangeCellValues.get('Sheet1!C4')![0][0]).toBe(false);
    expect(rangeCellValues.get('Sheet1!D4')![0][0]).toBe(true);
    // expect(rangeCellValues.get("Sheet1!E4")![0][0]).toBe(false);
    expect(rangeCellValues.get('Sheet1!B5')![0][0]).toBe(1.1);
    expect(rangeCellValues.get('Sheet1!C5')![0][0]).toBe(2.1);
    expect(rangeCellValues.get('Sheet1!B6')![0][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValues.get('Sheet1!C6')![0][0]).toStrictEqual(new Date('2018-01-02'));
    expect(rangeCellValues.get('Sheet1!B7')![0][0]).toBe(1);
    expect(rangeCellValues.get('Sheet1!C7')![0][0]).toBe('2.2');
    expect(rangeCellValues.get('Sheet1!B8')![0][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValues.get('Sheet1!C8')![0][0]).toStrictEqual(new Date('2018-01-02'));
  });
});
