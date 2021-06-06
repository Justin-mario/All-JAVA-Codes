package com.Practice.Course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddingStudentToCourseTest {
    AddingStudentToCourse course;
    @BeforeEach
    void beforeEachTest(){
        course = new AddingStudentToCourse ();
    }
    @Test
        void check_10_studentsCanTakeACourse(){
        assertEquals (10, course.getTotalNumberOfStudents() );
    }
    @Test
    void checkCourseCanBeAdded(){
        course.addCourse("Software Engineering");
        assertEquals ("Software Engineering",course.getCourseName(0));
    }

    @Test
    void checkMoreThanOneCourseCanBeAdded(){
        course.addCourse("Software Engineering");
        course.addCourse("Java Programming");
        course.addCourse("DataBase Management");
        assertEquals ("Software Engineering",course.getCourseName(0));
    }

    @Test
    void checkCourseCanBeDeleted(){
        course.addCourse("Software Engineering");
        course.addCourse("Java Programming");
        course.addCourse("DataBase Management");
        course.deleteCourseName(1);
        assertEquals (null,course.getCourseName ( 1 ));
    }

    @Test
    void CheckNumberOfCourseCanBeObtained(){
        course.addCourse("Software Engineering");
        course.addCourse("Java Programming");
        course.addCourse("DataBase Management");
        assertEquals ( 3, course.getNumberOfCourse() );
    }

    @Test
    void checkStudentCanBeAdded(){
        course.addStudent("Emeka John");
        assertTrue ( course.getStudent(0).equalsIgnoreCase ( "emeka john" ));
    }

    @Test
    void checkMoreThanOneStudentCanBeAdded(){
        course.addStudent("Emeka John");
        course.addStudent("Mary John");
        course.addStudent("Michael Ojeh");
        course.addStudent("Uzo Ben");
        course.addStudent("vero smart");
        assertEquals ( "vero smart",course.getStudent(4));
    }

    @Test
    void checkStudentCanBeDeleted(){
        course.addStudent("Emeka John");
        course.addStudent("Mary John");
        course.addStudent("Michael Ojeh");
        course.addStudent("Uzo Ben");
        course.addStudent("vero smart");
        course.deleteStudent(1);
        assertEquals ( null,course.getStudent(1));
    }

    @Test
    void checkNumberOfStudentCanBeObtained(){
        course.addStudent("Emeka John");
        course.addStudent("Mary John");
        course.addStudent("Michael Ojeh");
        course.addStudent("Uzo Ben");
        course.addStudent("vero smart");
        course.getNumberOfStudent();
        assertEquals ( 5,course.getNumberOfStudent ());
    }
}