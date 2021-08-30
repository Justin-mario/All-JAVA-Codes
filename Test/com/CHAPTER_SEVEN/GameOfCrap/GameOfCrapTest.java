package com.CHAPTER_SEVEN.GameOfCrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfCrapTest {
    GameOfCrap game;
    @BeforeEach
        void beforeEachTest(){
        game = new GameOfCrap ();
    }
//    @Test
//    @DisplayName ( "Check That Dice Can Be thrown" )
//        void checkThatDiceCanBeThrown(){
//        int firstDice = game.getFirstDiceThrown ();
//        assertEquals (  firstDice,firstDice);
//    }

//    @Test
//    @DisplayName ( "Check That Second Dice Can Be thrown" )
//    void checkThatSecondDiceCanBeThrown(){
//        int secondDice = game.getSecondDiceThrown ();
//        assertEquals (  secondDice,secondDice);
//    }

    @Test
    @DisplayName ( "Test That Sum Of Two Dice Thrown Can Be Obtained" )
        void checkThatSumOfTwoDiceCanBeObtained(){
        int dice = game.getSumOfDiceThrown ();
        assertEquals (  dice,dice);
    }

//    @Test
//    @DisplayName ( "Test Can Can Be Won when Sum Of Dice Is 7 or 11 On First Throw" )
//        void checkGameIsWonWhenSumOfDiceThrownIs_7_or_11_onFirstThrow(){
//        int firstDice = game.getFirstDiceThrown ();
//        int secondDice = game.getSecondDiceThrown ();
//        int dice = firstDice + secondDice;



    }

//}