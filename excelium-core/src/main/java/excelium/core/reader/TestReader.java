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

package excelium.core.reader;

import excelium.model.project.Template;
import excelium.model.test.Test;
import excelium.model.test.TestFilter;

import java.io.IOException;

/**
 * Test reader interface.
 * Provides method that reads test files.
 *
 * @param <W> Workbook class
 * @param <S> Sheet class
 * @author PhungDucKien
 * @since 2018.04.10
 */
public interface TestReader<W, S> extends WorkbookReader<W, S> {

    /**
     * Parses test file.
     *
     * @param template the template
     * @return Parsed test object
     * @throws IOException the io exception
     */
    Test parseTest(Template template) throws IOException;

    /**
     * Sets test filter.
     *
     * @param testFilter the test filter
     */
    void setTestFilter(TestFilter testFilter);
}
