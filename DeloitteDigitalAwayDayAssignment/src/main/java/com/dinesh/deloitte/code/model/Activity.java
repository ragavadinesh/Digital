package com.dinesh.deloitte.code.model;

import java.time.Duration;
import java.util.Objects;

/**
 * Created by uuchey on 23/05/2016.
 */
public class Activity {

    private static final String SPRINT = "sprint";
    private String name;
    private Duration duration;

    public Activity(String name, Duration Duration){
        this.name = name;
        this.duration = Duration;
    }
    public Duration getDuration() {

        return duration;
    }

    public void setDuration(Duration Duration) {
        this.duration = Duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(name, activity.name) &&
                Objects.equals(duration, activity.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    public String getFriendlyTime(){
        if (this.getDuration().equals(Duration.ofMinutes(15))){
            return SPRINT;
        }else{
            return this.getDuration().toMinutes()+" mins";
        }
    }

    /*@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Activity{");
        sb.append("name='").append(name).append('\'');
        sb.append(", duration=").append(duration.toMinutes() +" Mins");
        sb.append('}');
        return sb.toString();
    }*/
}
