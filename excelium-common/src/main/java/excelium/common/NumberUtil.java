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
}
