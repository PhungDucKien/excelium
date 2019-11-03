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

import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.MobileWebEnvironment;
import excelium.model.test.config.PcEnvironment;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link EnvironmentUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
public class EnvironmentUtilTest {

    @Test
    public void testGetAvailablePcEnvironments() {
        List<Environment> environments = EnvironmentUtil.getAvailablePcEnvironments(Browser.CHROME, null, null);
        Assert.assertEquals(1, environments.size());
        Assert.assertEquals(Browser.CHROME, ((PcEnvironment) environments.get(0)).getBrowser());
        Assert.assertEquals("1024x768", ((PcEnvironment) environments.get(0)).getResolution());

        environments = EnvironmentUtil.getAvailablePcEnvironments(Browser.CHROME, new ArrayList<String>() {{
            add("10.0");
        }}, new ArrayList<String>() {{
            add("800x600");
        }});
        Assert.assertEquals(1, environments.size());
        Assert.assertEquals(Browser.CHROME, ((PcEnvironment) environments.get(0)).getBrowser());
        Assert.assertEquals("10.0", ((PcEnvironment) environments.get(0)).getBrowserVersion());
        Assert.assertEquals("800x600", ((PcEnvironment) environments.get(0)).getResolution());
    }

    @Test
    public void testGetAvailableMobileWebEnvironments() {
        List<Environment> environments = EnvironmentUtil.getAvailableMobileWebEnvironments(Platform.ANDROID, null, null, null, null, null);
        Assert.assertEquals(1, environments.size());
        Assert.assertEquals(Browser.CHROME, ((MobileWebEnvironment) environments.get(0)).getBrowser());
        Assert.assertEquals(Platform.ANDROID, environments.get(0).getPlatform());
        Assert.assertEquals("Android Emulator", ((MobileWebEnvironment) environments.get(0)).getDeviceName());
        Assert.assertEquals("Portrait", ((MobileWebEnvironment) environments.get(0)).getOrientation());

        environments = EnvironmentUtil.getAvailableMobileWebEnvironments(Platform.IOS, null, null, null, null, null);
        Assert.assertEquals(1, environments.size());
        Assert.assertEquals(Browser.SAFARI, ((MobileWebEnvironment) environments.get(0)).getBrowser());
        Assert.assertEquals(Platform.IOS, environments.get(0).getPlatform());
        Assert.assertEquals("iPhone Simulator", ((MobileWebEnvironment) environments.get(0)).getDeviceName());
        Assert.assertEquals("Portrait", ((MobileWebEnvironment) environments.get(0)).getOrientation());
    }

    @Test
    public void testGetAvailableMobileAppEnvironments() {
        List<Environment> environments = EnvironmentUtil.getAvailableMobileAppEnvironments(Platform.ANDROID, null, null, null, null, null, null, null, null, null, null);
        Assert.assertEquals(1, environments.size());
        Assert.assertEquals(Platform.ANDROID, environments.get(0).getPlatform());
        Assert.assertEquals("Android Emulator", ((MobileAppEnvironment) environments.get(0)).getDeviceName());
        Assert.assertEquals("Portrait", ((MobileAppEnvironment) environments.get(0)).getOrientation());

        environments = EnvironmentUtil.getAvailableMobileAppEnvironments(Platform.IOS, null, null, null, null, null, null, null, null, null, null);
        Assert.assertEquals(1, environments.size());
        Assert.assertEquals(Platform.IOS, environments.get(0).getPlatform());
        Assert.assertEquals("iPhone Simulator", ((MobileAppEnvironment) environments.get(0)).getDeviceName());
        Assert.assertEquals("Portrait", ((MobileAppEnvironment) environments.get(0)).getOrientation());
    }
}
