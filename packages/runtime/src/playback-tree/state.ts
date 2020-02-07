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

import CommandObject from '../model/command-object';

export class State {
  private _state: CommandObject[];

  constructor() {
    this._state = [];
  }

  public empty() {
    return this._state.length === 0;
  }

  public push(obj: CommandObject) {
    this._state.push(obj);
  }

  public pop() {
    this._state.pop();
  }

  public top() {
    return this._state[this._state.length - 1];
  }
}
