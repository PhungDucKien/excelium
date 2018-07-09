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
import org.openqa.selenium.support.Color;

import java.util.List;

/**
 * Tests for {@link ObjectUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
public class ObjectUtilTest {

    @Test
    public void testGetStringValue() {
        Assert.assertEquals(null, ObjectUtil.getStringValue(null));
        Assert.assertEquals("", ObjectUtil.getStringValue(""));
        Assert.assertEquals("abc", ObjectUtil.getStringValue("abc"));
        Assert.assertEquals("true", ObjectUtil.getStringValue(true));
        Assert.assertEquals("1", ObjectUtil.getStringValue(1));
        Assert.assertEquals("1.0", ObjectUtil.getStringValue(1.0));
    }

    @Test
    public void testGetBooleanValue() {
        Assert.assertEquals(false, ObjectUtil.getBooleanValue(null));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue(""));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("YES"));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue("NO"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("Y"));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue("N"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("TRUE"));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue("FALSE"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("T"));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue("F"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue(1));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue(0));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue(true));
        Assert.assertEquals(false, ObjectUtil.getBooleanValue(false));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("☑"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("✓"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("✔"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("○"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("●"));
        Assert.assertEquals(true, ObjectUtil.getBooleanValue("◯"));
    }

    @Test
    public void testGetListValue() {
        Assert.assertEquals(0, ObjectUtil.getListValue(null).size());
        Assert.assertEquals(0, ObjectUtil.getListValue("").size());

        List<String> list = ObjectUtil.getListValue("abc");
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("abc", list.get(0));

        list = ObjectUtil.getListValue("abc, def");
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("abc", list.get(0));
        Assert.assertEquals("def", list.get(1));

        list = ObjectUtil.getListValue("abc   \n def");
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("abc", list.get(0));
        Assert.assertEquals("def", list.get(1));
    }

    @Test
    public void testCheckEquals() {
        Assert.assertTrue(ObjectUtil.checkEquals(null, null));
        Assert.assertTrue(ObjectUtil.checkEquals("#ff0000", new Color(255, 0, 0, 1)));
        Assert.assertTrue(ObjectUtil.checkEquals("red", new Color(255, 0, 0, 1)));

        Assert.assertFalse(ObjectUtil.checkEquals("abc", null));
        Assert.assertFalse(ObjectUtil.checkEquals("#ff0001", new Color(255, 0, 0, 1)));
        Assert.assertFalse(ObjectUtil.checkEquals("blue", new Color(255, 0, 0, 1)));

        Assert.assertTrue(ObjectUtil.checkEquals("1", 1));
        Assert.assertTrue(ObjectUtil.checkEquals("1", 1L));
        Assert.assertTrue(ObjectUtil.checkEquals("1", 1.0));
        Assert.assertTrue(ObjectUtil.checkEquals("true", true));
        Assert.assertTrue(ObjectUtil.checkEquals("false", false));
    }
}
