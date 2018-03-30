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

package excelium.model.test.item;

/**
 * Represents item model.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
public class Item {

    /** Name */
    private String name;

    /** Description */
    private String description;

    /** Value */
    private String value;

    /** Android value */
    private String androidValue;

    /** iOS value */
    private String iosValue;

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
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets android value.
     *
     * @return the android value
     */
    public String getAndroidValue() {
        return androidValue;
    }

    /**
     * Sets android value.
     *
     * @param androidValue the android value
     */
    public void setAndroidValue(String androidValue) {
        this.androidValue = androidValue;
    }

    /**
     * Gets ios value.
     *
     * @return the ios value
     */
    public String getIosValue() {
        return iosValue;
    }

    /**
     * Sets ios value.
     *
     * @param iosValue the ios value
     */
    public void setIosValue(String iosValue) {
        this.iosValue = iosValue;
    }
}
