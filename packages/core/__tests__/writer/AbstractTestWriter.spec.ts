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

import { Result, Template, TestStep } from '@excelium/model';
import os from 'os';
import AbstractTestWriter from '../../src/writer/AbstractTestWriter';

jest.mock('os');

/**
 * Tests for {@link AbstractTestWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
describe('test AbstractTestWriter', () => {
  test('write result', () => {
    const fake = new Date(2018, 0, 1);
    (jest.spyOn(global, 'Date') as any).mockImplementationOnce(() => fake);

    (os.userInfo as any).mockReturnValueOnce({ username: 'username' });

    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set(Template.TEST_DATE, 'Sheet1!A2');
    markupLocations.set(Template.TEST_PERSON, 'Sheet1!B3');
    markupLocations.set(Template.TEST_RESULT, 'Sheet1!C4');
    template.markupLocations = markupLocations;

    const testStep = new TestStep();
    testStep.rowIndex = 3 * 10;

    const testWriter = new MyTestWriter();
    testWriter.writeResult(template, 'Sheet2', testStep, Result.OK);

    expect(testWriter.getFlushValues().size).toBe(3);
    expect(testWriter.getFlushValues().get('Sheet2!A32')![0][0]).toBe(fake);
    expect(testWriter.getFlushValues().get('Sheet2!B33')![0][0]).toBe('username');
    expect(testWriter.getFlushValues().get('Sheet2!C34')![0][0]).toBe('OK');
  });

  class MyTestWriter extends AbstractTestWriter {
    public getFlushValues() {
      return this.flushValues;
    }

    public async flush(): Promise<void> {
      // Empty
    }
  }
});
