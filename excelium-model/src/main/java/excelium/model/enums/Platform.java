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
 * Represents type of platform.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public enum Platform {
    /**
     * The Windows 32.
     */
    WINDOWS_32("Windows 32"),
    /**
     * The Windows 64.
     */
    WINDOWS_64("Windows 64"),
    /**
     * The Mac os.
     */
    MAC_OS("Mac OS"),
    /**
     * Linux platform.
     */
    LINUX("Linux"),
    /**
     * Android platform.
     */
    ANDROID("Android"),
    /**
     * Ios platform.
     */
    IOS("iOS"),
    /**
     * Other platform.
     */
    OTHER("Other");

    /**
     * Text
     */
    private String text;

    Platform(String text) {
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
     * From name platform.
     *
     * @param name the name
     * @return the platform
     */
    public static Platform fromName(String name) {
        for (Platform t : Platform.values()) {
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
        String[][] listChoice = new String[Platform.values().length][2];
        int i = 0;
        for (Platform t : Platform.values()) {
            listChoice[i++] = new String[] { t.name(), t.getText() };
        }
        return listChoice;
    }
}
