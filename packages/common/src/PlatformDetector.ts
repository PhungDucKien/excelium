/*
 * Licensed to the Software Freedom Conservancy (SFC) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The SFC licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import { Platform } from '@excelium/model';

/**
 * Platform detector
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
export default class PlatformDetector {
  /**
   * Gets system platform
   *
   * @return system platform
   */
  public static getPlatform(): Platform {
    if (PlatformDetector.detectedPlatform == null) {
      const OS = PlatformDetector.getOsName().toLowerCase();
      if (OS.indexOf('mac') > -1 || OS.indexOf('darwin') > -1) {
        PlatformDetector.detectedPlatform = Platform.MAC_OS;
      } else if (OS.indexOf('win') > -1) {
        const arch = PlatformDetector.getOsArch().toLowerCase();
        if (arch.indexOf('64') > -1) {
          PlatformDetector.detectedPlatform = Platform.WINDOWS_64;
        } else {
          PlatformDetector.detectedPlatform = Platform.WINDOWS_32;
        }
      } else if (OS.indexOf('nux') > -1) {
        PlatformDetector.detectedPlatform = Platform.LINUX;
      } else {
        PlatformDetector.detectedPlatform = Platform.OTHER;
      }
    }
    return PlatformDetector.detectedPlatform;
  }

  /**
   * Gets OS name
   *
   * @return OS name
   */
  public static getOsName(): string {
    return process.platform;
  }

  /**
   * Gets OS arch
   *
   * @return OS arch
   */
  public static getOsArch(): string {
    return process.arch;
  }

  /**
   * Detected platform. For later uses
   */
  private static detectedPlatform: Platform;
}
