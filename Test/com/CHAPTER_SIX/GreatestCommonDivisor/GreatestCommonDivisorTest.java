package com.CHAPTER_SIX.GreatestCommonDivisor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {
    @Test
    @DisplayName ( "Test For The Greatest Common Divisor" )
        void CheckForGreatestCommonDivisor(){
        assertEquals (4,GreatestCommonDivisor.getTheGreatestCommonDivisor(20,16));
    }

}