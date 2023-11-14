package com.portnov.env_sky.logic.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public static String getDateNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS"));
    }
}
