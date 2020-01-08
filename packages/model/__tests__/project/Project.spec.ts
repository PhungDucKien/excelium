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

import Project from '../../src/project/Project';
import Template from '../../src/project/Template';
import TestFile from '../../src/project/TestFile';

/**
 * Tests for {@link Project}.
 *
 * @author PhungDucKien
 * @since 2018.04.20
 */
describe('test Project', () => {
  test('get test list choice', () => {
    const project = new Project();

    const testFile1 = new TestFile();
    testFile1.location = 'dir1/dir2/file1.xlsx';
    testFile1.name = 'Workbook1.xlsx';
    project.addTest(testFile1);

    const testFile2 = new TestFile();
    testFile2.location = 'dir1/dir2/file2.xlsx';
    testFile2.name = 'Workbook2.xlsx';
    project.addTest(testFile2);

    let listChoice = project.getTestListChoice(false);
    expect(listChoice.length).toBe(2);
    expect(listChoice[0][0]).toBe('dir1/dir2/file1.xlsx');
    expect(listChoice[0][1]).toBe('Workbook1.xlsx');
    expect(listChoice[1][0]).toBe('dir1/dir2/file2.xlsx');
    expect(listChoice[1][1]).toBe('Workbook2.xlsx');

    listChoice = project.getTestListChoice(true);
    expect(listChoice.length).toBe(3);
    expect(listChoice[0][0]).toBe('dir1/dir2/file1.xlsx');
    expect(listChoice[0][1]).toBe('Workbook1.xlsx');
    expect(listChoice[1][0]).toBe('dir1/dir2/file2.xlsx');
    expect(listChoice[1][1]).toBe('Workbook2.xlsx');
    expect(listChoice[2][0]).toBe('ALL');
    expect(listChoice[2][1]).toBe('All workbooks');
  });

  test('GetTemplateListChoice', () => {
    const project = new Project();

    const template1 = new Template();
    template1.location = 'dir1/dir2/file1.xlsx';
    template1.name = 'Workbook1.xlsx';
    project.addTemplate(template1);

    const template2 = new Template();
    template2.location = 'dir1/dir2/file2.xlsx';
    template2.name = 'Workbook2.xlsx';
    project.addTemplate(template2);

    let listChoice = project.getTemplateListChoice(false);
    expect(listChoice.length).toBe(2);
    expect(listChoice[0][0]).toBe('dir1/dir2/file1.xlsx');
    expect(listChoice[0][1]).toBe('Workbook1.xlsx');
    expect(listChoice[1][0]).toBe('dir1/dir2/file2.xlsx');
    expect(listChoice[1][1]).toBe('Workbook2.xlsx');

    listChoice = project.getTemplateListChoice(true);
    expect(listChoice.length).toBe(3);
    expect(listChoice[0][0]).toBe('dir1/dir2/file1.xlsx');
    expect(listChoice[0][1]).toBe('Workbook1.xlsx');
    expect(listChoice[1][0]).toBe('dir1/dir2/file2.xlsx');
    expect(listChoice[1][1]).toBe('Workbook2.xlsx');
    expect(listChoice[2][0]).toBe('ALL');
    expect(listChoice[2][1]).toBe('All templates');
  });
});
