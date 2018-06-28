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

package excelium.doclet;

import com.sun.javadoc.*;
import excelium.core.TestRunner;
import excelium.core.command.CommandFactory;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.test.command.Command;
import excelium.model.test.config.Environment;
import mockit.*;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Tests for {@link MyDoclet}.
 *
 * @author PhungDucKien
 * @since 2018.06.28
 */
public class MyDocletTest {

    @Mocked
    private RootDoc rootDoc;

    @Mocked
    private ClassDoc classDoc;

    @Injectable
    private MethodDoc methodDoc1;

    @Injectable
    private MethodDoc methodDoc2;

    @Injectable
    private AnnotationDesc annotationDesc1;

    @Injectable
    private AnnotationDesc annotationDesc2;

    @Injectable
    private AnnotationTypeDoc typeDoc1;

    @Injectable
    private AnnotationTypeDoc typeDoc2;

    @Injectable
    private ParamTag paramTag1;

    @Injectable
    private ParamTag paramTag2;

    @AfterClass
    public static void afterClass() throws IOException {
        Files.delete(Paths.get("build/docs/_web_api.md"));
        Files.delete(Paths.get("build/docs/_mobile_api.md"));
        Files.delete(Paths.get("build/docs"));
        Files.delete(Paths.get("build"));
    }

    @Test
    public void testStart() throws IOException {
        String[][] options = new String[1][];
        options[0] = new String[2];
        options[0][0] = "-d";
        options[0][1] = "build/docs";

        new Expectations() {{
            rootDoc.options(); result = options;
            rootDoc.classes(); result = new ClassDoc[] { classDoc };

            classDoc.methods(); result = new MethodDoc[] { methodDoc1, methodDoc2 };

            typeDoc1.qualifiedName(); result = "excelium.core.command.Action";
            typeDoc2.qualifiedName(); result = "excelium.core.command.Accessor";

            annotationDesc1.annotationType(); result = typeDoc1;
            annotationDesc2.annotationType(); result = typeDoc2;

            paramTag1.parameterName(); result = "action";
            paramTag1.parameterComment(); result = "the action";
            paramTag2.parameterName(); result = "locator";
            paramTag2.parameterComment(); result = "the locator";

            methodDoc1.name(); result = "executeAction";
            methodDoc1.commentText(); result = "Execute action.";
            methodDoc1.annotations(); result = new AnnotationDesc[] { annotationDesc1 };
            methodDoc1.paramTags(); result = new ParamTag[] { paramTag1 };
            methodDoc1.parameters(); result = new Parameter[1];

            methodDoc2.name(); result = "getValue";
            methodDoc2.commentText(); result = "Return the value of text box.";
            methodDoc2.annotations(); result = new AnnotationDesc[] { annotationDesc2 };
            methodDoc2.paramTags(); result = new ParamTag[] { paramTag2 };
            methodDoc2.parameters(); result = new Parameter[1];
        }};

        new MockUp<CommandFactory>() {
            @Mock
            Map<String, Command> createCommandMap(Environment environment, ContextAwareWebDriver webDriver, String baseUrl, TestRunner testRunner) {
                Map<String, Command> commandMap = new HashMap<>();

                Command command = new Command();
                command.setName("Execute Action");
                command.setMethod("executeAction");
                command.setSourceMethodKey("executeAction(1)");
                command.setParam1("action");
                commandMap.put("executeAction(1)", command);

                command = new Command();
                command.setName("Store Value");
                command.setMethod("storeValue");
                command.setSourceMethodKey("getValue(1)");
                command.setParam1("locator");
                command.setParam2("variable");
                commandMap.put("storeValue(2)", command);

                command = new Command();
                command.setName("Wait For Value");
                command.setMethod("waitForValue");
                command.setSourceMethodKey("getValue(1)");
                command.setParam1("locator");
                command.setParam2("text");
                commandMap.put("waitForValue(2)", command);

                command = new Command();
                command.setName("Execute If Value");
                command.setMethod("executeIfValue");
                command.setSourceMethodKey("getValue(1)");
                command.setParam2("action");
                command.setParam2("locator");
                command.setParam3("text");
                commandMap.put("executeIfValue(2)", command);

                command = new Command();
                command.setName("Verify Value");
                command.setMethod("verifyValue");
                command.setSourceMethodKey("getValue(1)");
                command.setParam1("locator");
                command.setParam2("text");
                commandMap.put("verifyValue(2)", command);

                command = new Command();
                command.setName("Assert Value");
                command.setMethod("assertValue");
                command.setSourceMethodKey("getValue(1)");
                command.setParam1("locator");
                command.setParam2("text");
                commandMap.put("assertValue(2)", command);

                return commandMap;
            }
        };

        MyDoclet.start(rootDoc);

        Assert.assertEquals(FileUtils.checksumCRC32(new File("build/docs/_web_api.md")),
                FileUtils.checksumCRC32(new File(MyDocletTest.class.getClassLoader().getResource("_web_api.md").getPath())));
        Assert.assertEquals(FileUtils.checksumCRC32(new File("build/docs/_mobile_api.md")),
                FileUtils.checksumCRC32(new File(MyDocletTest.class.getClassLoader().getResource("_mobile_api.md").getPath())));
    }
}
