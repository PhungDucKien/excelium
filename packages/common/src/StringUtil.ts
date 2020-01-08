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

import CollectionUtil from './CollectionUtil';

/**
 * Collection of string handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
export default class StringUtil {
  /**
   * Extract spreadsheet id from a spreadsheet url.
   *
   * @param url the spreadsheet url
   * @return the spreadsheet id. Return the given string if it is not a spreadsheet url.
   * @see <a href="https://developers.google.com/sheets/api/guides/concepts">Key Concepts in the Google Sheets API</a>
   */
  public static extractSpreadsheetId(url: string | null): string | null {
    if (!url) {
      return url;
    }

    const regex = /\/d\/([a-zA-Z0-9-_]+)/;
    const matcher = regex.exec(url);

    if (matcher && matcher[1]) {
      return matcher[1];
    }
    return url;
  }

  /**
   * Converts byte size to human readable format.
   * Eg: 1000 to "1 kB", 1000000 to "1 MB" etc.
   *
   * @param bytes byte size
   * @param si    decimal format
   * @return human readable byte size
   * @see <a href="http://programming.guide/java/formatting-byte-size-to-human-readable-format.html">Java: Formatting byte size to human readable format</a>
   */
  public static humanReadableByteCount(bytes: number, si: boolean): string {
    const unit = si ? 1000 : 1024;
    if (bytes < unit) {
      return bytes + ' B';
    }
    const exp = Math.trunc(Math.log(bytes) / Math.log(unit));
    const pre = (si ? 'kMGTPE' : 'KMGTPE').charAt(exp - 1) + (si ? '' : 'i');
    return (bytes / Math.pow(unit, exp)).toFixed(1) + ' ' + pre + 'B';
  }

  /**
   * Adds spaces to camel case.
   *
   * @param input the input string in camel case
   * @return the result string
   */
  public static addSpaceToCamelCase(input: string | null): string | null {
    if (!input) {
      return input;
    }
    return input.replace(/(\P{Ll})(\P{Ll}\p{Ll})/gu, '$1 $2').replace(/(\p{Ll})(\P{Ll})/gu, '$1 $2');
  }

  /**
   * Returns the first sentence of the input string.
   * The sentence ends with ends with "." or "!" or "?" and is followed by a white space character or the end of the line.
   * E.g:
   * 'This is first (e.g. 1st) sentence. And the second one.' returns 'This is first (e.g. 1st) sentence.'
   * 'I need this domain.com! Another sentence. And another sentence.' returns 'I need this domain.com!'
   *
   * @param input the input string
   * @return the first sentence
   */
  public static getFirstSentence(input: string | null): string | null {
    if (!input) {
      return input;
    }

    const matcher = StringUtil.GET_FIRST_SENTENCE_REGEX.exec(input);

    let firstSentence;
    if (matcher && matcher[1]) {
      firstSentence = matcher[1];
    } else {
      firstSentence = input;
    }
    return firstSentence;
  }

  /**
   * Returns the name with the number of parameters. The name can be parameterized by declaring
   * parameter names surrounded by square brackets.
   *
   * For instance, "Button [param1, param2]" takes param1 and param2 as its parameters.
   *
   * This method converts "Button [param1, param2]" into "Button [2]"
   *
   * @param name the name with parameters
   * @return the name with the number of parameters
   */
  public static getNameWithNumberOfParams(name: string | null): string | null {
    if (!name) {
      return name;
    }

    const regex = /\b[^()]+\[(.*)\]$/;
    const matcher = regex.exec(name);

    if (matcher && matcher[1]) {
      const params = matcher[1];
      return name.replace(params, params.split(',').length + '');
    }
    return name;
  }

  public static isNotBlank(str: string | null): boolean {
    return !!str && !/^\s*$/.test(str);
  }

  public static isBlank(str: string | null): boolean {
    return !str || /^\s*$/.test(str);
  }

  public static equalsAnyIgnoreCase(str: string | null, searchStrings: string[]): boolean {
    if (CollectionUtil.isNotEmpty(searchStrings)) {
      for (const next of searchStrings) {
        if (str && str.toUpperCase() === next.toUpperCase()) {
          return true;
        }
      }
    }
    return false;
  }

  public static startsWithAny(str: string | null, searchStrings: string[]): boolean {
    if (!str || CollectionUtil.isEmpty(searchStrings)) {
      return false;
    }
    for (const searchString of searchStrings) {
      if (str.startsWith(searchString)) {
        return true;
      }
    }
    return false;
  }

  public static containsAny(str: string | null, searchStrings: string[]): boolean {
    if (!str || CollectionUtil.isEmpty(searchStrings)) {
      return false;
    }
    for (const searchString of searchStrings) {
      if (str.indexOf(searchString) >= 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * Get first sentence regex
   */
  private static readonly GET_FIRST_SENTENCE_REGEX = /^(.*?[.!?])(?:\s|$)(?!.*\))/;
}
