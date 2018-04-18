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

package excelium.model.test.config;

/**
 * Represents environment model for mobile.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
public class MobileEnvironment extends Environment {

    /**
     * Device name
     */
    private String deviceName;

    /**
     * UDID
     */
    private String udid;

    /**
     * Orientation
     */
    private String orientation;

    /**
     * Gets device name.
     *
     * @return the device name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Sets device name.
     *
     * @param deviceName the device name
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * Gets udid.
     *
     * @return the udid
     */
    public String getUdid() {
        return udid;
    }

    /**
     * Sets udid.
     *
     * @param udid the udid
     */
    public void setUdid(String udid) {
        this.udid = udid;
    }

    /**
     * Gets orientation.
     *
     * @return the orientation
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * Sets orientation.
     *
     * @param orientation the orientation
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
