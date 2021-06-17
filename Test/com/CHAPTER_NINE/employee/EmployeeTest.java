package com.CHAPTER_NINE.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee;
    @Test
        void getFirstName(){
        employee = new Employee ( "John", "Edward", "222-222-222" );
        assertEquals ( "John", employee.getFirstName () );
    }

    @Test
    void getLastName(){
        employee = new Employee ( "John", "Edward", "222-222-222" );
        assertEquals ( "Edward", employee.getLastName ());
    }

    @Test
    void getSocialSecurityNumber(){
        employee = new Employee ( "John", "Edward", "222-222-222" );
        assertEquals ( "222-222-222", employee.getSocialSecurityNumber () );
        System.out.println (employee);
    }


}