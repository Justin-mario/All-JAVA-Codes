package com.CHAPTER_FIVE.GlobalWarmingQuiz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalWarmingFactQuizTest {

    @Test
    @DisplayName ( "Test Question one can be Displayed and Answered")
        void checkQuestionOneCanAnswered(){
        assertEquals ( "A",GlobalWarmingFactQuiz.getAnswerToQuestionOne ("A"));
    }

    @Test
    @DisplayName ( "Test That Correct Answers Are Properly Graded ")
    void checkGradeIsIncrementedWhenAnswerIsCorrect(){
        assertEquals ( "A",GlobalWarmingFactQuiz.getAnswerToQuestionOne ("A"));
        assertEquals ( 1,GlobalWarmingFactQuiz.correctAnswer );
    }

    @Test
    @DisplayName ( "Test That Incorrect Answers Are Not graded As correct Answer ")
    void checkGradeIsNotIncrementedWhenAnswerIsCorrect(){
        assertThrows ( Throwable.class, ()-> assertEquals ( "B",GlobalWarmingFactQuiz.getAnswerToQuestionOne ("B")));
        assertEquals ( 0,GlobalWarmingFactQuiz.correctAnswer );
    }

    @Test
    @DisplayName ( "Test That Incorrect Answers Are Properly Graded ")
    void checkIncorrectAnswerGradeIsIncrementedWhenAnswerIsInCorrect() {
        assertThrows ( Throwable.class, () -> assertEquals ( "B", GlobalWarmingFactQuiz.getAnswerToQuestionOne ( "B" ) ) );
        assertEquals ( 1, GlobalWarmingFactQuiz.incorrectAnswer );

    }
    @Test
    @DisplayName ( "Test Question Two can be Displayed and Answered")
    void checkQuestionTwoCanAnswered(){
        assertEquals ( "B",GlobalWarmingFactQuiz.getAnswerToQuestionTwo ("b"));
    }

    @Test
    @DisplayName ( "Test Question Three can be Displayed and Answered")
    void checkQuestionThreeCanAnswered(){
        assertEquals ( "C",GlobalWarmingFactQuiz.getAnswerToQuestionThree ("c"));
    }

    @Test
    @DisplayName ( "Test Question Four can be Displayed and Answered")
    void checkQuestionFourCanAnswered(){
        assertEquals ( "D",GlobalWarmingFactQuiz.getAnswerToQuestionFour ("D"));
    }

    @Test
    @DisplayName ( "Test Question Five can be Displayed and Answered")
    void checkQuestionFiveCanAnswered(){
        assertEquals ( "A",GlobalWarmingFactQuiz.getAnswerToQuestionFive ("a"));
    }

    @Test
    @DisplayName ( "Test That Total Correct Grade Can Be Obtained After Quiz ")
    void checkTotalCorrectAnswersCanBeObtainedAfterQuiz() {
        assertEquals ( "A", GlobalWarmingFactQuiz.getAnswerToQuestionOne ( "A" ) );
        assertEquals ( "B", GlobalWarmingFactQuiz.getAnswerToQuestionTwo ( "b" ) );
        assertEquals ( "C", GlobalWarmingFactQuiz.getAnswerToQuestionThree ( "c" ) );
        assertEquals ( "D", GlobalWarmingFactQuiz.getAnswerToQuestionFour ( "D" ) );
        assertEquals ( "A", GlobalWarmingFactQuiz.getAnswerToQuestionFive ( "A" ) );
        assertEquals ( 5, GlobalWarmingFactQuiz.correctAnswer );
    }





    @AfterEach
    void afterEachTest(){
        GlobalWarmingFactQuiz.incorrectAnswer = 0;
        GlobalWarmingFactQuiz.correctAnswer = 0;
    }
}