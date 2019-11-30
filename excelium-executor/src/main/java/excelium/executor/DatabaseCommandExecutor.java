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

package excelium.executor;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.database.DatabaseService;
import excelium.core.database.DatabaseServiceFactory;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.AssertFailedException;
import excelium.model.project.Project;

/**
 * Represents a class which contains commands for accessing database.
 *
 * @author PhungDucKien
 * @since 2018.07.04
 */
public class DatabaseCommandExecutor extends CommandExecutor {

    /**
     * Database service
     */
    private DatabaseService databaseService;

    /**
     * Instantiates a new Database command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public DatabaseCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
        databaseService = DatabaseServiceFactory.createService(project);
    }

    /**
     * Check if any row would be returned by the given input query statement.
     *
     * @param query the query
     * @return the boolean
     * @throws Exception the exception
     */
    @Accessor(param1 = "query")
    public boolean isExistsInDatabase(String query) throws Exception {
        int rowCount = this.databaseService.count(query);
        return rowCount > 0;
    }

    /**
     * Check if any row would be returned by the given input query statement.
     *
     * @param query  the query
     * @param values the values to bind
     * @return the boolean
     * @throws Exception the exception
     */
    @Accessor(param1 = "query", param2 = "values")
    public boolean isExistsInDatabase(String query, String values) throws Exception {
        int rowCount = this.databaseService.count(query, values);
        return rowCount > 0;
    }

    /**
     * Check if the number of rows returned by the given input query statement is equal to the value submitted.
     *
     * @param query the query
     * @param count the count
     * @throws Exception the exception
     */
    @Action(param1 = "query", param2 = "count")
    public void verifyRowCount(String query, String count) throws Exception {
        int rowCount = this.databaseService.count(query);
        int expectedRowCount = Integer.parseInt(count);
        if (rowCount != expectedRowCount) {
            throw new AssertFailedException("Expected to have " + expectedRowCount + " rows from '" + query + "' but got " + rowCount + " rows.");
        }
    }

    /**
     * Check if the number of rows returned by the given input query statement is greater than the value submitted.
     *
     * @param query the query
     * @param count the count
     * @throws Exception the exception
     */
    @Action(param1 = "query", param2 = "count")
    public void verifyRowCountGreaterThan(String query, String count) throws Exception {
        int rowCount = this.databaseService.count(query);
        int expectedRowCount = Integer.parseInt(count);
        if (rowCount < expectedRowCount) {
            throw new AssertFailedException("Expected to have more than " + expectedRowCount + " rows from '" + query + "' but got " + rowCount + " rows.");
        }
    }

    /**
     * Check if the number of rows returned by the given input query statement is less than the value submitted.
     *
     * @param query the query
     * @param count the count
     * @throws Exception the exception
     */
    @Action(param1 = "query", param2 = "count")
    public void verifyRowCountLessThan(String query, String count) throws Exception {
        int rowCount = this.databaseService.count(query);
        int expectedRowCount = Integer.parseInt(count);
        if (rowCount > expectedRowCount) {
            throw new AssertFailedException("Expected to have less than " + expectedRowCount + " rows from '" + query + "' but got " + rowCount + " rows.");
        }
    }

    /**
     * Check if the number of rows returned by the given input query statement is equal to the value submitted.
     *
     * @param query  the query
     * @param values the values to bind
     * @param count  the count
     * @throws Exception the exception
     */
    @Action(param1 = "query", param2 = "values", param3 = "count")
    public void verifyRowCount(String query, String values, String count) throws Exception {
        int rowCount = this.databaseService.count(query, values);
        int expectedRowCount = Integer.parseInt(count);
        if (rowCount != expectedRowCount) {
            throw new AssertFailedException("Expected to have " + expectedRowCount + " rows from '" + query + "' but got " + rowCount + " rows.");
        }
    }

    /**
     * Check if the number of rows returned by the given input query statement is greater than the value submitted.
     *
     * @param query  the query
     * @param values the values to bind
     * @param count  the count
     * @throws Exception the exception
     */
    @Action(param1 = "query", param2 = "values", param3 = "count")
    public void verifyRowCountGreaterThan(String query, String values, String count) throws Exception {
        int rowCount = this.databaseService.count(query, values);
        int expectedRowCount = Integer.parseInt(count);
        if (rowCount < expectedRowCount) {
            throw new AssertFailedException("Expected to have more than " + expectedRowCount + " rows from '" + query + "' but got " + rowCount + " rows.");
        }
    }

    /**
     * Check if the number of rows returned by the given input query statement is less than the value submitted.
     *
     * @param query  the query
     * @param values the values to bind
     * @param count  the count
     * @throws Exception the exception
     */
    @Action(param1 = "query", param2 = "values", param3 = "count")
    public void verifyRowCountLessThan(String query, String values, String count) throws Exception {
        int rowCount = this.databaseService.count(query, values);
        int expectedRowCount = Integer.parseInt(count);
        if (rowCount > expectedRowCount) {
            throw new AssertFailedException("Expected to have less than " + expectedRowCount + " rows from '" + query + "' but got " + rowCount + " rows.");
        }
    }
}
