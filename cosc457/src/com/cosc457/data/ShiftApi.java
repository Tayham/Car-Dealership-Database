package com.cosc457.data;

import com.cosc457.models.Schedule;
import com.cosc457.models.Shift;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by donnie on 12/11/16.
 */
public class ShiftApi {
    private static Database database = Database.getInstance();
    public static void saveShift(Shift s){
        String values = " '"+s.getEmployeeID() + "', '" + s.getScheduleID() + "', '"+s.getWeekDay()+"','"+s.getStartTime()+"','"+s.getEndTime()+"'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO SHIFT(employeeID, scheduleID, workDay, startTime, endTime) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static ArrayList<Shift> getShiftsForSchedule(Schedule s){
        ArrayList<Shift> shifts = new ArrayList<Shift>();
        String query = "SELECT * FROM SHIFT WHERE scheduleId = " + s.getID() + " ORDER BY workDay, startTime";
        try {
            database.retrieve(query, Shift.class);
            for(Object o : database.retrieve(query, Shift.class)){
                shifts.add((Shift)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shifts;
    }
}
