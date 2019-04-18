package com.dinesh.deloitte.code.exception;

/**
 * Created by uuchey on 26/05/2016.
 */
public class ActivityParseException extends RuntimeException{


    public ActivityParseException(String msg){
        super(msg);
    }

    public ActivityParseException(String msg, Throwable t){
        super(msg, t);
    }

}
