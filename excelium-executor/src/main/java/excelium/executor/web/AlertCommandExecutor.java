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

import com.thoughtworks.selenium.SeleniumException;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

/**
 * Represents a class which contains commands for controlling alert dialogs.
 *
 * @author PhungDucKien
 * @since 2018.06.29
 */
public class AlertCommandExecutor extends CommandExecutor {

    /**
     * Instantiates a new Alert command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public AlertCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Returns true if an alert dialog is present, or false otherwise.
     *
     * <p>
     * This function never throws an exception
     * </p>
     *
     * @return true if there is an alert
     */
    @Accessor
    public boolean isAlertPresent() {
        return checkAlertPresent();
    }

    /**
     * Returns true if a confirmation dialog is present, or false otherwise.
     *
     * <p>
     * This function never throws an exception
     * </p>
     *
     * @return true if there is a pending confirmation
     */
    @Accessor
    public boolean isConfirmationPresent() {
        return checkAlertPresent();
    }

    /**
     * Returns true if a prompt dialog is present, or false otherwise.
     *
     * <p>
     * This function never throws an exception
     * </p>
     *
     * @return true if there is a pending prompt
     */
    @Accessor
    public boolean isPromptPresent() {
        return checkAlertPresent();
    }

    /**
     * Retrieves the message of a JavaScript alert, or fail if there were no alerts.
     *
     * @return The message of the JavaScript alert
     */
    @Accessor
    public String getAlert() {
        if (!isAlertPresent()) {
            throw new SeleniumException("There were no alerts");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            return alert.getText();
        }
        return null;
    }

    /**
     * Retrieves the message of a JavaScript confirmation dialog.
     *
     * @return the message of the JavaScript confirmation dialog
     */
    @Accessor
    public String getConfirmation() {
        if (!isConfirmationPresent()) {
            throw new SeleniumException("There were no confirmations");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            return alert.getText();
        }
        return null;
    }

    /**
     * Retrieves the message of a JavaScript question prompt dialog.
     *
     * @return the message of the JavaScript question prompt
     */
    @Accessor
    public String getPrompt() {
        if (!isPromptPresent()) {
            throw new SeleniumException("There were no prompts");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            return alert.getText();
        }
        return null;
    }

    /**
     * Simulates as if the user had manually clicked OK.
     */
    @Action
    public void chooseOkAlert() {
        if (!isAlertPresent()) {
            throw new SeleniumException("There were no alerts");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            alert.accept();
        }
    }

    /**
     * Simulates as if the user had manually clicked OK.
     */
    @Action
    public void chooseOkConfirmation() {
        if (!isConfirmationPresent()) {
            throw new SeleniumException("There were no confirmations");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            alert.accept();
        }
    }

    /**
     * Simulates as if the user had manually clicked Cancel.
     */
    @Action
    public void chooseCancelConfirmation() {
        if (!isConfirmationPresent()) {
            throw new SeleniumException("There were no confirmations");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            alert.dismiss();
        }
    }

    /**
     * Instructs Selenium to return the specified answer string in response to the JavaScript
     * prompt [window.prompt()].
     *
     * @param answer the answer to give in response to the prompt pop-up
     */
    @Action(param1 = "answer")
    public void answerPrompt(String answer) {
        if (!isPromptPresent()) {
            throw new SeleniumException("There were no prompts");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            if (StringUtils.isNotBlank(answer)) {
                alert.sendKeys(answer);
            }
            alert.accept();
        }
    }

    /**
     * Simulates as if the user had manually clicked Cancel.
     */
    @Action
    public void chooseCancelPrompt() {
        if (!isPromptPresent()) {
            throw new SeleniumException("There were no prompts");
        }
        Alert alert = webDriver.switchTo().alert();
        if (alert != null) {
            alert.dismiss();
        }
    }

    /**
     * Determines whether an alert dialog is present.
     *
     * @return true if an alert dialog is present, false otherwise.
     */
    private boolean checkAlertPresent() {
        try {
            webDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
