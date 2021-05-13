package com.StudentGrader;

import java.util.Scanner;

public class StudentScoreGraderApp {
    public static void main(String[] args) {

        Scanner input = new Scanner ( System.in );
        int studentScore;

        System.out.print ("Input score To Compute Grade....\t");
        studentScore = input.nextInt ();
        if (studentScore == -1){
            System.exit ( 0 );
        }
        Grader.getStudentGrade ( studentScore );

        while(studentScore != -1){
        System.out.print ("Input Another score To Compute Grade....\t");
        studentScore = input.nextInt ();
        if (studentScore == -1){
            System.exit ( 0 );
        }
        Grader.getStudentGrade ( studentScore );}
    }
}
