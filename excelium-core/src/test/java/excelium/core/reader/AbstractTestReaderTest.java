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

import javax.management.AttributeList;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static excelium.core.reader.AbstractTestReader.DataLocation;

/**
 * Tests for {@link AbstractTestReader}.
 *
 * @author PhungDucKien
 * @since 2018.04.23
 */
public class AbstractTestReaderTest {

    @Test
    public void testPartitionColumnCellValues() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = AbstractTestReader.class.getDeclaredMethod("partitionColumnCellValues", Map.class, int.class);
        method.setAccessible(true);

        MyTestReader testReader = new MyTestReader();

        Map<String, List<Object>> columnValuesMap = new HashMap<>();
        List<Object> column1 = new AttributeList();
        column1.add("Name1");
        column1.add(null);
        column1.add("Name2");
        column1.add(null);
        column1.add("Name3");
        column1.add(null);
        List<Object> column2 = new AttributeList();
        column2.add("Address1");
        column2.add(null);
        column2.add("Address2");
        column2.add(null);
        column2.add("Address3");
        column2.add(null);
        List<Object> column3 = new AttributeList();
        column3.add("12367890");
        column3.add("12678907");
        column3.add("89786440");
        column3.add("97867561");
        column3.add("35678798");
        column3.add("87186323");
        columnValuesMap.put("A", column1);
        columnValuesMap.put("C", column2);
        columnValuesMap.put("E", column3);

        List<Map<String, List<Object>>> tableValues = (List<Map<String, List<Object>>>) method.invoke(testReader, columnValuesMap, 2);
        Assert.assertEquals(3, tableValues.size());

        Map<String, List<Object>> rowValues = tableValues.get(0);
        Assert.assertEquals(3, rowValues.size());
        Assert.assertEquals("Name1", rowValues.get("A").get(0));
        Assert.assertEquals("Address1", rowValues.get("C").get(0));
        Assert.assertEquals("12367890", rowValues.get("E").get(0));
        Assert.assertEquals("12678907", rowValues.get("E").get(1));

        rowValues = tableValues.get(1);
        Assert.assertEquals(3, rowValues.size());
        Assert.assertEquals("Name2", rowValues.get("A").get(0));
        Assert.assertEquals("Address2", rowValues.get("C").get(0));
        Assert.assertEquals("89786440", rowValues.get("E").get(0));
        Assert.assertEquals("97867561", rowValues.get("E").get(1));

        rowValues = tableValues.get(2);
        Assert.assertEquals(3, rowValues.size());
        Assert.assertEquals("Name3", rowValues.get("A").get(0));
        Assert.assertEquals("Address3", rowValues.get("C").get(0));
        Assert.assertEquals("35678798", rowValues.get("E").get(0));
        Assert.assertEquals("87186323", rowValues.get("E").get(1));

        method.setAccessible(false);
    }

    @Test
    public void testGetItemListByColumnCellValues() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = AbstractTestReader.class.getDeclaredMethod("getItemListByColumnCellValues", List.class, Map.class);
        method.setAccessible(true);

        MyTestReader testReader = new MyTestReader();

        List<Map<String, List<Object>>> columnCellValues = new ArrayList<>();
        Map<String, List<Object>> columnValuesMap = new HashMap<>();
        List<Object> column1 = new AttributeList();
        column1.add("Name1");
        column1.add(null);
        List<Object> column2 = new AttributeList();
        column2.add("Address1");
        column2.add(null);
        List<Object> column3 = new AttributeList();
        column3.add("12367890");
        column3.add("12678907");
        columnValuesMap.put("A", column1);
        columnValuesMap.put("C", column2);
        columnValuesMap.put("E", column3);
        columnCellValues.add(columnValuesMap);

        columnValuesMap = new HashMap<>();
        column1 = new AttributeList();
        column1.add("Name2");
        column1.add(null);
        column2 = new AttributeList();
        column2.add("Address2");
        column2.add(null);
        column3 = new AttributeList();
        column3.add("89786440");
        column3.add("97867561");
        columnValuesMap.put("A", column1);
        columnValuesMap.put("C", column2);
        columnValuesMap.put("E", column3);
        columnCellValues.add(columnValuesMap);

        columnValuesMap = new HashMap<>();
        column1 = new AttributeList();
        column1.add("Name3");
        column1.add(null);
        column2 = new AttributeList();
        column2.add("Address3");
        column2.add(null);
        column3 = new AttributeList();
        column3.add("35678798");
        column3.add("87186323");
        columnValuesMap.put("A", column1);
        columnValuesMap.put("C", column2);
        columnValuesMap.put("E", column3);
        columnCellValues.add(columnValuesMap);

        Map<Object, DataLocation> dataLocations = new HashMap<>();
        dataLocations.put("NAME", new DataLocation("A", 0));
        dataLocations.put("ADDRESS", new DataLocation("C", 0));
        dataLocations.put("PHONE1", new DataLocation("E", 0));
        dataLocations.put("PHONE2", new DataLocation("E", 1));

        List<Map<Object, Object>> tableValues = (List<Map<Object, Object>>) method.invoke(testReader, columnCellValues, dataLocations);
        Assert.assertEquals(3, tableValues.size());

        Map<Object, Object> rowValues = tableValues.get(0);
        Assert.assertEquals(4, rowValues.size());
        Assert.assertEquals("Name1", rowValues.get("NAME"));
        Assert.assertEquals("Address1", rowValues.get("ADDRESS"));
        Assert.assertEquals("12367890", rowValues.get("PHONE1"));
        Assert.assertEquals("12678907", rowValues.get("PHONE2"));

        rowValues = tableValues.get(1);
        Assert.assertEquals(4, rowValues.size());
        Assert.assertEquals("Name2", rowValues.get("NAME"));
        Assert.assertEquals("Address2", rowValues.get("ADDRESS"));
        Assert.assertEquals("89786440", rowValues.get("PHONE1"));
        Assert.assertEquals("97867561", rowValues.get("PHONE2"));

        rowValues = tableValues.get(2);
        Assert.assertEquals(4, rowValues.size());
        Assert.assertEquals("Name3", rowValues.get("NAME"));
        Assert.assertEquals("Address3", rowValues.get("ADDRESS"));
        Assert.assertEquals("35678798", rowValues.get("PHONE1"));
        Assert.assertEquals("87186323", rowValues.get("PHONE2"));

        method.setAccessible(false);
    }

    public static class MyTestReader extends AbstractTestReader<String, String> {

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
