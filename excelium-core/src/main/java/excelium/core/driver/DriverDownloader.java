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

import excelium.model.enums.Platform;
import excelium.model.test.config.PcEnvironment;
import excelium.progressbar.ProgressBar;
import excelium.progressbar.ProgressBarStyle;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Downloader that downloads web driver.
 *
 * @author PhungDucKien
 * @since 2018.05.05
 */
class DriverDownloader {

    /**
     * Size of the buffer
     */
    private static final int BUFFER_SIZE = 1024;

    /**
     * Download web driver for pc browsers.
     *
     * @param environment the environment
     * @param driverPath  the driver path
     * @throws IOException the io exception
     */
    static void downloadPcDriver(PcEnvironment environment, String driverPath) throws IOException {
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
    private static void downloadChromeDriver(Platform platform, String driverPath) throws IOException {
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

        downloadAndExtract("https://chromedriver.storage.googleapis.com/" + latestRelease + "/" + fileName,
                fileName, extractFileName, driverPath);
    }

    /**
     * Download Gecko web driver.
     *
     * @param platform   the platform
     * @param driverPath the driver path
     * @throws IOException the io exception
     */
    private static void downloadGeckoDriver(Platform platform, String driverPath) throws IOException {
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

        downloadAndExtract("https://github.com/mozilla/geckodriver/releases/download/"+ latestTag + "/" + fileName,
                fileName, extractFileName, driverPath);
    }

    /**
     * Download Opera web driver.
     *
     * @param platform   the platform
     * @param driverPath the driver path
     * @throws IOException the io exception
     */
    private static void downloadOperaDriver(Platform platform, String driverPath) throws IOException {
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

        downloadAndExtract("https://github.com/operasoftware/operachromiumdriver/releases/download/" + latestTag + "/" + fileName,
                fileName, extractFileName, driverPath);
    }

    /**
     * Get Github latest tag.
     *
     * @param repository the Github repository
     * @return Github latest tag
     * @throws IOException the io exception
     */
    private static String getGithubLatestTag(String repository) throws IOException {
        URL obj = new URL("https://github.com/" + repository + "/releases/latest");
        URLConnection conn = obj.openConnection();
        conn.getHeaderFields();
        String tagUrl = conn.getURL().getPath();
        return tagUrl.substring(tagUrl.lastIndexOf("/") + 1);
    }

    /**
     * Read string from an URL.
     *
     * @param requestURL the request URL
     * @return the URL content
     * @throws IOException the io exception
     */
    private static String readStringFromURL(String requestURL) throws IOException {
        try (InputStream is = new URL(requestURL).openStream();
             Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    /**
     * Download the archive file and extract the desired file to the specified path.
     *
     * @param downloadUrl     the download URL
     * @param fileName        the archive file name
     * @param extractFileName the file name to extract
     * @param path            the path to save
     * @throws IOException the io exception
     */
    private static void downloadAndExtract(String downloadUrl, String fileName, String extractFileName, String path) throws IOException {
        byte[] data = new byte[BUFFER_SIZE];

        URL url = new URL(downloadUrl);
        URLConnection connection = url.openConnection();
        connection.connect();

        int contentLength = connection.getContentLength();

        try (InputStream is = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(is);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            ProgressBar pb = new ProgressBar(fileName, contentLength, 500, ProgressBarStyle.ASCII);
            pb.start();

            int dataRead;
            while ((dataRead = bis.read(data, 0, BUFFER_SIZE)) > 0) {
                os.write(data, 0, dataRead);
                pb.stepBy(dataRead);
            }

            os.flush();
            pb.stop();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(os.toByteArray())) {
                if (fileName.endsWith(".tar.gz")) {
                    extractTarGz(bais, extractFileName, path);
                } else {
                    extractZip(bais, extractFileName, path);
                }
            }
        }
    }

    /**
     * Extract the desired file archived in a Zip file to the specified path.
     *
     * @param is              the Zip file InputStream
     * @param extractFileName the file name to extract
     * @param path            the path to save
     * @throws IOException the io exception
     */
    private static void extractZip(InputStream is, String extractFileName, String path) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (!entry.isDirectory() && entry.getName().equals(extractFileName)) {
                    try (FileOutputStream fos = new FileOutputStream(path)) {
                        IOUtils.copy(zis, fos);
                    }
                    System.out.println("Extracted " + extractFileName + " to " + path);
                    break;
                }
            }
            zis.closeEntry();
        }
    }

    /**
     * Extract the desired file archived in a Tar Gz file to the specified path.
     *
     * @param is              the Tar Gz file InputStream
     * @param extractFileName the file name to extract
     * @param path            the path to save
     * @throws IOException the io exception
     */
    private static void extractTarGz(InputStream is, String extractFileName, String path) throws IOException {
        try (GzipCompressorInputStream gzipIn = new GzipCompressorInputStream(is);
             TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
            ArchiveEntry entry;

            while ((entry = tarIn.getNextEntry()) != null) {
                if (!entry.isDirectory() && entry.getName().equals(extractFileName)) {
                    try (FileOutputStream fos = new FileOutputStream(path)) {
                        IOUtils.copy(tarIn, fos);
                    }
                    System.out.println("Extracted " + extractFileName + " to " + path);
                    break;
                }
            }
        }
    }
}
