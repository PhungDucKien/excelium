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

import { CommandNode } from '../../src/playback-tree/command-node';
import { ControlFlowCommandNames } from '../../src/playback-tree/commands';
import Variables from '../../src/Variables';

describe('Command Node', () => {
  let variables: Variables;
  beforeEach(() => {
    variables = new Variables();
  });
  it('control flow check returns correct result', () => {
    const node = new CommandNode({ command: '' });
    node.right = new CommandNode({ command: 'asdf' });
    expect(node.isControlFlow()).toBeTruthy();
    node.left = undefined;
    node.right = new CommandNode({ command: 'asdf' });
    expect(node.isControlFlow()).toBeTruthy();
  });
  it('retry limit defaults to 1000', () => {
    const command = {
      command: ControlFlowCommandNames.times,
      target: '',
      value: '',
    };
    const node = new CommandNode(command);
    node.timesVisited = 999;
    expect(node._isRetryLimit()).toBeFalsy();
    node.timesVisited = 1000;
    expect(node._isRetryLimit()).toBeTruthy();
  });
  it('retry limit can be overriden', () => {
    const command = {
      command: ControlFlowCommandNames.repeatIf,
      target: '',
      value: '5',
    };
    const node = new CommandNode(command);
    node.timesVisited = 5;
    expect(node._isRetryLimit()).toBeTruthy();
  });
  it('forEach fetches count from preset variable', () => {
    const collectionName = 'blah';
    variables.set(collectionName, [
      { a: 'a1', b: 'b1' },
      { a: 'a2', b: 'b2' },
    ]);
    const command = {
      command: ControlFlowCommandNames.forEach,
      target: collectionName,
      value: 'iteratorVar',
    };
    const node = new CommandNode(command);
    expect(node.evaluateForEach(variables)).toEqual(true);
  });
  it('forEach errors without a valid variable', () => {
    const command = {
      command: ControlFlowCommandNames.forEach,
      target: 'asdf',
      value: '',
    };
    const node = new CommandNode(command);
    expect(node.evaluateForEach(variables)).toEqual(false);
  });
  it('forEach stores iterated collection entry on a variable using the provided name', () => {
    const collectionName = 'asdf';
    variables.set(collectionName, [
      { a: 'a1', b: 'b1' },
      { a: 'a2', b: 'b2' },
    ]);
    const command = {
      command: ControlFlowCommandNames.forEach,
      target: collectionName,
      value: 'iteratorVar',
    };
    const node = new CommandNode(command);
    node.evaluateForEach(variables);
    expect(variables.get('iteratorVar')).toEqual({ a: 'a1', b: 'b1' });
  });
  it('forEach resets timesVisited after completing', () => {
    const collection = { name: 'asdf', value: [{ a: 'a' }, { b: 'b' }] };
    variables.set(collection.name, collection.value);
    const node = new CommandNode({
      command: ControlFlowCommandNames.forEach,
      target: collection.name,
      value: 'iteratorVar',
    });
    node.timesVisited = collection.value.length + 1;
    node.evaluateForEach(variables);
    expect(node.timesVisited).toEqual(-1);
  });
  it('execute resolves with an error message when too many retries attempted in a loop', () => {
    const command = {
      command: ControlFlowCommandNames.while,
      target: '',
      value: '2',
    };
    const node = new CommandNode(command);
    node.timesVisited = 3;
    return node.execute(undefined).catch((err: Error) => {
      expect(err.message).toEqual('Max retry limit exceeded. To override it, specify a new limit in the value input field.');
    });
  });
  it("evaluate resolves with an error message on 'times' when an invalid number is provided", () => {
    const command = {
      command: ControlFlowCommandNames.times,
      target: 'asdf',
      value: '',
    };
    const node = new CommandNode(command);
    return node._evaluate({ variables: new Variables() }).catch((err: Error) => {
      expect(err.message).toEqual('Invalid number provided as a target.');
    });
  });
  it('timesVisited only incremenrts for control flow commands', () => {
    let command = {
      command: ControlFlowCommandNames.times,
      target: '',
      value: '',
    };
    let node = new CommandNode(command);
    expect(node.timesVisited).toBe(0);
    node._incrementTimesVisited();
    expect(node.timesVisited).toBe(1);
    command = {
      command: 'command',
      target: '',
      value: '',
    };
    node = new CommandNode(command);
    expect(node.timesVisited).toBe(0);
    node._incrementTimesVisited();
    expect(node.timesVisited).toBe(0);
  });
  it("evaluationResult returns the 'right' node on true", () => {
    const command = {
      command: 'a',
      target: '',
      value: '',
    };
    const node = new CommandNode(command);
    const nodeRight = new CommandNode({ command: 'b' });
    const nodeLeft = new CommandNode({ command: 'c' });
    node.right = nodeRight;
    node.left = nodeLeft;
    const result = node._evaluationResult({ value: true });
    expect(result.next).toEqual(nodeRight);
  });
  it("evaluationResult returns the 'left' node on false", () => {
    const command = {
      command: 'a',
      target: '',
      value: '',
    };
    const node = new CommandNode(command);
    const nodeRight = new CommandNode({ command: 'b' });
    const nodeLeft = new CommandNode({ command: 'c' });
    node.right = nodeRight;
    node.left = nodeLeft;
    const result = node._evaluationResult({ value: false });
    expect(result.next).toEqual(nodeLeft);
  });
  it("executionResult returns the 'next' node on non-controlflow commands", () => {
    const command = {
      command: 'open',
      target: '',
      value: '',
    };
    const nodeA = new CommandNode(command);
    const nodeB = new CommandNode(command);
    nodeA.next = nodeB;
    expect(nodeA._executionResult().next).toEqual(nodeB);
  });
  it("executionResult returns a 'next' node on control flow", () => {
    const command = {
      command: ControlFlowCommandNames.if,
      target: '',
      value: '',
    };
    const nodeA = new CommandNode(command);
    nodeA.left = new CommandNode({ command: 'asdf' });
    const nodeB = new CommandNode(command);
    expect(
      nodeA._executionResult({
        next: nodeB,
      }).next
    ).toEqual(nodeB);
  });
});
