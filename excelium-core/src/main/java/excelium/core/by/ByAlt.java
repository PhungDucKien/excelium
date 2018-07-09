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

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;

import java.io.Serializable;
import java.util.List;

/**
 * Mechanism used to locate elements within a document by using alt attribute.
 *
 * @author PhungDucKien
 * @since 2018.07.08
 */
public class ByAlt extends By implements Serializable {

    /**
     * The alt value
     */
    private final String alt;

    /**
     * Instantiates a new ByAlt.
     *
     * @param alt the alt value
     */
    ByAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return ((FindsByXPath) context).findElementsByXPath(".//*[@alt = '" + alt + "']");
    }

    @Override
    public WebElement findElement(SearchContext context) {
        return ((FindsByXPath) context).findElementByXPath(".//*[@alt = '" + alt + "']");
    }

    @Override
    public String toString() {
        return "By.alt: " + alt;
    }
}