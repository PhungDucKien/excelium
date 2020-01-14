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

import fs from 'fs-extra';
import { OAuth2Client, OAuth2ClientOptions } from 'google-auth-library';
import { google } from 'googleapis';
import http, { IncomingMessage, ServerResponse } from 'http';
import isCI from 'is-ci';
import open from 'open';
import os from 'os';
import destroyer from 'server-destroy';
import url from 'url';
import GoogleConnection from './GoogleConnection';

/**
 * Implements {@link GoogleConnection} for uses in command line applications.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
export default class GoogleConnectionService extends GoogleConnection {
  /**
   * Command line client secret json file
   */
  private static readonly CLIENT_SECRETS = `${__dirname}/../../resources/installed_client_secret.json`;

  private static readonly SERVICE_ACCOUNT = `${__dirname}/../../resources/service_account.json`;

  /**
   * The file token.json stores the user's access and refresh tokens, and is
   * created automatically when the authorization flow completes for the first
   * time.
   */
  private static readonly DATA_STORE_FILE = `${os.homedir()}/.credentials/sheets.googleapis.com-excelium/token.json`;

  /**
   * OAuth2 client options
   */
  private static oAuth2ClientOptions: OAuth2ClientOptions;

  /**
   * Auth client
   */
  private authClient: OAuth2Client;

  public getOAuth2ClientOptions(): Promise<OAuth2ClientOptions> {
    if (GoogleConnectionService.oAuth2ClientOptions == null) {
      // Load client secrets from a local file
      return fs.readFile(GoogleConnectionService.CLIENT_SECRETS, 'utf8').then(content => {
        const credentials = JSON.parse(content);
        const { client_id, client_secret } = credentials.installed;
        const oAuth2ClientOptions = {
          clientId: client_id,
          clientSecret: client_secret,
          redirectUri: 'http://localhost:3000/oauth2callback',
        };
        GoogleConnectionService.oAuth2ClientOptions = oAuth2ClientOptions;
        return oAuth2ClientOptions;
      });
    }
    return Promise.resolve(GoogleConnectionService.oAuth2ClientOptions);
  }

  public getAuthClient(): Promise<OAuth2Client> {
    if (this.authClient == null) {
      if (isCI) {
        const googleAuth = new google.auth.GoogleAuth({
          keyFile: GoogleConnectionService.SERVICE_ACCOUNT,
          scopes: GoogleConnectionService.SCOPES,
        });
        return googleAuth.getClient();
      } else {
        // Build flow and trigger user authorization request.
        return this.getOAuth2ClientOptions().then(oAuth2ClientOptions => this.getAuthenticatedClient(oAuth2ClientOptions));
      }
    }

    return Promise.resolve(this.authClient);
  }

  /**
   * Create a new OAuth2Client, and go through the OAuth2 content
   * workflow.  Return the full client to the callback.
   */
  private getAuthenticatedClient(options: OAuth2ClientOptions): Promise<OAuth2Client> {
    return new Promise((resolve, reject) => {
      // create an oAuth client to authorize the API call.  Secrets are kept in a `.json` file,
      // which should be downloaded from the Google Developers Console.
      const oAuth2Client = new OAuth2Client(options);

      // Check if we have previously stored a token.
      fs.readFile(GoogleConnectionService.DATA_STORE_FILE, (err, token) => {
        if (err) {
          return this.getNewToken(oAuth2Client, resolve, reject);
        }
        oAuth2Client.setCredentials(JSON.parse(token.toString()));
        resolve(oAuth2Client);
      });
    });
  }

  /**
   * Get and store new token after prompting for user authorization, and then
   * execute the given callback with the authorized OAuth2 client.
   * @param {OAuth2Client} oAuth2Client The OAuth2 client to get token for.
   */
  private getNewToken(oAuth2Client: OAuth2Client, resolve: (value: OAuth2Client) => void, reject: (reason?: any) => void) {
    // Generate the url that will be used for the consent dialog.
    const authorizeUrl = oAuth2Client.generateAuthUrl({
      access_type: 'offline',
      scope: GoogleConnectionService.SCOPES,
    });

    // Open an http server to accept the oauth callback. In this simple example, the
    // only request to our webserver is to /oauth2callback?code=<code>
    const server = http
      .createServer(async (req: IncomingMessage, res: ServerResponse) => {
        try {
          if (req.url && req.url.indexOf('/oauth2callback') > -1) {
            // acquire the code from the querystring, and close the web server.
            const qs = new url.URL(req.url, 'http://localhost:3000').searchParams;
            const code = qs.get('code');
            res.end('Authentication successful! Please return to the console.');
            server.destroy();

            // Now that we have the code, use that to acquire tokens.
            const r = await oAuth2Client.getToken(code!);
            const token = r.tokens;
            // Make sure to set the credentials on the OAuth2 client.
            oAuth2Client.setCredentials(token);

            // Store the token to disk for later program executions
            fs.outputFile(GoogleConnectionService.DATA_STORE_FILE, JSON.stringify(token), err => {
              if (err) {
                return reject(err);
              }
            });
            resolve(oAuth2Client);
          }
        } catch (e) {
          reject(e);
        }
      })
      .listen(3000, () => {
        // open the browser to the authorize url to start the workflow
        open(authorizeUrl, { wait: false }).then(cp => cp.unref());
      });
    destroyer(server);
  }
}
