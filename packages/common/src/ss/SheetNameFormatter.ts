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

import StringUtil from '../StringUtil';
import CellLocation from './CellLocation';

/**
 * Formats sheet names for use in formula expressions.
 *
 * @author Josh Micich
 */
export default class SheetNameFormatter {
  /**
   * Used to format sheet names as they would appear in cell formula expressions.
   *
   * @return the sheet name unchanged if there is no need for delimiting.  Otherwise the sheet
   * name is enclosed in single quotes (').  Any single quotes which were already present in the
   * sheet name will be converted to double single quotes ('').
   */
  public static format(rawSheetName: string): string {
    return SheetNameFormatter.appendFormat('', rawSheetName);
  }

  /**
   * Convenience method for ({@link #format(String)}) when a StringBuilder is already available.
   *
   * @param out          - sheet name will be appended here possibly with delimiting quotes
   * @param rawSheetName - sheet name
   * @param workbookName - workbook name
   */
  public static appendFormat(out: string, rawSheetName: string, workbookName?: string): string {
    const needsQuotes = SheetNameFormatter.needsDelimiting(workbookName) || SheetNameFormatter.needsDelimiting(rawSheetName);
    if (needsQuotes) {
      out += SheetNameFormatter.DELIMITER;
      if (workbookName && StringUtil.isNotBlank(workbookName)) {
        out += '[';
        out = SheetNameFormatter.appendAndEscape(out, workbookName.replace('[', '(').replace(']', ')'));
        out += ']';
      }
      out = SheetNameFormatter.appendAndEscape(out, rawSheetName);
      out += SheetNameFormatter.DELIMITER;
    } else {
      if (workbookName && StringUtil.isNotBlank(workbookName)) {
        out += '[';
        out += workbookName;
        out += ']';
      }
      out += rawSheetName;
    }
    return out;
  }

  /**
   * Used to decide whether sheet names like 'AB123' need delimiting due to the fact that they
   * look like cell references.
   * <p>
   * This code is currently being used for translating formulas represented with <code>Ptg</code>
   * tokens into human readable text form.  In formula expressions, a sheet name always has a
   * trailing '!' so there is little chance for ambiguity.  It doesn't matter too much what this
   * method returns but it is worth noting the likely consumers of these formula text strings:
   * <ol>
   * <li>POI's own formula parser</li>
   * <li>Visual reading by human</li>
   * <li>VBA automation entry into Excel cell contents e.g.  ActiveCell.Formula = "=c64!A1"</li>
   * <li>Manual entry into Excel cell contents</li>
   * <li>Some third party formula parser</li>
   * </ol>
   * <p>
   * At the time of writing, POI's formula parser tolerates cell-like sheet names in formulas
   * with or without delimiters.  The same goes for Excel(2007), both manual and automated entry.
   * <p>
   * For better or worse this implementation attempts to replicate Excel's formula renderer.
   * Excel uses range checking on the apparent 'row' and 'column' components.  Note however that
   * the maximum sheet size varies across versions.
   *
   * @see CellLocation
   */
  /* package */
  public static cellReferenceIsWithinRange(lettersPrefix: string, numbersSuffix: string): boolean {
    return CellLocation.cellReferenceIsWithinRange(lettersPrefix, numbersSuffix);
  }

  /**
   * Note - this method assumes the specified rawSheetName has only letters and digits.  It
   * cannot be used to match absolute or range references (using the dollar or colon char).
   * <p>
   * Some notable cases:
   * <blockquote><table border="0" cellpadding="1" cellspacing="0"
   * summary="Notable cases.">
   * <tr><th>Input&nbsp;</th><th>Result&nbsp;</th><th>Comments</th></tr>
   * <tr><td>"A1"&nbsp;&nbsp;</td><td>true</td><td>&nbsp;</td></tr>
   * <tr><td>"a111"&nbsp;&nbsp;</td><td>true</td><td>&nbsp;</td></tr>
   * <tr><td>"AA"&nbsp;&nbsp;</td><td>false</td><td>&nbsp;</td></tr>
   * <tr><td>"aa1"&nbsp;&nbsp;</td><td>true</td><td>&nbsp;</td></tr>
   * <tr><td>"A1A"&nbsp;&nbsp;</td><td>false</td><td>&nbsp;</td></tr>
   * <tr><td>"A1A1"&nbsp;&nbsp;</td><td>false</td><td>&nbsp;</td></tr>
   * <tr><td>"A$1:$C$20"&nbsp;&nbsp;</td><td>false</td><td>Not a plain cell reference</td></tr>
   * <tr><td>"SALES20080101"&nbsp;&nbsp;</td><td>true</td>
   * <td>Still needs delimiting even though well out of range</td></tr>
   * </table></blockquote>
   *
   * @return <code>true</code> if there is any possible ambiguity that the specified rawSheetName
   * could be interpreted as a valid cell name.
   */
  /* package */
  public static nameLooksLikePlainCellReference(rawSheetName: string): boolean {
    const matcher = SheetNameFormatter.CELL_REF_PATTERN.exec(rawSheetName);
    if (!matcher) {
      return false;
    }

    // rawSheetName === "Sheet1" gets this far.
    const lettersPrefix = matcher[1];
    const numbersSuffix = matcher[2];
    return SheetNameFormatter.cellReferenceIsWithinRange(lettersPrefix, numbersSuffix);
  }

  private static readonly DELIMITER = "'";

  /**
   * Matches a single cell ref with no absolute ('$') markers
   */
  private static readonly CELL_REF_PATTERN = /^([A-Za-z]+)([0-9]+)$/;

  private static appendAndEscape(sb: string, rawSheetName: string): string {
    const len = rawSheetName.length;
    for (let i = 0; i < len; i++) {
      const ch = rawSheetName.charAt(i);
      if (ch === SheetNameFormatter.DELIMITER) {
        // single quotes (') are encoded as ('')
        sb += SheetNameFormatter.DELIMITER;
      }
      sb += ch;
    }
    return sb;
  }

  private static needsDelimiting(rawSheetName?: string): boolean {
    if (!rawSheetName) {
      return false;
    }
    const len = rawSheetName.length;
    if (len < 1) {
      throw new Error('Zero length string is an invalid sheet name');
    }
    if (/^[0-9]$/.test(rawSheetName.charAt(0))) {
      // sheet name with digit in the first position always requires delimiting
      return true;
    }
    for (let i = 0; i < len; i++) {
      const ch = rawSheetName.charAt(i);
      if (SheetNameFormatter.isSpecialChar(ch)) {
        return true;
      }
    }
    if (/^[A-Z]$/i.test(rawSheetName.charAt(0)) && /^[0-9]$/.test(rawSheetName.charAt(len - 1))) {
      // note - values like "A$1:$C$20" don't get this far
      if (SheetNameFormatter.nameLooksLikePlainCellReference(rawSheetName)) {
        return true;
      }
    }
    if (SheetNameFormatter.nameLooksLikeBooleanLiteral(rawSheetName)) {
      return true;
    }
    // Error constant literals all contain '#' and other special characters
    // so they don't get this far
    return false;
  }

  private static nameLooksLikeBooleanLiteral(rawSheetName: string): boolean {
    switch (rawSheetName.charAt(0)) {
      case 'T':
      case 't':
        return rawSheetName.toUpperCase() === 'TRUE';
      case 'F':
      case 'f':
        return rawSheetName.toUpperCase() === 'FALSE';
    }
    return false;
  }

  /**
   * @return <code>true</code> if the presence of the specified character in a sheet name would
   * require the sheet name to be delimited in formulas.  This includes every non-alphanumeric
   * character besides underscore '_' and dot '.'.
   */
  /* package */
  private static isSpecialChar(ch: string): boolean {
    // note - Character.isJavaIdentifierPart() would allow dollars '$'
    if (/^[0-9A-Z]$/i.test(ch)) {
      return false;
    }
    switch (ch) {
      case '.': // dot is OK
      case '_': // underscore is OK
        return false;
      case '\n':
      case '\r':
      case '\t':
        throw new Error('Illegal character (0x' + parseInt(ch.charCodeAt(0).toString(), 16) + ') found in sheet name');
    }
    return true;
  }

  private constructor() {
    // no instances of this class
  }
}
