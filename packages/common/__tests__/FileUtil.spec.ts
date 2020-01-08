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

import fs from 'fs-extra';
import path from 'path';
import FileUtil from '../src/FileUtil';

/**
 * Tests for {@link FileUtil}.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
describe('test FileUtil', () => {
  test('list files', async () => {
    const templatePath = 'template_test';

    // Generates files
    fs.ensureFileSync(path.resolve(templatePath, 'category1', 'group1', 'File1.xlsx'));
    fs.ensureFileSync(path.resolve(templatePath, 'category1', 'group2', 'File2.xlsx'));
    fs.ensureFileSync(path.resolve(templatePath, 'category2', 'group3', 'File3.xlsx'));
    fs.ensureFileSync(path.resolve(templatePath, 'category1', 'group1', 'File4.xlsx'));

    const templateFiles = await FileUtil.listFiles(templatePath);
    expect(templateFiles.length).toBe(4);
    expect(templateFiles).toContain('category1/group1/File1.xlsx');
    expect(templateFiles).toContain('category1/group1/File4.xlsx');
    expect(templateFiles).toContain('category1/group2/File2.xlsx');
    expect(templateFiles).toContain('category2/group3/File3.xlsx');

    // Deletes generated files
    await fs.remove(templatePath);
  });
});
