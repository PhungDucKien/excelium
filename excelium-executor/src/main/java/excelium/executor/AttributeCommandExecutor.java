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

package excelium.executor;

import com.google.common.base.Joiner;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.thoughtworks.selenium.SeleniumException;
import excelium.core.command.Accessor;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.executor.web.support.OptionSelector;
import excelium.model.project.Project;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Represents a class which contains commands for accessing element attributes.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class AttributeCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Attribute command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public AttributeCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Gets the text of an element. This works for any element that contains text. This command uses
     * either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the
     * element, which is the rendered text shown to the user.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return the text of the element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public String getText(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return webDriver.getElementText(element);
    }

    /**
     * Determines whether the text of an element is empty.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return true if the text of an element is empty, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isTextEmpty(String parentLocator, String locator) {
        String text = getText(parentLocator, locator);
        return StringUtils.isBlank(text);
    }

    /**
     * Gets the tag name of an element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return the tag name of the element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public String getTagName(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getTagName();
    }

    /**
     * Gets the (whitespace-trimmed) value of an input field (or anything else with a value
     * parameter). For checkbox/radio elements, the value will be "on" or "off" depending on whether
     * the element is checked or not.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return the element value, or "on/off" for checkbox/radio elements
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public String getValue(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        // Special-case handling for checkboxes and radio buttons: The Selenium API returns "on" for
        // checked checkboxes and radio buttons and off for unchecked ones. WebDriver will return "null" for
        // the "checked" attribute if the checkbox or the radio button is not-checked, "true" otherwise.
        if (element.getTagName().equals("input")
                && (element.getAttribute("type").equals("checkbox")
                || element.getAttribute("type").equals("radio")))
        {
            if (element.getAttribute("checked") == null) {
                return "off";
            }
            return "on";
        }

        return element.getAttribute("value");
    }

    /**
     * Determines whether the (whitespace-trimmed) value of an input field is empty.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return true if the (whitespace-trimmed) value of an input field is empty, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isValueEmpty(String parentLocator, String locator) {
        String value = getValue(parentLocator, locator);
        return StringUtils.isBlank(value);
    }

    /**
     * Get the value of the given attribute of the element. Will return the current value, even if
     * this has been modified after the page has been loaded.
     *
     * <p>More exactly, this method will return the value of the property with the given name, if it
     * exists. If it does not, then the value of the attribute with the given name is returned. If
     * neither exists, null is returned.
     *
     * <p>The "style" attribute is converted as best can be to a text representation with a trailing
     * semi-colon.
     *
     * <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:
     *
     * <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked,
     * defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate,
     * iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade,
     * novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless,
     * seeking, selected, truespeed, willvalidate
     *
     * <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as
     * expected:
     *
     * <ul>
     * <li>If the given name is "class", the "className" property is returned.
     * <li>If the given name is "readonly", the "readOnly" property is returned.
     * </ul>
     *
     * <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and
     * properties. If you need to do something more precise, e.g., refer to an attribute even when a
     * property of the same name exists, then you should evaluate Javascript to obtain the result
     * you desire.
     *
     * @param locator an element locator
     * @param name    The name of the attribute.
     * @return The attribute/property's current value or null if the value is not set.
     * @see <a href="https://github.com/SeleniumHQ/selenium/blob/master/javascript/atoms/domcore.js">Selenium RC</a>
     */
    @Accessor(param1 = "locator", param2 = "name")
    public String getAttribute(String locator, String name) {
        WebElement element = webDriver.findElement(locator);

        if (webDriver.isWeb()) {
            try {
                return (String) webDriver.executeScript(
                        Joiner.on("\n").join(
                                "var element = arguments[0];",
                                "var attributeName = arguments[1].toLowerCase();",
                                "if (attributeName == 'style') {",
                                "  var SPLIT_STYLE_ATTRIBUTE_ON_SEMICOLONS_REGEXP_ =",
                                "    new RegExp('[;]+' +",
                                "               '(?=(?:(?:[^\"]*\"){2})*[^\"]*$)' +",
                                "               '(?=(?:(?:[^\\']*\\'){2})*[^\\']*$)' +",
                                "               '(?=(?:[^()]*\\\\([^()]*\\\\))*[^()]*$)');",
                                "  var styleArray = element.style.cssText.split(",
                                "      SPLIT_STYLE_ATTRIBUTE_ON_SEMICOLONS_REGEXP_);",
                                "  var css = [];",
                                "  for (var index = 0; index < styleArray.length; index++) {",
                                "    var pair = styleArray[index];",
                                "    var i = pair.indexOf(':');",
                                "    if (i > 0) {",
                                "      var keyValue = [pair.slice(0, i), pair.slice(i + 1)];",
                                "      if (keyValue.length == 2) {",
                                "        css.push(keyValue[0].toLowerCase(), ':', keyValue[1], ';');",
                                "      }",
                                "    }",
                                "  }",
                                "  css = css.join('');",
                                "  css = css.charAt(css.length - 1) == ';' ? css : css + ';';",
                                "  return css;",
                                "}",
                                webDriver.isIE() ? Joiner.on("\n").join(
                                        "if ((!document.documentMode || document.documentMode < 8) && attributeName == 'value' &&",
                                        "    !!element && element.nodeType == 1 && element.tagName.toUpperCase() == 'INPUT') {",
                                        "  return element['value'];",
                                        "}",
                                        "if ((!document.documentMode || document.documentMode < 9) && element[attributeName] === true) {",
                                        "  return String(element.getAttribute(attributeName));",
                                        "}") : "",
                                "var attr = element.getAttributeNode(attributeName);",
                                "return (attr && attr.specified) ? attr.value : null;"),

                        element,
                        name);
            } catch (WebDriverException e) {
                return element.getAttribute(name);
            }
        } else {
            return element.getAttribute(name);
        }
    }

    /**
     * Determines whether the specified input element is editable, ie hasn't been disabled. This
     * method will fail if the specified element isn't an input element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return true if the input element is editable, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isEditable(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        String tagName = element.getTagName().toLowerCase();
        boolean acceptableTagName = "input".equals(tagName) || "select".equals(tagName);
        String readonly = "";
        if ("input".equals(tagName)) {
            readonly = element.getAttribute("readonly");
            if (readonly == null || "false".equals(readonly)) {
                readonly = "";
            }
        }

        return element.isEnabled() && acceptableTagName && "".equals(readonly);
    }

    /**
     * Gets whether an element is enabled. Fails if the specified element
     * doesn't exist.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return true if the element is enabled, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isEnabled(String parentLocator, String locator) {
        return webDriver.findElement(parentLocator, locator).isEnabled();
    }

    /**
     * Determines if the specified element is visible. An element can be rendered invisible by setting
     * the CSS "visibility" property to "hidden", or the "display" property to "none", either for the
     * element itself or one if its ancestors. This method will fail if the element is not present.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return true if the specified element is visible, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isVisible(String parentLocator, String locator) {
        return webDriver.findElement(parentLocator, locator).isDisplayed();
    }

    /**
     * Gets whether a toggle-button (checkbox/radio) is checked. Fails if the specified element
     * doesn't exist or isn't a toggle-button.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to a checkbox or radio
     *        button
     * @return true if the checkbox is checked, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator")
    public boolean isChecked(String parentLocator, String locator) {
        return webDriver.findElement(parentLocator, locator).isSelected();
    }

    /**
     * Gets option element ID for selected option in the specified select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return the selected option ID in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public String getSelectedId(String parentLocator, String locator) {
        return findFirstSelectedOptionProperty(parentLocator, locator, "id");
    }

    /**
     * Gets option index (option number, starting at 0) for selected option in the specified select
     * element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return the selected option index in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public String getSelectedIndex(String parentLocator, String locator) {
        return findFirstSelectedOptionProperty(parentLocator, locator, "index");
    }

    /**
     * Gets option label (visible text) for selected option in the specified select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return the selected option label in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public String getSelectedLabel(String parentLocator, String locator) {
        return findFirstSelectedOptionProperty(parentLocator, locator, "text");
    }

    /**
     * Gets option value (value attribute) for selected option in the specified select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return the selected option value in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public String getSelectedValue(String parentLocator, String locator) {
        return findFirstSelectedOptionProperty(parentLocator, locator, "value");
    }

    /**
     * Gets all option element IDs for selected options in the specified select or multi-select
     * element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return an array of all selected option IDs in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, waitCmd = false, executeCmd = false)
    public String[] getSelectedIds(String parentLocator, String locator) {
        return findSelectedOptionProperties(parentLocator, locator, "id");
    }

    /**
     * Gets all option indexes (option number, starting at 0) for selected options in the specified
     * select or multi-select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return an array of all selected option indexes in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, waitCmd = false, executeCmd = false)
    public String[] getSelectedIndexes(String parentLocator, String locator) {
        return findSelectedOptionProperties(parentLocator, locator, "index");
    }

    /**
     * Gets all option labels (visible text) for selected options in the specified select or
     * multi-select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return an array of all selected option labels in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, waitCmd = false, executeCmd = false)
    public String[] getSelectedLabels(String parentLocator, String locator) {
        return findSelectedOptionProperties(parentLocator, locator, "text");
    }

    /**
     * Gets all option values (value attributes) for selected options in the specified select or
     * multi-select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return an array of all selected option values in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, waitCmd = false, executeCmd = false)
    public String[] getSelectedValues(String parentLocator, String locator) {
        return findSelectedOptionProperties(parentLocator, locator, "value");
    }

    /**
     * Gets all option labels in the specified select drop-down.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return an array of all option labels in the specified select drop-down
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, waitCmd = false, executeCmd = false)
    public String[] getSelectOptions(String parentLocator, String locator) {
        OptionSelector selector = new OptionSelector(webDriver, parentLocator, locator);

        List<WebElement> allOptions = selector.getAllOptions();
        String[] labels = new String[allOptions.size()];
        for (int i = 0; i < allOptions.size(); i++) {
            labels[i] = webDriver.getElementText(allOptions.get(i));
        }

        return labels;
    }

    /**
     * Determines whether some option in a drop-down menu is selected.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @return true if some option has been selected, false otherwise
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public boolean isSomethingSelected(String parentLocator, String locator) {
        String script =
                "return (" + webDriver.getJavascriptLibrary().getSeleniumScript("isSomethingSelected.js") +
                        ").apply(null, arguments)";

        WebElement element = webDriver.findElement(parentLocator, locator);
        Object value = webDriver.executeScript(script, element);

        return Boolean.TRUE == value;
    }

    /**
     * Gets option attribute value for the first selected option in the specified select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @param property the attribute
     * @return the first selected option attribute value in the specified select drop-down
     */
    private String findFirstSelectedOptionProperty(String parentLocator, String locator, String property) {
        OptionSelector selector = new OptionSelector(webDriver, parentLocator, locator);
        List<WebElement> allOptions = selector.getSelectedOptions();

        if (allOptions.isEmpty()) {
            throw new SeleniumException("No options are selected");
        }

        return allOptions.get(0).getAttribute(property);
    }

    /**
     * Gets all option attribute values for selected options in the specified select or
     * multi-select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a drop-down menu
     * @param property the attribute
     * @return an array of all selected option attribute values in the specified select drop-down
     */
    private String[] findSelectedOptionProperties(String parentLocator, String locator, String property) {
        OptionSelector selector = new OptionSelector(webDriver, parentLocator, locator);
        List<WebElement> allOptions = selector.getSelectedOptions();
        String[] values = new String[allOptions.size()];

        for (int i = 0; i < allOptions.size(); i++) {
            WebElement element = allOptions.get(i);
            values[i] = element.getAttribute(property);
        }

        return values;
    }

    /**
     * Returns the text color of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the text color of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Color getColor(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return Color.fromString(element.getCssValue("color"));
    }

    /**
     * Returns the background color of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the background color of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Color getBackgroundColor(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return Color.fromString(element.getCssValue("background-color"));
    }

    /**
     * Returns the border color of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the border color of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Color getBorderColor(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return Color.fromString(element.getCssValue("border-color"));
    }

    /**
     * Returns the font family of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the font family of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public String getFontFamily(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getCssValue("font-family");
    }

    /**
     * Returns the font size of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the font size of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public String getFontSize(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getCssValue("font-size");
    }

    /**
     * Returns the font style of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the font style of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public String getFontStyle(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getCssValue("font-style");
    }

    /**
     * Returns the font weight of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the font weight of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public String getFontWeight(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getCssValue("font-weight");
    }

    /**
     * Returns the text decoration of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the text decoration of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public String getTextDecoration(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getCssValue("text-decoration");
    }

    /**
     * Returns the text alignment of the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return the text alignment of the specified element
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public String getTextAlignment(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        return element.getCssValue("text-align");
    }

    /**
     * Get the relative index of an element to its parent (starting from 0). The comment node and
     * empty text node will be ignored.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return of relative index of the element to its parent (starting from 0)
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getElementIndex(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);

        String script =
                "var _isCommentOrEmptyTextNode = function(node) {\n" +
                        "    return node.nodeType == 8 || ((node.nodeType == 3) && !(/[^\\t\\n\\r ]/.test(node.data)));\n" +
                        "};\n" +
                        "    var element = arguments[0];\n" +
                        "    var previousSibling;\n" +
                        "    var index = 0;\n" +
                        "    while ((previousSibling = element.previousSibling) != null) {\n" +
                        "        if (!_isCommentOrEmptyTextNode(previousSibling)) {\n" +
                        "            index++;\n" +
                        "        }\n" +
                        "        element = previousSibling;\n" +
                        "    }\n" +
                        "    return index;";

        return (Long) webDriver.executeScript(script, element);
    }

    /**
     * Retrieves the horizontal position of an element
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return of pixels from the edge of the frame.
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getElementPositionLeft(String parentLocator, String locator) {
        Point location = webDriver.findElement(parentLocator, locator).getLocation();
        return location.getX();
    }

    /**
     * Retrieves the vertical position of an element
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return of pixels from the edge of the frame.
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getElementPositionTop(String parentLocator, String locator) {
        Point location = webDriver.findElement(parentLocator, locator).getLocation();
        return location.getY();
    }

    /**
     * Retrieves the width of an element
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return width of an element in pixels
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getElementWidth(String parentLocator, String locator) {
        Dimension size = webDriver.findElement(parentLocator, locator).getSize();
        return size.getWidth();
    }

    /**
     * Retrieves the height of an element
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an element
     * @return height of an element in pixels
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, storeCmd = false, waitCmd = false, executeCmd = false)
    public Number getElementHeight(String parentLocator, String locator) {
        Dimension size = webDriver.findElement(parentLocator, locator).getSize();
        return size.getHeight();
    }

    /**
     * Retrieves the text cursor position in the given input element or textarea. Beware, this may not
     * work perfectly on all browsers.
     *
     * <p>
     * Specifically, if the cursor/selection has been cleared by JavaScript, this command will tend to
     * return the position of the last location of the cursor, even though the cursor is now gone from
     * the page. This is filed as <a href="http://jira.openqa.org/browse/SEL-243">SEL-243</a>.
     * </p>
     * This method will fail if the specified element isn't an input element or textarea, or there is
     * no cursor in the element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an input element or
     *        textarea
     * @return the numerical position of the cursor in the field
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false, waitCmd = false, executeCmd = false)
    public Number getCursorPosition(String parentLocator, String locator) {
        // All supported browsers apparently support "document.selection". Let's use that and the
        // relevant snippet of code from the original selenium core to implement this. What could
        // possibly go wrong?

        WebElement element = webDriver.findElement(parentLocator, locator);

        return (Number) webDriver.executeScript(
                Joiner.on("\n").join(
                        "var element = arguments[0];",
                                "var doc = document;",
                                "var win = window;",
                                "if( doc.selection && !browserVersion.isOpera){",
                                "    try {",
                                "        var selectRange = doc.selection.createRange().duplicate();",
                                "        var elementRange = element.createTextRange();",
                                "        selectRange.move('character',0);",
                                "        elementRange.move('character',0);",
                                "        var inRange1 = selectRange.inRange(elementRange);",
                                "        var inRange2 = elementRange.inRange(selectRange);",
                                "        elementRange.setEndPoint('EndToEnd', selectRange);",
                                "    } catch (e) {",
                                "        throw Error('There is no cursor on this page!');",
                                "    }",
                                "    var answer = String(elementRange.text).replace(/\\\\r/g,'').length;",
                                "    return answer;",
                                "} else {",
                                "    if (typeof(element.selectionStart) != 'undefined') {",
                                "        if (win.getSelection && typeof(win.getSelection().rangeCount) != undefined && win.getSelection().rangeCount == 0) {",
                                "            throw Error('There is no cursor on this page!');",
                                "        }",
                                "        return element.selectionStart;",
                                "    }",
                                "}",
                                "throw Error('Couldn\\\'t detect cursor position on this browser!');"),
                element);
    }

    /**
     * Gets the QR code's value from the image tag source encoded in Base64 format.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @return the QR code's value
     */
    @Accessor(param1 = "parentLocator", param2 = "locator", android = false, ios = false)
    public String getQR(String parentLocator, String locator) throws IOException, NotFoundException {
        WebElement element = webDriver.findElement(parentLocator, locator);

        String qrCode = element.getAttribute("src");
        if (qrCode.startsWith("data:")) {
            qrCode = qrCode.split(",")[1];
            return decodeQRCode(qrCode);
        } else {
            return decodeQRCode(new URL(qrCode));
        }
    }

    private static String decodeQRCode(URL qrCodeImage) throws IOException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeImage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }

    private static String decodeQRCode(String base64QRCode) throws IOException, NotFoundException {
        byte[] decoded = Base64.decodeBase64(base64QRCode);
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(decoded));
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }
}
