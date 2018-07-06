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

import com.thoughtworks.selenium.webdriven.CompoundMutator;
import com.thoughtworks.selenium.webdriven.ScriptMutator;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a class which contains commands for evaluating expressions and scripts.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class EvalCommandExecutor extends CommandExecutor {

    /**
     * Script mutator
     */
    private final ScriptMutator scriptMutator;

    /**
     * Instantiates a new Eval command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public EvalCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
        scriptMutator = new CompoundMutator(baseUrl);
    }

    /**
     * Gets the result of evaluating the specified snippet.
     *
     * @param expression the snippet to run
     * @return the results of evaluating the snippet
     */
    @Accessor(param1 = "expression")
    public Object getEval(String expression) {
        return webDriver.evalExp(expression);
    }

    /**
     * Returns the specified expression.
     *
     * <p>
     * This is useful because of JavaScript preprocessing. It is used to generate commands like
     * assertExpression and waitForExpression.
     * </p>
     *
     * @param expression the value to return
     * @return the value passed in
     */
    @Accessor(param1 = "expression")
    public String getExpression(String expression) {
        return expression;
    }

    /**
     * Creates a new "script" tag in the body of the current test window, and adds the specified text
     * into the body of the command. Scripts run in this way can often be debugged more easily than
     * scripts executed using Selenium's "getEval" command. Beware that JS exceptions thrown in these
     * script tags aren't managed by Selenium, so you should probably wrap your script in try/catch
     * blocks if there is any chance that the script will throw an exception.
     *
     * @param script the JavaScript snippet to run
     */
    @Action(param1 = "script", webOnly = true)
    public void runScript(String script) {
        evalScript(script);
    }

    /**
     * Gets the result of evaluating the specified JavaScript snippet. The snippet may have multiple
     * lines, but only the result of the last line will be returned.
     *
     * <p>
     * Note that, by default, the snippet will run in the context of the "selenium" object itself, so
     * <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the
     * window of your application, e.g. <code>window.document.getElementById('foo')</code>
     * </p>
     * <p>
     * If you need to use a locator to refer to a single element in your application page, you can use
     * <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator.
     * </p>
     *
     * @param script the JavaScript snippet to run
     * @return the results of evaluating the snippet
     */
    @Accessor(param1 = "script", webOnly = true)
    public String getEvalScript(String script) {
        return evalScript(script);
    }

    /**
     * Runs the specified JavaScript snippet repeatedly until it evaluates to "true". The snippet may
     * have multiple lines, but only the result of the last line will be considered.
     *
     * <p>
     * Note that, by default, the snippet will be run in the runner's test window, not in the window
     * of your application. To get the window of your application, you can use the JavaScript snippet
     * <code>selenium.browserbot.getCurrentWindow()</code>, and then run your JavaScript in there
     * </p>
     *
     * @param script the JavaScript snippet to run
     * @param timeout a timeout in milliseconds, after which this command will return with an error
     */
    @Action(param1 = "script", param2 = "timeout", webOnly = true)
    public void waitForCondition(String script, String timeout) {
        WebDriverWait wait = createWebDriverWait(timeout);
        wait.until(driver -> {
            Object result = evalScript(script);

            // Although the conditions should return a boolean, JS has a loose
            // definition of "true" Try and meet that definition.
            if (result == null) {
                return false;
            } else if (result instanceof String) {
                return !"".equals(result);
            } else if (result instanceof Boolean) {
                return (Boolean) result;
            } else {
                return true;
            }
        });
    }

    /**
     * Gets the result of evaluating the specified JavaScript snippet. The snippet may have multiple
     * lines, but only the result of the last line will be returned.
     *
     * @param script the JavaScript snippet to run
     * @return the results of evaluating the snippet
     */
    private String evalScript(String script) {
        StringBuilder builder = new StringBuilder();

        scriptMutator.mutate(script, builder);

        Object result = webDriver.executeScript(builder.toString());
        return result == null ? "" : String.valueOf(result);
    }
}
