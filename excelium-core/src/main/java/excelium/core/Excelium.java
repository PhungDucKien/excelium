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

package excelium.core;

import excelium.common.StringUtil;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.ActionNotFoundException;
import excelium.model.project.Project;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines an object that runs Excelium commands.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class Excelium {

    /**
     * Web driver
     */
    private final ContextAwareWebDriver webDriver;

    /**
     * Current context
     */
    private String currentContext;

    /**
     * The map of command contexts
     */
    private Map<String, CommandContext> commandContexts;

    /**
     * The map of actions
     */
    private Map<String, Action> actions;

    /**
     * Instantiates a new Excelium.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param project   the project
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    public Excelium(ContextAwareWebDriver webDriver, String baseUrl, Project project) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.webDriver = webDriver;
        this.actions = new HashMap<>();
        this.commandContexts = new HashMap<>();

        initCommandContexts(webDriver, baseUrl, project);
    }

    /**
     * Run the command.
     *
     * @param methodName the method name
     * @param param1     value of parameter 1
     * @param param2     value of parameter 2
     * @param param3     value of parameter 3
     * @throws Throwable if an error occurred
     */
    protected void runCommand(String methodName, Object param1, Object param2, Object param3) throws Throwable {
        commandContexts.get(currentContext).runCommand(methodName, param1, param2, param3);
    }

    /**
     * Run the action using the action name
     *
     * @param actionName the action name
     * @throws Exception if an error occurred
     */
    void runAction(String actionName) throws Exception {
        String actionNameWithNumberOfParams = StringUtil.getNameWithNumberOfParams(actionName).trim();
        for (String key : actions.keySet()) {
            if (StringUtil.getNameWithNumberOfParams(key).trim().equals(actionNameWithNumberOfParams)) {
                // Set parameters if any
                Pattern p = Pattern.compile("\\b[^()]+\\[(.*)\\]$");
                Matcher paramMatcher = p.matcher(key);
                Matcher valueMatcher = p.matcher(actionName);
                if (paramMatcher.find() && valueMatcher.find()) {
                    String[] params = paramMatcher.group(1).split(",");
                    String[] values = valueMatcher.group(1).split(",");

                    Map<String, Object> before = new HashMap<>();

                    int i = 0;
                    for (String param : params) {
                        String value = values[i];
                        before.put(param, webDriver.getVariable(param));
                        webDriver.setVariable(value, param);
                        i++;
                    }

                    actions.get(key).perform();

                    // Restores variable
                    for (String param : before.keySet()) {
                        webDriver.setVariable(before.get(param), param);
                    }
                } else {
                    actions.get(key).perform();
                }
                return;
            }
        }
        throw new ActionNotFoundException("Action not found: " + actionName);
    }

    private void initCommandContexts(ContextAwareWebDriver webDriver, String baseUrl, Project project) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (webDriver.isWebApp()) {
            CommandContext webContext = new CommandContext(baseUrl, this, project, true);
            commandContexts.put("WEB", webContext);

            setWebContext();
        } else if (webDriver.isMobileApp()) {
            CommandContext nativeContext = new CommandContext(baseUrl, this, project, false);
            commandContexts.put("NATIVE", nativeContext);

            CommandContext webContext = new CommandContext(baseUrl, this, project, true);
            commandContexts.put("WEB", webContext);

            setNativeContext();
        }
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public ContextAwareWebDriver getWebDriver() {
        return webDriver;
    }

    protected String getCurrentContext() {
        return currentContext;
    }

    protected void setWebContext() {
        this.currentContext = "WEB";
    }

    protected void setNativeContext() {
        this.currentContext = "NATIVE";
    }

    CommandContext getCurrentCommandContext() {
        return commandContexts.get(currentContext);
    }

    /**
     * Add action.
     *
     * @param actionName the action name
     * @param action     the action
     */
    void addAction(String actionName, Action action) {
        actions.put(actionName, action);
    }
}
