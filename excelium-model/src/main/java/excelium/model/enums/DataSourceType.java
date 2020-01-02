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

public enum DataSourceType {
    MYSQL("MySQL", "com.mysql.cj.jdbc.Driver", "jdbc:mysql://<host>:<port>/<db>", 3306),
    POSTGRESQL("PostgreSQL", "org.postgresql.Driver", "jdbc:postgresql://<host>:<port>/<db>", 5432),
    DYNAMODB("Amazon DynamoDB", null, null, 0);

    /**
     * Driver class
     */
    private String driverClass;

    /**
     * Url pattern
     */
    private String urlPattern;

    /**
     * Default port
     */
    private int defaultPort;

    /**
     * Gets driver class.
     *
     * @return the driver class
     */
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * Gets default port.
     *
     * @return the default port
     */
    public int getDefaultPort() {
        return defaultPort;
    }

    /**
     * Gets url.
     *
     * @param host the host
     * @param port the port
     * @param db   the db
     * @return the url
     */
    public String getUrl(String host, String port, String db) {
        return urlPattern.replace("<host>", host).replace("<port>", port).replace("<db>", db);
    }

    /**
     * Get list choice.
     *
     * @return the list choice
     */
    public static String[][] getListChoice() {
        String[][] listChoice = new String[DataSourceType.values().length][2];
        int i = 0;
        for (DataSourceType d : DataSourceType.values()) {
            listChoice[i++] = new String[]{d.name(), d.getText()};
        }
        return listChoice;
    }
}
