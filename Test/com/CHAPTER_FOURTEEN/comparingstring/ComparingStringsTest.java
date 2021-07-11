package com.CHAPTER_FOURTEEN.comparingstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparingStringsTest {
    @Test
    void compareTwoStringObject(){
        ComparingStrings compare = new ComparingStrings ();
        compare.compareTwoString("two", "two");
        assertEquals ( 0, compare.getResult() );
    }

}