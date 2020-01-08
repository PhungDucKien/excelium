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

/**
 * Represents mode of test data writing.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
enum WriteMode {
  /**
   * Append write mode.
   * Inserts and updates records without effecting others.
   */
  APPEND,
  /**
   * Replace write mode.
   * Truncates the table before inserting records.
   */
  REPLACE,
  /**
   * Remove write mode.
   * Removes records without effecting others.
   */
  REMOVE,
  /**
   * Truncate write mode.
   * Truncates the table.
   */
  TRUNCATE,
}

namespace WriteMode {
  /**
   * From name write mode.
   *
   * @param name the name
   * @return the write mode
   */
  export function fromName(name: string): WriteMode {
    let writeMode = (WriteMode as any)[name.toUpperCase()];
    if (!writeMode) {
      writeMode = WriteMode.APPEND;
    }
    return writeMode;
  }
}

export default WriteMode;
