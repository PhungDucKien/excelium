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

import { Project } from '@excelium/model';
import { Accessor, Action, CommandExecutor, WebDriverExecutor } from '@excelium/runtime';

/**
 * Represents a class which contains commands for controlling dates.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
export default class DateCommandExecutor extends CommandExecutor {
  /**
   * Instantiates a new Date command executor.
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
        execute: this.getCurrentDate.bind(this),
        exclude: ['verify', 'wait', 'execute'],
      }),
    ];
  }

  /**
   * Returns the current date.
   *
   * @return the current date
   */
  public async getCurrentDate() {
    return new Date();
  }
}
