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

package excelium.model.test.config;

/**
 * Represents environment model for mobile application.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
public class MobileAppEnvironment extends MobileEnvironment {

    /** App path */
    private String appPath;

    /** App activity */
    private String appActivity;

    /** App package */
    private String appPackage;

    /** App wait activity */
    private String appWaitActivity;

    /** App wait package */
    private String appWaitPackage;

    /**
     * Gets app path.
     *
     * @return the app path
     */
    public String getAppPath() {
        return appPath;
    }

    /**
     * Sets app path.
     *
     * @param appPath the app path
     */
    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    /**
     * Gets app activity.
     *
     * @return the app activity
     */
    public String getAppActivity() {
        return appActivity;
    }

    /**
     * Sets app activity.
     *
     * @param appActivity the app activity
     */
    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    /**
     * Gets app package.
     *
     * @return the app package
     */
    public String getAppPackage() {
        return appPackage;
    }

    /**
     * Sets app package.
     *
     * @param appPackage the app package
     */
    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    /**
     * Gets app wait activity.
     *
     * @return the app wait activity
     */
    public String getAppWaitActivity() {
        return appWaitActivity;
    }

    /**
     * Sets app wait activity.
     *
     * @param appWaitActivity the app wait activity
     */
    public void setAppWaitActivity(String appWaitActivity) {
        this.appWaitActivity = appWaitActivity;
    }

    /**
     * Gets app wait package.
     *
     * @return the app wait package
     */
    public String getAppWaitPackage() {
        return appWaitPackage;
    }

    /**
     * Sets app wait package.
     *
     * @param appWaitPackage the app wait package
     */
    public void setAppWaitPackage(String appWaitPackage) {
        this.appWaitPackage = appWaitPackage;
    }
}
