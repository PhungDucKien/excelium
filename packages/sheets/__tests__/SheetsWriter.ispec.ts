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

import { sheets_v4 } from 'googleapis';
import GoogleConnectionService from '../src/connection/GoogleConnectionService';
import SheetsReaderFactory from '../src/SheetsReaderFactory';
import SheetsServiceProvider from '../src/SheetsServiceProvider';
import SheetsWriterFactory from '../src/SheetsWriterFactory';

function getSheetsService(): Promise<sheets_v4.Sheets> {
  const connection = new GoogleConnectionService();
  const sheetsServiceProvider = new SheetsServiceProvider(connection);
  return sheetsServiceProvider.createSheetsService();
}

/**
 * Tests for {@link SheetsWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.03
 */
describe('test SheetsWriter', () => {
  test('flush', async () => {
    const sheetsService = await getSheetsService();
    const readerFactory = new SheetsReaderFactory(sheetsService);
    const writerFactory = new SheetsWriterFactory(sheetsService);

    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();
    const sheetsWriter = writerFactory.createWriter(workbook, '12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');

    const columnValues = [] as any[];
    for (let i = 0; i < 10; i++) {
      columnValues.push('');
    }

    sheetsWriter.setColumnCellValues(columnValues, 'Sheet2!A1:A10');
    await sheetsWriter.flush();

    expect(await sheetsReader.getCellValue('Sheet2!A1', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A2', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A3', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A4', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A5', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A6', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A7', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A8', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A9', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A10', workbook)).toBe(null);

    sheetsWriter.setCellValue('String', 'Sheet2!A1');
    sheetsWriter.setCellValue(true, 'Sheet2!A2');
    sheetsWriter.setCellValue(1.1, 'Sheet2!A3');
    sheetsWriter.setCellValue(1, 'Sheet2!A4');
    sheetsWriter.setCellValue(1, 'Sheet2!A5');
    sheetsWriter.setCellValue(null, 'Sheet2!A6');
    sheetsWriter.setCellValue('1.1', 'Sheet2!A7');
    sheetsWriter.setCellValue('1', 'Sheet2!A8');
    sheetsWriter.setCellValue(new Date('2018-01-01'), 'Sheet2!A9');
    sheetsWriter.setCellValue('TRUE', 'Sheet2!A10');
    await sheetsWriter.flush();

    expect(await sheetsReader.getCellValue('Sheet2!A1', workbook)).toBe('String');
    expect(await sheetsReader.getCellValue('Sheet2!A2', workbook)).toBe(true);
    expect(await sheetsReader.getCellValue('Sheet2!A3', workbook)).toBe(1.1);
    expect(await sheetsReader.getCellValue('Sheet2!A4', workbook)).toBe(1);
    expect(await sheetsReader.getCellValue('Sheet2!A5', workbook)).toBe(1);
    expect(await sheetsReader.getCellValue('Sheet2!A6', workbook)).toBe(null);
    expect(await sheetsReader.getCellValue('Sheet2!A7', workbook)).toBe(1.1);
    expect(await sheetsReader.getCellValue('Sheet2!A8', workbook)).toBe(1);
    expect(await sheetsReader.getCellValue('Sheet2!A9', workbook)).toStrictEqual(new Date('2018-01-01'));
    expect(await sheetsReader.getCellValue('Sheet2!A10', workbook)).toBe(true);
  }, 60000);

  test('flush interval', async done => {
    const sheetsService = await getSheetsService();
    const readerFactory = new SheetsReaderFactory(sheetsService);
    const writerFactory = new SheetsWriterFactory(sheetsService);

    const sheetsReader = readerFactory.createReader('12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');
    const workbook = await sheetsReader.getWorkbook();
    const sheetsWriter = writerFactory.createWriter(workbook, '12-ZymkuT2--PY0drfTqWrufyszVUTIoSNpBBr232Z3Q');

    sheetsWriter.setCellValue(0, 'Sheet2!A1');
    await sheetsWriter.flush();

    for (let i = 1; i <= 99; i++) {
      sheetsWriter.setCellValue(i, 'Sheet2!A' + i);
    }
    expect(await sheetsReader.getCellValue('Sheet2!A1', workbook)).toBe(0);

    sheetsWriter.setCellValue(100, 'Sheet2!A100');

    setTimeout(async () => {
      expect(await sheetsReader.getCellValue('Sheet2!A1', workbook)).toBe(1);
      done();
    }, 2000);
  }, 60000);
});
