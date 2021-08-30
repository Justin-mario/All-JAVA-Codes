package com.Kata;

import java.security.SecureRandom;

public class Kata {
    private int[] number = {2,4,6,8};
    SecureRandom random = new SecureRandom ();


    public int[] getArrayElements() {
        return number;
    }

    public int[] getShuffledArray() {
        for (int i = 0; i > number.length; i++){
            int temp = number[i];
            int shuffled = random.nextInt (number.length);
            number[i] = number[shuffled];
            number[shuffled] = temp;
        }
        return number;
    }
}
