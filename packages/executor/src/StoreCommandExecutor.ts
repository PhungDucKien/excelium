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
import {
  Accessor,
  Action,
  ArgType,
  CommandExecutor,
  interpolateString,
  text as _text,
  variable as _variable,
  WebDriverExecutor,
} from '@excelium/runtime';

/**
 * Represents a class which contains commands for storing and accessing variables.
 *
 * @author PhungDucKien
 * @since 2018.07.04
 */
export default class StoreCommandExecutor extends CommandExecutor {
  /**
   * Instantiates a new Store command executor.
   *
   * @param webDriver the web driver
   * @param project   the project
   */
  public constructor(webDriver: WebDriverExecutor, project: Project) {
    super(webDriver, project);
  }

  public getActions(): Array<Action<any>> {
    return [
      new Action({
        args: {
          text: ArgType.exact(_text).isRequired(),
          variable: ArgType.exact(_variable).isRequired(),
        },
        preprocessors: [interpolateString, undefined],
        execute: this.store.bind(this),
      }),
      new Accessor({
        args: {
          variable: ArgType.exact(_variable).isRequired(),
        },
        execute: this.getVariable.bind(this),
      }),
    ];
  }

  /**
   * Stores a value in a variable for later access.
   *
   * @param text     the value to store
   * @param variable the name of a variable in which the result is to be stored.
   */
  public async store(text?: string, variable?: string) {
    this.webDriver.setVariable(text!, variable!);
  }

  // /**
  //  * Stores a value in an array variable for later access.
  //  *
  //  * @param text     the value to store
  //  * @param variable the name of a variable in which the result is to be stored.
  //  */
  // @Action(param1 = "text", param2 = "variable")
  // public async storePush(text: string, variable: string) {
  //   this.webDriver.pushVariable(text, variable);
  // }

  /**
   * Returns the specified variable value.
   *
   * @param variable the variable
   * @return the specified variable value
   */
  public async getVariable(variable?: string) {
    return this.webDriver.getVariable(variable!);
  }
}
