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

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a command description language.
 *
 * @author PhungDucKien
 * @since 2018.05.10
 */
public enum Language {

    /**
     * The English language.
     */
    ENGLISH {
        @Override
        public String getToBeVerb() {
            return "is";
        }

        @Override
        public String getNotToBeVerb() {
            return "is not";
        }

        @Override
        public String getEqualVerb() {
            return "equals to";
        }

        @Override
        public String getNotEqualVerb() {
            return "not equal to";
        }

        @Override
        public String getContainVerb() {
            return "contains";
        }

        @Override
        public String getNotContainVerb() {
            return "not contain";
        }

        @Override
        public String getPushMessage(String subject) {
            return "Stores " + subject + " in an array variable for later access.";
        }

        @Override
        public String getStoreMessage(String subject) {
            return "Stores " + subject + " in a variable for later access.";
        }

        @Override
        public String getWaitMessage(String subject, String verb) {
            if (StringUtils.isNotBlank(verb)) {
                return "Waits for " + subject + " " + verb + " the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.";
            } else {
                return "Waits for " + subject + ". They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.";
            }
        }

        @Override
        public String getExecuteMessage(String subject, String verb) {
            if (StringUtils.isNotBlank(verb)) {
                return "Executes an action if " + subject + " " + verb + " the given value.";
            } else {
                return "Executes an action if " + subject + ".";
            }
        }

        @Override
        public String getVerifyMessage(String subject, String verb) {
            if (StringUtils.isNotBlank(verb)) {
                return "Verifies that " + subject + " " + verb + " the given value. When the verify fails, the test will continue execution, logging the failure.";
            } else {
                return "Verifies that " + subject + ". When the verify fails, the test will continue execution, logging the failure.";
            }
        }

        @Override
        public String getAssertMessage(String subject, String verb) {
            if (StringUtils.isNotBlank(verb)) {
                return "Asserts that " + subject + " " + verb + " the given value. When the assert fails, the test is aborted.";
            } else {
                return "Asserts that " + subject + ". When the assert fails, the test is aborted.";
            }
        }
    };

    /**
     * Gets the to be verb (present tense).
     *
     * @return the to be verb
     */
    public abstract String getToBeVerb();

    /**
     * Gets the not to be verb (present tense).
     *
     * @return the not to be verb
     */
    public abstract String getNotToBeVerb();

    /**
     * Gets the equal verb (present tense).
     *
     * @return the equal verb
     */
    public abstract String getEqualVerb();

    /**
     * Gets the not equal verb (present tense).
     *
     * @return the not equal verb
     */
    public abstract String getNotEqualVerb();

    /**
     * Gets the contain verb (present tense).
     *
     * @return the contain verb
     */
    public abstract String getContainVerb();

    /**
     * Gets the not contain verb (present tense).
     *
     * @return the not contain verb
     */
    public abstract String getNotContainVerb();

    /**
     * Gets the push command description
     *
     * @param subject the subject
     * @return the push command description
     */
    public abstract String getPushMessage(String subject);

    /**
     * Gets the store command description
     *
     * @param subject the subject
     * @return the store command description
     */
    public abstract String getStoreMessage(String subject);

    /**
     * Gets the wait command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @return the wait command description
     */
    public abstract String getWaitMessage(String subject, String verb);

    /**
     * Gets the execute command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @return the execute command description
     */
    public abstract String getExecuteMessage(String subject, String verb);

    /**
     * Gets the verify command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @return the verify command description
     */
    public abstract String getVerifyMessage(String subject, String verb);

    /**
     * Gets the assert command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @return the assert command description
     */
    public abstract String getAssertMessage(String subject, String verb);
}
