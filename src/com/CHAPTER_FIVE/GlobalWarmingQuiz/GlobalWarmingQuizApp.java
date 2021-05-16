package com.CHAPTER_FIVE.GlobalWarmingQuiz;

import java.util.Scanner;

public class GlobalWarmingQuizApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        int i = 1;
        String prompt = """
                Welcome to Global Warming Quiz.
                Choose Questions to Answer
                1 --> Question One
                2 --> Question Two
                3 --> Question Three
                4 --> Question Four
                5 --> Question five
                """;
        System.out.println (prompt);

        while (i != -1){
            int questionNumber = input.nextInt ();
            String answer;
            switch (questionNumber){
                case 1 -> {
                    System.out.println ("Choose An Answer From A - D ");
                    answer = input.nextLine ();
                    GlobalWarmingFactQuiz.getAnswerToQuestionOne ( answer );

                    System.out.println (prompt);
                }
                case 2 -> {
                    System.out.println ("Choose An Answer From A - D ");
                    answer = input.nextLine ();
                    GlobalWarmingFactQuiz.getAnswerToQuestionTwo ( answer ); }
                case 3 -> {
                    System.out.println ("Choose An Answer From A - D ");
                    answer = input.nextLine ();
                    GlobalWarmingFactQuiz.getAnswerToQuestionThree ( answer );}
                case 4 -> {
                    System.out.println ("Choose An Answer From A - D ");
                    answer = input.nextLine ();
                    GlobalWarmingFactQuiz.getAnswerToQuestionFour ( answer ); }
                case 5 -> {
                    System.out.println ("Choose An Answer From A - D ");
                    answer = input.nextLine ();
                    GlobalWarmingFactQuiz.getAnswerToQuestionFive ( answer ); }
                default ->
                    System.out.println ("Option Not Available");
            }
            i++;
        }
        GlobalWarmingFactQuiz.showScore ();
    }
}
