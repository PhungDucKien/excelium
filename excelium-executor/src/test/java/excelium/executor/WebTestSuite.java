/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.executor;

import excelium.executor.web.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MyExecutorProviderServiceTest.class,
        SeleniumMouseTest.class,
        TestAddSelection.class,
        TestAlerts.class,
        TestAttachFile.class,
        TestBasicAuth.class,
        TestCheckUncheck.class,
        TestClick.class,
        TestClickAt.class,
        TestClickBlankTarget.class,
        TestClickJavascriptHref.class,
        TestClickJavascriptHrefChrome.class,
        TestClickJavascriptHrefWithVoidChrome.class,
        TestCommandError.class,
        TestComments.class,
        TestConfirmations.class,
        TestCookie.class,
        TestCssLocators.class,
        TestCursorPosition.class,
        TestDojoDragAndDrop.class,
        TestDomainCookie.class,
        TestDragAndDrop.class,
        TestEditable.class,
        TestElementIndex.class,
        TestElementOrder.class,
        TestElementPresent.class,
        TestErrorChecking.class,
        TestEval.class,
        TestEvilClosingWindow.class,
        TestFailingAssert.class,
        TestFailingVerifications.class,
        TestFocusOnBlur.class,
        TestFramesClick.class,
        TestFramesClickJavascriptHref.class,
        TestFramesNested.class,
        TestFramesOpen.class,
        TestFramesSpecialTargets.class,
        TestFunkEventHandling.class,
        TestGet.class,
        TestGetTextContent.class,
        TestGettingValueOfCheckbox.class,
        TestGettingValueOfRadioButton.class,
        TestGoBack.class,
        TestHighlight.class,
        TestHtmlSource.class,
        TestImplicitLocators.class,
        TestJavaScriptAttributes.class,
        TestJavascriptParameters.class,
        TestLocators.class,
        TestModalDialog.class,
        TestMultiSelect.class,
        TestOpen.class,
        TestOpenInTargetFrame.class,
        TestPatternMatching.class,
        TestPause.class,
        TestPrompt.class,
        TestQuickOpen.class,
        TestRefresh.class,
        TestRollup.class,
        TestSelect.class,
        TestSelectMultiLevelFrame.class,
        TestSelectPopUp.class,
        TestSelectWindow.class,
        TestSelectWindowTitle.class,
        TestStore.class,
        TestSubmit.class,
        TestTable.class,
        TestTextWhitespace.class,
        TestType.class,
        TestTypeRichText.class,
        TestVerifications.class,
        TestVisibility.class,
        TestWait.class,
        TestWaitFor.class,
        TestWaitForNot.class,
        TestWaitInPopupWindow.class,
        TestXPathLocatorInXHtml.class,
        TestXPathLocators.class
})
public class WebTestSuite {
}
