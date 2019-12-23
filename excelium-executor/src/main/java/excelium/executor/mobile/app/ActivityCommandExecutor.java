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

import excelium.common.StringUtil;
import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import io.appium.java_client.android.Activity;

import java.io.IOException;
import java.util.Properties;

/**
 * Represents a class which contains commands for controlling Android activity actions.
 *
 * @author PhungDucKien
 * @since 2019.10.28
 */
public class ActivityCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Activity command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public ActivityCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Start an Android activity by providing package name and activity name.
     * If the activity belongs to another application, that application is started and the activity is opened.
     * <p>
     * The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties.
     * For example: appPackage=example,appActivity=example
     *
     * @param activity the given activity
     * @throws IOException Invalid properties provided
     */
    @Action(param1 = "activity")
    public void startActivity(String activity) throws IOException {
        Properties activityProps = StringUtil.parseProperties(activity, ",");
        webDriver.getAndroidDriver().startActivity(new Activity(activityProps.getProperty("appPackage"), activityProps.getProperty("appActivity")));
    }

    /**
     * Determines the current activity being run on the mobile device matches the given activity.
     * <p>
     * The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties.
     * For example: appPackage=example,appActivity=example
     *
     * @param activity the given activity
     * @return true if the current activity being run on the mobile device matches the given activity, false otherwise
     * @throws IOException Invalid properties provided
     */
    @Accessor(param1 = "activity")
    public boolean isActivity(String activity) throws IOException {
        String currentActivity = webDriver.getAndroidDriver().currentActivity();
        String currentPackage = webDriver.getAndroidDriver().getCurrentPackage();
        Properties activityProps = StringUtil.parseProperties(activity, ",");

        return activityProps.getProperty("appActivity").equals(currentActivity) && activityProps.getProperty("appPackage").equals(currentPackage);
    }
}
