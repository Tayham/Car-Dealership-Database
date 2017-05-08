package com.cosc457.models;

import java.util.Date;

/**
 * Created by donnie on 11/30/16.
 */
public class Schedule {

    private int ID;
    private Date startDate;
    private Date endDate;

    public Schedule(int ID, Date startDate, Date endDate) {
        this.ID = ID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Schedule(Date startDate, Date endDate) {

        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Schedule for: " + startDate + " - " + endDate;
    }
}
