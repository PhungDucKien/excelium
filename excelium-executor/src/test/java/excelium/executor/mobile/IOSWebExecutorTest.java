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
import excelium.executor.WebExcelium;
import excelium.executor.web.env.GlobalWebEnvironment;
import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.project.Project;
import excelium.model.test.TestRunConfig;
import excelium.model.test.config.MobileWebEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;

import java.nio.file.Paths;
import java.util.Date;

public class IOSWebExecutorTest {

    protected static ContextAwareWebDriver webDriver;

    protected static WebExcelium selenium;

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
     *
     * @throws Throwable
     */
    @BeforeClass
    public static void beforeClass() throws Throwable {
        MobileWebEnvironment environment = new MobileWebEnvironment();
        environment.setPlatform(Platform.IOS);
        environment.setBrowser(Browser.SAFARI);

        String udid = System.getenv("TEST_DEVICE_UDID");
        environment.setUdid(udid);
        if (StringUtils.isBlank(udid) || udid.equalsIgnoreCase("auto")) {
            isRealDevice = true;
        } else {
            isRealDevice = false;
        }

        project = new Project();
        project.setBasePath(Paths.get("."));
        project.setScreenshotPath(Paths.get("screenshot"));
        TestRunConfig testRunConfig = new TestRunConfig();
        webDriver = DriverPool.getInstance().getDriver(environment, project, testRunConfig);
        selenium = new WebExcelium(webDriver, GlobalWebEnvironment.get().getServerUrl(), project);

        if (isRealDevice) {
            selenium.assertLocation("http://appium.io/");
            selenium.assertTitle("Appium: Mobile App Automation Made Awesome.");
        } else {
            selenium.assertLocationMatch("/welcome");
            selenium.assertTitle("Appium/welcome");
            selenium.assertTextPresent("Let's browse!");
        }
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
    public void testImplicitWait() throws Throwable {
        selenium.setTimeout("5000");
        long before = new Date().getTime() / 1000;
        boolean hasThrown = false;

        /**
         * we have to use try catch to actually halt the process here
         */
        try {
            selenium.click("notgonnabethere");
        } catch (Exception e) {
            hasThrown = true;
        } finally {
            Assert.assertTrue(hasThrown);
        }

        long after = new Date().getTime() / 1000;
        Assert.assertTrue((after - before) > 5);
        selenium.setTimeout("1000");
    }

    @Test
    public void testTitle() throws Throwable {
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.assertTitle("I am a page title");
    }

    @Test
    public void testElement() throws Throwable {
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.assertElementPresent("i_am_an_id");
        selenium.assertElementPresent("css=a", "index=5");
        selenium.assertElementNotPresent("css=blar");
        selenium.assertElementPresent("class=border", "xpath=./form");
        selenium.click("link=i am a link");
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");
        selenium.goBack();
        selenium.waitForElementPresent("i_am_an_id");
        selenium.assertAttribute("i_am_an_id", "id", "i_am_an_id");
        selenium.assertElementPresent("css=option", "index=3");
        selenium.assertAttribute("css=option:nth-child(3)", "index", "2");
        selenium.assertText("i_am_an_id", "I am a div");
        selenium.assertText("css=#i_am_an_id", "I am a div");
        selenium.assertPageSourceMatch("<html");
        selenium.assertPageSourceMatch("I am a page title");
        selenium.assertPageSourceMatch("i appear 3 times");
        selenium.assertPageSourceMatch("</html>");
        selenium.assertLocationMatch("test/guinea-pig");
        selenium.click("link=i am an anchor link");
        selenium.pause("500");
        selenium.assertLocationMatch("#anchor");
        try {
            webDriver.getWindowHandles();
        } catch (Exception e) {
            Assert.fail("Should be ok");
        }
        selenium.clear("comments");
        selenium.type("comments", "hello world");
        selenium.assertAttribute("comments", "value", "hello world");

        selenium.clear("comments");
        selenium.typeKeys("comments", "hello world");
        selenium.assertAttribute("comments", "value", "hello world");
        selenium.clear("comments");
        selenium.assertAttribute("comments", "value", "");

        selenium.assertNotChecked("unchecked_checkbox");
        selenium.click("unchecked_checkbox");
        selenium.waitForChecked("unchecked_checkbox");
        selenium.assertChecked("unchecked_checkbox");

        selenium.assertBackgroundColor("fbemail", "rgba(255, 255, 255, 1)");

        selenium.assertTagName("fbemail", "input");
        selenium.assertTagName("css=a", "a");

        selenium.clickAt("link=i am a link", "5,15");
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");
        selenium.goBack();
        selenium.waitForElementPresent("i_am_an_id");

        selenium.type("comments", "This is a comment");
        selenium.submit("jumpContact");
        selenium.waitForText("your_comments", "Your comments: This is a comment");
        selenium.assertText("your_comments", "Your comments: This is a comment");

        selenium.assertVisible("link=i am a link");
        selenium.assertNotVisible("invisible div");
        selenium.assertEnabled("link=i am a link");
        selenium.runScript("$('#fbemail').attr('disabled', 'disabled');");
        selenium.assertNotEnabled("fbemail");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.assertEnabled("fbemail");

        selenium.click("link=i am an anchor link");
        selenium.pause("500");

        String url = webDriver.getCurrentUrl();
        selenium.open(url);
        selenium.assertLocationMatch("#anchor");

        selenium.refresh();
        selenium.assertLocation(url);
    }

    @Test
    public void testConsoleLog() throws Throwable {
        selenium.clearLog();
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.assertLogContainLine("Hello from Appium");
        selenium.assertLogContainLine("Loading guinea-pig page");
        selenium.assertLogContainLine("Done");
        selenium.assertLogNotContainLine("Error: JavaScript Error: xcuitest-error");

        selenium.clearLog();
        selenium.assertLogNotContainLine("Hello from Appium");
        selenium.assertLogNotContainLine("Loading guinea-pig page");
        selenium.assertLogNotContainLine("Done");
        selenium.assertLogNotContainLine("Error: JavaScript Error: xcuitest-error");

        selenium.clearLog();
        selenium.open("../tests/appium/test/guinea-pig.html?throwError=xcuitest-error");
        selenium.assertLogContainLine("Hello from Appium");
        selenium.assertLogContainLine("Loading guinea-pig page");
        selenium.assertLogContainLine("Done");
        selenium.assertLogContainLine("Error: JavaScript Error: xcuitest-error");

        selenium.clearLog();
        selenium.open("../tests/appium/test/guinea-pig.html");

        String[] strings = new String[]{"Log something to debug", "Log something to warn", "Log something to error"};
        for (String str : strings) {
            webDriver.executeScript("console.log('" + str + "');");
        }
        for (String str : strings) {
            selenium.assertLogContainLine(str);
        }
        selenium.assertLogNotContainLine("HELLO WORLD");

        webDriver.executeScript("console.log('HELLO WORLD');");
        for (String str : strings) {
            selenium.assertLogContainLine(str);
        }
        selenium.assertLogContainLine("HELLO WORLD");
    }

    @Test
    public void testAlert() throws Throwable {
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("alert1");
        selenium.assertAlert("I am an alert");
        selenium.chooseOkAlert();
        selenium.assertTitle("I am a page title");

        try {
            selenium.assertAlert("I am an alert");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.click("prompt1");
        selenium.answerPrompt("of course!");
        selenium.assertValue("promptVal", "of course!");

        selenium.click("alert1");

        try {
            selenium.answerPrompt("yes I do!");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.chooseOkAlert();
    }

    @Test
    public void testCookie() throws Throwable {
        selenium.open("../tests/appium/test/iframes.html");
        selenium.deleteAllVisibleCookies();
        selenium.assertCookieNotPresent("guineacookie1");
        selenium.assertCookieNotPresent("guineacookie2");
        selenium.assertCookieNotPresent("guineacookie3");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.deleteCookie("newcookie");

        selenium.assertCookiePresent("guineacookie1");
        selenium.assertCookiePresent("guineacookie2");

        selenium.createCookie("newcookie=i_am_new_here");
        selenium.assertCookiePresent("guineacookie1");
        selenium.assertCookiePresent("guineacookie2");
        selenium.assertCookiePresent("newcookie");

        selenium.deleteAllVisibleCookies();
        selenium.open("../tests/appium/test/guinea-pig.html");

        selenium.assertCookieNotPresent("expiredcookie");
        selenium.createCookie("expiredcookie=i_am_new_here", "max_age=5");
        selenium.assertCookiePresent("guineacookie1");
        selenium.assertCookiePresent("guineacookie2");
        selenium.assertCookiePresent("expiredcookie");

        selenium.pause("5000");

        selenium.assertCookiePresent("guineacookie1");
        selenium.assertCookiePresent("guineacookie2");
        selenium.assertCookieNotPresent("expiredcookie");

        selenium.deleteCookie("expiredcookie");

        selenium.deleteAllVisibleCookies();
        selenium.open("../tests/appium/test/guinea-pig.html");

        selenium.createCookie("newcookie=i_am_new_here");
        selenium.assertCookiePresent("newcookie");

        selenium.deleteCookie("newcookie");
        selenium.assertCookieNotPresent("newcookie");
        selenium.assertCookiePresent("guineacookie1");
        selenium.assertCookiePresent("guineacookie2");

        selenium.deleteAllVisibleCookies();
        selenium.open("../tests/appium/test/guinea-pig.html");

        selenium.createCookie("newcookie=i_am_new_here");
        selenium.assertCookiePresent("newcookie");

        selenium.deleteAllVisibleCookies();
        selenium.assertCookieNotPresent("newcookie");
        selenium.assertCookieNotPresent("guineacookie1");
        selenium.assertCookieNotPresent("guineacookie2");
    }

    @Test
    public void testExecute() throws Throwable {
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.scrollDown();

        try {
            selenium.runScript("'nan'--");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.assertEvalScript("1 + 1", "2");
        selenium.assertEvalScript("1+1", "2");

        try {
            selenium.runScript("return 1+1");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.assertEvalScript("document.body.innerHTML.indexOf('I am some page content') > 0", "true");
        selenium.assertEvalScript("document.body.innerHTML.indexOf('I am not some page content') > 0", "false");
    }

    @Test
    public void testNativeTap() throws Throwable {
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("link=i am a link to page 3");
        selenium.waitForTitle("Another Page: page 3");
        selenium.assertTitle("Another Page: page 3");

        selenium.open("../tests/appium/test/guinea-pig-app-banner.html");
        selenium.click("link=i am a link to page 3");
        selenium.waitForTitle("Another Page: page 3");
        selenium.assertTitle("Another Page: page 3");

        selenium.open("../tests/appium/test/guinea-pig-scrollable.html");
        selenium.scrollDown();
        selenium.click("link=i am a link to page 3");
        selenium.waitForTitle("Another Page: page 3");
        selenium.assertTitle("Another Page: page 3");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.assertPageSourceNotMatch("Your comments: Hello");
        selenium.type("css=[name='comments']", "Hello");
        selenium.click("css=[name='submit']");
        selenium.pause("1000");
        selenium.assertPageSourceMatch("Your comments: Hello");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("link=i am a new window link");
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("link=i am a link to page 3");
        selenium.waitForTitle("Another Page: page 3");
        selenium.assertTitle("Another Page: page 3");
        selenium.goBack();
        selenium.click("link=i am a link to page 3");
        selenium.waitForTitle("Another Page: page 3");
        selenium.assertTitle("Another Page: page 3");
    }

    @Test
    public void testWindow() throws Throwable {
        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.setTimeout("10000");
        try {
            selenium.selectWindow("noexistman");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.click("blanklink");
        selenium.waitForWindowCount("2");
        selenium.selectLastWindow();
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");
        selenium.close();
        selenium.selectOriginalWindow();
        selenium.waitForTitle("I am a page title");
        selenium.assertTitle("I am a page title");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("blanklink");
        selenium.waitForWindowCount("2");
        selenium.selectLastWindow();
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");
        selenium.selectOriginalWindow();
        selenium.waitForTitle("I am a page title");
        selenium.assertTitle("I am a page title");
        selenium.selectLastWindow();
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");
        selenium.close();
        selenium.selectOriginalWindow();
        selenium.waitForTitle("I am a page title");
        selenium.assertTitle("I am a page title");

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("link=i am a link");
        selenium.waitForElementPresent("only_on_page_2");
        selenium.assertElementPresent("only_on_page_2");
        selenium.goBack();
        selenium.waitForElementPresent("i_am_a_textbox");
        selenium.assertElementPresent("i_am_a_textbox");
        selenium.goForward();
        selenium.waitForElementPresent("only_on_page_2");
        selenium.assertElementPresent("only_on_page_2");
        selenium.goBack();

        selenium.open("../tests/appium/test/guinea-pig.html");
        selenium.click("link=i am a new window link");
        selenium.waitForWindowCount("2");
        selenium.selectLastWindow();
        selenium.waitForTitle("I am another page title");
        selenium.assertTitle("I am another page title");
    }

    @Test
    public void testFrame() throws Throwable {
        selenium.open("../tests/appium/test/frameset.html");
        selenium.selectFrame("name=first");
        selenium.assertTitle("Sub frame 1");
        selenium.assertText("css=h1", "Sub frame 1");

        selenium.open("../tests/appium/test/frameset.html");
        selenium.selectFrame("index=1");
        selenium.assertTitle("Sub frame 2");
        selenium.assertText("css=h1", "Sub frame 2");

        selenium.open("../tests/appium/test/frameset.html");
        selenium.selectFrame("id=frame3");
        selenium.assertTitle("Sub frame 3");
        selenium.assertText("css=h1", "Sub frame 3");

        selenium.open("../tests/appium/test/frameset.html");
        selenium.selectFrame("name=first");
        selenium.assertTitle("Sub frame 1");
        selenium.assertText("css=h1", "Sub frame 1");
        selenium.selectFrame("relative=top");
        selenium.assertElementPresent("css=frameset");

        selenium.open("../tests/appium/test/frameset.html");
        selenium.selectFrame("name=third");
        selenium.assertTitle("Sub frame 3");
        selenium.selectFrame("name=childframe");
        selenium.assertElementPresent("only_on_page_2");

        selenium.open("../tests/appium/test/frameset.html");
        selenium.selectFrame("name=first");
        selenium.assertEvalScript("document.getElementsByTagName('h1')[0].innerHTML", "Sub frame 1");

        selenium.open("../tests/appium/test/frameset.html");
        selenium.assertPageSourceMatch("Frameset guinea pig");
        selenium.selectFrame("name=first");
        selenium.assertPageSourceMatch("Sub frame 1");
        selenium.assertPageSourceNotMatch("Frameset guinea pig");
    }

    @Test
    public void testIFrame() throws Throwable {
        selenium.open("../tests/appium/test/iframes.html");
        selenium.selectFrame("name=iframe1");
        selenium.assertTitle("Sub frame 1");
        selenium.assertText("css=h1", "Sub frame 1");

        selenium.open("../tests/appium/test/iframes.html");
        selenium.selectFrame("index=1");
        selenium.assertTitle("Sub frame 2");
        selenium.assertText("css=h1", "Sub frame 2");

        selenium.open("../tests/appium/test/iframes.html");
        selenium.selectFrame("id=id-iframe3");
        selenium.assertTitle("Sub frame 3");
        selenium.assertText("css=h1", "Sub frame 3");

        selenium.open("../tests/appium/test/iframes.html");
        try {
            selenium.selectFrame("id=noexist");
            Assert.fail("Should be rejected");
        } catch (Exception e) {
        }

        selenium.open("../tests/appium/test/iframes.html");
        selenium.selectFrame("name=iframe1");
        selenium.assertTitle("Sub frame 1");
        selenium.assertText("css=h1", "Sub frame 1");
        selenium.selectFrame("relative=top");
        selenium.assertElementPresent("css=iframe");

        selenium.open("../tests/appium/test/iframes.html");
        selenium.assertPageSourceMatch("Iframe guinea pig");
        selenium.selectFrame("name=iframe1");
        selenium.assertPageSourceMatch("Sub frame 1");
        selenium.assertPageSourceNotMatch("Iframe guinea pig");
    }
}