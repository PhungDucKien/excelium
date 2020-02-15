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

import { Prompt, StringUtil } from '@excelium/common';
import { GenericTestReaderFactory, GenericTestWriterFactory, TestExecutor } from '@excelium/core';
import { Project, Result, TestCase, TestFile, TestFilter, TestRunConfig, TestSuite } from '@excelium/model';
import inquirer, { ChoiceOptions, DistinctChoice } from 'inquirer';
import { inject } from 'inversify';
import isCI from 'is-ci';
import updateNotifier from 'update-notifier';
import pkg from '../../package.json';
import BeanFactory from '../BeanFactory';
import { action, group } from '../commander';
import BaseController from './BaseController';

/**
 * Provides commands for controlling test.
 *
 * @author PhungDucKien
 * @since 2018.04.13
 */
@group({ name: 'exec', default: true })
export default class TestController extends BaseController {
  private static readonly ACTION_ALL = 'ALL';
  private static readonly ACTION_PREVIOUS_FILTER = 'PREVIOUS_FILTER';
  private static readonly ACTION_FILTER_TESTS = 'FILTER';
  private static readonly ACTION_QUIT = 'QUIT';

  /**
   * Project instance
   */
  @inject(BeanFactory.projectProvider)
  protected projectProvider: () => Promise<Project>;

  /**
   * Test reader factory
   */
  @inject(BeanFactory.testReaderFactoryProvider)
  protected testReaderFactoryProvider: () => Promise<GenericTestReaderFactory>;

  /**
   * Test writer factory
   */
  @inject(BeanFactory.testWriterFactoryProvider)
  protected testWriterFactoryProvider: () => Promise<GenericTestWriterFactory>;

  /**
   * Executes tests.
   */
  @action({
    options: [
      /**
       * All flag
       */
      {
        key: 'all',
        options: {
          alias: 'a',
          description: 'Run all tests',
          boolean: true,
        },
      },
      /**
       * Workbook filter
       */
      {
        key: 'workbook',
        options: {
          alias: 'w',
          description: 'Run workbook tests',
          string: true,
        },
      },
      /**
       * Sheet filter
       */
      {
        key: 'sheet',
        options: {
          alias: 's',
          description: 'Run sheet tests',
          string: true,
        },
      },
      /**
       * Test case filter
       */
      {
        key: 'test-case',
        options: {
          alias: 't',
          description: 'Run test case',
          string: true,
        },
      },
      /**
       * Remote host
       */
      {
        key: 'remote-host',
        options: {
          description: 'Remote WebDriver server host',
          string: true,
        },
      },
      /**
       * Remote port
       */
      {
        key: 'remote-port',
        options: {
          description: 'Remote WebDriver server port',
          number: true,
        },
      },
      /**
       * UDID
       */
      {
        key: 'udid',
        options: {
          description: 'Unique device identifier of the connected device',
          string: true,
        },
      },
      /**
       * Headless flag
       */
      {
        key: 'headless',
        options: {
          description: 'Run browser in headless mode',
          boolean: true,
        },
      },
      ...BaseController.baseParameters,
    ],
    default: true,
  })
  public async execute(argv: any): Promise<void> {
    console.log('Excelium ' + pkg.version);

    if (!isCI) {
      // Checks for available update and returns an instance
      const notifier = updateNotifier({ pkg });

      // Notify using the built-in convenience method
      notifier.notify();
    }

    const project = await this.projectProvider();
    const testReaderFactory = await this.testReaderFactoryProvider();
    const testWriterFactory = await this.testWriterFactoryProvider();

    // TODO
    // FileServer fileServer = null;

    // if (this.isRemoteHost(argv.remoteHost)) {
    //     fileServer = FileServer.createInstance(project);
    //     fileServer.start();
    // }

    try {
      const runConfig = new TestRunConfig();
      runConfig.remoteHost = argv.remoteHost;
      runConfig.remotePort = argv.remotePort;
      runConfig.udid = argv.udid;
      runConfig.headless = argv.headless;

      const testExecutor = new TestExecutor(project, runConfig, testReaderFactory, testWriterFactory);
      let testFilter = new TestFilter();
      let testExecuted = false;
      let testResult: Result | null = null;

      if (argv.all) {
        testFilter.workbook = TestFile.ALL;
        testResult = await testExecutor.execute(testFilter);
        testExecuted = true;

        if (isCI) {
          return process.exit(this.getExitCode(testResult));
        }
      }

      if (argv.workbook && StringUtil.isNotBlank(argv.workbook)) {
        testFilter.workbook = argv.workbook;

        if (argv.sheet && StringUtil.isNotBlank(argv.sheet)) {
          testFilter.sheet = argv.sheet;

          if (argv.testCase && StringUtil.isNotBlank(argv.testCase)) {
            testFilter.testCase = argv.testCase;
          } else {
            testFilter.testCase = TestCase.ALL;
          }
        } else {
          testFilter.sheet = TestSuite.ALL;
        }

        testResult = await testExecutor.execute(testFilter);
        testExecuted = true;

        if (isCI) {
          return process.exit(this.getExitCode(testResult));
        }
      }

      let chooseAction = '';
      while (chooseAction !== TestController.ACTION_QUIT) {
        chooseAction = await this.promptAction(
          testExecuted,
          argv.all,
          StringUtil.isNotBlank(argv.workbook),
          StringUtil.isNotBlank(argv.sheet),
          StringUtil.isNotBlank(argv.testCase)
        );
        switch (chooseAction) {
          case TestController.ACTION_ALL:
            testFilter = new TestFilter();
            testFilter.workbook = TestFile.ALL;
            testResult = await testExecutor.execute(testFilter);
            testExecuted = true;
            break;
          case TestController.ACTION_PREVIOUS_FILTER:
            testResult = await testExecutor.execute(testFilter);
            testExecuted = true;
            break;
          case TestController.ACTION_FILTER_TESTS:
            testFilter = new TestFilter();

            if (argv.workbook && StringUtil.isNotBlank(argv.workbook)) {
              testFilter.workbook = argv.workbook;

              if (argv.sheet && StringUtil.isNotBlank(argv.sheet)) {
                testFilter.sheet = argv.sheet;

                if (argv.testCase && StringUtil.isNotBlank(argv.testCase)) {
                  testFilter.testCase = argv.testCase;
                }
              }
            } else {
              const runWorkbook = await Prompt.promptList('Choose the test file to run:', project.getTestListChoice(true));
              testFilter.workbook = runWorkbook;
            }

            testResult = await testExecutor.execute(testFilter);
            testExecuted = true;
            break;
        }

        if (isCI) {
          return process.exit(this.getExitCode(testResult));
        }
      }
    } finally {
      // if (fileServer != null) {
      //     fileServer.stop();
      // }
    }
  }

  /**
   * Prompts for user to choose action
   *
   * @return User selected action
   */
  private promptAction(
    testExecuted: boolean,
    allFlag: boolean,
    hasWorkbookFlag: boolean,
    hasSheetFlag: boolean,
    hasTestCaseFlag: boolean
  ): Promise<string> {
    const choices = [] as Array<DistinctChoice<ChoiceOptions>>;
    if (!hasWorkbookFlag) {
      choices.push({
        key: 'a',
        name: 'Run all tests',
        value: TestController.ACTION_ALL,
      });
    }

    if (!allFlag) {
      if (hasWorkbookFlag && hasSheetFlag && hasTestCaseFlag) {
        choices.push({
          key: 't',
          name: 'Run filter tests',
          value: TestController.ACTION_FILTER_TESTS,
        });
      } else {
        if (testExecuted) {
          choices.push({
            key: 'p',
            name: 'Use previous filter and run tests',
            value: TestController.ACTION_PREVIOUS_FILTER,
          });
        }
        choices.push({
          key: 't',
          name: 'Set filter and run tests',
          value: TestController.ACTION_FILTER_TESTS,
        });
      }
    }
    choices.push(new inquirer.Separator());
    if (testExecuted) {
      choices.push({
        key: 'q',
        name: 'Quit',
        value: TestController.ACTION_QUIT,
      });
    }

    return inquirer
      .prompt({
        name: 'prompt',
        type: 'expand',
        message: 'Press one of the following keys to continue (or press <h> for help)',
        choices,
      })
      .then(ret => ret.prompt);
  }

  private isRemoteHost(remoteHost?: string): boolean {
    return !!remoteHost && StringUtil.isNotBlank(remoteHost);
  }

  private getExitCode(result: Result | null): number {
    if (result == null || result === Result.ERROR) {
      return 9;
    } else if (result === Result.FAIL) {
      return 1;
    } else {
      return 0;
    }
  }
}
