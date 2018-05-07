/*
 * MIT License
 *
 * Copyright (c) 2018 Excelium
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package excelium.core.reader;

import excelium.common.ObjectUtil;
import excelium.common.TemplateUtil;
import excelium.common.WildcardUtil;
import excelium.common.ss.CellLocation;
import excelium.core.writer.TestWriter;
import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.project.Template;
import excelium.model.test.*;
import excelium.model.test.action.TestAction;
import excelium.model.test.config.Environment;
import excelium.model.test.config.TestConfig;
import excelium.model.test.data.Column;
import excelium.model.test.data.TableData;
import excelium.model.test.data.TestData;
import excelium.model.test.item.Item;
import excelium.model.test.item.PageSet;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static excelium.common.EnvironmentUtil.*;
import static excelium.common.ObjectUtil.*;
import static excelium.model.project.Template.*;

/**
 * Abstract test reader that implements {@link TestReader}.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.23
 */
public abstract class AbstractTestReader<W, S> extends AbstractWorkbookReader<W, S> implements TestReader<W, S> {

    @Override
    public Test<W, S> parseTest(Template template, TestFilter testFilter, TestWriter testWriter) throws IOException {
        Test<W, S> test = new Test<>();
        test.setWorkbookName(getWorkbookName());
        parseTest(test, template, testFilter, testWriter);
        return test;
    }

    /**
     * Parses test file.
     *
     * @param test       Test object
     * @param template   Template object
     * @param testFilter Test filter
     * @param testWriter Test writer
     * @throws IOException if the IOException occurs
     */
    private void parseTest(Test<W, S> test, Template template, TestFilter testFilter, TestWriter testWriter) throws IOException {
        List<S> sheets = new ArrayList<>(listSheets());

        List<S> configurationSheets = filterSheets(sheets, TemplateUtil.getConfigurationSheets(template));
        sheets.removeAll(configurationSheets);

        List<S> ignoreSheets = filterSheets(sheets, template.getIgnorePatterns());
        sheets.removeAll(ignoreSheets);

        List<S> mappingSheets = filterSheets(sheets, template.getMappingPattern());
        sheets.removeAll(mappingSheets);

        List<S> dataSheets = filterSheets(sheets, template.getDataPattern());
        sheets.removeAll(dataSheets);

        List<S> actionSheets = filterSheets(sheets, template.getActionPattern());
        sheets.removeAll(actionSheets);

        List<S> testSheets = filterSheets(sheets, template.getTestPattern());
        if (testFilter != null && CollectionUtils.isNotEmpty(testFilter.getSheets())) {
            testSheets = filterSheets(testSheets, testFilter.getSheets());
        }

        setTestConfig(test, template);
        setPageSets(test, template, mappingSheets);
        setActions(test, template, actionSheets, testWriter);
        setData(test, template, dataSheets);
        setTestSuites(test, template, testSheets, testFilter, testWriter);
    }

    /**
     * Sets test configuration.
     *
     * @param test     Test
     * @param template Template
     * @throws IOException if the IOException occurs
     */
    private void setTestConfig(Test<W, S> test, Template template) throws IOException {
        Map<Object, String> markupLocations = TemplateUtil.getConfigurationMarkupLocations(template);
        Map<Object, Object> values = getMarkupValues(markupLocations);

        String baseUrl = getStringValue(values.get(BASE_URL));
        List<Environment> environments = getEnvironments(values);

        TestConfig testConfig = new TestConfig();
        testConfig.setBaseUrl(baseUrl);
        testConfig.setEnvironments(environments);

        test.setConfig(testConfig);
    }

    /**
     * Gets environment list.
     *
     * @param configurationValues Configuration values
     * @return Environment list
     * @throws IOException if the IOException occurs
     */
    private List<Environment> getEnvironments(Map<Object, Object> configurationValues) throws IOException {
        boolean pcEnabled = getBooleanValue(configurationValues.get(USE_PC));
        boolean androidEnabled = getBooleanValue(configurationValues.get(USE_ANDROID));
        boolean iOsEnabled = getBooleanValue(configurationValues.get(USE_IOS));

        // PC Configurations
        boolean chromeEnabled = getBooleanValue(configurationValues.get(USE_CHROME));
        boolean firefoxEnabled = getBooleanValue(configurationValues.get(USE_FIREFOX));
        boolean ieEnabled = getBooleanValue(configurationValues.get(USE_IE));
        boolean edgeEnabled = getBooleanValue(configurationValues.get(USE_EDGE));
        boolean safariEnabled = getBooleanValue(configurationValues.get(USE_SAFARI));
        boolean operaEnabled = getBooleanValue(configurationValues.get(USE_OPERA));

        List<String> chromeVersions = getListValue(configurationValues.get(CHROME_VERSION));
        List<String> firefoxVersions = getListValue(configurationValues.get(FIREFOX_VERSION));
        List<String> ieVersions = getListValue(configurationValues.get(IE_VERSION));
        List<String> edgeVersions = getListValue(configurationValues.get(EDGE_VERSION));
        List<String> safariVersions = getListValue(configurationValues.get(SAFARI_VERSION));
        List<String> operaVersions = getListValue(configurationValues.get(OPERA_VERSION));

        List<String> chromeResolutions = getListValue(configurationValues.get(CHROME_RESOLUTION));
        List<String> firefoxResolutions = getListValue(configurationValues.get(FIREFOX_RESOLUTION));
        List<String> ieResolutions = getListValue(configurationValues.get(IE_RESOLUTION));
        List<String> edgeResolutions = getListValue(configurationValues.get(EDGE_RESOLUTION));
        List<String> safariResolutions = getListValue(configurationValues.get(SAFARI_RESOLUTION));
        List<String> operaResolutions = getListValue(configurationValues.get(OPERA_RESOLUTION));

        // Mobile Configurations
        List<String> androidVersions = getListValue(configurationValues.get(ANDROID_PLATFORM_VERSION));
        List<String> iOsVersions = getListValue(configurationValues.get(IOS_PLATFORM_VERSION));
        List<String> androidDevices = getListValue(configurationValues.get(ANDROID_DEVICE_NAME));
        List<String> iOsDevices = getListValue(configurationValues.get(IOS_DEVICE_NAME));
        List<String> androidOrientations = getListValue(configurationValues.get(ANDROID_ORIENTATION));
        List<String> iOsOrientations = getListValue(configurationValues.get(IOS_ORIENTATION));
        String androidUdid = getStringValue(configurationValues.get(ANDROID_UDID));
        String iOsUdid = getStringValue(configurationValues.get(IOS_UDID));

        // Mobile web configurations
        List<String> androidBrowsers = getListValue(configurationValues.get(ANDROID_BROWSER));
        List<String> iOsBrowsers = getListValue(configurationValues.get(IOS_BROWSER));

        // Mobile app configurations
        String androidApkPath = getStringValue(configurationValues.get(ANDROID_APP));
        String iOsIpaPath = getStringValue(configurationValues.get(IOS_APP));
        String androidAppActivity = getStringValue(configurationValues.get(ANDROID_APP_ACTIVITY));
        String androidAppPackage = getStringValue(configurationValues.get(ANDROID_APP_PACKAGE));
        String androidAppWaitActivity = getStringValue(configurationValues.get(ANDROID_APP_WAIT_ACTIVITY));
        String androidAppWaitPackage = getStringValue(configurationValues.get(ANDROID_APP_WAIT_PACKAGE));

        List<Environment> environments = new ArrayList<>();
        if (pcEnabled) {
            if (chromeEnabled)
                environments.addAll(getAvailablePcEnvironments(Browser.CHROME, chromeVersions, chromeResolutions));
            if (firefoxEnabled)
                environments.addAll(getAvailablePcEnvironments(Browser.FIREFOX, firefoxVersions, firefoxResolutions));
            if (ieEnabled)
                environments.addAll(getAvailablePcEnvironments(Browser.IE, ieVersions, ieResolutions));
            if (edgeEnabled)
                environments.addAll(getAvailablePcEnvironments(Browser.EDGE, edgeVersions, edgeResolutions));
            if (safariEnabled)
                environments.addAll(getAvailablePcEnvironments(Browser.SAFARI, safariVersions, safariResolutions));
            if (operaEnabled)
                environments.addAll(getAvailablePcEnvironments(Browser.OPERA, operaVersions, operaResolutions));
        }

        if (androidEnabled) {
            if (CollectionUtils.isEmpty(androidBrowsers)) {
                environments.addAll(getAvailableMobileAppEnvironments(Platform.ANDROID, androidVersions, androidDevices, androidOrientations, androidUdid, androidApkPath, androidAppActivity, androidAppPackage, androidAppWaitActivity, androidAppWaitPackage));
            } else {
                environments.addAll(getAvailableMobileWebEnvironments(Platform.ANDROID, androidVersions, androidDevices, androidOrientations, androidUdid, androidBrowsers));
            }
        }

        if (iOsEnabled) {
            if (CollectionUtils.isEmpty(iOsBrowsers)) {
                environments.addAll(getAvailableMobileAppEnvironments(Platform.IOS, iOsVersions, iOsDevices, iOsOrientations, iOsUdid, iOsIpaPath, null, null, null, null));
            } else {
                environments.addAll(getAvailableMobileWebEnvironments(Platform.IOS, iOsVersions, iOsDevices, iOsOrientations, iOsUdid, iOsBrowsers));
            }
        }

        return environments;
    }

    /**
     * Sets page sets.
     *
     * @param test     Test
     * @param template Template
     * @param sheets   List of sheets
     * @throws IOException if the IOException occurs
     */
    private void setPageSets(Test<W, S> test, Template template, List<S> sheets) throws IOException {
        Map<String, PageSet> pageSets = new HashMap<>();
        for (S sheet : sheets) {
            Map<String, PageSet> sheetPageSets = getPageSets(template, sheet);
            for (String key : sheetPageSets.keySet()) {
                if (pageSets.containsKey(key)) {
                    PageSet pageSet = pageSets.get(key);
                    PageSet sheetPageSet = sheetPageSets.get(key);
                    pageSet.getItems().putAll(sheetPageSet.getItems());
                } else {
                    pageSets.put(key, sheetPageSets.get(key));
                }
            }
        }
        test.setPageSets(pageSets);
    }

    /**
     * Gets page sets of a given sheet.
     *
     * @param template Template
     * @param sheet    Sheet
     * @return Page sets of the sheet
     * @throws IOException if the IOException occurs
     */
    private Map<String, PageSet> getPageSets(Template template, S sheet) throws IOException {
        Map<Object, String> markupLocations = TemplateUtil.getMarkupLocations(template, s -> s.startsWith("%MAPPING_"));
        List<Map<Object, Object>> tableValues = getTableMarkupValues(markupLocations, getSheetName(sheet));

        Map<String, PageSet> pageSetMap = new HashMap<>();
        String lastPageSetName = null;
        for (Map<Object, Object> itemValues : tableValues) {
            String itemName = getStringValue(itemValues.get(MAPPING_ITEM_NAME));
            if (StringUtils.isBlank(itemName)) {
                continue;
            }

            String itemDesc = getStringValue(itemValues.get(MAPPING_ITEM_DESC));
            String itemValue = getStringValue(itemValues.get(MAPPING_ITEM_VALUE));
            String itemAndroidValue = getStringValue(itemValues.get(MAPPING_ITEM_ANDROID_VALUE));
            String itemIosValue = getStringValue(itemValues.get(MAPPING_ITEM_IOS_VALUE));

            String pageSetName = getStringValue(itemValues.get(MAPPING_PAGESET_NAME));
            String pageSetDesc = getStringValue(itemValues.get(MAPPING_PAGESET_DESC));
            String pageSetPath = getStringValue(itemValues.get(MAPPING_PAGESET_PATH));
            String pageSetTitle = getStringValue(itemValues.get(MAPPING_PAGESET_TITLE));

            Item item = new Item();
            item.setName(itemName);
            item.setDescription(itemDesc);
            item.setValue(itemValue);
            item.setAndroidValue(itemAndroidValue);
            item.setIosValue(itemIosValue);

            if (StringUtils.isBlank(pageSetName)) {
                pageSetName = lastPageSetName;
            }
            lastPageSetName = pageSetName;

            if (pageSetMap.containsKey(pageSetName)) {
                PageSet pageSet = pageSetMap.get(pageSetName);
                pageSet.getItems().put(itemName, item);
            } else {
                PageSet pageSet = new PageSet();
                pageSet.setName(pageSetName);
                pageSet.setDescription(pageSetDesc);
                pageSet.setPath(pageSetPath);
                pageSet.setTitle(pageSetTitle);

                pageSetMap.put(pageSetName, pageSet);

                Map<String, Item> items = new HashMap<>();
                items.put(itemName, item);
                pageSet.setItems(items);
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
     * @param testWriter Test writer
     * @throws IOException if the IOException occurs
     */
    private void setActions(Test<W, S> test, Template template, List<S> sheets, TestWriter testWriter) throws IOException {
        Map<String, TestAction> actions = new HashMap<>();
        for (S sheet : sheets) {
            Map<String, TestAction> sheetActions = getActions(template, sheet, testWriter);
            actions.putAll(sheetActions);
        }
        test.setActions(actions);
    }

    /**
     * Gets actions of a given sheet.
     *
     * @param template   Template
     * @param sheet      Sheet
     * @param testWriter Test writer
     * @return Actions of the sheet
     * @throws IOException if the IOException occurs
     */
    private Map<String, TestAction> getActions(Template template, S sheet, TestWriter testWriter) throws IOException {
        Map<Object, String> markupLocations = TemplateUtil.getMarkupLocations(template, s -> s.startsWith("%ACTION_"));
        List<Map<Object, Object>> tableValues = getTableMarkupValues(markupLocations, getSheetName(sheet));
        int height = getDataHeight(markupLocations);

        Map<String, TestAction> actionMap = new HashMap<>();
        TestAction currentTestAction;
        List<TestStep> testSteps = new ArrayList<>();
        int actualActionNo = 1;

        int index = 0;
        CellLocation actionNoFirstLocation = null;
        if (markupLocations.containsKey(ACTION_NO)) {
            actionNoFirstLocation = new CellLocation(markupLocations.get(ACTION_NO));
        }
        for (Map<Object, Object> itemValues : tableValues) {
            String actionCommand = getStringValue(itemValues.get(ACTION_COMMAND));
            if (StringUtils.isNotBlank(actionCommand)) {
                String actionNo = getStringValue(itemValues.get(ACTION_NO));
                String actionGutter = getStringValue(itemValues.get(ACTION_GUTTER));
                String actionAndroidGutter = getStringValue(itemValues.get(ACTION_ANDROID_GUTTER));
                String actionIosGutter = getStringValue(itemValues.get(ACTION_IOS_GUTTER));
                boolean actionCapture = getBooleanValue(itemValues.get(ACTION_CAPTURE));
                String actionName = getStringValue(itemValues.get(ACTION_NAME));
                String actionDesc = getStringValue(itemValues.get(ACTION_DESC));
                String actionParam1 = getStringValue(itemValues.get(ACTION_PARAM1));
                String actionParam2 = getStringValue(itemValues.get(ACTION_PARAM2));
                String actionParam3 = getStringValue(itemValues.get(ACTION_PARAM3));
                String actionData = getStringValue(itemValues.get(ACTION_DATA));

                TestStep testStep = new TestStep();
                testStep.setGutter(actionGutter);
                testStep.setAndroidGutter(actionAndroidGutter);
                testStep.setIosGutter(actionIosGutter);
                testStep.setCapture(actionCapture);
                testStep.setCommand(actionCommand);
                testStep.setParam1(actionParam1);
                testStep.setParam2(actionParam2);
                testStep.setParam3(actionParam3);
                testStep.setTestData(actionData);

                if (StringUtils.isNotBlank(actionName)) {
                    currentTestAction = new TestAction();
                    currentTestAction.setNo(actualActionNo);
                    currentTestAction.setName(actionName);
                    currentTestAction.setDescription(actionDesc);
                    actionMap.put(actionName, currentTestAction);

                    if (testWriter != null && actionNoFirstLocation != null && !String.valueOf(actualActionNo).equals(actionNo)) {
                        CellLocation cellLocation = new CellLocation(getSheetName(sheet), actionNoFirstLocation.getRow() + height * index, actionNoFirstLocation.getCol(), false, false);
                        testWriter.setCellValue(actualActionNo, cellLocation.formatAsString());
                    }

                    actualActionNo++;

                    testSteps = new ArrayList<>();
                    currentTestAction.setTestSteps(testSteps);
                } else {
                    if (testWriter != null && actionNoFirstLocation != null && StringUtils.isNotBlank(actionNo)) {
                        CellLocation cellLocation = new CellLocation(getSheetName(sheet), actionNoFirstLocation.getRow() + height * index, actionNoFirstLocation.getCol(), false, false);
                        testWriter.setCellValue(null, cellLocation.formatAsString());
                    }
                }
                testSteps.add(testStep);
            }
            index++;
        }
        return actionMap;
    }

    /**
     * Sets test suites.
     *
     * @param test       Test
     * @param template   Template
     * @param sheets     List of sheets
     * @param testFilter Test filter
     * @param testWriter Test writer
     * @throws IOException if the IOException occurs
     */
    private void setTestSuites(Test<W, S> test, Template template, List<S> sheets, TestFilter testFilter, TestWriter testWriter) throws IOException {
        Map<String, TestSuite<S>> testSuites = new HashMap<>();
        for (S sheet : sheets) {
            TestSuite<S> sheetTestSuite = getTestSuite(template, sheet, testFilter, testWriter);
            testSuites.put(getSheetName(sheet), sheetTestSuite);
        }
        test.setTestSuites(testSuites);
    }

    /**
     * Gets test suite of a given sheet.
     *
     * @param template   Template
     * @param sheet      Sheet
     * @param testFilter Test filter
     * @param testWriter Test writer
     * @return Test suite of the sheet
     * @throws IOException if the IOException occurs
     */
    private TestSuite<S> getTestSuite(Template template, S sheet, TestFilter testFilter, TestWriter testWriter) throws IOException {
        Map<Object, String> markupLocations = TemplateUtil.getMarkupLocations(template, s -> s.startsWith("%TEST_"));
        List<Map<Object, Object>> tableValues = getTableMarkupValues(markupLocations, getSheetName(sheet));
        int height = getDataHeight(markupLocations);

        TestSuite<S> testSuite = new TestSuite<>();
        testSuite.setSheet(sheet);
        testSuite.setSheetName(getSheetName(sheet));

        List<TestCase> testCases = new ArrayList<>();
        testSuite.setTestCases(testCases);
        TestCase currentTestCase;
        List<TestStep> testSteps = new ArrayList<>();
        int actualTestNo = 1;

        int index = 0;
        CellLocation testNoFirstLocation = null;
        if (markupLocations.containsKey(TEST_NO)) {
            testNoFirstLocation = new CellLocation(markupLocations.get(TEST_NO));
        }
        for (Map<Object, Object> itemValues : tableValues) {
            String testCommand = getStringValue(itemValues.get(TEST_COMMAND));
            if (StringUtils.isNotBlank(testCommand)) {
                String testNo = getStringValue(itemValues.get(TEST_NO));
                String testGutter = getStringValue(itemValues.get(TEST_GUTTER));
                String testAndroidGutter = getStringValue(itemValues.get(TEST_ANDROID_GUTTER));
                String testIosGutter = getStringValue(itemValues.get(TEST_IOS_GUTTER));
                boolean testCapture = getBooleanValue(itemValues.get(TEST_CAPTURE));
                String testName = getStringValue(itemValues.get(TEST_NAME));
                String testDesc = getStringValue(itemValues.get(TEST_DESC));
                String testParam1 = getStringValue(itemValues.get(TEST_PARAM1));
                String testParam2 = getStringValue(itemValues.get(TEST_PARAM2));
                String testParam3 = getStringValue(itemValues.get(TEST_PARAM3));
                String testData = getStringValue(itemValues.get(TEST_DATA));

                TestStep testStep = new TestStep();
                testStep.setGutter(testGutter);
                testStep.setAndroidGutter(testAndroidGutter);
                testStep.setIosGutter(testIosGutter);
                testStep.setCapture(testCapture);
                testStep.setCommand(testCommand);
                testStep.setParam1(testParam1);
                testStep.setParam2(testParam2);
                testStep.setParam3(testParam3);
                testStep.setTestData(testData);

                if (StringUtils.isNotBlank(testName)) {
                    currentTestCase = new TestCase();
                    currentTestCase.setNo(actualTestNo);
                    currentTestCase.setName(testName);
                    currentTestCase.setDescription(testDesc);
                    if (testFilter == null || CollectionUtils.isEmpty(testFilter.getTestCases()) || testFilter.getTestCases().contains(String.valueOf(actualTestNo))) {
                        testCases.add(currentTestCase);
                    }
                    if (testWriter != null && testNoFirstLocation != null && !String.valueOf(actualTestNo).equals(testNo)) {
                        CellLocation cellLocation = new CellLocation(getSheetName(sheet), testNoFirstLocation.getRow() + height * index, testNoFirstLocation.getCol(), false, false);
                        testWriter.setCellValue(actualTestNo, cellLocation.formatAsString());
                    }

                    actualTestNo++;

                    testSteps = new ArrayList<>();
                    currentTestCase.setTestSteps(testSteps);
                } else {
                    if (testWriter != null && testNoFirstLocation != null && StringUtils.isNotBlank(testNo)) {
                        CellLocation cellLocation = new CellLocation(getSheetName(sheet), testNoFirstLocation.getRow() + height * index, testNoFirstLocation.getCol(), false, false);
                        testWriter.setCellValue(null, cellLocation.formatAsString());
                    }
                }
                testSteps.add(testStep);
            }
            index++;
        }
        return testSuite;
    }

    /**
     * Sets data.
     *
     * @param test     Test
     * @param template Template
     * @param sheets   List of sheets
     * @throws IOException if the IOException occurs
     */
    private void setData(Test<W, S> test, Template template, List<S> sheets) throws IOException {
        Map<String, TestData> data = new HashMap<>();
        for (S sheet : sheets) {
            Map<String, TestData> sheetData = getData(template, sheet);
            data.putAll(sheetData);
        }
        test.setTestData(data);
    }

    /**
     * Gets data of a given sheet.
     *
     * @param template Template
     * @param sheet    Sheet
     * @return date of the sheet
     * @throws IOException if the IOException occurs
     */
    private Map<String, TestData> getData(Template template, S sheet) throws IOException {
        Map<Object, String> markupLocations = TemplateUtil.getMarkupLocations(template, s -> s.startsWith("%DATA_"));
        int lowest = getLowestMarkup(markupLocations);

        Map<Object, Short> columnIndexes = new HashMap<>();
        for (Object markup : markupLocations.keySet()) {
            CellLocation markupLocation = new CellLocation(markupLocations.get(markup));
            columnIndexes.put(markup, markupLocation.getCol());
        }

        Map<String, TestData> dataMap = new HashMap<>();
        List<List<Object>> values = getRangeCellValues(getSheetName(sheet));
        if (values == null || values.size() == 0) {
            return dataMap;
        }

        TestData testData = null;
        List<TableData> tableDataList = null;
        TableData tableData = null;
        List<Map<Column, Object>> rowDataList = null;
        for (int r = 0; r < values.size(); r++) {
            if (r < lowest) {
                continue;
            }

            List<Object> rowValue = values.get(r);
            if (rowValue == null || rowValue.size() == 0) {
                // Skip empty rows
                continue;
            }

            String dataName = columnIndexes.containsKey(DATA_NAME) && rowValue.size() > columnIndexes.get(DATA_NAME) ? ObjectUtil.getStringValue(rowValue.get(columnIndexes.get(DATA_NAME))) : null;
            if (StringUtils.isNotBlank(dataName)) {
                // if the data name is not blank, creates new test data
                testData = new TestData();
                tableDataList = new ArrayList<>();
                tableData = null;

                testData.setName(dataName);
                testData.setTableData(tableDataList);
                dataMap.put(dataName, testData);
            }

            String dataDesc = columnIndexes.containsKey(DATA_DESC) && rowValue.size() > columnIndexes.get(DATA_DESC) ? ObjectUtil.getStringValue(rowValue.get(columnIndexes.get(DATA_DESC))) : null;
            if (testData != null && tableData == null && StringUtils.isNotBlank(dataDesc)) {
                // when the test data is initialized, but no table is defined,
                // if the data description is not blank, set the description
                testData.setDescription(dataDesc);
            }

            String dataTableDef = columnIndexes.containsKey(DATA_TABLE_DEF) && rowValue.size() > columnIndexes.get(DATA_TABLE_DEF) ? ObjectUtil.getStringValue(rowValue.get(columnIndexes.get(DATA_TABLE_DEF))) : null;
            if (testData != null && StringUtils.isNotBlank(dataTableDef) && StringUtils.startsWith(dataTableDef.trim(), "TABLE")) {
                // if the test data is initialized, the data def (string that is started with TABLE) is not blank, creates new table def
                tableData = new TableData();

                String tableDefinition = (String) rowValue.get(1);
                String[] defs = tableDefinition.split(";");
                for (String def : defs) {
                    String[] keyVal = def.split("=");
                    switch (keyVal[0].trim().toLowerCase()) {
                        case "table":
                            tableData.setName(keyVal[1].trim());
                            break;
                        case "primary":
                            tableData.setPrimaryKeys(Arrays.asList(keyVal[1].split(",")));
                            break;
                    }
                }
                tableDataList.add(tableData);
            }

            String dataTableData = columnIndexes.containsKey(DATA_TABLE_DATA) && rowValue.size() > columnIndexes.get(DATA_TABLE_DATA) ? ObjectUtil.getStringValue(rowValue.get(columnIndexes.get(DATA_TABLE_DATA))) : null;
            if (testData != null && tableData != null && StringUtils.isNotBlank(dataTableData) && !StringUtils.startsWith(dataTableData.trim(), "TABLE") && CollectionUtils.isEmpty(tableData.getColumns())) {
                // if columns is not defined
                List<Column> columns = new ArrayList<>();
                for (int c = columnIndexes.get(DATA_TABLE_DATA); c < rowValue.size(); c++) {
                    if (rowValue.get(c) != null) {
                        String colStr = ObjectUtil.getStringValue(rowValue.get(c)).trim();
                        Pattern p = Pattern.compile("^((?:(?!\\().)+)(?:\\(([a-zA-Z]*)\\))?$");
                        Matcher m = p.matcher(colStr);
                        if (m.find()) {
                            Column col = new Column();
                            col.setName(m.group(1).trim());
                            if (StringUtils.isNotBlank(m.group(2))) {
                                col.setType(m.group(2).trim());
                            } else {
                                col.setType("varchar");
                            }
                            columns.add(col);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                rowDataList = new ArrayList<>();
                tableData.setColumns(columns);
                tableData.setRowData(rowDataList);
            } else if (testData != null && tableData != null && StringUtils.isNotBlank(dataTableData) && !StringUtils.startsWithIgnoreCase(dataTableData.trim(), "TABLE") && CollectionUtils.isNotEmpty(tableData.getColumns())) {
                // Data row
                Map<Column, Object> rowData = new HashMap<>();
                for (int i = 0; i < tableData.getColumns().size(); i++) {
                    Object cellValue = null;
                    if (i < rowValue.size() - columnIndexes.get(DATA_TABLE_DATA)) {
                        cellValue = rowValue.get(i + columnIndexes.get(DATA_TABLE_DATA));
                    }
                    Column column = tableData.getColumns().get(i);
                    if (cellValue != null && !"NULL".equals(cellValue)) {
                        rowData.put(column, cellValue);
                    } else {
                        rowData.put(column, null);
                    }
                }
                rowDataList.add(rowData);
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
     * @throws IOException if the IOException occurs
     */
    private List<S> filterSheets(List<S> sheets, String pattern) throws IOException {
        if (StringUtils.isNotBlank(pattern)) {
            List<String> patterns = new ArrayList<>();
            patterns.add(pattern);
            return filterSheets(sheets, patterns);
        }
        return new ArrayList<>();
    }

    /**
     * Filter sheets that their names match the given wildcard patterns.
     *
     * @param sheets   List of sheets
     * @param patterns List of wildcard patterns
     * @return the filtered sheets
     * @throws IOException if the IOException occurs
     */
    private List<S> filterSheets(List<S> sheets, List<String> patterns) throws IOException {
        List<S> filteredSheets = new ArrayList<>();
        for (S sheet : sheets) {
            String sheetName = getSheetName(sheet);
            boolean isMatch = false;
            if (CollectionUtils.isNotEmpty(patterns)) {
                for (String pattern : patterns) {
                    if (WildcardUtil.isMatch(sheetName, pattern)) {
                        isMatch = true;
                        break;
                    }
                }
            }
            if (isMatch) {
                filteredSheets.add(sheet);
            }
        }
        return filteredSheets;
    }

    /**
     * Returns the map of markups and their values.
     *
     * @param markupLocations Map of markup and its location
     * @return Map of markups and their values
     * @throws IOException if the IOException occurs
     */
    private Map<Object, Object> getMarkupValues(Map<Object, String> markupLocations) throws IOException {
        String[] locations = markupLocations.values().toArray(new String[0]);
        Map<String, Object> cellValues = batchGetCellValues(locations);

        Map<Object, Object> markupValues = new HashMap<>();
        for (Object markup : markupLocations.keySet()) {
            Object cellValue = cellValues.get(markupLocations.get(markup));
            if (cellValue != null) {
                markupValues.put(markup, cellValue);
            }
        }
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
     * @return the list of item data
     */
    private List<Map<Object, Object>> getTableMarkupValues(Map<Object, String> markupLocations, String sheetName) throws IOException {
        int lowest = getLowestMarkup(markupLocations);
        int height = getDataHeight(markupLocations);

        List<String> ranges = new ArrayList<>();
        Map<Object, DataLocation> dataLocations = new HashMap<>();
        for (Object markup : markupLocations.keySet()) {
            CellLocation markupLocation = new CellLocation(markupLocations.get(markup));
            CellLocation cellLocation = new CellLocation(sheetName, lowest, markupLocation.getCol(), false, false);
            String range = cellLocation.formatAsString() + ":" + CellLocation.convertNumToColString(markupLocation.getCol());
            if (!ranges.contains(range)) {
                ranges.add(range);
            }
            DataLocation dataLocation = new DataLocation(range, markupLocation.getRow() - lowest);
            dataLocations.put(markup, dataLocation);
        }

        List<Map<String, List<Object>>> partitionedColumnCellValues = partitionColumnCellValues(batchGetColumnCellValues(ranges.toArray(new String[0])), height);
        return getItemListByColumnCellValues(partitionedColumnCellValues, dataLocations);
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
    private List<Map<String, List<Object>>> partitionColumnCellValues(Map<String, List<Object>> columnCellValues, int dataHeight) {
        List<Map<String, List<Object>>> partitioned = new ArrayList<>();
        for (String column : columnCellValues.keySet()) {
            List<Object> columnValues = columnCellValues.get(column);
            List<List<Object>> partitionColumnValues = ListUtils.partition(columnValues, dataHeight);
            int i = 0;
            for (List<Object> partitionColumnValue : partitionColumnValues) {
                Map<String, List<Object>> map;
                if (i < partitioned.size()) {
                    map = partitioned.get(i);
                } else {
                    map = new HashMap<>();
                    partitioned.add(map);
                }
                map.put(column, partitionColumnValue);
                i++;
            }
        }
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
    private List<Map<Object, Object>> getItemListByColumnCellValues(List<Map<String, List<Object>>> columnCellValues, Map<Object, DataLocation> dataLocations) {
        List<Map<Object, Object>> itemDataList = new ArrayList<>();
        for (Map<String, List<Object>> columnValues : columnCellValues) {
            Map<Object, Object> itemData = new HashMap<>();
            for (Object key : dataLocations.keySet()) {
                DataLocation location = dataLocations.get(key);
                List<Object> columnValue = columnValues.get(location.getColumn());
                if (CollectionUtils.isNotEmpty(columnValue) && columnValue.size() > location.getRow()) {
                    Object object = columnValue.get(location.getRow());
                    itemData.put(key, object);
                }
            }
            itemDataList.add(itemData);
        }
        return itemDataList;
    }

    /**
     * Get the row index of the lowest markup from the list of markup locations.
     *
     * @param markupLocations the list of markup locations
     * @return the row index of the lowest markup
     */
    private int getLowestMarkup(Map<Object, String> markupLocations) {
        int lowest = Integer.MAX_VALUE;

        for (String markupLocation : markupLocations.values()) {
            CellLocation cellLocation = new CellLocation(markupLocation);
            int row = cellLocation.getRow();
            if (row < lowest) {
                lowest = row;
            }
        }
        return lowest;
    }

    /**
     * Get the row index of the highest markup from the list of markup locations.
     *
     * @param markupLocations the list of markup locations
     * @return the row index of the highest markup
     */
    private int getHighestMarkup(Map<Object, String> markupLocations) {
        int highest = Integer.MIN_VALUE;

        for (String markupLocation : markupLocations.values()) {
            CellLocation cellLocation = new CellLocation(markupLocation);
            int row = cellLocation.getRow();
            if (row > highest) {
                highest = row;
            }
        }
        return highest;
    }

    /**
     * Get the data height from the list of markup locations.
     *
     * @param markupLocations the list of markup locations
     * @return the data height
     */
    private int getDataHeight(Map<Object, String> markupLocations) {
        int lowest = getLowestMarkup(markupLocations);
        int highest = getHighestMarkup(markupLocations);
        return highest - lowest + 1;
    }

    /**
     * An inner class that stores locations of data item in a table.
     */
    static class DataLocation {

        /**
         * Column name
         */
        private String column;

        /**
         * Row index
         */
        private int row;

        /**
         * Instantiates a new Data location.
         *
         * @param column the column
         * @param row    the row
         */
        DataLocation(String column, int row) {
            this.column = column;
            this.row = row;
        }

        /**
         * Gets column.
         *
         * @return the column
         */
        String getColumn() {
            return column;
        }

        /**
         * Gets row.
         *
         * @return the row
         */
        int getRow() {
            return row;
        }
    }
}
