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

package excelium.executor.mobile.app;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import io.appium.java_client.appmanagement.ApplicationState;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriverException;

import java.time.Duration;

/**
 * Represents a class which contains commands for controlling mobile app actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class AppCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new App command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public AppCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Launch the app-under-test, which was provided in the capabilities at session creation, on the device, and (re)starts the session.
     * <p>
     * If the app-under-test (AUT) is closed, or backgrounded, it will launch it and bring to the foreground. If the AUT is already open, it will background it and re-launch it.
     */
    @Action
    public void launchApp() {
        webDriver.getAppiumDriver().launchApp();
    }

    /**
     * Send the currently running app for this session to the background, and either return after a certain amount of time, or leave the app deactivated (-1 means to deactivate the app entirely).
     *
     * @param secs An integer designating how long, in seconds, to background the app for. -1 means to deactivate the app entirely.
     */
    @Action(param1 = "secs")
    public void runAppInBackground(String secs) {
        webDriver.getAppiumDriver().runAppInBackground(Duration.ofSeconds(toInteger(secs, 1)));
    }

    /**
     * Close the app which was provided in the capabilities at session creation
     * and quits the session.
     */
    @Action
    public void closeApp() {
        webDriver.getAppiumDriver().closeApp();
    }

    /**
     * Resets the currently running app together with the session.
     */
    @Action
    public void resetApp() {
        webDriver.getAppiumDriver().resetApp();
    }

    /**
     * Reload the application without cleaning application data.
     */
    @Action
    public void reloadApp() {
        webDriver.getAppiumDriver().closeApp();
        webDriver.getAppiumDriver().launchApp();
    }

    /**
     * Activates the given app and moves it to the foreground if it installed, but not running or if it is running in the
     * background. The call is ignored if the application is already in foreground.
     *
     * @param bundleId the bundle identifier of the application, which is going to be brought to the foreground.
     */
    @Action(param1 = "bundleId")
    public void activateApp(String bundleId) {
        webDriver.getAppiumDriver().activateApp(bundleId);
    }

    /**
     * Terminates an existing application on the device if it is running. The call is ignored if the application is not running.
     *
     * @param bundleId the bundle identifier of the application, which is going to be terminated.
     */
    @Action(param1 = "bundleId")
    public void terminateApp(String bundleId) {
        ApplicationState state = webDriver.getAppiumDriver().queryAppState(bundleId);
        switch (state) {
            case NOT_INSTALLED:
                throw new NotFoundException("Application not found");
            case RUNNING_IN_BACKGROUND_SUSPENDED:
            case RUNNING_IN_BACKGROUND:
            case RUNNING_IN_FOREGROUND:
                boolean result = webDriver.getAppiumDriver().terminateApp(bundleId);
                if (!result) {
                    throw new WebDriverException("Unable to terminate application");
                }
                break;
            case NOT_RUNNING:
                break;
        }
    }
}
