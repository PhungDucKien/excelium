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
import { Browser, PcEnvironment, Template } from '@excelium/model';
import GoogleConnectionService from '../src/connection/GoogleConnectionService';
import SheetsReaderFactory from '../src/SheetsReaderFactory';
import SheetsServiceProvider from '../src/SheetsServiceProvider';

function getReaderFactory(): Promise<SheetsReaderFactory> {
  const connection = new GoogleConnectionService();
  const sheetsServiceProvider = new SheetsServiceProvider(connection);
  return sheetsServiceProvider.createSheetsService().then(sheetsService => new SheetsReaderFactory(sheetsService));
}

/**
 * Tests for {@link SheetsReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
describe('test SheetsReader', () => {
  test('parse test', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('1mNKWaLq-vmXJOGEVEJzUUTfkoBM22Bn6OZz99d6X0DE');

    const webTemplate = new Template();
    webTemplate.location = '1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50';
    webTemplate.name = '1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50 - Web Template';
    webTemplate.actionPattern = 'Actions';
    webTemplate.dataPattern = 'Test Data';
    webTemplate.mappingPattern = 'Mapping';
    webTemplate.testPattern = '*';
    webTemplate.ignorePatterns = ['Commands'];

    const markupLocations = new Map<string, string>();
    markupLocations.set(Template.BASE_URL, 'Configuration!B19');
    markupLocations.set(Template.USE_PC, 'Configuration!B27');
    markupLocations.set(Template.USE_CHROME, 'Configuration!B35');
    markupLocations.set(Template.MAPPING_PAGESET_NAME, 'Mapping!B2');
    markupLocations.set(Template.MAPPING_PAGESET_PATH, 'Mapping!C2');
    markupLocations.set(Template.MAPPING_PAGESET_TITLE, 'Mapping!D2');
    markupLocations.set(Template.MAPPING_ITEM_NAME, 'Mapping!E2');
    markupLocations.set(Template.MAPPING_ITEM_VALUE, 'Mapping!F2');
    markupLocations.set(Template.ACTION_NO, 'Actions!A3');
    markupLocations.set(Template.ACTION_GUTTER, 'Actions!B3');
    markupLocations.set(Template.ACTION_CAPTURE, 'Actions!C3');
    markupLocations.set(Template.ACTION_NAME, 'Actions!E3');
    markupLocations.set(Template.ACTION_COMMAND, 'Actions!F3');
    markupLocations.set(Template.ACTION_PARAM1, 'Actions!G3');
    markupLocations.set(Template.ACTION_PARAM2, 'Actions!H3');
    markupLocations.set(Template.ACTION_PARAM3, 'Actions!I3');
    markupLocations.set(Template.ACTION_DATA, 'Actions!J3');
    markupLocations.set(Template.TEST_NO, "'Test Case'!A3");
    markupLocations.set(Template.TEST_GUTTER, "'Test Case'!B3");
    markupLocations.set(Template.TEST_CAPTURE, "'Test Case'!C3");
    markupLocations.set(Template.TEST_NAME, "'Test Case'!E3");
    markupLocations.set(Template.TEST_COMMAND, "'Test Case'!F3");
    markupLocations.set(Template.TEST_PARAM1, "'Test Case'!G3");
    markupLocations.set(Template.TEST_PARAM2, "'Test Case'!H3");
    markupLocations.set(Template.TEST_PARAM3, "'Test Case'!I3");
    markupLocations.set(Template.TEST_DATA, "'Test Case'!J3");
    markupLocations.set(Template.DATA_NAME, "'Test Data'!A1");
    markupLocations.set(Template.DATA_DESC, "'Test Data'!B2");
    markupLocations.set(Template.DATA_TABLE_DEF, "'Test Data'!B3");
    markupLocations.set(Template.DATA_TABLE_DATA, "'Test Data'!B4");
    webTemplate.markupLocations = markupLocations;

    const workbook = await sheetsReader.getWorkbook();

    const test = await sheetsReader.parseTest(webTemplate, workbook);

    expect(test.workbookName).toBe('1mNKWaLq-vmXJOGEVEJzUUTfkoBM22Bn6OZz99d6X0DE - Web Test');
    expect(test.config.baseUrl).toBe('https://google.com.vn');
    expect(test.config.environments.length).toBe(1);
    expect((test.config.environments[0] as PcEnvironment).browser).toBe(Browser.CHROME);

    expect(test.pageSets.size).toBeGreaterThan(0);
    expect(test.actions.size).toBeGreaterThan(0);
    expect(test.testSuites.size).toBeGreaterThan(0);
    expect(test.testData.size).toBeGreaterThan(0);
  }, 60000);

  test('get workbook', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    expect(await sheetsReader.getWorkbook()).not.toBe(null);
  }, 60000);

  test('get workbook name', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();
    expect(sheetsReader.getWorkbookName(workbook)).toBe('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q - Workbook1.xlsx');
  }, 60000);

  test('list sheets', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();
    const sheets = sheetsReader.listSheets(workbook);
    expect(sheets.length).toBe(3);
  }, 60000);

  test('get sheet name', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();
    const sheets = sheetsReader.listSheets(workbook);
    expect(sheetsReader.getSheetName(sheets[0])).toBe('Sheet1');
    expect(sheetsReader.getSheetName(sheets[1])).toBe('Sheet2');
    expect(sheetsReader.getSheetName(sheets[2])).toBe('Sheet3');
  }, 60000);

  test('find first occurrence', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY');
    const workbook = await sheetsReader.getWorkbook();

    expect(await sheetsReader.findFirstOccurrence('%TEST_COMMAND1234%', workbook)).toBe(null);
    expect(await sheetsReader.findFirstOccurrence('%TEST_COMMAND%', workbook)).toBe("'Test Case'!A2");
    expect(await sheetsReader.findFirstOccurrence('%TEST_PARAM1%', workbook)).toBe("'Test Case'!B2");
    expect(await sheetsReader.findFirstOccurrence('%TEST_PARAM2%', workbook)).toBe("'Test Case'!C2");
    expect(await sheetsReader.findFirstOccurrence('%TEST_PARAM3%', workbook)).toBe("'Test Case'!D2");

    const sheets = sheetsReader.listSheets(workbook);
    expect(await sheetsReader.findFirstOccurrenceSheet('%TEST_COMMAND%', sheets[0], workbook)).toBe("'Test Case'!A2");
    expect(await sheetsReader.findFirstOccurrenceSheet('%TEST_PARAM1%', sheets[0], workbook)).toBe("'Test Case'!B2");
    expect(await sheetsReader.findFirstOccurrenceSheet('%TEST_PARAM2%', sheets[0], workbook)).toBe("'Test Case'!C2");
    expect(await sheetsReader.findFirstOccurrenceSheet('%TEST_PARAM3%', sheets[0], workbook)).toBe("'Test Case'!D2");
  }, 60000);

  test('batch find first occurrence', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY');
    const workbook = await sheetsReader.getWorkbook();

    let cellLocations = await sheetsReader.batchFindFirstOccurrence(TemplateUtil.getMarkups(), workbook);
    expect(cellLocations.size).toBe(4);
    expect(cellLocations.get('%TEST_COMMAND%')).toBe("'Test Case'!A2");
    expect(cellLocations.get('%TEST_PARAM1%')).toBe("'Test Case'!B2");
    expect(cellLocations.get('%TEST_PARAM2%')).toBe("'Test Case'!C2");
    expect(cellLocations.get('%TEST_PARAM3%')).toBe("'Test Case'!D2");

    const sheets = sheetsReader.listSheets(workbook);
    cellLocations = await sheetsReader.batchFindFirstOccurrenceSheet(TemplateUtil.getMarkups(), sheets[0], workbook);
    expect(cellLocations.size).toBe(4);
    expect(cellLocations.get('%TEST_COMMAND%')).toBe("'Test Case'!A2");
    expect(cellLocations.get('%TEST_PARAM1%')).toBe("'Test Case'!B2");
    expect(cellLocations.get('%TEST_PARAM2%')).toBe("'Test Case'!C2");
    expect(cellLocations.get('%TEST_PARAM3%')).toBe("'Test Case'!D2");
  }, 60000);

  test('get cell value', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    expect(await sheetsReader.getCellValue('Sheet1!B2', workbook)).toBe('Cell B2');
    expect(await sheetsReader.getCellValue('Sheet1!C2', workbook)).toBe('Cell C2');
    expect(await sheetsReader.getCellValue('Sheet1!D2', workbook)).toBe('Cell D2');
    expect(await sheetsReader.getCellValue('Sheet1!B3', workbook)).toBe(1);
    expect(await sheetsReader.getCellValue('Sheet1!C3', workbook)).toBe(2);
    expect(await sheetsReader.getCellValue('Sheet1!B4', workbook)).toBe(true);
    expect(await sheetsReader.getCellValue('Sheet1!C4', workbook)).toBe(false);
    expect(await sheetsReader.getCellValue('Sheet1!D4', workbook)).toBe(true);
    expect(await sheetsReader.getCellValue('Sheet1!E4', workbook)).toBe(false);
    expect(await sheetsReader.getCellValue('Sheet1!B5', workbook)).toBe(1.1);
    expect(await sheetsReader.getCellValue('Sheet1!C5', workbook)).toBe(2.1);
    expect(await sheetsReader.getCellValue('Sheet1!B6', workbook)).toStrictEqual(new Date('2018-01-01'));
    expect(await sheetsReader.getCellValue('Sheet1!C6', workbook)).toStrictEqual(new Date('2018-01-02'));
    expect(await sheetsReader.getCellValue('Sheet1!B7', workbook)).toBe(1);
    expect(await sheetsReader.getCellValue('Sheet1!C7', workbook)).toBe('2.2');
    expect(await sheetsReader.getCellValue('Sheet1!B8', workbook)).toStrictEqual(new Date('2018-01-01'));
    expect(await sheetsReader.getCellValue('Sheet1!C8', workbook)).toStrictEqual(new Date('2018-01-02'));
  }, 60000);

  test('get row cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    let rowCellValues = await sheetsReader.getRowCellValues('Sheet1!B2:E3', workbook);
    expect(rowCellValues[0]).toBe('Cell B2');
    expect(rowCellValues[1]).toBe('Cell C2');
    expect(rowCellValues[2]).toBe('Cell D2');

    rowCellValues = await sheetsReader.getRowCellValues('Sheet1!B4:E5', workbook);
    expect(rowCellValues[0]).toBe(true);
    expect(rowCellValues[1]).toBe(false);
    expect(rowCellValues[2]).toBe(true);
    expect(rowCellValues[3]).toBe(false);

    rowCellValues = await sheetsReader.getRowCellValues('Sheet1!B6:E8', workbook);
    expect(rowCellValues[0]).toStrictEqual(new Date('2018-01-01'));
    expect(rowCellValues[1]).toStrictEqual(new Date('2018-01-02'));
  }, 60000);

  test('get column cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    let columnCellValues = await sheetsReader.getColumnCellValues('Sheet1!B2:C7', workbook);
    expect(columnCellValues[0]).toBe('Cell B2');
    expect(columnCellValues[1]).toBe(1);
    expect(columnCellValues[2]).toBe(true);
    expect(columnCellValues[3]).toBe(1.1);
    expect(columnCellValues[4]).toStrictEqual(new Date('2018-01-01'));
    expect(columnCellValues[5]).toBe(1);

    columnCellValues = await sheetsReader.getColumnCellValues('Sheet1!D2:E7', workbook);
    expect(columnCellValues[0]).toBe('Cell D2');
    expect(columnCellValues[1]).toBe(null);
    expect(columnCellValues[2]).toBe(true);
  }, 60000);

  test('get range cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    const rangeCellValue = await sheetsReader.getRangeCellValues('Sheet1!B2:E8', workbook);
    expect(rangeCellValue[0][0]).toBe('Cell B2');
    expect(rangeCellValue[0][1]).toBe('Cell C2');
    expect(rangeCellValue[0][2]).toBe('Cell D2');
    expect(rangeCellValue[1][0]).toBe(1);
    expect(rangeCellValue[1][1]).toBe(2);
    expect(rangeCellValue[2][0]).toBe(true);
    expect(rangeCellValue[2][1]).toBe(false);
    expect(rangeCellValue[2][2]).toBe(true);
    expect(rangeCellValue[2][3]).toBe(false);
    expect(rangeCellValue[3][0]).toBe(1.1);
    expect(rangeCellValue[3][1]).toBe(2.1);
    expect(rangeCellValue[4][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValue[4][1]).toStrictEqual(new Date('2018-01-02'));
    expect(rangeCellValue[5][0]).toBe(1);
    expect(rangeCellValue[5][1]).toBe('2.2');
    expect(rangeCellValue[6][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValue[6][1]).toStrictEqual(new Date('2018-01-02'));
  }, 60000);

  test('batch get cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    const cellValues = await sheetsReader.batchGetCellValues(
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
    expect(cellValues.get('Sheet1!E4')).toBe(false);
    expect(cellValues.get('Sheet1!B5')).toBe(1.1);
    expect(cellValues.get('Sheet1!C5')).toBe(2.1);
    expect(cellValues.get('Sheet1!B6')).toStrictEqual(new Date('2018-01-01'));
    expect(cellValues.get('Sheet1!C6')).toStrictEqual(new Date('2018-01-02'));
    expect(cellValues.get('Sheet1!B7')).toBe(1);
    expect(cellValues.get('Sheet1!C7')).toBe('2.2');
    expect(cellValues.get('Sheet1!B8')).toStrictEqual(new Date('2018-01-01'));
    expect(cellValues.get('Sheet1!C8')).toStrictEqual(new Date('2018-01-02'));
  }, 60000);

  test('batch get row cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    const rowCellValues = await sheetsReader.batchGetRowCellValues(['Sheet1!B2:E3', 'Sheet1!B4:E5', 'Sheet1!B6:E8'], workbook);
    expect(rowCellValues.get('Sheet1!B2:E3')![0]).toBe('Cell B2');
    expect(rowCellValues.get('Sheet1!B2:E3')![1]).toBe('Cell C2');
    expect(rowCellValues.get('Sheet1!B2:E3')![2]).toBe('Cell D2');
    expect(rowCellValues.get('Sheet1!B4:E5')![0]).toBe(true);
    expect(rowCellValues.get('Sheet1!B4:E5')![1]).toBe(false);
    expect(rowCellValues.get('Sheet1!B4:E5')![2]).toBe(true);
    expect(rowCellValues.get('Sheet1!B4:E5')![3]).toBe(false);
    expect(rowCellValues.get('Sheet1!B6:E8')![0]).toStrictEqual(new Date('2018-01-01'));
    expect(rowCellValues.get('Sheet1!B6:E8')![1]).toStrictEqual(new Date('2018-01-02'));
  }, 60000);

  test('batch get column cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    const columnCellValues = await sheetsReader.batchGetColumnCellValues(['Sheet1!B2:C7', 'Sheet1!D2:E7'], workbook);
    expect(columnCellValues.get('Sheet1!B2:C7')![0]).toBe('Cell B2');
    expect(columnCellValues.get('Sheet1!B2:C7')![1]).toBe(1);
    expect(columnCellValues.get('Sheet1!B2:C7')![2]).toBe(true);
    expect(columnCellValues.get('Sheet1!B2:C7')![3]).toBe(1.1);
    expect(columnCellValues.get('Sheet1!B2:C7')![4]).toStrictEqual(new Date('2018-01-01'));
    expect(columnCellValues.get('Sheet1!B2:C7')![5]).toBe(1);
    expect(columnCellValues.get('Sheet1!D2:E7')![0]).toBe('Cell D2');
    expect(columnCellValues.get('Sheet1!D2:E7')![1]).toBe(null);
    expect(columnCellValues.get('Sheet1!D2:E7')![2]).toBe(true);
  }, 60000);

  test('batch get range cell values', async () => {
    const readerFactory = await getReaderFactory();
    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();

    const rangeCellValues = await sheetsReader.batchGetRangeCellValues(
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
    expect(rangeCellValues.get('Sheet1!E4')![0][0]).toBe(false);
    expect(rangeCellValues.get('Sheet1!B5')![0][0]).toBe(1.1);
    expect(rangeCellValues.get('Sheet1!C5')![0][0]).toBe(2.1);
    expect(rangeCellValues.get('Sheet1!B6')![0][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValues.get('Sheet1!C6')![0][0]).toStrictEqual(new Date('2018-01-02'));
    expect(rangeCellValues.get('Sheet1!B7')![0][0]).toBe(1);
    expect(rangeCellValues.get('Sheet1!C7')![0][0]).toBe('2.2');
    expect(rangeCellValues.get('Sheet1!B8')![0][0]).toStrictEqual(new Date('2018-01-01'));
    expect(rangeCellValues.get('Sheet1!C8')![0][0]).toStrictEqual(new Date('2018-01-02'));
  }, 60000);
});
