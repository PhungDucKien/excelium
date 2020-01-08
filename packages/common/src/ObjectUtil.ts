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

import BooleanUtil from './BooleanUtil';
import StringUtil from './StringUtil';

/**
 * Collection of object handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
export default class ObjectUtil {
  /**
   * Converts object to string.
   *
   * @param value object
   * @return string value
   */
  public static getStringValue(value: any): string | null {
    if (value != null) {
      return value.toString();
    }
    return null;
  }

  /**
   * Converts object to boolean
   *
   * @param value object
   * @return boolean value
   */
  public static getBooleanValue(value: any): boolean {
    if (typeof value === 'string' || value instanceof String) {
      const str = value as string;
      if (StringUtil.equalsAnyIgnoreCase(str, ['☑', '✓', '✔', '○', '●', '◯'])) {
        return true;
      }
      return BooleanUtil.toBoolean(str);
    } else if (typeof value === 'number' && Number.isInteger(value)) {
      return value !== 0;
    } else if (typeof value === 'boolean') {
      return value;
    }
    return false;
  }

  /**
   * Converts object to list of string.
   * The converted object is split based on commas, new lines.
   *
   * @param value object
   * @return list value
   */
  public static getListValue(value: any): string[] {
    const valueList = [] as string[];
    if (value != null && StringUtil.isNotBlank(value.toString())) {
      const items = value
        .toString()
        .trim()
        .split(/[,\n]/);
      for (const item of items) {
        valueList.push(item.trim());
      }
    }
    return valueList;
  }

  /**
   * Determine that two values are equal. The expected is in string format
   * and converted to the corresponding object type before comparing. If
   * <code>expected</code> and <code>actual</code> are <code>null</code>,
   * they are considered equal.
   *
   * @param expected the expected
   * @param actual   the actual
   * @return true, if the values are equal, otherwise, false
   */
  public static checkEquals(expected: string | null, actual: any): boolean {
    if (actual == null) {
      return expected == null;
    }
    // TODO
    // Class clazz = actual.getClass();
    // if (clazz.equals(Color.class)) {
    //     return actual.equals(Color.fromString(expected));
    // }
    // if (clazz.equals(Byte.class)) {
    //     return actual.equals(Byte.parseByte(expected));
    // }
    // if (clazz.equals(Short.class)) {
    //     return actual.equals(Short.parseShort(expected));
    // }
    // if (clazz.equals(Integer.class)) {
    //     return actual.equals(Integer.parseInt(expected));
    // }
    // if (clazz.equals(Long.class)) {
    //     return actual.equals(Long.parseLong(expected));
    // }
    // if (clazz.equals(Float.class)) {
    //     return actual.equals(Float.parseFloat(expected));
    // }
    // if (clazz.equals(Double.class)) {
    //     return actual.equals(Double.parseDouble(expected));
    // }
    // if (clazz.equals(Boolean.class)) {
    //     return actual.equals(Boolean.parseBoolean(expected));
    // }
    // Compares as string
    return actual.toString() === expected;
  }
}
