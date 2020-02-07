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

import EventEmitter from 'events';

export * from './events';

export interface CommandStateChangePayload {
  id?: string | number;
  callstackIndex?: number;
  state: string;
  message?: string;
}

export interface ControlFlowChangePayload {
  commandId?: string | number;
  type?: string;
  index?: number;
  iterator?: any;
  collection?: any;
  end?: boolean;
}

export class PlaybackEventEmitter extends EventEmitter {
  public emitCommandStateChange?: (payload: CommandStateChangePayload) => void;
  public emitControlFlowChange?: (payload: ControlFlowChangePayload) => void;
}
