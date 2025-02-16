package codr7.humr;

import codr7.tyred.BaseModel;
import codr7.tyred.Record;

public abstract class Model extends BaseModel {
    public final Database db;

    public Model(final Database db, final Record r) {
        super(r);
        this.db = db;
    }

    public final Model store(final Context cx) {
        super.store(cx.dbContext);
        return this;
    }
}
