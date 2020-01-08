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

/**
 * Represents state of code execution.
 *
 * @author PhungDucKien
 * @since 2019.12.06
 */
enum ExecutionState {
  RUNNING,
  PAUSED,
  STOPPED,
}

namespace ExecutionState {
  /**
   * From name code execution state.
   *
   * @param name the name
   * @return the code execution state
   */
  export function fromName(name: string): ExecutionState {
    let executionState = (ExecutionState as any)[name.toUpperCase()];
    if (!executionState) {
      executionState = ExecutionState.PAUSED;
    }
    return executionState;
  }
}

export default ExecutionState;
