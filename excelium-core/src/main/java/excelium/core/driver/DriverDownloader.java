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

package excelium.core.driver;

import excelium.core.Downloader;
import excelium.model.enums.Platform;
import excelium.model.test.config.PcEnvironment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Downloader that downloads web driver.
 *
 * @author PhungDucKien
 * @since 2018.05.05
 */
class DriverDownloader extends Downloader {

    /**
     * Download web driver for pc browsers.
     *
     * @param environment the environment
     * @param driverPath  the driver path
     * @throws IOException the io exception
     */
    void downloadPcDriver(PcEnvironment environment, String driverPath) throws IOException {
        Files.createDirectories(Paths.get(driverPath).getParent());

        switch (environment.getBrowser()) {
            case CHROME:
                downloadChromeDriver(environment.getPlatform(), driverPath);
                break;
            case FIREFOX:
                downloadGeckoDriver(environment.getPlatform(), driverPath);
                break;
            case IE:
            case EDGE:
                break;
            case OPERA:
                downloadOperaDriver(environment.getPlatform(), driverPath);
                break;
            case SAFARI:
        }

        // Set the driver executable
        if (environment.getPlatform() == Platform.MAC_OS || environment.getPlatform() == Platform.LINUX) {
            File driverFile = new File(driverPath);
            driverFile.setExecutable(true);
        }
    }

    /**
     * Download Chrome web driver.
     *
     * @param platform   the platform
     * @param driverPath the driver path
     * @throws IOException the io exception
     */
    private void downloadChromeDriver(Platform platform, String driverPath) throws IOException {
        String latestRelease = readStringFromURL("https://chromedriver.storage.googleapis.com/LATEST_RELEASE");
        String fileName = null;
        String extractFileName = null;
        switch (platform) {
            case WINDOWS_32:
            case WINDOWS_64:
                fileName = "chromedriver_win32.zip";
                extractFileName = "chromedriver.exe";
                break;
            case MAC_OS:
                fileName = "chromedriver_mac64.zip";
                extractFileName = "chromedriver";
                break;
            case LINUX:
                fileName = "chromedriver_linux64.zip";
                extractFileName = "chromedriver";
                break;
        }

        downloadAndExtract("https://chromedriver.storage.googleapis.com/" + latestRelease + "/" + fileName, extractFileName, driverPath);
    }

    /**
     * Download Gecko web driver.
     *
     * @param platform   the platform
     * @param driverPath the driver path
     * @throws IOException the io exception
     */
    private void downloadGeckoDriver(Platform platform, String driverPath) throws IOException {
        String latestTag = getGithubLatestTag("mozilla/geckodriver");
        String fileName = null;
        String extractFileName = null;
        switch (platform) {
            case WINDOWS_32:
                fileName = "geckodriver-" + latestTag + "-win32.zip";
                extractFileName = "geckodriver.exe";
                break;
            case WINDOWS_64:
                fileName = "geckodriver-" + latestTag + "-win64.zip";
                extractFileName = "geckodriver.exe";
                break;
            case MAC_OS:
                fileName = "geckodriver-" + latestTag + "-macos.tar.gz";
                extractFileName = "geckodriver";
                break;
            case LINUX:
                fileName = "geckodriver-" + latestTag + "-linux64.tar.gz";
                extractFileName = "geckodriver";
                break;
        }

        downloadAndExtract("https://github.com/mozilla/geckodriver/releases/download/" + latestTag + "/" + fileName, extractFileName, driverPath);
    }

    /**
     * Download Opera web driver.
     *
     * @param platform   the platform
     * @param driverPath the driver path
     * @throws IOException the io exception
     */
    private void downloadOperaDriver(Platform platform, String driverPath) throws IOException {
        String latestTag = getGithubLatestTag("operasoftware/operachromiumdriver");
        String fileName = null;
        String extractFileName = null;
        switch (platform) {
            case WINDOWS_32:
                fileName = "operadriver_win32.zip";
                extractFileName = "operadriver_win32/operadriver.exe";
                break;
            case WINDOWS_64:
                fileName = "operadriver_win64.zip";
                extractFileName = "operadriver_win64/operadriver.exe";
                break;
            case MAC_OS:
                fileName = "operadriver_mac64.zip";
                extractFileName = "operadriver_mac64/operadriver";
                break;
            case LINUX:
                fileName = "operadriver_linux64.zip";
                extractFileName = "operadriver_linux64/operadriver";
                break;
        }

        downloadAndExtract("https://github.com/operasoftware/operachromiumdriver/releases/download/" + latestTag + "/" + fileName, extractFileName, driverPath);
    }
}
