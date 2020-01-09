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

import { CellLocation } from '@excelium/common';
import { Result, Template, TestStep } from '@excelium/model';
import os from 'os';
import AbstractWorkbookWriter from './AbstractWorkbookWriter';
import TestWriter from './TestWriter';

/**
 * Abstract test writer that implements {@link TestWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.02
 */
export default abstract class AbstractTestWriter extends AbstractWorkbookWriter implements TestWriter {
  public writeResult(template: Template, sheetName: string, testStep: TestStep, result: Result): void {
    this.writeValue(template, sheetName, testStep, Template.TEST_DATE, new Date());
    this.writeValue(template, sheetName, testStep, Template.TEST_PERSON, os.userInfo().username);
    this.writeValue(template, sheetName, testStep, Template.TEST_RESULT, result);
  }

  /**
   * Write value to the markup position of test step in the workbook
   *
   * @param template  the template of the workbook
   * @param sheetName the sheet name
   * @param testStep  the test step
   * @param markup    the markup
   * @param value     the value
   */
  private writeValue(template: Template, sheetName: string, testStep: TestStep, markup: string, value: any): void {
    if (template.markupLocations.has(markup)) {
      const firstLocation = new CellLocation({ cellRef: template.markupLocations.get(markup) });
      const cellLocation = new CellLocation({
        sheetName,
        row: firstLocation.getRow() + testStep.rowIndex,
        col: firstLocation.getCol(),
        absRow: false,
        absCol: false,
      });
      this.setCellValue(value, cellLocation.formatAsString());
    }
  }
}
