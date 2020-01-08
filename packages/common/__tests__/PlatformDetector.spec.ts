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

import { Platform } from '@excelium/model';
import PlatformDetector from '../src/PlatformDetector';

/**
 * Tests for {@link PlatformDetector}.
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
describe('test PlatformDetector', () => {
  test('get platform win32', () => {
    jest.spyOn(PlatformDetector, 'getOsName').mockImplementationOnce(() => 'win32');
    jest.spyOn(PlatformDetector, 'getOsArch').mockImplementationOnce(() => 'x32');

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;

    expect(PlatformDetector.getPlatform()).toBe(Platform.WINDOWS_32);

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;
  });

  test('get platform win64', () => {
    jest.spyOn(PlatformDetector, 'getOsName').mockImplementationOnce(() => 'win32');
    jest.spyOn(PlatformDetector, 'getOsArch').mockImplementationOnce(() => 'x64');

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;

    expect(PlatformDetector.getPlatform()).toBe(Platform.WINDOWS_64);

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;
  });

  test('get platform mac', () => {
    jest.spyOn(PlatformDetector, 'getOsName').mockImplementationOnce(() => 'darwin');

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;

    expect(PlatformDetector.getPlatform()).toBe(Platform.MAC_OS);

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;
  });

  test('get platform linux', () => {
    jest.spyOn(PlatformDetector, 'getOsName').mockImplementationOnce(() => 'linux');

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;

    expect(PlatformDetector.getPlatform()).toBe(Platform.LINUX);

    // @ts-ignore
    PlatformDetector.detectedPlatform = null;
  });
});
