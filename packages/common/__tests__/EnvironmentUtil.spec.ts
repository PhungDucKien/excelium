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

import { Browser, MobileAppEnvironment, MobileWebEnvironment, PcEnvironment, Platform } from '@excelium/model';
import EnvironmentUtil from '../src/EnvironmentUtil';

/**
 * Tests for {@link EnvironmentUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
describe('test EnvironmentUtil', () => {
  test('get available Pc environments', () => {
    let environments = EnvironmentUtil.getAvailablePcEnvironments(Browser.CHROME, [], [], '');
    expect(environments.length).toBe(1);
    expect((environments[0] as PcEnvironment).browser).toBe(Browser.CHROME);
    expect((environments[0] as PcEnvironment).resolution).toBe('1024x768');

    environments = EnvironmentUtil.getAvailablePcEnvironments(Browser.CHROME, ['10.0'], ['800x600'], '');
    expect(environments.length).toBe(1);
    expect((environments[0] as PcEnvironment).browser).toBe(Browser.CHROME);
    expect((environments[0] as PcEnvironment).browserVersion).toBe('10.0');
    expect((environments[0] as PcEnvironment).resolution).toBe('800x600');
  });

  test('get available mobile web environments', () => {
    let environments = EnvironmentUtil.getAvailableMobileWebEnvironments(Platform.ANDROID, [], [], [], '', [], '');
    expect(environments.length).toBe(1);
    expect((environments[0] as MobileWebEnvironment).browser).toBe(Browser.CHROME);
    expect(environments[0].platform).toBe(Platform.ANDROID);
    expect((environments[0] as MobileWebEnvironment).deviceName).toBe('Android');
    expect((environments[0] as MobileWebEnvironment).orientation).toBe('Portrait');

    environments = EnvironmentUtil.getAvailableMobileWebEnvironments(Platform.IOS, [], [], [], '', [], '');
    expect(environments.length).toBe(1);
    expect((environments[0] as MobileWebEnvironment).browser).toBe(Browser.SAFARI);
    expect(environments[0].platform).toBe(Platform.IOS);
    expect((environments[0] as MobileWebEnvironment).deviceName).toBe('iPhone');
    expect((environments[0] as MobileWebEnvironment).orientation).toBe('Portrait');
  });

  test('get available mobile app environments', () => {
    let environments = EnvironmentUtil.getAvailableMobileAppEnvironments(Platform.ANDROID, [], [], [], '', '', '', '', '', '', '');
    expect(environments.length).toBe(1);
    expect(environments[0].platform).toBe(Platform.ANDROID);
    expect((environments[0] as MobileAppEnvironment).deviceName).toBe('Android');
    expect((environments[0] as MobileAppEnvironment).orientation).toBe('Portrait');

    environments = EnvironmentUtil.getAvailableMobileAppEnvironments(Platform.IOS, [], [], [], '', '', '', '', '', '', '');
    expect(environments.length).toBe(1);
    expect(environments[0].platform).toBe(Platform.IOS);
    expect((environments[0] as MobileAppEnvironment).deviceName).toBe('iPhone');
    expect((environments[0] as MobileAppEnvironment).orientation).toBe('Portrait');
  });
});
