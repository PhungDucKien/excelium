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
 * Represents type of mobile locator.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
enum MobileLocatorType {
  /**
   * Accessibility id mobile locator type.
   */
  ACCESSIBILITY_ID = 'accessibility id',
  /**
   * Class mobile locator type.
   */
  CLASS = 'class',
  /**
   * Id mobile locator type.
   */
  ID = 'id',
  /**
   * Name mobile locator type.
   */
  NAME = 'name',
  /**
   * Xpath mobile locator type.
   */
  XPATH = 'xpath',
  /**
   * Android uiautomator mobile locator type.
   */
  ANDROID_UIAUTOMATOR = 'android uiautomator',
  /**
   * Android view tag mobile locator type.
   */
  ANDROID_VIEWTAG = 'android viewtag',
  /**
   * Android data matcher mobile locator type.
   */
  ANDROID_DATAMATCHER = 'android datamatcher',
  /**
   * iOS Predicate String mobile locator type.
   */
  IOS_PREDICATE_STRING = 'ios predicate string',
  /**
   * iOS Class Chain mobile locator type.
   */
  IOS_CLASS_CHAIN = 'ios class chain',
  /**
   * Windows uiautomation mobile locator type.
   */
  WINDOWS_UIAUTOMATION = 'windows uiautomation',
  /**
   * Reserved locator type for specifying index.
   */
  INDEX = 'index',
  /**
   * Variable web locator type.
   */
  VARIABLE = 'variable',
}

namespace MobileLocatorType {
  /**
   * From strategy mobile locator type.
   *
   * @param strategy the strategy
   * @return the mobile locator type
   */
  export function fromStrategy(strategy: string): MobileLocatorType {
    const mobileLocatorType = (MobileLocatorType as any)[strategy.replace(/\s/g, '_').toUpperCase()];
    return mobileLocatorType;
  }
}

export default MobileLocatorType;
