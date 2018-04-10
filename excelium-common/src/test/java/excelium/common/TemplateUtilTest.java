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

package excelium.common;

import excelium.model.project.Template;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests for {@link TemplateUtil}.
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
public class TemplateUtilTest {

    @Test
    public void testGetSuggestSheetForConfiguration() throws IllegalAccessException {
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%SYSTEM_NAME%", "configuration!A2");
        markupLocations.put("%SYSTEM_IDENTIFIER%", "configuration!A3");
        markupLocations.put("%FUNCTION_NAME%", "configuration!A4");
        markupLocations.put("%FUNCTION_IDENTIFIER%", "config!A5");
        markupLocations.put("%BASE_URL%", "config!A6");
        template.setMarkupLocations(markupLocations);

        Assert.assertEquals("configuration", TemplateUtil.getSuggestSheetForConfiguration(template));

        template = new Template();
        markupLocations = new HashMap<>();
        markupLocations.put("%SYSTEM_NAME%", "configuration!A2");
        markupLocations.put("%SYSTEM_IDENTIFIER%", "config!A3");
        markupLocations.put("%FUNCTION_NAME%", "configuration!A4");
        markupLocations.put("%FUNCTION_IDENTIFIER%", "config!A5");
        markupLocations.put("%BASE_URL%", "config!A6");
        template.setMarkupLocations(markupLocations);

        Assert.assertEquals("config", TemplateUtil.getSuggestSheetForConfiguration(template));
    }

    @Test
    public void testGetSuggestSheetForMapping() throws IllegalAccessException {
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%MAPPING_ITEM_NAME%", "mapping!A2");
        markupLocations.put("%MAPPING_ITEM_DESC%", "map!A3");
        template.setMarkupLocations(markupLocations);

        Assert.assertEquals("mapping", TemplateUtil.getSuggestSheetForMapping(template));
    }

    @Test
    public void testGetSuggestSheetForAction() throws IllegalAccessException {
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%ACTION_NAME%", "action!A2");
        markupLocations.put("%ACTION_DESC%", "act!A3");
        template.setMarkupLocations(markupLocations);

        Assert.assertEquals("action", TemplateUtil.getSuggestSheetForAction(template));
    }

    @Test
    public void testGetSuggestSheetForData() throws IllegalAccessException {
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%DATA_NAME%", "data!A2");
        markupLocations.put("%DATA_DESC%", "dat!A3");
        template.setMarkupLocations(markupLocations);

        Assert.assertEquals("data", TemplateUtil.getSuggestSheetForData(template));
    }

    @Test
    public void testGetSuggestSheetForTest() throws IllegalAccessException {
        Template template = new Template();
        Map<Object, String> markupLocations = new HashMap<>();
        markupLocations.put("%TEST_COMMAND%", "test!A2");
        markupLocations.put("%TEST_NAME%", "tes!A3");
        template.setMarkupLocations(markupLocations);

        Assert.assertEquals("test", TemplateUtil.getSuggestSheetForTest(template));
    }
}
