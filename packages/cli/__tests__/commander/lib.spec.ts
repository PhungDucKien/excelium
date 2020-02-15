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

import 'reflect-metadata';

import { Container } from 'inversify';
import yargs from 'yargs';
import { TYPE } from '../../src/commander/declaration';
import { action, group } from '../../src/commander/decorator';
import { build, cleanUpMetadata, registerGroups } from '../../src/commander/lib';

describe('Lib', () => {
  let container: Container;
  let strResult = '';
  let argv: any;

  beforeEach(() => {
    cleanUpMetadata();

    @group({ name: 'testGroup' })
    class TestGroup {
      @action({ name: 'aTestAction' })
      public testA() {
        strResult = 'testGroup:aTestAction';
      }

      @action({
        name: 'bTestAction',
        options: [
          {
            key: 'exec_mode',
            options: {
              alias: 'e',
              description: 'Which exec mode to use',
            },
          },
        ],
      })
      public async testB(args: any) {
        strResult = 'testGroup:bTestAction';
        argv = args;
      }

      @action({
        name: 'cAsync',
      })
      public async cAsync(args: any) {
        return new Promise(resolve => {
          setTimeout(() => {
            strResult = 'testGroup:bTestAction';
            argv = args;
            resolve('cAsync');
          }, 100);
        });
      }
    }
  });

  it('Group and action metadata  in Group', () => {
    container = new Container();
    registerGroups(container);
    const groups = container.getAll<any>(TYPE.Group);
    expect(groups.length).toBeGreaterThan(0);
    expect(true).toBe(true);
    build(yargs, container);
  });

  it('Build', () => {
    yargs.parse(['testGroup:aTestAction', 'someCmd']);
    expect(strResult).toBe('testGroup:aTestAction');
  });

  it('Create, command and options', () => {
    yargs.parse(['testGroup:bTestAction', 'cmd', '--exec_mode', 'testing']);
    expect(strResult).toBe('testGroup:bTestAction');
    expect(argv.exec_mode).toBe('testing');
  });

  it('Build', async () => {
    yargs.parse(['testGroup:bTestAction', 'cmd', '--exec_mode', 'testing']);
    expect(strResult).toBe('testGroup:bTestAction');
    expect(argv.exec_mode).toBe('testing');
  });
});
