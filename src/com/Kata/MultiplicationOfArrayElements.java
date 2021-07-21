package com.Kata;

import java.util.Arrays;

public class MultiplicationOfArrayElements {
    public static void multiplyingArrayElement(int[] numbers){
        int[] newNumber = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            int product = 1;
            for (int j = 0; j < numbers.length; j++){
                if(i == j) {
                    continue;
                }
                    product *= numbers[j];
            }
            newNumber[i] = product;
        }
        System.out.println ( Arrays.toString (newNumber));

    }

    public static void main(String[] args) {
        int[] numbers = {4, 5, 10, 2};
        multiplyingArrayElement ( numbers );
    }
}
