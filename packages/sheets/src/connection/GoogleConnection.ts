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

import { OAuth2Client, OAuth2ClientOptions } from 'google-auth-library';

/**
 * Represents connection to Google services.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default abstract class GoogleConnection {
  /**
   * Global instance of the scopes.
   */
  protected static readonly SCOPES = ['https://www.googleapis.com/auth/spreadsheets'];

  /**
   * Gets oAuth2 client options.
   *
   * @return the oAuth2 client options
   */
  public abstract getOAuth2ClientOptions(): Promise<OAuth2ClientOptions>;

  /**
   * Gets auth client.
   *
   * @return the auth client
   */
  public abstract getAuthClient(): Promise<OAuth2Client>;
}
