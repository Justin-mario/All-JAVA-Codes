package com;


import com.Practice.Location;

public class Practices {
    public static void main(String[] args) {
        int number = 2;
        final int NUMBER_OF_PRIMES = 50;
        int count = 0;


        while (count < NUMBER_OF_PRIMES) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
                else
                    isPrime = true;
                System.out.println (number);
            }

        }
    }
}
//      boolean primeNumber = false;
//        if (prac.isPrime (4)){
//            System.out.println ("is a prime");
//        }else {
//            System.out.println ("is not a prime");
//
//
//      }}

//      public boolean isPrime(int num){
//          for(int i = 1; i <= num/2; i++){
//              if (num % i != 0){
//                  return true;
//              }
//          }
//          return  false;
//        }



