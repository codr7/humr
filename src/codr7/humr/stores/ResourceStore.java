package codr7.humr.stores;

import codr7.humr.Context;
import codr7.humr.Store;
import codr7.humr.models.Resource;
import codr7.tyred.Column;
import codr7.tyred.Query;
import codr7.tyred.Record;

import java.time.LocalDateTime;

public class ResourceStore extends Store {
    public ResourceStore(final Context cx) {
        super(cx);
    }

    public Record[] getCalendar(final Resource rc, final LocalDateTime start, final LocalDateTime end) {
        return new Query(db.calendars)
                .select(db.calendars.columns().map(c -> (Column)c))
                .where(db.calendarResource.foreignCondition(rc.record()))
                .where(db.calendarStart.LT(end))
                .where(db.calendarEnd.GT(start))
                .findAll(context.dbContext);
    }
}
