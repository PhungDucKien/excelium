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
 * Tests for {@link NumberUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.19
 */
public class NumberUtilTest {

    @Test
    public void testGetNumericValue() {
        Assert.assertEquals(1, NumberUtil.getNumericValue(1.0));
        Assert.assertEquals(1.4, NumberUtil.getNumericValue(1.4));
        Assert.assertEquals(-1, NumberUtil.getNumericValue(-1.0));
        Assert.assertEquals(10000000000L, NumberUtil.getNumericValue(10000000000.0));
    }

    @Test
    public void testGetIntValue() {
        Assert.assertEquals(1, NumberUtil.getIntValue(1.0));
        Assert.assertEquals(1, NumberUtil.getIntValue(1.4));
        Assert.assertEquals(1, NumberUtil.getIntValue(1.5));
        Assert.assertEquals(1, NumberUtil.getIntValue(1.6));
        Assert.assertEquals(-1, NumberUtil.getIntValue(-1.0));
        Assert.assertEquals(10000000000L, NumberUtil.getIntValue(10000000000.0));
    }

    @Test
    public void testParseInteger() {
        Assert.assertEquals(1234, NumberUtil.parseInteger("1234", 0));
        Assert.assertEquals(0, NumberUtil.parseInteger("0", 1));
        Assert.assertEquals(-1, NumberUtil.parseInteger("-1", 1));
        Assert.assertEquals(255, NumberUtil.parseInteger("#ff", 0));
        Assert.assertEquals(255, NumberUtil.parseInteger("0xff", 0));
        Assert.assertEquals(255, NumberUtil.parseInteger("0Xff", 0));
    }

    @Test
    public void testParsePositiveInteger() {
        Assert.assertEquals(1234, NumberUtil.parsePositiveInteger("1234", 0));
        Assert.assertEquals(0, NumberUtil.parsePositiveInteger("0", 1));
        Assert.assertEquals(1, NumberUtil.parsePositiveInteger("-1", 1));
        Assert.assertEquals(255, NumberUtil.parsePositiveInteger("#ff", 0));
        Assert.assertEquals(255, NumberUtil.parsePositiveInteger("0xff", 0));
        Assert.assertEquals(255, NumberUtil.parsePositiveInteger("0Xff", 0));
    }
}
