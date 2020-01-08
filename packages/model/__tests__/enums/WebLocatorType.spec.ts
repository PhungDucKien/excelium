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

import WebLocatorType from '../../src/enums/WebLocatorType';

/**
 * Tests for {@link WebLocatorType}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
describe('test WebLocatorType', () => {
  test('from strategy', () => {
    expect(WebLocatorType.fromStrategy('id')).toBe(WebLocatorType.ID);
    expect(WebLocatorType.fromStrategy('link')).toBe(WebLocatorType.LINK);
    expect(WebLocatorType.fromStrategy('partial link')).toBe(WebLocatorType.PARTIAL_LINK);
    expect(WebLocatorType.fromStrategy('tag')).toBe(WebLocatorType.TAG);
    expect(WebLocatorType.fromStrategy('name')).toBe(WebLocatorType.NAME);
    expect(WebLocatorType.fromStrategy('class')).toBe(WebLocatorType.CLASS);
    expect(WebLocatorType.fromStrategy('css')).toBe(WebLocatorType.CSS);
    expect(WebLocatorType.fromStrategy('xpath')).toBe(WebLocatorType.XPATH);
    expect(WebLocatorType.fromStrategy('identifier')).toBe(WebLocatorType.IDENTIFIER);
    expect(WebLocatorType.fromStrategy('alt')).toBe(WebLocatorType.ALT);
    expect(WebLocatorType.fromStrategy('dom')).toBe(WebLocatorType.DOM);
    expect(WebLocatorType.fromStrategy('index')).toBe(WebLocatorType.INDEX);
    expect(WebLocatorType.fromStrategy('variable')).toBe(WebLocatorType.VARIABLE);
  });
});
