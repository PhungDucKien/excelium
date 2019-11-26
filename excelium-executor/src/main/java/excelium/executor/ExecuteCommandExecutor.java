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

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Represents a class which contains commands for executing actions.
 *
 * @author PhungDucKien
 * @since 2018.07.04
 */
public class ExecuteCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Execute command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public ExecuteCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Executes an action.
     *
     * @param action the action
     * @throws Exception the exception
     */
    @Action(param1 = "action")
    public void execute(String action) throws Exception {
        runAction(action);
    }

    /**
     * Executes an action n times.
     *
     * @param action the action
     * @param times  the times
     * @throws Exception the exception
     */
    @Action(param1 = "action", param2 = "times")
    public void executeLoop(String action, String times) throws Exception {
        for (int i = 0; i < Double.valueOf(times).intValue(); i++) {
            runAction(action);
        }
    }

    /**
     * Iterates over the list of the specified elements and executes an action.
     *
     * @param action   the action
     * @param locator  the locator
     * @param variable the variable
     * @throws Exception the exception
     */
    @Action(param1 = "action", param2 = "locator", param3 = "variable")
    public void executeEach(String action, String locator, String variable) throws Exception {
        List<WebElement> webElements = webDriver.findElements(locator);
        for (WebElement webElement : webElements) {
            webDriver.setVariable(webElement, variable);
            runAction(action);
        }
    }
}
