package com.maven.bank.entities;

public class Company {
    private String rcNumber;
    private String name;
    private String address;

    public Company(String rcNumber, String companyName){
        this.rcNumber = rcNumber;
        name = companyName;
    }

    public Company(String rcNumber){
        this.rcNumber = rcNumber;
    }

    public String getRcNumber() {
        return rcNumber;
    }

    public void setRcNumber(String rcNumber) {
        this.rcNumber = rcNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
