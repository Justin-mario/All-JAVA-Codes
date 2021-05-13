package com.GreatestCommonDivisor;

public class GreatestCommonDivisor {

    public static int getTheGreatestCommonDivisor(int firstNumber, int secondNumber) {
        int commonDivisor = 1;
        int counter = 2;

        while(counter <= firstNumber && counter <= secondNumber){
        if (firstNumber % counter == 0 && secondNumber % counter == 0)
            commonDivisor = counter;
        counter++;
        }
        System.out.println ("Greatest Common Divisor Of Numbers\t" + firstNumber + " And " + secondNumber + " is " + commonDivisor );
        return commonDivisor;
    }
}
