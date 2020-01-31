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

import { Project, Template, WorkbookType } from '@excelium/model';
import { GoogleConnectionService, SheetsReaderFactory, SheetsServiceProvider } from '@excelium/sheets';
import inquirer from 'inquirer';
import TemplateController from '../../src/controller/TemplateController';

jest.mock('inquirer');

/**
 * Tests for {@link TemplateController}.
 *
 * @author PhungDucKien
 * @since 2018.04.12
 */
describe('test TemplateController', () => {
  test('import template simple', async () => {
    let updated = false;

    const templateController = new TemplateController();
    // @ts-ignore
    templateController.projectProvider = () => {
      const project = new Project();
      project.workbookType = WorkbookType.SHEETS;
      return Promise.resolve(project);
    };
    // @ts-ignore
    templateController.testReaderFactoryProvider = async () => {
      const connection = new GoogleConnectionService();
      const sheetsServiceProvider = new SheetsServiceProvider(connection);
      const sheetsService = await sheetsServiceProvider.createSheetsService();
      return Promise.resolve(new SheetsReaderFactory(sheetsService));
    };

    // @ts-ignore
    templateController.updateProjectFile = project => {
      updated = true;
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'https://docs.google.com/spreadsheets/u/2/d/10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY/edit#gid=0' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: '*' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: false });
      });

    await templateController.importTemplate();

    expect(updated).toBeTruthy();
  }, 60000);

  test('import template complex', async () => {
    let updated = false;

    const templateController = new TemplateController();
    // @ts-ignore
    templateController.projectProvider = () => {
      const project = new Project();
      project.workbookType = WorkbookType.SHEETS;
      return Promise.resolve(project);
    };
    // @ts-ignore
    templateController.testReaderFactoryProvider = async () => {
      const connection = new GoogleConnectionService();
      const sheetsServiceProvider = new SheetsServiceProvider(connection);
      const sheetsService = await sheetsServiceProvider.createSheetsService();
      return Promise.resolve(new SheetsReaderFactory(sheetsService));
    };

    // @ts-ignore
    templateController.updateProjectFile = project => {
      updated = true;
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'https://docs.google.com/spreadsheets/d/1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50/edit#gid=0' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Mapping' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Actions' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Test Data' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: '*' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: true });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Commands' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: false });
      });

    await templateController.importTemplate();

    expect(updated).toBeTruthy();
  }, 60000);

  test('import remove', async () => {
    let updated = false;

    const templateController = new TemplateController();
    // @ts-ignore
    templateController.projectProvider = () => {
      const project = new Project();
      project.templates = new Map([
        ['Template1', new Template()],
        ['Template2', new Template()],
        ['Template3', new Template()],
      ]);
      return Promise.resolve(project);
    };

    // @ts-ignore
    templateController.updateProjectFile = project => {
      expect(project.templates.size).toBe(2);
      updated = true;
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Template2' });
      });

    await templateController.remove();

    expect(updated).toBeTruthy();
  });
});
