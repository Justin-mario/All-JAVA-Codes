package com.CHAPTER_SIX.GuessRandom;

import java.util.Scanner;

public class RandomNumberGameApp {
    public static void main(String[] args) {

        Scanner input = new Scanner ( System.in );
        int counter = 0;
        System.out.println ("Guess A Magic Number");
        System.out.println ("The Number To Guess Is Between 1 And 1000\n");
        System.out.print ("Input Your Guess...\t");

        int userGuess = input.nextInt ();
        while (userGuess != -1) {
            GuessRandomNumber.getRandomNumberGame ( userGuess );
            System.out.print ("Input Another Number...\t");
            userGuess = input.nextInt ();
        }
    }
}
