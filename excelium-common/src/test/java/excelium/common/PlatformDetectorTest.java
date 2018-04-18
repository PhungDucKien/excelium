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

import excelium.model.enums.Platform;
import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link PlatformDetector}.
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
public class PlatformDetectorTest {

    @Test
    public void testGetPlatform_Win32() {
        new MockUp<PlatformDetector>() {
            @Mock
            String getOsName() {
                return "windows";
            }

            @Mock
            String getOsArch() {
                return "x86";
            }
        };
        PlatformDetector detector = new PlatformDetector();
        Deencapsulation.setField(detector, "detectedPlatform", null);
        Platform platform = PlatformDetector.getPlatform();
        Assert.assertEquals(Platform.WINDOWS_32, platform);
        Deencapsulation.setField(detector, "detectedPlatform", null);
    }

    @Test
    public void testGetPlatform_Win64() {
        new MockUp<PlatformDetector>() {
            @Mock
            String getOsName() {
                return "windows";
            }

            @Mock
            String getOsArch() {
                return "x86_64";
            }
        };
        PlatformDetector detector = new PlatformDetector();
        Deencapsulation.setField(detector, "detectedPlatform", null);
        Platform platform = PlatformDetector.getPlatform();
        Assert.assertEquals(Platform.WINDOWS_64, platform);
        Deencapsulation.setField(detector, "detectedPlatform", null);
    }

    @Test
    public void testGetPlatform_MacOS() {
        new MockUp<PlatformDetector>() {
            @Mock
            String getOsName() {
                return "mac os x";
            }

            @Mock
            String getOsArch() {
                return "x86";
            }
        };
        PlatformDetector detector = new PlatformDetector();
        Deencapsulation.setField(detector, "detectedPlatform", null);
        Platform platform = PlatformDetector.getPlatform();
        Assert.assertEquals(Platform.MAC_OS, platform);
        Deencapsulation.setField(detector, "detectedPlatform", null);
    }

    @Test
    public void testGetPlatform_Linux() {
        new MockUp<PlatformDetector>() {
            @Mock
            String getOsName() {
                return "linux";
            }

            @Mock
            String getOsArch() {
                return "x86";
            }
        };
        PlatformDetector detector = new PlatformDetector();
        Deencapsulation.setField(detector, "detectedPlatform", null);
        Platform platform = PlatformDetector.getPlatform();
        Assert.assertEquals(Platform.LINUX, platform);
        Deencapsulation.setField(detector, "detectedPlatform", null);
    }
}
