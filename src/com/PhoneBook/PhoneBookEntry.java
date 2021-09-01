package com.PhoneBook;

import java.time.LocalDateTime;

public class PhoneBookEntry {
    private String mobileNumber;
    private String email;
    private int entryId;
    private LocalDateTime entryDateAndTime;
    private static int lastEntry;

    public PhoneBookEntry(String mobileNumber, String email) {
        this.email = email;
        this.mobileNumber = mobileNumber;
        entryId = 1 + lastEntry++;
        entryDateAndTime = LocalDateTime.now ();
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getEntryId() {
        return entryId;
    }

    public LocalDateTime getEntryDateAndTime() {
        return entryDateAndTime;
    }

    public static int getLastEntry() {
        return lastEntry;
    }

    @Override
    public String toString() {
        return mobileNumber;
    }
//    return "Entry ID: " + entryId +
//            "\t\tEntry creation validateTime: " + entryDateAndTime +
//            "\nEntry body: " +  entryBody + ".....";
}
