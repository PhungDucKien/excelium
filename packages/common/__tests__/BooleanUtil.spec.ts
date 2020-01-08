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

import BooleanUtil from '../src/BooleanUtil';

describe('test BooleanUtil', () => {
  test('string to boolean', () => {
    expect(BooleanUtil.toBoolean(null)).toBe(false);
    expect(BooleanUtil.toBoolean('')).toBe(false);
    expect(BooleanUtil.toBoolean('false')).toBe(false);
    expect(BooleanUtil.toBoolean('no')).toBe(false);
    expect(BooleanUtil.toBoolean('off')).toBe(false);
    expect(BooleanUtil.toBoolean('FALSE')).toBe(false);
    expect(BooleanUtil.toBoolean('NO')).toBe(false);
    expect(BooleanUtil.toBoolean('OFF')).toBe(false);
    expect(BooleanUtil.toBoolean('oof')).toBe(false);
    expect(BooleanUtil.toBoolean('true')).toBe(true);
    expect(BooleanUtil.toBoolean('yes')).toBe(true);
    expect(BooleanUtil.toBoolean('on')).toBe(true);
    expect(BooleanUtil.toBoolean('TRUE')).toBe(true);
    expect(BooleanUtil.toBoolean('YES')).toBe(true);
    expect(BooleanUtil.toBoolean('ON')).toBe(true);
    expect(BooleanUtil.toBoolean('TruE')).toBe(true);
    expect(BooleanUtil.toBoolean('TruE')).toBe(true);

    expect(BooleanUtil.toBoolean('y')).toBe(true); // yes
    expect(BooleanUtil.toBoolean('Y')).toBe(true);
    expect(BooleanUtil.toBoolean('t')).toBe(true); // true
    expect(BooleanUtil.toBoolean('T')).toBe(true);
    expect(BooleanUtil.toBoolean('f')).toBe(false); // false
    expect(BooleanUtil.toBoolean('F')).toBe(false);
    expect(BooleanUtil.toBoolean('n')).toBe(false); // No
    expect(BooleanUtil.toBoolean('N')).toBe(false);
    expect(BooleanUtil.toBoolean('z')).toBe(false);

    expect(BooleanUtil.toBoolean('ab')).toBe(false);
    expect(BooleanUtil.toBoolean('yoo')).toBe(false);
    expect(BooleanUtil.toBoolean('true ')).toBe(false);
    expect(BooleanUtil.toBoolean('ono')).toBe(false);
  });
});
