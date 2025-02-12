package codr7.humr;

import codr7.tyred.*;
import codr7.tyred.columns.LongColumn;
import codr7.tyred.columns.StringColumn;

import java.util.stream.Stream;

public class Database extends Schema {
    public final Sequence userIds = add(new Sequence("userIds", 1));

    public final Table users = add(new Table("users"));
    public final LongColumn userId = new LongColumn(users, "id", Option.PrimaryKey);
    public final StringColumn userName = new StringColumn(users, "String", 100, Option.Nullable);

    public final Index userNameIndex = new Index(users, "userName", false, Stream.of(userName));
}
