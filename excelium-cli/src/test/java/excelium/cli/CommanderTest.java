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

package excelium.cli;

import com.beust.jcommander.JCommander;
import excelium.cli.annotation.Bean;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.cli.controller.BaseController;
import excelium.model.project.Project;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link Commander}.
 *
 * @author PhungDucKien
 * @since 2018.04.20
 */
public class CommanderTest {

    @Mocked
    private DefaultController defaultController;

    @Mocked
    private NonDefaultController nonDefaultController;

    @Test
    public void testRegisterControllers() throws InstantiationException, IllegalAccessException {
        Commander commander = new Commander();
        commander.registerControllers(DefaultController.class, NonDefaultController.class);

        Map<String, BaseController> controllerObjects = Deencapsulation.getField(commander, "controllerObjects");
        Assert.assertEquals(2, controllerObjects.size());
        Assert.assertTrue(controllerObjects.get("DEFAULT_OBJECT") instanceof DefaultController);
        Assert.assertTrue(controllerObjects.get("cmd") instanceof NonDefaultController);

        List mainObjects = Deencapsulation.getField(commander, "objects");
        Assert.assertEquals(1, mainObjects.size());
        Assert.assertTrue(mainObjects.get(0) instanceof DefaultController);

        Map<String, JCommander> mainCommands = commander.getCommands();
        Assert.assertEquals(1, mainCommands.size());

        JCommander ndCommander = mainCommands.get("cmd");

        List ndObjects = Deencapsulation.getField(ndCommander, "objects");
        Assert.assertEquals(1, ndObjects.size());
        Assert.assertTrue(ndObjects.get(0) instanceof NonDefaultController);

        Map<String, JCommander> ndCommands = Deencapsulation.getField(ndCommander, "commands");
        Assert.assertEquals(2, ndCommands.size());
    }

    @Test
    public void testRegisterBeanFactory() throws InstantiationException, IllegalAccessException {
        Commander commander = new Commander();
        commander.registerBeanFactory(MyBeanFactory.class);

        Object beanFactoryObject = Deencapsulation.getField(commander, "beanFactoryObject");
        Assert.assertTrue(beanFactoryObject instanceof MyBeanFactory);

        Map<Class, Method> beanMethodMap = Deencapsulation.getField(commander, "beanMethodMap");
        Assert.assertEquals(2, beanMethodMap.size());
        Assert.assertEquals("myProject", beanMethodMap.get(Project.class).getName());
        Assert.assertEquals("myGoogleConnection", beanMethodMap.get(GoogleConnection.class).getName());
    }

    @Test
    public void testExecuteDefault() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Commander commander = new Commander();
        commander.registerControllers(DefaultController.class, NonDefaultController.class);
        commander.registerBeanFactory(MyBeanFactory.class);
        commander.execute();

        Map<String, BaseController> controllerObjects = Deencapsulation.getField(commander, "controllerObjects");
        Assert.assertNotNull(Deencapsulation.getField(controllerObjects.get("DEFAULT_OBJECT"), "myGoogleConnection"));
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("cmd"), "myGoogleConnection"));

        new Verifications() {{
            defaultController.defaultCommand();
        }};
    }

    @Test
    public void testExecuteNonDefaultDefault() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Commander commander = new Commander();
        commander.registerControllers(DefaultController.class, NonDefaultController.class);
        commander.registerBeanFactory(MyBeanFactory.class);
        commander.execute("cmd");

        Map<String, BaseController> controllerObjects = Deencapsulation.getField(commander, "controllerObjects");
        Assert.assertNotNull(Deencapsulation.getField(controllerObjects.get("cmd"), "myGoogleConnection"));
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("DEFAULT_OBJECT"), "myGoogleConnection"));

        new Verifications() {{
            nonDefaultController.defaultCommand();
        }};
    }

    @Test
    public void testExecuteNonDefaultSub() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Commander commander = new Commander();
        commander.registerControllers(DefaultController.class, NonDefaultController.class);
        commander.registerBeanFactory(MyBeanFactory.class);
        commander.execute("cmd", "sub");

        Map<String, BaseController> controllerObjects = Deencapsulation.getField(commander, "controllerObjects");
        Assert.assertNotNull(Deencapsulation.getField(controllerObjects.get("cmd"), "myGoogleConnection"));
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("DEFAULT_OBJECT"), "myGoogleConnection"));

        new Verifications() {{
            nonDefaultController.subCommand();
        }};
    }

    @Test
    public void testExecuteDefaultHelp() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        new Expectations() {{
            defaultController.isHelp();
            result = true;
        }};

        Commander commander = new Commander();
        commander.registerControllers(DefaultController.class, NonDefaultController.class);
        commander.registerBeanFactory(MyBeanFactory.class);
        commander.execute("-h");

        Map<String, BaseController> controllerObjects = Deencapsulation.getField(commander, "controllerObjects");
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("DEFAULT_OBJECT"), "myGoogleConnection"));
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("cmd"), "myGoogleConnection"));

        new Verifications() {{
            defaultController.defaultCommand(); times = 0;
        }};
    }

    @Test
    public void testExecuteNonDefaultHelp() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        new Expectations() {{
            nonDefaultController.isHelp();
            result = true;
        }};

        Commander commander = new Commander();
        commander.registerControllers(DefaultController.class, NonDefaultController.class);
        commander.registerBeanFactory(MyBeanFactory.class);
        commander.execute("cmd", "-h");

        Map<String, BaseController> controllerObjects = Deencapsulation.getField(commander, "controllerObjects");
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("cmd"), "myGoogleConnection"));
        Assert.assertNull(Deencapsulation.getField(controllerObjects.get("DEFAULT_OBJECT"), "myGoogleConnection"));

        new Verifications() {{
            nonDefaultController.defaultCommand(); times = 0;
        }};
    }

    @Controller
    public static class DefaultController extends BaseController {

        @Injectable
        GoogleConnection myGoogleConnection;

        @Injectable
        GoogleConnection myGoogleConnection2;

        @Command
        public void defaultCommand() {}
    }

    @Controller(name = "cmd")
    public static class NonDefaultController extends BaseController {

        @Injectable
        GoogleConnection myGoogleConnection;

        @Command
        public void defaultCommand() {}

        @Command(name = "sub")
        public void subCommand() {}
    }

    public static class MyBeanFactory {

        @Bean
        public Project myProject() {
            return new Project();
        }

        @Bean
        public GoogleConnection myGoogleConnection() {
            return new GoogleConnectionService();
        }
    }
}
