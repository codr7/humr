package codr7.humr.ui;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;

import java.io.IOException;

public class Application {
    public static class HelloServlet extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            response.setContentType("text/html;");
            response.getWriter().println("<h1>Hello world!</h1>");
        }
    }

    public void start(final int port) throws Exception {
        final var server = new Server(port);
        final var servlets = new ServletContextHandler();
        //servlets.setContextPath("/humr");
        servlets.addServlet(HelloServlet.class, "/hello");
        final var resources = new ResourceHandler();
        final var handlers = new ContextHandlerCollection();
        handlers.setHandlers(servlets, resources);
        server.setHandler(handlers);
        server.start();
        server.join();
    }
}