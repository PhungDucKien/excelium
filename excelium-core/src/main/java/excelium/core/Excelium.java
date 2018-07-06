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

import excelium.core.command.CommandFactory;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.ActionNotFoundException;
import excelium.core.exception.CommandNotFoundException;
import excelium.model.project.Project;
import excelium.model.test.command.Command;
import org.apache.commons.lang3.StringUtils;

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
    protected final ContextAwareWebDriver webDriver;

    /**
     * The command map
     */
    private Map<String, Command> commandMap;

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
        this.commandMap = CommandFactory.createCommandMap(webDriver, baseUrl, this, project, webDriver.isWeb());
    }

    /**
     * Run the command.
     *
     * @param methodName the method name
     * @param param1  value of parameter 1
     * @param param2  value of parameter 2
     * @param param3  value of parameter 3
     * @throws Throwable if an error occurred
     */
    protected void runCommand(String methodName, Object param1, Object param2, Object param3) throws Throwable {
        Command command = commandMap.get(methodName + "(" + countParam(param1, param2, param3) + ")");
        if (command != null) {
            try {
                param1 = param1 instanceof String ? preprocessParameter((String) param1) : param1;
                param2 = param2 instanceof String ? preprocessParameter((String) param2) : param2;
                param3 = param3 instanceof String ? preprocessParameter((String) param3) : param3;
                command.getConsumer().accept(param1, param2, param3);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        } else {
            throw new CommandNotFoundException("Command not found: " + methodName);
        }
    }

    /**
     * Run the action using the action name
     *
     * @param actionName the action name
     * @throws Exception if an error occurred
     */
    void runAction(String actionName) throws Exception {
        if (actions.containsKey(actionName)) {
            actions.get(actionName).perform(null);
        } else {
            throw new ActionNotFoundException("Action not found: " + actionName);
        }
    }

    /**
     * Evaluate a parameter, performing evaluation and variable substitution.
     * If the string matches the pattern "exp{ ... }", evaluate the string between the braces.
     */
    private String preprocessParameter(String value) {
        Matcher match = Pattern.compile("^exp\\{((.|\\r?\\n)+)\\}$").matcher(value);
        if (match.find()) {
            Object result = webDriver.evalExp(match.group(1));
            return result == null ? null : result.toString();
        }
        return webDriver.evalTemplate(value);
    }

    /**
     * Count the number of parameters.
     *
     * @return the number of parameters
     */
    private static int countParam(Object param1, Object param2, Object param3) {
        int count = 0;
        if ((param1 instanceof String && StringUtils.isNotBlank((String) param1)) || param1 != null) count++;
        if ((param2 instanceof String && StringUtils.isNotBlank((String) param2)) || param2 != null) count++;
        if ((param3 instanceof String && StringUtils.isNotBlank((String) param3)) || param3 != null) count++;
        return count;
    }

    /**
     * Gets command map.
     *
     * @return the command map
     */
    Map<String, Command> getCommandMap() {
        return commandMap;
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
