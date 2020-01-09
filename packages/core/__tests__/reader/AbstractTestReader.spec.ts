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

import AbstractTestReader, { DataLocation } from '../../src/reader/AbstractTestReader';

class MyTestReader extends AbstractTestReader<string, string> {
  public async getWorkbook(): Promise<string> {
    return '';
  }

  public getWorkbookName(): string {
    return '';
  }

  public listSheets(): string[] {
    return [];
  }

  public getSheetName(): string {
    return '';
  }

  public async batchFindFirstOccurrenceSheet(): Promise<Map<string, string>> {
    return new Map<string, string>();
  }

  public async batchGetRangeCellValues(): Promise<Map<string, any[][]>> {
    return new Map<string, any[][]>();
  }
}

/**
 * Tests for {@link AbstractTestReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.23
 */
describe('test AbstractTestReader', () => {
  test('partition column cell values', () => {
    const testReader = new MyTestReader();

    const columnValuesMap = new Map<string, any[]>();
    const column1 = [] as any[];
    column1.push('Name1');
    column1.push(null);
    column1.push('Name2');
    column1.push(null);
    column1.push('Name3');
    column1.push(null);
    const column2 = [] as any[];
    column2.push('Address1');
    column2.push(null);
    column2.push('Address2');
    column2.push(null);
    column2.push('Address3');
    column2.push(null);
    const column3 = [] as any[];
    column3.push('12367890');
    column3.push('12678907');
    column3.push('89786440');
    column3.push('97867561');
    column3.push('35678798');
    column3.push('87186323');
    columnValuesMap.set('A', column1);
    columnValuesMap.set('C', column2);
    columnValuesMap.set('E', column3);

    // @ts-ignore
    const tableValues = testReader.partitionColumnCellValues(columnValuesMap, 2);
    expect(tableValues.length).toBe(3);

    let rowValues = tableValues[0];
    expect(rowValues.size).toBe(3);
    expect(rowValues.get('A')![0]).toBe('Name1');
    expect(rowValues.get('C')![0]).toBe('Address1');
    expect(rowValues.get('E')![0]).toBe('12367890');
    expect(rowValues.get('E')![1]).toBe('12678907');

    rowValues = tableValues[1];
    expect(rowValues.size).toBe(3);
    expect(rowValues.get('A')![0]).toBe('Name2');
    expect(rowValues.get('C')![0]).toBe('Address2');
    expect(rowValues.get('E')![0]).toBe('89786440');
    expect(rowValues.get('E')![1]).toBe('97867561');

    rowValues = tableValues[2];
    expect(rowValues.size).toBe(3);
    expect(rowValues.get('A')![0]).toBe('Name3');
    expect(rowValues.get('C')![0]).toBe('Address3');
    expect(rowValues.get('E')![0]).toBe('35678798');
    expect(rowValues.get('E')![1]).toBe('87186323');
  });

  test('get item list by column cell values', () => {
    const testReader = new MyTestReader();

    const columnCellValues = new Array<Map<string, any[]>>();
    let columnValuesMap = new Map<string, any[]>();
    let column1 = [] as any[];
    column1.push('Name1');
    column1.push(null);
    let column2 = [] as any[];
    column2.push('Address1');
    column2.push(null);
    let column3 = [] as any[];
    column3.push('12367890');
    column3.push('12678907');
    columnValuesMap.set('A', column1);
    columnValuesMap.set('C', column2);
    columnValuesMap.set('E', column3);
    columnCellValues.push(columnValuesMap);

    columnValuesMap = new Map<string, any[]>();
    column1 = [] as any[];
    column1.push('Name2');
    column1.push(null);
    column2 = [] as any[];
    column2.push('Address2');
    column2.push(null);
    column3 = [] as any[];
    column3.push('89786440');
    column3.push('97867561');
    columnValuesMap.set('A', column1);
    columnValuesMap.set('C', column2);
    columnValuesMap.set('E', column3);
    columnCellValues.push(columnValuesMap);

    columnValuesMap = new Map<string, any[]>();
    column1 = [] as any[];
    column1.push('Name3');
    column1.push(null);
    column2 = [] as any[];
    column2.push('Address3');
    column2.push(null);
    column3 = [] as any[];
    column3.push('35678798');
    column3.push('87186323');
    columnValuesMap.set('A', column1);
    columnValuesMap.set('C', column2);
    columnValuesMap.set('E', column3);
    columnCellValues.push(columnValuesMap);

    const dataLocations = new Map<string, DataLocation>();
    dataLocations.set('NAME', new DataLocation('A', 0));
    dataLocations.set('ADDRESS', new DataLocation('C', 0));
    dataLocations.set('PHONE1', new DataLocation('E', 0));
    dataLocations.set('PHONE2', new DataLocation('E', 1));

    // @ts-ignore
    const tableValues = testReader.getItemListByColumnCellValues(columnCellValues, dataLocations);
    expect(tableValues.length).toBe(3);

    let rowValues = tableValues[0];
    expect(rowValues.size).toBe(4);
    expect(rowValues.get('NAME')).toBe('Name1');
    expect(rowValues.get('ADDRESS')).toBe('Address1');
    expect(rowValues.get('PHONE1')).toBe('12367890');
    expect(rowValues.get('PHONE2')).toBe('12678907');

    rowValues = tableValues[1];
    expect(rowValues.size).toBe(4);
    expect(rowValues.get('NAME')).toBe('Name2');
    expect(rowValues.get('ADDRESS')).toBe('Address2');
    expect(rowValues.get('PHONE1')).toBe('89786440');
    expect(rowValues.get('PHONE2')).toBe('97867561');

    rowValues = tableValues[2];
    expect(rowValues.size).toBe(4);
    expect(rowValues.get('NAME')).toBe('Name3');
    expect(rowValues.get('ADDRESS')).toBe('Address3');
    expect(rowValues.get('PHONE1')).toBe('35678798');
    expect(rowValues.get('PHONE2')).toBe('87186323');
  });
});
