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

import NumberUtil from '../src/NumberUtil';

/**
 * Tests for {@link NumberUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.19
 */
describe('test NumberUtil', () => {
  test('get int value', () => {
    expect(NumberUtil.getIntValue(1.0)).toBe(1);
    expect(NumberUtil.getIntValue(1.4)).toBe(1);
    expect(NumberUtil.getIntValue(1.5)).toBe(1);
    expect(NumberUtil.getIntValue(1.6)).toBe(1);
    expect(NumberUtil.getIntValue(-1.0)).toBe(-1);
    expect(NumberUtil.getIntValue(10000000000.0)).toBe(10000000000);
  });

  test('parse integer', () => {
    expect(NumberUtil.parseInteger('1234', 0)).toBe(1234);
    expect(NumberUtil.parseInteger('0', 1)).toBe(0);
    expect(NumberUtil.parseInteger('-1', 1)).toBe(-1);
    expect(NumberUtil.parseInteger('#ff', 0)).toBe(0);
    expect(NumberUtil.parseInteger('0xff', 0)).toBe(255);
    expect(NumberUtil.parseInteger('0Xff', 0)).toBe(255);
    expect(NumberUtil.parseInteger('-0xff', 0)).toBe(-255);
    expect(NumberUtil.parseInteger('-0Xff', 0)).toBe(-255);
  });

  test('parse positive integer', () => {
    expect(NumberUtil.parsePositiveInteger('1234', 0)).toBe(1234);
    expect(NumberUtil.parsePositiveInteger('0', 1)).toBe(0);
    expect(NumberUtil.parsePositiveInteger('-1', 1)).toBe(1);
    expect(NumberUtil.parsePositiveInteger('#ff', 0)).toBe(0);
    expect(NumberUtil.parsePositiveInteger('0xff', 0)).toBe(255);
    expect(NumberUtil.parsePositiveInteger('0Xff', 0)).toBe(255);
    expect(NumberUtil.parsePositiveInteger('-0xff', 0)).toBe(0);
    expect(NumberUtil.parsePositiveInteger('-0Xff', 0)).toBe(0);
  });
});
