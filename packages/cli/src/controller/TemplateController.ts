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
import { GenericTestReaderFactory } from '@excelium/core';
import { Project, Template } from '@excelium/model';
import { inject } from 'inversify';
import path from 'path';
import BeanFactory from '../BeanFactory';
import { action, group } from '../commander';
import BaseController from './BaseController';

/**
 * Provides commands for controlling template.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
@group({ name: 'template' })
export default class TemplateController extends BaseController {
  /**
   * Project instance
   */
  @inject(BeanFactory.projectProvider)
  private projectProvider: () => Promise<Project>;

  /**
   * Test reader factory
   */
  @inject(BeanFactory.testReaderFactoryProvider)
  private testReaderFactoryProvider: () => Promise<GenericTestReaderFactory>;

  /**
   * Imports test template.
   */
  @action({ name: 'import', options: BaseController.baseParameters })
  public async importTemplate(): Promise<void> {
    const project = await this.projectProvider();
    const testReaderFactory = await this.testReaderFactoryProvider();
    const templatePath =
      StringUtil.isNotBlank(project.basePath) && StringUtil.isNotBlank(project.templatePath)
        ? path.resolve(project.basePath, project.templatePath || '')
        : path.resolve(project.templatePath || '');
    const fileLocation = await Prompt.promptFileLocation(
      project.workbookType,
      templatePath,
      'What is the file path of the template you want to import?',
      'What is the spreadsheet ID/URL of the template you want to import?'
    );
    const testReader = testReaderFactory.createReader(fileLocation || '');
    const workbook = await testReader.getWorkbook();

    const template = new Template();
    template.location = fileLocation || '';
    template.name = testReader.getWorkbookName(workbook);
    template.markupLocations = await testReader.batchFindFirstOccurrence(TemplateUtil.getMarkups(), workbook);

    const mappingSheet = TemplateUtil.getSuggestSheetForMapping(template);
    if (mappingSheet && StringUtil.isNotBlank(mappingSheet)) {
      const mappingPattern = await Prompt.promptInput(
        'What is the pattern of the name of Mapping sheet? (The asterisk (*) means any string)',
        mappingSheet
      );
      template.mappingPattern = mappingPattern;
    }

    const actionSheet = TemplateUtil.getSuggestSheetForAction(template);
    if (actionSheet && StringUtil.isNotBlank(actionSheet)) {
      const actionPattern = await Prompt.promptInput(
        'What is the pattern of the name of Action sheet? (The asterisk (*) means any string)',
        actionSheet
      );
      template.actionPattern = actionPattern;
    }

    const dataSheet = TemplateUtil.getSuggestSheetForData(template);
    if (dataSheet && StringUtil.isNotBlank(dataSheet)) {
      const dataPattern = await Prompt.promptInput('What is the pattern of the name of Data sheet? (The asterisk (*) means any string)', dataSheet);
      template.dataPattern = dataPattern;
    }

    const testPattern = await Prompt.promptInput('What is the pattern of the name of Test Case sheet? (The asterisk (*) means any string)', '*');
    template.testPattern = testPattern;

    let addIgnorePatterns = await Prompt.promptConfirm('Do you want to add the pattern of the name of sheet that should be ignored?');
    while (addIgnorePatterns) {
      const ignorePattern = await Prompt.promptInput('Please add the pattern of the name of sheet that should be ignored:');
      template.addIgnorePattern(ignorePattern);
      addIgnorePatterns = await Prompt.promptConfirm('Do you want to add the pattern of the name of sheet that should be ignored?');
    }

    project.addTemplate(template);

    await this.updateProjectFile(project);
  }

  /**
   * Removes test template.
   */
  @action({ name: 'remove', options: BaseController.baseParameters })
  public async remove(): Promise<void> {
    const project = await this.projectProvider();
    const removeTemplate = await Prompt.promptList('Choose the template to remove:', project.getTemplateListChoice(true));
    if (removeTemplate === Template.ALL) {
      project.templates.clear();
    } else {
      project.templates.delete(removeTemplate);
    }

    await this.updateProjectFile(project);
  }
}
