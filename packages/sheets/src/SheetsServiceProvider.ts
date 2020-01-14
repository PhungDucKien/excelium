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

import { google, sheets_v4 } from 'googleapis';
import GoogleConnection from './connection/GoogleConnection';

/**
 * Sheets service provider.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class SheetsServiceProvider {
  /**
   * Google connection
   */
  private connection: GoogleConnection;

  /**
   * Sheets service
   */
  private sheetsService: sheets_v4.Sheets;

  /**
   * Instantiates a new Sheets service provider.
   *
   * @param connection the connection
   */
  constructor(connection: GoogleConnection) {
    this.connection = connection;
  }

  /**
   * Constructs Sheets service.
   *
   * @return Sheets service
   */
  public createSheetsService(): Promise<sheets_v4.Sheets> {
    if (this.sheetsService == null) {
      return this.connection.getAuthClient().then(auth => {
        return google.sheets({ version: 'v4', auth });
      });
    }
    return Promise.resolve(this.sheetsService);
  }
}
