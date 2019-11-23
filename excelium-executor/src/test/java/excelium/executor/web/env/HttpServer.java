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

import com.github.underscore.U;
import excelium.common.NumberUtil;
import excelium.executor.web.env.servlet.UploadServlet;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.seleniumhq.jetty9.http.HttpMethod;
import org.seleniumhq.jetty9.server.Connector;
import org.seleniumhq.jetty9.server.Request;
import org.seleniumhq.jetty9.server.Server;
import org.seleniumhq.jetty9.server.ServerConnector;
import org.seleniumhq.jetty9.server.handler.ContextHandler;
import org.seleniumhq.jetty9.server.handler.HandlerList;
import org.seleniumhq.jetty9.server.handler.ResourceHandler;
import org.seleniumhq.jetty9.servlet.ServletContextHandler;
import org.seleniumhq.jetty9.servlet.ServletHolder;
import org.seleniumhq.jetty9.util.resource.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A HTTP server.
 *
 * @author PhungDucKien
 * @since 2018.06.29
 */
public class HttpServer {

    /**
     * The port number the server should use.
     */
    private static final Integer PORT = 8989;

    public static void main(String[] args) throws Exception {
        int port = PORT;

        int index = Arrays.asList(args).indexOf("-port");
        if (index > -1) {
            port = Integer.parseInt(args[index + 1]);
        }

        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});

        HandlerList handlers = new HandlerList();

        ContextHandler context = new ContextHandler();
        context.setContextPath("/tests");
        ResourceHandler testHandler = new DynamicResourceHandler();
        testHandler.setBaseResource(Resource.newClassPathResource("/tests"));
        testHandler.setDirectoriesListed(true);
        context.setHandler(testHandler);
        handlers.addHandler(context);

        ServletContextHandler servletContext = new ServletContextHandler();
        servletContext.setContextPath("/common");
        servletContext.addServlet(new ServletHolder(new UploadServlet()), "/upload");
        handlers.addHandler(servletContext);

        server.setHandler(handlers);
        server.start();
    }

    private static class DynamicResourceHandler extends ResourceHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String delay = request.getParameter("delay");
            if (StringUtils.isNotBlank(delay)) {
                try {
                    Thread.sleep(NumberUtil.parseInteger(delay, 0));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            String path = request.getPathInfo();
            if (path.endsWith(".html") && path.contains("/appium")) {
                String throwError = request.getParameter("throwError");

                response.setContentType("text/html");

                Cookie cookie1 = new Cookie("guineacookie1", "i_am_a_cookie_value");
                cookie1.setPath("/");
                response.addCookie(cookie1);

                Cookie cookie2 = new Cookie("guineacookie2", "cookie2");
                cookie2.setPath("/");
                response.addCookie(cookie2);

                Cookie cookie3 = new Cookie("guineacookie3", "cant_access_this");
                cookie3.setDomain(".blargimarg.com");
                cookie3.setPath("/");
                response.addCookie(cookie3);

                Map<Object, Object> params = new HashMap<>();
                params.put("throwError", throwError);
                params.put("serverTime", new Date().getTime() / 1000);
                params.put("userAgent", request.getHeader("user-agent"));
                params.put("comment", HttpMethod.POST.is(request.getMethod()) ? request.getParameter("comments") : "None");

                String template = IOUtils.toString(this.getClass().getResourceAsStream("/tests" + path), "UTF-8");
                String res = U.template(template).apply(params);
                OutputStream out = response.getOutputStream();
                out.write(res.getBytes());
                out.flush();

                baseRequest.setHandled(true);
            } else {
                super.handle(target, baseRequest, request, response);
            }
        }
    }
}
