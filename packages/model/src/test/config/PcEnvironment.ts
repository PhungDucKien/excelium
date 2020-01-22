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

import Browser from '../../enums/Browser';
import Environment from './Environment';

/**
 * Represents environment model for PC web application.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
export default class PcEnvironment extends Environment {
  /**
   * Browser
   */
  public browser: Browser;

  /**
   * Browser version
   */
  public browserVersion: string | null;

  /**
   * Resolution
   */
  public resolution: string | null;

  /**
   * Base url
   */
  public baseUrl: string | null;

  public getKey(): string {
    if (!this.resolution || this.resolution.toLowerCase() === 'ignored') {
      return this.browser;
    } else {
      return this.browser + '-' + this.resolution;
    }
  }
}