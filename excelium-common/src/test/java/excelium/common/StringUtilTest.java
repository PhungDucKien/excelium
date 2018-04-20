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
}
