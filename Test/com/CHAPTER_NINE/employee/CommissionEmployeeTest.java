package com.CHAPTER_NINE.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommissionEmployeeTest {
    @Test
        void getFirstName(){
        CommissionEmployee commissionEmployee = new CommissionEmployee ( "John", "Edward",
                "222-222-222", 100.0, 0.06 );
        assertEquals ( "John", commissionEmployee.getFirstName () );
    }

    @Test
    void getLastName(){
        CommissionEmployee commissionEmployee = new CommissionEmployee ( "John", "Edward",
                "222-222-222", 100.0, 0.06 );
        assertEquals ( "Edward", commissionEmployee.getLastName () );
    }

    @Test
    void getSocialSecurityNumber(){
        CommissionEmployee commissionEmployee = new CommissionEmployee ( "John", "Edward",
                "222-222-222", 100.0, 0.06 );
        assertEquals ( "222-222-222", commissionEmployee.getSocialSecurityNumber ());
    }

    @Test
    void getGrossSales(){
        CommissionEmployee commissionEmployee = new CommissionEmployee ( "John", "Edward",
                "222-222-222", 100.0, 0.06 );
        commissionEmployee.setGrossSales ( 200.00 );
        assertEquals ( 200.0, commissionEmployee.getGrossSales ());
    }

    @Test
    void getEarning(){
        CommissionEmployee commissionEmployee = new CommissionEmployee ( "John", "Edward",
                "222-222-222", 1000.0, 0.06 );
        commissionEmployee.setGrossSales ( 5000.00 );
        commissionEmployee.setCommissionRate ( 0.10 );
        assertEquals ( 500.0, commissionEmployee.earning ());
        System.out.println (commissionEmployee);
    }
}