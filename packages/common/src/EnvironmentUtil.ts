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

import { Browser, Environment, MobileAppEnvironment, MobileWebEnvironment, PcEnvironment, Platform } from '@excelium/model';
import CollectionUtil from './CollectionUtil';
import PlatformDetector from './PlatformDetector';
import StringUtil from './StringUtil';

/**
 * Collection of environment handling utilities
 *
 * @author PhungDucKien
 * @since 2018.04.17
 */
export default class EnvironmentUtil {
  /**
   * Gets available pc environments.
   *
   * @param browser     the browser
   * @param versions    the versions
   * @param resolutions the resolutions
   * @param baseUrl     the base url
   * @return the available pc environments
   */
  public static getAvailablePcEnvironments(browser: Browser, versions: string[], resolutions: string[], baseUrl: string | null): Environment[] {
    const environments = [] as Environment[];
    const platform = PlatformDetector.getPlatform();
    if (this.isBrowserAvailable(platform, browser)) {
      if (CollectionUtil.isEmpty(versions)) {
        versions = [''];
      }
      if (CollectionUtil.isEmpty(resolutions)) {
        resolutions = ['1024x768'];
      }
      for (const version of versions) {
        for (const resolution of resolutions) {
          const environment = new PcEnvironment();
          environment.platform = platform;
          environment.browser = browser;
          environment.browserVersion = version;
          environment.resolution = resolution;
          environment.baseUrl = baseUrl;
          environments.push(environment);
        }
      }
    }
    return environments;
  }

  /**
   * Gets available mobile web environments.
   *
   * @param platform         the platform
   * @param platformVersions the platform versions
   * @param deviceNames      the device names
   * @param orientations     the orientations
   * @param udid             the udid
   * @param browsers         the browsers
   * @param baseUrl          the base url
   * @return the available mobile web environments
   */
  public static getAvailableMobileWebEnvironments(
    platform: Platform,
    platformVersions: string[],
    deviceNames: string[],
    orientations: string[],
    udid: string | null,
    browsers: string[],
    baseUrl: string | null
  ): Environment[] {
    if (CollectionUtil.isEmpty(platformVersions)) {
      platformVersions = [''];
    }
    if (CollectionUtil.isEmpty(deviceNames)) {
      deviceNames = [];
      if (platform === Platform.ANDROID) {
        deviceNames.push('Android');
      } else if (platform === Platform.IOS) {
        deviceNames.push('iPhone');
      }
    }
    if (CollectionUtil.isEmpty(orientations)) {
      orientations = ['Portrait'];
    }
    if (CollectionUtil.isEmpty(browsers)) {
      browsers = [];
      if (platform === Platform.ANDROID) {
        browsers.push('Chrome');
      } else if (platform === Platform.IOS) {
        browsers.push('Safari');
      }
    }
    const environments = [] as Environment[];
    for (const platformVersion of platformVersions) {
      for (const deviceName of deviceNames) {
        for (const orientation of orientations) {
          for (const browser of browsers) {
            const environment = new MobileWebEnvironment();
            environment.platform = platform;
            environment.platformVersion = platformVersion;
            environment.deviceName = deviceName;
            environment.orientation = orientation;
            environment.udid = StringUtil.isBlank(udid) ? 'auto' : udid;
            environment.browser = Browser.fromName(browser);
            environment.baseUrl = baseUrl;
            environments.push(environment);
          }
        }
      }
    }
    return environments;
  }

  /**
   * Gets available mobile app environments.
   *
   * @param platform         the platform
   * @param platformVersions the platform versions
   * @param deviceNames      the device names
   * @param orientations     the orientations
   * @param udid             the udid
   * @param appPath          the app path
   * @param appActivity      the app activity
   * @param appPackage       the app package
   * @param appWaitActivity  the app wait activity
   * @param appWaitPackage   the app wait package
   * @param bundleId         the bundle ID
   * @return the available mobile app environments
   */
  public static getAvailableMobileAppEnvironments(
    platform: Platform,
    platformVersions: string[],
    deviceNames: string[],
    orientations: string[],
    udid: string | null,
    appPath: string | null,
    appActivity: string | null,
    appPackage: string | null,
    appWaitActivity: string | null,
    appWaitPackage: string | null,
    bundleId: string | null
  ): Environment[] {
    if (CollectionUtil.isEmpty(platformVersions)) {
      platformVersions = [''];
    }
    if (CollectionUtil.isEmpty(deviceNames)) {
      deviceNames = [];
      if (platform === Platform.ANDROID) {
        deviceNames.push('Android');
      } else if (platform === Platform.IOS) {
        deviceNames.push('iPhone');
      }
    }
    if (CollectionUtil.isEmpty(orientations)) {
      orientations = ['Portrait'];
    }
    const environments = [] as Environment[];
    for (const platformVersion of platformVersions) {
      for (const deviceName of deviceNames) {
        for (const orientation of orientations) {
          const environment = new MobileAppEnvironment();
          environment.platform = platform;
          environment.platformVersion = platformVersion;
          environment.deviceName = deviceName;
          environment.orientation = orientation;
          environment.udid = StringUtil.isBlank(udid) ? 'auto' : udid;
          environment.appPath = appPath;
          environment.appActivity = appActivity;
          environment.appPackage = appPackage;
          environment.appWaitActivity = appWaitActivity;
          environment.appWaitPackage = appWaitPackage;
          environment.bundleId = bundleId;
          environments.push(environment);
        }
      }
    }
    return environments;
  }

  /**
   * Checks if the given browser is available on the platform
   *
   * @param platform the platform
   * @param browser  the browser
   * @return is the browser available
   */
  private static isBrowserAvailable(platform: Platform, browser: Browser): boolean {
    switch (browser) {
      case Browser.IE:
      case Browser.EDGE:
        return Platform.isWindows(platform);
      case Browser.SAFARI:
        return Platform.isMac(platform);
      default:
        return true;
    }
  }
}
