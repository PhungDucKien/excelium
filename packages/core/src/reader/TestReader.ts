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

import { Template, Test, TestFilter } from '@excelium/model';
import TestWriter from '../writer/TestWriter';
import WorkbookReader from './WorkbookReader';

/**
 * Test reader interface.
 * Provides method that reads test files.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default interface TestReader<W, S> extends WorkbookReader<W, S> {
  /**
   * Parses test file.
   *
   * @param template   the template
   * @param workbook   the workbook
   * @param testFilter the test filter
   * @param testWriter the test writer
   * @return Parsed test object
   */
  parseTest(template: Template, workbook: W, testFilter?: TestFilter, testWriter?: TestWriter): Promise<Test>;
}
