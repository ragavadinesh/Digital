package com.dinesh.deloitte.code.util;

import java.time.Duration;
import java.time.Period;

/**
 * Created by uuchey on 23/05/2016.
 */
public final class DurationConverter {

    private static final String MINS = "min";
    private static final String SPRINT = "sprint";

    public static Duration convert(String string){
        Duration duration = null;
        if (string ==null){
            duration = Duration.ZERO;
        }else if(string.equals(SPRINT)){
            duration = Duration.ofMinutes(15);
        }else if(string.endsWith(MINS)){
            duration = Duration.ofMinutes(Integer.valueOf(string.substring(0,string.indexOf(MINS))));
        }
        return duration;
    }
}
