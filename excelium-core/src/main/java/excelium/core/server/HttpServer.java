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
import org.seleniumhq.jetty9.server.handler.ContextHandler;
import org.seleniumhq.jetty9.server.handler.HandlerList;
import org.seleniumhq.jetty9.server.handler.ResourceHandler;
import org.seleniumhq.jetty9.servlet.ServletContextHandler;
import org.seleniumhq.jetty9.servlet.ServletHolder;
import org.seleniumhq.jetty9.util.resource.Resource;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HttpServer {

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

        ContextHandler context = new ContextHandler();
        context.setContextPath("/");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setBaseResource(Resource.newClassPathResource("/html"));
        context.setHandler(resourceHandler);
        handlers.addHandler(context);

        ServletContextHandler servletContext = new ServletContextHandler();
        servletContext.setContextPath("/api");
        servletContext.addServlet(new ServletHolder(new HealthServlet()), "/health");
        servletContext.addServlet(new ServletHolder(new SessionDetailsServlet()), "/session/details");
        servletContext.addServlet(new ServletHolder(new RestartRecorderServlet()), "/session/restart");
        servletContext.addServlet(new ServletHolder(new ClientMethodHandleServlet()), "/session/execute");
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
}
