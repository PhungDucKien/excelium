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

package excelium.core;

import excelium.core.driver.ContextAwareWebDriver;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

/**
 * Tests for {@link CommandExecutor}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class CommandExecutorTest {

    @Mocked
    private ContextAwareWebDriver webDriver;

    @Mocked
    private Excelium excelium;

    @Test
    public void testRunAction_OK() throws Exception {
        CommandExecutor executor = new CommandExecutor(webDriver, null, excelium, null);

        new Expectations() {{
            excelium.runAction((String) any);
        }};

        executor.runAction(null);
    }

    @Test(expected = Exception.class)
    public void testRunAction_NG() throws Exception {
        CommandExecutor executor = new CommandExecutor(webDriver, null, excelium, null);

        new Expectations() {{
            excelium.runAction((String) any); result = new Exception();
        }};

        executor.runAction(null);
    }

    @Test(expected = Exception.class)
    public void testRunAction_ExceliumNull() throws Exception {
        CommandExecutor executor = new CommandExecutor(webDriver, null, null, null);
        executor.runAction(null);
    }
}
