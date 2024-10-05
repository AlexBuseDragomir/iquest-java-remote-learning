package com.iquest.java.problem1.main;

import com.iquest.java.problem1.date.DateTimeInfoExtractor;

import java.time.LocalDate;

public class MainLauncher {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1999, 12, 22);
        DateTimeInfoExtractor dateTimeInfoExtractor = new DateTimeInfoExtractor(localDate);
        dateTimeInfoExtractor.printDateTimeInformation();
    }
}
