package entity;

import java.util.Date;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private  Date birthDate;
    private String nationalId;
    private String mobileNumber;
    private String address;
    private String emailAddress;
    private String nationality;


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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


    public Customer(int id, String firstName, String lastName, Date birthDate, String nationalId,
                    String mobileNumber, String address, String emailAddress, String nationality){
        this.id = id;
        this.firstName = firstName;
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
