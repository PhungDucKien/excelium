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
import Color from 'color';
import CommandExecutor from '../src/command-executor';
import CommandFactory from '../src/command-factory';
import { AssertionError } from '../src/errors';
import { Accessor, Action, ArgType, text as _text } from '../src/model';
import Variables from '../src/Variables';
import WebDriverExecutor from '../src/webdriver';

/**
 * Tests for {@link CommandFactory}.
 *
 * @author PhungDucKien
 * @since 2018.05.18
 */
describe('test CommandFactory', () => {
  const f = jest.fn();

  class MyActionCommandExecutor extends CommandExecutor {
    public constructor(webDriver: WebDriverExecutor, project: Project) {
      super(webDriver, project);
    }

    public getActions(): Array<Action<any>> {
      return [
        new Action({
          execute: this.close.bind(this),
        }),
        new Action({
          args: {
            parentLocator: ArgType.exact(_text),
            locator: ArgType.exact(_text).isRequired(),
          },
          execute: this.click.bind(this),
        }),
        new Action({
          args: {
            text: ArgType.exact(_text).isRequired(),
            parentLocator: ArgType.exact(_text),
            locator: ArgType.exact(_text).isRequired(),
          },
          execute: this.input.bind(this),
        }),
        new Action({
          args: {
            text: ArgType.exact(_text).isRequired(),
            parentLocator: ArgType.exact(_text),
            locator: ArgType.exact(_text).isRequired(),
          },
          execute: this.verifyText.bind(this),
        }),
      ];
    }

    public async close() {
      expect(this).toBeInstanceOf(MyActionCommandExecutor);
      f(undefined, undefined, undefined);
    }

    public async click(parentLocator?: string, locator?: string) {
      expect(this).toBeInstanceOf(MyActionCommandExecutor);
      f(parentLocator, locator, undefined);
    }

    public async input(text?: string, parentLocator?: string, locator?: string) {
      expect(this).toBeInstanceOf(MyActionCommandExecutor);
      f(text, parentLocator, locator);
    }

    public async verifyText(text?: string, parentLocator?: string, locator?: string) {
      expect(this).toBeInstanceOf(MyActionCommandExecutor);
      f(text, parentLocator, locator);
    }
  }

  class MyAccessorCommandExecutor extends CommandExecutor {
    public constructor(webDriver: WebDriverExecutor, project: Project) {
      super(webDriver, project);
    }

    public getActions(): Array<Action<any>> {
      return [
        new Accessor({
          execute: this.getStringUrl.bind(this),
        }),
        new Accessor({
          args: {
            parentLocator: ArgType.exact(_text),
            locator: ArgType.exact(_text).isRequired(),
          },
          execute: this.getStringText.bind(this),
        }),
        new Accessor({
          args: {
            parentLocator: ArgType.exact(_text),
            locator: ArgType.exact(_text).isRequired(),
          },
          execute: this.getColor.bind(this),
        }),
      ];
    }

    public async getStringUrl() {
      expect(this).toBeInstanceOf(MyAccessorCommandExecutor);
      f(undefined, undefined, undefined);
      return 'OK';
    }

    public async getStringText(parentLocator?: string, locator?: string) {
      expect(this).toBeInstanceOf(MyAccessorCommandExecutor);
      f(parentLocator, locator, undefined);
      return 'OK';
    }

    public async getColor(parentLocator?: string, locator?: string): Promise<Color> {
      expect(this).toBeInstanceOf(MyAccessorCommandExecutor);
      f(parentLocator, locator, undefined);
      return new Color('black');
    }
  }

  test('Create action command map', () => {
    const webDriverExecutor = new WebDriverExecutor({});
    const commandExecutors = [new MyActionCommandExecutor(webDriverExecutor, new Project())];
    const commandMap = CommandFactory.createCommandMap(commandExecutors);

    expect(commandMap.size).toBe(5);

    expect(commandMap.get('click')?.param1).toBe('parentLocator');
    expect(commandMap.get('click')?.param2).toBe('locator');

    expect(commandMap.get('input')?.param1).toBe('text');
    expect(commandMap.get('input')?.param2).toBe('parentLocator');
    expect(commandMap.get('input')?.param3).toBe('locator');

    expect(commandMap.get('close')?.param1).toBe(null);

    expect(commandMap.get('verifyText')?.param1).toBe('text');
    expect(commandMap.get('verifyText')?.param2).toBe('parentLocator');
    expect(commandMap.get('verifyText')?.param3).toBe('locator');

    expect(commandMap.get('assertText')?.param1).toBe('text');
    expect(commandMap.get('assertText')?.param2).toBe('parentLocator');
    expect(commandMap.get('assertText')?.param3).toBe('locator');
  });

  test('Register action command executor', async () => {
    const webDriverExecutor = new WebDriverExecutor({});
    webDriverExecutor.registerCommandExecutors([MyActionCommandExecutor], new Project());

    await webDriverExecutor.doClick('id=1');
    expect(f).toBeCalledWith(undefined, 'id=1', undefined);

    await webDriverExecutor.doClick('id=1', 'id=2');
    expect(f).toBeCalledWith('id=1', 'id=2', undefined);

    await webDriverExecutor.doInput('text', 'id=1');
    expect(f).toBeCalledWith('text', undefined, 'id=1');

    await webDriverExecutor.doInput('text', 'id=1', 'id=2');
    expect(f).toBeCalledWith('text', 'id=1', 'id=2');

    await webDriverExecutor.doClose();
    expect(f).toBeCalledWith(undefined, undefined, undefined);

    await webDriverExecutor.doVerifyText('text', 'id=1');
    expect(f).toBeCalledWith('text', undefined, 'id=1');

    await webDriverExecutor.doVerifyText('text', 'id=1', 'id=2');
    expect(f).toBeCalledWith('text', 'id=1', 'id=2');

    await webDriverExecutor.doAssertText('text', 'id=1');
    expect(f).toBeCalledWith('text', undefined, 'id=1');

    await webDriverExecutor.doAssertText('text', 'id=1', 'id=2');
    expect(f).toBeCalledWith('text', 'id=1', 'id=2');
  });

  test('Create accessor command map', () => {
    const webDriverExecutor = new WebDriverExecutor({});
    const commandExecutors = [new MyAccessorCommandExecutor(webDriverExecutor, new Project())];
    const commandMap = CommandFactory.createCommandMap(commandExecutors);

    expect(commandMap.size).toBe(43);
  });

  test('Register accessor command executor', async () => {
    const webDriverExecutor = new WebDriverExecutor({});
    webDriverExecutor.registerCommandExecutors([MyAccessorCommandExecutor], new Project());
    webDriverExecutor.variables = new Variables();

    // new Expectations() {{
    //     executor.runAction(anyString);
    // }};

    // Url test
    await webDriverExecutor.doStoreUrl('var1');
    expect(webDriverExecutor.getVariable('var1')).toBe('OK');
    expect(f).toBeCalledWith(undefined, undefined, undefined);

    await webDriverExecutor.doVerifyUrl('OK');

    try {
      await webDriverExecutor.doVerifyUrl('NG');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyNotUrl('NG');

    try {
      await webDriverExecutor.doVerifyNotUrl('OK');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyUrlMatch('^O');

    try {
      await webDriverExecutor.doVerifyUrlMatch('O$');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyUrlNotMatch('^N');

    try {
      await webDriverExecutor.doVerifyUrlNotMatch('^O');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doWaitForUrl('OK');
    await webDriverExecutor.doWaitForNotUrl('NG');
    await webDriverExecutor.doWaitForUrlMatch('^O');
    await webDriverExecutor.doWaitForUrlNotMatch('O$');

    // commandMap.get("executeIfUrl(2)").getConsumer().accept("action1", "OK", null);
    // new Verifications() {{
    //     executor.runAction("action1");
    // }};

    // commandMap.get("executeIfUrl(2)").getConsumer().accept("action2", "NG", null);
    // new Verifications() {{
    //     executor.runAction("action2");
    //     times = 0;
    // }};

    // commandMap.get("executeIfNotUrl(2)").getConsumer().accept("action3", "NG", null);
    // new Verifications() {{
    //     executor.runAction("action3");
    // }};

    // commandMap.get("executeIfNotUrl(2)").getConsumer().accept("action4", "OK", null);
    // new Verifications() {{
    //     executor.runAction("action4");
    //     times = 0;
    // }};

    // commandMap.get("executeIfUrlMatch(2)").getConsumer().accept("action5", "^O", null);
    // new Verifications() {{
    //     executor.runAction("action5");
    // }};

    // commandMap.get("executeIfUrlMatch(2)").getConsumer().accept("action6", "O$", null);
    // new Verifications() {{
    //     executor.runAction("action6");
    //     times = 0;
    // }};

    // commandMap.get("executeIfUrlNotMatch(2)").getConsumer().accept("action7", "^N", null);
    // new Verifications() {{
    //     executor.runAction("action7");
    // }};

    // commandMap.get("executeIfUrlNotMatch(2)").getConsumer().accept("action8", "^O", null);
    // new Verifications() {{
    //     executor.runAction("action8");
    //     times = 0;
    // }};

    // Parent locator and locator test
    await webDriverExecutor.doStoreText('parentLocator', 'locator', 'var2');
    expect(webDriverExecutor.getVariable('var2')).toBe('OK');
    expect(f).toBeCalledWith('parentLocator', 'locator', undefined);

    await webDriverExecutor.doVerifyText('parentLocator', 'locator', 'OK');

    try {
      await webDriverExecutor.doVerifyText('parentLocator', 'locator', 'NG');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyNotText('parentLocator', 'locator', 'NG');

    try {
      await webDriverExecutor.doVerifyNotText('parentLocator', 'locator', 'OK');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyTextMatch('parentLocator', 'locator', '^O');

    try {
      await webDriverExecutor.doVerifyTextMatch('parentLocator', 'locator', 'O$');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyTextNotMatch('parentLocator', 'locator', '^N');

    try {
      await webDriverExecutor.doVerifyTextNotMatch('parentLocator', 'locator', '^O');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doWaitForText('parentLocator', 'locator', 'OK');
    await webDriverExecutor.doWaitForNotText('parentLocator', 'locator', 'NG');
    await webDriverExecutor.doWaitForTextMatch('parentLocator', 'locator', '^O');
    await webDriverExecutor.doWaitForTextNotMatch('parentLocator', 'locator', 'O$');

    // Locator only
    await webDriverExecutor.doStoreText('locator', 'var3');
    expect(webDriverExecutor.getVariable('var3')).toBe('OK');
    expect(f).toBeCalledWith(undefined, 'locator', undefined);

    await webDriverExecutor.doVerifyText('locator', 'OK');

    try {
      await webDriverExecutor.doVerifyText('locator', 'NG');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyNotText('locator', 'NG');

    try {
      await webDriverExecutor.doVerifyNotText('locator', 'OK');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyTextMatch('locator', '^O');

    try {
      await webDriverExecutor.doVerifyTextMatch('locator', 'O$');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyTextNotMatch('locator', '^N');

    try {
      await webDriverExecutor.doVerifyTextNotMatch('locator', '^O');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doWaitForText('locator', 'OK');
    await webDriverExecutor.doWaitForNotText('locator', 'NG');
    await webDriverExecutor.doWaitForTextMatch('locator', '^O');
    await webDriverExecutor.doWaitForTextNotMatch('locator', 'O$');

    // commandMap.get("executeIfText(3)").getConsumer().accept("textAction1", "locator", "OK");
    // new Verifications() {{
    //     executor.runAction("textAction1");
    // }};

    // commandMap.get("executeIfText(3)").getConsumer().accept("textAction2", "locator", "NG");
    // new Verifications() {{
    //     executor.runAction("textAction2");
    //     times = 0;
    // }};

    // commandMap.get("executeIfNotText(3)").getConsumer().accept("textAction3", "locator", "NG");
    // new Verifications() {{
    //     executor.runAction("textAction3");
    // }};

    // commandMap.get("executeIfNotText(3)").getConsumer().accept("textAction4", "locator", "OK");
    // new Verifications() {{
    //     executor.runAction("textAction4");
    //     times = 0;
    // }};

    // commandMap.get("executeIfTextMatch(3)").getConsumer().accept("textAction5", "locator", "^O");
    // new Verifications() {{
    //     executor.runAction("textAction5");
    // }};

    // commandMap.get("executeIfTextMatch(3)").getConsumer().accept("textAction6", "locator", "O$");
    // new Verifications() {{
    //     executor.runAction("textAction6");
    //     times = 0;
    // }};

    // commandMap.get("executeIfTextNotMatch(3)").getConsumer().accept("textAction7", "locator", "^N");
    // new Verifications() {{
    //     executor.runAction("textAction7");
    // }};

    // commandMap.get("executeIfTextNotMatch(3)").getConsumer().accept("textAction8", "locator", "^O");
    // new Verifications() {{
    //     executor.runAction("textAction8");
    //     times = 0;
    // }};

    // Color compare
    await webDriverExecutor.doStoreColor('parentLocator', 'locator', 'var4');
    expect(webDriverExecutor.getVariable('var4')).toStrictEqual(new Color('#000000'));
    expect(f).toBeCalledWith('parentLocator', 'locator', undefined);

    await webDriverExecutor.doVerifyColor('parentLocator', 'locator', '#000000');

    try {
      await webDriverExecutor.doVerifyColor('parentLocator', 'locator', '#000001');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyNotColor('parentLocator', 'locator', '#000001');

    try {
      await webDriverExecutor.doVerifyNotColor('parentLocator', 'locator', '#000000');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doStoreColor('locator', 'var5');
    expect(webDriverExecutor.getVariable('var5')).toStrictEqual(new Color('#000000'));
    expect(f).toBeCalledWith(undefined, 'locator', undefined);

    await webDriverExecutor.doVerifyColor('locator', '#000000');

    try {
      await webDriverExecutor.doVerifyColor('locator', '#000001');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }

    await webDriverExecutor.doVerifyNotColor('locator', '#000001');

    try {
      await webDriverExecutor.doVerifyNotColor('locator', '#000000');
      fail('AssertionError was not occured.');
    } catch (e) {
      expect(e).toBeInstanceOf(AssertionError);
    }
  });
});
