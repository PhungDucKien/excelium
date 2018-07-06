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

package excelium.executor.web.support;

import com.google.common.collect.Lists;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.webdriven.commands.SeleniumSelect;
import excelium.core.driver.ContextAwareWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @see {@link SeleniumSelect}
 */
public class OptionSelector {

    private final String findOption;
    private final ContextAwareWebDriver driver;
    private final WebElement select;

    public OptionSelector(ContextAwareWebDriver driver, String parentLocator, String locator) {
        this.driver = driver;

        findOption =
                "return (" + driver.getJavascriptLibrary().getSeleniumScript("findOption.js") + ").apply(null, arguments)";

        select = driver.findElement(parentLocator, locator);
        if (!"select".equals(select.getTagName().toLowerCase())) {
            throw new SeleniumException("Element is not a select element: " + locator);
        }
    }

    public void setSelected(String optionLocator) {
        if (isMultiple()) {
            for (WebElement opt : select.findElements(By.tagName("option"))) {
                if (opt.isSelected()) {
                    opt.click();
                }
            }
        }

        WebElement option = findOption(optionLocator);
        if (!option.isSelected()) {
            option.click();
        }
    }

    public void addSelection(String optionLocator) {
        assertSupportsMultipleSelections();

        WebElement option = findOption(optionLocator);
        if (!option.isSelected()) {
            option.click();
        }
    }

    public void removeSelection(String optionLocator) {
        assertSupportsMultipleSelections();

        WebElement option = findOption(optionLocator);
        if (option.isSelected()) {
            option.click();
        }
    }

    public List<WebElement> getSelectedOptions() {
        List<WebElement> toReturn = Lists.newArrayList();

        for (WebElement option : select.findElements(By.tagName("option"))) {
            if (option.isSelected()) {
                toReturn.add(option);
            }
        }

        return toReturn;
    }

    public WebElement findOption(String optionLocator) {
        return (WebElement) driver.executeScript(findOption, select, optionLocator);
    }

    private void assertSupportsMultipleSelections() {
        if (!isMultiple()) {
            throw new SeleniumException(
                    "You may only add a selection to a select that supports multiple selections");
        }
    }

    private boolean isMultiple() {
        String multipleValue = select.getAttribute("multiple");
        boolean multiple = "true".equals(multipleValue) || "multiple".equals(multipleValue);
        return multiple;
    }

    public List<WebElement> getAllOptions() {
        return select.findElements(By.tagName("option"));
    }
}
