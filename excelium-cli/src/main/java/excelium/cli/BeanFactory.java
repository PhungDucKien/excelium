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

package excelium.cli;

import com.google.api.services.sheets.v4.Sheets;
import excelium.cli.annotation.Bean;
import excelium.common.XmlMarshaller;
import excelium.core.reader.TestReaderFactory;
import excelium.core.writer.TestWriterFactory;
import excelium.model.enums.WorkbookType;
import excelium.model.project.Project;
import excelium.sheets.SheetsReaderFactory;
import excelium.sheets.SheetsServiceProvider;
import excelium.sheets.SheetsWriterFactory;
import excelium.sheets.connection.GoogleConnection;
import excelium.sheets.connection.GoogleConnectionService;
import excelium.xls.ExcelReaderFactory;
import excelium.xls.ExcelWriterFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Provides bean factory methods for constructing injectable application beans.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class BeanFactory {

    /**
     * Reads the current working directory's project configuration file and constructs project instance.
     *
     * @return Project instance
     * @throws JAXBException the jaxb exception
     */
    @Bean
    public Project getProject() throws JAXBException {
        return (Project) XmlMarshaller.unmarshall(Paths.get("project.xml"), Project.class);
    }

    /**
     * Constructs a Google connection.
     *
     * @param project Project instance
     * @return Google connection if project uses Sheets file. Otherwise, return null.
     */
    @Bean
    public GoogleConnection getGoogleConnection(Project project) {
        if (project.getWorkbookType() == WorkbookType.SHEETS) {
            return new GoogleConnectionService();
        }
        return null;
    }

    /**
     * Constructs Sheets service.
     *
     * @param project    Project instance
     * @param connection Google connection
     * @return Sheets service if project uses Sheets file. Otherwise, return null.
     * @throws IOException if IOException occurs
     */
    @Bean
    public Sheets getSheetsService(Project project, GoogleConnection connection) throws IOException {
        if (project.getWorkbookType() == WorkbookType.SHEETS && connection != null) {
            SheetsServiceProvider sheetsServiceProvider = new SheetsServiceProvider(connection);
            return sheetsServiceProvider.createSheetsService();
        }
        return null;
    }

    /**
     * Constructs test reader factory
     *
     * @param project       Project instance
     * @param sheetsService Sheets service
     * @return Excel test reader factory if project uses Excel files. Sheets test reader factory if projects uses Sheets files.
     */
    @Bean
    public TestReaderFactory getTestReaderFactory(Project project, Sheets sheetsService) {
        if (project.getWorkbookType() == WorkbookType.SHEETS) {
            return new SheetsReaderFactory(sheetsService);
        } else {
            return new ExcelReaderFactory();
        }
    }

    /**
     * Constructs test writer factory
     *
     * @param project       Project instance
     * @param sheetsService Sheets service
     * @return Excel test writer factory if project uses Excel files. Sheets test writer factory if projects uses Sheets files.
     */
    @Bean
    public TestWriterFactory getTestWriterFactory(Project project, Sheets sheetsService) {
        if (project.getWorkbookType() == WorkbookType.SHEETS) {
            return new SheetsWriterFactory(sheetsService);
        } else {
            return new ExcelWriterFactory();
        }
    }
}
