package com.CHAPTER_SIX.MinimumValue;

import java.util.Scanner;

public class FindingMinimumValueApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.print ("Input 3 Floating Point Numbers To Find The Minimum Value...\t");
        double firstNumber = input.nextDouble ();
        double secondNumber = input.nextDouble ();
        double thirdNumber = input.nextDouble ();
        FindingMinimumValue.getMinimum3 ( firstNumber, secondNumber, thirdNumber );
    }
}
