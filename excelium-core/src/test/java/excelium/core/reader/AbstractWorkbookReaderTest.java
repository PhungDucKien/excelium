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

package excelium.core.reader;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link AbstractWorkbookReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.23
 */
public class AbstractWorkbookReaderTest {

    @Test
    public void testGetFirstValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = AbstractWorkbookReader.class.getDeclaredMethod("getFirstValue", List.class);
        method.setAccessible(true);

        MyWorkbookReader workbookReader = new MyWorkbookReader();
        Assert.assertEquals(null,  method.invoke(workbookReader, (List) null));
        List<List<Object>> list = new ArrayList<>();
        Assert.assertEquals(null,  method.invoke(workbookReader, list));
        List<Object> childList = new ArrayList<>();
        list.add(childList);
        Assert.assertEquals(null, method.invoke(workbookReader, list));
        childList.add("abc");
        Assert.assertEquals("abc", method.invoke(workbookReader, list));

        method.setAccessible(false);
    }

    @Test
    public void testGetFirstRowValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = AbstractWorkbookReader.class.getDeclaredMethod("getFirstRowValues", List.class);
        method.setAccessible(true);

        MyWorkbookReader workbookReader = new MyWorkbookReader();
        Assert.assertEquals(0,  ((List) method.invoke(workbookReader, (List) null)).size());
        List<List<Object>> list = new ArrayList<>();
        Assert.assertEquals(0,  ((List) method.invoke(workbookReader, list)).size());
        List<Object> childList = new ArrayList<>();
        list.add(childList);
        Assert.assertEquals(0,  ((List) method.invoke(workbookReader, list)).size());
        childList.add("abc");
        childList.add("def");
        Assert.assertEquals(2, ((List) method.invoke(workbookReader, list)).size());
        Assert.assertEquals("abc", ((List) method.invoke(workbookReader, list)).get(0));
        Assert.assertEquals("def", ((List) method.invoke(workbookReader, list)).get(1));
        childList = new ArrayList<>();
        childList.add("def");
        childList.add("abc");
        Assert.assertEquals(2, ((List) method.invoke(workbookReader, list)).size());
        Assert.assertEquals("abc", ((List) method.invoke(workbookReader, list)).get(0));
        Assert.assertEquals("def", ((List) method.invoke(workbookReader, list)).get(1));

        method.setAccessible(false);
    }

    @Test
    public void testGetFirstColumnValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = AbstractWorkbookReader.class.getDeclaredMethod("getFirstColumnValues", List.class);
        method.setAccessible(true);

        MyWorkbookReader workbookReader = new MyWorkbookReader();
        Assert.assertEquals(0,  ((List) method.invoke(workbookReader, (List) null)).size());
        List<List<Object>> list = new ArrayList<>();
        Assert.assertEquals(0,  ((List) method.invoke(workbookReader, list)).size());
        List<Object> childList = new ArrayList<>();
        list.add(childList);
        Assert.assertEquals(1,  ((List) method.invoke(workbookReader, list)).size());
        Assert.assertEquals(null, ((List) method.invoke(workbookReader, list)).get(0));
        childList.add("abc");
        childList.add("def");
        Assert.assertEquals(1, ((List) method.invoke(workbookReader, list)).size());
        Assert.assertEquals("abc", ((List) method.invoke(workbookReader, list)).get(0));
        childList = new ArrayList<>();
        childList.add("abc");
        childList.add("def");
        list.add(childList);
        Assert.assertEquals(2, ((List) method.invoke(workbookReader, list)).size());
        Assert.assertEquals("abc", ((List) method.invoke(workbookReader, list)).get(0));
        Assert.assertEquals("abc", ((List) method.invoke(workbookReader, list)).get(1));

        method.setAccessible(false);
    }

    public static class MyWorkbookReader extends AbstractWorkbookReader<String, String> {
        @Override
        public String getWorkbook() throws IOException {
            return null;
        }

        @Override
        public String getWorkbookName() throws IOException {
            return null;
        }

        @Override
        public List<String> listSheets() throws IOException {
            return null;
        }

        @Override
        public String getSheetName(String sheet) {
            return null;
        }

        @Override
        public Map<Object, String> batchFindFirstOccurrence(List<Object> values, String sheet) throws IOException {
            return null;
        }

        @Override
        public Map<String, List<List<Object>>> batchGetRangeCellValues(String... ranges) throws IOException {
            return null;
        }
    }
}
