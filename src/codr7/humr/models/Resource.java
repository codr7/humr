package codr7.humr.models;

import codr7.humr.Database;
import codr7.humr.Model;
import codr7.humr.Context;
import codr7.tyred.Record;
import codr7.tyred.Table;

import java.time.OffsetDateTime;

public class Resource extends Model {
    public Resource(final Context cx) {
        super(cx.db, new Record());

        record()
                .set(db.resourceId, db.resourceIds.nextValue(cx.dbContext))
                .set(db.resourceCreatedAt, OffsetDateTime.now())
                .set(db.resourceCreatedBy, cx.currentUser().record());
    }

    public Resource(final Database db, final Record r) {
        super(db, r);
    }

    public OffsetDateTime createdAt() {
        return record().get(db.resourceCreatedAt);
    }

    public User createdBy() {
        return new User(db, record().get(db.resourceCreatedBy));
    }

    public long id() {
        return record().get(db.resourceId);
    }

    public String name() {
        return record().get(db.resourceName);
    }

    public Resource setName(final String v) {
        record().set(db.resourceName, v);
        return this;
    }

    @Override
    public Table[] tables() {
        return new Table[]{db.resources};
    }
}
