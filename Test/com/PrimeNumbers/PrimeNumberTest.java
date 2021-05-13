package com.PrimeNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {
    @Test
    @DisplayName ( "Check That A Number Is Prime" )
        void checkThatANumberIsPrime(){
       assertTrue (PrimeNumber.isPrime(97));
    }

    @Test
    @DisplayName ( "Check That A Number Is Not A Prime Number" )
    void checkThatANumberIsNotAPrimeNumber(){
        assertTrue (!PrimeNumber.isPrime(10));

    }
}