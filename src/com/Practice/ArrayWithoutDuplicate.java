package com.Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayWithoutDuplicate {

    public static int copyingArray(int[] numbers) {
        int[] newArray = new int[numbers.length];
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < newArray.length; j++)
                if (newArray[j] != numbers[i])
                    newArray[j] = numbers[i];
        }


        System.out.println ( Arrays.toString ( newArray ) );
        return newArray.length;

    }

    public static void main(String[] args) {
        int[] numbers = {1,1,2,2,3,3,4,7,7};
        System.out.println (removeDuplicate ( numbers ));
    }

    public static int removeDuplicate(int[] numbers){
        ArrayList<Integer> num = new ArrayList<> ();
        num.add ( numbers[0] );

        for (int i = 1; i < numbers.length; i++){
            boolean isDuplicate = false;
            for (int j = 0; j < num.size (); j++){
                if (num.get ( j ) == numbers[i]){
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate){
                num.add ( numbers[i] );
            }
        }
        System.out.println (num + " ");
        return num.size ();
    }


}
