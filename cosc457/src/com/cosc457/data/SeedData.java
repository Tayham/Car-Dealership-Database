package com.cosc457.data;

import java.sql.SQLException;

/**
 * Created by donnie on 12/11/16.
 */
public class SeedData {

    private static Database db;
    public static void seed(){
        db = Database.getInstance();
        seedEmployee();
        seedAvailability();

    }
    private static void seedEmployee(){
        try {
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Meredith', 'Price',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('John', 'Doe',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Maddie', 'Test',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Ash', 'Catchum',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('James', 'Test',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Sarah', 'Aye',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Jane', 'Doe',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Megan', 'Price',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Steve', 'Smith',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Joe', 'Guy',20, true);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void seedAvailability(){
        try {
            //Covers Monday
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('1', '1','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '1','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '1','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '1','12:00:00','19:30:00');");

            //Covers Tuesday
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '2','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('8', '2','07:00:00','9:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '2','9:00:00','15:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('5', '2','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('7', '2','15:00:00','19:30:00');");

            //Covers Wednesday
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '3','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '3','07:00:00','10:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '3','10:00:00','14:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('7', '3','14:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('8', '3','12:00:00','19:30:00');");

            //Covers Thursday
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('9', '4','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('8', '4','07:00:00','9:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '4','9:00:00','15:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('5', '4','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('7', '4','15:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '4','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('8', '4','07:00:00','9:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '4','9:00:00','15:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('5', '4','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('7', '4','15:00:00','19:30:00');");

            //Covers Friday
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '5','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('9', '5','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('10', '5','07:00:00','15:30:00');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
