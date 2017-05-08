package com.cosc457.data;

import com.cosc457.models.Invoice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Taylor on 5/8/2017.
 */
public class InvoiceApi {
    private static Database database = Database.getInstance();

    public static void saveInvoice(Invoice s){
        String values = "'"+s.getInvoiceID() + "', '" + s.getBuyPrice()+"', '"+s.getSellPrice() + "', '" + s.getDate()+"', '"+s.getSignature() + "', '" + s.getEmpID()+"', '"+s.getSsn() +"', '"+s.getVin()+ "'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO Invoice(InvoiceID, BuyPrice, SellPrice, Date, Signature, EmployeeID, SSN, VIN) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteInvoice(Invoice s){
        int id = s.getInvoiceID();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM Invoice WHERE InvoiceID ='"+id+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<Invoice> getAllInvoices(){
        ArrayList<Invoice> result = new ArrayList<Invoice>();
        String query = "SELECT * FROM Invoice";
        try {
            for(Object o : database.retrieve(query, Invoice.class)){
                result.add((Invoice)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Invoice getById(int id){
        String query = "SELECT * FROM Invoice WHERE ID = " + id;
        try {
            for(Object o : database.retrieve(query, Invoice.class)){
                return (Invoice)o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
