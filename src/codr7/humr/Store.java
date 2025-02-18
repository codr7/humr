package codr7.humr;

public class Store {
    public final Context context;
    public final Database db;

    public Store(final Context cx) {
        context = cx;
        db = cx.db;
    }
}
