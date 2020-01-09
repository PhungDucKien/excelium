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

import { Result, Template, TestStep } from '@excelium/model';
import WorkbookWriter from './WorkbookWriter';

/**
 * Test writer interface.
 * Provides method that writes test files.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
export default interface TestWriter extends WorkbookWriter {
  /**
   * Write test result to the workbook
   *
   * @param template  the template of the workbook
   * @param sheetName the sheet name
   * @param testStep  the test step
   * @param result    the result to write
   */
  writeResult(template: Template, sheetName: string, testStep: TestStep, result: Result): void;
}
