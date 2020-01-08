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

import DataSourceType from '../../src/enums/DataSourceType';

/**
 * Tests for {@link DataSourceType}.
 *
 * @author PhungDucKien
 * @since 2018.05.26
 */
describe('test DataSourceType', () => {
  test('from name', () => {
    expect(DataSourceType.fromName('MySQL')).toBe(DataSourceType.MYSQL);
    expect(DataSourceType.fromName('PostgreSQL')).toBe(DataSourceType.POSTGRESQL);
    expect(DataSourceType.fromName('DynamoDB')).toBe(DataSourceType.DYNAMODB);
  });

  test('get list choice', () => {
    const listChoice = DataSourceType.getListChoice();
    expect(listChoice.length).toBe(3);
    expect(listChoice[0][0]).toBe('MYSQL');
    expect(listChoice[0][1]).toBe('MySQL');
    expect(listChoice[1][0]).toBe('POSTGRESQL');
    expect(listChoice[1][1]).toBe('PostgreSQL');
    expect(listChoice[2][0]).toBe('DYNAMODB');
    expect(listChoice[2][1]).toBe('Amazon DynamoDB');
  });
});
