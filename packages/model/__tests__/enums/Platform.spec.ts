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

import Platform from '../../src/enums/Platform';

/**
 * Tests for {@link Platform}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
describe('test Platform', () => {
  test('from name', () => {
    expect(Platform.fromName('WINDOWS_32')).toBe(Platform.WINDOWS_32);
    expect(Platform.fromName('WINDOWS_64')).toBe(Platform.WINDOWS_64);
    expect(Platform.fromName('MAC_OS')).toBe(Platform.MAC_OS);
    expect(Platform.fromName('LINUX')).toBe(Platform.LINUX);
    expect(Platform.fromName('ANDROID')).toBe(Platform.ANDROID);
    expect(Platform.fromName('IOS')).toBe(Platform.IOS);
    expect(Platform.fromName('OTHER')).toBe(Platform.OTHER);
  });

  test('get list choice', () => {
    const listChoice = Platform.getListChoice();
    expect(listChoice.length).toBe(7);
    expect(listChoice[0][0]).toBe('WINDOWS_32');
    expect(listChoice[0][1]).toBe('Windows 32');
    expect(listChoice[1][0]).toBe('WINDOWS_64');
    expect(listChoice[1][1]).toBe('Windows 64');
    expect(listChoice[2][0]).toBe('MAC_OS');
    expect(listChoice[2][1]).toBe('Mac OS');
    expect(listChoice[3][0]).toBe('LINUX');
    expect(listChoice[3][1]).toBe('Linux');
    expect(listChoice[4][0]).toBe('ANDROID');
    expect(listChoice[4][1]).toBe('Android');
    expect(listChoice[5][0]).toBe('IOS');
    expect(listChoice[5][1]).toBe('iOS');
    expect(listChoice[6][0]).toBe('OTHER');
    expect(listChoice[6][1]).toBe('Other');
  });

  test('is windows', () => {
    expect(Platform.isWindows(Platform.WINDOWS_32)).toBe(true);
    expect(Platform.isWindows(Platform.WINDOWS_64)).toBe(true);
    expect(Platform.isWindows(Platform.MAC_OS)).toBe(false);
    expect(Platform.isWindows(Platform.LINUX)).toBe(false);
    expect(Platform.isWindows(Platform.ANDROID)).toBe(false);
    expect(Platform.isWindows(Platform.IOS)).toBe(false);
    expect(Platform.isWindows(Platform.OTHER)).toBe(false);
  });

  test('is mac', () => {
    expect(Platform.isMac(Platform.WINDOWS_32)).toBe(false);
    expect(Platform.isMac(Platform.WINDOWS_64)).toBe(false);
    expect(Platform.isMac(Platform.MAC_OS)).toBe(true);
    expect(Platform.isMac(Platform.LINUX)).toBe(false);
    expect(Platform.isMac(Platform.ANDROID)).toBe(false);
    expect(Platform.isMac(Platform.IOS)).toBe(false);
    expect(Platform.isMac(Platform.OTHER)).toBe(false);
  });
});
