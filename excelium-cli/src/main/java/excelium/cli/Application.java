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

package excelium.cli;

import excelium.cli.controller.*;
import org.fusesource.jansi.AnsiConsole;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.LogManager;

/**
 * Excelium Command Line Application.
 * This class parses command line arguments and takes corresponding actions.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class Application {

    /**
     * Program name
     */
    private static final String PROGRAM_NAME = "excelium";

    /**
     * Parses command line arguments and takes corresponding actions.
     *
     * @param args command line arguments
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        LogManager.getLogManager().reset();

        AnsiConsole.systemInstall();

        // Creates commander instance
        Commander commander = new Commander();
        commander.setProgramName(PROGRAM_NAME);

        // Registers controllers
        commander.registerControllers(
                TestController.class,
                ProjectController.class,
                TemplateController.class,
                TestFileController.class,
                DataSourceController.class
        );

        // Registers bean factory
        commander.registerBeanFactory(BeanFactory.class);

        // Parses arguments and executes command
        commander.execute(args);

        AnsiConsole.systemUninstall();
    }
}
