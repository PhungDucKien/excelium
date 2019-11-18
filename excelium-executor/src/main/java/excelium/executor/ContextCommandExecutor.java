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
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.executor.MobileExcelium;
import excelium.model.project.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Represents a class which contains commands for controlling mobile context actions.
 *
 * @author PhungDucKien
 * @since 2019.11.10
 */
public class ContextCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Context command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public ContextCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Set the context being automated.
     * <p>
     * Set the current context to that passed in. If this is moving into a web view context it will involve attempting to connect to that web view:
     * <p>
     * - iOS - attempt to connect to the application through the remote debugger
     * - Android - start a Chromedriver process and begin a session to connect to the web view
     *
     * @param context The name of the context to which to change
     */
    @Action(param1 = "context", web = false)
    public void setContext(String context) {
        webDriver.getAppiumDriver().context(context);
        if (context.toUpperCase().startsWith("WEBVIEW_")) {
            ((MobileExcelium) excelium).setWebContext();
        } else {
            ((MobileExcelium) excelium).setNativeContext();
        }
    }

    /**
     * Set the context being automated to the native app context.
     */
    @Action(web = false)
    public void setNativeAppContext() {
        webDriver.getAppiumDriver().context("NATIVE_APP");
        ((MobileExcelium) excelium).setNativeContext();
    }

    /**
     * Set the context being automated to a web view context.
     * <p>
     * It will involve attempting to connect to that web view:
     * <p>
     * - iOS - attempt to connect to the application through the remote debugger
     * - Android - start a Chromedriver process and begin a session to connect to the web view
     *
     * @param index The index of the web view context
     */
    @Action(param1 = "index", web = false)
    public void setWebViewContext(String index) {
        Set<String> contexts = webDriver.getAppiumDriver().getContextHandles();
        List<String> webViewContexts = new ArrayList<>();
        for (String context : contexts) {
            if (context.startsWith("WEBVIEW_")) {
                webViewContexts.add(context);
            }
        }

        int idx = Integer.parseInt(index);
        if (idx > webViewContexts.size()) {
            throw new IndexOutOfBoundsException("No context with index = " + index + " available");
        }

        webDriver.getAppiumDriver().context(webViewContexts.get(idx - 1));
        ((MobileExcelium) excelium).setWebContext();
    }

    /**
     * Get the current context in which Appium is running.
     * <p>
     * Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be:
     * <p>
     * - iOS - WEBVIEW_<id>
     * - Android - WEBVIEW_<package name>
     *
     * @return the current context
     */
    @Accessor(web = false)
    public String getContext() {
        return webDriver.getAppiumDriver().getContext();
    }

    /**
     * Get the count of contexts.
     *
     * @return the count of contexts
     */
    @Accessor(web = false)
    public int getContextCount() {
        return webDriver.getAppiumDriver().getContextHandles().size();
    }
}
