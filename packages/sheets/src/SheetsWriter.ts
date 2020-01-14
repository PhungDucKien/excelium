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

import { AbstractTestWriter } from '@excelium/core';
import { sheets_v4 } from 'googleapis';
import moment from 'moment';

/**
 * Writes Google Sheet spreadsheets.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
export default class SheetsWriter extends AbstractTestWriter {
  /**
   * Flush interval. Once the number of changes is greater than this config, flushes changes.
   */
  private static readonly FLUSH_INTERVAL = 100;

  /**
   * Sheets service
   */
  private sheetsService: sheets_v4.Sheets;

  /**
   * Spreadsheet id
   */
  private spreadsheetId: string;

  /**
   * Instantiates a new Sheets writer.
   *
   * @param sheetsService the sheets service
   * @param spreadsheetId the spreadsheet id
   */
  constructor(sheetsService: sheets_v4.Sheets, spreadsheetId: string) {
    super();
    this.spreadsheetId = spreadsheetId;
    this.sheetsService = sheetsService;
  }

  public async flush(): Promise<void> {
    const valueRanges = [] as sheets_v4.Schema$ValueRange[];
    this.flushValues.forEach((values, range) => {
      valueRanges.push({
        range,
        values,
      });
    });

    return this.sheetsService.spreadsheets.values
      .batchUpdate({
        spreadsheetId: this.spreadsheetId,
        requestBody: {
          data: valueRanges,
          valueInputOption: 'USER_ENTERED',
        },
      })
      .then(() => {
        this.flushValues.clear();
      });
  }

  public batchSetRangeCellValues(values: Map<string, any[][]>, ranges: string[]): void {
    super.batchSetRangeCellValues(this.interpretInputData(values), ranges);
    if (this.flushValues != null && this.flushValues.size >= SheetsWriter.FLUSH_INTERVAL) {
      this.flush();
    }
  }

  /**
   * Interpret input data to make sure Google Sheets understand it.
   *
   * @param values the input data
   * @return the interpreted data
   */
  private interpretInputData(values: Map<string, any[][]>): Map<string, any[][]> {
    const userEnterValues = new Map<string, any[][]>();
    values.forEach((rangeValues, range) => {
      const userEnterRangeValues = [] as any[][];
      for (const rowValues of rangeValues) {
        const userEnterRowValues = [] as any[];
        for (const colValue of rowValues) {
          if (typeof colValue === 'string' || colValue instanceof String) {
            userEnterRowValues.push(colValue);
          } else if (typeof colValue === 'boolean') {
            userEnterRowValues.push(colValue);
          } else if (colValue instanceof Date) {
            userEnterRowValues.push(moment(colValue).format('YYYY/MM/DD'));
          } else if (typeof colValue === 'number') {
            userEnterRowValues.push(colValue);
          } else if (colValue == null) {
            userEnterRowValues.push('');
          }
        }
        userEnterRangeValues.push(userEnterRowValues);
      }
      userEnterValues.set(range, userEnterRangeValues);
    });
    return userEnterValues;
  }
}
