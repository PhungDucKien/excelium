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

/**
 * Represents filter for test execution.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class TestFilter {

    /**
     * Workbook filter
     */
    private String workbook;

    /**
     * Sheet filter
     */
    private String sheet;

    /**
     * Test case filter
     */
    private String testCase;

    /**
     * Gets workbook filter.
     *
     * @return the workbook filter
     */
    public String getWorkbook() {
        return workbook;
    }

    /**
     * Sets workbook filter.
     *
     * @param workbook the workbook filter
     */
    public void setWorkbook(String workbook) {
        this.workbook = workbook;
    }

    /**
     * Gets sheet filter.
     *
     * @return the sheet filter
     */
    public String getSheet() {
        return sheet;
    }

    /**
     * Sets sheet filter.
     *
     * @param sheet the sheet filter
     */
    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    /**
     * Gets test case filter.
     *
     * @return the test case filter
     */
    public String getTestCase() {
        return testCase;
    }

    /**
     * Sets test case filter.
     *
     * @param testCase the test case filter
     */
    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }
}
