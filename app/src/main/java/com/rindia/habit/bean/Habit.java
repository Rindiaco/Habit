package com.rindia.habit.bean;

/**
 * Created by 汪磊 on 2018/1/3.
 */

public class Habit {
    private String habitName;
    private String habitId;
    private String habitKeepTime;
    private String habitRemindTime;
    private String habitImageId;
    private int habitKeepDay;

    public int getHabitKeepDay() {
        return habitKeepDay;
    }

    public void setHabitKeepDay(int habitKeepDay) {
        this.habitKeepDay = habitKeepDay;
    }

    public String getHabitRemindTime() {
        return habitRemindTime;
    }

    public void setHabitRemindTime(String habitRemindTime) {
        this.habitRemindTime = habitRemindTime;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitId() {
        return habitId;
    }

    public void setHabitId(String habitId) {
        this.habitId = habitId;
    }

    public String getHabitKeepTime() {
        return habitKeepTime;
    }

    public void setHabitKeepTime(String habitKeepTime) {
        this.habitKeepTime = habitKeepTime;
    }

    public String getHabitImageId() {
        return habitImageId;
    }

    public void setHabitImageId(String habitImageId) {
        this.habitImageId = habitImageId;
    }
}
