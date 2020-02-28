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

import { Project } from '@excelium/model';
import { Variables, WebDriverExecutor } from '@excelium/runtime';
import { createChrome, createServices, createStaticSite } from '@excelium/testkit';
import { AddressInfo } from 'net';
import { DriverService } from 'selenium-webdriver/remote';
import { promisify } from 'util';
import { BrowserObject } from 'webdriverio';
import AlertCommandExecutor from '../src/AlertCommandExecutor';

jest.setTimeout(30000);

describe('AlertCommandExecutor', () => {
  const services = createServices();
  const app = createStaticSite();
  let port: number;
  let close: () => void;
  let driverService: DriverService;
  let driver: BrowserObject;
  let executor: WebDriverExecutor;
  let variables: Variables;

  beforeAll(async () => {
    await new Promise(res => {
      const server = app.listen(() => {
        port = (server.address() as AddressInfo).port;
        close = promisify(server.close.bind(server));
        res();
      });
    });
  });
  afterAll(async () => {
    await close();
  });
  beforeAll(async () => {
    variables = new Variables();
    driverService = services.chromeService.build();
    driver = await createChrome(await driverService.start());
    executor = new WebDriverExecutor({ driver });
    await executor.init({ variables });
    executor.registerCommandExecutors([AlertCommandExecutor], new Project());
  });
  afterAll(async () => {
    await driver.deleteSession();
    await driverService.kill();
  });
  afterEach(async () => {
    try {
      await driver.releaseActions();
    } catch (err) {
      // chromedriver doesn't support clear()
    }
  });
  describe('accept alert', () => {
    it('should dismiss an alert', async () => {
      await driver.url(`http://localhost:${port}/popup/alert.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doAcceptAlert();
      await element.click();
      // accepting twice to make sure that we can interact with the page
      // after accepting initially
      await executor.doAcceptAlert();
    });
  });
  describe('answer prompt', () => {
    it('should answer prompt', async () => {
      await driver.url(`http://localhost:${port}/popup/prompt.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doAnswerPrompt('hello');
      await driver.pause(10);
      expect(await driver.getTitle()).toBe('hello');
      await element.click();
      await executor.doAnswerPrompt('world');
      await driver.pause(10);
      expect(await driver.getTitle()).toBe('world');
      await element.click();
      await executor.doAnswerPrompt('');
      await driver.pause(10);
      expect(await driver.getTitle()).toBe('empty');
    });
  });
  describe('assert alert', () => {
    it('should assert alert visibility', async () => {
      expect.assertions(1);
      await driver.url(`http://localhost:${port}/popup/alert.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doAssertAlert('test');
      await expect(executor.doAssertAlert('wat')).rejects.toThrow("Actual text 'test' did not match 'wat'");
      await driver.acceptAlert();
    });
  });
  describe('assert confirmation', () => {
    it('should assert confirmation visibility', async () => {
      expect.assertions(1);
      await driver.url(`http://localhost:${port}/popup/confirm.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doAssertConfirmation('test');
      await expect(executor.doAssertConfirmation('wat')).rejects.toThrow("Actual text 'test' did not match 'wat'");
      await driver.dismissAlert();
    });
  });
  describe('assert prompt', () => {
    it('should assert prompt visibility', async () => {
      expect.assertions(1);
      await driver.url(`http://localhost:${port}/popup/prompt.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doAssertPrompt('test');
      await expect(executor.doAssertPrompt('wat')).rejects.toThrow("Actual text 'test' did not match 'wat'");
      await driver.dismissAlert();
    });
  });
  describe('dismiss confirmation', () => {
    it('should dismiss a confirmation', async () => {
      await driver.url(`http://localhost:${port}/popup/confirm.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doDismissConfirmation();
      await element.click();
      // accepting twice to make sure that we can interact with the page
      // after accepting initially
      await executor.doDismissConfirmation();
    });
  });
  describe('dismiss prompt', () => {
    it('should dismiss a prompt', async () => {
      await driver.url(`http://localhost:${port}/popup/prompt.html`);
      const element = await driver.$('button');
      await element.click();
      await executor.doDismissPrompt();
      await element.click();
      // accepting twice to make sure that we can interact with the page
      // after accepting initially
      await executor.doDismissPrompt();
    });
  });
});
