package com.Kata;

import java.security.SecureRandom;

public class FrequencyOfDiceOccurrenceWithArray {
    public static void rollDice(){
        SecureRandom random = new SecureRandom ();
        int[] frequency = new int[7];

        for (int i = 0; i < 6_000_000; i++){
            ++frequency[1 + random.nextInt (6) ];
        }
        System.out.println ("Face\t" + "Frequency");
        for (int face = 1; face < frequency.length; face++){
            System.out.println (face + "\t" + frequency[face]);
        }
    }

    public static void surveyResponse(){
        int[] response = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3,2, 3, 3, 2, 14 };
        int[] frequency = new int[6];


        for (int i = 0; i < response.length; i++){
            try {
                ++frequency[response[i]];
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println (e);
                System.out.printf ("%d%4d%n",i, response[i]);
            }

        }
        System.out.printf ("%s%15s%n","Response","Occurrence");
        for (int i = 1; i < frequency.length; i++){
            System.out.printf ("%d%15d%n",i,frequency[i]);
        }

    }

    public static void main(String[] args) {
//        rollDice ();
        surveyResponse ();
    }
}
