package com.newphonebook.model;

import java.time.LocalDateTime;

public class PhonebookEntry {
    private final String name;
    private  String  mobileNumber;
    private String emailAddress;
    private String address;
    private LocalDateTime entryDateTime;
    private int entryId;
    private static int lastEntry;

    public PhonebookEntry(String name, String mobileNumber, String emailAddress, String address) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.address = address;
        entryDateTime = LocalDateTime.now ();
        entryId =   ++lastEntry ;
    }


    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public int getEntryId() {
        return entryId;
    }

    public static int getLastEntry() {
        return lastEntry;
    }

    public static void tearDown(){
        lastEntry =0;
    }

    @Override
    public String toString() {
        return "name: " + name + '\n' +
                "mobileNumber: " + mobileNumber + '\n' +
                "emailAddress: " + emailAddress + '\n' +
                "address: " + address + '\n' +
                "entryId: " + entryId;
    }


}
