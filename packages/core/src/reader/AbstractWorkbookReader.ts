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

import { CollectionUtil, RangeLocation, StringUtil } from '@excelium/common';
import WorkbookReader from './WorkbookReader';

/**
 * Abstract workbook reader.
 * This class implements some helper methods for inquiring and searching cell values.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.23
 */
export default abstract class AbstractWorkbookReader<W, S> implements WorkbookReader<W, S> {
  public abstract getWorkbook(): Promise<W>;

  public abstract getWorkbookName(workbook: W): string;

  public abstract listSheets(workbook: W): S[];

  public abstract getSheetName(sheet: S): string;

  public abstract batchFindFirstOccurrenceSheet(values: any[], sheet: S, workbook?: W): Promise<Map<string, string>>;

  public abstract batchGetRangeCellValues(ranges: string[], workbook: W): Promise<Map<string, any[][]>>;

  public async findFirstOccurrence(value: any, workbook: W): Promise<string | null> {
    const sheets = this.listSheets(workbook);
    for (const sheet of sheets) {
      const sheetCellLocation = await this.findFirstOccurrenceSheet(value, sheet, workbook);
      if (sheetCellLocation && StringUtil.isNotBlank(sheetCellLocation)) {
        return sheetCellLocation;
      }
    }
    return null;
  }

  public async batchFindFirstOccurrence(values: any[], workbook: W): Promise<Map<string, string>> {
    const locationMap = new Map<string, string>();

    const sheets = this.listSheets(workbook);
    for (const sheet of sheets) {
      const sheetCellLocations = await this.batchFindFirstOccurrenceSheet(values, sheet, workbook);

      for (const value of values) {
        const sheetCellLocation = sheetCellLocations.get(value);
        if (!locationMap.has(value) && sheetCellLocation && StringUtil.isNotBlank(sheetCellLocation)) {
          locationMap.set(value, sheetCellLocation);
        }
      }
    }
    return locationMap;
  }

  public async findFirstOccurrenceSheet(value: any, sheet: S, workbook?: W): Promise<string | null> {
    const values = [] as any[];
    values.push(value);

    const sheetCellLocations = await this.batchFindFirstOccurrenceSheet(values, sheet, workbook);
    return sheetCellLocations.get(value) || null;
  }

  public async getCellValue(cell: string, workbook: W): Promise<any> {
    return (await this.batchGetCellValues([cell], workbook)).get(cell);
  }

  public async getRowCellValues(row: string, workbook: W): Promise<any[]> {
    return (await this.batchGetRowCellValues([row], workbook)).get(row) || [];
  }

  public async getColumnCellValues(column: string, workbook: W): Promise<any[]> {
    return (await this.batchGetColumnCellValues([column], workbook)).get(column) || [];
  }

  public async getRangeCellValues(range: string, workbook: W): Promise<any[][]> {
    return (await this.batchGetRangeCellValues([range], workbook)).get(range) || [];
  }

  public async batchGetCellValues(cells: string[], workbook: W): Promise<Map<string, any>> {
    const batchRangeCellValues = await this.batchGetRangeCellValues(cells, workbook);
    const values = new Map<string, any>();
    batchRangeCellValues.forEach((rangeValue, cell) => {
      const rangeLocation = new RangeLocation({ reference: cell });
      values.set(rangeLocation.formatAsString(), this.getFirstValue(rangeValue));
    });
    return values;
  }

  public async batchGetRowCellValues(rows: string[], workbook: W): Promise<Map<string, any[]>> {
    const batchRangeCellValues = await this.batchGetRangeCellValues(rows, workbook);
    const values = new Map<string, any[]>();
    batchRangeCellValues.forEach((rangeValue, cell) => {
      const rangeLocation = new RangeLocation({ reference: cell });
      values.set(rangeLocation.formatAsString(), this.getFirstRowValues(rangeValue));
    });
    return values;
  }

  public async batchGetColumnCellValues(columns: string[], workbook: W): Promise<Map<string, any[]>> {
    const batchRangeCellValues = await this.batchGetRangeCellValues(columns, workbook);
    const values = new Map<string, any[]>();
    batchRangeCellValues.forEach((rangeValue, cell) => {
      const rangeLocation = new RangeLocation({ reference: cell });
      values.set(rangeLocation.formatAsString(), this.getFirstColumnValues(rangeValue));
    });
    return values;
  }

  /**
   * Gets first value of 2-dimension list of objects
   *
   * @param values 2-dimension list of objects
   * @return first value
   */
  public getFirstValue(values?: any[][]): any {
    if (values && CollectionUtil.isNotEmpty(values) && CollectionUtil.isNotEmpty(values[0])) {
      return values[0][0];
    }
    return null;
  }

  /**
   * Gets first row values of 2-dimension list of objects
   *
   * @param values 2-dimension list of objects
   * @return first row values
   */
  public getFirstRowValues(values?: any[][]): any[] {
    if (values && CollectionUtil.isNotEmpty(values)) {
      return values[0];
    }
    return [];
  }

  /**
   * Gets first column values of 2-dimension list of objects
   *
   * @param values 2-dimension list of objects
   * @return first column values
   */
  public getFirstColumnValues(values?: any[][]): any[] {
    const columnValues = [] as any[];
    if (values && CollectionUtil.isNotEmpty(values)) {
      for (const rowValues of values) {
        if (CollectionUtil.isNotEmpty(rowValues)) {
          columnValues.push(rowValues[0]);
        } else {
          columnValues.push(null);
        }
      }
    }
    return columnValues;
  }
}
