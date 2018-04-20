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

package excelium.model.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link Platform}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public class PlatformTest {

    @Test
    public void testFromName() {
        Assert.assertEquals(Platform.WINDOWS_32, Platform.fromName("WINDOWS_32"));
        Assert.assertEquals(Platform.WINDOWS_64, Platform.fromName("WINDOWS_64"));
        Assert.assertEquals(Platform.MAC_OS, Platform.fromName("MAC_OS"));
        Assert.assertEquals(Platform.LINUX, Platform.fromName("LINUX"));
        Assert.assertEquals(Platform.ANDROID, Platform.fromName("ANDROID"));
        Assert.assertEquals(Platform.IOS, Platform.fromName("IOS"));
        Assert.assertEquals(Platform.OTHER, Platform.fromName("OTHER"));
    }

    @Test
    public void testGetListChoice() {
        String[][] listChoice = Platform.getListChoice();
        Assert.assertEquals(7, listChoice.length);
        Assert.assertEquals("WINDOWS_32", listChoice[0][0]);
        Assert.assertEquals("Windows 32", listChoice[0][1]);
        Assert.assertEquals("WINDOWS_64", listChoice[1][0]);
        Assert.assertEquals("Windows 64", listChoice[1][1]);
        Assert.assertEquals("MAC_OS", listChoice[2][0]);
        Assert.assertEquals("Mac OS", listChoice[2][1]);
        Assert.assertEquals("LINUX", listChoice[3][0]);
        Assert.assertEquals("Linux", listChoice[3][1]);
        Assert.assertEquals("ANDROID", listChoice[4][0]);
        Assert.assertEquals("Android", listChoice[4][1]);
        Assert.assertEquals("IOS", listChoice[5][0]);
        Assert.assertEquals("iOS", listChoice[5][1]);
        Assert.assertEquals("OTHER", listChoice[6][0]);
        Assert.assertEquals("Other", listChoice[6][1]);
    }

    @Test
    public void testIsWindows() {
        Assert.assertTrue(Platform.WINDOWS_32.isWindows());
        Assert.assertTrue(Platform.WINDOWS_64.isWindows());
        Assert.assertFalse(Platform.MAC_OS.isWindows());
        Assert.assertFalse(Platform.LINUX.isWindows());
        Assert.assertFalse(Platform.ANDROID.isWindows());
        Assert.assertFalse(Platform.IOS.isWindows());
        Assert.assertFalse(Platform.OTHER.isWindows());
    }

    @Test
    public void testIsMac() {
        Assert.assertFalse(Platform.WINDOWS_32.isMac());
        Assert.assertFalse(Platform.WINDOWS_64.isMac());
        Assert.assertTrue(Platform.MAC_OS.isMac());
        Assert.assertFalse(Platform.LINUX.isMac());
        Assert.assertFalse(Platform.ANDROID.isMac());
        Assert.assertFalse(Platform.IOS.isMac());
        Assert.assertFalse(Platform.OTHER.isMac());
    }
}
