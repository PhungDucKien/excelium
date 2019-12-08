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

public class SourceAndScreenshot {
    private String source;
    private String sourceError;
    private String screenshot;
    private String screenshotError;
    private Dimension windowSize;
    private String windowSizeError;

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
}
