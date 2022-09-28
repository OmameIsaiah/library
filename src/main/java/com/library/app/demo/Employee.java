package com.library.app.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Employee {
    String name;
    ArrayList<String> leaveDays;

    public boolean mon=false;
    public boolean tue=false;
    public boolean wed=false;
    public boolean thu=false;
    public boolean fri=false;
    public boolean sat=false;
    public boolean sun=false;

    public void setName(String name) {
        this.name = name;
    }

    public void setLeaveDays(ArrayList<String> leaveDays) {
        this.leaveDays = leaveDays;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public Employee(String name, ArrayList<String> leaveDays){
        this.name= name;
        this.leaveDays= leaveDays;
    }

    public String getName(){
        return name;
    }
    public ArrayList<String> getLeaveDays(){
        return leaveDays;
    }
    public ArrayList<String> getAvailableWorkDays(){
        ArrayList<String> availableWorkDays= new ArrayList<>();
        if(leaveDays.size()==0){
            availableWorkDays= new ArrayList<>(Arrays.asList(new String[] {"mon", "tue", "wed", "thu", "fri", "sat", "sun"}));
            setMon(true);
            setTue(true);
            setWed(true);
            setThu(true);
            setFri(true);
            setSat(true);
            setSun(true);
        }else {
            if(!leaveDays.contains("mon")){
                availableWorkDays.add("mon");
                setMon(true);
            }
            if (!leaveDays.contains("tue")){
                availableWorkDays.add("tue");
                setTue(true);
            }
            if (!leaveDays.contains("wed")){
                availableWorkDays.add("wed");
                setWed(true);
            }
            if (!leaveDays.contains("thu")){
                availableWorkDays.add("thu");
                setThu(true);
            }
            if (!leaveDays.contains("fri")){
                availableWorkDays.add("fri");
                setFri(true);
            }
            if (!leaveDays.contains("sat")){
                availableWorkDays.add("sat");
                setSat(true);
            }
            if (!leaveDays.contains("sun")){
                availableWorkDays.add("sun");
                setSun(true);
            }
        }
        return availableWorkDays;
    }
    public int getMaxHours(){
        return 40;
    }
    public int getTotalHours(){
        int totalHours= 0;
        if(leaveDays.size()==0){
            totalHours = 8*7;
        }else {
                if(!leaveDays.contains("mon")){
                    totalHours +=8;
                }
                if (!leaveDays.contains("tue")){
                    totalHours +=8;
                }
                if (!leaveDays.contains("wed")){
                    totalHours +=8;
                }
                if (!leaveDays.contains("thu")){
                    totalHours +=8;
                }
                if (!leaveDays.contains("fri")){
                    totalHours +=8;
                }
                if (!leaveDays.contains("sat")){
                    totalHours +=8;
                }
                if (!leaveDays.contains("sun")){
                    totalHours +=8;
                }
        }
        return totalHours;
    }

}
