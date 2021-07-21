package com.CHAPTER_SIX.MakingADifferrence;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class ComputerAssistedInstructionReducingStudentFatigue {
    public static void main(String[] args) {
        getQuestion ();
    }

    public static void displayWinningMessage(){
        Random random1 = new Random ();
        int display = 1 + random1.nextInt ( 4 );
        switch (display) {
            case 1 -> System.out.println ( "Very Good!" );
            case 2 -> System.out.println ( "Excellent!" );
            case 3 -> System.out.println ( "Nice Work!" );
            case 4 -> System.out.println ( "Keep up the good work!" );
        }
    }

    public static void displayLosingMessage() {
        Random random1 = new Random ();
        int display = 1 + random1.nextInt ( 4 );
        switch (display) {
            case 1 -> System.out.println ( "No, Please Try Again!" );
            case 2 -> System.out.println ( "Wrong, Try one more!" );
            case 3 -> System.out.println ( "Don't give up!" );
            case 4 -> System.out.println ( "No keep trying!" );
        }
    }
    public static void getQuestion() {

        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        String question = "what is" + " " + firstOperand + " x " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand * secondOperand;

        if (userAnswer == -1) {
            System.exit ( 0 );
        }
        while (userAnswer != -1) {
            if (userAnswer == answer) {
               displayWinningMessage ();

            } else {
               displayLosingMessage ();
                }
                while (userAnswer != answer) {
                    System.out.println ( question );
                    userAnswer = input.nextInt ();
                    if (userAnswer != answer) {
                        displayLosingMessage ();
                    } else {

                        displayWinningMessage ();
                    }
                }
                getQuestion ();
            }

        }
    }

