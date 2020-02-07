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
import { ControlFlowCommandNames } from './commands';

export function deriveCommandLevels(commandStack: CommandObject[]) {
  let level = 0;
  let levels = [] as number[];
  commandStack.forEach(command => {
    const result = levelCommand(command, level, levels);
    level = result.level;
    levels = result.levels;
  });
  return levels;
}

function levelCommand(command: CommandObject, level: number, levels: number[]) {
  if (!command.skip && commandLevelers[command.command]) {
    return commandLevelers[command.command](command, level, levels);
  }
  return levelDefault(command, level, levels);
}

const commandLevelers = {
  [ControlFlowCommandNames.do]: levelBranchOpen,
  [ControlFlowCommandNames.else]: levelElse,
  [ControlFlowCommandNames.elseIf]: levelElse,
  [ControlFlowCommandNames.end]: levelBranchEnd,
  [ControlFlowCommandNames.forEach]: levelBranchOpen,
  [ControlFlowCommandNames.if]: levelBranchOpen,
  [ControlFlowCommandNames.repeatIf]: levelBranchEnd,
  [ControlFlowCommandNames.times]: levelBranchOpen,
  [ControlFlowCommandNames.while]: levelBranchOpen,
};

function levelDefault(_command: CommandObject, level: number, _levels: number[]) {
  const levels = [..._levels];
  levels.push(level);
  return { level, levels };
}

function levelBranchOpen(_command: CommandObject, level: number, _levels: number[]) {
  const levels = [..._levels];
  levels.push(level);
  level++;
  return { level, levels };
}

function levelBranchEnd(_command: CommandObject, level: number, _levels: number[]) {
  const levels = [..._levels];
  level--;
  levels.push(level);
  return { level, levels };
}

function levelElse(_command: CommandObject, level: number, _levels: number[]) {
  const levels = [..._levels];
  level--;
  levels.push(level);
  level++;
  return { level, levels };
}
