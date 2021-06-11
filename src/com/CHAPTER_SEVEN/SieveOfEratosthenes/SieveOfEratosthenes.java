package com.CHAPTER_SEVEN.SieveOfEratosthenes;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private boolean[] numbers = new boolean[1000];


    public int getLengthOfArray() {
        return numbers.length;
    }
    public void fillArray(){
        Arrays.fill ( numbers, true );
    }

    public  boolean getArray(int index){
        return numbers[index];
    }

    public boolean[] findPrimeIndices(boolean[] numbers) {

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i]) {
                eliminateMultiples ( numbers, i );

            }
        }
        return numbers;
    }

        public void eliminateMultiples ( boolean[] numbers, int i){
            int multiple;
            for (int j = 2; j < numbers.length; j++) {
                multiple = i * j;

                if (multiple < numbers.length ) {
                    numbers[multiple] = false;
                } else break;

            }
        }
    }

