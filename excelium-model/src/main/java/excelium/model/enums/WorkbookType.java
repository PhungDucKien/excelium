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
 * Represents type of workbook.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public enum WorkbookType {
    /**
     * The Sheets.
     */
    SHEETS("Google Spreadsheet"),
    /**
     * The Excel.
     */
    EXCEL("Excel Workbook");

    /**
     * Text
     */
    private String text;

    WorkbookType(String text) {
        this.text = text;
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
     * From name workbook type.
     *
     * @param name the name
     * @return the workbook type
     */
    public static WorkbookType fromName(String name) {
        for (WorkbookType t : WorkbookType.values()) {
            if (t.name().equalsIgnoreCase(name)) {
                return t;
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
        String[][] listChoice = new String[WorkbookType.values().length][2];
        int i = 0;
        for (WorkbookType t : WorkbookType.values()) {
            listChoice[i++] = new String[]{t.name(), t.getText()};
        }
        return listChoice;
    }
}
