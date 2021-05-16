package com.CHAPTER_FIVE.GlobalWarmingQuiz;

public class GlobalWarmingFactQuiz {
        static int correctAnswer;
        static int incorrectAnswer;
        static String rightAnswer;


    public static String getAnswerToQuestionOne(String answer) {
        rightAnswer = "A";
        setQuestionOne ();
        String answerToQuestionOne = validateAnswer ( answer );
        return answerToQuestionOne; }

    public static String getAnswerToQuestionTwo(String answer) {
        rightAnswer = "B";
      return validateAnswer ( answer ); }

    public static String getAnswerToQuestionThree(String answer) {
        rightAnswer = "C";
    return validateAnswer ( answer ); }

    public static String getAnswerToQuestionFour(String answer) {
        rightAnswer = "D";
      return validateAnswer ( answer ); }

    public static String getAnswerToQuestionFive(String answer) {
        rightAnswer = "A";
        return validateAnswer ( answer ); }

    public static String validateAnswer(String answer){

        if(answer.equalsIgnoreCase ( rightAnswer)){
            correctAnswer++;
            System.out.println ("Correct!!!");
            return rightAnswer;
        }else{
            incorrectAnswer++;
            System.out.println ("Incorrect answer,  correct answer is" + rightAnswer);
            return "Incorrect answer";}
    }

    public static void showScore(){
        if(correctAnswer == 5){ System.out.println ("Excellent Score is...." + correctAnswer); }
        else if (correctAnswer == 4){ System.out.println ("Very Good Score is...." + correctAnswer);}
        else{
            System.out.println ("score is ..." + correctAnswer + "\nTime To Brush Up On Your Knowledge Of Global Warming\nVisit the following Website to Update Your Knowledge");
        }
        System.out.println ();
    }

    public static void setQuestionOne(){
        String questionOne = """
                1 --> Which is a cause of global warming?
                    A. Gas flaring.
                    B. Hunting.
                    C. I dont know
                    D. None of the above.
                """;
        System.out.println (questionOne); }

    public static void setQuestionTwo() {
        String questionTwo = """
                2 --> Which is an effect of global warming?
                    A. Nothing.
                    B. Flooding.
                    C. I dont know.
                    D. Blindness.
                """;
        System.out.println (questionTwo);
    }

    public static void setQuestionThree() {
        String questionThree = """
               3 -->  Global sea level has risen by about how many inches?
                    A. 10.
                    B. 14.
                    C. 8.
                    D  1.
                """;
        System.out.println (questionThree);
    }

    public static void setQuestionFour() {
        String questionFour = """
                4 --> What year did reliable record keeping on rising sea level begin?
                    A. 1960.
                    B. 1990.
                    C. 2021.
                    D 1880.
                """;
        System.out.println (questionFour);
    }

    public static void setQuestionFive() {
        String questionFive = """
                5 --> Which is not a cause of global warming?
                    A. Hunting.
                    B. Gas flaring.
                    C. Industrialization
                    D. None of the above.
                """;
        System.out.println (questionFive);
    }
}

