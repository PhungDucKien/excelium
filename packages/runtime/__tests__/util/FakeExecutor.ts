// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import { StringUtil } from '@excelium/common';
import CommandObject from '../../src/model/command-object';
import Variables from '../../src/Variables';

export default class FakeExecutor {
  [x: string]: any;
  public baseUrl?: string;
  public variables?: Variables;
  private initialized: boolean;
  private killed: boolean;

  public init({ baseUrl, variables }: { baseUrl?: string; variables?: Variables }) {
    // this can be async
    this.variables = variables;
    this.baseUrl = baseUrl;
    this.initialized = true;
  }

  public async cleanup() {
    this.initialized = false;
  }

  public name(command: string) {
    if (!command) {
      return 'skip';
    }

    const upperCase = StringUtil.capitalize(command);
    const func = 'do' + upperCase;
    if (!this[func]) {
      throw new Error(`Unknown command ${command}`);
    }
    return func;
  }

  public async cancel() {
    // no-op in this case
  }

  public async kill() {
    this.killed = true;
  }

  public async beforeCommand(_commandObject: CommandObject) {
    if (!this.initialized) {
      throw new Error('executor is dead');
    }
    if (this.killed) {
      throw new Error('playback is dead');
    }
  }

  public async afterCommand(_commandObject: CommandObject) {
    if (!this.initialized) {
      throw new Error('executor is dead');
    }
    if (this.killed) {
      throw new Error('playback is dead');
    }
  }

  public async doPause(timeout: string | number = 0) {
    await new Promise(res => {
      setTimeout(res, typeof timeout === 'string' ? parseInt(timeout, 10) : timeout);
    });
  }
}
