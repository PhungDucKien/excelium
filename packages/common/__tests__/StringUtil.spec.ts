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

import StringUtil from '../src/StringUtil';

/**
 * Tests for {@link StringUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
describe('test StringUtil', () => {
  test('extract spreadsheet id', () => {
    expect(StringUtil.extractSpreadsheetId('https://docs.google.com/spreadsheets/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU')).toBe(
      '1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU'
    );
    expect(StringUtil.extractSpreadsheetId('https://docs.google.com/spreadsheets/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/')).toBe(
      '1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU'
    );
    expect(
      StringUtil.extractSpreadsheetId('https://docs.google.com/spreadsheets/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/edit#gid=1160173419')
    ).toBe('1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU');
    expect(StringUtil.extractSpreadsheetId('https://docs.google.com/spreadsheets/u/0/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU')).toBe(
      '1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU'
    );
    expect(StringUtil.extractSpreadsheetId('https://docs.google.com/spreadsheets/u/0/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/')).toBe(
      '1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU'
    );
    expect(
      StringUtil.extractSpreadsheetId('https://docs.google.com/spreadsheets/u/0/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/edit#gid=1160173419')
    ).toBe('1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU');
    expect(StringUtil.extractSpreadsheetId('1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU')).toBe('1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU');
  });

  test('get human readable byte count', () => {
    expect(StringUtil.humanReadableByteCount(0, true)).toBe('0 B');
    expect(StringUtil.humanReadableByteCount(0, false)).toBe('0 B');
    expect(StringUtil.humanReadableByteCount(27, true)).toBe('27 B');
    expect(StringUtil.humanReadableByteCount(27, false)).toBe('27 B');
    expect(StringUtil.humanReadableByteCount(999, true)).toBe('999 B');
    expect(StringUtil.humanReadableByteCount(999, false)).toBe('999 B');
    expect(StringUtil.humanReadableByteCount(1000, true)).toBe('1.0 kB');
    expect(StringUtil.humanReadableByteCount(1000, false)).toBe('1000 B');
    expect(StringUtil.humanReadableByteCount(1023, true)).toBe('1.0 kB');
    expect(StringUtil.humanReadableByteCount(1023, false)).toBe('1023 B');
    expect(StringUtil.humanReadableByteCount(1024, true)).toBe('1.0 kB');
    expect(StringUtil.humanReadableByteCount(1024, false)).toBe('1.0 KiB');
    expect(StringUtil.humanReadableByteCount(1728, true)).toBe('1.7 kB');
    expect(StringUtil.humanReadableByteCount(1728, false)).toBe('1.7 KiB');
    expect(StringUtil.humanReadableByteCount(110592, true)).toBe('110.6 kB');
    expect(StringUtil.humanReadableByteCount(110592, false)).toBe('108.0 KiB');
    expect(StringUtil.humanReadableByteCount(7077888, true)).toBe('7.1 MB');
    expect(StringUtil.humanReadableByteCount(7077888, false)).toBe('6.8 MiB');
    expect(StringUtil.humanReadableByteCount(452984832, true)).toBe('453.0 MB');
    expect(StringUtil.humanReadableByteCount(452984832, false)).toBe('432.0 MiB');
    expect(StringUtil.humanReadableByteCount(28991029248, true)).toBe('29.0 GB');
    expect(StringUtil.humanReadableByteCount(28991029248, false)).toBe('27.0 GiB');
    expect(StringUtil.humanReadableByteCount(1855425871872, true)).toBe('1.9 TB');
    expect(StringUtil.humanReadableByteCount(1855425871872, false)).toBe('1.7 TiB');
    expect(StringUtil.humanReadableByteCount(9223372036854775808, true)).toBe('9.2 EB');
    expect(StringUtil.humanReadableByteCount(9223372036854775808, false)).toBe('8.0 EiB');
  });

  test('add space to camel case', () => {
    expect(StringUtil.addSpaceToCamelCase('FirstName')).toBe('First Name');
    expect(StringUtil.addSpaceToCamelCase('ThisIsMyCapsDelimitedString')).toBe('This Is My Caps Delimited String');
    expect(StringUtil.addSpaceToCamelCase('IBMMakeStuffAndSellIt')).toBe('IBM Make Stuff And Sell It');
    expect(StringUtil.addSpaceToCamelCase('bigIDProblem')).toBe('big ID Problem');
    expect(StringUtil.addSpaceToCamelCase('AWSFile')).toBe('AWS File');
  });

  test('get first sentence ', () => {
    expect(StringUtil.getFirstSentence('This is the first sentence')).toBe('This is the first sentence');
    expect(StringUtil.getFirstSentence('This is the first sentence.')).toBe('This is the first sentence.');
    expect(StringUtil.getFirstSentence('This is the first sentence.This is the second sentence.')).toBe(
      'This is the first sentence.This is the second sentence.'
    );
    expect(StringUtil.getFirstSentence('This is the first sentence. This is the second sentence.')).toBe('This is the first sentence.');
    expect(StringUtil.getFirstSentence('This is first (e.g. 1st) sentence. And the second one.')).toBe('This is first (e.g. 1st) sentence.');
    expect(StringUtil.getFirstSentence('I need this domain.com! Another sentence. And another sentence.')).toBe('I need this domain.com!');
  });
});
