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

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Tests for {@link FunctionNamespace}.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class FunctionNamespaceTest {

    @Test
    public void testDateAdd() {
        FunctionNamespace functionNamespace = new FunctionNamespace();

        LocalDate date = LocalDate.of(2018, 1, 1);
        Assert.assertEquals(LocalDate.of(2019, 1, 1), functionNamespace.DATE_ADD(date, "1 year"));
        Assert.assertEquals(LocalDate.of(2016, 1, 1), functionNamespace.DATE_ADD(date, "-2 years"));

        Assert.assertEquals(LocalDate.of(2020, 3, 1), functionNamespace.DATE_ADD(date, "2 years 2 months"));
        Assert.assertEquals(LocalDate.of(2020, 3, 1), functionNamespace.DATE_ADD(date, "2 years and 2 months"));

        Assert.assertEquals(LocalDate.of(2020, 3, 8), functionNamespace.DATE_ADD(date, "2 years 2 months 1 week"));
        Assert.assertEquals(LocalDate.of(2020, 3, 8), functionNamespace.DATE_ADD(date, "2 years and 2 months and 1 week"));

        Assert.assertEquals(LocalDate.of(2020, 3, 11), functionNamespace.DATE_ADD(date, "2 years 2 months 1 week 3 day"));
        Assert.assertEquals(LocalDate.of(2020, 3, 11), functionNamespace.DATE_ADD(date, "2 years and 2 months and 1 week and 3 day"));
    }

    @Test
    public void testDateFormat() {
        FunctionNamespace functionNamespace = new FunctionNamespace();

        Assert.assertEquals("2018/06/13", functionNamespace.DATE_FORMAT(LocalDate.of(2018, 6, 13), "yyyy/MM/dd"));
    }
}
