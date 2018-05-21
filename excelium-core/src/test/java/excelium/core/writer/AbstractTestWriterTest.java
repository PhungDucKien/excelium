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

package excelium.core.writer;

import excelium.model.enums.Result;
import excelium.model.project.Template;
import excelium.model.test.TestStep;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Tests for {@link AbstractTestWriter}.
 *
 * @author PhungDucKien
 * @since 2018.05.16
 */
public class AbstractTestWriterTest {

    @Test
    public void testWriteResult() throws IOException {
        Date fake = new Date(2018,0,1);
        new MockUp<System>(){
            @Mock
            public long currentTimeMillis() {
                return fake.getTime();
            }
        };

        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put(Template.TEST_DATE, "Sheet1!A2");
        markupLocations.put(Template.TEST_PERSON, "Sheet1!B3");
        markupLocations.put(Template.TEST_RESULT, "Sheet1!C4");
        template.setMarkupLocations(markupLocations);

        TestStep testStep = new TestStep();
        testStep.setRowIndex(3 * 10);

        MyTestWriter testWriter = new MyTestWriter();
        testWriter.writeResult(template, "Sheet2", testStep, Result.OK);

        Assert.assertEquals(3, testWriter.flushValues.size());
        Assert.assertEquals(fake, testWriter.flushValues.get("Sheet2!A32").get(0).get(0));
        Assert.assertEquals(System.getProperty("user.name"), testWriter.flushValues.get("Sheet2!B33").get(0).get(0));
        Assert.assertEquals("OK", testWriter.flushValues.get("Sheet2!C34").get(0).get(0));
    }

    public static class MyTestWriter extends AbstractTestWriter {

        @Override
        public void flush() throws IOException {

        }
    }
}
