package com.GuessRandom;

public class GuessRandomNumber {

    public static int getRandomNumberGame(int userInput) {

        int randomNumber = (int) (Math.random () * 1000);
            if (userInput == randomNumber) {
                System.out.println ( "Congratulations!!!. You Guessed The Number" );
                System.out.println ( "Choose 1 To play Again and 2 to Exit" );
                if (userInput == 2) {
                    System.exit ( 1 );}
                } else if (userInput > randomNumber) {
                    System.out.println ( "Too High Try Again!!!" );
                } else if (userInput < randomNumber)
                System.out.println ( "Too Low Try Again!!!" );

                return randomNumber;
            }

    }

