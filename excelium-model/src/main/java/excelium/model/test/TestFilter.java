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

package excelium.model.test;

import java.util.List;

/**
 * Represents filter for test execution.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class TestFilter {

    /** Workbook filter */
    private List<String> workbooks;

    /** Sheet filter */
    private List<String> sheets;

    /** Test case filter */
    private List<String> testCases;

    /**
     * Gets workbooks.
     *
     * @return the workbooks
     */
    public List<String> getWorkbooks() {
        return workbooks;
    }

    /**
     * Sets workbooks.
     *
     * @param workbooks the workbooks
     */
    public void setWorkbooks(List<String> workbooks) {
        this.workbooks = workbooks;
    }

    /**
     * Gets sheets.
     *
     * @return the sheets
     */
    public List<String> getSheets() {
        return sheets;
    }

    /**
     * Sets sheets.
     *
     * @param sheets the sheets
     */
    public void setSheets(List<String> sheets) {
        this.sheets = sheets;
    }

    /**
     * Gets test cases.
     *
     * @return the test cases
     */
    public List<String> getTestCases() {
        return testCases;
    }

    /**
     * Sets test cases.
     *
     * @param testCases the test cases
     */
    public void setTestCases(List<String> testCases) {
        this.testCases = testCases;
    }
}
