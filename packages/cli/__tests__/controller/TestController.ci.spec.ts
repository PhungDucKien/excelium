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

import { TestExecutor } from '@excelium/core';
import { Project, TestFile, TestFilter } from '@excelium/model';
import { ExcelReaderFactory, ExcelWriterFactory } from '@excelium/xls';
import inquirer from 'inquirer';
import TestController from '../../src/controller/TestController';

jest.mock('inquirer');
jest.mock('@excelium/core');
jest.mock('is-ci', () => true);

/**
 * Tests for {@link TestController}.
 *
 * @author PhungDucKien
 * @since 2018.04.14
 */
describe('test TestController', () => {
  test('execute all one time', async () => {
    jest.mock('is-ci', () => true);

    (jest.spyOn(process, 'exit') as any).mockImplementationOnce(() => null);

    let times = 0;

    class MyTestController extends TestController {
      protected projectProvider = () => {
        const project = new Project();
        return Promise.resolve(project);
      };

      protected testReaderFactoryProvider = async () => {
        return Promise.resolve(new ExcelReaderFactory());
      };

      protected testWriterFactoryProvider = async () => {
        return Promise.resolve(new ExcelWriterFactory());
      };
    }

    (TestExecutor as any).mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('ALL');
          times++;
        },
      };
    });

    const testController = new MyTestController();
    await testController.execute({ all: true });

    expect(times).toBe(1);
  });

  test('execute workbook one time', async () => {
    (jest.spyOn(process, 'exit') as any).mockImplementationOnce(() => null);

    let times = 0;

    class MyTestController extends TestController {
      protected projectProvider = () => {
        const project = new Project();
        return Promise.resolve(project);
      };

      protected testReaderFactoryProvider = async () => {
        return Promise.resolve(new ExcelReaderFactory());
      };

      protected testWriterFactoryProvider = async () => {
        return Promise.resolve(new ExcelWriterFactory());
      };
    }

    (TestExecutor as any).mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('workbook-id');
          times++;
        },
      };
    });

    const testController = new MyTestController();
    await testController.execute({ workbook: 'workbook-id' });

    expect(times).toBe(1);
  });

  test('execute sheet one time', async () => {
    (jest.spyOn(process, 'exit') as any).mockImplementationOnce(() => null);

    let times = 0;

    class MyTestController extends TestController {
      protected projectProvider = () => {
        const project = new Project();
        return Promise.resolve(project);
      };

      protected testReaderFactoryProvider = async () => {
        return Promise.resolve(new ExcelReaderFactory());
      };

      protected testWriterFactoryProvider = async () => {
        return Promise.resolve(new ExcelWriterFactory());
      };
    }

    (TestExecutor as any).mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('workbook-id');
          expect(testFilter.sheet).toBe('sheet-name');
          times++;
        },
      };
    });

    const testController = new MyTestController();
    await testController.execute({ workbook: 'workbook-id', sheet: 'sheet-name' });

    expect(times).toBe(1);
  });

  test('execute test case one time', async () => {
    (jest.spyOn(process, 'exit') as any).mockImplementationOnce(() => null);

    let times = 0;

    class MyTestController extends TestController {
      protected projectProvider = () => {
        const project = new Project();
        return Promise.resolve(project);
      };

      protected testReaderFactoryProvider = async () => {
        return Promise.resolve(new ExcelReaderFactory());
      };

      protected testWriterFactoryProvider = async () => {
        return Promise.resolve(new ExcelWriterFactory());
      };
    }

    (TestExecutor as any).mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('workbook-id');
          expect(testFilter.sheet).toBe('sheet-name');
          expect(testFilter.testCase).toBe('case-no');
          times++;
        },
      };
    });

    const testController = new MyTestController();
    await testController.execute({ workbook: 'workbook-id', sheet: 'sheet-name', testCase: 'case-no' });

    expect(times).toBe(1);
  });

  test('execute one time', async () => {
    (jest.spyOn(process, 'exit') as any).mockImplementationOnce(() => null);

    let times = 0;

    class MyTestController extends TestController {
      protected projectProvider = () => {
        const project = new Project();
        project.tests = new Map([['Workbook1', new TestFile()]]);
        return Promise.resolve(project);
      };

      protected testReaderFactoryProvider = async () => {
        return Promise.resolve(new ExcelReaderFactory());
      };

      protected testWriterFactoryProvider = async () => {
        return Promise.resolve(new ExcelWriterFactory());
      };
    }

    (inquirer.prompt as any)
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'FILTER' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Workbook1' });
      });

    (TestExecutor as any).mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('Workbook1');
          times++;
        },
      };
    });

    const testController = new MyTestController();
    await testController.execute({});

    expect(times).toBe(1);
  });
});
