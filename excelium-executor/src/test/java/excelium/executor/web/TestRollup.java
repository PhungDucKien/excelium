/*
 * MIT License
 *
 * Copyright (c) 2018 Excelium
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package excelium.executor.web;

import org.junit.Test;

public class TestRollup extends WebExecutorTestBase {
  @Test
  public void testRollup() {
//    // TODO(simon): re-enable this. It looks like the addScript method is not right
//    selenium.addScript(getRollupScript(), "rollup");
//    selenium.open("../tests/html/test_rollup.html");
//    selenium.rollup("cake", "");
//    selenium.rollup("biscuits", "n=1");
//    verifyFalse(selenium.isChecked("name=one"));
//    verifyTrue(selenium.isChecked("name=dos"));
//    verifyTrue(selenium.isChecked("name=san"));
//    selenium.rollup("biscuits", "n=2");
//    verifyTrue(selenium.isChecked("name=one"));
//    verifyFalse(selenium.isChecked("name=dos"));
//    verifyTrue(selenium.isChecked("name=san"));
//    selenium.rollup("biscuits", "n=3");
//    verifyFalse(selenium.isChecked("name=one"));
//    verifyTrue(selenium.isChecked("name=dos"));
//    verifyFalse(selenium.isChecked("name=san"));
//    selenium.rollup("steamed spinach", "");
//    selenium.removeScript("rollup");
  }

  private String getRollupScript() {
    return "var rm = new RollupManager();\n"
        + "\n"
        + "rm.addRollupRule({\n"
        + "    name: 'cake'\n"
        + "    , description: \"Why we're all here\"\n"
        + "    , commandMatchers: []\n"
        + "    , expandedCommands: [\n"
        + "          new Command('verifyNotChecked', 'name=one')\n"
        + "        , new Command('verifyNotChecked', 'name=dos')\n"
        + "        , new Command('verifyNotChecked', 'name=san')\n"
        + "        , new Command('click', 'name=san')\n"
        + "        , new Command('click', 'name=dos')\n"
        + "        , new Command('click', 'name=one')\n"
        + "        , new Command('verifyText', 'id=message', 'HAPPY BIRTHDAY!')\n"
        + "    ]\n"
        + "});\n"
        + "\n"
        + "rm.addRollupRule({\n"
        + "    name: 'biscuits'\n"
        + "    , description: \"The rest of the time\"\n"
        + "    , commandMatchers: []\n"
        + "    , getExpandedCommands: function(args) {\n"
        + "        var commands = [];\n"
        + "        if (args.n >= 1) {\n"
        + "            commands.push(new Command('click', 'name=one'));\n"
        + "        }\n"
        + "        if (args.n >= 2) {\n"
        + "            commands.push(new Command('click', 'name=dos'));\n"
        + "        }\n"
        + "        if (args.n >= 3) {\n"
        + "            commands.push(new Command('click', 'name=san'));\n"
        + "        }\n"
        + "        return commands;\n"
        + "    }\n"
        + "});\n"
        + "\n"
        + "rm.addRollupRule({\n"
        + "    name: 'steamed spinach'\n"
        + "    , description: \"No complaints\"\n"
        + "    , commandMatchers: []\n"
        + "    , expandedCommands: [\n"
        + "          new Command('rollup', 'biscuits', 'n=2')\n"
        + "        , new Command('rollup', 'biscuits', 'n=1')\n"
        + "        , new Command('rollup', 'cake')\n"
        + "    ]\n"
        + "});";
  }
}
