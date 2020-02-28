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

import Variables from '../../Variables';
import WebDriverExecutor from '../../webdriver';
import ArgType, { ExtractArgument } from '../args/arg-type';
import Argument from '../args/argument';
import CommandObject from '../command-object';

export default class Action<T extends CommandArguments> {
  public readonly name: string;
  public readonly description?: string;
  public readonly args?: T;
  public readonly validate?: CommandValidationFunction<T>;
  public readonly execute: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>;
  public readonly predicate?: (webDriver: WebDriverExecutor) => boolean;
  public readonly preprocessors?: Array<((value?: any, variables?: Variables) => any) | undefined>;
  public readonly param1: string | null = null;
  public readonly param2: string | null = null;
  public readonly param3: string | null = null;

  constructor({ name, description, validate, args, execute, predicate, preprocessors }: ActionOptions<T>) {
    const methodNameParts = execute.name.split(' ');
    this.name = name || methodNameParts[methodNameParts.length - 1];
    this.description = description;
    this.args = args;
    this.validate = validate;
    this.execute = execute;
    this.predicate = predicate;
    this.preprocessors = preprocessors;

    if (args) {
      const paramNames = Object.getOwnPropertyNames(args);
      if (paramNames) {
        if (paramNames[0]) {
          this.param1 = paramNames[0];
        }
        if (paramNames[1]) {
          this.param2 = paramNames[1];
        }
        if (paramNames[2]) {
          this.param3 = paramNames[2];
        }
      }

      if (!this.validate) {
        const validateFn = (value: ExtractArgumentFromArgType<T>) => {
          let ret = true;
          if (this.param1) {
            ret = ret && args[this.param1].validate(value[this.param1]);
          }
          if (ret && this.param2) {
            ret = ret && args[this.param2].validate(value[this.param2]);
          }
          if (ret && this.param3) {
            ret = ret && args[this.param3].validate(value[this.param3]);
          }
          return ret;
        };
        this.validate = validateFn;
      }

      if (!this.preprocessors) {
        this.preprocessors = Array(paramNames.length).fill(undefined);
      }
    }
  }
}

export interface ActionOptions<T extends CommandArguments> {
  name?: string;
  description?: string;
  validate?: CommandValidationFunction<T>;
  args?: T;
  execute: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>;
  predicate?: (webDriver: WebDriverExecutor) => boolean;
  preprocessors?: Array<((value?: any, variables?: Variables) => any) | undefined>;
}

export interface CommandArguments {
  [key: string]: ArgType<Array<Argument<any, any>>>;
}

type ExtractArgType<A> = A extends ArgType<infer B> ? ExtractArgument<B[number]> | undefined : never;
type ExtractArgumentFromArgType<A extends CommandArguments> = {
  [K in keyof A]: ExtractArgType<A[K]>;
};
type CommandValidationFunction<A extends CommandArguments> = (value: ExtractArgumentFromArgType<A>) => boolean;
