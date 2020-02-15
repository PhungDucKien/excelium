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

import { AssertionError, VerificationError } from '../src/errors';
import { CommandStateChangePayload } from '../src/events';
import Playback, { CallstackChange, CommandStates, PlaybackEvents, PlaybackStates } from '../src/playback';
import Variables from '../src/Variables';
import FakeExecutor from './util/FakeExecutor';

describe('Playback', () => {
  describe('Event emitting', () => {
    describe('Control Flow', () => {
      it('forEach', async () => {
        const test = {
          id: 1,
          commands: [
            {
              id: 'asdf0',
              command: 'forEach',
              param1: 'collectionVarName',
              param2: 'iteratorVarName',
              param3: '',
            },
            {
              id: 'asdf1',
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              id: 'asdf2',
              command: 'end',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doOpen = jest.fn(async () => undefined);
        const variables = new Variables();
        variables.set('collectionVarName', ['a', 'b', 'c']);
        const playback = new Playback({
          executor,
          variables,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.CONTROL_FLOW_CHANGED, cb);
        await (await playback.play(test))().catch(() => undefined);
        const results = flat(cb.mock.calls);
        expect(results).toMatchSnapshot();
      });
    });
  });
  describe('Playback test queue', () => {
    it('should play a test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await (await playback.play(test))();
      expect(executor.doOpen).toHaveBeenCalledTimes(3);
    });

    it('should play a test twice', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await (await playback.play(test))();
      await (await playback.play(test))();
      expect(executor.doOpen).toHaveBeenCalledTimes(6);
    });

    it("should throw if trying to run a test when a driver isn't initialized", async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      await (await playback.play(test))();
      executor.cleanup();
      try {
        await (await playback.play(test))();
      } catch (err) {
        expect(err.message).toBe('executor is dead');
      }
    });

    it('should throw if trying to play while a test is running', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await playback.play(test);
      expect.assertions(1);
      try {
        await (await playback.play(test))();
      } catch (err) {
        expect(err.message).toBe("Can't start playback while a different playback is running");
      }
    });

    it("should not throw an uncought error if finish wasn't called", () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'error',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      playback.play(test);
      return psetTimeout(2);
    });

    it('should fail to play a test with an unknown command', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'fail',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      try {
        await (await playback.play(test))();
      } catch (err) {
        expect(err.message).toBe('Unknown command fail');
      }
    });

    it('should pass a test with a failing verify', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'verifyText',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doVerifyText = jest.fn(async () => {
        throw new VerificationError('failed to verify');
      });
      const playback = new Playback({
        executor,
      });
      expect(async () => await (await playback.play(test))()).not.toThrow();
    });

    it('should play a single command', async () => {
      const command = {
        command: 'open',
        param1: '',
        param2: '',
        param3: '',
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await playback.playSingleCommand(command);
      expect(executor.doOpen).toHaveBeenCalledTimes(1);
    });

    it('should play a single command twice', async () => {
      const command = {
        command: 'open',
        param1: '',
        param2: '',
        param3: '',
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await playback.playSingleCommand(command);
      await playback.playSingleCommand(command);
      expect(executor.doOpen).toHaveBeenCalledTimes(2);
    });

    it('should not be able to play a single command twice at the same time', async () => {
      const command = {
        command: 'open',
        param1: '',
        param2: '',
        param3: '',
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => psetTimeout(1));
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      playback.playSingleCommand(command);
      try {
        await playback.playSingleCommand(command);
      } catch (err) {
        expect(err.message).toBe("Can't play a command while playback is running");
      }
    });

    it('should play a single command while a test case is paused and then continue', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => psetTimeout(5));
      const playback = new Playback({
        executor,
      });
      const playPromise = await playback.play(test);
      await psetTimeout(7);
      await playback.pause();
      await playback.playSingleCommand({
        command: 'open',
        param1: '',
        param2: '',
        param3: '',
      });
      await playback.resume();
      await playPromise();
      expect(executor.doOpen).toHaveBeenCalledTimes(4);
    });

    it('should not be able to play a single command while a test case is playing', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => psetTimeout(1));
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      await playback.play(test);

      try {
        await playback.playSingleCommand({
          command: 'open',
          param1: '',
          param2: '',
          param3: '',
        });
      } catch (err) {
        expect(err.message).toBe("Can't play a command while playback is running");
      }
    });

    it('should play a nested test case', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'run',
            param1: 'test2',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };

      const test2 = {
        id: 2,
        commands: [
          {
            id: 4,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 5,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 6,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };

      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(0));
      const playback = new Playback({
        executor,
        getTestByName: () => test2,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.CALL_STACK_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      await (await playback.play(test))();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(2);
      expect(results[0].change).toBe(CallstackChange.CALLED);
      expect(results[1].change).toBe(CallstackChange.UNWINDED);

      expect(commandResults).toMatchSnapshot();
    });

    it("should fail to execute a nested test without providing 'getTestByName'", async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'run',
            param1: 'test2',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };

      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(0));
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      try {
        await (await playback.play(test))();
      } catch (err) {
        expect(err.message).toBe("'run' command is not supported");
      }
    });

    it("should fail to execute a nested test if the test doesn't exist", async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'run',
            param1: 'test2',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };

      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(0));
      const playback = new Playback({
        executor,
        getTestByName: () => undefined,
      });
      expect.assertions(1);
      try {
        await (await playback.play(test))();
      } catch (err) {
        expect(err.message).toBe("Can't run unknown test: test2");
      }
    });
    it('should play a test step by step', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => psetTimeout(0));
      const playback = new Playback({
        executor,
      });
      const playPromise = await playback.play(test, { pauseImmediately: true });
      expect(executor.doOpen).toHaveBeenCalledTimes(0);
      await psetTimeout(1);
      await playback.step();
      expect(executor.doOpen).toHaveBeenCalledTimes(1);
      await playback.step(2);
      expect(executor.doOpen).toHaveBeenCalledTimes(3);
      await playback.resume();
      await playPromise();
      expect(executor.doOpen).toHaveBeenCalledTimes(3);
    });

    it('should reject step if one of the steps failed', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'fail',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => psetTimeout(0));
      const playback = new Playback({
        executor,
      });
      const playPromise = await playback.play(test, { pauseImmediately: true });
      playPromise().catch(() => undefined);
      await psetTimeout(1);
      await playback.step();
      expect.assertions(2);
      expect(executor.doOpen).toHaveBeenCalledTimes(1);
      try {
        await playback.step(2);
      } catch (err) {
        expect(err.message).toBe('Playback stopped prematurely');
      }
      await playPromise();
    });
  });

  describe('play to and from', () => {
    it('should play to a point and continue to the end', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      const playPromise = await playback.playTo(test, test.commands[2]);
      expect(executor.doOpen).toHaveBeenCalledTimes(2);
      await playback.resume();
      await playPromise();
      expect(executor.doOpen).toHaveBeenCalledTimes(3);
    });
    it('should fail to play to a point that does not exist in the test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      try {
        await playback.playTo(test, { command: '' });
      } catch (err) {
        expect(err.message).toBe('Command not found in test');
      }
    });
    it('should replay a command when in a control flow loop', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'forEach',
            param1: 'collectionVarName',
            param2: 'iteratorVarName',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'end',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const variables = new Variables();
      variables.set('collectionVarName', [0, 1, 2]);
      const playback = new Playback({
        executor,
        variables,
      });
      const playPromise = await playback.playFrom(test, test.commands[0]);
      await playPromise();
      expect(executor.doOpen).toHaveBeenCalledTimes(3);
    });
    it('should fail to play to an unreachable point', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'if',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'end',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      executor.evaluateConditional = jest.fn(async () => false);
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      try {
        await playback.playTo(test, test.commands[2]);
      } catch (err) {
        expect(err.message).toBe("Playback finished before reaching the requested command, check to make sure control flow isn't preventing this");
      }
    });
    it('should play from a point', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      const playPromise = await playback.playFrom(test, test.commands[1]);
      await playPromise();
      expect(executor.doOpen).toHaveBeenCalledTimes(2);
    });
    it('should play to a command from a command', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: 't1',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: 't2',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: 't3',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: 't4',
            param2: '',
            param3: '',
          },
        ],
      };

      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await playback.playTo(test, test.commands[2], test.commands[1]);
      expect(executor.doOpen).toHaveBeenCalledTimes(1);
      expect(executor.doOpen).toHaveBeenCalledWith('t2', '', '', test.commands[1]);
    });
    it('should fail to play to a point that exists, from a point that does not exist in the test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      const playback = new Playback({
        executor,
      });
      expect.assertions(1);
      try {
        await playback.playTo(test, test.commands[0], { command: '' });
      } catch (err) {
        expect(err.message).toBe('Command to start from not found in test');
      }
    });
  });

  describe('resume', () => {
    it('should resume a paused test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);
      playbackPromise().catch(() => undefined);

      await psetTimeout(15);
      await playback.pause();
      await psetTimeout(15);
      await playback.resume();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(5);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.PAUSED);
      expect(results[3].state).toBe(PlaybackStates.PLAYING);
      expect(results[4].state).toBe(PlaybackStates.FINISHED);

      expect(commandResults).toMatchSnapshot();
    });

    it("resume is a no-op if test isn't paused", async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(0));
      const playback = new Playback({
        executor,
      });
      const playbackPromise = await playback.play(test);
      expect(() => playback.resume()).not.toThrow();

      await playbackPromise().catch(() => undefined);
    });

    it('resume after hitting a breakpoint', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
            isBreakpoint: true,
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);

      await psetTimeout(15);
      await playback.resume();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(5);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.BREAKPOINT);
      expect(results[3].state).toBe(PlaybackStates.PLAYING);
      expect(results[4].state).toBe(PlaybackStates.FINISHED);

      expect(commandResults).toMatchSnapshot();
    });
  });

  describe('stop', () => {
    it('should stop a test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);

      await psetTimeout(15);
      await playback.stop();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(3);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.STOPPED);

      expect(commandResults).toMatchSnapshot();
    });

    it('should stop a paused test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);

      await psetTimeout(15);
      await playback.pause();
      await psetTimeout(15);
      await playback.stop();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(4);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.PAUSED);
      expect(results[3].state).toBe(PlaybackStates.STOPPED);

      expect(commandResults).toMatchSnapshot();
    });
  });

  describe('abort', () => {
    it('should abort a test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);

      await psetTimeout(15);
      await playback.abort();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(3);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.ABORTED);

      expect(commandResults).toMatchSnapshot();
    });

    it('should abort a test after attempting to stop', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);
      playbackPromise().catch(err => {
        expect(err.message).toBe('playback is dead');
      });

      await psetTimeout(15);
      playback.stop();
      await psetTimeout(2);
      await playback.abort();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(3);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.ABORTED);

      expect(commandResults).toMatchSnapshot();
    });

    it('should abort a paused test', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);
      playbackPromise().catch(err => {
        expect(err.message).toBe('playback is dead');
      });

      await psetTimeout(15);
      await playback.pause();
      await psetTimeout(15);
      await playback.abort();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(4);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.PAUSED);
      expect(results[3].state).toBe(PlaybackStates.ABORTED);

      expect(commandResults).toMatchSnapshot();
    });
  });

  describe('pause on exceptions', () => {
    it('should pause until the command is fixed', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => {
        throw new Error('error');
      });
      const playback = new Playback({
        executor,
        options: {
          pauseOnExceptions: true,
        },
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);
      playbackPromise().catch(() => undefined);

      await psetTimeout(5);
      await playback.resume();
      await psetTimeout(5);
      executor.doOpen.mockImplementation(async () => undefined);
      await playback.resume();
      await psetTimeout(100);
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(7);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.BREAKPOINT);
      expect(results[3].state).toBe(PlaybackStates.PLAYING);
      expect(results[4].state).toBe(PlaybackStates.BREAKPOINT);
      expect(results[5].state).toBe(PlaybackStates.PLAYING);
      expect(results[6].state).toBe(PlaybackStates.FINISHED);

      expect(commandResults).toMatchSnapshot();
    });

    it('should pause for every type of error', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'verify',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'assert',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => {
        throw new Error('error');
      });
      executor.doVerify = jest.fn(async () => {
        throw new VerificationError('error in verify');
      });
      executor.doAssert = jest.fn(async () => {
        throw new AssertionError('error in assert');
      });
      const playback = new Playback({
        executor,
        options: {
          pauseOnExceptions: true,
        },
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);
      playbackPromise().catch(() => undefined);

      await psetTimeout(5);
      executor.doOpen.mockImplementation(async () => undefined);
      await playback.resume();
      await psetTimeout(5);
      executor.doVerify.mockImplementation(async () => undefined);
      await playback.resume();
      await psetTimeout(5);
      executor.doAssert.mockImplementation(async () => undefined);
      await psetTimeout(5);
      await playback.resume();
      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(9);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.BREAKPOINT);
      expect(results[3].state).toBe(PlaybackStates.PLAYING);
      expect(results[4].state).toBe(PlaybackStates.BREAKPOINT);
      expect(results[5].state).toBe(PlaybackStates.PLAYING);
      expect(results[6].state).toBe(PlaybackStates.BREAKPOINT);
      expect(results[7].state).toBe(PlaybackStates.PLAYING);
      expect(results[8].state).toBe(PlaybackStates.FINISHED);

      expect(commandResults).toMatchSnapshot();
    });
  });

  describe('ignore breakpoints', () => {
    it('should ignore breakpoints', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
            isBreakpoint: true,
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(1));
      const playback = new Playback({
        executor,
        options: {
          ignoreBreakpoints: true,
        },
      });
      const cb = jest.fn();
      playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      const playbackPromise = await playback.play(test);

      await playbackPromise();

      const results = flat(cb.mock.calls);
      expect(results.length).toBe(3);
      expect(results[0].state).toBe(PlaybackStates.PREPARATION);
      expect(results[1].state).toBe(PlaybackStates.PLAYING);
      expect(results[2].state).toBe(PlaybackStates.FINISHED);

      expect(commandResults).toMatchSnapshot();
    });
  });

  describe('delay between commands', () => {
    it('should delay between commands', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
        options: {
          delay: 5,
        },
      });
      const d = new Date();
      const playbackPromise = await playback.play(test);
      await playbackPromise();
      expect(new Date().getTime() - d.getTime()).toBeGreaterThan(10);
    });

    it('should be able to pause mid-delay', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
        options: {
          delay: 500,
        },
      });
      const d = new Date();
      await playback.play(test);
      await psetTimeout(2);
      await playback.pause();

      expect(new Date().getTime() - d.getTime()).toBeLessThan(30);
    });

    it('should be able to stop mid-delay', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
        options: {
          delay: 500,
        },
      });
      const d = new Date();
      await playback.play(test);
      await psetTimeout(2);
      await playback.stop();

      expect(new Date().getTime() - d.getTime()).toBeLessThan(30);
    });

    it('should be able to abort mid-delay', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
        options: {
          delay: 500,
        },
      });
      const d = new Date();
      const playbackPromise = await playback.play(test);
      playbackPromise().catch(err => {
        expect(err.message).toBe('playback is dead');
      });
      await psetTimeout(2);
      await playback.abort();

      expect(new Date().getTime() - d.getTime()).toBeLessThan(30);
    });
  });

  describe('skip', () => {
    it('should skip a command', async () => {
      const test = {
        id: 1,
        commands: [
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
            skip: true,
          },
          {
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      await (await playback.play(test))();
      expect(executor.doOpen).toHaveBeenCalledTimes(2);
    });
    it('should send a skipped status for skipped commands', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
            skip: true,
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      await (await playback.play(test))();

      expect(commandResults[3].state).toBe(CommandStates.SKIPPED);
    });
    it('should skip when playing single command', async () => {
      const command = {
        command: 'open',
        param1: '',
        param2: '',
        param3: '',
        skip: true,
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(async () => undefined);
      const playback = new Playback({
        executor,
      });
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));

      await playback.playSingleCommand(command);

      expect(executor.doOpen).toHaveBeenCalledTimes(0);
      expect(commandResults[1].state).toBe(CommandStates.SKIPPED);
    });
    it('should skip control flow commands', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'if',
            param1: '',
            param2: '',
            param3: '',
            skip: true,
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'end',
            param1: '',
            param2: '',
            param3: '',
            skip: true,
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      await (await playback.play(test))();

      expect(executor.doOpen).toHaveBeenCalledTimes(1);
      expect(commandResults[1].state).toBe(CommandStates.SKIPPED);
      expect(commandResults[5].state).toBe(CommandStates.SKIPPED);
    });
    it('should fail to play a test with invalid control flow structure due to skipping commands', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'if',
            param1: '',
            param2: '',
            param3: '',
            skip: true,
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'end',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));

      expect.assertions(1);

      try {
        await playback.play(test);
      } catch (err) {
        expect(err.message).toBe('Use of end without an opening keyword');
      }
    });

    it('should fail to play a test with undetermined control flow structure due to skipping commands', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'if',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 3,
            command: 'end',
            param1: '',
            param2: '',
            param3: '',
            skip: true,
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));

      expect.assertions(1);

      try {
        await playback.play(test);
      } catch (err) {
        expect(err.message).toBe('Incomplete block at if');
      }
    });

    it('should support skipping `run` command', async () => {
      const test = {
        id: 1,
        commands: [
          {
            id: 1,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
          {
            id: 2,
            command: 'run',
            param1: 'test',
            param2: '',
            param3: '',
            skip: true,
          },
          {
            id: 3,
            command: 'open',
            param1: '',
            param2: '',
            param3: '',
          },
        ],
      };
      const executor = new FakeExecutor();
      executor.doOpen = jest.fn(() => psetTimeout(10));
      const playback = new Playback({
        executor,
      });
      const commandResults = [] as CommandStateChangePayload[];
      playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, (r: CommandStateChangePayload) => commandResults.push(r));
      await (await playback.play(test))();

      expect(commandResults[3].state).toBe(CommandStates.SKIPPED);
    });
  });

  describe('Events', () => {
    describe("'command-state-changed'", () => {
      it('should listen to pending and pass changes', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doOpen = jest.fn(async () => undefined);
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, cb);
        await (await playback.play(test))();
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(2);
        expect(results[0].state).toBe(CommandStates.EXECUTING);
        expect(results[1].state).toBe(CommandStates.PASSED);
      });
      it('should listen to fail changes', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'verifyText',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doVerifyText = jest.fn(async () => {
          throw new VerificationError('failed to verify');
        });
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, cb);
        await (await playback.play(test))().catch(() => undefined);
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(2);
        expect(results[0].state).toBe(CommandStates.EXECUTING);
        expect(results[1].state).toBe(CommandStates.FAILED);
      });
      it('should listen to error changes', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'fatal',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.COMMAND_STATE_CHANGED, cb);
        await (await playback.play(test))().catch(() => undefined);
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(2);
        expect(results[0].state).toBe(CommandStates.EXECUTING);
        expect(results[1].state).toBe(CommandStates.ERRORED);
      });
    });
    describe("'playback-state-changed'", () => {
      it('should finish test successfully', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doOpen = jest.fn(async () => undefined);
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
        await (await playback.play(test))();
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(3);
        expect(results[0].state).toBe(PlaybackStates.PREPARATION);
        expect(results[1].state).toBe(PlaybackStates.PLAYING);
        expect(results[2].state).toBe(PlaybackStates.FINISHED);
      });
      it('should fail due to verify', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              command: 'verifyText',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doOpen = jest.fn(async () => undefined);
        executor.doVerifyText = jest.fn(async () => {
          throw new VerificationError('failed to verify');
        });
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
        await (await playback.play(test))();
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(3);
        expect(results[0].state).toBe(PlaybackStates.PREPARATION);
        expect(results[1].state).toBe(PlaybackStates.PLAYING);
        expect(results[2].state).toBe(PlaybackStates.FAILED);
      });
      it('should fail due to assertion', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              command: 'assertText',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doOpen = jest.fn(async () => undefined);
        executor.doAssertText = jest.fn(async () => {
          throw new AssertionError('failed to assert');
        });
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
        await (await playback.play(test))().catch(() => undefined);
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(3);
        expect(results[0].state).toBe(PlaybackStates.PREPARATION);
        expect(results[1].state).toBe(PlaybackStates.PLAYING);
        expect(results[2].state).toBe(PlaybackStates.FAILED);
      });
      it('should fail due to error', async () => {
        const test = {
          id: 1,
          commands: [
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              command: 'assertText',
              param1: '',
              param2: '',
              param3: '',
            },
            {
              command: 'open',
              param1: '',
              param2: '',
              param3: '',
            },
          ],
        };
        const executor = new FakeExecutor();
        executor.doOpen = jest.fn(async () => undefined);
        executor.doAssertText = jest.fn(async () => {
          throw new Error('error in command');
        });
        const playback = new Playback({
          executor,
        });
        const cb = jest.fn();
        playback.on(PlaybackEvents.PLAYBACK_STATE_CHANGED, cb);
        await (await playback.play(test))().catch(() => undefined);
        const results = flat(cb.mock.calls);
        expect(results.length).toBe(3);
        expect(results[0].state).toBe(PlaybackStates.PREPARATION);
        expect(results[1].state).toBe(PlaybackStates.PLAYING);
        expect(results[2].state).toBe(PlaybackStates.ERRORED);
      });
    });
  });
});

const psetTimeout = (timeout: number) =>
  new Promise(res => {
    setTimeout(res, timeout);
  });

const flat = (arr: any[]) => arr.reduce((f, a) => [...f, ...a], []);
