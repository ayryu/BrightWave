package com.example.alexr.brightwave;

import java.util.Date;

public class Goal {
    //var
    private String disc = "";
    private String mainGoal;
    private String subGoal;
    private Date end;
    private boolean complete = false;

    //constructor for Goal with subgoal underneath found in the MainActivity
    public Goal (String mainGoals, String subGoals) {
        mainGoal = mainGoals;
        subGoal = subGoals;
    }

    //constructor for subgoal with description underneath found in WeeklyGoal Activity
    public Goal(String gdisc, Date gend){
        disc = gdisc;
        end = gend;
    }

    public String getMainGoal() { return mainGoal;}
    public String getSubGoal() { return subGoal;}

    //discription setter and getter values
    public String getdisc(){
        return disc;
    }
    public void setdisc(String newdisc){
        disc = newdisc;
    }

    //deadline setter and getter values
    public Date getend(){
        return end;
    }
    public void setend(Date newend){
        end = newend;
    }
}
