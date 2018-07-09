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

import com.google.common.collect.Iterables;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.webdriven.Windows;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class which contains commands for controlling windows.
 *
 * @author PhungDucKien
 * @since 2018.07.04
 */
public class WindowCommandExecutor extends CommandExecutor {

    /**
     * Windows
     */
    private final Windows windows;

    /**
     * Instantiates a new Window command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public WindowCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
        windows = new Windows(webDriver);
    }

    /**
     * Opens a popup window. This accepts both relative and absolute URLs.
     * <p>
     * The "openWindow" command selects the window after the window is opened. (the "selectWindow" command is
     * implicitly invoked)
     *
     * @param url the URL to open; may be relative or absolute
     */
    @Action(param1 = "url")
    public void openWindow(String url) {
        webDriver.executeScript("window.open(arguments[0]);", getAbsoluteUrl(url));

        selectLastWindow();
    }

    /**
     * Opens a popup window (if a window with that ID isn't already open).
     * <p>
     * The "openWindow" command selects the window after the window is opened. (the "selectWindow" command is
     * implicitly invoked)
     *
     * <aside class="notice"> In some cases, Selenium will be unable to intercept a call to window.open
     * (if the call occurs during or before the "onLoad" event, for example). In those cases, you can force
     * Selenium to notice the open window's name by using the Selenium openWindow command, using an empty
     * (blank) url, like this: openWindow("", "myFunnyWindow").</aside>
     *
     * @param url      the URL to open, which can be blank
     * @param windowID the JavaScript window ID of the window to select
     */
    @Action(param1 = "url", param2 = "windowID")
    public void openWindow(String url, String windowID) {
        if (StringUtils.isNotEmpty(url)) {
            url = getAbsoluteUrl(url);
        }

        webDriver.executeScript("window.open(arguments[0], arguments[1]);", url, windowID);
        selectWindow(windowID);
    }

    /**
     * Simulates the user clicking the "close" button in the titlebar of a popup window or tab.
     */
    @Action
    public void close() {
        webDriver.close();
    }

    /**
     * Selects a popup window using a window locator; once a popup window has been selected, all
     * commands go to that window. To select the main window again, use null as the target.
     *
     * <p>
     *
     * Window locators provide different ways of specifying the window object: by title, by internal
     * JavaScript "name," or by JavaScript variable.
     * </p>
     * <ul>
     * <li><strong>title</strong>=<em>My Special Window</em>: Finds the window using the text that
     * appears in the title bar. Be careful; two windows can share the same title. If that happens,
     * this locator will just pick one.</li>
     * <li><strong>name</strong>=<em>myWindow</em>: Finds the window using its internal JavaScript
     * "name" property. This is the second parameter "windowName" passed to the JavaScript method
     * window.open(url, windowName, windowFeatures, replaceFlag) (which Selenium intercepts).</li>
     * <li><strong>var</strong>=<em>variableName</em>: Some pop-up windows are unnamed (anonymous),
     * but are associated with a JavaScript variable name in the current application window, e.g.
     * "window.foo = window.open(url);". In those cases, you can open the window using "var=foo".</li>
     * </ul>
     * <p>
     * If no window locator prefix is provided, we'll try to guess what you mean like this:
     * </p>
     * <p>
     * 1.) if windowID is null, (or the string "null") then it is assumed the user is referring to the
     * original window instantiated by the browser).
     * </p>
     * <p>
     * 2.) if the value of the "windowID" parameter is a JavaScript variable name in the current
     * application window, then it is assumed that this variable contains the return value from a call
     * to the JavaScript window.open() method.
     * </p>
     * <p>
     * 3.) Otherwise, selenium looks in a hash it maintains that maps string names to window "names".
     * </p>
     * <p>
     * 4.) If <em>that</em> fails, we'll try looping over all of the known windows to try to find the
     * appropriate "title". Since "title" is not necessarily unique, this may have unexpected
     * behavior.
     * </p>
     * <p>
     * If you're having trouble figuring out the name of a window that you want to manipulate, look at
     * the Selenium log messages which identify the names of windows created via window.open (and
     * therefore intercepted by Selenium). You will see messages like the following for each window as
     * it is opened:
     * </p>
     * <p>
     * <code>debug: window.open call intercepted; window ID (which you can use with selectWindow()) is "myNewWindow"</code>
     * </p>
     * <p>
     * In some cases, Selenium will be unable to intercept a call to window.open (if the call occurs
     * during or before the "onLoad" event, for example). (This is bug SEL-339.) In those cases, you
     * can force Selenium to notice the open window's name by using the Selenium openWindow command,
     * using an empty (blank) url, like this: openWindow("", "myFunnyWindow").
     * </p>
     *
     * @param windowID the JavaScript window ID of the window to select
     */
    @Action(param1 = "windowID")
    public void selectWindow(String windowID) {
        windows.selectWindow(webDriver, windowID);
    }

    /**
     * Simplifies the process of selecting a popup window (and does not offer functionality beyond
     * what <code>selectWindow()</code> already provides).
     * <ul>
     * <li>If <code>windowID</code> is either not specified, or specified as "null", the first non-top
     * window is selected. The top window is the one that would be selected by
     * <code>selectWindow()</code> without providing a <code>windowID</code> . This should not be used
     * when more than one popup window is in play.</li>
     * <li>Otherwise, the window will be looked up considering <code>windowID</code> as the following
     * in order: 1) the "name" of the window, as specified to <code>window.open()</code>; 2) a
     * javascript variable which is a reference to a window; and 3) the title of the window. This is
     * the same ordered lookup performed by <code>selectWindow</code> .</li>
     * </ul>
     *
     * @param windowID an identifier for the popup window, which can take on a number of different
     *        meanings
     */
    @Action(param1 = "windowID")
    public void selectPopUp(String windowID) {
        windows.selectPopUp(webDriver, windowID);
    }

    /**
     * Selects the main window. Functionally equivalent to using <code>selectWindow()</code> and
     * specifying no value for <code>windowID</code>.
     */
    @Action
    public void deselectPopUp() {
        windows.selectWindow(webDriver, "");
    }

    /**
     * Selects a frame within the current window. (You may invoke this command multiple times to
     * select nested frames.) To select the parent frame, use "relative=parent" as a locator; to
     * select the top frame, use "relative=top". You can also select a frame by its 0-based index
     * number; select the first frame with "index=0", or the third frame with "index=2".
     *
     * @param locator       an element locator identifying a frame or iframe
     */
    @Action(param1 = "locator")
    public void selectFrame(String locator) {
        windows.selectFrame(webDriver, locator);
    }

    /**
     * Selects the parent frame within the current window.
     * Equivalents to selectFrame("relative=up").
     */
    @Action
    public void selectParentFrame() {
        windows.selectFrame(webDriver, "relative=up");
    }

    /**
     * Waits for a popup window to appear and load up.
     *
     * @param windowID the JavaScript window "name" of the window that will appear (not the text of
     *        the title bar) If unspecified, or specified as "null", this command will wait for the
     *        first non-top window to appear (don't rely on this if you are working with multiple
     *        popups simultaneously).
     * @param timeout a timeout in milliseconds, after which the action will return with an error. If
     *        this value is not specified, the default Selenium timeout will be used. See the
     *        setTimeout() command.
     */
    @Action(param1 = "windowID", param2 = "timeout")
    public void waitForPopUp(String windowID, String timeout) {
        final String current = webDriver.getWindowHandle();

        WebDriverWait wait = createWebDriverWait(timeout);
        wait.until(driver -> {
            try {
                windows.selectPopUp(driver, windowID);
                return !"about:blank".equals(driver.getCurrentUrl());
            } catch (SeleniumException e) {
                // Swallow
            }
            return false;
        });

        webDriver.switchTo().window(current);
    }

    /**
     * Selects the first window (mostly the original window instantiated by the browser).
     */
    @Action
    public void selectFirstWindow() {
        String windowHandle = Iterables.getFirst(webDriver.getWindowHandles(), "");
        selectWindow(windowHandle);
    }

    /**
     * Selects the last opened window.
     */
    @Action
    public void selectLastWindow() {
        String windowHandle = Iterables.getLast(webDriver.getWindowHandles());
        selectWindow(windowHandle);
    }

    /** Gives focus to the currently selected window */
    @Action
    public void windowFocus() {
        webDriver.executeScript("window.focus()");
    }

    /** Resize currently selected window to take up the entire screen */
    @Action
    public void windowMaximize() {
        webDriver.executeScript("if (window.screen) { window.moveTo(0, 0); window.resizeTo(window.screen.availWidth, window.screen.availHeight);};");
    }

    /**
     * Returns every instance of some attribute from all known windows.
     *
     * @param attributeName name of an attribute on the windows
     * @return the set of values of this attribute from all known windows.
     */
    @Accessor(param1 = "attributeName", waitCmd = false, executeCmd = false)
    public String[] getAttributeFromAllWindows(String attributeName) {
        String current = webDriver.getWindowHandle();

        List<String> attributes = new ArrayList<>();
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);
            String value = (String) webDriver.executeScript(
                    "return '' + window[arguments[0]];", attributeName);
            attributes.add(value);
        }

        webDriver.switchTo().window(current);

        return attributes.toArray(new String[0]);
    }

    /**
     * Returns the names of all windows that the browser knows about.
     *
     * @return the names of all windows that the browser knows about.
     */
    @Accessor(waitCmd = false, executeCmd = false)
    public String[] getAllWindowNames() {
        String current = webDriver.getWindowHandle();

        List<String> attributes = new ArrayList<>();
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);
            attributes.add(webDriver.executeScript("return window.name").toString());
        }

        webDriver.switchTo().window(current);

        return attributes.toArray(new String[0]);
    }

    /**
     * Returns the titles of all windows that the browser knows about.
     *
     * @return the titles of all windows that the browser knows about.
     */
    @Accessor(waitCmd = false, executeCmd = false)
    public String[] getAllWindowTitles() {
        String current = webDriver.getWindowHandle();

        List<String> attributes = new ArrayList<>();
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);
            attributes.add(webDriver.getTitle());
        }

        webDriver.switchTo().window(current);

        return attributes.toArray(new String[0]);
    }
}
