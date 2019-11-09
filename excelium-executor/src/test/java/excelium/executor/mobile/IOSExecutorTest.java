/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.executor.mobile;

import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverPool;
import excelium.executor.MobileExcelium;
import excelium.model.enums.Platform;
import excelium.model.project.Project;
import excelium.model.test.config.MobileAppEnvironment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;

public class IOSExecutorTest {

    protected static ContextAwareWebDriver webDriver;

    protected static MobileExcelium selenium;

    /**
     * Belows are steps to be able to run this test.
     * - Install WDA as described at https://medium.com/@yash3x/appium-xcuitest-on-real-ios-devices-bd1ebe0dea55
     * - Set the following environment variables: UPDATE_WDA_BUNDLEID, TEST_PLATFORM_VERSION, TEST_DEVICE_NAME, TEST_DEVICE_UDID
     * - Save an XCode File config at ~/.xcconfig
     * - Run REAL_DEVICE=1 npm install to build the app under test
     *
     * @throws IOException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @BeforeClass
    public static void beforeClass() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MobileAppEnvironment environment = new MobileAppEnvironment();
        environment.setPlatform(Platform.IOS);
        environment.setPlatformVersion(System.getenv("TEST_PLATFORM_VERSION"));
        environment.setDeviceName(System.getenv("TEST_DEVICE_NAME"));
        environment.setUdid(System.getenv("TEST_DEVICE_UDID"));
        environment.setBundleId("vn.altplus.example.UICatalog");

        Project project = new Project();
        project.setAppPath(Paths.get("src/test/resources"));
        webDriver = DriverPool.getInstance().getDriver(environment, project);
        selenium = new MobileExcelium(webDriver, null, project);
    }

    @AfterClass
    public static void afterClass() {
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public void testAlert() throws Throwable {
        selenium.click("Alert Views");
        selenium.assertElementPresent("Simple");

        selenium.click("Simple");
        selenium.waitForAlertPresent();
        selenium.assertAlertMatch("^.*A Short Title Is Best.*$");
        selenium.chooseOkAlert();

        selenium.click("Okay / Cancel");
        selenium.waitForConfirmationPresent();
        selenium.assertConfirmationMatch("^.*A Short Title Is Best.*$");
        selenium.chooseOkConfirmation();

        selenium.click("Other");
        selenium.waitForConfirmationPresent();
        selenium.assertConfirmationMatch("^.*A Short Title Is Best.*$");
        selenium.chooseOkConfirmation();

        selenium.click("Text Entry");
        selenium.waitForPromptPresent();
        selenium.type("class=XCUIElementTypeTextField", "hello world");
        selenium.assertText("class=XCUIElementTypeTextField", "hello world");
        selenium.answerPrompt("");

        selenium.click("Secure Text Entry");
        selenium.waitForPromptPresent();
        selenium.type("class=XCUIElementTypeSecureTextField", "hello world");
        selenium.assertText("class=XCUIElementTypeSecureTextField", "•••••••••••");
        selenium.answerPrompt("");

        try {
            selenium.chooseOkAlert();
        } catch (Exception e) {
        }

        selenium.goBack();
    }
}
