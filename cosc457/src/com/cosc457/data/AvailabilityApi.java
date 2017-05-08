package com.cosc457.data;

import com.cosc457.models.Availability;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by donnie on 11/30/16.
 */
public class AvailabilityApi {
    private static Database database = Database.getInstance();

    public static void saveAvailability(Availability a){
        String values = "'"+a.getEmployeeID() + "', '" + a.getWeekDay() + "','" + a.getStartTime().toString()+"','" + a.getEndTime()+"'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static ArrayList<Availability> getAllAvailabilities(){
        String query = "SELECT * FROM EMPLOYEE_AVAILABILITY";
        ArrayList<Availability> result = new ArrayList<Availability>();
        try {
            for(Object o :  database.retrieve(query, Availability.class)){
                result.add((Availability)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
