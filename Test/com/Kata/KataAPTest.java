package com.Kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataAPTest {
    @Test
        void check_4th_elementOfArithmeticProgression(){
        KataAP progression = new KataAP ();
        progression.setFirstThreeNumbersOfArithmeticProgression (2,4,6);
        assertEquals (8, progression.getFourthElement() );
    }
    @Test
    void checkElementMustHaveSequenceOfArithmeticProgression(){
        KataAP arithmeticProgression = new KataAP ();
        assertThrows (ArithmeticException.class, ()-> arithmeticProgression.setFirstThreeNumbersOfArithmeticProgression (1,3,9));
    }

    @Test
    void check_4th_elementOfGeometricProgression(){
        KataAP progression = new KataAP ();
        progression.setFirstThreeNumbersOfGeometricProgression (1,3,9);
        assertEquals (27, progression.getFourthElementOfGeometricProgression() );
    }

    @Test
    void checkElementOfGeometricProgressionIsInCorrectSequence(){
        KataAP progression = new KataAP ();

        assertThrows ( ArithmeticException.class, ()-> progression.setFirstThreeNumbersOfGeometricProgression (1,5,9) );
        assertEquals (27, progression.getFourthElementOfGeometricProgression() );
    }
}