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

import * as os from 'os';
import * as path from 'path';
import * as chrome from 'selenium-webdriver/chrome';
import * as firefox from 'selenium-webdriver/firefox';
import { remote } from 'webdriverio';
import { CACHE_PATH } from './cache';

export async function createDriver({ url, capabilities }: { url?: string; capabilities: any }) {
  if (url) {
    const { protocol, hostname, port, pathname } = new URL(url);
    return await remote({
      protocol: protocol.substr(0, protocol.length - 1),
      hostname,
      port: parseInt(port, 10),
      path: pathname,
      logLevel: 'error',
      capabilities,
    });
  } else {
    return await remote({
      logLevel: 'error',
      capabilities,
    });
  }
}

export async function createChrome(url?: string) {
  return await createDriver({
    url,
    capabilities: {
      browserName: 'chrome',
    },
  });
}

export async function createHeadlessChrome(url?: string) {
  return await createDriver({
    url,
    capabilities: {
      browserName: 'chrome',
      'goog:chromeOptions': { args: ['headless', 'disable-gpu'] },
    },
  });
}

export async function createFirefox(url?: string) {
  return await createDriver({
    url,
    capabilities: {
      browserName: 'firefox',
    },
  });
}

export async function createHeadlessFirefox(url?: string) {
  return await createDriver({
    url,
    capabilities: {
      browserName: 'firefox',
      'moz:firefoxOptions': { args: ['-headless'] },
    },
  });
}

export function createServices() {
  return {
    chromeService: new chrome.ServiceBuilder(path.join(CACHE_PATH, `chromedriver${os.platform() === 'win32' ? '.exe' : ''}`)),
    firefoxService: new firefox.ServiceBuilder(path.join(CACHE_PATH, `geckodriver${os.platform() === 'win32' ? '.exe' : ''}`)),
  };
}
