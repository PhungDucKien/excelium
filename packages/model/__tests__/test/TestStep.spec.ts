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
import Platform from '../../src/enums/Platform';
import MobileAppEnvironment from '../../src/test/config/MobileAppEnvironment';
import PcEnvironment from '../../src/test/config/PcEnvironment';
import TestStep from '../../src/test/TestStep';

/**
 * Tests for {@link TestStep}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
describe('test TestStep', () => {
  test('is step skip', () => {
    const testStep = new TestStep();
    testStep.gutter = null;
    testStep.androidGutter = 'M';
    testStep.iosGutter = 'S';

    const web = new PcEnvironment();
    web.browser = Browser.CHROME;
    expect(testStep.isStepSkip(web)).toBe(false);

    const android = new MobileAppEnvironment();
    android.platform = Platform.ANDROID;
    expect(testStep.isStepSkip(android)).toBe(false);

    const ios = new MobileAppEnvironment();
    ios.platform = Platform.IOS;
    expect(testStep.isStepSkip(ios)).toBe(true);
  });

  test('is step debug', () => {
    const testStep = new TestStep();
    testStep.gutter = 'D';
    testStep.androidGutter = null;
    testStep.iosGutter = 'S';

    const web = new PcEnvironment();
    web.browser = Browser.CHROME;
    expect(testStep.isStepDebug(web)).toBe(true);

    const android = new MobileAppEnvironment();
    android.platform = Platform.ANDROID;
    expect(testStep.isStepDebug(android)).toBe(false);

    const ios = new MobileAppEnvironment();
    ios.platform = Platform.IOS;
    expect(testStep.isStepDebug(ios)).toBe(false);
  });
});
