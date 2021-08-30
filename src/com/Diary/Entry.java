package com.Diary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {
    private   int entryId;
    private String entryBody;
    private String entryDateAndTime;
    private static int lastEntry;



    public Entry(String entryBody) {
        this.entryBody = entryBody;
        entryDateAndTime = formattedDateAndTime ();
        entryId = 1 + lastEntry++;

    }
   public int setLastIdToZero(){
        return lastEntry = 0;
   }

    @Override
    public String toString() {
        return "Entry ID: " + entryId +
                "\t\tEntry creation validateTime: " + entryDateAndTime +
                "\nEntry body: " +  entryBody + ".....";
    }
    public String getEntryBody(){
        return entryBody;
    }

    public int getEntryID() {
        return entryId;
    }

    public String formattedDateAndTime(){

        String formattedDateTime;
        LocalDateTime myDateTime = LocalDateTime.now ();
        DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern ( "dd/MM/yyyy   hh:MM:ss" );
        formattedDateTime =  myDateTime.format ( myDateTimeFormatter ) ;
        return formattedDateTime;

    }
}
