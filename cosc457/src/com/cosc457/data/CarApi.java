package com.cosc457.data;

import com.cosc457.models.Car;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Taylor on 5/7/2017.
 */
public class CarApi {
    private static Database database = Database.getInstance();

    public static void saveCar(Car c){
        String values = "'"+c.getVin() + "', '" + c.getYear()+"', '"+c.getMake() + "', '" + c.getModel()+"', '"+c.getTrim() + "', '"
                + c.getExcolor()+"', '"+c.getIncolor() + "', '" + c.getMileage()+"', '"+c.getTransmission() + "', '" + c.getDrivetrain()+"', '"+c.getEngine() + "', '"
                + c.getBodytype()+"', '" + c.getAsking()+"', '"+c.getMaintence() + "', '" + c.getDatestock()+"', '"+c.getReadysale() + "', '" + c.getStatus()+"', '" + c.getPspace()+"'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO Car(VIN, Year, Make, Model, Trim, ExteriorColor, InteriorColor, Mileage, Transmission, DriveTrain, Engine, BodyType, AskingPrice, MaintenanceCost, DateInStock, ReadyforSale, Status, ParkingSpaceNum) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    public static void deleteCar(Car c){
        String vin = c.getVin();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM Car WHERE VIN ='"+vin+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<Car> getAllCars(){
        ArrayList<Car> result = new ArrayList<Car>();
        String query = "SELECT * FROM Car";
        try {
            for(Object o : database.retrieve(query, Car.class)){
                result.add((Car)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Car getByVIN(String vin){
        String query = "SELECT * FROM Car WHERE VIN = " + vin;
        try {
            for(Object o : database.retrieve(query, Car.class)){
                return (Car)o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static Car getEmployeeByName(String name){
//        for(Car c : CarApi.getAllCars()){
//            if(c.ge().equals(name)){
//                return c;
//            }
//        }
//        return null;
//    }

    public static HashMap<String, Car> getCarIdMap(){
        HashMap<String, Car> map = new HashMap<String, Car>();
        for(Car c : getAllCars()){
            map.put(c.getVin(), c);
        }
        return map;
    }
}
