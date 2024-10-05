package com.iquest.java.problem1.date;

import com.iquest.java.problem1.enums.DayOfWeekEnum;
import com.iquest.java.problem1.enums.MonthOfYearEnum;

public class SimpleDate {

    private DayOfWeekEnum day;
    private MonthOfYearEnum month;
    private int year;
    
    public SimpleDate(DayOfWeekEnum day, MonthOfYearEnum month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DayOfWeekEnum getDay() {
        return this.day;
    }

    public MonthOfYearEnum getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
}
