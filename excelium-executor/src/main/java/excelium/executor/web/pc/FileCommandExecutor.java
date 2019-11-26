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

package excelium.executor.web.pc;

import com.google.common.io.Resources;
import com.thoughtworks.selenium.SeleniumException;
import excelium.common.WildcardUtil;
import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.AssertFailedException;
import excelium.model.project.Project;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

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
     * @param locator       an element locator
     * @param filePath      a path or a URL pointing to the specified file.
     */
    @Action(param1 = "parentLocator", param2 = "locator", param3 = "filePath")
    public void attachFile(String parentLocator, String locator, String filePath) {
        File file = downloadFile(filePath);

        WebElement element = webDriver.findElement(parentLocator, locator);
        element.clear();
        element.sendKeys(file.getAbsolutePath());
    }

    /**
     * Determines whether a file is downloaded by browser.
     *
     * @param filePattern the file name pattern
     * @return true if a file is downloaded, false otherwise
     */
    @Accessor(param1 = "filePattern")
    public boolean isFileDownloaded(String filePattern) throws IOException {
        long matchCount = Files.walk(project.getDownloadPath())
                .filter(path -> WildcardUtil.isMatch(path.toFile().getName(), filePattern))
                .count();
        return matchCount > 0;
    }

    /**
     * Verifies the first line of the file equals to the given text.
     * This method is useful for testing CSV file's header.
     *
     * @param filePattern the file name pattern
     * @param charset     the charset
     * @param text        the text to compare
     * @throws AssertFailedException if the first line of the file doesn't equal to the given text
     */
    @Action(param1 = "filePattern", param2 = "charset", param3 = "text")
    public void verifyFileFirstLine(String filePattern, String charset, String text) throws Exception {
        Optional<Path> filePath = Files.walk(project.getDownloadPath())
                .filter(path -> WildcardUtil.isMatch(path.toFile().getName(), filePattern))
                .findFirst();

        if (filePath.isPresent()) {
            Stream<String> lines = Files.lines(filePath.get(), Charset.forName(charset));
            String header = lines.findFirst().get().replace("\uFEFF", "");
            if (!header.equals(text)) {
                throw new AssertFailedException("Actual header '" + header + "' did not match '" + text + "'");
            }
        }
    }

    /**
     * Verifies the contents of the file contains the given text.
     * This method is useful for testing CSV file's contents.
     *
     * @param filePattern the file name pattern
     * @param charset     the charset
     * @param text        the text to compare
     * @throws AssertFailedException if the contents of the file doesn't contain the given text
     */
    @Action(param1 = "filePattern", param2 = "charset", param3 = "text")
    public void verifyFileContainLine(String filePattern, String charset, String text) throws Exception {
        Optional<Path> filePath = Files.walk(project.getDownloadPath())
                .filter(path -> WildcardUtil.isMatch(path.toFile().getName(), filePattern))
                .findFirst();

        if (filePath.isPresent()) {
            Stream<String> lines = Files.lines(filePath.get(), Charset.forName(charset));
            if (lines.noneMatch(l -> l.replace("\uFEFF", "").equals(text))) {
                throw new AssertFailedException("Actual file did not contain '" + text + "'");
            }
        }
    }

    /**
     * Deletes downloaded files.
     *
     * @param filePattern the file name pattern
     */
    @Action(param1 = "filePattern")
    public void deleteDownloadedFile(String filePattern) throws Exception {
        Files.walk(project.getDownloadPath())
                .filter(path -> WildcardUtil.isMatch(path.toFile().getName(), filePattern))
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException e) {
                        throw new SeleniumException("Can't delete downloaded file: " + path.getFileName(), e);
                    }
                });
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
            try {
                return project.getFilePath().resolve(name).toUri().toURL();
            } catch (MalformedURLException e1) {
                throw new SeleniumException("Malformed URL: " + name);
            }
        }
    }
}
