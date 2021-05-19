package com.CHAPTER_SIX.HypotenuseCalculations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HypotenuseCalculatorTest {
    @Test
    @DisplayName ( "Test For Hypotenuse When The Length Of Two Sides Of A Triangle Is Given" )
        void checkForHypotenuseWhenTwoSidesOfATriangleAreGiven(){
            assertEquals (5,HypotenuseCalculator.getHypotenuse(3.0,4.0));
            assertEquals (13,HypotenuseCalculator.getHypotenuse(5.0,12.0));
            assertEquals (17,HypotenuseCalculator.getHypotenuse(8.0,15.0));

    }

}