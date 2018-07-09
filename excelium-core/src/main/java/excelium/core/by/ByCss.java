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

import com.thoughtworks.selenium.webdriven.ElementFinder;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.Serializable;
import java.util.List;

/**
 * Mechanism used to locate elements within a document by using CSS.
 *
 * @author PhungDucKien
 * @since 2018.07.08
 */
public class ByCss extends By implements Serializable {

    /**
     * The css selector
     */
    private final String cssSelector;

    /**
     * Element finder by DOM
     */
    private final ElementFinder elementFinder;

    /**
     * Instantiates a new ByCss.
     *
     * @param cssSelector the css selector
     */
    ByCss(String cssSelector) {
        this.cssSelector = cssSelector;
        this.elementFinder = new ElementFinder(new JavascriptLibrary());
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(new By.ByCssSelector(cssSelector));
    }

    @Override
    public WebElement findElement(SearchContext context) {
        return elementFinder.findElement((WebDriver) context, "css=" + cssSelector);
    }

    @Override
    public String toString() {
        return "By.css: " + cssSelector;
    }
}