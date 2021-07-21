package com.Kata;

import java.util.Random;
import java.util.Scanner;

public class DisplayingRandomQuestionWithArray {
    public static void generateQuestion(){
        Random random = new Random ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt (9);
        int secondOperand = 1 + random.nextInt (9);
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        char[] arithmeticOperator = {'+', '-', '*', '/'};

        int randomOperator = random.nextInt (4);
        char operator = arithmeticOperator[randomOperator];

        String question = "";
        int answer = 0;
        switch (operator){
            case '+' -> {
                question = "what is" + " " + firstOperand + " + " + secondOperand;
                answer = firstOperand + secondOperand;
            }
            case '-' -> {
                question = "what is" + " " + firstOperand + " - " + secondOperand;
                answer = firstOperand - secondOperand;
            }

            case '*' -> {
                question = "what is" + " " + firstOperand + " * " + secondOperand;
                answer = firstOperand * secondOperand;
            }
            case '/' -> {
                question = "what is" + " " + firstOperand + " / " + secondOperand;
                answer = firstOperand / secondOperand;
            }
        }

        System.out.println (question);
        int userAnswer = input.nextInt ();
        DisplayingRandomArithmeticQuestion.validateAnswer ( userAnswer,answer );
    }

    public static void main(String[] args) {
        generateQuestion ();
    }
}
