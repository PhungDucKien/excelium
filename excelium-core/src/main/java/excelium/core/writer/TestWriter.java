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

import excelium.model.enums.Result;
import excelium.model.project.Template;
import excelium.model.test.TestStep;

import java.io.IOException;

/**
 * Test writer interface.
 * Provides method that writes test files.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
public interface TestWriter extends WorkbookWriter {

    /**
     * Write test result to the workbook
     *
     * @param template  the template of the workbook
     * @param sheetName the sheet name
     * @param testStep  the test step
     * @param result    the result to write
     * @throws IOException the io exception
     */
    void writeResult(Template template, String sheetName, TestStep testStep, Result result) throws IOException;
}
