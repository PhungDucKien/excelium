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

package excelium.model.test.action;

import excelium.model.test.TestStep;

import java.util.List;

/**
 * Represents test action model.
 * A test action contains one or more test steps and can be called by "Execute" commands.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
public class TestAction {

    /** Serial number */
    private Integer no;

    /** Name */
    private String name;

    /** Test steps */
    private List<TestStep> testSteps;

    /**
     * Gets no.
     *
     * @return the no
     */
    public Integer getNo() {
        return no;
    }

    /**
     * Sets no.
     *
     * @param no the no
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets test steps.
     *
     * @return the test steps
     */
    public List<TestStep> getTestSteps() {
        return testSteps;
    }

    /**
     * Sets test steps.
     *
     * @param testSteps the test steps
     */
    public void setTestSteps(List<TestStep> testSteps) {
        this.testSteps = testSteps;
    }
}
