package event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public interface Event {

    boolean isValid();

    boolean isEventInInterval(LocalDateTime start, LocalDateTime end);

    boolean isEventOnDateForZoneId(LocalDate date, ZoneId zoneId);
}
