package com.dinesh.deloitte.code.model;

import static com.dinesh.deloitte.code.model.Team.ActivityDuration.AFTERNOON;
import static com.dinesh.deloitte.code.model.Team.ActivityDuration.MORNING;
import static com.dinesh.deloitte.code.model.Team.ActivityDuration.NONE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by uuchey on 25/05/2016.
 */
public class Team {

    Set<Activity> morningActivities = new HashSet<>();
    Set<Activity> afternoonActivities = new HashSet<>();
    ActivityDuration duration = MORNING;
    private String name;

    public Team (String name){
       this.name = name;
    }

    public enum ActivityDuration{
        MORNING(150,    180),
        AFTERNOON(240,  240),
        NONE(0, 0);
        private int minMins;
        private int maxMins;
        private int totalMins = 420;
        ActivityDuration(int minMins, int maxMins){
            this.minMins = minMins;
            this.maxMins = maxMins;
        }

        public int getMinMins() {
            return minMins;
        }

        public int getMaxMins() {
            return maxMins;
        }

        public ActivityDuration getNextDuration(){
            switch (this){
                case MORNING:
                    return AFTERNOON;
                case AFTERNOON:
                    return  NONE;
                case NONE:
                    return NONE;
            }
            return  NONE;
        }

        public Set<Activity> getActivities(Team team){
            switch (this){
                case MORNING:
                    return team.morningActivities;
                case AFTERNOON:
                    return  team.afternoonActivities;
            }
            return  new HashSet<>();
        }


        public int getTotalMins() {
            return totalMins;
        }
    }

    public void addActivities(Set<Activity> activities) {
        this.duration.getActivities(this).addAll( activities);
        this.duration = this.duration.getNextDuration();
    }

    public ActivityDuration durationNeeded(){
        return duration;
    }

    public Set<Activity> getMorningActivities() {
        return morningActivities;
    }

    public Set<Activity> getAfternoonActivities() {
        return afternoonActivities;
    }

    public String getName() {
        return name;
    }

}
