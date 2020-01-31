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

import { DataSource, Project } from '@excelium/model';
import inquirer from 'inquirer';
import DataSourceController from '../../src/controller/DataSourceController';

jest.mock('inquirer');

/**
 * Tests for {@link DataSourceController}.
 *
 * @author PhungDucKien
 * @since 2018.05.26
 */
describe('test DataSourceController', () => {
  // TODO
  // @Test
  // public void testAdd() throws IOException, JAXBException, IllegalAccessException {
  //     Project project = new Project();
  //     Deencapsulation.setField(dataSourceController, project);

  //     new MockUp<DatabaseServiceFactory>(){
  //         @Mock
  //         public DatabaseService createService(DataSource dataSource) {
  //             return databaseService;
  //         }
  //     };

  //     new Expectations() {{
  //         databaseService.testConnection(); result = true;

  //         consolePrompt.prompt((List<PromptableElementIF>) any);
  //         returns(new HashMap<String, ListResult>() {{ put("", new ListResult("MySQL")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("localhost")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("3306")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("dbname")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("user")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("passwd")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("default")); }});
  //     }};

  //     dataSourceController.add();

  //     Assert.assertEquals(1, project.getDataSources().size());
  //     Assert.assertEquals("default", project.getDefaultDataSource());
  //     Assert.assertEquals(DataSourceType.MYSQL, project.getDataSources().get("default").getType());
  //     Assert.assertEquals("com.mysql.cj.jdbc.Driver", project.getDataSources().get("default").getDriverClass());
  //     Assert.assertEquals("jdbc:mysql://localhost:3306/dbname", project.getDataSources().get("default").getUrl());
  //     Assert.assertEquals("user", project.getDataSources().get("default").getUserName());
  //     Assert.assertEquals("passwd", project.getDataSources().get("default").getPassword());

  //     new Verifications() {{
  //         projectGenerator.updateProject((Project) any, (Path) any);
  //     }};
  // }

  // @Test
  // public void testAddSecond() throws IOException, JAXBException, IllegalAccessException {
  //     Project project = new Project();
  //     Deencapsulation.setField(dataSourceController, project);

  //     new MockUp<DatabaseServiceFactory>(){
  //         @Mock
  //         public DatabaseService createService(DataSource dataSource) {
  //             return databaseService;
  //         }
  //     };

  //     new Expectations() {{
  //         databaseService.testConnection(); result = true;

  //         consolePrompt.prompt((List<PromptableElementIF>) any);
  //         returns(new HashMap<String, ListResult>() {{ put("", new ListResult("MySQL")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("localhost")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("3306")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("dbname")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("user")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("passwd")); }},
  //                 new HashMap<String, InputResult>() {{ put("", new InputResult("default")); }},
  //                 new HashMap<String, ListResult>() {{ put("", new ListResult("default")); }});

  //         project.setDefaultDataSource("ds2");
  //         project.setDataSources(new HashMap<String, DataSource>() {{
  //             put("ds2", new DataSource());
  //         }});
  //     }};

  //     dataSourceController.add();

  //     Assert.assertEquals(2, project.getDataSources().size());
  //     Assert.assertEquals("default", project.getDefaultDataSource());
  //     Assert.assertEquals(DataSourceType.MYSQL, project.getDataSources().get("default").getType());
  //     Assert.assertEquals("com.mysql.cj.jdbc.Driver", project.getDataSources().get("default").getDriverClass());
  //     Assert.assertEquals("jdbc:mysql://localhost:3306/dbname", project.getDataSources().get("default").getUrl());
  //     Assert.assertEquals("user", project.getDataSources().get("default").getUserName());
  //     Assert.assertEquals("passwd", project.getDataSources().get("default").getPassword());

  //     new Verifications() {{
  //         projectGenerator.updateProject((Project) any, (Path) any);
  //     }};
  // }

  test('remove non default', async () => {
    let updated = false;

    const dataSourceController = new DataSourceController();
    // @ts-ignore
    dataSourceController.projectProvider = () => {
      const project = new Project();
      project.defaultDataSource = 'ds3';
      project.dataSources = new Map([
        ['ds1', new DataSource()],
        ['ds2', new DataSource()],
        ['ds3', new DataSource()],
      ]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    dataSourceController.updateProjectFile = project => {
      expect(project.dataSources.size).toBe(2);
      updated = true;
    };

    // @ts-ignore
    inquirer.prompt.mockImplementationOnce(() => {
      return Promise.resolve({ prompt: 'ds2' });
    });

    await dataSourceController.remove();

    expect(updated).toBeTruthy();
  });

  test('remove default', async () => {
    let updated = false;

    const dataSourceController = new DataSourceController();
    // @ts-ignore
    dataSourceController.projectProvider = () => {
      const project = new Project();
      project.defaultDataSource = 'ds2';
      project.dataSources = new Map([
        ['ds1', new DataSource()],
        ['ds2', new DataSource()],
        ['ds3', new DataSource()],
      ]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    dataSourceController.updateProjectFile = project => {
      expect(project.dataSources.size).toBe(2);
      expect(project.defaultDataSource).toBe('ds3');
      updated = true;
    };

    inquirer.prompt
      // @ts-ignore
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'ds2' });
      })
      .mockImplementationOnce(() => {
        return Promise.resolve({ prompt: 'ds3' });
      });

    await dataSourceController.remove();

    expect(updated).toBeTruthy();
  });

  test('remove default 2', async () => {
    let updated = false;

    const dataSourceController = new DataSourceController();
    // @ts-ignore
    dataSourceController.projectProvider = () => {
      const project = new Project();
      project.defaultDataSource = 'ds2';
      project.dataSources = new Map([
        ['ds1', new DataSource()],
        ['ds2', new DataSource()],
      ]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    dataSourceController.updateProjectFile = project => {
      expect(project.dataSources.size).toBe(1);
      expect(project.defaultDataSource).toBe('ds1');
      updated = true;
    };

    // @ts-ignore
    inquirer.prompt.mockImplementationOnce(() => {
      return Promise.resolve({ prompt: 'ds2' });
    });

    await dataSourceController.remove();

    expect(updated).toBeTruthy();
  });

  test('remove last', async () => {
    let updated = false;

    const dataSourceController = new DataSourceController();
    // @ts-ignore
    dataSourceController.projectProvider = () => {
      const project = new Project();
      project.defaultDataSource = 'ds2';
      project.dataSources = new Map([['ds2', new DataSource()]]);
      return Promise.resolve(project);
    };
    // @ts-ignore
    dataSourceController.updateProjectFile = project => {
      expect(project.dataSources.size).toBe(0);
      expect(project.defaultDataSource).toBe(null);
      updated = true;
    };

    // @ts-ignore
    inquirer.prompt.mockImplementationOnce(() => {
      return Promise.resolve({ prompt: 'ds2' });
    });

    await dataSourceController.remove();

    expect(updated).toBeTruthy();
  });
});
