package com.CHAPTER_SIX.PrimeNumbers;

import java.util.Scanner;

public class PrimeNumber {

    public static void primeNumber(int number) {

        for (int divisor = 2; divisor <= number / 2; divisor++) {
            divisor = number / 2;
            if (number % divisor == 1) {
                System.out.println ("Is a prime number..." + number);
            } else{
                System.out.println (number + "...Is not a prime Number");}
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.print ("input Number....");
        int number = input.nextInt ();
        primeNumber ( number );
    }
}

