package com.CHAPTER_FOURTEEN.comparingstring;

import java.util.Scanner;

public class ComparingStringApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        ComparingStrings comparingStrings = new ComparingStrings ();

        System.out.print ("Input first word to compare ");
        String firstUserInput = input.nextLine ();
        System.out.print ("input second word to compare ");
        String secondUserInput = input.nextLine ();

        comparingStrings.compareTwoString ( firstUserInput, secondUserInput );
        comparingStrings.getResult ();


    }
}
