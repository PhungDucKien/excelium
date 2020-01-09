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

import AbstractWorkbookWriter from '../../src/writer/AbstractWorkbookWriter';

/**
 * Tests for {@link AbstractWorkbookWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.03
 */
describe('test AbstractWorkbookWriter', () => {
  test('set cell value()', () => {
    const workbookWriter = new MyWorkbookWriter();
    workbookWriter.setCellValue('String', 'Sheet1!A1');

    expect(workbookWriter.getFlushValues().size).toBe(1);
    expect(workbookWriter.getFlushValues().get('Sheet1!A1')![0][0]).toBe('String');
  });

  test('set row cell values()', () => {
    const workbookWriter = new MyWorkbookWriter();
    const rowValues = [] as any[];
    rowValues.push('A1');
    rowValues.push('B1');
    rowValues.push('C1');
    workbookWriter.setRowCellValues(rowValues, 'Sheet1!A1:C1');

    expect(workbookWriter.getFlushValues().size).toBe(1);
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C1')![0][0]).toBe('A1');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C1')![0][1]).toBe('B1');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C1')![0][2]).toBe('C1');
  });

  test('set column cell values()', () => {
    const workbookWriter = new MyWorkbookWriter();
    const columnValues = [] as any[];
    columnValues.push('A1');
    columnValues.push('A2');
    columnValues.push('A3');
    workbookWriter.setColumnCellValues(columnValues, 'Sheet1!A1:A3');

    expect(workbookWriter.getFlushValues().size).toBe(1);
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:A3')![0][0]).toBe('A1');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:A3')![1][0]).toBe('A2');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:A3')![2][0]).toBe('A3');
  });

  test('set range cell values()', () => {
    const workbookWriter = new MyWorkbookWriter();
    const rangeValues = [] as any[][];
    let rowValues = [] as any[];
    rowValues.push('A1');
    rowValues.push('B1');
    rowValues.push('C1');
    rangeValues.push(rowValues);
    rowValues = [] as any[];
    rowValues.push('A2');
    rowValues.push('B2');
    rowValues.push('C2');
    rangeValues.push(rowValues);
    rowValues = [] as any[];
    rowValues.push('A3');
    rowValues.push('B3');
    rowValues.push('C3');
    rangeValues.push(rowValues);
    workbookWriter.setRangeCellValues(rangeValues, 'Sheet1!A1:C3');

    expect(workbookWriter.getFlushValues().size).toBe(1);
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![0][0]).toBe('A1');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![0][1]).toBe('B1');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![0][2]).toBe('C1');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![1][0]).toBe('A2');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![1][1]).toBe('B2');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![1][2]).toBe('C2');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![2][0]).toBe('A3');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![2][1]).toBe('B3');
    expect(workbookWriter.getFlushValues().get('Sheet1!A1:C3')![2][2]).toBe('C3');
  });

  class MyWorkbookWriter extends AbstractWorkbookWriter {
    public getFlushValues() {
      return this.flushValues;
    }

    public async flush(): Promise<void> {
      // Empty
    }
  }
});
