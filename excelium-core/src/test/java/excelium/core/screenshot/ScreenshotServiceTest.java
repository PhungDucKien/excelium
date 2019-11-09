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

package excelium.core.screenshot;

import excelium.core.TestRunner;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.enums.Browser;
import excelium.model.project.Project;
import excelium.model.test.TestFlow;
import excelium.model.test.TestStep;
import excelium.model.test.TestSuite;
import excelium.model.test.config.Environment;
import excelium.model.test.config.PcEnvironment;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * Tests for {@link ScreenshotService}.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
public class ScreenshotServiceTest {

    @Mocked
    private TestRunner testRunner;

    @Mocked
    private AShot aShot;

    @Mocked
    private Screenshot screenshot;

    @Mocked
    private ContextAwareWebDriver webDriver;

    @Test
    public void testCaptureEntirePage() throws IOException {
        excelium.model.test.Test test = new excelium.model.test.Test();
        test.setWorkbookName("Workbook1");
        TestSuite testSuite = new TestSuite();
        testSuite.setSheetName("Sheet1");
        List<TestFlow> testFlows = new ArrayList<>();
        TestFlow testFlow = new TestFlow();
        testFlow.setNo(1);
        testFlows.add(testFlow);
        testFlow = new TestFlow();
        testFlow.setNo(3);
        testFlows.add(testFlow);
        testFlow = new TestFlow();
        testFlow.setNo(5);
        testFlows.add(testFlow);
        TestStep testStep = new TestStep();
        testStep.setNo(10);
        Environment environment = new PcEnvironment();
        ((PcEnvironment) environment).setBrowser(Browser.CHROME);

        Project project = new Project();
        project.setScreenshotPath(Paths.get("dump"));

        new Expectations() {{
            testRunner.getTest(); result = test;
            testRunner.getTestSuite(); result = testSuite;
            testRunner.getTestFlows(); result = testFlows;
            testRunner.getTestStep(); result = testStep;
            testRunner.getEnvironment(); result = environment;
            testRunner.getProject(); result = project;

            aShot.takeScreenshot((WebDriver) any); result = screenshot;
            screenshot.getImage(); result = new BufferedImage(100, 100, TYPE_INT_RGB);

            webDriver.executeScript(anyString); result = 1;
            webDriver.isWeb(); result = true;
        }};

        ScreenshotService screenshotService = new ScreenshotService(testRunner);
        screenshotService.captureEntirePage(webDriver);

        Path imagePath = Paths.get("dump/Chrome/Workbook1/Sheet1/1.3.5-10.png");
        Assert.assertTrue(Files.exists(imagePath));

        new Verifications() {{
            aShot.takeScreenshot((WebDriver) any);
        }};

        Files.delete(imagePath);
        Files.delete(Paths.get("dump/Chrome/Workbook1/Sheet1"));
        Files.delete(Paths.get("dump/Chrome/Workbook1"));
        Files.delete(Paths.get("dump/Chrome"));
        Files.delete(Paths.get("dump"));
    }
}
