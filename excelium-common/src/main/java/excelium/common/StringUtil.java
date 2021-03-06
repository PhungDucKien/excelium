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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Collection of string handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class StringUtil {

    /**
     * Get first sentence regex
     */
    private static final String GET_FIRST_SENTENCE_REGEX = "^(.*?[.!?])(?:\\s|$)(?!.*\\))";

    /**
     * Extract spreadsheet id from a spreadsheet url.
     *
     * @param url the spreadsheet url
     * @return the spreadsheet id. Return the given string if it is not a spreadsheet url.
     * @see <a href="https://developers.google.com/sheets/api/guides/concepts">Key Concepts in the Google Sheets API</a>
     */
    public static String extractSpreadsheetId(String url) {
        String regex = "/d/([a-zA-Z0-9-_]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return url;
    }

    /**
     * Converts byte size to human readable format.
     * Eg: 1000 to "1 kB", 1000000 to "1 MB" etc.
     *
     * @param bytes byte size
     * @param si    decimal format
     * @return human readable byte size
     * @see <a href="http://programming.guide/java/formatting-byte-size-to-human-readable-format.html">Java: Formatting byte size to human readable format</a>
     */
    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    /**
     * Adds spaces to camel case.
     *
     * @param input the input string in camel case
     * @return the result string
     */
    public static String addSpaceToCamelCase(String input) {
        return input.replaceAll("(\\P{Ll})(\\P{Ll}\\p{Ll})","$1 $2").replaceAll("(\\p{Ll})(\\P{Ll})","$1 $2");
    }

    /**
     * Parse configuration string to properties
     *
     * @param input     the input string
     * @param separator the separator
     * @return the properties
     * @throws IOException the io exception
     */
    public static Properties parseProperties(String input, String separator) throws IOException {
        Properties properties = new Properties();
        try (Reader reader = new StringReader(input.replaceAll(separator, "\n"))) {
            properties.load(reader);
        }
        return properties;
    }

    /**
     * Returns the first sentence of the input string.
     * The sentence ends with ends with "." or "!" or "?" and is followed by a white space character or the end of the line.
     * E.g:
     * 'This is first (e.g. 1st) sentence. And the second one.' returns 'This is first (e.g. 1st) sentence.'
     * 'I need this domain.com! Another sentence. And another sentence.' returns 'I need this domain.com!'
     *
     * @param input the input string
     * @return the first sentence
     */
    public static String getFirstSentence(String input) {
        Pattern p = Pattern.compile(GET_FIRST_SENTENCE_REGEX);
        Matcher m = p.matcher(input);
        String firstSentence;
        if (m.find()) {
            firstSentence = m.group(1);
        } else {
            firstSentence = input;
        }
        return firstSentence;
    }

    /**
     * Returns the name with the number of parameters. The name can be parameterized by declaring
     * parameter names surrounded by square brackets.
     *
     * For instance, "Button [param1, param2]" takes param1 and param2 as its parameters.
     *
     * This method converts "Button [param1, param2]" into "Button [2]"
     *
     * @param name the name with parameters
     * @return the name with the number of parameters
     */
    public static String getNameWithNumberOfParams(String name) {
        Pattern p = Pattern.compile("\\b[^()]+\\[(.*)\\]$");
        Matcher m = p.matcher(name);
        if (m.find()) {
            String params = m.group(1);
            return name.substring(0, m.start(1)) + params.split(",").length + name.substring(m.end(1));
        }
        return name;
    }
}
