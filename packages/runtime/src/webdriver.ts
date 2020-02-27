// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import { StringUtil } from '@excelium/common';
import { By, Key } from 'selenium-webdriver';
import { BrowserObject, Element, ElementArray, remote } from 'webdriverio';
import { enhanceElementsArray } from 'webdriverio/build/utils';
import { getElement, getElements } from 'webdriverio/build/utils/getElementObject';
import { AssertionError, VerificationError } from './errors';
import CommandObject from './model/command-object';
import { composePreprocessors, interpolateScript, interpolateString, preprocessArray } from './preprocessors';
import { absolutifyUrl } from './utils';
import Variables from './Variables';

/**
 * An operation did not complete before its timeout expired.
 */
class TimeoutError extends Error {}

const POLL_TIMEOUT = 50;
const DEFAULT_CAPABILITIES = {
  browserName: 'chrome',
};

const state = Symbol('state');

interface Hooks {
  [key: string]: (payload: any) => any;
}

interface ExecutorOpts {
  driver?: BrowserObject;
  capabilities?: any;
  server?: string;
  implicitWait?: number;
  hooks?: Hooks;
}

interface ExecutorState {
  openedWindows?: string[];
}

interface InitArgs {
  variables: Variables;
  baseUrl?: string;
  logger?: any;
}

export default class WebDriverExecutor {
  [x: string]: any;
  public variables: Variables;
  public hooks?: Hooks;

  private [state]: ExecutorState;

  private _driver?: BrowserObject;
  private capabilities?: any;
  private server?: string;
  private implicitWait?: number;

  private baseUrl?: string;
  private logger?: any;

  private initialized: boolean = false;
  private cancellable?: {
    cancel: () => void;
  };

  constructor({ driver, capabilities, server, hooks, implicitWait }: ExecutorOpts) {
    if (driver) {
      this._driver = driver;
    } else {
      this.capabilities = capabilities || DEFAULT_CAPABILITIES;
      this.server = server;
    }

    this.implicitWait = implicitWait || 5 * 1000;
    this.hooks = hooks;

    this.waitForNewWindow = this.waitForNewWindow.bind(this);
  }

  public async init({ baseUrl, logger, variables }: InitArgs) {
    this.baseUrl = baseUrl;
    this.variables = variables;
    this.logger = logger;
    this[state] = {};

    if (!this._driver) {
      let url = this.server;
      if (!url) {
        url = await this.executeHook('onPrepareService', {});
      }
      if (url) {
        const { protocol, hostname, port, pathname } = new URL(url);
        this._driver = await remote({
          protocol: protocol.substr(0, protocol.length - 1),
          hostname,
          port: parseInt(port, 10),
          path: pathname,
          logLevel: 'error',
          capabilities: this.capabilities,
        });
      } else {
        this._driver = await remote({
          logLevel: 'error',
          capabilities: this.capabilities,
        });
      }
    }
    this.initialized = true;
  }

  get driver() {
    return this._driver!;
  }

  public async cancel() {
    if (this.cancellable) {
      await this.cancellable.cancel();
    }
  }

  public async cleanup() {
    if (this.initialized) {
      await this.driver.deleteSession();
      this._driver = undefined;
      this.initialized = false;
    }
  }

  public isAlive() {
    // webdriver will throw for us, but not necessarily for all commands
    // TODO: check if there are commands that will succeed if we always return true
    return true;
  }

  public name(command: string) {
    if (!command) {
      return 'skip';
    }

    const upperCase = StringUtil.capitalize(command);
    const func = 'do' + upperCase;
    if (!this[func]) {
      throw new Error(`Unknown command ${command}`);
    }
    return func;
  }

  public async executeHook(hook: string, ...args: [any]) {
    if (this.hooks && this.hooks[hook]) {
      return await this.hooks[hook].apply(this, args);
    }
  }

  public async beforeCommand(commandObject: CommandObject) {
    if (commandObject.opensWindow) {
      this[state].openedWindows = await this.driver.getWindowHandles();
    }

    await this.executeHook('onBeforeCommand', { command: commandObject });
  }

  public async afterCommand(commandObject: CommandObject) {
    this.cancellable = undefined;
    if (commandObject.opensWindow) {
      const handle = await this.wait(this.waitForNewWindow, commandObject.windowTimeout);
      this.variables!.set(commandObject.windowHandleName!, handle);

      await this.executeHook('onWindowAppeared', {
        command: commandObject,
        windowHandleName: commandObject.windowHandleName,
        windowHandle: handle,
      });
    }

    await this.executeHook('onAfterCommand', { command: commandObject });
  }

  public async waitForNewWindow() {
    const currentHandles = await this.driver.getWindowHandles();
    return currentHandles.find(handle => !this[state].openedWindows!.includes(handle));
  }

  public registerCommand(commandName: string, fn: (param1?: string, param2?: string, param3?: string, command?: CommandObject) => Promise<any>) {
    this['do' + StringUtil.capitalize(commandName)] = fn;
  }

  public waitElementLocated(locator: By) {
    return async () => {
      return this.findElements(locator).then(elements => elements[0]);
    };
  }

  public waitStalenessOf(element: Element) {
    return async () => {
      return element.getTagName().then(
        () => false,
        () => true
      );
    };
  }

  public waitElementIsVisible(element: Element) {
    return async () => {
      return element.isDisplayed().then(v => (v ? element : null));
    };
  }

  public waitElementIsNotVisible(element: Element) {
    return async () => {
      return element.isDisplayed().then(v => (v ? null : element));
    };
  }

  public async findElement(by: By) {
    const res = (await this.driver.findElement(by.using, by.value)) as any;
    if (res.error) {
      throw new Error(res.error.message);
    }
    return getElement.call(this.driver, null, res);
  }

  public async findElements(by: By) {
    const res = (await this.driver.findElements(by.using, by.value)) as any;
    if (res.error) {
      throw new Error(res.error.message);
    }
    return enhanceElementsArray(getElements.call(this.driver, null, res), this.driver, null);
  }

  public async findElementFromElement(element: Element, by: By) {
    const res = (await this.driver.findElementFromElement(element.elementId, by.using, by.value)) as any;
    if (res.error) {
      throw new Error(res.error.message);
    }
    return getElement.call(this.driver, null, res);
  }

  public async findElementsFromElement(element: Element, by: By) {
    const res = (await this.driver.findElementsFromElement(element.elementId, by.using, by.value)) as any;
    if (res.error) {
      throw new Error(res.error.message);
    }
    return enhanceElementsArray(getElements.call(this.driver, null, res), this.driver, null);
  }

  public async findElementFromScript(script: string, args: any[]) {
    const res = (await this.driver.executeScript(script, args)) as any;
    if (res.error) {
      throw new Error(res.error.message);
    }
    return getElement.call(this.driver, null, res);
  }

  public async findElementsFromScript(script: string, args: any[]) {
    const res = (await this.driver.executeScript(script, args)) as any;
    if (res.error) {
      throw new Error(res.error.message);
    }
    return enhanceElementsArray(getElements.call(this.driver, null, res), this.driver, null);
  }

  public async moveTo(element: Element, xoffset?: number, yoffset?: number) {
    if (!this.driver.isW3C) {
      const { width, height } = await element.getSize();
      return element.moveTo(
        typeof xoffset === 'number' ? xoffset + width / 2 : undefined,
        typeof yoffset === 'number' ? yoffset + height / 2 : undefined
      );
    }

    await this.driver.performActions([
      {
        type: 'pointer',
        id: 'pointer1',
        parameters: { pointerType: 'mouse' },
        actions: [
          { type: 'pointerMove', origin: element, x: typeof xoffset === 'number' ? xoffset : 0, y: typeof yoffset === 'number' ? yoffset : 0 },
        ],
      },
    ]);
  }

  // Commands go after this line

  public async skip() {
    return Promise.resolve();
  }

  // window commands

  public async doOpen(url: string) {
    await this.driver.url(absolutifyUrl(url, this.baseUrl));
  }

  public async doSetWindowSize(widthXheight: string) {
    const [width, height] = widthXheight.split('x');
    await this.driver.setWindowSize(parseInt(width, 10), parseInt(height, 10));
  }

  public async doSelectWindow(handleLocator: string) {
    const prefix = 'handle=';
    if (handleLocator.startsWith(prefix)) {
      const handle = handleLocator.substr(prefix.length);
      await this.driver.switchToWindow(handle);
      await this.executeHook('onWindowSwitched', {
        windowHandle: handle,
      });
    } else {
      throw new Error('Invalid window handle given (e.g. handle=${handleVariable})');
    }
  }

  public async doClose() {
    await this.driver.closeWindow();
  }

  public async doSelectFrame(locator: string) {
    if (locator === 'relative=top') {
      await this.driver.switchToFrame(null);
    } else if (locator === 'relative=parent') {
      await this.driver.switchToParentFrame();
    } else if (locator.startsWith('index=')) {
      await this.driver.switchToFrame(+locator.substr('index='.length));
    } else {
      const element = await this.waitForElement(locator);
      await this.driver.switchToFrame(element);
    }
  }

  public async doSubmit() {
    throw new Error('"submit" is not a supported command in Selenium WebDriver. Please re-record the step.');
  }

  // mouse commands

  public async doAddSelection(locator: string, optionLocator: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const option = await this.findElementFromElement(element, parseOptionLocator(optionLocator));
    const selections = await this.findElementsFromScript('return arguments[0].selectedOptions', [element]);
    if (!findElement(selections, option)) {
      await option.click();
    }
  }

  public async doRemoveSelection(locator: string, optionLocator: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);

    if (!(await element.getAttribute('multiple'))) {
      throw new Error('Given element is not a multiple select type element');
    }

    const option = await this.findElementFromElement(element, parseOptionLocator(optionLocator));
    const selections = await this.findElementsFromScript('return arguments[0].selectedOptions', [element]);
    if (findElement(selections, option)) {
      await option.click();
    }
  }

  public async doCheck(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    if (!(await element.isSelected())) {
      await element.click();
    }
  }

  public async doUncheck(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    if (await element.isSelected()) {
      await element.click();
    }
  }

  public async doClick(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await element.click();
  }

  public async doClickAt(locator: string, coordString: string, _?: string, commandObject?: CommandObject) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await element.click(coords);
  }

  public async doDoubleClick(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await element.doubleClick();
  }

  public async doDoubleClickAt(locator: string, coordString: string, _?: string, commandObject?: CommandObject) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);

    if (!this.driver.isW3C) {
      const { width, height } = await element.getSize();
      await element.moveTo(coords.x + width / 2, coords.y + height / 2);
      return this.driver.positionDoubleClick();
    }

    await this.driver.performActions([
      {
        type: 'pointer',
        id: 'pointer1',
        parameters: { pointerType: 'mouse' },
        actions: [
          { type: 'pointerMove', origin: element, x: coords.x, y: coords.y },
          { type: 'pointerDown', button: 0 },
          { type: 'pointerUp', button: 0 },
          { type: 'pause', duration: 10 },
          { type: 'pointerDown', button: 0 },
          { type: 'pointerUp', button: 0 },
        ],
      },
    ]);

    await this.driver.releaseActions();
  }

  public async doDragAndDropToObject(dragLocator: string, dropLocator: string, _?: string, commandObject?: CommandObject) {
    const drag = await this.waitForElement(dragLocator, commandObject?.param1Fallback);
    const drop = await this.waitForElement(dropLocator, commandObject?.param2Fallback);
    await drag.dragAndDrop(drop);
  }

  public async doMouseDown(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);

    if (!this.driver.isW3C) {
      await element.moveTo();
      return this.driver.buttonDown();
    }

    await this.driver.performActions([
      {
        type: 'pointer',
        id: 'pointer1',
        parameters: { pointerType: 'mouse' },
        actions: [
          { type: 'pointerMove', origin: element, x: 0, y: 0 },
          { type: 'pointerDown', button: 0 },
        ],
      },
    ]);
  }

  public async doMouseDownAt(locator: string, coordString: string, _?: string, commandObject?: CommandObject) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);

    if (!this.driver.isW3C) {
      const { width, height } = await element.getSize();
      await element.moveTo(coords.x + width / 2, coords.y + height / 2);
      return this.driver.buttonDown();
    }

    await this.driver.performActions([
      {
        type: 'pointer',
        id: 'pointer1',
        parameters: { pointerType: 'mouse' },
        actions: [
          { type: 'pointerMove', origin: element, x: coords.x, y: coords.y },
          { type: 'pointerDown', button: 0 },
        ],
      },
    ]);
  }

  public async doMouseMoveAt(locator: string, coordString: string, _?: string, commandObject?: CommandObject) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await this.moveTo(element, coords.x, coords.y);
  }

  public async doMouseOut(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const [
      rect,
      vp,
    ] = await this.driver.executeScript('return [arguments[0].getBoundingClientRect(), {height: window.innerHeight, width: window.innerWidth}];', [
      element,
    ]);

    // try top
    if (rect.top > 0) {
      const y = Math.trunc(-(rect.height / 2 + 1));
      return await this.moveTo(element, undefined, y);
    }
    // try right
    else if (vp.width > rect.right) {
      const x = Math.trunc(rect.right / 2 + 1);
      return await this.moveTo(element, x, undefined);
    }
    // try bottom
    else if (vp.height > rect.bottom) {
      const y = Math.trunc(rect.height / 2 + 1);
      return await this.moveTo(element, undefined, y);
    }
    // try left
    else if (rect.left > 0) {
      const x = Math.trunc(-(rect.right / 2));
      return await this.moveTo(element, x, undefined);
    }

    throw new Error('Unable to perform mouse out as the element takes up the entire viewport');
  }

  public async doMouseOver(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await this.moveTo(element);
  }

  public async doMouseUp(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);

    if (!this.driver.isW3C) {
      await element.moveTo();
      return this.driver.buttonUp();
    }

    await this.driver.performActions([
      {
        type: 'pointer',
        id: 'pointer1',
        parameters: { pointerType: 'mouse' },
        actions: [
          { type: 'pointerMove', origin: element, x: 0, y: 0 },
          { type: 'pointerUp', button: 0 },
        ],
      },
    ]);
  }

  public async doMouseUpAt(locator: string, coordString: string, _?: string, commandObject?: CommandObject) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);

    if (!this.driver.isW3C) {
      const { width, height } = await element.getSize();
      await element.moveTo(coords.x + width / 2, coords.y + height / 2);
      return this.driver.buttonUp();
    }

    await this.driver.performActions([
      {
        type: 'pointer',
        id: 'pointer1',
        parameters: { pointerType: 'mouse' },
        actions: [
          { type: 'pointerMove', origin: element, x: coords.x, y: coords.y },
          { type: 'pointerUp', button: 0 },
        ],
      },
    ]);
  }

  public async doSelect(locator: string, optionLocator: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const option = await this.findElementFromElement(element, parseOptionLocator(optionLocator));
    await option.click();
  }

  // keyboard commands

  public async doEditContent(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await this.driver.executeScript(
      "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]} else {throw new Error('Element is not content editable')}",
      [element, value]
    );
  }

  public async doType(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await element.clearValue();
    await element.setValue(value);
  }

  public async doSendKeys(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    await element.setValue(value);
  }

  // wait commands

  public async doWaitForElementEditable(locator: string, timeout: string) {
    const element = await this.findElement(parseLocator(locator));
    await this.wait(async () => await this.isElementEditable(element), parseInt(timeout, 10), 'Timed out waiting for element to be editable');
  }

  public async doWaitForElementNotEditable(locator: string, timeout: string) {
    const element = await this.findElement(parseLocator(locator));
    await this.wait(async () => !(await this.isElementEditable(element)), parseInt(timeout, 10), 'Timed out waiting for element to not be editable');
  }

  public async doWaitForElementPresent(locator: string, timeout: string) {
    await this.wait(this.waitElementLocated(parseLocator(locator)), parseInt(timeout, 10));
  }

  public async doWaitForElementNotPresent(locator: string, timeout: string) {
    const parsedLocator = parseLocator(locator);
    const elements = await this.findElements(parsedLocator);
    if (elements.length !== 0) {
      await this.wait(this.waitStalenessOf(elements[0]), parseInt(timeout, 10));
    }
  }

  public async doWaitForElementVisible(locator: string, timeout: string) {
    const startTime = new Date();
    const element = await this.wait(this.waitElementLocated(parseLocator(locator)), parseInt(timeout, 10));
    const elapsed = new Date().getTime() - startTime.getTime();
    await this.wait(this.waitElementIsVisible(element), parseInt(timeout, 10) - elapsed);
  }

  public async doWaitForElementNotVisible(locator: string, timeout: string) {
    const parsedLocator = parseLocator(locator);
    const elements = await this.findElements(parsedLocator);

    if (elements.length > 0) {
      await this.wait(this.waitElementIsNotVisible(elements[0]), parseInt(timeout, 10));
    }
  }

  // script commands

  public async doRunScript(script: { script: string; argv: any[] }) {
    await this.driver.executeScript(script.script, ...script.argv);
  }

  public async doExecuteScript(script: { script: string; argv: any[] }, optionalVariable?: string) {
    const result = await this.driver.executeScript(script.script, ...script.argv);
    if (optionalVariable) {
      this.variables.set(optionalVariable, result);
    }
  }

  public async doExecuteAsyncScript(script: { script: string; argv: any[] }, optionalVariable?: string) {
    const result = await this.driver.executeAsyncScript(
      `var callback = arguments[arguments.length - 1];${script.script}.then(callback).catch(callback);`,
      script.argv
    );
    if (optionalVariable) {
      this.variables.set(optionalVariable, result);
    }
  }

  // alert commands

  public async doAcceptAlert() {
    await this.driver.acceptAlert();
  }

  public async doAcceptConfirmation() {
    await this.driver.acceptAlert();
  }

  public async doAnswerPrompt(optAnswer?: string) {
    if (optAnswer) {
      await this.driver.sendAlertText(optAnswer);
    }
    await this.driver.acceptAlert();
  }

  public async doDismissConfirmation() {
    await this.driver.dismissAlert();
  }

  public async doDismissPrompt() {
    await this.driver.dismissAlert();
  }

  // store commands

  public async doStore(string: string, variable: string) {
    this.variables.set(variable, string);
    return Promise.resolve();
  }

  public async doStoreAttribute(attributeLocator: string, variable: string) {
    const attributePos = attributeLocator.lastIndexOf('@');
    const elementLocator = attributeLocator.slice(0, attributePos);
    const attributeName = attributeLocator.slice(attributePos + 1);

    const element = await this.waitForElement(elementLocator);
    const value = await element.getAttribute(attributeName);
    this.variables.set(variable, value);
  }

  public async doStoreElementCount(locator: string, variable: string) {
    const elements = await this.findElements(parseLocator(locator));
    this.variables.set(variable, elements.length);
  }

  public async doStoreJson(json: any, variable: string) {
    this.variables.set(variable, JSON.parse(json));
    return Promise.resolve();
  }

  public async doStoreText(locator: string, variable: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const text = await element.getText();
    this.variables.set(variable, text);
  }

  public async doStoreTitle(variable: string) {
    const title = await this.driver.getTitle();
    this.variables.set(variable, title);
  }

  public async doStoreValue(locator: string, variable: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const value = await element.getAttribute('value');
    this.variables.set(variable, value);
  }

  public async doStoreWindowHandle(variable: string) {
    const handle = await this.driver.getWindowHandle();
    this.variables.set(variable, handle);
    await this.executeHook('onStoreWindowHandle', {
      windowHandle: handle,
      windowHandleName: variable,
    });
  }

  // assertions

  public async doAssert(variableName: string, value: string) {
    const variable = `${this.variables.get(variableName)}`;
    if (variable !== value) {
      throw new AssertionError("Actual value '" + variable + "' did not match '" + value + "'");
    }
  }

  public async doAssertAlert(expectedText: string) {
    const actualText = await this.driver.getAlertText();
    if (actualText !== expectedText) {
      throw new AssertionError("Actual alert text '" + actualText + "' did not match '" + expectedText + "'");
    }
  }

  public async doAssertConfirmation(expectedText: string) {
    const actualText = await this.driver.getAlertText();
    if (actualText !== expectedText) {
      throw new AssertionError("Actual confirm text '" + actualText + "' did not match '" + expectedText + "'");
    }
  }

  public async doAssertEditable(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    if (!(await this.isElementEditable(element))) {
      throw new AssertionError('Element is not editable');
    }
  }

  public async doAssertNotEditable(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    if (await this.isElementEditable(element)) {
      throw new AssertionError('Element is editable');
    }
  }

  public async doAssertPrompt(expectedText: string) {
    const actualText = await this.driver.getAlertText();
    if (actualText !== expectedText) {
      throw new AssertionError("Actual prompt text '" + actualText + "' did not match '" + expectedText + "'");
    }
  }

  public async doAssertTitle(title: string) {
    const actualTitle = await this.driver.getTitle();
    if (title !== actualTitle) {
      throw new AssertionError("Actual value '" + actualTitle + "' did not match '" + title + "'");
    }
  }

  public async doAssertElementPresent(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    await this.waitForElement(locator, commandObject?.param1Fallback);
  }

  public async doAssertElementNotPresent(locator: string) {
    const elements = await this.findElements(parseLocator(locator));
    if (elements.length) {
      throw new AssertionError('Unexpected element was found in page');
    }
  }

  public async doAssertText(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const text = await element.getText();
    if (text !== value) {
      throw new AssertionError("Actual value '" + text + "' did not match '" + value + "'");
    }
  }

  public async doAssertNotText(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const text = await element.getText();
    if (text === value) {
      throw new AssertionError("Actual value '" + text + "' did match '" + value + "'");
    }
  }

  public async doAssertValue(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue !== value) {
      throw new AssertionError("Actual value '" + elementValue + "' did not match '" + value + "'");
    }
  }

  // not generally implemented
  public async doAssertNotValue(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue === value) {
      throw new AssertionError("Actual value '" + elementValue + "' did match '" + value + "'");
    }
  }

  public async doAssertChecked(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    if (!(await element.isSelected())) {
      throw new AssertionError('Element is not checked, expected to be checked');
    }
  }

  public async doAssertNotChecked(locator: string, _?: string, __?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    if (await element.isSelected()) {
      throw new AssertionError('Element is checked, expected to be unchecked');
    }
  }

  public async doAssertSelectedValue(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue !== value) {
      throw new AssertionError("Actual value '" + elementValue + "' did not match '" + value + "'");
    }
  }

  public async doAssertNotSelectedValue(locator: string, value: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue === value) {
      throw new AssertionError("Actual value '" + elementValue + "' did match '" + value + "'");
    }
  }

  public async doAssertSelectedLabel(locator: string, label: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const selectedValue = await element.getAttribute('value');
    const selectedOption = await this.findElementFromElement(element, By.xpath(`option[@value="${selectedValue}"]`));
    const selectedOptionLabel = await selectedOption.getText();
    if (selectedOptionLabel !== label) {
      throw new AssertionError("Actual value '" + selectedOptionLabel + "' did not match '" + label + "'");
    }
  }

  public async doAssertNotSelectedLabel(locator: string, label: string, _?: string, commandObject?: CommandObject) {
    const element = await this.waitForElement(locator, commandObject?.param1Fallback);
    const selectedValue = await element.getAttribute('value');
    const selectedOption = await this.findElementFromElement(element, By.xpath(`option[@value="${selectedValue}"]`));
    const selectedOptionLabel = await selectedOption.getText();
    if (selectedOptionLabel === label) {
      throw new AssertionError("Actual value '" + selectedOptionLabel + "' not match '" + label + "'");
    }
  }

  // other commands

  public async doDebugger() {
    throw new Error('`debugger` is not supported in this run mode');
  }

  public async doEcho(string: string) {
    if (this.logger) {
      this.logger.log(`echo: ${string}`);
    }
  }

  public async doPause(time: number) {
    await this.driver.pause(time);
  }

  public async doRun() {
    throw new Error('`run` is not supported in this run mode');
  }

  public async doSetSpeed() {
    throw new Error('`set speed` is not supported in this run mode');
  }

  public async evaluateConditional(script: { script: string; argv: any[] }) {
    const result = await this.driver.executeScript(`return (${script.script})`, ...script.argv);
    return {
      value: !!result,
    };
  }

  public async waitForElement(locator: string, fallback?: string[][]): Promise<Element> {
    const elementLocator = parseLocator(locator);
    try {
      return await this.wait(this.waitElementLocated(elementLocator), this.implicitWait);
    } catch (err) {
      if (fallback) {
        for (const fb of fallback) {
          try {
            const loc = parseLocator(fb[0]);
            return await this.findElement(loc);
          } catch (e) {
            // try the next one
          }
        }
      }
      throw err;
    }
  }

  public async isElementEditable(element: Element) {
    const { enabled, readonly } = await this.driver.executeScript('return { enabled: !arguments[0].disabled, readonly: arguments[0].readOnly };', [
      element,
    ]);
    return enabled && !readonly;
  }

  public async wait(condition: (() => Promise<any>) | Promise<any>, timeout = 0, message?: string, pollTimeout = POLL_TIMEOUT): Promise<any> {
    if (typeof timeout !== 'number' || timeout < 0) {
      throw TypeError('timeout must be a number >= 0: ' + timeout);
    }

    if (typeof pollTimeout !== 'number' || pollTimeout < 0) {
      throw TypeError('pollTimeout must be a number >= 0: ' + pollTimeout);
    }

    if (condition instanceof Promise && typeof condition.then === 'function') {
      return new Promise((resolve, reject) => {
        if (!timeout) {
          resolve(condition);
          return;
        }

        const start = Date.now();
        let timer: NodeJS.Timeout | null = setTimeout(() => {
          timer = null;
          reject(new TimeoutError((message ? `${message}\n` : '') + 'Timed out waiting for promise to resolve after ' + (Date.now() - start) + 'ms'));
        }, timeout);
        const clearTimer = () => timer && clearTimeout(timer);

        condition.then(
          value => {
            clearTimer();
            resolve(value);
          },
          error => {
            clearTimer();
            reject(error);
          }
        );
      });
    }

    const fn: any = condition;
    if (typeof fn !== 'function') {
      throw TypeError('Wait condition must be a promise-like object, function');
    }

    const { driver } = this;
    function evaluateCondition() {
      return new Promise((resolve, reject) => {
        try {
          resolve(fn(driver));
        } catch (ex) {
          reject(ex);
        }
      });
    }

    const result = new Promise((resolve, reject) => {
      const startTime = Date.now();
      let cancelled = false;
      let resolveCancel: (value?: any) => void;
      const cancelPromise = new Promise(res => {
        resolveCancel = res;
      });
      this.cancellable = {
        cancel: () => {
          cancelled = true;
          return cancelPromise;
        },
      };
      const pollCondition = async () => {
        evaluateCondition().then(value => {
          const elapsed = Date.now() - startTime;
          if (cancelled) {
            resolveCancel();
            reject(new Error('Aborted by user'));
            this.cancellable = undefined;
          } else if (value) {
            resolve(value);
            this.cancellable = undefined;
          } else if (timeout && elapsed >= timeout) {
            reject(new TimeoutError((message ? `${message}\n` : '') + `Wait timed out after ${elapsed}ms`));
            this.cancellable = undefined;
          } else {
            setTimeout(pollCondition, pollTimeout);
          }
        }, reject);
      };
      pollCondition();
    });

    return result;
  }
}

WebDriverExecutor.prototype.doOpen = composePreprocessors(interpolateString, WebDriverExecutor.prototype.doOpen);

WebDriverExecutor.prototype.doSetWindowSize = composePreprocessors(interpolateString, WebDriverExecutor.prototype.doSetWindowSize);

WebDriverExecutor.prototype.doSelectWindow = composePreprocessors(interpolateString, WebDriverExecutor.prototype.doSelectWindow);

WebDriverExecutor.prototype.doSelectFrame = composePreprocessors(interpolateString, WebDriverExecutor.prototype.doSelectFrame);

WebDriverExecutor.prototype.doAnswerPrompt = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doAnswerPrompt);

WebDriverExecutor.prototype.doAddSelection = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
    param2Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doAddSelection
);

WebDriverExecutor.prototype.doRemoveSelection = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
    param2Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doRemoveSelection
);

WebDriverExecutor.prototype.doCheck = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doCheck
);

WebDriverExecutor.prototype.doUncheck = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doUncheck
);

WebDriverExecutor.prototype.doClick = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doClick
);

WebDriverExecutor.prototype.doClickAt = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doClickAt
);

WebDriverExecutor.prototype.doDoubleClick = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doDoubleClick
);

WebDriverExecutor.prototype.doDoubleClickAt = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doDoubleClickAt
);

WebDriverExecutor.prototype.doDragAndDropToObject = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
    param2Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doDragAndDropToObject
);

WebDriverExecutor.prototype.doMouseDown = composePreprocessors(
  interpolateString,
  null,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseDown
);

WebDriverExecutor.prototype.doMouseDownAt = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseDownAt
);

WebDriverExecutor.prototype.doMouseMoveAt = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseMoveAt
);

WebDriverExecutor.prototype.doMouseOut = composePreprocessors(
  interpolateString,
  null,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseOut
);

WebDriverExecutor.prototype.doMouseOver = composePreprocessors(
  interpolateString,
  null,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseOver
);

WebDriverExecutor.prototype.doMouseUp = composePreprocessors(
  interpolateString,
  null,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseUp
);

WebDriverExecutor.prototype.doMouseUpAt = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseUpAt
);

WebDriverExecutor.prototype.doSelect = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
    param2Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doSelect
);

WebDriverExecutor.prototype.doEditContent = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  {
    param1Fallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doEditContent
);

WebDriverExecutor.prototype.doType = composePreprocessors(
  interpolateString,
  interpolateString,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doType
);

WebDriverExecutor.prototype.doSendKeys = composePreprocessors(
  interpolateString,
  preprocessKeys,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doSendKeys
);

WebDriverExecutor.prototype.doRunScript = composePreprocessors(interpolateScript, WebDriverExecutor.prototype.doRunScript);

WebDriverExecutor.prototype.doExecuteScript = composePreprocessors(interpolateScript, null, WebDriverExecutor.prototype.doExecuteScript);

WebDriverExecutor.prototype.doExecuteAsyncScript = composePreprocessors(interpolateScript, null, WebDriverExecutor.prototype.doExecuteAsyncScript);

WebDriverExecutor.prototype.doStore = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doStore);

WebDriverExecutor.prototype.doStoreAttribute = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreAttribute
);

WebDriverExecutor.prototype.doStoreElementCount = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreElementCount
);

WebDriverExecutor.prototype.doStoreJson = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doStoreJson);

WebDriverExecutor.prototype.doStoreText = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreText
);

WebDriverExecutor.prototype.doStoreValue = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreValue
);

WebDriverExecutor.prototype.doAssert = composePreprocessors(null, interpolateString, WebDriverExecutor.prototype.doAssert);

WebDriverExecutor.prototype.doAssertAlert = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doAssertAlert);

WebDriverExecutor.prototype.doAssertConfirmation = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doAssertConfirmation);

WebDriverExecutor.prototype.doAssertEditable = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doAssertEditable
);

WebDriverExecutor.prototype.doAssertNotEditable = composePreprocessors(
  interpolateString,
  null,
  null,
  { param1Fallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doAssertNotEditable
);

WebDriverExecutor.prototype.doAssertPrompt = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doAssertPrompt);

WebDriverExecutor.prototype.doAssertText = composePreprocessors(interpolateString, interpolateString, WebDriverExecutor.prototype.doAssertText);

WebDriverExecutor.prototype.doEcho = composePreprocessors(interpolateString, WebDriverExecutor.prototype.doEcho);

function createVerifyCommands(Executor: any) {
  Object.getOwnPropertyNames(Executor.prototype)
    .filter(command => /^doAssert/.test(command))
    .forEach(assertion => {
      const verify = assertion.replace('doAssert', 'doVerify');
      Executor.prototype[verify] = {
        // creating the function inside an object since function declared in an
        // object are named after the property, thus creating dyanmic named funcs
        // also in order to be able to call(this) the function has to be normal
        // declaration rather than arrow, as arrow will be bound to
        // createVerifyCommands context which is undefined
        async [verify](...args: any) {
          try {
            return await Executor.prototype[assertion].call(this, ...args);
          } catch (err) {
            if (err instanceof AssertionError) {
              throw new VerificationError(err.message);
            }
            throw err;
          }
        },
      }[verify];
    });
}

createVerifyCommands(WebDriverExecutor);

function parseLocator(locator: string) {
  if (/^\/\//.test(locator)) {
    return By.xpath(locator);
  }
  const fragments = locator.split('=');
  const type = fragments.shift()!;
  const selector = fragments.join('=');
  const locatorFn = LOCATORS[type];
  if (locatorFn && selector) {
    return locatorFn(selector);
  } else {
    throw new Error(type ? `Unknown locator ${type}` : "Locator can't be empty");
  }
}

function parseOptionLocator(locator: string) {
  const fragments = locator.split('=');
  const type = fragments.shift()!;
  const selector = fragments.join('=');
  const locatorFn = OPTIONS_LOCATORS[type];
  if (locatorFn && selector) {
    return locatorFn(selector);
  } else if (!selector) {
    // no selector strategy given, assuming label
    return OPTIONS_LOCATORS.label(type);
  } else {
    throw new Error(type ? `Unknown selection locator ${type}` : "Locator can't be empty");
  }
}

function parseCoordString(coord: string) {
  const [x, y] = coord.split(',').map(n => parseInt(n, 10));

  return {
    x,
    y,
  };
}

function preprocessKeys(_str: string, variables?: Variables) {
  const str = interpolateString(_str, variables);
  const keys = [];
  const match = str.match(/\$\{\w+\}/g);
  if (!match) {
    keys.push(str);
  } else {
    let i = 0;
    while (i < str.length) {
      const currentKey = match.shift()!;
      const currentKeyIndex = str.indexOf(currentKey, i);
      if (currentKeyIndex > i) {
        // push the string before the current key
        keys.push(str.substr(i, currentKeyIndex - i));
        i = currentKeyIndex;
      }
      if (currentKey) {
        if (/^\$\{KEY_\w+\}/.test(currentKey)) {
          // is a key
          const keyName = currentKey.match(/\$\{KEY_(\w+)\}/)![1] as keyof typeof Key;
          const key = Key[keyName];
          if (key) {
            keys.push(key);
          } else {
            throw new Error(`Unrecognised key ${keyName}`);
          }
        } else {
          // not a key, and not a stored variable, push it as-is
          keys.push(currentKey);
        }
        i += currentKey.length;
      } else if (i < str.length) {
        // push the rest of the string
        keys.push(str.substr(i, str.length));
        i = str.length;
      }
    }
  }
  return keys;
}

interface Locators {
  [key: string]: (value: string) => By;
}

const LOCATORS: Locators = {
  id: By.id,
  name: By.name,
  link: By.linkText,
  linkText: By.linkText,
  partialLinkText: By.partialLinkText,
  css: By.css,
  xpath: By.xpath,
};

const OPTIONS_LOCATORS: Locators = {
  id: (id: string) => By.css(`*[id="${id}"]`),
  value: (value: string) => By.css(`*[value="${value}"]`),
  label: (label: string) => By.xpath(`//option[. = '${label}']`),
  index: (index: string) => By.css(`*:nth-child(${index})`),
};

function findElement(elements: ElementArray, element: Element) {
  const id = element.elementId;
  for (const e of elements) {
    if (e.elementId === id) {
      return true;
    }
  }
  return false;
}
