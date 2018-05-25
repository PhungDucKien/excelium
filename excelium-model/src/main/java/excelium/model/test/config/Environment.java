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

import excelium.model.enums.Platform;

/**
 * Represents environment model.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
public class Environment {

    /**
     * Platform
     */
    private Platform platform;

    /**
     * Platform version
     */
    private String platformVersion;

    /**
     * Gets platform.
     *
     * @return the platform
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * Sets platform.
     *
     * @param platform the platform
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /**
     * Gets platform version.
     *
     * @return the platform version
     */
    public String getPlatformVersion() {
        return platformVersion;
    }

    /**
     * Sets platform version.
     *
     * @param platformVersion the platform version
     */
    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    /**
     * Gets environment unique key.
     *
     * @return the key
     */
    public String getKey() {
        return platform.getText() + "-" + platformVersion;
    }
}
