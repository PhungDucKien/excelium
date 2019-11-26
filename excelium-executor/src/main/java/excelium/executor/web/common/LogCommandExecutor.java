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

package excelium.executor.web.common;

import com.google.gson.Gson;
import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.AssertFailedException;
import excelium.model.project.Project;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

/**
 * Console log related command executor.
 *
 * @author PhungDucKien
 * @since 2019.11.24
 */
public class LogCommandExecutor extends CommandExecutor {

    private List<String> logs;

    /**
     * Instantiates a new Console log command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public LogCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
        logs = new ArrayList<>();
    }

    /**
     * Clear browser console log.
     */
    @Action
    public void clearLog() {
        if (webDriver.isPC()) {
            webDriver.manage().logs().get(LogType.BROWSER);
        } else {
            webDriver.manage().logs().get("safariConsole");
        }
        logs.clear();
    }

    /**
     * Verifies the console log contains the given text.
     *
     * @param text the text to compare
     * @throws AssertFailedException if the console log doesn't contain the given text
     */
    @Action(param1 = "text")
    public void verifyLogContainLine(String text) throws Exception {
        if (webDriver.isPC()) {
            webDriver.manage().logs().get(LogType.BROWSER).iterator().forEachRemaining(entry -> logs.add(new Gson().fromJson(entry.getMessage(), LogEntry.class).getText()));
        } else {
            webDriver.manage().logs().get("safariConsole").iterator().forEachRemaining(entry -> logs.add(new Gson().fromJson(entry.getMessage(), LogEntry.class).getText()));
        }

        if (logs.stream().noneMatch(l -> l.equals(text))) {
            throw new AssertFailedException("Actual console log did not contain '" + text + "'");
        }
    }

    /**
     * Verifies the console log does not contain the given text.
     *
     * @param text the text to compare
     * @throws AssertFailedException if the console log contains the given text
     */
    @Action(param1 = "text")
    public void verifyLogNotContainLine(String text) throws Exception {
        if (webDriver.isPC()) {
            webDriver.manage().logs().get(LogType.BROWSER).iterator().forEachRemaining(entry -> logs.add(new Gson().fromJson(entry.getMessage(), LogEntry.class).getText()));
        } else {
            webDriver.manage().logs().get("safariConsole").iterator().forEachRemaining(entry -> logs.add(new Gson().fromJson(entry.getMessage(), LogEntry.class).getText()));
        }

        if (logs.stream().anyMatch(l -> l.equals(text))) {
            throw new AssertFailedException("Actual console log did contain '" + text + "'");
        }
    }

    private static class LogEntry {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
