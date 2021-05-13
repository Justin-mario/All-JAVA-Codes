package com.GuessRandom;

import java.util.Scanner;

public class GuessGameModifiedApp {
    public static void main(String[] args) {

        Scanner input = new Scanner ( System.in );
        System.out.println ("Guess A Magic Number");
        System.out.println ("The Number To Guess Is Between 1 And 1000\n");
        System.out.print ("Input Your Guess...\t");

        int userGuess = input.nextInt ();
        while (userGuess != -1) {
            if (userGuess <= 1000){
            GuessGameModified.getRandomNumberGame ( userGuess );
            System.out.print ("Input Another Number...\t");
            userGuess = input.nextInt ();}
            else
                System.out.println ("Guess Is Out Of Range!!!...Guess Between 1 And 1000");
            GuessGameModified.getRandomNumberGame ( userGuess );
            System.out.print ("Input Another Number...\t");
            userGuess = input.nextInt ();}
        }
    }
