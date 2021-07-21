package com.CHAPTER_SIX.MakingADifferrence;

import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerAssistedInstruction {

    public static void main(String[] args) {
        getQuestion ();
    }

    public static void getQuestion(){
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt (9);
        int secondOperand = 1 + random.nextInt (9);
        String question = "what is" + " " + firstOperand + " x " + secondOperand;

        System.out.println (question);
        int userAnswer = input.nextInt ();
        int answer = firstOperand * secondOperand;

        if (userAnswer == -1){
            System.exit ( 0 );
        }
        while(userAnswer != -1){

            if (userAnswer == answer){
                System.out.println ("Very Good!");

            }
            else{
                System.out.println ("No, Please Try Again.");
                while(userAnswer != answer){
                    System.out.println (question);
                    userAnswer = input.nextInt ();
                    if (userAnswer != answer){
                        System.out.println ("No, Please Try Again.");}
                    else{
                        System.out.println ("Very Good!");
                    }
                }
            }
            getQuestion ();
        }

    }
        }















