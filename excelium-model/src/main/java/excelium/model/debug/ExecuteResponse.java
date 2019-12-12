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

package excelium.model.debug;

import org.openqa.selenium.Dimension;

public class ExecuteResponse {
    private String source;
    private String sourceError;
    private String screenshot;
    private String screenshotError;
    private Dimension windowSize;
    private String windowSizeError;
    private WebElement el;
    private String variableName;
    private String variableType;
    private Integer variableIndex;
    private String strategy;
    private String selector;
    private String id;
    private String methodName;
    private Boolean ignoreResult;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceError() {
        return sourceError;
    }

    public void setSourceError(String sourceError) {
        this.sourceError = sourceError;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getScreenshotError() {
        return screenshotError;
    }

    public void setScreenshotError(String screenshotError) {
        this.screenshotError = screenshotError;
    }

    public Dimension getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(Dimension windowSize) {
        this.windowSize = windowSize;
    }

    public String getWindowSizeError() {
        return windowSizeError;
    }

    public void setWindowSizeError(String windowSizeError) {
        this.windowSizeError = windowSizeError;
    }

    public WebElement getEl() {
        return el;
    }

    public void setEl(WebElement el) {
        this.el = el;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public Integer getVariableIndex() {
        return variableIndex;
    }

    public void setVariableIndex(Integer variableIndex) {
        this.variableIndex = variableIndex;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Boolean getIgnoreResult() {
        return ignoreResult;
    }

    public void setIgnoreResult(Boolean ignoreResult) {
        this.ignoreResult = ignoreResult;
    }
}
