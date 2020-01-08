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
 * Represents type of browser.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
enum Browser {
  /**
   * Chrome browser.
   */
  CHROME = 'Chrome',
  /**
   * Firefox browser.
   */
  FIREFOX = 'Firefox',
  /**
   * The Ie.
   */
  IE = 'Internet Explorer',
  /**
   * The Edge.
   */
  EDGE = 'Microsoft Edge',
  /**
   * Safari browser.
   */
  SAFARI = 'Safari',
  /**
   * Opera browser.
   */
  OPERA = 'Opera',
  /**
   * Chromium browser.
   */
  CHROMIUM = 'Chromium',
  /**
   * Browser browser.
   */
  BROWSER = 'Browser',
}

namespace Browser {
  /**
   * From name browser.
   *
   * @param name the name
   * @return the browser
   */
  export function fromName(name: string): Browser {
    const browser = (Browser as any)[name.toUpperCase()];
    return browser;
  }

  /**
   * Get list choice.
   *
   * @return the list choice
   */
  export function getListChoice(): string[][] {
    const listChoice = [] as string[][];
    for (const key of Object.keys(Browser)) {
      const value = (Browser as any)[key];
      if (typeof value === 'string' || value instanceof String) {
        listChoice.push([key, value as string]);
      }
    }
    return listChoice;
  }
}

export default Browser;
