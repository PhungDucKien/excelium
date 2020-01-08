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

import StringUtil from './StringUtil';

/**
 * Collection of number handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.19
 */
export default class NumberUtil {
  /**
   * Gets integer value from a double value.
   * If the value is over integer's limit, the long value is returned.
   *
   * @param number double value
   * @return integer or long value
   */
  public static getIntValue(number: number): number {
    return Math.trunc(number);
  }

  /**
   * Parse the given {@code text} into a positive {@link Integer} instance,
   * using the corresponding {@code decode} / {@code valueOf} method.
   * <p>Trims the input {@code String} before attempting to parse the number.
   * <p>Supports numbers in hex format (with leading "0x", "0X", or "#") as well.
   * If the parsed number is below 0, or any exception occurred, returns the default value.
   *
   * @param text         the text to convert
   * @param defaultValue the default value
   * @return the parsed number
   * @see Integer#decode
   */
  public static parsePositiveInteger(text: string | null, defaultValue: number): number {
    let number = this.parseInteger(text, -1);
    if (number < 0) {
      number = defaultValue;
    }
    return number;
  }

  /**
   * Parse the given {@code text} into an {@link Integer} instance,
   * using the corresponding {@code decode} / {@code valueOf} method.
   * <p>Trims the input {@code String} before attempting to parse the number.
   * <p>Supports numbers in hex format (with leading "0x", "0X", or "#") as well.
   * If the parsed number is below 0, or any exception occurred, returns the default value.
   *
   * @param text         the text to convert
   * @param defaultValue the default value
   * @return the parsed number
   * @see Integer#decode
   */
  public static parseInteger(text: string | null, defaultValue: number): number {
    const trimmed = text ? text.trim() : text;
    if (trimmed && StringUtil.isNotBlank(trimmed)) {
      try {
        // tslint:disable-next-line: radix
        const number = parseInt(trimmed);
        if (Number.isNaN(number)) {
          return defaultValue;
        }
        return number;
      } catch (e) {
        return defaultValue;
      }
    }
    return defaultValue;
  }
}
