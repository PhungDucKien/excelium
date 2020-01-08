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
 * Collection of wildcard handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.15
 */
export default class WildcardUtil {
  /**
   * Matches wildcard pattern with support for '?' and '*'.
   * <p>
   * '?' Matches any single character.
   * '*' Matches any sequence of characters (including the empty sequence).
   * </p>
   * The matching should cover the entire input string (not partial).
   *
   * @param s the input string
   * @param p the pattern
   * @return the input string matches the pattern or not
   * @see <a href="https://www.quora.com/How-do-I-solve-the-wildcard-matching-problem-in-Java">How do I solve the wildcard matching problem in Java?</a>
   */
  public static isMatch(s: string, p: string): boolean {
    let i = 0;
    let j = 0;
    let starIndex = -1;
    let iIndex = -1;

    while (i < s.length) {
      if (j < p.length && (p.charAt(j) === '?' || p.charAt(j) === s.charAt(i))) {
        ++i;
        ++j;
      } else if (j < p.length && p.charAt(j) === '*') {
        starIndex = j;
        iIndex = i;
        j++;
      } else if (starIndex !== -1) {
        j = starIndex + 1;
        i = iIndex + 1;
        iIndex++;
      } else {
        return false;
      }
    }
    while (j < p.length && p.charAt(j) === '*') {
      ++j;
    }
    return j === p.length;
  }
}
