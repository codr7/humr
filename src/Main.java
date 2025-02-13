import codr7.humr.models.Resource;
import codr7.humr.models.User;
import java.nio.file.Paths;
import codr7.humr.Context;

public class Main {
    public static void main(String[] args) throws Exception {
        final var cx = new Context("jdbc:h2:" + Paths.get("humr").toAbsolutePath(), "humr", "humr");
        cx.db.migrate(cx.dbContext);

        final var u = new User(cx);
        u.setName("System");
        u.store(cx);

        cx.setUser(u);

        final var r = new Resource(cx);
        r.setName("Employees");
        r.store(cx);

        cx.dbContext.rollback();
    }
}