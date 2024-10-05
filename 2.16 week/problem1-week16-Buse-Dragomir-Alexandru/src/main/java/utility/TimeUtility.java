package utility;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeUtility {

    private static final DateTimeFormatter LOCAL_DATE_FORMATTER =
            DateTimeFormatter.
                    ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER =
            DateTimeFormatter.
                    ofPattern("yyyy-MM-dd HH:mm:ss");

    public boolean isZoneIdStringValid(String zoneIdString) {
        return ZoneId.getAvailableZoneIds().contains(zoneIdString);
    }

    public LocalDateTime convertStringToLocalDateTime(String localDateTimeString) {
        return LocalDateTime.parse(localDateTimeString, LOCAL_DATE_TIME_FORMATTER);
    }

    public LocalDate convertStringToLocalDate(String localDateString) {
        return LocalDate.parse(localDateString, LOCAL_DATE_FORMATTER);
    }

    public LocalDateTime getLocalTimeOfForeignZone(LocalDateTime local, ZoneId zoneId) {
        ZonedDateTime utcZoned = ZonedDateTime.of(local, ZoneId.systemDefault());
        ZonedDateTime foreignZoned = utcZoned.withZoneSameInstant(zoneId);

        return foreignZoned.toLocalDateTime();
    }
}
