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

export default class BooleanUtil {
  public static toBoolean(str: string | null): boolean {
    if (str === 'true') {
      return true;
    }
    if (!str) {
      return false;
    }
    switch (str.length) {
      case 1: {
        const ch0 = str.charAt(0);
        if (ch0 === 'y' || ch0 === 'Y' || ch0 === 't' || ch0 === 'T') {
          return true;
        }
        if (ch0 === 'n' || ch0 === 'N' || ch0 === 'f' || ch0 === 'F') {
          return false;
        }
        break;
      }
      case 2: {
        const ch0 = str.charAt(0);
        const ch1 = str.charAt(1);
        if ((ch0 === 'o' || ch0 === 'O') && (ch1 === 'n' || ch1 === 'N')) {
          return true;
        }
        if ((ch0 === 'n' || ch0 === 'N') && (ch1 === 'o' || ch1 === 'O')) {
          return false;
        }
        break;
      }
      case 3: {
        const ch0 = str.charAt(0);
        const ch1 = str.charAt(1);
        const ch2 = str.charAt(2);
        if ((ch0 === 'y' || ch0 === 'Y') && (ch1 === 'e' || ch1 === 'E') && (ch2 === 's' || ch2 === 'S')) {
          return true;
        }
        if ((ch0 === 'o' || ch0 === 'O') && (ch1 === 'f' || ch1 === 'F') && (ch2 === 'f' || ch2 === 'F')) {
          return false;
        }
        break;
      }
      case 4: {
        const ch0 = str.charAt(0);
        const ch1 = str.charAt(1);
        const ch2 = str.charAt(2);
        const ch3 = str.charAt(3);
        if ((ch0 === 't' || ch0 === 'T') && (ch1 === 'r' || ch1 === 'R') && (ch2 === 'u' || ch2 === 'U') && (ch3 === 'e' || ch3 === 'E')) {
          return true;
        }
        break;
      }
      case 5: {
        const ch0 = str.charAt(0);
        const ch1 = str.charAt(1);
        const ch2 = str.charAt(2);
        const ch3 = str.charAt(3);
        const ch4 = str.charAt(4);
        if (
          (ch0 === 'f' || ch0 === 'F') &&
          (ch1 === 'a' || ch1 === 'A') &&
          (ch2 === 'l' || ch2 === 'L') &&
          (ch3 === 's' || ch3 === 'S') &&
          (ch4 === 'e' || ch4 === 'E')
        ) {
          return false;
        }
        break;
      }
      default:
        break;
    }

    return false;
  }
}
