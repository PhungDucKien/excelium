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

import { ControlFlowChangePayload } from '../events';
import CommandObject from '../model/command-object';
import { interpolateScript } from '../preprocessors';
import Variables from '../Variables';
import { ControlFlowCommandChecks } from './commands';

interface CommandNodeOpts {
  emitControlFlowEvent?: (payload: ControlFlowChangePayload) => void;
}

interface ExecuteArgs {
  executorOverride?: (target?: string, value?: string) => Promise<void>;
}

export class CommandNode {
  public command: CommandObject;
  public next?: CommandNode;
  public left?: CommandNode;
  public right?: CommandNode;
  public index: number;
  public level: number;
  public timesVisited: number;
  public emitControlFlowEvent: (payload: ControlFlowChangePayload) => void;

  constructor(command: CommandObject, { emitControlFlowEvent }: CommandNodeOpts = {}) {
    this.command = command;
    this.next = undefined;
    this.left = undefined;
    this.right = undefined;
    this.timesVisited = 0;
    this.emitControlFlowEvent = emitControlFlowEvent ? emitControlFlowEvent : () => undefined;
  }

  public isControlFlow() {
    return !!(this.left || this.right);
  }

  public isTerminal() {
    return ControlFlowCommandChecks.isTerminal(this.command) || this.command.command === '';
  }

  public shouldSkip() {
    return !!this.command.skip;
  }

  public execute(commandExecutor: any, args?: ExecuteArgs) {
    if (this._isRetryLimit()) {
      return Promise.reject(new Error('Max retry limit exceeded. To override it, specify a new limit in the value input field.'));
    }
    if (this.shouldSkip()) {
      return Promise.resolve(this._executionResult({ skipped: true }));
    }
    return commandExecutor.beforeCommand(this.command).then(() => {
      return this._executeCommand(commandExecutor, args).then((result: { next?: CommandNode; skipped?: boolean }) => {
        return commandExecutor.afterCommand(this.command).then(() => {
          return this._executionResult(result);
        });
      });
    });
  }

  public _executeCommand(commandExecutor: any, { executorOverride }: ExecuteArgs = {}) {
    if (executorOverride) {
      return executorOverride(this.command.target, this.command.value);
    } else if (this.isControlFlow()) {
      return Promise.resolve(this._evaluate(commandExecutor));
    } else if (this.isTerminal()) {
      return Promise.resolve();
    } else {
      return commandExecutor[commandExecutor.name(this.command.command)](this.command.target, this.command.value, this.command);
    }
  }

  public _executionResult(result: { next?: CommandNode; skipped?: boolean } = {}) {
    this._incrementTimesVisited();
    return {
      next: this.isControlFlow() ? result.next : this.next,
      skipped: result.skipped,
    };
  }

  public evaluateForEach(variables: Variables) {
    const collection = variables.get(interpolateScript(this.command.target || '', variables).script);
    if (!collection) {
      console.error('Invalid variable provided.');
      return false;
    }
    variables.set(interpolateScript(this.command.value || '', variables).script, collection[this.timesVisited]);
    const result = this.timesVisited < collection.length;
    if (result) {
      this.emitControlFlowEvent({
        commandId: this.command.id,
        type: CommandType.LOOP,
        index: this.timesVisited,
        iterator: collection[this.timesVisited],
        collection,
      });
    }
    // Reset timesVisited if loop ends, needed to support forEach recursion.
    // It's set to -1 since the incrementer will pick it up. Setting it to
    // 0 when called on a subsequent interation.
    else {
      this.timesVisited = -1;
    }
    return result;
  }

  public _evaluate(commandExecutor: any) {
    const expression = interpolateScript(this.command.target || '', commandExecutor.variables);
    if (ControlFlowCommandChecks.isTimes(this.command)) {
      const number = Math.floor(+expression);
      if (isNaN(number)) {
        return Promise.reject(new Error('Invalid number provided as a target.'));
      }
      return this._evaluationResult({ value: this.timesVisited < number });
    } else if (ControlFlowCommandChecks.isForEach(this.command)) {
      const result = this.evaluateForEach(commandExecutor.variables);
      if (!result) {
        this.emitControlFlowEvent({
          commandId: this.command.id,
          type: CommandType.LOOP,
          end: true,
        });
      }
      return this._evaluationResult({
        value: result,
      });
    }
    return commandExecutor.evaluateConditional(expression).then((result: { value: boolean }) => {
      return this._evaluationResult(result);
    });
  }

  public _evaluationResult(result: { value: boolean }) {
    if (result.value) {
      return {
        next: this.right,
      };
    } else {
      return {
        next: this.left,
      };
    }
  }

  public _incrementTimesVisited() {
    if (ControlFlowCommandChecks.isLoop(this.command)) {
      this.timesVisited++;
    }
  }

  public _isRetryLimit() {
    if (ControlFlowCommandChecks.isLoop(this.command)) {
      let limit = 1000;
      if (this.command.value) {
        const value = Math.floor(+this.command.value);
        if (!isNaN(value)) {
          limit = value;
        }
      }
      return this.timesVisited >= limit;
    }
    return false;
  }
}

export const CommandType = {
  LOOP: 'loop',
  CONDITIONAL: 'conditional',
};
