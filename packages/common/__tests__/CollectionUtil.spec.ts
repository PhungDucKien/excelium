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

import CollectionUtil from '../src/CollectionUtil';

describe('test CollectionUtil', () => {
  test('is not empty', () => {
    expect(CollectionUtil.isNotEmpty(undefined)).toBe(false);
    expect(CollectionUtil.isNotEmpty(null)).toBe(false);
    expect(CollectionUtil.isNotEmpty('a')).toBe(false);
    expect(CollectionUtil.isNotEmpty(1)).toBe(false);
    expect(CollectionUtil.isNotEmpty([])).toBe(false);
    expect(CollectionUtil.isNotEmpty(['a'])).toBe(true);
    expect(CollectionUtil.isNotEmpty([1])).toBe(true);
  });

  test('is empty', () => {
    expect(CollectionUtil.isEmpty(undefined)).toBe(true);
    expect(CollectionUtil.isEmpty(null)).toBe(true);
    expect(CollectionUtil.isEmpty('a')).toBe(true);
    expect(CollectionUtil.isEmpty(1)).toBe(true);
    expect(CollectionUtil.isEmpty([])).toBe(true);
    expect(CollectionUtil.isEmpty(['a'])).toBe(false);
    expect(CollectionUtil.isEmpty([1])).toBe(false);
  });
});
