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

import { CellLocation, NumberUtil, RangeLocation, StringUtil } from '@excelium/common';
import { AbstractTestReader } from '@excelium/core';
import {
  Cell,
  CellErrorValue,
  CellFormulaValue,
  CellHyperlinkValue,
  CellRichTextValue,
  CellSharedFormulaValue,
  FormulaType,
  Row,
  ValueType,
  Workbook,
  Worksheet,
} from 'exceljs';

/**
 * Reads Microsoft Excel files.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class ExcelReader extends AbstractTestReader<Workbook, Worksheet> {
  /**
   * File path
   */
  private filePath: string;

  /**
   * Instantiates a new reader for a specific Excel file.
   *
   * @param filePath Path of file to read
   */
  constructor(filePath: string) {
    super();
    this.filePath = filePath;
  }

  public getWorkbook(): Promise<Workbook> {
    const workbook = new Workbook();
    return workbook.xlsx.readFile(this.filePath);
  }

  public getWorkbookName(_: Workbook): string {
    return this.filePath;
  }

  public listSheets(workbook: Workbook): Worksheet[] {
    return workbook.worksheets;
  }

  public getSheetName(sheet: Worksheet): string {
    return sheet.name;
  }

  public async batchFindFirstOccurrenceSheet(values: any[], sheet: Worksheet): Promise<Map<string, string>> {
    const cellLocations = new Map<string, string>();
    for (const value of values) {
      const cellLocation = await this.findFirstOccurrenceSheet(value, sheet);
      if (cellLocation && StringUtil.isNotBlank(cellLocation)) {
        cellLocations.set(value, cellLocation);
      }
    }
    return cellLocations;
  }

  public async batchGetRangeCellValues(ranges: string[], workbook: Workbook): Promise<Map<string, any[][]>> {
    const rangeCellValues = new Map<string, any[][]>();
    for (const range of ranges) {
      const rangeLocation = new RangeLocation({ reference: range });
      const sheetName = rangeLocation.getFirstCell().getSheetName();
      const sheet = workbook.getWorksheet(sheetName!);
      const values = [] as any[][];
      for (let r = rangeLocation.getFirstCell().getRow(); r <= rangeLocation.getLastCell().getRow(); r++) {
        const rowValues = [] as any[];
        for (let c = rangeLocation.getFirstCell().getCol(); c <= rangeLocation.getLastCell().getCol(); c++) {
          rowValues.push(this._getCellValue(sheet, r + 1, c + 1));
        }
        values.push(rowValues);
      }
      rangeCellValues.set(rangeLocation.formatAsString(), values);
    }
    return rangeCellValues;
  }

  public async findFirstOccurrenceSheet(value: any, sheet: Worksheet): Promise<string | null> {
    const firstRow = 0;
    const lastRow = sheet.rowCount;

    for (let i = firstRow; i < lastRow; i++) {
      let r: Row;
      try {
        r = sheet.getRow(i);
      } catch (e) {
        throw e;
      }
      if (r != null) {
        const firstCol = 0;
        const lastCol = r.actualCellCount;

        for (let j = firstCol; j < lastCol; j++) {
          const cellValue = this._getCellValue(sheet, i + 1, j + 1);
          if (cellValue != null && cellValue === value) {
            const cellLocation = new CellLocation({ sheetName: sheet.name, row: i, col: j });
            return cellLocation.formatAsString();
          }
        }
      }
    }
    return null;
  }

  /**
   * Get value of a cell at specific location in a given sheet
   *
   * @param sheet Sheet
   * @param row   Row index
   * @param col   Column index
   * @return Cell value
   */
  private _getCellValue(sheet: Worksheet, row: number, col: number): any {
    let r: Row;
    try {
      r = sheet.getRow(row);
    } catch (e) {
      throw e;
    }
    if (r != null) {
      let c: Cell;
      try {
        c = r.getCell(col);
      } catch (e) {
        throw e;
      }
      if (c != null) {
        const cellFont = c.font;
        if (cellFont && cellFont.strike) {
          return null;
        }

        switch (c.type) {
          case ValueType.RichText:
            const richText = c.value as CellRichTextValue;
            const runs = richText.richText.length;
            if (runs > 0) {
              let plainText = '';
              for (let i = 0; i < runs; i++) {
                const text = richText.richText[i];
                let indexFont = text.font;
                if (!indexFont) {
                  indexFont = cellFont;
                }
                if (!indexFont || !indexFont.strike) {
                  plainText += text.text;
                }
              }
              if (plainText.length > 0) {
                return plainText;
              } else {
                return null;
              }
            }
            return null;
          case ValueType.Error:
            return (c.value as CellErrorValue).error;
          case ValueType.Hyperlink:
            return (c.value as CellHyperlinkValue).text;
          case ValueType.SharedString:
          case ValueType.String:
          case ValueType.Date:
          case ValueType.Boolean:
            return c.value;
          case ValueType.Number:
            return this.getNumericFormatValue(c.value, c.numFmt);
          case ValueType.Formula:
            let result: number | string | Date | { error: CellErrorValue } | undefined;
            if (c.formulaType === FormulaType.Master) {
              result = (c.value as CellFormulaValue).result;
            } else if (c.formulaType === FormulaType.Shared) {
              result = (c.value as CellSharedFormulaValue).result;
            }
            switch (c.effectiveType) {
              case ValueType.Number:
                return this.getNumericFormatValue(result != null ? result : 0, c.numFmt);
              case ValueType.String:
                return result != null ? result : '';
              case ValueType.Boolean:
                return result != null ? result : false;
            }
            return result || null;
        }
      }
      return null;
    }
  }

  /**
   * Get numeric format value.
   * This method converts cell value to appropriate data type using cell data format.
   *
   * @param value  Cell value
   * @param format Cell format
   * @return numeric format value
   */
  private getNumericFormatValue(value: any, format: string): any {
    if (StringUtil.isBlank(format) || format === 'General') {
      return value;
    } else if (StringUtil.equalsAnyIgnoreCase(format, ['TEXT', '@'])) {
      return value.toString();
    } else if (StringUtil.containsAny(format, ['.0', '.#', '.?'])) {
      return value;
    } else {
      return NumberUtil.getIntValue(value);
    }
  }
}
