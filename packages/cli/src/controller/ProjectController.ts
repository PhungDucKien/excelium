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

import { Prompt, StringUtil, TemplateUtil } from '@excelium/common';
import { ProjectGenerator } from '@excelium/generator';
import { AppType, Project, Template, WorkbookType } from '@excelium/model';
import { GoogleConnectionService, SheetsReaderFactory, SheetsServiceProvider } from '@excelium/sheets';
import fs from 'fs-extra';
import path from 'path';
import { action, group } from '../commander';
import BaseController from './BaseController';

/**
 * Provides commands for controlling project.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
@group({ name: 'project' })
export default class ProjectController extends BaseController {
  /**
   * Creates an empty structured project folder.
   * Project configuration file will be written to excelium.json of specified folder.
   */
  @action({ name: 'create [folderName]', options: BaseController.baseParameters })
  public async create(argv: any): Promise<void> {
    const basePath = !argv.folderName || StringUtil.isBlank(argv.folderName) ? '.' : argv.folderName;
    const customProjectFile = argv.projectFile;
    const projectFile = StringUtil.isBlank(customProjectFile) ? 'excelium.json' : customProjectFile;
    const projectFilePath = path.resolve(basePath, projectFile);

    if (fs.existsSync(projectFilePath)) {
      const overwrite = await Prompt.promptConfirm('Project configuration file (' + projectFile + ') already exists. Would you like to overwrite?');
      if (!overwrite) {
        return;
      }
    }

    // Project instance
    const project = new Project();

    const name = await Prompt.promptInput('What is the name of your project?', path.basename(path.dirname(projectFilePath)));
    project.name = name;

    const appTypeId = await Prompt.promptList('Which type of application would you like to test?', AppType.getListChoice());
    project.appType = AppType.fromName(appTypeId);

    const workbookTypeId = await Prompt.promptList('Which type of workbook would you like to use?', WorkbookType.getListChoice());
    project.workbookType = WorkbookType.fromName(workbookTypeId);

    if (project.workbookType === WorkbookType.EXCEL) {
      const testFolder = await Prompt.promptInput('Where do you want to load test files?', 'test');
      project.testPath = testFolder;

      const templateFolder = await Prompt.promptInput('Where do you want to load templates?', 'template');
      project.templatePath = templateFolder;
    }

    if (project.appType === AppType.WEB) {
      const fileFolder = await Prompt.promptInput('Where do you want to load files?', 'file');
      project.filePath = fileFolder;

      const downloadFolder = await Prompt.promptInput('Where do you want to store downloads?', 'download');
      project.downloadPath = downloadFolder;
    } else {
      const appFolder = await Prompt.promptInput('Where do you want to load application?', 'app');
      project.appPath = appFolder;
    }

    const screenshotFolder = await Prompt.promptInput('Where do you want to store screenshots?', 'screenshot');
    project.screenshotPath = screenshotFolder;

    if (project.workbookType === WorkbookType.SHEETS) {
      const importDefault = await Prompt.promptConfirm('Would you like to import the default template?');
      if (importDefault) {
        let fileLocation = '';
        if (project.appType === AppType.WEB) {
          fileLocation = '1iQNDv7fLjWhXZr4Jgs3oKvy5AlK4wib4RJEi79n9s50';
        } else if (project.appType === AppType.MOBILE) {
          fileLocation = '1u1Wr4JrcaGp84joTFCRLSQA1cWXLaa9TK3fUv-EkX9w';
        }
        if (StringUtil.isNotBlank(fileLocation)) {
          const googleConnection = new GoogleConnectionService();
          const sheetsServiceProvider = new SheetsServiceProvider(googleConnection);
          const sheetsService = await sheetsServiceProvider.createSheetsService();
          const testReaderFactory = new SheetsReaderFactory(sheetsService);
          const testReader = testReaderFactory.createReader(fileLocation);
          const workbook = await testReader.getWorkbook();

          const template = new Template();
          template.location = fileLocation;
          template.name = testReader.getWorkbookName(workbook);
          template.markupLocations = await testReader.batchFindFirstOccurrence(TemplateUtil.getMarkups(), workbook);

          const mappingSheet = TemplateUtil.getSuggestSheetForMapping(template);
          template.mappingPattern = mappingSheet || '';

          const actionSheet = TemplateUtil.getSuggestSheetForAction(template);
          template.actionPattern = actionSheet || '';

          const dataSheet = TemplateUtil.getSuggestSheetForData(template);
          template.dataPattern = dataSheet || '';

          template.testPattern = '*';
          template.addIgnorePattern('Commands');

          project.addTemplate(template);
        }
      }
    }

    const generator = new ProjectGenerator();
    await generator.createProject(project, projectFilePath);
  }
}
