import codr7.humr.models.Resource;
import codr7.humr.models.User;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

import codr7.humr.Context;
import codr7.humr.stores.ResourceStore;

public class Main {
    public static void main(String[] args) throws Exception {
        final var cx = new Context("jdbc:h2:" + Paths.get("humr").toAbsolutePath(), "humr", "humr");
        cx.db.migrate(cx.dbContext);

        final var u = new User(cx);
        u.setName("System");
        u.store(cx);

        cx.setUser(u);
        cx.dbContext.rollback();
    }
}