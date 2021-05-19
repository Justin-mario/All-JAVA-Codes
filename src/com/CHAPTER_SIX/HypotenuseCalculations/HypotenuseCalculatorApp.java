package com.CHAPTER_SIX.HypotenuseCalculations;

import java.util.Scanner;

public class HypotenuseCalculatorApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.print ("Input Length of first Side Of Triangle..... ");
        double side1 = input.nextDouble ();
        System.out.print ("Input Length of second Side Of Triangle..... ");
        double side2 = input.nextDouble ();

        HypotenuseCalculator.getHypotenuse ( side1, side2 );
    }
}
