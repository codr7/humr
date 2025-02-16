package codr7.humr.models;

import codr7.humr.Database;
import codr7.humr.Model;
import codr7.tyred.Record;
import codr7.tyred.Table;
import codr7.humr.Context;

public class User extends Model {
    public User(final Context cx) {
        super(cx.db, new Record());
    }

    public User(final Database db, final Record r) {
        super(db, r);
    }

    public String name() {
        return record().get(db.userName);
    }

    public User setName(final String v) {
        record().set(db.userName, v);
        return this;
    }

    @Override
    public Table[] tables() {
        return new Table[]{db.users};
    }
}
