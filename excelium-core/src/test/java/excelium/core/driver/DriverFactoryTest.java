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

package excelium.core.driver;

import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.project.Project;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.MobileWebEnvironment;
import excelium.model.test.config.PcEnvironment;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import mockit.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Tests for {@link DriverFactory}.
 *
 * @author PhungDucKien
 * @since 2018.05.06
 */
public class DriverFactoryTest {

    @Mocked
    private WebDriver.Options webDriverOptions;

    @Mocked
    private WebDriver.Window webDriverWindow;

    @Mocked
    private WebDriver.Timeouts webDriverTimeouts;

    @Mocked
    private ChromeDriver chromeDriver;

    @Mocked
    private FirefoxDriver firefoxDriver;

    @Mocked
    private InternetExplorerDriver internetExplorerDriver;

    @Mocked
    private EdgeDriver edgeDriver;

    @Mocked
    private SafariDriver safariDriver;

    @Mocked
    private OperaDriver operaDriver;

    @Mocked
    private AndroidDriver androidDriver;

    @Mocked
    private IOSDriver iosDriver;

    @Test
    public void testCreateChromeDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.window(); result = webDriverWindow;
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            chromeDriver.manage(); result = webDriverOptions;
        }};

        new MockUp<DriverDownloader>()
        {
            @Mock
            void downloadPcDriver(PcEnvironment environment, String driverPath) {
            }
        };

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));

        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environment.setPlatform(Platform.WINDOWS_32);
        environment.setResolution("1024x768");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof ChromeDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
            webDriverWindow.setSize((Dimension) any);
        }};
    }

    @Test
    public void testCreateFirefoxDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.window(); result = webDriverWindow;
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            firefoxDriver.manage(); result = webDriverOptions;
        }};

        new MockUp<DriverDownloader>()
        {
            @Mock
            void downloadPcDriver(PcEnvironment environment, String driverPath) {
            }
        };

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));

        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.FIREFOX);
        environment.setPlatform(Platform.WINDOWS_32);
        environment.setResolution("1024x768");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof FirefoxDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
            webDriverWindow.setSize((Dimension) any);
        }};
    }

    @Test
    public void testCreateIEDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.window(); result = webDriverWindow;
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            internetExplorerDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));

        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.IE);
        environment.setPlatform(Platform.WINDOWS_32);
        environment.setResolution("1024x768");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof InternetExplorerDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
            webDriverWindow.setSize((Dimension) any);
        }};
    }

    @Test
    public void testCreateEdgeDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.window(); result = webDriverWindow;
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            edgeDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));

        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.EDGE);
        environment.setPlatform(Platform.WINDOWS_32);
        environment.setResolution("1024x768");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof EdgeDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
            webDriverWindow.setSize((Dimension) any);
        }};
    }

    @Test
    public void testCreateSafariDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.window(); result = webDriverWindow;
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            safariDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));

        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.SAFARI);
        environment.setPlatform(Platform.WINDOWS_32);
        environment.setResolution("1024x768");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof SafariDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
            webDriverWindow.setSize((Dimension) any);
        }};
    }

    @Test
    public void testCreateOperaDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            operaDriver.manage(); result = webDriverOptions;
        }};

        new MockUp<DriverDownloader>()
        {
            @Mock
            void downloadPcDriver(PcEnvironment environment, String driverPath) {
            }
        };

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));

        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.OPERA);
        environment.setPlatform(Platform.WINDOWS_32);
        environment.setResolution("1024x768");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof OperaDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
        }};
    }

    @Test
    public void testCreateAndroidAppDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            androidDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();
        project.setAppPath(Paths.get("app"));

        MobileAppEnvironment environment = new MobileAppEnvironment();
        environment.setPlatform(Platform.ANDROID);
        environment.setAppPath("test.apk");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof AndroidDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
        }};
    }

    @Test
    public void testCreateAndroidWebDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            androidDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();

        MobileWebEnvironment environment = new MobileWebEnvironment();
        environment.setPlatform(Platform.ANDROID);
        environment.setBrowser(Browser.CHROME);

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof AndroidDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
        }};
    }

    @Test
    public void testCreateIOSAppDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            iosDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();
        project.setAppPath(Paths.get("app"));

        MobileAppEnvironment environment = new MobileAppEnvironment();
        environment.setPlatform(Platform.IOS);
        environment.setAppPath("test.ipa");

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof IOSDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
        }};
    }

    @Test
    public void testCreateIOSWebDriver() throws IOException {
        new Expectations() {{
            webDriverOptions.timeouts(); result = webDriverTimeouts;
            iosDriver.manage(); result = webDriverOptions;
        }};

        Project project = new Project();

        MobileWebEnvironment environment = new MobileWebEnvironment();
        environment.setPlatform(Platform.IOS);
        environment.setBrowser(Browser.SAFARI);

        WebDriver driver = DriverFactory.createDriver(environment, project, null);
        WebDriver innerDriver = Deencapsulation.getField(driver, "webDriver");
        Assert.assertTrue(innerDriver instanceof IOSDriver);

        new Verifications() {{
            webDriverTimeouts.implicitlyWait(anyLong, (TimeUnit) any);
        }};
    }
}
