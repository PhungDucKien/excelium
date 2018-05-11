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

package excelium.core.command;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link Language}.
 *
 * @author PhungDucKien
 * @since 2018.05.11
 */
public class LanguageTest {

    @Test
    public void testGetPossessiveNoun() {
        Assert.assertEquals("A's B", Language.ENGLISH.getPossessiveNoun("A", "B"));
        Assert.assertEquals("A の B", Language.JAPANESE.getPossessiveNoun("A", "B"));
    }

    @Test
    public void testGetPushMessage() {
        Assert.assertEquals("Push subject to ${target} and store", Language.ENGLISH.getPushMessage("subject", "target"));
        Assert.assertEquals("subject を ${target}　に追加して保存。", Language.JAPANESE.getPushMessage("subject", "target"));
    }

    @Test
    public void testGetStoreMessage() {
        Assert.assertEquals("Store subject as ${target}", Language.ENGLISH.getStoreMessage("subject", "target"));
        Assert.assertEquals("${target}　として、subject を保存。", Language.JAPANESE.getStoreMessage("subject", "target"));
    }

    @Test
    public void testGetWaitMessage() {
        Assert.assertEquals("Wait until subject is [ target ]", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getToBeVerb(), "target"));
        Assert.assertEquals("subjectが「target」であるまで待機。", Language.JAPANESE.getWaitMessage("subject", Language.JAPANESE.getToBeVerb(), "target"));
        Assert.assertEquals("Wait until subject is not [ target ]", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getNotToBeVerb(), "target"));
        Assert.assertEquals("subjectが「target」ではないまで待機。", Language.JAPANESE.getWaitMessage("subject", Language.JAPANESE.getNotToBeVerb(), "target"));
        Assert.assertEquals("Wait until subject contains [ target ]", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getContainVerb(), "target"));
        Assert.assertEquals("subjectが「target」を含むまで待機。", Language.JAPANESE.getWaitMessage("subject", Language.JAPANESE.getContainVerb(), "target"));
        Assert.assertEquals("Wait until subject not contain [ target ]", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getNotContainVerb(), "target"));
        Assert.assertEquals("subjectが「target」を含まないまで待機。", Language.JAPANESE.getWaitMessage("subject", Language.JAPANESE.getNotContainVerb(), "target"));

        Assert.assertEquals("Wait until subject", Language.ENGLISH.getWaitMessage("subject", null, null));
        Assert.assertEquals("subjectまで待機。", Language.JAPANESE.getWaitMessage("subject", null, null));
    }

    @Test
    public void testGetExecuteMessage() {
        Assert.assertEquals("Execute #1 if subject is [ target ]", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getToBeVerb(), "target"));
        Assert.assertEquals("subjectが「target」である場合、#1 を実行。", Language.JAPANESE.getExecuteMessage("subject", Language.JAPANESE.getToBeVerb(), "target"));
        Assert.assertEquals("Execute #1 if subject is not [ target ]", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getNotToBeVerb(), "target"));
        Assert.assertEquals("subjectが「target」ではない場合、#1 を実行。", Language.JAPANESE.getExecuteMessage("subject", Language.JAPANESE.getNotToBeVerb(), "target"));
        Assert.assertEquals("Execute #1 if subject contains [ target ]", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getContainVerb(), "target"));
        Assert.assertEquals("subjectが「target」を含む場合、#1 を実行。", Language.JAPANESE.getExecuteMessage("subject", Language.JAPANESE.getContainVerb(), "target"));
        Assert.assertEquals("Execute #1 if subject not contain [ target ]", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getNotContainVerb(), "target"));
        Assert.assertEquals("subjectが「target」を含まない場合、#1 を実行。", Language.JAPANESE.getExecuteMessage("subject", Language.JAPANESE.getNotContainVerb(), "target"));

        Assert.assertEquals("Execute #1 if subject", Language.ENGLISH.getExecuteMessage("subject", null, null));
        Assert.assertEquals("subject場合、#1 を実行。", Language.JAPANESE.getExecuteMessage("subject", null, null));
    }

    @Test
    public void testGetVerifyMessage() {
        Assert.assertEquals("Verify that subject is [ target ]", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getToBeVerb(), "target"));
        Assert.assertEquals("subjectが「target」であること。", Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getToBeVerb(), "target"));
        Assert.assertEquals("Verify that subject is not [ target ]", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getNotToBeVerb(), "target"));
        Assert.assertEquals("subjectが「target」ではないこと。", Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getNotToBeVerb(), "target"));
        Assert.assertEquals("Verify that subject contains [ target ]", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getContainVerb(), "target"));
        Assert.assertEquals("subjectが「target」を含むこと。", Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getContainVerb(), "target"));
        Assert.assertEquals("Verify that subject not contain [ target ]", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getNotContainVerb(), "target"));
        Assert.assertEquals("subjectが「target」を含まないこと。", Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getNotContainVerb(), "target"));

        Assert.assertEquals("Verify that subject", Language.ENGLISH.getVerifyMessage("subject", null, null));
        Assert.assertEquals("subjectこと。", Language.JAPANESE.getVerifyMessage("subject", null, null));
    }

    @Test
    public void testGetAssertMessage() {
        Assert.assertEquals("Assert that subject is [ target ]. (If not, stop test case.)", Language.ENGLISH.getAssertMessage(Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getToBeVerb(), "target")));
        Assert.assertEquals("subjectが「target」であること。（※違う場合はテストを中断）", Language.JAPANESE.getAssertMessage(Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getToBeVerb(), "target")));
        Assert.assertEquals("Assert that subject is not [ target ]. (If not, stop test case.)", Language.ENGLISH.getAssertMessage(Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getNotToBeVerb(), "target")));
        Assert.assertEquals("subjectが「target」ではないこと。（※違う場合はテストを中断）", Language.JAPANESE.getAssertMessage(Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getNotToBeVerb(), "target")));
        Assert.assertEquals("Assert that subject contains [ target ]. (If not, stop test case.)", Language.ENGLISH.getAssertMessage(Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getContainVerb(), "target")));
        Assert.assertEquals("subjectが「target」を含むこと。（※違う場合はテストを中断）", Language.JAPANESE.getAssertMessage(Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getContainVerb(), "target")));
        Assert.assertEquals("Assert that subject not contain [ target ]. (If not, stop test case.)", Language.ENGLISH.getAssertMessage(Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getNotContainVerb(), "target")));
        Assert.assertEquals("subjectが「target」を含まないこと。（※違う場合はテストを中断）", Language.JAPANESE.getAssertMessage(Language.JAPANESE.getVerifyMessage("subject", Language.JAPANESE.getNotContainVerb(), "target")));

        Assert.assertEquals("Assert that subject. (If not, stop test case.)", Language.ENGLISH.getAssertMessage(Language.ENGLISH.getVerifyMessage("subject", null, null)));
        Assert.assertEquals("subjectこと。（※違う場合はテストを中断）", Language.JAPANESE.getAssertMessage(Language.JAPANESE.getVerifyMessage("subject", null, null)));
    }
}
