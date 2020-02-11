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

import webdriver, { By, Condition, Key, until, WebDriver, WebElement, WebElementCondition, WebElementPromise } from 'selenium-webdriver';
import { AssertionError, VerificationError } from './errors';
import CommandObject from './model/command-object';
import { composePreprocessors, interpolateScript, interpolateString, preprocessArray } from './preprocessors';
import { absolutifyUrl } from './utils';
import Variables from './Variables';

const { TimeoutError } = webdriver.error;

const POLL_TIMEOUT = 50;
const DEFAULT_CAPABILITIES = {
  browserName: 'chrome',
};

const state = Symbol('state');

interface Hooks {
  [key: string]: (payload: any) => void;
}

interface ExecutorOpts {
  driver?: WebDriver;
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

  private _driver?: WebDriver;
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
      this._driver = await new webdriver.Builder()
        .withCapabilities(this.capabilities)
        .usingServer(this.server!)
        .build();
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
      await this.driver.quit();
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

    const upperCase = command.charAt(0).toUpperCase() + command.slice(1);
    const func = 'do' + upperCase;
    // @ts-ignore
    if (!this[func]) {
      throw new Error(`Unknown command ${command}`);
    }
    return func;
  }

  public async executeHook(hook: string, ...args: [any]) {
    if (this.hooks && this.hooks[hook]) {
      await this.hooks[hook].apply(this, args);
    }
  }

  public async beforeCommand(commandObject: CommandObject) {
    if (commandObject.opensWindow) {
      this[state].openedWindows = await this.driver.getAllWindowHandles();
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
    const currentHandles = await this.driver.getAllWindowHandles();
    return currentHandles.find(handle => !this[state].openedWindows!.includes(handle));
  }

  public registerCommand(commandName: string, fn: (target?: string, value?: string) => void) {
    // @ts-ignore
    this['do' + commandName.charAt(0).toUpperCase() + commandName.slice(1)] = fn;
  }

  // Commands go after this line

  public async skip() {
    return Promise.resolve();
  }

  // window commands

  public async doOpen(url: string) {
    await this.driver.get(absolutifyUrl(url, this.baseUrl));
  }

  public async doSetWindowSize(widthXheight: string) {
    const [width, height] = widthXheight.split('x');
    await this.driver
      .manage()
      .window()
      .setSize(parseInt(width, 10), parseInt(height, 10));
  }

  public async doSelectWindow(handleLocator: string) {
    const prefix = 'handle=';
    if (handleLocator.startsWith(prefix)) {
      const handle = handleLocator.substr(prefix.length);
      await this.driver.switchTo().window(handle);
      await this.executeHook('onWindowSwitched', {
        windowHandle: handle,
      });
    } else {
      throw new Error('Invalid window handle given (e.g. handle=${handleVariable})');
    }
  }

  public async doClose() {
    await this.driver.close();
  }

  public async doSelectFrame(locator: string) {
    const targetLocator = this.driver.switchTo();
    if (locator === 'relative=top') {
      await targetLocator.defaultContent();
    } else if (locator === 'relative=parent') {
      // TODO
      // await targetLocator.parentFrame();
    } else if (locator.startsWith('index=')) {
      await targetLocator.frame(+locator.substr('index='.length));
    } else {
      const element = await this.waitForElement(locator);
      await targetLocator.frame(element);
    }
  }

  public async doSubmit() {
    throw new Error('"submit" is not a supported command in Selenium WebDriver. Please re-record the step.');
  }

  // mouse commands

  public async doAddSelection(locator: string, optionLocator: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const option = await element.findElement(parseOptionLocator(optionLocator));
    const selections = await this.driver.executeScript('return arguments[0].selectedOptions', element);
    if (!(await findElement(selections as WebElement[], option))) {
      await option.click();
    }
  }

  public async doRemoveSelection(locator: string, optionLocator: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);

    if (!(await element.getAttribute('multiple'))) {
      throw new Error('Given element is not a multiple select type element');
    }

    const option = await element.findElement(parseOptionLocator(optionLocator));
    const selections = await this.driver.executeScript('return arguments[0].selectedOptions', element);
    if (await findElement(selections as WebElement[], option)) {
      await option.click();
    }
  }

  public async doCheck(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    if (!(await element.isSelected())) {
      await element.click();
    }
  }

  public async doUncheck(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    if (await element.isSelected()) {
      await element.click();
    }
  }

  public async doClick(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await element.click();
  }

  public async doClickAt(locator: string, coordString: string, commandObject: { targetFallback?: string[][] } = {}) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element, ...coords })
      .click()
      .perform();
  }

  public async doDoubleClick(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .doubleClick(element)
      .perform();
  }

  public async doDoubleClickAt(locator: string, coordString: string, commandObject: { targetFallback?: string[][] } = {}) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element, ...coords })
      .doubleClick()
      .perform();
  }

  public async doDragAndDropToObject(
    dragLocator: string,
    dropLocator: string,
    commandObject: { targetFallback?: string[][]; valueFallback?: string[][] } = {}
  ) {
    const drag = await this.waitForElement(dragLocator, commandObject.targetFallback);
    const drop = await this.waitForElement(dropLocator, commandObject.valueFallback);
    await this.driver
      .actions({ bridge: true })
      .dragAndDrop(drag, drop)
      .perform();
  }

  public async doMouseDown(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element })
      .press()
      .perform();
  }

  public async doMouseDownAt(locator: string, coordString: string, commandObject: { targetFallback?: string[][] } = {}) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element, ...coords })
      .press()
      .perform();
  }

  public async doMouseMoveAt(locator: string, coordString: string, commandObject: { targetFallback?: string[][] } = {}) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element, ...coords })
      .perform();
  }

  public async doMouseOut(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const [rect, vp] = await this.driver.executeScript(
      'return [arguments[0].getBoundingClientRect(), {height: window.innerHeight, width: window.innerWidth}];',
      element
    );

    // try top
    if (rect.top > 0) {
      const y = Math.trunc(-(rect.height / 2 + 1));
      return await this.driver
        .actions({ bridge: true })
        .move({ origin: element, y })
        .perform();
    }
    // try right
    else if (vp.width > rect.right) {
      const x = Math.trunc(rect.right / 2 + 1);
      return await this.driver
        .actions({ bridge: true })
        .move({ origin: element, x })
        .perform();
    }
    // try bottom
    else if (vp.height > rect.bottom) {
      const y = Math.trunc(rect.height / 2 + 1);
      return await this.driver
        .actions({ bridge: true })
        .move({ origin: element, y })
        .perform();
    }
    // try left
    else if (rect.left > 0) {
      const x = Math.trunc(-(rect.right / 2));
      return await this.driver
        .actions({ bridge: true })
        .move({ origin: element, x })
        .perform();
    }

    throw new Error('Unable to perform mouse out as the element takes up the entire viewport');
  }

  public async doMouseOver(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element })
      .perform();
  }

  public async doMouseUp(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element })
      .release()
      .perform();
  }

  public async doMouseUpAt(locator: string, coordString: string, commandObject: { targetFallback?: string[][] } = {}) {
    const coords = parseCoordString(coordString);
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver
      .actions({ bridge: true })
      .move({ origin: element, ...coords })
      .release()
      .perform();
  }

  public async doSelect(locator: string, optionLocator: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const option = await element.findElement(parseOptionLocator(optionLocator));
    await option.click();
  }

  // keyboard commands

  public async doEditContent(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await this.driver.executeScript(
      "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]} else {throw new Error('Element is not content editable')}",
      element,
      value
    );
  }

  public async doType(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await element.clear();
    await element.sendKeys(value);
  }

  public async doSendKeys(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    await element.sendKeys(...value);
  }

  // wait commands

  public async doWaitForElementEditable(locator: string, timeout: string) {
    const element = await this.driver.findElement(parseLocator(locator));
    await this.wait(async () => await this.isElementEditable(element), parseInt(timeout, 10), 'Timed out waiting for element to be editable');
  }

  public async doWaitForElementNotEditable(locator: string, timeout: string) {
    const element = await this.driver.findElement(parseLocator(locator));
    await this.wait(async () => !(await this.isElementEditable(element)), parseInt(timeout, 10), 'Timed out waiting for element to not be editable');
  }

  public async doWaitForElementPresent(locator: string, timeout: string) {
    await this.wait(until.elementLocated(parseLocator(locator)), parseInt(timeout, 10));
  }

  public async doWaitForElementNotPresent(locator: string, timeout: string) {
    const parsedLocator = parseLocator(locator);
    const elements = await this.driver.findElements(parsedLocator);
    if (elements.length !== 0) {
      await this.wait(until.stalenessOf(elements[0]), parseInt(timeout, 10));
    }
  }

  public async doWaitForElementVisible(locator: string, timeout: string) {
    const startTime = new Date();
    const element = await this.wait(until.elementLocated(parseLocator(locator)), parseInt(timeout, 10));
    const elapsed = new Date().getTime() - startTime.getTime();
    await this.wait(until.elementIsVisible(element as WebElement), parseInt(timeout, 10) - elapsed);
  }

  public async doWaitForElementNotVisible(locator: string, timeout: string) {
    const parsedLocator = parseLocator(locator);
    const elements = await this.driver.findElements(parsedLocator);

    if (elements.length > 0) {
      await this.wait(until.elementIsNotVisible(elements[0]), parseInt(timeout, 10));
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
      ...script.argv
    );
    if (optionalVariable) {
      this.variables.set(optionalVariable, result);
    }
  }

  // alert commands

  public async doAcceptAlert() {
    await this.driver
      .switchTo()
      .alert()
      .accept();
  }

  public async doAcceptConfirmation() {
    await this.driver
      .switchTo()
      .alert()
      .accept();
  }

  public async doAnswerPrompt(optAnswer?: string) {
    const alert = await this.driver.switchTo().alert();
    if (optAnswer) {
      await alert.sendKeys(optAnswer);
    }
    await alert.accept();
  }

  public async doDismissConfirmation() {
    await this.driver
      .switchTo()
      .alert()
      .dismiss();
  }

  public async doDismissPrompt() {
    await this.driver
      .switchTo()
      .alert()
      .dismiss();
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
    const elements = await this.driver.findElements(parseLocator(locator));
    this.variables.set(variable, elements.length);
  }

  public async doStoreJson(json: any, variable: string) {
    this.variables.set(variable, JSON.parse(json));
    return Promise.resolve();
  }

  public async doStoreText(locator: string, variable: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const text = await element.getText();
    this.variables.set(variable, text);
  }

  public async doStoreTitle(variable: string) {
    const title = await this.driver.getTitle();
    this.variables.set(variable, title);
  }

  public async doStoreValue(locator: string, variable: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
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
    const alert = await this.driver.switchTo().alert();
    const actualText = await alert.getText();
    if (actualText !== expectedText) {
      throw new AssertionError("Actual alert text '" + actualText + "' did not match '" + expectedText + "'");
    }
  }

  public async doAssertConfirmation(expectedText: string) {
    const alert = await this.driver.switchTo().alert();
    const actualText = await alert.getText();
    if (actualText !== expectedText) {
      throw new AssertionError("Actual confirm text '" + actualText + "' did not match '" + expectedText + "'");
    }
  }

  public async doAssertEditable(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    if (!(await this.isElementEditable(element))) {
      throw new AssertionError('Element is not editable');
    }
  }

  public async doAssertNotEditable(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    if (await this.isElementEditable(element)) {
      throw new AssertionError('Element is editable');
    }
  }

  public async doAssertPrompt(expectedText: string) {
    const alert = await this.driver.switchTo().alert();
    const actualText = await alert.getText();
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

  public async doAssertElementPresent(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    await this.waitForElement(locator, commandObject.targetFallback);
  }

  public async doAssertElementNotPresent(locator: string) {
    const elements = await this.driver.findElements(parseLocator(locator));
    if (elements.length) {
      throw new AssertionError('Unexpected element was found in page');
    }
  }

  public async doAssertText(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const text = await element.getText();
    if (text !== value) {
      throw new AssertionError("Actual value '" + text + "' did not match '" + value + "'");
    }
  }

  public async doAssertNotText(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const text = await element.getText();
    if (text === value) {
      throw new AssertionError("Actual value '" + text + "' did match '" + value + "'");
    }
  }

  public async doAssertValue(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue !== value) {
      throw new AssertionError("Actual value '" + elementValue + "' did not match '" + value + "'");
    }
  }

  // not generally implemented
  public async doAssertNotValue(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue === value) {
      throw new AssertionError("Actual value '" + elementValue + "' did match '" + value + "'");
    }
  }

  public async doAssertChecked(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    if (!(await element.isSelected())) {
      throw new AssertionError('Element is not checked, expected to be checked');
    }
  }

  public async doAssertNotChecked(locator: string, _?: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    if (await element.isSelected()) {
      throw new AssertionError('Element is checked, expected to be unchecked');
    }
  }

  public async doAssertSelectedValue(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue !== value) {
      throw new AssertionError("Actual value '" + elementValue + "' did not match '" + value + "'");
    }
  }

  public async doAssertNotSelectedValue(locator: string, value: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const elementValue = await element.getAttribute('value');
    if (elementValue === value) {
      throw new AssertionError("Actual value '" + elementValue + "' did match '" + value + "'");
    }
  }

  public async doAssertSelectedLabel(locator: string, label: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const selectedValue = await element.getAttribute('value');
    const selectedOption = await element.findElement(By.xpath(`option[@value="${selectedValue}"]`));
    const selectedOptionLabel = await selectedOption.getText();
    if (selectedOptionLabel !== label) {
      throw new AssertionError("Actual value '" + selectedOptionLabel + "' did not match '" + label + "'");
    }
  }

  public async doAssertNotSelectedLabel(locator: string, label: string, commandObject: { targetFallback?: string[][] } = {}) {
    const element = await this.waitForElement(locator, commandObject.targetFallback);
    const selectedValue = await element.getAttribute('value');
    const selectedOption = await element.findElement(By.xpath(`option[@value="${selectedValue}"]`));
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
    await this.driver.sleep(time);
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

  public async waitForElement(locator: string, fallback?: string[][]): Promise<WebElement> {
    const elementLocator = parseLocator(locator);
    try {
      return await this.wait(until.elementLocated(elementLocator), this.implicitWait);
    } catch (err) {
      if (fallback) {
        for (const fb of fallback) {
          try {
            const loc = parseLocator(fb[0]);
            return await this.driver.findElement(loc);
          } catch (e) {
            // try the next one
          }
        }
      }
      throw err;
    }
  }

  public async isElementEditable(element: WebElement) {
    const { enabled, readonly } = await this.driver.executeScript(
      'return { enabled: !arguments[0].disabled, readonly: arguments[0].readOnly };',
      element
    );
    return enabled && !readonly;
  }

  public async wait(
    condition: (() => Promise<any>) | Promise<any> | Condition<any>,
    timeout = 0,
    message?: string,
    pollTimeout = POLL_TIMEOUT
  ): Promise<any> {
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

    let fn: any = condition;
    if (condition instanceof Condition) {
      message = message || condition.description();
      fn = condition.fn;
    }

    if (typeof fn !== 'function') {
      throw TypeError('Wait condition must be a promise-like object, function, or a ' + 'Condition object');
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

    let result = new Promise((resolve, reject) => {
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

    if (condition instanceof WebElementCondition) {
      result = new WebElementPromise(
        driver,
        result.then(value => {
          if (!(value instanceof WebElement)) {
            throw TypeError('WebElementCondition did not resolve to a WebElement: ' + Object.prototype.toString.call(value));
          }
          return value;
        })
      );
    }
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
  {
    targetFallback: preprocessArray(interpolateString),
    valueFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doAddSelection
);

WebDriverExecutor.prototype.doRemoveSelection = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
    valueFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doRemoveSelection
);

WebDriverExecutor.prototype.doCheck = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doCheck
);

WebDriverExecutor.prototype.doUncheck = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doUncheck
);

WebDriverExecutor.prototype.doClick = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doClick
);

WebDriverExecutor.prototype.doClickAt = composePreprocessors(
  interpolateString,
  interpolateString,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doClickAt
);

WebDriverExecutor.prototype.doDoubleClick = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doDoubleClick
);

WebDriverExecutor.prototype.doDoubleClickAt = composePreprocessors(
  interpolateString,
  interpolateString,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doDoubleClickAt
);

WebDriverExecutor.prototype.doDragAndDropToObject = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
    valueFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doDragAndDropToObject
);

WebDriverExecutor.prototype.doMouseDown = composePreprocessors(
  interpolateString,
  null,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseDown
);

WebDriverExecutor.prototype.doMouseDownAt = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseDownAt
);

WebDriverExecutor.prototype.doMouseMoveAt = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseMoveAt
);

WebDriverExecutor.prototype.doMouseOut = composePreprocessors(
  interpolateString,
  null,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseOut
);

WebDriverExecutor.prototype.doMouseOver = composePreprocessors(
  interpolateString,
  null,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseOver
);

WebDriverExecutor.prototype.doMouseUp = composePreprocessors(
  interpolateString,
  null,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseUp
);

WebDriverExecutor.prototype.doMouseUpAt = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doMouseUpAt
);

WebDriverExecutor.prototype.doSelect = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
    valueFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doSelect
);

WebDriverExecutor.prototype.doEditContent = composePreprocessors(
  interpolateString,
  interpolateString,
  {
    targetFallback: preprocessArray(interpolateString),
  },
  WebDriverExecutor.prototype.doEditContent
);

WebDriverExecutor.prototype.doType = composePreprocessors(
  interpolateString,
  interpolateString,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doType
);

WebDriverExecutor.prototype.doSendKeys = composePreprocessors(
  interpolateString,
  preprocessKeys,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doSendKeys
);

WebDriverExecutor.prototype.doRunScript = composePreprocessors(interpolateScript, WebDriverExecutor.prototype.doRunScript);

WebDriverExecutor.prototype.doExecuteScript = composePreprocessors(interpolateScript, null, WebDriverExecutor.prototype.doExecuteScript);

WebDriverExecutor.prototype.doExecuteAsyncScript = composePreprocessors(interpolateScript, null, WebDriverExecutor.prototype.doExecuteAsyncScript);

WebDriverExecutor.prototype.doStore = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doStore);

WebDriverExecutor.prototype.doStoreAttribute = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreAttribute
);

WebDriverExecutor.prototype.doStoreElementCount = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreElementCount
);

WebDriverExecutor.prototype.doStoreJson = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doStoreJson);

WebDriverExecutor.prototype.doStoreText = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreText
);

WebDriverExecutor.prototype.doStoreValue = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doStoreValue
);

WebDriverExecutor.prototype.doAssert = composePreprocessors(null, interpolateString, WebDriverExecutor.prototype.doAssert);

WebDriverExecutor.prototype.doAssertAlert = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doAssertAlert);

WebDriverExecutor.prototype.doAssertConfirmation = composePreprocessors(interpolateString, null, WebDriverExecutor.prototype.doAssertConfirmation);

WebDriverExecutor.prototype.doAssertEditable = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
  WebDriverExecutor.prototype.doAssertEditable
);

WebDriverExecutor.prototype.doAssertNotEditable = composePreprocessors(
  interpolateString,
  null,
  { targetFallback: preprocessArray(interpolateString) },
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
  const type = fragments.shift();
  const selector = fragments.join('=');
  // @ts-ignore
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
  // @ts-ignore
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
          const keyName = currentKey.match(/\$\{KEY_(\w+)\}/)![1];
          // @ts-ignore
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

const LOCATORS = {
  id: By.id,
  name: By.name,
  link: By.linkText,
  linkText: By.linkText,
  partialLinkText: By.partialLinkText,
  css: By.css,
  xpath: By.xpath,
};

const OPTIONS_LOCATORS = {
  id: (id: string) => By.css(`*[id="${id}"]`),
  value: (value: string) => By.css(`*[value="${value}"]`),
  label: (label: string) => By.xpath(`//option[. = '${label}']`),
  index: (index: string) => By.css(`*:nth-child(${index})`),
};

async function findElement(elements: WebElement[], element: WebElement) {
  const id = await element.getId();
  for (const e of elements) {
    if ((await e.getId()) === id) {
      return true;
    }
  }
  return false;
}
