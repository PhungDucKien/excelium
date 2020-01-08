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

import MobileLocatorType from '../../src/enums/MobileLocatorType';

/**
 * Tests for {@link MobileLocatorType}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
describe('test MobileLocatorType', () => {
  test('from strategy', () => {
    expect(MobileLocatorType.fromStrategy('accessibility id')).toBe(MobileLocatorType.ACCESSIBILITY_ID);
    expect(MobileLocatorType.fromStrategy('class')).toBe(MobileLocatorType.CLASS);
    expect(MobileLocatorType.fromStrategy('id')).toBe(MobileLocatorType.ID);
    expect(MobileLocatorType.fromStrategy('name')).toBe(MobileLocatorType.NAME);
    expect(MobileLocatorType.fromStrategy('xpath')).toBe(MobileLocatorType.XPATH);
    expect(MobileLocatorType.fromStrategy('android uiautomator')).toBe(MobileLocatorType.ANDROID_UIAUTOMATOR);
    expect(MobileLocatorType.fromStrategy('android viewtag')).toBe(MobileLocatorType.ANDROID_VIEWTAG);
    expect(MobileLocatorType.fromStrategy('android datamatcher')).toBe(MobileLocatorType.ANDROID_DATAMATCHER);
    expect(MobileLocatorType.fromStrategy('ios predicate string')).toBe(MobileLocatorType.IOS_PREDICATE_STRING);
    expect(MobileLocatorType.fromStrategy('ios class chain')).toBe(MobileLocatorType.IOS_CLASS_CHAIN);
    expect(MobileLocatorType.fromStrategy('windows uiautomation')).toBe(MobileLocatorType.WINDOWS_UIAUTOMATION);
    expect(MobileLocatorType.fromStrategy('index')).toBe(MobileLocatorType.INDEX);
    expect(MobileLocatorType.fromStrategy('variable')).toBe(MobileLocatorType.VARIABLE);
  });
});
