package codr7.humr.models;

import codr7.humr.Model;
import codr7.humr.Context;
import codr7.tyred.Record;
import codr7.tyred.Table;

public class Resource extends Model {
    public Resource(final Context cx) {
        super(cx.db, new Record());
        record().set(db.resourceId, db.resourceIds.nextValue(cx.dbContext));
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
