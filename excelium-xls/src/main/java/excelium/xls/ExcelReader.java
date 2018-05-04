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

import excelium.common.ss.CellLocation;
import excelium.common.ss.DateUtil;
import excelium.common.ss.RangeLocation;
import excelium.core.reader.AbstractTestReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static excelium.common.NumberUtil.getIntValue;
import static excelium.common.NumberUtil.getNumericValue;

/**
 * Reads Microsoft Excel files.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class ExcelReader extends AbstractTestReader<Workbook, Sheet> {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * File path
     */
    private String filePath;

    /**
     * Instantiates a new reader for a specific Excel file.
     *
     * @param filePath Path of file to read
     * @throws IOException if any IOException occurs
     */
    ExcelReader(String filePath) throws IOException {
        File file = Paths.get(filePath).toFile();

        this.filePath = filePath;
        if (file.getName().endsWith(".xlsx")) {
            this.workbook = new XSSFWorkbook(new FileInputStream(file));
        } else {
            this.workbook = new HSSFWorkbook(new FileInputStream(file));
        }
    }

    @Override
    public Workbook getWorkbook() throws IOException {
        return workbook;
    }

    @Override
    public String getWorkbookName() throws IOException {
        return filePath;
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
    public String getSheetName(Sheet sheet) {
        return sheet.getSheetName();
    }

    @Override
    public Map<Object, String> batchFindFirstOccurrence(List<Object> values, Sheet sheet) throws IOException {
        Map<Object, String> cellLocations = new HashMap<>();
        for (Object value : values) {
            if (StringUtils.isNotBlank(findFirstOccurrence(value, sheet))) {
                cellLocations.put(value, findFirstOccurrence(value, sheet));
            }
        }
        return cellLocations;
    }

    @Override
    public String findFirstOccurrence(Object value, Sheet sheet) {
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
                    if (cellValue != null && cellValue.equals(value)) {
                        CellLocation cellLocation = new CellLocation(sheet.getSheetName(), i, j, false, false);
                        return cellLocation.formatAsString();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Map<String, List<List<Object>>> batchGetRangeCellValues(String... ranges) throws IOException {
        Map<String, List<List<Object>>> rangeCellValues = new HashMap<>();
        for (String range : ranges) {
            RangeLocation rangeLocation = new RangeLocation(range);
            String sheetName = rangeLocation.getFirstCell().getSheetName();
            Sheet sheet = workbook.getSheet(sheetName);
            List<List<Object>> values = new ArrayList<>();
            for (int r = rangeLocation.getFirstCell().getRow(); r <= rangeLocation.getLastCell().getRow(); r++) {
                List<Object> rowValues = new ArrayList<>();
                for (int c = rangeLocation.getFirstCell().getCol(); c <= rangeLocation.getLastCell().getCol(); c++) {
                    rowValues.add(getCellValue(sheet, r, c));
                }
                values.add(rowValues);
            }
            rangeCellValues.put(rangeLocation.formatAsString(), values);
        }
        return rangeCellValues;
    }

    /**
     * Get value of a cell at specific location in a given sheet
     *
     * @param sheet Sheet
     * @param row   Row index
     * @param col   Column index
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
                CellStyle cellStyle = c.getCellStyle();
                Font cellFont = sheet.getWorkbook().getFontAt(cellStyle.getFontIndex());
                if (cellFont != null && cellFont.getStrikeout()) {
                    return null;
                }

                switch (c.getCellTypeEnum()) {
                    case STRING:
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
                        return c.getStringCellValue();
                    case NUMERIC:
                        return getNumericCellValue(c);
                    case BOOLEAN:
                        return c.getBooleanCellValue();
                    case FORMULA:
                        switch (c.getCachedFormulaResultTypeEnum()) {
                            case STRING:
                                return c.getStringCellValue();
                            case NUMERIC:
                                return getNumericCellValue(c);
                            case BOOLEAN:
                                return c.getBooleanCellValue();
                        }
                }
            }
        }
        return null;
    }

    /**
     * Get numeric cell value.
     * This method converts cell value to appropriate data type using cell data format.
     *
     * @param cell Cell object
     * @return numeric cell value
     */
    private Object getNumericCellValue(Cell cell) {
        String format = cell.getCellStyle().getDataFormatString();
        if (StringUtils.isBlank(format) || "General".equals(format)) {
            return getNumericValue(cell.getNumericCellValue());
        } else if (StringUtils.equalsAnyIgnoreCase(format, "TEXT", "@")) {
            return String.valueOf(getNumericValue(cell.getNumericCellValue()));
        } else if (DateUtil.isADateFormat(format)) {
            return cell.getDateCellValue();
        } else if (StringUtils.containsAny(format, ".0", ".#", ".?")) {
            return cell.getNumericCellValue();
        } else {
            return getIntValue(cell.getNumericCellValue());
        }
    }
}
