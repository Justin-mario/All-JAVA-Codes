package com.PhoneBook;

import java.time.LocalDateTime;

public class PhoneBookEntry {
    private String name;
    private String mobile;
    private String email;
    private int entryId;
    private LocalDateTime entryDateAndTime;
    private static int lastEntry;

    public PhoneBookEntry(String name, String mobile, String email) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        entryId = 1 + lastEntry++;
        entryDateAndTime = LocalDateTime.now ();

    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
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
}
