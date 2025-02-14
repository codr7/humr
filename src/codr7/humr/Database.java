package codr7.humr;

import codr7.tyred.*;
import codr7.tyred.columns.DateTimeColumn;
import codr7.tyred.columns.LongColumn;
import codr7.tyred.columns.StringColumn;

import java.util.stream.Stream;

public class Database extends Schema {
    public final Sequence userIds = add(new Sequence("userIds", 1));

    public final Table users = add(new Table("users"));
    public final LongColumn userId = new LongColumn(users, "id", Option.PrimaryKey);
    public final StringColumn userName = new StringColumn(users, "name", 100);

    public final Index userNameIndex = new Index(users, "userName", false, Stream.of(userName));

    public final Sequence resourceIds = add(new Sequence("resourceIds", 1));

    public final Table resources = add(new Table("resources"));
    public final LongColumn resourceId = new LongColumn(resources, "id", Option.PrimaryKey);
    public final StringColumn resourceName = new StringColumn(resources, "name", 100);
    public final DateTimeColumn resourceCreatedAt = new DateTimeColumn(resources, "createdAt");
    public final ForeignKey resourceCreatedBy = new ForeignKey(resources, "resourceCreatedBy", users);
    public final Index resourceNameIndex = new Index(resources, "resourceName", false, Stream.of(resourceName));
}
