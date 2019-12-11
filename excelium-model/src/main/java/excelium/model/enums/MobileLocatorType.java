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
    ACCESSIBILITY_ID("accessibility id"),
    /**
     * Class mobile locator type.
     */
    CLASS("class"),
    /**
     * Id mobile locator type.
     */
    ID("id"),
    /**
     * Name mobile locator type.
     */
    NAME("name"),
    /**
     * Xpath mobile locator type.
     */
    XPATH("xpath"),
    /**
     * Android uiautomator mobile locator type.
     */
    ANDROID_UIAUTOMATOR("android uiautomator"),
    /**
     * Android view tag mobile locator type.
     */
    ANDROID_VIEWTAG("android viewtag"),
    /**
     * Android data matcher mobile locator type.
     */
    ANDROID_DATAMATCHER("android datamatcher"),
    /**
     * iOS Predicate String mobile locator type.
     */
    IOS_PREDICATE_STRING("ios predicate string"),
    /**
     * iOS Class Chain mobile locator type.
     */
    IOS_CLASS_CHAIN("ios class chain"),
    /**
     * Windows uiautomation mobile locator type.
     */
    WINDOWS_UIAUTOMATION("windows uiautomation"),
    /**
     * Reserved locator type for specifying index.
     */
    INDEX("index"),
    /**
     * Variable web locator type.
     */
    VARIABLE("variable");

    private final String strategy;

    MobileLocatorType(String strategy) {
        this.strategy = strategy;
    }

    /**
     * From strategy mobile locator type.
     *
     * @param strategy the strategy
     * @return the mobile locator type
     */
    public static MobileLocatorType fromStrategy(String strategy) {
        for (MobileLocatorType t : MobileLocatorType.values()) {
            if (t.strategy.equalsIgnoreCase(strategy)) {
                return t;
            }
        }
        return null;
    }

    @Override public String toString() {
        return strategy;
    }
}
