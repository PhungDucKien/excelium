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

import { JsonMarshaller, StringUtil } from '@excelium/common';
import { GenericTestReaderFactory, GenericTestWriterFactory } from '@excelium/core';
import { DataSource, Project, Template, TestFile, WorkbookType } from '@excelium/model';
import { GoogleConnection, GoogleConnectionService, SheetsReaderFactory, SheetsServiceProvider, SheetsWriterFactory } from '@excelium/sheets';
import { ExcelReaderFactory, ExcelWriterFactory } from '@excelium/xls';
import { plainToClass } from 'class-transformer';
import { sheets_v4 } from 'googleapis';
import { interfaces } from 'inversify';
import path from 'path';

/**
 * Provides bean factory methods for constructing injectable application beans.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class BeanFactory {
  /**
   * Reads the current working directory's project configuration file and constructs project instance.
   *
   * @return Project instance
   */
  public static projectProvider = (customProjectFile?: string) => {
    return () => {
      return async (): Promise<Project> => {
        const projectFilePath = !customProjectFile || StringUtil.isBlank(customProjectFile) ? 'excelium.json' : customProjectFile;
        const project = plainToClass(Project, await JsonMarshaller.unmarshall(projectFilePath), {
          targetMaps: [
            {
              target: Project,
              properties: {
                tests: TestFile,
                templates: Template,
                dataSources: DataSource,
              },
            },
          ],
        });
        project.basePath = path.dirname(path.resolve(projectFilePath));
        return project;
      };
    };
  };

  /**
   * Constructs a Google connection.
   *
   * @param project Project instance
   * @return Google connection if project uses Sheets file. Otherwise, return null.
   */
  public static googleConnectionProvider = () => {
    return (context: interfaces.Context) => {
      return async (): Promise<GoogleConnection | null> => {
        const projectProvider = context.container.get<() => Promise<Project>>(BeanFactory.projectProvider);
        const project = await projectProvider();
        if (project.workbookType === WorkbookType.SHEETS) {
          return new GoogleConnectionService();
        }
        return null;
      };
    };
  };

  /**
   * Constructs Sheets service.
   *
   * @param project    Project instance
   * @param connection Google connection
   * @return Sheets service if project uses Sheets file. Otherwise, return null.
   */
  public static sheetsServiceProvider = () => {
    return (context: interfaces.Context) => {
      return async (): Promise<sheets_v4.Sheets | null> => {
        const projectProvider = context.container.get<() => Promise<Project>>(BeanFactory.projectProvider);
        const project = await projectProvider();
        const googleConnectionProvider = context.container.get<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider);
        const googleConnection = await googleConnectionProvider();

        if (project.workbookType === WorkbookType.SHEETS && googleConnection != null) {
          const sheetsServiceProvider = new SheetsServiceProvider(googleConnection);
          return sheetsServiceProvider.createSheetsService();
        }
        return null;
      };
    };
  };

  /**
   * Constructs test reader factory
   *
   * @param project       Project instance
   * @param sheetsService Sheets service
   * @return Excel test reader factory if project uses Excel files. Sheets test reader factory if projects uses Sheets files.
   */
  public static testReaderFactoryProvider = () => {
    return (context: interfaces.Context) => {
      return async (): Promise<GenericTestReaderFactory> => {
        const projectProvider = context.container.get<() => Promise<Project>>(BeanFactory.projectProvider);
        const project = await projectProvider();
        const sheetsServiceProvider = context.container.get<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider);
        const sheetsService = await sheetsServiceProvider();

        if (project.workbookType === WorkbookType.SHEETS && sheetsService != null) {
          return new SheetsReaderFactory(sheetsService);
        } else {
          return new ExcelReaderFactory();
        }
      };
    };
  };

  /**
   * Constructs test writer factory
   *
   * @param project       Project instance
   * @param sheetsService Sheets service
   * @return Excel test writer factory if project uses Excel files. Sheets test writer factory if projects uses Sheets files.
   */
  public static testWriterFactoryProvider = () => {
    return (context: interfaces.Context) => {
      return async (): Promise<GenericTestWriterFactory> => {
        const projectProvider = context.container.get<() => Promise<Project>>(BeanFactory.projectProvider);
        const project = await projectProvider();
        const sheetsServiceProvider = context.container.get<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider);
        const sheetsService = await sheetsServiceProvider();

        if (project.workbookType === WorkbookType.SHEETS && sheetsService != null) {
          return new SheetsWriterFactory(sheetsService);
        } else {
          return new ExcelWriterFactory();
        }
      };
    };
  };
}
