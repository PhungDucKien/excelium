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
import TemplateUtil from '../src/TemplateUtil';

/**
 * Tests for {@link TemplateUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
describe('test TemplateUtil', () => {
  test('get markups', () => {
    const markupList = TemplateUtil.getMarkups();
    expect(markupList.length).toBe(79);
  });

  test('get markup locations', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%SYSTEM_NAME%', 'configuration!A2');
    markupLocations.set('%SYSTEM_IDENTIFIER%', 'configuration!A3');
    markupLocations.set('%FUNCTION_NAME%', 'configuration!A4');
    markupLocations.set('%FUNCTION_IDENTIFIER%', 'config!A5');
    markupLocations.set('%BASE_URL%', 'config!A6');
    markupLocations.set('%MAPPING_ITEM_NAME%', 'mapping!A2');
    markupLocations.set('%MAPPING_ITEM_DESC%', 'map!A3');
    markupLocations.set('%ACTION_NAME%', 'action!A2');
    markupLocations.set('%ACTION_DESC%', 'act!A3');
    markupLocations.set('%DATA_NAME%', 'data!A2');
    markupLocations.set('%DATA_DESC%', 'dat!A3');
    markupLocations.set('%TEST_COMMAND%', 'test!A2');
    markupLocations.set('%TEST_NAME%', 'tes!A3');
    template.markupLocations = markupLocations;

    let predicateMarkupLocations = TemplateUtil.getMarkupLocations(template, s => s === '%TEST_NAME%');
    expect(predicateMarkupLocations.size).toBe(1);
    expect(predicateMarkupLocations.get('%TEST_NAME%')).toBe('tes!A3');

    predicateMarkupLocations = TemplateUtil.getMarkupLocations(template, () => true);
    expect(predicateMarkupLocations.size).toBe(13);

    predicateMarkupLocations = TemplateUtil.getMarkupLocations(template, () => false);
    expect(predicateMarkupLocations.size).toBe(0);
  });

  test('get configuration markup locations', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%SYSTEM_NAME%', 'configuration!A2');
    markupLocations.set('%SYSTEM_IDENTIFIER%', 'configuration!A3');
    markupLocations.set('%FUNCTION_NAME%', 'configuration!A4');
    markupLocations.set('%FUNCTION_IDENTIFIER%', 'config!A5');
    markupLocations.set('%BASE_URL%', 'config!A6');
    markupLocations.set('%MAPPING_ITEM_NAME%', 'mapping!A2');
    markupLocations.set('%MAPPING_ITEM_DESC%', 'map!A3');
    markupLocations.set('%ACTION_NAME%', 'action!A2');
    markupLocations.set('%ACTION_DESC%', 'act!A3');
    markupLocations.set('%DATA_NAME%', 'data!A2');
    markupLocations.set('%DATA_DESC%', 'dat!A3');
    markupLocations.set('%TEST_COMMAND%', 'test!A2');
    markupLocations.set('%TEST_NAME%', 'tes!A3');
    template.markupLocations = markupLocations;

    const configurationMarkupLocations = TemplateUtil.getConfigurationMarkupLocations(template);

    expect(configurationMarkupLocations.size).toBe(5);
    expect(configurationMarkupLocations.get('%SYSTEM_NAME%')).toBe('configuration!A2');
    expect(configurationMarkupLocations.get('%SYSTEM_IDENTIFIER%')).toBe('configuration!A3');
    expect(configurationMarkupLocations.get('%FUNCTION_NAME%')).toBe('configuration!A4');
    expect(configurationMarkupLocations.get('%FUNCTION_IDENTIFIER%')).toBe('config!A5');
    expect(configurationMarkupLocations.get('%BASE_URL%')).toBe('config!A6');
  });

  test('get configuration sheets', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%SYSTEM_NAME%', 'configuration!A2');
    markupLocations.set('%SYSTEM_IDENTIFIER%', 'configuration!A3');
    markupLocations.set('%FUNCTION_NAME%', 'configuration!A4');
    markupLocations.set('%FUNCTION_IDENTIFIER%', 'config!A5');
    markupLocations.set('%BASE_URL%', 'config!A6');
    markupLocations.set('%MAPPING_ITEM_NAME%', 'mapping!A2');
    markupLocations.set('%MAPPING_ITEM_DESC%', 'map!A3');
    markupLocations.set('%ACTION_NAME%', 'action!A2');
    markupLocations.set('%ACTION_DESC%', 'act!A3');
    markupLocations.set('%DATA_NAME%', 'data!A2');
    markupLocations.set('%DATA_DESC%', 'dat!A3');
    markupLocations.set('%TEST_COMMAND%', 'test!A2');
    markupLocations.set('%TEST_NAME%', 'tes!A3');
    template.markupLocations = markupLocations;

    const configurationSheets = TemplateUtil.getConfigurationSheets(template);

    expect(configurationSheets.length).toBe(2);
    expect(configurationSheets[0]).toBe('configuration');
    expect(configurationSheets[1]).toBe('config');
  });

  test('get suggest sheet for mapping', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%MAPPING_ITEM_NAME%', 'mapping!A2');
    markupLocations.set('%MAPPING_ITEM_DESC%', 'map!A3');
    template.markupLocations = markupLocations;

    expect(TemplateUtil.getSuggestSheetForMapping(template)).toBe('mapping');
  });

  test('get suggest sheet for action', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%ACTION_COMMAND%', 'action!A2');
    markupLocations.set('%ACTION_NAME%', 'act!A3');
    template.markupLocations = markupLocations;

    expect(TemplateUtil.getSuggestSheetForAction(template)).toBe('action');
  });

  test('GetSuggestSheetForData', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%DATA_NAME%', 'data!A2');
    markupLocations.set('%DATA_DESC%', 'dat!A3');
    template.markupLocations = markupLocations;

    expect(TemplateUtil.getSuggestSheetForData(template)).toBe('data');
  });

  test('GetSuggestSheetForTest', () => {
    const template = new Template();
    const markupLocations = new Map<string, string>();
    markupLocations.set('%TEST_COMMAND%', 'test!A2');
    markupLocations.set('%TEST_NAME%', 'tes!A3');
    template.markupLocations = markupLocations;

    expect(TemplateUtil.getSuggestSheetForTest(template)).toBe('test');
  });
});
