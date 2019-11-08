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

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.prompt.ConfirmResult;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import excelium.common.Version;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class AppUpdaterTest {

    @Tested
    private AppUpdater appUpdater;

    @Mocked
    ConsolePrompt consolePrompt;

    @Test
    public void testWhenCurrentVersionIsLatest() throws IOException {
        new Expectations(appUpdater) {{
            appUpdater.getGithubLatestTag(anyString);
            result = Version.VERSION;
        }};

        Assert.assertFalse(appUpdater.checkVersion());
    }

    @Test
    public void testWhenNetworkDisabled() throws IOException {
        new Expectations(appUpdater) {{
            appUpdater.getGithubLatestTag(anyString);
            result = "latest";
        }};

        Assert.assertFalse(appUpdater.checkVersion());
    }

    @Test
    public void testNoWhenNewVersionAvailable() throws IOException {
        new Expectations(appUpdater) {{
            appUpdater.getGithubLatestTag(anyString);
            result = Version.VERSION + "-RELEASE";

            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ConfirmResult>() {{
                put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.NO));
            }};
        }};

        Assert.assertFalse(appUpdater.checkVersion());
    }

    @Test
    public void testFailedWhenNewVersionAvailable() throws IOException {
        new Expectations(appUpdater) {{
            appUpdater.getGithubLatestTag(anyString);
            result = Version.VERSION + "-RELEASE";

            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ConfirmResult>() {{
                put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES));
            }};

            appUpdater.download(anyString);
            result = new IOException();
        }};

        Assert.assertFalse(appUpdater.checkVersion());
    }

    @Test
    public void testOKWhenNewVersionAvailable() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(FileUtils.readFileToByteArray(Paths.get(getClass().getClassLoader().getResource("excelium.zip").getPath()).toFile()));
        baos.flush();

        new Expectations(appUpdater) {{
            appUpdater.getGithubLatestTag(anyString);
            result = Version.VERSION + "-RELEASE";

            consolePrompt.prompt((List<PromptableElementIF>) any);
            result = new HashMap<String, ConfirmResult>() {{
                put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES));
            }};

            appUpdater.download(anyString);
            result = baos;
        }};

        Assert.assertTrue(appUpdater.checkVersion());
    }
}
