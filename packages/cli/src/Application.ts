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
import 'reflect-metadata';

import { GenericTestReaderFactory, GenericTestWriterFactory } from '@excelium/core';
import { Project } from '@excelium/model';
import { GoogleConnection } from '@excelium/sheets';
import { sheets_v4 } from 'googleapis';
import { Container } from 'inversify';
import yargs from 'yargs';
import parse from 'yargs-parser';
import BeanFactory from './BeanFactory';
import { build, registerGroups } from './commander';

import './controller/DataSourceController';
import './controller/ProjectController';
import './controller/TemplateController';
import './controller/TestController';
import './controller/TestFileController';

/**
 * Excelium Command Line Application.
 * This class parses command line arguments and takes corresponding actions.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class Application {
  /**
   * Parses command line arguments and takes corresponding actions.
   *
   * @param args command line arguments
   */
  public static main(args: string[]): void {
    let customProjectFile: string | undefined;
    const argv = parse(args, {
      string: ['project-file'],
      alias: { 'project-file': ['f'] },
    });
    if (typeof argv.projectFile === 'string' || argv.projectFile instanceof String) {
      customProjectFile = argv.projectFile as string;
    }

    // Creates inversify container
    const container = new Container();
    container.bind<() => Promise<Project>>(BeanFactory.projectProvider).toProvider<Project>(BeanFactory.projectProvider(customProjectFile));
    container
      .bind<() => Promise<GoogleConnection | null>>(BeanFactory.googleConnectionProvider)
      .toProvider<GoogleConnection | null>(BeanFactory.googleConnectionProvider());
    container
      .bind<() => Promise<sheets_v4.Sheets | null>>(BeanFactory.sheetsServiceProvider)
      .toProvider<sheets_v4.Sheets | null>(BeanFactory.sheetsServiceProvider());
    container
      .bind<() => Promise<GenericTestReaderFactory>>(BeanFactory.testReaderFactoryProvider)
      .toProvider<GenericTestReaderFactory>(BeanFactory.testReaderFactoryProvider());
    container
      .bind<() => Promise<GenericTestWriterFactory>>(BeanFactory.testWriterFactoryProvider)
      .toProvider<GenericTestWriterFactory>(BeanFactory.testWriterFactoryProvider());

    // Registers controllers
    registerGroups(container);
    build(yargs, container);

    // Parses arguments and executes command
    yargs.scriptName(Application.PROGRAM_NAME).parse(args);
  }

  /**
   * Program name
   */
  private static readonly PROGRAM_NAME = 'excelium';
}
