package handler;

import event.Event;
import utility.TimeUtility;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SimpleEventHandler implements EventHandler {

    private List<Event> eventList;
    private TimeUtility timeUtility;

    private static final Logger LOGGER =
            Logger.getLogger(SimpleEventHandler.class.getName());

    public SimpleEventHandler() {
        this.eventList = new ArrayList<>();
        this.timeUtility = new TimeUtility();
    }

    @Override
    public void addEvent(Event event) {
        if (event.isValid()) {
            this.eventList.add(event);
        } else {
            LOGGER.warning("Unexpected event format");
            throw new IllegalArgumentException("Event with incorrect format");
        }
    }

    @Override
    public void listAllEvents() {
        for (Event event: this.eventList) {
            System.out.println(event);
            System.out.println();
        }
    }

    @Override
    public void listEventsForNextWeekend() {
        LocalDateTime currentDayMidnight =
                LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);

        LocalDateTime nextSaturdayHourZero =
                currentDayMidnight.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

        LocalDateTime nextMondayHourZero =
                currentDayMidnight.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDateTime oneSecondBeforeMonday =
                nextMondayHourZero.minus(1, ChronoUnit.SECONDS);

        for (Event event: this.eventList) {
            if (event.isEventInInterval(nextSaturdayHourZero, oneSecondBeforeMonday)) {
                System.out.println(event);
                System.out.println();
            }
        }
    }

    @Override
    public void listEventsForTimeZone(String date, String zoneIdString) {
        if (this.timeUtility.isZoneIdStringValid(zoneIdString)) {
            ZoneId zoneId = ZoneId.of(zoneIdString);
            LocalDate localDate = this.timeUtility.convertStringToLocalDate(date);

            for (Event event: this.eventList) {
                if(event.isEventOnDateForZoneId(localDate, zoneId)) {
                    System.out.println(event);
                    System.out.println();
                }
            }
        } else {
            LOGGER.warning("Zone id string is invalid");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void listEventsInInterval(String startTime, String endTime) {
        LocalDateTime startDateTime =
                this.timeUtility.convertStringToLocalDateTime(startTime);
        LocalDateTime endDateTime =
                this.timeUtility.convertStringToLocalDateTime(endTime);

        if (startDateTime.isAfter(endDateTime)) {
            LOGGER.warning("The start time is after the end time!");
        } else {
            for (Event event: this.eventList) {
                if (event.isEventInInterval(startDateTime, endDateTime)) {
                    System.out.println(event);
                }
            }
        }
    }
}
