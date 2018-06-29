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

package excelium.doclet.i18n;

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
    public void testGetPushMessage() {
        Assert.assertEquals("Stores subject in an array variable for later access.", Language.ENGLISH.getPushMessage("subject"));
    }

    @Test
    public void testGetStoreMessage() {
        Assert.assertEquals("Stores subject in a variable for later access.", Language.ENGLISH.getStoreMessage("subject"));
    }

    @Test
    public void testGetWaitMessage() {
        Assert.assertEquals("Waits for subject equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getEqualVerb()));
        Assert.assertEquals("Waits for subject not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getNotEqualVerb()));
        Assert.assertEquals("Waits for subject contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getContainVerb()));
        Assert.assertEquals("Waits for subject not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.", Language.ENGLISH.getWaitMessage("subject", Language.ENGLISH.getNotContainVerb()));

        Assert.assertEquals("Waits for subject. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.", Language.ENGLISH.getWaitMessage("subject", null));
    }

    @Test
    public void testGetExecuteMessage() {
        Assert.assertEquals("Executes an action if subject equals to the given value.", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getEqualVerb()));
        Assert.assertEquals("Executes an action if subject not equal to the given value.", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getNotEqualVerb()));
        Assert.assertEquals("Executes an action if subject contains the given value.", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getContainVerb()));
        Assert.assertEquals("Executes an action if subject not contain the given value.", Language.ENGLISH.getExecuteMessage("subject", Language.ENGLISH.getNotContainVerb()));

        Assert.assertEquals("Executes an action if subject.", Language.ENGLISH.getExecuteMessage("subject", null));
    }

    @Test
    public void testGetVerifyMessage() {
        Assert.assertEquals("Verifies that subject equals to the given value. When the verify fails, the test will continue execution, logging the failure.", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getEqualVerb()));
        Assert.assertEquals("Verifies that subject not equal to the given value. When the verify fails, the test will continue execution, logging the failure.", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getNotEqualVerb()));
        Assert.assertEquals("Verifies that subject contains the given value. When the verify fails, the test will continue execution, logging the failure.", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getContainVerb()));
        Assert.assertEquals("Verifies that subject not contain the given value. When the verify fails, the test will continue execution, logging the failure.", Language.ENGLISH.getVerifyMessage("subject", Language.ENGLISH.getNotContainVerb()));

        Assert.assertEquals("Verifies that subject. When the verify fails, the test will continue execution, logging the failure.", Language.ENGLISH.getVerifyMessage("subject", null));
    }

    @Test
    public void testGetAssertMessage() {
        Assert.assertEquals("Asserts that subject equals to the given value. When the assert fails, the test is aborted.", Language.ENGLISH.getAssertMessage("subject", Language.ENGLISH.getEqualVerb()));
        Assert.assertEquals("Asserts that subject not equal to the given value. When the assert fails, the test is aborted.", Language.ENGLISH.getAssertMessage("subject", Language.ENGLISH.getNotEqualVerb()));
        Assert.assertEquals("Asserts that subject contains the given value. When the assert fails, the test is aborted.", Language.ENGLISH.getAssertMessage("subject", Language.ENGLISH.getContainVerb()));
        Assert.assertEquals("Asserts that subject not contain the given value. When the assert fails, the test is aborted.", Language.ENGLISH.getAssertMessage("subject", Language.ENGLISH.getNotContainVerb()));

        Assert.assertEquals("Asserts that subject. When the assert fails, the test is aborted.", Language.ENGLISH.getAssertMessage("subject", null));
    }
}