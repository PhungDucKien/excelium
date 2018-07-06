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

package excelium.executor.web;

import com.thoughtworks.selenium.SeleniumException;
import excelium.core.command.Accessor;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a class which contains commands for accessing tables.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class TableCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Table command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public TableCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Gets the text from a cell of a table. The cellAddress syntax row.column, where row
     * and column start at 0.
     *
     * @param locator an element locator pointing to a table
     * @param cellAddress a cell address, e.g. "1.4"
     * @return the text from the specified cell
     */
    @Accessor(param1 = "locator", param2 = "cellAddress")
    public String getTable(String locator, String cellAddress) {
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)").matcher(cellAddress);
        if (!matcher.matches()) {
            throw new SeleniumException(
                    "Invalid target format. Correct format is rowNum.columnNum");
        }

        long row = Long.parseLong(matcher.group(1));
        long col = Long.parseLong(matcher.group(2));

        WebElement table = webDriver.findElement(locator);

        String script =
                "var table = arguments[0]; var row = arguments[1]; var col = arguments[2];" +
                        "if (row > table.rows.length) { return \"Cannot access row \" + row + \" - table has \" + table.rows.length + \" rows\"; }" +
                        "if (col > table.rows[row].cells.length) { return \"Cannot access column \" + col + \" - table row has \" + table.rows[row].cells.length + \" columns\"; }" +
                        "return table.rows[row].cells[col];";

        Object value = webDriver.executeScript(script, table, row, col);
        if (value instanceof WebElement) {
            return webDriver.getElementText((WebElement) value).trim();
        }

        throw new SeleniumException((String) value);
    }
}
