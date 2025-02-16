package codr7.humr.models;

import codr7.humr.Database;
import codr7.humr.Model;
import codr7.tyred.Record;
import codr7.tyred.Table;

import java.time.LocalDateTime;

public class Calendar extends Model {
    public Calendar(final Resource rc) {
        super(rc.db, new codr7.tyred.Record());

        record()
                .set(db.calendarResource, rc.record())
                .set(db.calendarStart, LocalDateTime.MIN)
                .set(db.calendarEnd, LocalDateTime.MAX)
                .set(db.calendarTotal, 0)
                .set(db.calendarUsed, 0);
    }

    public Calendar(final Database db, final Record r) {
        super(db, r);
    }

    public LocalDateTime end() {
        return record().get(db.calendarEnd);
    }

    public Resource resource() {
        return new Resource(db, record().get(db.calendarResource));
    }

    public LocalDateTime start() {
        return record().get(db.calendarStart);
    }

    public int total() {
        return record().get(db.calendarTotal);
    }

    public int used() {
        return record().get(db.calendarUsed);
    }

    public Calendar adjust(final int q) {
        record().set(db.calendarTotal, total() - q)
                .set(db.calendarUsed, used() + q);

        return this;
    }

    @Override
    public Table[] tables() {
        return new Table[]{db.calendars};
    }
}
