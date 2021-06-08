package com.Diary;

public class DiaryUser {

private final String userName;
private final Diary diary;

    public DiaryUser(Diary diary, String userName) {
        this.diary = diary;
        this.userName = userName;
    }

    public Diary getDiary() {
        return diary;
    }

    public void createEntry(String entryBody) {
        diary.addEntry  ( entryBody );
    }

    public int getNumberOfEntry() {
       return diary.getNumberOfEntries ();
    }

    public void deleteEntry(int diaryIndex) {
    diary.deleteEntry ( diaryIndex );
    }

    public void deleteAllEntry() {
        diary.deleteAllEntry ();
    }
}
