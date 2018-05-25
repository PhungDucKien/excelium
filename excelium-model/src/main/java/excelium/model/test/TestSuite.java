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
 * Represents test suite model.
 * Typically, a test suite is a collection of test cases contained in one sheet.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class TestSuite {

    /**
     * Sheet name
     */
    private String sheetName;

    /**
     * Test cases
     */
    private List<TestCase> testCases;

    /**
     * Gets sheet name.
     *
     * @return the sheet name
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * Sets sheet name.
     *
     * @param sheetName the sheet name
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * Gets test cases.
     *
     * @return the test cases
     */
    public List<TestCase> getTestCases() {
        return testCases;
    }

    /**
     * Sets test cases.
     *
     * @param testCases the test cases
     */
    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }
}
