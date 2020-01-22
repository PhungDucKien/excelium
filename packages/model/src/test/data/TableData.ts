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

import WriteMode from '../../enums/WriteMode';
import Column from './Column';

/**
 * Represents table data model.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
export default class TableData {
  /**
   * Table name
   */
  public name: string;

  /**
   * Write mode
   */
  public mode: WriteMode;

  /**
   * List of primary keys
   */
  public primaryKeys: string[];

  /**
   * List of columns
   */
  public columns: Column[];

  /**
   * Row data
   */
  public rowData: Array<Map<string, any>>;
}