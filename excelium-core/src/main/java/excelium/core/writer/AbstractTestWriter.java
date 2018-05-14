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

package excelium.core.writer;

import excelium.common.ss.CellLocation;
import excelium.model.enums.Result;
import excelium.model.project.Template;
import excelium.model.test.TestStep;

import java.io.IOException;
import java.util.Date;

import static excelium.model.project.Template.*;

/**
 * Abstract test writer that implements {@link TestWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.02
 */
public abstract class AbstractTestWriter extends AbstractWorkbookWriter implements TestWriter {

    @Override
    public void writeResult(Template template, String sheetName, TestStep testStep, Result result) throws IOException {
        writeValue(template, sheetName, testStep, TEST_DATE, new Date());
        writeValue(template, sheetName, testStep, TEST_PERSON, System.getProperty("user.name"));
        writeValue(template, sheetName, testStep, TEST_RESULT, result.getText());
    }

    /**
     * Write value to the markup position of test step in the workbook
     *
     * @param template  the template of the workbook
     * @param sheetName the sheet name
     * @param testStep  the test step
     * @param markup    the markup
     * @param value     the value
     * @throws IOException the io exception
     */
    private void writeValue(Template template, String sheetName, TestStep testStep, String markup, Object value) throws IOException {
        if (template.getMarkupLocations().containsKey(markup)) {
            CellLocation firstLocation = new CellLocation(template.getMarkupLocations().get(markup));
            CellLocation cellLocation = new CellLocation(sheetName, firstLocation.getRow() + testStep.getRowIndex(), firstLocation.getCol(), false, false);
            setCellValue(value, cellLocation.formatAsString());
        }
    }
}
