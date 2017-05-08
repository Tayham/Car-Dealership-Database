package com.cosc457.data;

import com.cosc457.models.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Taylor on 5/8/2017.
 */
public class CustomerApi {
    private static Database database = Database.getInstance();

    public static void saveCustomer(Customer c){
        String values = "'"+c.getSSN() + "', '" + c.getFirstName()+"', '"+c.getLastName() + "', '" + c.getPhone()+"', '"+c.getEmail() + "'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO Customer (SSN, FirstName, LastName, PhoneNumber, Email) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteCustomerViaName(Customer s){
        String first_name = s.getFirstName();
        String last_name = s.getLastName();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM Customer WHERE firstName ='"+first_name+"' AND lastName ='"+last_name+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static void deleteCustomerViaSSN(Customer s){
        String ssn = s.getSSN();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM Customer WHERE SSN = '"+ssn+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> result = new ArrayList<Customer>();
        String query = "SELECT * FROM Customer";
        try {
            for(Object o : database.retrieve(query, Customer.class)){
                result.add((Customer)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Customer getById(String ssn){
        String query = "SELECT * FROM Customer WHERE SSN = " + ssn;
        try {
            for(Object o : database.retrieve(query, Customer.class)){
                return (Customer)o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static Customer getEmployeeByName(String name){
//        for(Customer e : CustomerApi.getAllEmployees()){
//            if(e.getFullName().equals(name)){
//                return e;
//            }
//        }
//        return null;
//    }
//
//    public static HashMap<Integer, Customer> getEmployeeIdMap(){
//        HashMap<Integer, Customer> map = new HashMap<Integer, Customer>();
//        for(Customer e : getAllEmployees()){
//            map.put(e.getID(), e);
//        }
//        return map;
//    }
}
