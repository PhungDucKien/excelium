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

package excelium.xls;

import excelium.common.CellLocation;
import excelium.core.reader.DefaultTestReader;
import excelium.model.project.Template;
import excelium.model.test.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Reads Microsoft Excel files.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class ExcelReader extends DefaultTestReader<Workbook, Sheet> {

    /** Logger */
    private static final Logger LOG = LogManager.getLogger();

    /** File path */
    private String filePath;

    /**
     * Instantiates a new reader for a specific Excel file.
     *
     * @param filePath Path of file to read
     * @throws IOException if any IOException occurs
     */
    public ExcelReader(String filePath) throws IOException {
        File file = Paths.get(filePath).toFile();

        this.filePath = filePath;
        if (file.getName().endsWith(".xlsx")) {
            this.workbook = new XSSFWorkbook(new FileInputStream(file));
        } else {
            this.workbook = new HSSFWorkbook(new FileInputStream(file));
        }
    }

    @Override
    public String getWorkbookName() throws IOException {
        return filePath;
    }

    @Override
    public Test parseTest(Template template) throws IOException {
        return null;
    }

    @Override
    public List<Sheet> listSheets() throws IOException {
        List<Sheet> sheetList = new ArrayList<>();
        Iterator<Sheet> sheetIterator = this.workbook.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            sheetList.add(sheet);
        }
        return sheetList;
    }

    @Override
    public String[] getMarkupLocations(List<Object> markups, Sheet sheet) throws IOException {
        String[] cellLocations = new String[markups.size()];

        int i = 0;
        for (Object markup : markups) {
            cellLocations[i] = getMarkupLocation(markup, sheet);
            i++;
        }
        return cellLocations;
    }

    /**
     * Searches the given sheet to find the location of the first cell that has
     * value matches the given markup.
     *
     * @param markup The markup to search
     * @param sheet Sheet
     * @return Cell location with sheet name. Return null if no cell found
     */
    private String getMarkupLocation(Object markup, Sheet sheet) {
        int firstRow = sheet.getFirstRowNum() < 0 ? 0 : sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum() < 0 ? 0 : sheet.getLastRowNum();

        for (int i = firstRow; i <= lastRow; i++) {
            Row r;
            try {
                r = sheet.getRow(i);
            } catch (RuntimeException e) {
                throw e;
            }
            if (r != null) {
                int firstCol = r.getFirstCellNum() < 0 ? 0 : r.getFirstCellNum();
                int lastCol = r.getLastCellNum() < 0 ? 0 : r.getLastCellNum();

                for (int j = firstCol; j <= lastCol; j++) {
                    Object cellValue = getCellValue(sheet, i, j);
                    if (cellValue != null && cellValue.equals(markup)) {
                        CellLocation cellLocation = new CellLocation(sheet.getSheetName(), i, j, false, false);
                        return cellLocation.formatAsString();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Get value of a cell at specific location in a given sheet
     *
     * @param sheet Sheet
     * @param row Row index
     * @param col Column index
     * @return Cell value
     */
    private Object getCellValue(Sheet sheet, int row, int col) {
        Row r;
        try {
            r = sheet.getRow(row);
        } catch (RuntimeException e) {
            LOG.error("Error at " + row + "," + col);
            throw e;
        }

        if (r != null) {
            Cell c;
            try {
                c = r.getCell(col);
            } catch (RuntimeException e) {
                LOG.error("Error at " + row + "," + col);
                throw e;
            }
            if (c != null) {
                if (c.getCellTypeEnum() == CellType.STRING) {
                    CellStyle cellStyle = c.getCellStyle();
                    Font cellFont = sheet.getWorkbook().getFontAt(cellStyle.getFontIndex());

                    RichTextString richText = c.getRichStringCellValue();
                    if (richText != null) {
                        XSSFRichTextString xssfRichText = (XSSFRichTextString) richText;
                        int runs = xssfRichText.numFormattingRuns();
                        if (runs > 0) {
                            StringBuilder plainText = new StringBuilder();
                            for (int i = 0; i < runs; i++) {
                                Font indexFont = xssfRichText.getFontOfFormattingRun(i);
                                if (indexFont == null) {
                                    indexFont = cellFont;
                                }
                                if (indexFont == null || !indexFont.getStrikeout()) {
                                    plainText.append(xssfRichText.getString().substring(xssfRichText.getIndexOfFormattingRun(i),
                                            xssfRichText.getIndexOfFormattingRun(i)
                                                    + xssfRichText.getLengthOfFormattingRun(i)));
                                }
                            }
                            if (plainText.length() > 0) {
                                return plainText.toString();
                            } else {
                                return null;
                            }
                        }
                    }
                    if (cellFont == null || !cellFont.getStrikeout()) {
                        return c.getStringCellValue();
                    } else {
                        return null;
                    }
                } else if (c.getCellTypeEnum() == CellType.FORMULA) {
                    if (c.getCachedFormulaResultTypeEnum() == CellType.STRING) {
                        return c.getStringCellValue();
                    } else if (c.getCachedFormulaResultTypeEnum() == CellType.NUMERIC) {
                        return c.getNumericCellValue();
                    }
                } else if (c.getCellTypeEnum() == CellType.NUMERIC) {
                    return c.getNumericCellValue();
                } else if (c.getCellTypeEnum() == CellType.BOOLEAN) {
                    return c.getBooleanCellValue();
                }
            }
        }
        return null;
    }

    /**
     * Get 2-dimension list of values of a cell range in a given sheet that identified by sheet name.
     *
     * @param sheetName Sheet name
     * @param range Range reference
     * @return A 2-dimension list of values of range.
     */
    public List<List<Object>> getRangeCellValues(String sheetName, String range) {
        Sheet sheet = workbook.getSheet(sheetName);
        Map<String, List<List<Object>>> values = getBatchRangeCellValues(sheet, range);
        return values.values().iterator().next();
    }

    /**
     * Get a map of 2-dimension list of values of multiple cell ranges in a given sheet that identified by sheet name.
     *
     * @param sheetName Sheet name
     * @param ranges Range array
     * @return Map of range object values. The key of the return map is range definition.
     */
    public Map<String, List<List<Object>>> getBatchRangeCellValues(String sheetName, String... ranges) {
        Sheet sheet = workbook.getSheet(sheetName);
        return getBatchRangeCellValues(sheet, ranges);
    }

    /**
     * Get a map of 2-dimension list of values of multiple cell ranges in a given sheet
     *
     * @param sheet Sheet
     * @param ranges Range array
     * @return Map of range object values. The key of the return map is range definition.
     */
    private Map<String, List<List<Object>>> getBatchRangeCellValues(Sheet sheet, String... ranges) {
        Map<String, List<List<Object>>> rangeCellValues = new HashMap<>();
        for (String range : ranges) {
            CellRangeAddress cellRangeAddress = CellRangeAddress.valueOf(range);
            List<List<Object>> values = new ArrayList<>();
            for (int r = cellRangeAddress.getFirstRow(); r <= cellRangeAddress.getLastRow(); r++) {
                List<Object> rowValues = new ArrayList<>();
                for (int c = cellRangeAddress.getFirstColumn(); c <= cellRangeAddress.getLastColumn(); c++) {
                    rowValues.add(getCellValue(sheet, r, c));
                }
                values.add(rowValues);
            }
            rangeCellValues.put(range, values);
        }
        return rangeCellValues;
    }
}
