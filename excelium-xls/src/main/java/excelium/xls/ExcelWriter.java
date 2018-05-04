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

import excelium.common.ss.DateUtil;
import excelium.common.ss.RangeLocation;
import excelium.core.writer.AbstractTestWriter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Writes Microsoft Excel files.
 *
 * @author PhungDucKien
 * @since 2018.05.01
 */
public class ExcelWriter extends AbstractTestWriter {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Workbook object
     */
    protected Workbook workbook;

    /**
     * File path
     */
    private String filePath;

    /**
     * Instantiates a new Excel writer.
     *
     * @param workbook the workbook
     * @param filePath the file path
     * @throws IOException the io exception
     */
    ExcelWriter(Workbook workbook, String filePath) {
        this.workbook = workbook;
        this.filePath = filePath;
    }

    @Override
    public synchronized void flush() throws IOException {
        for (String range : flushValues.keySet()) {
            List<List<Object>> rangeValues = flushValues.get(range);
            if (CollectionUtils.isEmpty(rangeValues)) {
                continue;
            }
            RangeLocation rangeLocation = new RangeLocation(range);
            String sheetName = rangeLocation.getFirstCell().getSheetName();
            Sheet sheet = workbook.getSheet(sheetName);
            for (int r = rangeLocation.getFirstCell().getRow(); r <= rangeLocation.getLastCell().getRow(); r++) {
                int i = r - rangeLocation.getFirstCell().getRow();
                if (rangeValues.size() > i) {
                    List<Object> rowValues = rangeValues.get(i);
                    for (int c = rangeLocation.getFirstCell().getCol(); c <= rangeLocation.getLastCell().getCol(); c++) {
                        int j = c - rangeLocation.getFirstCell().getCol();
                        if (rowValues.size() > j) {
                            Object cellValue = rowValues.get(j);
                            setCellValue(sheet, r, c, cellValue);
                        }
                    }
                }
            }
        }
        write();
    }

    /**
     * Write out the workbook.
     *
     * @throws IOException the io exception
     */
    private void write() throws IOException {
        writeBackup(filePath);
        try (OutputStream stream = new FileOutputStream(new File(filePath))) {
            workbook.write(stream);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            writeFallback(filePath);
        }
    }

    /**
     * Backups file before any writing.
     *
     * @param filePath Source file to backup
     * @throws IOException the io exception
     */
    private void writeBackup(String filePath) throws IOException {
        String filePathWithoutExt = filePath.substring(0, filePath.lastIndexOf("."));
        String extension = filePath.substring(filePath.lastIndexOf("."));

        File file = new File(filePathWithoutExt + "(backup)" + extension);

        Files.copy(Paths.get(filePath), new FileOutputStream(file));
    }

    /**
     * Writes to fallback file if the give file is busy (occupied by another process)
     *
     * @param filePath File path
     * @throws IOException the io exception
     */
    private void writeFallback(String filePath) throws IOException {
        String filePathWithoutExt = filePath.substring(0, filePath.lastIndexOf("."));
        String extension = filePath.substring(filePath.lastIndexOf("."));

        int i = 1;
        File file;
        do {
            file = new File(filePathWithoutExt + "(" + i++ + ")" + extension);
        } while (file.exists());

        try (OutputStream stream = new FileOutputStream(file)) {
            workbook.write(stream);
        }
    }

    /**
     * Set value of a cell at specific location in a given sheet
     *
     * @param sheet Sheet
     * @param row   Row index
     * @param col   Column index
     * @param value Cell value
     */
    private void setCellValue(Sheet sheet, int row, int col, Object value) {
        Row r;
        try {
            r = sheet.getRow(row);
        } catch (RuntimeException e) {
            LOG.error("Error at " + row + "," + col);
            throw e;
        }
        if (r == null) {
            r = sheet.createRow(row);
        }
        Cell c;
        try {
            c = r.getCell(col);
        } catch (RuntimeException e) {
            LOG.error("Error at " + row + "," + col);
            throw e;
        }
        if (c == null) {
            c = r.createCell(col);
        }
        if (value instanceof String) {
            c.setCellValue((String) value);
        } else if (value instanceof Boolean) {
            c.setCellValue((boolean) value);
        } else if (value instanceof Calendar) {
            c.setCellValue((Calendar) value);
            ensureDateFormatted(c);
        } else if (value instanceof Date) {
            c.setCellValue((Date) value);
            ensureDateFormatted(c);
        } else if (value instanceof Double) {
            c.setCellValue((double) value);
        } else if (value instanceof Integer) {
            c.setCellValue(Integer.valueOf((int) value).doubleValue());
        } else if (value instanceof Long) {
            c.setCellValue(Long.valueOf((long) value).doubleValue());
        } else if (value == null) {
            c.setCellValue((String) null);
        }
    }

    /**
     * Ensures that specified cell is date formatted.
     *
     * @param cell Cell
     */
    private void ensureDateFormatted(Cell cell) {
        if (!DateUtil.isADateFormat(cell.getCellStyle().getDataFormatString())) {
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setDataFormat((short) 0xe);
            cell.setCellStyle(cellStyle);
        }
    }
}
