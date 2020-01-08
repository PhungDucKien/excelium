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

import fs from 'fs-extra';

// https://stackoverflow.com/questions/29085197/how-do-you-json-stringify-an-es6-map
function replacer(this: any, key: string, value: any) {
  const originalObject = this[key];
  if (originalObject instanceof Map) {
    return {
      dataType: 'Map',
      value: Array.from(originalObject.entries()),
    };
  } else {
    return value;
  }
}

function reviver(this: any, _: string, value: any) {
  if (typeof value === 'object' && value !== null) {
    if (value.dataType === 'Map') {
      return new Map(value.value);
    }
  }
  return value;
}

/**
 * Provides functions for object marshalling.
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
export default class JsonMarshaller {
  /**
   * Unmarshal Json data from the specified file path and return the resulting
   * content tree.
   *
   * @param path  The file path to unmarshal Json data from
   * @return Unmarshalled object
   */
  public static async unmarshall(path: string): Promise<any> {
    const content = await fs.readFile(path, 'utf-8');
    return JSON.parse(content, reviver);
  }

  /**
   * Marshal the content tree into a file.
   *
   * @param object the content tree to be marshalled
   * @param path   The file path to marshal to
   */
  public static async marshall(object: any, path: string): Promise<void> {
    const content = JSON.stringify(object, replacer, 2);
    await fs.outputFile(path, content);
  }
}
