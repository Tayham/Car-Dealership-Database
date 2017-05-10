package com.cosc457.models;

/**
 * Created by Taylor on 5/8/2017.
 */
public class Customer {
    private String SSN;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Customer(String SSN, String firstName, String lastName, String phone, String email) {
        this.SSN = SSN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return  "Customer SSN: " + SSN +
                " First Name: " + firstName +
                " Last Name: " + lastName +
                " Phone: " + phone +
                " Email: " + email;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String toTable() {
        return ("    <td>" + SSN + "</td>\n" +
                "    <td>" + firstName + "</td>\n" +
                "    <td>" + lastName + "</td>\n" +
                "    <td>" + phone + "</td>\n" +
                "    <td>" + email + "</td>\n");
    }
}
