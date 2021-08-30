package com.CHAPTER_SEVEN.GameOfCrap;

import java.security.SecureRandom;

import static com.CHAPTER_SEVEN.GameOfCrap.GameStatus.NEW_GAME;

public class Game {
    static int counter = 1;
    public static void main(String[] args) {
        int bankBalance = 1000;
        SecureRandom randomGame = new SecureRandom ();



        while (true) {
            int sumOfDice = (randomGame.nextInt (6) + 1) + (randomGame.nextInt (6) + 1);
        if (sumOfDice == 7 || sumOfDice == 11) {
            System.out.println (sumOfDice);
            System.out.println ( "You Won on first Attempt" );
            System.out.println (counter);
            break;
            }
        else if(sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12){
            System.out.println (sumOfDice);
            System.out.println ("You Lost");
            System.out.println (counter);
            break;
            }
        else if(sumOfDice == 4 || sumOfDice == 5 || sumOfDice == 6 || sumOfDice == 8 || sumOfDice == 9 || sumOfDice == 10){

            do{
                ++counter;
                sumOfDice = (randomGame.nextInt (6) + 1) + (randomGame.nextInt (6) + 1);
                if (sumOfDice == 7){
                    System.out.println (sumOfDice);
                    System.out.println ("You Lost on " + counter + " attempt");
                    break;
                }
//                counter++;
            }while(!(sumOfDice == 4 || sumOfDice == 5 || sumOfDice == 6 || sumOfDice == 8 || sumOfDice == 9 || sumOfDice == 10));
            if(sumOfDice == 4 || sumOfDice == 5 || sumOfDice == 6 || sumOfDice == 8 || sumOfDice == 9 || sumOfDice == 10){
                System.out.println (sumOfDice);
                System.out.println ("You won on " + counter + "  attempt");
                System.out.println (counter);
            }
        }
        else {
            System.out.println ("Well you lost " + counter + "attempt");
        }

        break;
        }
    }
}
