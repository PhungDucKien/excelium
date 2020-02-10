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

import * as fs from 'fs-extra';
import fetch from 'node-fetch';
import * as path from 'path';
import * as stream from 'stream';
import tar from 'tar';
import * as unzipper from 'unzipper';
import { Browser, Platform, resolveDriverName, resolveDriverUrl } from './resolve-driver';

export default async function downloadDriver({
  downloadDirectory,
  browser,
  platform,
  arch,
  version,
  artifactName,
}: {
  downloadDirectory: string;
  browser: Browser;
  platform: Platform;
  arch: string;
  version: string;
  artifactName?: string;
}) {
  let end: () => Promise<undefined>;
  const p = new Promise(resolve => {
    end = resolve as () => Promise<undefined>;
  });
  const url = await resolveDriverUrl({ browser, platform, arch, version });
  const downloadDestination = path.join(downloadDirectory, artifactName || resolveDriverName({ browser, platform, version }));
  const res = await fetch(url);
  if (!res.ok) {
    throw new Error('Failed to download driver');
  }

  if (url.endsWith('.zip')) {
    res.body.pipe(unzipper.Parse()).pipe(
      new stream.Transform({
        objectMode: true,
        transform(entry, _e, cb) {
          const fileName = entry.path;
          if (fileName === 'chromedriver' || fileName === 'chromedriver.exe' || fileName === 'geckodriver' || fileName === 'geckodriver.exe') {
            entry.pipe(fs.createWriteStream(downloadDestination)).on('finish', end);
          } else {
            entry.autodrain();
            cb();
          }
        },
      })
    );
  } else {
    res.body.pipe(
      tar.t({
        filter: (filePath, _stat) => filePath === 'geckodriver',
        onentry: entry => {
          entry.pipe(fs.createWriteStream(downloadDestination)).on('close', end);
        },
      })
    );
  }
  await p;
  await fs.chmod(downloadDestination, 0o755);
  return downloadDestination;
}
