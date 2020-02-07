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

export default class Variables {
  private storedVars: Map<string, any>;

  constructor() {
    this.storedVars = new Map<string, any>();
  }

  public get(key: string) {
    return this.storedVars.get(key);
  }

  public set(key: string, value: any) {
    this.storedVars.set(key, value);
  }

  public has(key: string) {
    return this.storedVars.has(key);
  }

  public delete(key: string) {
    if (this.storedVars.has(key)) {
      this.storedVars.delete(key);
    }
  }

  public clear() {
    this.storedVars.clear();
  }
}
