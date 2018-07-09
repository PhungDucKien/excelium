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

package excelium.executor.web;

import excelium.common.PlatformDetector;
import excelium.core.CommandExecutor;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverFactory;
import excelium.executor.WebExcelium;
import excelium.executor.web.env.GlobalWebEnvironment;
import excelium.model.enums.Browser;
import excelium.model.project.Project;
import excelium.model.test.config.PcEnvironment;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;

/**
 * Test base for {@link CommandExecutor}
 *
 * @author PhungDucKien
 * @since 2018.06.29
 */
public class WebExecutorTestBase {

    protected static ContextAwareWebDriver webDriver;

    protected static WebExcelium selenium;

    @BeforeClass
    public static void initializeServer() {
        GlobalWebEnvironment.setUp();
    }

    @BeforeClass
    public static void beforeClass() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environment.setPlatform(PlatformDetector.getPlatform());
        environment.setResolution("1024x768");

        Project project = new Project();
        project.setDownloadPath(Paths.get("download"));
        webDriver = DriverFactory.createDriver(environment, project);
        selenium = new WebExcelium(webDriver, GlobalWebEnvironment.get().getServerUrl(), null);
    }

    @AfterClass
    public static void afterClass() {
        webDriver.quit();
        webDriver = null;
    }
}