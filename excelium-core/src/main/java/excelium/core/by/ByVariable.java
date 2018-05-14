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

package excelium.core.by;

import excelium.core.driver.ContextAwareWebDriver;
import org.openqa.selenium.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Mechanism used to locate elements within a document by using context variable.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class ByVariable extends By implements Serializable {

    /**
     * The variable name
     */
    private final String variable;

    /**
     * Instantiates a new ByVariable.
     *
     * @param variable the variable name
     */
    ByVariable(String variable) {
        this.variable = variable;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        if (context instanceof ContextAwareWebDriver) {
            Object element = ((ContextAwareWebDriver) context).getVariable(variable);

            List<WebElement> elements;
            if (element instanceof WebElement) {
                elements = new ArrayList<>();
                elements.add((WebElement) element);
                return elements;
            } else if (element instanceof List) {
                return (List<WebElement>) element;
            } else if (element instanceof String) {
                return ((ContextAwareWebDriver) context).findElements((String) element);
            } else {
                throw new InvalidSelectorException("Invalid variable.");
            }
        } else {
            throw new WebDriverException("Not supported web driver.");
        }
    }

    @Override
    public WebElement findElement(SearchContext context) {
        if (context instanceof ContextAwareWebDriver) {
            Object element = ((ContextAwareWebDriver) context).getVariable(variable);

            if (element instanceof WebElement) {
                return (WebElement) element;
            } else if (element instanceof List) {
                return ((List<WebElement>) element).get(0);
            } else if (element instanceof String) {
                return ((ContextAwareWebDriver) context).findElement((String) element);
            } else {
                throw new InvalidSelectorException("Invalid variable.");
            }
        } else {
            throw new WebDriverException("Not supported web driver.");
        }
    }

    @Override
    public String toString() {
        return "By.variable: " + variable;
    }
}