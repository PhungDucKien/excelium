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
import * as fs from 'fs-extra';
import moment from 'moment';
import MultiProgress from 'multi-progress';
import fetch from 'node-fetch';
import * as path from 'path';
import * as stream from 'stream';
import tar from 'tar';
import * as unzipper from 'unzipper';
import URL from 'url';
import { Browser, Platform, resolveDriverName, resolveDriverUrl } from './resolve-driver';

export default async function downloadDriver({
  downloadDirectory,
  browser,
  platform,
  arch,
  version,
  artifactName,
  multiProgress,
}: {
  downloadDirectory: string;
  browser: Browser;
  platform: Platform;
  arch: string;
  version: string;
  artifactName?: string;
  multiProgress?: MultiProgress;
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

  if (multiProgress) {
    const contentLen = res.headers.get('content-length');
    if (contentLen) {
      const total = parseInt(contentLen, 10);
      const fileName = path.basename(URL.parse(url).pathname!);

      const bar = multiProgress.newBar(fileName + ' :percent [:bar] :currLen/:contentLen (:elapseTime / :completeTime)', {
        complete: '=',
        incomplete: ' ',
        width: Math.max(10, process.stdout.columns! - fileName.length - 50),
        total,
      });

      let start: Date;

      res.body.on('data', chunk => {
        if (bar.curr === 0) {
          start = new Date();
        }

        if (bar.tick) {
          const elapsed = start ? new Date().getTime() - start.getTime() : NaN;
          const curr = bar.curr + chunk.length;
          const eta = curr >= bar.total ? 0 : elapsed * (bar.total / curr - 1);

          bar.tick(chunk.length, {
            currLen: StringUtil.humanReadableByteCount(curr, true),
            contentLen: StringUtil.humanReadableByteCount(bar.total, true),
            elapseTime: isNaN(elapsed) ? '00:00:00' : moment.utc(elapsed).format('HH:mm:ss'),
            completeTime: isNaN(eta) || !isFinite(eta) ? '-:-:-' : moment.utc(eta).format('HH:mm:ss'),
          });
        }
      });

      res.body.on('end', () => {
        console.log('\n');
      });
    }
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
