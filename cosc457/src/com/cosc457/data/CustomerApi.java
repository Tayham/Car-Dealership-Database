package com.cosc457.data;

import com.cosc457.models.Customer;

import java.sql.PreparedStatement;
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

    public static void updateCustomer(Customer c){
        String query = String.format("UPDATE Customer SET FirstName = '%s' , LastName = '%s' , PhoneNumber = '%s' , Email = '%s' WHERE SSN = '%s'; ", c.getFirstName(), c.getLastName(), c.getPhone(), c.getEmail(), c.getSSN());
        try {
            database.insert(query);
        } catch (SQLException e1) {
            e1.printStackTrace();
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
}
