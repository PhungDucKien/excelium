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

import { TestReaderFactory } from '@excelium/core';
import { sheets_v4 } from 'googleapis';
import SheetsReader from './SheetsReader';

/**
 * Creates test readers for Google Sheets spreadsheets.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class SheetsReaderFactory extends TestReaderFactory<SheetsReader> {
  /**
   * Sheets service
   */
  private sheetsService: sheets_v4.Sheets;

  /**
   * Instantiates a new Sheets reader factory.
   *
   * @param sheetsService the sheets service
   */
  constructor(sheetsService: sheets_v4.Sheets) {
    super();
    this.sheetsService = sheetsService;
  }

  public createReader(spreadsheetId: string): SheetsReader {
    return new SheetsReader(this.sheetsService, spreadsheetId);
  }
}
