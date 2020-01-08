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

/**
 * Represents type of platform.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
enum Platform {
  /**
   * The Windows 32.
   */
  WINDOWS_32 = 'Windows 32',
  /**
   * The Windows 64.
   */
  WINDOWS_64 = 'Windows 64',
  /**
   * The Mac os.
   */
  MAC_OS = 'Mac OS',
  /**
   * Linux platform.
   */
  LINUX = 'Linux',
  /**
   * Android platform.
   */
  ANDROID = 'Android',
  /**
   * Ios platform.
   */
  IOS = 'iOS',
  /**
   * Other platform.
   */
  OTHER = 'Other',
}

namespace Platform {
  /**
   * From name platform.
   *
   * @param name the name
   * @return the platform
   */
  export function fromName(name: string): Platform {
    const platform = (Platform as any)[name.toUpperCase()];
    return platform;
  }

  /**
   * Get list choice.
   *
   * @return the list choice
   */
  export function getListChoice(): string[][] {
    const listChoice = [] as string[][];
    for (const key of Object.keys(Platform)) {
      const value = (Platform as any)[key];
      if (typeof value === 'string' || value instanceof String) {
        listChoice.push([key, value as string]);
      }
    }
    return listChoice;
  }

  /**
   * Checks if platform is Windows
   *
   * @return return true if platform is Windows
   */
  export function isWindows(platform: Platform): boolean {
    return platform === Platform.WINDOWS_32 || platform === Platform.WINDOWS_64;
  }

  /**
   * Checks if platform is Mac OS
   *
   * @return return true if platform is Mac OS
   */
  export function isMac(platform: Platform): boolean {
    return platform === Platform.MAC_OS;
  }
}

export default Platform;
