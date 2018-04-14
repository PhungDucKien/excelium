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

package excelium.cli;

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.prompt.ConfirmResult;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import de.codeshelf.consoleui.prompt.builder.ListPromptBuilder;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import excelium.common.FileUtil;
import excelium.common.StringUtil;
import excelium.model.enums.WorkbookType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Provides common functions to prompt for user input
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class Prompt {

    /**
     * Prompts for user to input text.
     *
     * @param message A message that is displayed to user
     * @param defaultValue A default value if user press Enter immediately
     * @return User-input value
     * @throws IOException if an I/O exception is thrown
     */
    public static String promptInput(String message, String defaultValue) throws IOException {
        ConsolePrompt prompt = new ConsolePrompt();
        PromptBuilder promptBuilder = prompt.getPromptBuilder();

        promptBuilder.createInputPrompt()
                .message(message)
                .defaultValue(defaultValue)
                .addPrompt();

        InputResult inputResult = (InputResult) prompt.prompt(promptBuilder.build()).values().iterator().next();
        return inputResult.getInput();
    }

    /**
     * Prompts for user to select an item
     *
     * @param message A message that is displayed to user
     * @param options Array of options. Each option is 2-elements string array
     * @return User selected option
     * @throws IOException if an I/O exception is thrown
     */
    public static String promptList(String message, String[]... options) throws IOException {
        ConsolePrompt prompt = new ConsolePrompt();
        PromptBuilder promptBuilder = prompt.getPromptBuilder();

        ListPromptBuilder listPromptBuilder = promptBuilder.createListPrompt()
                .message(message);

        for (String[] option : options) {
            listPromptBuilder.newItem(option[0]).text(option[1]).add();
        }

        listPromptBuilder.addPrompt();

        ListResult listResult = (ListResult) prompt.prompt(promptBuilder.build()).values().iterator().next();
        return listResult.getSelectedId();
    }

    /**
     * Prompts for user to select an item
     *
     * @param message A message that is displayed to user
     * @param options List of options.
     * @return User selected option
     * @throws IOException if an I/O exception is thrown
     */
    public static String promptList(String message, List<String> options) throws IOException {
        ConsolePrompt prompt = new ConsolePrompt();
        PromptBuilder promptBuilder = prompt.getPromptBuilder();

        ListPromptBuilder listPromptBuilder = promptBuilder.createListPrompt()
                .message(message);

        for (String option : options) {
            listPromptBuilder.newItem(option).text(option).add();
        }

        listPromptBuilder.addPrompt();

        ListResult listResult = (ListResult) prompt.prompt(promptBuilder.build()).values().iterator().next();
        return listResult.getSelectedId();
    }

    /**
     * Prompts for user to confirm
     *
     * @param message A message that is displayed to user
     * @return User confirmed value
     * @throws IOException if an I/O exception is thrown
     */
    public static boolean promptConfirm(String message) throws IOException {
        ConsolePrompt prompt = new ConsolePrompt();
        PromptBuilder promptBuilder = prompt.getPromptBuilder();

        promptBuilder.createConfirmPromp()
                .message(message)
                .addPrompt();

        ConfirmResult confirmResult = (ConfirmResult) prompt.prompt(promptBuilder.build()).values().iterator().next();
        return confirmResult.getConfirmed() == ConfirmChoice.ConfirmationValue.YES;
    }

    /**
     * Prompts for file location.
     * Lists all files in a given directory, if workbook type is Microsoft Excel,
     * or asks for the spreadsheet url or id, if workbook type is Google Sheets.
     *
     * @param workbookType   the workbook type
     * @param excelPath      the excel path
     * @param excelQuestion  the excel question
     * @param sheetsQuestion the sheets question
     * @return the string
     * @throws IOException the io exception
     */
    public static String promptFileLocation(WorkbookType workbookType, Path excelPath, String excelQuestion, String sheetsQuestion) throws IOException {
        if (workbookType == WorkbookType.EXCEL) {
            List<String> filePaths = FileUtil.listFiles(excelPath);
            String filePath = Prompt.promptList(excelQuestion, filePaths);
            return excelPath.resolve(filePath).toString();
        } else if (workbookType == WorkbookType.SHEETS) {
            String spreadsheetLocation = Prompt.promptInput(sheetsQuestion, null);
            return StringUtil.extractSpreadsheetId(spreadsheetLocation);
        }
        return null;
    }
}
