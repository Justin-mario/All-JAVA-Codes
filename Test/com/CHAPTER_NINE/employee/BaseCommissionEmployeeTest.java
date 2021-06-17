package com.CHAPTER_NINE.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseCommissionEmployeeTest {
    @Test
        void getFirstName(){
        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee (  "John", "Edward",
                "222-222-222", 5000.0, 0.04, 1000.0 );
        assertEquals ( "John", baseCommissionEmployee.getFirstName () );
    }

    @Test
    void getLastName(){
        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee (  "John", "Edward",
                "222-222-222", 5000.0, 0.04, 1000.0 );
        assertEquals ( "Edward", baseCommissionEmployee.getLastName () );
    }

    @Test
    void getSocialSecurityNumber(){
        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee (  "John", "Edward",
                "333-33-3333", 5000.0, 0.04, 1000.0 );
        assertEquals ( "333-33-3333", baseCommissionEmployee.getSocialSecurityNumber () );
    }

    @Test
    void getGrossSales(){
        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee (  "John", "Edward",
                "333-33-3333", 5000.0, 0.04, 1000.0 );
        baseCommissionEmployee.setGrossSales ( 6000.0 );
        assertEquals ( 6000, baseCommissionEmployee.getGrossSales () );
    }

    @Test
    void checkGrossSalesCannotBeOrLessThanZero(){
        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee (  "John", "Edward",
                "333-33-3333", 5000.0, 0.04, 1000.0 );
        assertThrows ( IllegalArgumentException.class, ()-> baseCommissionEmployee.setGrossSales ( -10.0 ));
        assertEquals ( 5000.0, baseCommissionEmployee.getGrossSales () );
    }

    @Test
    void getEarning(){
        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee (  "John", "Edward",
                "333-33-3333", 6000.0, 0.06, 2000.0 );
        baseCommissionEmployee.setCommissionRate ( 0.04 );
        baseCommissionEmployee.setGrossSales ( 5000 );
        baseCommissionEmployee.setBaseSalary ( 1000 );
        assertEquals (1200 , baseCommissionEmployee.earning () );
        System.out.println (baseCommissionEmployee);
    }

}