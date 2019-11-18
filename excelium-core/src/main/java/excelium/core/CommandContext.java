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

package excelium.core;

import excelium.core.command.CommandFactory;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.CommandNotFoundException;
import excelium.model.project.Project;
import excelium.model.test.command.Command;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines a context to run Excelium commands.
 *
 * @author PhungDucKien
 * @since 2019.11.16
 */
public class CommandContext {

    /**
     * Web driver
     */
    protected final ContextAwareWebDriver webDriver;

    /**
     * The command map
     */
    private Map<String, Command> commandMap;

    /**
     * Instantiates a new Command context.
     *
     * @param baseUrl    the base url
     * @param excelium   the excelium object
     * @param project    the project
     * @param webContext the web context
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    public CommandContext(String baseUrl, Excelium excelium, Project project, boolean webContext) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.webDriver = excelium.getWebDriver();
        this.commandMap = CommandFactory.createCommandMap(this.webDriver, baseUrl, excelium, project, webContext);
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
                param1 = preprocessParameter(param1);
                param2 = preprocessParameter(param2);
                param3 = preprocessParameter(param3);
                command.getConsumer().accept(param1, param2, param3);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        } else {
            throw new CommandNotFoundException("Command not found: " + methodName);
        }
    }

    /**
     * Preprocesses parameter value.
     *
     * @param paramValue parameter value
     * @return processed value
     */
    private Object preprocessParameter(Object paramValue) {
        if (paramValue instanceof String) {
            return preprocessStringParameter((String) paramValue);
        }
        if (paramValue != null && paramValue.getClass().equals(String[].class)) {
            String[] value = new String[((String[])paramValue).length];
            for (int i = 0; i < ((String[])paramValue).length; i++) {
                value[i] = preprocessStringParameter(((String[])paramValue)[i]);
            }
            return value;
        }
        return paramValue;
    }

    /**
     * Evaluate a string parameter, performing evaluation and variable substitution.
     * If the string matches the pattern "exp{ ... }", evaluate the string between the braces.
     */
    private String preprocessStringParameter(String value) {
        Matcher match = Pattern.compile("^exp\\{((.|\\r?\\n)+)\\}$").matcher(value);
        if (match.find()) {
            Object result = webDriver.evalExp(match.group(1));
            return result == null ? null : result.toString();
        }
        try {
            return webDriver.evalTemplate(value);
        } catch (Exception e) {
            return value;
        }
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
}
