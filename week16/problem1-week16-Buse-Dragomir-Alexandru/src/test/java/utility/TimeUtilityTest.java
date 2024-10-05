package utility;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TimeUtilityTest {

    private TimeUtility timeUtility;

    @Before
    public void setUp() {
        this.timeUtility = new TimeUtility();
    }

    @Test
    public void testIsZoneIdStringValidTrue() {
        String zoneString = "Atlantic/Reykjavik";
        boolean result = this.timeUtility.isZoneIdStringValid(zoneString);
        assertThat(result, is(true));
    }

    @Test
    public void testIsZoneIdStringValidFalse() {
        String zoneString = "This/IsNotGood";
        boolean result = this.timeUtility.isZoneIdStringValid(zoneString);
        assertThat(result, is(false));
    }

    @Test
    public void testConvertStringToLocalDateTimeSuccess1() {
        String dateTimeString = "2019-05-29 12:23:40";
        LocalDateTime localDateTime =
                this.timeUtility.convertStringToLocalDateTime(dateTimeString);
        assertThat(localDateTime.getYear(), is(2019));
        assertThat(localDateTime.getMonthValue(), is(5));
        assertThat(localDateTime.getDayOfMonth(), is(29));
        assertThat(localDateTime.getHour(), is(12));
        assertThat(localDateTime.getMinute(), is(23));
        assertThat(localDateTime.getSecond(), is(40));
    }

    @Test
    public void testConvertStringToLocalDateTimeSuccess2() {
        String dateTimeString = "1970-01-01 00:00:00";
        LocalDateTime localDateTime =
                this.timeUtility.convertStringToLocalDateTime(dateTimeString);

        assertThat(localDateTime.getYear(), is(1970));
        assertThat(localDateTime.getMonthValue(), is(1));
        assertThat(localDateTime.getDayOfMonth(), is(1));
        assertThat(localDateTime.getHour(), is(0));
        assertThat(localDateTime.getMinute(), is(0));
        assertThat(localDateTime.getSecond(), is(0));
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateTimeFail1() {
        String dateTimeString = "2019-5-29 12:23:40";
        this.timeUtility.convertStringToLocalDateTime(dateTimeString);
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateTimeFail2() {
        String dateTimeString = "2019-05-f9 12:23:40";
        this.timeUtility.convertStringToLocalDateTime(dateTimeString);
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateTimeFail3() {
        String dateTimeString = "2019-05-39:12:23:40";
        this.timeUtility.convertStringToLocalDateTime(dateTimeString);
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateTimeFail4() {
        String dateTimeString = "2019-05-39 12/23/40";
        this.timeUtility.convertStringToLocalDateTime(dateTimeString);
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateTimeFail5() {
        String dateTimeString = "2019-05-39";
        this.timeUtility.convertStringToLocalDateTime(dateTimeString);
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateTimeFail6() {
        String dateTimeString = "2019 12:23:40";
        this.timeUtility.convertStringToLocalDateTime(dateTimeString);
    }

    @Test
    public void testConvertStringToLocalDateSuccess1() {
        String dateString = "2019-05-31";
        LocalDate localDateTime =
                this.timeUtility.convertStringToLocalDate(dateString);

        assertThat(localDateTime.getYear(), is(2019));
        assertThat(localDateTime.getMonthValue(), is(5));
        assertThat(localDateTime.getDayOfMonth(), is(31));
    }

    @Test
    public void testConvertStringToLocalDateSuccess2() {
        String dateString = "2019-12-31";
        LocalDate localDateTime =
                this.timeUtility.convertStringToLocalDate(dateString);

        assertThat(localDateTime.getYear(), is(2019));
        assertThat(localDateTime.getMonthValue(), is(12));
        assertThat(localDateTime.getDayOfMonth(), is(31));
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateFail1() {
        String dateString = "2019-11-32";
        this.timeUtility.convertStringToLocalDate(dateString);
    }

    @Test(expected = DateTimeParseException.class)
    public void testConvertStringToLocalDateFail2() {
        String dateString = "2019-11-00";
        this.timeUtility.convertStringToLocalDate(dateString);
    }

    @Test
    public void testGetLocalTimeOfForeignZoneUtfNorfolk() {
        // (UTC+3:00)
        LocalDateTime localDateTime = LocalDateTime.now();
        // (UTC+11:00)
        ZoneId zoneId = ZoneId.of("Pacific/Norfolk");
        LocalDateTime localTimeNorfolk =
                this.timeUtility.getLocalTimeOfForeignZone(localDateTime, zoneId);

        assertThat(localTimeNorfolk.getHour(),
                is(LocalDateTime.now().plus(8, ChronoUnit.HOURS).getHour()));
    }

    @Test
    public void testGetLocalTimeOfForeignZoneUtfNewfoundland() {
        // (UTC+3:00)
        LocalDateTime localDateTime = LocalDateTime.now();
        // (UTC-2:30)
        ZoneId zoneId = ZoneId.of("Canada/Newfoundland");
        LocalDateTime localTimeNewfoundland =
                this.timeUtility.getLocalTimeOfForeignZone(localDateTime, zoneId);

        assertThat(localTimeNewfoundland.getHour(),
                is(LocalDateTime.now()
                        .minus(5, ChronoUnit.HOURS)
                        .minus(30, ChronoUnit.MINUTES)
                        .getHour()));
    }

    @Test
    public void testGetLocalTimeOfForeignZoneUtfHawaii() {
        // (UTC+3:00)
        LocalDateTime localDateTime = LocalDateTime.now();
        // (UTC-10:00)
        ZoneId zoneId = ZoneId.of("US/Hawaii");
        LocalDateTime localTimeHawaii =
                this.timeUtility.getLocalTimeOfForeignZone(localDateTime, zoneId);

        assertThat(localTimeHawaii.getHour(),
                is(LocalDateTime.now().minus(13, ChronoUnit.HOURS).getHour()));
    }
}