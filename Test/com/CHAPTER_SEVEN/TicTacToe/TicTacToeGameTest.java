package com.CHAPTER_SEVEN.TicTacToe;

import com.CHAPTER_SEVEN.TicTacToe.TicTacToeGameExceptionException.TicTacToeBoardOverFlowException;
import com.CHAPTER_SEVEN.TicTacToe.TicTacToeGameExceptionException.TicTacToeBoardUnderFlowException;
import org.junit.jupiter.api.*;


import java.util.Arrays;

import static com.CHAPTER_SEVEN.TicTacToe.TicTacToePlayers.*;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {
    TicTacToePlayers[][] prompt;
   @BeforeEach
   void beforeEachTest(){
       prompt = new TicTacToePlayers[3][3];
   }
    @Test
    @DisplayName ( "Test That Tic Tac Toe Board Can Be Displayed" )
        void checkTicTacToeBoardCanBeDisplayed(){
     TicTacToePlayers[][]    prompt = {{EMPTY, UP_SYMBOLS, EMPTY, UP_SYMBOLS, EMPTY},
                                        {DOWN_SYMBOL, DOWN_SYMBOL, DOWN_SYMBOL, DOWN_SYMBOL,DOWN_SYMBOL},
                                        {EMPTY, UP_SYMBOLS, EMPTY, UP_SYMBOLS, EMPTY},
                                        {DOWN_SYMBOL, DOWN_SYMBOL, DOWN_SYMBOL, DOWN_SYMBOL, DOWN_SYMBOL},
                                        {EMPTY, UP_SYMBOLS, EMPTY, UP_SYMBOLS, EMPTY}};


        for (TicTacToePlayers[] arrays: prompt) {
            System.out.println (Arrays.toString ( arrays ));
        }
            //System.out.println ( Arrays.deepToString ( prompt ));


        assertArrayEquals ( prompt,TicTacToeGame.getTicTacToeBoard());
    }

   @Test
    @DisplayName ( "Test Players One Can Play Game" )
        void checkPlayerOneCanPlayGame(){
        assertEquals ( X,TicTacToeGame.playGame (X,1));
   }

    @Test
    @DisplayName ( "Test Players One Can Play Any Position" )
    void checkPlayerOneCanPlayAnyPosition() {
        assertEquals ( X, TicTacToeGame.playGame (X, 9 ) ); }

    @Test
    @DisplayName ( "Test Players Two Can Play " )
    void checkPlayerTwoCanPlayGame() {
        assertEquals ( O, TicTacToeGame.playGame ( O,1 ) );
    }

    @Test
    @DisplayName ( "Test Players Two Can Play Any Position" )
    void checkPlayerTwoCanPlayAnyPosition() {
        assertEquals ( O, TicTacToeGame.playGame ( O,9 ) );
        assertEquals ( O, TicTacToeGame.playGame ( O,5 ) ); }

    @Test
    @DisplayName ( "Test Players can Not Play A Position Below 1" )
        void CheckPlayerCannotPlayAPositionBelowOne(){
       assertThrows ( TicTacToeBoardUnderFlowException.class,()-> TicTacToeGame.playGame ( X,0 ) ); }

    @Test
    @DisplayName ( "Test Players can Not Play A Position Above 9" )
    void CheckPlayerCannotPlayAPositionAboveNine(){
        assertThrows ( TicTacToeBoardOverFlowException.class,()-> TicTacToeGame.playGame ( X,10 ) ); }

    @Test
    @DisplayName ( "Test Two position Can Not Be Played Twice" )
        void checkTwoPositionCannotBePlayedTwice(){
        TicTacToeGame.playGame ( O,9 );
        assertEquals ( PLAYED, TicTacToeGame.playGame ( O,9 ) ); }

    @Test
    @DisplayName ( "Test Game Can Be Won" )
        void checkGameCanBeWon(){
        TicTacToeGame.playGame ( X,4 );
        TicTacToeGame.playGame ( X,4 );
        TicTacToeGame.playGame ( X,6 );
       assertEquals (X, TicTacToeGame.getWinner() );
    }
    @AfterEach
    void afterEachTest(){
        prompt = null;
    }
}