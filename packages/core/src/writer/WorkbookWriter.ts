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

/**
 * Workbook writer interface.
 * Provides helper methods for writing cell values.
 *
 * @author PhungDucKien
 * @since 2018.04.28
 */
export default interface WorkbookWriter {
  /**
   * Writes cell value to a single cell
   *
   * @param value cell value
   * @param cell  Cell location
   */
  setCellValue(value: any, cell: string): void;

  /**
   * Writes list of cell values to a single row
   *
   * @param values cell values of row
   * @param row    Row location
   */
  setRowCellValues(values: any[], row: string): void;

  /**
   * Writes list of cell values to a single column
   *
   * @param values cell values of column
   * @param column Column location
   */
  setColumnCellValues(values: any[], column: string): void;

  /**
   * Writes 2-dimension list of cell values to a single range
   *
   * @param values cell values of range
   * @param range  Range location
   */
  setRangeCellValues(values: any[][], range: string): void;

  /**
   * Writes a map of cell values to multiple cells
   *
   * @param values Map of cell values. The key of the map is cell location.
   * @param cells  Cell location array
   */
  batchSetCellValues(values: Map<string, any>, cells: string[]): void;

  /**
   * Writes a map of list of cell values to multiple rows
   *
   * @param values Map of row cell values. The key of the map is row location.
   * @param rows   Row location array
   */
  batchSetRowCellValues(values: Map<string, any[]>, rows: string[]): void;

  /**
   * Writes a map of list of cell values to multiple columns
   *
   * @param values  Map of column cell values. The key of the map is column location.
   * @param columns Column location array
   */
  batchSetColumnCellValues(values: Map<string, any[]>, columns: string[]): void;

  /**
   * Writes a map of 2-dimension list of cell values to multiple ranges
   *
   * @param values Map of range cell values. The key of the map is range location.
   * @param ranges Range location array
   */
  batchSetRangeCellValues(values: Map<string, any[][]>, ranges: string[]): void;

  /**
   * Flush all changes.
   */
  flush(): Promise<void>;
}
