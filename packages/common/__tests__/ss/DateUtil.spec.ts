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

import DateUtil from '../../src/ss/DateUtil';

describe('test DateUtil', () => {
  test('excelToDate - invalid value', () => {
    const dateValue = -1;
    const use1904windowing = false;

    expect(DateUtil.excelToDate(dateValue, use1904windowing)).toBe(null);
  });

  test('excelToDate - valid value', () => {
    const dateValue = 0;
    const use1904windowing = false;
    const date = new Date(Date.UTC(1899, 11, 30, 0, 0, 0));

    expect(DateUtil.excelToDate(dateValue, use1904windowing)).toStrictEqual(date);
  });

  /**
   * Checks the date conversion functions in the DateUtil class.
   */
  test('date conversion', () => {
    // check 1900 and 1904 date windowing conversions
    const excelDate = 36526.0;
    // with 1900 windowing, excelDate is Jan. 1, 2000
    // with 1904 windowing, excelDate is Jan. 2, 2004
    const dateIf1900 = new Date(Date.UTC(2000, 0, 1, 0, 0, 0)); // Jan. 1, 2000
    const dateIf1904 = new Date(Date.UTC(2004, 0, 2, 0, 0, 0)); // Jan. 2, 2004
    // 1900 windowing
    expect(DateUtil.excelToDate(excelDate, false)).toStrictEqual(dateIf1900);
    // 1904 windowing
    expect(DateUtil.excelToDate(excelDate, true)).toStrictEqual(dateIf1904);
  });

  test('date bug', () => {
    expect(DateUtil.excelToDate(59.0, false)).toStrictEqual(new Date(Date.UTC(1900, 1, 27)));
    expect(DateUtil.excelToDate(60.0, false)).toStrictEqual(new Date(Date.UTC(1900, 1, 28)));
    expect(DateUtil.excelToDate(61.0, false)).toStrictEqual(new Date(Date.UTC(1900, 2, 1)));

    expect(DateUtil.excelToDate(37315.0, false)).toStrictEqual(new Date(Date.UTC(2002, 1, 28)));
    expect(DateUtil.excelToDate(37316.0, false)).toStrictEqual(new Date(Date.UTC(2002, 2, 1)));
    expect(DateUtil.excelToDate(37257.0, false)).toStrictEqual(new Date(Date.UTC(2002, 0, 1)));
    expect(DateUtil.excelToDate(38074.0, false)).toStrictEqual(new Date(Date.UTC(2004, 2, 28)));
  });

  test('date 1904', () => {
    expect(DateUtil.excelToDate(1.0, true)).toStrictEqual(new Date(Date.UTC(1904, 0, 2)));
    expect(DateUtil.excelToDate(0.0, true)).toStrictEqual(new Date(Date.UTC(1904, 0, 1)));

    expect(DateUtil.excelToDate(35981, false)).toStrictEqual(new Date(Date.UTC(1998, 6, 5)));
    expect(DateUtil.excelToDate(34519, true)).toStrictEqual(new Date(Date.UTC(1998, 6, 5)));
  });

  /**
   * Ensure that date values *with* a fractional portion get the right time of day
   */
  test('convert date time', () => {
    // Excel day 30000 is date 18-Feb-1982
    // 0.7 corresponds to time 16:48:00
    expect(DateUtil.excelToDate(30000.7, false)).toStrictEqual(new Date(Date.UTC(1982, 1, 18, 16, 48, 0)));
  });

  test('bug 56269', () => {
    const excelFraction = 41642.45833321759;
    const date = DateUtil.excelToDate(excelFraction, false);
    expect(date?.getUTCHours()).toBe(10);
    expect(date?.getUTCMinutes()).toBe(59);
    expect(date?.getUTCSeconds()).toBe(59);
  });
});
