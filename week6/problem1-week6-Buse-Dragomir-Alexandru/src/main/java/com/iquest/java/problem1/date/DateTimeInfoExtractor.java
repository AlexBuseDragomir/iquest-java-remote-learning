package com.iquest.java.problem1.date;

import com.iquest.java.problem1.enums.DayOfWeekEnum;
import com.iquest.java.problem1.enums.MonthOfYearEnum;

import java.time.LocalDate;

public class DateTimeInfoExtractor {

    private LocalDate dateToExtractFrom;

    public DateTimeInfoExtractor(LocalDate dateToExtractFrom) {
        this.dateToExtractFrom = dateToExtractFrom;
    }

    public void printDateTimeInformation() {
        System.out.println("------ LOCAL DATE TIME INFOS -------");
        System.out.println("The year is: " + this.getYear());
        System.out.println("The month is: " + this.getMonthOfYear());
        System.out.println("The day is: " + this.getDayOfWeek());
    }

    public SimpleDate populateDateObjectFromLocalDate() {
        return new SimpleDate(this.getDayOfWeek(), this.getMonthOfYear(), this.getYear());
    }

    private DayOfWeekEnum getDayOfWeek() {
        int integerDayValue = this.dateToExtractFrom.getDayOfWeek().getValue();
        return DayOfWeekEnum.values()[integerDayValue - 1];
    }

    private MonthOfYearEnum getMonthOfYear() {
        int integerMonthValue = this.dateToExtractFrom.getMonthValue();
        return MonthOfYearEnum.values()[integerMonthValue - 1];
    }

    private int getYear() {
        return this.dateToExtractFrom.getYear();
    }
}
