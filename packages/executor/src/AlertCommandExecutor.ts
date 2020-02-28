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
import { Project } from '@excelium/model';
import { Accessor, Action, ArgType, CommandExecutor, interpolateString, text, WebDriverExecutor } from '@excelium/runtime';

/**
 * Represents a class which contains commands for controlling alert dialogs.
 *
 * @author PhungDucKien
 * @since 2018.06.29
 */
export default class AlertCommandExecutor extends CommandExecutor {
  /**
   * Instantiates a new Alert command executor.
   *
   * @param webDriver the web driver
   * @param project   the project
   */
  public constructor(webDriver: WebDriverExecutor, project: Project) {
    super(webDriver, project);
  }

  public getActions(): Array<Action<any>> {
    return [
      new Accessor({
        execute: this.isAlertPresent.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Accessor({
        execute: this.isConfirmationPresent.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Accessor({
        execute: this.isPromptPresent.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Accessor({
        execute: this.getStringAlert.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Accessor({
        execute: this.getStringConfirmation.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Accessor({
        execute: this.getStringPrompt.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Action({
        execute: this.acceptAlert.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Action({
        execute: this.acceptConfirmation.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Action({
        execute: this.dismissConfirmation.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Action({
        args: {
          answer: ArgType.exact(text).isRequired(),
        },
        preprocessors: [interpolateString],
        execute: this.answerPrompt.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
      new Action({
        execute: this.dismissPrompt.bind(this),
        predicate: (executor: WebDriverExecutor) => !executor.driver.isAndroid,
      }),
    ];
  }

  /**
   * Returns true if an alert dialog is present, or false otherwise.
   *
   * <p>
   * This function never throws an exception
   * </p>
   *
   * @return true if there is an alert
   */
  public async isAlertPresent() {
    return this.checkAlertPresent();
  }

  /**
   * Returns true if a confirmation dialog is present, or false otherwise.
   *
   * <p>
   * This function never throws an exception
   * </p>
   *
   * @return true if there is a pending confirmation
   */
  public async isConfirmationPresent() {
    return this.checkAlertPresent();
  }

  /**
   * Returns true if a prompt dialog is present, or false otherwise.
   *
   * <p>
   * This function never throws an exception
   * </p>
   *
   * @return true if there is a pending prompt
   */
  public async isPromptPresent() {
    return this.checkAlertPresent();
  }

  /**
   * Retrieves the message of a alert, or fail if there were no alerts.
   *
   * @return The message of the alert
   */
  public async getStringAlert() {
    if (!(await this.isAlertPresent())) {
      throw new Error('There were no alerts');
    }
    return this.webDriver.driver.getAlertText();
  }

  /**
   * Retrieves the message of a confirmation dialog.
   *
   * @return the message of the confirmation dialog
   */
  public async getStringConfirmation() {
    if (!(await this.isConfirmationPresent())) {
      throw new Error('There were no confirmations');
    }
    return this.webDriver.driver.getAlertText();
  }

  /**
   * Retrieves the message of a question prompt dialog.
   *
   * @return the message of the question prompt
   */
  public async getStringPrompt() {
    if (!(await this.isPromptPresent())) {
      throw new Error('There were no prompts');
    }
    return this.webDriver.driver.getAlertText();
  }

  /**
   * Simulates as if the user had manually clicked OK.
   */
  public async acceptAlert() {
    if (!(await this.isAlertPresent())) {
      throw new Error('There were no alerts');
    }
    return this.webDriver.driver.acceptAlert();
  }

  /**
   * Simulates as if the user had manually clicked OK.
   */
  public async acceptConfirmation() {
    if (!(await this.isConfirmationPresent())) {
      throw new Error('There were no confirmations');
    }
    return this.webDriver.driver.acceptAlert();
  }

  /**
   * Simulates as if the user had manually clicked Cancel.
   */
  public async dismissConfirmation() {
    if (!(await this.isConfirmationPresent())) {
      throw new Error('There were no confirmations');
    }
    return this.webDriver.driver.dismissAlert();
  }

  /**
   * Instructs Selenium to return the specified answer string in response to the prompt.
   *
   * @param answer the answer to give in response to the prompt pop-up
   */
  public async answerPrompt(answer?: string) {
    if (!(await this.isPromptPresent())) {
      throw new Error('There were no prompts');
    }
    if (answer && StringUtil.isNotBlank(answer)) {
      await this.webDriver.driver.sendAlertText(answer);
    }
    return this.webDriver.driver.acceptAlert();
  }

  /**
   * Simulates as if the user had manually clicked Cancel.
   */
  public async dismissPrompt() {
    if (!(await this.isPromptPresent())) {
      throw new Error('There were no prompts');
    }
    return this.webDriver.driver.dismissAlert();
  }

  /**
   * Determines whether an alert dialog is present.
   *
   * @return true if an alert dialog is present, false otherwise.
   */
  private async checkAlertPresent() {
    return this.webDriver.driver.isAlertOpen();
  }
}
