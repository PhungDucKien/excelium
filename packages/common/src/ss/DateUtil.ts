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

/**
 * Contains methods for dealing with Excel dates.
 */
export default class DateUtil {
  public static dateToExcel(d: Date, date1904: boolean): number {
    return 25569 + d.getTime() / (24 * 3600 * 1000) - (date1904 ? 1462 : 0);
  }

  public static excelToDate(v: number, date1904: boolean): Date | null {
    if (!DateUtil.isValidExcelDate(v)) {
      return null;
    }
    const millisecondSinceEpoch = Math.round((v - 25569 + (date1904 ? 1462 : 0)) * 24 * 3600 * 1000);
    return new Date(millisecondSinceEpoch);
  }

  public static isDateFmt(fmt: string): boolean {
    if (!fmt) {
      return false;
    }

    // must remove all chars inside quotes and []
    fmt = fmt.replace(/\[[^\]]*]/g, '');
    fmt = fmt.replace(/"[^"]*"/g, '');
    // then check for date formatting chars
    const result = fmt.match(/[ymdhMsb]+/) !== null;
    return result;
  }

  public static toIsoDateString(dt: Date): string {
    return dt.toISOString().substr(0, 10);
  }

  /**
   * Given a double, checks if it is a valid Excel date.
   *
   * @param value the double value
   * @return true if valid
   */
  public static isValidExcelDate(value: number): boolean {
    return value > -Number.MIN_VALUE;
  }
}
