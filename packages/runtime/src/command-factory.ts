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

import { ObjectUtil, StringUtil } from '@excelium/common';
import _ from 'lodash';
import CommandExecutor from './command-executor';
import { AssertionError } from './errors';
import { Accessor, Action, ArgType, Command, CommandObject, text } from './model';
import { interpolateString } from './preprocessors';
import Variables from './Variables';

/**
 * Factory that creates commands.
 *
 * @author PhungDucKien
 * @since 2018.05.07
 */
export default class CommandFactory {
  /**
   * Creates the map of commands from the list of command executors.
   *
   * @param commandExecutors the list of command executors
   * @return the map of commands
   */
  public static createCommandMap(commandExecutors: CommandExecutor[]): Map<string, Command<any>> {
    const commandMap = new Map<string, Command<any>>();
    for (const executor of commandExecutors) {
      const commands = this.createCommandList(executor);
      for (const command of commands) {
        commandMap.set(command.name, command);
      }
    }
    return commandMap;
  }

  /**
   * Creates the list of commands from the command executor.
   *
   * @param executor the command executor
   * @return the list of commands
   */
  private static createCommandList(executor: CommandExecutor): Array<Command<any>> {
    const actions = [] as Array<Action<any>>;
    const accessors = [] as Array<Accessor<any>>;
    for (const action of executor.getActions()) {
      if (!action.predicate || action.predicate(executor.getWebDriver())) {
        if (action instanceof Accessor) {
          accessors.push(action);
        } else {
          actions.push(action);
        }
      }
    }

    let commands = this.createCommandsForActions(actions);
    commands = _.concat(commands, this.createCommandsForAccessors(executor, accessors));
    return commands;
  }

  /**
   * Creates the list of commands from actions of the command executor.
   *
   * @param actions  the map of actions
   * @return the list of commands
   */
  private static createCommandsForActions(actions: Array<Action<any>>): Array<Command<any>> {
    const commands = [] as Array<Command<any>>;
    for (const action of actions) {
      const regex = /^([a-zA-Z].+)$/g;
      const matcher = regex.exec(action.name);

      if (matcher !== null) {
        const baseName = StringUtil.capitalize(matcher[1]);

        commands.push(this.createCommand(action, baseName));
        if (baseName.startsWith('Verify')) {
          commands.push(this.createCommand(action, baseName.replace('Verify', 'Assert')));
        }
      }
    }
    return commands;
  }

  /**
   * Creates the list of commands from accessors of the command executor.
   *
   * @param executor  the command executor
   * @param accessors the map of accessors
   * @return the list of commands
   */
  private static createCommandsForAccessors(executor: CommandExecutor, accessors: Array<Accessor<any>>): Array<Command<any>> {
    const storeCommands = [] as Array<Command<any>>;
    const verifyCommands = [] as Array<Command<any>>;
    const verifyNotCommands = [] as Array<Command<any>>;
    const verifyContainCommands = [] as Array<Command<any>>;
    const verifyNotContainCommands = [] as Array<Command<any>>;
    const verifyMatchCommands = [] as Array<Command<any>>;
    const verifyNotMatchCommands = [] as Array<Command<any>>;
    const assertCommands = [] as Array<Command<any>>;
    const assertNotCommands = [] as Array<Command<any>>;
    const assertContainCommands = [] as Array<Command<any>>;
    const assertNotContainCommands = [] as Array<Command<any>>;
    const assertMatchCommands = [] as Array<Command<any>>;
    const assertNotMatchCommands = [] as Array<Command<any>>;
    const waitCommands = [] as Array<Command<any>>;
    const waitNotCommands = [] as Array<Command<any>>;
    const waitContainCommands = [] as Array<Command<any>>;
    const waitNotContainCommands = [] as Array<Command<any>>;
    const waitMatchCommands = [] as Array<Command<any>>;
    const waitNotMatchCommands = [] as Array<Command<any>>;
    const executeCommands = [] as Array<Command<any>>;
    const executeNotCommands = [] as Array<Command<any>>;
    const executeContainCommands = [] as Array<Command<any>>;
    const executeNotContainCommands = [] as Array<Command<any>>;
    const executeMatchCommands = [] as Array<Command<any>>;
    const executeNotMatchCommands = [] as Array<Command<any>>;
    for (const accessor of accessors) {
      const regex = /^(get|is)(String)?([A-Z].+)$/g;
      const matcher = regex.exec(accessor.name);

      if (matcher !== null) {
        const baseName = StringUtil.capitalize(matcher[3]);

        const paramCount = this.countParam(accessor);
        const isString = 'get' === matcher[1] && 'String' === matcher[2];
        const isBool = 'is' === matcher[1];
        const isContainParentLocators = 'parentLocator' === accessor.param1 && 'locator' === accessor.param2;

        if (this.allow(accessor, 'verify')) {
          verifyCommands.push(this.createCommandForAccessor(executor, accessor, 'verify', baseName, isBool));
          verifyNotCommands.push(this.createCommandForAccessor(executor, accessor, 'verify', this.invertPredicateName(baseName), isBool));
          assertCommands.push(this.createCommandForAccessor(executor, accessor, 'assert', baseName, isBool));
          assertNotCommands.push(this.createCommandForAccessor(executor, accessor, 'assert', this.invertPredicateName(baseName), isBool));
        }
        if ('variable' !== accessor.param1) {
          if (!isBool && this.allow(accessor, 'store')) {
            storeCommands.push(this.createCommandForAccessor(executor, accessor, 'store', baseName, false));
          }
          if (this.allow(accessor, 'wait')) {
            waitCommands.push(this.createCommandForAccessor(executor, accessor, 'waitFor', baseName, isBool));
            waitNotCommands.push(this.createCommandForAccessor(executor, accessor, 'waitFor', this.invertPredicateName(baseName), isBool));
          }
        }
        if ((isBool || paramCount < 2 || isContainParentLocators) && this.allow(accessor, 'execute')) {
          executeCommands.push(this.createCommandForAccessor(executor, accessor, 'executeIf', baseName, isBool));
          executeNotCommands.push(this.createCommandForAccessor(executor, accessor, 'executeIf', this.invertPredicateName(baseName), isBool));
        }

        if (isString) {
          if (this.allow(accessor, 'verify')) {
            // verifyContainCommands.push(this.createCommandForAccessor(executor, accessor, "verify", baseName + "Contain", isBool));
            // verifyNotContainCommands.push(this.createCommandForAccessor(executor, accessor, "verify", this.invertPredicateName(baseName + "Contain"), isBool));
            // assertContainCommands.push(this.createCommandForAccessor(executor, accessor, "assert", baseName + "Contain", isBool));
            // assertNotContainCommands.push(this.createCommandForAccessor(executor, accessor, "assert", this.invertPredicateName(baseName + "Contain"), isBool));
            verifyMatchCommands.push(this.createCommandForAccessor(executor, accessor, 'verify', baseName + 'Match', isBool));
            verifyNotMatchCommands.push(
              this.createCommandForAccessor(executor, accessor, 'verify', this.invertPredicateName(baseName + 'Match'), isBool)
            );
            assertMatchCommands.push(this.createCommandForAccessor(executor, accessor, 'assert', baseName + 'Match', isBool));
            assertNotMatchCommands.push(
              this.createCommandForAccessor(executor, accessor, 'assert', this.invertPredicateName(baseName + 'Match'), isBool)
            );
          }
          if ('variable' !== accessor.param1 && this.allow(accessor, 'wait')) {
            // waitContainCommands.push(this.createCommandForAccessor(executor, accessor, "waitFor", baseName + "Contain", isBool));
            // waitNotContainCommands.push(this.createCommandForAccessor(executor, accessor, "waitFor", this.invertPredicateName(baseName + "Contain"), isBool));
            waitMatchCommands.push(this.createCommandForAccessor(executor, accessor, 'waitFor', baseName + 'Match', isBool));
            waitNotMatchCommands.push(
              this.createCommandForAccessor(executor, accessor, 'waitFor', this.invertPredicateName(baseName + 'Match'), isBool)
            );
          }
          if ((paramCount < 2 || isContainParentLocators) && this.allow(accessor, 'execute')) {
            // executeContainCommands.push(this.createCommandForAccessor(executor, accessor, "executeIf", baseName + "Contain", isBool));
            // executeNotContainCommands.push(this.createCommandForAccessor(executor, accessor, "executeIf", this.invertPredicateName(baseName + "Contain"), isBool));
            executeMatchCommands.push(this.createCommandForAccessor(executor, accessor, 'executeIf', baseName + 'Match', isBool));
            executeNotMatchCommands.push(
              this.createCommandForAccessor(executor, accessor, 'executeIf', this.invertPredicateName(baseName + 'Match'), isBool)
            );
          }
        }
      }
    }

    let commands = [] as Array<Command<any>>;
    commands = _.concat(commands, storeCommands);
    commands = _.concat(commands, verifyCommands);
    commands = _.concat(commands, verifyNotCommands);
    commands = _.concat(commands, verifyContainCommands);
    commands = _.concat(commands, verifyNotContainCommands);
    commands = _.concat(commands, verifyMatchCommands);
    commands = _.concat(commands, verifyNotMatchCommands);
    commands = _.concat(commands, assertCommands);
    commands = _.concat(commands, assertNotCommands);
    commands = _.concat(commands, assertContainCommands);
    commands = _.concat(commands, assertNotContainCommands);
    commands = _.concat(commands, assertMatchCommands);
    commands = _.concat(commands, assertNotMatchCommands);
    commands = _.concat(commands, waitCommands);
    commands = _.concat(commands, waitNotCommands);
    commands = _.concat(commands, waitContainCommands);
    commands = _.concat(commands, waitNotContainCommands);
    commands = _.concat(commands, waitMatchCommands);
    commands = _.concat(commands, waitNotMatchCommands);
    commands = _.concat(commands, executeCommands);
    commands = _.concat(commands, executeNotCommands);
    commands = _.concat(commands, executeContainCommands);
    commands = _.concat(commands, executeNotContainCommands);
    commands = _.concat(commands, executeMatchCommands);
    commands = _.concat(commands, executeNotMatchCommands);

    return commands;
  }

  /**
   * Creates a command from an action of the command executor.
   *
   * @param action   the action
   * @param baseName the command base name
   * @return the command
   */
  private static createCommand(action: Action<any>, baseName: string): Command<any> {
    return new Command({
      name: StringUtil.uncapitalize(baseName),
      displayName: StringUtil.addSpaceToCamelCase(baseName)!,
      description: action.description,
      predicate: action.predicate,
      args: action.args,
      validate: action.validate,
      execute: action.execute,
      preprocessors: action.preprocessors,
    });
  }

  /**
   * Creates a command from an accessor of the command executor.
   *
   * @param executor the command executor
   * @param accessor the accessor
   * @param action   the action
   * @param baseName the command base name
   * @param isBool   is boolean method
   * @return the command
   */
  private static createCommandForAccessor(
    executor: CommandExecutor,
    accessor: Accessor<any>,
    action: 'verify' | 'assert' | 'store' | 'waitFor' | 'executeIf',
    baseName: string,
    isBool: boolean
  ): Command<any> {
    const paramCount = this.countParam(accessor);
    const paramName = action === 'store' ? 'variable' : isBool ? '' : 'text';
    if (action === 'executeIf') {
      const args = {} as { [key: string]: any };
      const preprocessors = [] as Array<((value?: any, variables?: Variables | undefined) => any) | undefined>;

      args.action = ArgType.exact(text).isRequired();
      preprocessors.push(interpolateString);
      if ('parentLocator' === accessor.param1 && 'locator' === accessor.param2 && paramName) {
        args[accessor.param2!] = accessor.args[accessor.param2!];
        preprocessors.push(accessor.preprocessors?.[1]);

        args[paramName] = ArgType.exact(text).isRequired();
        preprocessors.push(interpolateString);
      } else {
        if (accessor.param1) {
          args[accessor.param1] = accessor.args[accessor.param1];
          preprocessors.push(accessor.preprocessors?.[0]);
        }
        if (accessor.param2) {
          args[accessor.param2] = accessor.args[accessor.param2];
          preprocessors.push(accessor.preprocessors?.[1]);
        }
        if (paramCount < 2 && paramName) {
          args[paramName] = ArgType.exact(text).isRequired();
          preprocessors.push(interpolateString);
        }
      }

      return new Command({
        name: action + baseName,
        displayName: StringUtil.addSpaceToCamelCase(StringUtil.capitalize(action) + baseName)!,
        description: accessor.description,
        predicate: accessor.predicate,
        args,
        execute: async (__?: string, param2?: string, param3?: string, command?: CommandObject) => {
          try {
            if ('parentLocator' === accessor.param1 && 'locator' === accessor.param2 && paramName) {
              await this.assertValue(executor, accessor.execute, baseName, null, param2, param3, command, paramCount);
            } else {
              await this.assertValue(executor, accessor.execute, baseName, param2, param3, null, command, paramCount);
            }
            // return executor.runAction(param1);
          } catch (e) {
            console.error(e);
          }
        },
        preprocessors,
      });
    } else {
      const args = {} as { [key: string]: any };
      const preprocessors = [] as Array<((value?: any, variables?: Variables | undefined) => any) | undefined>;

      if (accessor.param1) {
        args[accessor.param1] = accessor.args[accessor.param1];
        preprocessors.push(accessor.preprocessors?.[0]);
      }
      if (accessor.param2) {
        args[accessor.param2] = accessor.args[accessor.param2];
        preprocessors.push(accessor.preprocessors?.[1]);
      }
      if (paramName) {
        args[paramName] = ArgType.exact(text).isRequired();
        preprocessors.push(interpolateString);
      }

      return new Command({
        name: action + baseName,
        displayName: StringUtil.addSpaceToCamelCase(StringUtil.capitalize(action) + baseName)!,
        description: accessor.description,
        predicate: accessor.predicate,
        args,
        execute: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => {
          if (action === 'store') {
            return this.storeValue(executor, accessor.execute, param1, param2, param3, command, paramCount);
          } else if (action === 'verify' || action === 'assert') {
            return this.assertValue(executor, accessor.execute, baseName, param1, param2, param3, command, paramCount);
          } else if (action.startsWith('waitFor')) {
            return executor
              .getWebDriver()
              .wait(this.getExpectedCondition(executor, accessor.execute, baseName, param1, param2, param3, command, paramCount));
          }
          throw new Error('Invalid action');
        },
        preprocessors,
      });
    }
  }

  /**
   * Inverts predicate name.
   *
   * @param baseName the base name
   * @return inverted name
   */
  private static invertPredicateName(baseName: string): string {
    const verbs = 'Present|Contain|Match';
    const r = '^((?:(?!(?:' + verbs + ')).)+)(' + verbs + ')(.*)$';

    const regex = new RegExp(r, 'g');
    const matcher = regex.exec(baseName);

    if (matcher !== null) {
      return matcher[1] + 'Not' + matcher[2] + matcher[3];
    }
    return 'Not' + baseName;
  }

  /**
   * Count the number of parameters of the action.
   *
   * @param action the action
   * @return the number of parameters
   */
  private static countParam(action: Action<any>): number {
    if (action.args) {
      return Object.getOwnPropertyNames(action.args).length;
    }
    return 0;
  }

  /**
   * Gets expected condition.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param baseName   the base name
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   * @return the expected condition
   */
  private static getExpectedCondition(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    baseName: string,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): () => Promise<boolean> {
    return async () => {
      try {
        this.assertValue(executor, method, baseName, param1, param2, param3, command, paramCount);
        return true;
      } catch (e) {
        return false;
      }
    };
  }

  /**
   * Store value.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async storeValue(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (paramCount === 0) {
      return executor.getWebDriver().setVariable(value, param1);
    } else if (paramCount === 1) {
      return executor.getWebDriver().setVariable(value, param2);
    } else if (paramCount === 2) {
      return executor.getWebDriver().setVariable(value, param3);
    }
  }

  /**
   * Assert value.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param baseName   the base name
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static assertValue(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    baseName: string,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    if (baseName.indexOf('NotContain') !== -1 && baseName.indexOf('NotContainElement') === -1) {
      return this.assertStringNotContain(executor, method, param1, param2, param3, command, paramCount);
    } else if (baseName.indexOf('Contain') !== -1 && baseName.indexOf('ContainElement') === -1) {
      return this.assertStringContains(executor, method, param1, param2, param3, command, paramCount);
    } else if (baseName.indexOf('NotMatch') !== -1) {
      return this.assertStringNotMatch(executor, method, param1, param2, param3, command, paramCount);
    } else if (baseName.indexOf('Match') !== -1) {
      return this.assertStringMatches(executor, method, param1, param2, param3, command, paramCount);
    } else if (baseName.indexOf('Not') !== -1) {
      return this.assertValueNotToBe(executor, method, param1, param2, param3, command, paramCount);
    } else {
      return this.assertValueToBe(executor, method, param1, param2, param3, command, paramCount);
    }
  }

  /**
   * Assert value to be.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async assertValueToBe(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (value == null) {
      throw new AssertionError('Actual value is null.');
    }
    if (typeof value === 'boolean') {
      if (!value) {
        throw new AssertionError('Actual value is FALSE.');
      }
    } else {
      if (typeof value === 'string' || Array.isArray(value)) {
        const actual = this.getStringValue(value);
        if (paramCount === 0) {
          if (actual !== executor.normalizeText(param1 as string)) {
            throw new AssertionError("Actual text '" + actual + "' did not match '" + param1 + "'");
          }
        } else if (paramCount === 1) {
          if (actual !== executor.normalizeText(param2 as string)) {
            throw new AssertionError("Actual text '" + actual + "' did not match '" + param2 + "'");
          }
        } else if (paramCount === 2) {
          if (actual !== executor.normalizeText(param3 as string)) {
            throw new AssertionError("Actual text '" + actual + "' did not match '" + param3 + "'");
          }
        } else {
          throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
        }
      } else {
        if (paramCount === 0) {
          if (!ObjectUtil.checkEquals(param1, value)) {
            throw new AssertionError("Actual value '" + value + "' did not match '" + param1 + "'");
          }
        } else if (paramCount === 1) {
          if (!ObjectUtil.checkEquals(param2, value)) {
            throw new AssertionError("Actual value '" + value + "' did not match '" + param2 + "'");
          }
        } else if (paramCount === 2) {
          if (!ObjectUtil.checkEquals(param3, value)) {
            throw new AssertionError("Actual value '" + value + "' did not match '" + param3 + "'");
          }
        } else {
          throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
        }
      }
    }
  }

  /**
   * Assert value not to be.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async assertValueNotToBe(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (value == null) {
      throw new AssertionError('Actual value is null.');
    }
    if (typeof value === 'boolean') {
      if (value) {
        throw new AssertionError('Actual value is TRUE.');
      }
    } else {
      if (typeof value === 'string' || Array.isArray(value)) {
        const actual = this.getStringValue(value);
        if (paramCount === 0) {
          if (actual === executor.normalizeText(param1 as string)) {
            throw new AssertionError("Actual text '" + actual + "' did match '" + param1 + "'");
          }
        } else if (paramCount === 1) {
          if (actual === executor.normalizeText(param2 as string)) {
            throw new AssertionError("Actual text '" + actual + "' did match '" + param2 + "'");
          }
        } else if (paramCount === 2) {
          if (actual === executor.normalizeText(param3 as string)) {
            throw new AssertionError("Actual text '" + actual + "' did match '" + param3 + "'");
          }
        } else {
          throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
        }
      } else {
        if (paramCount === 0) {
          if (ObjectUtil.checkEquals(param1, value)) {
            throw new AssertionError("Actual value '" + value + "' did match '" + param1 + "'");
          }
        } else if (paramCount === 1) {
          if (ObjectUtil.checkEquals(param2, value)) {
            throw new AssertionError("Actual value '" + value + "' did match '" + param2 + "'");
          }
        } else if (paramCount === 2) {
          if (ObjectUtil.checkEquals(param3, value)) {
            throw new AssertionError("Actual value '" + value + "' did match '" + param3 + "'");
          }
        } else {
          throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
        }
      }
    }
  }

  /**
   * Assert string contains.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async assertStringContains(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (value == null) {
      throw new AssertionError('Actual value is null.');
    }
    const actual = this.getStringValue(value);
    if (paramCount === 0) {
      if (actual.indexOf(executor.normalizeText(param1 as string)) === -1) {
        throw new AssertionError("Actual text '" + actual + "' did not contain '" + param1 + "'");
      }
    } else if (paramCount === 1) {
      if (actual.indexOf(executor.normalizeText(param2 as string)) === -1) {
        throw new AssertionError("Actual text '" + actual + "' did not contain '" + param2 + "'");
      }
    } else if (paramCount === 2) {
      if (actual.indexOf(executor.normalizeText(param3 as string)) === -1) {
        throw new AssertionError("Actual text '" + actual + "' did not contain '" + param3 + "'");
      }
    } else {
      throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
    }
  }

  /**
   * Assert string not contain.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async assertStringNotContain(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (value == null) {
      throw new AssertionError('Actual value is null.');
    }
    const actual = this.getStringValue(value);
    if (paramCount === 0) {
      if (actual.indexOf(executor.normalizeText(param1 as string)) > -1) {
        throw new AssertionError("Actual text '" + actual + "' did contain '" + param1 + "'");
      }
    } else if (paramCount === 1) {
      if (actual.indexOf(executor.normalizeText(param2 as string)) > -1) {
        throw new AssertionError("Actual text '" + actual + "' did ontain '" + param2 + "'");
      }
    } else if (paramCount === 2) {
      if (actual.indexOf(executor.normalizeText(param3 as string)) > -1) {
        throw new AssertionError("Actual text '" + actual + "' did contain '" + param3 + "'");
      }
    } else {
      throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
    }
  }

  /**
   * Assert string matches a given pattern.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async assertStringMatches(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (value == null) {
      throw new AssertionError('Actual value is null.');
    }
    const actual = this.getStringValue(value);
    if (paramCount === 0) {
      if (new RegExp(executor.normalizeText(param1 as string), 'm').exec(actual) == null) {
        throw new AssertionError("Actual text '" + actual + "' did not match '" + param1 + "'");
      }
    } else if (paramCount === 1) {
      if (new RegExp(executor.normalizeText(param2 as string), 'm').exec(actual) == null) {
        throw new AssertionError("Actual text '" + actual + "' did not match '" + param2 + "'");
      }
    } else if (paramCount === 2) {
      if (new RegExp(executor.normalizeText(param3 as string), 'm').exec(actual) == null) {
        throw new AssertionError("Actual text '" + actual + "' did not match '" + param3 + "'");
      }
    } else {
      throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
    }
  }

  /**
   * Assert string not match a given pattern.
   *
   * @param executor   the command executor
   * @param method     the method
   * @param param1     the parameter 1
   * @param param2     the parameter 2
   * @param param3     the parameter 3
   * @param command    the command object
   * @param paramCount the parameter count
   */
  private static async assertStringNotMatch(
    executor: CommandExecutor,
    method: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>,
    param1: any,
    param2: any,
    param3: any,
    command: CommandObject | undefined,
    paramCount: number
  ): Promise<void> {
    const value = await method.call(executor, param1, param2, undefined, command);
    if (value == null) {
      throw new AssertionError('Actual value is null.');
    }
    const actual = this.getStringValue(value);
    if (paramCount === 0) {
      if (new RegExp(executor.normalizeText(param1 as string), 'm').exec(actual) != null) {
        throw new AssertionError("Actual text '" + actual + "' did match '" + param1 + "'");
      }
    } else if (paramCount === 1) {
      if (new RegExp(executor.normalizeText(param2 as string), 'm').exec(actual) != null) {
        throw new AssertionError("Actual text '" + actual + "' did match '" + param2 + "'");
      }
    } else if (paramCount === 2) {
      if (new RegExp(executor.normalizeText(param3 as string), 'm').exec(actual) != null) {
        throw new AssertionError("Actual text '" + actual + "' did match '" + param3 + "'");
      }
    } else {
      throw new AssertionError('Number of parameters is invalid. Param count is ' + paramCount);
    }
  }

  /**
   * Returns the string representation of a value.
   * If the given value is in string array format, join the element delimited by new line character.
   *
   * @param value the value object
   * @return the string representation
   */
  private static getStringValue(value: string | string[]): string {
    if (typeof value === 'string' || value instanceof String) {
      return value as string;
    } else {
      return value.join('\n');
    }
  }

  private static allow(accessor: Accessor<any>, action: 'store' | 'verify' | 'wait' | 'execute') {
    return !accessor.exclude || accessor.exclude.indexOf(action) === -1;
  }
}
