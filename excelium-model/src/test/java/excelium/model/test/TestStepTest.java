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

package excelium.model.test;

import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.PcEnvironment;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link TestStep}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class TestStepTest {

    @Test
    public void testIsSkipOn() {
        TestStep testStep = new TestStep();
        testStep.setGutter(null);
        testStep.setAndroidGutter("M");
        testStep.setIosGutter("S");

        PcEnvironment web = new PcEnvironment();
        web.setBrowser(Browser.CHROME);
        Assert.assertFalse(testStep.isSkipOn(web));

        MobileAppEnvironment android = new MobileAppEnvironment();
        android.setPlatform(Platform.ANDROID);
        Assert.assertFalse(testStep.isSkipOn(android));

        MobileAppEnvironment ios = new MobileAppEnvironment();
        ios.setPlatform(Platform.IOS);
        Assert.assertTrue(testStep.isSkipOn(ios));
    }

    @Test
    public void testIsDebugOn() {
        TestStep testStep = new TestStep();
        testStep.setGutter("D");
        testStep.setAndroidGutter(null);
        testStep.setIosGutter("S");

        PcEnvironment web = new PcEnvironment();
        web.setBrowser(Browser.CHROME);
        Assert.assertTrue(testStep.isDebugOn(web));

        MobileAppEnvironment android = new MobileAppEnvironment();
        android.setPlatform(Platform.ANDROID);
        Assert.assertFalse(testStep.isDebugOn(android));

        MobileAppEnvironment ios = new MobileAppEnvironment();
        ios.setPlatform(Platform.IOS);
        Assert.assertFalse(testStep.isDebugOn(ios));
    }
}
