package com.CHAPTER_SIX.MinimumValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindingMinimumValueTest {
    @Test
    @DisplayName ( "Check For The Minimum Value Of Three Floating Point Numbers" )
        void checkForTheMinimumValueOfThreeFloatingPointNumbers(){
        FindingMinimumValue minimumValue = new FindingMinimumValue ();
        assertEquals ( 0.75,minimumValue.getMinimum3(7.5,0.75,100.78) );
    }
}