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

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of object handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
public class ObjectUtil {

    /**
     * Converts object to string.
     *
     * @param value object
     * @return string value
     */
    public static String getStringValue(Object value) {
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    /**
     * Converts object to boolean
     *
     * @param value object
     * @return boolean value
     */
    public static boolean getBooleanValue(Object value) {
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtils.equalsAnyIgnoreCase(str, "☑", "✓", "✔", "○", "●", "◯")) {
                return true;
            }
            return BooleanUtils.toBoolean(str);
        } else if (value instanceof Integer) {
            return BooleanUtils.toBoolean((Integer) value);
        } else if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return false;
    }

    /**
     * Converts object to list of string.
     * The converted object is split based on commas, new lines.
     *
     * @param value object
     * @return list value
     */
    public static List<String> getListValue(Object value) {
        List<String> valueList = new ArrayList<>();
        if (value != null && StringUtils.isNotBlank(value.toString())) {
            String[] items = value.toString().trim().split("[,\n]");
            for (String item : items) {
                valueList.add(item.trim());
            }
        }
        return valueList;
    }

    /**
     * Determine that two values are equal. The expected is in string format
     * and converted to the corresponding object type before comparing. If
     * <code>expected</code> and <code>actual</code> are <code>null</code>,
     * they are considered equal.
     *
     * @param expected the expected
     * @param actual   the actual
     * @return true, if the values are equal, otherwise, false
     */
    public static boolean checkEquals(String expected, Object actual) {
        if (actual == null) {
            return expected == null;
        }
        Class clazz = actual.getClass();
        if (clazz.equals(Color.class)) {
            return actual.equals(Color.fromString(expected));
        }
        return false;
    }
}
