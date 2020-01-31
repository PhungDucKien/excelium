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

import { action, group } from '../../src/commander/decorator';
import {
  cleanUpMetadata,
  getActionsMetadata,
  getActionsPrototypeMetadata,
  getGroupMetadata,
  getGroupPrototypeMetadata,
  getGroupsMetadata,
} from '../../src/commander/lib';

describe('Decorators', () => {
  let groupInstance!: any;
  let TestGroup!: any;

  beforeEach(() => {
    cleanUpMetadata();

    @group({ name: 'test' })
    class TestGroupClass {
      @action({ name: 'test1' })
      public test1() {
        // Empty
      }

      @action({ name: 'test2' })
      public test2() {
        // Empty
      }
    }

    TestGroup = TestGroupClass;
    groupInstance = new TestGroup();
  });

  it('Group and action metadata  in Group', () => {
    const groupsMetadata = getGroupsMetadata();
    const groupMetadataA = groupsMetadata.find(o => o.name === 'test');
    expect(groupMetadataA!.name).toBe('test');

    let groupMetadataB = getGroupPrototypeMetadata(TestGroup);
    expect(groupMetadataB.name).toBe('test');
    expect(groupMetadataB.name).toBe(groupMetadataA!.name);

    let actionsMetadata = getActionsPrototypeMetadata(TestGroup);
    let test2MetaData = actionsMetadata.find(o => o.name === 'test2');
    expect(test2MetaData!.key).toBe('test2');

    // Instance.
    groupMetadataB = getGroupMetadata(groupInstance);
    expect(groupMetadataB.name).toBe('test');
    expect(groupMetadataB.name).toBe(groupMetadataA!.name);

    actionsMetadata = getActionsMetadata(groupInstance);
    test2MetaData = actionsMetadata.find(o => o.name === 'test2');
    expect(test2MetaData!.key).toBe('test2');
  });
});
