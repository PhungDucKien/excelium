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

import 'reflect-metadata';

import { Project, Template, TestFile, WorkbookType } from '@excelium/model';
import { GoogleConnectionService, SheetsReaderFactory, SheetsServiceProvider } from '@excelium/sheets';
import inquirer from 'inquirer';
import TestFileController from '../../src/controller/TestFileController';

jest.mock('inquirer');

/**
 * Tests for {@link TestFileController}.
 *
 * @author PhungDucKien
 * @since 2018.04.13
 */
describe('test TestFileController', () => {
  test('add', async () => {
    let updated = false;

    const testFileController = new TestFileController();
    // @ts-ignore
    testFileController.projectProvider = () => {
      const project = new Project();
      project.workbookType = WorkbookType.SHEETS;
      project.templates = new Map([
        ['Template1', new Template()],
        ['Template2', new Template()],
        ['Template3', new Template()],
      ]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    testFileController.testReaderFactoryProvider = async () => {
      const connection = new GoogleConnectionService();
      const sheetsServiceProvider = new SheetsServiceProvider(connection);
      const sheetsService = await sheetsServiceProvider.createSheetsService();
      return Promise.resolve(new SheetsReaderFactory(sheetsService));
    };

    // @ts-ignore
    testFileController.updateProjectFile = project => {
      expect(project.tests.size).toBe(1);
      updated = true;
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'https://docs.google.com/spreadsheets/u/2/d/10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY/edit#gid=0' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Template1' });
      });

    await testFileController.add();

    expect(updated).toBeTruthy();
  }, 60000);

  test('remove', async () => {
    let updated = false;

    const testFileController = new TestFileController();
    // @ts-ignore
    testFileController.projectProvider = () => {
      const project = new Project();
      project.tests = new Map([
        ['File1', new TestFile()],
        ['File2', new TestFile()],
        ['File3', new TestFile()],
      ]);
      return Promise.resolve(project);
    };

    // @ts-ignore
    testFileController.updateProjectFile = project => {
      expect(project.tests.size).toBe(2);
      updated = true;
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'File2' });
      });

    await testFileController.remove();

    expect(updated).toBeTruthy();
  });
});
