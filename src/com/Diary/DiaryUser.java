package com.Diary;

public class DiaryUser {

private final String userName;
private final Diary diary;
private String diaryBody;


    public DiaryUser(Diary diary, String userName) {
        this.diary = diary;
        this.userName = userName;
    }

    public Diary getDiary() {
        return diary;
    }

    public void createEntry(String entryBody) {
        diaryBody = entryBody;
        diary.addEntry  ( entryBody );
    }

    public int getNumberOfEntry() {
       return diary.getNumberOfEntries ();
    }

    public void deleteEntry(int diaryIndex) {
        diary.deleteEntry ( diaryIndex );}


    public void deleteAllEntry() {
        diary.deleteAllEntry ();
    }

    public Entry readEntry(int diaryIndex) {
        return diary.getEntry ( diaryIndex );}

    public int resetDiaryPage(){
        return diary.resetDiaryPage ();
    }

}


