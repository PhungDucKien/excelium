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

import { ArgType, Command, text as _text, variable as _variable } from '../../../src/model';

export default new Command({
  name: 'Store',
  description: 'Save a target string as a variable for easy re-use.',
  args: {
    text: ArgType.exact(_text).isRequired(),
    variable: ArgType.exact(_variable).isRequired(),
  },
  validate({ text, variable }) {
    return this.args.text.validate(text) && this.args.variable.validate(variable);
  },
});
