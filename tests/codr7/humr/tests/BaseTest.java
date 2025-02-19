package codr7.humr.tests;

import codr7.humr.Context;
import codr7.humr.models.User;

import java.nio.file.Paths;

public class BaseTest {
    public static Context newTestContext() {
        final var cx = new Context("jdbc:h2:" + Paths.get("test").toAbsolutePath(), "test", "test");
        cx.db.migrate(cx.dbContext);

        final var u = new User(cx);
        u.setName("System");
        u.store(cx);

        cx.setUser(u);

        return cx;
    }
}
