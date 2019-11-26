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

package excelium.executor.mobile.common;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;

/**
 * Represents a class which contains commands for controlling mobile session actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class SessionCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Session command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public SessionCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Set the current device/browser orientation to landscape.
     */
    @Action
    public void landscape() {
        webDriver.getAppiumDriver().rotate(ScreenOrientation.LANDSCAPE);
    }

    /**
     * Set the current device/browser orientation to portrait.
     */
    @Action
    public void portrait() {
        webDriver.getAppiumDriver().rotate(ScreenOrientation.PORTRAIT);
    }

    /**
     * Rotate the device in three dimensions.
     *
     * @param rotation a string represents the three dimensional plane and how a device can be rotated about it.
     */
    @Action(param1 = "rotation")
    public void rotate(String rotation) {
        String[] dim = rotation.split("\\s*,\\s*");
        webDriver.getAppiumDriver().rotate(new DeviceRotation(Integer.parseInt(dim[0]), Integer.parseInt(dim[1]), Integer.parseInt(dim[2])));
    }

    /**
     * Set the current geo location.
     *
     * @param location the string of physical location of the browser separated by commas ("latitude,longitude,altitude")
     */
    @Action(param1 = "location")
    public void setGeolocation(String location) {
        String[] pos = location.split("\\s*,\\s*");
        webDriver.getAppiumDriver().setLocation(new Location(Float.parseFloat(pos[0]), Float.parseFloat(pos[1]), Float.parseFloat(pos[2])));
    }
}
