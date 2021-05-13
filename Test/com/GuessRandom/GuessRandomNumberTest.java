package com.GuessRandom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GuessRandomNumberTest {
    @Test
    @DisplayName ( "Check Guess Game Generates Random Number" )
        void checkGuessGameGeneratesRandomNumber(){
        assertNotEquals(GuessRandomNumber.getRandomNumberGame(4),GuessRandomNumber.getRandomNumberGame(456));
    }
}
