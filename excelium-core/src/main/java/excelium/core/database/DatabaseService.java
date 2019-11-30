/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.core.database;

import excelium.model.test.data.TableData;

import java.util.List;

/**
 * Database service interface.
 *
 * @author PhungDucKien
 * @since 2019.11.28
 */
public interface DatabaseService {

    /**
     * Test connection boolean.
     *
     * @return the boolean
     */
    boolean testConnection();

    /**
     * Create test data.
     *
     * @param tableDataList the table data list
     * @throws Exception the exception
     */
    void createTestData(List<TableData> tableDataList) throws Exception;

    /**
     * Executes the given query and return the count.
     *
     * @param query the query
     * @return the count
     * @throws Exception the exception
     */
    int count(String query) throws Exception;

    /**
     * Executes the given query and return the count.
     *
     * @param query  the query
     * @param values the values to bind
     * @return the count
     * @throws Exception the exception
     */
    int count(String query, String values) throws Exception;
}
