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
 * Represents test flow model.
 * A test flow contains one or more test steps.
 *
 * @author PhungDucKien
 * @since 2018.05.17
 */
public class TestFlow {

    /**
     * Serial number
     */
    private Integer no;

    /**
     * Name
     */
    private String name;

    /**
     * Description
     */
    private String description;

    /**
     * Test steps
     */
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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
