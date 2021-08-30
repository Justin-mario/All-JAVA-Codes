package com.CHAPTER_EIGHT.date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void dateObjectTest(){
        Date date1 = new Date (10, 14,2002);
        Date date2 = new Date ("March", 3,2005);


        System.out.printf ("Date object with 3 in args --> %s%n", date1);
        System.out.printf ("Date object with String (month), int (day), int(year) --> %n%s%n", date2);
    }

    @Test
    void testThirdConstructor(){
        Date date3 = new Date (365,2003);
        assertEquals (12, date3.getMonth () );
        assertEquals ( 31, date3.getDay () );
        assertEquals ( 2003,date3.getYear () );
    }

    @AfterEach
    void tearDown() {
    }
}