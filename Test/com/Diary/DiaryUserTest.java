package com.Diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryUserTest {
    Diary personalDiary;
    DiaryUser ben;
    @BeforeEach
        void onSetUp(){
        personalDiary = new Diary ();
        ben = new DiaryUser ( personalDiary,"ben" );
    }
    @Test
        void userHasADiary(){
        assertNotNull ( ben.getDiary() );
    }

    @Test
        void userCanAddEntryOnDiary(){
        ben.createEntry("On this day, I am trying to learn java programming");
        assertEquals (1,ben.getNumberOfEntry());
    }

    @Test
    void userCanAddMultipleEntryOnDiary(){
        ben.createEntry("On this day, I am trying to learn java programming");
        ben.createEntry("On this day, I am trying to learn java programming");
        ben.createEntry("On this day, I am trying to learn java programming");
        ben.createEntry("On this day, I am trying to learn java programming");
        assertEquals (4,ben.getNumberOfEntry());
    }

    @Test
    void userCanDeleteEntryOnDiary(){
        ben.createEntry("On this day, I am trying to learn java programming");
        ben.createEntry("On another day, I am trying to learn java programming");
        ben.createEntry("On yet another day, I am trying to learn java programming");
        ben.createEntry("On, emm yea another day, I am trying to learn java programming");
        ben.deleteEntry(2);
        assertEquals (3,ben.getNumberOfEntry());
    }

    @Test
    void userCanDeleteAllEntryOnDiary(){
        ben.createEntry("On this day, I am trying to learn java programming");
        ben.createEntry("On another day, I am trying to learn java programming");
        ben.createEntry("On yet another day, I am trying to learn java programming");
        ben.createEntry("On, emm yea another day, I am trying to learn java programming");
        ben.deleteAllEntry();
        assertEquals (0,ben.getNumberOfEntry());
    }
}