package com.CHAPTER_SEVEN.GameOfCrap;

import java.security.SecureRandom;

import static com.CHAPTER_SEVEN.GameOfCrap.GameStatus.*;

public class GameOfCrap {

    public static int getSumOfDiceThrown() {
        SecureRandom randomDice = new SecureRandom ();
         int  firstDiceThrown = randomDice.nextInt (6) + 1;
         int secondDiceThrown = randomDice.nextInt (6) + 1;
        int sumOfDice = firstDiceThrown + secondDiceThrown;
      return   sumOfDice;
    }


    public GameStatus PlayGame(GameStatus gameStatus) {
      int gameScore =  getSumOfDiceThrown ();
      if (gameStatus.equals ( NEW_GAME ) && gameScore == 7 || gameScore == 11){
          return WON;
      }
        return LOST;
    }
}
