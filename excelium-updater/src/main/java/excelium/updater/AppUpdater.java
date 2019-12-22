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

package excelium.updater;

import excelium.common.Prompt;
import excelium.common.Version;
import excelium.core.Downloader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppUpdater extends Downloader {

    private static final Logger LOG = LogManager.getLogger();

    public boolean checkVersion() throws IOException {
        String latestTag = Version.VERSION;
        try {
            latestTag = getGithubLatestTag("PhungDucKien/excelium");
        } catch (IOException e) {
            LOG.error("Update check failed. Please check your network connection.");
        }

        boolean isLatest = Version.VERSION.equals(latestTag);
        if (!isLatest && !latestTag.equals("latest")) {
            boolean agree = Prompt.promptConfirm("Excelium " + latestTag + " is now available. Do you want to download the new version?");
            if (agree) {
                return updateToVersion(latestTag);
            }
        }
        return false;
    }

    private boolean updateToVersion(String version) {
        String appHome = System.getProperty("app.home");
        if (StringUtils.isBlank(appHome)) {
            appHome = System.getProperty("user.dir");
        }

        try {
            Path tempDir = Files.createTempDirectory("lib");
            downloadAndExtract("https://github.com/PhungDucKien/excelium/releases/download/" + version + "/excelium-" + version + ".zip", "lib/", tempDir.toFile().getAbsolutePath());

            FileUtils.deleteDirectory(new File(appHome + File.separator + "lib/"));
            FileUtils.moveDirectory(tempDir.toFile(), new File(appHome + File.separator + "lib/"));

            return true;
        } catch (IOException e) {
            LOG.error("Update failed. " + e.getLocalizedMessage());
        }
        return false;
    }
}
