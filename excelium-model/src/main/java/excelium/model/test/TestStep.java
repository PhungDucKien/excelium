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

package excelium.model.test;

import excelium.model.enums.Platform;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.MobileWebEnvironment;
import excelium.model.test.config.PcEnvironment;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents test step model.
 * This model stores the data retrieved from one row.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class TestStep {

    /**
     * Serial number
     */
    private Integer no;

    /**
     * Gutter
     */
    private String gutter;

    /**
     * Android gutter
     */
    private String androidGutter;

    /**
     * iOS gutter
     */
    private String iosGutter;

    /**
     * Is capture taken after step execution?
     */
    private boolean capture;

    /**
     * Name
     */
    private String name;

    /**
     * Description
     */
    private String description;

    /**
     * Command
     */
    private String command;

    /**
     * Parameter 1
     */
    private String param1;

    /**
     * Parameter 2
     */
    private String param2;

    /**
     * Parameter 3
     */
    private String param3;

    /**
     * Test data
     */
    private String testData;

    /**
     * Row index
     */
    private int rowIndex;

    /**
     * Gets no.
     *
     * @return the no
     */
    public Integer getNo() {
        return no;
    }

    /**
     * Sets no.
     *
     * @param no the no
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * Gets gutter.
     *
     * @return the gutter
     */
    public String getGutter() {
        return gutter;
    }

    /**
     * Sets gutter.
     *
     * @param gutter the gutter
     */
    public void setGutter(String gutter) {
        this.gutter = gutter;
    }

    /**
     * Gets android gutter.
     *
     * @return the android gutter
     */
    public String getAndroidGutter() {
        return androidGutter;
    }

    /**
     * Sets android gutter.
     *
     * @param androidGutter the android gutter
     */
    public void setAndroidGutter(String androidGutter) {
        this.androidGutter = androidGutter;
    }

    /**
     * Gets ios gutter.
     *
     * @return the ios gutter
     */
    public String getIosGutter() {
        return iosGutter;
    }

    /**
     * Sets ios gutter.
     *
     * @param iosGutter the ios gutter
     */
    public void setIosGutter(String iosGutter) {
        this.iosGutter = iosGutter;
    }

    /**
     * Is capture boolean.
     *
     * @return the boolean
     */
    public boolean isCapture() {
        return capture;
    }

    /**
     * Sets capture.
     *
     * @param capture the capture
     */
    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets command.
     *
     * @param command the command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Gets param 1.
     *
     * @return the param 1
     */
    public String getParam1() {
        return param1;
    }

    /**
     * Sets param 1.
     *
     * @param param1 the param 1
     */
    public void setParam1(String param1) {
        this.param1 = param1;
    }

    /**
     * Gets param 2.
     *
     * @return the param 2
     */
    public String getParam2() {
        return param2;
    }

    /**
     * Sets param 2.
     *
     * @param param2 the param 2
     */
    public void setParam2(String param2) {
        this.param2 = param2;
    }

    /**
     * Gets param 3.
     *
     * @return the param 3
     */
    public String getParam3() {
        return param3;
    }

    /**
     * Sets param 3.
     *
     * @param param3 the param 3
     */
    public void setParam3(String param3) {
        this.param3 = param3;
    }

    /**
     * Gets test data.
     *
     * @return the test data
     */
    public String getTestData() {
        return testData;
    }

    /**
     * Sets test data.
     *
     * @param testData the test data
     */
    public void setTestData(String testData) {
        this.testData = testData;
    }

    /**
     * Gets row index.
     *
     * @return the row index
     */
    public int getRowIndex() {
        return rowIndex;
    }

    /**
     * Sets row index.
     *
     * @param rowIndex the row index
     */
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    /**
     * Determine whether the step should be skipped on an environment.
     *
     * @param environment the environment
     * @return true if the step should be skipped, otherwise, false
     */
    public boolean isStepSkip(Environment environment) {
        return (isStepSkip(getGutter()) && (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment)) ||
                (isStepSkip(getAndroidGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.ANDROID) ||
                (isStepSkip(getIosGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.IOS);
    }

    /**
     * Determine whether the step is a debug point of an environment.
     *
     * @param environment the environment
     * @return true if the step is a debug point, otherwise, false
     */
    public boolean isStepDebug(Environment environment) {
        return (isStepDebug(getGutter()) && (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment)) ||
                (isStepDebug(getAndroidGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.ANDROID) ||
                (isStepDebug(getIosGutter()) && environment instanceof MobileAppEnvironment && environment.getPlatform() == Platform.IOS);
    }

    /**
     * Determine whether the step gutter indicates a skip.
     *
     * @param stepGutter the gutter of the step
     * @return true if the step gutter indicates a skip, otherwise, false
     */
    private boolean isStepSkip(String stepGutter) {
        return StringUtils.isNotBlank(stepGutter) && !StringUtils.equalsAnyIgnoreCase(stepGutter, "B", "D", "M");
    }

    /**
     * Determine whether the step gutter indicates a debug.
     *
     * @param stepGutter the gutter of the step
     * @return true if the step gutter indicates a debug, otherwise, false
     */
    private boolean isStepDebug(String stepGutter) {
        return StringUtils.isNotBlank(stepGutter) && StringUtils.equalsAnyIgnoreCase(stepGutter, "B", "D");
    }
}
