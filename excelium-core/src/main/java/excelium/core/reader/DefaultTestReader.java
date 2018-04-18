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

import excelium.common.TemplateUtil;
import excelium.common.WildcardUtil;
import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.project.Template;
import excelium.model.test.Test;
import excelium.model.test.config.Environment;
import excelium.model.test.config.TestConfig;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static excelium.common.EnvironmentUtil.*;
import static excelium.common.ObjectUtil.*;

/**
 * Implements the default {@link TestReader}.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.10
 */
public abstract class DefaultTestReader<W, S> extends BaseTestReader<W, S> {

    @Override
    public Test<W, S> parseTest(Template template) throws IOException {
        Test<W, S> test = new Test<>();
        test.setWorkbookName(getWorkbookName());
        parseTest(test, template);
        return test;
    }

    /**
     * Parses test file.
     *
     * @param test     Test object
     * @param template Template object
     * @throws IOException if the IOException occurs
     */
    private void parseTest(Test<W, S> test, Template template) throws IOException {
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

        setTestConfig(test, template);
    }

    /**
     * Sets test configuration.
     *
     * @param test     Test
     * @param template Template
     * @throws IOException if the IOException occurs
     */
    private void setTestConfig(Test<W, S> test, Template template) throws IOException {
        Map<Object, String> configurationMarkupLocations = TemplateUtil.getConfigurationMarkupLocations(template);
        String[] configurationLocations = configurationMarkupLocations.values().toArray(new String[0]);
        Map<Object, Object> values = getMarkupValues(configurationMarkupLocations, getBatchCellValues(configurationLocations));

        String baseUrl = getStringValue(values.get(Template.BASE_URL));
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
        boolean pcEnabled = getBooleanValue(configurationValues.get(Template.USE_PC));
        boolean androidEnabled = getBooleanValue(configurationValues.get(Template.USE_ANDROID));
        boolean iOsEnabled = getBooleanValue(configurationValues.get(Template.USE_IOS));

        // PC Configurations
        boolean chromeEnabled = getBooleanValue(configurationValues.get(Template.USE_CHROME));
        boolean firefoxEnabled = getBooleanValue(configurationValues.get(Template.USE_FIREFOX));
        boolean ieEnabled = getBooleanValue(configurationValues.get(Template.USE_IE));
        boolean edgeEnabled = getBooleanValue(configurationValues.get(Template.USE_EDGE));
        boolean safariEnabled = getBooleanValue(configurationValues.get(Template.USE_SAFARI));
        boolean operaEnabled = getBooleanValue(configurationValues.get(Template.USE_OPERA));

        List<String> chromeVersions = getListValue(configurationValues.get(Template.CHROME_VERSION));
        List<String> firefoxVersions = getListValue(configurationValues.get(Template.FIREFOX_VERSION));
        List<String> ieVersions = getListValue(configurationValues.get(Template.IE_VERSION));
        List<String> edgeVersions = getListValue(configurationValues.get(Template.EDGE_VERSION));
        List<String> safariVersions = getListValue(configurationValues.get(Template.SAFARI_VERSION));
        List<String> operaVersions = getListValue(configurationValues.get(Template.OPERA_VERSION));

        List<String> chromeResolutions = getListValue(configurationValues.get(Template.CHROME_RESOLUTION));
        List<String> firefoxResolutions = getListValue(configurationValues.get(Template.FIREFOX_RESOLUTION));
        List<String> ieResolutions = getListValue(configurationValues.get(Template.IE_RESOLUTION));
        List<String> edgeResolutions = getListValue(configurationValues.get(Template.EDGE_RESOLUTION));
        List<String> safariResolutions = getListValue(configurationValues.get(Template.SAFARI_RESOLUTION));
        List<String> operaResolutions = getListValue(configurationValues.get(Template.OPERA_RESOLUTION));

        // Mobile Configurations
        List<String> androidVersions = getListValue(configurationValues.get(Template.ANDROID_PLATFORM_VERSION));
        List<String> iOsVersions = getListValue(configurationValues.get(Template.IOS_PLATFORM_VERSION));
        List<String> androidDevices = getListValue(configurationValues.get(Template.ANDROID_DEVICE_NAME));
        List<String> iOsDevices = getListValue(configurationValues.get(Template.IOS_DEVICE_NAME));
        List<String> androidOrientations = getListValue(configurationValues.get(Template.ANDROID_ORIENTATION));
        List<String> iOsOrientations = getListValue(configurationValues.get(Template.IOS_ORIENTATION));

        // Mobile web configurations
        List<String> androidBrowsers = getListValue(configurationValues.get(Template.ANDROID_BROWSER));
        List<String> iOsBrowsers = getListValue(configurationValues.get(Template.IOS_BROWSER));

        // Mobile app configurations
        String androidApkPath = getStringValue(configurationValues.get(Template.ANDROID_APP));
        String iOsIpaPath = getStringValue(configurationValues.get(Template.IOS_APP));
        String androidAppActivity = getStringValue(configurationValues.get(Template.ANDROID_APP_ACTIVITY));
        String androidAppPackage = getStringValue(configurationValues.get(Template.ANDROID_APP_PACKAGE));
        String androidAppWaitActivity = getStringValue(configurationValues.get(Template.ANDROID_APP_WAIT_ACTIVITY));
        String androidAppWaitPackage = getStringValue(configurationValues.get(Template.ANDROID_APP_WAIT_PACKAGE));

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
                environments.addAll(getAvailableMobileAppEnvironments(Platform.ANDROID, androidVersions, androidDevices, androidOrientations, androidApkPath, androidAppActivity, androidAppPackage, androidAppWaitActivity, androidAppWaitPackage));
            } else {
                environments.addAll(getAvailableMobileWebEnvironments(Platform.ANDROID, androidVersions, androidDevices, androidOrientations, androidBrowsers));
            }
        }

        if (iOsEnabled) {
            if (CollectionUtils.isEmpty(iOsBrowsers)) {
                environments.addAll(getAvailableMobileAppEnvironments(Platform.IOS, iOsVersions, iOsDevices, iOsOrientations, iOsIpaPath, null, null, null, null));
            } else {
                environments.addAll(getAvailableMobileWebEnvironments(Platform.IOS, iOsVersions, iOsDevices, iOsOrientations, iOsBrowsers));
            }
        }

        return environments;
    }

    /**
     * Maps markup to markup values.
     *
     * @param markupLocations Map of markup and its location
     * @param cellValues      Map of location and its values
     * @return Map of markup and its values
     */
    private Map<Object, Object> getMarkupValues(Map<Object, String> markupLocations, Map<String, Object> cellValues) {
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
     * Filter sheets that their names match the given wildcard pattern.
     *
     * @param sheets  List of sheets
     * @param pattern the wildcard pattern
     * @return the filtered sheets
     * @throws IOException if the IOException occurs
     */
    private List<S> filterSheets(List<S> sheets, String pattern) throws IOException {
        List<String> patterns = new ArrayList<>();
        patterns.add(pattern);
        return filterSheets(sheets, patterns);
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
            for (String pattern : patterns) {
                if (WildcardUtil.isMatch(sheetName, pattern)) {
                    isMatch = true;
                    break;
                }
            }
            if (isMatch) {
                filteredSheets.add(sheet);
            }
        }
        return filteredSheets;
    }
}
