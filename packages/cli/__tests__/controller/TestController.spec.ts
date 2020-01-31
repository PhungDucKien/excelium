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

/**
 * Tests for {@link TestController}.
 *
 * @author PhungDucKien
 * @since 2018.04.14
 */
describe('test TestController', () => {
  test('execute all', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'ALL' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('ALL');
          times++;
        },
      };
    });

    await testController.execute({});

    expect(times).toBe(1);
  });

  test('execute all twice', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'ALL' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'ALL' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('ALL');
          times++;
        },
      };
    });

    await testController.execute({});

    expect(times).toBe(2);
  });

  test('execute filter', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      project.tests = new Map([['Workbook1', new TestFile()]]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'FILTER' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Workbook1' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('Workbook1');
          times++;
        },
      };
    });

    await testController.execute({});

    expect(times).toBe(1);
  });

  test('execute filter twice', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      project.tests = new Map([['Workbook1', new TestFile()]]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'FILTER' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Workbook1' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'FILTER' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Workbook1' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('Workbook1');
          times++;
        },
      };
    });

    await testController.execute({});

    expect(times).toBe(2);
  });

  test('execute previous filter', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      project.tests = new Map([['Workbook1', new TestFile()]]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'FILTER' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'Workbook1' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'PREVIOUS_FILTER' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('Workbook1');
          times++;
        },
      };
    });

    await testController.execute({});

    expect(times).toBe(2);
  });

  test('execute all and quit', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('ALL');
          times++;
        },
      };
    });

    await testController.execute({ all: true });

    expect(times).toBe(1);
  });

  test('execute workbook and quit', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('workbook-id');
          times++;
        },
      };
    });

    await testController.execute({ workbook: 'workbook-id' });

    expect(times).toBe(1);
  });

  test('execute sheet and quit', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('workbook-id');
          expect(testFilter.sheet).toBe('sheet-name');
          times++;
        },
      };
    });

    await testController.execute({ workbook: 'workbook-id', sheet: 'sheet-name' });

    expect(times).toBe(1);
  });

  test('execute test case and quit', async () => {
    let times = 0;
    const testController = new TestController();

    // @ts-ignore
    testController.projectProvider = () => {
      const project = new Project();
      return Promise.resolve(project);
    };
    // @ts-ignore
    testController.testReaderFactoryProvider = async () => {
      return Promise.resolve(new ExcelReaderFactory());
    };
    // @ts-ignore
    testController.testWriterFactoryProvider = async () => {
      return Promise.resolve(new ExcelWriterFactory());
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'QUIT' });
      });

    // @ts-ignore
    TestExecutor.mockImplementationOnce(() => {
      return {
        execute: (testFilter: TestFilter) => {
          expect(testFilter.workbook).toBe('workbook-id');
          expect(testFilter.sheet).toBe('sheet-name');
          expect(testFilter.testCase).toBe('case-no');
          times++;
        },
      };
    });

    await testController.execute({ workbook: 'workbook-id', sheet: 'sheet-name', testCase: 'case-no' });

    expect(times).toBe(1);
  });
});
