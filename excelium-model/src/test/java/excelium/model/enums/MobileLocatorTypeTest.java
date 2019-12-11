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
    public void testFromStrategy() {
        Assert.assertEquals(MobileLocatorType.ACCESSIBILITY_ID, MobileLocatorType.fromStrategy("accessibility id"));
        Assert.assertEquals(MobileLocatorType.CLASS, MobileLocatorType.fromStrategy("class"));
        Assert.assertEquals(MobileLocatorType.ID, MobileLocatorType.fromStrategy("id"));
        Assert.assertEquals(MobileLocatorType.NAME, MobileLocatorType.fromStrategy("name"));
        Assert.assertEquals(MobileLocatorType.XPATH, MobileLocatorType.fromStrategy("xpath"));
        Assert.assertEquals(MobileLocatorType.ANDROID_UIAUTOMATOR, MobileLocatorType.fromStrategy("android uiautomator"));
        Assert.assertEquals(MobileLocatorType.ANDROID_VIEWTAG, MobileLocatorType.fromStrategy("android viewtag"));
        Assert.assertEquals(MobileLocatorType.ANDROID_DATAMATCHER, MobileLocatorType.fromStrategy("android datamatcher"));
        Assert.assertEquals(MobileLocatorType.IOS_PREDICATE_STRING, MobileLocatorType.fromStrategy("ios predicate string"));
        Assert.assertEquals(MobileLocatorType.IOS_CLASS_CHAIN, MobileLocatorType.fromStrategy("ios class chain"));
        Assert.assertEquals(MobileLocatorType.WINDOWS_UIAUTOMATION, MobileLocatorType.fromStrategy("windows uiautomation"));
        Assert.assertEquals(MobileLocatorType.INDEX, MobileLocatorType.fromStrategy("index"));
        Assert.assertEquals(MobileLocatorType.VARIABLE, MobileLocatorType.fromStrategy("variable"));
    }
}
