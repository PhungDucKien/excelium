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

import TestWriter from './TestWriter';

/**
 * Creates test writers.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
export default abstract class TestWriterFactory<W, TW extends TestWriter> {
  /**
   * Creates test writer for the given workbook.
   *
   * @param workbook Workbook object
   * @param fileLocation File location.
   *                     May be the file path if the file is local system file.
   *                     Or the spreadsheet ID or URL if the file is a remote web file.
   * @return Test writer to write specified workbook
   */
  public abstract createWriter(workbook: W, fileLocation: string): TW;
}
