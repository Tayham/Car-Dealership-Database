package com.cosc457.models;

/**
 * Created by Taylor on 5/7/2017.
 */
public class Car {
    private String vin;
    private String year;
    private String trim;
    private String model;
    private String make;
    private String excolor;
    private String incolor;
    private String mileage;
    private String transmission;
    private String drivetrain;
    private String engine;
    private String bodytype;
    private String asking;
    private String maintence;
    private String datestock;
    private String readysale;
    private String status;
    private String pspace;


    @Override
    public String toString() {
        return  "vin='" + vin + '\'' +
                ", year='" + year + '\'' +
                ", trim='" + trim + '\'' +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", excolor='" + excolor + '\'' +
                ", incolor='" + incolor + '\'' +
                ", mileage='" + mileage + '\'' +
                ", transmission='" + transmission + '\'' +
                ", drivetrain='" + drivetrain + '\'' +
                ", engine='" + engine + '\'' +
                ", bodytype='" + bodytype + '\'' +
                ", asking='" + asking + '\'' +
                ", maintence='" + maintence + '\'' +
                ", datestock='" + datestock + '\'' +
                ", readysale='" + readysale + '\'' +
                ", status='" + status + '\'' +
                ", pspace='" + pspace + '\'' +
                '}';
    }

    public String getExcolor() {
        return excolor;
    }

    public void setExcolor(String excolor) {
        this.excolor = excolor;
    }

    public String getIncolor() {
        return incolor;
    }

    public void setIncolor(String incolor) {
        this.incolor = incolor;
    }

    public Car(String vin, String year, String trim, String model,  String make, String excolor, String incolor, String mileage, String transmission, String drivetrain, String engine, String bodytype, String asking, String maintence, String datestock, String readysale, String status, String pspace) {
        this.vin = vin;
        this.year = year;
        this.trim = trim;
        this.model = model;
        this.make = make;
        this.excolor=excolor;
        this.incolor=incolor;
        this.mileage = mileage;
        this.transmission = transmission;
        this.drivetrain = drivetrain;
        this.engine = engine;
        this.bodytype = bodytype;
        this.asking = asking;
        this.maintence = maintence;
        this.datestock = datestock;
        this.readysale = readysale;
        this.status = status;
        this.pspace = pspace;
    }
    public Car(String vin) {
        this.vin = vin;
    }
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBodytype() {
        return bodytype;
    }

    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    public String getAsking() {
        return asking;
    }

    public void setAsking(String asking) {
        this.asking = asking;
    }

    public String getMaintence() {
        return maintence;
    }

    public void setMaintence(String maintence) {
        this.maintence = maintence;
    }

    public String getDatestock() {
        return datestock;
    }

    public void setDatestock(String datestock) {
        this.datestock = datestock;
    }

    public String getReadysale() {
        return readysale;
    }

    public void setReadysale(String readysale) {
        this.readysale = readysale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPspace() {
        return pspace;
    }

    public void setPspace(String pspace) {
        this.pspace = pspace;
    }

}
