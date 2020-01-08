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
 * Represents type of application.
 *
 * @author PhungDucKien
 * @since 2018.03.26
 */
enum AppType {
  /**
   * The Web.
   */
  WEB = 'Web application',
  /**
   * The Mobile.
   */
  MOBILE = 'Mobile application',
}

namespace AppType {
  /**
   * From name app type.
   *
   * @param name the name
   * @return the app type
   */
  export function fromName(name: string): AppType {
    const appType = (AppType as any)[name.toUpperCase()];
    return appType;
  }

  /**
   * Get list choice.
   *
   * @return the list choice
   */
  export function getListChoice(): string[][] {
    const listChoice = [] as string[][];
    for (const key of Object.keys(AppType)) {
      const value = (AppType as any)[key];
      if (typeof value === 'string' || value instanceof String) {
        listChoice.push([key, value as string]);
      }
    }
    return listChoice;
  }
}

export default AppType;
