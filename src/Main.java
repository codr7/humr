import codr7.humr.Database;
import codr7.humr.models.User;
import codr7.tyred.Context;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static class HelloServlet extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            response.setContentType("text/html;");
            response.getWriter().println("<h1>Hello world!</h1>");
        }
    }

    public static void main(String[] args) throws Exception {
        final var db = new Database();
        final var cx = new Context("jdbc:h2:" + Paths.get("humr").toAbsolutePath(), "humr", "humr");
        db.migrate(cx);

        final var u = new User(db, cx);
        u.store(cx);

        cx.rollback();

        final var server = new Server(8080);
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