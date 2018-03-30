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
 * Tests for {@link MobileLocatorType}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public class MobileLocatorTypeTest {

    @Test
    public void testFromName() {
        Assert.assertEquals(MobileLocatorType.ACCESSIBILITY_ID, MobileLocatorType.fromName("ACCESSIBILITY_ID"));
        Assert.assertEquals(MobileLocatorType.CLASS, MobileLocatorType.fromName("CLASS"));
        Assert.assertEquals(MobileLocatorType.ID, MobileLocatorType.fromName("ID"));
        Assert.assertEquals(MobileLocatorType.NAME, MobileLocatorType.fromName("NAME"));
        Assert.assertEquals(MobileLocatorType.XPATH, MobileLocatorType.fromName("XPATH"));
        Assert.assertEquals(MobileLocatorType.IOS_UIAUTOMATION, MobileLocatorType.fromName("IOS_UIAUTOMATION"));
        Assert.assertEquals(MobileLocatorType.ANDROID_UIAUTOMATOR, MobileLocatorType.fromName("ANDROID_UIAUTOMATOR"));
        Assert.assertEquals(MobileLocatorType.VARIABLE, MobileLocatorType.fromName("VARIABLE"));
    }
}
