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

package excelium.xls;

import excelium.core.reader.TestReader;
import excelium.model.project.Template;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Tests for {@link ExcelReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class ExcelReaderTest {

    /** Excel reader factory */
    private static ExcelReaderFactory readerFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {
        readerFactory = new ExcelReaderFactory();
    }

    @Test
    public void testGetWorkbookName() throws IOException, URISyntaxException {
        TestReader sheetsReader = readerFactory.createReader(ExcelReader.class.getResource("/Simple Template.xlsx").toURI().getPath());
        Assert.assertTrue(sheetsReader.getWorkbookName().endsWith("Simple Template.xlsx"));
    }

    @Test
    public void testGetMarkupLocationMap() throws IllegalAccessException, IOException, URISyntaxException {
        TestReader sheetsReader = readerFactory.createReader(ExcelReader.class.getResource("/Simple Template.xlsx").toURI().getPath());
        Map<Object, String> markupLocations = sheetsReader.getMarkupLocationMap(Template.getMarkupList());
        Assert.assertEquals(4, markupLocations.size());
        Assert.assertEquals("'Test Case'!A2", markupLocations.get("%TEST_COMMAND%"));
        Assert.assertEquals("'Test Case'!B2", markupLocations.get("%TEST_PARAM1%"));
        Assert.assertEquals("'Test Case'!C2", markupLocations.get("%TEST_PARAM2%"));
        Assert.assertEquals("'Test Case'!D2", markupLocations.get("%TEST_PARAM3%"));
    }
}
