package com.CHAPTER_SIX.DisplayingASquare;

import java.util.Scanner;

public class DisplayingASquareOfAsterisks {
    public static void squareOfAsterisks(int numberOfStarToDisplay, char fillCharacter){
        int line = numberOfStarToDisplay;
        for(int i = 0; i < line ; i++){
            for(int j = numberOfStarToDisplay; j > 0; j--){
                System.out.print (fillCharacter + " ");
            }
            System.out.println ();
        }

    }
    public static void main(String[] args) {

        Scanner input = new Scanner ( System.in );
        System.out.print ("Input The Character To Print....");
        char fill = input.next ().charAt ( 0 );
        System.out.print ("Input the number To print....");
        int star = input.nextInt ();

        squareOfAsterisks ( star, fill );
    }
}
