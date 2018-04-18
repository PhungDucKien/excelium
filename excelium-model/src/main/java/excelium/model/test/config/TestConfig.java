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

package excelium.model.test.config;

import java.util.List;

/**
 * Represents test configuration model.
 *
 * @author PhungDucKien
 * @since 2018.03.28
 */
public class TestConfig {

    /**
     * Base url
     */
    private String baseUrl;

    /**
     * List of environments that tests are executed on
     */
    private List<Environment> environments;

    /**
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets base url.
     *
     * @param baseUrl the base url
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Gets environments.
     *
     * @return the environments
     */
    public List<Environment> getEnvironments() {
        return environments;
    }

    /**
     * Sets environments.
     *
     * @param environments the environments
     */
    public void setEnvironments(List<Environment> environments) {
        this.environments = environments;
    }
}
