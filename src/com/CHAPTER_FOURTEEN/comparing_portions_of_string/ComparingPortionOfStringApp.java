package com.CHAPTER_FOURTEEN.comparing_portions_of_string;

import java.util.Scanner;

public class ComparingPortionOfStringApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        ComparingPortionsOfString comparingPortionsOfString = new ComparingPortionsOfString ();

        System.out.print ("Input first word to compare ");
        String firstUserInput = input.nextLine ();
        System.out.print ("input second word to compare ");
        String secondUserInput = input.nextLine ();

        comparingPortionsOfString.compareTwoString ( firstUserInput,secondUserInput );
        comparingPortionsOfString.getResult ();

    }
}
