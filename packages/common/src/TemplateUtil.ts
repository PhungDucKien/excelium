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

import { Template } from '@excelium/model';
import CollectionUtil from './CollectionUtil';
import CellLocation from './ss/CellLocation';
import StringUtil from './StringUtil';

/**
 * Collection of template handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
export default class TemplateUtil {
  /**
   * Gets markup list.
   * The markups are defined in {@link Template} as public static strings.
   *
   * @return the markup list
   */
  public static getMarkups(): string[] {
    const values = [] as string[];
    const propertyNames = Object.getOwnPropertyNames(Template);
    if (CollectionUtil.isNotEmpty(propertyNames)) {
      for (const propertyName of propertyNames) {
        // @ts-ignore
        const propertyValue = Template[propertyName];
        if (propertyValue && (typeof propertyValue === 'string' || propertyValue instanceof String)) {
          if (/^\%.*\%$/.test(propertyValue as string)) {
            values.push(propertyValue as string);
          }
        }
      }
    }
    return values;
  }

  /**
   * Gets map of markups that match the given predicate and their locations.
   *
   * @param template  the template
   * @param predicate the markup predicate
   * @return the map of markups and their locations
   */
  public static getMarkupLocations(template: Template, predicate: (markup: string) => boolean): Map<string, string> {
    if (template.markupLocations == null) {
      return new Map<string, string>();
    }
    const markupLocations = new Map<string, string>();
    template.markupLocations.forEach((location, markup) => {
      if (predicate(markup)) {
        if (StringUtil.isNotBlank(location)) {
          markupLocations.set(markup, location);
        }
      }
    });
    return markupLocations;
  }

  /**
   * Gets map of configuration markups and their locations.
   *
   * @param template the template
   * @return the map of configuration markups and their locations
   */
  public static getConfigurationMarkupLocations(template: Template): Map<string, string> {
    return this.getMarkupLocations(template, s => !StringUtil.startsWithAny(s, ['%MAPPING_', '%ACTION_', '%TEST_', '%DATA_']));
  }

  /**
   * Get the names of configuration sheets.
   * This method lists up all the sheets that contain configuration items.
   *
   * @param template Template
   * @return The names of configuration sheets
   */
  public static getConfigurationSheets(template: Template): string[] {
    const configurationSheets = [] as string[];
    const configurationMarkupLocations = this.getConfigurationMarkupLocations(template);
    configurationMarkupLocations.forEach(location => {
      const cellLocation = new CellLocation({ cellRef: location });
      const sheet = cellLocation.getSheetName();

      if (sheet && configurationSheets.indexOf(sheet) === -1) {
        configurationSheets.push(sheet);
      }
    });
    return configurationSheets;
  }

  /**
   * Get the suggestion for the name of mapping sheet.
   *
   * @param template Template
   * @return The suggestion of the mapping sheet
   */
  public static getSuggestSheetForMapping(template: Template): string | null {
    const mappingItemNameLoc = template.markupLocations.get(Template.MAPPING_ITEM_NAME);
    if (mappingItemNameLoc && StringUtil.isNotBlank(mappingItemNameLoc)) {
      const cellLocation = new CellLocation({ cellRef: mappingItemNameLoc });
      return cellLocation.getSheetName();
    }
    return null;
  }

  /**
   * Get the suggestion for the name of action sheet.
   *
   * @param template Template
   * @return The suggestion of the action sheet
   */
  public static getSuggestSheetForAction(template: Template): string | null {
    const actionNameLoc = template.markupLocations.get(Template.ACTION_COMMAND);
    if (actionNameLoc && StringUtil.isNotBlank(actionNameLoc)) {
      const cellLocation = new CellLocation({ cellRef: actionNameLoc });
      return cellLocation.getSheetName();
    }
    return null;
  }

  /**
   * Get the suggestion for the name of data sheet.
   *
   * @param template Template
   * @return The suggestion of the data sheet
   */
  public static getSuggestSheetForData(template: Template): string | null {
    const dataNameLoc = template.markupLocations.get(Template.DATA_NAME);
    if (dataNameLoc && StringUtil.isNotBlank(dataNameLoc)) {
      const cellLocation = new CellLocation({ cellRef: dataNameLoc });
      return cellLocation.getSheetName();
    }
    return null;
  }

  /**
   * Get the suggestion for the name of test sheet.
   *
   * @param template Template
   * @return The suggestion of the test sheet
   */
  public static getSuggestSheetForTest(template: Template): string | null {
    const testCommandLoc = template.markupLocations.get(Template.TEST_COMMAND);
    if (testCommandLoc && StringUtil.isNotBlank(testCommandLoc)) {
      const cellLocation = new CellLocation({ cellRef: testCommandLoc });
      return cellLocation.getSheetName();
    }
    return null;
  }
}
