package com.codegym.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
    public static DateFormat parseDateFormat = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);

    public static Sex parseSex(String sex){
        if (sex.equals("m")){
            return Sex.MALE;
        }else if (sex.equals("f")){
            return Sex.FEMALE;
        } else return null;
    }

    public static Date parseDate(String date){
        try {
            return parseDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
