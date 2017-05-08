package com.cosc457.data;

import com.cosc457.models.CarLot;
import com.cosc457.models.CarLot;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Taylor on 5/7/2017.
 */
public class CarLotApi {
    private static Database database = Database.getInstance();

    public static void saveCarLot(CarLot c){
        String values = "'"+c.getAddress() + "', '" + c.getCapacity()+"', '"+c.getName() + "'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO CarLot(Address, TotalCapacity, Name) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    public static void deleteCarLot(CarLot c){
        String address = c.getAddress();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM CarLot WHERE Address ='"+address+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }


    public static ArrayList<CarLot> getAllCarLots(){
        ArrayList<CarLot> result = new ArrayList<CarLot>();
        String query = "SELECT * FROM CarLot";
        try {
            for(Object o : database.retrieve(query, CarLot.class)){
                result.add((CarLot)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static CarLot getByAddress(String address){
        String query = "SELECT * FROM CarLot WHERE Address = " + address;
        try {
            for(Object o : database.retrieve(query, CarLot.class)){
                return (CarLot)o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, CarLot> getCarLotIdMap(){
        HashMap<String, CarLot> map = new HashMap<String, CarLot>();
        for(CarLot c : getAllCarLots()){
            map.put(c.getAddress(), c);
        }
        return map;
    }
}
