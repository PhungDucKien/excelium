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

import { JsonMarshaller } from '@excelium/common';
import { GenericTestReaderFactory, GenericTestWriterFactory } from '@excelium/core';
import { AppType, Project, Template, TestFile, WorkbookType } from '@excelium/model';
import { GoogleConnection, SheetsReaderFactory, SheetsWriterFactory } from '@excelium/sheets';
import { ExcelReaderFactory, ExcelWriterFactory } from '@excelium/xls';
import fs from 'fs-extra';
import { sheets_v4 } from 'googleapis';
import { Container, inject, injectable } from 'inversify';
import BeanFactory from '../src/BeanFactory';

/**
 * Tests for {@link BeanFactory}.
 *
 * @author PhungDucKien
 * @since 2018.04.20
 */
describe('test BeanFactory', () => {
  test('get project', async () => {
    const project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;
    project.testPath = 'tests';

    const testFiles = new Map<string, TestFile>();
    const testFile = new TestFile();
    testFile.name = 'testFile';
    testFile.location = 'testFile.xlsx';
    testFiles.set('testFile', testFile);
    project.tests = testFiles;

    const templates = new Map<string, Template>();
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%SYSTEM_NAME%', 'A2');
    template.markupLocations = markupLocations;
    const ignorePatterns = [] as string[];
    ignorePatterns.push('*');
    template.ignorePatterns = ignorePatterns;
    templates.set('default', template);
    project.templates = templates;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    @injectable()
    class Klass {
      @inject(BeanFactory.projectProvider)
      private projectProvider: () => Promise<Project>;

      public project() {
        return this.projectProvider();
      }
    }

    const container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container.bind<Klass>(Klass).to(Klass);

    const klass = container.get<Klass>(Klass);
    const unmarshalled = await klass.project();

    expect(unmarshalled.name).toBe('myproject');
    expect(unmarshalled.appType).toBe(AppType.WEB);
    expect(unmarshalled.workbookType).toBe(WorkbookType.SHEETS);
    expect(unmarshalled.testPath).toBe('tests');

    expect(unmarshalled.tests.size).toBe(1);
    expect(unmarshalled.tests.get('testFile')!.name).toBe('testFile');
    expect(unmarshalled.tests.get('testFile')!.location).toBe('testFile.xlsx');

    expect(unmarshalled.templates.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.get('%SYSTEM_NAME%')).toBe('A2');
    expect(unmarshalled.templates.get('default')!.ignorePatterns.length).toBe(1);
    expect(unmarshalled.templates.get('default')!.ignorePatterns[0]).toBe('*');

    await fs.remove('myproject');
  });

  test('get google connection', async () => {
    let project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    @injectable()
    class Klass {
      @inject(BeanFactory.googleConnectionProvider)
      private googleConnectionProvider: () => Promise<GoogleConnection | null>;

      public async googleConnection() {
        return await this.googleConnectionProvider();
      }
    }

    let container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container.bind<Klass>(Klass).to(Klass);

    let klass = container.get<Klass>(Klass);
    let googleConnection = await klass.googleConnection();

    expect(googleConnection).not.toBeNull();

    await fs.remove('myproject');

    project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.EXCEL;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container.bind<Klass>(Klass).to(Klass);

    klass = container.get<Klass>(Klass);
    googleConnection = await klass.googleConnection();

    expect(googleConnection).toBeNull();

    await fs.remove('myproject');
  });

  test('get sheets service', async () => {
    let project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    @injectable()
    class Klass {
      @inject(BeanFactory.sheetsServiceProvider)
      private sheetsServiceProvider: () => Promise<sheets_v4.Sheets | null>;

      public async sheetsService() {
        return await this.sheetsServiceProvider();
      }
    }

    let container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container.bind<Klass>(Klass).to(Klass);

    let klass = container.get<Klass>(Klass);
    let sheetsService = await klass.sheetsService();

    expect(sheetsService).not.toBeNull();

    await fs.remove('myproject');

    project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.EXCEL;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container.bind<Klass>(Klass).to(Klass);

    klass = container.get<Klass>(Klass);
    sheetsService = await klass.sheetsService();

    expect(sheetsService).toBeNull();

    await fs.remove('myproject');
  });

  test('get test reader factory', async () => {
    let project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    @injectable()
    class Klass {
      @inject(BeanFactory.testReaderFactoryProvider)
      private testReaderFactoryProvider: () => Promise<GenericTestReaderFactory>;

      public async testReaderFactory() {
        return await this.testReaderFactoryProvider();
      }
    }

    let container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container
      .bind<() => Promise<GenericTestReaderFactory>>(BeanFactory.testReaderFactoryProvider)
      .toProvider<GenericTestReaderFactory>(BeanFactory.testReaderFactoryProvider());
    container.bind<Klass>(Klass).to(Klass);

    let klass = container.get<Klass>(Klass);
    let testReaderFactory = await klass.testReaderFactory();

    expect(testReaderFactory instanceof SheetsReaderFactory).toBeTruthy();

    await fs.remove('myproject');

    project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.EXCEL;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container
      .bind<() => Promise<GenericTestReaderFactory>>(BeanFactory.testReaderFactoryProvider)
      .toProvider<GenericTestReaderFactory>(BeanFactory.testReaderFactoryProvider());
    container.bind<Klass>(Klass).to(Klass);

    klass = container.get<Klass>(Klass);
    testReaderFactory = await klass.testReaderFactory();

    expect(testReaderFactory instanceof ExcelReaderFactory).toBeTruthy();

    await fs.remove('myproject');
  });

  test('get test writer factory', async () => {
    let project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    @injectable()
    class Klass {
      @inject(BeanFactory.testWriterFactoryProvider)
      private testWriterFactoryProvider: () => Promise<GenericTestWriterFactory>;

      public async testWriterFactory() {
        return await this.testWriterFactoryProvider();
      }
    }

    let container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container
      .bind<() => Promise<GenericTestWriterFactory>>(BeanFactory.testWriterFactoryProvider)
      .toProvider<GenericTestWriterFactory>(BeanFactory.testWriterFactoryProvider());
    container.bind<Klass>(Klass).to(Klass);

    let klass = container.get<Klass>(Klass);
    let testWriterFactory = await klass.testWriterFactory();

    expect(testWriterFactory instanceof SheetsWriterFactory).toBeTruthy();

    await fs.remove('myproject');

    project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.EXCEL;

    await JsonMarshaller.marshall(project, 'myproject/excelium.json');

    container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider('myproject/excelium.json'));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container
      .bind<() => Promise<GenericTestWriterFactory>>(BeanFactory.testWriterFactoryProvider)
      .toProvider<GenericTestWriterFactory>(BeanFactory.testWriterFactoryProvider());
    container.bind<Klass>(Klass).to(Klass);

    klass = container.get<Klass>(Klass);
    testWriterFactory = await klass.testWriterFactory();

    expect(testWriterFactory instanceof ExcelWriterFactory).toBeTruthy();

    await fs.remove('myproject');
  });
});
