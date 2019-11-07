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

package excelium.common;

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.prompt.ConfirmResult;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import excelium.model.enums.WorkbookType;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for {@link Prompt}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class PromptTest {

    @Mocked
    ConsolePrompt consolePrompt = new ConsolePrompt();

    @Test
    public void testPromptInput() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); result = new HashMap<String, InputResult>() {{ put("", new InputResult("result")); }};
        }};

        Assert.assertEquals("result", Prompt.promptInput("Question", null));
    }

    @Test
    public void testPromptStringArray() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); result = new HashMap<String, ListResult>() {{ put("", new ListResult("result")); }};
        }};

        Assert.assertEquals("result", Prompt.promptList("Question", new String[]{"result", "desc"}));
    }

    @Test
    public void testPromptList() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); result = new HashMap<String, ListResult>() {{ put("", new ListResult("result")); }};
        }};

        List<String> options = new ArrayList<>();
        options.add("result");

        Assert.assertEquals("result", Prompt.promptList("Question", options));
    }

    @Test
    public void testPromptConfirm() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); result = new HashMap<String, ConfirmResult>() {{ put("", new ConfirmResult(ConfirmChoice.ConfirmationValue.YES)); }};
        }};

        Assert.assertEquals(true, Prompt.promptConfirm("Question"));
    }

    @Test
    public void testPromptFileLocationExcel() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); result = new HashMap<String, ListResult>() {{ put("", new ListResult("result")); }};
        }};

        Path basePath = Paths.get("myproject");
        Files.createDirectories(basePath);

        Assert.assertEquals("myproject/result", Prompt.promptFileLocation(WorkbookType.EXCEL, basePath,"Question", null));

        Files.delete(basePath);
    }

    @Test
    public void testPromptFileLocationSheets() throws Exception {
        new Expectations() {{
            consolePrompt.prompt((List<PromptableElementIF>) any); result = new HashMap<String, InputResult>() {{ put("", new InputResult("result")); }};
        }};

        Assert.assertEquals("result", Prompt.promptFileLocation(WorkbookType.SHEETS, null, null,"Question"));
    }
}
