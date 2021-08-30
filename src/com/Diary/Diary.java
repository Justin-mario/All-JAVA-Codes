package com.Diary;

import java.util.ArrayList;



public class Diary {
    private ArrayList<Entry> diary = new ArrayList<> ();


    public void addEntry(String entryBody) {
        diary.add ( new Entry ( entryBody ));
    }

    public int getNumberOfEntries() {
        return diary.size ();
    }

    public void deleteEntry(int dairyIndex) {
        diary.remove ( dairyIndex );
    }

    public String getEntryBody(int entryID) {
        String message = "";
        for (int i = 0; i < diary.size (); i++) {
            if(diary.get(i).getEntryID() == entryID)
                message = diary.get(i).getEntryBody ();
        }
        return message;
    }

    public void deleteAllEntry() {
        diary.clear ();
    }
    public int resetDiaryPage(){
        Entry entry = new Entry ( "" );
        return entry.setLastIdToZero ();
    }

    public Entry getEntry(int entryId){
        return diary.get ( entryId - 1 );
    }

}
