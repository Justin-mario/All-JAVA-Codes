package com.Practice.Course;

import java.util.ArrayList;

public class AddingStudentAndCourseUsingList {
    private String courseName;
    private String studentName;
    private int numberOfStudent;
    private ArrayList<String> studentList = new ArrayList<> ();

    public AddingStudentAndCourseUsingList(String courseName) {
        this.courseName = courseName;

    }

    public void addStudent(String studentName) {
        this.studentName = studentName;
        studentList.add ( studentName );
        numberOfStudent++;

    }

    public String getStudent(int studentIndex) {
        return studentList.get ( studentIndex );
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String studentName) {
        studentList.remove (studentName  );
        numberOfStudent--;
    }

    public int getNumberOfStudents() {
        return numberOfStudent;
    }
}
