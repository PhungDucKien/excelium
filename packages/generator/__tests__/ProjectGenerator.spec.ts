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

import { JsonMarshaller } from '@excelium/common';
import { AppType, Project, Template, TestFile, WorkbookType } from '@excelium/model';
import fs from 'fs-extra';
import path from 'path';
import ProjectGenerator from '../src/ProjectGenerator';

/**
 * Tests for {@link ProjectGenerator}.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
describe('test ProjectGenerator', () => {
  test('create project', async () => {
    const project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;

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

    const projectFilePath = 'myproject/excelium.json';
    const basePath = path.dirname(path.resolve(projectFilePath));

    const generator = new ProjectGenerator();
    await generator.createProject(project, projectFilePath);

    expect(fs.existsSync(basePath)).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'config'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'excelium.json'))).toBe(true);
    expect(fs.existsSync(projectFilePath)).toBe(true);

    const unmarshalled = (await JsonMarshaller.unmarshall(projectFilePath)) as Project;

    expect(unmarshalled.name).toBe('myproject');
    expect(unmarshalled.appType).toBe(AppType.WEB);
    expect(unmarshalled.workbookType).toBe(WorkbookType.SHEETS);

    expect(unmarshalled.tests.size).toBe(1);
    expect(unmarshalled.tests.get('testFile')!.name).toBe('testFile');
    expect(unmarshalled.tests.get('testFile')!.location).toBe('testFile.xlsx');

    expect(unmarshalled.templates.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.get('%SYSTEM_NAME%')).toBe('A2');
    expect(unmarshalled.templates.get('default')!.ignorePatterns.length).toBe(1);
    expect(unmarshalled.templates.get('default')!.ignorePatterns[0]).toBe('*');

    // Deletes generated files
    await fs.remove(basePath);
  });

  test('create project with all paths', async () => {
    const project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;
    project.testPath = 'test';
    project.templatePath = 'template';
    project.appPath = 'app';
    project.filePath = 'file';
    project.screenshotPath = 'screenshot';
    project.downloadPath = 'download';

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

    const projectFilePath = 'myproject/excelium.json';
    const basePath = path.dirname(path.resolve(projectFilePath));

    const generator = new ProjectGenerator();
    await generator.createProject(project, projectFilePath);

    expect(fs.existsSync(basePath)).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'config'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'test'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'template'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'app'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'file'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'screenshot'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'download'))).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'excelium.json'))).toBe(true);
    expect(fs.existsSync(projectFilePath)).toBe(true);

    const unmarshalled = (await JsonMarshaller.unmarshall(projectFilePath)) as Project;

    expect(unmarshalled.name).toBe('myproject');
    expect(unmarshalled.appType).toBe(AppType.WEB);
    expect(unmarshalled.workbookType).toBe(WorkbookType.SHEETS);
    expect(unmarshalled.testPath).toBe('test');
    expect(unmarshalled.templatePath).toBe('template');
    expect(unmarshalled.appPath).toBe('app');
    expect(unmarshalled.filePath).toBe('file');
    expect(unmarshalled.screenshotPath).toBe('screenshot');
    expect(unmarshalled.downloadPath).toBe('download');

    expect(unmarshalled.tests.size).toBe(1);
    expect(unmarshalled.tests.get('testFile')!.name).toBe('testFile');
    expect(unmarshalled.tests.get('testFile')!.location).toBe('testFile.xlsx');

    expect(unmarshalled.templates.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.get('%SYSTEM_NAME%')).toBe('A2');
    expect(unmarshalled.templates.get('default')!.ignorePatterns.length).toBe(1);
    expect(unmarshalled.templates.get('default')!.ignorePatterns[0]).toBe('*');

    // Deletes generated files
    await fs.remove(basePath);
  });

  test('update project', async () => {
    const project = new Project();
    project.name = 'myproject';
    project.appType = AppType.WEB;
    project.workbookType = WorkbookType.SHEETS;

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

    const projectFilePath = 'myproject/excelium.json';
    const basePath = path.dirname(path.resolve(projectFilePath));

    const generator = new ProjectGenerator();
    await generator.updateProject(project, projectFilePath);

    expect(fs.existsSync(basePath)).toBe(true);
    expect(fs.existsSync(path.resolve(basePath, 'excelium.json'))).toBe(true);
    expect(fs.existsSync(projectFilePath)).toBe(true);

    const unmarshalled = (await JsonMarshaller.unmarshall(projectFilePath)) as Project;

    expect(unmarshalled.name).toBe('myproject');
    expect(unmarshalled.appType).toBe(AppType.WEB);
    expect(unmarshalled.workbookType).toBe(WorkbookType.SHEETS);

    expect(unmarshalled.tests.size).toBe(1);
    expect(unmarshalled.tests.get('testFile')!.name).toBe('testFile');
    expect(unmarshalled.tests.get('testFile')!.location).toBe('testFile.xlsx');

    expect(unmarshalled.templates.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.size).toBe(1);
    expect(unmarshalled.templates.get('default')!.markupLocations.get('%SYSTEM_NAME%')).toBe('A2');
    expect(unmarshalled.templates.get('default')!.ignorePatterns.length).toBe(1);
    expect(unmarshalled.templates.get('default')!.ignorePatterns[0]).toBe('*');

    // Deletes generated files
    await fs.remove(basePath);
  });
});
