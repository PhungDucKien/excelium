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

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Represents a class which contains commands for simulating events.
 *
 * @author PhungDucKien
 * @since 2018.07.05
 */
public class EventCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Event command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public EventCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Sends keys to the keyboard representation in the browser.
     *
     * @param value the value to type
     */
    @Action(param1 = "value")
    public void typeKeys(String value) {
        value = value.replace("\\10", Keys.ENTER);
        value = value.replace("\\13", Keys.RETURN);
        value = value.replace("\\27", Keys.ESCAPE);
        value = value.replace("\\38", Keys.ARROW_UP);
        value = value.replace("\\40", Keys.ARROW_DOWN);
        value = value.replace("\\37", Keys.ARROW_LEFT);
        value = value.replace("\\39", Keys.ARROW_RIGHT);

        webDriver.getKeyboard().sendKeys(value);
    }

    /**
     * Simulates keystroke events on the specified element, as though you typed the value key-by-key.
     *
     * <p>
     * This is a convenience method for calling keyDown, keyUp, keyPress for every character in the
     * specified string; this is useful for dynamic UI widgets (like auto-completing combo boxes) that
     * require explicit key events.
     * </p>
     * <p>
     * Unlike the simple "type" command, which forces the specified value into the page directly, this
     * command may or may not have any visible effect, even in cases where typing keys would normally
     * have a visible effect. For example, if you use "typeKeys" on a form element, you may or may not
     * see the results of what you typed in the field.
     * </p>
     * <p>
     * In some cases, you may need to use the simple "type" command to set the value of the field and
     * then the "typeKeys" command to send the keystroke events corresponding to what you just typed.
     * </p>
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param value         the value to type
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "value")
    public void typeKeys(String parentLocator, String locator, String value) {
        value = value.replace("\\10", Keys.ENTER);
        value = value.replace("\\13", Keys.RETURN);
        value = value.replace("\\27", Keys.ESCAPE);
        value = value.replace("\\38", Keys.ARROW_UP);
        value = value.replace("\\40", Keys.ARROW_DOWN);
        value = value.replace("\\37", Keys.ARROW_LEFT);
        value = value.replace("\\39", Keys.ARROW_RIGHT);

        WebElement element = webDriver.findElement(parentLocator, locator);
        element.sendKeys(value);
    }

    /**
     * Simulates a user pressing and releasing a key.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param keySequence   Either be a string(
     *                      "\" followed by the numeric keycode  of the key to be pressed, normally the ASCII value of that key), or a single  character. For example: "
     *                      w", "\119".
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "keySequence")
    public void keyPress(String parentLocator, String locator, String keySequence) {
        typeKeys(parentLocator, locator, keySequence);
    }

    /**
     * Simulates a user pressing a key (without releasing it yet).
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param keySequence   Either be a string(
     *                      "\" followed by the numeric keycode  of the key to be pressed, normally the ASCII value of that key), or a single  character. For example: "
     *                      w", "\119".
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "keySequence")
    public void keyDown(String parentLocator, String locator, String keySequence) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        webDriver.getJavascriptLibrary().callEmbeddedSelenium(webDriver, "doKeyDown", element,
                keySequence, webDriver.isControlKeyDown(), webDriver.isAltKeyDown(), webDriver.isShiftKeyDown(), webDriver.isMetaKeyDown());
    }

    /**
     * Simulates a user releasing a key.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param keySequence   Either be a string(
     *                      "\" followed by the numeric keycode  of the key to be pressed, normally the ASCII value of that key), or a single  character. For example: "
     *                      w", "\119".
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "keySequence")
    public void keyUp(String parentLocator, String locator, String keySequence) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        webDriver.getJavascriptLibrary().callEmbeddedSelenium(webDriver, "doKeyUp", element,
                keySequence, webDriver.isControlKeyDown(), webDriver.isAltKeyDown(), webDriver.isShiftKeyDown(), webDriver.isMetaKeyDown());
    }

    /**
     * Simulates a user pressing and releasing a key by sending a native operating system keystroke.
     * This function uses the java.awt.Robot class to send a keystroke; this more accurately simulates
     * typing a key on the keyboard. It does not honor settings from the shiftKeyDown, controlKeyDown,
     * altKeyDown and metaKeyDown commands, and does not target any particular HTML element. To send a
     * keystroke to a particular element, focus on the element first before running this command.
     *
     * @param keycode an integer keycode number corresponding to a java.awt.event.KeyEvent; note that
     *                Java keycodes are NOT the same thing as JavaScript keycodes!
     */
    @Action(param1 = "keycode")
    public void keyPress(String keycode) {
        char[] chars = Character.toChars(Integer.parseInt(keycode));
        new Actions(webDriver).sendKeys(new String(chars)).perform();
    }

    /**
     * Simulates a user pressing a key (without releasing it yet) by sending a native operating system
     * keystroke. This function uses the java.awt.Robot class to send a keystroke; this more
     * accurately simulates typing a key on the keyboard. It does not honor settings from the
     * shiftKeyDown, controlKeyDown, altKeyDown and metaKeyDown commands, and does not target any
     * particular HTML element. To send a keystroke to a particular element, focus on the element
     * first before running this command.
     *
     * @param keycode an integer keycode number corresponding to a java.awt.event.KeyEvent; note that
     *                Java keycodes are NOT the same thing as JavaScript keycodes!
     */
    @Action(param1 = "keycode")
    public void keyDown(String keycode) {
        char[] chars = Character.toChars(Integer.parseInt(keycode));
        new Actions(webDriver).keyDown(Keys.getKeyFromUnicode(chars[0])).perform();
    }

    /**
     * Simulates a user releasing a key by sending a native operating system keystroke. This function
     * uses the java.awt.Robot class to send a keystroke; this more accurately simulates typing a key
     * on the keyboard. It does not honor settings from the shiftKeyDown, controlKeyDown, altKeyDown
     * and metaKeyDown commands, and does not target any particular HTML element. To send a keystroke
     * to a particular element, focus on the element first before running this command.
     *
     * @param keycode an integer keycode number corresponding to a java.awt.event.KeyEvent; note that
     *                Java keycodes are NOT the same thing as JavaScript keycodes!
     */
    @Action(param1 = "keycode")
    public void keyUp(String keycode) {
        char[] chars = Character.toChars(Integer.parseInt(keycode));
        new Actions(webDriver).keyUp(Keys.getKeyFromUnicode(chars[0])).perform();
    }

    /**
     * Press the meta key and hold it down until doMetaUp() is called or a new page is loaded.
     */
    @Action
    public void metaKeyDown() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyDown(Keys.META).perform();
        webDriver.setMetaKeyDown(true);
    }

    /**
     * Release the meta key.
     */
    @Action
    public void metaKeyUp() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyUp(Keys.META).perform();
        webDriver.setMetaKeyDown(false);
    }

    /**
     * Press the alt key and hold it down until doAltUp() is called or a new page is loaded.
     */
    @Action
    public void altKeyDown() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyDown(Keys.ALT).perform();
        webDriver.setAltKeyDown(true);
    }

    /**
     * Release the alt key.
     */
    @Action
    public void altKeyUp() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyUp(Keys.ALT).perform();
        webDriver.setAltKeyDown(false);
    }

    /**
     * Press the control key and hold it down until doControlUp() is called or a new page is loaded.
     */
    @Action
    public void controlKeyDown() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyDown(Keys.CONTROL).perform();
        webDriver.setControlKeyDown(true);
    }

    /**
     * Release the control key.
     */
    @Action
    public void controlKeyUp() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyUp(Keys.CONTROL).perform();
        webDriver.setControlKeyDown(false);
    }

    /**
     * Press the shift key and hold it down until doShiftUp() is called or a new page is loaded.
     */
    @Action
    public void shiftKeyDown() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyDown(Keys.SHIFT).perform();
        webDriver.setShiftKeyDown(true);
    }

    /**
     * Release the shift key.
     */
    @Action
    public void shiftKeyUp() {
        Actions actionBuilder = new Actions(webDriver);
        actionBuilder.keyUp(Keys.SHIFT).perform();
        webDriver.setShiftKeyDown(false);
    }

    /**
     * Clicks on a link, button, checkbox or radio button. If the click action causes a new page to
     * load (like a link usually does), call waitForPageToLoad.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "coordString")
    public void clickAt(String parentLocator, String locator, String coordString) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        String[] parts = coordString.split(",");
        int xOffset = Integer.parseInt(parts[0]);
        int yOffset = Integer.parseInt(parts[1]);
        if (webDriver.isPC()) {
            new Actions(webDriver).moveToElement(element, xOffset, yOffset).click().perform();
        } else {
            new TouchAction(webDriver.getAppiumDriver())
                    .tap(TapOptions.tapOptions().withTapsCount(1).withPosition(PointOption.point(element.getLocation().x + xOffset, element.getLocation().y + yOffset)))
                    .perform();
        }
    }

    /**
     * Double clicks on a link, button, checkbox or radio button. If the double click action causes a
     * new page to load (like a link usually does), call waitForPageToLoad.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "coordString")
    public void doubleClickAt(String parentLocator, String locator, String coordString) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        String[] parts = coordString.split(",");
        int xOffset = Integer.parseInt(parts[0]);
        int yOffset = Integer.parseInt(parts[1]);
        if (webDriver.isPC()) {
            new Actions(webDriver).moveToElement(element, xOffset, yOffset).doubleClick().perform();
        } else {
            new TouchAction(webDriver.getAppiumDriver())
                    .tap(TapOptions.tapOptions().withTapsCount(2).withPosition(PointOption.point(element.getLocation().x + xOffset, element.getLocation().y + yOffset)))
                    .perform();
        }
    }

    /**
     * Simulates opening the context menu for the specified element (as might happen if the user
     * "right-clicked" on the element).
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "coordString")
    public void contextMenuAt(String parentLocator, String locator, String coordString) {
        WebElement element = webDriver.findElement(parentLocator, locator);
        String[] parts = coordString.split(",");
        int xOffset = Integer.parseInt(parts[0]);
        int yOffset = Integer.parseInt(parts[1]);
        if (webDriver.isPC()) {
            new Actions(webDriver).moveToElement(element, xOffset, yOffset).contextClick().perform();
        } else {
            new TouchAction(webDriver.getAppiumDriver())
                    .longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(element.getLocation().x + xOffset, element.getLocation().y + yOffset)))
                    .perform();
        }
    }

    /**
     * Simulates a user hovering a mouse over the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void mouseOver(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "mouseover");
    }

    /**
     * Simulates a user moving the mouse pointer away from the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void mouseOut(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "mouseout");
    }

    /**
     * Simulates a user pressing the left mouse button (without releasing it yet) on the specified
     * element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void mouseDown(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "mousedown");
    }

    /**
     * Simulates a user pressing the left mouse button (without releasing it yet) at the specified
     * location.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "coordString")
    public void mouseDownAt(String parentLocator, String locator, String coordString) {
        fireEventAt(parentLocator, locator, "mousedown", coordString);
    }

    /**
     * Simulates the event that occurs when the user releases the mouse button (i.e., stops holding
     * the button down) on the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void mouseUp(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "mouseup");
    }

    /**
     * Simulates the event that occurs when the user releases the mouse button (i.e., stops holding
     * the button down) at the specified location.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "coordString")
    public void mouseUpAt(String parentLocator, String locator, String coordString) {
        fireEventAt(parentLocator, locator, "mouseup", coordString);
    }

    /**
     * Simulates a user pressing the mouse button (without releasing it yet) on the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void mouseMove(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "mousemove");
    }

    /**
     * Simulates a user pressing the mouse button (without releasing it yet) on the specified element.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "coordString")
    public void mouseMoveAt(String parentLocator, String locator, String coordString) {
        fireEventAt(parentLocator, locator, "mousemove", coordString);
    }

    /**
     * Move the focus to the specified element; for example, if the element is an input field, move
     * the cursor to that field.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void focus(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "focus");
    }

    /**
     * Remove the focus from the specified element; for example, if the element is an input field, remove
     * the cursor from that field.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     */
    @Action(param1 = "parentLocator", param2 = "locator")
    public void blur(String parentLocator, String locator) {
        fireEvent(parentLocator, locator, "blur");
    }

    /**
     * Explicitly simulate an event, to trigger the corresponding "on<em>event</em>" handler.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param eventName     the event name, e.g. "focus" or "blur"
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "eventName")
    public void fireEvent(String parentLocator, String locator, String eventName) {
        String fire = "return (" + webDriver.getJavascriptLibrary().getSeleniumScript("fireEvent.js") + ").apply(null, arguments);";

        WebElement element = webDriver.findElement(parentLocator, locator);
        webDriver.executeScript(fire, element, eventName);
    }

    /**
     * Explicitly simulate an event, to trigger the corresponding "on<em>event</em>" handler.
     *
     * @param parentLocator an element locator of parent element
     * @param locator       an element locator
     * @param eventName     the event name, e.g. "focus" or "blur"
     * @param coordString   specifies the x,y position (i.e. - 10,20) of the mouse event relative to the
     *                      element returned by the locator.
     */
    private void fireEventAt(String parentLocator, String locator, String eventName, String coordString) {
        String fire = "return (" + webDriver.getJavascriptLibrary().getSeleniumScript("fireEventAt.js") + ").apply(null, arguments);";

        WebElement element = webDriver.findElement(parentLocator, locator);
        webDriver.executeScript(fire, element, eventName, coordString);
    }
}
