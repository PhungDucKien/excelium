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

package excelium.core.context;

import mockit.Mock;
import mockit.MockUp;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Tests for {@link TestContext}.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class TestContextTest {

    @Test
    public void testReservedVariables() {
        new MockUp<LocalDate>() {
            @Mock
            LocalDate now() {
                return LocalDate.of(2018, 1, 1);
            }
        };

        new MockUp<LocalTime>() {
            @Mock
            LocalTime now() {
                return LocalTime.of(10, 10, 10);
            }
        };

        new MockUp<LocalDateTime>() {
            @Mock
            LocalDateTime now() {
                return LocalDateTime.of(2018, 1, 1, 10, 10, 10);
            }
        };

        TestContext testContext = new TestContext();
        JexlEngine jexl = new JexlBuilder().create();

        Assert.assertEquals(LocalDate.now(), jexl.createExpression("current_date").evaluate(testContext));
        Assert.assertEquals(LocalTime.now(), jexl.createExpression("CURRENT_TIME").evaluate(testContext));
        Assert.assertEquals(LocalDateTime.now(), jexl.createExpression("current_TIMESTAMP").evaluate(testContext));
    }

    @Test
    public void testFunctionNamespace() {
        new MockUp<LocalDate>() {
            @Mock
            LocalDate now() {
                return LocalDate.of(2018, 1, 1);
            }
        };

        TestContext testContext = new TestContext();
        JexlEngine jexl = new JexlBuilder().create();

        Assert.assertEquals(LocalDate.of(2020, 3, 1), jexl.createExpression("DATE_ADD(current_date, '2 years 2 months')").evaluate(testContext));
        Assert.assertEquals("2018/01/01", jexl.createExpression("DATE_FORMAT(CURRENT_DATE, 'yyyy/MM/dd')").evaluate(testContext));
    }

    @Test
    public void testVariable() {
        TestContext testContext = new TestContext();
        testContext.set("variABLE", "value");

        JexlEngine jexl = new JexlBuilder().create();

        Assert.assertEquals("value", jexl.createExpression("variable").evaluate(testContext));
        Assert.assertEquals("value", jexl.createExpression("VARIABLE").evaluate(testContext));
    }

    @Test(expected = JexlException.class)
    public void testClear() {
        TestContext testContext = new TestContext();
        testContext.set("variable", "value");

        JexlEngine jexl = new JexlBuilder().create();

        testContext.clear();
        Assert.assertEquals(null, jexl.createExpression("variable").evaluate(testContext));
    }
}
