package com.cosc457.data;

import com.cosc457.models.*;

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
            }else if(type.equals(Car.class)){
                results.add(parseCar(set));
            }else if(type.equals(CarLot.class)){
                results.add(parseCarLot(set));
            }else if(type.equals(Customer.class)){
                results.add(parseCustomer(set));
            }else if(type.equals(Invoice.class)){
            results.add(parseInvoice(set));        }

        }
        return results;
    }


    private SalesPeople parseEmployee(ResultSet set) throws SQLException {

        return new SalesPeople(set.getString("FirstName"), set.getString("LastName"), set.getString("Salary"), set.getString("DateofBirth"),set.getString("HireDate"),set.getString("PhoneNumber"),set.getString("Email"));
//        return new SalesPeople(set.getInt("ID"),set.getString("FirstName"), set.getString("LastName"));
    }
    private Car parseCar(ResultSet set) throws SQLException{
        return new Car(set.getString("VIN"), set.getString("Year"), set.getString("Trim"), set.getString("Model"),set.getString("Make"), set.getString("ExteriorColor"), set.getString("InteriorColor"), set.getString("Mileage"), set.getString("Transmission"), set.getString("DriveTrain"), set.getString("Engine"), set.getString("BodyType"), set.getString("AskingPrice"), set.getString("MaintenanceCost"), set.getString("DateinStock"), set.getString("ReadyforSale"), set.getString("Status"), set.getString("ParkingSpaceNum"));
    }
    private CarLot parseCarLot(ResultSet set) throws SQLException{
        return new CarLot(set.getString("Address"), set.getString("TotalCapacity"), set.getString("Name"));
    }
    private Customer parseCustomer(ResultSet set) throws SQLException{
        return new Customer(set.getString("SSN"), set.getString("FirstName"), set.getString("LastName"), set.getString("PhoneNumber"), set.getString("Email"));
    }
    private Invoice parseInvoice(ResultSet set) throws SQLException{
        return new Invoice(set.getInt("InvoiceID"), set.getString("BuyPrice"), set.getString("SellPrice"), set.getString("Date"), set.getString("Signature"), set.getInt("EmployeeID"), set.getString("SSN"), set.getString("VIN"));
    }
}
