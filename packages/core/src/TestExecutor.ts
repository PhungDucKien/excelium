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

import { Project, Result, TestFile, TestFilter, TestRunConfig } from '@excelium/model';
import { GenericTestReaderFactory, GenericTestWriterFactory } from '.';

/**
 * Executes project's tests.
 *
 * @author PhungDucKien
 * @since 2018.04.13
 */
export default class TestExecutor {
  /**
   * Project instance
   */
  private project: Project;

  /**
   * Test run config
   */
  private testRunConfig: TestRunConfig;

  /**
   * Test reader factory
   */
  private testReaderFactory: GenericTestReaderFactory;

  /**
   * Test writer factory
   */
  private testWriterFactory: GenericTestWriterFactory;

  /**
   * Instantiates a new Test executor.
   *
   * @param project           the project
   * @param testRunConfig     the test run config
   * @param testReaderFactory the test reader factory
   * @param testWriterFactory the test writer factory
   */
  constructor(
    project: Project,
    testRunConfig: TestRunConfig,
    testReaderFactory: GenericTestReaderFactory,
    testWriterFactory: GenericTestWriterFactory
  ) {
    this.project = project;
    this.testRunConfig = testRunConfig;
    this.testReaderFactory = testReaderFactory;
    this.testWriterFactory = testWriterFactory;
  }

  /**
   * Executes tests.
   *
   * @param testFilter the test filter
   * @return Result of the test
   */
  public async execute(testFilter: TestFilter): Promise<Result> {
    let result = Result.OK;
    const testFiles = this.filterTestFiles(testFilter);
    for (const testFile of testFiles) {
      const template = this.project.templates.get(testFile.template)!;
      try {
        const testReader = this.testReaderFactory.createReader(testFile.location);
        const workbook = await testReader.getWorkbook();
        const testWriter = this.testWriterFactory.createWriter(workbook, testFile.location);

        // Parses test
        const test = await testReader.parseTest(template, workbook, testFilter, testWriter);

        // TODO
        // // Test reporter
        // const testReporter = new TestReporter(System.out);

        // // Executes all tests of workbook
        // const testRunner = new TestRunner(test, project, testRunConfig, testReporter, testWriter, template);
        // const testResult = testRunner.runAll();
        // if (testResult === Result.ERROR) {
        //     result = Result.ERROR;
        // } else if (testResult === Result.FAIL && result !== Result.ERROR) {
        //     result = Result.FAIL;
        // }
      } catch (e) {
        console.error(e);
        result = Result.ERROR;
      }
    }
    return result;
  }

  /**
   * Filter test files.
   *
   * @param testFilter the test filter
   * @return filtered test files
   */
  private filterTestFiles(testFilter: TestFilter): TestFile[] {
    const tests = this.project.tests;
    if (testFilter && testFilter.workbook && testFilter.workbook !== TestFile.ALL) {
      const filtered = [] as TestFile[];
      const workbook = testFilter.workbook;
      if (Array.from(tests.keys()).indexOf(workbook) !== -1) {
        filtered.push(tests.get(workbook)!);
      }
      return filtered;
    } else {
      return Array.from(tests.values());
    }
  }
}
