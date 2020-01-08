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

import Environment from './config/Environment';
import Test from './Test';

/**
 * Represents the state of test execution.
 *
 * @author PhungDucKien
 * @since 2018.05.14
 */
export default class TestState {
  /**
   * The Test.
   */
  public test: Test;

  /**
   * The Test total count.
   */
  public testTotalCount: number;

  /**
   * The Test executed count.
   */
  public testExecutedCount: number;

  /**
   * The Test error count.
   */
  public testErrorCount: number;

  /**
   * The Test failed count.
   */
  public testFailedCount: number;

  /**
   * The Test skipped count.
   */
  public testSkippedCount: number;

  /**
   * The Environment.
   */
  public environment: Environment;

  /**
   * The Environment total count.
   */
  public environmentTotalCount: number;

  /**
   * The Environment executed count.
   */
  public environmentExecutedCount: number;

  /**
   * The Environment error count.
   */
  public environmentErrorCount: number;

  /**
   * The Environment failed count.
   */
  public environmentFailedCount: number;

  /**
   * The Environment skipped count.
   */
  public environmentSkippedCount: number;

  /**
   * The Suite total count.
   */
  public suiteTotalCount: number;

  /**
   * The Suite executed count.
   */
  public suiteExecutedCount: number;

  /**
   * The Suite error count.
   */
  public suiteErrorCount: number;

  /**
   * The Suite failed count.
   */
  public suiteFailedCount: number;

  /**
   * The Suite skipped count.
   */
  public suiteSkippedCount: number;

  /**
   * The Case total count.
   */
  public caseTotalCount: number;

  /**
   * The Case executed count.
   */
  public caseExecutedCount: number;

  /**
   * The Case error count.
   */
  public caseErrorCount: number;

  /**
   * The Case failed count.
   */
  public caseFailedCount: number;

  /**
   * The Case skipped count.
   */
  public caseSkippedCount: number;
}
