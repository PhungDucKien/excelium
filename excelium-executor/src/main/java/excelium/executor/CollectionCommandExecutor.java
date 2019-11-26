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

import com.google.common.collect.Ordering;
import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.AssertFailedException;
import excelium.model.project.Project;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Represents a class which contains commands for accessing collections.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class CollectionCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Collection command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public CollectionCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Return true if the specified text pattern appears in the specified variable list value, or false otherwise.
     *
     * @param variable the variable
     * @param text     the text to compare
     * @return true if the specified text pattern appears in the specified variable list value, or false otherwise
     */
    @Accessor(param1 = "variable", param2 = "text")
    public boolean isListContain(String variable, String text) throws Exception {
        Object value = this.webDriver.getVariable(variable);
        List list;
        if (value.getClass().isArray()) {
            list = Arrays.asList((String[]) value);
        } else if (value instanceof List) {
            list = (List) value;
        } else {
            throw new Exception("The variable must be a List or an Array");
        }
        return list.contains(normalizeText(text));
    }

    /**
     * Verifies that the specified variable list value is in ascending order.
     *
     * @param variable the variable
     * @return true if the values in ascending order, false otherwise
     */
    @Action(param1 = "variable")
    public void verifyListOrderAsc(String variable) throws Exception {
        List list = (List) this.webDriver.getVariable(variable);
        if (list == null || !Ordering.natural().isOrdered(list)) {
            throw new AssertFailedException("Actual list ${" + variable + "} is not in ascending order");
        }
    }

    /**
     * Verifies that the specified variable list value is in descending order.
     *
     * @param variable the variable
     * @return true if the values in descending order, false otherwise
     */
    @Action(param1 = "variable")
    public void verifyListOrderDesc(String variable) throws Exception {
        List list = (List) this.webDriver.getVariable(variable);
        if (list == null || !Ordering.natural().reverse().isOrdered(list)) {
            throw new AssertFailedException("Actual list ${" + variable + "} is not in descending order");
        }
    }

    /**
     * Returns the text values of the specified elements are sorted in ascending order.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @return true if the values in ascending order, false otherwise
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void verifyTextListOrderAsc(String parentLocator, String locator) throws Exception {
        List<WebElement> elements = webDriver.findElements(parentLocator, locator);
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(webDriver.getElementText(element));
        }
        if (!Ordering.natural().isOrdered(textList)) {
            throw new AssertFailedException("Actual list is not in ascending order. List = " + Arrays.toString(textList.toArray()));
        }
    }

    /**
     * Returns the text values of the specified elements are sorted in descending order.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @return true if the values in descending order, false otherwise
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void verifyTextListOrderDesc(String parentLocator, String locator) throws Exception {
        List<WebElement> elements = webDriver.findElements(parentLocator, locator);
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(webDriver.getElementText(element));
        }
        if (!Ordering.natural().reverse().isOrdered(textList)) {
            throw new AssertFailedException("Actual list is not in descending order. List = " + Arrays.toString(textList.toArray()));
        }
    }

    /**
     * Returns the text values of the specified elements are sorted in ascending order.
     * The values are assuming to be numbers.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @return true if the values in ascending order, false otherwise
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void verifyIntegerListOrderAsc(String parentLocator, String locator) throws Exception {
        List<WebElement> elements = webDriver.findElements(parentLocator, locator);
        List<Integer> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(Integer.parseInt(webDriver.getElementText(element)));
        }
        if (!Ordering.natural().isOrdered(textList)) {
            throw new AssertFailedException("Actual list is not in ascending order. List = " + Arrays.toString(textList.toArray()));
        }
    }

    /**
     * Returns the text values of the specified elements are sorted in descending order.
     * The values are assuming to be numbers.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @return true if the values in descending order, false otherwise
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void verifyIntegerListOrderDesc(String parentLocator, String locator) throws Exception {
        List<WebElement> elements = webDriver.findElements(parentLocator, locator);
        List<Integer> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(Integer.parseInt(webDriver.getElementText(element)));
        }
        if (!Ordering.natural().reverse().isOrdered(textList)) {
            throw new AssertFailedException("Actual list is not in descending order. List = " + Arrays.toString(textList.toArray()));
        }
    }

    /**
     * Returns the text values of the specified elements are sorted in ascending order.
     * The values are assuming to be dates.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @param format        date format to parse
     * @return true if the values in ascending order, false otherwise
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "format")
    public void verifyDateListOrderAsc(String parentLocator, String locator, String format) throws Exception {
        List<WebElement> elements = webDriver.findElements(parentLocator, locator);
        List<Date> textList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        for (WebElement element : elements) {
            textList.add(dateFormat.parse(webDriver.getElementText(element)));
        }
        if (!Ordering.natural().isOrdered(textList)) {
            throw new AssertFailedException("Actual list is not in ascending order. List = " + Arrays.toString(textList.toArray()));
        }
    }

    /**
     * Returns the text values of the specified elements are sorted in descending order.
     * The values are assuming to be dates.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @param format        date format to parse
     * @return true if the values in descending order, false otherwise
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "format")
    public void verifyDateListOrderDesc(String parentLocator, String locator, String format) throws Exception {
        List<WebElement> elements = webDriver.findElements(parentLocator, locator);
        List<Date> textList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        for (WebElement element : elements) {
            textList.add(dateFormat.parse(webDriver.getElementText(element)));
        }
        if (!Ordering.natural().reverse().isOrdered(textList)) {
            throw new AssertFailedException("Actual list is not in descending order. List = " + Arrays.toString(textList.toArray()));
        }
    }
}
