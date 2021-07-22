package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static LocalDate strToLocalDate (String str){
        String patternOl = "yyyy-MM-dd";
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(patternOl));
    }
}
