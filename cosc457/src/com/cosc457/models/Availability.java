package com.cosc457.models;

import com.cosc457.data.SalesPeopleApi;

import java.sql.Time;

/**
 * Created by donnie on 11/30/16.
 */
public class Availability {
    private int ID;
    private int employeeID;
    private int weekDay;
    private Time startTime;
    private Time endTime;

    public Availability(int employeeID, int weekDay, Time startTime, Time endTime) {
        this.employeeID = employeeID;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Availability(int ID, int employeeID, int weekDay, Time startTime, Time endTime) {

        this.ID = ID;
        this.employeeID = employeeID;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }



    public SalesPeople retrieveEmployee(){
        return SalesPeopleApi.getById(employeeID);
    }


    @Override
    public String toString(){
        SalesPeople e = retrieveEmployee();
        return e.getFirstName() + " " + e.getLastName(); //update more
    }


}
