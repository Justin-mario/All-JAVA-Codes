package com.Diary;

import java.util.ArrayList;

public class Diary {
    private ArrayList<Entry> diary = new ArrayList<> ();

    public void addEntry(String entryBody) {
        diary.add ( new Entry ( entryBody ) );
    }

    public int getNumberOfEntries() {
        return diary.size ();
    }

    public void deleteEntry(int dairyIndex) {
        diary.remove ( dairyIndex );
    }

    public Entry readEntry(int diaryIndex) {
        return diary.get ( 0 );
    }

    public void deleteAllEntry() {
        diary.clear ();
    }
}
