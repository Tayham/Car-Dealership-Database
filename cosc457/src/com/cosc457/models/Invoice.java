package com.cosc457.models;

/**
 * Created by Taylor on 5/8/2017.
 */
public class Invoice {
    private int invoiceID;
    private String buyPrice;
    private String sellPrice;
    private String date;

    public Invoice(int idInt) {
        this.invoiceID = idInt;
    }

    public Invoice(String buyPrice, String sellPrice, String date, String signature, int empID, String ssn, String vin) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.date = date;
        this.signature = signature;
        this.empID = empID;
        this.ssn = ssn;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "ID: " + invoiceID + " Buy Price: " + buyPrice + " Sell Price: " + sellPrice+ " Date: " + date + " Signature: " + signature + " Employee ID: " + empID + " SSN: " + ssn  + " VIN: " + vin;
    }

    public Invoice(int invoiceID, String buyPrice, String sellPrice, String date, String signature, int empID, String ssn, String vin) {
        this.invoiceID = invoiceID;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.date = date;
        this.signature = signature;
        this.empID = empID;
        this.ssn = ssn;
        this.vin = vin;
    }

    private String signature;
    private int empID;
    private String ssn;
    private String vin;

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
