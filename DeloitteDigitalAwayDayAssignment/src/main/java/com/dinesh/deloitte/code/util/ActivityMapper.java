package com.dinesh.deloitte.code.util;

import java.time.Duration;

import com.dinesh.deloitte.code.model.Activity;

/**
 * Created by uuchey on 23/05/2016.
 */
public class ActivityMapper {

    public static Activity map(String activityRow){
        Activity activity = null;
        if (activityRow !=null){
            String[] tokens = activityRow.split(" ");
            String durationString = tokens[tokens.length - 1];
            String name = activityRow.replace(durationString, "");
            Duration duration = DurationConverter.convert(durationString);
            activity =  new Activity(name.trim(), duration);
        }
        return activity;
    }
}
