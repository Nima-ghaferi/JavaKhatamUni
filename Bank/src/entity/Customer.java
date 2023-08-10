package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    // fields
    private int Id;
    private static List<Integer> IdList = new ArrayList<>();
    private String firstName;
    private String lastName;
    private  Date birthDate;
    private String nationalId;
    private String mobileNumber;
    private String address;
    private String emailAddress;
    private String nationality;


    // getter and setter methods
    public int getId() {
        return this.Id;
    }

    public static List<Integer> getIdList() {
        return IdList;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalId() {
        return this.nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    // constructor
    public Customer(int Id, String firsName, String lastName, Date birthDate, String nationalId,
                    String mobileNumber, String address, String emailAddress, String nationality){
        this.Id = Id;
        this.firstName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
        IdList.add(Id);
    }

    public Customer(){

    }
}
