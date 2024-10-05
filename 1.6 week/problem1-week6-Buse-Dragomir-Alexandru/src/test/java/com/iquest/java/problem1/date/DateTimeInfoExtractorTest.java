package com.iquest.java.problem1.date;

import com.iquest.java.problem1.enums.DayOfWeekEnum;
import com.iquest.java.problem1.enums.MonthOfYearEnum;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DateTimeInfoExtractorTest {

    private SimpleDate simpleDate;

    @Before
    public void setUp() {
        LocalDate localDate = LocalDate.of(2019, 3, 5);
        DateTimeInfoExtractor dateTimeInfoExtractor = new DateTimeInfoExtractor(localDate);
        this.simpleDate = dateTimeInfoExtractor.populateDateObjectFromLocalDate();
    }

    @Test
    public void testYear() {
        //WHEN
        int year = simpleDate.getYear();
        //THEN
        assertThat(year, is(2019));
    }

    @Test
    public void testMonth() {
        //WHEN
        MonthOfYearEnum month = simpleDate.getMonth();
        //THEN
        assertThat(month, is(MonthOfYearEnum.MARCH));
    }

    @Test
    public void testDay() {
        //WHEN
        DayOfWeekEnum day = simpleDate.getDay();
        //THEN
        assertThat(day, is(DayOfWeekEnum.TUESDAY));
    }
}