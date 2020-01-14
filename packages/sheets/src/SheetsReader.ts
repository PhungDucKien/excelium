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

import { CellLocation, CollectionUtil, DateUtil, NumberUtil, RangeLocation, StringUtil } from '@excelium/common';
import { AbstractTestReader } from '@excelium/core';
import { sheets_v4 } from 'googleapis';

/**
 * Reads Google Sheet spreadsheets.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class SheetsReader extends AbstractTestReader<sheets_v4.Schema$Spreadsheet, sheets_v4.Schema$Sheet> {
  /**
   * Sheets service
   */
  private sheetsService: sheets_v4.Sheets;

  /**
   * Spreadsheet id
   */
  private spreadsheetId: string;

  /**
   * Constructs reader for a specific Sheets spreadsheet.
   *
   * @param sheetsService Sheets service
   * @param spreadsheetId Spreadsheet ID
   */
  constructor(sheetsService: sheets_v4.Sheets, spreadsheetId: string) {
    super();
    this.spreadsheetId = spreadsheetId;
    this.sheetsService = sheetsService;
  }

  public getWorkbook(): Promise<sheets_v4.Schema$Spreadsheet> {
    return this.sheetsService.spreadsheets
      .get({
        spreadsheetId: this.spreadsheetId,
        fields: 'spreadsheetId,properties.title,sheets(properties(title,sheetId))',
        prettyPrint: false,
      })
      .then(resp => resp.data);
  }

  public getWorkbookName(workbook: sheets_v4.Schema$Spreadsheet): string {
    return workbook.spreadsheetId + ' - ' + workbook.properties!.title;
  }

  public listSheets(workbook: sheets_v4.Schema$Spreadsheet): sheets_v4.Schema$Sheet[] {
    return workbook.sheets || [];
  }

  public getSheetName(sheet: sheets_v4.Schema$Sheet): string {
    return sheet.properties!.title || '';
  }

  public batchFindFirstOccurrenceSheet(
    values: any[],
    sheet: sheets_v4.Schema$Sheet,
    workbook: sheets_v4.Schema$Spreadsheet
  ): Promise<Map<string, string>> {
    // The data filters used to match the ranges of values to retrieve.  Ranges
    // that match any of the specified data filters will be included in the
    // response.
    return this.sheetsService.spreadsheets.values
      .batchGetByDataFilter({
        spreadsheetId: workbook.spreadsheetId!,
        requestBody: {
          dataFilters: [
            {
              gridRange: {
                sheetId: sheet.properties!.sheetId,
              },
            },
          ],
        },
      })
      .then(resp => resp.data)
      .then(resp => {
        const sheetValues = resp.valueRanges![0].valueRange!.values!;

        const cellLocations = new Map<string, string>();

        for (const value of values) {
          let r = 0;
          let c = 0;

          for (const rowValues of sheetValues) {
            if (rowValues != null) {
              for (const cellValue of rowValues) {
                if (cellValue != null && cellValue === value) {
                  const cellLocation = new CellLocation({ sheetName: this.getSheetName(sheet), row: r, col: c });
                  cellLocations.set(value, cellLocation.formatAsString());
                }
                c++;
              }
            }
            r++;
            c = 0;
          }
        }
        return cellLocations;
      });
  }

  public async batchGetRangeCellValues(ranges: string[], workbook: sheets_v4.Schema$Spreadsheet): Promise<Map<string, any[][]>> {
    const resp = await this.sheetsService.spreadsheets.get({
      spreadsheetId: workbook.spreadsheetId!,
      fields:
        'sheets(properties.title,data(rowData.values(effectiveValue,effectiveFormat(textFormat.strikethrough,numberFormat),textFormatRuns(format.strikethrough,startIndex))))',
      includeGridData: true,
      prettyPrint: false,
      ranges,
    });
    const spreadsheetData = resp.data;
    const rangeGroup = this.groupRanges(ranges);
    const values = new Map<string, any[][]>();
    rangeGroup.forEach((sheetRanges, sheetName) => {
      const sheet = this.getSheet(spreadsheetData, sheetName);
      if (sheet != null) {
        const gridData = sheet.data;
        if (gridData && CollectionUtil.isNotEmpty(gridData)) {
          let i = 0;
          for (const data of gridData) {
            const range = sheetRanges[i];
            values.set(range, this.getRangeData(data));
            i++;
          }
        }
      }
    });
    return values;
  }

  /**
   * Gets sheet by specified name.
   *
   * @param spreadsheet Spreadsheet
   * @param sheetName Sheet name
   * @return Sheet
   */
  private getSheet(spreadsheet: sheets_v4.Schema$Spreadsheet, sheetName: string): sheets_v4.Schema$Sheet | null {
    const sheets = this.listSheets(spreadsheet);
    for (const sheet of sheets) {
      if (this.getSheetName(sheet) === sheetName) {
        return sheet;
      }
    }
    return null;
  }

  /**
   * Groups input ranges by range's sheet name.
   *
   * @param ranges the ranges
   * @return grouped range
   */
  private groupRanges(ranges: string[]): Map<string, string[]> {
    const rangeGroup = new Map<string, string[]>();
    for (const range of ranges) {
      let sheetName: string;
      if (range.indexOf('!') >= 0) {
        const rangeLocation = new RangeLocation({ reference: range });
        sheetName = rangeLocation.getFirstCell().getSheetName() || '';
      } else {
        sheetName = range;
      }
      let group = rangeGroup.get(sheetName);
      if (!group) {
        group = [] as string[];
        rangeGroup.set(sheetName, group);
      }
      if (group.indexOf(range) === -1) {
        group.push(range);
      }
    }
    return rangeGroup;
  }

  /**
   * Get range data from the given {@link GridData}
   *
   * @param gridData Grid data
   * @return Range data
   */
  private getRangeData(gridData: sheets_v4.Schema$GridData): any[][] {
    const rangeData = [] as any[][];
    const gridRowData = gridData.rowData || [];
    if (gridRowData && CollectionUtil.isNotEmpty(gridRowData)) {
      for (const gridRow of gridRowData) {
        const rowData = [];
        const gridCellData = gridRow.values;
        if (gridCellData && CollectionUtil.isNotEmpty(gridCellData)) {
          for (const gridCell of gridCellData) {
            rowData.push(this.getCellDataValue(gridCell));
          }
        }
        rangeData.push(rowData);
      }
    }
    return rangeData;
  }

  /**
   * Get cell data value from the given {@link CellData}
   *
   * @param cellData Cell data
   * @return Cell data value
   */
  private getCellDataValue(cellData: sheets_v4.Schema$CellData): any {
    const effectiveValue = cellData.effectiveValue;
    const effectiveFormat = cellData.effectiveFormat;
    if (effectiveValue == null || (effectiveFormat != null && this.isStrikethrough(effectiveFormat.textFormat))) {
      return null;
    }
    if (effectiveValue.stringValue != null) {
      const formatRuns = cellData.textFormatRuns;
      if (formatRuns && CollectionUtil.isNotEmpty(formatRuns)) {
        let plainText = '';
        let i = 0;
        for (const formatRun of formatRuns) {
          const runStart = formatRun.startIndex == null ? 0 : formatRun.startIndex;
          let runLength;
          if (i < formatRuns.length - 1) {
            const nextRun = formatRuns[i + 1];
            runLength = (nextRun.startIndex == null ? 0 : nextRun.startIndex) - runStart;
          } else {
            runLength = effectiveValue.stringValue.length - 1 - runStart;
          }
          if (!this.isStrikethrough(formatRun.format)) {
            plainText += effectiveValue.stringValue.substring(runStart, runStart + runLength);
          }
          i++;
        }
        if (plainText.length > 0) {
          return plainText;
        } else {
          return null;
        }
      }
      return effectiveValue.stringValue;
    } else if (effectiveValue.numberValue != null) {
      if (effectiveFormat == null || effectiveFormat.numberFormat == null) {
        return effectiveValue.numberValue;
      } else if (StringUtil.equalsAnyIgnoreCase(effectiveFormat.numberFormat.type!, ['TEXT'])) {
        return effectiveValue.numberValue.toString();
      } else if (StringUtil.equalsAnyIgnoreCase(effectiveFormat.numberFormat.type!, ['DATE', 'TIME', 'DATE_TIME'])) {
        return DateUtil.excelToDate(effectiveValue.numberValue, false);
      } else {
        if (StringUtil.containsAny(effectiveFormat.numberFormat.pattern!, ['.0', '.#', '.?'])) {
          return effectiveValue.numberValue;
        } else {
          return NumberUtil.getIntValue(effectiveValue.numberValue);
        }
      }
    } else if (effectiveValue.boolValue != null) {
      return effectiveValue.boolValue;
    }
    return null;
  }

  /**
   * Checks if the text format is strike-through.
   *
   * @param textFormat The text format
   * @return true if the text format is strike-through
   */
  private isStrikethrough(textFormat?: sheets_v4.Schema$TextFormat): boolean {
    return textFormat != null && textFormat.strikethrough != null && textFormat.strikethrough;
  }
}
