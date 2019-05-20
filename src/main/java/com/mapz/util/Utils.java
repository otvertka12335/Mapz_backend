package com.mapz.util;

import java.time.LocalDate;

public class Utils {
    public static LocalDate getDateFromString(String date) {
        String[] splittedString = date.split("-");
        int year = Integer.valueOf(splittedString[0]);
        int month = Integer.valueOf(splittedString[1]);
        int day = Integer.valueOf(splittedString[2]);

        return LocalDate.of(year, month, day);
    }
}