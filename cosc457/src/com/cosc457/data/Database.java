package com.cosc457.data;

import com.cosc457.models.Availability;
import com.cosc457.models.SalesPeople;
import com.cosc457.models.Schedule;
import com.cosc457.models.Shift;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static Database INSTANCE;
    private Connection connection;

    private Database(){

    }

    public static Database getInstance(){
       if(INSTANCE == null){
           INSTANCE = new Database();
       }
        return INSTANCE;
    }

    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3360/?user=thamil10", "thamil10", "Cosc*2jbb");
            connection.setSchema("thamil10db");
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void initializeDatabase() throws SQLException {
        String check = "SHOW TABLES LIKE 'EMPLOYEE';";
        String employeeCreation = "CREATE TABLE EMPLOYEE(ID INT AUTO_INCREMENT NOT NULL,firstName VARCHAR(45),lastName VARCHAR(45),maxHours VARCHAR(45), isManager BOOLEAN, PRIMARY KEY(ID));";
        String employeeAvailability = "CREATE TABLE EMPLOYEE_AVAILABILITY(ID INT AUTO_INCREMENT NOT NULL,employeeID INT,weekDay INT(1),startTime time,endTime time,PRIMARY KEY(ID),FOREIGN KEY(employeeID) REFERENCES EMPLOYEE(ID));";
        String scheduleCreation = "CREATE TABLE SCHEDULE(ID INT AUTO_INCREMENT NOT NULL,startDate date,endDate date,PRIMARY KEY(ID));";
        String shiftCreation = "CREATE TABLE SHIFT(ID INT AUTO_INCREMENT NOT NULL,employeeID INT,scheduleID INT,workDay INT,startTime time,endTime time,PRIMARY KEY(ID),FOREIGN KEY(employeeID) REFERENCES EMPLOYEE(ID),FOREIGN KEY(scheduleID) REFERENCES SCHEDULE(ID));";
        Statement stmt=connection.createStatement();
        stmt.execute("use thamil10db");
        ResultSet set = stmt.executeQuery(check);
        boolean exists = set.next();
        if(!exists){ //Initialize the db if it doesn't exist
            stmt.execute(employeeCreation);
            stmt.execute(employeeAvailability);
            stmt.execute(scheduleCreation);
            stmt.execute(shiftCreation);
        }
    }

    public void insert(String query) throws SQLException{
        System.out.println(query);
        Statement stmt = connection.createStatement();
        stmt.execute(query);
    }

    public ArrayList<Object> retrieve(String query, Class<?> type) throws SQLException{
        ArrayList<Object> results = new ArrayList<Object>();

        Statement stmt = connection.createStatement();
        ResultSet set = stmt.executeQuery(query);
        while(set.next()){
            if(type.equals(SalesPeople.class)){
                results.add(parseEmployee(set));
            }else if(type.equals(Availability.class)){
                results.add(parseAvailability(set));
            }else if(type.equals(Schedule.class)){
                results.add(parseSchedule(set));
            }else if(type.equals(Shift.class)){
                results.add(parseShift(set));
            }

        }
        return results;
    }


    private SalesPeople parseEmployee(ResultSet set) throws SQLException {

        return new SalesPeople(set.getString("FirstName"), set.getString("LastName"), set.getString("Salary"), set.getString("DateofBirth"),set.getString("HireDate"),set.getString("PhoneNumber"),set.getString("Email"));
//        return new SalesPeople(set.getInt("ID"),set.getString("FirstName"), set.getString("LastName"));
    }
    private Availability parseAvailability(ResultSet set) throws SQLException{
        return new Availability(set.getInt("ID"), set.getInt("employeeID"),set.getInt("weekDay"), set.getTime("startTime"), set.getTime("endTime"));
    }
    private Schedule parseSchedule(ResultSet set) throws SQLException{
        return new Schedule(set.getInt("ID"), set.getDate("startDate"), set.getDate("endDate"));
    }

    private Shift parseShift(ResultSet set) throws SQLException{
        return new Shift(set.getInt("ID"), set.getInt("employeeID"), set.getInt("workDay"), set.getInt("scheduleID"), set.getTime("startTime"), set.getTime("endTime"));
    }
}
