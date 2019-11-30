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

package excelium.model.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link DataSourceType}.
 *
 * @author PhungDucKien
 * @since 2018.05.26
 */
public class DataSourceTypeTest {

    @Test
    public void testFromName() {
        Assert.assertEquals(DataSourceType.MYSQL, DataSourceType.fromName("MySQL"));
        Assert.assertEquals(DataSourceType.POSTGRESQL, DataSourceType.fromName("PostgreSQL"));
        Assert.assertEquals(DataSourceType.DYNAMODB, DataSourceType.fromName("DynamoDB"));
    }

    @Test
    public void testGetListChoice() {
        String[][] listChoice = DataSourceType.getListChoice();
        Assert.assertEquals(3, listChoice.length);
        Assert.assertEquals("MYSQL", listChoice[0][0]);
        Assert.assertEquals("MySQL", listChoice[0][1]);
        Assert.assertEquals("POSTGRESQL", listChoice[1][0]);
        Assert.assertEquals("PostgreSQL", listChoice[1][1]);
        Assert.assertEquals("DYNAMODB", listChoice[2][0]);
        Assert.assertEquals("Amazon DynamoDB", listChoice[2][1]);
    }

    @Test
    public void testGetUrl() {
        Assert.assertEquals("jdbc:mysql://localhost:1234/dbname", DataSourceType.MYSQL.getUrl("localhost", "1234", "dbname"));
        Assert.assertEquals("jdbc:postgresql://localhost:1234/dbname", DataSourceType.POSTGRESQL.getUrl("localhost", "1234", "dbname"));
    }
}
