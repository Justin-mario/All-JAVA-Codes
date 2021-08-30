package com.newpractice.chapter8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testForTimeWithToString(){
        Time time = new Time ();
        try {
            time.setTime (23,12,02);
        }catch (IllegalArgumentException ex){
                ex.getMessage ();
        }
        String newTime = "11 : 12 : 02 PM";
        assertEquals (newTime, time.toString ()  );
    }

    @Test
    void testForTimeWithToUniversalTime(){
        Time time = new Time ();
        try {
            time.setTime (23,12,02);
        }catch (IllegalArgumentException ex){

        }
        String newTime = "23: 12: 02";
        assertEquals (newTime, time.toUniversalTime ()  );

    }
}