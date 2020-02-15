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

import {
  CellLocation,
  CollectionUtil,
  EnvironmentUtil,
  ObjectUtil,
  PlatformDetector,
  Prompt,
  StringUtil,
  TemplateUtil,
  WildcardUtil,
} from '@excelium/common';
import {
  Browser,
  Column,
  Environment,
  Item,
  PageSet,
  PcEnvironment,
  Platform,
  TableData,
  Template,
  Test,
  TestAction,
  TestCase,
  TestConfig,
  TestData,
  TestFile,
  TestFilter,
  TestFlow,
  TestStep,
  TestSuite,
  WriteMode,
} from '@excelium/model';
import _ from 'lodash';
import TestWriter from '../writer/TestWriter';
import AbstractWorkbookReader from './AbstractWorkbookReader';
import TestReader from './TestReader';

/**
 * An inner class that stores locations of data item in a table.
 */
export class DataLocation {
  /**
   * Column name
   */
  public column: string;

  /**
   * Row index
   */
  public row: number;

  /**
   * Instantiates a new Data location.
   *
   * @param column the column
   * @param row    the row
   */
  constructor(column: string, row: number) {
    this.column = column;
    this.row = row;
  }
}

/**
 * Abstract test reader that implements {@link TestReader}.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.23
 */
export default abstract class AbstractTestReader<W, S> extends AbstractWorkbookReader<W, S> implements TestReader<W, S> {
  public async parseTest(template: Template, workbook: W, testFilter?: TestFilter, testWriter?: TestWriter): Promise<Test> {
    const test = new Test();
    test.workbookName = this.getWorkbookName(workbook);
    await this.innerParseTest(test, template, workbook, testFilter, testWriter);
    return test;
  }

  /**
   * Returns consecutive sub-lists of column cell values, each of the same size
   * (the final list may be smaller).
   * The returned sub-lists have the same key as the source column cell values.
   *
   * @param columnCellValues Map of column cell values. The key of the return map is column location.
   * @param dataHeight       the desired size of each sublist (the last may be smaller)
   * @return a list of consecutive sublists
   */
  public partitionColumnCellValues(columnCellValues: Map<string, any[]>, dataHeight: number): Array<Map<string, any[]>> {
    const partitioned = new Array<Map<string, any[]>>();
    columnCellValues.forEach((columnValues, column) => {
      const partitionColumnValues = _.chunk(columnValues, dataHeight);
      let i = 0;
      for (const partitionColumnValue of partitionColumnValues) {
        let map;
        if (i < partitioned.length) {
          map = partitioned[i];
        } else {
          map = new Map<string, any[]>();
          partitioned.push(map);
        }
        map.set(column, partitionColumnValue);
        i++;
      }
    });
    return partitioned;
  }

  /**
   * Returns list of map of markups and their values from partitioned column cell values
   * and the markup data locations.
   * The markup data locations is a map that maps a markup with its location in the data window.
   *
   * @param columnCellValues the partitioned list of map of column values
   * @param dataLocations    the map of data locations
   * @return the list of item data
   */
  public getItemListByColumnCellValues(
    columnCellValues: Array<Map<string, any[]>>,
    dataLocations: Map<string, DataLocation>
  ): Array<Map<string, any>> {
    const itemDataList = new Array<Map<string, any>>();
    for (const columnValues of columnCellValues) {
      const itemData = new Map<string, any>();
      dataLocations.forEach((location, key) => {
        const columnValue = columnValues.get(location.column);
        if (columnValue && CollectionUtil.isNotEmpty(columnValue) && columnValue.length > location.row) {
          const object = columnValue[location.row];
          itemData.set(key, object);
        }
      });
      itemDataList.push(itemData);
    }
    return itemDataList;
  }

  /**
   * Parses test file.
   *
   * @param test       Test object
   * @param template   Template object
   * @param workbook   Workbook object
   * @param testFilter Test filter
   * @param testWriter Test writer
   */
  private async innerParseTest(test: Test, template: Template, workbook: W, testFilter?: TestFilter, testWriter?: TestWriter): Promise<any> {
    const sheets = this.listSheets(workbook);

    const configurationSheets = this.filterSheets(sheets, TemplateUtil.getConfigurationSheets(template));
    _.pullAll(sheets, configurationSheets);

    const ignoreSheets = this.filterSheets(sheets, template.ignorePatterns);
    _.pullAll(sheets, ignoreSheets);

    const mappingSheets = this.filterSheet(sheets, template.mappingPattern);
    _.pullAll(sheets, mappingSheets);

    const dataSheets = this.filterSheet(sheets, template.dataPattern);
    _.pullAll(sheets, dataSheets);

    const actionSheets = this.filterSheet(sheets, template.actionPattern);
    _.pullAll(sheets, actionSheets);

    let testSheets = this.filterSheet(sheets, template.testPattern);
    if (testFilter && testFilter.workbook && testFilter.workbook !== TestFile.ALL) {
      if (StringUtil.isBlank(testFilter.sheet)) {
        const listChoice = [] as string[][];
        for (const sheet of testSheets) {
          const sheetName = this.getSheetName(sheet);
          listChoice.push([sheetName, sheetName]);
        }
        listChoice.push([TestSuite.ALL, 'All sheets']);

        const runSheet = await Prompt.promptList('Choose the test sheet to run:', listChoice);
        testFilter.sheet = runSheet;
      }

      if (testFilter.sheet && testFilter.sheet !== TestSuite.ALL) {
        testSheets = this.filterSheet(testSheets, testFilter.sheet);

        if (StringUtil.isBlank(testFilter.testCase)) {
          const runTestCase = await Prompt.promptInput('Input the test number to run (leave empty to run all):', TestCase.ALL);
          testFilter.testCase = runTestCase;
        }
      }
    }

    return Promise.all([
      this.setTestConfig(test, template, workbook),
      this.setPageSets(test, template, mappingSheets, workbook),
      this.setActions(test, template, actionSheets, workbook, testWriter),
      this.setData(test, template, dataSheets, workbook),
      this.setTestSuites(test, template, testSheets, workbook, testFilter, testWriter),
    ]);
  }

  /**
   * Sets test configuration.
   *
   * @param test     Test
   * @param template Template
   * @param workbook Workbook object
   */
  private async setTestConfig(test: Test, template: Template, workbook: W): Promise<void> {
    const markupLocations = TemplateUtil.getConfigurationMarkupLocations(template);
    const values = await this.getMarkupValues(markupLocations, workbook);

    const baseUrl = ObjectUtil.getStringValue(values.get(Template.BASE_URL));
    const environments = this.getEnvironments(values);

    const testConfig = new TestConfig();
    testConfig.baseUrl = baseUrl;
    testConfig.environments = environments;

    test.config = testConfig;
  }

  /**
   * Gets environment list.
   *
   * @param configurationValues Configuration values
   * @return Environment list
   */
  private getEnvironments(configurationValues: Map<string, any>): Environment[] {
    const baseUrl = ObjectUtil.getStringValue(configurationValues.get(Template.BASE_URL));

    const pcEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_PC));
    const androidEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_ANDROID));
    const iOsEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_IOS));

    // PC Configurations
    const chromeEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_CHROME));
    const firefoxEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_FIREFOX));
    const ieEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_IE));
    const edgeEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_EDGE));
    const safariEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_SAFARI));
    const operaEnabled = ObjectUtil.getBooleanValue(configurationValues.get(Template.USE_OPERA));

    const chromeVersions = ObjectUtil.getListValue(configurationValues.get(Template.CHROME_VERSION));
    const firefoxVersions = ObjectUtil.getListValue(configurationValues.get(Template.FIREFOX_VERSION));
    const ieVersions = ObjectUtil.getListValue(configurationValues.get(Template.IE_VERSION));
    const edgeVersions = ObjectUtil.getListValue(configurationValues.get(Template.EDGE_VERSION));
    const safariVersions = ObjectUtil.getListValue(configurationValues.get(Template.SAFARI_VERSION));
    const operaVersions = ObjectUtil.getListValue(configurationValues.get(Template.OPERA_VERSION));

    const chromeResolutions = ObjectUtil.getListValue(configurationValues.get(Template.CHROME_RESOLUTION));
    const firefoxResolutions = ObjectUtil.getListValue(configurationValues.get(Template.FIREFOX_RESOLUTION));
    const ieResolutions = ObjectUtil.getListValue(configurationValues.get(Template.IE_RESOLUTION));
    const edgeResolutions = ObjectUtil.getListValue(configurationValues.get(Template.EDGE_RESOLUTION));
    const safariResolutions = ObjectUtil.getListValue(configurationValues.get(Template.SAFARI_RESOLUTION));
    const operaResolutions = ObjectUtil.getListValue(configurationValues.get(Template.OPERA_RESOLUTION));

    // Mobile Configurations
    const androidVersions = ObjectUtil.getListValue(configurationValues.get(Template.ANDROID_PLATFORM_VERSION));
    const iOsVersions = ObjectUtil.getListValue(configurationValues.get(Template.IOS_PLATFORM_VERSION));
    const androidDevices = ObjectUtil.getListValue(configurationValues.get(Template.ANDROID_DEVICE_NAME));
    const iOsDevices = ObjectUtil.getListValue(configurationValues.get(Template.IOS_DEVICE_NAME));
    const androidOrientations = ObjectUtil.getListValue(configurationValues.get(Template.ANDROID_ORIENTATION));
    const iOsOrientations = ObjectUtil.getListValue(configurationValues.get(Template.IOS_ORIENTATION));
    const androidUdid = ObjectUtil.getStringValue(configurationValues.get(Template.ANDROID_UDID));
    const iOsUdid = ObjectUtil.getStringValue(configurationValues.get(Template.IOS_UDID));

    // Mobile web configurations
    const androidBrowsers = ObjectUtil.getListValue(configurationValues.get(Template.ANDROID_BROWSER));
    const iOsBrowsers = ObjectUtil.getListValue(configurationValues.get(Template.IOS_BROWSER));

    // Mobile app configurations
    const androidApkPath = ObjectUtil.getStringValue(configurationValues.get(Template.ANDROID_APP));
    const iOsIpaPath = ObjectUtil.getStringValue(configurationValues.get(Template.IOS_APP));
    const androidAppActivity = ObjectUtil.getStringValue(configurationValues.get(Template.ANDROID_APP_ACTIVITY));
    const androidAppPackage = ObjectUtil.getStringValue(configurationValues.get(Template.ANDROID_APP_PACKAGE));
    const androidAppWaitActivity = ObjectUtil.getStringValue(configurationValues.get(Template.ANDROID_APP_WAIT_ACTIVITY));
    const androidAppWaitPackage = ObjectUtil.getStringValue(configurationValues.get(Template.ANDROID_APP_WAIT_PACKAGE));
    const bundleId = ObjectUtil.getStringValue(configurationValues.get(Template.IOS_BUNDLE_ID));

    let environments = [] as Environment[];
    if (pcEnabled) {
      if (chromeEnabled) {
        environments = _.concat(environments, EnvironmentUtil.getAvailablePcEnvironments(Browser.CHROME, chromeVersions, chromeResolutions, baseUrl));
      }
      if (firefoxEnabled) {
        environments = _.concat(
          environments,
          EnvironmentUtil.getAvailablePcEnvironments(Browser.FIREFOX, firefoxVersions, firefoxResolutions, baseUrl)
        );
      }
      if (ieEnabled) {
        environments = _.concat(environments, EnvironmentUtil.getAvailablePcEnvironments(Browser.IE, ieVersions, ieResolutions, baseUrl));
      }
      if (edgeEnabled) {
        environments = _.concat(environments, EnvironmentUtil.getAvailablePcEnvironments(Browser.EDGE, edgeVersions, edgeResolutions, baseUrl));
      }
      if (safariEnabled) {
        environments = _.concat(environments, EnvironmentUtil.getAvailablePcEnvironments(Browser.SAFARI, safariVersions, safariResolutions, baseUrl));
      }
      if (operaEnabled) {
        environments = _.concat(environments, EnvironmentUtil.getAvailablePcEnvironments(Browser.OPERA, operaVersions, operaResolutions, baseUrl));
      }
    }

    if (androidEnabled) {
      if (CollectionUtil.isEmpty(androidBrowsers)) {
        environments = _.concat(
          environments,
          EnvironmentUtil.getAvailableMobileAppEnvironments(
            Platform.ANDROID,
            androidVersions,
            androidDevices,
            androidOrientations,
            androidUdid,
            androidApkPath,
            androidAppActivity,
            androidAppPackage,
            androidAppWaitActivity,
            androidAppWaitPackage,
            null
          )
        );
      } else {
        environments = _.concat(
          environments,
          EnvironmentUtil.getAvailableMobileWebEnvironments(
            Platform.ANDROID,
            androidVersions,
            androidDevices,
            androidOrientations,
            androidUdid,
            androidBrowsers,
            baseUrl
          )
        );
      }
    }

    if (iOsEnabled) {
      if (CollectionUtil.isEmpty(iOsBrowsers)) {
        environments = _.concat(
          environments,
          EnvironmentUtil.getAvailableMobileAppEnvironments(
            Platform.IOS,
            iOsVersions,
            iOsDevices,
            iOsOrientations,
            iOsUdid,
            iOsIpaPath,
            null,
            null,
            null,
            null,
            bundleId
          )
        );
      } else {
        environments = _.concat(
          environments,
          EnvironmentUtil.getAvailableMobileWebEnvironments(Platform.IOS, iOsVersions, iOsDevices, iOsOrientations, iOsUdid, iOsBrowsers, baseUrl)
        );
      }
    }

    if (CollectionUtil.isEmpty(environments)) {
      const environment = new PcEnvironment();
      environment.platform = PlatformDetector.getPlatform();
      environment.browser = Browser.CHROME;
      environment.browserVersion = '';
      environment.resolution = '1024x768';
      environments.push(environment);
    }

    return environments;
  }

  /**
   * Sets page sets.
   *
   * @param test     Test
   * @param template Template
   * @param sheets   List of sheets
   * @param workbook Workbook object
   */
  private async setPageSets(test: Test, template: Template, sheets: S[], workbook: W): Promise<void> {
    const pageSets = new Map<string | null, PageSet>();
    for (const sheet of sheets) {
      const sheetPageSets = await this.getPageSets(template, sheet, workbook);
      sheetPageSets.forEach((sheetPageSet, key) => {
        const pageSet = pageSets.get(key);
        if (pageSet) {
          const items = pageSet.items;
          const sheetItems = sheetPageSet.items;
          pageSet.items = new Map<string, Item>([...items, ...sheetItems]);
        } else {
          pageSets.set(key, sheetPageSet);
        }
      });
    }
    test.pageSets = pageSets;
  }

  /**
   * Gets page sets of a given sheet.
   *
   * @param template Template
   * @param sheet    Sheet
   * @param workbook Workbook object
   * @return Page sets of the sheet
   */
  private async getPageSets(template: Template, sheet: S, workbook: W): Promise<Map<string | null, PageSet>> {
    const markupLocations = TemplateUtil.getMarkupLocations(template, s => s.startsWith('%MAPPING_'));
    const tableValues = await this.getTableMarkupValues(markupLocations, this.getSheetName(sheet), workbook);

    const pageSetMap = new Map<string | null, PageSet>();
    let lastPageSetName: string | null = null;
    for (const itemValues of tableValues) {
      const itemName = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_ITEM_NAME));
      if (!itemName || StringUtil.isBlank(itemName)) {
        continue;
      }

      const itemDesc = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_ITEM_DESC));
      const itemValue = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_ITEM_VALUE));
      const itemAndroidValue = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_ITEM_ANDROID_VALUE));
      const itemIosValue = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_ITEM_IOS_VALUE));

      let pageSetName = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_PAGESET_NAME));
      const pageSetDesc = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_PAGESET_DESC));
      const pageSetPath = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_PAGESET_PATH));
      const pageSetTitle = ObjectUtil.getStringValue(itemValues.get(Template.MAPPING_PAGESET_TITLE));

      const item = new Item();
      item.name = itemName;
      item.description = itemDesc;
      item.value = itemValue;
      item.androidValue = itemAndroidValue;
      item.iosValue = itemIosValue;

      if (StringUtil.isBlank(pageSetName)) {
        pageSetName = lastPageSetName;
      }
      lastPageSetName = pageSetName;

      let pageSet = pageSetMap.get(pageSetName);
      if (pageSet) {
        pageSet.items.set(itemName, item);
      } else {
        pageSet = new PageSet();
        pageSet.name = pageSetName;
        pageSet.description = pageSetDesc;
        pageSet.path = pageSetPath;
        pageSet.title = pageSetTitle;

        pageSetMap.set(pageSetName, pageSet);

        const items = new Map<string, Item>();
        items.set(itemName, item);
        pageSet.items = items;
      }
    }
    return pageSetMap;
  }

  /**
   * Sets actions.
   *
   * @param test       Test
   * @param template   Template
   * @param sheets     List of sheets
   * @param workbook   Workbook object
   * @param testWriter Test writer
   */
  private async setActions(test: Test, template: Template, sheets: S[], workbook: W, testWriter?: TestWriter): Promise<void> {
    let actions = new Map<string | null, TestAction>();
    for (const sheet of sheets) {
      const sheetActions = await this.getActions(template, sheet, workbook, testWriter);
      actions = new Map<string | null, TestAction>([...actions, ...sheetActions]);
    }
    test.actions = actions;
  }

  /**
   * Gets actions of a given sheet.
   *
   * @param template   Template
   * @param sheet      Sheet
   * @param workbook   Workbook object
   * @param testWriter Test writer
   * @return Actions of the sheet
   */
  private async getActions(template: Template, sheet: S, workbook: W, testWriter?: TestWriter): Promise<Map<string | null, TestAction>> {
    const actionMap = new Map<string | null, TestAction>();

    const testFlows = await this.getTestFlows(template, sheet, '%ACTION_', workbook, null, testWriter);
    for (const testFlow of testFlows) {
      const testAction = new TestAction();
      testAction.no = testFlow.no;
      testAction.name = testFlow.name;
      testAction.description = testFlow.description;
      testAction.testSteps = testFlow.testSteps;
      actionMap.set(testFlow.name, testAction);
    }

    return actionMap;
  }

  /**
   * Sets test suites.
   *
   * @param test       Test
   * @param template   Template
   * @param sheets     List of sheets
   * @param workbook   Workbook object
   * @param testFilter Test filter
   * @param testWriter Test writer
   */
  private async setTestSuites(
    test: Test,
    template: Template,
    sheets: S[],
    workbook: W,
    testFilter?: TestFilter,
    testWriter?: TestWriter
  ): Promise<void> {
    const testSuites = new Map<string, TestSuite>();
    for (const sheet of sheets) {
      const testSuite = await this.getTestSuite(template, sheet, workbook, testFilter, testWriter);
      testSuites.set(this.getSheetName(sheet), testSuite);
    }
    test.testSuites = testSuites;
  }

  /**
   * Gets test suite of a given sheet.
   *
   * @param template   Template
   * @param sheet      Sheet
   * @param workbook   Workbook object
   * @param testFilter Test filter
   * @param testWriter Test writer
   * @return Test suite of the sheet
   */
  private async getTestSuite(template: Template, sheet: S, workbook: W, testFilter?: TestFilter, testWriter?: TestWriter): Promise<TestSuite> {
    const testSuite = new TestSuite();
    testSuite.sheetName = this.getSheetName(sheet);

    const testCases = [] as TestCase[];
    testSuite.testCases = testCases;

    const testFlows = await this.getTestFlows(template, sheet, '%TEST_', workbook, testFilter, testWriter);
    for (const testFlow of testFlows) {
      const testCase = new TestCase();
      testCase.no = testFlow.no;
      testCase.name = testFlow.name;
      testCase.description = testFlow.description;
      testCase.testSteps = testFlow.testSteps;
      testCases.push(testCase);
    }

    return testSuite;
  }

  /**
   * Gets the list of test flows of a given sheet.
   *
   * @param template   Template
   * @param sheet      Sheet
   * @param prefix     the markup prefix
   * @param workbook   Workbook object
   * @param testFilter Test filter
   * @param testWriter Test writer
   * @return the list of test flows of the sheet
   */
  private async getTestFlows(
    template: Template,
    sheet: S,
    prefix: string,
    workbook: W,
    testFilter?: TestFilter | null,
    testWriter?: TestWriter
  ): Promise<TestFlow[]> {
    const markupLocations = TemplateUtil.getMarkupLocations(template, s => s.startsWith(prefix));
    const tableValues = await this.getTableMarkupValues(markupLocations, this.getSheetName(sheet), workbook);
    const height = this.getDataHeight(markupLocations);

    const testFlows = [] as TestFlow[];
    let currentTestFlow;
    let testSteps = [] as TestStep[];
    let actualTestNo = 1;

    let index = 0;
    let testNoFirstLocation = null;
    if (markupLocations.has(prefix + 'NO%')) {
      testNoFirstLocation = new CellLocation({ cellRef: markupLocations.get(prefix + 'NO%') });
    }
    for (const itemValues of tableValues) {
      const testCommand = ObjectUtil.getStringValue(itemValues.get(prefix + 'COMMAND%'));
      if (testCommand && StringUtil.isNotBlank(testCommand)) {
        const testNo = ObjectUtil.getStringValue(itemValues.get(prefix + 'NO%'));
        const testGutter = ObjectUtil.getStringValue(itemValues.get(prefix + 'GUTTER%'));
        const testAndroidGutter = ObjectUtil.getStringValue(itemValues.get(prefix + 'ANDROID_GUTTER%'));
        const testIosGutter = ObjectUtil.getStringValue(itemValues.get(prefix + 'IOS_GUTTER%'));
        const testCapture = ObjectUtil.getBooleanValue(itemValues.get(prefix + 'CAPTURE%'));
        const testName = ObjectUtil.getStringValue(itemValues.get(prefix + 'NAME%'));
        const testDesc = ObjectUtil.getStringValue(itemValues.get(prefix + 'DESC%'));
        const testParam1 = ObjectUtil.getStringValue(itemValues.get(prefix + 'PARAM1%'));
        const testParam2 = ObjectUtil.getStringValue(itemValues.get(prefix + 'PARAM2%'));
        const testParam3 = ObjectUtil.getStringValue(itemValues.get(prefix + 'PARAM3%'));
        const testData = ObjectUtil.getStringValue(itemValues.get(prefix + 'DATA%'));

        const testStep = new TestStep();
        testStep.gutter = testGutter;
        testStep.androidGutter = testAndroidGutter;
        testStep.iosGutter = testIosGutter;
        testStep.capture = testCapture;
        testStep.command = testCommand;
        testStep.param1 = testParam1;
        testStep.param2 = testParam2;
        testStep.param3 = testParam3;
        testStep.testData = testData;
        testStep.rowIndex = height * index;

        const nameLocation = markupLocations.get(prefix + 'NAME%');
        if (StringUtil.isNotBlank(testName) || !nameLocation || StringUtil.isBlank(nameLocation)) {
          currentTestFlow = new TestCase();
          currentTestFlow.no = actualTestNo;
          currentTestFlow.name = testName;
          currentTestFlow.description = testDesc;
          if (!testFilter || !testFilter.testCase || testFilter.testCase === TestCase.ALL || testFilter.testCase === actualTestNo.toString()) {
            testFlows.push(currentTestFlow);
          }
          if (testWriter && testNoFirstLocation && actualTestNo.toString() === testNo) {
            const cellLocation = new CellLocation({
              sheetName: this.getSheetName(sheet),
              row: testNoFirstLocation.getRow() + height * index,
              col: testNoFirstLocation.getCol(),
            });
            testWriter.setCellValue(actualTestNo, cellLocation.formatAsString());
          }

          actualTestNo++;

          testSteps = [];
          currentTestFlow.testSteps = testSteps;
        } else {
          if (testWriter && testNoFirstLocation && StringUtil.isNotBlank(testNo)) {
            const cellLocation = new CellLocation({
              sheetName: this.getSheetName(sheet),
              row: testNoFirstLocation.getRow() + height * index,
              col: testNoFirstLocation.getCol(),
            });
            testWriter.setCellValue(null, cellLocation.formatAsString());
          }
        }
        testSteps.push(testStep);
      }
      index++;
    }
    return testFlows;
  }

  /**
   * Sets data.
   *
   * @param test     Test
   * @param template Template
   * @param sheets   List of sheets
   * @param workbook Workbook object
   */
  private async setData(test: Test, template: Template, sheets: S[], workbook: W): Promise<void> {
    let data = new Map<string, TestData>();
    for (const sheet of sheets) {
      const sheetData = await this.getData(template, sheet, workbook);
      data = new Map<string, TestData>([...data, ...sheetData]);
    }
    test.testData = data;
  }

  /**
   * Gets data of a given sheet.
   *
   * @param template Template
   * @param sheet    Sheet
   * @param workbook Workbook object
   * @return date of the sheet
   */
  private async getData(template: Template, sheet: S, workbook: W): Promise<Map<string, TestData>> {
    const markupLocations = TemplateUtil.getMarkupLocations(template, s => s.startsWith('%DATA_'));
    const lowest = this.getLowestMarkup(markupLocations);

    const columnIndexes = new Map<string, number>();
    markupLocations.forEach((cellRef, markup) => {
      const markupLocation = new CellLocation({ cellRef });
      columnIndexes.set(markup, markupLocation.getCol());
    });

    const dataMap = new Map<string, TestData>();
    const values = await this.getRangeCellValues(this.getSheetName(sheet), workbook);
    if (CollectionUtil.isEmpty(values)) {
      return dataMap;
    }

    let testData: TestData | null = null;
    let tableDataList = [] as TableData[];
    let tableData: TableData | null = null;
    let rowDataList = [] as Array<Map<string, any>>;
    for (let r = 0; r < values.length; r++) {
      if (r < lowest) {
        continue;
      }

      const rowValue = values[r];
      if (CollectionUtil.isEmpty(rowValue)) {
        // Skip empty rows
        continue;
      }

      const getValue = (markup: string) => {
        const index = columnIndexes.get(markup);
        if (index != null && rowValue.length > index) {
          return ObjectUtil.getStringValue(rowValue[index]);
        }
        return null;
      };

      const dataName = getValue(Template.DATA_NAME);
      if (dataName && StringUtil.isNotBlank(dataName)) {
        // if the data name is not blank, creates new test data
        testData = new TestData();
        tableDataList = [];
        tableData = null;

        testData.name = dataName;
        testData.tableData = tableDataList;
        dataMap.set(dataName, testData);
      }

      const dataDesc = getValue(Template.DATA_DESC);
      if (testData && !tableData && dataDesc && StringUtil.isNotBlank(dataDesc)) {
        // when the test data is initialized, but no table is defined,
        // if the data description is not blank, set the description
        testData.description = dataDesc;
      }

      const dataTableDef = getValue(Template.DATA_TABLE_DEF);
      if (
        testData &&
        dataTableDef &&
        StringUtil.isNotBlank(dataTableDef) &&
        dataTableDef
          .trim()
          .toUpperCase()
          .startsWith('TABLE')
      ) {
        // if the test data is initialized, the data def (string that is started with TABLE) is not blank, creates new table def
        tableData = new TableData();

        const tableDefinition = rowValue[1] as string;
        const defs = tableDefinition.split(';');
        for (const def of defs) {
          const keyVal = def.split('=');
          switch (keyVal[0].trim().toLowerCase()) {
            case 'table':
              tableData.name = keyVal[1].trim();
              break;
            case 'primary':
              tableData.primaryKeys = keyVal[1].split(',');
              break;
            case 'mode':
              tableData.mode = WriteMode.fromName(keyVal[1]);
              break;
          }
        }
        tableDataList.push(tableData);
      }

      const dataTableData = getValue(Template.DATA_TABLE_DATA);
      if (
        testData &&
        tableData &&
        dataTableData &&
        StringUtil.isNotBlank(dataTableData) &&
        !dataTableData
          .trim()
          .toUpperCase()
          .startsWith('TABLE')
      ) {
        if (CollectionUtil.isEmpty(tableData.columns)) {
          // if columns is not defined
          const columns = [] as Column[];
          const dataIndex = columnIndexes.get(Template.DATA_TABLE_DATA);
          for (let c = dataIndex!; c < rowValue.length; c++) {
            if (rowValue[c] != null) {
              const colStr = ObjectUtil.getStringValue(rowValue[c])!.trim();
              const m = /^((?:(?!\().)+)(?:\(([a-zA-Z]*)\))?$/.exec(colStr);
              if (m && m[1]) {
                const col = new Column();
                col.name = m[1].trim();
                if (StringUtil.isNotBlank(m[2])) {
                  col.type = m[2].trim();
                } else {
                  col.type = 'varchar';
                }
                columns.push(col);
              } else {
                break;
              }
            } else {
              break;
            }
          }
          rowDataList = [];
          tableData.columns = columns;
          tableData.rowData = rowDataList;
        } else {
          // Data row
          const rowData = new Map<string, any>();
          const dataIndex = columnIndexes.get(Template.DATA_TABLE_DATA);
          for (let i = 0; i < tableData.columns.length; i++) {
            let cellValue = null;
            if (i < rowValue.length - dataIndex!) {
              cellValue = rowValue[i + dataIndex!];
            }
            const column = tableData.columns[i];
            if (cellValue != null && cellValue !== 'NULL') {
              rowData.set(column.name, cellValue);
            } else {
              rowData.set(column.name, null);
            }
          }
          rowDataList.push(rowData);
        }
      }
    }

    return dataMap;
  }

  /**
   * Filter sheets that their names match the given wildcard pattern.
   *
   * @param sheets  List of sheets
   * @param pattern the wildcard pattern
   * @return the filtered sheets
   */
  private filterSheet(sheets: S[], pattern: string): S[] {
    if (StringUtil.isNotBlank(pattern)) {
      const patterns = [] as string[];
      patterns.push(pattern);
      return this.filterSheets(sheets, patterns);
    }
    return [];
  }

  /**
   * Filter sheets that their names match the given wildcard patterns.
   *
   * @param sheets   List of sheets
   * @param patterns List of wildcard patterns
   * @return the filtered sheets
   */
  private filterSheets(sheets: S[], patterns: string[]): S[] {
    const filteredSheets = [] as S[];
    for (const sheet of sheets) {
      const sheetName = this.getSheetName(sheet);
      let isMatch = false;
      if (CollectionUtil.isNotEmpty(patterns)) {
        for (const pattern of patterns) {
          if (WildcardUtil.isMatch(sheetName, pattern)) {
            isMatch = true;
            break;
          }
        }
      }
      if (isMatch) {
        filteredSheets.push(sheet);
      }
    }
    return filteredSheets;
  }

  /**
   * Returns the map of markups and their values.
   *
   * @param markupLocations Map of markup and its location
   * @param workbook        Workbook object
   * @return Map of markups and their values
   */
  private async getMarkupValues(markupLocations: Map<string, string>, workbook: W): Promise<Map<string, any>> {
    const locations = Array.from(markupLocations.values());
    const cellValues = await this.batchGetCellValues(locations, workbook);

    const markupValues = new Map<string, any>();
    markupLocations.forEach((location, markup) => {
      const cellValue = cellValues.get(location);
      if (cellValue != null) {
        markupValues.set(markup, cellValue);
      }
    });
    return markupValues;
  }

  /**
   * Returns list of table items of a sheet with the given sheet name based on
   * the markup locations.
   * First, the data window height is calculated. (the highest row minus the lowest row).
   * Then, retrieves the data of all relevant columns and partition into a list of consecutive sub-lists of column cell values.
   * Finally, translates the data into list of items using markup data locations.
   *
   * @param markupLocations the markup locations
   * @param sheetName       the sheet name
   * @param workbook        Workbook object
   * @return the list of item data
   */
  private async getTableMarkupValues(markupLocations: Map<string, string>, sheetName: string, workbook: W): Promise<Array<Map<any, any>>> {
    const lowest = this.getLowestMarkup(markupLocations);
    const height = this.getDataHeight(markupLocations);

    const ranges = [] as string[];
    const dataLocations = new Map<string, DataLocation>();
    markupLocations.forEach((location, markup) => {
      const markupLocation = new CellLocation({ cellRef: location });
      const cellLocation = new CellLocation({ sheetName, row: lowest, col: markupLocation.getCol() });
      const range = cellLocation.formatAsString() + ':' + CellLocation.convertNumToColString(markupLocation.getCol());
      if (ranges.indexOf(range) === -1) {
        ranges.push(range);
      }
      const dataLocation = new DataLocation(range, markupLocation.getRow() - lowest);
      dataLocations.set(markup, dataLocation);
    });

    const partitionedColumnCellValues = this.partitionColumnCellValues(await this.batchGetColumnCellValues(ranges, workbook), height);
    return this.getItemListByColumnCellValues(partitionedColumnCellValues, dataLocations);
  }

  /**
   * Get the row index of the lowest markup from the list of markup locations.
   *
   * @param markupLocations the list of markup locations
   * @return the row index of the lowest markup
   */
  private getLowestMarkup(markupLocations: Map<string, string>): number {
    let lowest = 2147483647;

    markupLocations.forEach(markupLocation => {
      const cellLocation = new CellLocation({ cellRef: markupLocation });
      const row = cellLocation.getRow();
      if (row < lowest) {
        lowest = row;
      }
    });
    return lowest;
  }

  /**
   * Get the row index of the highest markup from the list of markup locations.
   *
   * @param markupLocations the list of markup locations
   * @return the row index of the highest markup
   */
  private getHighestMarkup(markupLocations: Map<string, string>): number {
    let highest = -2147483648;

    markupLocations.forEach(markupLocation => {
      const cellLocation = new CellLocation({ cellRef: markupLocation });
      const row = cellLocation.getRow();
      if (row > highest) {
        highest = row;
      }
    });
    return highest;
  }

  /**
   * Get the data height from the list of markup locations.
   *
   * @param markupLocations the list of markup locations
   * @return the data height
   */
  private getDataHeight(markupLocations: Map<string, string>): number {
    const lowest = this.getLowestMarkup(markupLocations);
    const highest = this.getHighestMarkup(markupLocations);
    return highest - lowest + 1;
  }
}
