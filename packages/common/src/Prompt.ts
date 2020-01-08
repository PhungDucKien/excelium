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

import { WorkbookType } from '@excelium/model';
import inquirer, { ChoiceOptions, DistinctChoice } from 'inquirer';
import path from 'path';
import FileUtil from './FileUtil';
import StringUtil from './StringUtil';

/**
 * Provides common functions to prompt for user input
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class Prompt {
  /**
   * Prompts for user to input text.
   *
   * @param message      A message that is displayed to user
   * @param defaultValue A default value if user press Enter immediately
   * @return User input value
   */
  public static promptInput(message: string, defaultValue?: string): Promise<string> {
    return inquirer
      .prompt({
        name: 'prompt',
        type: 'input',
        message,
        default: defaultValue,
      })
      .then(ret => ret.prompt);
  }

  /**
   * Prompts for user to select an item
   *
   * @param message A message that is displayed to user
   * @param options Array of options. Each option is 2-elements string array or a string
   * @return User selected option
   */
  public static promptList(message: string, options: string[] | string[][]): Promise<string> {
    const choices = [] as Array<DistinctChoice<ChoiceOptions>>;
    options.forEach((option: string | string[]) => {
      if (typeof option === 'string' || option instanceof String) {
        choices.push({ value: option, name: option });
      } else {
        choices.push({ value: option[0], name: option[1] });
      }
    });

    return inquirer
      .prompt({
        name: 'prompt',
        type: 'list',
        message,
        choices,
      })
      .then(ret => ret.prompt);
  }

  /**
   * Prompts for user to confirm
   *
   * @param message A message that is displayed to user
   * @return User confirmed value
   */
  public static promptConfirm(message: string): Promise<boolean> {
    return inquirer
      .prompt({
        name: 'prompt',
        type: 'confirm',
        message,
      })
      .then(ret => ret.prompt);
  }

  /**
   * Prompts for file location.
   * Lists all files in a given directory, if workbook type is Microsoft Excel,
   * or asks for the spreadsheet url or id, if workbook type is Google Sheets.
   *
   * @param workbookType   the workbook type
   * @param excelPath      the excel path
   * @param excelQuestion  the excel question
   * @param sheetsQuestion the sheets question
   * @return the string
   */
  public static promptFileLocation(
    workbookType: WorkbookType,
    excelPath?: string,
    excelQuestion?: string,
    sheetsQuestion?: string
  ): Promise<string | null> {
    if (workbookType === WorkbookType.EXCEL) {
      return FileUtil.listFiles(excelPath!).then(filePaths => {
        return Prompt.promptList(excelQuestion!, filePaths).then(filePath => path.join(excelPath!, filePath));
      });
    } else if (workbookType === WorkbookType.SHEETS) {
      return Prompt.promptInput(sheetsQuestion!).then(spreadsheetLocation => StringUtil.extractSpreadsheetId(spreadsheetLocation));
    }
    return Promise.resolve(null);
  }
}
