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

import excelium.model.project.Project;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.net.UrlChecker;
import org.seleniumhq.jetty9.server.Connector;
import org.seleniumhq.jetty9.server.Server;
import org.seleniumhq.jetty9.server.ServerConnector;
import org.seleniumhq.jetty9.server.handler.ContextHandler;
import org.seleniumhq.jetty9.server.handler.HandlerList;
import org.seleniumhq.jetty9.server.handler.ResourceHandler;
import org.seleniumhq.jetty9.util.resource.Resource;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class FileServer {

    private static FileServer instance;

    private Project project;
    private Server server;
    private boolean running;
    private String serverUrl;

    private FileServer(Project project) {
        this.project = project;
    }

    public static FileServer createInstance(Project project) {
        instance = new FileServer(project);
        return instance;
    }

    public static FileServer getInstance() {
        return instance;
    }

    public void start() {
        if (!isRunning()) {
            int port = PortProber.findFreePort();

            try {
                startServer(port);

                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("google.com", 80));
                serverUrl = "http://" + socket.getLocalAddress() + ":" + port;

                URL status = new URL("http://localhost:" + port);
                new UrlChecker().waitUntilAvailable(60, TimeUnit.SECONDS, status);

                System.out.println("Project files served at " + serverUrl);

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
        resourceHandler.setBaseResource(Resource.newResource(project.getBasePath().toAbsolutePath().toFile().getCanonicalFile()));
        resourceHandler.setDirectoriesListed(true);
        context.setHandler(resourceHandler);

        handlers.addHandler(context);

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
        Project project = new Project();
        project.setBasePath(Paths.get("."));
        FileServer server = new FileServer(project);
        server.start();
    }
}
