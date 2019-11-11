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
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Date;

public class IOSExecutorTest {

    protected static ContextAwareWebDriver webDriver;

    protected static MobileExcelium selenium;

    protected static Project project;

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

        project = new Project();
        project.setAppPath(Paths.get("src/test/resources"));
        project.setScreenshotPath(Paths.get("screenshot"));
        webDriver = DriverPool.getInstance().getDriver(environment, project);
        selenium = new MobileExcelium(webDriver, null, project);
    }

    @AfterClass
    public static void afterClass() {
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public void testPageSource() throws Throwable {
        selenium.assertPageSourceMatch("^.*<AppiumAUT>.*$");
        selenium.assertPageSourceMatch("^.*<XCUIElementTypeApplication.*$");
        selenium.assertPageSourceNotMatch("^.*AX error.*$");
    }

    @Test
    public void testDeactivate() throws Throwable {
        Date before = new Date();
        selenium.runAppInBackground("4000");
        Date now = new Date();
        Assert.assertTrue(now.getTime() - before.getTime() >= 4000);
        selenium.assertPageSourceMatch("^.*<AppiumAUT>.*$");
    }

    @Test
    public void testScreenshot() throws Throwable {
        FileUtils.deleteDirectory(project.getScreenshotPath().toFile());
        selenium.captureScreenshot();
        Assert.assertTrue(project.getScreenshotPath().toFile().list().length == 1);

        // make sure WDA didn't crash, by using it again
        selenium.assertElementPresent("Alert Views");

        selenium.landscape();
        selenium.pause("1000");
        FileUtils.deleteDirectory(project.getScreenshotPath().toFile());
        selenium.captureScreenshot();
        Assert.assertTrue(project.getScreenshotPath().toFile().list().length == 1);

        selenium.portrait();
        selenium.pause("1000");
        FileUtils.deleteDirectory(project.getScreenshotPath().toFile());
        selenium.captureViewport();
        Assert.assertTrue(project.getScreenshotPath().toFile().list().length == 1);

        FileUtils.deleteDirectory(project.getScreenshotPath().toFile());
    }

    @Test
    public void testOrientation() throws Throwable {
        selenium.portrait();
        Assert.assertEquals(webDriver.getAppiumDriver().getOrientation(), ScreenOrientation.PORTRAIT);

        selenium.click("Buttons");
        selenium.click("Button");
        selenium.goBack();

        selenium.landscape();
        Assert.assertEquals(webDriver.getAppiumDriver().getOrientation(), ScreenOrientation.LANDSCAPE);

        selenium.click("Buttons");
        selenium.click("Button");
        selenium.goBack();

        selenium.portrait();
        Assert.assertEquals(webDriver.getAppiumDriver().getOrientation(), ScreenOrientation.PORTRAIT);
    }

    @Test
    public void testGeoLocation() throws Throwable {
        selenium.setGeolocation("30.0001,21.0002,10");
    }

    @Test
    public void testShake() throws Throwable {
        selenium.shake();
    }

    @Test
    public void testLock() throws Throwable {
        selenium.lock();
        Assert.assertTrue(webDriver.getIOSDriver().isDeviceLocked());

        selenium.unlock();
        Assert.assertFalse(webDriver.getIOSDriver().isDeviceLocked());
    }

    @Test
    public void testContext() throws Throwable {
        selenium.scrollDownTo("Web View");
        selenium.click("Web View");

        // TODO

        selenium.goBack();
        selenium.scrollUp();
    }

    @Test
    public void testElement() throws Throwable {
        selenium.assertText("Buttons", "Buttons");
        selenium.assertText("Image View", "Image View");

        selenium.assertTagName("Buttons", "XCUIElementTypeStaticText");

        selenium.assertVisible("Buttons");
        selenium.assertNotVisible("Web View");
    }

    @Test
    public void testTap() throws Throwable {
        selenium.tap("Buttons");
        selenium.waitForElementPresent("class=XCUIElementTypeButton");
        selenium.assertVisible("class=XCUIElementTypeButton");
        selenium.goBack();
    }

    @Test
    public void testTextField() throws Throwable {
        String text1 = "bunchoftext";
        String text2 = "differenttext";
        String text3 = "http://appium.io/";
        String secureText = "•••••••••••";
        String phText = "Placeholder text";

        selenium.scrollDownTo("Text Fields");
        selenium.click("Text Fields");

        selenium.type("class=XCUIElementTypeTextField", text1);
        selenium.assertText("class=XCUIElementTypeTextField", text1);

        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", text3);
        selenium.assertText("class=XCUIElementTypeTextField", text3);

        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", text3);
        selenium.assertText("class=XCUIElementTypeTextField", text3);

        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", text3);
        selenium.assertText("class=XCUIElementTypeTextField", text3);

        selenium.clear("class=XCUIElementTypeTextField", "index=1");
        selenium.type("class=XCUIElementTypeTextField", "index=1", text1);
        selenium.hideKeyboard("Done");
        selenium.clear("class=XCUIElementTypeTextField", "index=2");
        selenium.type("class=XCUIElementTypeTextField", "index=2", text2);
        selenium.assertText("class=XCUIElementTypeTextField", "index=1", text1);
        selenium.assertText("class=XCUIElementTypeTextField", "index=2", text2);

        // should type a backspace
        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", "0123456789\\uE003");
        selenium.assertText("class=XCUIElementTypeTextField", "012345678");

        // should type a delete
        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", "0123456789\\ue017");
        selenium.assertText("class=XCUIElementTypeTextField", "012345678");

        // should type a newline
        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", "0123456789\\uE006");
        selenium.assertText("class=XCUIElementTypeTextField", "0123456789");

        // clear
        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", "0123456789abcdefghijklmnopqrstuvwxyz");
        selenium.assertText("class=XCUIElementTypeTextField", "0123456789abcdefghijklmnopqrstuvwxyz");
        selenium.clear("class=XCUIElementTypeTextField");
        selenium.assertText("class=XCUIElementTypeTextField", phText);

        selenium.clear("class=XCUIElementTypeTextField", "index=1");
        selenium.type("class=XCUIElementTypeTextField", "index=1", text1);
        selenium.assertText("class=XCUIElementTypeTextField", "index=1", text1);
        selenium.hideKeyboard("Done");
        selenium.clear("class=XCUIElementTypeTextField", "index=2");
        selenium.type("class=XCUIElementTypeTextField", "index=2", text2);
        selenium.assertText("class=XCUIElementTypeTextField", "index=2", text2);
        selenium.clear("class=XCUIElementTypeTextField", "index=1");
        selenium.assertText("class=XCUIElementTypeTextField", "index=1", phText);
        selenium.hideKeyboard("Done");
        selenium.clear("class=XCUIElementTypeTextField", "index=2");
        selenium.assertText("class=XCUIElementTypeTextField", "index=2", phText);

        selenium.clear("class=XCUIElementTypeSecureTextField");
        selenium.type("class=XCUIElementTypeSecureTextField", text1);
        selenium.assertText("class=XCUIElementTypeSecureTextField", secureText);
        selenium.clear("class=XCUIElementTypeSecureTextField");
        selenium.assertText("class=XCUIElementTypeSecureTextField", phText);

        // Unicode
        selenium.clear("class=XCUIElementTypeTextField");
        selenium.type("class=XCUIElementTypeTextField", "あいうえおアイウエオ日本");
        selenium.assertText("class=XCUIElementTypeTextField", "あいうえおアイウエオ日本");
        selenium.clear("class=XCUIElementTypeTextField");

        // hide keyboard
        selenium.click("class=XCUIElementTypeTextField");
        selenium.pause("500");
        selenium.assertVisible("Done");
        selenium.hideKeyboard("Done");
        selenium.pause("1000");
        selenium.assertElementNotPresent("Done");

        selenium.goBack();
        selenium.scrollUp();
    }

    @Test
    public void testPickerWheel() throws Throwable {
        selenium.click("Picker View");
        selenium.assertValue("class=XCUIElementTypePickerWheel", "index=1", "65");
        selenium.assertValue("class=XCUIElementTypePickerWheel", "index=2", "205");
        selenium.assertValue("class=XCUIElementTypePickerWheel", "index=3", "120");

        selenium.type("class=XCUIElementTypePickerWheel", "index=1", "150");
        selenium.type("class=XCUIElementTypePickerWheel", "index=2", "150");
        selenium.type("class=XCUIElementTypePickerWheel", "index=3", "150");

        selenium.assertValue("class=XCUIElementTypePickerWheel", "index=1", "150");
        selenium.assertValue("class=XCUIElementTypePickerWheel", "index=2", "150");
        selenium.assertValue("class=XCUIElementTypePickerWheel", "index=3", "150");

        selenium.goBack();
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
