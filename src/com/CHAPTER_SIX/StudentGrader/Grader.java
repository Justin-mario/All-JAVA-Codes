package com.CHAPTER_SIX.StudentGrader;

public class Grader {

    public static int getStudentGrade(int studentScore) {
        int grade;
        if(studentScore  >= 90 && studentScore <= 100){
             grade = 4;
            System.out.println ("For Student Score " + studentScore + " Grade is " + grade);
            return grade;}
        else if(studentScore >= 80 && studentScore <90){
            grade = 3;
            System.out.println ("For Student Score " + studentScore + " Grade is " + grade);
            return grade; }
        else if(studentScore >= 70 && studentScore < 80){
            grade = 2;
            System.out.println ("For Student Score " + studentScore + " Grade is " + grade);
            return grade; }
        else if(studentScore >= 60 && studentScore < 70){
            grade = 1;
            System.out.println ("For Student Score " + studentScore + " Grade is " + grade);
            return grade; }
        else{
            grade = 0;
            System.out.println ("For Student Score " + studentScore + " Grade is " + grade);
        return grade;}

    }
}
