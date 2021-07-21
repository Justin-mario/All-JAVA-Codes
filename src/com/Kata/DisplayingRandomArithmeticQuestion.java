package com.Kata;

import java.util.Random;
import java.util.Scanner;

public class DisplayingRandomArithmeticQuestion {
    public static void main(String[] args) {
        getQuestion ();
    }

    public static void getQuestion() {
        Scanner input = new Scanner ( System.in );
        Random random = new Random ();

        int firstOperand = 1 + random.nextInt (9);
        int secondOperand = 1 + random.nextInt (9);
        if (firstOperand < secondOperand){
            int temp;
            temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        int arithmeticOperation = 1 + random.nextInt (4);

        int answer = 0;
        String question = "";
        switch (arithmeticOperation){
            case 1 ->{
                question = "what is" + " " + firstOperand + " + " + secondOperand;
                answer = firstOperand + secondOperand;
            }
            case 2 ->{
                question = "what is" + " " + firstOperand + " - " + secondOperand;
                answer = firstOperand - secondOperand;
            }
            case 3 ->{
                question = "what is" + " " + firstOperand + " * " + secondOperand;
                answer = firstOperand * secondOperand;
            }
            case 4 ->{
                question = "what is" + " " + firstOperand + " / " + secondOperand;
                answer = firstOperand / secondOperand;
            }
        }
        System.out.println (question);
        int userAnswer = input.nextInt ();
        validateAnswer ( userAnswer,answer );

    }
    public static void validateAnswer(int userAnswer, int answer){
        if (userAnswer == answer){
            displayMessageForCorrectAnswer ();
        }
        else if (userAnswer == -1){
            System.exit ( 0 );
        }
        else {
            displayMessageForIncorrectAnswer ();
        }

        getQuestion ();

    }

    public static void displayMessageForCorrectAnswer(){
        Random random = new Random ();
        int randomMessage = 1 + random.nextInt (3);
        switch (randomMessage){
            case 1:
                System.out.println ("You are smart!");
                break;
            case 2:
                System.out.println ("Correct!");
                break;
            case 3:
                System.out.println ("You will go places in life!");
        }
    }

    public static void displayMessageForIncorrectAnswer(){
        Random random = new Random ();
        int randomMessage = 1 + random.nextInt (3);
        switch (randomMessage){
            case 1:
                System.out.println ("You can do better!");
                break;
            case 2:
                System.out.println ("Na wa for you oo!");
                break;
            case 3:
                System.out.println ("You will end up in macdonald!");
        }
    }
}
