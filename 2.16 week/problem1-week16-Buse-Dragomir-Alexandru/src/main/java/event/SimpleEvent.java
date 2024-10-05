package event;

import utility.TimeUtility;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class SimpleEvent implements Event {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String summary;
    private String location;

    private TimeUtility timeUtility;

    private static final Logger LOGGER =
            Logger.getLogger(SimpleEvent.class.getName());

    public SimpleEvent(String summary, LocalDateTime startDate,
                       LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.location = null;
        this.timeUtility = new TimeUtility();
    }

    public SimpleEvent(String summary, LocalDateTime startDate,
                       LocalDateTime endDate, String location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.location = location;
        this.timeUtility = new TimeUtility();
    }

    @Override
    public boolean isValid() {
        return this.summary != null &&
               this.startDate != null &&
               this.endDate != null;
    }

    @Override
    public boolean isEventInInterval(LocalDateTime start, LocalDateTime end) {
        if (this.isValid()) {
            return (this.startDate.isAfter(start) || this.startDate.isEqual(start)) &&
                   (this.endDate.isBefore(end) || this.endDate.isEqual(end));
        } else {
            LOGGER.warning("Event does not have a valid form");
            throw new IllegalArgumentException("Event with incorrect format");
        }
    }

    @Override
    public boolean isEventOnDateForZoneId(LocalDate givenDate, ZoneId zoneId) {
        LocalDateTime foreignStart =
                this.timeUtility.getLocalTimeOfForeignZone(this.startDate, zoneId);
        LocalDateTime foreignEnd =
                this.timeUtility.getLocalTimeOfForeignZone(this.endDate, zoneId);

        return foreignStart.toLocalDate().equals(foreignEnd.toLocalDate()) &&
               foreignStart.getYear() == givenDate.getYear() &&
               foreignStart.getMonthValue() == givenDate.getMonthValue() &&
               foreignStart.getDayOfMonth() == givenDate.getDayOfMonth();
    }

    @Override
    public String toString() {

        String startDateFormatted =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(this.startDate);
        String endDateFormatted =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(this.endDate);

        if (this.location != null) {
            return "Summary: " + this.summary + "\n" +
                   "Start Date Time: " + startDateFormatted + "\n" +
                   "End Date Time: " + endDateFormatted + "\n" +
                   "Location: " + this.location + "\n";
        } else {
            return "Summary: " + this.summary + "\n" +
                   "Start Date Time: " + startDateFormatted + "\n" +
                   "End Date Time: " + endDateFormatted + "\n" +
                   "Location: -";
        }
    }
}
