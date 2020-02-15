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

import { WorkbookType } from '@excelium/model';
import fs from 'fs-extra';
import inquirer from 'inquirer';
import Prompt from '../src/Prompt';

jest.mock('inquirer');

/**
 * Tests for {@link Prompt}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
describe('test Prompt', () => {
  test('prompt input', async () => {
    (inquirer.prompt as any).mockImplementationOnce((questions: any) => {
      expect(questions.type).toBe('input');
      expect(questions.message).toBe('Question');
      return Promise.resolve({ prompt: 'result' });
    });

    const result = await Prompt.promptInput('Question');
    expect(result).toBe('result');
  });

  test('prompt string array', async () => {
    (inquirer.prompt as any).mockImplementationOnce((questions: any) => {
      expect(questions.type).toBe('list');
      expect(questions.message).toBe('Question');
      expect(questions.choices.length).toBe(1);
      expect(questions.choices[0].value).toBe('result');
      expect(questions.choices[0].name).toBe('desc');
      return Promise.resolve({ prompt: 'result' });
    });

    const result = await Prompt.promptList('Question', [['result', 'desc']]);
    expect(result).toBe('result');
  });

  test('prompt list', async () => {
    (inquirer.prompt as any).mockImplementationOnce((questions: any) => {
      expect(questions.type).toBe('list');
      expect(questions.message).toBe('Question');
      expect(questions.choices.length).toBe(1);
      expect(questions.choices[0].value).toBe('result');
      expect(questions.choices[0].name).toBe('result');
      return Promise.resolve({ prompt: 'result' });
    });

    const result = await Prompt.promptList('Question', ['result']);
    expect(result).toBe('result');
  });

  test('prompt confirm', async () => {
    (inquirer.prompt as any).mockImplementationOnce((questions: any) => {
      expect(questions.type).toBe('confirm');
      expect(questions.message).toBe('Question');
      return Promise.resolve({ prompt: true });
    });

    const result = await Prompt.promptConfirm('Question');
    expect(result).toBe(true);
  });

  test('prompt file location excel', async () => {
    (inquirer.prompt as any).mockImplementationOnce((questions: any) => {
      expect(questions.type).toBe('list');
      expect(questions.message).toBe('Question');
      expect(questions.choices.length).toBe(1);
      expect(questions.choices[0].value).toBe('result');
      expect(questions.choices[0].name).toBe('result');
      return Promise.resolve({ prompt: 'result' });
    });

    const basePath = 'myproject';
    fs.removeSync(basePath);
    fs.ensureFileSync(basePath + '/result');

    const result = await Prompt.promptFileLocation(WorkbookType.EXCEL, basePath, 'Question');
    expect(result).toBe(basePath + '/result');

    fs.removeSync(basePath);
  });

  test('prompt file location sheets', async () => {
    (inquirer.prompt as any).mockImplementationOnce((questions: any) => {
      expect(questions.type).toBe('input');
      expect(questions.message).toBe('Question');
      return Promise.resolve({ prompt: 'result' });
    });

    const result = await Prompt.promptFileLocation(WorkbookType.SHEETS, undefined, undefined, 'Question');
    expect(result).toBe('result');
  });
});
