package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    // fields
    private final int customerID;
    private String firstName;
    private String lastName;
    private final Date birthDate;
    private final String nationalID;
    private String mobileNumber;
    private String address;
    private String emailAddress;
    private List<String> nationality = new ArrayList<>();


    // getter and setter methods
    public int getCustomerID() {
        return customerID;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<String> getNationality() {
        return nationality;
    }

    // Add nationality
    public void addNationality(String nationality) {
        this.nationality.add(nationality);
    }

    // constructor
    public Customer(int customerID, String firsName, String lastName, Date birthDate, String nationalID,
                    String mobileNumber, String address, String emailAddress, List<String> nationality){
        this.customerID = customerID;
        this.firstName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationalID = nationalID;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }
}
