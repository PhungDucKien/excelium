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
import excelium.model.test.config.MobileWebEnvironment;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Date;

public class IOSWebExecutorTest {

    protected static ContextAwareWebDriver webDriver;

    protected static WebExcelium selenium;

    protected static Project project;

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

        project = new Project();
        project.setScreenshotPath(Paths.get("screenshot"));
        webDriver = DriverPool.getInstance().getDriver(environment, project);
        selenium = new WebExcelium(webDriver, GlobalWebEnvironment.get().getServerUrl(), project);

       selenium.assertLocation("http://appium.io/");
       selenium.assertTitle("Appium: Mobile App Automation Made Awesome.");
    }

    @AfterClass
    public static void afterClass() {
        if (webDriver != null) {
            DriverPool.getInstance().dismissDriver(webDriver.getWebDriver());
        }
        webDriver = null;
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
        selenium.assertHtmlSourceMatch("<html");
        selenium.assertHtmlSourceMatch("I am a page title");
        selenium.assertHtmlSourceMatch("i appear 3 times");
        selenium.assertHtmlSourceMatch("</html>");
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
}
