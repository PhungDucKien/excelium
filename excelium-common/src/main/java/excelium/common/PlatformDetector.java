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

import excelium.model.enums.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

/**
 * Platform detector
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
public class PlatformDetector {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Detected platform. For later uses
     */
    private static Platform detectedPlatform;

    /**
     * Gets system platform
     *
     * @return system platform
     */
    public static Platform getPlatform() {
        if (detectedPlatform == null) {
            String OS = getOsName().toLowerCase(Locale.ENGLISH);
            if (OS.contains("mac") || OS.contains("darwin")) {
                detectedPlatform = Platform.MAC_OS;
            } else if (OS.contains("win")) {
                String arch = getOsArch().toLowerCase(Locale.ENGLISH);
                if (arch.contains("64")) {
                    detectedPlatform = Platform.WINDOWS_64;
                } else {
                    detectedPlatform = Platform.WINDOWS_32;
                }
            } else if (OS.contains("nux")) {
                detectedPlatform = Platform.LINUX;
            } else {
                detectedPlatform = Platform.OTHER;
            }
            LOG.info("Detected Platform: {}", detectedPlatform.getText());
        }
        return detectedPlatform;
    }

    /**
     * Gets OS name
     *
     * @return OS name
     */
    private static String getOsName() {
        return System.getProperty("os.name", "generic");
    }

    /**
     * Gets OS arch
     *
     * @return OS arch
     */
    private static String getOsArch() {
        return System.getProperty("os.arch");
    }
}
