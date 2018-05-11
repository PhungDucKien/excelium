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

import excelium.model.enums.Result;

/**
 * Represents the result of a test step.
 *
 * @author PhungDucKien
 * @since 2018.05.07
 */
public class StepResult {

    /**
     * Result
     */
    private Result result;

    /**
     * Should the test runner continue to run next test step ?
     */
    private boolean shouldContinue;

    /**
     * Instantiates a new Step result.
     *
     * @param result         the result
     * @param shouldContinue the should continue
     */
    public StepResult(Result result, boolean shouldContinue) {
        this.result = result;
        this.shouldContinue = shouldContinue;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(Result result) {
        this.result = result;
    }

    /**
     * Is should continue boolean.
     *
     * @return the boolean
     */
    public boolean isShouldContinue() {
        return shouldContinue;
    }

    /**
     * Sets should continue.
     *
     * @param shouldContinue the should continue
     */
    public void setShouldContinue(boolean shouldContinue) {
        this.shouldContinue = shouldContinue;
    }
}
