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

package excelium.executor.web.env;

import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.os.CommandLine;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Web test environment.
 *
 * @author PhungDucKien
 * @since 2018.06.29
 */
public class WebEnvironment {

    private CommandLine command;

    private String serverUrl;

    public WebEnvironment() {
        this(PortProber.findFreePort());
    }

    public WebEnvironment(int port) {
        try {
            String classPath = System.getProperty("java.class.path");

            List<Object> args = new ArrayList<>();
            args.add("-cp");
            args.add(classPath);
            args.add(HttpServer.class.getName());
            args.add("-port");
            args.add(String.valueOf(port));

            command = new CommandLine("java", args.toArray(new String[args.size()]));
            command.copyOutputTo(System.out);
            command.executeAsync();

            PortProber.pollPort(port);
            serverUrl = "http://localhost:" + port;

            URL status = new URL(serverUrl + "/tests");
            new UrlChecker().waitUntilAvailable(60, TimeUnit.SECONDS, status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getServerUrl() {
        return serverUrl;
    }


    public void stop() {
        command.destroy();
    }
}
