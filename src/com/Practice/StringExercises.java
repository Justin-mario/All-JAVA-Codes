package com.Practice;

import java.util.Random;
import java.util.Scanner;

public class StringExercises {
    public static void main(String[] args) {
//        String s1 = "Hello World!";
//        int y = 10;
//        char[] s2 = new char[5];
//        for (int i = s1.length ()-1; i >=0; i--){
//            System.out.print (s1.charAt ( i ));
//            s1.getChars ( 0,5, s2,0 );
//
//
//        }
//        System.out.println ();
//        System.out.println ( s2);
//        System.out.println (String.valueOf (y));
        Random random = new Random ();
        Scanner input = new Scanner ( System.in );
       char[] operator = {'+', '-', '*', '/', '%'};
       int questionOne = random.nextInt (10);
       int questionTwo = random.nextInt (10);
       int answer =0;
       char sign = operator[random.nextInt (5)];

       String question = questionOne + " " + sign + " " + questionTwo;
        System.out.println ("What is " + question);
        int userAnswer = input.nextInt ();
        switch (sign){
            case '+'-> answer = questionOne + questionTwo;
            case '-' -> answer = questionOne - questionTwo;
            case '*' -> answer = questionOne * questionTwo;
            case '/' -> answer = questionOne / questionTwo;
            case '%' -> answer = questionOne % questionTwo;
        }
        if (userAnswer == answer){
            System.out.println ("Correct");
        }
        else{
            System.out.println ("Incorrect Try Again");
        }







    }
}
