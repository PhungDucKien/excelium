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

import { Prompt } from '@excelium/common';
import { DataSource, DataSourceType, Project } from '@excelium/model';
import { inject } from 'inversify';
import BeanFactory from '../BeanFactory';
import { action, group } from '../commander';
import BaseController from './BaseController';

/**
 * Provides commands for controlling data source.
 *
 * @author PhungDucKien
 * @since 2018.05.25
 */
@group({ name: 'ds' })
export default class DataSourceController extends BaseController {
  /**
   * Project instance
   */
  @inject(BeanFactory.projectProvider)
  protected projectProvider: () => Promise<Project>;

  /**
   * Adds data source.
   */
  @action({ name: 'add', options: BaseController.baseParameters })
  public async add(): Promise<void> {
    const project = await this.projectProvider();

    const dataSourceTypeId = await Prompt.promptList('What is the type of database you want to connect?', DataSourceType.getListChoice());
    const dataSourceType = DataSourceType.fromName(dataSourceTypeId);

    const dataSource = new DataSource();
    dataSource.type = dataSourceType;

    // TODO
    // let databaseName;

    // if (dataSourceType === DataSourceType.MYSQL || dataSourceType === DataSourceType.POSTGRESQL) {
    //   const driverClass = dataSourceType.getDriverClass();

    //   const databaseHost = await Prompt.promptInput('Database Host', 'localhost');
    //   const databasePort = await Prompt.promptInput('Database Port', String.valueOf(dataSourceType.getDefaultPort()));
    //   databaseName = await Prompt.promptInput('Database Name', dataSourceType);
    //   const userName = await Prompt.promptInput('User Name');
    //   const password = await Prompt.promptInput('Password');

    //   const url = dataSourceType.getUrl(databaseHost, databasePort, databaseName);

    //   dataSource.driverClass = driverClass;
    //   dataSource.url = url;
    //   dataSource.userName = userName;
    //   dataSource.password = password;
    // } else if (dataSourceType === DataSourceType.DYNAMODB) {
    //   databaseName = dataSourceType;
    // }

    // const databaseService = DatabaseServiceFactory.createService(dataSource);
    // const isConnectible = databaseService.testConnection();

    // if (isConnectible) {
    //   const dataSourceName = await Prompt.promptInput('Enter the name of the data source', databaseName);
    //   dataSource.name = dataSourceName;
    //   project.addDataSource(dataSource);

    //   if (project.dataSources.size === 1) {
    //     project.defaultDataSource = dataSource.name;
    //   } else {
    //     const defaultDataSource = await Prompt.promptList('Please choose the default data source', project.getDataSourceListChoice(false));
    //     project.defaultDataSource = defaultDataSource;
    //   }

    //   await this.updateProjectFile(project);
    // } else {
    //   console.error('The database is not connectible.');
    // }
  }

  /**
   * Removes data source.
   */
  @action({ name: 'remove', options: BaseController.baseParameters })
  public async remove(): Promise<void> {
    const project = await this.projectProvider();

    const removeDataSource = await Prompt.promptList('Choose the data source to remove:', project.getDataSourceListChoice(true));
    if (removeDataSource === DataSource.ALL) {
      project.dataSources.clear();
      project.defaultDataSource = null;
    } else {
      project.dataSources.delete(removeDataSource);
      if (project.defaultDataSource === removeDataSource) {
        if (project.dataSources.size === 0) {
          project.defaultDataSource = null;
        } else if (project.dataSources.size === 1) {
          project.defaultDataSource = project.dataSources.keys().next().value;
        } else {
          const defaultDataSource = await Prompt.promptList('Please choose the default data source', project.getDataSourceListChoice(false));
          project.defaultDataSource = defaultDataSource;
        }
      }
    }

    await this.updateProjectFile(project);
  }
}
