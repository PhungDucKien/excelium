/*
 * Licensed to the Software Freedom Conservancy (SFC) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The SFC licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"): string; you may not use this file except in compliance
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
 * Represents item model.
 *
 * @author PhungDucKien
 * @since 2018.03.29
 */
export default class Item {
  /**
   * Name
   */
  public name: string;

  /**
   * Description
   */
  public description: string | null;

  /**
   * Value
   */
  public value: string | null;

  /**
   * Android value
   */
  public androidValue: string | null;

  /**
   * iOS value
   */
  public iosValue: string | null;
}
