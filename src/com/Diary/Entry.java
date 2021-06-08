package com.Diary;

import java.time.LocalDateTime;

public class Entry {
    private int entryId;
    private String entryBody;
    private LocalDateTime entryDateAndTime;
    private static int lastEntry;

    public Entry(String entryBody) {
        this.entryBody = entryBody;
        entryDateAndTime = LocalDateTime.now ();
        entryId = lastEntry++;

    }
}
