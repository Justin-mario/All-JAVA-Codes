package com.maven.bank.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long bvn;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Account> accounts = new ArrayList<> ();
    private LocalDateTime relationshipStartDate;
    private LocalDate dateOfBirth;


    public void setBvn(long bvn) {
        this.bvn = bvn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBvn() {
        return bvn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getRelationshipStartDate() {
        return relationshipStartDate;
    }

    public void setRelationshipStartDate(LocalDateTime relationshipStartDate) {
        this.relationshipStartDate = relationshipStartDate;

    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
