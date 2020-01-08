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
 * Represents template model.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
export default class Template {
  public static readonly ALL: string = 'ALL';

  /**
   * The constant BASE_URL.
   */
  public static readonly BASE_URL: string = '%BASE_URL%';

  /**
   * The constant USE_PC.
   */
  public static readonly USE_PC: string = '%USE_PC%';
  /**
   * The constant USE_ANDROID.
   */
  public static readonly USE_ANDROID: string = '%USE_ANDROID%';
  /**
   * The constant USE_IOS.
   */
  public static readonly USE_IOS: string = '%USE_IOS%';

  /**
   * The constant USE_CHROME.
   */
  public static readonly USE_CHROME: string = '%USE_CHROME%';
  /**
   * The constant USE_FIREFOX.
   */
  public static readonly USE_FIREFOX: string = '%USE_FIREFOX%';
  /**
   * The constant USE_IE.
   */
  public static readonly USE_IE: string = '%USE_IE%';
  /**
   * The constant USE_EDGE.
   */
  public static readonly USE_EDGE: string = '%USE_EDGE%';
  /**
   * The constant USE_SAFARI.
   */
  public static readonly USE_SAFARI: string = '%USE_SAFARI%';
  /**
   * The constant USE_OPERA.
   */
  public static readonly USE_OPERA: string = '%USE_OPERA%';

  /**
   * The constant CHROME_VERSION.
   */
  public static readonly CHROME_VERSION: string = '%CHROME_VERSION%';
  /**
   * The constant FIREFOX_VERSION.
   */
  public static readonly FIREFOX_VERSION: string = '%FIREFOX_VERSION%';
  /**
   * The constant IE_VERSION.
   */
  public static readonly IE_VERSION: string = '%IE_VERSION%';
  /**
   * The constant EDGE_VERSION.
   */
  public static readonly EDGE_VERSION: string = '%EDGE_VERSION%';
  /**
   * The constant SAFARI_VERSION.
   */
  public static readonly SAFARI_VERSION: string = '%SAFARI_VERSION%';
  /**
   * The constant OPERA_VERSION.
   */
  public static readonly OPERA_VERSION: string = '%OPERA_VERSION%';

  /**
   * The constant CHROME_RESOLUTION.
   */
  public static readonly CHROME_RESOLUTION: string = '%CHROME_RESOLUTION%';
  /**
   * The constant FIREFOX_RESOLUTION.
   */
  public static readonly FIREFOX_RESOLUTION: string = '%FIREFOX_RESOLUTION%';
  /**
   * The constant IE_RESOLUTION.
   */
  public static readonly IE_RESOLUTION: string = '%IE_RESOLUTION%';
  /**
   * The constant EDGE_RESOLUTION.
   */
  public static readonly EDGE_RESOLUTION: string = '%EDGE_RESOLUTION%';
  /**
   * The constant SAFARI_RESOLUTION.
   */
  public static readonly SAFARI_RESOLUTION: string = '%SAFARI_RESOLUTION%';
  /**
   * The constant OPERA_RESOLUTION.
   */
  public static readonly OPERA_RESOLUTION: string = '%OPERA_RESOLUTION%';

  /**
   * The constant ANDROID_PLATFORM_VERSION.
   */
  public static readonly ANDROID_PLATFORM_VERSION: string = '%ANDROID_PLATFORM_VERSION%';
  /**
   * The constant ANDROID_DEVICE_NAME.
   */
  public static readonly ANDROID_DEVICE_NAME: string = '%ANDROID_DEVICE_NAME%';
  /**
   * The constant ANDROID_ORIENTATION.
   */
  public static readonly ANDROID_ORIENTATION: string = '%ANDROID_ORIENTATION%';
  /**
   * The constant ANDROID_UDID.
   */
  public static readonly ANDROID_UDID: string = '%ANDROID_UDID%';
  /**
   * The constant ANDROID_BROWSER.
   */
  public static readonly ANDROID_BROWSER: string = '%ANDROID_BROWSER%';
  /**
   * The constant ANDROID_APP.
   */
  public static readonly ANDROID_APP: string = '%ANDROID_APP%';
  /**
   * The constant ANDROID_APP_ACTIVITY.
   */
  public static readonly ANDROID_APP_ACTIVITY: string = '%ANDROID_APP_ACTIVITY%';
  /**
   * The constant ANDROID_APP_PACKAGE.
   */
  public static readonly ANDROID_APP_PACKAGE: string = '%ANDROID_APP_PACKAGE%';
  /**
   * The constant ANDROID_APP_WAIT_ACTIVITY.
   */
  public static readonly ANDROID_APP_WAIT_ACTIVITY: string = '%ANDROID_APP_WAIT_ACTIVITY%';
  /**
   * The constant ANDROID_APP_WAIT_PACKAGE.
   */
  public static readonly ANDROID_APP_WAIT_PACKAGE: string = '%ANDROID_APP_WAIT_PACKAGE%';

  /**
   * The constant IOS_PLATFORM_VERSION.
   */
  public static readonly IOS_PLATFORM_VERSION: string = '%IOS_PLATFORM_VERSION%';
  /**
   * The constant IOS_DEVICE_NAME.
   */
  public static readonly IOS_DEVICE_NAME: string = '%IOS_DEVICE_NAME%';
  /**
   * The constant IOS_ORIENTATION.
   */
  public static readonly IOS_ORIENTATION: string = '%IOS_ORIENTATION%';
  /**
   * The constant IOS_UDID.
   */
  public static readonly IOS_UDID: string = '%IOS_UDID%';
  /**
   * The constant IOS_BROWSER.
   */
  public static readonly IOS_BROWSER: string = '%IOS_BROWSER%';
  /**
   * The constant IOS_APP.
   */
  public static readonly IOS_APP: string = '%IOS_APP%';
  /**
   * The constant IOS_BUNDLE_ID.
   */
  public static readonly IOS_BUNDLE_ID: string = '%IOS_BUNDLE_ID%';

  /**
   * The constant MAPPING_PAGESET_NAME.
   */
  public static readonly MAPPING_PAGESET_NAME: string = '%MAPPING_PAGESET_NAME%';
  /**
   * The constant MAPPING_PAGESET_DESC.
   */
  public static readonly MAPPING_PAGESET_DESC: string = '%MAPPING_PAGESET_DESC%';
  /**
   * The constant MAPPING_PAGESET_PATH.
   */
  public static readonly MAPPING_PAGESET_PATH: string = '%MAPPING_PAGESET_PATH%';
  /**
   * The constant MAPPING_PAGESET_TITLE.
   */
  public static readonly MAPPING_PAGESET_TITLE: string = '%MAPPING_PAGESET_TITLE%';

  /**
   * The constant MAPPING_ITEM_NAME.
   */
  public static readonly MAPPING_ITEM_NAME: string = '%MAPPING_ITEM_NAME%';
  /**
   * The constant MAPPING_ITEM_DESC.
   */
  public static readonly MAPPING_ITEM_DESC: string = '%MAPPING_ITEM_DESC%';
  /**
   * The constant MAPPING_ITEM_VALUE.
   */
  public static readonly MAPPING_ITEM_VALUE: string = '%MAPPING_ITEM_VALUE%';
  /**
   * The constant MAPPING_ITEM_ANDROID_VALUE.
   */
  public static readonly MAPPING_ITEM_ANDROID_VALUE: string = '%MAPPING_ITEM_ANDROID_VALUE%';
  /**
   * The constant MAPPING_ITEM_IOS_VALUE.
   */
  public static readonly MAPPING_ITEM_IOS_VALUE: string = '%MAPPING_ITEM_IOS_VALUE%';

  /**
   * The constant ACTION_NO.
   */
  public static readonly ACTION_NO: string = '%ACTION_NO%';
  /**
   * The constant ACTION_GUTTER.
   */
  public static readonly ACTION_GUTTER: string = '%ACTION_GUTTER%';
  /**
   * The constant ACTION_ANDROID_GUTTER.
   */
  public static readonly ACTION_ANDROID_GUTTER: string = '%ACTION_ANDROID_GUTTER%';
  /**
   * The constant ACTION_IOS_GUTTER.
   */
  public static readonly ACTION_IOS_GUTTER: string = '%ACTION_IOS_GUTTER%';
  /**
   * The constant ACTION_CAPTURE.
   */
  public static readonly ACTION_CAPTURE: string = '%ACTION_CAPTURE%';
  /**
   * The constant ACTION_NAME.
   */
  public static readonly ACTION_NAME: string = '%ACTION_NAME%';
  /**
   * The constant ACTION_DESC.
   */
  public static readonly ACTION_DESC: string = '%ACTION_DESC%';
  /**
   * The constant ACTION_COMMAND.
   */
  public static readonly ACTION_COMMAND: string = '%ACTION_COMMAND%';
  /**
   * The constant ACTION_PARAM1.
   */
  public static readonly ACTION_PARAM1: string = '%ACTION_PARAM1%';
  /**
   * The constant ACTION_PARAM2.
   */
  public static readonly ACTION_PARAM2: string = '%ACTION_PARAM2%';
  /**
   * The constant ACTION_PARAM3.
   */
  public static readonly ACTION_PARAM3: string = '%ACTION_PARAM3%';
  /**
   * The constant ACTION_DATA.
   */
  public static readonly ACTION_DATA: string = '%ACTION_DATA%';

  /**
   * The constant TEST_NO.
   */
  public static readonly TEST_NO: string = '%TEST_NO%';
  /**
   * The constant TEST_GUTTER.
   */
  public static readonly TEST_GUTTER: string = '%TEST_GUTTER%';
  /**
   * The constant TEST_ANDROID_GUTTER.
   */
  public static readonly TEST_ANDROID_GUTTER: string = '%TEST_ANDROID_GUTTER%';
  /**
   * The constant TEST_IOS_GUTTER.
   */
  public static readonly TEST_IOS_GUTTER: string = '%TEST_IOS_GUTTER%';
  /**
   * The constant TEST_CAPTURE.
   */
  public static readonly TEST_CAPTURE: string = '%TEST_CAPTURE%';
  /**
   * The constant TEST_NAME.
   */
  public static readonly TEST_NAME: string = '%TEST_NAME%';
  /**
   * The constant TEST_DESC.
   */
  public static readonly TEST_DESC: string = '%TEST_DESC%';
  /**
   * The constant TEST_COMMAND.
   */
  public static readonly TEST_COMMAND: string = '%TEST_COMMAND%';
  /**
   * The constant TEST_PARAM1.
   */
  public static readonly TEST_PARAM1: string = '%TEST_PARAM1%';
  /**
   * The constant TEST_PARAM2.
   */
  public static readonly TEST_PARAM2: string = '%TEST_PARAM2%';
  /**
   * The constant TEST_PARAM3.
   */
  public static readonly TEST_PARAM3: string = '%TEST_PARAM3%';
  /**
   * The constant TEST_DATA.
   */
  public static readonly TEST_DATA: string = '%TEST_DATA%';
  /**
   * The constant TEST_DATE.
   */
  public static readonly TEST_DATE: string = '%TEST_DATE%';
  /**
   * The constant TEST_PERSON.
   */
  public static readonly TEST_PERSON: string = '%TEST_PERSON%';
  /**
   * The constant TEST_RESULT.
   */
  public static readonly TEST_RESULT: string = '%TEST_RESULT%';

  /**
   * The constant DATA_NAME.
   */
  public static readonly DATA_NAME: string = '%DATA_NAME%';
  /**
   * The constant DATA_DESC.
   */
  public static readonly DATA_DESC: string = '%DATA_DESC%';
  /**
   * The constant DATA_TABLE_DEF.
   */
  public static readonly DATA_TABLE_DEF: string = '%DATA_TABLE_DEF%';
  /**
   * The constant DATA_TABLE_DATA.
   */
  public static readonly DATA_TABLE_DATA: string = '%DATA_TABLE_DATA%';

  /**
   * Template location. File path or spreadsheet ID
   */
  public location: string;

  /**
   * Template name
   */
  public name: string;

  /**
   * Markup locations. This store a map of markup and its location in the template.
   */
  public markupLocations: Map<string, string>;

  /**
   * Pattern for name of sheets that should be considered as mapping item sheets.
   */
  public mappingPattern: string;

  /**
   * Pattern for name of sheets that should be considered as action sheets.
   */
  public actionPattern: string;

  /**
   * Pattern for name of sheets that should be considered as data sheets.
   */
  public dataPattern: string;

  /**
   * Pattern for name of sheets that should be considered as test sheets.
   */
  public testPattern: string;

  /**
   * Pattern for name of sheets that should be ignored.
   */
  public ignorePatterns: string[];

  /**
   * Add ignore pattern.
   *
   * @param ignorePattern the ignore pattern
   */
  public addIgnorePattern(ignorePattern: string) {
    if (this.ignorePatterns == null) {
      this.ignorePatterns = [];
    }
    this.ignorePatterns.push(ignorePattern);
  }
}
