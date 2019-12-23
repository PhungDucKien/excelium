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

import org.openqa.selenium.net.UrlChecker;
import org.seleniumhq.jetty9.server.Connector;
import org.seleniumhq.jetty9.server.Server;
import org.seleniumhq.jetty9.server.ServerConnector;
import org.seleniumhq.jetty9.server.handler.HandlerList;
import org.seleniumhq.jetty9.servlet.DefaultServlet;
import org.seleniumhq.jetty9.servlet.ErrorPageErrorHandler;
import org.seleniumhq.jetty9.servlet.ServletContextHandler;
import org.seleniumhq.jetty9.servlet.ServletHolder;
import org.seleniumhq.jetty9.util.resource.Resource;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DebugServer {

    /**
     * The port number the server should use.
     */
    private static final Integer PORT = 7714;

    private Server server;
    private boolean running;
    private String serverUrl;

    public void start() {
        if (!isRunning()) {
            int port = PORT;

            try {
                startServer(port);

                serverUrl = "http://localhost:" + port;

                URL status = new URL(serverUrl + "/api/health");
                new UrlChecker().waitUntilAvailable(60, TimeUnit.SECONDS, status);

                running = true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        if (isRunning()) {
            try {
                server.stop();

                server = null;
                running = false;
                serverUrl = null;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void startServer(int port) throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});

        HandlerList handlers = new HandlerList();

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletContext.setContextPath("/");
        servletContext.setBaseResource(Resource.newClassPathResource("/html"));

        servletContext.addServlet(new ServletHolder(new HealthServlet()), "/api/health");
        servletContext.addServlet(new ServletHolder(new SessionDetailsServlet()), "/api/session/details");
        servletContext.addServlet(new ServletHolder(new RestartRecorderServlet()), "/api/session/restart");
        servletContext.addServlet(new ServletHolder(new ClientMethodHandleServlet()), "/api/session/execute");
        servletContext.addServlet(new ServletHolder(new StepOverSessionServlet()), "/api/session/step-over");
        servletContext.addServlet(new ServletHolder(new ResumeSessionServlet()), "/api/session/resume");
        servletContext.addServlet(new ServletHolder(new MuteAndResumeSessionServlet()), "/api/session/mute-resume");
        servletContext.addServlet(DefaultServlet.class, "/");

        ErrorPageErrorHandler errorHandler = new ErrorPageErrorHandler();
        errorHandler.addErrorPage(404, "/");
        servletContext.setErrorHandler(errorHandler);

        handlers.addHandler(servletContext);

        server.setHandler(handlers);
        server.start();
    }

    public boolean isRunning() {
        return running;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public static void main(String[] args) {
        DebugServer server = new DebugServer();
        server.start();
    }
}
