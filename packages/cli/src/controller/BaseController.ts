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

import { StringUtil } from '@excelium/common';
import { ProjectGenerator } from '@excelium/generator';
import { Project } from '@excelium/model';
import { injectable } from 'inversify';
import path from 'path';
import { Option } from '../commander';

/**
 * Base controller.
 *
 * @author PhungDucKien
 * @since 2018.04.15
 */
@injectable()
export default class BaseController {
  protected static baseParameters: Option[] = [
    /**
     * Project file
     */
    {
      key: 'project-file',
      options: {
        alias: 'f',
        description: 'Force the use of an alternate project file',
        string: true,
      },
    },
  ];

  protected async updateProjectFile(project: Project, customProjectFile?: string): Promise<void> {
    const basePath = project.basePath;
    const projectFile = !customProjectFile || StringUtil.isBlank(customProjectFile) ? 'excelium.json' : customProjectFile;
    const projectFilePath = path.resolve(basePath, projectFile);

    const generator = new ProjectGenerator();
    await generator.updateProject(project, projectFilePath);
  }
}
