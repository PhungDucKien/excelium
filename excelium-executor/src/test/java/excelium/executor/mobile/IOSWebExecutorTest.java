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
import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.project.Project;
import excelium.model.test.config.MobileWebEnvironment;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;

public class IOSWebExecutorTest {

    protected static ContextAwareWebDriver webDriver;

    protected static MobileExcelium selenium;

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
     * @throws IOException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @BeforeClass
    public static void beforeClass() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MobileWebEnvironment environment = new MobileWebEnvironment();
        environment.setPlatform(Platform.IOS);
        environment.setBrowser(Browser.SAFARI);

        project = new Project();
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