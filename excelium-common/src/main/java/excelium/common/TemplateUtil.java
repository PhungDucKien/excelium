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

package excelium.common;

import excelium.common.ss.CellLocation;
import excelium.model.project.Template;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Predicate;

/**
 * Collection of template handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
public class TemplateUtil {

    /**
     * Gets markup list.
     * The markups are defined in {@link Template} as public static strings.
     *
     * @return the markup list
     * @throws IllegalAccessException the illegal access exception
     */
    public static List<Object> getMarkups() throws IllegalAccessException {
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
     * Gets map of markups that match the given predicate and their locations.
     *
     * @param template  the template
     * @param predicate the markup predicate
     * @return the map of markups and their locations
     */
    public static Map<Object, String> getMarkupLocations(Template template, Predicate<String> predicate) {
        if (template.getMarkupLocations() == null) {
            return new HashMap<>();
        }
        Map<Object, String> markupLocations = new LinkedHashMap<>();
        for (Object item : template.getMarkupLocations().keySet()) {
            if (item instanceof String) {
                String markup = (String) item;
                if (predicate.test(markup)) {
                    String location = template.getMarkupLocations().get(markup);
                    if (StringUtils.isNotBlank(location)) {
                        markupLocations.put(markup, location);
                    }
                }
            }
        }
        return markupLocations;
    }

    /**
     * Gets map of configuration markups and their locations.
     *
     * @param template the template
     * @return the map of configuration markups and their locations
     */
    public static Map<Object, String> getConfigurationMarkupLocations(Template template) {
        return getMarkupLocations(template,
                s -> !StringUtils.startsWithAny(s, "%MAPPING_", "%ACTION_", "%TEST_", "%DATA_"));
    }

    /**
     * Get the names of configuration sheets.
     * This method lists up all the sheets that contain configuration items.
     *
     * @param template Template
     * @return The names of configuration sheets
     */
    public static List<String> getConfigurationSheets(Template template) {
        List<String> configurationSheets = new ArrayList<>();
        Map<Object, String> configurationMarkupLocations = getConfigurationMarkupLocations(template);
        for (String location : configurationMarkupLocations.values()) {
            CellLocation cellLocation = new CellLocation(location);
            String sheet = cellLocation.getSheetName();

            if (!configurationSheets.contains(sheet)) {
                configurationSheets.add(sheet);
            }
        }
        return configurationSheets;
    }

    /**
     * Get the suggestion for the name of mapping sheet.
     *
     * @param template Template
     * @return The suggestion of the mapping sheet
     */
    public static String getSuggestSheetForMapping(Template template) {
        String mappingItemNameLoc = template.getMarkupLocations().get(Template.MAPPING_ITEM_NAME);
        if (StringUtils.isNotBlank(mappingItemNameLoc)) {
            CellLocation cellLocation = new CellLocation(mappingItemNameLoc);
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
    public static String getSuggestSheetForAction(Template template) {
        String actionNameLoc = template.getMarkupLocations().get(Template.ACTION_COMMAND);
        if (StringUtils.isNotBlank(actionNameLoc)) {
            CellLocation cellLocation = new CellLocation(actionNameLoc);
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
    public static String getSuggestSheetForData(Template template) {
        String dataNameLoc = template.getMarkupLocations().get(Template.DATA_NAME);
        if (StringUtils.isNotBlank(dataNameLoc)) {
            CellLocation cellLocation = new CellLocation(dataNameLoc);
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
    public static String getSuggestSheetForTest(Template template) {
        String testCommandLoc = template.getMarkupLocations().get(Template.TEST_COMMAND);
        if (StringUtils.isNotBlank(testCommandLoc)) {
            CellLocation cellLocation = new CellLocation(testCommandLoc);
            return cellLocation.getSheetName();
        }
        return null;
    }
}
