package com.dinesh.deloitte.code.scheduler;

import com.dinesh.deloitte.code.exception.ActivityHandlerException;
import com.dinesh.deloitte.code.model.Activity;
import com.dinesh.deloitte.code.model.Team;
import com.dinesh.deloitte.code.util.ActivityFileParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by uuchey on 23/05/2016.
 */
public class ActivityScheduler {

    List<Activity> activities;
    List<Team> teamList = new ArrayList<>();

    public List<Team> schedule(int teams, String fileLocation) throws ActivityHandlerException {
        try {
            activities = new ActivityFileParser(fileLocation).parse();
        } catch (IOException e) {
           throw  new ActivityHandlerException("Unable to parse input activity file: "+fileLocation, e);
        }
        IntStream.range(0,teams).forEach(n->teamList.add(new Team("Team "+(n+1))));
        scheduleMorningActivitiesToTeams();
        scheduleNoonActivitiesToTeams();
        return  teamList;
    }


    protected void scheduleMorningActivitiesToTeams(){
        for(Team team : teamList) {
            Team.ActivityDuration activityDuration = team.durationNeeded();
            Set<Activity> selectedActivities = new HashSet<>();

            //get activities with that duration
            for (Iterator<Activity> iterator = activities.iterator(); iterator.hasNext();) {
                Activity activity = iterator.next();
                //check that it fits the duration we need
                selectedActivities.add(activity);
                if (activityDurationSum(selectedActivities) <= activityDuration.getMaxMins()) {
                    iterator.remove();
                } else {
                    selectedActivities.remove(activity);
                }
                if (activityDurationSum(selectedActivities) > activityDuration.getMinMins()) {
                    break;
                }
            }

            team.addActivities(selectedActivities);
        }
    }

    protected void scheduleNoonActivitiesToTeams(){
        for(Team team : teamList) {
            long remainingTime = team.durationNeeded().getTotalMins() - activityDurationSum(team.getMorningActivities());
            Set<Activity> selectedActivities = new HashSet<>();

            //get activities with that duration
            for (Iterator<Activity> iterator = activities.iterator(); iterator.hasNext();) {
                Activity activity = iterator.next();
                //check that it fits the duration we need
                selectedActivities.add(activity);
                if (activityDurationSum(selectedActivities) <= remainingTime && !team.getMorningActivities().contains(activity)) {
                    iterator.remove();
                } else {
                    selectedActivities.remove(activity);
                }
            }

            team.addActivities(selectedActivities);
        }
    }

    private long activityDurationSum(Set<Activity> activities){
        long sum = 0;
        for(Activity activity : activities){
            sum += activity.getDuration().toMinutes();
        }
        return sum;
    }
}
