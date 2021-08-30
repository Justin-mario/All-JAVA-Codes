package com.CHAPTER_SIX.MinimumValue;

public class FindingMinimumValue {

    public static double getMinimum3(double number1, double number2, double number3) {
        double minimumValue = Math.min ( number1,(Math.min ( number2, number3 )) );
        System.out.println ("The Minimum Value is " + minimumValue);
        return minimumValue;
    }
}
