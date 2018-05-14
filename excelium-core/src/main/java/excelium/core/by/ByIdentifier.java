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
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByXPath;

import java.io.Serializable;
import java.util.List;

/**
 * Mechanism used to locate elements within a document by using identifier.
 * With this mechanism, the first element with the id attribute value matching
 * the location will be used. If no element has a matching id attribute, then
 * the first element with a name attribute matching the location will be used.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class ByIdentifier extends By implements Serializable {

    /**
     * The identifier value
     */
    private final String identifier;

    /**
     * Instantiates a new ByIdentifier.
     *
     * @param identifier the identifier value
     */
    ByIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        List<WebElement> idElements;
        if (context instanceof FindsById) {
            idElements = ((FindsById) context).findElementsById(identifier);
        } else {
            idElements = ((FindsByXPath) context).findElementsByXPath(".//*[@id = '" + identifier
                    + "']");
        }

        List<WebElement> nameElements;
        if (context instanceof FindsByName) {
            nameElements = ((FindsByName) context).findElementsByName(identifier);
        } else {
            nameElements = ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
                    + identifier + "']");
        }
        idElements.addAll(nameElements);
        return idElements;
    }

    @Override
    public WebElement findElement(SearchContext context) {
        WebElement idElement;
        if (context instanceof FindsById) {
            idElement = ((FindsById) context).findElementById(identifier);
        } else {
            idElement = ((FindsByXPath) context).findElementByXPath(".//*[@id = '" + identifier
                    + "']");
        }

        if (idElement != null) {
            return idElement;
        }

        if (context instanceof FindsByName) {
            return ((FindsByName) context).findElementByName(identifier);
        } else {
            return ((FindsByXPath) context).findElementByXPath(".//*[@name = '"
                    + identifier + "']");
        }
    }

    @Override
    public String toString() {
        return "By.identifier: " + identifier;
    }
}
