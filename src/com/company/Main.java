package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // write your code here

        LocalDate date = LocalDate.of(2021, 3, 4);
        DayOfWeek day = date.getDayOfWeek();
        String dayName = day.getDisplayName(TextStyle.FULL, Locale.getDefault());
        System.out.println(dayName);


    }
}
