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

package excelium.executor;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.driver.DriverPool;
import excelium.model.project.Project;

import java.util.concurrent.TimeUnit;

/**
 * Represents a class which contains commands for controlling drivers.
 *
 * @author PhungDucKien
 * @since 2019.11.27
 */
public class DriverCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Driver command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public DriverCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Clean the current web driver to the initial state.
     */
    @Action
    public void cleanDriver() {
        DriverPool.getInstance().cleanDriver(webDriver.getWebDriver());
    }

    /**
     * Specifies the amount of time that Selenium will wait for actions to complete.
     *
     * <p>
     * Actions that require waiting include "open" and the "waitFor*" actions.
     * </p>
     * The default timeout is 30 seconds.
     *
     * @param timeout a timeout in milliseconds, after which the action will return with an error
     */
    @Action(param1 = "timeout")
    public void setTimeout(String timeout) {
        webDriver.manage().timeouts().implicitlyWait(Long.valueOf(timeout), TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().setScriptTimeout(Long.valueOf(timeout), TimeUnit.MILLISECONDS);
        webDriver.setTimeout(Integer.valueOf(timeout));
    }

    /**
     * Sets the amount of time to wait for a page load to complete before throwing an error.
     *
     * @param timeout a timeout in milliseconds, after which the page load will return with an error
     */
    @Action(param1 = "timeout", android = false, ios = false)
    public void setPageLoadTimeout(String timeout) {
        long wait = toPositiveInteger(timeout, webDriver.getTimeout());
        webDriver.manage().timeouts().pageLoadTimeout(wait, TimeUnit.MILLISECONDS);
    }
}
