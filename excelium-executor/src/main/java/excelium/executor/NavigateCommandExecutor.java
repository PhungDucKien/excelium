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

import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;

/**
 * Represents a class which contains commands for navigating.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class NavigateCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Navigate command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public NavigateCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Simulates the user clicking the "Refresh" button on their browser.
     */
    @Action(webOnly = true)
    public void refresh() {
        webDriver.navigate().refresh();
    }

    /**
     * Simulates the user clicking the "back" button on their browser.
     */
    @Action
    public void goBack() {
        webDriver.navigate().back();
    }

    /**
     * Simulates the user clicking the "forward" button on their browser.
     */
    @Action(webOnly = true)
    public void goForward() {
        webDriver.navigate().forward();
    }
}
