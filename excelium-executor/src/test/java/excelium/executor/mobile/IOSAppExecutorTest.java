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
import excelium.executor.web.env.GlobalWebEnvironment;
import excelium.model.enums.Platform;
import excelium.model.project.Project;
import excelium.model.test.config.MobileAppEnvironment;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Date;

public class IOSAppExecutorTest {

    protected static ContextAwareWebDriver webDriver;

    protected static MobileExcelium selenium;

    protected static Project project;

    protected static boolean isRealDevice;

    @BeforeClass
    public static void initializeServer() {
        GlobalWebEnvironment.setUp();
    }

    /**
     * Belows are steps to be able to run this test.
     * - Install WDA as described at https://medium.com/@yash3x/appium-xcuitest-on-real-ios-devices-bd1ebe0dea55
     * - Set the following environment variables: UPDATE_WDA_BUNDLEID
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

        String udid = System.getenv("TEST_DEVICE_UDID");
        environment.setUdid(udid);
        if (StringUtils.isBlank(udid) || udid.equalsIgnoreCase("auto")) {
            environment.setBundleId("com.vn.altplus.UICatalog");
            isRealDevice = true;
        } else {
            environment.setAppPath("ios-uicatalog/UICatalog/build/Release-iphonesimulator/UICatalog-iphonesimulator.app");
            isRealDevice = false;
        }

        project = new Project();
        project.setAppPath(Paths.get("src/test/resources"));
        project.setScreenshotPath(Paths.get("screenshot"));
        webDriver = DriverPool.getInstance().getDriver(environment, project);
        selenium = new MobileExcelium(webDriver, GlobalWebEnvironment.get().getServerUrl(), project);
    }

    @AfterClass
    public static void afterClass() {
        if (webDriver != null) {
            DriverPool.getInstance().dismissDriver(webDriver.getWebDriver());
        }
        webDriver = null;
    }

    @Before
    public void before() throws Throwable {
        selenium.cleanDriver();
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
        selenium.runAppInBackground("4");
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

        selenium.tap("Buttons");
        selenium.tap("Button");
        selenium.goBack();

        selenium.landscape();
        Assert.assertEquals(webDriver.getAppiumDriver().getOrientation(), ScreenOrientation.LANDSCAPE);

        selenium.tap("Buttons");
        selenium.tap("Button");
        selenium.goBack();

        selenium.portrait();
        Assert.assertEquals(webDriver.getAppiumDriver().getOrientation(), ScreenOrientation.PORTRAIT);
    }

    @Test
    public void testGeoLocation() throws Throwable {
        if (!isRealDevice) {
            selenium.setGeolocation("30.0001,21.0002,10");
        }
    }

    @Test
    public void testShake() throws Throwable {
        if (!isRealDevice) {
            selenium.shake();
        }
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
        selenium.tap("Web View");

        selenium.waitForContextCount("2");

        selenium.assertContextCount("2");
        selenium.setWebViewContext("1");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.assertTitle("I am a page title");

        selenium.setNativeAppContext();

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
        selenium.tap("Text Fields");

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
        selenium.tap("class=XCUIElementTypeTextField");
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
        selenium.tap("Picker View");
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
    public void testFindElements() throws Throwable {
        selenium.assertElementPresent("Buttons");
        selenium.assertElementNotPresent("Buttons", "class=XCUIElementTypeNavigationBar");

        selenium.tap("class=XCUIElementTypeTable", "class=XCUIElementTypeStaticText");
        selenium.pause("1000");
        selenium.tap("class=XCUIElementTypeTable", "class=XCUIElementTypeStaticText");
        selenium.assertAlertPresent();
        selenium.chooseOkAlert();

        selenium.goBack();

        selenium.assertElementPresent("Alert Views");
        selenium.assertElementPresent("Alert Views", "index=1");
        selenium.assertElementNotPresent("Alert Views", "index=2");
        selenium.assertAttribute("Alert Views", "label", "Alert Views");

        selenium.tap("Buttons");
        selenium.assertElementPresent("Button");

        selenium.setTimeout("5000");
        Date before = new Date();
        try {
            selenium.tap("//something_not_there");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }
        Date now = new Date();
        Assert.assertTrue(now.getTime() - before.getTime() >= 5000);
        selenium.setTimeout("1000");

        selenium.assertAttribute("//XCUIElementTypeCell[last()]/XCUIElementTypeButton", "name", "Button");
        selenium.assertAttribute("//XCUIElementTypeButton", "name", "UICatalog");
        selenium.assertElementPresent("//XCUIElementTypeButton", "index=4");
        selenium.assertAttribute("//XCUIElementTypeButton[@name='X Button']", "name", "X Button");
        selenium.assertElementNotPresent("/XCUIElementTypeButton");

        try {
            selenium.assertAttribute("//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText", "name", "Buttons");
        } catch (Exception e) {
            selenium.assertAttribute("//XCUIElementTypeNavigationBar/XCUIElementTypeOther", "name", "Buttons");
        }
        selenium.assertAttribute("//XCUIElementTypeTable[1]//XCUIElementTypeButton[1]", "name", "Button");
        selenium.assertAttribute("//XCUIElementTypeTable[1]//XCUIElementTypeCell[4]//XCUIElementTypeButton[1]", "name", "X Button");
        selenium.assertAttribute("//XCUIElementTypeTable//XCUIElementTypeButton[contains(@name, 'X')]", "name", "X Button");

        selenium.assertElementPresent("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]");
        selenium.assertElementNotPresent("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]", "index=2");

        selenium.goBack();

        selenium.tap("Accessibility_Id=Alert Views");
        selenium.assertAttribute("Accessibility_Id=Okay / Cancel", "name", "Okay / Cancel");
        selenium.assertElementNotPresent("Accessibility_Id=Okay / Cancel", "index=2");

        selenium.goBack();

        selenium.assertElementPresent("class=XCUIElementTypeTable", "Accessibility_Id=Alert Views");

        selenium.tap("Image View");
        selenium.assertElementPresent("class=XCUIElementTypeImage");

        selenium.goBack();
        selenium.tap("Alert Views");
        selenium.assertElementPresent("Okay / Cancel", "class=XCUIElementTypeStaticText");

        selenium.goBack();

        selenium.scrollDownTo("Text Fields");
        selenium.tap("Text Fields");
        selenium.assertElementPresent("class=XCUIElementTypeTextField", "index=4");
        selenium.assertElementNotPresent("class=XCUIElementTypeTextField", "index=5");
        selenium.assertElementPresent("class=XCUIElementTypeSecureTextField", "index=1");
        selenium.assertElementNotPresent("class=XCUIElementTypeSecureTextField", "index=2");

        selenium.goBack();
        selenium.scrollUpTo("Alert Views");

        selenium.assertElementPresent("ios_ns_predicate=visible = 1");
        selenium.assertElementPresent("ios_ns_predicate=visible = 0");
        selenium.assertElementPresent("ios_ns_predicate=wdRect.width >= 0");
        selenium.assertElementPresent("ios_ns_predicate=wdRect.width BETWEEN {100,200}");
        selenium.assertElementPresent("ios_ns_predicate=wdName LIKE '* View'", "index=2");
        selenium.assertElementPresent("ios_ns_predicate=wdRect.x >= 0 AND wdRect.y >= 0", "index=2");

        selenium.assertElementPresent("ios_class_chain=XCUIElementTypeWindow");
        selenium.assertElementPresent("ios_class_chain=XCUIElementTypeWindow/*");
        selenium.assertElementPresent("ios_class_chain=XCUIElementTypeWindow[1]/*");
        selenium.assertElementPresent("ios_class_chain=XCUIElementTypeWindow/*[-1]");

        selenium.assertAttribute("//XCUIElementTypeTable//*[@visible=\"true\"][1]", "type", "XCUIElementTypeCell");
        selenium.assertAttribute("//XCUIElementTypeTable/*[@visible=\"true\"][1]/*[@visible = 'true'][1]", "name", "Action Sheets");

        selenium.assertElementPresent("//*[@scrollable=\"true\"]");
        selenium.assertAttribute("//*[@scrollable=\"true\"]", "type", "XCUIElementTypeTable");
    }

    @Test
    public void testGestures() throws Throwable {
        selenium.tap("Alert Views");
        selenium.waitForElementPresent("Okay / Cancel");

        selenium.tap("Okay / Cancel");
        selenium.assertElementPresent("OK");
        selenium.tap("OK");

        selenium.waitForElementNotPresent("OK");

        WebElement element = webDriver.findElement("Okay / Cancel");
        int x = element.getLocation().x + element.getSize().width / 2;
        int y = element.getLocation().y + element.getSize().height / 2;
        selenium.tapAt(x + "," + y);
        selenium.assertElementPresent("OK");
        selenium.tap("OK");

        selenium.waitForElementNotPresent("OK");

        selenium.longPress("Okay / Cancel");
        selenium.assertElementPresent("Cancel");
        selenium.tap("Cancel");

        selenium.waitForElementNotPresent("Cancel");

        selenium.longPressAt(x + "," + y);
        selenium.assertElementPresent("OK");
        selenium.tap("OK");

        selenium.waitForElementNotPresent("OK");

        selenium.goBack();
        selenium.scrollUpTo("Alert Views");

        selenium.assertNotVisible("Web View");
        selenium.dragAndDropToObject("Progress Views", "Activity Indicators");
        selenium.waitForVisible("Web View");
        selenium.assertVisible("Web View");

        selenium.goBack();
        selenium.scrollUpTo("Alert Views");

        selenium.scrollDown();
        selenium.tap("Steppers");
        selenium.doubleTap("Increment");
        selenium.assertElementPresent("2");

        selenium.goBack();
        selenium.scrollUpTo("Alert Views");

        WebElement pickerEl = webDriver.findElement("Picker View");
        int yInit = pickerEl.getLocation().y;
        selenium.swipeUp("class=XCUIElementTypeWindow");
        int yMiddle = pickerEl.getLocation().y;
        Assert.assertTrue(yMiddle < yInit);
        selenium.swipeDown("class=XCUIElementTypeWindow");
        int yFinal = pickerEl.getLocation().y;
        Assert.assertTrue(yFinal > yMiddle);

        selenium.scrollDownTo("Web View");
        selenium.tap("Web View");

        // at this point this test relies on watching it happen, nothing is asserted
        // in automation, this just checks that errors aren't thrown
        selenium.waitForContextCount("2");

        selenium.setWebViewContext("1");
        selenium.open("../tests/appium/appium.png");
        selenium.setNativeAppContext();

        selenium.pinch("class=XCUIElementTypeApplication", "6");
        selenium.pinch("class=XCUIElementTypeApplication", "0.5");

        selenium.goBack();
        selenium.scrollUpTo("Alert Views");
    }

    @Test
    public void testControlCenter() throws Throwable {
        boolean isStatusBarAvailable = false;
        try {
            selenium.assertElementNotPresent("class=XCUIElementTypeStatusBar");
        } catch (Exception err) {
            // if this exists,
            isStatusBarAvailable = true;
            selenium.assertElementNotPresent("ControlCenterView");
        }

        selenium.openControlCenter();

        // Control Center ought to be visible now
        if (isStatusBarAvailable) {
            selenium.assertElementPresent("ControlCenterView");
        } else {
            selenium.assertElementPresent("class='XCUIElementTypeStatusBar'");
        }

        selenium.closeControlCenter();

        if (isStatusBarAvailable) {
            selenium.assertElementNotPresent("ControlCenterView");
        } else {
            selenium.assertElementNotPresent("class=XCUIElementTypeStatusBar");
        }
    }

    @Test
    public void testAlert() throws Throwable {
        selenium.tap("Alert Views");
        selenium.assertElementPresent("Simple");

        selenium.tap("Simple");
        selenium.waitForAlertPresent();
        selenium.assertAlertMatch("^.*A Short Title Is Best.*$");
        selenium.chooseOkAlert();
        selenium.waitForAlertNotPresent();

        selenium.tap("Okay / Cancel");
        selenium.waitForConfirmationPresent();
        selenium.assertConfirmationMatch("^.*A Short Title Is Best.*$");
        selenium.chooseOkConfirmation();
        selenium.waitForConfirmationNotPresent();

        selenium.tap("Other");
        selenium.waitForConfirmationPresent();
        selenium.assertConfirmationMatch("^.*A Short Title Is Best.*$");
        selenium.chooseOkConfirmation();
        selenium.waitForConfirmationNotPresent();

        selenium.tap("Text Entry");
        selenium.waitForPromptPresent();
        selenium.type("class=XCUIElementTypeTextField", "hello world");
        selenium.assertText("class=XCUIElementTypeTextField", "hello world");
        selenium.answerPrompt("");
        selenium.waitForPromptNotPresent();

        selenium.tap("Secure Text Entry");
        selenium.waitForPromptPresent();
        selenium.type("class=XCUIElementTypeSecureTextField", "hello world");
        selenium.assertText("class=XCUIElementTypeSecureTextField", "•••••••••••");
        selenium.answerPrompt("");
        selenium.waitForPromptNotPresent();

        try {
            selenium.chooseOkAlert();
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.goBack();
    }
}
