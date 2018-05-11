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

package excelium.core.context;

import org.joda.time.DateTime;
import org.joda.time.MutablePeriod;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.format.PeriodParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The namespace that is used to resolve functions.
 *
 * @author PhungDucKien
 * @since 2018.05.10
 */
public class FunctionNamespace {

    /**
     * Adds or subtracts dates.
     * The period string can be expressed like "15 years and 8 months".
     *
     * @param date   the date
     * @param period human readable period string
     * @return the result date
     */
    public LocalDate DATE_ADD(LocalDate date, String period) {
        long days = parsePeriod(period).toDurationFrom(new DateTime(0)).getStandardDays();
        return date.plusDays(days);
    }

    /**
     * Formats dates using the given date format pattern.
     *
     * @param date   the date
     * @param format the date format pattern
     * @return the date string
     */
    public String DATE_FORMAT(LocalDate date, String format) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(format);
        return date.format(dateTimeFormat);
    }

    /**
     * Parses human readable period string to period.
     * The period string can be expressed like "15 years and 8 months".
     *
     * @param period human readable period string
     * @return the period
     */
    private MutablePeriod parsePeriod(String period) {
        PeriodParser parser = new PeriodFormatterBuilder()
                .appendYears()
                .appendSuffix(" year", " years")
                .appendSeparator(" ", " ", new String[] { " and "})
                .appendMonths()
                .appendSuffix(" month", " months")
                .appendSeparator(" ", " ", new String[] { " and "})
                .appendWeeks()
                .appendSuffix(" week", " weeks")
                .appendSeparator(" ", " ", new String[] { " and "})
                .appendDays()
                .appendSuffix(" day", " days")
                .appendSeparator(" ", " ", new String[] { " and "})
                .appendHours()
                .appendSuffix(" hour", " hours")
                .appendSeparator(" ", " ", new String[] { " and "})
                .appendMinutes()
                .appendSuffix(" minute", " minutes")
                .appendSeparator(" ", " ", new String[] { " and "})
                .appendSeconds()
                .appendSuffix(" second", " seconds")
                .toParser();

        MutablePeriod mutablePeriod = new MutablePeriod();
        parser.parseInto(mutablePeriod, period, 0, Locale.getDefault());
        return mutablePeriod;
    }
}
