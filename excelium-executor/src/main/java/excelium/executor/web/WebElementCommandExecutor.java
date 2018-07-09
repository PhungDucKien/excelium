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

package excelium.executor.web;

import com.thoughtworks.selenium.SeleniumException;
import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.executor.web.support.OptionSelector;
import excelium.model.project.Project;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.function.BiFunction;

/**
 * Represents a class which contains commands for controlling web elements.
 *
 * @author PhungDucKien
 * @since 2018.07.03
 */
public class WebElementCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Web element command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public WebElementCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Sets the value of an input field, as though you typed it in.
     *
     * <p>
     * Can also be used to set the value of combo boxes, check boxes, etc. In these cases, value
     * should be the value of the option selected, not the visible text.
     * </p>
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param value         the value to type
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void type(String parentLocator, String locator, String value) {
        if (webDriver.isControlKeyDown() || webDriver.isAltKeyDown() || webDriver.isMetaKeyDown())
            throw new SeleniumException(
                    "type not supported immediately after call to controlKeyDown() or altKeyDown() or metaKeyDown()");

        String valueToUse = webDriver.isShiftKeyDown() ? value.toUpperCase() : value;

        WebElement element = webDriver.findElement(parentLocator, locator);

        String tagName = element.getTagName();
        String elementType = element.getAttribute("type");
        if (!"input".equals(tagName.toLowerCase())) {
            webDriver.executeScript("arguments[0].value = '';", element);
            element.sendKeys(valueToUse);
        } else {
            if (elementType != null && "file".equals(elementType.toLowerCase())) {
                element.sendKeys(valueToUse);
            } else {
                String type = "return (" + webDriver.getJavascriptLibrary().getSeleniumScript("type.js") + ").apply(null, arguments);";
                webDriver.executeScript(type, element, valueToUse);
            }
        }
    }

    /**
     * Sets the value of an input field, as though you typed it in and press Tab key.
     *
     * <p>
     * Can also be used to set the value of combo boxes, check boxes, etc. In these cases, value
     * should be the value of the option selected, not the visible text.
     * </p>
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param value         the value to type
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void typeAndTab(String parentLocator, String locator, String value) {
        type(parentLocator, locator, value);
        new Actions(webDriver).sendKeys(Keys.TAB).perform();
    }

    /**
     * Clicks on a link, button, checkbox or radio button. If the click action causes a new page to
     * load (like a link usually does), call waitForPageToLoad.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void click(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        element.click();
    }

    /**
     * Double clicks on a link, button, checkbox or radio button. If the double click action causes a
     * new page to load (like a link usually does), call waitForPageToLoad.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void doubleClick(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);

        new Actions(webDriver).doubleClick(element).perform();
    }

    /**
     * Simulates opening the context menu for the specified element (as might happen if the user
     * "right-clicked" on the element).
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void contextMenu(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.contextClick(element).perform();
    }

    /**
     * Select an option from a drop-down using an option locator.
     *
     * <p>
     * Option locators provide different ways of specifying options of an HTML Select element (e.g.
     * for selecting a specific option, or for asserting that the selected option satisfies a
     * specification). There are several forms of Select Option Locator.
     * </p>
     * <ul>
     * <li><strong>label</strong>=<em>labelPattern</em>: matches options based on their labels, i.e.
     * the visible text. (This is the default.)
     * <ul class="first last simple">
     * <li>label=regexp:^[Oo]ther</li>
     * </ul>
     * </li>
     * <li><strong>value</strong>=<em>valuePattern</em>: matches options based on their values.
     * <ul class="first last simple">
     * <li>value=other</li>
     * </ul>
     * </li>
     * <li><strong>id</strong>=<em>id</em>:
     *
     * matches options based on their ids.
     * <ul class="first last simple">
     * <li>id=option1</li>
     * </ul>
     * </li>
     * <li><strong>index</strong>=<em>index</em>: matches an option based on its index (offset from
     * zero).
     * <ul class="first last simple">
     * <li>index=2</li>
     * </ul>
     * </li>
     * </ul>
     * <p>
     * If no option locator prefix is provided, the default behaviour is to match on
     * <strong>label</strong>.
     * </p>
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator identifying a drop-down menu
     * @param optionLocator an option locator (a label by default)
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "optionLocator")
    public void select(String parentLocator, String locator, String optionLocator) {
        OptionSelector selector = new OptionSelector(webDriver, parentLocator, locator);
        selector.setSelected(optionLocator);
    }

    /**
     * Select an option from a drop-down using a label.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator identifying a drop-down menu
     * @param label         a label
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "label")
    public void selectLabel(String parentLocator, String locator, String label) {
        select(parentLocator, locator, "label=" + label);
    }

    /**
     * Select an option from a drop-down using a value.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator identifying a drop-down menu
     * @param value         a value
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void selectValue(String parentLocator, String locator, String value) {
        select(parentLocator, locator, "value=" + value);
    }

    /**
     * Select an option from a drop-down using an index.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator identifying a drop-down menu
     * @param index         an index
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "index")
    public void selectIndex(String parentLocator, String locator, String index) {
        select(parentLocator, locator, "index=" + index);
    }

    /**
     * Select an option from a drop-down using an element ID.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator identifying a drop-down menu
     * @param id            an element ID
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "id")
    public void selectId(String parentLocator, String locator, String id) {
        select(parentLocator, locator, "id=" + id);
    }

    /**
     * Add a selection to the set of selected options in a multi-select element using an option
     * locator.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param optionLocator an option locator (a label by default)
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "optionLocator")
    public void addSelection(String parentLocator, String locator, String optionLocator) {
        OptionSelector selector = new OptionSelector(webDriver, parentLocator, locator);
        selector.addSelection(optionLocator);
    }

    /**
     * Add a selection to the set of selected options in a multi-select element using a label.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param label a label
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "label")
    public void addSelectionLabel(String parentLocator, String locator, String label) {
        addSelection(parentLocator, locator, "label=" + label);
    }

    /**
     * Add a selection to the set of selected options in a multi-select element using a value.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param value a value
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void addSelectionValue(String parentLocator, String locator, String value) {
        addSelection(parentLocator, locator, "value=" + value);
    }

    /**
     * Add a selection to the set of selected options in a multi-select element using an index.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param index an index
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "index")
    public void addSelectionIndex(String parentLocator, String locator, String index) {
        addSelection(parentLocator, locator, "index=" + index);
    }

    /**
     * Add a selection to the set of selected options in a multi-select element using an element ID.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param id an element ID
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "id")
    public void addSelectionId(String parentLocator, String locator, String id) {
        addSelection(parentLocator, locator, "id=" + id);
    }

    /**
     * Remove a selection from the set of selected options in a multi-select element using an option
     * locator.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param optionLocator an option locator (a label by default)
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "optionLocator")
    public void removeSelection(String parentLocator, String locator, String optionLocator) {
        OptionSelector selector = new OptionSelector(webDriver, parentLocator, locator);
        selector.removeSelection(optionLocator);
    }

    /**
     * Remove a selection from the set of selected options in a multi-select element using a label.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param label a label
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "label")
    public void removeSelectionLabel(String parentLocator, String locator, String label) {
        removeSelection(parentLocator, locator, "label=" + label);
    }

    /**
     * Remove a selection from the set of selected options in a multi-select element using a value.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param value a value
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void removeSelectionValue(String parentLocator, String locator, String value) {
        removeSelection(parentLocator, locator, "value=" + value);
    }

    /**
     * Remove a selection from the set of selected options in a multi-select element using an index.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param index an index
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "index")
    public void removeSelectionIndex(String parentLocator, String locator, String index) {
        removeSelection(parentLocator, locator, "index=" + index);
    }

    /**
     * Remove a selection from the set of selected options in a multi-select element using an element ID.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     * @param id an element ID
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "id")
    public void removeSelectionId(String parentLocator, String locator, String id) {
        removeSelection(parentLocator, locator, "id=" + id);
    }

    /**
     * Unselects all of the selected options in a multi-select element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator identifying a multi-select box
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void removeAllSelections(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        Select selectElement = new Select(element);
        if (selectElement.isMultiple()) {
            selectElement.deselectAll();
        }
    }

    /**
     * Check a toggle-button (checkbox/radio)
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void check(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * Uncheck a toggle-button (checkbox/radio)
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void uncheck(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    /**
     * Submit the specified form. This is particularly useful for forms without submit buttons, e.g.
     * single-input "Search" forms.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator for the form you want to submit
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void submit(String parentLocator, String locator) {
        webDriver.findElement(parentLocator, locator).submit();
    }

    /**
     * Clears the value of an input field.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void clear(String parentLocator, String locator) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        element.clear();
    }

    /**
     * Drags an element a certain distance and then drops it
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator
     * @param movementsString offset in pixels from the current location to which the element should
     *        be moved, e.g., "+70,-300"
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "movementsString")
    public void dragAndDrop(String parentLocator, String locator, String movementsString) {
        String[] parts = movementsString.split("\\s*,\\s*", 2);
        int xDelta = Integer.parseInt(parts[0].trim());
        int yDelta = Integer.parseInt(parts[1].trim());

        WebElement element = webDriver.findElement(parentLocator, locator);
        Point clientStartXY = element.getLocation();
        int clientStartX = clientStartXY.getX();
        int clientStartY = clientStartXY.getY();

        int clientFinishX = ((clientStartX + xDelta) < 0) ? 0 : (clientStartX + xDelta);
        int clientFinishY = ((clientStartY + yDelta) < 0) ? 0 : (clientStartY + yDelta);

        int mouseSpeed = 10;
        BiFunction<Integer, Integer, Integer> move = (current, dest) -> {
            if (current.equals(dest)) return 0;
            if (Math.abs(current - dest) < mouseSpeed) return dest - current;
            return (current < dest) ? mouseSpeed : - mouseSpeed;
        };

        int clientX = clientStartX;
        int clientY = clientStartY;

        Actions actions = new Actions(webDriver).clickAndHold(element);

        while ((clientX != clientFinishX) || (clientY != clientFinishY)) {
            int deltaX = move.apply(clientX, clientFinishX);
            int deltaY = move.apply(clientY, clientFinishY);
            clientX += deltaX;
            clientY += deltaY;
            actions.moveByOffset(deltaX, deltaY);
        }

        actions.release();
        actions.perform();
    }

    /**
     * Drags an element and drops it on another element
     *
     * @param toBeDraggedObjectLocator an element to be dragged
     * @param dragDestinationObjectLocator an element whose location (i.e., whose center-most pixel)
     *        will be the point where locatorOfObjectToBeDragged is dropped
     */
    @Action(param1 = "toBeDraggedObjectLocator", param2 = "dragDestinationObjectLocator")
    public void dragAndDropToObject(String toBeDraggedObjectLocator, String dragDestinationObjectLocator) {
        WebElement elementFrom = webDriver.findElement(toBeDraggedObjectLocator);
        WebElement elementTo = webDriver.findElement(dragDestinationObjectLocator);
        new Actions(webDriver).dragAndDrop(elementFrom, elementTo).perform();
    }

    /**
     * Moves the text cursor to the specified position in the given input element or textarea. This
     * method will fail if the specified element isn't an input element or textarea.
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator pointing to an input element or textarea
     * @param position the numerical position of the cursor in the field; position should be 0 to move
     *        the position to the beginning of the field. You can also set the cursor to -1 to move it
     *        to the end of the field.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "position")
    public void setCursorPosition(String parentLocator, String locator, String position) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        long index = toInteger(position, -1);

        String setPosition = webDriver.getJavascriptLibrary().getSeleniumScript("setCursorPosition.js");

        webDriver.executeScript(
                "(" + setPosition + ")(arguments[0], arguments[1]);",
                element,
                index);
    }

    /**
     * Temporarily sets the "id" attribute of the specified element, so you can locate it in the
     * future using its ID rather than a slow/complicated XPath. This ID will disappear once the page
     * is reloaded.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator pointing to an element
     * @param identifier a string to be used as the ID of the specified element
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "identifier")
    public void assignId(String parentLocator, String locator, String identifier) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        webDriver.executeScript("arguments[0].id = arguments[1]", element, identifier);
    }

    /**
     * Check if these two elements have same parent and are ordered siblings in the DOM. Two same
     * elements will not be considered ordered.
     *
     * @param firstLocator an element locator pointing to the first element
     * @param secondLocator an element locator pointing to the second element
     * @return true if element1 is the previous sibling of element2, false otherwise
     */
    @Accessor(param1 = "firstLocator", param2 = "secondLocator", storeCmd = false, waitCmd = false, executeCmd = false)
    public boolean isOrdered(String firstLocator, String secondLocator) {
        WebElement one = webDriver.findElement(firstLocator);
        WebElement two = webDriver.findElement(secondLocator);

        String ordered =
                "    if (arguments[0] === arguments[1]) return false;\n" +
                        "\n" +
                        "    var previousSibling;\n" +
                        "    while ((previousSibling = arguments[1].previousSibling) != null) {\n" +
                        "        if (previousSibling === arguments[0]) {\n" +
                        "            return true;\n" +
                        "        }\n" +
                        "        arguments[1] = previousSibling;\n" +
                        "    }\n" +
                        "    return false;\n";

        Boolean result = (Boolean) webDriver.executeScript(ordered, one, two);
        return result != null && result;
    }
}
