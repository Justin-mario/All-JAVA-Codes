package com.Practice.Course;


import java.util.Arrays;

public class AddingStudentToCourse {
    private String[][] listOfStudentsAndCourses = new String[10][3];
    private String courseName;
    private String student;
    private int numberOfCourse;
    private int numberOfStudents;


    public int getTotalNumberOfStudents() {
        return listOfStudentsAndCourses.length;

    }

    public void addStudent(String student) {
        this.student = student;
        listOfStudentsAndCourses[numberOfStudents][numberOfCourse] = student;
        numberOfStudents++;
    }

    public String getCourseName(int numberOfCourse) {
        this.numberOfCourse = numberOfCourse;
        courseName = listOfStudentsAndCourses[numberOfStudents][numberOfCourse];
        return courseName;
    }


    public void deleteStudent(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        listOfStudentsAndCourses[numberOfStudents][numberOfCourse] = null;
        numberOfStudents--;
    }

    public String getStudent(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
            student = listOfStudentsAndCourses[numberOfStudents][numberOfCourse];
        return student;
    }

    public int getNumberOfStudent() {
        return numberOfStudents;
    }

    public void addCourse(String courseName) {
        this.courseName = courseName;
        listOfStudentsAndCourses[numberOfStudents][numberOfCourse] = courseName;
        numberOfCourse++;
    }

    public int getNumberOfCourse() {
        return numberOfCourse;
    }

    public void deleteCourseName(int numberOfCourse) {
        this.numberOfCourse = numberOfCourse;
        listOfStudentsAndCourses[numberOfStudents][numberOfCourse] = null;
    }
    public String getAllInput(){
        for (String student[]: listOfStudentsAndCourses) {
            System.out.println ( Arrays.deepToString ( student ) );
        }
        return listOfStudentsAndCourses[numberOfStudents][numberOfCourse];
    }
}
