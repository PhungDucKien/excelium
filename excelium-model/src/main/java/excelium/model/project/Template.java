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

package excelium.model.project;

import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents template model.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public class Template {

    /**
     * The constant SYSTEM_NAME.
     */
    public static final String SYSTEM_NAME = "%SYSTEM_NAME%";
    /**
     * The constant SYSTEM_IDENTIFIER.
     */
    public static final String SYSTEM_IDENTIFIER = "%SYSTEM_IDENTIFIER%";
    /**
     * The constant FUNCTION_NAME.
     */
    public static final String FUNCTION_NAME = "%FUNCTION_NAME%";
    /**
     * The constant FUNCTION_IDENTIFIER.
     */
    public static final String FUNCTION_IDENTIFIER = "%FUNCTION_IDENTIFIER%";
    /**
     * The constant BASE_URL.
     */
    public static final String BASE_URL = "%BASE_URL%";

    /**
     * The constant USE_PC.
     */
    public static final String USE_PC = "%USE_PC%";
    /**
     * The constant USE_ANDROID.
     */
    public static final String USE_ANDROID = "%USE_ANDROID%";
    /**
     * The constant USE_IOS.
     */
    public static final String USE_IOS = "%USE_IOS%";

    /**
     * The constant USE_CHROME.
     */
    public static final String USE_CHROME = "%USE_CHROME%";
    /**
     * The constant USE_FIREFOX.
     */
    public static final String USE_FIREFOX = "%USE_FIREFOX%";
    /**
     * The constant USE_IE.
     */
    public static final String USE_IE = "%USE_IE%";
    /**
     * The constant USE_EDGE.
     */
    public static final String USE_EDGE = "%USE_EDGE%";
    /**
     * The constant USE_SAFARI.
     */
    public static final String USE_SAFARI = "%USE_SAFARI%";
    /**
     * The constant USE_OPERA.
     */
    public static final String USE_OPERA = "%USE_OPERA%";

    /**
     * The constant CHROME_VERSION.
     */
    public static final String CHROME_VERSION = "%CHROME_VERSION%";
    /**
     * The constant FIREFOX_VERSION.
     */
    public static final String FIREFOX_VERSION = "%FIREFOX_VERSION%";
    /**
     * The constant IE_VERSION.
     */
    public static final String IE_VERSION = "%IE_VERSION%";
    /**
     * The constant EDGE_VERSION.
     */
    public static final String EDGE_VERSION = "%EDGE_VERSION%";
    /**
     * The constant SAFARI_VERSION.
     */
    public static final String SAFARI_VERSION = "%SAFARI_VERSION%";
    /**
     * The constant OPERA_VERSION.
     */
    public static final String OPERA_VERSION = "%OPERA_VERSION%";

    /**
     * The constant CHROME_RESOLUTION.
     */
    public static final String CHROME_RESOLUTION = "%CHROME_RESOLUTION%";
    /**
     * The constant FIREFOX_RESOLUTION.
     */
    public static final String FIREFOX_RESOLUTION = "%FIREFOX_RESOLUTION%";
    /**
     * The constant IE_RESOLUTION.
     */
    public static final String IE_RESOLUTION = "%IE_RESOLUTION%";
    /**
     * The constant EDGE_RESOLUTION.
     */
    public static final String EDGE_RESOLUTION = "%EDGE_RESOLUTION%";
    /**
     * The constant SAFARI_RESOLUTION.
     */
    public static final String SAFARI_RESOLUTION = "%SAFARI_RESOLUTION%";
    /**
     * The constant OPERA_RESOLUTION.
     */
    public static final String OPERA_RESOLUTION = "%OPERA_RESOLUTION%";

    /**
     * The constant ANDROID_PLATFORM_VERSION.
     */
    public static final String ANDROID_PLATFORM_VERSION = "%ANDROID_PLATFORM_VERSION%";
    /**
     * The constant ANDROID_DEVICE_NAME.
     */
    public static final String ANDROID_DEVICE_NAME = "%ANDROID_DEVICE_NAME%";
    /**
     * The constant ANDROID_ORIENTATION.
     */
    public static final String ANDROID_ORIENTATION = "%ANDROID_ORIENTATION%";
    /**
     * The constant ANDROID_UDID.
     */
    public static final String ANDROID_UDID = "%ANDROID_UDID%";
    /**
     * The constant ANDROID_BROWSER.
     */
    public static final String ANDROID_BROWSER = "%ANDROID_BROWSER%";
    /**
     * The constant ANDROID_APP.
     */
    public static final String ANDROID_APP = "%ANDROID_APP%";
    /**
     * The constant ANDROID_APP_ACTIVITY.
     */
    public static final String ANDROID_APP_ACTIVITY = "%ANDROID_APP_ACTIVITY%";
    /**
     * The constant ANDROID_APP_PACKAGE.
     */
    public static final String ANDROID_APP_PACKAGE = "%ANDROID_APP_PACKAGE%";
    /**
     * The constant ANDROID_APP_WAIT_ACTIVITY.
     */
    public static final String ANDROID_APP_WAIT_ACTIVITY = "%ANDROID_APP_WAIT_ACTIVITY%";
    /**
     * The constant ANDROID_APP_WAIT_PACKAGE.
     */
    public static final String ANDROID_APP_WAIT_PACKAGE = "%ANDROID_APP_WAIT_PACKAGE%";

    /**
     * The constant IOS_PLATFORM_VERSION.
     */
    public static final String IOS_PLATFORM_VERSION = "%IOS_PLATFORM_VERSION%";
    /**
     * The constant IOS_DEVICE_NAME.
     */
    public static final String IOS_DEVICE_NAME = "%IOS_DEVICE_NAME%";
    /**
     * The constant IOS_ORIENTATION.
     */
    public static final String IOS_ORIENTATION = "%IOS_ORIENTATION%";
    /**
     * The constant IOS_UDID.
     */
    public static final String IOS_UDID = "%IOS_UDID%";
    /**
     * The constant IOS_BROWSER.
     */
    public static final String IOS_BROWSER = "%IOS_BROWSER%";
    /**
     * The constant IOS_APP.
     */
    public static final String IOS_APP = "%IOS_APP%";

    /**
     * The constant MAPPING_PAGESET_NAME.
     */
    public static final String MAPPING_PAGESET_NAME = "%MAPPING_PAGESET_NAME%";
    /**
     * The constant MAPPING_PAGESET_DESC.
     */
    public static final String MAPPING_PAGESET_DESC = "%MAPPING_PAGESET_DESC%";
    /**
     * The constant MAPPING_PAGESET_PATH.
     */
    public static final String MAPPING_PAGESET_PATH = "%MAPPING_PAGESET_PATH%";
    /**
     * The constant MAPPING_PAGESET_TITLE.
     */
    public static final String MAPPING_PAGESET_TITLE = "%MAPPING_PAGESET_TITLE%";

    /**
     * The constant MAPPING_ITEM_NAME.
     */
    public static final String MAPPING_ITEM_NAME = "%MAPPING_ITEM_NAME%";
    /**
     * The constant MAPPING_ITEM_DESC.
     */
    public static final String MAPPING_ITEM_DESC = "%MAPPING_ITEM_DESC%";
    /**
     * The constant MAPPING_ITEM_VALUE.
     */
    public static final String MAPPING_ITEM_VALUE = "%MAPPING_ITEM_VALUE%";
    /**
     * The constant MAPPING_ITEM_ANDROID_VALUE.
     */
    public static final String MAPPING_ITEM_ANDROID_VALUE = "%MAPPING_ITEM_ANDROID_VALUE%";
    /**
     * The constant MAPPING_ITEM_IOS_VALUE.
     */
    public static final String MAPPING_ITEM_IOS_VALUE = "%MAPPING_ITEM_IOS_VALUE%";

    /**
     * The constant ACTION_NO.
     */
    public static final String ACTION_NO = "%ACTION_NO%";
    /**
     * The constant ACTION_GUTTER.
     */
    public static final String ACTION_GUTTER = "%ACTION_GUTTER%";
    /**
     * The constant ACTION_ANDROID_GUTTER.
     */
    public static final String ACTION_ANDROID_GUTTER = "%ACTION_ANDROID_GUTTER%";
    /**
     * The constant ACTION_IOS_GUTTER.
     */
    public static final String ACTION_IOS_GUTTER = "%ACTION_IOS_GUTTER%";
    /**
     * The constant ACTION_CAPTURE.
     */
    public static final String ACTION_CAPTURE = "%ACTION_CAPTURE%";
    /**
     * The constant ACTION_NAME.
     */
    public static final String ACTION_NAME = "%ACTION_NAME%";
    /**
     * The constant ACTION_DESC.
     */
    public static final String ACTION_DESC = "%ACTION_DESC%";
    /**
     * The constant ACTION_COMMAND.
     */
    public static final String ACTION_COMMAND = "%ACTION_COMMAND%";
    /**
     * The constant ACTION_PARAM1.
     */
    public static final String ACTION_PARAM1 = "%ACTION_PARAM1%";
    /**
     * The constant ACTION_PARAM2.
     */
    public static final String ACTION_PARAM2 = "%ACTION_PARAM2%";
    /**
     * The constant ACTION_PARAM3.
     */
    public static final String ACTION_PARAM3 = "%ACTION_PARAM3%";
    /**
     * The constant ACTION_DATA.
     */
    public static final String ACTION_DATA = "%ACTION_DATA%";

    /**
     * The constant TEST_NO.
     */
    public static final String TEST_NO = "%TEST_NO%";
    /**
     * The constant TEST_GUTTER.
     */
    public static final String TEST_GUTTER = "%TEST_GUTTER%";
    /**
     * The constant TEST_ANDROID_GUTTER.
     */
    public static final String TEST_ANDROID_GUTTER = "%TEST_ANDROID_GUTTER%";
    /**
     * The constant TEST_IOS_GUTTER.
     */
    public static final String TEST_IOS_GUTTER = "%TEST_IOS_GUTTER%";
    /**
     * The constant TEST_CAPTURE.
     */
    public static final String TEST_CAPTURE = "%TEST_CAPTURE%";
    /**
     * The constant TEST_NAME.
     */
    public static final String TEST_NAME = "%TEST_NAME%";
    /**
     * The constant TEST_DESC.
     */
    public static final String TEST_DESC = "%TEST_DESC%";
    /**
     * The constant TEST_COMMAND.
     */
    public static final String TEST_COMMAND = "%TEST_COMMAND%";
    /**
     * The constant TEST_PARAM1.
     */
    public static final String TEST_PARAM1 = "%TEST_PARAM1%";
    /**
     * The constant TEST_PARAM2.
     */
    public static final String TEST_PARAM2 = "%TEST_PARAM2%";
    /**
     * The constant TEST_PARAM3.
     */
    public static final String TEST_PARAM3 = "%TEST_PARAM3%";
    /**
     * The constant TEST_DATA.
     */
    public static final String TEST_DATA = "%TEST_DATA%";
    /**
     * The constant TEST_DATE.
     */
    public static final String TEST_DATE = "%TEST_DATE%";
    /**
     * The constant TEST_PERSON.
     */
    public static final String TEST_PERSON = "%TEST_PERSON%";
    /**
     * The constant TEST_RESULT.
     */
    public static final String TEST_RESULT = "%TEST_RESULT%";

    /**
     * The constant DATA_NAME.
     */
    public static final String DATA_NAME = "%DATA_NAME%";
    /**
     * The constant DATA_DESC.
     */
    public static final String DATA_DESC = "%DATA_DESC%";
    /**
     * The constant DATA_BODY.
     */
    public static final String DATA_BODY = "%DATA_BODY%";

    /** Template location. File path or spreadsheet ID */
    private String location;

    /** Template name */
    private String name;

    /**
     * Markup locations. This store a map of markup and its location in the template.
     */
    private Map<Object, String> markupLocations;

    /**
     * Pattern for name of the sheet that should be considered as configuration sheet.
     */
    private String configurationPattern;

    /**
     * Pattern for name of sheets that should be considered as mapping item sheets.
     */
    private String mappingPattern;

    /**
     * Pattern for name of sheets that should be considered as action sheets.
     */
    private String actionPattern;

    /**
     * Pattern for name of sheets that should be considered as data sheets.
     */
    private String dataPattern;

    /**
     * Pattern for name of sheets that should be considered as test sheets.
     */
    private String testPattern;

    /**
     * Pattern for name of sheets that should be ignored.
     */
    private List<String> ignorePatterns;

    /**
     * Gets markup list.
     *
     * @return the markup list
     * @throws IllegalAccessException the illegal access exception
     */
    public static List<Object> getMarkupList() throws IllegalAccessException {
        Template template = new Template();
        List<Object> values = new ArrayList<>();
        Field[] fields = Template.class.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getType().equals(String.class)) {
                    values.add(field.get(template));
                }
            }
        }
        return values;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets markup locations.
     *
     * @return the markup locations
     */
    public Map<Object, String> getMarkupLocations() {
        return markupLocations;
    }

    /**
     * Sets markup locations.
     *
     * @param markupLocations the markup locations
     */
    public void setMarkupLocations(Map<Object, String> markupLocations) {
        this.markupLocations = markupLocations;
    }

    /**
     * Gets configuration pattern.
     *
     * @return the configuration pattern
     */
    public String getConfigurationPattern() {
        return configurationPattern;
    }

    /**
     * Sets configuration pattern.
     *
     * @param configurationPattern the configuration pattern
     */
    public void setConfigurationPattern(String configurationPattern) {
        this.configurationPattern = configurationPattern;
    }

    /**
     * Gets mapping pattern.
     *
     * @return the mapping pattern
     */
    public String getMappingPattern() {
        return mappingPattern;
    }

    /**
     * Sets mapping pattern.
     *
     * @param mappingPattern the mapping pattern
     */
    public void setMappingPattern(String mappingPattern) {
        this.mappingPattern = mappingPattern;
    }

    /**
     * Gets action pattern.
     *
     * @return the action pattern
     */
    public String getActionPattern() {
        return actionPattern;
    }

    /**
     * Sets action pattern.
     *
     * @param actionPattern the action pattern
     */
    public void setActionPattern(String actionPattern) {
        this.actionPattern = actionPattern;
    }

    /**
     * Gets data pattern.
     *
     * @return the data pattern
     */
    public String getDataPattern() {
        return dataPattern;
    }

    /**
     * Sets data pattern.
     *
     * @param dataPattern the data pattern
     */
    public void setDataPattern(String dataPattern) {
        this.dataPattern = dataPattern;
    }

    /**
     * Gets test pattern.
     *
     * @return the test pattern
     */
    public String getTestPattern() {
        return testPattern;
    }

    /**
     * Sets test pattern.
     *
     * @param testPattern the test pattern
     */
    public void setTestPattern(String testPattern) {
        this.testPattern = testPattern;
    }

    /**
     * Gets ignore patterns.
     *
     * @return the ignore patterns
     */
    @XmlElement(name="ignorePattern")
    public List<String> getIgnorePatterns() {
        return ignorePatterns;
    }

    /**
     * Sets ignore patterns.
     *
     * @param ignorePatterns the ignore patterns
     */
    public void setIgnorePatterns(List<String> ignorePatterns) {
        this.ignorePatterns = ignorePatterns;
    }

    /**
     * Add ignore pattern.
     *
     * @param ignorePattern the ignore pattern
     */
    public void addIgnorePattern(String ignorePattern) {
        if (ignorePatterns == null) {
            ignorePatterns = new ArrayList<>();
        }
        ignorePatterns.add(ignorePattern);
    }
}
