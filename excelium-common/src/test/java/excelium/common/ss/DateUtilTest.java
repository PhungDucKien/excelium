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

/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package excelium.common.ss;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.util.Calendar.*;
import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void getJavaDate_InvalidValue() {
        double dateValue = -1;
        TimeZone tz = TimeZone.getDefault();
        boolean use1904windowing = false;
        boolean roundSeconds = false;

        assertEquals(null, DateUtil.getJavaDate(dateValue));
        assertEquals(null, DateUtil.getJavaDate(dateValue, tz));
        assertEquals(null, DateUtil.getJavaDate(dateValue, use1904windowing));
        assertEquals(null, DateUtil.getJavaDate(dateValue, use1904windowing, tz));
        assertEquals(null, DateUtil.getJavaDate(dateValue, use1904windowing, tz, roundSeconds));
    }

    @Test
    public void getJavaDate_ValidValue() {
        double dateValue = 0;
        TimeZone tz = TimeZone.getDefault();
        boolean use1904windowing = false;
        boolean roundSeconds = false;

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.set(1900, 0, 0, 0, 0, 0);
        calendar.clear(Calendar.MILLISECOND);
        Date date = calendar.getTime();

        assertEquals(date, DateUtil.getJavaDate(dateValue));
        assertEquals(date, DateUtil.getJavaDate(dateValue, tz));
        assertEquals(date, DateUtil.getJavaDate(dateValue, use1904windowing));
        assertEquals(date, DateUtil.getJavaDate(dateValue, use1904windowing, tz));
        assertEquals(date, DateUtil.getJavaDate(dateValue, use1904windowing, tz, roundSeconds));
    }

    @Test
    public void getJavaCalendar_InvalidValue() {
        double dateValue = -1;
        TimeZone tz = TimeZone.getDefault();
        boolean use1904windowing = false;
        boolean roundSeconds = false;

        assertEquals(null, DateUtil.getJavaCalendar(dateValue));
        assertEquals(null, DateUtil.getJavaCalendar(dateValue, use1904windowing));
        assertEquals(null, DateUtil.getJavaCalendar(dateValue, use1904windowing, tz));
        assertEquals(null, DateUtil.getJavaCalendar(dateValue, use1904windowing, tz, roundSeconds));
    }

    @Test
    public void getJavaCalendar_ValidValue() {
        double dateValue = 0;
        TimeZone tz = TimeZone.getDefault();
        boolean use1904windowing = false;
        boolean roundSeconds = false;

        Calendar expCal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        expCal.set(1900, 0, 0, 0, 0, 0);
        expCal.clear(Calendar.MILLISECOND);

        Calendar actCal[] = {
                DateUtil.getJavaCalendar(dateValue),
                DateUtil.getJavaCalendar(dateValue, use1904windowing),
                DateUtil.getJavaCalendar(dateValue, use1904windowing, tz),
                DateUtil.getJavaCalendar(dateValue, use1904windowing, tz, roundSeconds)
        };
        assertEquals(expCal, actCal[0]);
        assertEquals(expCal, actCal[1]);
        assertEquals(expCal, actCal[2]);
        assertEquals(expCal, actCal[3]);
    }

    @Test
    public void isADateFormat() {
        // Cell content 2016-12-8 as an example
        // Cell show "12/8/2016"
        assertTrue(DateUtil.isADateFormat("m/d/yy"));
        // Cell show "Thursday, December 8, 2016"
        assertTrue(DateUtil.isADateFormat("[$-F800]dddd\\,\\ mmmm\\ dd\\,\\ yyyy"));
        // Cell show "12/8"
        assertTrue(DateUtil.isADateFormat("m/d;@"));
        // Cell show "12/08/16"
        assertTrue(DateUtil.isADateFormat("mm/dd/yy;@"));
        // Cell show "8-Dec-16"
        assertTrue(DateUtil.isADateFormat("[$-409]d\\-mmm\\-yy;@"));
        // Cell show "D-16"
        assertTrue(DateUtil.isADateFormat("[$-409]mmmmm\\-yy;@"));

        // Cell show "2016年12月8日"
        assertTrue(DateUtil.isADateFormat("yyyy\"\u5e74\"m\"\u6708\"d\"\u65e5\";@"));
        // Cell show "2016年12月"
        assertTrue(DateUtil.isADateFormat("yyyy\"\u5e74\"m\"\u6708\";@"));
        // Cell show "12月8日"
        assertTrue(DateUtil.isADateFormat("m\"\u6708\"d\"\u65e5\";@"));
        // Cell show "十二月八日"
        assertTrue(DateUtil.isADateFormat("[DBNum1][$-404]m\"\u6708\"d\"\u65e5\";@"));
        // Cell show "贰零壹陆年壹拾贰月捌日"
        assertTrue(DateUtil.isADateFormat("[DBNum2][$-804]yyyy\"\u5e74\"m\"\u6708\"d\"\u65e5\";@"));
        // Cell show "２０１６年１２月８日"
        assertTrue(DateUtil.isADateFormat("[DBNum3][$-804]yyyy\"\u5e74\"m\"\u6708\"d\"\u65e5\";@"));
    }

    /**
     * Checks the date conversion functions in the DateUtil class.
     */
    @Test
    public void dateConversion() {

        // Iteratating over the hours exposes any rounding issues.
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(2002, JANUARY, 1, 0, 1, 1);
        cal.clear(Calendar.MILLISECOND);
        for (int hour = 0; hour < 23; hour++) {
            double excelDate = DateUtil.getExcelDate(cal.getTime(), false);

            assertEquals("Checking hour = " + hour, cal.getTime().getTime(),
                    DateUtil.getJavaDate(excelDate, false).getTime());

            cal.add(Calendar.HOUR_OF_DAY, 1);
        }

        // check 1900 and 1904 date windowing conversions
        double excelDate = 36526.0;
        // with 1900 windowing, excelDate is Jan. 1, 2000
        // with 1904 windowing, excelDate is Jan. 2, 2004
        cal.set(2000, JANUARY, 1, 0, 0, 0); // Jan. 1, 2000
        Date dateIf1900 = cal.getTime();
        cal.add(Calendar.YEAR, 4); // now Jan. 1, 2004
        cal.add(Calendar.DATE, 1); // now Jan. 2, 2004
        Date dateIf1904 = cal.getTime();
        // 1900 windowing
        assertEquals("Checking 1900 Date Windowing",
                dateIf1900.getTime(),
                DateUtil.getJavaDate(excelDate, false).getTime());
        // 1904 windowing
        assertEquals("Checking 1904 Date Windowing",
                dateIf1904.getTime(),
                DateUtil.getJavaDate(excelDate, true).getTime());
    }

    /**
     * Checks the conversion of a java.util.date to Excel on a day when
     * Daylight Saving Time starts.
     */
    @Test
    public void excelConversionOnDSTStart() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(2004, MARCH, 28, 0, 0, 0);
        cal.clear(Calendar.MILLISECOND);
        for (int hour = 0; hour < 24; hour++) {

            // Skip 02:00 CET as that is the Daylight change time
            // and Java converts it automatically to 03:00 CEST
            if (hour == 2) {
                continue;
            }

            cal.set(Calendar.HOUR_OF_DAY, hour);
            Date javaDate = cal.getTime();


            double excelDate = DateUtil.getExcelDate(javaDate, false);
            double difference = excelDate - Math.floor(excelDate);
            int differenceInHours = (int) (difference * 24 * 60 + 0.5) / 60;
            assertEquals("Checking " + hour + " hour on Daylight Saving Time start date",
                    hour,
                    differenceInHours);
            assertEquals("Checking " + hour + " hour on Daylight Saving Time start date",
                    javaDate.getTime(),
                    DateUtil.getJavaDate(excelDate, false).getTime());
        }
    }

    /**
     * Checks the conversion of an Excel date to a java.util.date on a day when
     * Daylight Saving Time starts.
     */
    @Test
    public void javaConversionOnDSTStart() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(2004, MARCH, 28, 0, 0, 0);
        cal.clear(Calendar.MILLISECOND);
        double excelDate = DateUtil.getExcelDate(cal.getTime(), false);
        double oneHour = 1.0 / 24;
        double oneMinute = oneHour / 60;
        for (int hour = 0; hour < 24; hour++, excelDate += oneHour) {

            // Skip 02:00 CET as that is the Daylight change time
            // and Java converts it automatically to 03:00 CEST
            if (hour == 2) {
                continue;
            }

            cal.set(Calendar.HOUR_OF_DAY, hour);
            Date javaDate = DateUtil.getJavaDate(excelDate, false);
            double actDate = DateUtil.getExcelDate(javaDate, false);
            assertEquals("Checking " + hour + " hours on Daylight Saving Time start date",
                    excelDate, actDate, oneMinute);
        }
    }

    /**
     * Checks the conversion of a java.util.Date to Excel on a day when
     * Daylight Saving Time ends.
     */
    @Test
    public void excelConversionOnDSTEnd() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(2004, OCTOBER, 31, 0, 0, 0);
        cal.clear(Calendar.MILLISECOND);
        for (int hour = 0; hour < 24; hour++) {
            cal.set(Calendar.HOUR_OF_DAY, hour);
            Date javaDate = cal.getTime();
            double excelDate = DateUtil.getExcelDate(javaDate, false);
            double difference = excelDate - Math.floor(excelDate);
            int differenceInHours = (int) (difference * 24 * 60 + 0.5) / 60;
            assertEquals("Checking " + hour + " hour on Daylight Saving Time end date",
                    hour,
                    differenceInHours);
            assertEquals("Checking " + hour + " hour on Daylight Saving Time start date",
                    javaDate.getTime(),
                    DateUtil.getJavaDate(excelDate, false).getTime());
        }
    }

    /**
     * Checks the conversion of an Excel date to java.util.Date on a day when
     * Daylight Saving Time ends.
     */
    @Test
    public void javaConversionOnDSTEnd() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(2004, OCTOBER, 31, 0, 0, 0);
        cal.clear(Calendar.MILLISECOND);
        double excelDate = DateUtil.getExcelDate(cal.getTime(), false);
        double oneHour = 1.0 / 24;
        double oneMinute = oneHour / 60;
        for (int hour = 0; hour < 24; hour++, excelDate += oneHour) {
            cal.set(Calendar.HOUR_OF_DAY, hour);
            Date javaDate = DateUtil.getJavaDate(excelDate, false);
            assertEquals("Checking " + hour + " hours on Daylight Saving Time start date",
                    excelDate,
                    DateUtil.getExcelDate(javaDate, false), oneMinute);
        }
    }

    /**
     * Tests that we deal with time-zones properly
     */
    @Test
    public void calendarConversion() {
        try {
            Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            cal.set(2002, JANUARY, 1, 12, 1, 1);
            cal.clear(Calendar.MILLISECOND);
            Date expected = cal.getTime();

            // Iterating over the hours exposes any rounding issues.
            for (int hour = -12; hour <= 12; hour++) {
                String id = "GMT" + (hour < 0 ? "" : "+") + hour + ":00";
                cal.setTimeZone(TimeZone.getTimeZone(id));
                cal.set(Calendar.HOUR_OF_DAY, 12);
                double excelDate = DateUtil.getExcelDate(cal, false);
                Date javaDate = DateUtil.getJavaDate(excelDate);

                // Should match despite time-zone
                assertEquals("Checking timezone " + id, expected.getTime(), javaDate.getTime());
            }

            // Check that the timezone aware getter works correctly
            TimeZone cet = TimeZone.getTimeZone("Europe/Copenhagen");
            TimeZone ldn = TimeZone.getTimeZone("Europe/London");

            // 12:45 on 27th April 2012
            double excelDate = 41026.53125;

            // Same, no change
            assertEquals(
                    DateUtil.getJavaDate(excelDate, false).getTime(),
                    DateUtil.getJavaDate(excelDate, false, TimeZone.getDefault()).getTime()
            );

            // London vs Copenhagen, should differ by an hour
            Date cetDate = DateUtil.getJavaDate(excelDate, false, cet);
            Date ldnDate = DateUtil.getJavaDate(excelDate, false, ldn);
            assertEquals(ldnDate.getTime() - cetDate.getTime(), 60 * 60 * 1000);
        } finally {
        }
    }

    /**
     * Tests that we correctly detect date formats as such
     */
    @Test
    public void identifyDateFormats() {
        // First up, try with a few built in date formats
        String[] builtins = new String[]{"m/d/yy", "d-mmm-yy", "d-mmm", "m/d/yy h:mm", "mm:ss", "[h]:mm:ss"};
        for (String builtin : builtins) {
            assertTrue(DateUtil.isInternalDateFormat(builtin));
            assertTrue(DateUtil.isADateFormat(builtin));
        }

        // Now try a few built-in non date formats
        builtins = new String[]{"0", "0.00", "#,##0.00_);(#,##0.00)", "_($* #,##0.00_);_($* (#,##0.00);_($* \"-\"??_);_(@_)", "##0.0E+0"};
        for (String builtin : builtins) {
            assertFalse(DateUtil.isInternalDateFormat(builtin));
            assertFalse(DateUtil.isADateFormat(builtin));
        }

        // Now for some non-internal ones
        // These come after the real ones

        // Valid ones first
        String[] formats = new String[]{
                "yyyy-mm-dd", "yyyy/mm/dd", "yy/mm/dd", "yy/mmm/dd",
                "dd/mm/yy", "dd/mm/yyyy", "dd/mmm/yy",
                "dd-mm-yy", "dd-mm-yyyy",
                "DD-MM-YY", "DD-mm-YYYY",
                "dd\\-mm\\-yy", // Sometimes escaped
                "dd.mm.yyyy", "dd\\.mm\\.yyyy",
                "dd\\ mm\\.yyyy AM", "dd\\ mm\\.yyyy pm",
                "dd\\ mm\\.yyyy\\-dd", "[h]:mm:ss",
                "mm/dd/yy", "\"mm\"/\"dd\"/\"yy\"",
                "m\\/d\\/yyyy",

                // These crazy ones are valid
                "yyyy-mm-dd;@", "yyyy/mm/dd;@",
                "dd-mm-yy;@", "dd-mm-yyyy;@",
                // These even crazier ones are also valid
                // (who knows what they mean though...)
                "[$-F800]dddd\\,\\ mmm\\ dd\\,\\ yyyy",
                "[$-F900]ddd/mm/yyy",
                // These ones specify colours, who knew that was allowed?
                "[BLACK]dddd/mm/yy",
                "[yeLLow]yyyy-mm-dd"
        };
        for (String format : formats) {
            assertTrue(
                    format + " is a date format",
                    DateUtil.isADateFormat(format)
            );
        }

        // Then time based ones too
        formats = new String[]{
                "yyyy-mm-dd hh:mm:ss", "yyyy/mm/dd HH:MM:SS",
                "mm/dd HH:MM", "yy/mmm/dd SS",
                "mm/dd HH:MM AM", "mm/dd HH:MM am",
                "mm/dd HH:MM PM", "mm/dd HH:MM pm",
                "m/d/yy h:mm AM/PM",
                "hh:mm:ss", "hh:mm:ss.0", "mm:ss.0",
                //support elapsed time [h],[m],[s]
                "[hh]", "[mm]", "[ss]", "[SS]", "[red][hh]"
        };
        for (String format : formats) {
            assertTrue(
                    format + " is a datetime format",
                    DateUtil.isADateFormat(format)
            );
        }

        // Then invalid ones
        formats = new String[]{
                "yyyy*mm*dd",
                "0.0", "0.000",
                "0%", "0.0%",
                "[]Foo", "[BLACK]0.00%",
                "[ms]", "[Mh]",
                "", null
        };
        for (String format : formats) {
            assertFalse(
                    format + " is not a date or datetime format",
                    DateUtil.isADateFormat(format)
            );
        }

        // And these are ones we probably shouldn't allow,
        //  but would need a better regexp
        formats = new String[]{
                "yyyy:mm:dd",
        };
        for (String format : formats) {
            //    assertFalse( DateUtil.isADateFormat(formatId, formats[i]) );
        }
    }

    @Test
    public void excelDateBorderCases() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        df.setTimeZone(TimeZone.getDefault());

        assertEquals(1.0, DateUtil.getExcelDate(df.parse("1900-01-01")), 0.00001);
        assertEquals(31.0, DateUtil.getExcelDate(df.parse("1900-01-31")), 0.00001);
        assertEquals(32.0, DateUtil.getExcelDate(df.parse("1900-02-01")), 0.00001);
        assertEquals(/* BAD_DATE! */ -1.0, DateUtil.getExcelDate(df.parse("1899-12-31")), 0.00001);
    }

    @Test
    public void dateBug_2Excel() {
        assertEquals(59.0, DateUtil.getExcelDate(createDate(1900, FEBRUARY, 28), false), 0.00001);
        assertEquals(61.0, DateUtil.getExcelDate(createDate(1900, MARCH, 1), false), 0.00001);

        assertEquals(37315.00, DateUtil.getExcelDate(createDate(2002, FEBRUARY, 28), false), 0.00001);
        assertEquals(37316.00, DateUtil.getExcelDate(createDate(2002, MARCH, 1), false), 0.00001);
        assertEquals(37257.00, DateUtil.getExcelDate(createDate(2002, JANUARY, 1), false), 0.00001);
        assertEquals(38074.00, DateUtil.getExcelDate(createDate(2004, MARCH, 28), false), 0.00001);
    }

    @Test
    public void dateBug_2Java() {
        assertEquals(createDate(1900, FEBRUARY, 28), DateUtil.getJavaDate(59.0, false));
        assertEquals(createDate(1900, MARCH, 1), DateUtil.getJavaDate(61.0, false));

        assertEquals(createDate(2002, FEBRUARY, 28), DateUtil.getJavaDate(37315.00, false));
        assertEquals(createDate(2002, MARCH, 1), DateUtil.getJavaDate(37316.00, false));
        assertEquals(createDate(2002, JANUARY, 1), DateUtil.getJavaDate(37257.00, false));
        assertEquals(createDate(2004, MARCH, 28), DateUtil.getJavaDate(38074.00, false));
    }

    @Test
    public void date1904() {
        assertEquals(createDate(1904, JANUARY, 2), DateUtil.getJavaDate(1.0, true));
        assertEquals(createDate(1904, JANUARY, 1), DateUtil.getJavaDate(0.0, true));
        assertEquals(0.0, DateUtil.getExcelDate(createDate(1904, JANUARY, 1), true), 0.00001);
        assertEquals(1.0, DateUtil.getExcelDate(createDate(1904, JANUARY, 2), true), 0.00001);

        assertEquals(createDate(1998, JULY, 5), DateUtil.getJavaDate(35981, false));
        assertEquals(createDate(1998, JULY, 5), DateUtil.getJavaDate(34519, true));

        assertEquals(35981.0, DateUtil.getExcelDate(createDate(1998, JULY, 5), false), 0.00001);
        assertEquals(34519.0, DateUtil.getExcelDate(createDate(1998, JULY, 5), true), 0.00001);
    }

    /**
     * @param month zero based
     * @param day   one based
     */
    private static Date createDate(int year, int month, int day) {
        return createDate(year, month, day, 0, 0, 0);
    }

    /**
     * @param month zero based
     * @param day   one based
     */
    private static Date createDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        c.set(year, month, day, hour, minute, second);
        c.clear(Calendar.MILLISECOND);
        return c.getTime();
    }

    /**
     * Check if DateUtil.getAbsoluteDay works as advertised.
     */
    @Test
    public void absoluteDay() {
        // 1 Jan 1900 is 1 day after 31 Dec 1899
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(1900, JANUARY, 1, 0, 0, 0);
        cal.clear(Calendar.MILLISECOND);
        assertEquals("Checking absolute day (1 Jan 1900)", 1, DateUtil.absoluteDay(cal, false));
        // 1 Jan 1901 is 366 days after 31 Dec 1899
        cal.set(1901, JANUARY, 1, 0, 0, 0);
        assertEquals("Checking absolute day (1 Jan 1901)", 366, DateUtil.absoluteDay(cal, false));
    }

    @Test
    public void absoluteDayYearTooLow() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(1899, JANUARY, 1, 0, 0, 0);
        cal.clear(Calendar.MILLISECOND);
        try {
            DateUtil.absoluteDay(cal, false);
            fail("Should fail here");
        } catch (IllegalArgumentException e) {
            // expected here
        }

        try {
            cal.set(1903, JANUARY, 1, 0, 0, 0);
            DateUtil.absoluteDay(cal, true);
            fail("Should fail here");
        } catch (IllegalArgumentException e) {
            // expected here
        }
    }

    @Test
    public void convertTime() {

        final double delta = 1E-7; // a couple of digits more accuracy than strictly required
        assertEquals(0.5, DateUtil.convertTime("12:00"), delta);
        assertEquals(2.0 / 3, DateUtil.convertTime("16:00"), delta);
        assertEquals(0.0000116, DateUtil.convertTime("0:00:01"), delta);
        assertEquals(0.7330440, DateUtil.convertTime("17:35:35"), delta);
    }

    @Test
    public void parseDate() {
        assertEquals(createDate(2008, AUGUST, 3), DateUtil.parseYYYYMMDDDate("2008/08/03"));
        assertEquals(createDate(1994, MAY, 1), DateUtil.parseYYYYMMDDDate("1994/05/01"));
    }

    /**
     * Ensure that date values *with* a fractional portion get the right time of day
     */
    @Test
    public void convertDateTime() {
        // Excel day 30000 is date 18-Feb-1982
        // 0.7 corresponds to time 16:48:00
        Date actual = DateUtil.getJavaDate(30000.7);
        Date expected = createDate(1982, 1, 18, 16, 48, 0);
        assertEquals(expected, actual);
    }

    /**
     * DateUtil.isCellFormatted(Cell) should not true for a numeric cell
     * that's formatted as ".0000"
     */
    @Test
    public void bug54557() throws Exception {
        final String format = ".0000";
        boolean isDateFormat = DateUtil.isADateFormat(format);

        assertEquals(false, isDateFormat);
    }

    @Test
    public void bug56269() throws Exception {
        double excelFraction = 41642.45833321759d;
        Calendar calNoRound = DateUtil.getJavaCalendar(excelFraction, false);
        assertEquals(10, calNoRound.get(Calendar.HOUR));
        assertEquals(59, calNoRound.get(Calendar.MINUTE));
        assertEquals(59, calNoRound.get(Calendar.SECOND));
        Calendar calRound = DateUtil.getJavaCalendar(excelFraction, false, null, true);
        assertEquals(11, calRound.get(Calendar.HOUR));
        assertEquals(0, calRound.get(Calendar.MINUTE));
        assertEquals(0, calRound.get(Calendar.SECOND));
    }
}