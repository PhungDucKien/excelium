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

package excelium.core.driver;

import excelium.model.enums.Browser;
import excelium.model.test.config.Environment;
import excelium.model.test.config.PcEnvironment;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverCleaner {

    /**
     * Default implicit wait (in milliseconds) for web driver
     */
    private static final int WEBDRIVER_DEFAULT_IMPLICIT_WAIT = 1000;

    /**
     * Default script timeout (in milliseconds) for web driver
     */
    private static final int WEBDRIVER_DEFAULT_SCRIPT_TIMEOUT = 30000;

    /**
     * Default page load timeout (in milliseconds) for web driver
     */
    private static final int WEBDRIVER_DEFAULT_PAGE_LOAD_TIMEOUT = 300000;

    public boolean clean(RemoteWebDriver webDriver, Environment environment, String originalHandle) {
        if (webDriver == null) {
            return false;
        }
        try {
            webDriver.manage().timeouts().implicitlyWait(WEBDRIVER_DEFAULT_IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
            webDriver.manage().timeouts().setScriptTimeout(WEBDRIVER_DEFAULT_SCRIPT_TIMEOUT, TimeUnit.MILLISECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(WEBDRIVER_DEFAULT_PAGE_LOAD_TIMEOUT, TimeUnit.MILLISECONDS);

            if (!(webDriver instanceof AppiumDriver) || ((AppiumDriver) webDriver).isBrowser()) {
                if (webDriver.switchTo() != null) {
                    if (isAlertPresent(webDriver)) {
                        Alert alert = webDriver.switchTo().alert();
                        if (alert != null) {
                            alert.dismiss();
                        }
                    }

                    for (String handle : webDriver.getWindowHandles()) {
                        if (!handle.equals(originalHandle)) {
                            webDriver.switchTo().window(handle);
                            webDriver.close();
                        }
                    }
                    webDriver.switchTo().window(originalHandle);
                }

                webDriver.manage().deleteAllCookies();

                if (environment instanceof PcEnvironment) {
                    // OperaChromiumDriver 2.32: cannot resize window https://github.com/operasoftware/operachromiumdriver/issues/50
                    if (((PcEnvironment) environment).getBrowser() != Browser.OPERA) {
                        setWindowSize(webDriver, (PcEnvironment) environment);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determines whether an alert dialog is present.
     *
     * @return true if an alert dialog is present, false otherwise.
     */
    private boolean isAlertPresent(RemoteWebDriver webDriver) {
        try {
            webDriver.switchTo().alert();
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    /**
     * Set the web driver to the desired window size
     *
     * @param webDriver   the web driver
     * @param environment the environment
     */
    private void setWindowSize(RemoteWebDriver webDriver, PcEnvironment environment) {
        String resolution = environment.getResolution();
        if (StringUtils.isNotBlank(resolution)) {
            String[] dimensions = resolution.split("x");
            webDriver.manage().window().setSize(new Dimension(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])));
        }
    }
}
