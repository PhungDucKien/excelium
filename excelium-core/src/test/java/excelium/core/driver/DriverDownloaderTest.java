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

import excelium.model.enums.Browser;
import excelium.model.enums.Platform;
import excelium.model.test.config.PcEnvironment;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tests for {@link DriverDownloader}.
 *
 * @author PhungDucKien
 * @since 2018.05.06
 */
public class DriverDownloaderTest {

    @Test
    public void testDownloadChromeWin32Driver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environment.setPlatform(Platform.WINDOWS_32);

        String driverPath = "driver/chrome_win_32";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadChromeWin64Driver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environment.setPlatform(Platform.WINDOWS_64);

        String driverPath = "driver/chrome_win_64";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadChromeMacDriver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environment.setPlatform(Platform.MAC_OS);

        String driverPath = "driver/chrome_mac";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadChromeLinuxDriver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.CHROME);
        environment.setPlatform(Platform.LINUX);

        String driverPath = "driver/chrome_linux";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadFirefoxWin32Driver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.FIREFOX);
        environment.setPlatform(Platform.WINDOWS_32);

        String driverPath = "driver/firefox_win_32";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadFirefoxWin64Driver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.FIREFOX);
        environment.setPlatform(Platform.WINDOWS_64);

        String driverPath = "driver/firefox_win_64";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadFirefoxMacDriver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.FIREFOX);
        environment.setPlatform(Platform.MAC_OS);

        String driverPath = "driver/firefox_mac";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadFirefoxLinuxDriver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.FIREFOX);
        environment.setPlatform(Platform.LINUX);

        String driverPath = "driver/firefox_linux";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadOperaWin32Driver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.OPERA);
        environment.setPlatform(Platform.WINDOWS_32);

        String driverPath = "driver/opera_win_32";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadOperaWin64Driver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.OPERA);
        environment.setPlatform(Platform.WINDOWS_64);

        String driverPath = "driver/opera_win_64";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadOperaMacDriver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.OPERA);
        environment.setPlatform(Platform.MAC_OS);

        String driverPath = "driver/opera_mac";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }

    @Test
    public void testDownloadOperaLinuxDriver() throws IOException {
        PcEnvironment environment = new PcEnvironment();
        environment.setBrowser(Browser.OPERA);
        environment.setPlatform(Platform.LINUX);

        String driverPath = "driver/opera_linux";

        DriverDownloader.downloadPcDriver(environment, driverPath);

        Path driver = Paths.get(driverPath);
        Assert.assertTrue(Files.exists(driver));
        Files.delete(driver);
    }
}
