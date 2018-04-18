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
 * Tests for {@link WildcardUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.15
 */
public class WildcardUtilTest {

    @Test
    public void testIsMatch() {
        Assert.assertEquals(false, WildcardUtil.isMatch("aa", "a"));
        Assert.assertEquals(true, WildcardUtil.isMatch("aa", "*"));
        Assert.assertEquals(false, WildcardUtil.isMatch("cb", "?a"));
        Assert.assertEquals(true, WildcardUtil.isMatch("adceb", "*a*b"));
        Assert.assertEquals(false, WildcardUtil.isMatch("acdcb", "a*c?b"));
        Assert.assertEquals(true, WildcardUtil.isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
    }
}
