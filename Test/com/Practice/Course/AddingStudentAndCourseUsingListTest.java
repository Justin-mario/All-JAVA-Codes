package com.Practice.Course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddingStudentAndCourseUsingListTest {
    AddingStudentAndCourseUsingList studentList;
    @BeforeEach
    void beforeEachTest(){
        studentList = new AddingStudentAndCourseUsingList ("SoftWare Engineering");
    }
    @Test
    void checkStudentCanBeAdded(){
        studentList.addStudent("Emeka John");
        assertEquals ( "Emeka John", studentList.getStudent( 0 ));
    }

    @Test
    void checkMultiplyStudentCanBeAdded(){
        studentList.addStudent("Emeka John");
        studentList.addStudent("Ken Berg");
        studentList.addStudent("Cindy Low");
        studentList.addStudent("Kelvin Bryant");
        studentList.addStudent("Michael Jordan");
        assertEquals ( "Emeka John", studentList.getStudent(0));
    }

    @Test
    void checkCourseNameCanBeObtained(){
        assertEquals ( "SoftWare Engineering", studentList.getCourseName());
    }

    @Test
    void checkStudentCanBeDropped(){
        studentList.addStudent("Emeka John");
        studentList.addStudent("Ken Berg");
        studentList.addStudent("Cindy Low");
        studentList.addStudent("Kelvin Bryant");
        studentList.addStudent("Michael Jordan");
        studentList.dropStudent("Emeka John");
        assertEquals ( "Ken Berg",studentList.getStudent ( 0 ) );
    }

    @Test
    void checkNumberOfStudentsRegisteredCanBeObtained(){
        studentList.addStudent("Emeka John");
        studentList.addStudent("Ken Berg");
        studentList.addStudent("Cindy Low");
        studentList.addStudent("Kelvin Bryant");
        studentList.addStudent("Michael Jordan");
        assertEquals ( 5,studentList.getNumberOfStudents() );
    }
}