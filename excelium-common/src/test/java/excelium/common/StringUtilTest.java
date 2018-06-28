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

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Tests for {@link StringUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class StringUtilTest {

    @Test
    public void testExtractSpreadsheetId() {
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("https://docs.google.com/spreadsheets/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU"));
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("https://docs.google.com/spreadsheets/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/"));
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("https://docs.google.com/spreadsheets/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/edit#gid=1160173419"));
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("https://docs.google.com/spreadsheets/u/0/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU"));
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("https://docs.google.com/spreadsheets/u/0/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/"));
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("https://docs.google.com/spreadsheets/u/0/d/1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU/edit#gid=1160173419"));
        Assert.assertEquals("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU", StringUtil.extractSpreadsheetId("1c87yUrvu-j-2Ve55NM8hYxYCkorcPm3W9VwHR_hDThU"));
    }

    @Test
    public void testHumanReadableByteCount() {
        Assert.assertEquals("0 B", StringUtil.humanReadableByteCount(0, true));
        Assert.assertEquals("0 B", StringUtil.humanReadableByteCount(0, false));
        Assert.assertEquals("27 B", StringUtil.humanReadableByteCount(27, true));
        Assert.assertEquals("27 B", StringUtil.humanReadableByteCount(27, false));
        Assert.assertEquals("999 B", StringUtil.humanReadableByteCount(999, true));
        Assert.assertEquals("999 B", StringUtil.humanReadableByteCount(999, false));
        Assert.assertEquals("1.0 kB", StringUtil.humanReadableByteCount(1000, true));
        Assert.assertEquals("1000 B", StringUtil.humanReadableByteCount(1000, false));
        Assert.assertEquals("1.0 kB", StringUtil.humanReadableByteCount(1023, true));
        Assert.assertEquals("1023 B", StringUtil.humanReadableByteCount(1023, false));
        Assert.assertEquals("1.0 kB", StringUtil.humanReadableByteCount(1024, true));
        Assert.assertEquals("1.0 KiB", StringUtil.humanReadableByteCount(1024, false));
        Assert.assertEquals("1.7 kB", StringUtil.humanReadableByteCount(1728, true));
        Assert.assertEquals("1.7 KiB", StringUtil.humanReadableByteCount(1728, false));
        Assert.assertEquals("110.6 kB", StringUtil.humanReadableByteCount(110592, true));
        Assert.assertEquals("108.0 KiB", StringUtil.humanReadableByteCount(110592, false));
        Assert.assertEquals("7.1 MB", StringUtil.humanReadableByteCount(7077888, true));
        Assert.assertEquals("6.8 MiB", StringUtil.humanReadableByteCount(7077888, false));
        Assert.assertEquals("453.0 MB", StringUtil.humanReadableByteCount(452984832, true));
        Assert.assertEquals("432.0 MiB", StringUtil.humanReadableByteCount(452984832, false));
        Assert.assertEquals("29.0 GB", StringUtil.humanReadableByteCount(28991029248L, true));
        Assert.assertEquals("27.0 GiB", StringUtil.humanReadableByteCount(28991029248L, false));
        Assert.assertEquals("1.9 TB", StringUtil.humanReadableByteCount(1855425871872L, true));
        Assert.assertEquals("1.7 TiB", StringUtil.humanReadableByteCount(1855425871872L, false));
        Assert.assertEquals("9.2 EB", StringUtil.humanReadableByteCount(Long.MAX_VALUE, true));
        Assert.assertEquals("8.0 EiB", StringUtil.humanReadableByteCount(Long.MAX_VALUE, false));
    }

    @Test
    public void testAddSpaceToCamelCase() {
        Assert.assertEquals("First Name", StringUtil.addSpaceToCamelCase("FirstName"));
        Assert.assertEquals("This Is My Caps Delimited String", StringUtil.addSpaceToCamelCase("ThisIsMyCapsDelimitedString"));
        Assert.assertEquals("IBM Make Stuff And Sell It", StringUtil.addSpaceToCamelCase("IBMMakeStuffAndSellIt"));
        Assert.assertEquals("big ID Problem", StringUtil.addSpaceToCamelCase("bigIDProblem"));
        Assert.assertEquals("AWS File", StringUtil.addSpaceToCamelCase("AWSFile"));
    }

    @Test
    public void testParseProperties() throws IOException {
        Properties properties = StringUtil.parseProperties("  a    =    b  ;    c    =   d;   e   ; f  = ", "\\s*;");
        Assert.assertEquals("b", properties.get("a"));
        Assert.assertEquals("d", properties.get("c"));
        Assert.assertEquals("", properties.get("e"));
        Assert.assertEquals("", properties.get("f"));
    }

    @Test
    public void testGetFirstSentence() {
        Assert.assertEquals("This is the first sentence", StringUtil.getFirstSentence("This is the first sentence"));
        Assert.assertEquals("This is the first sentence.", StringUtil.getFirstSentence("This is the first sentence."));
        Assert.assertEquals("This is the first sentence.This is the second sentence.", StringUtil.getFirstSentence("This is the first sentence.This is the second sentence."));
        Assert.assertEquals("This is the first sentence.", StringUtil.getFirstSentence("This is the first sentence. This is the second sentence."));
        Assert.assertEquals("This is first (e.g. 1st) sentence.", StringUtil.getFirstSentence("This is first (e.g. 1st) sentence. And the second one."));
        Assert.assertEquals("I need this domain.com!", StringUtil.getFirstSentence("I need this domain.com! Another sentence. And another sentence."));
    }
}
