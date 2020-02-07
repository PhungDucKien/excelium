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

import { CommandObject, Test } from './model';
import { CommandNode } from './playback-tree/command-node';

interface Procedure {
  callee: Test;
  caller?: {
    position?: CommandNode;
    tree?: {
      startingCommandNode: CommandNode;
      nodes: CommandNode[];
      containsControlFlow: boolean;
    };
    commands?: CommandObject[];
  };
}

const stack = Symbol('stack');

export default class Callstack {
  private [stack]: Procedure[];

  constructor() {
    this[stack] = [];
  }

  get length() {
    return this[stack].length;
  }

  public call(procedure: Procedure) {
    this[stack].push(procedure);
  }

  public unwind() {
    if (!this.length) {
      throw new Error('Call stack is empty');
    }
    return this[stack].pop();
  }

  public top() {
    return this[stack][this[stack].length - 1];
  }
}
