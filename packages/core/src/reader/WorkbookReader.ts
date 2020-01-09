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
 * Workbook reader interface.
 * Provides helper methods for inquiring and searching cell values.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.23
 */
export default interface WorkbookReader<W, S> {
  /**
   * Gets workbook object.
   *
   * @return the workbook
   */
  getWorkbook(): Promise<W>;

  /**
   * Gets workbook name.
   *
   * @param workbook the workbook
   * @return the workbook name
   */
  getWorkbookName(workbook: W): string;

  /**
   * Gets list of sheets.
   *
   * @param workbook the workbook
   * @return List of sheets
   */
  listSheets(workbook: W): S[];

  /**
   * Gets sheet name.
   *
   * @param sheet Sheet object
   * @return sheet name
   */
  getSheetName(sheet: S): string;

  /**
   * Finds the first cell with the given value in the workbook/spreadsheet
   * and returns the cell location.
   * The location of the cell contains the sheet name and A1 notation.
   *
   * @param value the value to find
   * @param workbook the workbook
   * @return Cell location
   */
  findFirstOccurrence(value: any, workbook: W): Promise<string | null>;

  /**
   * Finds the first cells with the given values in the workbook/spreadsheet
   * and returns the map that maps a value to the found cell location.
   * The location of the cell contains the sheet name and A1 notation.
   *
   * @param values the values to find
   * @param workbook the workbook
   * @return Cell location map
   */
  batchFindFirstOccurrence(values: any[], workbook: W): Promise<Map<string, string>>;

  /**
   * Finds the first cell with the given value in the given sheet
   * and returns the cell location.
   * The location of the cell contains the sheet name and A1 notation.
   *
   * @param value the value to find
   * @param sheet the sheet
   * @param workbook the workbook
   * @return Cell location
   */
  findFirstOccurrenceSheet(value: any, sheet: S, workbook?: W): Promise<string | null>;

  /**
   * Finds the first cells with the given values in the given sheet
   * and returns the map that maps a value to the found cell location.
   * The location of the cell contains the sheet name and A1 notation.
   *
   * @param values the values to find
   * @param sheet  the sheet
   * @param workbook the workbook
   * @return Cell location map
   */
  batchFindFirstOccurrenceSheet(values: any[], sheet: S, workbook?: W): Promise<Map<string, string>>;

  /**
   * Gets cell value of a single cell
   *
   * @param cell Cell location
   * @param workbook the workbook
   * @return cell value
   */
  getCellValue(cell: string, workbook: W): Promise<any>;

  /**
   * Gets list of cell values of a single row
   *
   * @param row Row location
   * @param workbook the workbook
   * @return cell values of row
   */
  getRowCellValues(row: string, workbook: W): Promise<any[]>;

  /**
   * Gets list of cell values of a single column
   *
   * @param column Column location
   * @param workbook the workbook
   * @return cell values of column
   */
  getColumnCellValues(column: string, workbook: W): Promise<any[]>;

  /**
   * Gets 2-dimension list of cell values of a single range
   *
   * @param range Range location
   * @param workbook the workbook
   * @return cell values of range
   */
  getRangeCellValues(range: string, workbook: W): Promise<any[][]>;

  /**
   * Gets a map of cell values of multiple cells
   *
   * @param cells Cell location array
   * @param workbook the workbook
   * @return Map of cell values. The key of the return map is cell location.
   */
  batchGetCellValues(cells: string[], workbook: W): Promise<Map<string, any>>;

  /**
   * Gets a map of list of cell values of multiple rows
   *
   * @param rows Row location array
   * @param workbook the workbook
   * @return Map of row cell values. The key of the return map is row location.
   */
  batchGetRowCellValues(rows: string[], workbook: W): Promise<Map<string, any[]>>;

  /**
   * Gets a map of list of cell values of multiple columns
   *
   * @param columns Column location array
   * @param workbook the workbook
   * @return Map of column cell values. The key of the return map is column location.
   */
  batchGetColumnCellValues(columns: string[], workbook: W): Promise<Map<string, any[]>>;

  /**
   * Gets a map of 2-dimension list of cell values of multiple ranges
   *
   * @param ranges Range location array
   * @param workbook the workbook
   * @return Map of range cell values. The key of the return map is range location.
   */
  batchGetRangeCellValues(ranges: string[], workbook: W): Promise<Map<string, any[][]>>;
}
