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
import org.openqa.selenium.NoSuchSessionException;
import org.seleniumhq.jetty9.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StepOverSessionServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String sessionId = request.getParameter("sessionId"); // Session ID
            DebugSession debugSession = DebugSessionHolder.getInstance().getSession(sessionId);
            if (debugSession == null) {
                response.setStatus(HttpStatus.NOT_FOUND_404);
                writeToResponse(new ErrorResponse(new NoSuchSessionException("Session is either terminated or not started")), response);
                return;
            }
            debugSession.stepOver();
            writeToResponse("{\"result\":\"OK\"}", response);
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
