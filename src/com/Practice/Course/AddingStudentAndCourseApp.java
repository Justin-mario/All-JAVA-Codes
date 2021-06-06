package com.Practice.Course;
import java.util.Scanner;

public class AddingStudentAndCourseApp {
    public static void main(String[] args) {
        AddingStudentToCourse course = new AddingStudentToCourse ();
        Scanner input = new Scanner ( System.in );


        System.out.print ( "Input student Name..." );
        String studentName = input.nextLine ();
        course.addStudent ( studentName );
        System.out.print ( "Input Course..." );
        String courseName = input.nextLine ();
        course.addCourse ( courseName );
        course.getAllInput ();

    }
}
