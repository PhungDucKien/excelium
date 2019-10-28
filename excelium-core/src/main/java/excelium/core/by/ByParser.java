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

package excelium.core.by;

import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.enums.MobileLocatorType;
import excelium.model.enums.WebLocatorType;
import excelium.model.locator.MobileLocator;
import excelium.model.locator.WebLocator;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.support.ByIdOrName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses the locator string to the corresponding By mechanism.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class ByParser {

    /**
     * Parses the locator string to By mechanism.
     *
     * @param locator   the locator string
     * @param webDriver the web driver
     * @return By object
     */
    public static By parseBy(String locator, ContextAwareWebDriver webDriver) {
        if (webDriver.isWeb()) {
            return parseWebBy(locator);
        } else {
            return parseMobileBy(locator);
        }
    }

    /**
     * Parses the locator string to By mechanism of Web environment.
     *
     * @param locator the locator string
     * @return By object
     */
    private static By parseWebBy(String locator) {
        WebLocator lc = parseWebLocator(locator);
        switch (lc.getType()) {
            case ID:
                return By.id(lc.getValue());
            case NAME:
                return By.name(lc.getValue());
            case CSS:
                return new ByCss(lc.getValue());
            case LINK:
                return By.linkText(lc.getValue());
            case XPATH:
                if (lc.getValue().endsWith("/")) {
                    return By.xpath(lc.getValue().substring(0, lc.getValue().length() - 1));
                }
                return By.xpath(lc.getValue());
            case IDENTIFIER:
                return new ByIdOrName(lc.getValue());
            case CLASS:
                return By.className(lc.getValue());
            case ALT:
                return new ByAlt(lc.getValue());
            case VARIABLE:
                return new ByVariable(lc.getValue());
            case DOM:
                return new ByDom(lc.getValue());
            default:
                break;
        }
        throw new InvalidSelectorException("Invalid selector.");
    }

    /**
     * Parses the locator string to By mechanism of Mobile environment.
     *
     * @param locator the locator string
     * @return By object
     */
    private static By parseMobileBy(String locator) {
        MobileLocator lc = parseMobileLocator(locator);
        switch (lc.getType()) {
            case ACCESSIBILITY_ID:
                return MobileBy.AccessibilityId(lc.getValue());
            case CLASS:
                return MobileBy.className(lc.getValue());
            case ID:
                return MobileBy.id(lc.getValue());
            case NAME:
                return MobileBy.name(lc.getValue());
            case XPATH:
                if (lc.getValue().endsWith("/")) {
                    return MobileBy.xpath(lc.getValue().substring(0, lc.getValue().length() - 1));
                }
                return MobileBy.xpath(lc.getValue());
            case ANDROID_UIAUTOMATOR:
                return MobileBy.AndroidUIAutomator(lc.getValue());
            case VARIABLE:
                return new ByVariable(lc.getValue());
            default:
                break;
        }
        throw new InvalidSelectorException("Invalid selector.");
    }

    /**
     * Parses web locator string.
     *
     * @param locator the locator string
     * @return Web locator
     */
    private static WebLocator parseWebLocator(String locator) {
        Pattern p = Pattern.compile("^([A-Za-z_]+)=([\\S\\s]+)");
        Matcher m = p.matcher(locator);
        WebLocator lc = new WebLocator();
        if (m.find()) {
            lc.setType(WebLocatorType.fromName(m.group(1).toLowerCase()));
            lc.setValue(m.group(2));
        } else {
            if (locator.startsWith("//")) {
                lc.setType(WebLocatorType.XPATH);
            } else if (locator.startsWith("document")) {
                lc.setType(WebLocatorType.DOM);
            } else {
                lc.setType(WebLocatorType.IDENTIFIER);
            }
            lc.setValue(locator);
        }
        return lc;
    }

    /**
     * Parses mobile locator string.
     *
     * @param locator the locator string
     * @return Mobile locator
     */
    private static MobileLocator parseMobileLocator(String locator) {
        Pattern p = Pattern.compile("^([A-Za-z_]+)=([\\S\\s]+)");
        Matcher m = p.matcher(locator);
        MobileLocator lc = new MobileLocator();
        if (m.find()) {
            lc.setType(MobileLocatorType.fromName(m.group(1).toLowerCase()));
            lc.setValue(m.group(2));
        } else {
            lc.setType(MobileLocatorType.ACCESSIBILITY_ID);
            lc.setValue(locator);
        }
        return lc;
    }
}
