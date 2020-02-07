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

import { ControlFlowCommandNames } from '../../src/playback-tree/commands';
import { validateControlFlowSyntax } from '../../src/playback-tree/syntax-validation';

function createCommand(command: string) {
  return {
    command,
    target: '',
    value: '',
  };
}

describe('Control Flow', () => {
  describe('Preprocess', () => {
    describe('Syntax Validation', () => {
      test('if, end', () => {
        const result = validateControlFlowSyntax([createCommand(ControlFlowCommandNames.if), createCommand(ControlFlowCommandNames.end)]);
        expect(result).toBeTruthy();
      });
      test('if, else, end', () => {
        const result = validateControlFlowSyntax([
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.else),
          createCommand(ControlFlowCommandNames.end),
        ]);
        expect(result).toBeTruthy();
      });
      test('if, elseIf, end', () => {
        const result = validateControlFlowSyntax([
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.elseIf),
          createCommand(ControlFlowCommandNames.end),
        ]);
        expect(result).toBeTruthy();
      });
      test('if, elseIf, else, end', () => {
        const result = validateControlFlowSyntax([
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.elseIf),
          createCommand(ControlFlowCommandNames.else),
          createCommand(ControlFlowCommandNames.end),
        ]);
        expect(result).toBeTruthy();
      });
      test('while, end', () => {
        const result = validateControlFlowSyntax([createCommand(ControlFlowCommandNames.while), createCommand(ControlFlowCommandNames.end)]);
        expect(result).toBeTruthy();
      });
      test('times, end', () => {
        const result = validateControlFlowSyntax([createCommand('times'), createCommand(ControlFlowCommandNames.end)]);
        expect(result).toBeTruthy();
      });
      test('do, repeatIf', () => {
        const result = validateControlFlowSyntax([createCommand(ControlFlowCommandNames.do), createCommand(ControlFlowCommandNames.repeatIf)]);
        expect(result).toBeTruthy();
      });
      test('do, while, end, repeatIf', () => {
        const result = validateControlFlowSyntax([
          createCommand(ControlFlowCommandNames.do),
          createCommand(ControlFlowCommandNames.while),
          createCommand(ControlFlowCommandNames.end),
          createCommand(ControlFlowCommandNames.repeatIf),
        ]);
        expect(result).toBeTruthy();
      });
    });
    describe('Syntax Invalidation', () => {
      test('if', () => {
        const input = [createCommand(ControlFlowCommandNames.if)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at if');
      });
      test('if, if, end', () => {
        const input = [
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.end),
        ];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at if');
      });
      test('if, else, elseIf, end', () => {
        const input = [
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.else),
          createCommand(ControlFlowCommandNames.elseIf),
          createCommand(ControlFlowCommandNames.end),
        ];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incorrect command order of else if / else');
      });
      test('if, else, else, end', () => {
        const input = [
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.else),
          createCommand(ControlFlowCommandNames.else),
          createCommand(ControlFlowCommandNames.end),
        ];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Too many else commands used');
      });
      test('else', () => {
        const input = [createCommand(ControlFlowCommandNames.else)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('An else used outside of an if block');
      });
      test('else, else', () => {
        const input = [createCommand(ControlFlowCommandNames.else), createCommand(ControlFlowCommandNames.else)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('An else used outside of an if block');
      });
      test('elseIf', () => {
        const input = [createCommand(ControlFlowCommandNames.elseIf)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('An else if used outside of an if block');
      });
      test('while', () => {
        const input = [createCommand(ControlFlowCommandNames.while)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at while');
      });
      test('if, while', () => {
        const input = [createCommand(ControlFlowCommandNames.if), createCommand(ControlFlowCommandNames.while)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at while');
      });
      test('if, while, end', () => {
        const input = [
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.while),
          createCommand(ControlFlowCommandNames.end),
        ];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at if');
      });
      test('if, while, else, end', () => {
        const input = [
          createCommand(ControlFlowCommandNames.if),
          createCommand(ControlFlowCommandNames.while),
          createCommand(ControlFlowCommandNames.else),
          createCommand(ControlFlowCommandNames.end),
        ];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('An else used outside of an if block');
      });
      test('times', () => {
        const input = [createCommand('times')];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at times');
      });
      test('forEach', () => {
        const input = [createCommand(ControlFlowCommandNames.forEach)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow(`Incomplete block at ${ControlFlowCommandNames.forEach}`);
      });
      test('repeatIf', () => {
        const input = [createCommand(ControlFlowCommandNames.repeatIf)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('A repeat if used without a do block');
      });
      test('do', () => {
        const input = [createCommand(ControlFlowCommandNames.do)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Incomplete block at do');
      });
      test('end', () => {
        const input = [createCommand(ControlFlowCommandNames.end)];
        expect(() => {
          validateControlFlowSyntax(input);
        }).toThrow('Use of end without an opening keyword');
      });
    });
  });
});
