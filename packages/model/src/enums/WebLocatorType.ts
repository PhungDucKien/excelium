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
 * Represents type of web locator.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
enum WebLocatorType {
  /**
   * Id web locator type.
   */
  ID = 'id',
  /**
   * Link web locator type.
   */
  LINK = 'link',
  /**
   * Partial Link web locator type.
   */
  PARTIAL_LINK = 'partial link',
  /**
   * Tag web locator type.
   */
  TAG = 'tag',
  /**
   * Name web locator type.
   */
  NAME = 'name',
  /**
   * Class web locator type.
   */
  CLASS = 'class',
  /**
   * Css web locator type.
   */
  CSS = 'css',
  /**
   * Xpath web locator type.
   */
  XPATH = 'xpath',
  /**
   * Identifier web locator type.
   */
  IDENTIFIER = 'identifier',
  /**
   * Alt web locator type.
   */
  ALT = 'alt',
  /**
   * Dom web locator type.
   */
  DOM = 'dom',
  /**
   * Reserved locator type for specifying index.
   */
  INDEX = 'index',
  /**
   * Variable web locator type.
   */
  VARIABLE = 'variable',
}

namespace WebLocatorType {
  /**
   * From strategy web locator type.
   *
   * @param strategy the strategy
   * @return the web locator type
   */
  export function fromStrategy(strategy: string): WebLocatorType {
    const webLocatorType = (WebLocatorType as any)[strategy.replace(/\s/g, '_').toUpperCase()];
    return webLocatorType;
  }
}

export default WebLocatorType;
