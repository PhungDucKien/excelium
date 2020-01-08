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
import path from 'path';

/**
 * Collection of file handling utilities
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
export default class FileUtil {
  /**
   * Returns list of file paths in a given directory.
   * The listing is recursive.
   *
   * @param path the directory path
   * @return list of file paths
   */
  public static listFiles(dir: string): Promise<string[]> {
    return new Promise<string[]>((resolve, reject) => {
      FileUtil.walk(dir, (err, list) => {
        if (err) {
          return reject(err);
        }
        if (list) {
          return resolve(list.map(file => path.relative(dir, file)));
        } else {
          return resolve([]);
        }
      });
    });
  }

  // https://stackoverflow.com/questions/5827612/node-js-fs-readdir-recursive-directory-search
  private static walk(dir: string, done: (error?: any, results?: string[]) => void): void {
    let results = [] as string[];
    fs.readdir(dir, (err, list) => {
      if (err) {
        return done(err);
      }
      let pending = list.length;
      if (!pending) {
        return done(null, results);
      }
      list.forEach(file => {
        file = path.resolve(dir, file);
        fs.stat(file, (err1, stat) => {
          if (err1) {
            return done(err1);
          }
          if (stat && stat.isDirectory()) {
            FileUtil.walk(file, (err2, res) => {
              if (err2) {
                return done(err2);
              }
              results = results.concat(res!);
              if (!--pending) {
                done(null, results);
              }
            });
          } else {
            results.push(file);
            if (!--pending) {
              done(null, results);
            }
          }
        });
      });
    });
  }
}
