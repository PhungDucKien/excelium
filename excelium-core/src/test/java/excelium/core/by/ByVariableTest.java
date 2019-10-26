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
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link ByVariable}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class ByVariableTest {

    @Mocked
    private RemoteWebDriver webDriver;

    @Mocked
    private WebElement element;

    @Test(expected = WebDriverException.class)
    public void testFindElement_NotSupportDriver() {
        ByVariable by = new ByVariable("var1");
        by.findElement(webDriver);
    }

    @Test(expected = InvalidSelectorException.class)
    public void testFindElement_InvalidVariable() {
        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        contextAwareWebDriver.setVariable(element, "var2");

        ByVariable by = new ByVariable("var1");
        by.findElement(contextAwareWebDriver);
    }

    @Test
    public void testFindElement_SingleElement() {
        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        contextAwareWebDriver.setVariable(element, "var1");

        ByVariable by = new ByVariable("var1");
        Assert.assertEquals("By.variable: var1", by.toString());
        Assert.assertEquals(element, by.findElement(contextAwareWebDriver));
    }

    @Test
    public void testFindElement_ElementList() {
        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        List<WebElement> elements = new ArrayList<>();
        elements.add(element);
        elements.add(element);
        contextAwareWebDriver.setVariable(elements, "var1");

        ByVariable by = new ByVariable("var1");
        Assert.assertEquals(element, by.findElement(contextAwareWebDriver));
    }

    @Test
    public void testFindElement_String() {
        new Expectations() {{
            webDriver.findElement((By) any); result = element;
        }};

        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        contextAwareWebDriver.setVariable("id=123456", "var1");

        ByVariable by = new ByVariable("var1");
        Assert.assertEquals(element, by.findElement(contextAwareWebDriver));
    }

    @Test(expected = WebDriverException.class)
    public void testFindElements_NotSupportDriver() {
        ByVariable by = new ByVariable("var1");
        by.findElements(webDriver);
    }

    @Test(expected = InvalidSelectorException.class)
    public void testFindElements_InvalidVariable() {
        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        contextAwareWebDriver.setVariable(element, "var2");

        ByVariable by = new ByVariable("var1");
        by.findElements(contextAwareWebDriver);
    }

    @Test
    public void testFindElements_SingleElement() {
        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        contextAwareWebDriver.setVariable(element, "var1");

        ByVariable by = new ByVariable("var1");
        List<WebElement> elements = by.findElements(contextAwareWebDriver);
        Assert.assertEquals(1, elements.size());
        Assert.assertEquals(element, elements.get(0));
    }

    @Test
    public void testFindElements_ElementList() {
        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        List<WebElement> elements = new ArrayList<>();
        elements.add(element);
        elements.add(element);
        contextAwareWebDriver.setVariable(elements, "var1");

        ByVariable by = new ByVariable("var1");
        elements = by.findElements(contextAwareWebDriver);
        Assert.assertEquals(2, elements.size());
        Assert.assertEquals(element, elements.get(0));
        Assert.assertEquals(element, elements.get(1));
    }

    @Test
    public void testFindElements_String() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(element);

        new Expectations() {{
            webDriver.findElements((By) any); result = elements;
        }};

        ContextAwareWebDriver contextAwareWebDriver = new ContextAwareWebDriver(webDriver, null);
        contextAwareWebDriver.setVariable("id=123456", "var1");

        ByVariable by = new ByVariable("var1");
        List<WebElement> retElements = by.findElements(contextAwareWebDriver);
        Assert.assertEquals(1, retElements.size());
        Assert.assertEquals(element, retElements.get(0));
    }
}
