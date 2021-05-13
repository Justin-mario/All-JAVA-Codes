package com.GreatestCommonDivisor;

import java.util.Scanner;

public class GreatestCommonDivisorApp {
    public static void main(String[] args) {

        Scanner input = new Scanner ( System.in );

        System.out.print ("Input First Integer...\t");
        int firstNumber = input.nextInt ();
        System.out.print ("Input Second Integer...\t");
        int secondNumber = input.nextInt ();

        GreatestCommonDivisor.getTheGreatestCommonDivisor ( firstNumber, secondNumber);


    }
}
