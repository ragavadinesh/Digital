package com.dinesh.deloitte.code.util;

import com.dinesh.deloitte.code.model.Activity;

/**
 * Created by uuchey on 25/05/2016.
 */
public class ActivityConsolePrinter {

    public static void print(String time, Activity activity){
        System.out.println(time +" "+activity.getName() +" "+ activity.getFriendlyTime());
    }
}
