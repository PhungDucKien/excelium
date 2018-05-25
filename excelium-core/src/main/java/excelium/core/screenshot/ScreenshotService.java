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

import com.google.common.io.Files;
import excelium.core.TestRunner;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import excelium.model.test.Test;
import excelium.model.test.TestFlow;
import excelium.model.test.TestStep;
import excelium.model.test.TestSuite;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ru.yandex.qatools.ashot.util.InnerScript.execute;

/**
 * A service for screenshot capturing.
 *
 * @author PhungDucKien
 * @since 2018.05.22
 */
public class ScreenshotService {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Path to the javascript to find the DPR (device pixel ratio) value of the current environment
     */
    private static final String DPR_JS = "js/dpr.js";

    /**
     * Test runner
     */
    private final TestRunner testRunner;

    /**
     * Project
     */
    private final Project project;

    /**
     * Screenshot taker
     */
    private final AShot screenshotTaker;

    /**
     * Current web driver
     */
    private ContextAwareWebDriver currentWebDriver;

    /**
     * Instantiates a new Screenshot service.
     *
     * @param testRunner the test runner
     * @param project    the project
     */
    public ScreenshotService(TestRunner testRunner, Project project) {
        this.testRunner = testRunner;
        this.project = project;

        screenshotTaker = new AShot();
    }

    /**
     * Capture a screenshot of entire page.
     *
     * @param webDriver the web driver
     */
    public void captureEntirePage(ContextAwareWebDriver webDriver) {
        if (testRunner.getEnvironment() instanceof MobileAppEnvironment) {
            captureAppPage(webDriver);
        } else {
            captureWebPage(webDriver);
        }
    }

    /**
     * Capture a screenshot of an element
     *
     * @param webDriver the web driver
     * @param element   the web element
     */
    public void captureElement(ContextAwareWebDriver webDriver, WebElement element) {
        if (testRunner.getEnvironment() instanceof MobileAppEnvironment) {
            throw new RuntimeException("The action is not supported");
        } else {
            captureWebElement(webDriver, element);
        }
    }

    /**
     * Capture a screenshot of entire mobile application page.
     *
     * @param webDriver  the web driver
     */
    private void captureAppPage(ContextAwareWebDriver webDriver) {
        try {
            File srcFile = webDriver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(getScreenshotImagePath()));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Capture a screenshot of entire web page.
     *
     * @param webDriver  the web driver
     */
    private void captureWebPage(ContextAwareWebDriver webDriver) {
        try {
            setShootingStrategy(webDriver);
            Screenshot screenshot = screenshotTaker.takeScreenshot(webDriver);
            writeImage(screenshot.getImage(), getScreenshotImagePath());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Capture a screenshot of a web element
     *
     * @param webDriver  the web driver
     * @param element    the web element
     */
    private void captureWebElement(ContextAwareWebDriver webDriver, WebElement element) {
        try {
            setShootingStrategy(webDriver);
            Screenshot screenshot = screenshotTaker.takeScreenshot(webDriver, element);
            writeImage(screenshot.getImage(), getScreenshotImagePath());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Gets the path to save the screenshot to.
     *
     * @return the screenshot image path
     */
    private String getScreenshotImagePath() {
        Environment environment = testRunner.getEnvironment();
        Test test = testRunner.getTest();
        TestSuite testSuite = testRunner.getTestSuite();
        TestStep testStep = testRunner.getTestStep();

        StringBuilder stringBuilder = new StringBuilder();
        for (TestFlow testFlow : testRunner.getTestFlows()) {
            stringBuilder.append(testFlow.getNo() + "-");
        }
        stringBuilder.append(testStep.getNo()).append(".png");

        return this.project.getScreenshotPath()
                .resolve(environment.getKey())
                .resolve(test.getWorkbookName())
                .resolve(testSuite.getSheetName())
                .resolve(stringBuilder.toString()).toString();
    }

    /**
     * Writes the buffered image to disk.
     *
     * @param image     the buffered image
     * @param imagePath the image path
     * @throws IOException if the IOException occurs
     */
    private void writeImage(BufferedImage image, String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        // Create parent dirs
        Files.createParentDirs(imageFile);
        ImageIO.write(image, "png", imageFile);
    }

    /**
     * Sets the shooting strategy
     *
     * @param webDriver the web driver
     */
    private synchronized void setShootingStrategy(ContextAwareWebDriver webDriver) {
        if (currentWebDriver != webDriver) {
            screenshotTaker.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(getDpr(webDriver)), 100));
            currentWebDriver = webDriver;
        }
    }

    /**
     * Gets the DPR (device pixel ratio) value of the current environment
     *
     * @param webDriver the web driver
     * @return DPR value
     */
    private float getDpr(ContextAwareWebDriver webDriver) {
        return ((Number) execute(DPR_JS, webDriver)).floatValue();
    }
}
