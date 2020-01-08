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
 * Represents mode of debugger execution step.
 *
 * @author PhungDucKien
 * @since 2019.12.06
 */
enum StepMode {
  STEP_OVER,
  STEP_NEXT_BREAKPOINT,
  STEP_MUTE,
}

namespace StepMode {
  /**
   * From name debugger execution step mode.
   *
   * @param name the name
   * @return the debugger execution step mode
   */
  export function fromName(name: string): StepMode {
    let stepMode = (StepMode as any)[name.toUpperCase()];
    if (!stepMode) {
      stepMode = StepMode.STEP_NEXT_BREAKPOINT;
    }
    return stepMode;
  }
}

export default StepMode;
