package com.cosc457.models;

public class SalesPeople {
    private int ID;
    private String firstName;
    private String lastName;
    private String salary;
    private String dob;
    private String hireDate;
    private String phone;
    private String email;

    public SalesPeople(int ID) {
        this.ID = ID;
    }

    public SalesPeople(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SalesPeople(String firstName, String lastName, String salary, String dob, String hireDate, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dob = dob;
        this.hireDate = hireDate;
        this.phone = phone;
        this.email = email;
    }

    public SalesPeople(int ID, String firstName, String lastName, String salary, String dob, String hireDate, String phone, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dob = dob;
        this.hireDate = hireDate;
        this.phone = phone;
        this.email = email;
    }

    public SalesPeople(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }


    @Override
    public String toString() {
        return "ID: " + ID + " First Name: " +firstName+ " Last Name: " + lastName+ " Salary: " + salary+ " Date of Birth: " + dob +" Hire Date: " + hireDate + " Phone Number: " + phone+" Email: " + email;
    }
}








                       












 

