package com.CHAPTER_FOURTEEN.comparing_portions_of_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


class ComparingPortionsOfStringTest {
    @Test
        void compareTwoPortionsOfString(){
        ComparingPortionsOfString comparingPortionsOfString = new ComparingPortionsOfString ();

        comparingPortionsOfString.compareTwoString ("hippopotamus", "hippopotamus");
        assertFalse ( comparingPortionsOfString.getResult () );
    }

}