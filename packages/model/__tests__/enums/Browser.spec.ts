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

import Browser from '../../src/enums/Browser';

/**
 * Tests for {@link Browser}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
describe('test Browser', () => {
  test('from name', () => {
    expect(Browser.fromName('CHROME')).toBe(Browser.CHROME);
    expect(Browser.fromName('FIREFOX')).toBe(Browser.FIREFOX);
    expect(Browser.fromName('IE')).toBe(Browser.IE);
    expect(Browser.fromName('EDGE')).toBe(Browser.EDGE);
    expect(Browser.fromName('SAFARI')).toBe(Browser.SAFARI);
    expect(Browser.fromName('OPERA')).toBe(Browser.OPERA);
    expect(Browser.fromName('CHROMIUM')).toBe(Browser.CHROMIUM);
    expect(Browser.fromName('BROWSER')).toBe(Browser.BROWSER);
  });

  test('get list choice', () => {
    const listChoice = Browser.getListChoice();
    expect(listChoice.length).toBe(8);
    expect(listChoice[0][0]).toBe('CHROME');
    expect(listChoice[0][1]).toBe('Chrome');
    expect(listChoice[1][0]).toBe('FIREFOX');
    expect(listChoice[1][1]).toBe('Firefox');
    expect(listChoice[2][0]).toBe('IE');
    expect(listChoice[2][1]).toBe('Internet Explorer');
    expect(listChoice[3][0]).toBe('EDGE');
    expect(listChoice[3][1]).toBe('Microsoft Edge');
    expect(listChoice[4][0]).toBe('SAFARI');
    expect(listChoice[4][1]).toBe('Safari');
    expect(listChoice[5][0]).toBe('OPERA');
    expect(listChoice[5][1]).toBe('Opera');
    expect(listChoice[6][0]).toBe('CHROMIUM');
    expect(listChoice[6][1]).toBe('Chromium');
    expect(listChoice[7][0]).toBe('BROWSER');
    expect(listChoice[7][1]).toBe('Browser');
  });
});
