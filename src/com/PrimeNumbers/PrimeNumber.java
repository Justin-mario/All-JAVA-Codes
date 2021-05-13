package com.PrimeNumbers;

public class PrimeNumber {
        static boolean isPrime;
    public static boolean isPrime(int number) {
        if (number == 2 || number % 2 == 1) {
            isPrime = true;
            return isPrime;}
        else {
            isPrime = false;
        return isPrime;}

    }
}
