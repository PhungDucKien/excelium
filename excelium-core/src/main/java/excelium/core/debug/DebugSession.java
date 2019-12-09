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

package excelium.core.debug;

import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.debug.*;
import excelium.model.enums.ExecutionState;
import excelium.model.enums.StepMode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import javax.servlet.ServletException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebugSession {

    private ContextAwareWebDriver webDriver;

    private Map<String, ElementEntry> elementCache;

    private int elVariableCounter = 1;
    private int elArrayVariableCounter = 1;
    private ExecutionState executionState = ExecutionState.PAUSED;
    private StepMode stepMode = StepMode.STEP_NEXT_BREAKPOINT;

    public DebugSession(ContextAwareWebDriver webDriver) {
        this.webDriver = webDriver;
        this.elementCache = new HashMap<>();
    }

    public void resume() {
        this.executionState = ExecutionState.RUNNING;
        this.stepMode = StepMode.STEP_NEXT_BREAKPOINT;
    }

    public void stepOver() {
        this.executionState = ExecutionState.RUNNING;
        this.stepMode = StepMode.STEP_OVER;
    }

    public void muteAndResume() {
        this.executionState = ExecutionState.RUNNING;
        this.stepMode = StepMode.STEP_MUTE;
    }

    public void pause() {
        this.executionState = ExecutionState.PAUSED;
    }

    public ElementEntry fetchElement(String strategy, String selector) {
        try {
            RemoteWebElement element = (RemoteWebElement) webDriver.findElement(strategy + "=" + selector);
            String id = element.getId();

            // Cache this ID along with its variable name, variable type and strategy/selector
            ElementEntry cachedEl = new ElementEntry();
            cachedEl.setEl(element);
            cachedEl.setVariableType("string");
            cachedEl.setStrategy(strategy);
            cachedEl.setSelector(selector);
            cachedEl.setId(id);
            this.elementCache.put(id, cachedEl);

            return cachedEl;
        } catch (NoSuchElementException e) {
        }
        return new ElementEntry();
    }

    public ElementArray fetchElements(String strategy, String selector) {
        try {
            List<WebElement> els = webDriver.findElements(strategy + "=" + selector);

            String variableName = "els" + this.elArrayVariableCounter++;
            String variableType = "array";

            // Cache the elements that we find
            List<ElementEntry> elements = new ArrayList<>();
            int index = 0;
            for (WebElement el : els) {
                String id = ((RemoteWebElement) el).getId();
                ElementEntry cachedEl = new ElementEntry();
                cachedEl.setEl((RemoteWebElement) el);
                cachedEl.setVariableName(variableName);
                cachedEl.setVariableIndex(index);
                cachedEl.setVariableType("string");
                cachedEl.setStrategy(strategy);
                cachedEl.setSelector(selector);
                cachedEl.setId(id);
                this.elementCache.put(id, cachedEl);
                elements.add(cachedEl);

                index++;
            }

            ElementArray ret = new ElementArray();
            ret.setVariableName(variableName);
            ret.setVariableType(variableType);
            ret.setStrategy(strategy);
            ret.setSelector(selector);
            ret.setElements(elements);

            return ret;
        } catch (NoSuchElementException e) {
        }
        return new ElementArray();
    }

    private ExecuteResponse execute(String elementId, String methodName, Object[] args, boolean skipScreenshotAndSource) throws ServletException {
        ElementEntry cachedEl = null;
        if (StringUtils.isNotBlank(elementId)) {
            // Give the cached element a variable name (el1, el2, el3,...) the first time it's used
            cachedEl = this.elementCache.get(elementId);
            if (StringUtils.isBlank(cachedEl.getVariableName()) && "string".equals(cachedEl.getVariableType())) {
                cachedEl.setVariableName("el" + this.elVariableCounter++);
            }

            applyMethod(cachedEl.getEl(), methodName, args);
        } else {
            // Specially handle the tap and swipe method
            if ("tap".equals(methodName)) {
                new TouchAction(webDriver.getAppiumDriver())
                        .tap(TapOptions.tapOptions().withPosition(PointOption.point(((Double) args[0]).intValue(), ((Double) args[1]).intValue())))
                        .perform();
            } else if ("swipe".equals(methodName)) {
                int startX = ((Double) args[0]).intValue();
                int startY = ((Double) args[1]).intValue();
                int endX = ((Double) args[2]).intValue();
                int endY = ((Double) args[3]).intValue();

                new TouchAction(webDriver.getAppiumDriver())
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
            } else if ("back".equals(methodName)) {
                this.webDriver.getWebDriver().navigate().back();
            } else if ("refresh".equals(methodName)) {
                this.webDriver.getWebDriver().navigate().refresh();
            } else if ("forward".equals(methodName)) {
                this.webDriver.getWebDriver().navigate().forward();
            } else if (!"source".equals(methodName) && !"screenshot".equals(methodName)) {
                applyMethod(this.webDriver.getWebDriver(), methodName, args);
            }
        }

        // Give the source/screenshot time to change before taking the screenshot
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }

        SourceAndScreenshot sourceAndScreenshot = null;
        if (!skipScreenshotAndSource) {
            sourceAndScreenshot = getSourceAndScreenshot();
        }

        ExecuteResponse response = new ExecuteResponse();
        if (sourceAndScreenshot != null) {
            response.setSource(sourceAndScreenshot.getSource());
            response.setSourceError(sourceAndScreenshot.getSourceError());
            response.setScreenshot(sourceAndScreenshot.getScreenshot());
            response.setScreenshotError(sourceAndScreenshot.getScreenshotError());
            response.setWindowSize(sourceAndScreenshot.getWindowSize());
            response.setWindowSizeError(sourceAndScreenshot.getWindowSizeError());
        }
        if (cachedEl != null) {
            response.setEl(cachedEl.getEl());
            response.setVariableName(cachedEl.getVariableName());
            response.setVariableType(cachedEl.getVariableType());
            response.setVariableIndex(cachedEl.getVariableIndex());
            response.setStrategy(cachedEl.getStrategy());
            response.setSelector(cachedEl.getSelector());
            response.setId(cachedEl.getId());
        }
        return response;
    }

    public ExecuteResponse executeElementCommand(String elementId, String methodName, Object[] args, boolean skipScreenshotAndSource) throws ServletException {
        return execute(elementId, methodName, args, skipScreenshotAndSource);
    }

    public ExecuteResponse executeMethod(String methodName, Object[] args, boolean skipScreenshotAndSource) throws ServletException {
        return execute(null, methodName, args, skipScreenshotAndSource);
    }

    private SourceAndScreenshot getSourceAndScreenshot() {
        String source = null;
        String sourceError = null;
        String screenshot = null;
        String screenshotError = null;
        Dimension windowSize = null;
        String windowSizeError = null;

        try {
            source = this.webDriver.getPageSource();
        } catch (Exception e) {
            sourceError = e.getMessage();
        }

        try {
            screenshot = this.webDriver.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            screenshotError = e.getMessage();
        }

        try {
            windowSize = this.webDriver.manage().window().getSize();
        } catch (Exception e) {
            windowSizeError = e.getMessage();
        }

        SourceAndScreenshot res = new SourceAndScreenshot();
        res.setSource(source);
        res.setSourceError(sourceError);
        res.setScreenshot(screenshot);
        res.setScreenshotError(screenshotError);
        res.setWindowSize(windowSize);
        res.setWindowSizeError(windowSizeError);
        return res;
    }

    public SessionDetails getSessionDetails() {
        SessionDetails sessionDetails = new SessionDetails();
        sessionDetails.setDesiredCapabilities(webDriver.getCapabilities().asMap());
        if (webDriver.isMobile()) {
            sessionDetails.setSessionDetails(webDriver.getAppiumDriver().getSessionDetails());

            URL remoteAddress = webDriver.getAppiumDriver().getRemoteAddress();
            sessionDetails.setHost(remoteAddress.getHost());
            sessionDetails.setPort(remoteAddress.getPort());
            sessionDetails.setPath(remoteAddress.getPath());
            sessionDetails.setHttps(remoteAddress.getProtocol().equals("https"));
        }
        return sessionDetails;
    }

    public void restart() {
        // Clear the variable names and start over (el1, el2, els1, els2, etc...)
        this.elementCache.clear();

        // Restart the variable counter
        this.elVariableCounter = 1;
        this.elArrayVariableCounter = 1;

        this.executionState = ExecutionState.PAUSED;
        this.stepMode = StepMode.STEP_NEXT_BREAKPOINT;
    }

    public void close(String reason, boolean killedByUser) {
        this.executionState = ExecutionState.STOPPED;
    }

    private void applyMethod(Object obj, String methodName, Object[] args) throws ServletException {
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName) && method.getParameterCount() == (args == null ? 0 : args.length)) {
                try {
                    method.invoke(obj, args);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new ServletException(e);
                }
                break;
            }
        }
    }

    public ExecutionState getExecutionState() {
        return executionState;
    }

    public StepMode getStepMode() {
        return stepMode;
    }
}
