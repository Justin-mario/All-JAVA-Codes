package com.Kata;

import java.util.Arrays;

public class SortingAndReturningIndexOfArray {

    public static void sortingArray(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++) {
                int tempI = numbers[i];
                int tempJ = numbers[j];
                if (tempJ < tempI) {
                   numbers[i] = tempJ;
                   numbers[j] = tempI;
                }
            }
        }

//        int firstCounter = 0;
//        int second_counter = 0;
//
//        while (firstCounter < numbers.length) {
//            while (second_counter < numbers.length) {
//                if (numbers[firstCounter] < numbers[second_counter]) {
//                    int temp = numbers[firstCounter];
//                    numbers[firstCounter] = numbers[second_counter];
//                    numbers[second_counter] = temp;
//                }
//                second_counter += 1;
//            }
//            second_counter = 0;
//            firstCounter += 1;
//        }

    }

    public static void firstAndLastIndexOfArray(int[] numbers, int valueToOutput){
        int firstIndex = -1;
        int lastIndex = -1;
        int[] index = {firstIndex, lastIndex};
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < index.length; j++) {
                if (numbers[i] == valueToOutput && firstIndex == -1) {
                    firstIndex = i;
                    index[0] = firstIndex;

                }
                if (numbers[i] == valueToOutput && firstIndex != -1) {
                    lastIndex = i;
                    if (firstIndex != lastIndex)
                    index[1] = lastIndex;
                }
            }
        }

        System.out.println (Arrays.toString ( index ));

    }
    public static void main(String[] args) {
        int[] numbers = {0, 8, -2, 5, 0, 0, 0};
        int value = 8;
        sortingArray ( numbers );
        System.out.println ( Arrays.toString (numbers));
        firstAndLastIndexOfArray ( numbers,value );

    }
}
