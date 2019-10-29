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

package excelium.executor;

import excelium.core.TestRunner;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverFactory;
import excelium.core.report.TestReporter;
import excelium.core.screenshot.ScreenshotService;
import excelium.core.writer.TestWriter;
import excelium.model.enums.Browser;
import excelium.model.project.Project;
import excelium.model.test.config.Environment;
import excelium.model.test.config.PcEnvironment;
import excelium.model.test.config.TestConfig;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link MyExecutorProviderService}
 *
 * @author PhungDucKien
 * @since 2018.05.29
 */
public class MyExecutorProviderServiceTest {

    @Mocked
    private TestWriter testWriter;

    @Mocked
    private ContextAwareWebDriver webDriver;

    @Test
    public void testGetWebExecutorClasses() throws Exception {
        new MockUp<DriverFactory>() {
            @Mock
            public ContextAwareWebDriver createDriver(Environment environment, Project project, ScreenshotService screenshotService) throws IOException {
                return webDriver;
            }
        };

        excelium.model.test.Test test = new excelium.model.test.Test();
        test.setWorkbookName("Workbook test");

        TestConfig testConfig = new TestConfig();
        List<Environment> environments = new ArrayList<>();
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environments.add(environment);
        testConfig.setEnvironments(environments);
        test.setConfig(testConfig);

        TestReporter testReporter = new TestReporter(System.out);

        TestRunner testRunner = new TestRunner(test, null, testReporter, testWriter, null);
        testRunner.runAll();

//        List<Class<? extends CommandExecutor>> webCommandExecutorClasses = Deencapsulation.getField(testRunner, "webCommandExecutorClasses");
//        Assert.assertEquals(1, webCommandExecutorClasses.size());
//        Assert.assertEquals(WebCommandExecutor.class, webCommandExecutorClasses.get(0));
    }
}
