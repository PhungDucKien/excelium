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

import { AppType, Project, Template, TestFile, WorkbookType } from '@excelium/model';
import fs from 'fs-extra';
import JsonMarshaller from '../src/JsonMarshaller';

/**
 * Tests for {@link JsonMarshaller}.
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
describe('test JsonMarshaller', () => {
  test('marshall', async () => {
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

    await JsonMarshaller.marshall(project, 'dump');
    const unmarshalled = (await JsonMarshaller.unmarshall('dump')) as Project;

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

    await fs.remove('dump');
  });
});
