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

import Platform from '../enums/Platform';
import Environment from './config/Environment';
import MobileAppEnvironment from './config/MobileAppEnvironment';
import MobileWebEnvironment from './config/MobileWebEnvironment';
import PcEnvironment from './config/PcEnvironment';

/**
 * Represents test step model.
 * This model stores the data retrieved from one row.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
export default class TestStep {
  /**
   * Serial number
   */
  public no: number;

  /**
   * Gutter
   */
  public gutter: string | null;

  /**
   * Android gutter
   */
  public androidGutter: string | null;

  /**
   * iOS gutter
   */
  public iosGutter: string | null;

  /**
   * Is capture taken after step execution?
   */
  public capture: boolean;

  /**
   * Name
   */
  public name: string | null;

  /**
   * Description
   */
  public description: string | null;

  /**
   * Command
   */
  public command: string;

  /**
   * Parameter 1
   */
  public param1: string | null;

  /**
   * Parameter 2
   */
  public param2: string | null;

  /**
   * Parameter 3
   */
  public param3: string | null;

  /**
   * Test data
   */
  public testData: string | null;

  /**
   * Row index
   */
  public rowIndex: number;

  /**
   * Determine whether the step should be skipped on an environment.
   *
   * @param environment the environment
   * @return true if the step should be skipped, otherwise, false
   */
  public isStepSkip(environment: Environment): boolean {
    return (
      (this._isStepSkip(this.gutter) && (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment)) ||
      (this._isStepSkip(this.androidGutter) && environment instanceof MobileAppEnvironment && environment.platform === Platform.ANDROID) ||
      (this._isStepSkip(this.iosGutter) && environment instanceof MobileAppEnvironment && environment.platform === Platform.IOS)
    );
  }

  /**
   * Determine whether the step is a debug point of an environment.
   *
   * @param environment the environment
   * @return true if the step is a debug point, otherwise, false
   */
  public isStepDebug(environment: Environment): boolean {
    return (
      (this._isStepDebug(this.gutter) && (environment instanceof PcEnvironment || environment instanceof MobileWebEnvironment)) ||
      (this._isStepDebug(this.androidGutter) && environment instanceof MobileAppEnvironment && environment.platform === Platform.ANDROID) ||
      (this._isStepDebug(this.iosGutter) && environment instanceof MobileAppEnvironment && environment.platform === Platform.IOS)
    );
  }

  /**
   * Determine whether the step gutter indicates a skip.
   *
   * @param stepGutter the gutter of the step
   * @return true if the step gutter indicates a skip, otherwise, false
   */
  private _isStepSkip(stepGutter: string | null): boolean {
    return this._isNotBlank(stepGutter) && !this._equalsAnyIgnoreCase(stepGutter, ['B', 'D', 'M']);
  }

  /**
   * Determine whether the step gutter indicates a debug.
   *
   * @param stepGutter the gutter of the step
   * @return true if the step gutter indicates a debug, otherwise, false
   */
  private _isStepDebug(stepGutter: string | null): boolean {
    return this._isNotBlank(stepGutter) && this._equalsAnyIgnoreCase(stepGutter, ['B', 'D']);
  }

  private _isNotBlank(str: string | null): boolean {
    return !!str && !/^\s*$/.test(str);
  }

  private _equalsAnyIgnoreCase(str: string | null, searchStrings: string[]): boolean {
    if (Array.isArray(searchStrings) && searchStrings.length) {
      for (const next of searchStrings) {
        if (str && str.toUpperCase() === next.toUpperCase()) {
          return true;
        }
      }
    }
    return false;
  }
}
