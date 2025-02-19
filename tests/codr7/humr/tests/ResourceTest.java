package codr7.humr.tests;

import codr7.humr.Database;
import codr7.humr.models.Calendar;
import codr7.humr.models.Resource;
import codr7.humr.stores.ResourceStore;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import codr7.tyred.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceTest extends BaseTest {

    @Test
    public void create() {
        final var db = new Database();
        final var cx = newTestContext();

        final var rc = new Resource(cx);
        rc.setName("Employees");
        rc.setQuantity(1);
        rc.store(cx);

        final var rcs = new ResourceStore(cx);
        final var cs = rcs.getCalendar(rc, LocalDateTime.MIN, LocalDateTime.MAX).toArray(Record[]::new);
        assertEquals(1, cs.length);

        final var c = cs[0];
        assertEquals(1, c.get(db.calendarTotal));
        assertEquals(0, c.get(db.calendarUsed));
        assertEquals(Calendar.START, c.get(db.calendarStart));
        assertEquals(Calendar.END, c.get(db.calendarEnd));
    }
}