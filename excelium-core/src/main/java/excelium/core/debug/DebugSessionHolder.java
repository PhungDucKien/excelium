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

package excelium.core.debug;

import excelium.core.driver.ContextAwareWebDriver;

import java.util.HashMap;
import java.util.Map;

public class DebugSessionHolder {

    private static DebugSessionHolder instance = new DebugSessionHolder();
    private Map<String, DebugSession> debugSessions = new HashMap<>();

    private DebugSessionHolder() {
    }

    public static DebugSessionHolder getInstance() {
        return instance;
    }

    public DebugSession createSession(ContextAwareWebDriver webDriver) {
        DebugSession debugSession = new DebugSession(webDriver);
        debugSessions.put(webDriver.getSessionId().toString(), debugSession);
        return debugSession;
    }

    public void killSession(String sessionId, boolean killedByUser) {
        DebugSession debugSession = debugSessions.get(sessionId);
        debugSessions.remove(sessionId);

        if (debugSession != null) {
            debugSession.close("", killedByUser);
        }
    }

    public DebugSession getSession(String sessionId) {
        DebugSession debugSession = debugSessions.get(sessionId);
        if (debugSession != null) {
            return debugSession;
        }
        return null;
    }
}
