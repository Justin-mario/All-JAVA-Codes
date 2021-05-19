package com.CHAPTER_SIX.HypotenuseCalculations;

public class HypotenuseCalculator {

    public static double getHypotenuse(double side1, double side2) {
       double answer = Math.pow ( side1, 2) + Math.pow ( side2, 2);
       double hypotenuse = Math.sqrt ( answer );
        System.out.println ("Hypotenuse of " + side1 + " and " + side2 + " is " + hypotenuse);
       //double hypotenuse = Math.hypot ( side1,side2 );
        return hypotenuse;
    }
}
