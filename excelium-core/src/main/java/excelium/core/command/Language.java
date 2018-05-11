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
        public String getPossessiveNoun(String possessor, String possessed) {
            return possessor + "'s " + possessed;
        }

        @Override
        public String getToBeVerb() {
            return "is";
        }

        @Override
        public String getNotToBeVerb() {
            return "is not";
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
        public String getPushMessage(String subject, String target) {
            return "Push " + subject + " to ${" + target + "} and store";
        }

        @Override
        public String getStoreMessage(String subject, String target) {
            return "Store " + subject + " as ${" + target + "}";
        }

        @Override
        public String getWaitMessage(String subject, String verb, String target) {
            if (StringUtils.isNotBlank(target)) {
                return "Wait until " + subject + " " + verb + " [ " + target + " ]";
            } else {
                return "Wait until " + subject;
            }
        }

        @Override
        public String getExecuteMessage(String subject, String verb, String target) {
            if (StringUtils.isNotBlank(target)) {
                return "Execute #1 if " + subject + " " + verb + " [ " + target + " ]";
            } else {
                return "Execute #1 if " + subject;
            }
        }

        @Override
        public String getVerifyMessage(String subject, String verb, String target) {
            if (StringUtils.isNotBlank(target)) {
                return "Verify that " + subject + " " + verb + " [ " + target + " ]";
            } else {
                return "Verify that " + subject;
            }
        }

        @Override
        public String getAssertMessage(String verifyMessage) {
            return verifyMessage.replace("Verify that", "Assert that") + ". (If not, stop test case.)";
        }
    },
    /**
     * The Japanese language.
     */
    JAPANESE {
        @Override
        public String getPossessiveNoun(String possessor, String possessed) {
            return possessor + " の " + possessed;
        }

        @Override
        public String getToBeVerb() {
            return "である";
        }

        @Override
        public String getNotToBeVerb() {
            return "ではない";
        }

        @Override
        public String getContainVerb() {
            return "を含む";
        }

        @Override
        public String getNotContainVerb() {
            return "を含まない";
        }

        @Override
        public String getPushMessage(String subject, String target) {
            return subject + " を ${" + target + "}　に追加して保存。";
        }

        @Override
        public String getStoreMessage(String subject, String target) {
            return "${" + target + "}　として、" + subject + " を保存。";
        }

        @Override
        public String getWaitMessage(String subject, String verb, String target) {
            if (StringUtils.isNotBlank(target)) {
                return subject + "が「" + target + "」" + verb + "まで待機。";
            } else {
                return subject + "まで待機。";
            }
        }

        @Override
        public String getExecuteMessage(String subject, String verb, String target) {
            if (StringUtils.isNotBlank(target)) {
                return subject + "が「" + target + "」" + verb + "場合、#1 を実行。";
            } else {
                return subject + "場合、#1 を実行。";
            }
        }

        @Override
        public String getVerifyMessage(String subject, String verb, String target) {
            if (StringUtils.isNotBlank(target)) {
                return subject + "が「" + target + "」" + verb + "こと。";
            } else {
                return subject + "こと。";
            }
        }

        @Override
        public String getAssertMessage(String verifyMessage) {
            return verifyMessage + "（※違う場合はテストを中断）";
        }
    };

    /**
     * Forms a possessive noun.
     *
     * @param possessor the possessor
     * @param possessed the possessed
     * @return the possessive noun
     */
    abstract String getPossessiveNoun(String possessor, String possessed);

    /**
     * Gets the to be verb (present tense).
     *
     * @return the to be verb
     */
    abstract String getToBeVerb();

    /**
     * Gets the not to be verb (present tense).
     *
     * @return the not to be verb
     */
    abstract String getNotToBeVerb();

    /**
     * Gets the contain verb (present tense).
     *
     * @return the contain verb
     */
    abstract String getContainVerb();

    /**
     * Gets the not contain verb (present tense).
     *
     * @return the not contain verb
     */
    abstract String getNotContainVerb();

    /**
     * Gets the push command description
     *
     * @param subject the subject
     * @param target  the target
     * @return the push command description
     */
    abstract String getPushMessage(String subject, String target);

    /**
     * Gets the store command description
     *
     * @param subject the subject
     * @param target  the target
     * @return the store command description
     */
    abstract String getStoreMessage(String subject, String target);

    /**
     * Gets the wait command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @param target  the target
     * @return the wait command description
     */
    abstract String getWaitMessage(String subject, String verb, String target);

    /**
     * Gets the execute command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @param target  the target
     * @return the execute command description
     */
    abstract String getExecuteMessage(String subject, String verb, String target);

    /**
     * Gets the verify command description
     *
     * @param subject the subject
     * @param verb    the verb
     * @param target  the target
     * @return the verify command description
     */
    abstract String getVerifyMessage(String subject, String verb, String target);

    /**
     * Transforms verify message to assert message.
     *
     * @param verifyMessage the verify message
     * @return the assert command description
     */
    abstract String getAssertMessage(String verifyMessage);
}
