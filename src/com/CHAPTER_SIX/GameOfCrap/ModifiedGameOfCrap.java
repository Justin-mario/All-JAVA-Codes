package com.CHAPTER_SIX.GameOfCrap;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;


public class ModifiedGameOfCrap {
   static Scanner input = new Scanner ( System.in );
    static int counter = 1;
    static SecureRandom randomGame = new SecureRandom ();
    static int sumOfDice = (randomGame.nextInt ( 6 ) + 1) + (randomGame.nextInt ( 6 ) + 1);
    static int bankBalance = 1000;

    public static void playGame(int wager) {
        while (true) {

            if (sumOfDice == 7 || sumOfDice == 11) {
                displayMessage ();
                bankBalance += wager;
                System.out.println ("Your Balance is " + bankBalance);
                break;
            } else if (sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12) {
                displayMessage ();
                bankBalance -= wager;
                System.out.println ("Your Balance is " + bankBalance);
                break;
            } else if (sumOfDice == 4 || sumOfDice == 5 || sumOfDice == 6 || sumOfDice == 8 || sumOfDice == 9 || sumOfDice == 10) {

                do {
                    ++counter;
                    sumOfDice = (randomGame.nextInt ( 6 ) + 1) + (randomGame.nextInt ( 6 ) + 1);
                    if (sumOfDice == 7) {
                        displayMessage ();
                        bankBalance -= wager;
                        System.out.println ("Your Balance is " + bankBalance);
                        break;
                    }

                } while (!(sumOfDice == 4 || sumOfDice == 5 || sumOfDice == 6 || sumOfDice == 8 || sumOfDice == 9 || sumOfDice == 10));
                if (sumOfDice == 4 || sumOfDice == 5 || sumOfDice == 6 || sumOfDice == 8 || sumOfDice == 9 || sumOfDice == 10) {
                    displayMessage ();
                    bankBalance += wager;
                    System.out.println ("Your Balance is " + bankBalance);
                }
            }

            break;
        }
    }

    public static void placeWager(int wager){
        while (bankBalance !=0){
            playGame (wager);
            System.out.print ("Enter Wager ");
            wager = input.nextInt ();
            if (bankBalance == 0 ){
                System.out.println ("Sorry you are busted");
                break;
            }
            else if (bankBalance < wager){
                do{
                System.out.print ("Enter Wager ");
                wager = input.nextInt ();}
                while (bankBalance < wager);
            }
        }
    }

    public static void displayMessage(){
        Random random = new Random ();
        int message = 1 + random.nextInt (3);
        switch (message){
            case 1-> System.out.println ("Oh you are going for broke, huh?");
            case 2-> System.out.println ("Aw c'mon, take a chance!");
            case 3-> System.out.println ("you are up big. now's the validateTime to cash in your chips");
        }
    }

    public static void main(String[] args) {

        System.out.print ("Enter Wager ");
        int wager = input.nextInt ();
        if (wager <= bankBalance){
            placeWager ( wager );

        }
        else {
            do{
                System.out.print ("Enter Wager ");
                wager = input.nextInt ();
            }while (wager > bankBalance);
        }
        if(wager <= bankBalance){
            placeWager ( wager );
        }
    }
}