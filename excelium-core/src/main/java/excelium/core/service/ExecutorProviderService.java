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

package excelium.core.service;

import excelium.core.CommandExecutor;
import excelium.core.driver.ContextAwareWebDriver;

import java.util.List;

/**
 * An interface service that defines public methods for retrieving
 * command executor classes used for web and mobile applications.
 * <p>
 * The implementations of this service must register their presence with the service
 * through ServiceLoader mechanism.
 *
 * @author PhungDucKien
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html">Class ServiceLoader</a>
 * @since 2018.05.28
 */
public interface ExecutorProviderService {

    /**
     * Defines command executor classes used for web applications.
     *
     * @return list of command executor class
     */
    List<Class<? extends CommandExecutor>> getWebExecutorClasses(ContextAwareWebDriver driver);

    /**
     * Defines command executor classes used for mobile applications.
     *
     * @return list of command executor class
     */
    List<Class<? extends CommandExecutor>> getMobileExecutorClasses(ContextAwareWebDriver driver);
}
