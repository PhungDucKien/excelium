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

/**
 * Represents type of data source.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
public enum DataSourceType {
    /**
     * MySQL
     */
    MYSQL("MySQL", "com.mysql.cj.jdbc.Driver", "jdbc:mysql://<host>:<port>/<db>", 3306),
    /**
     * PostgreSQL
     */
    POSTGRESQL("PostgreSQL", "org.postgresql.Driver", "jdbc:postgresql://<host>:<port>/<db>", 5432),
    /**
     * Amazon DynamoDB
     */
    DYNAMODB("Amazon DynamoDB", null, null, 0);

    /**
     * Text
     */
    private String text;

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

    DataSourceType(String text, String driverClass, String urlPattern, int defaultPort) {
        this.text = text;
        this.driverClass = driverClass;
        this.urlPattern = urlPattern;
        this.defaultPort = defaultPort;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

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
     * From name data source type.
     *
     * @param name the name
     * @return the data source type
     */
    public static DataSourceType fromName(String name) {
        for (DataSourceType d : DataSourceType.values()) {
            if (d.name().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
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
