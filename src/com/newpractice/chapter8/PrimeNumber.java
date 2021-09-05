package com.newpractice.chapter8;

public class PrimeNumber {
    public static void main(String[] args) {
        boolean isPrime ;
        int num = 1;
        if (num < 2){
            isPrime = false;
        }
        else
            isPrime = true;
        for (int j = 0; j <=100; j++ ) {
            for (int i = 2; i <= j / i; i++) {
                if (j % i == 0) {
                    isPrime = false;
                    continue;
//                System.out.printf ( "%s%d %n","not prime", j );
                }
            }
        }
        if (isPrime){
            System.out.printf ( "%s", "prime number" );
        }
        else
            System.out.printf ( "%s", "not a prime number" );
    }
}
