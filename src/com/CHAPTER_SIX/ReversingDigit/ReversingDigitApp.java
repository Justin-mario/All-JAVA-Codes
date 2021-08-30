package com.CHAPTER_SIX.ReversingDigit;

import java.util.Scanner;

public class ReversingDigitApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.print ("Input Digits To Be Reversed...\t");
        int userInput = input.nextInt ();
        ReversingDigits.getReversedDigits ( userInput );
    }
}
