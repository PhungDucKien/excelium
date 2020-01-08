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

import ObjectUtil from '../src/ObjectUtil';

/**
 * Tests for {@link ObjectUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
describe('test ObjectUtil', () => {
  test('get string value', () => {
    expect(ObjectUtil.getStringValue(null)).toBe(null);
    expect(ObjectUtil.getStringValue('')).toBe('');
    expect(ObjectUtil.getStringValue('abc')).toBe('abc');
    expect(ObjectUtil.getStringValue(true)).toBe('true');
    expect(ObjectUtil.getStringValue(1)).toBe('1');
    // expect(ObjectUtil.getStringValue(1.0)).toBe('1.0');
  });

  test('get boolean value', () => {
    expect(ObjectUtil.getBooleanValue(null)).toBe(false);
    expect(ObjectUtil.getBooleanValue('')).toBe(false);
    expect(ObjectUtil.getBooleanValue('YES')).toBe(true);
    expect(ObjectUtil.getBooleanValue('NO')).toBe(false);
    expect(ObjectUtil.getBooleanValue('Y')).toBe(true);
    expect(ObjectUtil.getBooleanValue('N')).toBe(false);
    expect(ObjectUtil.getBooleanValue('TRUE')).toBe(true);
    expect(ObjectUtil.getBooleanValue('FALSE')).toBe(false);
    expect(ObjectUtil.getBooleanValue('T')).toBe(true);
    expect(ObjectUtil.getBooleanValue('F')).toBe(false);
    expect(ObjectUtil.getBooleanValue(1)).toBe(true);
    expect(ObjectUtil.getBooleanValue(0)).toBe(false);
    expect(ObjectUtil.getBooleanValue(true)).toBe(true);
    expect(ObjectUtil.getBooleanValue(false)).toBe(false);
    expect(ObjectUtil.getBooleanValue('☑')).toBe(true);
    expect(ObjectUtil.getBooleanValue('✓')).toBe(true);
    expect(ObjectUtil.getBooleanValue('✔')).toBe(true);
    expect(ObjectUtil.getBooleanValue('○')).toBe(true);
    expect(ObjectUtil.getBooleanValue('●')).toBe(true);
    expect(ObjectUtil.getBooleanValue('◯')).toBe(true);
  });

  test('get list value', () => {
    expect(ObjectUtil.getListValue(null).length).toBe(0);
    expect(ObjectUtil.getListValue('').length).toBe(0);

    let list = ObjectUtil.getListValue('abc');
    expect(list.length).toBe(1);
    expect(list[0]).toBe('abc');

    list = ObjectUtil.getListValue('abc, def');
    expect(list.length).toBe(2);
    expect(list[0]).toBe('abc');
    expect(list[1]).toBe('def');

    list = ObjectUtil.getListValue('abc   \n def');
    expect(list.length).toBe(2);
    expect(list[0]).toBe('abc');
    expect(list[1]).toBe('def');
  });

  test('check equals', () => {
    expect(ObjectUtil.checkEquals(null, null)).toBe(true);
    // Assert.assertTrue(ObjectUtil.checkEquals("#ff0000", new Color(255, 0, 0, 1)));
    // Assert.assertTrue(ObjectUtil.checkEquals("red", new Color(255, 0, 0, 1)));

    expect(ObjectUtil.checkEquals('abc', null)).toBe(false);
    // Assert.assertFalse(ObjectUtil.checkEquals("#ff0001", new Color(255, 0, 0, 1)));
    // Assert.assertFalse(ObjectUtil.checkEquals("blue", new Color(255, 0, 0, 1)));

    expect(ObjectUtil.checkEquals('1', 1)).toBe(true);
    // Assert.assertTrue(ObjectUtil.checkEquals("1", 1L));
    expect(ObjectUtil.checkEquals('1', 1.0)).toBe(true);
    expect(ObjectUtil.checkEquals('true', true)).toBe(true);
    expect(ObjectUtil.checkEquals('false', false)).toBe(true);
  });
});
