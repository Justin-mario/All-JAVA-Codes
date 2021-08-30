package com.Kata;

import java.util.Arrays;

public class SortingArray {
    public static void main(String[] args) {
        int[] numbers = {1,44,12,34,0,18,60,10};

        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length ; j++) {
                int temp1 = numbers[i];
                int temp2 = numbers[j];

                if (temp2 < temp1){
                    numbers[j] = temp1;
                    numbers[i] = temp2;

                }
            }

        }

            System.out.println (Arrays.toString ( numbers ));


    }
}
