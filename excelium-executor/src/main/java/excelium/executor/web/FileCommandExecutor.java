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

import com.google.common.io.Resources;
import com.thoughtworks.selenium.SeleniumException;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * File related command executor.
 *
 * @author PhungDucKien
 * @since 2018.06.30
 */
public class FileCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new File command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public FileCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Sets a file input (upload) field to the file listed in fileLocator
     *
     * @param parentLocator an element locator of parent element
     * @param locator an element locator
     * @param fileLocator a URL pointing to the specified file. Before the file can be set in the
     *        input field (fieldLocator), Selenium RC may need to transfer the file to the local
     *        machine before attaching the file in a web page form. This is common in selenium grid
     *        configurations where the RC server driving the browser is not the same machine that
     *        started the test. Supported Browsers: Firefox ("*chrome") only.
     */
    public void attachFile(String parentLocator, String locator, String value) {
        File file = downloadFile(value);

        WebElement element = webDriver.findElement(parentLocator, locator);
        element.clear();
        element.sendKeys(file.getAbsolutePath());
    }

    private File downloadFile(String name) {
        URL url = getUrl(name);

        File dir = TemporaryFilesystem.getDefaultTmpFS().createTempDir("attachFile", "dir");
        File outputTo = new File(dir, new File(url.getFile()).getName());

        try (FileOutputStream fos = new FileOutputStream(outputTo)) {
            Resources.copy(url, fos);
        } catch (IOException e) {
            throw new SeleniumException("Can't access file to upload: " + url, e);
        }

        return outputTo;
    }

    private URL getUrl(String name) {
        try {
            return new URL(name);
        } catch (MalformedURLException e) {
            throw new SeleniumException("Malformed URL: " + name);
        }
    }
}
