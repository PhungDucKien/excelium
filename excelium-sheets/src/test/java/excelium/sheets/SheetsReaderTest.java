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

package excelium.sheets;

import com.google.api.services.sheets.v4.Sheets;
import excelium.common.TemplateUtil;
import excelium.core.reader.TestReader;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Tests for {@link SheetsReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class SheetsReaderTest {

    /** Sheets reader factory */
    private static SheetsReaderFactory readerFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {
        GoogleConnection connection = new GoogleConnectionService();
        SheetsServiceProvider sheetsServiceProvider = new SheetsServiceProvider(connection);
        Sheets sheetsService = sheetsServiceProvider.createSheetsService();
        readerFactory = new SheetsReaderFactory(sheetsService);
    }

    @Test
    public void testGetWorkbookName() throws IOException {
        TestReader sheetsReader = readerFactory.createReader("10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY");
        Assert.assertEquals("10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY - Simple Template", sheetsReader.getWorkbookName());
    }

    @Test
    public void testGetMarkupLocationMap() throws IllegalAccessException, IOException {
        TestReader sheetsReader = readerFactory.createReader("10jtBkmwYw4fTBAU1iSj4QkjCfBRNNuTPqW5mA1qgYqY");
        Map<Object, String> markupLocations = sheetsReader.getMarkupLocationMap(TemplateUtil.getMarkups());
        Assert.assertEquals(4, markupLocations.size());
        Assert.assertEquals("'Test Case'!A2", markupLocations.get("%TEST_COMMAND%"));
        Assert.assertEquals("'Test Case'!B2", markupLocations.get("%TEST_PARAM1%"));
        Assert.assertEquals("'Test Case'!C2", markupLocations.get("%TEST_PARAM2%"));
        Assert.assertEquals("'Test Case'!D2", markupLocations.get("%TEST_PARAM3%"));
    }
}
