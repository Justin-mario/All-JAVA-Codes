package com.StudentGrader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraderTest {
    @Test
    @DisplayName ( "Check Student With Score between 90 to 100 Can Be Graded" )
        void checkStudentWithScoreBetween_90_and_100_canBeGraded(){
        assertEquals (4,Grader.getStudentGrade (90));
        assertEquals (4,Grader.getStudentGrade (100));
    }

    @Test
    @DisplayName ( "Check Student With Score between 80 to 89 Can Be Graded" )
    void checkStudentWithScoreBetween_80_and_89_canBeGraded(){
        assertEquals (3,Grader.getStudentGrade (80));
        assertEquals (3,Grader.getStudentGrade (89));
    }

    @Test
    @DisplayName ( "Check Student With Score between 70 to 79 Can Be Graded" )
    void checkStudentWithScoreBetween_70_and_79_canBeGraded(){
        assertEquals (2,Grader.getStudentGrade (70));
        assertEquals (2,Grader.getStudentGrade (79));
    }

    @Test
    @DisplayName ( "Check Student With Score between 60 to 69 Can Be Graded" )
    void checkStudentWithScoreBetween_60_and_69_canBeGraded(){
        assertEquals (1,Grader.getStudentGrade (60));
        assertEquals (1,Grader.getStudentGrade (69));
    }
    @Test
    @DisplayName ( "Check Student With Score Below 60 Can Be Graded" )
    void checkStudentWithScoreBelow_60_canBeGraded(){
        assertEquals (0,Grader.getStudentGrade (0));
        assertEquals (0,Grader.getStudentGrade (59));
    }

    @Test
    @DisplayName ( "Check Grader Can Not Accept Negative Scores" )
    void checkStudentCanNotHaveNegativeScore(){
        assertEquals (0,Grader.getStudentGrade (-98));
    }

    @Test
    @DisplayName ( "Check Student Can Not Score Above 100" )
    void checkStudentCanNotScoreAbove_100_(){
        assertEquals (0,Grader.getStudentGrade (101));
    }
}