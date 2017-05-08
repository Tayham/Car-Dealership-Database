package com.cosc457.data;

import com.cosc457.models.Schedule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by donnie on 11/30/16.
 */
public class ScheduleApi {

    private static Database database = Database.getInstance();

    public static void saveSchedule(Schedule s){
        String values = "'"+s.getStartDate() + "', '" + s.getEndDate() + "' ";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO SCHEDULE(startDate, endDate) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public static Schedule getSchedule(Date startDate, Date endDate){
        String query = "SELECT * FROM SCHEDULE WHERE startDate='"+new java.sql.Date(startDate.getTime()) + "' AND endDate = '" + new java.sql.Date(endDate.getTime()) + "' ORDER BY ID DESC";
        System.out.println(query);
        Schedule s = null;
        try {
           for(Object o : database.retrieve(query, Schedule.class)){
               return (Schedule)o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static ArrayList<Schedule> getAllSchedules(){
        ArrayList<Schedule> result = new ArrayList<Schedule>();
        String query = "SELECT * FROM SCHEDULE";
        try {
            for(Object o : database.retrieve(query, Schedule.class)){
                result.add((Schedule)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


}
