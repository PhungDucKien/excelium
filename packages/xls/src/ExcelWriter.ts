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

import { CollectionUtil, RangeLocation } from '@excelium/common';
import { AbstractTestWriter } from '@excelium/core';
import { Cell, Row, Workbook, Worksheet } from 'exceljs';
import fs from 'fs-extra';

/**
 * Writes Microsoft Excel files.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
export default class ExcelWriter extends AbstractTestWriter {
  /**
   * Workbook object
   */
  protected workbook: Workbook;

  /**
   * File path
   */
  private filePath: string;

  /**
   * Instantiates a new Excel writer.
   *
   * @param workbook the workbook
   * @param filePath the file path
   */
  constructor(workbook: Workbook, filePath: string) {
    super();
    this.workbook = workbook;
    this.filePath = filePath;
  }

  public flush(): Promise<void> {
    this.flushValues.forEach((rangeValues, range) => {
      if (CollectionUtil.isNotEmpty(rangeValues)) {
        const rangeLocation = new RangeLocation({ reference: range });
        const sheetName = rangeLocation.getFirstCell().getSheetName();
        if (sheetName) {
          const sheet = this.workbook.getWorksheet(sheetName);
          for (let r = rangeLocation.getFirstCell().getRow(); r <= rangeLocation.getLastCell().getRow(); r++) {
            const i = r - rangeLocation.getFirstCell().getRow();
            if (rangeValues.length > i) {
              const rowValues = rangeValues[i];
              for (let c = rangeLocation.getFirstCell().getCol(); c <= rangeLocation.getLastCell().getCol(); c++) {
                const j = c - rangeLocation.getFirstCell().getCol();
                if (rowValues.length > j) {
                  const cellValue = rowValues[j];
                  this._setCellValue(sheet, r + 1, c + 1, cellValue);
                }
              }
            }
          }
        }
      }
    });
    return this.write();
  }

  /**
   * Write out the workbook.
   */
  private write(): Promise<void> {
    return this.writeBackup(this.filePath).then(() => {
      return this.workbook.xlsx.writeFile(this.filePath).catch(() => this.writeFallback(this.filePath));
    });
  }

  /**
   * Backups file before any writing.
   *
   * @param filePath Source file to backup
   */
  private writeBackup(filePath: string): Promise<void> {
    const filePathWithoutExt = filePath.substring(0, filePath.lastIndexOf('.'));
    const extension = filePath.substring(filePath.lastIndexOf('.'));

    const backupFile = filePathWithoutExt + '(backup)' + extension;

    return fs.copyFile(filePath, backupFile);
  }

  /**
   * Writes to fallback file if the give file is busy (occupied by another process)
   *
   * @param filePath File path
   */
  private writeFallback(filePath: string): Promise<void> {
    const filePathWithoutExt = filePath.substring(0, filePath.lastIndexOf('.'));
    const extension = filePath.substring(filePath.lastIndexOf('.'));

    let i = 1;
    let fallbackFile;
    do {
      fallbackFile = filePathWithoutExt + '(' + i++ + ')' + extension;
    } while (fs.existsSync(fallbackFile));

    return this.workbook.xlsx.writeFile(fallbackFile);
  }

  /**
   * Set value of a cell at specific location in a given sheet
   *
   * @param sheet Sheet
   * @param row   Row index
   * @param col   Column index
   * @param value Cell value
   */
  private _setCellValue(sheet: Worksheet, row: number, col: number, value: any): void {
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
        c.value = value;
      }
    }
  }
}
