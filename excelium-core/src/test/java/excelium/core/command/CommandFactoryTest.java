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

package excelium.core.command;

import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.exception.AssertFailedException;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import excelium.model.test.command.Command;
import excelium.model.test.command.TriConsumer;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Tests for {@link CommandFactory}.
 *
 * @author PhungDucKien
 * @since 2018.05.18
 */
public class CommandFactoryTest {

    @Injectable
    private TriConsumer triConsumer;

    @Mocked
    private Excelium excelium;

    @Test
    public void testCreateActionCommandMap() throws Exception {
        List<CommandExecutor> commandExecutors = new ArrayList<>();
        commandExecutors.add(new MyActionCommandExecutor(null, null, excelium, null));

        Map<String, Command> commandMap = CommandFactory.createCommandMap(commandExecutors);

        Assert.assertEquals(9, commandMap.size());
        Assert.assertEquals("locator", commandMap.get("click(1)").getParam1());

        Assert.assertEquals("parentLocator", commandMap.get("click(2)").getParam1());
        Assert.assertEquals("locator", commandMap.get("click(2)").getParam2());

        Assert.assertEquals("text", commandMap.get("input(2)").getParam1());
        Assert.assertEquals("locator", commandMap.get("input(2)").getParam2());

        Assert.assertEquals("text", commandMap.get("input(3)").getParam1());
        Assert.assertEquals("parentLocator", commandMap.get("input(3)").getParam2());
        Assert.assertEquals("locator", commandMap.get("input(3)").getParam3());

        Assert.assertEquals("", commandMap.get("close(0)").getParam1());

        Assert.assertEquals("text", commandMap.get("verifyText(2)").getParam1());
        Assert.assertEquals("locator", commandMap.get("verifyText(2)").getParam2());

        Assert.assertEquals("text", commandMap.get("verifyText(3)").getParam1());
        Assert.assertEquals("parentLocator", commandMap.get("verifyText(3)").getParam2());
        Assert.assertEquals("locator", commandMap.get("verifyText(3)").getParam3());

        Assert.assertEquals("text", commandMap.get("assertText(2)").getParam1());
        Assert.assertEquals("locator", commandMap.get("assertText(2)").getParam2());

        Assert.assertEquals("text", commandMap.get("assertText(3)").getParam1());
        Assert.assertEquals("parentLocator", commandMap.get("assertText(3)").getParam2());
        Assert.assertEquals("locator", commandMap.get("assertText(3)").getParam3());

        commandMap.get("click(1)").getConsumer().accept("id=1", null, null);
        new Verifications() {{
           triConsumer.accept(null, "id=1", null);
        }};

        commandMap.get("click(2)").getConsumer().accept("id=1", "id=2", null);
        new Verifications() {{
            triConsumer.accept("id=1", "id=2", null);
        }};

        commandMap.get("input(2)").getConsumer().accept("text", "id=1", null);
        new Verifications() {{
            triConsumer.accept("text", null, "id=1");
        }};

        commandMap.get("input(3)").getConsumer().accept("text", "id=1", "id=2");
        new Verifications() {{
            triConsumer.accept("text", "id=1", "id=2");
        }};

        commandMap.get("close(0)").getConsumer().accept(null, null, null);
        new Verifications() {{
            triConsumer.accept(null, null, null);
        }};

        commandMap.get("verifyText(2)").getConsumer().accept("text", "id=1", null);
        new Verifications() {{
            triConsumer.accept("text", null, "id=1");
        }};

        commandMap.get("verifyText(3)").getConsumer().accept("text", "id=1", "id=2");
        new Verifications() {{
            triConsumer.accept("text", "id=1", "id=2");
        }};
    }

    @Test
    public void testCreateAccessorCommandMap() throws Exception {
        ContextAwareWebDriver webDriver = new ContextAwareWebDriver(null, null, null);
        List<CommandExecutor> commandExecutors = new ArrayList<>();
        CommandExecutor executor = new MyAccessorCommandExecutor(webDriver, null, excelium, null);
        commandExecutors.add(executor);

        new Expectations() {{
            executor.runAction(anyString);
        }};

        Map<String, Command> commandMap = CommandFactory.createCommandMap(commandExecutors);

        Assert.assertEquals(63, commandMap.size());

        // Url test
        commandMap.get("storeUrl(1)").getConsumer().accept("var1", null, null);
        Assert.assertEquals("OK", webDriver.getVariable("var1"));
        new Verifications() {{
            triConsumer.accept(null, null, null);
        }};

        commandMap.get("verifyUrl(1)").getConsumer().accept("OK", null, null);

        try {
            commandMap.get("verifyUrl(1)").getConsumer().accept("NG", null, null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyNotUrl(1)").getConsumer().accept("NG", null, null);

        try {
            commandMap.get("verifyNotUrl(1)").getConsumer().accept("OK", null, null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyUrlMatch(1)").getConsumer().accept("^O", null, null);

        try {
            commandMap.get("verifyUrlMatch(1)").getConsumer().accept("O$", null, null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyUrlNotMatch(1)").getConsumer().accept("^N", null, null);

        try {
            commandMap.get("verifyUrlNotMatch(1)").getConsumer().accept("^O", null, null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("waitForUrl(1)").getConsumer().accept("OK", null, null);
        commandMap.get("waitForNotUrl(1)").getConsumer().accept("NG", null, null);
        commandMap.get("waitForUrlMatch(1)").getConsumer().accept("^O", null, null);
        commandMap.get("waitForUrlNotMatch(1)").getConsumer().accept("O$", null, null);

        commandMap.get("executeIfUrl(2)").getConsumer().accept("action1", "OK", null);
        new Verifications() {{
            executor.runAction("action1");
        }};

        commandMap.get("executeIfUrl(2)").getConsumer().accept("action2", "NG", null);
        new Verifications() {{
            executor.runAction("action2"); times = 0;
        }};

        commandMap.get("executeIfNotUrl(2)").getConsumer().accept("action3", "NG", null);
        new Verifications() {{
            executor.runAction("action3");
        }};

        commandMap.get("executeIfNotUrl(2)").getConsumer().accept("action4", "OK", null);
        new Verifications() {{
            executor.runAction("action4"); times = 0;
        }};

        commandMap.get("executeIfUrlMatch(2)").getConsumer().accept("action5", "^O", null);
        new Verifications() {{
            executor.runAction("action5");
        }};

        commandMap.get("executeIfUrlMatch(2)").getConsumer().accept("action6", "O$", null);
        new Verifications() {{
            executor.runAction("action6"); times = 0;
        }};

        commandMap.get("executeIfUrlNotMatch(2)").getConsumer().accept("action7", "^N", null);
        new Verifications() {{
            executor.runAction("action7");
        }};

        commandMap.get("executeIfUrlNotMatch(2)").getConsumer().accept("action8", "^O", null);
        new Verifications() {{
            executor.runAction("action8"); times = 0;
        }};

        // Parent locator and locator test
        commandMap.get("storeText(3)").getConsumer().accept("parentLocator", "locator", "var2");
        Assert.assertEquals("OK", webDriver.getVariable("var2"));
        new Verifications() {{
            triConsumer.accept("parentLocator", "locator", null);
        }};

        commandMap.get("verifyText(3)").getConsumer().accept("parentLocator", "locator","OK");

        try {
            commandMap.get("verifyText(3)").getConsumer().accept("parentLocator", "locator","NG");
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyNotText(3)").getConsumer().accept("parentLocator", "locator","NG");

        try {
            commandMap.get("verifyNotText(3)").getConsumer().accept("parentLocator", "locator","OK");
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyTextMatch(3)").getConsumer().accept("parentLocator", "locator","^O");

        try {
            commandMap.get("verifyTextMatch(3)").getConsumer().accept("parentLocator", "locator","O$");
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyTextNotMatch(3)").getConsumer().accept("parentLocator", "locator","^N");

        try {
            commandMap.get("verifyTextNotMatch(3)").getConsumer().accept("parentLocator", "locator","^O");
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("waitForText(3)").getConsumer().accept("parentLocator", "locator","OK");
        commandMap.get("waitForNotText(3)").getConsumer().accept("parentLocator", "locator","NG");
        commandMap.get("waitForTextMatch(3)").getConsumer().accept("parentLocator", "locator","^O");
        commandMap.get("waitForTextNotMatch(3)").getConsumer().accept("parentLocator", "locator","O$");

        // Locator only
        commandMap.get("storeText(2)").getConsumer().accept("locator", "var3", null);
        Assert.assertEquals("OK", webDriver.getVariable("var3"));
        new Verifications() {{
            triConsumer.accept(null, "locator", null);
        }};

        commandMap.get("verifyText(2)").getConsumer().accept("locator","OK", null);

        try {
            commandMap.get("verifyText(2)").getConsumer().accept("locator","NG", null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyNotText(2)").getConsumer().accept("locator","NG", null);

        try {
            commandMap.get("verifyNotText(2)").getConsumer().accept("locator","OK", null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyTextMatch(2)").getConsumer().accept("locator","^O", null);

        try {
            commandMap.get("verifyTextMatch(2)").getConsumer().accept("locator","O$", null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyTextNotMatch(2)").getConsumer().accept("locator","^N", null);

        try {
            commandMap.get("verifyTextNotMatch(2)").getConsumer().accept("locator","^O", null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("waitForText(2)").getConsumer().accept("locator","OK", null);
        commandMap.get("waitForNotText(2)").getConsumer().accept("locator","NG", null);
        commandMap.get("waitForTextMatch(2)").getConsumer().accept("locator","^O", null);
        commandMap.get("waitForTextNotMatch(2)").getConsumer().accept("locator","O$", null);

        commandMap.get("executeIfText(3)").getConsumer().accept("textAction1", "locator","OK");
        new Verifications() {{
            executor.runAction("textAction1");
        }};

        commandMap.get("executeIfText(3)").getConsumer().accept("textAction2", "locator","NG");
        new Verifications() {{
            executor.runAction("textAction2"); times = 0;
        }};

        commandMap.get("executeIfNotText(3)").getConsumer().accept("textAction3", "locator","NG");
        new Verifications() {{
            executor.runAction("textAction3");
        }};

        commandMap.get("executeIfNotText(3)").getConsumer().accept("textAction4", "locator","OK");
        new Verifications() {{
            executor.runAction("textAction4"); times = 0;
        }};

        commandMap.get("executeIfTextMatch(3)").getConsumer().accept("textAction5", "locator","^O");
        new Verifications() {{
            executor.runAction("textAction5");
        }};

        commandMap.get("executeIfTextMatch(3)").getConsumer().accept("textAction6", "locator","O$");
        new Verifications() {{
            executor.runAction("textAction6"); times = 0;
        }};

        commandMap.get("executeIfTextNotMatch(3)").getConsumer().accept("textAction7", "locator","^N");
        new Verifications() {{
            executor.runAction("textAction7");
        }};

        commandMap.get("executeIfTextNotMatch(3)").getConsumer().accept("textAction8", "locator","^O");
        new Verifications() {{
            executor.runAction("textAction8"); times = 0;
        }};

        // Color compare
        commandMap.get("storeColor(3)").getConsumer().accept("parentLocator", "locator", "var4");
        Assert.assertEquals(Color.fromString("#000000"), webDriver.getVariable("var4"));
        new Verifications() {{
            triConsumer.accept("parentLocator", "locator", null);
        }};

        commandMap.get("verifyColor(3)").getConsumer().accept("parentLocator", "locator", "#000000");

        try {
            commandMap.get("verifyColor(3)").getConsumer().accept("parentLocator", "locator", "#000001");
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyNotColor(3)").getConsumer().accept("parentLocator", "locator", "#000001");

        try {
            commandMap.get("verifyNotColor(3)").getConsumer().accept("parentLocator", "locator", "#000000");
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("storeColor(2)").getConsumer().accept( "locator", "var5", null);
        Assert.assertEquals(Color.fromString("#000000"), webDriver.getVariable("var5"));
        new Verifications() {{
            triConsumer.accept( null, "locator", null);
        }};

        commandMap.get("verifyColor(2)").getConsumer().accept( "locator", "#000000", null);

        try {
            commandMap.get("verifyColor(2)").getConsumer().accept( "locator", "#000001", null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }

        commandMap.get("verifyNotColor(2)").getConsumer().accept( "locator", "#000001", null);

        try {
            commandMap.get("verifyNotColor(2)").getConsumer().accept( "locator", "#000000", null);
            fail("AssertFailedException was not occured.");
        } catch (AssertFailedException e) {
        }
    }

        public class MyActionCommandExecutor extends CommandExecutor {
        public MyActionCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
            super(webDriver, baseUrl, excelium, project);
        }

        @Action
        public void close() throws Exception {
            triConsumer.accept(null, null, null);
        }

        @Action(param1 = "parentLocator", param2 = "locator")
        public void click(String parentLocator, String locator) throws Exception {
            triConsumer.accept(parentLocator, locator, null);
        }

        @Action(param1 = "text", param2 = "parentLocator", param3 = "locator")
        public void input(String text, String parentLocator, String locator) throws Exception {
            triConsumer.accept(text, parentLocator, locator);
        }

        @Action(param1 = "text", param2 = "parentLocator", param3 = "locator")
        public void verifyText(String text, String parentLocator, String locator) throws Exception {
            triConsumer.accept(text, parentLocator, locator);
        }
    }

    public class MyAccessorCommandExecutor extends CommandExecutor {

        public MyAccessorCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
            super(webDriver, baseUrl, excelium, project);
        }

        @Accessor
        public String getUrl() throws Exception {
            triConsumer.accept(null, null, null);
            return "OK";
        }

        @Accessor(param1 = "parentLocator", param2 = "locator")
        public String getText(String parentLocator, String locator) throws Exception {
            triConsumer.accept(parentLocator, locator, null);
            return "OK";
        }

        @Accessor(param1 = "parentLocator", param2 = "locator")
        public Color getColor(String parentLocator, String locator) throws Exception {
            triConsumer.accept(parentLocator, locator, null);
            return Color.fromString("black");
        }
    }
}
