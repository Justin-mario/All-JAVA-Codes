package com.CHAPTER_SIX.MakingADifferrence;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class ComputerAidedInstructionVaryingTheTypesOfProblem {
    public static void main(String[] args) {
        startQuiz ();
    }
    public static void startQuiz(){
        Scanner input = new Scanner ( System.in );

        String prompt = """
                choose Level.
                1. Easy Level
                2. Difficult level
                3. To Exit
                """;
        int userLevel;
        System.out.println ( prompt );
        userLevel = input.nextInt ();


        String prompt2 = """
                choose Arithmetic Problem To Study
                1. Addition
                2. Subtraction
                3. Multiplication
                4. Division
                5. Mixture Of All Type
                6. Exit
                """;
        switch (userLevel) {

            case 1 -> {
                System.out.println (prompt2);
                int arithmeticProblem = input.nextInt ();
                switch (arithmeticProblem){
                    case 1 -> additionEasyLevel ();
                    case 2 -> subtractionEasyLevel ();
                    case 3 -> multiplicationEasyLevel ();
                    case 4 -> divisionEasyLevel ();
                    case 5 -> mixtureEasyLevel ();
                    case 6 -> System.exit ( 0 );
                }
            }
            case 2 ->{
                System.out.println (prompt2);
                int arithmeticProblem = input.nextInt ();
                switch (arithmeticProblem){
                    case 1 -> additionDifficultLevel ();
                    case 2 -> subtractionDifficultLevel ();
                    case 3 -> multiplicationDifficultLevel ();
                    case 4 -> divisionDifficultLevel ();
                    case 5 -> mixtureDifficultLevel ();
                    case 6 -> System.exit ( 0 );
                }
            }
            case 3 ->
                System.exit ( 0 );

        }




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
    public static void additionEasyLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );



        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        String question = "what is" + " " + firstOperand + " + " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand + secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            additionEasyLevel ();

        }

    }

    public static void subtractionEasyLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        String question = "what is" + " " + firstOperand + " - " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand - secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            subtractionEasyLevel ();

        }

    }

    public static void multiplicationEasyLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        String question = "what is" + " " + firstOperand + " * " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand * secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            multiplicationEasyLevel ();

        }

    }

    public static void divisionEasyLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        String question = "what is" + " " + firstOperand + " / " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand / secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            divisionEasyLevel ();

        }

    }

    public static void mixtureEasyLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        int randomQuestion = 1 + random.nextInt (4);
        String question = "";
        int answer = 0;
        switch (randomQuestion){
            case 1 ->{
                question = "what is" + " " + firstOperand + " + " + secondOperand;
                System.out.println ( question );
                answer = firstOperand + secondOperand;
            }
            case 2 ->{
                question = "what is" + " " + firstOperand + " - " + secondOperand;
                System.out.println ( question );
                answer = firstOperand - secondOperand;
            }
            case 3 ->{
                question = "what is" + " " + firstOperand + " * " + secondOperand;
                System.out.println ( question );
                answer = firstOperand * secondOperand;
            }
            case 4 ->{
                question = "what is" + " " + firstOperand + " / " + secondOperand;
                System.out.println ( question );
                answer = firstOperand / secondOperand;
            }
        }


        int userAnswer = input.nextInt ();
        if (userAnswer == -1) {
            startQuiz ();
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
            mixtureEasyLevel ();

        }

    }

    public static void additionDifficultLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 99 );
        int secondOperand = 1 + random.nextInt ( 99 );
        String question = "what is" + " " + firstOperand + " + " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand + secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            additionDifficultLevel ();

        }

    }

    public static void subtractionDifficultLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 99 );
        int secondOperand = 1 + random.nextInt ( 99 );
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        String question = "what is" + " " + firstOperand + " - " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand - secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            subtractionDifficultLevel ();

        }

    }
    public static void multiplicationDifficultLevel(){
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 99 );
        int secondOperand = 1 + random.nextInt ( 99 );
        String question = "what is" + " " + firstOperand + " x " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand * secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            multiplicationDifficultLevel ();

        }

    }

    public static void divisionDifficultLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 99 );
        int secondOperand = 1 + random.nextInt ( 99 );
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        String question = "what is" + " " + firstOperand + " / " + secondOperand;

        System.out.println ( question );
        int userAnswer = input.nextInt ();
        int answer = firstOperand / secondOperand;

        if (userAnswer == -1) {
            startQuiz ();
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
            divisionDifficultLevel ();

        }

    }

    public static void mixtureDifficultLevel() {
        SecureRandom random = new SecureRandom ();
        Scanner input = new Scanner ( System.in );

        int firstOperand = 1 + random.nextInt ( 9 );
        int secondOperand = 1 + random.nextInt ( 9 );
        if (firstOperand < secondOperand){
            int temp = firstOperand;
            firstOperand = secondOperand;
            secondOperand = temp;
        }
        int randomQuestion = 1 + random.nextInt (4);
        String question = "";
        int answer = 0;
        switch (randomQuestion){
            case 1 ->{
                question = "what is" + " " + firstOperand + " + " + secondOperand;
                System.out.println ( question );
                answer = firstOperand + secondOperand;
            }
            case 2 ->{
                question = "what is" + " " + firstOperand + " - " + secondOperand;
                System.out.println ( question );
                answer = firstOperand - secondOperand;
            }
            case 3 ->{
                question = "what is" + " " + firstOperand + " * " + secondOperand;
                System.out.println ( question );
                answer = firstOperand * secondOperand;
            }
            case 4 ->{
                question = "what is" + " " + firstOperand + " / " + secondOperand;
                System.out.println ( question );
                answer = firstOperand / secondOperand;
            }
        }


        int userAnswer = input.nextInt ();
        if (userAnswer == -1) {
            startQuiz ();
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
            mixtureDifficultLevel ();

        }

    }


}
