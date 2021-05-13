package com.GuessRandom;

public class GuessGameModified {
    static int counter = 0;
    public static int getRandomNumberGame(int userInput) {

    int randomNumber = (int) (Math.random () * 1000);

        if (userInput == randomNumber && counter < 10) {
            System.out.println ( "Either You Know The Secret Or you Got Lucky!" );
            counter++;
            System.out.println ("Number Of Guesses..." + counter);
            System.out.println ( "Choose 1 To play Again and 2 to Exit" );
            if (userInput == 2) {
                System.exit ( 1 );}
            else
                randomNumber /= (int) (Math.random () * 1000); }

        else if (userInput == randomNumber && counter == 10){
            System.out.println ( "Aha! You Know The Secret!" );
            counter++;
            System.out.println ("Number Of Guesses..." + counter);
            System.out.println ( "Choose 1 To play Again and 2 to Exit" );
            if (userInput == 2) {
                System.exit ( 1 );}
            else
                randomNumber /= (int) (Math.random () * 1000); }
        else if (userInput == randomNumber && counter > 10){
            System.out.println ( "You Should Be Able To Do Better!" );
            counter++;
            System.out.println ("Number Of Guesses..." + counter);
            System.out.println ( "Choose 1 To play Again and 2 to Exit" );

            if (userInput == 2) {
                System.exit ( 1 );}
            else
                randomNumber /= (int) (Math.random () * 1000); }

         else if (userInput > randomNumber) {
            System.out.println ( "Too High Try Again!!!" );
            counter++;
            System.out.println ("Number Of Guesses..." + counter);

    }   else if  (userInput < randomNumber){
            System.out.println ( "Too Low Try Again!!!" );
            counter++;
            System.out.println ("Number Of Guesses..." + counter);}

                return randomNumber;
}
}
