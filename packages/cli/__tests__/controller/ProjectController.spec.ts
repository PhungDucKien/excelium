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

import { ProjectGenerator } from '@excelium/generator';
import inquirer from 'inquirer';
import ProjectController from '../../src/controller/ProjectController';

jest.mock('inquirer');
jest.mock('@excelium/generator');

/**
 * Tests for {@link ProjectController}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
describe('test ProjectController', () => {
  test('create web sheets', async () => {
    let updated = false;

    const projectController = new ProjectController();

    (inquirer.prompt as any)
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'myproject' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'WEB' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'SHEETS' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'file' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'download' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'screenshot' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: false });
      });

    (ProjectGenerator as jest.Mock<ProjectGenerator>).mockImplementationOnce(() => {
      return {
        createProject: async () => {
          updated = true;
        },
        updateProject: async () => undefined,
      };
    });

    await projectController.create({});

    expect(updated).toBeTruthy();
  });

  test('create web excel', async () => {
    let updated = false;

    const projectController = new ProjectController();

    (inquirer.prompt as any)
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'myproject' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'WEB' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'EXCEL' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'test' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'template' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'file' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'download' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'screenshot' });
      });

    (ProjectGenerator as jest.Mock<ProjectGenerator>).mockImplementationOnce(() => {
      return {
        createProject: async () => {
          updated = true;
        },
        updateProject: async () => undefined,
      };
    });

    await projectController.create({});

    expect(updated).toBeTruthy();
  });

  test('create mobile sheets', async () => {
    let updated = false;

    const projectController = new ProjectController();

    (inquirer.prompt as any)
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'myproject' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'MOBILE' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'SHEETS' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'app' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'screenshot' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: false });
      });

    (ProjectGenerator as jest.Mock<ProjectGenerator>).mockImplementationOnce(() => {
      return {
        createProject: async () => {
          updated = true;
        },
        updateProject: async () => undefined,
      };
    });

    await projectController.create({});

    expect(updated).toBeTruthy();
  });

  test('create mobile excel', async () => {
    let updated = false;

    const projectController = new ProjectController();

    (inquirer.prompt as any)
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'myproject' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'MOBILE' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'EXCEL' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'test' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'template' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'app' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'screenshot' });
      });

    (ProjectGenerator as jest.Mock<ProjectGenerator>).mockImplementationOnce(() => {
      return {
        createProject: async () => {
          updated = true;
        },
        updateProject: async () => undefined,
      };
    });

    await projectController.create({});

    expect(updated).toBeTruthy();
  });
});
