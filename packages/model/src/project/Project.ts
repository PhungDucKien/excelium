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

import AppType from '../enums/AppType';
import WorkbookType from '../enums/WorkbookType';
import DataSource from './DataSource';
import Template from './Template';
import TestFile from './TestFile';

/**
 * Represents project model.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
export default class Project {
  /**
   * Project name
   */
  public name: string;

  /**
   * Application type
   */
  public appType: AppType;

  /**
   * Workbook type
   */
  public workbookType: WorkbookType;

  /**
   * Base path
   */
  public basePath: string;

  /**
   * Test path
   */
  public testPath: string | null;

  /**
   * Template path
   */
  public templatePath: string | null;

  /**
   * App path
   */
  public appPath: string | null;

  /**
   * File path
   */
  public filePath: string | null;

  /**
   * Screenshot path
   */
  public screenshotPath: string;

  /**
   * Download path
   */
  public downloadPath: string | null;

  /**
   * Test files
   */
  public tests: Map<string, TestFile>;

  /**
   * Templates
   */
  public templates: Map<string, Template>;

  /**
   * Data sources
   */
  public dataSources: Map<string, DataSource>;

  /**
   * Default data source
   */
  public defaultDataSource: string | null;

  /**
   * Add test.
   *
   * @param test the test
   */
  public addTest(test: TestFile) {
    if (this.tests == null) {
      this.tests = new Map<string, TestFile>();
    }
    this.tests.set(test.location, test);
  }

  /**
   * Add template.
   *
   * @param template the template
   */
  public addTemplate(template: Template) {
    if (this.templates == null) {
      this.templates = new Map<string, Template>();
    }
    this.templates.set(template.location, template);
  }

  /**
   * Add data source.
   *
   * @param dataSource the data source
   */
  public addDataSource(dataSource: DataSource) {
    if (this.dataSources == null) {
      this.dataSources = new Map<string, DataSource>();
    }
    this.dataSources.set(dataSource.name, dataSource);
  }

  /**
   * Get test file list choice.
   *
   * @return the test file list choice
   */
  public getTestListChoice(showAll: boolean): string[][] {
    const listChoice = [] as string[][];
    if (this.tests != null) {
      this.tests.forEach(t => {
        listChoice.push([t.location, t.name]);
      });
      if (showAll) {
        listChoice.push([TestFile.ALL, 'All workbooks']);
      }
    }
    return listChoice;
  }

  /**
   * Get template list choice.
   *
   * @return the template list choice
   */
  public getTemplateListChoice(showAll: boolean): string[][] {
    const listChoice = [] as string[][];
    if (this.templates != null) {
      this.templates.forEach(t => {
        listChoice.push([t.location, t.name]);
      });
      if (showAll) {
        listChoice.push([Template.ALL, 'All templates']);
      }
    }
    return listChoice;
  }

  /**
   * Get data source list choice.
   *
   * @return the data source list choice
   */
  public getDataSourceListChoice(showAll: boolean): string[][] {
    const listChoice = [] as string[][];
    if (this.dataSources != null) {
      this.dataSources.forEach(t => {
        listChoice.push([t.name, t.name]);
      });
      if (showAll) {
        listChoice.push([DataSource.ALL, 'All data sources']);
      }
    }
    return listChoice;
  }
}
