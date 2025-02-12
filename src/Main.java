import codr7.humr.Database;
import codr7.humr.models.User;
import codr7.tyred.Context;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        final var db = new Database();
        final var cx = new Context("jdbc:h2:" + Paths.get("humr").toAbsolutePath(), "humr", "humr");
        db.migrate(cx);

        final var u = new User(db, cx);
        u.store(cx);

        cx.rollback();
    }
}