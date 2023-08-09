package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    // fields
    private int Id;
    private String firstName;
    private String lastName;
    private  Date birthDate;

    private String nationalId;
    private String mobileNumber;
    private String address;
    private String emailAddress;
    private List<String> nationality = new ArrayList<>();


    // getter and setter methods
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
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

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
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

    public void setNationality(List<String> nationality) {
        this.nationality = nationality;
    }


    // Add nationality
    public void addNationality(String nationality) {
        this.nationality.add(nationality);
    }

    // constructor
    public Customer(int Id, String firsName, String lastName, Date birthDate, String nationalId,
                    String mobileNumber, String address, String emailAddress, List<String> nationality){
        this.Id = Id;
        this.firstName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }

    public Customer(){

    }
}