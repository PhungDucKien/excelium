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

package excelium.core.server;

import excelium.core.debug.DebugSession;
import excelium.core.debug.DebugSessionHolder;
import excelium.model.debug.ErrorResponse;
import excelium.model.debug.ExecuteResponse;
import excelium.model.debug.SourceAndScreenshot;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.seleniumhq.jetty9.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientMethodHandleServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String sessionId = request.getParameter("sessionId"); // Session ID
            String methodName = request.getParameter("methodName"); // Optional. Name of method being provided
            String strategy = request.getParameter("strategy"); // Optional. Element locator strategy
            String selector = request.getParameter("selector"); // Optional. Element fetch selector
            boolean fetchArray = Boolean.valueOf(request.getParameter("fetchArray")); // Optional. Are we fetching an array of elements or just one?
            String elementId = request.getParameter("elementId"); // Optional. Element being operated on
            Object[] args = gson.fromJson(request.getParameter("args"), Object[].class); // Optional. Arguments passed to method
            boolean skipScreenshotAndSource = Boolean.valueOf(request.getParameter("skipScreenshotAndSource")); // Optional. Do we want the updated source and screenshot?
            boolean ignoreResult = Boolean.valueOf(request.getParameter("ignoreResult")); // Optional. Do we want to send the result back to the renderer?

            DebugSession debugSession = DebugSessionHolder.getInstance().getSession(sessionId);
            if (debugSession == null) {
                response.setStatus(HttpStatus.NOT_FOUND_404);
                writeToResponse(new ErrorResponse(new NoSuchSessionException("Session is either terminated or not started")), response);
                return;
            }

            if ("quit".equals(methodName)) {
                DebugSessionHolder.getInstance().killSession(sessionId, args == null || args[0] == null);
                writeToResponse(new SourceAndScreenshot(), response);
            } else {
                if (StringUtils.isNotBlank(methodName)) {
                    ExecuteResponse executeResponse;
                    if (StringUtils.isNotBlank(elementId)) {
                        executeResponse = debugSession.executeElementCommand(elementId, methodName, args, skipScreenshotAndSource);
                    } else {
                        executeResponse = debugSession.executeMethod(methodName, args, skipScreenshotAndSource);
                    }
                    executeResponse.setMethodName(methodName);
                    executeResponse.setIgnoreResult(ignoreResult);
                    writeToResponse(executeResponse, response);
                } else if (StringUtils.isNotBlank(strategy) && StringUtils.isNotBlank(selector)) {
                    if (fetchArray) {
                        writeToResponse(debugSession.fetchElements(strategy, selector), response);
                    } else {
                        writeToResponse(debugSession.fetchElement(strategy, selector), response);
                    }
                }
            }
        } catch (Exception e) {
            if (e instanceof NoSuchSessionException) {
                response.setStatus(HttpStatus.NOT_FOUND_404);
                writeToResponse(new ErrorResponse(new NoSuchSessionException("Session is either terminated or not started")), response);
            } else {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR_500);
                writeToResponse(new ErrorResponse(e), response);
            }
        }
    }
}
