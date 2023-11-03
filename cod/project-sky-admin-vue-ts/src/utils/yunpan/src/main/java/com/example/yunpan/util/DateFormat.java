package com.example.yunpan.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {
    public static String dateFormat(LocalDateTime date, String pattarn){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattarn);
        return date.format(df);
    }
}
