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

import { CollectionUtil } from '@excelium/common';
import WorkbookWriter from './WorkbookWriter';

/**
 * Abstract workbook writer.
 * This class implements some helper methods for writing cell values.
 *
 * @author PhungDucKien
 * @since 2018.04.29
 */
export default abstract class AbstractWorkbookWriter implements WorkbookWriter {
  /**
   * Flush values
   */
  protected flushValues = new Map<string, any[][]>();

  public setCellValue(value: any, cell: string): void {
    const valueMap = new Map<string, any>();
    valueMap.set(cell, value);
    this.batchSetCellValues(valueMap, [cell]);
  }

  public setRowCellValues(values: any[], row: string): void {
    const valueMap = new Map<string, any[]>();
    valueMap.set(row, values);
    this.batchSetRowCellValues(valueMap, [row]);
  }

  public setColumnCellValues(values: any[], column: string): void {
    const valueMap = new Map<string, any[]>();
    valueMap.set(column, values);
    this.batchSetColumnCellValues(valueMap, [column]);
  }

  public setRangeCellValues(values: any[][], range: string): void {
    const valueMap = new Map<string, any[][]>();
    valueMap.set(range, values);
    this.batchSetRangeCellValues(valueMap, [range]);
  }

  public batchSetCellValues(values: Map<string, any>, cells: string[]): void {
    const valueMap = new Map<string, any[][]>();
    for (const cell of cells) {
      const rangeValues = [] as any[][];
      const rowValues = [] as any[];
      rowValues.push(values.get(cell));
      rangeValues.push(rowValues);
      valueMap.set(cell, rangeValues);
    }
    this.batchSetRangeCellValues(valueMap, cells);
  }

  public batchSetRowCellValues(values: Map<string, any[]>, rows: string[]): void {
    const valueMap = new Map<string, any[][]>();
    for (const row of rows) {
      const rangeValues = [] as any[][];
      const value = values.get(row);
      if (value && CollectionUtil.isNotEmpty(value)) {
        rangeValues.push(value);
      }
      valueMap.set(row, rangeValues);
    }
    this.batchSetRangeCellValues(valueMap, rows);
  }

  public batchSetColumnCellValues(values: Map<string, any[]>, columns: string[]): void {
    const valueMap = new Map<string, any[][]>();
    for (const column of columns) {
      const rangeValues = [] as any[][];
      const columnValues = values.get(column);
      if (columnValues && CollectionUtil.isNotEmpty(columnValues)) {
        for (const value of columnValues) {
          const rowValues = [] as any[];
          rowValues.push(value);
          rangeValues.push(rowValues);
        }
      }
      valueMap.set(column, rangeValues);
    }
    this.batchSetRangeCellValues(valueMap, columns);
  }

  public batchSetRangeCellValues(values: Map<string, any[][]>, ranges: string[]): void {
    for (const range of ranges) {
      const value = values.get(range);
      if (value && CollectionUtil.isNotEmpty(value)) {
        this.flushValues.set(range, value);
      }
    }
  }

  public close(): Promise<void> {
    if (this.flushValues && this.flushValues.size > 0) {
      return this.flush();
    }
    return Promise.resolve();
  }

  public abstract flush(): Promise<void>;
}
