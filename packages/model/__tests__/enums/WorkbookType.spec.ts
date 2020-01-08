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

import WorkbookType from '../../src/enums/WorkbookType';

/**
 * Tests for {@link WorkbookType}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
describe('test WorkbookType', () => {
  test('from name', () => {
    expect(WorkbookType.fromName('SHEETS')).toBe(WorkbookType.SHEETS);
    expect(WorkbookType.fromName('EXCEL')).toBe(WorkbookType.EXCEL);
  });

  test('get list choice', () => {
    const listChoice = WorkbookType.getListChoice();
    expect(listChoice.length).toBe(2);
    expect(listChoice[0][0]).toBe('SHEETS');
    expect(listChoice[0][1]).toBe('Google Spreadsheet');
    expect(listChoice[1][0]).toBe('EXCEL');
    expect(listChoice[1][1]).toBe('Excel Workbook');
  });
});
