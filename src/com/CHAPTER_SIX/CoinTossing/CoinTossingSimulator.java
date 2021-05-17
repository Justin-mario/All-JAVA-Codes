package com.CHAPTER_SIX.CoinTossing;

import java.security.SecureRandom;
import java.util.Scanner;

import static com.CHAPTER_SIX.CoinTossing.CoinTossing.HEAD;
import static com.CHAPTER_SIX.CoinTossing.CoinTossing.TAILS;

public class CoinTossingSimulator {
    static int face;
    public static void  flip(){
        if (face == 1 ){
            System.out.println (HEAD);
        }
        else
            System.out.println (TAILS);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        SecureRandom randomCoinGame = new SecureRandom ();
        int userChoice = 0;
        int headCounter = 0;
        int tailCounter = 0;


        String prompt = """
                Toss Coin""";


        while(userChoice != -1){
            System.out.print ( prompt + "  " );
            userChoice = input.nextInt ();
            if (userChoice == -1){
                System.out.println ("Head Appeared " + headCounter + " Tail appeared " + tailCounter);
                System.exit ( 0 );
            }

            if (userChoice == 1) {
                 face = 1 + randomCoinGame.nextInt ( 2 );
                if (face == 1) {
                    System.out.println (face );
                    flip ();
                    headCounter++;
                } else {
                    System.out.println ( face );
                    flip ();
                    tailCounter++;
                }
            } else {
                System.out.println ( "Choice Does Not Exist" );
            }
        }

    }


}
