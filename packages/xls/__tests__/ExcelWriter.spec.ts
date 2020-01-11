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

import fs from 'fs-extra';
import ExcelReaderFactory from '../src/ExcelReaderFactory';
import ExcelWriterFactory from '../src/ExcelWriterFactory';

/**
 * Excel reader factory
 */
const readerFactory = new ExcelReaderFactory();

/**
 * Excel writer factory
 */
const writerFactory = new ExcelWriterFactory();

fs.ensureDirSync(`${__dirname}/build`);
fs.copyFileSync(`${__dirname}/resources/Workbook1.xlsx`, `${__dirname}/build/Workbook1.xlsx`);

/**
 * Tests for {@link ExcelWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.04
 */
describe('test ExcelWriter', () => {
  test('flush', async () => {
    const excelReader = readerFactory.createReader(`${__dirname}/build/Workbook1.xlsx`);
    const workbook = await excelReader.getWorkbook();
    const excelWriter = writerFactory.createWriter(workbook, `${__dirname}/build/Workbook1.xlsx`);

    const columnValues = [] as any[];
    for (let i = 0; i < 8; i++) {
      columnValues.push(null);
    }
    excelWriter.setColumnCellValues(columnValues, 'Sheet2!A1:A8');
    await excelWriter.close();

    const excelReader1 = readerFactory.createReader(`${__dirname}/build/Workbook1.xlsx`);
    const workbook1 = await excelReader1.getWorkbook();

    expect(await excelReader1.getCellValue('Sheet2!A1', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A2', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A3', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A4', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A5', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A6', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A7', workbook1)).toBe(null);
    expect(await excelReader1.getCellValue('Sheet2!A8', workbook1)).toBe(null);

    const excelWriter1 = writerFactory.createWriter(workbook1, `${__dirname}/build/Workbook1.xlsx`);

    excelWriter1.setCellValue('1', 'Sheet2!A1');
    excelWriter1.setCellValue(true, 'Sheet2!A2');
    const date = new Date(2018, 0, 1, 0, 0, 0);
    excelWriter1.setCellValue(date, 'Sheet2!A3');
    excelWriter1.setCellValue(date, 'Sheet2!A4');
    excelWriter1.setCellValue(1.1, 'Sheet2!A5');
    excelWriter1.setCellValue(1, 'Sheet2!A6');
    excelWriter1.setCellValue(1, 'Sheet2!A7');
    excelWriter1.setCellValue(null, 'Sheet2!A8');
    await excelWriter1.close();

    const excelReader2 = readerFactory.createReader(`${__dirname}/build/Workbook1.xlsx`);
    const workbook2 = await excelReader2.getWorkbook();

    expect(await excelReader2.getCellValue('Sheet2!A1', workbook2)).toBe('1');
    expect(await excelReader2.getCellValue('Sheet2!A2', workbook2)).toBe(true);
    expect(await excelReader2.getCellValue('Sheet2!A3', workbook2)).toStrictEqual(date);
    expect(await excelReader2.getCellValue('Sheet2!A4', workbook2)).toStrictEqual(date);
    expect(await excelReader2.getCellValue('Sheet2!A5', workbook2)).toBe(1.1);
    expect(await excelReader2.getCellValue('Sheet2!A6', workbook2)).toBe(1);
    expect(await excelReader2.getCellValue('Sheet2!A7', workbook2)).toBe(1);
    expect(await excelReader2.getCellValue('Sheet2!A8', workbook2)).toBe(null);
  });
});
