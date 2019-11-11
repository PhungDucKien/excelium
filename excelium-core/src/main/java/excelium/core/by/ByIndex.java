/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Mechanism used to locate an element by using another By mechanism and index of the desired element in the found list.
 *
 * @author PhungDucKien
 * @since 2019.11.11
 */
public class ByIndex extends By implements Serializable {

    /**
     * The list By
     */
    private final By listBy;

    /**
     * The index
     */
    private final int index;

    /**
     * Instantiates a new ByIndex.
     *
     * @param listBy the list By
     * @param index  the index
     */
    ByIndex(By listBy, int index) {
        this.listBy = listBy;
        this.index = index;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        List<WebElement> elements = context.findElements(listBy);
        if (elements.size() < index) {
            throw new InvalidSelectorException("No element with index = " + index + " found.");
        }
        List<WebElement> filter = new ArrayList<>();
        filter.add(elements.get(index - 1));
        return filter;
    }

    @Override
    public WebElement findElement(SearchContext context) {
        List<WebElement> elements = context.findElements(listBy);
        if (elements.size() < index) {
            throw new InvalidSelectorException("No element with index = " + index + " found.");
        }
        return elements.get(index - 1);
    }

    @Override
    public String toString() {
        return "By.index: [" + listBy + "][" + index + "]";
    }
}