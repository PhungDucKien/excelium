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
import { By } from 'selenium-webdriver';
import { Element, ElementArray } from 'webdriverio';
import { Action } from './model';
import WebDriverExecutor from './webdriver';

/**
 * Base class for command executors.
 *
 * @author PhungDucKien
 * @since 2018.05.07
 */
export default abstract class CommandExecutor {
  protected static parseLocator(locator: string) {
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

  protected static parseOptionLocator(locator: string) {
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

  protected static parseCoordString(coord: string) {
    const [x, y] = coord.split(',').map(n => parseInt(n, 10));

    return {
      x,
      y,
    };
  }

  protected static findElement(elements: ElementArray, element: Element) {
    const id = element.elementId;
    for (const e of elements) {
      if (e.elementId === id) {
        return true;
      }
    }
    return false;
  }

  /**
   * Web driver
   */
  protected webDriver: WebDriverExecutor;

  /**
   * Project instance
   */
  protected project: Project;

  /**
   * Instantiates a new Command executor.
   *
   * @param webDriver the web driver
   * @param project   the project
   */
  public constructor(webDriver: WebDriverExecutor, project: Project) {
    this.webDriver = webDriver;
    this.project = project;
  }

  /**
   * Gets web driver.
   *
   * @return the web driver
   */
  public getWebDriver(): WebDriverExecutor {
    return this.webDriver;
  }

  /**
   * Normalize text string.
   *
   * @param text the text
   * @return the string
   */
  public normalizeText(text: string): string {
    text = text.replace('\r\n', '\n');
    return text;
  }

  public abstract getActions(): Array<Action<any>>;
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
