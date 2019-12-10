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

package excelium.model.debug;

import java.util.Map;

public class SessionDetails {
    private Map<String, Object> desiredCapabilities;
    private Map<String, Object> sessionDetails;
    private String host;
    private Integer port;
    private String path;
    private Boolean https;

    public Map<String, Object> getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public void setDesiredCapabilities(Map<String, Object> desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }

    public Map<String, Object> getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(Map<String, Object> sessionDetails) {
        this.sessionDetails = sessionDetails;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean isHttps() {
        return https;
    }

    public void setHttps(Boolean https) {
        this.https = https;
    }
}