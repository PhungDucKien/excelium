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

package excelium.model.enums;

/**
 * Represents type of mobile locator.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public enum MobileLocatorType {
    /**
     * Accessibility id mobile locator type.
     */
    ACCESSIBILITY_ID,
    /**
     * Class mobile locator type.
     */
    CLASS,
    /**
     * Id mobile locator type.
     */
    ID,
    /**
     * Name mobile locator type.
     */
    NAME,
    /**
     * Xpath mobile locator type.
     */
    XPATH,
    /**
     * Android uiautomator mobile locator type.
     */
    ANDROID_UIAUTOMATOR,
    /**
     * iOS NS Predicate mobile locator type.
     */
    IOS_NS_PREDICATE,
    /**
     * iOS Class Chain mobile locator type.
     */
    IOS_CLASS_CHAIN,
    /**
     * Variable mobile locator type.
     */
    VARIABLE,
    /**
     * Reserved locator type for specifying index.
     */
    INDEX;

    /**
     * From name mobile locator type.
     *
     * @param name the name
     * @return the mobile locator type
     */
    public static MobileLocatorType fromName(String name) {
        for (MobileLocatorType t : MobileLocatorType.values()) {
            if (t.name().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }
}
