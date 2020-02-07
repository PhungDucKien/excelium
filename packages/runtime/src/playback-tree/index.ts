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
import { deriveCommandLevels } from './command-leveler';
import { CommandNode } from './command-node';
import { ControlFlowCommandChecks, ControlFlowCommandNames } from './commands';
import { State } from './state';
import { repeatIfError, validateControlFlowSyntax } from './syntax-validation';
export { createPlaybackTree }; // public API
export { createCommandNodesFromCommandStack }; // for testing

interface PlaybackTreeOpts {
  isValidationDisabled?: boolean;
  emitControlFlowEvent?: (payload: ControlFlowChangePayload) => void;
}

interface ConnectArgs {
  commandNode: CommandNode;
  nextCommandNode: CommandNode | undefined;
  commandNodeStack: CommandNode[];
  state: State;
}

function createPlaybackTree(commandStack: CommandObject[], { isValidationDisabled, emitControlFlowEvent }: PlaybackTreeOpts = {}) {
  const nodes = createCommandNodesFromCommandStack(commandStack, isValidationDisabled, emitControlFlowEvent);
  return {
    startingCommandNode: nodes[0],
    nodes,
    containsControlFlow: containsControlFlow(nodes),
  };
}

function containsControlFlow(nodes: CommandNode[]) {
  return !!nodes.filter(node => node.isControlFlow()).length;
}

function createCommandNodesFromCommandStack(
  commandStack: CommandObject[],
  isValidationDisabled = false,
  emitControlFlowEvent?: (payload: ControlFlowChangePayload) => void
) {
  if (!isValidationDisabled) {
    validateControlFlowSyntax(commandStack);
  }
  const levels = deriveCommandLevels(commandStack);
  const nodes = createCommandNodes(commandStack, levels, emitControlFlowEvent);
  return connectCommandNodes(nodes);
}

function createCommandNodes(commandStack: CommandObject[], levels: number[], emitControlFlowEvent?: (payload: ControlFlowChangePayload) => void) {
  const commandNodes = [] as CommandNode[];
  commandStack.forEach((command, index) => {
    const node = new CommandNode(command, { emitControlFlowEvent });
    node.index = index;
    node.level = levels[index];
    commandNodes.push(node);
  });
  return commandNodes;
}

function connectCommandNodes(_commandNodeStack: CommandNode[]) {
  const commandNodeStack = [..._commandNodeStack];
  const state = new State();
  commandNodeStack.forEach(commandNode => {
    const nextCommandNode = commandNodeStack[commandNode.index + 1];
    connectCommandNode({
      commandNode,
      nextCommandNode,
      commandNodeStack,
      state,
    });
  });
  return commandNodeStack;
}

function connectCommandNode({ commandNode, nextCommandNode, commandNodeStack, state }: ConnectArgs) {
  if (commandNode.command.skip || !commandNodeConnectors[commandNode.command.command]) {
    connectDefault(commandNode, nextCommandNode, commandNodeStack, state);
  } else {
    commandNodeConnectors[commandNode.command.command](commandNode, nextCommandNode, commandNodeStack, state);
  }
}

const commandNodeConnectors = {
  [ControlFlowCommandNames.do]: trackBranchOpen,
  [ControlFlowCommandNames.else]: connectNext,
  [ControlFlowCommandNames.elseIf]: connectConditional,
  [ControlFlowCommandNames.end]: trackBranchClose,
  [ControlFlowCommandNames.forEach]: connectConditionalForBranchOpen,
  [ControlFlowCommandNames.if]: connectConditionalForBranchOpen,
  [ControlFlowCommandNames.repeatIf]: connectDo,
  [ControlFlowCommandNames.times]: connectConditionalForBranchOpen,
  [ControlFlowCommandNames.while]: connectConditionalForBranchOpen,
};

function connectDefault(commandNode: CommandNode, _nextCommandNode: CommandNode | undefined, stack: CommandNode[], state: State) {
  let nextCommandNode;
  if (_nextCommandNode && ControlFlowCommandChecks.isIf(state.top()) && ControlFlowCommandChecks.isElseOrElseIf(_nextCommandNode.command)) {
    nextCommandNode = findNextNodeBy(stack, commandNode.index, state.top().level!, ControlFlowCommandNames.end);
  } else if (_nextCommandNode && ControlFlowCommandChecks.isLoop(state.top()) && ControlFlowCommandChecks.isEnd(_nextCommandNode.command)) {
    nextCommandNode = stack[state.top().index!];
  } else {
    nextCommandNode = _nextCommandNode;
  }
  connectNext(commandNode, nextCommandNode);
}

function trackBranchOpen(commandNode: CommandNode, nextCommandNode: CommandNode | undefined, _stack: CommandNode[], state: State) {
  state.push({
    command: commandNode.command.command,
    level: commandNode.level,
    index: commandNode.index,
  });
  if (ControlFlowCommandChecks.isDo(commandNode.command)) {
    connectNext(commandNode, nextCommandNode);
  }
}

function trackBranchClose(commandNode: CommandNode, nextCommandNode: CommandNode | undefined, stack: CommandNode[], state: State) {
  state.pop();
  const top = state.top();
  let nextCommandNodeOverride;
  if (top && ControlFlowCommandChecks.isLoop(top) && nextCommandNode && ControlFlowCommandChecks.isEnd(nextCommandNode.command)) {
    nextCommandNodeOverride = stack[top.index!];
  }
  connectNext(commandNode, nextCommandNodeOverride ? nextCommandNodeOverride : nextCommandNode);
}

function connectConditionalForBranchOpen(commandNode: CommandNode, nextCommandNode: CommandNode | undefined, stack: CommandNode[], state: State) {
  trackBranchOpen(commandNode, nextCommandNode, stack, state);
  connectConditional(commandNode, nextCommandNode, stack);
}

function connectConditional(commandNode: CommandNode, nextCommandNode: CommandNode | undefined, stack: CommandNode[]) {
  const left = findNextNodeBy(stack, commandNode.index, commandNode.level);
  const right = nextCommandNode;
  commandNode.right = right;
  commandNode.left = left;
}

function connectNext(commandNode: CommandNode, nextCommandNode: CommandNode | undefined) {
  commandNode.next = nextCommandNode;
}

function connectDo(commandNode: CommandNode, nextCommandNode: CommandNode | undefined, stack: CommandNode[], state: State) {
  const top = state.top();
  if (!top) {
    repeatIfError();
  }
  commandNode.right = stack[top.index!];
  commandNode.left = nextCommandNode;
  state.pop();
}

function findNextNodeBy(stack: CommandNode[], index: number, level: number, commandName?: string) {
  for (let i = index + 1; i < stack.length + 1; i++) {
    if (commandName) {
      if (stack[i].level === level && stack[i].command.command === commandName) {
        return stack[i];
      }
    } else {
      if (stack[i].level === level) {
        return stack[i];
      }
    }
  }
  return undefined;
}
