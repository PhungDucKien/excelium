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
 * Represents type of data source.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
enum DataSourceType {
  /**
   * MySQL
   */
  MYSQL = 'MySQL',
  /**
   * PostgreSQL
   */
  POSTGRESQL = 'PostgreSQL',
  /**
   * Amazon DynamoDB
   */
  DYNAMODB = 'Amazon DynamoDB',
}

namespace DataSourceType {
  /**
   * From name data source type.
   *
   * @param name the name
   * @return the data source type
   */
  export function fromName(name: string): DataSourceType {
    const dataSourceType = (DataSourceType as any)[name.toUpperCase()];
    return dataSourceType;
  }

  /**
   * Get list choice.
   *
   * @return the list choice
   */
  export function getListChoice(): string[][] {
    const listChoice = [] as string[][];
    for (const key of Object.keys(DataSourceType)) {
      const value = (DataSourceType as any)[key];
      if (typeof value === 'string' || value instanceof String) {
        listChoice.push([key, value as string]);
      }
    }
    return listChoice;
  }
}

export default DataSourceType;
