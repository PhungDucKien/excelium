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
import { Project } from '@excelium/model';
import fs from 'fs-extra';
import _ from 'lodash';
import path from 'path';

/**
 * Creates an empty structured project folder.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class ProjectGenerator {
  /**
   * Creates an empty structured project folder.
   *
   * @param project         Project model
   * @param projectFilePath Project file path
   */
  public async createProject(project: Project, projectFilePath: string): Promise<void> {
    const basePath = path.dirname(path.resolve(projectFilePath));

    await fs.ensureDir(path.resolve(basePath, 'config'));

    if (project.testPath != null) {
      await fs.ensureDir(path.resolve(basePath, project.testPath));
    }
    if (project.templatePath != null) {
      await fs.ensureDir(path.resolve(basePath, project.templatePath));
    }
    if (project.appPath != null) {
      await fs.ensureDir(path.resolve(basePath, project.appPath));
    }
    if (project.filePath != null) {
      await fs.ensureDir(path.resolve(basePath, project.filePath));
    }
    if (project.screenshotPath != null) {
      await fs.ensureDir(path.resolve(basePath, project.screenshotPath));
    }
    if (project.downloadPath != null) {
      await fs.ensureDir(path.resolve(basePath, project.downloadPath));
    }

    await JsonMarshaller.marshall(_.omit(project, 'basePath'), projectFilePath);
  }

  /**
   * Update project configuration file.
   *
   * @param project         Project model
   * @param projectFilePath Project file path
   */
  public async updateProject(project: Project, projectFilePath: string): Promise<void> {
    await JsonMarshaller.marshall(_.omit(project, 'basePath'), projectFilePath);
  }
}
