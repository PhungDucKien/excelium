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

import { StringUtil } from '@excelium/common';
import { Command } from './model';
import Variables from './Variables';

const nbsp = String.fromCharCode(160);

export function composeMapper(command: Command<any>, func: any) {
  const commandParamCount = countCommandParam(command);
  return function map(this: any, param1: any, param2: any, param3: any, options: any) {
    const paramCount = countParam(param1, param2, param3);
    if ('parentLocator' === command.param1 && 'locator' === command.param2) {
      return func.call(
        this,
        paramCount >= commandParamCount ? param1 : undefined,
        paramCount >= commandParamCount ? param2 : param1,
        paramCount >= commandParamCount ? param3 : param2,
        options
      );
    } else if ('parentLocator' === command.param2 && 'locator' === command.param3) {
      return func.call(
        this,
        param1,
        paramCount >= commandParamCount ? param2 : undefined,
        paramCount >= commandParamCount ? param3 : param2,
        options
      );
    } else {
      return func.call(this, param1, param2, param3, options);
    }
  };
}

export function composeValidator(command: Command<any>, ...args: any[]) {
  const func = args[args.length - 1];
  const params = args.slice(0, args.length - 1);
  if (params.length === 0 || !params[0]) {
    return func;
  } else {
    return function validate(this: any, param1: any, param2: any, param3: any, options: any) {
      const value = {} as { [key: string]: any };
      if (command.param1) {
        value[command.param1] = param1;
      }
      if (command.param2) {
        value[command.param2] = param2;
      }
      if (command.param3) {
        value[command.param3] = param3;
      }
      if (params[0].call(command, value)) {
        return func.call(this, param1, param2, param3, options);
      }
      throw new Error('Validation failed');
    };
  }
}

// this function is meant to be composed on the prototype of the executor
// refer to preprocessor.spec.js for an example on how to do so
// this will define this to be in scope allowing the executor function to
// have this in scope as well as grant the preprocessor access to the variables
export function composePreprocessors(...args: any[]) {
  const func = args[args.length - 1];
  const params = args.slice(0, args.length - 1);
  if (params.length === 0) {
    return func;
  } else if (params.length === 1) {
    return function preprocess(this: any, param1: any) {
      return func.call(this, runPreprocessor(params[0], param1, this.variables));
    };
  } else if (params.length === 2) {
    return function preprocess(this: any, param1: any, param2: any) {
      return func.call(this, runPreprocessor(params[0], param1, this.variables), runPreprocessor(params[1], param2, this.variables));
    };
  } else if (params.length === 3) {
    return function preprocess(this: any, param1: any, param2: any, param3: any) {
      return func.call(
        this,
        runPreprocessor(params[0], param1, this.variables),
        runPreprocessor(params[1], param2, this.variables),
        runPreprocessor(params[2], param3, this.variables)
      );
    };
  } else {
    return function preprocess(this: any, param1: any, param2: any, param3: any, options: any) {
      if (!options) {
        return func.call(
          this,
          runPreprocessor(params[0], param1, this.variables),
          runPreprocessor(params[1], param2, this.variables),
          runPreprocessor(params[2], param3, this.variables)
        );
      }
      return func.call(
        this,
        runPreprocessor(params[0], param1, this.variables),
        runPreprocessor(params[1], param2, this.variables),
        runPreprocessor(params[2], param3, this.variables),
        preprocessObject(params[3], options, this.variables)
      );
    };
  }
}

function runPreprocessor(preprocessor: (value?: any, variables?: Variables) => any, value?: any, variables?: Variables) {
  if (typeof preprocessor === 'function') {
    return preprocessor(value, variables);
  }
  return value;
}

function preprocessObject(
  preprocessors: {
    [key: string]: (value?: any, variables?: Variables) => any;
  },
  obj: {
    [key: string]: any;
  },
  variables?: Variables
) {
  const result = { ...obj };

  Object.keys(preprocessors).forEach(prop => {
    if (result[prop]) {
      result[prop] = runPreprocessor(preprocessors[prop], result[prop], variables);
    }
  });

  return result;
}

export function preprocessArray(interpolator: (value?: any, variables?: Variables) => any) {
  return function _preprocessArray(items: any[][], variables?: Variables) {
    return items.map(item => [interpolator(item[0], variables), item[1]]);
  };
}

export function interpolateString(value?: string, variables?: Variables) {
  if (value != null) {
    value = value.replace(/^\s+/, '');
    value = value.replace(/\s+$/, '');
    let r2;
    const parts = [] as string[];
    if (/\$\{/.exec(value)) {
      const regexp = /\$\{(.*?)\}/g;
      let lastIndex = 0;
      r2 = regexp.exec(value);
      while (r2) {
        if (variables && variables.has(r2[1])) {
          if (r2.index - lastIndex > 0) {
            parts.push(string(value.substring(lastIndex, r2.index)));
          }
          parts.push(variables.get(r2[1]));
          lastIndex = regexp.lastIndex;
        } else if (variables && r2[1] === 'nbsp') {
          if (r2.index - lastIndex > 0) {
            parts.push(variables.get(string(value.substring(lastIndex, r2.index))));
          }
          parts.push(nbsp);
          lastIndex = regexp.lastIndex;
        }
        r2 = regexp.exec(value);
      }
      if (lastIndex < value.length) {
        parts.push(string(value.substring(lastIndex, value.length)));
      }
      return parts.map(String).join('');
    } else {
      return string(value);
    }
  } else {
    return value;
  }
}

export function interpolateScript(script?: string, variables?: Variables) {
  if (script != null) {
    const value = script.replace(/^\s+/, '').replace(/\s+$/, '');
    let r2;
    const parts = [] as string[];
    const variablesUsed = {} as {
      [key: string]: number;
    };
    const argv = [] as any[];
    let argl = 0; // length of arguments
    if (/\$\{/.exec(value)) {
      const regexp = /\$\{(.*?)\}/g;
      let lastIndex = 0;
      r2 = regexp.exec(value);
      while (r2) {
        const variableName = r2[1];
        if (variables && variables.has(variableName)) {
          if (r2.index - lastIndex > 0) {
            parts.push(string(value.substring(lastIndex, r2.index)));
          }
          if (!Object.prototype.hasOwnProperty.call(variablesUsed, variableName)) {
            variablesUsed[variableName] = argl;
            argv.push(variables.get(variableName));
            argl++;
          }
          parts.push(`arguments[${variablesUsed[variableName]}]`);
          lastIndex = regexp.lastIndex;
        }
        r2 = regexp.exec(value);
      }
      if (lastIndex < value.length) {
        parts.push(string(value.substring(lastIndex, value.length)));
      }
      return {
        script: parts.join(''),
        argv,
      };
    } else {
      return {
        script: string(value),
        argv,
      };
    }
  } else {
    return {
      script,
      argv: [],
    };
  }
}

function string(value?: string) {
  if (value != null) {
    value = value.replace(/\\\\/g, '\\');
    value = value.replace(/\\r/g, '\r');
    value = value.replace(/\\n/g, '\n');
    return value;
  } else {
    return '';
  }
}

/**
 * Count the number of parameters.
 *
 * @return the number of parameters
 */
function countParam(param1?: any, param2?: any, param3?: any): number {
  let count = 0;
  if (param1 != null) {
    if (typeof param1 === 'string' || param1 instanceof String) {
      if (StringUtil.isNotBlank(param1 as string)) {
        count++;
      }
    } else {
      count++;
    }
  }
  if (param2 != null) {
    if (typeof param2 === 'string' || param2 instanceof String) {
      if (StringUtil.isNotBlank(param2 as string)) {
        count++;
      }
    } else {
      count++;
    }
  }
  if (param3 != null) {
    if (typeof param3 === 'string' || param3 instanceof String) {
      if (StringUtil.isNotBlank(param3 as string)) {
        count++;
      }
    } else {
      count++;
    }
  }
  return count;
}

/**
 * Count the number of parameters of the command.
 *
 * @param command the command
 * @return the number of parameters
 */
function countCommandParam(command: Command<any>): number {
  if (command.args) {
    return Object.getOwnPropertyNames(command.args).length;
  }
  return 0;
}
