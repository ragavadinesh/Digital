package com.dinesh.deloitte.code.exception;

/**
 * Created by uuchey on 23/05/2016.
 */
public class ActivityHandlerException extends Exception {

    public ActivityHandlerException(String msg){
        super(msg);
    }

    public ActivityHandlerException(String msg, Throwable t){
        super(msg, t);
    }

}
