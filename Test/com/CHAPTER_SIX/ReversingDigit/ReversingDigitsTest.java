package com.CHAPTER_SIX.ReversingDigit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversingDigitsTest {
    @Test
    @DisplayName ( "Test Digits Can Be Reversed" )
        void checkDigitsCanBeReversed(){
        assertEquals (2487,ReversingDigits.getReversedDigits(7842));
    }

}