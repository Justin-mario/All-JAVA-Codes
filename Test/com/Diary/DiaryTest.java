package com.Diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    Diary diary;
    @BeforeEach
        void onSetUp(){
        diary = new Diary ();
    }
    @Test
        void addEntryToDiary(){
        diary.addEntry("I Dont really understand what i am doing");
        assertEquals ( 1, diary.getNumberOfEntries() );
    }
    @Test
    void deleteEntryFromDiary(){
        diary.addEntry("I Dont really understand what i am doing");
        diary.addEntry("well i am getting better now.");
        diary.deleteEntry(0);
        assertEquals ( 1, diary.getNumberOfEntries() );
    }

    @Test
    void deleteEntryAllFromDiary(){
        diary.addEntry("I Dont really understand what i am doing");
        diary.addEntry("well i am getting better now.");
        diary.addEntry("I Dont really understand what i am doing");
        diary.addEntry("well i am getting better now.");
        diary.deleteAllEntry();
        assertEquals ( 0, diary.getNumberOfEntries() );
    }
}