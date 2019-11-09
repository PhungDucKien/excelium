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
import org.fusesource.jansi.Ansi;
import org.openqa.selenium.WebElement;

import static org.apache.commons.lang3.StringUtils.rightPad;

/**
 * Represents a class which contains commands for debugging.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class DebugCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Debug command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public DebugCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Prints the specified message into the third table cell in your Selenese tables.
     * Useful for debugging.
     *
     * @param message the message to print
     */
    @Action(param1 = "message")
    public void echo(String message) {
        System.out.print(Ansi.ansi().cursorUp(1).eraseLine());
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).a(rightPad("", 10) + message).reset());
        System.out.println();
    }

    /**
     * Briefly changes the backgroundColor of the specified element yellow. Useful for debugging.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public void highlight(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        webDriver.getJavascriptLibrary().callEmbeddedHtmlUtils(webDriver, "highlight", element);
    }
}
