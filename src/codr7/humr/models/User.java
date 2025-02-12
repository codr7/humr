package codr7.humr.models;

import codr7.humr.Database;
import codr7.tyred.BaseModel;
import codr7.tyred.Context;
import codr7.tyred.Record;
import codr7.tyred.Table;

public class User extends BaseModel {
    private final Database db;

    public User(final Database db, final Record r) {
        super(r);
        this.db = db;
    }

    public User(final Database db, final Context cx) {
        this(db, new Record());
        record().set(db.userId, db.userIds.nextValue(cx));
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
