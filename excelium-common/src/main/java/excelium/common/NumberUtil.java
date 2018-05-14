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

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Collection of number handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.19
 */
public class NumberUtil {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Gets appropriate numeric value from a double value.
     * This method returns integer or long value if the given number can be written without a fractional component,
     * otherwise, the double value is returned.
     *
     * @param number double value
     * @return numeric value
     */
    public static Object getNumericValue(double number) {
        if (Math.floor(number) == number) return getIntValue(number);
        return number;
    }

    /**
     * Gets integer value from a double value.
     * If the value is over integer's limit, the long value is returned.
     *
     * @param number double value
     * @return integer or long value
     */
    public static Object getIntValue(double number) {
        final double abs = Math.abs(number);
        if (abs <= Integer.MAX_VALUE) {
            return Double.valueOf(number).intValue();
        } else {
            return Double.valueOf(number).longValue();
        }
    }

    /**
     * Parse the given {@code text} into a positive {@link Integer} instance,
     * using the corresponding {@code decode} / {@code valueOf} method.
     * <p>Trims the input {@code String} before attempting to parse the number.
     * <p>Supports numbers in hex format (with leading "0x", "0X", or "#") as well.
     * If the parsed number is below 0, or any exception occurred, returns the default value.
     *
     * @param text         the text to convert
     * @param defaultValue the default value
     * @return the parsed number
     * @see Integer#decode
     */
    public static int parsePositiveInteger(String text, int defaultValue) {
        String trimmed = StringUtils.trim(text);
        int number = -1;
        if (StringUtils.isNotBlank(trimmed)) {
            try {
                number = isHexNumber(trimmed) ? Integer.decode(trimmed) : Integer.valueOf(trimmed);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        if (number < 0) {
            number = defaultValue;
        }
        return number;
    }

    /**
     * Determine whether the given {@code value} String indicates a hex number,
     * i.e. needs to be passed into {@code Integer.decode} instead of
     * {@code Integer.valueOf}, etc.
     *
     * @param value the value
     * @return true if the value is a hex number, otherwise, false
     */
    private static boolean isHexNumber(String value) {
        int index = (value.startsWith("-") ? 1 : 0);
        return (value.startsWith("0x", index) || value.startsWith("0X", index) || value.startsWith("#", index));
    }
}
