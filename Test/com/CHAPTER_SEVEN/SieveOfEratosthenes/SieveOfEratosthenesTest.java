package com.CHAPTER_SEVEN.SieveOfEratosthenes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SieveOfEratosthenesTest {

    @Test
    void findPrimeIndices(){
        SieveOfEratosthenes primeNumbers = new SieveOfEratosthenes ();
        boolean[] number = new boolean[100];
        primeNumbers.fillArray ();
        assertTrue ( primeNumbers.getArray ( 2 ) );
        assertFalse ( number[2] );
        Arrays.fill ( number,true);
        assertTrue ( number[2] );

        primeNumbers.findPrimeIndices ( number );
        assertFalse ( number[4] );

        for (int i = 0; i < number.length; i++){
            System.out.println (number[i] ? i : "not prime");
        }




    }
}