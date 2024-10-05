package event;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleEventTest {

    @Before
    public void setUp() {
        //
    }

    @Test
    public void testIsEventInIntervalTrue1() {
        LocalDateTime startOfEvent =
                LocalDateTime.of(2019, 5, 12, 13, 44, 30);

        LocalDateTime endOfEvent =
                LocalDateTime.of(2019, 5, 30, 0, 44, 30);

        LocalDateTime beforeEvent =
                LocalDateTime.of(2019, 5, 12, 13, 20, 30);

        LocalDateTime afterEvent =
                LocalDateTime.of(2019, 6, 8, 14, 20, 30);

        Event event= new SimpleEvent("test event", startOfEvent, endOfEvent);

        boolean isValid = event.isValid();
        boolean isBetweenDates = event.isEventInInterval(beforeEvent, afterEvent);

        assertThat(isValid, is(true));
        assertThat(isBetweenDates, is(true));
    }

    @Test
    public void testIsEventInIntervalTrue2() {
        LocalDateTime startOfEvent =
                LocalDateTime.of(2019, 12, 30, 13, 44, 30);

        LocalDateTime endOfEvent =
                LocalDateTime.of(2019, 12, 31, 0, 44, 30);

        LocalDateTime beforeEvent =
                LocalDateTime.of(2019, 12, 30, 13, 44, 30);

        LocalDateTime afterEvent =
                LocalDateTime.of(2019, 12, 31, 0, 44, 30);

        Event event= new SimpleEvent("test event", startOfEvent, endOfEvent);

        boolean isValid = event.isValid();
        boolean isBetweenDates = event.isEventInInterval(beforeEvent, afterEvent);

        assertThat(isValid, is(true));
        assertThat(isBetweenDates, is(true));
    }

    @Test
    public void testIsEventInIntervalFalse1() {
        LocalDateTime startOfEvent =
                LocalDateTime.of(2019, 5, 12, 13, 44, 30);

        LocalDateTime endOfEvent =
                LocalDateTime.of(2019, 5, 30, 0, 44, 30);

        LocalDateTime beforeEvent =
                LocalDateTime.of(2019, 5, 12, 13, 20, 30);

        LocalDateTime afterEvent =
                LocalDateTime.of(2019, 5, 8, 14, 20, 30);

        Event event= new SimpleEvent("test event", startOfEvent, endOfEvent);

        boolean isValid = event.isValid();
        boolean isBetweenDates = event.isEventInInterval(beforeEvent, afterEvent);

        assertThat(isValid, is(true));
        assertThat(isBetweenDates, is(false));
    }

    @Test
    public void testIsEventInIntervalFalse2() {
        LocalDateTime startOfEvent =
                LocalDateTime.of(2019, 6, 12, 13, 44, 30);

        LocalDateTime endOfEvent =
                LocalDateTime.of(2019, 5, 30, 0, 44, 30);

        LocalDateTime beforeEvent =
                LocalDateTime.of(2019, 5, 12, 13, 20, 30);

        LocalDateTime afterEvent =
                LocalDateTime.of(2019, 6, 8, 14, 20, 30);

        Event event= new SimpleEvent("test event", startOfEvent, endOfEvent);

        boolean isValid = event.isValid();
        boolean isBetweenDates = event.isEventInInterval(beforeEvent, afterEvent);

        assertThat(isValid, is(true));
        assertThat(isBetweenDates, is(true));
    }

    @Test
    public void testIsEventOnDateForZoneIdTrue() {
        LocalDateTime startOfEvent =
                LocalDateTime.of(2019, 5, 24, 1, 0, 0);

        LocalDateTime endOfEvent =
                LocalDateTime.of(2019, 5, 24, 2, 0, 0);

        Event event= new SimpleEvent("test event", startOfEvent, endOfEvent);

        LocalDate givenDate = LocalDate.of(2019, 5, 23);

        // (UTC-5:00)
        ZoneId zoneId = ZoneId.of("America/Chicago");

        boolean isEventOnDate = event.isEventOnDateForZoneId(givenDate, zoneId);

        assertThat(isEventOnDate, is(true));
    }

    @Test
    public void testIsEventOnDateForZoneIdFalse() {
        LocalDateTime startOfEvent =
                LocalDateTime.of(2019, 5, 24, 1, 0, 0);

        LocalDateTime endOfEvent =
                LocalDateTime.of(2019, 5, 24, 2, 0, 0);

        Event event= new SimpleEvent("test event", startOfEvent, endOfEvent);

        LocalDate givenDate = LocalDate.of(2019, 5, 23);

        // (UTC+11:00)
        ZoneId zoneId = ZoneId.of("Pacific/Norfolk");

        boolean isEventOnDate = event.isEventOnDateForZoneId(givenDate, zoneId);

        assertThat(isEventOnDate, is(false));
    }
}